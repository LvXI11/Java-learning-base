package com.lv.projects.librarymanager;

public abstract class LibraryItem {
    private String id;
    private String title;
    private boolean borrowed = false;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    abstract String getType();

    public String getInfo(){
        return "编号:" + id + " 书名:" + title + " 类型:" + getType() +
                "状态:" + (borrowed ? "已借出" : "在馆");
    }

    public boolean borrow(){
        if(borrowed) return false;
        else{
            borrowed = true;
            return true;
        }
    }

    boolean giveBack(){
        if(!borrowed) return false;
        else{
            borrowed = false;
            return true;
        }
    }

    boolean isBorrowed(){
        return borrowed;
    }

}
