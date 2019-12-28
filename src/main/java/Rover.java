import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author Lenovo
 *
 */
public class Rover
{
	/**
	 * 方向: 东
	 */
	private static final String EAST = "E";
	/**
	 * 方向: 西
	 */
	private static final String WEAST = "W";
	/**
	 * 方向: 南
	 */
	private static final String SOUTH = "S";
	/**
	 * 方向: 北
	 */
	private static final String NORTH = "N";

	/**
	 * 转向: 左
	 */
	private static final String TURN_LEFT = "L";
	/**
	 * 转向: 右
	 */
	private static final String TURN_RIGHT = "R";

	/**
	 * 探索区域
	 */
	private Area area;
	/**
	 * 降落地点的x坐标
	 */
	private int locationX;
	/**
	 * 降落地点的y坐标
	 */
	private int locationY;
	/**
	 * 朝向信息(N、S、E、W)
	 */
	private String direction;

	/**
	 * 朝向集合
	 */
	private static final Set<String> DIRECTIONS = new HashSet<String>(6);
	static
	{
		DIRECTIONS.add(EAST);
		DIRECTIONS.add(WEAST);
		DIRECTIONS.add(NORTH);
		DIRECTIONS.add(SOUTH);
	}

	/**
	 * 朝向集合
	 */
	private static final Set<String> TURN_DIRECTIONS = new HashSet<String>(2);
	static
	{
		TURN_DIRECTIONS.add(TURN_LEFT);
		TURN_DIRECTIONS.add(TURN_RIGHT);
	}

	/**
	 * 转向缓存
	 */
	private static final Map<String, String> TURN_DIRECTION_CACHE = new HashMap<String, String>(11);
	static
	{
		TURN_DIRECTION_CACHE.put("EL", "N");
		TURN_DIRECTION_CACHE.put("ER", "S");

		TURN_DIRECTION_CACHE.put("WL", "S");
		TURN_DIRECTION_CACHE.put("WR", "N");

		TURN_DIRECTION_CACHE.put("NL", "W");
		TURN_DIRECTION_CACHE.put("NR", "E");

		TURN_DIRECTION_CACHE.put("SL", "E");
		TURN_DIRECTION_CACHE.put("SR", "W");
	}

	/**
	 * @param area
	 * @param locationX
	 * @param locationY
	 * @param direction
	 */
	public void land(final Area area, final int locationX, final int locationY, final String direction)
	{
		this.area = area;

		if (area.getWidth() <= 0 || area.getLength() <= 0)
		{
			throw new IllegalArgumentException("降落区域的长度或宽度非法");
		}

		if (locationX > area.getLength() || locationY > area.getWidth())
		{
			throw new IllegalArgumentException("火星车不能降落在区域外");
		}

		this.locationX = locationX;
		this.locationY = locationY;
		this.direction = direction;
	}

	/**
	 * 移动
	 *
	 * @param moveDistance
	 */
	public void move(final int moveDistance)
	{
		if (moveDistance > area.getLength() || moveDistance > area.getWidth())
		{
			throw new IllegalArgumentException("火星车不能移动到区域外");
		}

		if (!DIRECTIONS.contains(direction))
		{
			throw new IllegalArgumentException("未知的转向指令");
		}

		if (NORTH.equals(direction))
		{
			final int y = locationY + moveDistance;
			if (y > area.getWidth())
			{
				throw new IllegalArgumentException("火星车不能移动到区域外");
			}
			this.locationY = y;
		}

		if (SOUTH.equals(direction))
		{
			final int y = locationY - moveDistance;
			if (y < 0)
			{
				throw new IllegalArgumentException("火星车不能移动到区域外");
			}
			this.locationY = y;
		}

		if (EAST.equals(direction))
		{
			final int x = locationX + moveDistance;
			if (x > area.getLength())
			{
				throw new IllegalArgumentException("火星车不能移动到区域外");
			}
			this.locationX = x;
		}

		if (WEAST.equals(direction))
		{
			final int x = locationX - moveDistance;
			if (x < 0)
			{
				throw new IllegalArgumentException("火星车不能移动到区域外");
			}
			this.locationX = x;
		}
	}

	/**
	 * @param turnDirection
	 */
	public void turn(final String turnDirection)
	{
		if (turnDirection == null || turnDirection.length() <= 0)
		{
			throw new IllegalArgumentException("必须指定转向");
		}

		if (!TURN_DIRECTIONS.contains(turnDirection))
		{
			throw new IllegalArgumentException("未知的转向");
		}

		this.direction = TURN_DIRECTION_CACHE.get(this.direction + turnDirection);
	}

	/**
	 * @return the postion
	 */
	public String getPosition()
	{
		final StringBuilder builder = new StringBuilder();
		builder.append(locationX);
		builder.append(locationY);
		builder.append(direction);
		return builder.toString();
	}
}
