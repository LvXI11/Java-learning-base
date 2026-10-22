public class MyArrayList {
    private Object[] data;
    private int size;
    private int count = 0;

    public MyArrayList() {
        data = new Object[10];
    }

    public MyArrayList(int size) {
        this.size = size;
        data = new Object[size];
    }

    public void add(Object e) {
        if(count == size) {
            extendCapacity();
        }
        data[count++] = e;
    }

    public void add(int index, Object e) {
        checkIndexForAdd(index);
        if(count == size) {
            extendCapacity();
        }
        for (int i = count; i > index ; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        count++;
    }

    public Object get(int index) {
        checkIndex(index);
            return data[index];
    }

    public Object set(int index, Object e) {
        checkIndex(index);
        Object re = data[index];
        data[index] = e;
        return re;
    }

    public Object remove(int index) {
        checkIndex(index);
        Object re = null;
        re = data[index];
        for(int i = index;i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return re;
    }

    public int size() {
        return this.count;
    }

    boolean isEmpty() {
        return count == 0;
    }

    public void clear() {
        for(int i = 0;i < count; i++) {
            data[i] = null;
        }
        count = 0;
    }

    public String toString() {
        String s = s = "[";
        if(count == 0) {
            return "[]";
        }
        for(int i = 0;i < count - 1; i++) {
            s = s + data[i] + ",";
        }
        s = s + data[count - 1] + "]";
        return s;
    }

    private void extendCapacity() {
        Object[] temp = new Object[size + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
        size += 10;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("index:" + index + "size:" + count);
        }
    }

    private void checkIndexForAdd(int index) {
        if(index < 0 || index > count) {
            throw new IndexOutOfBoundsException("index:" + index + "size:" + count);
        }
    }
}
