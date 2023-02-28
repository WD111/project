/*#include<iostream>
#include<vector>
using namespace std;


bool backtracking(vector<double>& nums) {
	if (nums.size() == 1) {
		return abs(nums[0] - 24) <= 1e-6;  //������ֹ������ֻ��һ����ʱ��24�Ƚ�
	}                                      //

	for (int i = 0; i < nums.size(); i++) {
		for (int j = 0; j < nums.size(); j++) {
			if (i == j) {
				continue;
			}
			double a = nums[i];
			double b = nums[j];
			vector<double> nums_remainder;
			for (int k = 0; k < nums.size(); k++) {
				if (k == i || k == j) {  //��֤ȡ��������ͬ����
					continue;
				}
				nums_remainder.push_back(nums[k]);//ʣ��������ʣ������
			}
			//������������Ӽ��˳��Ľ��
			double sum = a + b;
			double sub = a - b;
			double mul = a * b;
			double div = a / b;
			double operation[4] = { sum, sub, mul, div };
			for (int l = 0; l < 4; l++) {
				nums_remainder.push_back(operation[l]);
				if (backtracking(nums_remainder)) {
					return true;  //���������ж�ʣ����������ǰ�����������������Ŀ���
				}
				nums_remainder.pop_back();
			}
		}
	}
	return false;
}
bool judgePoint24(vector<int>& cards) {
	vector<double> nums;
	for (int x : cards) {
		nums.push_back((double)x);
	}
	return backtracking(nums);
}

int main() {
	vector<int> cards(4);
	cout << "��������1-9��4������: ";
	for (int i = 0; i < 4; i++) {
		cin >> cards[i];
	}

	if (judgePoint24(cards)) {
		cout << "�ɹ�";
	}
	else {
		cout << "ʧ��";
	}
}*/