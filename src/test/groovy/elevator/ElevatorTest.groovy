package elevator

import com.deniz.elevator.Elevator
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

    Elevator elevator = new Elevator(10)

    @Test
    void test1() {
        elevator.direction = UP
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 7)
        ]
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test2() {
        Elevator elevator = new Elevator()
        elevator.direction = UP
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = [
                new Passenger(sourceFloor: 7)
        ]

        elevator.move()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test3() {
        Elevator elevator = new Elevator()
        elevator.direction = UP
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, IMMOBILE
        assertEquals elevator.currentFloor, 5
    }

    @Test
    void test4() {
        Elevator elevator = new Elevator()
        elevator.direction = UP
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 2)
        ]
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test5() {
        Elevator elevator = new Elevator()
        elevator.direction = UP
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = [
                new Passenger(sourceFloor: 3)
        ]

        elevator.move()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }


    @Test
    void test6() {
        Elevator elevator = new Elevator()
        elevator.direction = DOWN
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 3)
        ]
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test7() {
        Elevator elevator = new Elevator()
        elevator.direction = DOWN
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = [
                new Passenger(sourceFloor: 3)
        ]

        elevator.move()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test8() {
        Elevator elevator = new Elevator()
        elevator.direction = DOWN
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, IMMOBILE
        assertEquals elevator.currentFloor, 5
    }

    @Test
    void test9() {
        Elevator elevator = new Elevator()
        elevator.direction = DOWN
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 8)
        ]
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test10() {
        Elevator elevator = new Elevator()
        elevator.direction = DOWN
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = [
                new Passenger(sourceFloor: 9)
        ]

        elevator.move()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test11() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 8),
                new Passenger(targetFloor: 1)
        ]
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test12() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 9),
                new Passenger(targetFloor: 2)
        ]
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test13() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 5)
        ]
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, IMMOBILE
        assertEquals elevator.currentFloor, 5
    }

    @Test
    void test14() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = [
                new Passenger(sourceFloor: 8),
                new Passenger(sourceFloor: 1)
        ]

        elevator.move()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test15() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = [
                new Passenger(sourceFloor: 9),
                new Passenger(sourceFloor: 2)
        ]

        elevator.move()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test16() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = [
                new Passenger(sourceFloor: 5)
        ]

        elevator.move()

        assertEquals elevator.direction, IMMOBILE
        assertEquals elevator.currentFloor, 5
    }

    @Test
    void test17() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, IMMOBILE
        assertEquals elevator.currentFloor, 5
    }

    @Test
    void test18() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 9),
                new Passenger(targetFloor: 1)
        ]
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }

    @Test
    void test19() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = [
                new Passenger(targetFloor: 1),
                new Passenger(targetFloor: 9)
        ]
        elevator.callerList = []

        elevator.move()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }

    @Test
    void test20() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = [
                new Passenger(sourceFloor: 9),
                new Passenger(sourceFloor: 1)
        ]

        elevator.move()

        assertEquals elevator.direction, UP
        assertEquals elevator.currentFloor, 6
    }


    @Test
    void test21() {
        Elevator elevator = new Elevator()
        elevator.direction = IMMOBILE
        elevator.currentFloor = 5

        elevator.passengerList = []
        elevator.callerList = [
                new Passenger(sourceFloor: 1),
                new Passenger(sourceFloor: 9)
        ]

        elevator.move()

        assertEquals elevator.direction, DOWN
        assertEquals elevator.currentFloor, 4
    }
}
