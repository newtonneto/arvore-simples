package com.newton.resources;

import com.newton.exceptions.InvalidNoException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

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

        //O replace irá colocar o Objeto de w em v, e retornar o antigo objeto de v, que será colocado
        //em w
        w.setElement(replace(v, w.element()));
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
    public int height(No node) {
        if (this.isExternal(node)) {
            return 0;
        }

        int tree_height = 0;
        Iterator childrens = this.children(node);

        while(childrens.hasNext()) {
            tree_height = Math.max(tree_height, height((No)childrens.next()));
        }

        return 1 + tree_height;
    }

    /** Retorna um iterator com os elementos armazenados na árvore */
    public Iterator elements() {
        Vector elements = new Vector();

        elements = getElements(this.raiz, elements);
        //Adiciona o elemento do no raiz no inicio do vector
        elements.add(0, this.raiz.element());

        Iterator iterator_elements = elements.iterator();

        return iterator_elements;
    }

    public Vector getElements(No root, Vector elements) {
        Iterator childrens = this.children(root);

        while (childrens.hasNext()) {
            No node = (No) childrens.next();
            elements.add(node.element());

            if (node.childrenNumber() > 0) {
                getElements(node, elements);
            }
        }

        return elements;
    }

    /** Retorna um iterator com as posições (Nós) da árvore */
    public Iterator Nos() {
        //ArrayList nodes = new ArrayList();
        Vector nodes = new Vector();

        nodes = getNodes(this.root(), nodes);
        //Adiciona o no raiz no inicio do vector
        nodes.add(0, this.raiz);

        Iterator iterator_nodes = nodes.iterator();

        return iterator_nodes;
    }

    public Vector getNodes(No root, Vector nodes) {
        Iterator childrens = this.children(root);

        while (childrens.hasNext()) {
            No node = (No) childrens.next();
            nodes.add(node);

            if (node.childrenNumber() > 0) {
                getNodes(node, nodes);
            }
        }

        return nodes;
    }

    /** Retorna o número de Nos da árvore
     */
    public int size() {
        return this.tamanho;
    }

    /** Retorna se a ávore está vazia. Sempre vai ser falso, pois não permitimos remover a raiz
     */
    public boolean isEmpty() {
        return false;
    }

    public Object replace(No v, Object o) {
        //Salva o objeto que será substituido
        Object swappable_element = v.element();
        //Armazena no nó o seu novo objeto
        v.setElement(o);

        return swappable_element;
    }

    //Procura por um nó especifico na árvore, com exceção da raiz
    public No findNode(No root, Object wanted_node) {
        No search_result = null;
        Iterator nodes = this.children(root);

        //Vai varrer os filhos, somente se tiver proximo e se o search_result for nulo, pois caso não
        //seja, o objeto buscado já foi encontrado
        while (nodes.hasNext() && search_result == null) {
            No node = (No) (nodes.next());

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
