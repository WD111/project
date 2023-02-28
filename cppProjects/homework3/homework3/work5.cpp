//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//int solve(vector<int>& nums) {
//	int res = 0;  //记录当前最长非递减序列的长度
//	int n = nums.size();
//	int start = 0;  //记录一个非递减序列的开始位置
//	for (int i = 0; i < n; i++) {
//		if (i > 0 && nums[i] < nums[i - 1]) {
//			start = i;  //若当前位置的元素小于前一个元素，则更新start
//		}
//		res = max(res, i - start + 1); //更新res，res为 原res 和 i-start+1 的最大值
//	}
//	return res;
//}
//
//int main() {
//	int n;
//	cout << "请输入数组长度: ";
//	cin >> n;
//	vector<int> nums(n);
//	cout << "请依次输入数组各个元素: ";
//	for (int i = 0; i < n; i++) {
//		cin >> nums[i];
//	}
//	int res = solve(nums);
//	cout << "最长非递减子序列的长度为: " << res;
//	return 0;
//
//}