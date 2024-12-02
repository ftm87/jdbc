import java.sql.*;
/*
Transaction: DB de en küçük işlem birimi(parçalanamaz,atomik)
Bazı durumlarda transaction yönetimini ele alabiliriz.
Bir veya birden fazla işlemi bir araya getirerek tek bir transaction başlatabiliriz.
Bu işlemlerden en az 1 i başarısız olduğunda yada herhangi bir koşulda
transactionı ROLLBACK ile geri alabiliriz
İşlemlerin tamamı başarılı olduğunda ise COMMIT ile onaylayarak
transactionı sonlandırıp değişiklikleri kalıcı hale getirebiliriz.

 */

public class Transaction01 {
    public static void main(String[] args) throws SQLException {
        //n02-ADIM:bağlantıyı oluşturma: db url,kullanıcı adı,password
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_dt",
                "techpro","password");


        //n03-ADIM:Statement oluşturma:SQL ifadelerini veritabanına
        //iletir ve çalıştırır
        Statement st =connection.createStatement();

        st.execute("CREATE TABLE IF NOT EXISTS hesaplar (hesap_no INT UNIQUE, isim VARCHAR(50), bakiye REAL)");

        String sql1 = "INSERT INTO hesaplar VALUES (?,?,?) ";

        PreparedStatement prst1 = connection.prepareStatement(sql1);
        prst1.setInt(1, 1234);
        prst1.setString(2,"Fred");
        prst1.setDouble(3,9000);
        prst1.executeUpdate();

        prst1.setInt(1, 5678);
        prst1.setString(2,"Barnie");
        prst1.setDouble(3,6000);
        prst1.executeUpdate();

        //TASK: hesap no:1234 ten hesap no:5678 e 1000$ para transferi olsun.
        String sql="update hesaplar set bakiye=bakiye+? where hesap_no=1234";
        PreparedStatement prst2=connection.prepareStatement(sql);

        try {


            //1.islem:gonderen heasabin bakiyesi azalacak

            prst2.setDouble(1, -1000);
            prst2.setInt(2, 1234);
            prst2.executeUpdate();

            //sistemde hata olustu kabu edelim
            if (true) {
                throw new RuntimeException();
            }

            //2.islem:alici hesabin bakiyesi artacak
            prst2.setDouble(1, 1000);
            prst2.setInt(2, 5678);
            prst2.executeUpdate();

            prst2.close();
        }catch (Exception e){
            System.out.println("Sistemde hata olustu");
            e.printStackTrace();
        }



        st.close();
        prst1.close();

    }
}
