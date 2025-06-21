/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int mini = 1e9;

    void func(TreeNode* root, TreeNode*& prev){
        if(root->left!=NULL) func(root->left, prev);
        if(prev!=NULL) mini = min(mini, abs(root->val - prev->val));
        prev = root;
        if(root->right!=NULL) func(root->right, prev);
    }
    int getMinimumDifference(TreeNode* root) {
        TreeNode* prev = nullptr;
        func(root, prev);
        return mini;
    }
};