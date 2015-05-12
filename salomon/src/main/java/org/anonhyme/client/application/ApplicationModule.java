package org.anonhyme.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import org.anonhyme.client.application.reservation.ReservationModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ReservationModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}