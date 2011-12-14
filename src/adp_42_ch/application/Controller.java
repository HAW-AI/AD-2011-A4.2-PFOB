package adp_42_ch.application;

import static adp_42_ch.implementations.Images.*;

public class Controller {

	private Controller(){
		
	}
	
	static Controller create(){
		return new Controller();
	}
	
	public static void main(String[] args) {
		Controller controller=create();
		NewView view=new NewView();
                view.setVisible(true);
//		view.display(image(randomPoints(20, -200, 200, -200, 200).points()));
	}
}
