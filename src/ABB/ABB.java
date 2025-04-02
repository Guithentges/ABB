package ABB;
import Queue.Queue;

import java.util.LinkedList;
import java.util.Stack;

 public class ABB<T extends Comparable<T>> {
 private ABBNode<T> root;

 public boolean isEmpty() {
 return this.root == null;
 }

 public void inserir(T info) {
 if (this.root == null) {
 root = new ABBNode<>(info);
 } else {
 insert(this.root, info);
 }
 }

 private void insert(ABBNode<T> node, T info) {
 while (true) {
 int retorno = info.compareTo(node.getInfo());

 if (retorno < 0) {
 if (node.getLeft() == null) {
 node.setLeft(new ABBNode<>(info));
 return;
 } else {
 node = node.getLeft();
 }
 } else if (retorno > 0) {
 if (node.getRight() == null) {
 node.setRight(new ABBNode<>(info));
 return;
 } else {
 node = node.getRight();
 }
 } else {
 System.out.println("Valor repetido: " + info);
 return;
 }
 }
 }

 public T buscar(T info) {
    ABBNode<T> node = buscarNo(root, info);
    return node != null ? node.getInfo() : null; 
}


 private ABBNode<T> buscarNo(ABBNode<T> node, T info) {
 if (node == null) {
 return null;
 }
 int comparacao = info.compareTo(node.getInfo());
 if (comparacao == 0) {
 return node;
    } else if (comparacao < 0) {
 return buscarNo(node.getLeft(), info);
    } else {
 return buscarNo(node.getRight(), info);
    }
 }

 public void inOrder() {
 inOrderRec(root);
 System.out.println();
 }

 private void inOrderRec(ABBNode<T> node) {
 if (node != null) {
 inOrderRec(node.getLeft());
 System.out.print(node.getInfo() + " ");
 inOrderRec(node.getRight());
        }
    }

 private ABBNode<T> acharMenor(){
    if (this.root == null) { 
        return null;
    }    
    ABBNode<T> node = this.root;
    while(node.getLeft() != null){
        node = node.getLeft();
    }
    return node;
 }
    
 public T exibirMenor(){
    ABBNode<T> menor = acharMenor();
    if (menor == null) {
        System.out.println("A árvore está vazia.");
        return null; 
    }else{
        return menor.getInfo();
    }
 }
 private ABBNode<T> acharMaior(){
    ABBNode<T> node = this.root;
    while(node.getRight() != null){
        node = node.getRight();
    }
    return node;
 }

 public T exibirMaior(){
    ABBNode<T> maior = acharMaior();
    if (maior == null) {
        System.out.println("A árvore está vazia.");
        return null; 
    }else{
        return maior.getInfo();
    }
 }

 public void porNivel() {
    if (this.root == null) {
        System.out.println("A árvore está vazia.");
        return;
    }

    Queue<ABBNode<T>> fila = new Queue<>(); 
    fila.enqueue(this.root); 
    System.out.print("Árvore ordenada por nível: ");
    while (!fila.isEmpty()) {
        ABBNode<T> atual = fila.dequeue().getInfo();
        System.out.print(atual.getInfo() + " "); 

        if (atual.getLeft() != null) {
            fila.enqueue(atual.getLeft());
        }
        if (atual.getRight() != null) {
            fila.enqueue(atual.getRight());
        }
    }
    System.out.println();
}

public void inOrderNR() {
    Stack<ABBNode<T>> stack = new Stack<>();
    ABBNode<T> atual = this.root;

    while (atual != null || !stack.isEmpty()) {
        while (atual != null) {
            stack.push(atual);
            atual = atual.getLeft();
        }

        atual = stack.pop();
        System.out.print(atual.getInfo() + " ");
        System.out.println();
        atual = atual.getRight();
    }
    System.out.println();
}

public int contarNos() {
    return contarNosNR();
}

private int contarNosRec(ABBNode<T> node) {
    if (node == null) {
        return 0;
    }
    return 1 + contarNosRec(node.getLeft()) + contarNosRec(node.getRight());
}

public int contarNosNR() {
    if (this.root == null) {
        return 0;
    }
    Queue<ABBNode<T>> fila = new Queue<>();
    fila.enqueue(this.root);
    int count = 0;

    while (!fila.isEmpty()) {
        ABBNode<T> node = fila.dequeue().getInfo();
        count++;

        if (node.getLeft() != null) {
            fila.enqueue(node.getLeft());
        }
        if (node.getRight() != null) {
            fila.enqueue(node.getRight());
        }
    }
    return count;
}

public int contarFolhas(){
    return contarFolhasR(this.root);
}

private int contarFolhasR(ABBNode<T> node){
    if(node == null){
        return 0;
    }

    if(node.getLeft() == null || node.getRight() == null){
        return 1;
    }
    return contarFolhasR(node.getLeft()) + contarFolhasR(node.getRight());
}


public int contarFolhasNR() {
    if (this.root == null) {
        return 0;
    }

    int count = 0;
    Queue<ABBNode<T>> fila = new Queue<>();
    fila.enqueue(this.root);

    while (!fila.isEmpty()) {
        ABBNode<T> node = fila.dequeue().getInfo();

        if (node.getLeft() == null && node.getRight() == null) {
            count++;
        }

        if (node.getLeft() != null) {
            fila.enqueue(node.getLeft());
        }
        if (node.getRight() != null) {
            fila.enqueue(node.getRight());
        }
    }

    return count;
}

    
}