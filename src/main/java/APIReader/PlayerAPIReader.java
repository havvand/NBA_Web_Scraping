package APIReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import lombok.NoArgsConstructor;
import lombok.ToString;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http2.Hpack;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PlayerAPIReader {

    static Gson gson =  new GsonBuilder().setPrettyPrinting().create();
    public void callToAPI() {
        int pageNumber = 1;
        String url = "";
        for(int i = 1; i <= 50 ; i++) {
            url = (i == pageNumber) ? "https://www.balldontlie.io/api/v1/players?page=1" : "https://www.balldontlie.io/api/v1/players?page=" + i;

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            System.out.println("dsaldhaldnsakldas "+res);
            PlayerDTO nflDTO = gson.fromJson(res, PlayerDTO.class);
            nflDTO.generateDTO();
        }catch (IOException e) {
            throw new RuntimeException(e);

        }
        }
    }



    @NoArgsConstructor
    @ToString
    private static class PlayerDTO {
        private String id;
        private String first_name;
        private String last_name;
        private String position;
        private String height_feet;
        private String height_inches;
        private String weight_pounds;
        private Object team;
        List<PlayerDTO> data;

        public List<PlayerDTO> generateDTO(){
            List<PlayerDTO> foundPlayers = new ArrayList<>();
            for (PlayerDTO s : data) {
                System.out.println(s);
                foundPlayers.add(s);
            }

            return foundPlayers;

        }
    }

    private static class nextPage {
        private String total_pages;
        private String current_pages;
        private String next_page;
        private String per_page;
        private String total_count;
    }

}
