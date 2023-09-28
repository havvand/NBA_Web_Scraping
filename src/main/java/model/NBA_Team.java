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
public class NBA_Team {
    @Id
    private int id;
    private String name;
    private String abbreviation;
    @ManyToOne
    private NBA_Division division;
    @ManyToOne
    private NBA_Arena arena;
    @ManyToOne
    private NBA_Location location;

    @OneToMany(mappedBy = "team")
    private Set<NBA_Player> players = new HashSet<>();

    public NBA_Team(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public void addPlayer(NBA_Player player) {
        this.players.add(player);
        if (player != null) {
            player.setTeam(this);
        }
    }

}
