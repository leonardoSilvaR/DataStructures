public class DynamicArray<T> {
    private T[] array;
    private int length = 0;
    private int arrayCapacity;

    public DynamicArray() {
        this.array = (T[]) new Object[2];
        this.arrayCapacity = array.length;
    }

    public void add(T item) {
        //then duplicate Size and copy values from Old array
        if (length >= arrayCapacity) {
            array = resize(array);
        }
        array[length++] = item;
    }

    public boolean remove(Object item) {
        int index = indexOf(item);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    public void removeAt(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size(); i++) {
            array[i] = array[i + 1];
        }
        arrayCapacity--;
        length--;
    }

    public int indexOf(Object item) {
        for (int i = 0; i < size(); i++) {
            if (item == null) {
                if (array[i] == null) return i;
            } else {
                if (item.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < arrayCapacity; i++) {
            array[i] = null;
        }
        length = 0;
    }

    private T[] resize(T[] oldArray) {
        arrayCapacity = arrayCapacity * 2;
        T[] newArray = (T[]) new Object[arrayCapacity];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (isEmpty()) {
            sb.append("]");
        } else {
            for (int i = 0; i < size() - 1; i++) {
                sb.append(array[i] + ", ");
            }
            sb.append(array[size() - 1] + "]");
        }
        return sb.toString();
    }

    private int size() {
        return length;
    }

    private boolean isEmpty() {
        return size() == 0;
    }


    public static void main(String[] args) {
        DynamicArray<String> array = new DynamicArray<>();
        array.add("Teste 1");
        array.add("Teste 2");
        array.add("Teste 3");
        array.removeAt(1);
        System.out.println(array);
    }

}


