package questionbox;

/*
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This class manages the Online Search. In the event that the quey being search does not exit in the database
 * this class searches from a list of recommended sites.
 *
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.com.json.JSONArray;   // JSON library from http://www.json.org/java/
import org.com.json.JSONObject;
import qbox.model.*;
import java.util.*;



/**
 *
 * @author Moses Mugisha
 */
public class OnlineSearch {


     // Yahoo API key
     private final String API_KEY = "N8J0mNjV34H0dLOBpSzcdXXK1jnwnYlND3AsBbVgHs_NEtEMThKp1D25qbQWQA8-";

     /**
     * This function creates the queries for the yahoo API while only using an array of recommended sites
     * to search from
     * @param query
     * @return
     */
     public String YahooQuery(String query) {
     String result="";
        try{
             ArrayList<RecommendedSite> recsites = RecommendedSite.getRecommendedSites();

             for (RecommendedSite site : recsites)
             {      //for each recommended site the query is combined and searched view makeQuery function.
                    result = result + "<br/><hr width=100% />" +makeQuery(query + " site:"+site.getUrl());
             }
            
        }catch(Exception e)
        {
            result +=e.getMessage();
        }

        return result;
     }

     /**
     * This functions is used to execute queries for recommended sites based on JSON format.
     * @param query
     * @return
     */

     public String makeQuery(String query) {
          String answer="";

          answer = answer + " <br><font color=\"black\" size=14pt >  Querying for " + query;

          try
          {
               // Convert spaces to +, etc. to make a valid URL
               query = URLEncoder.encode(query, "UTF-8");

               // Give me back 5 results in JSON format
               URL url = new URL("http://boss.yahooapis.com/ysearch/web/v1/" + query +
                 "?appid=" + API_KEY + "&count=5&format=json");
               URLConnection connection = url.openConnection();

               //Read the result of the query one line at a time into a string buffer.
               String line;
               StringBuilder builderResult = new StringBuilder();
               BufferedReader reader = new BufferedReader( new InputStreamReader(connection.getInputStream()));
               while((line = reader.readLine()) != null) {
                builderResult.append(line);
               }

               String response = builderResult.toString();

               //Convert results into a json object to get more attributes about the results and
               JSONObject json = new JSONObject(response);
               answer=answer+"\n <b>Results:</b>";
               answer=answer+"<br/>Total results = " + json.getJSONObject("ysearchresponse").getString("deephits") +"\n";

               JSONArray ja = json.getJSONObject("ysearchresponse").getJSONArray("resultset_web");

               answer = answer+"<br/>\n Web Results:</font>";
               for (int i = 0; i < ja.length(); i++) {
                 answer=answer+"<br>"+ (i+1) + "  . ";
                 JSONObject j = ja.getJSONObject(i);
                 answer=answer+j.getString("title");
                 answer=answer+"<a href="+j.getString("url")+">"+j.getString("url")+ "</a>";
                }

          }
          catch (Exception e)
          {
               answer = answer+"The network is down...";
               e.printStackTrace();
          }
          return answer;
     }

}






