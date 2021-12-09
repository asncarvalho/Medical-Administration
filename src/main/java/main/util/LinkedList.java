/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe responsável por se comportar como uma lista encadeada.
 * @author Ariel Carvalho
 * @param <T>
 */
public class LinkedList<T> implements IList<T>, Serializable {
    
    private Node<T> first;

    public LinkedList(){

    }

    @Override
    public int size() {
        int count = 0;

        if(isEmpty()){
            return 0;
        }else{
            for(Node<T> n = first; n!=null; n = n.getNextNode()){
                    count++;
            }
        }

        return count;
    }

    @Override
    public void add(final T obj) {
        add(size(), obj);
    }

    @Override
    public boolean add(int pos, final T obj) {
        
        Node<T> newNode = new Node<T>(obj);

        if(isEmpty()){
            if(pos > 0){
                return false;
            }
            this.first = newNode;
            return true;
        }else if(pos == 0){
            newNode.setNextNode(this.first);
            this.first = newNode;
            return true;
        }

        Node<T> atual = this.first;

        for(int i = 0; i < pos - 1; i++){
            atual = atual.getNextNode();
        }

        newNode.setNextNode(atual.getNextNode());
        atual.setNextNode(newNode);
        System.out.println(this.first);
        
        return true;
    }

    @Override
    public T remove(int pos) {
        if(this.isEmpty()) return null;

        if (!checkLimits(pos, 0, size() - 1)) return null;

        if(pos == 0){
            Node<T> auxiliar = first;
            T content = first.getElement();
            first = auxiliar.getNextNode();
            return content;
        }

        Node<T> anterior = first;

        for(int i = 0; i < pos -1; i++){
                anterior = anterior.getNextNode();
        }

        Node<T> removido = anterior.getNextNode();
        Node<T> posterior = removido.getNextNode();
        anterior.setNextNode(posterior);
        removido.setNextNode(null);

        return removido.getElement();
    }

    @Override
    public T get(int index) {
        if(isEmpty()) return null;

    if(!checkLimits(index, 0, size())) return null;

    Node<T> current = this.first;

    for (int i = 0; i < index; i++) {
        current = current.getNextNode();
    }
        return current.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private Node<T> currentNode = first;

            @Override
            public boolean hasNext(){
                    return currentNode != null;
            }

            @Override
            public T next(){
                if(hasNext()){
                        final T element = currentNode.getElement();
                        currentNode = currentNode.getNextNode();
                        return element;
                }else{
                        return null;
                }
            }
        };
    }

    public boolean checkLimits(int pos, int low, int high){
        System.out.println(pos);
        System.out.println(low);
        System.out.println(high);
        if(pos > high || pos < low){
            return true;
        }else{
            return false;
        }
    }


    public T searchByElement(T element){
            if(element == null) return null;

            Node<T> current = first;

            while (current != null) {
                    if (current.getElement() == element){
                            return element;
                    } 
            }
            return null;
    }

    public T removeByElement(T element){
            T newElement = searchByElement(element);

            if (newElement == null) return null;

            Node<T> atual1st = this.first;

            if(newElement == atual1st.getElement()){

                    this.first =  null;
                    this.first = atual1st.getNextNode();

                    return atual1st.getElement();
            }

            Node<T> atual = first;
            Node<T> anterior = first;
            while(atual.getElement() != newElement){
                    anterior = atual;
                    atual = atual.getNextNode();
            }

            anterior.setNextNode(atual.getNextNode());
            return atual.getElement();
    }

}
