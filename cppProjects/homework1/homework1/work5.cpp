//#include<iostream>
//using namespace std;
//
//int divide(int n) {
//	if (n < 1) {
//		return -1;
//	}
//	else if (n == 1) {  //递归出口
//		return 1;
//	}
//	int num = 0;
//	for (int i = 2; i <= n; i++) {
//		if (n % i == 0) {
//			num += divide(n / i);  //递归查找n的因数的分解式个数
//		}                          //n的分解式个数为其因数的分解式个数之和
//	}
//	return num;
//}
//
//int main() {
//	int n;
//	cout << "输入n: ";
//	cin >> n;
//	cout << "分解式个数为: ";
//	cout << divide(n);
//	return 0;
//}