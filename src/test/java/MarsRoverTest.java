import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 *
 */
public class MarsRoverTest
{

	/**
	 *
	 */
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/**
	 *
	 */
	@Test
	public void shoudLandWithinTheArea()
	{
		final Area area = new Area(10, 10);
		final Rover rover = new Rover();
		rover.land(area, 5, 5, "N");

		final String position = rover.getPosition();
		assertThat(position).isEqualTo("55N");
	}

	/**
	 *
	 */
	@Test
	public void shoudLandOutOfTheArea()
	{
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("火星车不能降落在区域外");

		final Area area = new Area(10, 10);
		final Rover rover = new Rover();
		rover.land(area, 15, 5, "N");
	}

	/**
	 *
	 */
	@Test
	public void shoudMoveForward()
	{
		final Area area = new Area(10, 10);
		final Rover rover = new Rover();
		rover.land(area, 5, 5, "N");
		rover.move(2);

		final String position = rover.getPosition();
		assertThat(position).isEqualTo("57N");
	}

	/**
	 *
	 */
	@Test
	public void shoudTurnRight()
	{
		final Area area = new Area(10, 10);
		final Rover rover = new Rover();
		rover.land(area, 5, 5, "E");
		rover.turn("R");

		final String position = rover.getPosition();
		assertThat(position).isEqualTo("55S");
	}

	/**
	 *
	 */
	@Test
	public void shoudTurnMission()
	{
		final Rover rover = new Rover();
		final RoverController controller = new RoverController(rover);

		final String mission = "10,10,5,5,E,M,L,M,R";
		controller.excute(mission);

		final String position = rover.getPosition();
		assertThat(position).isEqualTo("66E");
	}
}
