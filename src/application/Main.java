package application;
	
import java.math.BigDecimal;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import java.math.RoundingMode;


public class Main extends Application {
	private int canvasHeight;
	private int canvasWidth;
	
	public Main() {
		canvasHeight = 400;
		canvasWidth = 600;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root);
			Canvas canvas = new Canvas(canvasWidth, canvasHeight);
			PixelWriter pw = canvas.getGraphicsContext2D().getPixelWriter();
			drawShapes(pw);
			root.getChildren().add(canvas);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("mandelbrød bby");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void drawShapes(PixelWriter pw) {
		BigDecimal squareSum = new BigDecimal(0);
		BigDecimal normalSquareSum = new BigDecimal(0);
		//BigDecimal squareSumDivisor = new BigDecimal(Math.pow(canvasWidth + canvasHeight, 2));
		BigDecimal squareSumDivisor = new BigDecimal(3922);
		for (int i = 0; i < canvasWidth; i++) {
			for (int j = 0; j < canvasHeight; j++) {
				//squareSum = new BigDecimal(i + j).pow(2).divide(squareSumDivisor, RoundingMode.DOWN);
				//pw.setColor(i, j, Color.rgb(Math.round(i/2.36f), squareSum.intValue(), Math.round(j/1.57f), 1));
				pw.setColor(i, j, mandelCalc(i, j));
			}
		}
	}
	
	private Color mandelCalc(int x, int y) {
		int iterasjoner = 0;
		ComplexNumber z = new ComplexNumber(0, 0);
		// TODO: skaler til x i (-3, 1) og y i (-1.5, 1) elns
		ComplexNumber c = new ComplexNumber(x/200d - 2d, y/-200d + 1d);
		while (c.abs() <= 2 && iterasjoner < 2) {
			z = z.sqr().add(c);
			iterasjoner += 1;
		}
		return Color.rgb(Math.round(iterasjoner*100), 0, 0, 1.0);
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
