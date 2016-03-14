import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

//Oppgaver som gjenstår: Fikse kollisjonskode mellom ball og racket. Fjerne klosser når ball kolliderer
//og endre ballretning. Knytte Level knappene til brettet og indikere når bruker har fullført et nivå

public class PlayArea extends Application {
private Timeline detectCollisionBallAndRacket;
	@Override
	public void start(Stage primaryStage) {
		
//		lager sentrale objekter i spillet basert på andre klasser
		Pane ballAndRacketInCenter = new Pane();
		Ball ball = new Ball();
		Racket racket = new Racket();
		ballAndRacketInCenter.getChildren().addAll(ball, racket);
		
//		playArea er "main-pane". Alle andre panes legges til denne
		BorderPane playArea = new BorderPane();
		playArea.setTop(new BlockOfBricks());
		playArea.setCenter(ballAndRacketInCenter);
		playArea.setBottom(new ButtonsAndTimer());
	
		//kode for å få racket til å følge muspekeren i X-retning
		ballAndRacketInCenter.setOnMouseMoved(e -> {
			if (e.getX() < 5) {
				racket.setX(-10);
			}
			else if (e.getX() > 650) {
				racket.setX(640);
			}
			else {
				racket.setX(e.getX());
			}				
		});
				
//		kode for å øke/redusere ballhastighet med UP og DOWN keys, brukes til testing,
//		fjernes før endelig versjon
		ball.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				ball.increaseSpeed();
			}
			else if (e.getCode() == KeyCode.DOWN) {
				ball.decreaseSpeed();
			}
		});
		
//		kode for collision-detection between ball and racket
		detectCollisionBallAndRacket = new Timeline(new KeyFrame(Duration.millis(2), e -> isBallAndRacketColliding(ball, racket)));
		detectCollisionBallAndRacket.setCycleCount(Timeline.INDEFINITE);
		detectCollisionBallAndRacket.play();
	
		Scene scene = new Scene(playArea, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		ball.requestFocus();
		
	}
//	kode som brukes til å bestemme om ball og racket treffer hverandre. Virker bare delvis
	public void isBallAndRacketColliding(Ball ball, Racket racket) {
		
		if (racket.intersects(ball.getBoundsInLocal())) {
			ball.setY(330);
			ball.setDy(ball.getDy() * -1);
		}
	}
}
