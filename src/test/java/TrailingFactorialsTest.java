import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrailingFactorialsTest {


    @Test
    public void testZeros() throws Exception {
        assertThat(TrailingFactorials.zeros(0), is(0));
        assertThat(TrailingFactorials.zeros(6), is(1));
        assertThat(TrailingFactorials.zeros(14), is(2));
        assertThat(TrailingFactorials.zeros(20), is(4));
        assertThat(TrailingFactorials.zeros(78), is(18));
        assertThat(TrailingFactorials.zeros(100), is(24));
    }
}