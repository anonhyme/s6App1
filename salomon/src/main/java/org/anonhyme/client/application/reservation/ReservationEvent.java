package org.anonhyme.client.application.reservation;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.web.bindery.event.shared.HandlerRegistration;

import org.anonhyme.shared.dto.ReservationDto;

import java.util.List;


/**
 * Created with IntelliJ IDEA Project: salomon on 5/10/2015
 *
 * @author antoine
 */
public class ReservationEvent extends GwtEvent<ReservationEventHandler> {
    public static Type<ReservationEventHandler> TYPE = new Type<ReservationEventHandler>();

    public interface FetchDataEventHandlers extends HasHandlers {
        HandlerRegistration addInfoHandler(ReservationEventHandler handler);
    }


    ReservationDto reservationDto;
    List<ReservationDto> data;

    public ReservationEvent() {
    }

    public ReservationEvent(ReservationDto reservationDto) {
        this.reservationDto = reservationDto;
    }

    public ReservationEvent(List<ReservationDto> data) {
        this.data = data;
    }

    public Type<ReservationEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(ReservationEventHandler handler) {
        handler.onFetchData(this);
    }

    public static void fire(HasHandlers source, List<ReservationDto> data) {
        source.fireEvent(new ReservationEvent(data));
    }


}
