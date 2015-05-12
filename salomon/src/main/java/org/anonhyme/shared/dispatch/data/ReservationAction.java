/*
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.anonhyme.shared.dispatch.data;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

public class ReservationAction extends UnsecuredActionImpl<ReservationResult> {

    public ReservationAction() {

    }

    private String categorie;
    private String date;
    private String startTime;
    private String endTime;

    public ReservationAction(String categorie, String date, String startTime, String endTime){
        this.categorie = categorie;
        this.date =date;
        this.startTime = startTime;
        this.endTime = endTime;

    }
    public String getCategorie() {
        return categorie;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }


}
