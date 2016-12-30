package com.tree.binary;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by hackus on 12/26/16.
 */
public class TreeUtils {
    private final static int COUNT = 10;
    private final static String SPACE = " ";
    List<String> stringList = new ArrayList<String>();
    public TreeUtils(){
        stringList.add("");
    }


    public void print(Node node, int space){
        if(node == null ) return;

        space+=COUNT;

        print(node.getRight(),space);
        display("\n");
        display(StringUtils.repeat(" ", space));

        display(node.getValue());

        print(node.getLeft(), space);
    }


    public int print2(Node node, int spaces, int index, boolean isLeft){
        if(node == null) return 0;
        insertString(0, "", index, "");
        int spacesLeft = 0;
        int spacesRight = 0;
        int spacesMiddle = 0;
        int maxSpaces = 0;
        spacesLeft = node.isLeftNull() ? 0 : print2(node.getLeft(), spaces, index + 2, true);

        maxSpaces = Math.max(spaces,spacesLeft);
        spacesMiddle = maxSpaces + node.getLength();
        insertString(maxSpaces, node.getValue(), index, isLeft ? "/" : "\\");

        spacesRight = node.isRightNull() ? 0 : print2(node.getRight(), spacesMiddle, index + 2, false);

        return Math.max(spacesMiddle, spacesRight);
    }

    public void showTree(){
        for(String str : stringList){
            display(str);
            display("\n");
        }
    }

    private void insertString(int spaces, String str, int index, String direction){
        if(index < stringList.size()){
            int spaces_to_draw = spaces - stringList.get(index).length();
            stringList.set(index, stringList.get(index) + drawSpaces(spaces_to_draw) + str);
            stringList.set(index-1, stringList.get(index-1) + drawSpaces(spaces_to_draw + str.length()-1) + (index == 1 ? "" : direction));
        } else {
            stringList.add(str);
            stringList.add(drawSpaces(str.length()));
        }
    }

    private void display(String str){
        System.out.print(str);
    }

    private String drawSpaces(int length){
        return StringUtils.repeat(SPACE, length);
    }
}
