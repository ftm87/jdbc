package day01_databasetesting;

import java.util.Scanner;

public class C01_firstTest {

 /*
    Software Testing    : Expected Data ile Actual Data nin karsilastirilmasindan ibarettir
    Expected Data       : Gereksinimlere göre beklenen data
    Actual Data         : Uygulamadan gelen asıl data
     */

    public static void main(String[] args) {

        Scanner input =new Scanner(System.in);//kalipta ne varsa objede o vardir


        String expectedData ="selenium";
        String actualData ="jdbc";// eger burasida selenium olsa idi sonuc passed olacakti

        if(expectedData.equals(actualData)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

    }




}
