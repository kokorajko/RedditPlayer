/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redditplayer.gui.components;

import gui.ScrollPanel;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gwozdziu
 */
public class SearchTextField {
    
    ScrollPanel scrollPanel;
    

    public void getSite(String tag) throws IOException {
        ArrayList<String> word = new ArrayList();
        scrollPanel = new ScrollPanel();
        word = siteWords(setUrl(tag));
        getLinks(word);
    }
    
    private URL setUrl(String tag) throws IOException {
        String urlText = "http://www.reddit.com/r/" + tag;
        return new URL(urlText);
    }

    private ArrayList siteWords(URL url) throws IOException {
        ArrayList<String> word = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            word.addAll(Arrays.asList(tokens));
        }
        in.close();
        return new ArrayList(word);
    }

    private void getLinks(ArrayList word) {
        ArrayList<String> soundLinks = new ArrayList();
        for (int i = 0; i < word.size() - 1; i++) {
            if (word.get(i).toString().equalsIgnoreCase("class=\"domain\">(<a")) {
                int j = i;
                while (!word.get(j).toString().contains("href=\"")) {
                    j--;
                }
                soundLinks.add(word.get(j).toString());
            }
        }
        clearLinks(soundLinks);
    }

 


    private void clearLinks(ArrayList word) {
        for (int i = 0; i < word.size(); i++) {
            word.set(i, word.get(i).toString().substring(6, word.get(i).toString().length() - 1)).toString();
            if (word.get(i).toString().contains("/r/")) {
                word.remove(i);
                i--;
            }
        }
        showLinks(word);
    }

    private void showLinks(ArrayList word) {
        for (Object word1 : word) {
            System.out.println(word1);
        }
    }
}
