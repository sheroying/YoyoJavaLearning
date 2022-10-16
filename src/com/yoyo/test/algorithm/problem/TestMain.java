package com.yoyo.test.algorithm.problem;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {

        Object a = new People("Tom", 15);
        Object b = new People("Tom", 15);
        System.out.println("a type" + a.getClass() + "  " + a.equals(b));


//        int aa = 12;
//        String array [] = new String[3];
//        List testList = new ArrayList<String>();
//        testList.iterator();
//        System.out.println(aa);
//        boolean bb = 2>=0;
        /**
         * https://blog.csdn.net/u010525970/article/details/52381730
         *
         * Array、List的区别
         * Array—是基于索引(index)的数据结构，它使用索引在数组中搜索和读取数据是很快的。Array获取数据的时间复杂度是O(1),但是要删除数据却是开销很大
         *
         * 的，因为这需要重排数组中的所有数据
         *
         * List—是一个有序的集合，可以包含重复的元素，提供了按索引访问的方式，它继承Collection。
         *
         * List有两个重要的实现类：ArrayList和LinkedList
         *
         * ArrayList：可以看作是能够自动增长容量的数组，利用ArrayList的toArray返回一个数组；Arrays.asList返回一个列表
         *
         * 1、ArrayList底层采用数组实现，当使用不带参数的构造方法生成ArrayList对象时，实际上会在底层生成一个长度为10的Object类型的数组
         *
         * 2、如果增加的元素个数超过10个，那么ArrayList底层会生成一个新的数组，长度为原数组的1.5倍+1，然后将原数组的内容复制到新数组中，并且后续增
         *
         * 加的内容都会放到新的数组当中，当新的数组无法容纳增加的元素时，重读该过程
         *
         * 3、对于ArrayList元素的删除操作，需要将被删除元素的后续元素向前移动，代价比较大
         *
         * 4、集合当中只能放置对象的引用，无法放置原生数据类型，我们必须使用原生数据的包装类才能加入到集合当中
         *
         * 5、集合当中都是Object类型，因此取出来的也是Object类型，那么必须要使用强制类型转化将其转换成真正的类型（放置进去的类型）
         *
         * LinkedList:是一个双链表,在添加和删除元素时具有比ArrayList更好的性能.但在get与set方面弱于ArrayList.当然,这些对比都是指数据量很大或者操作很频繁
         *
         * 的情况下的对比,如果数据和运算量很小,那么对比将失去意义
         *
         *
         * LinkedList和ArrayList区别
         * LinkedList和ArrayList的差别主要来自于Array和LinkedList数据结构的不同。如果你很熟悉Array和LinkedList，你容易得出下面的结论：
         *
         * 1) 因为Array是基于索引(index)的数据结构，它使用索引在数组中搜索和读取数据是很快的。Array获取数据的时间复杂度是O(1),但是要删除数据却是开销很大的，因为这需要重排数组中的所有数据。
         *
         * 2) 相对于ArrayList，LinkedList插入是更快的。因为LinkedList不像ArrayList一样，不需要改变数组的大小，也不需要在数组装满的时候要将所有的数据重新装入一个新的数组，这是ArrayList最坏的一种情况，时间复杂度是O(n)，而LinkedList中插入或删除的时间复杂度仅为O(1)。ArrayList在插入数据时还需要更新索引（除了插入数组的尾部）。
         *
         * 3) 类似于插入数据，删除数据时，LinkedList也优于ArrayList。
         *
         * 4) LinkedList需要更多的内存，因为ArrayList的每个索引的位置是实际的数据，而LinkedList中的每个节点中存储的是实际的数据和前后节点的位置。
         *
         * 什么情况下用LinkedList或者使用ArrayList
         *
         * 1) 你的应用不会随机访问数据。因为如果你需要LinkedList中的第n个元素的时候，你需要从第一个元素顺序数到第n个数据，然后读取数据。
         *
         * 2) 你的应用更多的插入和删除元素，更少的读取数据。因为插入和删除元素不涉及重排数据，所以它要比ArrayList要快。
         *
         * 以上就是关于ArrayList和LinkedList的差别。你需要一个不同步的基于索引的数据访问时，请尽量使用ArrayList。ArrayList很快，也很容易使用。但是要记得要给定一个合适的初始大小，尽可能的减少更改数组的大小
         * ————————————————
         * 版权声明：本文为CSDN博主「江边的锋」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
         * 原文链接：https://blog.csdn.net/u010525970/article/details/52381730
         */


    }

    public static class People {
        String name;
        int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object b) {
            People p = (People) b;
            System.out.println("hello");
            return this.name.equals(p.name) && this.age == p.age;
        }
    }

}
