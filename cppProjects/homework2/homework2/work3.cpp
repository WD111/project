//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//vector<vector<int>> res;
//vector<int> path;
//bool flag = false;
//int k;
//int n;
//int minSize;
//
//void init() {
//	cout << "请输入目标值: ";
//	cin >> k;
//	cout << "请输入数组长度: ";
//	cin >> n;
//	minSize = n;
//}
//
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
////void backtrack(int cur, int n, int rw, vector<int>& weight) {
////	if (flag == false) {
////		if (rw == 0) {
////			flag = true;
////			return;
////		}
////		for (int i = cur; i < n && rw - weight[cur] >= 0; i++) {
////			if (i > cur && weight[i] == weight[i - 1]) {
////				continue;
////			}
////			path.push_back(weight[i]);
////			backtrack(i + 1, n, rw - weight[i], weight);
////			path.pop_back();
////		}
////	}
////}
//
//void backtrack(int cur, int rw, vector<int>& weight) {
//	if (rw == 0 && path.size() <= minSize) {
//		if (path.size() == minSize) { // 若最新查找的结果与已知最小数量相等
//			res.push_back(path); //直接记录该结果
//		}
//		else { // 若最新查找的情况小于已知最小数量
//			res.clear(); // 将已找到的的结果全部清除
//			minSize = path.size(); // 更新最小数量
//			res.push_back(path); // 记录最新结果
//		}
//		return;
//	}
//	for (int i = cur; i < n && rw - weight[cur] >= 0; i++) {
//		if (i > cur && weight[i] == weight[i - 1]) {
//			continue;
//		}
//		path.push_back(weight[i]);
//		backtrack(i + 1, rw - weight[i], weight);
//		path.pop_back();
//	}
//}
//
//int main() {
//	init();
//	vector<int> weight(n);
//	cout << "请依次输入数组元素: ";
//	for (int i = 0; i < n; i++) {
//		cin >> weight[i];
//	}
//	sort(weight.begin(), weight.end());
//	backtrack(0, k, weight);
//	if (res.size() > 0) {
//		cout << "最小长度为: " << minSize << endl;
//		cout << "结果有: " << endl;
//		disp(res);
//	}
//	else {
//		cout << "未找到";
//	}
//	return 0;
//}