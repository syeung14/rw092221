package com.agiledeveloper.lab;

public class MinesweeperLogic {
  public enum GameStatus { INPROGRESS, LOST, WON }
  
  public enum CellState { UNEXPOSED, EXPOSED, SEALED }

  private final int SIZE = 10;
  private CellState[][] _cells = new CellState[SIZE][SIZE];
  private boolean[][] _bomb = new boolean[SIZE][SIZE];

  public MinesweeperLogic() {
    for(int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        _cells[i][j] = CellState.UNEXPOSED;
      }
    }
  }

  public CellState getCellState(int row, int column) {
    return _cells[row][column];
  }

  public boolean isMineAt(int row, int column){
    return _bomb[row][column];
  }

  public void setMine(int row, int column) {
    _bomb[row][column] = true;
  }

  public void expose(int row, int column) {
    if(_cells[row][column] == CellState.UNEXPOSED) {
      _cells[row][column] = CellState.EXPOSED;
    }
  }

  public void toggleSeal(int row, int column) {
    _cells[row][column] = switch(_cells[row][column]) {
      case UNEXPOSED -> CellState.SEALED;
      case SEALED -> CellState.UNEXPOSED;
      case EXPOSED -> CellState.EXPOSED;
    };
  }

  //we need to reduce the complexity of getGameStatus by breaking that into
  //smaller methods (SLAP). Thus all the methods will be cohesive and
  //getGameStatus will also be small and delegate responsibilities to other functions.
  public GameStatus getGameStatus() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if(isMineAt(i, j) && getCellState(i, j) == CellState.EXPOSED) {
          return GameStatus.LOST;
        }
      }
    }

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if(isMineAt(i, j) && getCellState(i, j) != CellState.SEALED
         || !isMineAt(i, j) && getCellState(i, j) != CellState.EXPOSED) {
          return GameStatus.INPROGRESS;
        }
      }
    }

    return GameStatus.WON;
  }

  int getMinedNeighborsCount(int row, int column) {
    int count = 0;

    for(int i = row - 1; i <= row + 1; i++) {
      for (int j = column - 1; j <= column + 1; j++) {
        if (i >= 0 && i < SIZE && j >= 0 && j < SIZE && _bomb[i][j]) {
          count++;
        }
      }
    }

    return _bomb[row][column] ? count - 1 : count;
  }
}
