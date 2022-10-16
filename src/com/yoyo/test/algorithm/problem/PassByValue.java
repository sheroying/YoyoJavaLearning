package com.yoyo.test.algorithm.problem;

public class PassByValue {

    //Java中的值传递和参数传递
    public static final int FINAL_VALUE = 0;
    public static final Student student = new Student();
    public static void main(String[] args) {
//        FINAL_VALUE = 2; variable with final key word can't be changed;
        student.setName("test");
//         student = new Student();  reference type variable with final key word can't be changed;
        Student st = new Student(2); // reference type variable with final key word  can change the property
        System.out.println(st);
        System.out.println(st.name);
        changeStudent(st);
        System.out.println(st);
        System.out.println(st.name);


        System.out.println(8%9);

    }

    public static void changeStudent(Student student) {
        student.setName("changed Name");
    }


    public static class Student {

        public int age;
        public String name;
        public Student(){
            this.age = age;
        }
        public Student(int age){
            this.age = age;
        }

        public Student getName(String name){
            return new Student(12);
        }

        public int getName(int agenmae) {
            return 2;
        }
        public void setName(String name) {
            this.name = name;
        }

    }

}
