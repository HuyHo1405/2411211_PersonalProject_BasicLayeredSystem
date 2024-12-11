
package model;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Song implements Comparable<Song>, Serializable{
    private final String title;
    private final String author;
    private final int duration;//assume this is music

    public Song(String title, String author, int duration) {
        this.title = title;
        this.author = author;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", title, author);
    }
    
    public void play(){
        System.out.println("Now playing [" + this + "]...");
        
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (Exception e) {
            System.out.println("The memory is corrupted!");
        }
        
        System.out.println("Song ended. Thank you for listening!");
    }

    @Override
    public int compareTo(Song other) {
        return this.title.compareTo(other.title);
    }
    
    
    
}
