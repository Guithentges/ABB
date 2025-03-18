package Queue;

public class QueueNode<T> {
    T info;
    QueueNode<T> next;

    QueueNode (T info){
        this.info = info;
    }

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public QueueNode<T> getNext() {
        return next;
    }
    public void setNext(QueueNode<T> next) {
        this.next = next;
    }
}
