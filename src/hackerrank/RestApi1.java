package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.Context;
import jdk.nashorn.internal.runtime.ScriptObject;

public class RestApi1 {
    public static void main(String[] args) throws Exception {
        getMatches();
    }

    public static void getMatches() throws Exception {
        String path = "https://jsonmock.hackerrank.com/api/football_matches?year=2011&page=1";
        URL url = new URL(path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content.toString());
        final Global global = Context.getGlobal();
        JSONParser parse = new JSONParser(content.toString(), global, false);
        //parse.parse()
    }
}
