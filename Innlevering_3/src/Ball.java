import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends Pane {

	public final double radius = 10;
	private double x = radius, y = radius;
	private double dx = 1, dy = 1;
	private Circle circle = new Circle(x, y, radius);
	private Timeline animation;
	
	public Ball() {
		circle.setFill(Color.BLUE);
		getChildren().add(circle);
		
		//animasjonskoden for moveBall er en modifisert utgave fra læreboken, kap. 15.12
		animation = new Timeline(new KeyFrame(Duration.millis(4), e -> moveBall()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getDy() {
		return dy;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}
	public double getY() {
		return y;
	}
	public double getX() {
		return x;
	}
	public void play() {
		animation.play();
	}
	public void pause() {
		animation.pause();
	}
	public void increaseSpeed() {
		animation.setRate(animation.getRate() + 0.1);
	}
	public void decreaseSpeed() {
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
	}
	public DoubleProperty rateProperty() {
		return animation.rateProperty();
	}
	protected void moveBall() {
		if (x < 10 || x > 700) {
			dx *= -1; 
		}
		if (y < -165 || y > 400) {
			dy *= -1;
		}
		x += dx;
		y += dy;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}		
}
	


