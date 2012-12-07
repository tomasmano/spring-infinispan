package cz.cvut.ajeelab.springinfinispandemo;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
@Service("setSongStorage")
public class SongsStorageSetImpl implements SimpleStorage{
    
    Set<String> storage = new HashSet<String>();

    @Override
    public void add(String name) {
        storage.add(name);
    }

    @Override
    public void remove(String name) {
        storage.remove(name);
    }

    @Override
    public Set<String> getAll() {
        return storage;
    }
    
}
