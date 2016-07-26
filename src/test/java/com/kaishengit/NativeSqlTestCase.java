package com.kaishengit;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by D on 2016/7/26.
 */
public class NativeSqlTestCase {
    @Test
    public void testFind(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String sql = "select*from t_user";
        SQLQuery query = session.createSQLQuery(sql);
        List<Object[]> result = query.list();
        for (Object[] objects:result){
            System.out.println(objects[1]+":"+objects[2]);
        }
        session.getTransaction().commit();
    }
    @Test
    public void testFindById(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String sql = "select * from t_user where id = :id";
        SQLQuery query = session.createSQLQuery(sql);
        query.setInteger("id",8);
        Object[] objects = (Object[]) query.uniqueResult();
        System.out.println(objects[0]+"->"+objects[1]);
        session.getTransaction().commit();
    }
    @Test
    public void testFindByIdToUser(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String sql = "select * from t_user where id = :id";
        SQLQuery query = session.createSQLQuery(sql).addEntity(User.class);
        query.setParameter("id",8);
        User user = (User) query.uniqueResult();
        System.out.println(user);
        session.getTransaction().commit();
    }

}
