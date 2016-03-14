import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ButtonsAndTimer extends HBox {

	ButtonsAndTimer() {
		super();
		Label lvl1 = new Label("Level 1");
		lvl1.setFont(Font.font(20));
		Label lvl2 = new Label("Level 2");
		lvl2.setFont(Font.font(20));
		Label lvl3 = new Label("Level 3");
		lvl3.setFont(Font.font(20));

		super.getChildren().addAll(lvl1, lvl2, lvl3);
		super.setSpacing(15);
		super.setAlignment(Pos.TOP_LEFT);
		super.setPadding(new Insets(0, 0, 50, 50));
	}
}
