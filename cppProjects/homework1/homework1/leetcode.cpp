//#include<iostream>
//#include<vector>
//#include<numeric>
//using namespace std;
//
//
//  struct TreeNode {
//      int val;
//      TreeNode *left;
//      TreeNode *right;
//      TreeNode() : val(0), left(nullptr), right(nullptr) {}
//      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
//   };
//
//  void createbtree(TreeNode* &bt) {
//	char node;
//	cin >> node;
//	if (node == '#') { 
//		bt = nullptr;     //输入 # 表示该节点为null
//	}
//	else {
//		bt = new TreeNode();
//		bt->val = node - '0';
//		createbtree(bt->left); //递归建立左子树
//		createbtree(bt->right); //递归建立右子树
//	}
//}
//
//  TreeNode* binaryTree(int ch[], int n, int start) {
//      if (ch[start] == '#') {
//          return NULL;
//      }
//      TreeNode* root = new TreeNode();
//      root->val = ch[start];
//      root->left = NULL;
//      root->right = NULL;
//
//      int l = 2 * start + 1;
//      int r = 2 * start + 2;
//      if (l > n - 1) {
//          root->left = NULL;
//      }
//      else {
//          root->left = binaryTree(ch, n, l);
//      }
//
//      if (r > n - 1) {
//          root->right = NULL;
//      }
//      else {
//          root->right = binaryTree(ch, n, r);
//      }
//      return root;
//  }
//
//  vector<vector<int>> res;
//  vector<int> path;
//
//  bool check(TreeNode* leaf) {
//      if (leaf->left == nullptr && leaf->right == nullptr) {
//          return true;
//      }
//      return false;
//  }
//  void backtrack(TreeNode* root, int targetSum, TreeNode* cur) {
//      /*if (cur == nullptr) {
//          return;
//      }*/
//      if (check(cur)) {
//          path.push_back(cur->val);
//          if (accumulate(path.begin(), path.end(), 0) == targetSum) {
//              res.push_back(path);
//              return;
//          }
//          return;
//      }
//      //if (abs(accumulate(path.begin(), path.end(), 0)) <= abs(targetSum)) {
//          path.push_back(cur->val);
//          if (cur->left != nullptr) {
//              backtrack(root, targetSum, cur->left);
//              path.pop_back();
//          }
//          if (cur->right != nullptr) {
//              backtrack(root, targetSum, cur->right);
//              path.pop_back();
//          }
//         
//     // }
//  }
//  vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
//      if (root == nullptr) {
//          return  {};
//      }
//      backtrack(root, targetSum, root);
//      return res;
//  }
//
//int main() {
//    int ch[] = {8, 9, -6, '#', '#', 5, 9};
//    TreeNode* root = binaryTree(ch, 7, 0);
//    //createbtree(root);
//    vector<vector<int>> temp =  pathSum(root,7);
//    return 0;
//}