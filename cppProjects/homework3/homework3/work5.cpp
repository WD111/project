//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//int solve(vector<int>& nums) {
//	int res = 0;  //��¼��ǰ��ǵݼ����еĳ���
//	int n = nums.size();
//	int start = 0;  //��¼һ���ǵݼ����еĿ�ʼλ��
//	for (int i = 0; i < n; i++) {
//		if (i > 0 && nums[i] < nums[i - 1]) {
//			start = i;  //����ǰλ�õ�Ԫ��С��ǰһ��Ԫ�أ������start
//		}
//		res = max(res, i - start + 1); //����res��resΪ ԭres �� i-start+1 �����ֵ
//	}
//	return res;
//}
//
//int main() {
//	int n;
//	cout << "���������鳤��: ";
//	cin >> n;
//	vector<int> nums(n);
//	cout << "�����������������Ԫ��: ";
//	for (int i = 0; i < n; i++) {
//		cin >> nums[i];
//	}
//	int res = solve(nums);
//	cout << "��ǵݼ������еĳ���Ϊ: " << res;
//	return 0;
//
//}