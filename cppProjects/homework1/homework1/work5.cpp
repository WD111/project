//#include<iostream>
//using namespace std;
//
//int divide(int n) {
//	if (n < 1) {
//		return -1;
//	}
//	else if (n == 1) {  //�ݹ����
//		return 1;
//	}
//	int num = 0;
//	for (int i = 2; i <= n; i++) {
//		if (n % i == 0) {
//			num += divide(n / i);  //�ݹ����n�������ķֽ�ʽ����
//		}                          //n�ķֽ�ʽ����Ϊ�������ķֽ�ʽ����֮��
//	}
//	return num;
//}
//
//int main() {
//	int n;
//	cout << "����n: ";
//	cin >> n;
//	cout << "�ֽ�ʽ����Ϊ: ";
//	cout << divide(n);
//	return 0;
//}