package DTO;

import APIReader.TeamAPIReader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@ToString
@Getter
public class TeamDTO {
    private String id;
    private String city;
    private String abbreviation;
    private String division;
    private String full_name;
    private String name;

    List<TeamDTO> data;

    public TeamDTO generateDTO(String name){
        for (TeamDTO s : data) {
            if(s.full_name.toLowerCase().contains(name)) {
                return s;
            }
        }
        return null;
    }
}
