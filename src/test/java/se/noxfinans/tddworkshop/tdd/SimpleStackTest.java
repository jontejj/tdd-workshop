package se.noxfinans.tddworkshop.tdd;

import org.fest.assertions.Assertions;
import org.junit.Test;
import se.noxfinans.tddworkshop.SimpleStackImpl;

public class SimpleStackTest
{
    @Test
    public void testApp()
    {
		Assertions.assertThat(new SimpleStackImpl().size()).isEqualTo(0);
    }
}
