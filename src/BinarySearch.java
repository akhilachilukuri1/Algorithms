
public class BinarySearch {
	public static int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid=(nums.length-1)/2;
        while(mid>=0&&mid<=nums.length-1)
        {
            if(target==nums[mid])
            {
                return mid;
            }
            else
            if(target>nums[mid])
            {
                start=mid+1;
                mid=(mid+1+end)/2;
            }
            else if(target<nums[mid])
            {
                end=mid-1;
                mid=(start+mid-1)/2;
            }
           
        }
        return -1;
    }
	public static void main(String []args)
	{
		int nums[]= {-1,0,3,5,9,12};
		System.out.println(search(nums,2));
	}
}
