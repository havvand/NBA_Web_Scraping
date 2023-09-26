package APIReader;

import DTO.TeamDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TeamAPIReader {
    static Gson gson =  new GsonBuilder().setPrettyPrinting().create();

    public void callToAPI() {
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
            System.out.println(team1.getFull_name() + " " + team1.getId());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
