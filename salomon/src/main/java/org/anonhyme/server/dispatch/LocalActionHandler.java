package org.anonhyme.server.dispatch;

import com.google.inject.Inject;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import org.anonhyme.entities.Campus;
import org.anonhyme.server.logic.LocalType;
import org.anonhyme.shared.dispatch.LocalAction;
import org.anonhyme.shared.dispatch.LocalResult;

import java.math.BigInteger;

import javax.persistence.EntityManager;

public class LocalActionHandler implements ActionHandler<LocalAction, LocalResult> {

    @Inject
    LocalType localType;


    @Override
    public LocalResult execute(LocalAction action, ExecutionContext context)
            throws ActionException {
        LocalResult localResult = new LocalResult();
        localResult.setLocalType(localType.getLocalType(action.getLocal()));
        return localResult;
    }

    @Override
    public void undo(LocalAction action, LocalResult result,
                     ExecutionContext context) throws ActionException {


    }

    @Override
    public Class<LocalAction> getActionType() {
        return null;
    }
}
