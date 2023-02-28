//#include<iostream>
//#include<vector>
//using namespace std;
//
//int findMin(vector<int>& nums) {
//	int l = 0;
//	int r = nums.size() - 1;
//	while (l < r) {
//		int m = (r - l) / 2 + l;
//		if (nums[m] < nums[r]) { //目标元素在查找范围左侧
//			r = m;               //将右边界左移，置为m
//		}
//		else {
//			l = m + 1;          //目标元素在查找范围右侧，左边界右移
//		}
//	}
//	return nums[l];
//}
//
//int main() {
//	int len;
//	cout << "输入数组长度: ";
//	cin >> len;
//	vector<int> nums(len);
//	cout << "依次输入数组元素: ";
//	for (int i = 0; i < len; i++) {
//		cin >> nums[i];
//	}
//
//	cout <<"最小元素为: " << findMin(nums);
//	return 0;
//}