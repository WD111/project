//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
////int solve(int m, int n) {
////	vector<vector<int>> paths(m, vector<int>(n)); //定义paths数组，存储每个点的路径数
////	for (int i = 0; i < m; i++) {
////		paths[i][0] = 1;  //初始化第一列，路径数均为1
////	}
////	for (int j = 0; j < n; j++) {
////		paths[0][j] = 1;  //初始化第一行。路径数均为1
////	}
////	for (int i = 1; i < m; i++) {
////		for (int j = 1; j < n; j++) {
////			paths[i][j] = paths[i - 1][j] + paths[i][j - 1];  //动态规划公式
////		}
////	}
////	return paths[m - 1][n - 1];
////}
//
//int solve(int m, int n) {
//	long long res = 1;
//	for (int x = n, y = 1; y < m; x++, y++) {
//		res = res * x / y;
//	}
//	return res;
//}
//
//
//int main() {
//	int m;
//	int n;
//	cout << "请输入m: ";
//	cin >> m;
//	cout << "请输入n: ";
//	cin >> n;
//	int res = solve(m, n);
//
//	cout << "路径数为: ";
//	cout << res;
//	return 0;
//}