package com.itheima;


import com.itheima.domain.Customer;
import com.itheima.utils.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    @Test
    public void testSave(){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");

        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Customer customer = new Customer();
        customer.setCustName("传智播客");
        customer.setCustAddress("南京");

        em.persist(customer);
        tx.commit();

        em.close();
        factory.close();

    }


    @Test
    public void testSave2(){

        EntityManager em = JPAUtil.getEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Customer customer = new Customer();
        customer.setCustName("传智播客2");
        customer.setCustAddress("南京2");

        em.persist(customer);
        tx.commit();

        em.close();


    }

    @Test
    public void testAdd(){
        Customer c = new Customer();
        c.setCustName("传智学院");
        c.setCustLevel("VIP客户");
        c.setCustSource("网络");
        c.setCustIndustry("IT教育");
        c.setCustAddress("昌平区北七家镇");
        c.setCustPhone("010-84389340");

        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            // 获取实体管理对象
            em = JPAUtil.getEntityManager();
            // 获取事务对象
            tx = em.getTransaction();
            // 开启事务
            tx.begin();
            // 执行操作
            em.persist(c);
            // 提交事务
            tx.commit();
        } catch (Exception e) {
            // 回滚事务
            tx.rollback();
            e.printStackTrace();
        } finally {
            // 释放资源
            em.close();
        }


    }

    @Test
    public void testFind(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        //EntityTransaction tx = entityManager.getTransaction();
        //tx.begin();

        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer);
        //tx.commit();
        entityManager.close();
    }

    /**
     *
     */
    @Test
    public  void testReference() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println(customer);
        tx.commit();
        entityManager.close();
    }
}

