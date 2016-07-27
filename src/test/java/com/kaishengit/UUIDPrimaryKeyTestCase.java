package com.kaishengit;

import com.kaishengit.pojo.Task;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.junit.Test;

public class UUIDPrimaryKeyTestCase {
    @Test
    public void testSave(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Task task = new Task();
        task.setTitle("X-1");
        session.save(task);
        session.getTransaction().commit();
    }
    @Test
    public void testFindByID(){
        Session session  = HibernateUtil.getSession();
        session.beginTransaction();
        Task task = (Task) session.get(Task.class,"4028818d562af5ab01562af5b19e0000");
//        System.out.println(session.contains(task));
//        session.clear();
        session.getTransaction().commit();
        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();

        Task task1 = (Task) session1.get(Task.class,"4028818d562af5ab01562af5b19e0000");
        System.out.println(task1.getTitle());
        session1.getTransaction().commit();
    }
    //乐观锁
    @Test
    public void testUpdate() throws InterruptedException {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Task task = (Task) session.get(Task.class,"8a8082e454bc3f1b0154bc3f1f6a0000");
        task.setTitle("H3");
        Thread.sleep(10000);
        session.getTransaction().commit();
    }

    //悲观锁
    @Test
    public void testUpdate2() throws InterruptedException {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Task task = (Task) session.get(Task.class,"8a8082e454bc3f1b0154bc3f1f6a0000", LockOptions.UPGRADE);
        task.setTitle("H3");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Session session1 = HibernateUtil.getSession();
                session1.beginTransaction();
                Task task1 = (Task) session1.get(Task.class,"8a8082e454bc3f1b0154bc3f1f6a0000", LockOptions.UPGRADE);
                task1.setTitle("H6");
                session1.getTransaction().commit();
            }
        });
        thread.start();
        Thread.sleep(5000);
        session.getTransaction().commit();
    }
}
