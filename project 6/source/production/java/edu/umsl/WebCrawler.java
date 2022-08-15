//*******************************************************************************************************
//Course     : CMP-2261-001
//Author     : Silvia Matthews
//Professor  : Steve Riegerix
//Project 6  : Traverse 1000 wikipedia links, and count words that you see a specific word.
//Note       : Only count words, not HTML elements/attributes.
//Date       : 04/18/2022
//*******************************************************************************************************
package edu.umsl;

public class WebCrawler {
    public static void main (String[] args) {
        String startUrl = "https://en.wikipedia.org/wiki/The_Legend_of_Zelda";
        Crawler cra = new Crawler();
        cra.getUrls(startUrl,0);
        System.out.println("*****************Printing all titles*****************");
        //Print titles
        cra.PrintTitles();
        System.out.println("*****************Printing all words*****************");
        //Print words
        cra.PrintWords();
    }
}



