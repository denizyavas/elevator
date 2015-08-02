package com.deniz.elevator

/**
 * author: TRYavasU
 * date: 01/08/2015
 */
class Chrone {

    int now = 0

    def passengers = []

    Elevator elevator

    Chrone(maxFloor, passengers) {
        this.elevator = new Elevator(maxFloor)
        this.passengers = passengers
    }

    void passTime() {
        println "===Time $now==="
        println "Elevator is on floor: $elevator.currentFloor"
        //Call elevator
        passengers.findAll {
            it.time == now
        }.each {
            it.callElevator(elevator)
            passengers.remove(it)
        }

        //Load/Unload passengers
        elevator.transferLoad()

        //Move up or down
        elevator.move()

        now++
    }
}
