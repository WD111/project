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
//	if (r - i + 1 == k) { //������ǡ��Ϊk��ֱ�ӷ���
//		return;
//	}
//	else if (r - i + 1 > k) {  //����������k���ݹ�����Ԫ���ٴ�����
//		findKsmall(a, i + 1, r, k);
//	}
//	else {
//		findKsmall(a, l, i - 1, k - (r - i + 1));  //���Ԫ��С��k���ݹ���Ҳ�Ԫ���ٴ�����
//	}
//}
//
//int main() {
//	int len;
//	cout << "�������鳤��: ";
//	cin >> len;
//	vector<int> a(len);
//	cout << "������������Ԫ��: ";
//	for (int i = 0; i < len; i++) {
//		cin >> a[i];
//	}
//
//	int k;
//	cout << "����k: ";
//	cin >> k;
//	findKsmall(a, 0, len - 1, len - k);
//
//	cout << "ǰk����С��Ԫ��Ϊ: ";
//	for (int i = 0; i < k; i++) {
//		cout << a[i] << " ";
//	}
//
//}