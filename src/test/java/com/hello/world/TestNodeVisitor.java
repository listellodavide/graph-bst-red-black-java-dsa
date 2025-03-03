package com.hello.world;

import com.hello.world.bst.BSTNode;
import com.hello.world.bst.BasicDataType;
import com.hello.world.bst.NodeVisitor;

import java.util.ArrayList;
import java.util.List;

public class TestNodeVisitor implements NodeVisitor {

    private List<BasicDataType> dataList = new ArrayList<>();

    @Override
    public void visit(BSTNode node) {
        dataList.add(node.getData());
    }

    public List<BasicDataType> getDataList() {
        return dataList;
    }
}
