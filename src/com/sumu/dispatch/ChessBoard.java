package com.sumu.dispatch;

/**
 * 棋盘覆盖(分治算法)
 * 
 * @author YaoMingliang
 * @date 2018年1月15日 下午8:38:02
 */
public class ChessBoard {
	private static int count = 0;

	/**
	 * 
	 * @param size
	 *            棋盘的大小
	 * @param specialRow
	 *            //特殊点的行下标
	 * @param specialLow
	 *            //特殊点的列下标
	 */
	public static void chessBoard(int size, int specialRow, int specialLow) {
		int[][] board = new int[size][size];// 初始化棋盘
		chessBoard(board, specialRow, specialLow, 0, 0, size);
		printArray(board);
	}

	/**
	 * 
	 * @param board
	 *            棋盘
	 * @param specialRow
	 *            特殊点的行下标
	 * @param specialLow
	 *            特殊点的列下标
	 * @param leftTopRow
	 *            小棋盘的左上角顶点行下标
	 * @param leftToplow
	 *            小棋盘的左上角顶点列下标
	 * @param size
	 *            棋盘大小
	 */
	public static void chessBoard(int[][] board, int specialRow, int specialLow, int leftTopRow, int leftToplow,
			int size) {
		if (size == 1) {
			return;
		}
		int subSize = size / 2;
		count++;
		// 如果特殊点的位置在左上角
		if (specialRow <leftTopRow+subSize && specialLow < leftTopRow+subSize) {
			chessBoard(board, specialRow, specialLow, leftTopRow, leftToplow, subSize);
		} else {
			//覆盖右下角
			board[leftTopRow+subSize][leftToplow+subSize]=count;
			//再以右下角那个点作为特殊点继续
			chessBoard(board, leftTopRow+subSize, leftTopRow+subSize, leftTopRow, leftTopRow, subSize);
		}

		// 如果特殊点的位置在右上角
		if (specialRow < leftTopRow+subSize && specialLow >= leftTopRow+subSize) {
			chessBoard(board, specialRow, specialLow, leftTopRow, leftToplow, subSize);
		} else {
			//覆盖左下角
			board[leftTopRow+subSize][leftToplow]=count;
			chessBoard(board, leftTopRow+subSize, leftToplow, leftTopRow, leftToplow, subSize);
		}

		// 如果特殊点的位置在左下角
		if (specialRow >= leftTopRow+subSize && specialLow < leftTopRow+subSize) {
			chessBoard(board, specialRow, specialLow, leftTopRow, leftToplow, subSize);
		} else {
			//覆盖右上角
			board[leftTopRow][leftToplow+subSize]=count;
			chessBoard(board, leftTopRow, leftToplow+subSize, leftTopRow, leftToplow, subSize);
		}

		// 如果特殊点的位置在右下角
		if (specialRow >= leftTopRow+subSize && specialLow >= leftTopRow+subSize) {
			chessBoard(board, specialRow, specialLow, leftTopRow, leftTopRow, subSize);
		} else {
			//覆盖左上角
			board[leftTopRow][leftToplow]=count;
			chessBoard(board, leftTopRow, leftToplow, leftTopRow, leftToplow, subSize);
		}
	}

	public static void printArray(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		ChessBoard.chessBoard(4, 0, 0);
	}
}
