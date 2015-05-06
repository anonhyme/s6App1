package com.gwtplatform.samples.basic.server.data.initializer;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

/**
 * Created with IntelliJ IDEA
 * Project: gwtp-sample-basic
 * on 5/5/2015
 *
 * @author antoine
 */
public class DbInitializer {

    @Inject
    DbInitializer(PersistService service) {
        service.start();
    }
}
