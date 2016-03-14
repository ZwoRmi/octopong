package Controller;

/**
 * Created by Lucas on 14/03/2016.
 */
public interface IBallEngine {
    // mon constructeur prend une map en param
    void move();
    void generateBall(); // ajouter une ball a map en lui settant une direction random
}
