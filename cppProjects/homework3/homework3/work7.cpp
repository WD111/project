//#include <iostream>
//#include <cstdio>
//using namespace std;
//
//int main()
//{
//	int dis[101][101];		// dis[i][j]: �ӵ�iվ��jվ�������� 
//	int n, temp;
//	cout << "���������վ����: ";
//	cin >> n;
//
//	cout << "��������iվ��jվ�����: " << endl;
//	// �������ݲ����� 
//	for (int i = 1; i < n; i++)
//	{
//		for (int j = i + 1; j <= n; j++)
//		{
//			cin >> temp;
//			dis[i][j] = temp;
//		}
//	}
//
//	// �����վ1��վn������������ 
//	for (int j = 2; j <= n; j++)		// 1վ��jվ������� 
//	{
//		for (int i = 2; i < j; i++)		// i��ʾ�ڼ��п�ʼ 
//		{
//			if (dis[1][j] > dis[1][i] + dis[i][j])
//				dis[1][j] = dis[1][i] + dis[i][j];
//		}
//	}
//
//	cout << "�������Ϊ " << dis[1][n];
//
//	return 0;
//}