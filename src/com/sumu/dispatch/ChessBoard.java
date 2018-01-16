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
	 * @param specialCol
	 *            //���������±�
	 */
	public static void chessBoard(int size, int specialRow, int specialCol) {
		int[][] board = new int[size][size];// ��ʼ������
		chessBoard(board, specialRow, specialCol, 0, 0, size);
		printArray(board);
	}

	/**
	 * 
	 * @param board
	 *            ����
	 * @param specialRow
	 *            ���������±�
	 * @param specialCol
	 *            ���������±�
	 * @param leftTopRow
	 *            С���̵����ϽǶ������±�
	 * @param leftTopCol
	 *            С���̵����ϽǶ������±�
	 * @param size
	 *            ���̴�С
	 */
	public static void chessBoard(int[][] board, int specialRow, int specialCol, int leftTopRow, int leftTopCol,
			int size) {
		if (size == 1) {
			return;
		}
		count++;
		int t=count;//L�ͱ��
		int subSize = size / 2;
		// ���������λ�������ϽǾ�������
		if (specialRow <leftTopRow+subSize && specialCol < leftTopCol+subSize) {
			chessBoard(board, specialRow, specialCol, leftTopRow, leftTopCol, subSize);
		} else {
			//����������ϽǾ������ô�������ϽǾ�������½���Ϊ�����
			board[leftTopRow+subSize-1][leftTopCol+subSize-1]=t;
			//�������½��Ǹ�����Ϊ�����,����������ϽǾ���
			chessBoard(board, leftTopRow+subSize-1, leftTopCol+subSize-1, leftTopRow, leftTopCol, subSize);
		}

		// ���������λ�������ϽǾ�������
		if (specialRow < leftTopRow+subSize && specialCol >= leftTopCol+subSize) {
			chessBoard(board, specialRow, specialCol, leftTopRow, leftTopCol+subSize, subSize);
		} else {
			//����������ϽǾ������ô�������ϽǾ�������½���Ϊ�����
			board[leftTopRow+subSize-1][leftTopCol+subSize]=t;
			//�������½��Ǹ�����Ϊ�����,����������ϽǾ���
			chessBoard(board, leftTopRow+subSize-1, leftTopCol+subSize, leftTopRow, leftTopCol+subSize, subSize);
		}

		// ���������λ�������½Ǿ�������
		if (specialRow >= leftTopRow+subSize && specialCol < leftTopCol+subSize) {
			chessBoard(board, specialRow, specialCol, leftTopRow+subSize, leftTopCol, subSize);
		} else {
			//����������½Ǿ������ô�������½Ǿ�������Ͻ���Ϊ�����
			board[leftTopRow+subSize][leftTopCol+subSize-1]=t;
			//�������Ͻ��Ǹ�����Ϊ�����,����������½Ǿ���
			chessBoard(board, leftTopRow+subSize, leftTopCol+subSize-1, leftTopRow+subSize, leftTopCol, subSize);
		}

		// ���������λ�������½Ǿ�������
		if (specialRow >= leftTopRow+subSize && specialCol >= leftTopCol+subSize) {
			chessBoard(board, specialRow, specialCol, leftTopRow+subSize, leftTopCol+subSize, subSize);
		} else {
			//����������½Ǿ������ô�������½Ǿ�������Ͻ���Ϊ�����
			board[leftTopRow+subSize][leftTopCol+subSize]=t;
			//�������Ͻ��Ǹ�����Ϊ�����,����������½Ǿ���
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
