package sviat.dev.task7;

import org.hibernate.Session;
import sviat.dev.task6.HibernateUtil;
import sviat.dev.task7.dao.Address;
import sviat.dev.task7.dao.Person;

public class Task7 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Person person1 = Person.builder()
                .name("Person 1")
                .address(Address.builder().street("Test street").city("Test city").build())
                .build();

        session.save(person1);

        session.getTransaction().commit();

        session.close();

        HibernateUtil.shutdown();
    }
}
