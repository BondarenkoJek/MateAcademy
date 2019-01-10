package ua.bondarenkojek.homework.jpa.model.accessory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "accessory")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accessory_id")
    private Long id;
}
