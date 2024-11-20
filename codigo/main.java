public class MyList<T> implements Collection<T> {
    private T[] items;
    private int size;

    public MyList(int capacity) {
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T item) {
        if (size < items.length) {
            items[size++] = item;
        } else {
            throw new ArrayIndexOutOfBoundsException("List is full");
        }
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> createIterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Sem mais elementos");
            }
            return items[currentIndex++];
        }
    }
}
