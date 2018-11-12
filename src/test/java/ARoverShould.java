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
        "R, 0 0 E",
        "RR, 0 0 S",
        "RRR, 0 0 W",
        "RRRR, 0 0 N",
    })
    public void rotate_right(String commands, String expectedPosition) {
        // starting 0 0 N
        Rover rover = new Rover();
        assertThat(rover.executeCommands(commands), is(expectedPosition));
    }
}
