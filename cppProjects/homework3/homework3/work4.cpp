//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
////int solve(int m, int n) {
////	vector<vector<int>> paths(m, vector<int>(n)); //����paths���飬�洢ÿ�����·����
////	for (int i = 0; i < m; i++) {
////		paths[i][0] = 1;  //��ʼ����һ�У�·������Ϊ1
////	}
////	for (int j = 0; j < n; j++) {
////		paths[0][j] = 1;  //��ʼ����һ�С�·������Ϊ1
////	}
////	for (int i = 1; i < m; i++) {
////		for (int j = 1; j < n; j++) {
////			paths[i][j] = paths[i - 1][j] + paths[i][j - 1];  //��̬�滮��ʽ
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
//	cout << "������m: ";
//	cin >> m;
//	cout << "������n: ";
//	cin >> n;
//	int res = solve(m, n);
//
//	cout << "·����Ϊ: ";
//	cout << res;
//	return 0;
//}