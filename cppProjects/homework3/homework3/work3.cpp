//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//bool cmp(vector<int> m, vector<int> n) {
//	return m[0] > n[0];
//}
//
//int solve(int W, vector<vector<int>> coins, int n) {
//	int count = 0;
//	for (int i = 0; i < n; i++) {
//		int temp = min(W / coins[i][0], coins[i][1]); //ѡ���������Ӳ�������������ܶ�
//		W -= temp * coins[i][0]; //���� W ��ֵ
//		if (temp != 0) {
//			cout << "ѡ�����Ϊ " << coins[i][0] << " �Ľ�� " << temp << " ö" << endl;
//		}
//		count += temp; //����Ӳ������
//	}
//	return count;
//}
//
//int main() {
//	int n;
//	int W;
//	cout << "����������Ӳ�Ҽ�ֵ: ";
//	cin >> W;
//	cout << "������Ӳ����������: ";
//	cin >> n;
//	vector<vector<int>> coins(n, vector<int>(2, 0));
//	cout << "����������Ӳ��������: " << endl;
//	for (int i = 0; i < n; i++) {
//		for (int j = 0; j < 2; j++) {
//			cin >> coins[i][j];
//		}
//	}
//	cout << endl;
//	sort(coins.begin(), coins.end(), cmp);
//	cout << "������Ӳ������Ϊ: " << endl;
//	for (int i = 0; i < n; i++) {
//		for (int j = 0; j < 2; j++) {
//			cout << coins[i][j] << " ";
//		}
//		cout << endl;
//	}
//	cout << endl;
//	cout << "ѡ���������: " << endl;
//	int res = solve(W, coins, n);
//	cout << endl;
//	cout << "����Ӳ�Ҹ���Ϊ: " << res;
//	return 0;
//}