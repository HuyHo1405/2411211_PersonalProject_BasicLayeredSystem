package controller;

import data.FileHandler;
import data.PlaylistData;
import data.SongData;
import model.*;

public class DataManager {
    //class này sẽ quản lý những data sau khi file handler đã đọc 
    //đóng vai trò điều phối dữ liệu cần thiết và truyền vaò cách class logic

    //fields
    private final SongData songData;
    private final PlaylistData playlistData;

    //methods for CLI
    ///constructor
    public DataManager(SongData songData, PlaylistData playlistData) {
        this.songData = songData;
        this.playlistData = playlistData;
    }

    ///save change data
    public void saveChangeData() {
        FileHandler.saveChangeData(songData, playlistData);
    }

    //methods for logic classes
    ///getters
    public SongData getSongData() {
        return songData;
    }

    public PlaylistData getPlaylistData() {
        return playlistData;
    }

    ///add
    public void addSongToData(Song song) {
        songData.put(song.getTitle(), song);
    }

    public void addPlaylistToData(Playlist playlist) {
        playlistData.put(playlist.getName(), playlist);
    }

    ///get
    public Song getSongFromData(String title) {
        return songData.getOrDefault(title, null);
    }

    public Playlist getPlaylistFromData(String name) {
        return playlistData.getOrDefault(name, null);
    }

    ///remove
    public void removeSongFromData(String title) {
        songData.remove(title);
    }

    public void removePlaylistFromData(String name) {
        playlistData.remove(name);
    }
}
