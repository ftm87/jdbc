package day01_databasetesting;

import org.junit.Assert;
import org.junit.Test;

public class C02_JunitFirstTest {
    //  Assert.assertEquals(expectedData,actualData); iki degerin esit olup olmadigini kontrol eder esitse test gecer degilse kalir
    @Test
    public  void  test1(){

        String expectedData ="selenium";
        String actualData ="selenium";
        Assert.assertEquals(expectedData,actualData);
    }

    // Assert.assertTrue("selenium".contains("E"));parantez icersinin ture oldugunun olup olmadigini kontrol eder.true ise gecer yoksa kalir
    @Test
    public void test2() {
        Assert.assertTrue("selenium".contains("e"));
        Assert.assertTrue(3<5);
    }

    // Assert.assertFalse(5<3);parantes icersinin false olup olmadigini kontrol eder false ise gecer
    @Test
    public void test3() {
        Assert.assertFalse(5<3);
    }

//Assert.assertNotEquals("selenium","seleniuM");iki degerin esit olmadigini kontrol eder esitse test KALİR degilse GECER
    @Test
    public void test4() {
        Assert.assertNotEquals("selnium","java");
    }
}
