package hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {
    String file = "hibernateOneToOne.cfg.xml";

    @Test
    void BiDiractional() {
        SessionFactory factory = getSessionFactory(file);
        Session session = factory.getCurrentSession();

        try {

  InstructorDetails instructorDetails = new InstructorDetails("youtube111", "golf", new Instructor("jan", "kowalski", "blabla@wp.pl"));

            session.beginTransaction();
            session.save(instructorDetails);

            session.getTransaction().commit();

            System.out.println("Działa!!!");
            assertTrue(true);
        } finally {
            {
                factory.close();
            }
        }

    }

    @Test
    void oneToOneAndOneDirection() {

        SessionFactory factory = getSessionFactory(file);
        Session session = factory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Maciej123", "Kowalczuk123", "as3d@wp.pl", new InstructorDetails("zostan testerem123", "snooker123"));

            session.beginTransaction();
            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Działa!!!");
            assertTrue(true);
        } finally {
            {
                factory.close();
            }
        }
    }

    private static SessionFactory getSessionFactory(String file) {
        return new Configuration()
                .configure(file)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

    @Test
    void BIDirectionaldelete() {

        SessionFactory factory = getSessionFactory(file);
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            InstructorDetails instructorDetails = session.get(InstructorDetails.class, 4);

            session.delete(instructorDetails);

            session.getTransaction().commit();

            System.out.println("Działa!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            {
                session.close();
                factory.close();
            }
        }

        assertTrue(true);
    }

    @Test
    void delete() {

        SessionFactory factory = getSessionFactory(file);
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 2);

            session.delete(instructor);

            session.getTransaction().commit();

            System.out.println("Działa!!!");
        } finally {
            {
                factory.close();
            }
        }

        assertTrue(true);
    }


    @Test
    void dbConnectionCheck() {

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
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