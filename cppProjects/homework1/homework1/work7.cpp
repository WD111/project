//#include<iostream>
//#include<vector>
//using namespace std;
//
//int findMin(vector<int>& nums) {
//	int l = 0;
//	int r = nums.size() - 1;
//	while (l < r) {
//		int m = (r - l) / 2 + l;
//		if (nums[m] < nums[r]) { //Ŀ��Ԫ���ڲ��ҷ�Χ���
//			r = m;               //���ұ߽����ƣ���Ϊm
//		}
//		else {
//			l = m + 1;          //Ŀ��Ԫ���ڲ��ҷ�Χ�Ҳ࣬��߽�����
//		}
//	}
//	return nums[l];
//}
//
//int main() {
//	int len;
//	cout << "�������鳤��: ";
//	cin >> len;
//	vector<int> nums(len);
//	cout << "������������Ԫ��: ";
//	for (int i = 0; i < len; i++) {
//		cin >> nums[i];
//	}
//
//	cout <<"��СԪ��Ϊ: " << findMin(nums);
//	return 0;
//}