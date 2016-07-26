package com.kaishengit;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by D on 2016/7/26.
 */
public class CriteriaTestCase {
    @Test
    public void testFindAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List<User> userList = criteria.list();
        for (User user:userList){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }
    @Test
    public void testFindByWhere(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);

//        criteria.add(Restrictions.eq("password","33333"));
//        criteria.add(Restrictions.eq("username","李四"));

//        criteria.add(Restrictions.like("username","李", MatchMode.ANYWHERE));

//        criteria.add(Restrictions.in("username",new Object[]{"李四","李斯"}));

        /*Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.eq("username","李四"));
        disjunction.add(Restrictions.eq("username","李"));
        criteria.add(disjunction);*/

        criteria.add(Restrictions.or(Restrictions.eq("username","李四"),Restrictions.eq("username","张三")));

        List<User>userList = criteria.list();
        for(User user:userList){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }

    @Test
    public void testUnique(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("password","33333"));
        User user = (User) criteria.uniqueResult();
        System.out.println(user);
        session.getTransaction().commit();
    }

    @Test
    public void testPage(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.addOrder(Order.asc("id"));
        criteria.setFirstResult(2);
        criteria.setMaxResults(3);
        List<User> userList = criteria.list();
        for (User user:userList){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }
    @Test
    public void testCount(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
//        criteria.setProjection(Projections.rowCount());
//        criteria.setProjection(Projections.count("id"));
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.rowCount());
        projectionList.add(Projections.max("id"));
        criteria.setProjection(projectionList);
        Object[] objects = (Object[]) criteria.uniqueResult();
        System.out.println("Count:"+objects[0]);
        System.out.println("Max:"+objects[1]);
        session.getTransaction().commit();
    }

}
