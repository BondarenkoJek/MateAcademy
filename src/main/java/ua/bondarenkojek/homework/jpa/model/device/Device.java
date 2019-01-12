package ua.bondarenkojek.homework.jpa.model.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.accessory.Accessory;
import ua.bondarenkojek.homework.jpa.model.test.Test;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "device")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "device_id")
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "brand")
    private String brand;
    @OneToMany(mappedBy = "device", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Accessory> accessories;

    public void addAccessory(Accessory accessory) {
        if (accessories == null) {
            accessories = new ArrayList<>();
        }
        accessory.setDevice(this);
        accessories.add(accessory);
    }

    public void doTest(Test test, Patient patient) {
        test.doTest(patient);
        test.setDateOfCreate(LocalDate.now());
    }
}
