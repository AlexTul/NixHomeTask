import java.util.AbstractList;

/**
 * To implement an unmodifiable list, the programmer needs only to extend this class and provide implementations
 * for the get(int) and size() methods.
 * To implement a modifiable list, the programmer must additionally override the set(int, E) method (which otherwise
 * throws an UnsupportedOperationException). If the list is variable-size the programmer must additionally override
 * the add(int, E) and remove(int) methods.
 * <p>
 * https://habr.com/ru/post/337558/
 */
public class ForwardLinkedList<E> extends AbstractList<E> {

    /**
     * Size of ForwardLinkedList.
     */
    private int size = 0;

    /**
     * Pointer to first node.
     */
    private Node<E> head;

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean add(E o) {
        Node<E> newNode = new Node<>(o);
        Node<E> currentNode = head;

        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }

        size++;
        return true;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);

        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    @Override
    public void add(int index, E element) {
        checkElementIndex(index);

        if (index == size - 1) {
            add(element);
        } else {
            node(index);
            Node<E> currentNode = node(index);
            Node<E> newNode = new Node<>(element);
            Node<E> previous = node(index - 1);
            previous.next = newNode;
            newNode.next = currentNode;
            size++;
        }
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);

        final E element;
        if (index == 0) {
            element = head.item;
            head = head.next;
        } else {
            Node<E> previous = node(index - 1);
            Node<E> remote = previous.next;
            previous.next = remote.next;
            element = remote.item;
        }
        size--;
        return element;
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Search Node.
     */
    Node<E> node(int index) {
        // assert isElementIndex(index);
        Node<E> x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    /**
     * For print.
     */
    public void print() {
        Node currentNode = head;

        if (head != null) {
            System.out.println(head.item);
        }

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println(currentNode.item);
        }
    }

}
