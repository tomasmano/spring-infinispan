package cz.cvut.ajeelab.springinfinispandemo;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
@Service("songManager")
public class SongManagerImpl implements SongManager {

    @Autowired
    @Qualifier("setSongStorage")
    SimpleStorage storage;

    @Override
    @CacheEvict(value = "songs")
    public void addSong(String name) {
        storage.add(name);
    }

    @Override
    @CacheEvict(value = "songs", allEntries = false)
    public void deleteSong(String name) {
        storage.remove(name);
    }

    @Override
    @Cacheable("songs")
    public Set<String> getAll() {
        return storage.getAll();
    }

    @Override
    public SimpleStorage getStorage() {
        return storage;
    }

    @Override
    public void setStorage(SimpleStorage storage) {
        this.storage = storage;
    }
}
