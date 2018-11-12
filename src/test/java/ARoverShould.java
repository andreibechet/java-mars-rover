import Rover.Rover;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ARoverShould {


    @Test
    @Parameters({
        "R, N, 0 0 E",
        "RR, N, 0 0 S",
        "RRR, N, 0 0 W",
        "RRRR, N, 0 0 N",
    })
    public void rotate_right(String commands, String startingDirection, String expectedPosition) {
        // starting 0 0 N
        Rover rover = new Rover(startingDirection);
        assertThat(rover.executeCommands(commands), is(expectedPosition));
    }

    @Test
    public void have_a_starting_position() throws Exception {
        String emptyCommands = "";
        String startingDirection = "E";
        Rover rover = new Rover(startingDirection);

        String expectedPosition = "0 0 " + startingDirection;
        assertThat(rover.executeCommands(emptyCommands), is(expectedPosition));
    }
}
