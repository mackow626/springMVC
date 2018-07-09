package hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    String file = "hibernateOneToMany.cfg.xml";

    @Test
    void getInstrictorCourses() {
        SessionFactory factory = getSessionFactory(file);
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Course course = session.get(Course.class, 15);
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
    void OneToManyCreate() {
        SessionFactory factory = getSessionFactory(file);
        Session session = factory.getCurrentSession();

        try {

            InstructorDetails instructorDetails = new InstructorDetails("youtube", "tenis");
            Instructor instructor = new Instructor("Maciej", "Kowalczuk", "email@wp.pl", instructorDetails);
            instructorDetails.setInstructor(instructor);

            Course course1 = new Course("java12");
            Course course2 = new Course("C#13");
            instructor.add(course1);
            instructor.add(course2);
            session.beginTransaction();
            session.save(instructorDetails);

            session.save(course1);
            session.save(course2);

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

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb-03-one-to-many?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
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

    public static SessionFactory getSessionFactory(String file) {
        return new Configuration()
                .configure(file)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }


}