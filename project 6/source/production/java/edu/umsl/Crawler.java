package edu.umsl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.HashSet;

public class Crawler {
    private static final int MAX_LINKS = 1000;
    private HashSet<String>  titles = new HashSet<>();               //Hold titles for each link
    private HashSet<String> urlTrack = new HashSet<>();              //Hold links
    private HashMap<String, Integer> mapTrack = new HashMap<>();     //Hold the words and count

    //Crawler links
    public void getUrls (String url, int depth) {
        if (!urlTrack.contains(url)  && (titles.size() < MAX_LINKS) ) {
            try {
                Document document = Jsoup.connect(url).get();
                String pageTitles = document.title();
                 titles.add(pageTitles);

                //Call function to count the words
                String text = document.body().text();
                CountWords(text);

                Elements nextPage = document.select("a[href^=\"/wiki/\"]");
                depth++;
                for (Element page : nextPage) {
                    String absUrl = page.attr("abs:href");
                 //Strip out those duplicate URLs
                    if (absUrl.startsWith("https://en.wikipedia.org/wiki/") &&
                          !absUrl.matches(".*\\.(bmp|gif|jpg|png|js|css|svg)$") &&
                              !absUrl.matches(".*#.*$") && (document.title().contains(pageTitles)))  {
                        if ( urlTrack.add(url) ) {
                            Thread.sleep(500);
                            //Check if my code is running
                          //  System.out.println(url);
                        }
                        getUrls(absUrl, depth);
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Count the words (page 833 in Chapter 21)
    private void CountWords(String text) {
        String[] keyWords = text.split("[\\s+\\d+\\p{P}]"); //Whitespace, number and punctuation
        for (String i: keyWords) {
            if (mapTrack.containsKey(i)) {
                int value = mapTrack.get(i);
                value ++;
                mapTrack.remove(i);
                mapTrack.put(i,value);
            } else {
                mapTrack.put(i,1);
            }
        }
    }

    //Method to print all titles
    public void PrintTitles() {
        for (String s : titles) {
            System.out.println(s);
        }
    }

    //Method to print words and the number of count
    public void PrintWords() {
        for (String k : mapTrack.keySet()) {
            System.out.println(k + ": " + mapTrack.get(k));
        }
    }

}






