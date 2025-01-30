import java.util.*;
class PriorityQueue{
	public static boolean insert ( int [] a,int n){
		int i=n;
		int item =a[n];
		while((i>1) && (item>a[(int).Math.floor(i/2)])){
			a[i]=a[(int).Math.floor(i/2)];
			i=(int)Math.floor(i/2);
		}
		
		a[i]=item;
		return true;
	}
	public static boolean DeleteMAx(int[] a,int n,int x){
		if(n==0){
			System.out.println("Heap is empty!");
			return false;
		}
		
		x=a[i];
		a[i]=a[n];
		Adjust(a,1,n-1);
		return true;
	}
	public static void Adjust(int[] a,int i,int n){
		int j=2*i;
		int item=a[i];
		while(j<=n){
			if((j<n)&& (a[j] < a[j+1])){
				j=j+1;
			}
			if(item>= a[j]){
				break;
			}
			a[[j/2]]=a[j];
			j=2*j;
		}
		a[[j/2]]=item;
	}
	public static void sort(int[] a,int i){
		int x=0;
		for(int i=0;i<n;i++){
			insert(a,i);
		}
		for(int i=n;i>n;i--){
			DelMax(a,i,x);
			a[i]=x;
		}
	}
	public static void main(String[]  args){
		Scanner sc
	}
}
	
