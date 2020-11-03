package com.company;

public class BTree {
    private Node root;
    private Node currentNode;

    public BTree() {
        root = null;
    }
    public boolean search(int data) {
        if(root.value == data) {
            return true;
        }
        if(root.left != null) {
            if(search(root.left.value)) {
                return true;
            }
            if(root.right != null) {
                if(search(root.right.value)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    public void printInOrder(){
        root.inorder();
    }
    public void printPreOrder() {
        root.preorder();
    }
    public void printPostOrder() {
        root.postorder();
    }
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root){
        this.root = root;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public int countNodes() {
        return countNodes(root);
    }
    public int countNodes(Node node) {
        int count = 1;
        if(node == null) {
            return 0;
        }
        else {
            count += countNodes(node.getLeft());
            count += countNodes(node.getRight());
            return count;
        }
    }
    public void print(){
        root.print();
    }
    public Node getCurrent() {
        return currentNode;
    }
    public void setCurrent(Node node) {
        currentNode = node;
    }

}
