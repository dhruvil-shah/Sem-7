import java.util.*;
import java.io.*;
public class Prac1_Rsa
{
public static void main(String[] args) {
ArrayList<Integer> prime =genPrime(20);
Random random=new Random();
int p=prime.get(random.nextInt(prime.size()));
int q=p;
while(p==q){
   q=prime.get(random.nextInt(prime.size()));
}
int n=p*q;
int phi_n=(p-1)*(q-1);
int e=-1;
for(int i=2;i<phi_n;i++){
   if(gcd(i,phi_n)==1){
       e=i;
       break;
   }
}
// (e*d)%phi_n=1;
int d=1;
while((d==p) || (d==q) || (e*d)%phi_n!=1 ){
   d++;
}
int message=5;
long encrypt=((long)Math.pow((message),e))%n;
        long decrypt=((long)Math.pow((encrypt),d))%n;
if(decrypt==message){
   System.out.println("Correct!!");
}else{
   System.out.println("Sorry Incorrect!!");
}
}
public static int gcd(int a,int b){
   if(b==0){
       return a;
   }
   return gcd(b,a%b);
}
public static ArrayList<Integer> genPrime(int n){
   ArrayList<Integer> primeList =new ArrayList<Integer>();
   boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for(int i = 2; i <= n; i++)
        {
            if(prime[i])
            primeList.add(i);
        }
        return primeList;
   
}
}

