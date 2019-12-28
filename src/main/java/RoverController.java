/**
 *
 */
public class RoverController
{
	/**
	 * 验收信息
	 */
	private Rover rover;

	/**
	 * @param rover
	 */
	public RoverController(final Rover rover)
	{
		super();
		this.rover = rover;
	}

	/**
	 * @param mission
	 * @return the position
	 */
	public String excute(final String mission)
	{
		final String[] missions = mission.split(",");

		final int width = Integer.parseInt(missions[0]);
		final int length = Integer.parseInt(missions[1]);
		final Area area = new Area(width, length);

		final int x = Integer.parseInt(missions[2]);
		final int y = Integer.parseInt(missions[3]);
		final String direction = missions[4];
		rover.land(area, x, y, direction);

		for (int i = 5; i < missions.length; i++)
		{
			if ("M".equals(missions[i]))
			{
				rover.move(1);
			}
			if ("L".equals(missions[i]) || "R".equals(missions[i]))
			{
				rover.turn(missions[i]);
			}
		}

		return rover.getPosition();
	}
}
