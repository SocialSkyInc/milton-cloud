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

import io.milton.resource.CollectionResource;
import io.milton.resource.Resource;
import io.milton.cloud.server.apps.AppConfig;
import io.milton.cloud.server.apps.Application;
import io.milton.cloud.server.web.SpliffyResourceFactory;
import io.milton.cloud.server.apps.website.WebsiteRootFolder;
import io.milton.cloud.server.web.ResourceList;
import io.milton.event.EventManager;

/**
 *
 * @author brad
 */
public class SignupApp implements Application {
    private EventManager eventManager;
    private String signupPageName = "signup";

    public SignupApp() {
    }

    
    
    @Override
    public String getInstanceId() {
        return "signup";
    }

        
    @Override
    public void init(SpliffyResourceFactory resourceFactory, AppConfig config) throws Exception {
        this.eventManager = resourceFactory.getEventManager();
    }

    @Override
    public Resource getPage(Resource parent, String requestedName) {
        if (parent instanceof WebsiteRootFolder) {
            WebsiteRootFolder rf = (WebsiteRootFolder) parent;
            if (requestedName.equals(signupPageName)) {
                return new SignupPage(requestedName, rf);
            }
        }
        return null;
    }

    @Override
    public void addBrowseablePages(CollectionResource parent, ResourceList children) {
    }
}