
import cz.cvut.ajeelab.springinfinispandemo.SimpleStorage;
import cz.cvut.ajeelab.springinfinispandemo.SongManager;
import cz.cvut.ajeelab.springinfinispandemo.SongsCacheListener;
import cz.cvut.ajeelab.springinfinispandemo.SongsStorageSetImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.mockito.Mockito.*;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-test.xml")
public class InfinispanSpringTest {

    @Autowired(required = true)
    private SongManager songManager;
    
    private SimpleStorage storage;
    
    @Autowired
    private SongsCacheListener cacheListener;

    @Before
    public void setUpMocks() {
        storage = mock(SongsStorageSetImpl.class);
    }

    @Test
    public void cache_test() {
        // override spring autowiring with my mock
        songManager.setStorage(storage);
        
        //given
        songManager.addSong("One More Night");
        songManager.addSong("Ho Hey");
        songManager.addSong("Let Me Love You");
        
        //when
        songManager.getAll();
        songManager.getAll();
        songManager.getAll();
        songManager.getAll();
        
        //then
        verify(storage, times(1)).getAll();
    }
}
