#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode {
	int data;
	struct TreeNode* right, * left;
}TreeNode;

void postorder(TreeNode* root)
{
	if (root != NULL) {
		postorder(root->left);
		postorder(root->right);
		printf("%d\n", root->data);
	}
}

TreeNode * toTree(TreeNode* root, int item) {


	if (root == NULL) {
		TreeNode* tmp = (TreeNode*)malloc(sizeof(TreeNode));	
		tmp->data = item;
		tmp->left = NULL;
		tmp->right = NULL;
		return tmp;
	}

	if (root->data > item)
		root-> left = toTree(root->left, item);
	else
		root -> right = toTree(root->right, item);

	return root;
}
//입력 대로 하자마자 넣어줘야 함
// 만들어진 루트 이용 
int main() {

	int data, idx, i = 0;
	TreeNode* root = NULL;

	while (scanf("%d", &data) != EOF){
		root =toTree(root, data);
	}

	postorder(root);
}