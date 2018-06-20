package hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.nio.channels.SeekableByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    String file = "hibernate.cfg.xml";

    @Test
    void delete() {
        SessionFactory factory = getSessionFactory(file);

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Student student = session.get(Student.class, 1);
            session.delete(student);
            session.getTransaction().commit();
            System.out.println("Działa!!!");
        } finally {
            {
                factory.close();
            }
        }
    }

    @Test
    void updateStudent() {
        SessionFactory factory = getSessionFactory(file);

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Student student = session.get(Student.class, 2);
            student.setFirstName("Jola");
            student.setLastName("Gross");
            session.createQuery("update Student set email='aaaa@gmail.com'").executeUpdate();
            session.getTransaction().commit();

            assertEquals(student.getFirstName(), "Jola");


            System.out.println("Działa!!!");
        } finally {
            {
                factory.close();
            }
        }

    }

    @Test
    void hqlGetStudentList() {
        SessionFactory factory = getSessionFactory(file);

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student ").getResultList();

            displayList(students);

            List<Student> students1 = session.createQuery("from Student s where s.lastName ='Kowalczuk1'").getResultList();

            displayList(students1);

            List<Student> students2 = session.createQuery("from Student s where s.lastName ='Kowalczuk1' or s.firstName='Maciek2'").getResultList();

            List<Student> students3 = session.createQuery("from Student s where s.email LIKE '%@wp.pl'").getResultList();

            session.getTransaction().commit();

            assertEquals(students.size(), 7);
            assertEquals(students1.size(), 2);
            assertEquals(students2.size(), 4);
            assertEquals(students3.size(), 7);

            System.out.println("Działa!!!");
        } finally {
            {
                factory.close();
            }
        }

    }

    private void displayList(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    void getStudent() {
        SessionFactory factory = getSessionFactory(file);

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Student student = session.get(Student.class, 2);
            session.getTransaction().commit();

            assertEquals(student.getId(), 2);
            assertEquals(student.getFirstName(), "Maciek1");
            assertEquals(student.getLastName(), "Kowalczuk1");
            assertEquals(student.getEmail(), "email1@wp.pl");

            System.out.println("Działa!!!");
        } finally {
            {
                factory.close();
            }
        }

        assertTrue(true);

    }

    @Test
    public void primaryKeyDemoSave() {

        SessionFactory factory = getSessionFactory(file);

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Maciek1", "Kowalczuk1", "email1@wp.pl");
            Student student1 = new Student("Maciek2", "Kowalczuk2", "email2@wp.pl");
            Student student2 = new Student("Maciek3", "Kowalczuk3", "email3@wp.pl");
            session.beginTransaction();
            session.save(student);
            session.save(student1);
            session.save(student2);
            session.getTransaction().commit();

            System.out.println("Działa!!!");
        } finally {
            {
                factory.close();
            }
        }

        assertTrue(true);
    }

    private static SessionFactory getSessionFactory(String file) {
        return new Configuration()
                .configure(file)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    @Test
    public void saveNewUserToDatabase() {

        SessionFactory factory = getSessionFactory(file);

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Maciek", "Kowalczuk", "email@wp.pl");
            session.beginTransaction();
            session.save(student);
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
    public void ConectionTest() {

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb-01-one-to-one-uni?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
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