//#include <iostream>
//using namespace std;
//
//typedef struct BNode {
//	int data;
//	struct BNode* lchild, * rchild;
//}BTNode, * BTree;
//
//void createbtree(btree& bt) {
//	char node;
//	cin >> node;
//	if (node == '#') { 
//		bt = null;     //���� # ��ʾ�ýڵ�Ϊnull
//	}
//	else {
//		bt = new btnode();
//		bt->data = node - '0';
//		createbtree(bt->lchild); //�ݹ齨��������
//		createbtree(bt->rchild); //�ݹ齨��������
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
//int findNum(BTNode* bt, int k) {
//	if (bt == NULL) {
//		return 0;
//	}
//	int l = findNum(bt->lchild, k); //�ݹ����������
//	int r = findNum(bt->rchild, k); //�ݹ����������
//	if (bt->data >= k) {
//		return l + r + 1;  //�ҵ� +1
//	}
//	else {
//		return l + r;
//	}
//}
//
//int main() {
//	BTree bt;
//	int res;
//	CreateBTree(bt);
//	cout << "����������ǰ���������Ϊ: ";
//	DispBTree(bt);
//	cout << endl;
//	int k;
//	cout << "����k: ";
//	cin >> k;
//	res = findNum(bt, k);
//	cout << "���ڵ���k�Ľڵ����Ϊ: " << res;
//	DestroyBTree(bt);
//	return 0;
//}