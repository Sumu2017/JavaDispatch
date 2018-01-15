package com.sumu.dispatch;

/**
 * ���̸���(�����㷨)
 * 
 * @author YaoMingliang
 * @date 2018��1��15�� ����8:38:02
 */
public class ChessBoard {
	private static int count = 0;

	/**
	 * 
	 * @param size
	 *            ���̵Ĵ�С
	 * @param specialRow
	 *            //���������±�
	 * @param specialLow
	 *            //���������±�
	 */
	public static void chessBoard(int size, int specialRow, int specialLow) {
		int[][] board = new int[size][size];// ��ʼ������
		chessBoard(board, specialRow, specialLow, 0, 0, size);
		printArray(board);
	}

	/**
	 * 
	 * @param board
	 *            ����
	 * @param specialRow
	 *            ���������±�
	 * @param specialLow
	 *            ���������±�
	 * @param leftTopRow
	 *            С���̵����ϽǶ������±�
	 * @param leftToplow
	 *            С���̵����ϽǶ������±�
	 * @param size
	 *            ���̴�С
	 */
	public static void chessBoard(int[][] board, int specialRow, int specialLow, int leftTopRow, int leftToplow,
			int size) {
		if (size == 1) {
			return;
		}
		int subSize = size / 2;
		count++;
		// ���������λ�������Ͻ�
		if (specialRow <leftTopRow+subSize && specialLow < leftTopRow+subSize) {
			chessBoard(board, specialRow, specialLow, leftTopRow, leftToplow, subSize);
		} else {
			//�������½�
			board[leftTopRow+subSize][leftToplow+subSize]=count;
			//�������½��Ǹ�����Ϊ��������
			chessBoard(board, leftTopRow+subSize, leftTopRow+subSize, leftTopRow, leftTopRow, subSize);
		}

		// ���������λ�������Ͻ�
		if (specialRow < leftTopRow+subSize && specialLow >= leftTopRow+subSize) {
			chessBoard(board, specialRow, specialLow, leftTopRow, leftToplow, subSize);
		} else {
			//�������½�
			board[leftTopRow+subSize][leftToplow]=count;
			chessBoard(board, leftTopRow+subSize, leftToplow, leftTopRow, leftToplow, subSize);
		}

		// ���������λ�������½�
		if (specialRow >= leftTopRow+subSize && specialLow < leftTopRow+subSize) {
			chessBoard(board, specialRow, specialLow, leftTopRow, leftToplow, subSize);
		} else {
			//�������Ͻ�
			board[leftTopRow][leftToplow+subSize]=count;
			chessBoard(board, leftTopRow, leftToplow+subSize, leftTopRow, leftToplow, subSize);
		}

		// ���������λ�������½�
		if (specialRow >= leftTopRow+subSize && specialLow >= leftTopRow+subSize) {
			chessBoard(board, specialRow, specialLow, leftTopRow, leftTopRow, subSize);
		} else {
			//�������Ͻ�
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
