package Controller;

/**
 * Created by Lucas on 14/03/2016.
 */
public interface IGoalEngine {
    //mon constructeur prend une Map en param
    void move(); // faire bouger le goal vers sa target position
    void checkBallInDetectionArea();
    void goalDetection(); // détecter si il y a un but
    void onGoal(); // appeler updateScore et faire disparaitre la balle (supprimer de l'arraylist de balls dans objet map)
    void updateScore(); //score++
    void calculateBallTargetPosition();
    void centerGoalKeeper(); // si pas de balle dans la zone et que targetPosition == actualPosition alors set la targetPosition
    void initMap(); //initialiliser la map
}
