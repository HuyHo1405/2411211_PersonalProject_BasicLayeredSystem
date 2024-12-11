package controller;

import data.PlaylistData;
import data.SongData;
import logic.PlaylistLogic;
import util.InputUtils;

public class PlaylistController {
    
    public void addSongToPlaylist(PlaylistData playlistData, SongData songData) {
        if (playlistData == null || songData == null) {
            return;
        }
        if (playlistData.isEmpty()) {
            System.out.println("You don't have any playlist");
            System.out.println("Creat a new playlist?");
            System.out.println(" 1. Yes");
            System.out.println(" 2. No");
            int choice = InputUtils.inputInteger("your choice", 1, 2);
            if (choice == 2) {
                return;
            } else if (choice == 1) {
                playlistData.addNewPlaylist();
            }
        }
        
        PlaylistLogic.addSongToPlaylist(playlistData, songData);
    }
    
    public void removeSongFromPlaylist(PlaylistData playlistData, SongData songData) {
        if (playlistData == null || songData == null) {
            return;
        }
        if (playlistData.isEmpty()) {
            System.out.println("You don't have any playlist yet!");
            return;
        }
        if (songData.isEmpty()) {
            System.out.println("The song data is empty!");
            return;
        }
        PlaylistLogic.removeSongFromPlaylist(playlistData, songData);
    }
    
    public void showPlaylist(PlaylistData playlistData) {
        if (playlistData == null) {
            return;
        }
        
        if (playlistData.isEmpty()) {
            System.out.println("You don't have any playlist yet!");
            return;
        }
        PlaylistLogic.showPlaylist(playlistData);
    }
    
    public void addPlaylist(PlaylistData playlistData) {
        if (playlistData == null) {
            return;
        }
        PlaylistLogic.addPlaylist(playlistData);
    }
    
    public void removePlaylist(PlaylistData playlistData) {
        if (playlistData == null) {
            return;
        }
        if (playlistData.isEmpty()) {
            System.out.println("There is no playlist left!");
        }
        PlaylistLogic.removePlaylist(playlistData);
    }
    
}
