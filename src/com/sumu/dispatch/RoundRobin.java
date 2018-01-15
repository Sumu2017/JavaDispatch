package com.sumu.dispatch;

/**
 * 循环赛(分治算法)
 * 
 * @author sumu
 *
 */
public class RoundRobin {
	/**
	 * 设有n=2^k个队伍要进行循环赛，设计一个满足以下要求的比赛日程表 
	 * （1）每个队伍必须与其他n-1个队伍各赛一次 
	 * （2）每个队伍一天只能赛一次 
	 * @param table 日程表table[i][0]代表i+1号队伍，从table[i][1]开始到table[i][j]代表的是i+1号队伍的第j天比赛，列如table[i][1]代表的是i+1队伍第一天的对手队伍
	 * @param n  有多少个队伍
	 * 采用分治法进行处理，将日程安排分成四个象限来处理
	 */
	public static void roundRobin(int[][] table,int n) {
		if (n==1) {
			table[0][0]=1;
			return;
		}
		int m=n/2;
		//填充左上区域
		roundRobin(table, m);
		//填充右上区域
		for (int i = 0; i <m ; i++) {
			for (int j = m; j < n; j++) {
				table[i][j]=table[i][j-m]+m;
			}
		}
		//填充左下区域
		for (int i = m; i < n; i++) {
			for (int j = 0; j < m; j++) {
				table[i][j]=table[i-m][j]+m;
			}
		}
		//填充右下区域
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
