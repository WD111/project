//#include<iostream>
//#include<string>
//#include<vector>
//#include<unordered_set>
//using namespace std;
//
//void disp(int m, int n, vector<vector<string>> v) {
//	for (int i = 0; i < m; i++) {
//		cout << "情况" + to_string(i + 1) + ":" << endl;
//		for (int j = 0; j < n; j++) {
//			for (int k = 0; k < n; k++) {
//				if (v[i][j][k] == '.') {
//					printf("□");
//				}
//				else {
//					printf("■");
//				}
//			}
//			cout << endl;
//		}
//		cout << endl;
//	}
//}
//
//bool check(int col, int row, int n, vector<string>& board) {
//	//检查是否在同一列存在皇后
//	for (int i = 0; i < row; i++) {
//		if (board[i][col] == 'Q') {
//			return false;
//		}
//	}
//
//	//检查是否在左对角线存在皇后
//	for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//		if (board[i][j] == 'Q') {
//			return false;
//		}
//	}
//
//	//检查是否在右对角线存在皇后
//	for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
//		if (board[i][j] == 'Q') {
//			return false;
//		}
//	}
//	return true;
//}
//
//void backtrack(vector<string>& board,int n, int cur, int& res, vector<vector<string>>& res_board) {
//	if (cur == n) { //搜索到最后一层，找到一种情况
//		res_board.push_back(board);
//		res++;
//		return;
//	}
//
//	for (int i = 0; i < n; i++) {
//		if (check(i, cur, n, board)) { //判断是否剪枝，若位置不合法
//			board[cur][i] = 'Q';
//			backtrack(board, n, cur + 1, res, res_board); //位置合法，继续向下搜索
//			board[cur][i] = '.';
//		}
//	}
//}
//
//int main() {
//	int res = 0;
//	vector<vector<string>> res_board;
//	int n;
//	cout << "请输入皇后个数: ";
//	cin >> n;
//	vector<string> board(n, string(n, '.'));
//	backtrack(board, n, 0, res, res_board);
//	cout << "共有 " << res <<" 种情况" << endl;
//	cout << endl;
//	disp(res, n, res_board);
//	return 0;
//}