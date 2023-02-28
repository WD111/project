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
//			break;  //所有会议都已分组，则遍历完毕
//		}
//		cout << "第 " << res + 1 << " 组:" << endl;
//		for (int i = 0; i < n; i++) {
//			if (temp.empty()) {
//				if (visited[i]) {
//					continue;    // 找到第一个尚未分组的数组
//				}
//				visited[i] = true;
//				temp.push_back(meets[i]);
//				cout << "选择开始时间为 " << meets[i][0] << " 结束时间为 " << meets[i][1] << " 的会议" << endl;
//			}
//			else {
//				int t = temp.size();
//				if (visited[i]) {
//					continue;
//				}
//				if (meets[i][0] >= temp[t - 1][1]) {  //满足条件直接加入该组
//					visited[i] = true;
//					temp.push_back(meets[i]);
//					cout << "选择开始时间为 " << meets[i][0] << " 结束时间为 " << meets[i][1] << " 的会议" << endl;
//				}
//			}
//		}
//		num += temp.size();
//		res++; //得到一个分组，会议室数量加一
//		cout << endl;
//	}
//	
//}
//
//int main() {
//	int n;
//	cout << "请输入会议个数: ";
//	cin >> n;
//	vector<vector<int>> meets(n, vector<int>(2, 0));
//	cout << "请依次输入各个会议时间: " << endl;
//	for (int i = 0; i < n; i++) {
//		for (int j = 0; j < 2; j++) {
//			cin >> meets[i][j];
//		}
//	}
//	int res = 0;
//	sort(meets.begin(), meets.end(), cmp);
//	cout << "排序后的会议数组为: " << endl;
//	for (int i = 0; i < n; i++) {
//		for (int j = 0; j < 2; j++) {
//			cout << meets[i][j] << " ";
//		}
//		cout << endl;
//	}
//	solve(n, meets, res);
//	cout << "最少需要的会议室数量为: " << res;
//	return 0;
//}