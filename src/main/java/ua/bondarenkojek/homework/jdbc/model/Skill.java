package ua.bondarenkojek.homework.jdbc.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Skill {
    private long id;
    private TypeOfSkill typeOfSkill;
    private SkillLevel skillLevel;

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
