package com.tree.binary;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by hackus on 12/26/16.
 */
public class TreeUtils {
    private final static int COUNT = 10;
    List<String> stringList = new ArrayList<String>();

    public void print(Node node, int space){
        if(node == null ) return;

        space+=COUNT;

        print(node.getRight(),space);
        display("\n");
        display(StringUtils.repeat(" ", space));

        display(node.getValue());

        print(node.getLeft(), space);
    }


    public int print2(Node node, int spaces, int index){
        if(node == null) return 0;
        insertString(0, "", index);
        int spacesLeft = 0;
        int spacesRight = 0;
        int spacesMiddle = 0;
        if(node.getLeft()==null && node.getRight()==null){
            spacesRight = node.getValue().length();
            insertString(spaces, node.getValue(), index);
        }else {
            spacesLeft = print2(node.getLeft(), spaces, index + 1);
            spacesMiddle = spaces + spacesLeft + node.getLength();
            spacesRight = print2(node.getRight(), spacesMiddle, index + 1);
            insertString(spaces + spacesLeft, node.getValue(), index);
        }
        return spacesMiddle + spacesRight;
    }

    public void showTree(){
        for(String str : stringList){
            display(str);
            display("\n");
        }
    }

    private void insertString(int spaces, String str, int index){
        if(index < stringList.size()){
            int spaces_to_draw = spaces - stringList.get(index).length();
            stringList.set(index, stringList.get(index) + drawSpaces(spaces_to_draw) + str);
        } else {
            stringList.add(str);
        }
    }

    private void display(String str){
        System.out.print(str);
    }

    private String drawSpaces(int length){
        return StringUtils.repeat("_", length);
    }
}
