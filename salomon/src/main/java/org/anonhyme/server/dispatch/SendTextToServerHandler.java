///*
// * Copyright 2011 ArcBees Inc.
// *
// * Licensed under the Apache License, Version 2.0 (the "License"); you may not
// * use this file except in compliance with the License. You may obtain a copy of
// * the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
// * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
// * License for the specific language governing permissions and limitations under
// * the License.
// */
//
//package org.anonhyme.server.dispatch;
//
//import com.google.inject.Inject;
//import com.google.inject.Provider;
//
//import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
//import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
//import com.gwtplatform.dispatch.shared.ActionException;
//
//import org.anonhyme.entities.Campus;
//import org.anonhyme.shared.FieldVerifier;
//import org.anonhyme.shared.dispatch.SendTextToServerAction;
//import org.anonhyme.shared.dispatch.SendTextToServerResult;
//
//import java.math.BigInteger;
//
//import javax.persistence.EntityManager;
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//
//public class SendTextToServerHandler implements ActionHandler<SendTextToServerAction, SendTextToServerResult> {
//    private Provider<HttpServletRequest> requestProvider;
//    private ServletContext servletContext;
//
//    @Inject
//    SendTextToServerHandler(
//            ServletContext servletContext,
//            Provider<HttpServletRequest> requestProvider) {
//        this.servletContext = servletContext;
//        this.requestProvider = requestProvider;
//    }
//
//    @Inject
//    EntityManager em;
//
////    @Inject
////    CampusDao campus;
//
//    @Override
//    public SendTextToServerResult execute(SendTextToServerAction action, ExecutionContext context)
//            throws ActionException {
//        String input = action.getTextToServer();
//
////      Injector injector = Guice.createInjector(new DaoModule("persistUnit"));
////      campus = injector.getInstance(CampusDaoImpl.class);
//
////        campus.findById(1);
//        // Verify that the input is valid.
//        if (!FieldVerifier.isValidName(input)) {
//            // If the input is not valid, throw an IllegalArgumentException back to the client.
//            throw new ActionException("Name must be at least 4 characters long.");
//        }
//        em.find(Campus.class, BigInteger.valueOf(1));
//
//        String serverInfo = servletContext.getServerInfo();
//        String userAgent = requestProvider.get().getHeader("User-Agent");
//        String response = String.format("Hello, %s!<br/><br/>I am running %s.<br/><br/>" +
//                        "It looks like you are using:<br/>%s",
//                input, serverInfo, userAgent);
//
//        return new SendTextToServerResult(response);
//    }
//
//    @Override
//    public Class<SendTextToServerAction> getActionType() {
//        return SendTextToServerAction.class;
//    }
//
//    @Override
//    public void undo(SendTextToServerAction action, SendTextToServerResult result, ExecutionContext context)
//            throws ActionException {
//        // Not undoable
//    }
//}
