import java.util.*;

class BFS{
	
	int arr[][]=new int[3][3],h;
public static void printboard(int a[][])
{
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<3;j++)
			System.out.print(a[i][j]+" ");
		System.out.println();	
	}
}

public static void copy2darray(BFS temp,BFS a)
{
	for(int i=0; i<3; i++)
  		for(int j=0; j<3; j++)
    		temp.arr[i][j]=a.arr[i][j];
    	
    temp.h=a.h;

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

	


public static void main(String ar[])throws Exception
{
	BFS initial=new BFS();
	int goal[][]=new int[][]{{1,2,3},{8,0,4},{7,6,5}};
	System.out.println("Goal position");
	printboard(goal);	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter tiles and for position of blank tile enter zero");
	for(int l=0;l<3;l++)
		for(int m=0;m<3;m++)
			initial.arr[l][m]=sc.nextInt();
	System.out.println("Initial position");
	printboard(initial.arr);
	initial.h=findheuristic(initial.arr,goal);
	System.out.println("heuristic="+initial.h);

	BFS var[]=new BFS[20];
	for(int i=0;i<20;i++)
		var[i]=new BFS();
	int k=0,h;
	copy2darray(var[k],initial);
	BFS queue[]=new BFS[20];
	for(int i=0;i<20;i++)
		queue[i]=new BFS();
	int tos=0;
	h=var[k].h;
	int pos=k;
	while(h!=0)
	{
		int ans[]=findzero(var[pos].arr);
		int i=ans[0],j=ans[1];
		int var2;
		if((i-1)>=0)//up
		{
			k++;
			copy2darray(var[k],var[pos]);
			var2=var[k].arr[i][j];
			var[k].arr[i][j]=var[k].arr[i-1][j];
			var[k].arr[i-1][j]=var2;
			var[k].h=findheuristic(var[k].arr,goal);
			copy2darray(queue[tos++],var[k]);
		}
		if((i+1)<=2)//down
		{
			k++;
			copy2darray(var[k],var[pos]);
			var2=var[k].arr[i][j];
			var[k].arr[i][j]=var[k].arr[i+1][j];
			var[k].arr[i+1][j]=var2;
			var[k].h=findheuristic(var[k].arr,goal);
			copy2darray(queue[tos++],var[k]);
		}
		if((j-1)>=0)//left
		{
			k++;
			copy2darray(var[k],var[pos]);
			var2=var[k].arr[i][j];
			var[k].arr[i][j]=var[k].arr[i][j-1];
			var[k].arr[i][j-1]=var2;
			var[k].h=findheuristic(var[k].arr,goal);
			copy2darray(queue[tos++],var[k]);
		}
		if((j+1)<=2)//right
		{
			k++;
			copy2darray(var[k],var[pos]);
			var2=var[k].arr[i][j];
			var[k].arr[i][j]=var[k].arr[i][j+1];
			var[k].arr[i][j+1]=var2;
			var[k].h=findheuristic(var[k].arr,goal);
			copy2darray(queue[tos++],var[k]);
		}
		tos--;

		BFS temp=new BFS();
		for(int z=0;z<tos;z++)
			for(int l=0;l<tos;l++)
				if(queue[l].h<queue[l+1].h)
				{
					copy2darray(temp,queue[l+1]);
					copy2darray(queue[l+1],queue[l]);
					copy2darray(queue[l],temp);
				}
	
		printboard(queue[tos].arr);
		System.out.println("heuristic="+queue[tos].h);
		h=queue[tos].h;
		int pro[]=findzero(queue[tos].arr);
		for(int z=0;z<=k;z++)
		{
			int go[]=findzero(var[z].arr);
			if(queue[tos].h==var[z].h && pro[0]==go[0] && pro[1]==go[1])
				pos=z;
		}
		tos--;	
	}

}


}

/*

Goal position
1 2 3 
8 0 4 
7 6 5 
Enter tiles and for position of blank tile enter zero
2 8 3 1 6 4 7 0 5
Initial position
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