package day02_databasetesting;

import org.junit.Assert;
import org.junit.Test;
import utilities.JdbcLocalDBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class C01_UtilitiesTest {


    // query city names with population over 3 million from 'cities' table
    // verify given city names "Istanbul", "Ankara", "Izmir"
    //close connection


    @Test
    public void test1() throws SQLException {

        JdbcLocalDBUtils.executeQuery("select * from cities");

        // 'cities' tablosundan nufusu 3 milyondan fazla olan sehir isimleri sorgula

        String sql="select city_name from cities where population>3000000";
        ResultSet resultSet = JdbcLocalDBUtils.executeQuery(sql);


        // verilen sehir isimlerini doğrula "Istanbul", "Ankara", "Izmir"

        List<String>actualData=new ArrayList<>();
        while (resultSet.next()){
           String cityName = resultSet.getString("city_name");
           actualData.add(cityName);

        }
        List<String> expectedData = List.of("Istanbul", "Ankara", "Izmir");
        Assert.assertEquals(expectedData,actualData);

        JdbcLocalDBUtils.closeConnection();

        //baglantiyi kapat


    }
}
