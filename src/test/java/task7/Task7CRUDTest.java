package task7;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sviat.dev.task6.HibernateUtil;
import sviat.dev.task7.dao.*;

/**
 * Implement OneToOne, OneToMany, and ManyToMany relations in your models from the previous task.(Task_6) <br/>
 * Test it by CRUD.
 */
public class Task7CRUDTest {
    private Session session;
    private Transaction transaction;

    @BeforeMethod
    public void setUp() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
    }

    @AfterMethod
    public void tearDown() {
        if (session != null) {
            session.close();
        }
    }

    @Test
    public void testCreatePerson() {
        Person person = Person.builder()
                .name("Test Person 1")
                .build();

        Address address = Address.builder()
                .city("Test City 1")
                .street("Test Street 1")
                .build();

        person.setAddress(address);

        session.save(person);

        Person savedPerson = session.get(Person.class, person.getId());

        Assert.assertNotNull(savedPerson);
        Assert.assertEquals(savedPerson.getName(), "Test Person 1");
        Assert.assertEquals(savedPerson.getAddress().getCity(), "Test City 1");
        Assert.assertEquals(savedPerson.getAddress().getStreet(), "Test Street 1");
    }

    @Test(dependsOnMethods = {"testCreatePerson"})
    public void testReadPerson() {
        Person fetchedPerson = session.get(Person.class, 1L);

        Assert.assertNotNull(fetchedPerson);
        Assert.assertEquals(fetchedPerson.getName(), "Test Person 1");
        Assert.assertEquals(fetchedPerson.getAddress().getCity(), "Test City 1");
        Assert.assertEquals(fetchedPerson.getAddress().getStreet(), "Test Street 1");
    }

    @Test(dependsOnMethods = {"testCreatePerson", "testReadPerson"})
    public void testUpdatePerson() {
        Person fetchedPerson = session.get(Person.class, 1L);

        fetchedPerson.setName("Test Person 1 Updated");
        session.update(fetchedPerson);

        Person updatedPerson = session.get(Person.class, 1L);
        Assert.assertNotNull(updatedPerson);
        Assert.assertEquals(updatedPerson.getName(), "Test Person 1 Updated");
    }

    @Test(dependsOnMethods = {"testCreatePerson", "testReadPerson", "testUpdatePerson", "testOneToManyRelationship"})
    public void testDeletePerson() {
        Person fetchedPerson = session.get(Person.class, 1L);

        session.delete(fetchedPerson);
        session.flush();

        Person deletedPerson = session.get(Person.class, fetchedPerson.getId());
        Assert.assertNull(deletedPerson);
    }

    @Test
    public void testOneToManyRelationship() {
        Person person = session.get(Person.class, 1L);

        Order order1 = Order.builder()
                .orderNumber("SN001")
                .person(person)
                .build();

        Order order2 = Order.builder()
                .orderNumber("SN002")
                .person(person)
                .build();

        person.getOrders().add(order1);
        person.getOrders().add(order2);

        session.save(person);
        session.flush();

        Person savedPerson = session.get(Person.class, 1L);
        Assert.assertEquals(savedPerson.getOrders().size(), 2);
    }

}
