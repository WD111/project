//#include <iostream>
//#include <algorithm>
//#include <cstring>
//#include<vector>
//using namespace std;
//
//
//bool cmp(vector<int> m, vector<int> n) {
//	return m[0] < n[0];
//}
//
//void solve(int n, vector<vector<int>> meets, int& res) {
//	vector<bool> visited(n, false);
//	int num = 0;
//	while (true) {
//		vector<vector<int>> temp;
//		if (num == meets.size()) {
//			break;  //���л��鶼�ѷ��飬��������
//		}
//		cout << "�� " << res + 1 << " ��:" << endl;
//		for (int i = 0; i < n; i++) {
//			if (temp.empty()) {
//				if (visited[i]) {
//					continue;    // �ҵ���һ����δ���������
//				}
//				visited[i] = true;
//				temp.push_back(meets[i]);
//				cout << "ѡ��ʼʱ��Ϊ " << meets[i][0] << " ����ʱ��Ϊ " << meets[i][1] << " �Ļ���" << endl;
//			}
//			else {
//				int t = temp.size();
//				if (visited[i]) {
//					continue;
//				}
//				if (meets[i][0] >= temp[t - 1][1]) {  //��������ֱ�Ӽ������
//					visited[i] = true;
//					temp.push_back(meets[i]);
//					cout << "ѡ��ʼʱ��Ϊ " << meets[i][0] << " ����ʱ��Ϊ " << meets[i][1] << " �Ļ���" << endl;
//				}
//			}
//		}
//		num += temp.size();
//		res++; //�õ�һ�����飬������������һ
//		cout << endl;
//	}
//	
//}
//
//int main() {
//	int n;
//	cout << "������������: ";
//	cin >> n;
//	vector<vector<int>> meets(n, vector<int>(2, 0));
//	cout << "�����������������ʱ��: " << endl;
//	for (int i = 0; i < n; i++) {
//		for (int j = 0; j < 2; j++) {
//			cin >> meets[i][j];
//		}
//	}
//	int res = 0;
//	sort(meets.begin(), meets.end(), cmp);
//	cout << "�����Ļ�������Ϊ: " << endl;
//	for (int i = 0; i < n; i++) {
//		for (int j = 0; j < 2; j++) {
//			cout << meets[i][j] << " ";
//		}
//		cout << endl;
//	}
//	solve(n, meets, res);
//	cout << "������Ҫ�Ļ���������Ϊ: " << res;
//	return 0;
//}