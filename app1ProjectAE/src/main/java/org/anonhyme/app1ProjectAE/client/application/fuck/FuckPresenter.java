
package org.anonhyme.app1ProjectAE.client.application.fuck; 

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class FuckPresenter extends PresenterWidget<FuckPresenter.MyView> implements FuckUiHandlers {
    public interface MyView extends View, HasUiHandlers<FuckUiHandlers> {
    }

    @Inject
    FuckPresenter(EventBus eventBus, MyView view) {
        super(eventBus, view);

        getView().setUiHandlers(this);
    }
    
    protected void onBind() {
        super.onBind();
    }


    protected void onReset() {
        super.onReset();
    }

}
