/*
 * Copyright (C) 2012 McEvoy Software Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.milton.cloud.server.apps.signup;

import io.milton.cloud.common.CurrentDateService;
import io.milton.cloud.process.*;
import io.milton.resource.CollectionResource;
import io.milton.resource.Resource;
import io.milton.cloud.server.apps.AppConfig;
import io.milton.cloud.server.apps.BrowsableApplication;
import io.milton.cloud.server.apps.ChildPageApplication;
import io.milton.cloud.server.apps.PortletApplication;
import io.milton.cloud.server.apps.ReportingApplication;
import io.milton.cloud.server.apps.SettingsApplication;
import io.milton.cloud.server.apps.orgs.OrganisationFolder;
import io.milton.cloud.server.web.SpliffyResourceFactory;
import io.milton.cloud.server.apps.website.WebsiteRootFolder;
import io.milton.cloud.server.db.GroupMembershipApplication;
import io.milton.cloud.server.db.SignupLog;
import io.milton.cloud.server.event.SubscriptionEvent;
import io.milton.cloud.server.event.SubscriptionEvent.SubscriptionAction;
import io.milton.cloud.server.web.CommonResource;
import io.milton.cloud.server.web.JsonResult;
import io.milton.cloud.server.web.ResourceList;
import io.milton.cloud.server.web.RootFolder;
import io.milton.cloud.server.web.reporting.JsonReport;
import io.milton.cloud.server.web.templating.TextTemplater;
import io.milton.event.Event;
import io.milton.event.EventListener;
import io.milton.event.EventManager;
import io.milton.http.FileItem;
import io.milton.http.exceptions.BadRequestException;
import io.milton.http.exceptions.ConflictException;
import io.milton.http.exceptions.NotAuthorizedException;
import io.milton.vfs.db.*;
import io.milton.vfs.db.utils.SessionManager;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.velocity.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.milton.context.RequestContext._;
import org.hibernate.Session;

/**
 *
 * @author brad
 */
public class SignupApp implements ChildPageApplication, BrowsableApplication, EventListener, ReportingApplication, SettingsApplication, PortletApplication {

    private static final Logger log = LoggerFactory.getLogger(SignupApp.class);
    public static final String NEXT_HREF = "signup.next.href";
    
    private String signupPageName = "signup";
    private StateProcess userManagementProcess;
    private TimerService timerService;
    private CurrentDateService currentDateService;
    private EventManager eventManager;
    private List<JsonReport> reports;
    private AppConfig config;

    public SignupApp() {
        reports = new ArrayList<>();
        reports.add(new GroupSignupsReport());
        
    }

    @Override
    public String getInstanceId() {
        return "signup";
    }

    @Override
    public String getTitle(Organisation organisation, Website website) {
        return "User registration and signup";
    }

    @Override
    public String getSummary(Organisation organisation, Website website) {
        return "Provides signup pages, which allows people to join your websites and groups";
    }

    @Override
    public void init(SpliffyResourceFactory resourceFactory, AppConfig config) throws Exception {
        userManagementProcess = buildProcess();
        eventManager = resourceFactory.getEventManager();
        currentDateService = config.getContext().get(CurrentDateService.class);
        timerService = config.getContext().get(TimerService.class);
        this.config = config;
    }

    @Override
    public Resource getPage(Resource parent, String requestedName) {
        if (parent instanceof GroupInWebsiteFolder) {
            GroupInWebsiteFolder wrf = (GroupInWebsiteFolder) parent;
            if (requestedName.equals(signupPageName)) {
                return new GroupRegistrationPage(requestedName, wrf, this);
            }
        }
        if( parent instanceof OrganisationFolder) {
            OrganisationFolder orgFolder = (OrganisationFolder) parent;
            if( requestedName.equals("pendingApps")) {
                return new ProcessPendingPage("pendingApps", orgFolder, this);
            }
        }
        return null;
    }

    @Override
    public void addBrowseablePages(CollectionResource parent, ResourceList children) {
        if (parent instanceof WebsiteRootFolder) {
            WebsiteRootFolder wrf = (WebsiteRootFolder) parent;
            Website website = wrf.getWebsite();
            List<GroupInWebsite> groupsInWebsite = website.groups(SessionManager.session());
            for (GroupInWebsite giw : groupsInWebsite) {
                GroupInWebsiteFolder f = new GroupInWebsiteFolder(giw, wrf);
                children.add(f);
            }
        }
    }


    @Override
    public List<JsonReport> getReports(Organisation org, Website website) {
        return reports;
    }    
    
    private StateProcess buildProcess() {
        StateProcessBuilder b = new StateProcessBuilder("userSubscription", "start");
        b.from("start").transition("started").to("active").when(new TrueRule()).then(signupEvent(SubscriptionEvent.SubscriptionAction.ACCEPTED));;
        // TODO: more stuff here eventually
        return b.getProcess();
    }



    private ActionHandler signupEvent(SubscriptionEvent.SubscriptionAction a) {
        return new SubscriptionEventActionHandler(a);
    }

    public void onNewMembership(GroupMembership gm, RootFolder rf) {
        MembershipProcess pp = new MembershipProcess();
        pp.setMembership(gm);
        pp.setProcessName(userManagementProcess.getName());
        pp.setProcessVersion(1);

        ProcessContext context = new ProcessContext(pp, userManagementProcess, timerService, currentDateService);
        if (rf instanceof WebsiteRootFolder) {
            RootFolder wrf = rf;
            context.addAttribute("website", wrf);
        }
        context.scan();
        log.info("Final state: " + pp.getStateName());
    }

    /**
     * Get the URL to redirect the new user to
     * 
     * @param newUser
     * @return 
     */
    public String getNextHref(Profile newUser, Website website) {
        String s = config.get(NEXT_HREF, website);
        return s;
    }
    
    @Override
    public void onEvent(Event e) {
    }

    @Override
    public void renderSettings(Profile currentUser, Organisation org, Website website, Context context, Writer writer) throws IOException {
        String href; // = findSetting("gaAccountNumber", rootFolder);
        if( website != null ) {
            System.out.println("get from website - " + website.getName());
            href = config.get(NEXT_HREF, website);
        } else {
            System.out.println("get from org");
            href = config.get(NEXT_HREF, org);
        }        
        System.out.println("current href: " + href);
        if( href == null ) {
            href = "";
        }
        writer.write("<label for='signupNextHref'>First page after signup</label>");
        writer.write("<input type='text' id='signupNextHref' name='signupNextHref' value='" + href + "' />");
        writer.flush();
    }

    
    @Override
    public JsonResult processForm(Map<String, String> parameters, Map<String, FileItem> files, Organisation org, Website website) throws BadRequestException, NotAuthorizedException, ConflictException {
        System.out.println("save settings");
        String signupNextHref = parameters.get("signupNextHref");
        if( website != null ) {
            config.set(NEXT_HREF, website, signupNextHref);
        } else {
            config.set(NEXT_HREF, org, signupNextHref);
        }
        return new JsonResult(true);        
    }

    @Override
    public void renderPortlets(String portletSection, Profile currentUser, RootFolder rootFolder, Context context, Writer writer) throws IOException {
        if (portletSection.equals("adminDashboardPrimary")) {
            CommonResource r = (CommonResource) context.get("page");
            List<GroupMembershipApplication> applications = GroupMembershipApplication.findByAdminOrg(r.getOrganisation(), SessionManager.session());
            System.out.println("apps: " + applications.size() + " for org: " + r.getOrganisation().getId() + " - " + r.getOrganisation().getName() + " - " + r.getClass());
            context.put("applications", applications);
            _(TextTemplater.class).writePage("signup/pendingAccountsPortlet.html", currentUser, rootFolder, context, writer);
        }
    }

    /**
     * accept or reject the given app
     * 
     * @param gma
     * @param b 
     */
    public void processPending(GroupMembershipApplication gma, Boolean b, Session session) {        
        if( b ) {
            Profile p = gma.getMember();            
            Organisation org = gma.getWithinOrg();
            Group group = gma.getGroupEntity();
            p.addToGroup(group, org, session);
            SignupLog.logSignup(gma.getWebsite(), p, org, group, SessionManager.session());
        } else {
            // TODO: send rejected email
        }
        session.delete(gma);
    }
      

    public class SubscriptionEventActionHandler implements ActionHandler {

        private final SubscriptionEvent.SubscriptionAction action;

        public SubscriptionEventActionHandler(SubscriptionAction action) {
            this.action = action;
        }

        @Override
        public void process(ProcessContext context) {
            MembershipProcess pi = (MembershipProcess) context.getProcessInstance();
            GroupMembership gm = pi.getMembership();
            WebsiteRootFolder wrf = (WebsiteRootFolder) context.getAttribute("website");
            Website website = null;
            if (wrf != null) {
                website = wrf.getWebsite();
            }
            try {
                
                SubscriptionEvent e = new SubscriptionEvent(gm, website, action);
                eventManager.fireEvent(e);
            } catch (ConflictException | BadRequestException | NotAuthorizedException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
