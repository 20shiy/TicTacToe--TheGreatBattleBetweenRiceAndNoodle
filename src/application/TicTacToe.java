package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class TicTacToe extends Application {

	Pane pane = new Pane();
	
	boolean[] isFilled = new boolean[9];

	// create an array to simulate board situation. '1' will be x and '2' will be o
	int[] boardSituation = new int[9];

	@Override
	public void start(Stage stage) throws Exception {

		pane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		Scene scene = new Scene(pane, 600, 630);

		stage.setTitle("Tic Tac Toe -- The Great Battle Between Rice And Noodle");
		stage.setScene(scene);
		stage.setResizable(false);
		
		Button restart = new Button("RESTART");
		restart.setLayoutX(270);
		restart.setLayoutY(604);
		pane.getChildren().add(restart);
		
		resetHandlerClass reset = new resetHandlerClass();
		restart.setOnAction(reset);

		// create the game board using rectangle
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Rectangle tile = new Rectangle(i * 200, j * 200, 200, 200);
				tile.setStroke(Color.WHITE);
				tile.setStrokeWidth(3);
				tile.setFill(Color.TRANSPARENT);

				pane.getChildren().add(tile);
			}
		}

		// what will happened if the game board is clicked
		pane.setOnMouseClicked(new mouseEventHandler());

		stage.show();
	}
	
	// reset the game board
	class resetHandlerClass implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			for(int i=0; i<boardSituation.length; i++) {
				boardSituation[i] = 0;
			}
			for(int i=0; i<isFilled.length; i++) {
				isFilled[i] = false;
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					Rectangle tile = new Rectangle(i * 200, j * 200, 200, 200);
					tile.setStroke(Color.WHITE);
					tile.setStrokeWidth(3);
					tile.setFill(Color.LIGHTBLUE);

					pane.getChildren().add(tile);
				}
			}
			
		}
		
	}

	// event handler class
	class mouseEventHandler implements EventHandler<MouseEvent> {
		boolean drawX = true;
		

		// import image
		Image rice = new Image("rice.png");
		Image noodle = new Image("noodle.png");

//		ImageView riceView = new ImageView(rice);
//		ImageView noodleView = new ImageView(noodle);

		@Override
		public void handle(MouseEvent e) {
			if (e.getButton() == MouseButton.PRIMARY) {
				if (e.getX() <= 200) { // check the x position and if the tile is filled
					if (e.getY() <= 200 && isFilled[0] == false) { // check the y position
						if (drawX) {// check if we should draw x
							// Text x = new Text(100, 100, "X");
							ImageView x = new ImageView(rice);
							x.setFitHeight(100);
							x.setFitWidth(100);
							x.setX(50);
							x.setY(50);
							pane.getChildren().add(x);
							drawX = false;
							isFilled[0] = true;
							boardSituation[0] = 1;
						} else {// draw o
							// Text o = new Text(100, 100, "O");
							ImageView o = new ImageView(noodle);
							o.setFitHeight(150);
							o.setFitWidth(150);
							o.setX(30);
							o.setY(30);
							pane.getChildren().add(o);
							isFilled[0] = true;
							drawX = true;
							boardSituation[0] = 2;
						}
						// ^ 0th tile
					} else if (e.getY() > 200 && e.getY() <= 400 && isFilled[3] == false) {
						if (drawX) {
							// Text x = new Text(100, 300, "X");
							ImageView x = new ImageView(rice);
							x.setFitHeight(100);
							x.setFitWidth(100);
							x.setX(50);
							x.setY(250);
							pane.getChildren().add(x);
							drawX = false;
							isFilled[3] = true;
							boardSituation[3] = 1;
						} else {
							// Text o = new Text(100, 300, "O");
							ImageView o = new ImageView(noodle);
							o.setFitHeight(150);
							o.setFitWidth(150);
							o.setX(30);
							o.setY(230);
							pane.getChildren().add(o);
							isFilled[3] = true;
							drawX = true;
							boardSituation[3] = 2;
						}
						// ^ 3rd tile
					} else if (e.getY() > 400 && isFilled[6] == false) {
						if (drawX) {
							// Text x = new Text(100, 500, "X");
							ImageView x = new ImageView(rice);
							x.setFitHeight(100);
							x.setFitWidth(100);
							x.setX(50);
							x.setY(450);
							pane.getChildren().add(x);
							drawX = false;
							isFilled[6] = true;
							boardSituation[6] = 1;
						} else {
							// Text o = new Text(100, 500, "O");
							ImageView o = new ImageView(noodle);
							o.setFitHeight(150);
							o.setFitWidth(150);
							o.setX(30);
							o.setY(430);
							pane.getChildren().add(o);
							isFilled[6] = true;
							drawX = true;
							boardSituation[6] = 2;
						}
						// ^6th tile
					}
					// ^ 1st column
				} else if (e.getX() <= 400) {
					if (e.getY() <= 200 && isFilled[1] == false) { // check the y position
						if (drawX) {// check if we should draw x
							// Text x = new Text(300, 100, "X");
							ImageView x = new ImageView(rice);
							x.setFitHeight(100);
							x.setFitWidth(100);
							x.setX(250);
							x.setY(50);
							pane.getChildren().add(x);
							drawX = false;
							isFilled[1] = true;
							boardSituation[1] = 1;
						} else {// draw o
							// Text o = new Text(300, 100, "O");
							ImageView o = new ImageView(noodle);
							o.setFitHeight(150);
							o.setFitWidth(150);
							o.setX(230);
							o.setY(30);
							pane.getChildren().add(o);
							isFilled[1] = true;
							drawX = true;
							boardSituation[1] = 2;
						}
						// ^ 1st tile
					} else if (e.getY() > 200 && e.getY() <= 400 && isFilled[4] == false) {
						if (drawX) {
							// Text x = new Text(300, 300, "X");
							ImageView x = new ImageView(rice);
							x.setFitHeight(100);
							x.setFitWidth(100);
							x.setX(250);
							x.setY(250);
							pane.getChildren().add(x);
							drawX = false;
							isFilled[4] = true;
							boardSituation[4] = 1;
						} else {
							// Text o = new Text(300, 300, "O");
							ImageView o = new ImageView(noodle);
							o.setFitHeight(150);
							o.setFitWidth(150);
							o.setX(230);
							o.setY(230);
							pane.getChildren().add(o);
							isFilled[4] = true;
							drawX = true;
							boardSituation[4] = 2;
						}
						// ^ 4th tile
					} else if (e.getY() > 400 && isFilled[7] == false) {
						if (drawX) {
							// Text x = new Text(300, 500, "X");
							ImageView x = new ImageView(rice);
							x.setFitHeight(100);
							x.setFitWidth(100);
							x.setX(250);
							x.setY(450);
							pane.getChildren().add(x);
							drawX = false;
							isFilled[7] = true;
							boardSituation[7] = 1;
						} else {
							// Text o = new Text(300, 500, "O");
							ImageView o = new ImageView(noodle);
							o.setFitHeight(150);
							o.setFitWidth(150);
							o.setX(230);
							o.setY(430);
							pane.getChildren().add(o);
							isFilled[7] = true;
							drawX = true;
							boardSituation[7] = 2;
						}
						// ^ 7th tile
					}
					// ^ 2nd column
				} else {
					if (e.getY() <= 200 && isFilled[2] == false) { // check the y position
						if (drawX) {// check if we should draw x
							// Text x = new Text(500, 100, "X");
							ImageView x = new ImageView(rice);
							x.setFitHeight(100);
							x.setFitWidth(100);
							x.setX(450);
							x.setY(50);
							pane.getChildren().add(x);
							drawX = false;
							isFilled[2] = true;
							boardSituation[2] = 1;
						} else {// draw o
							// Text o = new Text(500, 100, "O");
							ImageView o = new ImageView(noodle);
							o.setFitHeight(150);
							o.setFitWidth(150);
							o.setX(430);
							o.setY(30);
							pane.getChildren().add(o);
							isFilled[2] = true;
							drawX = true;
							boardSituation[2] = 2;
						}
						// ^ 2nd tile
					} else if (e.getY() > 200 && e.getY() <= 400 && isFilled[5] == false) {
						if (drawX) {
							// Text x = new Text(500, 300, "X");
							ImageView x = new ImageView(rice);
							x.setFitHeight(100);
							x.setFitWidth(100);
							x.setX(450);
							x.setY(250);
							pane.getChildren().add(x);
							drawX = false;
							isFilled[5] = true;
							boardSituation[5] = 1;
						} else {
							// Text o = new Text(500, 300, "O");
							ImageView o = new ImageView(noodle);
							o.setFitHeight(150);
							o.setFitWidth(150);
							o.setX(430);
							o.setY(230);
							pane.getChildren().add(o);
							isFilled[5] = true;
							drawX = true;
							boardSituation[5] = 2;
						}
						// ^ 5th tile
					} else if (e.getY() > 400 && isFilled[8] == false) {
						if (drawX) {
							// Text x = new Text(500, 500, "X");
							ImageView x = new ImageView(rice);
							x.setFitHeight(100);
							x.setFitWidth(100);
							x.setX(450);
							x.setY(450);
							pane.getChildren().add(x);
							drawX = false;
							isFilled[8] = true;
							boardSituation[8] = 1;
						} else {
							// Text o = new Text(500, 500, "O");
							ImageView o = new ImageView(noodle);
							o.setFitHeight(150);
							o.setFitWidth(150);
							o.setX(430);
							o.setY(430);
							pane.getChildren().add(o);
							isFilled[8] = true;
							drawX = true;
							boardSituation[8] = 2;
						}
						// ^ 8th tile
					}
					// ^ 3rd column
				}
			}

			// check the row
			boolean row = false;
			for (int i = 0; i < boardSituation.length; i += 3) {
				if (boardSituation[i] != 0 && boardSituation[i] == boardSituation[i + 1]
						&& boardSituation[i] == boardSituation[i + 2]) {
					if (i == 0) {
						Line line = new Line(100, 100, 500, 100);
						line.setStroke(Color.WHITE);
						line.setStrokeWidth(6);
						pane.getChildren().add(line);
					} else if (i == 3) {
						Line line = new Line(100, 300, 500, 300);
						line.setStroke(Color.WHITE);
						line.setStrokeWidth(6);
						pane.getChildren().add(line);
					} else {
						Line line = new Line(100, 500, 500, 500);
						line.setStroke(Color.WHITE);
						line.setStrokeWidth(6);
						pane.getChildren().add(line);
					}
					for (int j = 0; j < isFilled.length; j++) {
						isFilled[j] = true;
					}
					if (boardSituation[i] == 1) {
						Text text_rice = new Text(200, 270, "Rice\nWon!");
						text_rice.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 100));
						pane.getChildren().add(text_rice);
					} else {
						Text text_noodle = new Text(200, 270, "Noodle\nWon!");
						text_noodle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 100));
						pane.getChildren().add(text_noodle);
					}
					row = true;
				}
			}

			// check the column
			boolean column = false;
			for (int i = 0; i < 3; i++) {
				if (boardSituation[i] != 0 && boardSituation[i] == boardSituation[i + 3]
						&& boardSituation[i] == boardSituation[i + 6]) {
					if (i == 0) {
						Line line = new Line(100, 100, 100, 500);
						line.setStroke(Color.WHITE);
						line.setStrokeWidth(6);
						pane.getChildren().add(line);

					} else if (i == 1) {
						Line line = new Line(300, 100, 300, 500);
						line.setStroke(Color.WHITE);
						line.setStrokeWidth(6);
						pane.getChildren().add(line);

					} else {
						Line line = new Line(500, 100, 500, 500);
						line.setStroke(Color.WHITE);
						line.setStrokeWidth(6);
						pane.getChildren().add(line);

					}
					for (int j = 0; j < isFilled.length; j++) {
						isFilled[j] = true;
					}

					if (boardSituation[i] == 1) {
						Text text_rice = new Text(200, 270, "Rice\nWon!");
						text_rice.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 100));
						pane.getChildren().add(text_rice);
					} else {
						Text text_noodle = new Text(200, 270, "Noodle\nWon!");
						text_noodle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 100));
						pane.getChildren().add(text_noodle);
					}
					column = true;
				}
			}

			// check diagonal
			boolean diagonal = false;
			if ((boardSituation[0] != 0 && boardSituation[0] == boardSituation[4]
					&& boardSituation[0] == boardSituation[8])
					|| (boardSituation[2] != 0 && boardSituation[2] == boardSituation[4]
							&& boardSituation[2] == boardSituation[6])) {
				if (boardSituation[0] == boardSituation[4] && boardSituation[0] == boardSituation[8]) {
					Line line = new Line(100, 100, 500, 500);
					line.setStroke(Color.WHITE);
					line.setStrokeWidth(6);
					pane.getChildren().add(line);

				} else {
					Line line = new Line(500, 100, 100, 500);
					line.setStroke(Color.WHITE);
					line.setStrokeWidth(6);
					pane.getChildren().add(line);

				}
				for (int j = 0; j < isFilled.length; j++) {
					isFilled[j] = true;
				}

				if (boardSituation[4] == 1) {
					Text text_rice = new Text(200, 270, "Rice\nWon!");
					text_rice.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 100));
					pane.getChildren().add(text_rice);
				} else {
					Text text_noodle = new Text(200, 270, "Noodle\nWon!");
					text_noodle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 100));
					pane.getChildren().add(text_noodle);
				}
				diagonal = true;

			}

			// check tied
			// if the game result in a tied, the sum of the array will be either 13 or 14
			int sum = 0;
			for (int i = 0; i < boardSituation.length; i++) {
				sum += boardSituation[i];
			}
			if ((sum == 14 || sum == 13) && row == false && column == false && diagonal == false) {
				Text text_tied = new Text(200, 300, "Tied!");
				text_tied.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 100));
				pane.getChildren().add(text_tied);

				// reset all the element in boardSituation array back to 0
				for (int i = 0; i < boardSituation.length; i++) {
					boardSituation[i] = 0;
				}
			}

		}

	}

	public static void main(String args[]) {
		launch(args);
	}

}
