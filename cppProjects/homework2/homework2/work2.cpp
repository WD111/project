//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//vector<vector<int>> res;
//vector<int> path;
//bool flag = false;
//
//void disp(vector<vector<int>> v) {
//	for (int i = 0; i < v.size(); i++) {
//		for (int j = 0; j < v[i].size(); j++) {
//			cout << v[i][j] << " ";
//		}
//		cout << endl;
//	}
//}
//
//void backtrack(int cur, int n, int rw, vector<int>& weight) {
//	if (!flag) {  //一种情况也未找到
//		if (rw == 0) {
//			flag = true;  //找到一种情况
//			res.push_back(path);
//			return;
//		}
//		for (int i = cur; i < n && rw - weight[cur] >= 0; i++) { // rw - weight[cur] >= 0 判断是否执行剪枝
//			if (i > cur && weight[i] == weight[i - 1]) { //临近两元素相等
//				continue;
//			}
//			path.push_back(weight[i]);
//			backtrack(i + 1, n, rw - weight[i], weight);
//			path.pop_back();
//		}
//	}
//}
//
////void backtrack(int cur, int n, int rw, vector<int>& weight) {
////	if (rw == 0) {
////		flag = true;
////		res.push_back(path);
////		return;
////	}
////	for (int i = cur; i < n && rw - weight[cur] >= 0; i++) {
////		if (i > cur && weight[i] == weight[i - 1]) {
////			continue;
////		}
////		path.push_back(weight[i]);
////		backtrack(i + 1, n, rw - weight[i], weight);
////		path.pop_back();
////	}
////}
//
//int main() {
//	int W;
//	int n;
//	cout << "请输入载重量: ";
//	cin >> W;
//	cout << "请输入集装箱数量: ";
//	cin >> n;
//	vector<int> weight(n);
//	cout << "请依次输入集装箱重量: ";
//	for (int i = 0; i < n; i++) {
//		cin >> weight[i];
//	}
//	sort(weight.begin(), weight.end());
//	backtrack(0, n, W, weight);
//	if (flag) {
//		cout << endl;
//		cout << "true" << endl;
//		cout << "找到的第一种情况为: ";
//		disp(res);
//	}
//	else {
//		cout << endl;
//		cout << "false";
//	}
//	return 0;
//}