package cz.cvut.ajeelab.springinfinispandemo;

import org.infinispan.Cache;
import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryCreated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryModified;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryRemoved;
import org.infinispan.notifications.cachelistener.event.CacheEntryEvent;
import org.infinispan.spring.provider.SpringEmbeddedCacheManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
@Service
@Listener
public class SongsCacheListener implements InitializingBean {

    @Autowired(required = true)
    private SpringEmbeddedCacheManager booksCacheManager;

    private Cache<?, ?> songsCache() {
        return (Cache) this.booksCacheManager.getCache("songs").getNativeCache();
    }

    public void installCacheListener() {
        songsCache().addListener(this);
    }

    @Override
    public void afterPropertiesSet() throws IllegalStateException {
        installCacheListener();
    }

    @CacheEntryCreated
    @CacheEntryModified
    @CacheEntryRemoved
    public void cacheModified(CacheEntryEvent event) {
        System.out.println(">>>>>>>>>>>>>> Cache modified: " + event);
    }
}
