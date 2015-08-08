package com.deniz.elevator

import static com.deniz.elevator.Elevator.Direction.*

/**
 * author: TRYavasU
 * date: 02/08/2015
 */
class ElevatorLogic {
    def elevators
    def callerList = []
    Metric metric

    ElevatorLogic(maxFloor, numberOfElevators, metric) {
        def elevators = []
        numberOfElevators.times {
            elevators << new Elevator(maxFloor, it + 1, metric)
        }
        this.elevators = elevators
        this.metric = metric
    }

    void addPassengerToCallerList(def passenger, now) {
        callerList.add(passenger)
        metric.passengerCalledElevator(passenger, now)
    }

    void decideElevatorToEmbark(now) {
        callerList.each { Passenger caller ->
            def suitableElevator = findSuitableElevator(caller)
            if (suitableElevator) {
                suitableElevator.loadPassenger(caller, now)
                //println "Passenger with name : $caller.name has entered the elevator: $suitableElevator.id wants to go to floor: $caller.targetFloor"
                callerList -= caller
            }
        }
    }

    private Elevator findSuitableElevator(caller) {
        elevators.find { Elevator elevator ->
            caller.sourceFloor == elevator.currentFloor
            // && caller.desiredDirection() == elevator.direction
        }
    }

    def moveElevators() {
        //Add callers to passenger list as temporary
        if (callerList) {
            callerList.each { Passenger caller ->
                def possibleElevators = elevators.findAll { Elevator elevator ->
                    isGoingToTargetFloor(elevator, caller.sourceFloor)
                }
                if (possibleElevators) {
                    (possibleElevators.min { Elevator possibleElevator ->
                        (possibleElevator.currentFloor - caller.sourceFloor).abs()
                    } as Elevator).assignTemporaryPassenger(caller)
                }
            }
        }

        elevators.each { Elevator elevator ->
            def passengerList = elevator.passengerList
            if (passengerList) {
                if (elevator.direction == UP) {
                    if (passengerList.any { it.nextStep() > elevator.currentFloor }) {
                        elevator.move(UP)
                    } else {
                        elevator.move(DOWN)
                    }
                } else if (elevator.direction == DOWN) {
                    if (passengerList.any { it.nextStep() < elevator.currentFloor }) {
                        elevator.move(DOWN)
                    } else {
                        elevator.move(UP)
                    }
                } else {
                    def nextFloor = passengerList.min { (it.nextStep() - elevator.currentFloor).abs() }.nextStep()
                    if (nextFloor > elevator.currentFloor) {
                        //11
                        elevator.move(UP)
                    } else if (nextFloor < elevator.currentFloor) {
                        //12
                        elevator.move(DOWN)
                    } else {
                        //13
                        elevator.move(IMMOBILE)
                        //println "Problematic passenger wants to go same floor that is currently in"
                    }
                }
            } else {
                //Changing this logic doesn't help?!
                elevator.move(IMMOBILE)
            }
        }

        elevators.each { def elevator ->
            //println "Elevator $elevator.id is in floor: $elevator.currentFloor and it is going $elevator.direction"

            //Remove temporary callers from elevators
            elevator.passengerList.each { Passenger temporaryPassenger ->
                if (temporaryPassenger.isTemporary) {
                    elevator.passengerList -= temporaryPassenger
                }
            }
        }
    }

    private static boolean isGoingToTargetFloor(Elevator elevator, int targetFloor) {
        (elevator.currentFloor < targetFloor && elevator.direction == UP) || (elevator.currentFloor > targetFloor && elevator.direction == DOWN) || (elevator.direction == IMMOBILE) || !elevator.passengerList
    }
}