package com.library.management.entity;

public class User {
    int user_id;
    String user_name;
    int user_phone_no;
    String user_address;


    int book_id;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_phone_no() {
        return user_phone_no;
    }

    public void setUser_phone_no(int user_phone_no) {
        this.user_phone_no = user_phone_no;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }


}
