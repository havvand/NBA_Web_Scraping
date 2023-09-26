package APIReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScrapper {

    public static void main(String[] args) {

        String url = "https://en.wikipedia.org/wiki/National_Basketball_Association";
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("#mw-content-text > div.mw-parser-output > table:nth-child(80)");
            List<String> arena = new ArrayList<>();
            List<String> capacity = new ArrayList<>();
            List<Integer> joined = new ArrayList<>();



//            for (Element element : elements) {
//                System.out.println(element.text());
//            }
//
//            String table = elements.get(0).text();
//            String[] rows = table.split(" ");
//            for (String row : rows) {
//                System.out.println(row);
//            }
//
//            String table2 = elements.get(0).text();
//            String[] columns = table.split(" ");
//            for (String column : columns) {
//                System.out.println(column);
//            }

//          ////////////////////////////////////// Team ////////////////////////////////////////////////////////////////
            Elements el = document.select("#mw-content-text > div.mw-parser-output > table:nth-child(80) td:eq(0)");

            for (Element e : el){
                System.out.println(e.text());
            }
//
//
            ////////////////////////////////////// Location ////////////////////////////////////////////////////////////////

            Elements el2 = document.select("#mw-content-text > div.mw-parser-output > table:nth-child(80) td:eq(1)");
            for (Element e : el2){
                System.out.println(e.text());
            }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            ////////////////////////////////////// Arena ////////////////////////////////////////////////////////////////
            Elements el3 = document.select("#mw-content-text > div.mw-parser-output > table:nth-child(80) td:eq(2)");
            for (Element e : el3){
                System.out.println(e.text());
                arena.add(e.text());

            }

            ////////////////////////////////////// Capacity ////////////////////////////////////////////////////////////////
            Elements el4 = document.select("#mw-content-text > div.mw-parser-output > table:nth-child(80) td:eq(3)");
            for (Element e : el4){
                System.out.println(e.text());
                capacity.add(e.text());
            }

            ////////////////////////////////////// Joined ////////////////////////////////////////////////////////////////
            Elements el5 = document.select("#mw-content-text > div.mw-parser-output > table:nth-child(80) td:eq(6)");
            for (Element e : el5){
                System.out.println(e.text());
                joined.add(Integer.parseInt(e.text()));

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

