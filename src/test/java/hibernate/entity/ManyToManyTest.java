package hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

class ManyToManyTest {

    String file = "hibernateManyToMany.cfg.xml";
    @Test
    void ManyToManyDeleteStudentButNotDeleteCourse() {
        SessionFactory factory = CourseTest.getSessionFactory(file);
        Session session = factory.getCurrentSession();
        Student student;


        try {
            session.beginTransaction();

            student = session.get(Student.class, 3);
            session.delete(student);

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
    void ManyToManyDeleteCourseButNotDeleteStudent() {
        SessionFactory factory = CourseTest.getSessionFactory(file);
        Session session = factory.getCurrentSession();
        Course course;


        try {
            session.beginTransaction();

            course = session.get(Course.class, 11);
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
    void ManyToManyCreate() {
        SessionFactory factory = CourseTest.getSessionFactory(file);
        Session session = factory.getCurrentSession();
        Course course;
        Student student;
        Student student1;

        try {
            session.beginTransaction();

            course = new Course("Manytomany kurs");
            student = new Student("Maciek", "jol", "aefse2p.pl");
            student1 = new Student("Maciek123", "3333", "ae1232p.pl");

            course.add(student);
            course.add(student1);

            session.save(student);
              session.save(course);
            session.save(student1);


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
    void ManyToManyAndcourse() {
        SessionFactory factory = CourseTest.getSessionFactory(file);
        Session session = factory.getCurrentSession();
        Course course;
        Course course1;
        Student student;


        try {
            session.beginTransaction();

            student = session.get(Student.class, 3);
            course = new Course("drugi kurs12344");
            course1 = new Course("trzeci kurs41241");
            student.add(course);
            student.add(course1);

            session.save(course);
            session.save(course1);

            //  session.update(student);




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
    void ManyToManyGET() {
        SessionFactory factory = CourseTest.getSessionFactory(file);
        Session session = factory.getCurrentSession();
        Student student;


        try {
            session.beginTransaction();

            student = session.get(Student.class, 3);

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

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb-05-many-to-many?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
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