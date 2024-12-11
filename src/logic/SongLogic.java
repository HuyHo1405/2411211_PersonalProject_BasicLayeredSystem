package logic;

import data.SongData;
import model.Playlist;
import model.Song;
import util.InputUtils;

public class SongLogic {

    //class này sẽ xử lý các logic liên quan đến song data(pool)
    public static Song findSong(SongData data) {
        String title = InputUtils.inputNonEmptyString("song title");
        Song search = data.getOrDefault(title, null);
        if (search == null) {
            System.out.println("Song doesn's exist!");
            System.out.println("Do you want to upload this song?");
            System.out.println(" 1. Yes");
            System.out.println(" 2. No");
            int choice = InputUtils.inputInteger("your choice", 1, 2);
            if (choice == 1) {
                search = addNewSong(data);
            }
        }
        return search;
    }

    private static Song addNewSong(SongData data) {
        String title = InputUtils.inputNonEmptyString("song title");
        String author = InputUtils.inputNonEmptyString("author's name");
        int duration = InputUtils.inputPositiveInteger("song duration");
        Song newSong = new Song(title, author, duration);
        data.put(title, newSong);
        return newSong;
    }
}
