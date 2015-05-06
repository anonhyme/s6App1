
package org.anonhyme.app1ProjectAE.client.application.fuck;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class FuckView extends ViewWithUiHandlers<FuckUiHandlers> implements FuckPresenter.MyView {
    public interface Binder extends UiBinder<HTMLPanel, FuckView> {
    }

    @UiField
    HTMLPanel panel;

    @Inject
    FuckView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
}
