package sviat.dev.task6;

import org.hibernate.Session;
import sviat.dev.task6.dao.Meeting;

import java.util.Date;

/**
 * Install MySQL server (or any SQL like db) <br/>
 * Make at least two tables (Entities from the previous task or any additional if needed) <br/>
 * Make models for those Entities (from Task_5) <br/>
 * Setup Hibernate for those Entities and local DB <br/>
 * Check basic CRUD (create, read, update, and delete the BD records using Hibernate) <br/>
 * Generate a few rows into all tables
 */
public class Task6 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        // Create
        Meeting meeting = Meeting.builder()
                .title("Test")
                .description("Test description")
                .date(new Date())
                .build();

        Long id = (Long) session.save(meeting);

        // Read
        Meeting meetingLoaded = session.get(Meeting.class, id);
        System.out.println(meetingLoaded);

        // Update
        meetingLoaded.setDescription("New test description");
        session.update(meetingLoaded);

        System.out.println(meetingLoaded);

        // Delete
        session.delete(meetingLoaded);

        System.out.println(session.get(Meeting.class, id));

        session.getTransaction().commit();

        session.close();

        HibernateUtil.shutdown();
    }
}
