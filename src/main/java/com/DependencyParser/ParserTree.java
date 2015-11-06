package com.DependencyParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harishankar on 9/23/2015.
 */


public class ParserTree<T> {
    private List<ParserTree<T>> children = new ArrayList<ParserTree<T>>();
    private ParserTree<T> parent = null;
    private T data = null;

    public ParserTree(T data) {
        this.data = data;
    }

    public ParserTree(T data, ParserTree<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public List<ParserTree<T>> getChildren() {
        return children;
    }

    public void setParent(ParserTree<T> parent) {
        parent.addChild(this);
        this.parent = parent;
    }
    public void setCurrentParent(ParserTree<T> parent) {
        parent.children.add(this);
        this.parent = parent;
    }

    public void addChild(T data) {
        ParserTree<T> child = new ParserTree<T>(data);
        child.setParent(this);
//        child.setCurrentParent(this);
        this.children.add(child);
    }

    public void addChild(ParserTree<T> child) {
//        child.setParent(this);
       // child.setCurrentParent(this);
        child.parent = this;
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }
}