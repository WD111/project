//#include<iostream>
//using namespace std;
//
//typedef struct BNode {
//	int data;
//	struct BNode* lchild, * rchild;
//}BTNode, * BTree;
//
//void CreateBTree(BTree& bt) {
//	char node;
//	cin >> node;
//	if (node == '#') {
//		bt == NULL;
//	}
//	else {
//		bt = new BTNode();
//		bt->data = node - '0';
//		CreateBTree(bt->lchild);
//		CreateBTree(bt->rchild);
//	}
//}
//
//void DispBTree(BTNode* bt) {
//	if (bt != NULL) {
//		cout << bt->data << " ";
//		DispBTree(bt->lchild);
//		DispBTree(bt->rchild);
//	}
//}
//
//void DestroyBTree(BTNode* bt) {
//	if (bt == NULL) {
//		return;
//	}
//	else {
//		DestroyBTree(bt->lchild);
//		DestroyBTree(bt->rchild);
//		free(bt);
//	}
//}
//
//int findLevel(BTNode* bt, int x, int start) {
//	if (bt == NULL) {
//		return 0;   //��Ϊ��ֱ�ӷ���NULL
//	}
//	if (bt->data == x) {
//		return start;
//	}
//	else {
//		int l = findLevel(bt->lchild, x, start + 1);  //���µݹ��������������ǰ��μ�һ
//		if (l != 0) {
//			return l;
//		}
//		return findLevel(bt->rchild, x, start + 1);  //���µݹ��������������ǰ��μ�һ
//	}
//}
//
//int main() {
//	BTNode* bt;
//	CreateBTree(bt);
//	cout << "����������ǰ���������Ϊ: ";
//	DispBTree(bt);
//	cout << endl;
//	int x;
//	cout << "����ָ���ڵ�ֵ: ";
//	cin >> x;
//	int res = findLevel(bt, x, 1);
//	if (res) {
//		cout << "ָ���ڵ����ڲ��Ϊ: " << res;
//	}
//	else {
//		cout << "�����ڸýڵ�";
//	}
//	DestroyBTree(bt);
//	return 0;
//}