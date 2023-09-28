package APIReader;

import dto.PlayerDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerAPIReader {

    static Gson gson =  new GsonBuilder().setPrettyPrinting().create();
    public List<PlayerDTO> callToAPI() {
        List<PlayerDTO> playerList = new ArrayList<>();
        String url = "";
        for(int i = 1; i <= 50 ; i++) {
            url = "https://www.balldontlie.io/api/v1/players?page=" + i;
            System.out.println(url);

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            PlayerDTO playerDTO = gson.fromJson(res, PlayerDTO.class);
            playerList = playerDTO.generateDTO();

        }catch (IOException e) {
            throw new RuntimeException(e);

        }
        }
        return playerList;
    }

}
