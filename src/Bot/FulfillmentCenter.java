package Bot;
import battlecode.common.*;

public class FulfillmentCenter extends Building {
    public FulfillmentCenter(RobotController rc, Direction[] dir) {
        super(rc, dir);
    }
    
    public void run() throws GameActionException {
        for (Direction direction : dir)
            tryBuild(RobotType.DELIVERY_DRONE, direction);
    }
}
