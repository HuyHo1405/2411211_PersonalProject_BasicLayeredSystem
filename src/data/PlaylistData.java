package data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import model.Playlist;
import util.InputUtils;

public class PlaylistData extends LinkedHashMap<String, Playlist> implements Serializable {

    //các song được người dùng phân chia vào các playlist
    //cần một nơi quản lý và lưu trữ các playlist
    //class này sẽ đảm nhận phần đó
    public void addNewPlaylist() {
        String newPlaylistName = InputUtils.inputNonEmptyString("new playlist name");
        this.put(newPlaylistName, new Playlist(newPlaylistName));
    }
}
