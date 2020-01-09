package Bot;
import battlecode.common.*;

public class Headquarter extends Building {
    public Headquarter(RobotController rc, Direction[] dir) {
        super(rc, dir);
    }

    @Override
    public void run() throws GameActionException {
        super.run();
        for (Direction direction : dir)
            tryBuild(RobotType.MINER, direction);
    }
}