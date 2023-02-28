//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//vector<int> path;
//vector<vector<int>> res;
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
//void backtrack(vector<int>& nums, int n, int cur, vector<bool>& used) {
//	if (cur == n) {
//		res.push_back(path);
//		return;
//	}
//	for (int i = 0; i < n; i++) {
//		if ((i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) || used[i]) { //若两数相同且前一数未使用则执行剪枝
//			continue;
//		}
//		path.push_back(nums[i]);
//		used[i] = true;
//		backtrack(nums, n, cur + 1, used);
//		used[i] = false;
//		path.pop_back();
//	}
//}
//
//int main() {
//	int n;
//	cout << "请输入数组长度: ";
//	cin >> n;
//	vector<int> nums(n);
//	cout << "请依次输入数组元素: ";
//	for (int i = 0; i < n; i++) {
//		cin >> nums[i];
//	}
//	sort(nums.begin(), nums.end());
//	vector<bool> used(n, false);
//	backtrack(nums, n, 0, used);
//	cout << "结果有: " << endl;
//	disp(res);
//	return 0;
//
//}