package com.itheima.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {


    private static EntityManagerFactory em;

    static {
        em = Persistence.createEntityManagerFactory("myPersistUnit");

    }

    /**
     * 使用管理器工厂生产一个管理器对象
     * @return
     */
    public static EntityManager getEntityManager(){
        return em.createEntityManager();
    }

}
