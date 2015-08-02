package com.deniz.elevator

import static com.deniz.elevator.Elevator.Direction.UP
import static com.deniz.elevator.Elevator.Direction.DOWN
import static com.deniz.elevator.Elevator.Direction.IMMOBILE

/**
 * author: TRYavasU
 * date: 02/08/2015
 */
class Elevator {

    int currentFloor = 0
    Direction direction = IMMOBILE
    def callerList = []
    def passengerList = []
    def maxFloor

    Elevator(maxFloor) {
        this.maxFloor = maxFloor
    }

    void transferLoad() {
        disembarkPassengers()
        embarkPassengers()
    }

    void move() {
        if (direction == UP) {
            if (passengerList.any { it.targetFloor > currentFloor } ||
                    callerList.any { it.sourceFloor > currentFloor }) {
                //1&2
                move(UP)
            } else {
                if (passengerList.empty && callerList.empty) {
                    //3
                    move(IMMOBILE)
                } else {
                    //4 & 5
                    move(DOWN)
                }
            }
        } else if (direction == DOWN) {
            if (passengerList.any { it.targetFloor < currentFloor } ||
                    callerList.any { it.sourceFloor < currentFloor }) {
                //6&7
                move(DOWN)
            } else {
                if (passengerList.empty && callerList.empty) {
                    //8
                    move(IMMOBILE)
                } else {
                    //9&10
                    move(UP)
                }
            }
        } else {
            //Passengers First
            if (!passengerList.empty) {
                //18 & 19 ; if there are multiple close target floors; first come first served
                def nextFloor = passengerList.min { (it.targetFloor - currentFloor).abs() }.targetFloor
                if (nextFloor > currentFloor) {
                    //11
                    move(UP)
                } else if (nextFloor < currentFloor) {
                    //12
                    move(DOWN)
                } else {
                    //13
                    move(IMMOBILE)
                    println "Problematic passenger wants to go same floor that is currently in"
                }
            }
            //Callers Second
            else if (!callerList.empty) {
                //20 & 21 ; if there are multiple close source floors; first come first served
                def nextFloor = callerList.min { (it.sourceFloor - currentFloor).abs() }.sourceFloor
                if (nextFloor > currentFloor) {
                    //14
                    move(UP)
                } else if (nextFloor < currentFloor) {
                    //15
                    move(DOWN)
                } else {
                    //16
                    move(IMMOBILE)
                    println "Problematic passenger wants to go same floor that is currently in"
                }
            }
            //There is no passenger or caller
            else {
                //17
                move(IMMOBILE)
                println "No passenger, no caller; staying immobile"
            }
        }

        println "Elevator is in floor: $currentFloor and it is going $direction"
    }

    void move(Direction direction) {
        if (direction == DOWN) {
            currentFloor--
        } else if (direction == UP) {
            currentFloor++
        }
        this.direction = direction
    }

    void addPassengerToCallerList(def passenger) {
        callerList.add(passenger)
    }

    private ArrayList<Object> disembarkPassengers() {
        passengerList.findAll {
            it.targetFloor == currentFloor
        }.each {
            println "Passenger with name : $it.name has left the elevator"
            passengerList.remove(it)
        }
    }

    private ArrayList<Object> embarkPassengers() {
        callerList.findAll {
            it.sourceFloor == currentFloor
        }.each {
            println "Passenger with name : $it.name has entered the elevator wants to go to floor: $it.targetFloor"
            passengerList.add(it)
            callerList.remove(it)
        }
    }

    enum Direction {
        UP, DOWN, IMMOBILE
    }
}
