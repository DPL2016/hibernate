package com.kaishengit;


import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class HibernateLifeTestCase {
    @Test
    public void testSave(){
        Session session  = HibernateUtil.getSession();
        session.beginTransaction();
        User user = new User();
        user.setUsername("rose");
        user.setPassword("123123");
        session.persist(user);
        System.out.println(user.getId());
        /*session.save(user);
        System.out.println(user.getId());
        Integer id = (Integer) session.save(user);
        System.out.println(id);
        session.getTransaction().commit();*/

    }
    @Test
    public void testFindByGet(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,7);
        session.getTransaction().commit();
        Assert.assertNull(user);
    }

    @Test
    public void testFindByLoad(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.load(User.class,7);
        System.out.println(user.getUsername());
        System.out.println(user==null);
        session.getTransaction().commit();
    }
    @Test
    public void testUpdate(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,6);
        session.getTransaction().commit();
        user.setUsername("james");
        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();
        session1.update(user);
        session1.getTransaction().commit();
    }
    @Test
    public void testSaveOrUpdate(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = new User();
        user.setUsername("李斯");
        user.setPassword("321455");
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        user.setPassword("90840723");
        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();
        session1.saveOrUpdate(user);
        session1.getTransaction().commit();
    }

    @Test
    public void testMerge(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
//        User user = new User();
//        user.setUsername("李四");
//        user.setPassword("33333");
//        session.merge(user);
        User user = (User) session.get(User.class,6);
        session.getTransaction().commit();
        user.setPassword("456321");
        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();
        session1.merge(user);
        session1.getTransaction().commit();
    }

    @Test
    public void testDelete(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,5);
        session.getTransaction().commit();
        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();
        session1.delete(user);
        session1.getTransaction().commit();
    }

    @Test
    public void testClear(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,4);
        user.setPassword("164839");
        session.flush();
        System.out.println(user);
        session.getTransaction().commit();
    }
}
