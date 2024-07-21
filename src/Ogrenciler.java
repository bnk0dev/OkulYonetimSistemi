import java.sql.SQLException;
import java.util.Scanner;

public class Ogrenciler extends Person {
    static Scanner scan = new Scanner(System.in);

    //Secilen OgrenciMenusunun gosterildigi method
    public static void ogrenciMenu() throws InterruptedException, SQLException {
        String secim;
        do {
            Thread.sleep(1000);
            System.out.println("---------- OGRENCI MENU -------\n" +
                    "\t 1- Ogrencileri Goruntule\n" +
                    "\t 2- Ogrenci Kaydi Yap (SUDO GEREKLI)\n" +
                    "\t 3- TC No ile Ogrenci Kaydi Sil (SUDO GEREKLI)\n" +
                    "\t 4- Ust Menu'ye Don\n" +
                    "\t Q- CIKIS YAP");

            System.out.print("Lutfen Yapmak Istediginiz Islemi Seciniz: ");
            secim = scan.nextLine();
            switch (secim) {
                case "1":
                    DbHelper.ogrenciListele();
                    break;

                case "2":
                    System.out.print("DEVAM ETMEK ICIN SIFRE GIRINIZ: ");
                    for(int i = 3; i >= 0; i--) {
                        int sifre = scan.nextInt();
                        if(sifre == password){
                            DbHelper.OgrenciEkle();
                            Depo.anaMenu();
                        }else{System.out.println("HATALI GIRIS KALAN HAK:" + i);}

                    }
                    break;

                case "3":System.out.print("DEVAM ETMEK ICIN SIFRE GIRINIZ: ");
                    for(int i = 3; i >= 0; i--) {
                        int sifre = scan.nextInt();
                        if(sifre == password){
                            DbHelper.ogrenciSil();
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
}
