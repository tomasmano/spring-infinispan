package cz.cvut.ajeelab.springinfinispandemo;

import java.util.Set;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public interface SongManager {

    public void addSong(String name);
    
    public void deleteSong(String name);
    
    public Set<String> getAll();
    
    public SimpleStorage getStorage();

    public void setStorage(SimpleStorage storage);
}
