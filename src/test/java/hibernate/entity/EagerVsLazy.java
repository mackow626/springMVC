package hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EagerVsLazy {


    String file = "hibernateOneToMany.cfg.xml";

    @Test
    void getLazy() {
        SessionFactory factory = CourseTest.getSessionFactory(file);
        Session session = factory.getCurrentSession();
        Instructor instructor;

        try {
            session.beginTransaction();
            instructor = session.get(Instructor.class, 22);
            // assertEquals(instructor.getCourses().size(),0);


            session.getTransaction().commit();

            System.out.println("Działa!!!");
            assertTrue(true);
        } finally {
            {
                session.close();
                factory.close();
            }
        }
        assertEquals(2, instructor.getCourses().size());
    }


    @Test
    void getLazyHQL() {
        SessionFactory factory = CourseTest.getSessionFactory(file);
        Session session = factory.getCurrentSession();
        Instructor instructor;

        try {
            session.beginTransaction();

            Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses where i.id=22", Instructor.class);

       //     query.setParameter("InstructorID", 22);

            instructor = query.getSingleResult();

            session.getTransaction().commit();

            System.out.println("Działa!!!");
            assertTrue(true);
        } finally {
            {
                session.close();
                factory.close();
            }
        }
        assertEquals(2, instructor.getCourses().size());

    }
}