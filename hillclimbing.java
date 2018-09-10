/*

This program is implementation of 8 puzzle problem using hill climbing.

*/
import java.util.*;

class hillclimbing{
public static void printboard(int a[][])
{
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<3;j++)
			System.out.print(a[i][j]+" ");
		System.out.println();	
	}
}

public static void copy2darray(int temp[][],int a[][])
{
	for(int i=0; i<3; i++)
  		for(int j=0; j<3; j++)
    		temp[i][j]=a[i][j];

}


public static int[] findzero(int temp[][])
{
	int[] ans = new int[2];
	for(int i=0; i<3; i++)
  		for(int j=0; j<3; j++)
  			if(temp[i][j]==0)
  			{
  				ans[0]=i;
  				ans[1]=j;
  			}
  	return ans;
}


public static int findheuristic(int a[][],int b[][])
{
	int h=0,i=0,j=0;
	for(int p=0;p<3;p++)
		for(int k=0;k<3;k++)
		{
			for(i=0;i<3;i++)
				for(j=0;j<3;j++)
					if(b[p][k]==a[i][j] && a[i][j]!=0)
					{
						//System.out.println(i+""+j+""+p+""+k);
						h=h+Math.abs(p-i)+Math.abs(k-j);
					}
		}
	return h;
}	

public static void main(String ar[])
{
	int initial[][]=new int[3][3];
	int goal[][]=new int[][]{{1,2,3},{8,0,4},{7,6,5}};
	System.out.println("Goal position");
	printboard(goal);	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter tiles and for position of blank tile enter zero");
	for(int l=0;l<3;l++)
		for(int m=0;m<3;m++)
			initial[l][m]=sc.nextInt();
	System.out.println("Initial position");
	printboard(initial);
	int h=findheuristic(initial,goal);
	System.out.println("heuristic="+h);

	while(h!=0)
	{
		int ans[]=findzero(initial);
		int i=ans[0],j=ans[1];
		int he[]={99,99,99,99};
		int var;
		int temp1[][]=new int[3][3];
		copy2darray(temp1,initial);
		int temp2[][]=new int[3][3];
		copy2darray(temp2,initial);
		int temp3[][]=new int[3][3];
		copy2darray(temp3,initial);
		int temp4[][]=new int[3][3];
		copy2darray(temp4,initial);
		if((i-1)>=0)
		{
			var=temp1[i][j];
			temp1[i][j]=temp1[i-1][j];
			temp1[i-1][j]=var;
			he[0]=findheuristic(temp1,goal);
		}
		if((i+1)<=2)
		{
			var=temp2[i][j];
			temp2[i][j]=temp2[i+1][j];
			temp2[i+1][j]=var;
			he[1]=findheuristic(temp2,goal);	
		}
		if((j-1)>=0)
		{
			var=temp3[i][j];
			temp3[i][j]=temp3[i][j-1];
			temp3[i][j-1]=var;
			he[2]=findheuristic(temp3,goal);
		}
		if((j+1)<=2)
		{
			var=temp4[i][j];
			temp4[i][j]=temp4[i][j+1];
			temp4[i][j+1]=var;
			he[3]=findheuristic(temp4,goal);	
		}
		int b[]={0,0,0,0};
		for(int k=0;k<4;k++)
			b[k]=he[k];
		Arrays.sort(b);
		int p=9;
		for(int k=0;k<4;k++)
			if(he[k]==b[0])
				p=k;
		if(p==0)
			copy2darray(initial,temp1);
		if(p==1)
			copy2darray(initial,temp2);
		if(p==2)
			copy2darray(initial,temp3);
		if(p==3)
			copy2darray(initial,temp4);
		System.out.println();
		printboard(initial);
			h=b[0];
		System.out.println("heuristic="+h);
	}
	
}
}

/*

Output:
Goal position
1 2 3 
8 0 4 
7 6 5 
Enter tiles and for position of blank tile enter zero
2 8 3 1 6 4 0 7 5
Initial position
2 8 3 
1 6 4 
0 7 5 
heuristic=6

2 8 3 
1 6 4 
7 0 5 
heuristic=5

2 8 3 
1 0 4 
7 6 5 
heuristic=4

2 0 3 
1 8 4 
7 6 5 
heuristic=3

0 2 3 
1 8 4 
7 6 5 
heuristic=2

1 2 3 
0 8 4 
7 6 5 
heuristic=1

1 2 3 
8 0 4 
7 6 5 
heuristic=0

*/