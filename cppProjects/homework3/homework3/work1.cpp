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
	cout << "选择开始时间为 " << meets[0][0] << " 结束时间为 " << meets[0][1] << " 的会议" << endl;
	for (int i = 0; i < n; i++) {
		if (meets[i][0] >= last) {
			res++;
			last = meets[i][1];
			cout << "选择开始时间为 " << meets[i][0] << " 结束时间为 " << meets[i][1] << " 的会议" << endl;
		}
	}
	cout << "最多可安排会议数: " << res << endl;
}


int main() {
	int n;
	int res = 0;
	cout << "请输入会议个数: ";
	cin >> n;
	vector<vector<int>> meets(n, vector<int>(2, 0));
	cout << "依次输入每个会议开始和结束时间: " << endl;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2; j++) {
			cin >> meets[i][j];
		}
	}
	sort(meets.begin(), meets.end(), cmp);
	cout << "按时间排序后会议依次为: " << endl;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2; j++) {
			cout << meets[i][j] << " ";
		}
		cout << endl;
	}
	solve(n, meets, res);
	return 0;
}