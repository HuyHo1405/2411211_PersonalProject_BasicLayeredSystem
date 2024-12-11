package logic;

import data.PlaylistData;
import data.SongData;
import model.Playlist;
import model.Song;
import util.InputUtils;

public class PlaylistLogic {
    //class này sẽ xử lý các logic liên quan đến quản lý đến các playlist

    private static void displayPlaylists(PlaylistData playlistData) {
        int i = 1;
        for (String name : playlistData.keySet()) {
            System.out.println(String.format(" %02d. %s", i++, name));
        }
    }

    public static Playlist findPlaylist(PlaylistData playlistData) {
        displayPlaylists(playlistData);
        int choice = InputUtils.inputInteger("your chosen playlist", 1, playlistData.size());
        int i = 1;
        for (String key : playlistData.keySet()) {
            if (choice == i++) {
                return playlistData.get(key);
            }
        }
        System.out.println("The playlist doesn't exist!");
        return null;
    }

    private static void displayPlaylist(Playlist playlist) {
        if (playlist == null) {
            System.out.println("The playlist doesn't exist!");
            return;
        }
        if (playlist.isEmpty()) {
            System.out.println("Empty playlist!");
            return;
        }
        System.out.println("- " + playlist.getName() + " - - - - - - - - - - - -");
        int i = 1;
        for (Song song : playlist) {
            System.out.println(String.format(" %02d. %s", i++, song));
        }
    }

    private static Song getSongFromPlaylist(Playlist playlist) {
        displayPlaylist(playlist);
        int choice = InputUtils.inputInteger("song", 1, playlist.size());
        return playlist.get(choice - 1);
    }

    //add song to playlist
    public static void addSongToPlaylist(PlaylistData playlistData, SongData songData) {
        Playlist playlist = findPlaylist(playlistData);
        Song song = SongLogic.findSong(songData);
        if (song == null || playlist == null) {
            System.out.println("The song is unavailable!");
            return;
        }
        playlist.add(song);
        System.out.println("Add [" + song + "] successfully!");
    }

    //remove song from playlist
    public static void removeSongFromPlaylist(PlaylistData playlistData, SongData songData) {
        Playlist playlist = findPlaylist(playlistData);
        int choice = InputUtils.inputInteger("song", 1, playlist.size());
        Song search = playlist.get(choice - 1);
        playlist.remove(choice - 1);
        System.out.println("Remove [" + search + "] from playlist [" + playlist.getName() + "] successfully!");

    }

    //show playlist
    public static void showPlaylist(PlaylistData playlistData) {
        Playlist playlist = findPlaylist(playlistData);
        displayPlaylist(playlist);
    }

    //add playlist
    public static void addPlaylist(PlaylistData playlistData) {
        String newPlaylistName = InputUtils.inputNonEmptyString("new playlist's name");
        playlistData.put(newPlaylistName, new Playlist(newPlaylistName));
        System.out.println("Add playlist [" + newPlaylistName + "] successfully!");
    }

    //remove playlist
    public static void removePlaylist(PlaylistData playlistData) {
        Playlist playlist = findPlaylist(playlistData);
        playlistData.remove(playlist.getName());
        System.out.println("Remove playlist [" + playlist.getName() + "] successfully!");
    }
}
