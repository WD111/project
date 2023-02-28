//#include<iostream>
//#include<vector>
//using namespace std;
//
// void swap(int& a, int& b) {
//	int temp = a;
//	a = b;
//	b = temp;
//}
//
//void findKsmall(vector<int>& a, int l, int r, int k) {
//	if (l >= r) {
//		return;
//	}
//	int i = l;
//	int j = r;
//	int temp = a[i];
//	while (i != j) {
//		while (i < j && a[j] >= temp) {
//			j--;
//		}
//		swap(a[i], a[j]);
//		while (i < j && a[i] < temp) {
//			i++;
//		}
//		swap(a[i], a[j]);
//	}
//	if (r - i + 1 == k) { //左侧个数恰好为k，直接返回
//		return;
//	}
//	else if (r - i + 1 > k) {  //左侧个数大于k，递归对左侧元素再次排序
//		findKsmall(a, i + 1, r, k);
//	}
//	else {
//		findKsmall(a, l, i - 1, k - (r - i + 1));  //左侧元素小于k，递归对右侧元素再次排序
//	}
//}
//
//int main() {
//	int len;
//	cout << "输入数组长度: ";
//	cin >> len;
//	vector<int> a(len);
//	cout << "依次输入数组元素: ";
//	for (int i = 0; i < len; i++) {
//		cin >> a[i];
//	}
//
//	int k;
//	cout << "输入k: ";
//	cin >> k;
//	findKsmall(a, 0, len - 1, len - k);
//
//	cout << "前k个最小的元素为: ";
//	for (int i = 0; i < k; i++) {
//		cout << a[i] << " ";
//	}
//
//}