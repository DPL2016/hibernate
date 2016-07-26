package com.kaishengit;

import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Employee;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by D on 2016/7/26.
 */
public class OneToManyTestCase {
    @Test
    public void testSave(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Dept dept = new Dept();
        dept.setDeptname("one");
        Employee employee = new Employee();
        employee.setEmpname("a1");
        employee.setDept(dept);
        Employee employee1 = new Employee();
        employee1.setEmpname("a2");
        employee1.setDept(dept);
        session.save(dept);
        session.save(employee);
        session.save(employee1);
        session.getTransaction().commit();
    }
    @Test
    public void testFindDept(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Dept dept = (Dept) session.get(Dept.class,15);
        System.out.println(dept.getDeptname());
        Set<Employee> employeeSet = dept.getEmployeeSet();
        for (Employee employee:employeeSet){
            System.out.println(employee.getEmpname());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testFindEmployee(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class,29);
        System.out.println(employee.getEmpname());
        Dept dept = employee.getDept();
        System.out.println(dept.getDeptname());
        session.getTransaction().commit();
    }
    @Test
    public void testFindEmployeeAll(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        List<Employee> employeeList = criteria.list();
        for (Employee employee:employeeList){
            System.out.println(employee.getId()+":"+employee.getEmpname()+":"+employee.getDept().getDeptname());
        }
        session.getTransaction().commit();
    }
    @Test
    public void testDelete(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Dept dept = (Dept) session.get(Dept.class,15);
        session.delete(dept);
        session.getTransaction().commit();
    }
}
