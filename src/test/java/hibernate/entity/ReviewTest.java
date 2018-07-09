package hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {


    String file = "hibernateOneToManyUni.cfg.xml";

    @Test
    void OneToManyUniCreate() {
        SessionFactory factory = CourseTest.getSessionFactory(file);
        Session session = factory.getCurrentSession();
        Course course;

        try {
            session.beginTransaction();

            course = new Course("fajny kurs1");
            course.add(new Review("super kurs1"));
            course.add(new Review("skkaby kurs"));
            course.add(new Review("taki o kurs"));

            session.save(course);

            session.getTransaction().commit();

            System.out.println("Działa!!!");
            assertTrue(true);
        } finally {
            {
                session.close();
                factory.close();
            }
        }
        assertEquals(course.getReviews().size(),3);
    }
    @Test
    void OneToManyUniDELETE() {
        SessionFactory factory = CourseTest.getSessionFactory(file);
        Session session = factory.getCurrentSession();
        Course course;

        try {
            session.beginTransaction();

            course = session.get(Course.class, 13);
            session.delete(course);

            session.getTransaction().commit();

            System.out.println("Działa!!!");
            assertTrue(true);
        } finally {
            {
                session.close();
                factory.close();
            }
        }

    }

    @Test
    void OneToManyUniGET() {
        SessionFactory factory = CourseTest.getSessionFactory(file);
        Session session = factory.getCurrentSession();
        Course course;

        try {
            session.beginTransaction();

            course = session.get(Course.class, 13);
            assertEquals(course.getReviews().size(),3);

            session.getTransaction().commit();

            System.out.println("Działa!!!");
            assertTrue(true);
        } finally {
            {
                session.close();
                factory.close();
            }
        }

    }

    @Test
    void dbConnectionCheck() {

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb-04-one-to-many-uni?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!!!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }



}