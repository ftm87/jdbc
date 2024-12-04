package day02_databasetesting;

import org.junit.Assert;
import org.junit.Test;
import utilities.JdbcLocalDBUtils;
import utilities.JdbcMedunnaDBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class C03_MedunnaTest {

    // User connects to database
    // (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6)
    // User sends query with room_number to get created room
    // User verifies that room information is saved correctly
    // User closes connection
    @Test
    public void test01() throws SQLException {

        //    Kullanıcı veritabanına bağlanır
        //    (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6)
        //    Kullanıcı, oluşturulan odayı getirmek için room_number ile sorgu gönderir
        //    Kullanıcı, oda bilgilerinin doğru kaydedildiğini doğrular
        //    Kullanıcı, bağlantıyı kapatır

        //1) Expected Datalar duzenlenir(gereksinimler yani kullanicinin girdigi

        String expectedRoomType="TWIN";
        String expectedDescription="Batch 291Database Testi icin olusturuldu";
        boolean expectedStatus=true;

        //2)Database den gerekli query ile datalar cekilir

        String sql="select * from room where room_number =30303033 ";
        ResultSet resultSet = JdbcMedunnaDBUtils.executeQuery(sql);
        resultSet.next();


        //3) Actual Datalar duzenlenir(uygulamadan gelen

        String actualRoomType=resultSet.getString("room_type");
        String actualDescription=resultSet.getString("description");
        boolean actualStatus=resultSet.getBoolean("status");

        //4) Assertionlar yapilir

       Assert.assertEquals(expectedRoomType,actualRoomType);
       Assert.assertEquals(expectedDescription,actualDescription);
        Assert.assertEquals(expectedStatus,actualStatus);
    }

//----------------------------------------------------------------
//2.yolda daha sadeleserek yapalim


    @Test
    public void test2() throws SQLException {

        //1)Database den gerekli query ile datalar cekilir
        String sql="select * from room where room_number =30303033 ";
        ResultSet resultSet = JdbcMedunnaDBUtils.executeQuery(sql);

        resultSet.next();

        //2) Assertionlar yapilir

        Assert.assertEquals("TWIN",resultSet.getString("room_type"));
        Assert.assertEquals("Batch 291Database Testi icin olusturuldu",resultSet.getString("description"));
        Assert.assertTrue(resultSet.getBoolean("status"));

        //NOT;burda yaptigimiz sadelestirme  Expected Datalar ile Actual Datalar assert ederken ayni sekilde sorguladik
    }
}
