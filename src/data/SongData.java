
package data;

import java.io.Serializable;
import java.util.HashMap;
import model.Song;

public class SongData extends HashMap<String, Song> implements Serializable{
    //giả sử bạn thiết bị của bạn đã có một mục chứa rất nhiều file nhạc
    //class này sẽ là pool của class song
    //với các song là những file nhạc trong thư mục music
        
    //điều này giúp quản lý các song dễ hơn 
    
}
