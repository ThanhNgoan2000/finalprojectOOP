package run;


import controller.Controller;
import model.Board;
import model.Music;
import model.Player;

public class GameRunning {
     public static void main(String[] args)   {

    	 Music music = new Music();
    	 Board board = new Board();
    	 Player player = new Player();
		Controller ctrl = new Controller(board,player,music);
//		StartingGround starting = new StartingGround();
////		ctrl.showStarting();
//		ctrl.showView();
//		ctrl.turnMusic();
////        ctrl.offMusic();
	}
}
