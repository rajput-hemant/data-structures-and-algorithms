package recursion;

import java.util.Scanner;

// Number of ways to invite n people to party, single of in pair
public class PartyInvite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of people you want to invite -> ");
        int n = sc.nextInt();
        System.out.print("Total ways to invite '" + n + "' people -> " + partyInvite(n));
        sc.close();
    }
    static int partyInvite(int n) {
        // base case
        if(n <= 1)
            return 1;
        // single
        int single = partyInvite(n-1);
        // in pairs
        int pairs = (n-1) * partyInvite(n-2);
        return pairs + single;
    }
}
