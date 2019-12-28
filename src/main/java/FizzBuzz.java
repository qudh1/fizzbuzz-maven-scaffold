public class FizzBuzz {

	private static final String FIZZ = "Fizz"; // 被3整除
	private static final String BUZZ = "Buzz"; // 被5整除
	private static final String WHIZZ = "Whizz"; // 被7整除

	public String done(final int num) {
		if (num <= 0) {
			throw new IllegalArgumentException("Invalid input");
		}

		final StringBuilder builder = new StringBuilder();
		if (num % 3 == 0) {
			builder.append(FIZZ);
		}

		if (num % 5 == 0) {
			builder.append(BUZZ);
		}

		if (num % 7 == 0) {
			builder.append(WHIZZ);
		}

		if (builder.length() > 0)
		{
			return builder.toString();
		}

		return String.valueOf(num);
	}
}
