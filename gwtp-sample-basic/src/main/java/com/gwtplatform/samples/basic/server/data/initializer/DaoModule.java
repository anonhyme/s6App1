package com.gwtplatform.samples.basic.server.data.initializer;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * Created with IntelliJ IDEA
 * Project: gwtp-sample-basic
 * on 5/6/2015
 *
 * @author antoine
 */
public class DaoModule extends AbstractModule {
    final String persistenceUnit;

    public DaoModule( String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    @Override
    protected void configure() {
        JpaPersistModule jpaPersistModule = new JpaPersistModule(persistenceUnit);
        install(jpaPersistModule);
    }
}
