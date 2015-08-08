package elevator

import com.deniz.elevator.Elevator
import com.deniz.elevator.ElevatorLogic
import com.deniz.elevator.Metric

import static com.deniz.elevator.Elevator.Direction.UP
import static com.deniz.elevator.Elevator.Direction.DOWN
import static com.deniz.elevator.Elevator.Direction.IMMOBILE
import com.deniz.elevator.Passenger
import org.junit.Test
import static org.junit.Assert.assertEquals

/**
 * author: TRYavasU
 * date: 02/08/2015
 */
class ElevatorTest {

    Metric metric = new Metric(null)
    ElevatorLogic elevatorLogic = new ElevatorLogic(10, 1, metric)
    Elevator elevator = elevatorLogic.elevators.get(0)

    @Test
    void test1() {
        elevator.direction = UP
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 7)
        ]
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test2() {
        elevator.direction = UP
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = [
                new Passenger(sourceFloor: 7)
        ]

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test3() {
        elevator.direction = UP
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test4() {
        elevator.direction = UP
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 2)
        ]
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test5() {
        elevator.direction = UP
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = [
                new Passenger(sourceFloor: 3)
        ]

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }


    @Test
    void test6() {
        elevator.direction = DOWN
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 3)
        ]
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test7() {
        elevator.direction = DOWN
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = [
                new Passenger(sourceFloor: 3)
        ]

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test8() {
        elevator.direction = DOWN
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test9() {
        elevator.direction = DOWN
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 8)
        ]
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test10() {
        elevator.direction = DOWN
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = [
                new Passenger(sourceFloor: 9)
        ]

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test11() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 8),
                new Passenger(targetFloor: 1)
        ]
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test12() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 9),
                new Passenger(targetFloor: 2)
        ]
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test13() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 5)
        ]
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, IMMOBILE
        assertEquals elevator.currentFloor, 5
    }

    @Test
    void test14() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = [
                new Passenger(sourceFloor: 8),
                new Passenger(sourceFloor: 1)
        ]

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test15() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = [
                new Passenger(sourceFloor: 9),
                new Passenger(sourceFloor: 2)
        ]

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test16() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = [
                new Passenger(sourceFloor: 5)
        ]

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, IMMOBILE
        assertEquals elevator.currentFloor, 5
    }

    @Test
    void test17() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test18() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 9),
                new Passenger(targetFloor: 1)
        ]
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test19() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 1),
                new Passenger(targetFloor: 9)
        ]
        elevatorLogic.callerList = []

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test20() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = [
                new Passenger(sourceFloor: 9),
                new Passenger(sourceFloor: 1)
        ]

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }


    @Test
    void test21() {
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevatorLogic.callerList = [
                new Passenger(sourceFloor: 1),
                new Passenger(sourceFloor: 9)
        ]

        elevatorLogic.moveElevators()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }
}
