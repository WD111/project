//#include<iostream>
//#include<string>
//#include<vector>
//#include<unordered_set>
//using namespace std;
//
//void disp(int m, int n, vector<vector<string>> v) {
//	for (int i = 0; i < m; i++) {
//		cout << "���" + to_string(i + 1) + ":" << endl;
//		for (int j = 0; j < n; j++) {
//			for (int k = 0; k < n; k++) {
//				if (v[i][j][k] == '.') {
//					printf("��");
//				}
//				else {
//					printf("��");
//				}
//			}
//			cout << endl;
//		}
//		cout << endl;
//	}
//}
//
//bool check(int col, int row, int n, vector<string>& board) {
//	//����Ƿ���ͬһ�д��ڻʺ�
//	for (int i = 0; i < row; i++) {
//		if (board[i][col] == 'Q') {
//			return false;
//		}
//	}
//
//	//����Ƿ�����Խ��ߴ��ڻʺ�
//	for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//		if (board[i][j] == 'Q') {
//			return false;
//		}
//	}
//
//	//����Ƿ����ҶԽ��ߴ��ڻʺ�
//	for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
//		if (board[i][j] == 'Q') {
//			return false;
//		}
//	}
//	return true;
//}
//
//void backtrack(vector<string>& board,int n, int cur, int& res, vector<vector<string>>& res_board) {
//	if (cur == n) { //���������һ�㣬�ҵ�һ�����
//		res_board.push_back(board);
//		res++;
//		return;
//	}
//
//	for (int i = 0; i < n; i++) {
//		if (check(i, cur, n, board)) { //�ж��Ƿ��֦����λ�ò��Ϸ�
//			board[cur][i] = 'Q';
//			backtrack(board, n, cur + 1, res, res_board); //λ�úϷ���������������
//			board[cur][i] = '.';
//		}
//	}
//}
//
//int main() {
//	int res = 0;
//	vector<vector<string>> res_board;
//	int n;
//	cout << "������ʺ����: ";
//	cin >> n;
//	vector<string> board(n, string(n, '.'));
//	backtrack(board, n, 0, res, res_board);
//	cout << "���� " << res <<" �����" << endl;
//	cout << endl;
//	disp(res, n, res_board);
//	return 0;
//}