
public class RadixSort {
	
	/*
	 * find the number of bits in a number
	 */
	public int numberOfBits(int[] a){
		//int[] a={3,4,2,1,7};
		int n=a.length;
		if(n>0){
			int max=a[0];
			for(int i=0;i<n;i++){
				if(a[i]>max){
					max=a[i];
				}
			}
		
			if(max==0){
				return 1;
			}
			int b=0;
			while(max!=0){
				max=max/2;
				b++;
			}
			return b;
		}
		return 0;
	}
	
	/*
	 * traverse through all the bits and call method rs1() to sort them :O(n+k) where k is the number of max bits and n the number
	 * of elements in array
	 */
	private void rs(int nb,int[] a){
		for(int i=0;i<nb;i++){
			rs1(i,a);
		}
		
	}
	
	/*
	 * start sorting from the LSB
	 */
	private void rs1(int bit,int[] a){
		int n=a.length;
		int mask=1 << bit;
		int[] zeroa=new int[n];
		int t0=0;
		int[] onea= new int[n];
		int t1=0;
		
		for(int i=0;i<n;i++){
			if((a[i] & mask)!=0){ //looking for 1
				onea[t1++]=a[i];
			}
			else{
				zeroa[t0++]=a[i];
			}
		}
		int k=0;
		
		/* populate back the original array with the sorted column of LSB's*/
		for(int i=0; i<t0;i++){
			a[k++]=zeroa[i];
		}
		for(int i=0;i<t1;i++){
			a[k++]=onea[i];
		}
	} 
		
	/*
	 * sort the given array a
	 */
	public void sort(int[] a){
		int nb=numberOfBits(a);
		rs(nb,a);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadixSort r=new RadixSort();
		int[] a={170,45,75,90,802,2,24,66};
		r.sort(a);
		for(int i:a)
			System.out.println("Sorted array is:"+i+" ");
	}

}
