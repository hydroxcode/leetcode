class Solution {
    public int search(int[] arr, int target) {
        int b=0;
        int r = arr.length-1;

        while(b<=r){
            int mid=b+(r-b)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                b=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }
}