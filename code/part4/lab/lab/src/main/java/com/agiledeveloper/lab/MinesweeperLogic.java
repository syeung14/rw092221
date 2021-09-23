package com.agiledeveloper.lab;

public class MinesweeperLogic {
  private final int SIZE = 10;
  private String gameStatus = "INPROGRESS";

  private String[][] _cells = new String[SIZE][SIZE];
  private boolean[][] _bomb = new boolean[SIZE][SIZE];

  public MinesweeperLogic() {
    for(int i = 0; i < SIZE; i++)
      for(int j = 0; j < SIZE; j++)
        _cells[i][j] = "UNEXPOSED";
  }

  public String getCellState(int row, int column) {
    return _cells[row][column];
  }

  public boolean isMineAt(int row, int column){
    return _bomb[row][column];
  }

  public void setMine(int row, int column) {
    _bomb[row][column] = true;
  }

  public boolean expose(int row, int column) {
    if(_bomb[row][column]) gameStatus = "LOST";
    if(_cells[row][column] == "UNEXPOSED")
      _cells[row][column] = "EXPOSED";
    boolean result = _cells[row][column] == "EXPOSED";

    boolean won = true;
    for(int i = 0; i < SIZE; i++)
      for(int j = 0; j < SIZE; j++)
        if(_bomb[i][j] && _cells[i][j] != "SEALED" ||
          !_bomb[i][j] && _cells[i][j] != "EXPOSED")
          won = false;

    if(won) gameStatus = "WON";

    return result;
  }

  public boolean seal(int row, int column) {
    if(_cells[row][column] == "UNEXPOSED")
      _cells[row][column] = "SEALED";
    boolean result = _cells[row][column] == "SEALED";

    boolean won = true;
    for(int i = 0; i < SIZE; i++)
      for(int j = 0; j < SIZE; j++)
        if(_bomb[i][j] && _cells[i][j] != "SEALED" ||
          !_bomb[i][j] && _cells[i][j] != "EXPOSED")
          won = false;

    if(won) gameStatus = "WON";

    return result;
  }

  public boolean unseal(int row, int column) {
    if(_cells[row][column] == "SEALED")
      _cells[row][column] = "UNEXPOSED";
    return _cells[row][column] == "UNEXPOSED";
  }

  public String getGameStatus() {
    return gameStatus;
  }

  int getMinedNeighborsCount(int row, int column) {
    int count = 0;

    for(int i = row - 1; i <= row + 1; i++)
      for(int j = column - 1; j <= column + 1; j++)
        if(i >= 0 && i < SIZE && j >= 0 && j < SIZE && _bomb[i][j]) count++;

    return _bomb[row][column] ? count - 1 : count;
  }
}
