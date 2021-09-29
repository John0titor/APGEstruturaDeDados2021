import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.RowFilter.Entry;

public class App {
    public static void main(String[] args) throws Exception {
        
        //double linked list
        Map<Integer, Estudante> doublyLinkedList = new LinkedHashMap<Integer, Estudante>();
        //tree
        TreeMap<Integer, Estudante> treeMap = new TreeMap<Integer, Estudante>();
        //Vector
        Map<Integer, Estudante> vectorMap = new VectorMap(100000);

        Long tempoInicial;
        Long tempoFinal;
        
        //criacao dos alunos
        List<Estudante> listaDeAlunos = new ArrayList<Estudante>();
        for (int i = 0; i < 100000; i++) {
            listaDeAlunos.add(new Estudante());
        }
        //ordenação dos alunos
        listaDeAlunos.sort(Comparator.comparing(Estudante::getMatricula));

        //teste de doubly linked list

            //inserção dos alunos
            tempoInicial = System.nanoTime();
                for (Estudante estudante : listaDeAlunos) {
                    doublyLinkedList.put(estudante.getMatricula(), estudante);
                }
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de INSERCAO - doubly linked list: " + (tempoFinal-tempoInicial));
            
            //apresentação dos alunos
            tempoInicial = System.nanoTime();
                //doublyLinkedList.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de APRESENTACAO - doubly linked list: " + (tempoFinal-tempoInicial));

            //verificar se aluno Engenharia de software
            tempoInicial = System.nanoTime();
                Iterator<Map.Entry<Integer, Estudante>> values = doublyLinkedList.entrySet().iterator();
                while (values.hasNext()) {
                    Map.Entry<Integer, Estudante> value = values.next();
                    value.getValue().isCursoES();
                }
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de VERIFICACAO - doubly linked list: " + (tempoFinal-tempoInicial));
            
            //excluir > 202060000
            tempoInicial = System.nanoTime();
                List<Integer> listaARemover = new ArrayList<Integer>();
                for (Integer key : doublyLinkedList.keySet()) {
                    if (key>202060000) {
                        listaARemover.add(key);
                    }
                }
                for (Integer integer : listaARemover) {
                    doublyLinkedList.remove(integer);
                }
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de EXCLUCAO - doubly linked list: " + (tempoFinal-tempoInicial));


        // tree
            //inserção dos alunos
            tempoInicial = System.nanoTime();
                for (Estudante estudante : listaDeAlunos) {
                    treeMap.put(estudante.getMatricula(), estudante);
                }
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de INSERCAO - tree: " + (tempoFinal-tempoInicial));
            
            //apresentação dos alunos
            tempoInicial = System.nanoTime();
                //treeMap.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de APRESENTACAO - tree: " + (tempoFinal-tempoInicial));

            //verificar se aluno Engenharia de software
            tempoInicial = System.nanoTime();
                Iterator<Map.Entry<Integer, Estudante>> valuesMap = treeMap.entrySet().iterator();
                while (valuesMap.hasNext()) {
                    Map.Entry<Integer, Estudante> valueMap = valuesMap.next();
                    valueMap.getValue().isCursoES();
                }
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de VERIFICACAO - tree: " + (tempoFinal-tempoInicial));
            
            //remover alunos
            tempoInicial = System.nanoTime();
                treeMap.headMap(202060000).clear();
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de REMOCAO - tree: " + (tempoFinal-tempoInicial));

        //vector

        
            //inserção dos alunos
            tempoInicial = System.nanoTime();
                for (Estudante estudante : listaDeAlunos) {
                    vectorMap.put(estudante.getMatricula(), estudante);
                }
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de INSERCAO - vector: " + (tempoFinal-tempoInicial));
            
            //apresentação dos alunos
            tempoInicial = System.nanoTime();
                //vectorMap.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de APRESENTACAO - vector: " + (tempoFinal-tempoInicial));

            //verificar se aluno Engenharia de software
            tempoInicial = System.nanoTime();
                Iterator<Map.Entry<Integer, Estudante>> valuesVector = vectorMap.entrySet().iterator();
                while (valuesVector.hasNext()) {
                    Map.Entry<Integer, Estudante> value = valuesVector.next();
                    value.getValue().isCursoES();
                }
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de VERIFICACAO - vector: " + (tempoFinal-tempoInicial));
            
            //excluir > 202060000
            tempoInicial = System.nanoTime();
                List<Integer> listaARemoverVector = new ArrayList<Integer>();
                for (Integer key : vectorMap.keySet()) {
                    if (key>202060000) {
                        listaARemover.add(key);
                    }
                }
                for (Integer integer : listaARemover) {
                    vectorMap.remove(integer);
                }
            tempoFinal = System.nanoTime();
            System.out.println("Tempo de EXCLUCAO - vector: " + (tempoFinal-tempoInicial));
    }
}
