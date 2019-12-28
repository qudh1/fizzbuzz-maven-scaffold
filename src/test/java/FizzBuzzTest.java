import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FizzBuzzTest {

	private int num;
	private String result;

	public FizzBuzzTest(final int num, final String result) {
		this.num = num;
		this.result = result;
	}

	@Parameters
	public static List<Object[]> prepareData() {
		return Arrays.asList(new Object[][] { { 1, "1" }, { 3, "fizz" }, {15, "buzz"} });
	}

	@Test
	public void test() {
		assertThat(new FizzBuzz().done(num)).isEqualTo(result);
	}
}