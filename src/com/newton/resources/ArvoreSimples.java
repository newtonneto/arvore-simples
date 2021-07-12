package com.newton.resources;

import com.newton.exceptions.InvalidNoException;

import java.util.Iterator;

public class ArvoreSimples {
    No raiz;
    int tamanho;

    public ArvoreSimples(Object o) {
        raiz = new No(null, o);
        tamanho = 1;
    }

    /** Retorna a raiz da árvore */
    public No root() {
        return raiz;
    }

    /** Retorna o No pai de um No */
    public No parent(No v) {
        return (v.parent());
    }

    /** retorna os filhos de um No */
    public Iterator children(No v) {
        return v.children();
    }

    /** Testa se um No é interno */
    public boolean isInternal(No v) {
        return (v.childrenNumber() > 0);
    }

    /** Testa se um No é externo*/
    public boolean isExternal(No v) {
        return (v.childrenNumber() == 0);
    }

    /** Testa se um No é a raiz */
    public boolean isRoot(No v) {
        return v == raiz;
    }

    /** Adiciona um filho a um No */
    public void addChild(No v, Object o) {
        No novo = new No(v, o);
        v.addChild(novo);
        tamanho++;
    }

    /** Remove um No
     *  Só pode remover Nos externos e que tenham um pai (não seja raiz)*/
    public Object remove(No v) throws InvalidNoException {
        No pai = v.parent();
        if (pai != null || isExternal(v))
            pai.removeChild(v);
        else
            throw new InvalidNoException("Nó invalido");
        Object o = v.element();
        tamanho--;
        return o;
    }

    /** Troca dois elementos de posição */
    public void swapElements(No v, No w) {
        /*Método que serve de exercicio
         * Este método deverá fazer com que o objeto
         * que estava na posição v fique na posição w
         * e fazer com que o objeto que estava na posição w
         * fique na posição v
         */
    }

    /** Retorna a profundidade de um Nó */
    public int depth(No v) {
        int profundidade = profundidade(v);
        return profundidade;
    }

    private int profundidade(No v) {
        if (v == raiz)
            return 0;
        else
            return 1 + profundidade(v.parent());
    }

    /** Retorna a altura da árvore */
    public int height() {
        // Método que serve de exercicio
        int altura = 0;
        return altura;
    }

    /** Retorna um iterator com os elementos armazenados na árvore */
    public Iterator elements() {
        // Método que serve de exercicio
        return null;
    }

    /** Retorna um iterator com as posições (Nós) da árvore */
    public Iterator Nos() {
        // Método que serve de exercicio
        return null;
    }

    /** Retorna o número de Nos da árvore
     */
    public int size() {
        // Método que serve de exercicio
        return 0;
    }

    /** Retorna se a ávore está vazia. Sempre vai ser falso, pois não permitimos remover a raiz
     */
    public boolean isEmpty() {
        return false;
    }

    public Object replace(No v, Object o) {
        // Método que serve de exercicio
        return null;
    }

    //Procura por um nó especifico na árvore
    public No findNode(No root, Object wanted_node) {
        No search_result = null;
        Iterator nodes = this.children(root);

        //Vai varrer os filhos
        while (nodes.hasNext()) {
            No node = (No)(nodes.next());

            if (wanted_node == node.element()) {
                return node;
            }

            search_result = findNode(node, wanted_node);
        }

        //Retorna null caso não encontre o elemento buscado
        return search_result;
    }

    public void printNodes(No node) {
        if (isInternal(node)) {
            Iterator childrens = this.children(node);

            while (childrens.hasNext()) {
                printNodes((No) (childrens.next()));
            }
        }

        System.out.println(">" + node.element());
    }
}
