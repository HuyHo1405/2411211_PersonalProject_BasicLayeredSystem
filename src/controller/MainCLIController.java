package controller;

import data.FileHandler;
import util.InputUtils;

public class MainCLIController {

    private final PlaylistController playlistController = new PlaylistController();
    private final MusicPlayerController musicPlayerController = new MusicPlayerController();
    private final DataManager dataManager = FileHandler.loadSavedData();

    public void start() {
        while (true) {
            displayOptions();
            int userChoice = InputUtils.inputInteger("your choice", 1, 11);
            if (userChoice == 11) {
                dataManager.saveChangeData();
                System.out.println("Thank you for using PlayEasy! Hope you a wonderful day!");
                return;
            }
            handle(userChoice);
        }
    }

    private void displayOptions() {
        System.out.println("- PlayEasy - - - - - - - - - - - - -");
        //playlist and song logic
        System.out.println(" 01. Add song to playlist");
        System.out.println(" 02. Remove song from playlist");
        System.out.println(" 03. Show playlist");
        System.out.println(" 04. Add playlist");
        System.out.println(" 05. Remove playlist");

        //basic music player logic
        System.out.println(" 06. Add song to playing queue");
        System.out.println(" 07. Add playlist to playing queue");
        System.out.println(" 08. Clear playing queue");
        System.out.println(" 09. Show playing queue");
        System.out.println(" 10. Play");

        //end
        System.out.println(" 11. Exit");

    }

    public void handle(int userChoice) {
        switch (userChoice) {
            case 1:
                playlistController.addSongToPlaylist(
                        dataManager.getPlaylistData(),
                        dataManager.getSongData());
                break;
            case 2:
                playlistController.removeSongFromPlaylist(
                        dataManager.getPlaylistData(),
                        dataManager.getSongData());

                break;
            case 3:
                playlistController.showPlaylist(dataManager.getPlaylistData());
                break;
            case 4:
                playlistController.addPlaylist(dataManager.getPlaylistData());
                break;
            case 5:
                playlistController.removePlaylist(dataManager.getPlaylistData());
                break;
            case 6:
                musicPlayerController.addSong(dataManager.getSongData());
                break;
            case 7:
                musicPlayerController.addPlaylist(dataManager.getPlaylistData());
                break;
            case 8:
                musicPlayerController.clear();
                break;
            case 9:
                musicPlayerController.displayPlayingQueue();
                break;
            case 10:
                musicPlayerController.play();
                break;
        }
    }
}
