public abstract class Calisanlar extends Person{
    //Calisanlar Class'ında nesne uretilmeyecegi icin, abstract.
    private String depertmant;
   //private int salary;
    private int pm_WorkingDay;
    private int pm_WorkingTime;

    protected abstract int Salary();

    public String getDepertmant() {
        return depertmant;
    }

    public void setDepertmant(String depertmant) {
        this.depertmant = depertmant;
    }

    public int getPm_WorkingDay() {
        return pm_WorkingDay;
    }

    public void setPm_WorkingDay(int pm_WorkingDay) {
        this.pm_WorkingDay = pm_WorkingDay;
    }

    public int getPm_WorkingTime() {
        return pm_WorkingTime;
    }

    public void setPm_WorkingTime(int pm_WorkingTime) {
        this.pm_WorkingTime = pm_WorkingTime;
    }

}
