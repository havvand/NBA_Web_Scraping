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
public class NBA_Arena {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String arenaName;
    private int capacity;
    @ManyToOne
    private NBA_Team team;

    public NBA_Arena(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.capacity = capacity;
    }

}
