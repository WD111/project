//#include<iostream>
//#include<vector>
//#include<ctime>
//using namespace std;
//
//int BinarySearch(vector<int>& a, int l, int r, int x) {
//	if (l > r) {
//		return -1;
//	}
//	int m = (r - 1) / 2 + l;
//	if (a[m] == x) {
//		return m;
//	}
//	else if (a[m] > x) {
//		return BinarySearch(a, l, m - 1, x);
//	}
//	else {
//		return BinarySearch(a, m + 1, r, x);
//	}
//}
//
//int TripleSearch(vector<int> a, int l, int r, int x) {
//	if (l > r) {
//		return -1;
//	}
//	int one_third = l + (r - l) / 3;
//	int two_third = r - (r - l) / 3;
//	if (a[one_third] == x) {
//		return one_third;
//	}
//	else if (a[one_third] > x) {
//		return TripleSearch(a, l, one_third - 1, x);
//	}
//	else {
//		if (a[two_third] == x) {
//			return two_third;
//		}
//		else if (a[two_third] > x) {
//			return TripleSearch(a, one_third + 1, two_third - 1, x);
//		}
//		else {
//			return TripleSearch(a, two_third + 1, r, x);
//		}
//	}
//}
//
//int main() {
//	vector<int> a = { 0, 1, 2, 3, 4, 5, 6, 7 };
//	cout << "原始数组: ";
//	for (int i = 0; i < a.size(); i++) {
//		cout << a[i] << " ";
//	}
//	cout << endl;
//	int x;
//	cout << "请输入x: ";
//	cin >> x;
//	int m, n;
//	//m = BinarySearch(a, 0, a.size() - 1, x);
//	n = TripleSearch(a, 0, a.size() - 1, x);
//	//cout << m << endl;
//	cout << "找到" << endl;
//
//}