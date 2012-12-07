package cz.cvut.ajeelab.springinfinispandemo;

import java.util.Set;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public interface SimpleStorage {
    
    public void add(String name);
    
    public void remove(String name);
    
    public Set<String> getAll();
}
