//#include<iostream>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//int solve(string s) {
//	int n = s.size();
//	if (n < 2) {
//		return 1; //����������ַ�������С��2ʱ
//	}
//	int maxLen = 1;  //��¼��ǰ������Ӵ��ĳ���
//	int begin = 0;
//	vector<vector<int>> dp(n, vector<int>(n));
//	for (int i = 0; i < n; i++) {
//		dp[i][i] = true;  //����Ϊ1���ִ���Ϊ���Ĵ�
//	}
//	for (int l = 2; l <= n; l++) { //l��ʾi��j�ĳ���
//		for (int i = 0; i < n; i++) { //iΪ��߽�
//			int j = l + i - 1; //��l��iȷ���ұ߽�
//			if (j >= n) {
//				break; //�ұ߽�Խ�磬�˳�ѭ��
//			}
//			if (s[i] != s[j]) {
//				dp[i][j] = false;
//			}
//			else {  //s[i]==s[j]ʱ
//				if (j - i < 3) {
//					dp[i][j] = true;
//				}
//				else {
//					dp[i][j] = dp[i + 1][j - 1]; //��̬�滮����
//				}
//			}
//			if (dp[i][j] && j - i + 1 > maxLen) {
//				maxLen = j - i + 1;
//				begin = i;
//			}
//		}
//	}
//	cout << s.substr(begin, maxLen) << endl;
//	return maxLen;
//}
//
//int main() {
//	string s;
//	cout << "�������ַ���: ";
//	cin >> s;
//	int res = solve(s);
//	cout << "������Ӵ�����Ϊ: " << res;
//	return 0;
//}