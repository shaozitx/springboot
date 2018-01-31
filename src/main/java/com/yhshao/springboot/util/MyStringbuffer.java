package com.yhshao.springboot.util;

import java.util.Arrays;

/**
 * Created by shaoqi on 18/1/31.
 */
public class MyStringbuffer implements IStringbuffer {

    public char[] value = {};

    MyStringbuffer(){

    }

    public String toString(){
        return new String(this.value);
    }

    //追加字符串
    public void append(String str){
        int count = value.length;
        value = Arrays.copyOf(value,value.length+str.length());
        int i = 0;
        for (char c:str.toCharArray()){
            value[count + i] = c;
            ++i;
        }

    }
    //追加字符
    public void append(char c){
        value = Arrays.copyOf(value,value.length+1);
        value[value.length-1] = c;
    }
    //指定位置插入字符
    public void insert(int pos,char b){
        value = Arrays.copyOf(value,value.length+1);
        for (int i = value.length-1; i > 0; i--) {
            if (i > pos)
               value[i] = value[i-1];
        }
        value[pos] = b;
    }

    //指定位置插入字符串
    public void insert(int pos,String b){
        value = Arrays.copyOf(value,value.length+b.length());

        for (int i = value.length-1; i > 0; i--) {
            if (i > pos){
                value[i] = value[i-b.length()];
            }
        }
        for (int i = 0; i < b.toCharArray().length; i++) {
            value[pos + i] = b.toCharArray()[i];
        }

    }
    //从开始位置删除剩下的
    public void delete(int start){
        value = Arrays.copyOf(value,start+1);
    }
    //从开始位置删除结束位置-1
    public void delete(int start,int end){
        int ll = value.length-end+start;
        char[] temp = new char[ll];
        int j = 0;
        for (int i = 0; i < value.length; i++) {
            if (i >= start && i < end){
            }else {
                temp[j] = value[i];
                ++j;
            }
        }
        value = temp;
    }
    //反转
    public void reverse(){
        char temp;
        for (int i = 0; i < value.length/2; i++) {
            temp = value[i];
            value[i] =value[value.length-1-i];
            value[value.length-1-i] = temp;

        }
    }
    //返回长度
    public int length(){
        return value.length;
    }



}
