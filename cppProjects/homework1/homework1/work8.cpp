/*#include<iostream>
#include<vector>
using namespace std;


bool backtracking(vector<double>& nums) {
	if (nums.size() == 1) {
		return abs(nums[0] - 24) <= 1e-6;  //回溯终止条件，只有一个数时与24比较
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
				if (k == i || k == j) {  //保证取出两个不同的数
					continue;
				}
				nums_remainder.push_back(nums[k]);//剩余数放入剩余数组
			}
			//计算出两个数加减乘除的结果
			double sum = a + b;
			double sub = a - b;
			double mul = a * b;
			double div = a / b;
			double operation[4] = { sum, sub, mul, div };
			for (int l = 0; l < 4; l++) {
				nums_remainder.push_back(operation[l]);
				if (backtracking(nums_remainder)) {
					return true;  //回溯依次判断剩余两个数与前两个数四则运算结果的可能
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
	cout << "依次输入1-9的4个数字: ";
	for (int i = 0; i < 4; i++) {
		cin >> cards[i];
	}

	if (judgePoint24(cards)) {
		cout << "成功";
	}
	else {
		cout << "失败";
	}
}*/