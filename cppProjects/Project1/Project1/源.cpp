#include<iostream>
#include<vector>
#include<queue>
#include<unordered_set>
using namespace std;

int longestCommonSubsequence(string text1, string text2) {
    int m = text1.length();
    int n = text2.length();
    if (m == 1 && n == 1) {
        return text1[0] == text2[0] ? 1 : 0;
    }
    vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
            else {
                dp[i][j] = max(dp[i - 1][j], max(dp[i - 1][j - 1], dp[i][j - 1]));
            }
        }
    }
    return dp[m][n];
}



int main() {
    string a;
    string b;
    cin >> a;
    cin >> b;
    int res = longestCommonSubsequence(a, b);
    cout << res;
    return 0;
}