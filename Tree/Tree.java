package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree<E> implements AbstractTree<E> {
    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;


    public Tree(E key, Tree<E>... children) {
        this.key = key;
        this.children = new ArrayList<>();
        for (Tree<E> child:children){
            this.children.add(child);
            child.parent = this;
        }
    }

    public Tree(){

    }
    public Tree(E key) {
        this.key = key;
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public Tree<E> getParent() {
        return parent;
    }

    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<E>> children) {
        children = children;
    }
    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);
        while (queue.size() > 0) {
            Tree<E> current = queue.poll();
            result.add(current.key);
            if (current.children!=null)
            for (Tree<E> child : current.children)
                queue.offer(child);
        }
        return result;

    }

    @Override
    public List<E> orderDfs() {
        List<E> order = new ArrayList<>();
        this.dfs(this,order);
        return order;
    }

    private void dfs(Tree<E> tree, List<E> order) {
        if (tree.children!=null)
        for (Tree<E> child:tree.children){
            this.dfs(child,order);
        }
        order.add(tree.key);
    }


    @Override
    public void addChild(E parentKey, Tree<E> child) {
        if (key.equals(parentKey)) {
            //if (this.children==null) this.children = new ArrayList<>();
            this.children.add(child);
            return;
        }
        if (this.children!=null)
        for (Tree<E> c:this.children){
            c.addChild(parentKey, child);
        }
    }
	
	@Override
    public void removeNode(E nodeKey) {
        if (key.equals(nodeKey)){
            if (this.children!=null){
                for (Tree<E> c:this.children){
                    c.parent = null;
                }
            }
            this.children = null;
            Tree<E> parentNode = this.parent;
            parentNode.children.remove(this);
            this.parent = null;
            return;
        }
        if (this.children!=null){
            for (int i =0;i<this.children.size();i++){
                this.children.get(i).removeNode(nodeKey);
            }
        }
    }

    @Override
    public void swap(E firstKey, E secondKey) {

    }
}



