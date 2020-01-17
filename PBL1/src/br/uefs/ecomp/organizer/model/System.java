/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autor: <Ian Zaque Pereira de Jesus dos Santos>
 * Data:  <09/10/2018>
 *
 * Declaro que este código foi elaborado por mim de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */
package br.uefs.ecomp.organizer.model;

import br.uefs.ecomp.organizer.util.MyLinkedList;
import java.util.Iterator;


public class System implements Iterable{
    MyLinkedList autoresLista;

    /**
     * Construtor da Classe System.
     * Inicializa a lista de autores instanciando um objeto do tipo MyLinkedList.
     * @see MyLinkedList
     */ 
    public System(){
        autoresLista =  new MyLinkedList();
    }
    
    /**
     * Método que adiciona autor passado como parâmetro na lista de autores.
     * @param autor 
     * @see Author
     * @see MyLinkedList
     */ 
    public void add(Author autor) {
        autoresLista.add(autor);
    }

    /**
     * Método que retorna objeto de posição escolhida.
     * @param index posição escolhida.
     * @return retorna objeto da lista que está na posição igual ao index.
     * @see MyLinkedList
     */ 
    public Object get(int index) {
       return autoresLista.get(index);
    }

    /**
     * Método que remove autores que possuem nome e sobrenome iguais aos 
     * passados como parâmetro.
     * @param name Nome do autor.
     * @param surname Sobrenome do autor.
     * @see MyLinkedList
     * @see Author
     */ 
    public void remove(String name, String surname) {
         MyLinkedList listaAux = new MyLinkedList();
         MyLinkedList excluidos = new MyLinkedList();
         int tam = 0;
         int cont = autoresLista.size();
         
         while(!autoresLista.isEmpty() && tam != cont)
         {  listaAux.addInicio(autoresLista.removeInicio());
            
             if( ((Author)listaAux.get(tam)).getName().equals(name) && ((Author)listaAux.get(tam)).getSurname().equals(surname)  )
                {   excluidos.addInicio((Author)listaAux.removeInicio()); 
                    tam++;
                }
         }
         
         while(!listaAux.isEmpty())
         {  autoresLista.add(listaAux.remove());       }      
    }

    /**
     * Método que retorna tamanho da lista de autores
     * @return quantidade de autores da lista.
     * @see MyLinkedList
     */ 
    public int size() {
        return autoresLista.size();
    }

    /**
     * Método que retorna iteradtor da lista de autores.
     * @return iterador da lista.
     * @see MyLinkedList
     */ 
    @Override
    public Iterator iterator() {
        return autoresLista.iterator();
    }
    
}
