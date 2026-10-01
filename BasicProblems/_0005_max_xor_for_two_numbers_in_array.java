import java.util.HashSet;
class max_xor_for_two_numbers_in_array{
    public static void main(String[] args){
        int arr[] = {0,1,0,0,1024};
        HashSet<Integer> set = new HashSet<>();
        int mask=0,res=0,curr=0;
        for(int i = 31; i >= 0 ; i --){
            mask |= (1<<i);
            for(int val: arr){
                set.add(mask & val);
            }
            curr = res | (1<<i);
            for(int val: set){
                if(set.contains(val^curr)){
                    res = curr;
                }
            }
            set.clear();
        }
        IO.print(to_binary(res));
        IO.print("\n");
    }
    public static String to_binary(int num){
        String res = "";
        for(int i = 31; i >= 0; i--){
            if((num&(1<<i))!=0){
                res = res + "1";
            }
            else{
                res = res + "0";
            }
        }
        return res;
    }
}
