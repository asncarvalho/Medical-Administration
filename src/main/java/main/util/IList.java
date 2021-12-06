/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.util;
import java.io.Serializable;
import java.util.Iterator;

public interface IList<T> extends Iterable<T>, Serializable{
        /**
     * Método responsável por retornar o número de elementos contidos na lista encadeada.
     * @return Retorna a quantidade de elementos contidos.
     */
    public int size();

    /**
	 * Método responsável por adicionar um item na lista encadeada.
	 * @param obj Item a ser adicionado.
	 */
    public void add(T obj);
    
    /**
     * Método responsável por adicionar um item na lista no índice especificado.
     * @param pos Refere-se a chave de acesso do indice da lista.
     * @param obj Refere-se ao item a ser adicionado.
     */
    public boolean add(int pos, T obj);

    /**
     * Método responsável por remover um item da lista no índice especificado.
     * @param pos Refere-se a chave do elemento que se deseja remover.
     * @return Retorna um booleano afirmando se o elemento foi removido ou não.
     */
    public T remove(int pos);

    /**
     * Retorna um elemento que está em um indice da lista.
     * @param index Refere-se a chave onde o elemento está localizado.
     * @return Retorna o item encontrado.
     */
    public T get(int index);   

    /**
     * Método que verifica se a lista está vazia.
     * @return Retorna um booleano afirmando se a lista está ou não vazia.
     */
    public boolean isEmpty();


    /**
     * Iterador da lista encadeada
     * @return Retorna o iterador da lista encadeada
     */
    public Iterator<T> iterator();
}
