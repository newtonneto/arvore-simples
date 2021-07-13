package com.newton;

import com.newton.resources.ArvoreSimples;
import com.newton.resources.No;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArvoreSimples simples = new ArvoreSimples("raiz");
        simples.addChild(simples.root(), 2);
        simples.addChild(simples.root(), 3);
        simples.addChild(simples.root(), 4);
        simples.addChild(simples.root(), 5);

        //Procura por um nó especifico
        No find_it_node_1 = simples.findNode(simples.root(), 4);
        if (find_it_node_1 != null) {
            //Adiciona filhos ao nó encontrado
            simples.addChild((No)find_it_node_1, 12);
            simples.addChild((No)find_it_node_1, 13);
        }

        //Procura por um nó especifico
        No find_it_node_2 = simples.findNode(simples.root(), 5);
        if (find_it_node_2 != null) {
            //Adiciona filhos ao nó encontrado
            simples.addChild((No)find_it_node_2, 14);
            simples.addChild((No)find_it_node_2, 15);
        }

        //Procura por um nó especifico
        No find_it_node_3 = simples.findNode(simples.root(), 12);
        if (find_it_node_3 != null) {
            //Verifica o pai do no encontrado
            No parent = find_it_node_3.parent();
            System.out.println("O pai do nó " + find_it_node_3.element() + ": " + parent.element());
        }

        //Procura por um nó especifico
        No find_it_node_4 = simples.findNode(simples.root(), 15);
        if (find_it_node_4 != null) {
            //Verifica o pai do no encontrado
            No parent = find_it_node_4.parent();
            System.out.println("O pai do nó " + find_it_node_4.element() + ": " + parent.element());
        }

        System.out.println("");
        //Imprime todos os nos
        simples.printNodes(simples.root());

        //Recebe todos os nos
        Iterator all_nodes = simples.Nos();

        System.out.println("");
        //Exibe os nos recebidos
        while (all_nodes.hasNext()) {
            System.out.println("No: " + all_nodes.next());
        }

        //Recebe todos os elementos
        Iterator all_elements = simples.elements();

        System.out.println("");
        //Exibe os elementos recebidos
        while (all_elements.hasNext()) {
            System.out.println("Elemento: " + all_elements.next());
        }

        System.out.println("");
        //Exibe o valor de dois nós
        System.out.println("Nó 1: " + find_it_node_3.element() + "\nNó 2: " + find_it_node_4.element());
        //Exibe os elementos dos pais desses nós
        System.out.println("Pai do nó 1: " + find_it_node_3.parent().element() + "\nPai do nó 2: " + find_it_node_4.parent().element());

        //Troca os elementos (objetos) dos dois nos exibidos
        simples.swapElements(find_it_node_3, find_it_node_4);

        //Exibe o valor de dois nós, agora com os elementos trocados
        System.out.println("No 1: " + find_it_node_3.element() + "\nNo 2: " + find_it_node_4.element());
        //Exibe os elementos dos pais desses nós
        System.out.println("Pai do nó 1: " + find_it_node_3.parent().element() + "\nPai do nó 2: " + find_it_node_4.parent().element());

        System.out.println("");
        //Exibe a altura da árvore
        System.out.println("Altura da árvore: " + simples.height(simples.root()));

        //Adiciona nos na altura 3
        simples.addChild(find_it_node_4, 22);
        simples.addChild(find_it_node_4, 23);

        System.out.println("");
        //Exibe a nova altura da árvore
        System.out.println("Altura da árvore: " + simples.height(simples.root()));
    }
}
