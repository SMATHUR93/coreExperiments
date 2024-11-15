package com.shrek.leetCode._019_Math;

/**
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Constraints:
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -104 <= xn <= 104
 *
 */

public class _134M_PowXN {

    public double myPow(double x, int n) {
        double ans = 1;
        long pow = n;
        if(pow<0){
            pow *= -1;
        }
        while(pow>0){
            if(pow%2==1){
                ans = ans*x;
                pow = pow-1;
                //System.out.println("Debugging odd, ans = "+ans+" , x = "+x+" and pow = "+pow);
            } else{
                x = x*x;
                pow = pow/2;
                //System.out.println("Debugging even, ans = "+ans+" , x = "+x+" and pow = "+pow);
            }
        }
        // ans=ans*x;
        if(n<0){
            ans = (double)(1.0) / (double)(ans);
        }
        return ans;
    }

}
