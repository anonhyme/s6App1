
package org.anonhyme.app1ProjectAE.client.application.fuck;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class FuckModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenterWidget(FuckPresenter.class, FuckPresenter.MyView.class, FuckView.class);
    }
}
