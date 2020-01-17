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
package br.uefs.ecomp.organizer.util;


public class MyStack implements IStack{
    private MyLinkedList pilha;
    
    /**
     * Construtor da pilha
     * Cria pilha com métodos aproveitados da classe MyLinkedList adaptados
     * para o conceito de pilha.
     */
    public MyStack(){        
        this.pilha = new MyLinkedList();        
    }
     
    /**
     * Método que insere elemento no topo da pilha.
     * @param obj é o objeto a ser adicionado.
     * 
     */
    @Override
    public void push(Object obj){                 
        pilha.addFim(obj);  
    }     
        
    /**
     * Método que remove topo da pilha.   
     * @return última célula removida.
     * */
    @Override
    public Object pop(){        
        return pilha.remove();
    }    
    
    /**
     * Método que checa se há elementos na pilha.
     * @return 'true' caso pilha esteja vazia, 'false' caso contrário.
     * */
    @Override
    public boolean isEmpty(){
        return pilha.isEmpty();
    }   

    /**
     * Método que retorna topo da pilha.  
     * @return última célula da pilha.
     * */
    @Override
    public Object peek() {               
        return pilha.get(pilha.size());
    }

    /**
     * Método que retorna quantidade de itens da pilha.   
     * @return quantidade de células da pilha.
     * */
    @Override
    public int size() {
        return pilha.size();
    }
      
        
    
    
    
    
}