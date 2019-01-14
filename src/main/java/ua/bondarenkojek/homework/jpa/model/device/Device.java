package ua.bondarenkojek.homework.jpa.model.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
    private Set<Accessory> accessories;

    @OneToMany(mappedBy = "device", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Test> tests;

    public void addAccessory(Accessory accessory) {
        if (accessories == null) {
            accessories = new HashSet<>();
        }
        accessory.setDevice(this);
        accessories.add(accessory);
    }

    public void addTest(Test test) {
        if (tests == null) {
            tests = new HashSet<>();
        }
        test.setDevice(this);
        tests.add(test);
    }
}
