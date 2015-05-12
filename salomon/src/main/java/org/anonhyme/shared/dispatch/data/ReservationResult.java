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

import com.gwtplatform.dispatch.rpc.shared.Result;

import org.anonhyme.shared.dto.ReservationDto;

import java.util.List;

/**
 * The result of a {@link ReservationResult} action.
 */
public class ReservationResult implements Result {
    private ReservationDto reservationDto;
    private List<ReservationDto> reservations;

    public ReservationResult(ReservationDto ReservationDto) {
        this.reservationDto = reservationDto;
    }

    public ReservationResult(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    public ReservationResult() {
    }

    public ReservationDto getResponse() {
        return reservationDto;
    }

    public List<ReservationDto> getResponseList() {
        return reservations;
    }


}
