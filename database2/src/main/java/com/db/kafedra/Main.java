package com.db.kafedra;

import jakarta.persistence.EntityManager;
import com.db.kafedra.entity.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = DatabaseManager.getEntityManager();
        em.getTransaction().begin();


        Teacher t1 = new Teacher("Иван", "Петров");
        Teacher t2 = new Teacher("Анна", "Сидорова");

        em.persist(t1);
        em.persist(t2);

        em.persist(new Discipline("Базы данных", t1));
        em.persist(new Discipline("Java", t1));
        em.persist(new Discipline("Алгоритмы", t2));

        em.getTransaction().commit();

        System.out.println("\n=== Универсальное отношение ===");

        List<Discipline> list =
                em.createQuery("SELECT d FROM Discipline d", Discipline.class)
                        .getResultList();

        for (Discipline d : list) {
            System.out.println(d.getTeacher() + " — " + d.getName());
        }

        em.close();
    }
}