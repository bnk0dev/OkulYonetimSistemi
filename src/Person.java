public abstract class Person {

    /*
    * Olusturulacak nesnelerimizin(ogretmen, ogrenci)
    * ParentClass'i person Class'idir.
    * Butun bulunan nesneler bu class'tan inherit edilmektedir.*/

    private String name;
    private String lastName;
    private String gender;
    private int TCno;
    public static final int password = 1234;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTCno() {
        return TCno;
    }

    public void setTCno(int TCno) {
        this.TCno = TCno;
    }
}
