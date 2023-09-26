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
public class NBA_Location {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String location;
    @OneToMany(mappedBy = "location")
    private Set<NBA_Team> teams = new HashSet<>();
    public NBA_Location(String location) {
        this.location = location;
    }
    public void addTeam(NBA_Team team) {
        this.teams.add(team);
        if (team != null) {
            team.setLocation(this);
        }
    }
}
