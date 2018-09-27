import java.util.*;

class routefind{

	public static void main(String ar[])
	{
		int n=6,numedge;
		int a[][]={{0,7,8,9,0,0,},{7,0,11,0,0,20},{8,11,0,0,4,12},{9,0,0,0,18,0},{0,0,4,18,0,6},{0,20,12,0,6,0}};
		int h[]={16,18,8,22,4,0};
		System.out.println("Adjacency matrix");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.printf("%3d",a[i][j]);
		System.out.println();
		}
		System.out.println("\nWe start with root");

		int gofn=0,fofn,hofn,cost=0,k=0,temp=0,one=1,same=0,temp2=0;
		int g[]=new int[50];
		int path[]=new int[10];
		int l=0,m=0; 
		hofn=h[k];
		fofn=gofn+hofn;
		cost+=gofn;
		g[l++]=0;g[l++]=0;g[l++]=0;g[l++]=hofn;
		path[m++]=k;
		while(hofn!=0)
		{
			for(int i=0;i<n;i++)
				if(a[k][i]!=0 && i!=temp2)
				{
					g[l++]=k;
					g[l++]=i;
 					g[l++]=same+a[k][i];
 					g[l++]=h[i]+same+a[k][i];
					if((h[i]+gofn+a[k][i])<=fofn||one==1)
					{
						one=0;
						gofn=same+a[k][i];
						fofn=gofn+h[i];
						temp=i;
					}
				}
			hofn=h[temp];
			same=gofn;
			cost+=a[k][temp];
			temp2=k;
			k=temp;
			path[m++]=k;
			one=1;

		}
		
		for(int i=0;i<l;i+=4)
		{
			System.out.print("g("+g[i]+","+g[i+1]+")="+g[i+2]);
			System.out.print("\th("+g[i+1]+")="+h[g[i+1]]);
			System.out.print("\t\tf("+g[i]+","+g[i+1]+")="+g[i+3]);
			System.out.println();
		}
		System.out.println("Goal!!!");
		System.out.print("Path:");
		for(int i=0;i<m;i++)
			System.out.print(path[i]+" ");
		System.out.print("\nCost="+cost+"\n");
	}
}

/*
output:
Adjacency matrix
  0  7  8  9  0  0
  7  0 11  0  0 20
  8 11  0  0  4 12
  9  0  0  0 18  0
  0  0  4 18  0  6
  0 20 12  0  6  0

We start with root
g(0,0)=0	h(0)=16		f(0,0)=16
g(0,1)=7	h(1)=18		f(0,1)=25
g(0,2)=8	h(2)=8		f(0,2)=16
g(0,3)=9	h(3)=22		f(0,3)=31
g(2,1)=19	h(1)=18		f(2,1)=37
g(2,4)=12	h(4)=4		f(2,4)=16
g(2,5)=20	h(5)=0		f(2,5)=20
g(4,3)=30	h(3)=22		f(4,3)=52
g(4,5)=18	h(5)=0		f(4,5)=18
Goal!!!
Path:0 2 4 5 
Cost=18

*/
