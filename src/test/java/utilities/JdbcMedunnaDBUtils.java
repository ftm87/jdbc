package utilities;

import java.sql.*;

public class JdbcMedunnaDBUtils {
    private static Connection connection;
    private static Statement statement ;

    //tek satirlik aciklamalar icin
    /*
    çok satirlik aciklamalar icin
     */
    /**
     * Bu method belirtilen parametreleri kullanarak database e baglanti kurar
     * @return connection
     */
    public static Connection connectToDatabase()  {

        String url="jdbc:postgresql://medunna.com:5432/medunna_db_v2";
        String user="select_user";
        String password="Medunna_pass_@6";
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    /**
     * Bu method daha once olusturulan connection objecti uzerinden statement olusturur
     * @return statement
     */
    public static Statement createStatement(){
        try {
            statement = connectToDatabase().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }
    /**
     * Bu method parametre olarak verilen SQL sorgusunu calistirir ve sonuclari bir resultset olarak return eder
     * @param sql
     * @return resultset
     */
    public static ResultSet executeQuery(String sql){
        try {
            return createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Bu method statement ve connection u kapatir
     */
    public static void closeConnection(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}