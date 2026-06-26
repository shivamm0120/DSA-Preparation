package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		List<List<String>> ans= new ArrayList<>();
		int n = 3;
		
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append('.');
		}
		
		for(int i=0;i<n;i++) {
			List<String> al= new ArrayList<>();
			sb.setCharAt(i, 'Q');
			al.add(sb.toString());
			findPosition(1, 0, ans, al, new StringBuilder(), 1, n);
		}
		System.out.println(ans);
		
	}
	static void findPosition(int row,int col,List<List<String>>ans,
			List<String>al,StringBuilder sb,int placed,int n) {
		if(row==n) {
		  if(placed==n) {
			  ans.add(new ArrayList<>(al));
		  }
		  return;
		}
		if(col==0) {
			sb=new StringBuilder();
			for(int i=0;i<n;i++)
				sb.append('.');
		}
		
		for(int i=0;i<al.size();i++) {
			String s1=al.get(i);
			int pos=s1.indexOf('Q');
			boolean attack=(i==row)||(col==pos)||(row-i)==(col-pos);
			if(attack) {
				findPosition(row,col+1,ans,al,sb,placed,n);
			}
			else {
				sb.setCharAt(col, 'Q');
				al.add(sb.toString());
				placed++;
				findPosition(row+1,0,ans,al,sb,placed,n);
			}
		}
		String s=new String();
			
		
		
		
	}

}
