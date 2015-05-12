package org.anonhyme.client.application.reservation;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ReservationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ReservationPresenter.class, ReservationPresenter.MyView.class, ReservationView.class, ReservationPresenter.MyProxy.class);
    }
}
