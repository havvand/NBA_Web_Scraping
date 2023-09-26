package APIReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class TeamAPIReader {
    static Gson gson =  new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        String url = "https://www.balldontlie.io/api/v1/teams";
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();

        Response response;
        try {
            response = client.newCall(request).execute();
            String res = response.body().string();
            TeamDTO nflDTO = gson.fromJson(res, TeamDTO.class);
            TeamDTO team1 = nflDTO.generateDTO("kings");
            System.out.println(team1.full_name + " " + team1.id);
        }catch (IOException e) {
            throw new RuntimeException(e);

        }

    }

    @NoArgsConstructor
    @ToString
    private static class TeamDTO {
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

}
