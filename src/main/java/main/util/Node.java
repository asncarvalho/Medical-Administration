package main.util;

import java.io.Serializable;

/**
 * Classe responsável por se comportar como um nó capaz de compor a lista de nós.
 * @author Ariel Carvalho
 */
public class Node<T> implements Serializable{
    private Node<T> nextNode;
    private final T element;

    /**
     * Construtor responsável por inicializar a classe e seus atributos.
     * @param element Refere-se ao elemento contido no nó.
     */
    public Node(final T element) {
        this.element = element;
    }

    /**
     * Método responsável por retornar o elemento contino no nó.
     * @return Retorna elemento.
     */
    public T getElement() {
        return element;
    }

    /**
     * Método responsável por modificar o nó seguinte.
     */
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
    
    
    /**
     * Método responsável por retornar o próximo nó.
     * @return
     */
    public Node<T> getNextNode() {
        return nextNode;
    }

}

