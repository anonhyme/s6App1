package org.anonhyme.server.dispatch;

import com.google.inject.Inject;
import com.google.inject.Provider;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import org.anonhyme.server.dao.ReservationDao;
import org.anonhyme.shared.dispatch.data.ReservationAction;
import org.anonhyme.shared.dispatch.data.ReservationResult;

import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA Project: salomon on 5/10/2015
 * @author antoine
 */
public class ReservationHandler implements ActionHandler<ReservationAction, ReservationResult> {
    private Provider<HttpServletRequest> requestProvider;
    private ServletContext servletContext;

    @Inject
    ReservationDao reservationDao;

    @Inject
    ReservationHandler(ServletContext servletContext, Provider<HttpServletRequest> requestProvider) {
        this.servletContext = servletContext;
        this.requestProvider = requestProvider;
    }

    @Override
    public ReservationResult execute(ReservationAction action, ExecutionContext context) throws ActionException {
        return new ReservationResult(reservationDao.findReservationDto(action.getCategorie(), Date.valueOf(action.getDate()), Time.valueOf(action.getStartTime()), Time.valueOf(action.getEndTime())));
    }

    @Override
    public Class<ReservationAction> getActionType() {
        return null;
    }

    @Override
    public void undo(ReservationAction action, ReservationResult result, ExecutionContext context) throws ActionException {

    }

}
