package cc.robotdreams;

import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class PersonTest {

    public void testGettersAndSetters() {
        Man man = new Man("Василь", "Чірт", 30);
        man.setAge(40);
        man.setLastName("Сірт");

        Assert.assertEquals(man.getFirstName(), "Василь", "Невірне ім'я");
        Assert.assertEquals(man.getLastName(), "Сірт", "Невірне прізвище");
        Assert.assertEquals(man.getAge(), 40, "Невірний вік");
    }

    public void testIsRetiredForMan() {
        Man man1 = new Man("Василь", "Чірт", 65);
        Man man2 = new Man("Петро", "Коваль", 66);

        Assert.assertTrue(man1.isRetired(), "Василь Чірт на пенсії");
        Assert.assertTrue(man2.isRetired(), "Петро Коваль на пенсії");
    }

    public void testIsNotRetiredForMan() {
        Man man = new Man("Володимир", "Сидоренко", 64);
        Assert.assertFalse(man.isRetired(), "Володимир Сидоренко ще не на пенсії");
    }

    public void testIsRetiredForWoman() {
        Woman woman1 = new Woman("Іра", "Дика", 60);
        Woman woman2 = new Woman("Ольга", "Лисенко", 61);

        Assert.assertTrue(woman1.isRetired(), "Іра Дика на пенсії");
        Assert.assertTrue(woman2.isRetired(), "Ольга Лисенко повинна бути на пенсії");
    }

    public void testIsNotRetiredForWoman() {
        Woman woman = new Woman("Тетяна", "Мельник", 59);
        Assert.assertFalse(woman.isRetired(), "Тетяна Мельник ще не на пенсії");
    }

    public void testRegisterPartnershipForManAndWoman() {
        Person man = new Man("Іван", "Петров", 30);
        Person woman = new Woman("Ольга", "Коваленко", 28);

        ((Man) man).registerPartnership((Woman) woman);

        Assert.assertEquals(((Man) man).getPartner(), woman, "Партнерство між чоловіком і жінкою не встановлено");
        Assert.assertEquals(((Woman) woman).getPartner(), man, "Партнерство між жінкою і чоловіком не встановлено");
    }

    public void testDeregisterPartnershipForMan() {
        Person man = new Man("Іван", "Петров", 30);
        Person woman = new Woman("Ольга", "Коваленко", 28);

        ((Woman) woman).registerPartnership((Man) man);
        ((Woman) woman).deregisterPartnership(true);

        Assert.assertNull(((Man) man).getPartner(), "Партнер чоловіка не був видалений");
        Assert.assertNull(((Woman) woman).getPartner(), "Партнер жінки не був видалений");
    }
}