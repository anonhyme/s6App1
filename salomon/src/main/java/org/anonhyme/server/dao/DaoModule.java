package org.anonhyme.server.dao;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * Created with IntelliJ IDEA Project: gwtp-sample-basic on 5/6/2015
 *
 * @author antoine
 */

public class DaoModule extends AbstractModule {
    final String persistenceUnit;

    @Inject
    public DaoModule(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    @Override
    protected void configure() {
        install(new JpaPersistModule(persistenceUnit));
        bind(ReservationDao.class).to(ReservationDaoImpl.class);

    }
}