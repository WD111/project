#include<iostream>
#include<algorithm>
#include<cstring>
#include<vector>
using namespace std;

bool cmp(vector<int> m, vector<int> n) {
	if (m[1] == n[1]) {
		return m[0] > n[0];
	}
	return m[1] < n[1];
}

void solve(int n, vector<vector<int>>& meets, int res) {
	sort(meets.begin(), meets.end(), cmp);
	res = 1;
	int last = meets[0][1];
	cout << "ѡ��ʼʱ��Ϊ " << meets[0][0] << " ����ʱ��Ϊ " << meets[0][1] << " �Ļ���" << endl;
	for (int i = 0; i < n; i++) {
		if (meets[i][0] >= last) {
			res++;
			last = meets[i][1];
			cout << "ѡ��ʼʱ��Ϊ " << meets[i][0] << " ����ʱ��Ϊ " << meets[i][1] << " �Ļ���" << endl;
		}
	}
	cout << "���ɰ��Ż�����: " << res << endl;
}


int main() {
	int n;
	int res = 0;
	cout << "������������: ";
	cin >> n;
	vector<vector<int>> meets(n, vector<int>(2, 0));
	cout << "��������ÿ�����鿪ʼ�ͽ���ʱ��: " << endl;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2; j++) {
			cin >> meets[i][j];
		}
	}
	sort(meets.begin(), meets.end(), cmp);
	cout << "��ʱ��������������Ϊ: " << endl;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2; j++) {
			cout << meets[i][j] << " ";
		}
		cout << endl;
	}
	solve(n, meets, res);
	return 0;
}