package logic;

import java.util.Queue;
import model.Song;
import util.InputUtils;

public class MusicPlayerLogic {

    public static void displayOption() {
        System.out.println("Music player: ");
        System.out.println(" 1. Play next music");
        System.out.println(" 2. Play previous music");
        System.out.println(" 3. Play agian");
        System.out.println(" 4. Skip next music");
        System.out.println(" 5. Pause");
    }

    public static void play(Queue<Song> playingQueue) {
        Song previous = null;
        while (!playingQueue.isEmpty()) {
            Song current = playingQueue.poll();
            current.play();

            if (check(previous, current, playingQueue)) {
                return;
            }
            previous = current;
        }
    }

    private static boolean check(Song previous, Song current, Queue<Song> playingQueue) {
        while (true) {
            displayOption();
            int choice = InputUtils.inputInteger("your choice", 1, 5);
            switch (choice) {
                case 1://continue playing
                    return false;
                case 2://play previous
                    if (previous == null) {
                        System.out.println("Previous's not available");
                        break;
                    }
                    previous.play();
                    Song t = previous;
                    previous = current;
                    current = previous;
                    break;
                case 3://play again
                    current.play();
                    break;
                case 4://skip next music
                    playingQueue.poll();
                    return false;
                case 5://pause
                    return true;
            }
        }
    }
}
