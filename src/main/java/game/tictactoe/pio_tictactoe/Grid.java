package game.tictactoe.pio_tictactoe;

import javafx.scene.layout.AnchorPane;

import java.util.Vector;

public
class Grid extends AnchorPane
{

	private final int x;
	private final int y;
	final CustomCircle circle = new CustomCircle(GameInfo.BIG_CIRCLE_COORDINATES,
														 GameInfo.BIG_CIRCLE_COORDINATES, GameInfo.BIG_CIRCLE_RADIUS,
														 GameInfo.BIG_CIRCLE_WIDTH);
	final Cross cross = new Cross(GameInfo.BIG_CROSS_WIDTH, GameInfo.BIG_CROSS_SIZE, GameInfo.BIG_CROSS_SIZE,
										  GameInfo.BIG_CROSS_COORDINATES, GameInfo.BIG_CROSS_COORDINATES);
	public Board parent;
	Vector<Square> squares = new Vector<>();
	private boolean winner;
	private PlayerType playerType = null;
	public
	Grid (int boardColumn, int boardRow, Board _parent, AnchorPane boardGrid)
	{
		this.x = boardColumn;
		this.y = boardRow;
		this.parent = _parent;
		this.resize(GameInfo.getGridSize(), GameInfo.getGridSize());
		this.setLayoutX(GameInfo.getGridSize() * boardColumn);
		this.setLayoutY(GameInfo.getGridSize() * boardRow);
		this.winner = false;
		for (int gridRow = 0; gridRow < 3; gridRow++)
		{
			for (int gridColumn = 0; gridColumn < 3; gridColumn++)
			{
				Square square = new Square(boardGrid, gridColumn, gridRow);
				this.getChildren().add(square);
				this.squares.add(square);
				square.parent = this;

			}
		}
	}

	public
	int getX ()
	{
		return x;
	}

	public
	int getY ()
	{
		return y;
	}

	void paintSquares ()
	{
		for (Square square : this.squares)
		{
			square.paintSquare();
		}
	}

	void unpaintSquares ()
	{
		for (Square square : this.squares)
		{
			square.unpaintSquare();
		}
	}

	boolean isWinner ()
	{
		return this.winner;
	}

	void checkWinCondition ()
	{
        if( winner )
        {
            return;
        }

        for (int i = 0; i < 3; i++)
        {
            this.checkColumn(i);
        }
        for (int i = 0; i < 3; i++)
        {
            this.checkRow(i);
        }
		this.checkLeftUpDiagonal();
		this.checkRightUpDiagonal();

		parent.checkWinStatus();
	}

	void checkRow (int row)
	{
        if( winner )
        {
            return;
        }

		if( (squares.get(row * 3).checkCross() && squares.get(row * 3 + 1).checkCross() && squares.get(row * 3 + 2)
																								  .checkCross()) )
		{
			this.getChildren().add(cross);
			this.winner = true;
			this.playerType = PlayerType.Cross;
		}
		else if( (squares.get(row * 3).checkCircle() && squares.get(row * 3 + 1).checkCircle() && squares.get(
				row * 3 + 2).checkCircle()) )
		{
			this.getChildren().add(circle);
			this.winner = true;
			this.playerType = PlayerType.Circle;
		}

	}

	void checkColumn (int col)
	{
        if( winner )
        {
            return;
        }

		if( (squares.get(col).checkCross() && squares.get(col + 3).checkCross() && squares.get(col + 6).checkCross()) )
		{
			this.getChildren().add(cross);
			this.winner = true;
			this.playerType = PlayerType.Cross;
		}
		else if( (squares.get(col).checkCircle() && squares.get(col + 3).checkCircle() && squares.get(col + 6)
																								 .checkCircle()) )
		{
			this.getChildren().add(circle);
			this.winner = true;
			this.playerType = PlayerType.Circle;
		}
	}

	void checkLeftUpDiagonal ()
	{
        if( winner )
        {
            return;
        }

		if( (squares.get(0).checkCross() && squares.get(4).checkCross() && squares.get(8).checkCross()) )
		{
			this.getChildren().add(cross);
			this.winner = true;
			this.playerType = PlayerType.Cross;
		}
		else if( (squares.get(0).checkCircle() && squares.get(4).checkCircle() && squares.get(8).checkCircle()) )
		{
			this.getChildren().add(circle);
			this.winner = true;
			this.playerType = PlayerType.Circle;
		}
	}

	void checkRightUpDiagonal ()
	{
        if( winner )
        {
            return;
        }

		if( (squares.get(2).checkCross() && squares.get(4).checkCross() && squares.get(6).checkCross()) )
		{
			this.getChildren().add(cross);
			this.winner = true;
			this.playerType = PlayerType.Cross;
		}
		else if( (squares.get(2).checkCircle() && squares.get(4).checkCircle() && squares.get(6).checkCircle()) )
		{
			this.getChildren().add(circle);
			this.winner = true;
			this.playerType = PlayerType.Circle;
		}
	}

	boolean isFull ()
	{
		if(winner)
			return true;

		for (int i = 0; i < 9; i++)
		{
            if( squares.get(i).empty )
            {
                return false;
            }
		}
		return true;
	}

	boolean checkCross ()
	{
		return this.winner && this.playerType == PlayerType.Cross;
	}

	boolean checkCircle ()
	{
		return this.winner && this.playerType == PlayerType.Circle;
	}

}
