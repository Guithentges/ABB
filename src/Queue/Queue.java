package Queue;

public class Queue<T>{
    private QueueNode<T> first;
    private QueueNode<T> last;
    int level;

    public boolean isEmpty() {
        return this.first == null;
        }

    public void setFirst(QueueNode<T> first){
        this.first = first.getNext();
    }

    public void enqueue(T info){
        if(isEmpty()){
            this.first = new QueueNode<>(info);
            this.last = this.first;
        }else{
            QueueNode<T> last = this.last;
            QueueNode<T> node = new QueueNode<>(info);
            last.setNext(node);
            this.last = node;
        }
    }

    public QueueNode<T> dequeue(){
        if(isEmpty()){
            System.out.println("Fila vazia");
            return null;
        }else{
            QueueNode<T> first = this.first;
            QueueNode<T> next = first.getNext();
            this.first = next;
            return first;
        }
    }
}
