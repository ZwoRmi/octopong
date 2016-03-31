package Model;

public class BallToBallReboundCalculator {
    private final Ball ball;
    private final Ball otherBall;

    public BallToBallReboundCalculator(Ball ball, Ball otherBall) {
        this.ball = ball;
        this.otherBall = otherBall;
    }

    public void updateDirections() {
        Position newDirectionBall = new Position();
        newDirectionBall.setX((this.ball.getDirection().getX() * (this.ball.getMass() - this.otherBall.getMass()) +
                (2 * this.otherBall.getMass() * this.otherBall.getDirection().getX())) / (this.ball.getMass() + this
                .otherBall.getMass()));
        newDirectionBall.setY((this.ball.getDirection().getY() * (this.ball.getMass() - this.otherBall.getMass()) +
                (2 * this.otherBall.getMass() * this.otherBall.getDirection().getY())) / (this.ball.getMass() + this
                .otherBall.getMass()));
        Position newDirectionOtherBall = new Position();
        newDirectionOtherBall.setX((this.otherBall.getDirection().getX() * (this.otherBall.getMass() - this.ball
                .getMass()) + (2 * this.ball.getMass() * this.ball.getDirection().getX())) / (this.otherBall.getMass
                () + this.ball.getMass()));
        newDirectionOtherBall.setY((this.otherBall.getDirection().getY() * (this.otherBall.getMass() - this.ball
                .getMass()) + (2 * this.ball.getMass() * this.ball.getDirection().getY())) / (this.otherBall.getMass
                () + this.ball.getMass()));
        this.ball.setDirection(newDirectionBall);
        this.otherBall.setDirection(newDirectionOtherBall);
    }
}
