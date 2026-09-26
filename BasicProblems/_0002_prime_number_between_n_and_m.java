import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _0002_prime_number_between_n_and_m{
    public static void main(String[] args){
        IO.print(new _0002_prime_number_between_n_and_m().func(10,30));
    }
    public List<Integer> func(int n, int m){
        boolean[] hash = new boolean[m+1];
        Arrays.fill(hash,true);
        for(int i = 2; i<Math.sqrt(m); i++){
            if(hash[i]==true){
                for(int j = i*i; j<=m; j+=i){
                    hash[j]=false;
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        // IO.print(Arrays.toString(hash));
        for(int i = n; i < m+1; i ++){
            if(hash[i]){
                result.add(i);
            }
        }
        return result;
    }
}
