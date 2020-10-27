package contacts;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Maxim Suhochev
 */
public class Client {

    /** id client*/
    private int id;
    /** surname, name and patronymic client*/
    private String SNP;
    /** birthdate client*/
    private LocalDate birthDate;
    /** sex client*/
    private String sex;
    /** passport series client*/
    private int serPas;
    /** passport number client*/
    private int numPas;
    /** age client*/
    private int age;

    /**
     * Client constructor
     * @param id
     * @param SNP
     * @param birthDate
     * @param sex
     * @param serPas
     * @param numPas
     */
    public Client(int id, String SNP, LocalDate birthDate, String sex, int serPas, int numPas) {
        this.id = id;
        this.SNP = SNP;
        getAge(birthDate);
        this.sex = sex;
        this.serPas = serPas;
        this.numPas = numPas;

    }

    /**
     * Age considered here
     * @param birthDate
     * @return age client
     */
    public int getAge(LocalDate birthDate) {
        return age = Period.between(birthDate, LocalDate.now()).getYears();
    }


    @Override
    public String toString() {
        return "(" +
                "id=" + id +
                ", SNP='" + SNP + '\'' +
                ", sex='" + sex + '\'' +
                ", serPas=" + serPas +
                ", numPas=" + numPas +
                ", age=" + age +
                ")\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSNP() {
        return SNP;
    }

    public void setSNP(String SNP) {
        this.SNP = SNP;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSerPas() {
        return serPas;
    }

    public void setSerPas(int serPas) {
        this.serPas = serPas;
    }

    public int getNumPas() {
        return numPas;
    }

    public void setNumPas(int numPas) {
        this.numPas = numPas;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
