package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
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
    private NBA_Conference conference;

    @OneToMany (mappedBy = "division")
    private Set<NBA_Team> teams = new HashSet<>();

    public NBA_Division(String divisionName, NBA_Conference conference) {
        this.divisionName = divisionName;
        this.conference = conference;
    }

    public void addTeam(NBA_Team team) {
        this.teams.add(team);
        if (team != null) {
            team.setDivision(this);
        }
    }
}
