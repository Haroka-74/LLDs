package models;

import java.time.Duration;
import java.time.LocalTime;

public class Fee {
    private Ticket ticket;

    public Fee(Ticket ticket) {
        this.ticket = ticket;
    }

    public double calculate() {
        var minutes = Duration.between(ticket.getEntryTime(), LocalTime.now()).toMinutes();
        var rate = ticket.getVehicle().getSize().getRate();

        return minutes * rate;
    }
}