package org.anonhyme.client.application.reservation;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/10/2015
 *
 * @author antoine
 */
public interface ReservationEventHandler extends EventHandler {
    void onFetchData(ReservationEvent event);
}
