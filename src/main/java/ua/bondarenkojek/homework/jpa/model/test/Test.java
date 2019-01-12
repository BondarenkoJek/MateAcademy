package ua.bondarenkojek.homework.jpa.model.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.bondarenkojek.homework.jpa.model.Patient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "test")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_id")
    private Long id;
    @Column(name = "date_of_create")
    private LocalDate dateOfCreate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient owner;

    public Test doTest(Patient patient) {
        setOwner(patient);
        patient.addTest(this);
        return this;
    }

    public abstract Double getResult();

    public static Test getTest(TestType testType) {
        switch (testType) {
            case SKIN: return new SkinTest();
            case BLOOD: return new BloodTest();
        }
        return null;
    }

    public static enum TestType {
        BLOOD,
        SKIN
    }
}
