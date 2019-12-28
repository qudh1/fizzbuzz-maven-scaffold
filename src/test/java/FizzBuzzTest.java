import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FizzBuzzTest {
	private static final String FIZZ = "Fizz"; // 被3整除
	private static final String BUZZ = "Buzz"; // 被5整除
	private static final String WHIZZ = "Whizz"; // 被7整除

	private static final String FIZZ_BUZZ = "FizzBuzz"; // 被3和5整除
	private static final String FIZZ_WHIZZ = "FizzWhizz"; // 被3和7整除
	private static final String BUZZ_WHIZZ = "BuzzWhizz"; // 被5和7整除

	private static final String FIZZ_BUZZ_WHIZZ = "FizzBuzzWhizz"; // 被3、5和7整除

	private int num;
	private String result;

	public FizzBuzzTest(final int num, final String result) {
		this.num = num;
		this.result = result;
	}

	@Parameters
	public static List<Object[]> prepareData() {
		return Arrays.asList(new Object[][] {{ 1, "1" }, { 3, FIZZ }, {15, FIZZ_BUZZ} });
	}

	@Test
	public void test() {
		assertThat(new FizzBuzz().done(num)).isEqualTo(result);
	}
}