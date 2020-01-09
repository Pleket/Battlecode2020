package Bot;
import battlecode.common.*;

public class Building {
    RobotController rc;
    
    Direction[] dir;
    
    static int turnCount;

    Building(RobotController rc, Direction[] dir) {
        this.rc = rc;
        this.dir = dir;
    }

    public void run() throws GameActionException {
        System.out.println("This does nothing");
    }

    /**
     * Attempts to build a given robot in a given direction.
     *
     * @param type The type of the robot to build
     * @param dir The intended direction of movement
     * @return true if a move was performed
     * @throws GameActionException
     */
    public boolean tryBuild(RobotType type, Direction dir) throws GameActionException {
        if (rc.isReady() && rc.canBuildRobot(type, dir)) {
            rc.buildRobot(type, dir);
            return true;
        } else return false;
    }
}