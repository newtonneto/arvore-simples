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
        No find_it_node_3 = simples.findNode(simples.root(), 14);
        if (find_it_node_3 != null) {
            //Verifica o pai do no encontrado
            No parent = find_it_node_3.parent();
            System.out.println("O pai do nó " + find_it_node_3.element() + ": " + parent.element());
        }

        //Procura por um nó especifico
        No find_it_node_4 = simples.findNode(simples.root(), 13);
        System.out.println("Mo> " + find_it_node_4);
        if (find_it_node_4 != null) {
            //Verifica o pai do no encontrado
            No parent = find_it_node_4.parent();
            System.out.println("O pai do nó " + find_it_node_4.element() + ": " + parent.element());
        }


        //Imprime todos os nos
        //simples.printNodes(simples.root());
    }
}
