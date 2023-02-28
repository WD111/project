//#include<iostream>
//#include<vector>
//using namespace std;
//
//int findI(vector<int>& a) {
//	int l = 0;
//	int r = a.size() - 1;
//	int m = 0;
//	while (l <= r) {
//		m = (r - l) / 2 + l;
//		if (a[m] == m) {
//			return m;
//		}
//		else if (a[m] < m) {
//			l = m + 1;
//		}
//		else {
//			r = m - 1;
//		}
//	}
//	return -1;
//}
//
//
//
//int main() {
//	int len;
//	cout << "输入数组长度: ";
//	cin >> len;
//	vector<int> a(len);
//	cout << "依次输入数组元素: ";
//	for (int j = 0; j < len; j++) {
//		cin >> a[j];
//	}
//	int i = findI(a);
//	if (i == -1) {
//		cout << "未找到";
//	}
//	else {
//		cout << "下标为: " << i;
//	}
//
//	return 0;
//}