package org.anonhyme.app1ProjectAE.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import org.anonhyme.app1ProjectAE.client.application.fuck.FuckModule;
import org.anonhyme.app1ProjectAE.client.application.home.HomeModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());
        install(new FuckModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
