package Model;

/**
 * Created by Lucas on 22/03/2016.
 */
public class BallToBallReboundCalculator {
    private Ball ball;
    private Ball otherBall;

    public BallToBallReboundCalculator(Ball ball, Ball otherBall) {
        this.ball = ball;
        this.otherBall = otherBall;
    }

    public void updateDirections() {
        Position newDirectionBall = new Position();
        newDirectionBall.setX((ball.getDirection().getX()*(ball.getMass()-otherBall.getMass())+(2*otherBall.getMass()*otherBall.getDirection().getX()))/(ball.getMass()+otherBall.getMass()));
        newDirectionBall.setY((ball.getDirection().getY()*(ball.getMass()-otherBall.getMass())+(2*otherBall.getMass()*otherBall.getDirection().getY()))/(ball.getMass()+otherBall.getMass()));
        Position newDirectionOtherBall = new Position();
        newDirectionOtherBall.setX((otherBall.getDirection().getX()*(otherBall.getMass()-ball.getMass())+(2*ball.getMass()*ball.getDirection().getX()))/(otherBall.getMass()+ball.getMass()));
        newDirectionOtherBall.setY((otherBall.getDirection().getY()*(otherBall.getMass()-ball.getMass())+(2*ball.getMass()*ball.getDirection().getY()))/(otherBall.getMass()+ball.getMass()));
        ball.setDirection(newDirectionBall);
        otherBall.setDirection(newDirectionOtherBall);
    }
}
