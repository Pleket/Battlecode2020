package Bot;
import battlecode.common.*;

public class Miner extends Soldier {
    RobotType[] spawnedByMiner;

    Miner(RobotController rc, Direction[] dir, RobotType[] spawnedByMiner) {
        super(rc, dir);
        this.spawnedByMiner = spawnedByMiner;
    }

    // Many of these auxiliary methods links to methods in Soldier.java. Only specific implementations go here
    @Override
    public void run() throws GameActionException {
        super.run();
        tryBlockchain();
        tryMove(randomDirection());
        if (tryMove(randomDirection()))
            System.out.println("I moved!");
        // tryBuild(randomSpawnedByMiner(), randomDirection());
        for (Direction direction : dir)
            super.tryBuild(RobotType.FULFILLMENT_CENTER, direction);
        for (Direction direction : dir)
            if (tryRefine(direction))
                System.out.println("I refined soup! " + rc.getTeamSoup());
        for (Direction direction : dir)
            if (tryMine(direction))
                System.out.println("I mined soup! " + rc.getSoupCarrying());
    }
}