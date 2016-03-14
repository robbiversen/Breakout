import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BlockOfBricks extends GridPane {

	BlockOfBricks() {
		super();
		super.setAlignment(Pos.CENTER);
		super.setHgap(1);
		super.setVgap(1);
		
		//lager 120 blokker, farge basert på radindeks, legg til i gridpane
		for (int row = 0; row < 10; row++) {
			for (int column = 0; column < 15; column++) {
				Rectangle r1 = new Rectangle(35, 17);
				if (row < 3) {
					r1.setFill(Color.RED);
				}
				else if (row < 6) {
					r1.setFill(Color.GREEN);
				}
				else {
					r1.setFill(Color.BLUE);
				}
				super.add(r1, column, row);
			}
		}
		//fjerne 20 tilfeldige brikker
		int[] placeHolderToKeep20RandomValues = new int[20]; 
		int counter = 0;
		while (counter <= 19) {
			int number = (int)(Math.random() * (150 - counter));
			if (checkIfNumberIsUniqueInArray(number, placeHolderToKeep20RandomValues)) {
				placeHolderToKeep20RandomValues[counter] = number;
				counter++;
				super.getChildren().remove(number);
			}
		}
	}
//	metode som brukes for å fjerne 20 tilfeldige brikker
	private static final boolean checkIfNumberIsUniqueInArray(int number, int[] array) {
		for (int i = 0; i < array.length; i ++) {
			if (array[i] == number) {
				return false;
			}
		}
		return true;
	}
}


