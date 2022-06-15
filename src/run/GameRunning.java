package run;


import controller.Controller;

public class GameRunning {
     public static void main(String[] args)   {
		Controller ctrl = new Controller();
		ctrl.showView();
		ctrl.turnMusic();
	}
}
