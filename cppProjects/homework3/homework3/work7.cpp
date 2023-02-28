//#include <iostream>
//#include <cstdio>
//using namespace std;
//
//int main()
//{
//	int dis[101][101];		// dis[i][j]: 从第i站到j站所需的租金 
//	int n, temp;
//	cout << "请输入出租站个数: ";
//	cin >> n;
//
//	cout << "依次输入i站到j站的租金: " << endl;
//	// 输入数据并保存 
//	for (int i = 1; i < n; i++)
//	{
//		for (int j = i + 1; j <= n; j++)
//		{
//			cin >> temp;
//			dis[i][j] = temp;
//		}
//	}
//
//	// 计算从站1到站n所需的最少租金 
//	for (int j = 2; j <= n; j++)		// 1站到j站最少租金 
//	{
//		for (int i = 2; i < j; i++)		// i表示第几行开始 
//		{
//			if (dis[1][j] > dis[1][i] + dis[i][j])
//				dis[1][j] = dis[1][i] + dis[i][j];
//		}
//	}
//
//	cout << "最少租金为 " << dis[1][n];
//
//	return 0;
//}