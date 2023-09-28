package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class PlayerDTO {
    private String id;
    private String first_name;
    private String last_name;
    private String position;
    private String height_feet;
    private String height_inches;
    private String weight_pounds;
    private Object team;
    List<PlayerDTO> data = new ArrayList<>();

    public List<PlayerDTO> generateDTO(){
        List<PlayerDTO> foundPlayers = new ArrayList<>();
        for (PlayerDTO s : data) {
            if(s.position.matches("[\\w]")) {
                foundPlayers.add(s);
            }
        }
        return foundPlayers;


    }
}