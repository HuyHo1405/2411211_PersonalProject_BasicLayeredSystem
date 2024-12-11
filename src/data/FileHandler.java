package data;

import controller.DataManager;
import java.io.*;

public class FileHandler {
    //với số lượng lớn song và playlist
    //người dùng có nhu cầu lưu lại để sau này xài
    //nhiệm vụ của class này là đảm các object lưu và xuất vào các file

    private static final String songFileName = "SongData.dat";
    private static final String playlistFileName = "PlaylistData.dat";

    //load saved data
    public static DataManager loadSavedData() {
        SongData songData = loadSavedSongData();
        PlaylistData playlistData = loadSavedPlaylistData();
        return new DataManager(songData, playlistData);
    }

    private static SongData loadSavedSongData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(songFileName));) {
            return (SongData) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new SongData();
        }
    }

    private static PlaylistData loadSavedPlaylistData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(playlistFileName));) {
            return (PlaylistData) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new PlaylistData();
        }
    }

    //save change data
    public static void saveChangeData(SongData songData, PlaylistData playlistData) {
        saveSongData(songData);
        savePlaylistData(playlistData);
    }

    private static void saveSongData(SongData songData) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(songFileName));) {
            oos.writeObject(songData);
        } catch (IOException e) {
        }
    }

    private static void savePlaylistData(PlaylistData playlistData) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(playlistFileName));) {
            oos.writeObject(playlistData);
        } catch (IOException e) {
        }
    }

}
