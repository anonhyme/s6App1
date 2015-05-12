package org.anonhyme.client.application.reservation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import org.anonhyme.shared.dto.ReservationDto;

import java.util.List;

import javax.inject.Inject;


public class ReservationView extends ViewWithUiHandlers<ReservationUiHandlers> implements ReservationPresenter.MyView {

    @UiField
    TextBox categorie;

    @UiField
    TextBox date;

    @UiField
    TextBox startTime;

    @UiField
    TextBox endTime;

    @UiField
    FlexTable reservationTable;

    @UiField
    Button sendButton;

    @UiField
    HTMLPanel main;

//    @UiField
//    DatePicker datePicker;

    List<ReservationDto> reservations;

    @Inject
    ReservationView(Binder binder) {
        initWidget(binder.createAndBindUi(this));


    }

    @Override
    public void updateTable(List<ReservationDto> reservations) {
        this.reservations = reservations;
        reservationTable.removeAllRows();
        reservationTable.clear();

        reservationTable.setText(0, 0, "Periode");
        reservationTable.setText(0, 1, "Local");
        reservationTable.setText(0, 2, "Description");
        for (int i = 0; i < reservations.size(); i++) {
            reservationTable.setText(i+1, 0, reservations.get(i).getPeriode());
            reservationTable.setText(i+1, 1, reservations.get(i).getLocal());
            reservationTable.setText(i+1, 2, reservations.get(i).getDescription());
        }
    }

    interface Binder extends UiBinder<Widget, ReservationView> {
    }

    @Override
    public void initView() {
        reservationTable.setTitle("Reservation");
        reservationTable.setCellSpacing(10);
        reservationTable.setCellPadding(5);
        reservationTable.setCellSpacing(10);
        reservationTable.setBorderWidth(1);
        categorie.setText("Projet");
        date.setText("2001-01-01");
        startTime.setText("00:00:00");
        endTime.setText("23:30:00");
        sendButton.setText("Send");
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == ReservationPresenter.SLOT_LocalReservation) {
            main.add(content);
        } else {
            super.setInSlot(slot, content);
        }
    }

    @UiHandler("sendButton")
    void onSend(ClickEvent event) {
        getUiHandlers().sendReservationListRequest(categorie.getText(), date.getText(), startTime.getText(), endTime.getText());
    }


}
