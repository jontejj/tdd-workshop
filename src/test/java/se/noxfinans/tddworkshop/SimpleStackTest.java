package se.noxfinans.tddworkshop;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class SimpleStackTest
{
    @Test
    public void testApp()
    {
		Assertions.assertThat(new SimpleStackImpl().size()).isEqualTo(0);
    }
}
