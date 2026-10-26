package com.lv.projects.librarymanager;

public class PaperBook extends LibraryItem{
    private int pages;

    public PaperBook(String id, String title, int pages) {
        super(id, title);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    @Override
    String getType() {
        return "纸质书";
    }

}
