package task2;

public class Main {

    public static void main(String[] args) {
        Robot rob = new Robot();
        //Your code here
        findExit(new int[][]{}, rob, new int[]{0, 0});
    }

    /*
     * Provided mock solution for building robot path.
     * Robot is moving recursively through all possible variants of a path
     * */
    public static void findExit(int[][] maze, Robot robot, int[] startPoint) {
        while (!robot.hasExited()) {
            if (robot.isPathClear()) {
                robot.moveForward();
            } else {
                robot.turnLeft();
                boolean wayFound = false;
                for (int i = 0; i < 3; i++) {
                    //check the way left and right
                    //skip the step when robot turns back
                    if (i != 1) {
                        robot.turnLeft();
                        if (robot.isPathClear()) {
                            wayFound = true;
                            robot.moveForward();
                            startPoint[0] = i == 0 ? i - 1 : i + 1;
                            findExit(maze, robot, startPoint);
                        }
                    }
                }
                //break if the way is wrong
                if (!wayFound) {
                    break;
                }
            }
        }
    }

}
