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
public class NBA_Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String position;
    @ManyToOne
    private NBA_Team team;

    public NBA_Player(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

}
