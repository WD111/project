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
//		bt = null;     //输入 # 表示该节点为null
//	}
//	else {
//		bt = new btnode();
//		bt->data = node - '0';
//		createbtree(bt->lchild); //递归建立左子树
//		createbtree(bt->rchild); //递归建立右子树
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
//	int l = findNum(bt->lchild, k); //递归查找左子树
//	int r = findNum(bt->rchild, k); //递归查找右子树
//	if (bt->data >= k) {
//		return l + r + 1;  //找到 +1
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
//	cout << "所建立树的前序遍历序列为: ";
//	DispBTree(bt);
//	cout << endl;
//	int k;
//	cout << "输入k: ";
//	cin >> k;
//	res = findNum(bt, k);
//	cout << "大于等于k的节点个数为: " << res;
//	DestroyBTree(bt);
//	return 0;
//}