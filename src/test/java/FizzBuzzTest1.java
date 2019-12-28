import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FizzBuzzTest1 {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test_le_0() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Invalid input");
		assertThat(new FizzBuzz().done(-1)).isEqualTo("-1");
	}
}