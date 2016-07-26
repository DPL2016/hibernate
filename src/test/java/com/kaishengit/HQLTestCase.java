package com.kaishengit;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by D on 2016/7/26.
 */
public class HQLTestCase {
    @Test
    public void testFind(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();
        for (User user:userList){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }

    @Test
    public void testFindByWhere(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from User as u where u.password = :password and u.username = :name";
        Query query = session.createQuery(hql);
        query.setParameter("password","33333");
        query.setParameter("name","李四");
        List<User> userList = query.list();
        for (User user:userList){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }
    @Test
    public void testFindUnique(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from User where password = :pwd";
        Query query = session.createQuery(hql);
        query.setParameter("pwd","33333");
        User user = (User) query.uniqueResult();
        System.out.println(user);
        session.getTransaction().commit();
    }

    @Test
    public void findByCloumn(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "select id,username,password from User";
        Query query = session.createQuery(hql);
        List<Object[]>result = query.list();
        for (Object[]objects:result){
            System.out.println(objects[0]+"->"+objects[1]);
        }
        session.getTransaction().commit();
    }
    @Test
    public void testCount(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "select count(*),max(id) from User";
        Query query = session.createQuery(hql);
        Object[] objects = (Object[]) query.uniqueResult();
        System.out.println("count:"+objects[0]);
        System.out.println("Max:"+objects[1]);
        session.getTransaction().commit();
    }
    @Test
    public void testPage(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from User order by id desc";
        Query query = session.createQuery(hql);
        query.setFirstResult(2);
        query.setMaxResults(3);
        List<User>userList = query.list();
        for (User user:userList){
            System.out.println(user);
        }
        session.getTransaction().commit();
    }


}
