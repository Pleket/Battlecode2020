package Bot;
import battlecode.common.*;

public strictfp class RobotPlayer {
    static RobotController rc;

    static Direction[] directions = {
            Direction.NORTH,
            Direction.NORTHEAST,
            Direction.EAST,
            Direction.SOUTHEAST,
            Direction.SOUTH,
            Direction.SOUTHWEST,
            Direction.WEST,
            Direction.NORTHWEST
    };

    static RobotType[] spawnedByMiner = {RobotType.REFINERY, RobotType.VAPORATOR, RobotType.DESIGN_SCHOOL,
            RobotType.FULFILLMENT_CENTER, RobotType.NET_GUN};

    static int turncount;

    /**
     * run() is the method that is called when a robot is instantiated in the Battlecode world.
     * If this method returns, the robot dies!
     **/
    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {
        RobotPlayer.rc = rc;
        Building building;
        Soldier unit;
        boolean soldier = false;
        turncount = 0;
        switch(rc.getType()) {
            case HQ:                 building = new Headquarter(rc, directions); unit = null;
            case MINER:              unit = new Miner(rc, directions, spawnedByMiner); building = null;
            case REFINERY:           building = new Refinery(rc, directions); unit = null;
            case VAPORATOR:          unit = new Vaporator(rc, directions); building = null;
            case DESIGN_SCHOOL:      building = new DesignSchool(rc, directions); unit = null;
            case FULFILLMENT_CENTER: building = new FulfillmentCenter(rc, directions); unit = null;
            case LANDSCAPER:         unit = new Landscaper(rc, directions); building = null;
            case DELIVERY_DRONE:     unit = new DeliveryDrone(rc, directions); building = null;
            case NET_GUN:            unit = new NetGun(rc, directions); building = null;
            default:                 unit = new Miner(rc, directions, spawnedByMiner); building = null;
        }
        System.out.println("I'm a " + rc.getType() + " and I just got created!");
        while(true) {
            turncount++;
            try {
                if (unit == null && building != null) {
                    building.run();
                } else {
                    unit.run();
                }
            } catch (Exception e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();
            }
        }
    }
}