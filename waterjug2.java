import java.util.*;
//In this program choice will be made based on user's choice

class waterjug2{
	public static void main(String ar[]){
		int d=2,x,y;
		int jug1=0,jug2=0;
		System.out.println("Enter value of capacity of jug1, capacity of jug2, to be filled capacity");
		System.out.println("Provided c(jug1)>c(jug2)");
		Scanner sc = new Scanner(System.in);
		x=sc.nextInt();
		y=sc.nextInt();
		d=sc.nextInt();
		
		while(jug1!=d){
			System.out.println("\n1:Fill 3G \n2:Fill 4G\n3:Empty 3G\n4:Empty 4G\n5:Transfer all water form 3G to 4G\n6:Transfer all water form 4G to 3G\n7:Transfer some water form 3G to 4G\n8:Transfer some water form 4G to 3G\n ");
			int ch=sc.nextInt();
			switch(ch){
				case 1:
					if(jug2<y)
						jug2=y;
					System.out.println("JUG1="+jug1+",JUG2="+jug2);
					break;
				case 2:
					if(jug1<x)
						jug1=x;
					System.out.println("JUG1="+jug1+",JUG2="+jug2);
					break;
				case 3:
					if(jug2>0)
						jug2=0;
					System.out.println("JUG1="+jug1+",JUG2="+jug2);
					break;
				case 4:
					if(jug1>0)
						jug1=0;
					System.out.println("JUG1="+jug1+",JUG2="+jug2);
					break;
				case 5:
					if(jug1+jug2<=x && jug2>0){
					jug1=jug1+jug2;
					jug2=0;
					}
					System.out.println("JUG1="+jug1+",JUG2="+jug2);
					break;
				case 6:
					if(jug1+jug2<=y && jug1>0){
					jug2=jug1+jug2;
					jug1=0;
					}
					System.out.println("JUG1="+jug1+",JUG2="+jug2);
					break;
				case 7:
					if(jug1+jug2>x && jug2>0){
					jug2=jug2-(x-jug1);
					jug1=x;
					}
					System.out.println("JUG1="+jug1+",JUG2="+jug2);
					break;
				case 8:
					if(jug1+jug2>y && jug1>0){
					jug1=jug1-(y-jug2);
					jug2=y;
					}
					System.out.println("JUG1="+jug1+",JUG2="+jug2);
					break;
				default:System.out.println("JUG1="+jug1+",JUG2="+jug2+"\nInvalid choice");
			}
		}
	}
}

/*
Output:
Enter value of capacity of jug1, capacity of jug2, to be filled capacity
Provided c(jug1)>c(jug2)
4
3
2

1:Fill 3G 
2:Fill 4G
3:Empty 3G
4:Empty 4G
5:Transfer all water form 3G to 4G
6:Transfer all water form 4G to 3G
7:Transfer some water form 3G to 4G
8:Transfer some water form 4G to 3G
 
1
JUG1=0,JUG2=3

1:Fill 3G 
2:Fill 4G
3:Empty 3G
4:Empty 4G
5:Transfer all water form 3G to 4G
6:Transfer all water form 4G to 3G
7:Transfer some water form 3G to 4G
8:Transfer some water form 4G to 3G
 
5
JUG1=3,JUG2=0

1:Fill 3G 
2:Fill 4G
3:Empty 3G
4:Empty 4G
5:Transfer all water form 3G to 4G
6:Transfer all water form 4G to 3G
7:Transfer some water form 3G to 4G
8:Transfer some water form 4G to 3G
 
1
JUG1=3,JUG2=3

1:Fill 3G 
2:Fill 4G
3:Empty 3G
4:Empty 4G
5:Transfer all water form 3G to 4G
6:Transfer all water form 4G to 3G
7:Transfer some water form 3G to 4G
8:Transfer some water form 4G to 3G
 
7
JUG1=4,JUG2=2

1:Fill 3G 
2:Fill 4G
3:Empty 3G
4:Empty 4G
5:Transfer all water form 3G to 4G
6:Transfer all water form 4G to 3G
7:Transfer some water form 3G to 4G
8:Transfer some water form 4G to 3G
 
4
JUG1=0,JUG2=2

1:Fill 3G 
2:Fill 4G
3:Empty 3G
4:Empty 4G
5:Transfer all water form 3G to 4G
6:Transfer all water form 4G to 3G
7:Transfer some water form 3G to 4G
8:Transfer some water form 4G to 3G
 
5
JUG1=2,JUG2=0

*/
