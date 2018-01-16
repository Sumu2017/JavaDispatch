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
	 * @param specialCol
	 *            //特殊点的列下标
	 */
	public static void chessBoard(int size, int specialRow, int specialCol) {
		int[][] board = new int[size][size];// 初始化棋盘
		chessBoard(board, specialRow, specialCol, 0, 0, size);
		printArray(board);
	}

	/**
	 * 
	 * @param board
	 *            棋盘
	 * @param specialRow
	 *            特殊点的行下标
	 * @param specialCol
	 *            特殊点的列下标
	 * @param leftTopRow
	 *            小棋盘的左上角顶点行下标
	 * @param leftTopCol
	 *            小棋盘的左上角顶点列下标
	 * @param size
	 *            棋盘大小
	 */
	public static void chessBoard(int[][] board, int specialRow, int specialCol, int leftTopRow, int leftTopCol,
			int size) {
		if (size == 1) {
			return;
		}
		count++;
		int t=count;//L型编号
		int subSize = size / 2;
		// 如果特殊点的位置在左上角矩阵里面
		if (specialRow <leftTopRow+subSize && specialCol < leftTopCol+subSize) {
			chessBoard(board, specialRow, specialCol, leftTopRow, leftTopCol, subSize);
		} else {
			//如果不在左上角矩阵里，那么就以左上角矩阵的右下角作为特殊点
			board[leftTopRow+subSize-1][leftTopCol+subSize-1]=t;
			//再以右下角那个点作为特殊点,继续填充左上角矩阵
			chessBoard(board, leftTopRow+subSize-1, leftTopCol+subSize-1, leftTopRow, leftTopCol, subSize);
		}

		// 如果特殊点的位置在右上角矩阵里面
		if (specialRow < leftTopRow+subSize && specialCol >= leftTopCol+subSize) {
			chessBoard(board, specialRow, specialCol, leftTopRow, leftTopCol+subSize, subSize);
		} else {
			//如果不在右上角矩阵里，那么就以右上角矩阵的左下角作为特殊点
			board[leftTopRow+subSize-1][leftTopCol+subSize]=t;
			//再以左下角那个点作为特殊点,继续填充右上角矩阵
			chessBoard(board, leftTopRow+subSize-1, leftTopCol+subSize, leftTopRow, leftTopCol+subSize, subSize);
		}

		// 如果特殊点的位置在左下角矩阵里面
		if (specialRow >= leftTopRow+subSize && specialCol < leftTopCol+subSize) {
			chessBoard(board, specialRow, specialCol, leftTopRow+subSize, leftTopCol, subSize);
		} else {
			//如果不在左下角矩阵里，那么就以左下角矩阵的右上角作为特殊点
			board[leftTopRow+subSize][leftTopCol+subSize-1]=t;
			//再以右上角那个点作为特殊点,继续填充左下角矩阵
			chessBoard(board, leftTopRow+subSize, leftTopCol+subSize-1, leftTopRow+subSize, leftTopCol, subSize);
		}

		// 如果特殊点的位置在右下角矩阵里面
		if (specialRow >= leftTopRow+subSize && specialCol >= leftTopCol+subSize) {
			chessBoard(board, specialRow, specialCol, leftTopRow+subSize, leftTopCol+subSize, subSize);
		} else {
			//如果不在右下角矩阵里，那么就以右下角矩阵的左上角作为特殊点
			board[leftTopRow+subSize][leftTopCol+subSize]=t;
			//再以左上角那个点作为特殊点,继续填充右下角矩阵
			chessBoard(board, leftTopRow+subSize, leftTopCol+subSize, leftTopRow+subSize, leftTopCol+subSize, subSize);
		}
		
	}

	public static void printArray(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		ChessBoard.chessBoard(4, 1, 1);
	}
}
