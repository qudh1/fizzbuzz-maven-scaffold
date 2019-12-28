public class FizzBuzz {

	private static final String FIZZ = "fizz";
	private static final String BUZZ = "buzz";

	public String done(final int num) {
		if ((num % 3 == 0)) {
			if ((num % 5 == 0)) {
				return BUZZ;
			} else {
				return FIZZ;
			}
		}
		return String.valueOf(num);
	}
}
