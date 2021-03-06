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
package io.milton.vfs.db;

import io.milton.vfs.db.utils.DbUtils;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Represents that some entity (normally a user) is a member of a group within
 * an organisation or business unit.
 *
 * Note that the concept of user groups is common, but is not usually qualified
 * the way we do it here. This is because frequently there is only a single
 * administrative domain, but milton-cloud supports multiple, nested business
 * units.
 *
 * Examples: - Sally is a pharmacist in "Cronulla Amcal Pharmacy" - Bob is in
 * the "Sales Rep" group for the "Southern Region" - Bob is also in the "Report
 * Viewers" group for the "ACME Corporation" - Susan is in the "Administrators"
 * group for "ACME Corporation"
 *
 * @author brad
 */
@Entity
@Table(
//        uniqueConstraints = {
//    @UniqueConstraint(columnNames = {"member", "group_entity", "within_org"})}
)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GroupMembership implements Serializable {

    public static GroupMembership get(long membershipId, Session session) {
        return (GroupMembership) session.get(GroupMembership.class, membershipId);
    }

    public static List<GroupMembership> findByCustomValue(Group g, String fieldName, String fieldValue, Session session) {
        Criteria crit = session.createCriteria(GroupMembership.class);
        crit.createAlias("fields.nvPairs", "p");
        crit.setCacheable(true);
        crit.add(Restrictions.eq("groupEntity", g));
        crit.add(Restrictions.eq("p.name", fieldName));
        crit.add(Restrictions.eq("p.propValue", fieldValue));
        return DbUtils.toList(crit, GroupMembership.class);
    }

    public static List<GroupMembership> find(Organisation withinOrg, Session session) {
        Criteria crit = session.createCriteria(GroupMembership.class);
        crit.setCacheable(true);
        crit.add(Restrictions.eq("withinOrg", withinOrg));
        return DbUtils.toList(crit, GroupMembership.class);
    }

    public static List<GroupMembership> find(Group group, Organisation withinOrg, Session session) {
        Criteria crit = session.createCriteria(GroupMembership.class);
        crit.setCacheable(true);
        crit.add(Restrictions.eq("withinOrg", withinOrg));
        crit.add(Restrictions.eq("groupEntity", group));
        return DbUtils.toList(crit, GroupMembership.class);
    }

    public static List<GroupMembership> find(String groupName, Organisation withinOrg, Session session) {
        Criteria crit = session.createCriteria(GroupMembership.class);
        Criteria critGroup = crit.createCriteria("groupEntity");
        crit.setCacheable(true);
        crit.add(Restrictions.eq("withinOrg", withinOrg));
        critGroup.add(Restrictions.eq("name", groupName));
        return DbUtils.toList(crit, GroupMembership.class);
    }

    public static long count(Group group, Session session) {
        Criteria crit = session.createCriteria(GroupMembership.class);
        crit.setCacheable(true)
                .setProjection(Projections.projectionList()
                .add(Projections.rowCount()));
        crit.add(Restrictions.eq("groupEntity", group));
        List list = crit.list();
        if (list == null || list.isEmpty()) {
            return 0;
        } else {
            Object o = list.get(0);
            if (o instanceof Long) {
                return (long) o;
            } else if (o instanceof Integer) {
                Integer i = (Integer) o;
                return i.longValue();
            } else {
                throw new RuntimeException("Unknown type: " + o.getClass());
            }
        }
    }

    public static long count(Group group, Organisation org, Session session) {
        Criteria crit = session.createCriteria(GroupMembership.class);
        crit.setCacheable(true)
                .setProjection(Projections.projectionList()
                .add(Projections.rowCount()));
        crit.add(Restrictions.eq("withinOrg", org));
        crit.add(Restrictions.eq("groupEntity", group));
        List list = crit.list();
        if (list == null || list.isEmpty()) {
            return 0;
        } else {
            Object o = list.get(0);
            if (o instanceof Long) {
                return (long) o;
            } else if (o instanceof Integer) {
                Integer i = (Integer) o;
                return i.longValue();
            } else {
                throw new RuntimeException("Unknown type: " + o.getClass());
            }
        }
    }

    /**
     * Returns a de-duped set of organisations which the given memberships are
     * linked ot
     *
     * @param memberships
     * @return
     */
    public static Set<Organisation> toOrgs(List<GroupMembership> memberships) {
        Set<Organisation> set = new HashSet<>();
        for( GroupMembership m : memberships ) {
            set.add(m.getWithinOrg());
        }
        return set;
    }

    /**
     * Find memberships for a profile and group, regardless of containing org
     *
     * @param group
     * @param member
     * @param session
     * @return
     */
    public static List<GroupMembership> find(Group group, Profile member, Session session) {
        Criteria crit = session.createCriteria(GroupMembership.class);
        crit.setCacheable(true);
        crit.add(Restrictions.eq("member", member));
        crit.add(Restrictions.eq("groupEntity", group));
        return DbUtils.toList(crit, GroupMembership.class);
    }

    private Long id;
    private Organisation withinOrg;
    private Profile member;
    private Group groupEntity;
    private Date createdDate;
    private Date modifiedDate;
    private List<Subordinate> subordinates;
    private NvSet fields;

    public GroupMembership() {
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public NvSet getFields() {
        return fields;
    }

    public void setFields(NvSet fields) {
        this.fields = fields;
    }

    /**
     * The organisation that the linked user is a member of this group within.
     *
     * Eg Sally is a Manager in ACME Corporation
     *
     * @return
     */
    @ManyToOne(optional = false)
    public Organisation getWithinOrg() {
        return withinOrg;
    }

    public void setWithinOrg(Organisation withinOrg) {
        this.withinOrg = withinOrg;
    }

    @ManyToOne(optional = false)
    public Profile getMember() {
        return member;
    }

    public void setMember(Profile member) {
        this.member = member;
    }

    @ManyToOne(optional = false)
    public Group getGroupEntity() {
        return groupEntity;
    }

    public void setGroupEntity(Group group) {
        this.groupEntity = group;
    }

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @OneToMany(mappedBy = "groupMembership")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<Subordinate> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Subordinate> subordinates) {
        this.subordinates = subordinates;
    }

    public void delete(Session session) {
        if (getSubordinates() != null) {
            for (Subordinate s : getSubordinates()) {
                s.delete(session);
            }
        }
        this.getMember().getMemberships().remove(this);
        this.getGroupEntity().getGroupMemberships().remove(this);
        session.delete(this);
    }

    public void updateSubordinates(Session session) {

        if (getSubordinates() != null) {
            Iterator<Subordinate> it = getSubordinates().iterator();
            while (it.hasNext()) {
                Subordinate s = it.next();
                session.delete(s);
                it.remove();
            }
        }
        session.flush();

        Organisation subordinateTo = getWithinOrg();
        Profile user = getMember();
        while (subordinateTo != null) {
            user.createSubordinate(subordinateTo, this, session);
            subordinateTo = subordinateTo.getOrganisation();
        }
    }


}
