package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class NBA_Division {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String divisionName;
    private String conference;

    @OneToMany (mappedBy = "division")
    private Set<NBA_Team> teams = new HashSet<>();

    public NBA_Division(String divisionName) {
        this.divisionName = divisionName;

    }

    public void addTeam(NBA_Team team) {
        this.teams.add(team);
        if (team != null) {
            team.setDivision(this);
        }
    }

}
