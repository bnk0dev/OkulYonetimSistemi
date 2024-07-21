import java.sql.SQLException;
import java.util.Scanner;

public class Depo {
    static Scanner scan = new Scanner(System.in);
    static String secim;
    //Projenin anamenusu ve durdurulmasinin saglandigi methodlar
    public static void anaMenu() throws InterruptedException, SQLException {

        do {
            Thread.sleep(1500);
            System.out.println("---------- KOC KOLEJI -------\n" +
                    "----------  ANA MENU  -------\n" +
                    "\t 1- Ogretmen Menu\n" +
                    "\t 2- Ogrenci Menu\n" +
                    "\t Q- CIKIS YAP");

            System.out.print("Lutfen Yapmak Istediginiz Islemi Seciniz: ");
            secim = scan.nextLine();
            switch (secim) {
                case "1":
                    Ogretmen.ogretmenMenu();
                    break;
                case "2":
                    Ogrenciler.ogrenciMenu();
                    break;
                case "3":
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



    public static void ProjeDurdur(){
        System.out.println("Sistemden Cikis Yapiliyor...");
    }


}