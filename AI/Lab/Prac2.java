import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
public class Solution{
static int mod=(int)1e9+7;
static long mod1=998244353;
static FastScanner sc = new FastScanner();
static StringBuffer as;
public static void solve(){
 int[][] dp=sc.read2dArray(3,3);
 Queue<int[][]> q=new LinkedList<>();
 Set<String> set=new HashSet<>();
 q.add(dp);
 set.add(getString(dp));
 outer:while (!q.isEmpty()) {
   int sz=q.size();
   while (sz-->0) {
     int[][] state=q.poll();
     for (int i=0;i<3;i++) {
       for (int j=0;j<3;j++) {
         System.out.print(state[i][j]+" ");
       }
       System.out.println("");
     }
     
     if (isDone(state)) {
        System.out.println("Final State");
        for (int i=0;i<3;i++) {
          for (int j=0;j<3;j++) {
            System.out.print(state[i][j]+" ");
          }
          System.out.println("");
        }
       break outer;
     }
     for (int i=0;i<3;i++) {
       for (int j=0;j<3;j++) {
         if (state[i][j]==0) {
           if (i-1>=0) {
             int up=state[i-1][j];
             state[i][j]=up;
             state[i-1][j]=0;
             if (!set.contains(getString(state))) {
             int[][] copy = Arrays.stream(state).map(int[]::clone).toArray(int[][]::new);
             q.add(copy);
             set.add(getString(copy));
             }
             state[i-1][j]=up;
             state[i][j]=0;
           }
           if (i+1<3) {
             int down=state[i+1][j];
             state[i][j]=down;
             state[i+1][j]=0;
             if (!set.contains(getString(state))) {
             int[][] copy = Arrays.stream(state).map(int[]::clone).toArray(int[][]::new);
             q.add(copy);
             set.add(getString(copy));
             }
             state[i+1][j]=down;
             state[i][j]=0;
           }
           if (j-1>=0) {
             int left=state[i][j-1];
             state[i][j]=left;
             state[i][j-1]=0;
             if (!set.contains(getString(state))) {
             int[][] copy = Arrays.stream(state).map(int[]::clone).toArray(int[][]::new);
             q.add(copy);
             set.add(getString(copy));
             }
             state[i][j-1]=left;
             state[i][j]=0;
           }
           if (j+1<3) {
             int right=state[i][j+1];
             state[i][j]=right;
             state[i][j+1]=0;
             if (!set.contains(getString(state))) {
             int[][] copy = Arrays.stream(state).map(int[]::clone).toArray(int[][]::new);
             q.add(copy);
             set.add(getString(copy));
             }
             state[i][j+1]=right;
             state[i][j]=0;
           }
         }

       }
     }
   }
 }
}
public static String getString(int[][] dp){
  String str="";
  for (int i=0;i<3;i++) {
    for (int j=0;j<3;j++) {
      str+=dp[i][j]+"";
    }
  }
  return str;
}
public static boolean isDone(int[][] dp){
  ArrayList<Integer> check=new ArrayList<>();
  for (int i=0;i<3;i++) {
    for (int j=0;j<3;j++) {
      check.add(dp[i][j]);
    }
  }

  if (check.get(0)==0) {
    for (int i=1;i<=8;i++) {
      if (check.get(i)!=i) {
        return false;
      }
    }
    return true;
  }
  if (check.get(8)==0) {
    for (int i=0;i<8;i++) {
      if (check.get(i)!=i+1) {
        return false;
      }
    }
    return true;
  }
  return false;
}
public static void main(String[] args) {
  solve();
}
static int[] leftRotate(int arr[], int n, int k)
{
      int[] b=new int[n];
        int mod = k % n;
    for (int i = 0; i < n; ++i)
            b[i]=arr[(i + mod) % n] ;
 
        return b;
}
static boolean isSubSequence(String str1, String str2,
                                 int m, int n)
    {
        int j = 0;
    for (int i = 0; i < n && j < m; i++)
            if (str1.charAt(j) == str2.charAt(i))
                j++;
        return (j == m);
    }
  static int reverseDigits(int num)
    {
        int rev_num = 0;
        while (num > 0) {
            rev_num = rev_num * 10 + num % 10;
            num = num / 10;
        }
        return rev_num;
    }
    /* Function to check if n is Palindrome*/
    static boolean isPalindrome(int n)
    {
        // get the reverse of n
        int rev_n = reverseDigits(n);
     
        // Check if rev_n and n are same or not.
        if (rev_n == n)
            return true;
        else
            return false;
    }
static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
  
        if (n % 2 == 0 || n % 3 == 0)
            return false;
  
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
  
        return true;
    }
public static int[] LPS(String s){
  int[] lps=new int[s.length()];
  int i=0,j=1;
  while (j<s.length()) {
    if(s.charAt(i)==s.charAt(j)){
      lps[j]=i+1;
      i++;
      j++;
      continue;
    }else{
      if (i==0) {
        j++;
        continue;
      }
      i=lps[i-1];
      while(s.charAt(i)!=s.charAt(j) && i!=0) {
        i=lps[i-1];
      }
      if(s.charAt(i)==s.charAt(j)){
      lps[j]=i+1;
      i++;
      }
      j++;
    }
  }
  return lps;
}
static long getPairsCount(int n, double sum,int[] arr)
    {
        HashMap<Double, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey((double)arr[i]))
                hm.put((double)arr[i], 0);
            hm.put((double)arr[i], hm.get((double)arr[i]) + 1);
        }
        long twice_count = 0;
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null)
                twice_count += hm.get(sum - arr[i]);
            if (sum - (double)arr[i] == (double)arr[i])
                twice_count--;
        }
        return twice_count / 2l;
    }
static boolean[] sieveOfEratosthenes(int n)
    {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
 
        for (int p = 2; p * p <= n; p++)
        {
            if (prime[p] == true)
            {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        prime[1]=false;
        return prime;
 }
static long power(long x, long y, long p)
  {
    long res = 1l; 
    x = x % p;
    if (x == 0)
      return 0;
    while (y > 0)
    {

      if ((y & 1) != 0)
        res = (res * x) % p;
      y>>=1;
      x = (x * x) % p;
    }
    return res;
  }

public static int log2(int N)
    {
        int result = (int)(Math.log(N) / Math.log(2));
  
        return result;
    }

////////////////////////////////////////////////////////////////////////////////////
////////////////////DO NOT READ AFTER THIS LINE //////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////
static long modFact(int n, 
                       int p) 
    { 
        if (n >= p) 
            return 0; 
      
        long result = 1l; 
        for (int i = 2; i <= n; i++) 
            result = (result * i) % p; 
      
        return result; 
    } 
  public static String reverseString(String str){  
  char ch[]=str.toCharArray();  
  String rev="";  
  for(int i=ch.length-1;i>=0;i--){  
    rev+=ch[i];  
  }  
  return rev;  
  }  
static boolean isPalindrom(char[] arr, int i, int j) {
  boolean ok = true;
  while (i <= j) {
    if (arr[i] != arr[j]) {
      ok = false;
      break;
    }
    i++;
    j--;
  }
  return ok;
}

static int max(int a, int b) {
  return Math.max(a, b);
}

static int min(int a, int b) {
  return Math.min(a, b);
}

static long max(long a, long b) {
  return Math.max(a, b);
}

static long min(long a, long b) {
  return Math.min(a, b);
}

static int abs(int a) {
  return Math.abs(a);
}

static long abs(long a) {
  return Math.abs(a);
}

static void swap(long arr[], int i, int j) {
  long temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

static void swap(int arr[], int i, int j) {
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

static int maxArr(int arr[]) {
  int maxi = Integer.MIN_VALUE;
  for (int x : arr)
    maxi = max(maxi, x);
  return maxi;
}

static int minArr(int arr[]) {
  int mini = Integer.MAX_VALUE;
  for (int x : arr)
    mini = min(mini, x);
  return mini;
}

static long maxArr(long arr[]) {
  long maxi = Long.MIN_VALUE;
  for (long x : arr)
    maxi = max(maxi, x);
  return maxi;
}

static long minArr(long arr[]) {
  long mini = Long.MAX_VALUE;
  for (long x : arr)
    mini = min(mini, x);
  return mini;
}
static int lcm(int a,int b){
  return (int)(((long)a*b)/(long)gcd(a,b));
}
static long lcm(long a,long b){
  return ((a*b)/(long)gcd(a,b));
}
static int gcd(int a, int b) {
  if (b == 0)
    return a;
  return gcd(b, a % b);
}

static long gcd(long a, long b) {
  if (b == 0)
    return a;
  return gcd(b, a % b);
}

static void ruffleSort(int[] a) {
  int n = a.length;
  Random r = new Random();
  for (int i = 0; i < a.length; i++) {
    int oi = r.nextInt(n);
    int temp = a[i];
    a[i] = a[oi];
    a[oi] = temp;
  }
  Arrays.sort(a);
}

public static int binarySearch(int a[], int target) {
  int left = 0;
  int right = a.length - 1;
  int mid = (left + right) / 2;
  int i = 0;
  while (left <= right) {
    if (a[mid] <= target) {
      i = mid + 1;
      left = mid + 1;
    } else {
      right = mid - 1;
    }
    mid = (left + right) / 2;
  }
  return i-1;
}


static class FastScanner {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next() {
    while (!st.hasMoreTokens())
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    return st.nextToken();
  }

  int nextInt() {
    return Integer.parseInt(next());
  }

  int[] readArray(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = nextInt();
    return a;
  }

  long[] readLongArray(int n) {
    long[] a = new long[n];
    for (int i = 0; i < n; i++)
      a[i] = nextLong();
    return a;
  }

  int[][] read2dArray(int n, int m) {
    int arr[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = nextInt();
      }
    }
    return arr;
  }

  ArrayList<Integer> readArrayList(int n) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      int a = nextInt();
      arr.add(a);
    }
    return arr;
  }

  long nextLong() {
    return Long.parseLong(next());
  }
}
 static class SegmentTree {
      int seg[];
      int arr[];
      int n;
 
      public SegmentTree(int arr[], int n) {
        this.n = n;
        seg = new int[n * 4];
        this.arr = arr;
      }
       int task(int a, int b) {
        return Math.min(a, b);// TO DO
      }
 
       int mSeg(int i, int l, int r) {
        if (l == r) {
          seg[i] = task(arr[l], arr[l]);
          return arr[l];
        }
        int m = (l + r) / 2;
        return seg[i] = task(mSeg(2 * i + 1, l, m), mSeg(2 * i + 2, m + 1, r));
      }
 
       int qSeg(int ql, int qr, int i, int l, int r) {
        if (r < ql || l > qr)
          return Integer.MAX_VALUE;// TO DO
        if (ql <= l && qr >= r)
          return seg[i];
        int m = (l + r) / 2;
        return task(qSeg(ql, qr, 2 * i + 1, l, m), qSeg(ql, qr, 2 * i + 2, m + 1, r));
      }
    }
 static class Pair{
      int x, y;
        Pair(int x, int y){
             this.x=x;
             this.y=y;
        }
    }

  }
