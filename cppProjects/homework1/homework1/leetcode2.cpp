#include<iostream>
#include<vector>
using namespace std;
int minFallingPathSum(vector<vector<int>>& matrix) {
    
    int n = matrix.size();
    vector<vector<int>> dp = matrix;
    int res = INT_MAX;
    for (int i = n - 2; i >= 0; i--) {
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
            else if (j == n - 1) {
                dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j - 1]);
            }
            else {
                dp[i][j] = matrix[i][j] + min(dp[i + 1][j - 1], min(dp[i + 1][j], dp[i + 1][j + 1]));
            }
            if (i == 0) {
                res = min(dp[i][j], res);
            }
        }
    }
    return res;
}
int main() {
    vector<vector<int>> m = { {2, 1, 3}, {6, 5, 4}, {7, 8, 9} };
    minFallingPathSum(m);
    return 0;
}