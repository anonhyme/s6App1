package org.anonhyme.server.dao;

import com.google.inject.Inject;

import org.anonhyme.entities.procedure.ReservationProcedure;
import org.anonhyme.shared.dto.ReservationDto;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/10/2015
 *
 * @author antoine
 */
public class ReservationDaoImpl implements ReservationDao {

    @Inject
    EntityManager entityManager;

//    public List<ReservationProcedure> findReservation(String categorie, Date date, Time startTime, Time stopTime) {
//        return (List<ReservationProcedure>) getReservationList(categorie, date, startTime, stopTime);
//    }


    @Override
    public List<ReservationDto> finAll() {
        return entityToDto(entityManager.createQuery("SELECT e FROM ReservationProcedure e").getResultList());
    }

    @Override
    public List<ReservationDto> findReservationDto(String categorie, Date date, Time startTime, Time stopTime) {
        List<ReservationProcedure> reservationDtos = getReservationList(categorie, date, startTime, stopTime);
        return entityToDto(reservationDtos);
    }

    private List<ReservationProcedure> getReservationList(String categorie, Date date, Time startTime, Time stopTime) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("GetReservation");
        query.setParameter("p_cat", categorie);
        query.setParameter("p_jour", date);
        query.setParameter("p_start_time", startTime);
        query.setParameter("p_end_time", stopTime);
        query.execute();
        query.getClass();
        return (List<ReservationProcedure>)query.getResultList();
    }


    private List<ReservationDto> entityToDto(List<ReservationProcedure> list) {
        ArrayList<ReservationDto> reservationDtos = new ArrayList<>();
        for (ReservationProcedure reservation : list) {
            reservationDtos.add(createDto(reservation));
        }
        return reservationDtos;
    }

    private ReservationDto createDto(ReservationProcedure data) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setPeriode(data.getPeriode());
        reservationDto.setLocal(data.getLocal());
        reservationDto.setDescription(data.getDescription());
        return reservationDto;
    }

}
