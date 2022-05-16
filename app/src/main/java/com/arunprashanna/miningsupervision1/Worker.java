package com.arunprashanna.miningsupervision1;

public class Worker {
    public String curNode;
    public String uid;

    public Worker() {}

    public Worker(String curNode, String uid) {
        this.curNode = curNode;
        this.uid = uid;
    }

    public String getCurNode() {
        return curNode;
    }

    public String getUid() {
        return uid;
    }
}