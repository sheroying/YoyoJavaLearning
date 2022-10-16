package com.yoyo.test.algorithmProblem;

import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {
/**
        一、题目描述
        对字符串中的所有单词进行倒排。

        说明：

        1、每个单词是以26个大写或小写英文字母构成；

        2、非构成单词的字符均视为单词间隔符；

        3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；

        4、每个单词最长20个字母；

        输入描述:
        输入一行以空格来分隔的句子

        输出描述:
        输出句子的逆序

                示例1
        输入
        I am a student
        输出
        student a am I
        二、解决思路
        从前遍历，逐个单词插入向量容器中，再逆序输出单词 。
#include<iostream>
#include<vector>
#include<string>
        using namespace std;
        int main(){
            string s;
            vector<string> vec;
            while(getline(cin,s)){
                vec.clear();//清空向量
                int i;
                string temp="";//空串
                for(i=0;i<s.size();i++){
                    if(s[i]>='a'&&s[i]<='z'||s[i]>='A'&&s[i]<='Z'){
                        temp+=s[i];
                    }
                    else{
                        if(temp.size()>0){
                            vec.push_back(temp);
                            temp="";//再次赋值为空串
                        }

                    }
                }

                //如果最后一个单词后面没有任何字符，甚至连标点符号都没有
                //这种情况需要把temp中的内容插入向量容器(前提是最后一个是单词)
                if(temp.size()>0)
                    vec.push_back(temp);


                for(i=vec.size()-1;i>0;i--){
                    cout<<vec[i]<<' ';
                }
                cout<<vec[0]<<endl;

            }
            return 0;
        }

        原文链接：https://blog.csdn.net/cnd2449294059/article/details/77388407

 @SuppressWarnings("resource")

 public static void main(String[] args) throws UnsupportedEncodingException {

 Scanner in = new Scanner(System.in);

 System.out.printf("Please input how many lines you want to enter(test by jb51): ");

 String[] input = new String[in.nextInt()];

 in.nextLine();

 for (int i = 0; i < input.length; i++) {

 input[i] = in.nextLine();

 }

 System.out.printf("\nYour input:\n");

 for (String s : input) {

 System.out.println(reverseWords(s));

 }

 }

 }
 ————————————————
 版权声明：本文为CSDN博主「维京女侠」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/weixin_32672675/article/details/114145089

 */
        //1
        String str = "I am a boy great!";
        String[] strList = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < strList.length; i++ ) {
            sb.append(strList[strList.length-i -1] + " ");
        }
        System.out.println(sb.toString());

        //2
        Stack stack = new Stack();
        for(String string : strList){
            stack.push(string);
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}
