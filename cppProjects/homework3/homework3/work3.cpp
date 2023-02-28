//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//bool cmp(vector<int> m, vector<int> n) {
//	return m[0] > n[0];
//}
//
//int solve(int W, vector<vector<int>> coins, int n) {
//	int count = 0;
//	for (int i = 0; i < n; i++) {
//		int temp = min(W / coins[i][0], coins[i][1]); //选择最大面额的硬币且数量尽可能多
//		W -= temp * coins[i][0]; //更新 W 的值
//		if (temp != 0) {
//			cout << "选择面额为 " << coins[i][0] << " 的金币 " << temp << " 枚" << endl;
//		}
//		count += temp; //计算硬币数量
//	}
//	return count;
//}
//
//int main() {
//	int n;
//	int W;
//	cout << "请输入所需硬币价值: ";
//	cin >> W;
//	cout << "请输入硬币种类数量: ";
//	cin >> n;
//	vector<vector<int>> coins(n, vector<int>(2, 0));
//	cout << "请依次输入硬币面额及数量: " << endl;
//	for (int i = 0; i < n; i++) {
//		for (int j = 0; j < 2; j++) {
//			cin >> coins[i][j];
//		}
//	}
//	cout << endl;
//	sort(coins.begin(), coins.end(), cmp);
//	cout << "排序后的硬币数组为: " << endl;
//	for (int i = 0; i < n; i++) {
//		for (int j = 0; j < 2; j++) {
//			cout << coins[i][j] << " ";
//		}
//		cout << endl;
//	}
//	cout << endl;
//	cout << "选择过程如下: " << endl;
//	int res = solve(W, coins, n);
//	cout << endl;
//	cout << "所需硬币个数为: " << res;
//	return 0;
//}