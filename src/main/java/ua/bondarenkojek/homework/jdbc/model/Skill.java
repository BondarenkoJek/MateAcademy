package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode(exclude = "owner")
@ToString(exclude = "owner")
public class Skill {
    private long id;
    private TypeOfSkill typeOfSkill;
    private SkillLevel skillLevel;
    private Developer owner;

    public enum TypeOfSkill {
        JAVA,
        CPP,
        C_SHARP,
        JS
    }

    public enum SkillLevel {
        JUNIOR,
        MIDDLE,
        SENIOR
    }
}
