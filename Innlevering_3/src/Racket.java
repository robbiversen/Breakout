import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Racket extends Rectangle {
//	boolean collisionBetweenRacketAndBall = false;
//	protected Timeline collisionBetweenRacketAndBallTimeline;
	
	Racket() {
		super(70, 10);
		super.setFill(Color.CORAL);
		super.setX(300);
		super.setY(350);
	}
}
