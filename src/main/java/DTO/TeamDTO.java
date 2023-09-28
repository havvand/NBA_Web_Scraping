package dto;

import APIReader.TeamAPIReader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@ToString
@Getter
public class TeamDTO {
    private String id;
    private String city;
    private String abbreviation;
    private String division;

    private String conference;
    private String full_name;
    private String name;

    List<TeamDTO> data;

    public List<TeamDTO> generateDTO(){
        List<TeamDTO> foundTeams = new ArrayList<>();
        for (TeamDTO s : data) {
            foundTeams.add(s);
        }
        return foundTeams;
    }
}
