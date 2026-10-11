public class LibraryManager {
    private static int count = 0;

    public boolean addBook(LibraryItem[] library, LibraryItem book){
        if(count == library.length){
            System.out.println("库已满！");
        }
        if(count < library.length){
                for(int i = 0;i < count; i++){
                    if(library[i].getId().equals(book.getId())){
                        System.out.println("编号已存在");
                        return false;
                    }
                }
                library[count ++] = book;
                return true;
            }else{
            return false;
        }
    }

    public boolean borrowBook(LibraryItem[] library, String id){
        for(int i = 0;i < count; i++){
            if(library[i].getId().equals(id)){
                if(library[i].isBorrowed()){
                    System.out.println("已借出");
                    return false;
                }else{
                    return library[i].borrow();
                }
            }
        }
        System.out.println("图书馆内没有该书籍");
        return false;
    }

    public boolean givebackBook(LibraryItem[] library, String id){
        for(int i = 0;i < count; i++){
            if(library[i].getId().equals(id)){
                if(!library[i].isBorrowed()){
                    System.out.println("图书馆中此书未借出过");
                    return false;
                }else{
                    return library[i].giveBack();
                }
            }
        }
        System.out.println("此书不是本馆内的书籍");
        return false;
    }

    public boolean findBookById(LibraryItem[] library, String id){
        for(int i = 0;i < count; i++){
            if(library[i].getId().equals(id)){
                System.out.println(library[i].getInfo());
                return true;
            }
        }
        return false;
    }

    public boolean findBookByName(LibraryItem[] library, String name){
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if(library[i].getTitle().contains(name)){
                System.out.println(library[i].getInfo());
                found = true;
            }
        }
        return found;
    }

    public void showAllBooks(LibraryItem[] library){
        if(count == 0){
            System.out.println("暂无馆藏");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(library[i].getInfo());
        }
    }

    public void countBooks(LibraryItem[] library){
        int amountOfPaper = 0;
        int amountOfE = 0;
        int amountBorrowed = 0;
        for (int i = 0; i < count; i++) {
            if(library[i] instanceof PaperBook) amountOfPaper++;
            if(library[i] instanceof EBook) amountOfE++;
            if(library[i].isBorrowed()) amountBorrowed++;
        }
        System.out.println("*********************");
        System.out.println("总共有" + count + "本书");
        System.out.println("纸质书共" + amountOfPaper + "本");
        System.out.println("电子书共" + amountOfE + "本");
        System.out.println("已借出" + amountBorrowed + "本书");
        System.out.println("*********************");
    }

}
