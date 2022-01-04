package com.shrek.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.shrek.string.NestedInteger;

public class NestedIterator<NestedInteger>{// implements Iterator<Integer> {
    //Write  Code
    // List<1,1>, 2, List< 3, List<4,5> >

    /*Iterator<Integer> itr;

    List<NestedInteger> current;

    List<Integer> flatList = new ArrayList<Integer>();

    public NestedIterator(List<NestedInteger> nestedList) {
        //Write Code
        flatList.addAll( flattenNestedList(nestedList) );
        itr = flatList.iterator();
        //Iterator<NestedInteger> itr = nestedList.iterator();
    }

    List<Integer> flattenNestedList(List<NestedInteger> nestedList){
        List<Integer> tempList = new ArrayList<Integer>();
        Iterator<NestedInteger> itr = nestedList.iterator();
        while(itr.hasNext()){
            NestedInteger nestedInteger = itr.next();
            if(nestedInteger.isInteger()==false){
                flattenNestedList(nestedInteger.getList());
            } else{
                tempList.add(nestedInteger.getInteger());
            }
        }
        return tempList;
    }

    @Override
    public Integer next() {
        //Write Code
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        //Write Code
        current
        return false;
    }*/
}
