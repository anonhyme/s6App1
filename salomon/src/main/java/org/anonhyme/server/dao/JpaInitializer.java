package org.anonhyme.server.dao;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

/**
 * Created with IntelliJ IDEA Project: gwtp-sample-basic on 5/5/2015
 *
 * @author antoine
 */

public class JpaInitializer {

    @Inject
    JpaInitializer(PersistService service) {
        service.start();
    }
}
