package com.arunprashanna.miningsupervision1;

public class Node {
    public String id;
    public String temperature, humidity, methane;

    public Node() { }

    public Node(String id, String temperature, String humidity, String methane) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.methane = methane;
    }

    public String getId() {
        return id;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getMethane() {
        return methane;
    }
}
