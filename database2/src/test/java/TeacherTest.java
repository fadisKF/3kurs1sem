package com.db.kafedra;

import com.db.kafedra.entity.Teacher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    void testTeacherConstructor() {

        Teacher t = new Teacher("Иван","Петров");

        assertEquals("Иван", t.getFirstname());
        assertEquals("Петров", t.getLastname());
    }

    @Test
    void testTeacherToString(){

        Teacher t = new Teacher("Иван","Петров");

        assertEquals("Иван Петров", t.toString());
    }
}