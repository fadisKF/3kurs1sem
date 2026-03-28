package com.db.kafedra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseManager {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {

        try {

            emf = Persistence.createEntityManagerFactory("KAFEDRA");

            System.out.println("Подключение к основной БД MySQL");

        } catch (Exception e) {

            System.out.println("Ошибка подключения к MySQL");
            System.out.println("Переключение на резервную БД MariaDB");

            emf = Persistence.createEntityManagerFactory("KAFEDRA_BACKUP");
        }

        return emf.createEntityManager();
    }
}