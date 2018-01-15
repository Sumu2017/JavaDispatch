package com.sumu.dispatch;

/**
 * ѭ����(�����㷨)
 * 
 * @author sumu
 *
 */
public class RoundRobin {
	/**
	 * ����n=2^k������Ҫ����ѭ���������һ����������Ҫ��ı����ճ̱� 
	 * ��1��ÿ���������������n-1���������һ�� 
	 * ��2��ÿ������һ��ֻ����һ�� 
	 * @param table �ճ̱�table[i][0]����i+1�Ŷ��飬��table[i][1]��ʼ��table[i][j]�������i+1�Ŷ���ĵ�j�����������table[i][1]�������i+1�����һ��Ķ��ֶ���
	 * @param n  �ж��ٸ�����
	 * ���÷��η����д������ճ̰��ŷֳ��ĸ�����������
	 */
	public static void roundRobin(int[][] table,int n) {
		if (n==1) {
			table[0][0]=1;
			return;
		}
		int m=n/2;
		//�����������
		roundRobin(table, m);
		//�����������
		for (int i = 0; i <m ; i++) {
			for (int j = m; j < n; j++) {
				table[i][j]=table[i][j-m]+m;
			}
		}
		//�����������
		for (int i = m; i < n; i++) {
			for (int j = 0; j < m; j++) {
				table[i][j]=table[i-m][j]+m;
			}
		}
		//�����������
		for (int i = m; i < n; i++) {
			for (int j = m; j < n; j++) {
				table[i][j]=table[i-m][j-m];
			}
		}
	}
	
	public static void printArray(int[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				System.out.print(table[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		int n=8;
		int[][] table=new int[n][n];
		RoundRobin.roundRobin(table, n);
		printArray(table);
	}
}
