package com.db.kafedra;

import com.db.kafedra.entity.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DisciplineTest {

    @Test
    void testDiscipline(){

        Teacher t = new Teacher("Анна","Сидорова");

        Discipline d = new Discipline("Java", t);

        assertEquals("Java", d.getName());
        assertEquals(t, d.getTeacher());
    }

}