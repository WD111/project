//#include<iostream>
//#include<vector>
//using namespace std;
//
//vector<int> path_z;
//vector<int> path_p;
//vector<vector<int>> res;
//vector<vector<int>> temp;
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
//void backtrack_p(int cur, int n) {
//	if (cur == n) {
//		res.push_back(path_p);
//		return;
//	}
//	for (int i = cur; i < n; i++) {
//		swap(path_p[i], path_p[cur]);
//		backtrack_p(cur + 1, n);
//		swap(path_p[i], path_p[cur]);
//	}
//}
//
//void backtrack_z(int cur, int n, int m) {
//	if (path_z.size() + (n - cur + 1) < m) {
//		return; //若剩余元素的个数一定小于m，则直接撤销一步进行回溯
//	}
//	if (path_z.size() == m) {
//		path_p = path_z; //将已找到的组合赋给path_p
//		backtrack_p(0, m); //对path_p进行全排列操作
//		return;
//	}
//	path_z.push_back(cur);
//	backtrack_z(cur + 1, n, m);
//	path_z.pop_back();
//	backtrack_z(cur + 1, n, m);
//}
//
//int main() {
//	int n;
//	int m;
//	cout << "请输入n: ";
//	cin >> n;
//	cout << "请输入m: ";
//	cin >> m;
//	backtrack_z(1, n, m);
//	cout << "结果有:" << endl;
//	disp(res);
//	return 0;
//}