package ru.netology.domain;

public class FlightOption implements Comparable<FlightOption> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int travelTime;

    @Override
    public int compareTo(FlightOption o) {
        FlightOption tmp = (FlightOption)o;
        if(this.price < tmp.price) {
            return -1;
        }
        if(this.price > tmp.price) {
            return 1;
        }
        return 0;
    }

    public FlightOption() {
    }

    public FlightOption(int id, int price, String from, String to, int travelTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }
}
