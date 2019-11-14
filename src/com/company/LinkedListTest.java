package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;




import java.util.ArrayList;
import java.util.Arrays;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class LinkedListTest {

    private LinkedList<String>  linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }

    @Test
    void testAddOneObject() {
        linkedList.add("a");

        assertThat(linkedList.get(0), is("a"));
        assertThat(linkedList.size(), is(1));

    }

    @Test
    void testAddTwoObjects() {
        linkedList.add("a");
        linkedList.add("b");

        assertThat(linkedList.get(0), is("a"));
        assertThat(linkedList.get(1), is("b"));
        assertThat(linkedList.size(), is(2));

    }

    @Test
    void testAddObject() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        assertThat(linkedList.get(0), is("a"));
        assertThat(linkedList.get(1), is("b"));
        assertThat(linkedList.get(2), is("c"));
        assertThat(linkedList.size(), is(3));
    }


    @Test
    void testRemoveFirstIndexObject() {

        linkedList.add("a");

        linkedList.remove(0);

        assertThat(linkedList.contains("a"), is(Boolean.FALSE));
        assertThat(linkedList.size(), is(0));
    }

    @Test
    void testRemoveRandomIndex() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        linkedList.remove(2);

        assertThat(linkedList.contains("c"), is(Boolean.FALSE));
        assertThat(linkedList.size(), is(3));
        assertThat(linkedList.get(0), is("a"));
        assertThat(linkedList.get(1), is("b"));
        assertThat(linkedList.get(2), is("d"));

    }


    @Test
    void testAddObjectAtIndexZero(){
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.add(0,"d");

        assertThat(linkedList.size(), is(4));
        assertThat(linkedList.get(0), is("d"));

    }

    @Test
    void testAddObjectAtIndexOne(){
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.add(1,"d");

        assertThat(linkedList.size(), is(4));
        assertThat(linkedList.get(0), is("a"));
    }
    @Test

    void testAddObjectAtIndexZeroNullList() {

        linkedList.add(0,"a");
        assertThat(linkedList.size(), is(1));
        assertThat(linkedList.get(0), is("a"));

    }

    @Test
    void testAddObjectAtIndexNullList() {

        Assertions.assertThrows(IndexOutOfBoundsException.class , () -> linkedList.add(5, "test"));

    }

    @Test
    void testAddObjectAtIndexRandom() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");

        linkedList.add(3,"f");

        assertThat(linkedList.size(), is(6));
        assertThat(linkedList.get(3), is("f"));
    }

    @Test
    void testAddAll(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Picard");
        list.add("Riker");
        list.add("Data");
        list.add("LaForge");

        linkedList.addAll(list);

        assertThat(linkedList , hasItems("Picard" , "Riker" , "Data" , "LaForge"));
        assertThat(linkedList.size(), is(4));
    }
    @Test
    void testAddAllIndexZero() {

        ArrayList<String> list = new ArrayList<>();
        list.add("Picard");
        list.add("Riker");
        list.add("Data");
        list.add("LaForge");



        linkedList.addAll(0,list);

        assertThat(linkedList , hasItems("Picard" , "Riker" , "Data" , "LaForge"));
        assertThat(linkedList.size(), is(4));

    }

    @Test
    void testAddAllIndexOne() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Picard");
        list.add("Riker");
        list.add("Data");
        list.add("LaForge");

        linkedList.add("Crusher");
        linkedList.add("Wesley");

        linkedList.addAll(1, list);

        assertThat(linkedList.size(), is(6));
        assertThat(linkedList.get(0), is("Crusher"));
        assertThat(linkedList.get(5), is("Wesley"));
        assertThat(linkedList, hasItems("Picard" , "Riker", "Data" , "LaForge"));
    }

    @Test
    void testClear() {

        linkedList.add("a");
        linkedList.add("b");

        linkedList.clear();

        assertThat(linkedList.size(), is(0));
    }

    @Test
    void testRemoveData() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.remove("b");

        assertThat(linkedList.size(), is(2));
        assertThat(linkedList.contains("b"), is(Boolean.FALSE));
        assertThat(linkedList, hasItems("a" , "c"));

    }
    @Test
    void testRemoveSizeOneData() {
        linkedList.add("a");
        linkedList.remove("a");

        assertThat(linkedList.size(), is(0));
    }
    @Test
    void testRemoveFirstData() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.remove("a");

        assertThat(linkedList.size(), is(2));
        assertThat(linkedList.contains("a"), is(Boolean.FALSE));
        assertThat(linkedList, hasItems("b" , "c"));
    }
     @Test
     void testRemoveLastData() {
            linkedList.add("a");
            linkedList.add("b");
            linkedList.add("c");

            linkedList.remove("c");

            assertThat(linkedList.contains("c"), is(Boolean.FALSE));
            assertThat(linkedList.size(), is(2));
            assertThat(linkedList, hasItems("a" , "b"));

     }

    @Test
    void testIsEmpty() {

        assertThat(linkedList.isEmpty(), is(Boolean.TRUE));
    }

    @Test

    void testRemoveAllColl() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("c" , "d" , "e"));

        linkedList.removeAll(arrayList);

        assertThat(linkedList.size(), is(3));
        assertThat(linkedList.containsAll(arrayList), is(Boolean.FALSE));
        assertThat(linkedList , hasItems("a" , "b" , "f"));

    }

    @Test
    void testRemoveAllCollUnordered() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("e" , "c" , "d"));

        linkedList.removeAll(arrayList);

        assertThat(linkedList.size(), is(3));
        assertThat(linkedList.containsAll(arrayList), is(Boolean.FALSE));
        assertThat(linkedList, hasItems("a" , "b" , "f"));

    }

    @Test
    void testRemoveAllFirst() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("a" , "b" , "c"));

        linkedList.removeAll(arrayList);

        assertThat(linkedList.size(), is(3));
        assertThat(linkedList.containsAll(arrayList), is(Boolean.FALSE));
        assertThat(linkedList, hasItems("d" , "e" , "f"));

    }

    @Test
    void testRemoveAllList() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("a" , "b" , "c"));

        linkedList.removeAll(arrayList);

        assertThat(linkedList.size(), is(0));


    }

    @Test
    void testSetObject() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.set(1, "test");

        assertThat(linkedList.get(1), is("test"));
        assertThat(linkedList.size(), is(3));

    }
    @Test
    void testSetObjectPosZero() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.set(0, "test");


        assertThat(linkedList.get(0) , is("test"));
        assertThat(linkedList.size(), is(3));
    }


    @Test
    void testSetObjectPosLast() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.set(2, "test");

        assertThat(linkedList.get(2) , is("test"));
        assertThat(linkedList.size(), is(3));
    }

    @Test
    void testRetainAll() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");
        linkedList.add("g");
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("c");

        linkedList.retainAll(arrayList);

        assertThat(linkedList, hasItems("d", "e" , "c" ));
        assertThat(linkedList.size(), is(3));

    }

    @Test
    void RetainAllNoValues() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("f");
        arrayList.add("g");
        arrayList.add("h");

        linkedList.retainAll(arrayList);

        assertThat(linkedList.size(), is(0));

    }

    @Test
    void RetainAllFirstValue() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("a");

        linkedList.retainAll(arrayList);

        assertThat(linkedList.size(), is(1));
        assertThat(linkedList.get(0), is("a"));

    }
    @Test
    void testIndexOf() {

        linkedList.add("a");
        linkedList.add("e");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        assertThat(linkedList.indexOf("c"), is(3));

    }

    @Test
    void testLastIndexOf() {

        linkedList.add("a");
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("e");
        linkedList.add("d");

        assertThat(linkedList.lastIndexOf("d"), is(4));

    }

    @Test
    void testLastIndexOfLastVal() {
        linkedList.add("d");
        linkedList.add("d");
        linkedList.add("d");
        linkedList.add("d");
        linkedList.add("d");

        assertThat(linkedList.lastIndexOf("d"), is(4));
    }

    @Test
    void testLastIndexOfFirstVal() {
        linkedList.add("d");
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("e");

        assertThat(linkedList.lastIndexOf("d"), is(0));
    }

    @Test
    void testLastIndexOfNotFound() {
        linkedList.add("d");
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("e");

        assertThat(linkedList.lastIndexOf("test"), is(-1));
    }

    @Test
    void testContainsAll() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        assertThat(linkedList.containsAll(arrayList) , is(Boolean.TRUE));

    }

    @Test
    void testContainsAllFalse() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("a");
        arrayList.add("f");

        assertThat(linkedList.containsAll(arrayList) , is(Boolean.FALSE));
    }

    @Test
    void testContainsAllFalseNone() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("x");
        arrayList.add("y");
        arrayList.add("z");

        assertThat(linkedList.containsAll(arrayList) , is(Boolean.FALSE));

    }

    @Test
    void testContainsAllFalseDisorder() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("c");

        assertThat(linkedList.containsAll(arrayList) , is(Boolean.FALSE));
    }
    @Test
    void testContainsAllFalseDisorderTwo() {

        linkedList.add("a");
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("b");
        arrayList.add("C");
        arrayList.add("a");

        assertThat(linkedList.containsAll(arrayList) , is(Boolean.FALSE));

    }

    @Test
    void testIndexOfNotFound() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        assertThat(linkedList.indexOf("f"), is(-1));

    }

    @Test
    void testAddIndexShouldThrowIOOBException() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        Assertions.assertThrows(IndexOutOfBoundsException.class , () -> linkedList.add(5, "test"));
        Assertions.assertThrows(IndexOutOfBoundsException.class , () -> linkedList.add(-1, "test"));
    }

    @Test
    void testToArray() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        Object[] myArray = linkedList.toArray();

        assertThat(myArray.length, is(linkedList.size()));
        assertThat(myArray[0] , is(linkedList.get(0)));
        assertThat(myArray[1] , is(linkedList.get(1)));
        assertThat(myArray[2] , is(linkedList.get(2)));

    }

    @Test
    void testToArrayObjectSize0Array() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        String[] array = linkedList.toArray(new String[0]);

        assertThat(array.length, is(3));
        assertThat(array[0], is("a"));
        assertThat(array[1], is("b"));
        assertThat(array[2], is("c"));

    }

    @Test
    void testToArrayObjectSizedArray() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        String[] array = linkedList.toArray(new String[linkedList.size()]);

        assertThat(array.length, is(3));
        assertThat(array[0], is("a"));
        assertThat(array[1], is("b"));
        assertThat(array[2], is("c"));

    }

    @Test
    void testToArrayObjectGreaterSizedArray() {

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        String[] array = linkedList.toArray(new String[4]);

        assertThat(array.length, is(4));
        assertThat(array[0], is("a"));
        assertThat(array[1], is("b"));
        assertThat(array[2], is("c"));

    }

    @Test
    void testSubList() {

        linkedList.add("Riker");
        linkedList.add("Picard");
        linkedList.add("LaForge");
        linkedList.add("Crusher");
        linkedList.add("Data");
        linkedList.add("Troi");
        linkedList.add("Worf");


        assertThat(linkedList.subList(2, 4).get(0) , is("LaForge") );
        assertThat(linkedList.subList(2, 4).get(1) , is("Crusher"));
        assertThat(linkedList.subList(2, 4).get(2) , is("Data"));
        assertThat(linkedList.subList(2, 4).size(), is(3));


    }

    @Test
    void testSubListRemove() {

        linkedList.add("Riker");
        linkedList.add("Picard");
        linkedList.add("LaForge");
        linkedList.add("Crusher");
        linkedList.add("Data");
        linkedList.add("Troi");
        linkedList.add("Worf");


        linkedList.subList(2, 4).clear();

        assertThat(linkedList.size(), is(4));

    }

}