package ua.bondarenkojek.homework.jpa.model.accessory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.bondarenkojek.homework.jpa.model.device.Device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(exclude = "device")
@ToString(exclude = "device")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accessory_id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "device_id")
    private Device device;
}
