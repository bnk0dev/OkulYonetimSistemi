import java.sql.*;
import java.util.Scanner;

public class DbHelper {

    private String userName = ""; //DB'nin UserName'ini Girmelisin.
    private String password = "";  //DB'nin Sifresini Girmelisin.
    private String dbUrl ="";  //DB'nin Yolunu Belirtmelisin.'
    static Scanner scan = new Scanner(System.in);
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,userName,password);
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error Code: " + exception.getErrorCode());
    }

    /* OGRETMEN ICIN DB KODLARI */
    public static void ogretmenEkle() throws SQLException {
            //Scanner scan = new Scanner(System.in);
            Connection conn = null;
            DbHelper helper = new DbHelper();

            System.out.print("TC No: ");
            String tcno = scan.next();

            scan.nextLine();

            System.out.print("İsim: ");
            String isim = scan.nextLine().toLowerCase();

            System.out.print("Soyisim: ");
            String soyisim = scan.nextLine().toLowerCase();

            System.out.print("Cinsiyet (Erkek, Kadın, Diğer): ");
            String cinsiyet = scan.next();
            cinsiyet = cinsiyet.toUpperCase();

            scan.nextLine();

            System.out.print("Departman: ");
            String Departman = scan.nextLine().toLowerCase();

            System.out.print("Maaş: ");

            double maas = scan.nextDouble();

            System.out.print("Doğum Tarihi (YYYY-MM-DD): ");
            String dogumTarihi = scan.next();

            String sql = "INSERT INTO ogretmen (TCno, Isim, Soyisim, Cinsiyet, Departman, Maas, dogum_tarihi) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Connection connection = helper.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, tcno);
                statement.setString(2, isim);
                statement.setString(3, soyisim);
                statement.setString(4, cinsiyet);
                statement.setString(5, Departman);
                statement.setDouble(6, maas);
                statement.setString(7, dogumTarihi);

                statement.executeUpdate();
                System.out.println("Kayıt Eklendi... ");
            } catch (SQLException exception) {
                helper.showErrorMessage(exception);
            }
        }

    public static void ogretmenListele() {
        DbHelper helper = new DbHelper();
        String sql = "SELECT * FROM ogretmen";

        try (Connection connection = helper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String TCno = resultSet.getString("TCno");
                String Isim = resultSet.getString("Isim");
                String Soyisim = resultSet.getString("Soyisim");
                String Cinsiyet = resultSet.getString("Cinsiyet");
                String Departman = resultSet.getString("Departman");
                double Maas = resultSet.getDouble("Maas");
                String dogum_tarihi = resultSet.getString("dogum_tarihi");

                System.out.println("TC No: " + TCno + ", İsim: " + Isim + ", Soyisim: " + Soyisim +
                        ", Cinsiyet: " + Cinsiyet + ", Departman: " + Departman +
                        ", Maaş: " + Maas + ", Doğum Tarihi: " + dogum_tarihi);
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public static void ogretmenSil() throws SQLException {
        Scanner scan = new Scanner(System.in);
        DbHelper helper = new DbHelper();

        System.out.print("Silinecek Ogretmen'in TC No: ");
        String tcno = scan.next();

        String sql = "DELETE FROM ogretmen WHERE TCno = ?";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tcno);

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Kayıt Silindi...");
            } else {
                System.out.println("Kayıt Bulunamadı...");
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    /* OGRENCİ İCİN DB KODLARI */
    public static void OgrenciEkle() throws SQLException {
        Scanner scan = new Scanner(System.in);
        Connection conn = null;
        DbHelper helper = new DbHelper();

        System.out.print("TC No: ");
        String tcno = scan.next();

        scan.nextLine();

        System.out.print("İsim: ");
        String isim = scan.nextLine().toLowerCase();

        System.out.print("Soyisim: ");
        String soyisim = scan.nextLine().toLowerCase();

        System.out.print("Cinsiyet (Erkek, Kadın, Diğer): ");
        String cinsiyet = scan.next();
        cinsiyet = cinsiyet.toUpperCase();

        scan.nextLine();

        System.out.print("Bolum: ");
        String Bolum = scan.nextLine().toLowerCase();

        System.out.print("Doğum Tarihi (YYYY-MM-DD): ");
        String dogum_tarihi = scan.next();

        String sql = "INSERT INTO ogrenci (TCno, Isim, Soyisim, Cinsiyet, Bolum, dogum_tarihi) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tcno);
            statement.setString(2, isim);
            statement.setString(3, soyisim);
            statement.setString(4, cinsiyet);
            statement.setString(5, Bolum);
            statement.setString(6, dogum_tarihi);

            statement.executeUpdate();
            System.out.println("Kayıt Eklendi... ");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public static void ogrenciListele() {
        DbHelper helper = new DbHelper();
        String sql = "SELECT * FROM ogrenci";

        try (Connection connection = helper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String TCno = resultSet.getString("TCno");
                String Isim = resultSet.getString("Isim");
                String Soyisim = resultSet.getString("Soyisim");
                String Cinsiyet = resultSet.getString("Cinsiyet");
                String Bolum = resultSet.getString("Bolum");
                String dogum_tarihi = resultSet.getString("dogum_tarihi");

                System.out.println("TC No: " + TCno + ", İsim: " + Isim + ", Soyisim: " + Soyisim +
                        ", Cinsiyet: " + Cinsiyet + ", Bolum: " + Bolum + ", Doğum Tarihi: " + dogum_tarihi);
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public static void ogrenciSil() throws SQLException {
       // Scanner scan = new Scanner(System.in);
        DbHelper helper = new DbHelper();

        System.out.print("Silinecek Ogrenci'nin TC No: ");
        String tcno = scan.next();

        String sql = "DELETE FROM ogrenci WHERE TCno = ?";

        try (Connection connection = helper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tcno);

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Kayıt Silindi...");
            }else {
                System.out.println("Kayıt Bulunamadı...");
            }
        }catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }
}