
package model;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

public class Playlist extends LinkedList<Song> implements Serializable{
    //extra field
    private String name;

    public Playlist() {
    }
    
    public Playlist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    //extra methods
    ///add a song
    public void addASong(String name){
        
    }
    
    ///suffle the list
    public void shuffle(){
        //special case
        if(this.isEmpty()){
            return;
        }
        
        //normal case
        Collections.shuffle(this);
    }
    
    ///sort the list
    public void sort(){
        //special case
        if(this.isEmpty()){
            return;
        }
        
        //normal case
        Collections.sort(this);
    }
    
    ///
    public void displaySongs(){
        for (int i = 1; i <= size(); i++) {
            System.out.println(String.format(
                    "%02d. %s", i, this.get(i - 1)
            ));
        }
    }
    
    public Song getSongByOrdinal(int ordinal){
        return this.get(ordinal - 1);
    }
   
    
    
}
