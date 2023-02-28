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
//		return 0;   //树为空直接返回NULL
//	}
//	if (bt->data == x) {
//		return start;
//	}
//	else {
//		int l = findLevel(bt->lchild, x, start + 1);  //向下递归查找左子树，当前层次加一
//		if (l != 0) {
//			return l;
//		}
//		return findLevel(bt->rchild, x, start + 1);  //向下递归查找右子树，当前层次加一
//	}
//}
//
//int main() {
//	BTNode* bt;
//	CreateBTree(bt);
//	cout << "所建立树的前序遍历序列为: ";
//	DispBTree(bt);
//	cout << endl;
//	int x;
//	cout << "输入指定节点值: ";
//	cin >> x;
//	int res = findLevel(bt, x, 1);
//	if (res) {
//		cout << "指定节点所在层次为: " << res;
//	}
//	else {
//		cout << "不存在该节点";
//	}
//	DestroyBTree(bt);
//	return 0;
//}