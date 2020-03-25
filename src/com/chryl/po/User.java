package com.chryl.po;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Chr.yl
 */
public class User {
    private String uname;
    private String upass;

    public User() {
    }

    public User(String uname, String upass) {
        this.uname = uname;
        this.upass = upass;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                '}';
    }


    /**
     * 定义比较器,在compare内部进行设置比较规则即可
     *
     * @author Chr.yl
     *         升序比较器，降序只要将b1,b2换个顺序即可
     */
    public static class MyComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            User b1 = (User) o1;
            User b2 = (User) o2;
            return b1.getUname().length() - b2.getUname().length();
        }
    }


    public static void main(String[] args) {

        TreeSet<User> treeset = new TreeSet<>(new MyComparator());

        treeset.add(new User("动物世界111", "30"));
        treeset.add(new User("动物世界", "30"));
        treeset.add(new User("动物世界2", "30"));

        System.out.println(treeset);


    }
}
