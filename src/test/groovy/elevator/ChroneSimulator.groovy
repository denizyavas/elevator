package elevator

import com.deniz.elevator.Chrone
import com.deniz.elevator.Passenger
import org.junit.Test

/**
 * author: TRYavasU
 * date: 01/08/2015
 */
class ChroneSimulator {

    final int MAX_TIME = 15
    final int MAX_FLOOR = 10
    final int NO_OF_PASSENGERS = 5

    // class variable
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    final Random rand = new Random();

    // consider using a Map<String,Boolean> to say whether the identifier is being used or not
    final Set<String> identifiers = new HashSet<String>();

    public String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
                if (identifiers.contains(builder.toString())) {
                    builder = new StringBuilder();
                }
            }
        }
        return builder.toString();
    }

    @Test
    void callElevatorInTimeTest() {
        Random rand = new Random()
        def passengers = []

        NO_OF_PASSENGERS.times {
            passengers << new Passenger(time: rand.nextInt(MAX_TIME + 1), sourceFloor: rand.nextInt(MAX_FLOOR + 1), targetFloor: rand.nextInt(MAX_FLOOR + 1), name: randomIdentifier())
        }

        Chrone chrone = new Chrone(MAX_FLOOR, passengers)

        println "PASSENGER MANIFEST"
        passengers.each {
            println it
        }

        while (chrone.elevator.passengerList || chrone.elevator.callerList || chrone.passengers) {
            chrone.passTime()
        }
    }

}
