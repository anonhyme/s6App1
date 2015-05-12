


package org.anonhyme.client.application.reservation;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

import org.anonhyme.client.place.NameTokens;
import org.anonhyme.shared.dispatch.data.ReservationAction;
import org.anonhyme.shared.dispatch.data.ReservationResult;
import org.anonhyme.shared.dto.ReservationDto;

import java.util.List;

public class ReservationPresenter extends Presenter<ReservationPresenter.MyView, ReservationPresenter.MyProxy> implements ReservationUiHandlers {

    interface MyView extends View, HasUiHandlers<ReservationUiHandlers> {
        void updateTable(List<ReservationDto> reservationDtos);
        void initView();
    }

    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_LocalReservation = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.localReservation)
    @ProxyStandard
    public interface MyProxy extends ProxyPlace<ReservationPresenter> {
    }

    DispatchAsync dispatcher;
    EventBus eventBus;
    ReservationPresenter presenter;
    PlaceManager placeManager;


    @Inject
    public ReservationPresenter(EventBus eventBus,
                                MyView view,
                                MyProxy proxy,
                                PlaceManager placeManager,
                                DispatchAsync dispatcher) {
        super(eventBus, view, proxy, RevealType.Root);

        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        getView().setUiHandlers(this);
    }

    @Override
    public void sendReservationListRequest(String categorie, String date, String startTime, String stopTime) {
        dispatcher.execute(new ReservationAction(categorie, date, startTime, stopTime), new AsyncCallback<ReservationResult>() {
            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(ReservationResult result) {
                List<ReservationDto> reservations = result.getResponseList();
                getView().updateTable(reservations);
            }
        });
    }


    protected void onBind() {
        super.onBind();
        getView().initView();
    }


    protected void onHide() {
        super.onHide();
    }

    protected void onUnbind() {
        super.onUnbind();
    }

    protected void onReset() {
        super.onReset();
    }


}
