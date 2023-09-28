package APIReader;

import dto.TeamDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamAPIReader {
    static Gson gson =  new GsonBuilder().setPrettyPrinting().create();

    public List<TeamDTO> callToAPI() {
        List<TeamDTO> teamList = new ArrayList<>();
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
            TeamDTO teamDTO = gson.fromJson(res, TeamDTO.class);
            teamList = teamDTO.generateDTO();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return teamList;

    }

}
