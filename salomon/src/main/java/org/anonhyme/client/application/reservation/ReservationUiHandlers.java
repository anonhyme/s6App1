package org.anonhyme.client.application.reservation;

import com.gwtplatform.mvp.client.UiHandlers;

public interface ReservationUiHandlers extends UiHandlers {


    void sendReservationListRequest(String categorie, String date, String startTime, String stopTime);



//    void updateTable(CampusDto campusDto);

}
