package game.tictactoe.pio_tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public
class TicTacToeApplication extends Application
{
	public static
	void main (String[] args)
	{
		launch();
	}

	@Override
	public
	void start (Stage stage) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeApplication.class.getResource("mainGrid.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 840, 840);
		stage.setTitle("TicTacToe");
		stage.setScene(scene);
		stage.show();
	}
}