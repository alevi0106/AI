import java.util.*;

class routefind{

	public static void main(String ar[])
	{
		int n,numedge;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of nodes");
		n=sc.nextInt();
		int a[][]=new int[n][n];
		System.out.println("Enter number of edges");
		numedge=sc.nextInt();
		System.out.println("Enter edges");
		int l,m,edge;
		for(int i=0;i<numedge;i++)
		{
			l=sc.nextInt();
			m=sc.nextInt();
			edge=sc.nextInt();
			a[l][m]=a[m][l]=edge;
		}
		System.out.println("Adjacency matrix");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.printf("%3d",a[i][j]);
		System.out.println();
		}
		
		System.out.println("Enter straight line distance");
		int h[]=new int[n];
		for(int i=0;i<n;i++)
			h[i]=sc.nextInt();
			
		int gofn=0,fofn,hofn,cost=0,k=0,temp=0,one=1,same=0;
		hofn=h[k];
		fofn=gofn+hofn;
		cost+=gofn;
		System.out.print("\nPath:");
		System.out.print(k);
		while(hofn!=0)
		{
			System.out.print("-");
			for(int i=k+1;i<n;i++)
				if(a[k][i]!=0 && ((h[i]+gofn+a[k][i])<=fofn)||one==1)
				{
					one=0;
					gofn=same+a[k][i];
					fofn=gofn+h[i];
					temp=i;
				}
			hofn=h[temp];
			same=gofn;
			cost+=a[k][temp];
			k=temp;
			System.out.print(k);
			one=1;

		}
		System.out.println("\nCost="+cost);
	}
}

/*
output:
Enter number of nodes
6
Enter number of edges
9
Enter edges
0 1 7
0 2 8
0 3 9
1 2 11
1 5 20
2 5 12
2 4 4
4 5 6
3 4 18
Adjacency matrix
  0  7  8  9  0  0
  7  0 11  0  0 20
  8 11  0  0  4 12
  9  0  0  0 18  0
  0  0  4 18  0  6
  0 20 12  0  6  0
Enter straight line distance
16 18 8 22 4 0

Path:0-2-4-5
Cost=18


*/
