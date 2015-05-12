package org.anonhyme.server.dao;

import org.anonhyme.shared.dto.ReservationDto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/10/2015
 *
 * @author antoine
 */
public interface ReservationDao {
//    public List<ReservationProcedure> findReservation(String categorie, Date date, Time startTime, Time stopTime);
    public List<ReservationDto> finAll();
    public List<ReservationDto> findReservationDto(String categorie, Date date, Time startTime, Time stopTime);
}
