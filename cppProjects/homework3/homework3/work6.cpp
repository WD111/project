//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//int solve(string s) {
//	int n = s.size();
//	if (n < 2) {
//		return 1; //特殊情况，字符串长度小于2时
//	}
//	int maxLen = 1;  //记录当前最长回文子串的长度
//	int begin = 0;
//	vector<vector<int>> dp(n, vector<int>(n));
//	for (int i = 0; i < n; i++) {
//		dp[i][i] = true;  //长度为1的字串均为回文串
//	}
//	for (int l = 2; l <= n; l++) { //l表示i到j的长度
//		for (int i = 0; i < n; i++) { //i为左边界
//			int j = l + i - 1; //由l和i确定右边界
//			if (j >= n) {
//				break; //右边界越界，退出循环
//			}
//			if (s[i] != s[j]) {
//				dp[i][j] = false;
//			}
//			else {  //s[i]==s[j]时
//				if (j - i < 3) {
//					dp[i][j] = true;
//				}
//				else {
//					dp[i][j] = dp[i + 1][j - 1]; //动态规划方程
//				}
//			}
//			if (dp[i][j] && j - i + 1 > maxLen) {
//				maxLen = j - i + 1;
//				begin = i;
//			}
//		}
//	}
//	cout << s.substr(begin, maxLen) << endl;
//	return maxLen;
//}
//
//int main() {
//	string s;
//	cout << "请输入字符串: ";
//	cin >> s;
//	int res = solve(s);
//	cout << "最长回文子串长度为: " << res;
//	return 0;
//}