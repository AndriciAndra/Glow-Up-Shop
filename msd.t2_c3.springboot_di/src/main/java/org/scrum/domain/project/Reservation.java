package org.scrum.domain.project;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reservation {
    @JsonProperty("reservationId")
    private int reservationId;

    @JsonProperty("clientName")
    private String clientName;

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("reservationTime")
    private LocalDateTime reservationTime;

    public Reservation() {
    }

    public Reservation(String clientName, String serviceName, LocalDateTime reservationTime) {
        this.clientName = clientName;
        this.serviceName = serviceName;
        this.reservationTime = reservationTime;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }
}
