package day01_databasetesting;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class C03_CityTest {

          /*
connect to the database
get city names from the 'cities' table
verify that there are at least 10 city names in the city_name column
close the connection
    */


    @Test
    public void test01() throws SQLException {

        //veritabanına bağlan
        String url="jdbc:postgresql://localhost:5432/myDatabase";
        String user="tester";
        String password="tester";

        Connection connection =DriverManager.getConnection(url,user,password);
        Statement statement=connection.createStatement();

        //'cities' tablosundan sehir isimlerini al
        ResultSet resultSet= statement.executeQuery("select city_name from cities");
        int counter=0;
        while (resultSet.next()){
            counter++;
        }



        //city_name sütununda en az 10 tane sehir ismi olduğunu doğrulayın

        Assert.assertTrue(counter>9);


        //bağlantıyı kapat

       statement.close();
       connection.close();

    }
    @Test
    public void test02() throws SQLException {
        //veritabanına bağlan
        String url = "jdbc:postgresql://localhost:5432/myDatabase";
        String user = "tester";
        String password = "tester";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        //'cities' tablosundan sehir isimlerini al
        ResultSet resultSet = statement.executeQuery("select count(city_name) from cities");

        resultSet.next();

        //city_name sütununda en az 10 tane sehir ismi olduğunu doğrulayın

        int actualData = resultSet.getInt("count");

        Assert.assertTrue(actualData > 9);

        //bağlantıyı kapat
        statement.close();
        connection.close();
    }
}
