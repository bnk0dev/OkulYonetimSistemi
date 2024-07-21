import java.sql.*;
import java.util.Scanner;

public class Ogretmen extends Calisanlar{
static Scanner scan = new Scanner(System.in);

    //secilen OgretmenMenu'sunun gosterildigi method
    public static void ogretmenMenu() throws InterruptedException, SQLException {
       String secim;
        do {
            Thread.sleep(1000);
            System.out.println("---------- OGRETMEN MENU -------\n" +
                    "\t 1- Ogretmenleri Goruntule\n" +
                    "\t 2- Ogretmen Girisi Yap (SUDO GEREKLI)\n" +
                    "\t 3- TC No ile Ogretmen Cikisi Yap (SUDO GEREKLI)\n" +
                    "\t 4- Ust Menu'ye Don\n" +
                    "\t Q- CIKIS YAP");

            System.out.print("Lutfen Yapmak Istediginiz Islemi Seciniz: ");
            secim = scan.nextLine();
            switch (secim) {
                case "1":
                    DbHelper.ogretmenListele();

                    break;

                case "2":
                    System.out.print("DEVAM ETMEK ICIN SIFRE GIRINIZ: ");
                    for(int i = 3; i >= 0; i--) {
                        int sifre = scan.nextInt();
                        if(sifre == password){
                            DbHelper.ogretmenEkle();
                        }else{System.out.println("HATALI GIRIS KALAN HAK:" + i);}

                    }
                   // scan.nextLine();
                    break;

                case "3":System.out.print("DEVAM ETMEK ICIN SIFRE GIRINIZ: ");
                    for(int i = 3; i >= 0; i--) {
                        int sifre = scan.nextInt();
                        if(sifre == password){
                            DbHelper.ogretmenSil();
                        }else{System.out.println("HATALI GIRIS KALAN HAK:" + i);}
                    }
                    break;
                case "4":
                    Depo.anaMenu();
                    break;
                case "q":
                case "Q":
                    Depo.ProjeDurdur();
                    break;
                default:
                    System.out.println("Lütfen Gecerli Bir Tuslama Yapiniz");
            }
        }while(!secim.equalsIgnoreCase("q"));
    }

    @Override
    protected int Salary() {
        return (getPm_WorkingDay() * getPm_WorkingTime()) * 1000;
    }

}

