package org.contract.api.model;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Maxim Suhochev
 */
public class Client {

    private static Client.Builder builder;
    /** id client*/
    private int id;
    /** surname, name and patronymic client*/
    private String SNP;
    /**
     * birthdate client
     */
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
    private Client(int id, String SNP, LocalDate birthDate, String sex, int serPas, int numPas) {
        this.id = id;
        this.SNP = SNP;
        //getAge(birthDate);
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

    /**
     * This method get id client
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * This method set id client
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method get id SNP
     * @return SNP
     */
    public String getSNP() {
        return SNP;
    }

    /**
     * This method set SNP
     */
    public void setSNP(String SNP) {
        this.SNP = SNP;
    }

    /**
     * This method get birth date client
     * @return birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * This method set birth date client
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        getAge(birthDate);
    }

    /**
     * This method get sex client
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method set sex client
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * This method get series passport client
     * @return serPas
     */
    public int getSerPas() {
        return serPas;
    }

    /**
     * This method set series passport client
     */
    public void setSerPas(int serPas) {
        this.serPas = serPas;
    }

    /**
     * This method get number passport client
     * @return numPas
     */
    public int getNumPas() {
        return numPas;
    }

    /**
     * This method set number passport client
     */
    public void setNumPas(int numPas) {
        this.numPas = numPas;
    }

    /**
     * This method get age client
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * This method set age client
     */
    public void setAge(int age) {
        this.age = age;
    }

    public static class Builder {
        private int id;
        private String SNP;
        private LocalDate birthDate;
        private String sex;
        private int serPas;
        private int numPas;

        public Client.Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Client.Builder setSNP(String SNP) {
            this.SNP = SNP;
            return this;
        }

        public Client.Builder setBirthDate(LocalDate date) {
            this.birthDate = date;

            return this;
        }

        public Client.Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Client.Builder setNumPas(int numPas) {
            this.numPas = numPas;
            return this;
        }

        public Client.Builder setSerPas(int serPas) {
            this.serPas = serPas;
            return this;
        }

        public Client build() {
            Client.setBuilder(this);
            return new Client(id, SNP, birthDate, sex, serPas, numPas);
        }
    }

    public static Client.Builder builder() {
        return new Client.Builder();
    }

    private static void setBuilder(Client.Builder builder) {
        Client.builder = builder;
    }

    public Client.Builder toBuilder() {
        return builder;
    }
}
