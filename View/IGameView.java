package View;

/**
 * Created by DanyPatient on 14/03/2016.
 */
public interface IGameView {
    void drawMap(); //appel toutes les methodes sauf drawLogo

    void drawGoal();

    void drawGoalKeeper();

    void drawBall();

    void drawScore();

    void drawTime();

    void drawLogo();
}
