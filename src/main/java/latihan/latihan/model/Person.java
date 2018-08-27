package latihan.latihan.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Reja Nur Rochmat rezanurrochmat3@gmail.com
 * Person Model
 **/


@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id_person")
    private String idPerson;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_age")
    private String personAge;

    @Column(name = "person_address")
    private String personAddress;

    @Column(name = "person_phone_number")
    private String personPhoneNumber;

    @Column(name = "person_birthday")
    private Date personBirthday;


    /**
     * GETTER SETTER PERSON
     **/
    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAge() {
        return personAge;
    }

    public void setPersonAge(String personAge) {
        this.personAge = personAge;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    public void setPersonPhoneNumber(String personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }

    public Date getPersonBirthday() {
        return personBirthday;
    }

    public void setPersonBirthday(Date personBirthday) {
        this.personBirthday = personBirthday;
    }

    /**
     * BUILDER CLASS
     **/

    public static class Builder {

        private String personId;
        private String personName;
        private String personAge;
        private String personAddress;
        private String personPhoneNumber;
        private Date personBirthday;

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder personId(String personId) {
            this.personId = personId;
            return this;
        }

        public Builder personName(String personName) {
            this.personName = personName;
            return this;
        }

        public Builder personAge(String personAge) {
            this.personAge = personAge;
            return this;
        }

        public Builder personAddress(String personAddress) {
            this.personAddress = personAddress;
            return this;
        }

        public Builder personPhoneNumber(String personPhoneNumber) {
            this.personPhoneNumber = personPhoneNumber;
            return this;
        }

        public Builder personBirthday(Date personBirthday) {
            this.personBirthday = personBirthday;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.setIdPerson(personId);
            person.setPersonName(personName);
            person.setPersonAge(personAge);
            person.setPersonAddress(personAddress);
            person.setPersonPhoneNumber(personPhoneNumber);
            person.setPersonBirthday(personBirthday);

            return person;
        }
    }
}
