package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class NBA_Arena {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String arenaName;
    private int capacity;
    @OneToMany(mappedBy = "arena")
    private Set<NBA_Team> teams = new HashSet<>();

    public NBA_Arena(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.capacity = capacity;
    }

    public void addTeam(NBA_Team team) {
        this.teams.add(team);
        if (team != null) {
            team.setArena(this);
        }
    }
}
