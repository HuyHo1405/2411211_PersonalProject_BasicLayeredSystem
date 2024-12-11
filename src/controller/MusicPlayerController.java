package controller;

import data.PlaylistData;
import data.SongData;
import java.util.LinkedList;
import java.util.Queue;
import logic.MusicPlayerLogic;
import logic.PlaylistLogic;
import logic.SongLogic;
import model.Playlist;
import model.Song;

public class MusicPlayerController {

    private final Queue<Song> musicPlayerQueue = new LinkedList<>();

    public void play() {
        if (musicPlayerQueue.isEmpty()) {
            System.out.println("The playing queue is empty! Please add song to play!");
            return;
        }
        MusicPlayerLogic.play(musicPlayerQueue);
    }

    public void addSong(SongData data) {
        if (data == null) {
            return;
        }
        if (data.isEmpty()) {
            System.out.println("Song data is empty!");
            return;
        }
        Song addSong = SongLogic.findSong(data);
        musicPlayerQueue.add(addSong);
        System.out.println("Add [" + addSong + "] successfully!");
    }

    public void addPlaylist(PlaylistData data) {
        if (data == null) {
            return;
        }
        if (data.isEmpty()) {
            System.out.println("You don't have any playlist yet!");
            return;
        }
        Playlist addedPlaylist = PlaylistLogic.findPlaylist(data);
        musicPlayerQueue.addAll(addedPlaylist);
        System.out.println("Add playlist [" + addedPlaylist.getName() + "] successfully!");
    }

    public void clear() {
        musicPlayerQueue.clear();
        System.out.println("Playing queue is cleared!");
    }

    public void displayPlayingQueue() {
        if (musicPlayerQueue.isEmpty()) {
            System.out.println("The playing queue is empty!");
            return;
        }
        System.out.println("- Playing queue - - - - - - - - - - - - - - - - - -");
        int i = 1;
        for (Song song : musicPlayerQueue) {
            System.out.println(String.format(" %02d. %s", i++, song));
        }
    }
}
