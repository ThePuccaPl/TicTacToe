package game.tictactoe.pio_tictactoe;

public
class GameInfo
{
	public static final int CROSS_SIZE = 20;
	public static final int CROSS_WIDTH = 8;
	public static final int CIRCLE_CENTER = 25;
	public static final int CIRCLE_RADIUS = 25;
	public static final int CIRCLE_WIDTH = 7;
	public static final int CROSS_CURSOR_SIZE = 10;
	public static final int CROSS_CURSOR_WIDTH = 4;
	public static final int CIRCLE_CURSOR_CENTER = 0;
	public static final int CIRCLE_CURSOR_RADIUS = 12;
	public static final int CIRCLE_CURSOR_WIDTH = 4;
	public static final int BIG_CIRCLE_COORDINATES = 30;
	public static final int BIG_CIRCLE_RADIUS = 100;
	public static final int BIG_CIRCLE_WIDTH = 20;
	public static final int BIG_CROSS_COORDINATES = 20;
	public static final int BIG_CROSS_WIDTH = 30;
	public static final int BIG_CROSS_SIZE = 100;
	public static final String FILL_COLOR = "cdffa6";
	public static final int placedSize = 50;
	public static final int SECTOR_UNRESTRICTED = -1;
	private static final int gridSize = 280;
	private static final int squareSize = 90;
	static Board gameBoard;
	private static int currentSector = SECTOR_UNRESTRICTED;
	private static EndGameStatus status = null;
	private static PlayerType currentPlayer;

	public static
	PlayerType getCurrentPlayer ()
	{
		return currentPlayer;
	}

	public static
	void setCurrentPlayer (PlayerType currentPlayer)
	{
		GameInfo.currentPlayer = currentPlayer;
	}

	public static
	int getCurrentSector ()
	{
		return currentSector;
	}

	public static
	void setCurrentSector (int _newSector)
	{
        if( (_newSector >= 0 && _newSector < 9) || _newSector == GameInfo.SECTOR_UNRESTRICTED )
        {
            currentSector = _newSector;
        }
	}

	static public
	int getSquareSize ()
	{
		return squareSize;
	}

	public static
	EndGameStatus getStatus ()
	{
		return status;
	}

	public static
	void setStatus (EndGameStatus _status)
	{
		status = _status;
	}

	public static
	int getGridSize ()
	{
		return gridSize;
	}
}
