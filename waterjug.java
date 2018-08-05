import java.util.*;

class waterjug{
	public static void main(String ar[]){
		int d=2,x,y;
		int jug1=0,jug2=0;
		System.out.println("Enter value of capacity of jug1, capacity of jug2, to be filled capacity");
		System.out.println("Provided c(jug1)>c(jug2)");
		Scanner sc = new Scanner(System.in);
		x=sc.nextInt();
		y=sc.nextInt();
		d=sc.nextInt();
		//here actual logic starts
		System.out.println("Solution1:");
		while(jug1!=d){
			if(jug1==0){
				jug1=x;
				System.out.println("JUG1="+jug1+",JUG2="+jug2);
				if(jug1==d)
				break;
			}
			if(jug1+jug2>y && jug1>0){
				jug1=jug1-(y-jug2);
				jug2=y;
				System.out.println("JUG1="+jug1+",JUG2="+jug2);
				if(jug1==d)
				break;
			}
			if(jug2>0){
				jug2=0;
				System.out.println("JUG1="+jug1+",JUG2="+jug2);
				if(jug1==d)
				break;
			}
			if(jug1+jug2<=y && jug1>0){
				jug2=jug1+jug2;
				jug1=0;
				System.out.println("JUG1="+jug1+",JUG2="+jug2);
				if(jug1==d)
				break;
			}
		}
		System.out.println();
		System.out.println("Solution2:");
		jug1=0;jug2=0;
		while(jug1!=d){
			if(jug2==0){
				jug2=y;
				System.out.println("JUG1="+jug1+",JUG2="+jug2);
				if(jug1==d)
				break;
			}
			if(jug1+jug2<=x && jug2>0){
				jug1=jug1+jug2;
				jug2=0;
				System.out.println("JUG1="+jug1+",JUG2="+jug2);
				if(jug1==d)
				break;
			}
			if(jug1+jug2>4 && jug2>0){
				jug2=jug2-(x-jug1);
				jug1=x;
				System.out.println("JUG1="+jug1+",JUG2="+jug2);
				if(jug1==d)
				break;
			}
			if(jug1==x){
				jug1=0;
				System.out.println("JUG1="+jug1+",JUG2="+jug2);
				if(jug1==d)
				break;
			}
		}
	}
}