//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//vector<vector<int>> res;
//vector<int> path;
//bool flag = false;
//int k;
//int n;
//int minSize;
//
//void init() {
//	cout << "������Ŀ��ֵ: ";
//	cin >> k;
//	cout << "���������鳤��: ";
//	cin >> n;
//	minSize = n;
//}
//
//
//void disp(vector<vector<int>> v) {
//	for (int i = 0; i < v.size(); i++) {
//		for (int j = 0; j < v[i].size(); j++) {
//			cout << v[i][j] << " ";
//		}
//		cout << endl;
//	}
//}
//
////void backtrack(int cur, int n, int rw, vector<int>& weight) {
////	if (flag == false) {
////		if (rw == 0) {
////			flag = true;
////			return;
////		}
////		for (int i = cur; i < n && rw - weight[cur] >= 0; i++) {
////			if (i > cur && weight[i] == weight[i - 1]) {
////				continue;
////			}
////			path.push_back(weight[i]);
////			backtrack(i + 1, n, rw - weight[i], weight);
////			path.pop_back();
////		}
////	}
////}
//
//void backtrack(int cur, int rw, vector<int>& weight) {
//	if (rw == 0 && path.size() <= minSize) {
//		if (path.size() == minSize) { // �����²��ҵĽ������֪��С�������
//			res.push_back(path); //ֱ�Ӽ�¼�ý��
//		}
//		else { // �����²��ҵ����С����֪��С����
//			res.clear(); // �����ҵ��ĵĽ��ȫ�����
//			minSize = path.size(); // ������С����
//			res.push_back(path); // ��¼���½��
//		}
//		return;
//	}
//	for (int i = cur; i < n && rw - weight[cur] >= 0; i++) {
//		if (i > cur && weight[i] == weight[i - 1]) {
//			continue;
//		}
//		path.push_back(weight[i]);
//		backtrack(i + 1, rw - weight[i], weight);
//		path.pop_back();
//	}
//}
//
//int main() {
//	init();
//	vector<int> weight(n);
//	cout << "��������������Ԫ��: ";
//	for (int i = 0; i < n; i++) {
//		cin >> weight[i];
//	}
//	sort(weight.begin(), weight.end());
//	backtrack(0, k, weight);
//	if (res.size() > 0) {
//		cout << "��С����Ϊ: " << minSize << endl;
//		cout << "�����: " << endl;
//		disp(res);
//	}
//	else {
//		cout << "δ�ҵ�";
//	}
//	return 0;
//}