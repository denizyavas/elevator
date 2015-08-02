package com.deniz.elevator

/**
 * author: TRYavasU
 * date: 02/08/2015
 */
class Passenger {
    int time
    int sourceFloor
    int targetFloor
    String name

    void callElevator(Elevator elevator) {
        println "Passenger $name is calling elevator from floor: $sourceFloor  at time:$time"
        elevator.addPassengerToCallerList(this)
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "time=" + time +
                ", sourceFloor=" + sourceFloor +
                ", targetFloor=" + targetFloor +
                ", name='" + name + '\'' +
                '}';
    }
}
