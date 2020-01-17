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
import br.uefs.ecomp.organizer.util.MyStack;
import java.util.Iterator;


public class Author {
    private String name;
    private String surname;
    private MyStack pilhaLivros;
       
    /**
     * Construtor da classe Chapter.
     * Inicializa o nome do autor sendo o nome por parâmetro.
     * Inicializa o sobrenome do autor sendo o sobrenome por parâmetro.
     * Inicializa pilha de livros ao instanciar nova pilha.
     * @param name     
     * @param surname
     */ 
    public Author(String name, String surname){
       this.name = name;
       this.surname = surname; 
       pilhaLivros = new MyStack();       
    }

    /**
     * Método que retorna o nome do autor analisado.
     * @return name nome do autor. 
     * @see Author
     */ 
    public String getName() {
        return name;
    }    

    /**
     * Método que retorna o sobrenome do autor. analisado.
     * @return surname sobrenome do autor. 
     * @see Author
     */ 
    public String getSurname() {
        return surname;
    }

    /**
     * Método que modifica o nome do autor analisado.
     * @param name nome novo do autor. 
     * @see Author
     */ 
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Método que modifica o sobrenome do autor analisado.
     * @param surname novo sobrenome do autor. 
     * @see Author
     */ 
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Método que adiciona um livro no topo da pilha de livros.
     * @param buq
     * @see MyStack
     * @see Book
     */
    public void addBook(Book buq) {
        this.pilhaLivros.push(buq);        
    }  
    
    /**
    * Método que retorna quantidade de livros da pilha.
    * @return tamanho da pilha.
    * @see MyStack
    */
    public Object numBooks() {
        return pilhaLivros.size();
    }
    
    /**
    * Método que retorna último livro da pilha de livros.
    * @return ultimo Último livro da pilha.
    * @see MyStack
    */
    public Book getLastBook() {
          Book ultimo = (Book)pilhaLivros.peek();
     return ultimo;
    }
    
    /**
    * Método roda laços de repetição até encontrar no conteúdo a String passada
    * como parâmetro.
    * @param txt String que é procurada entre os capítulos dos livros.
    * @return retorna iterator da lista com os livros que contém a String.
    * @see MyStack
    * @see MyLinkedList
    * @see Book
    * @see Chapter
    */
    public Iterator searchBookByContent(String txt) {
        MyLinkedList listaAchados = new MyLinkedList();
        Book livro;
        Iterator itera = books();
                
        while(itera.hasNext())
        {   livro = (Book)itera.next();                            //livro recebe o objeto atual do iterador
            
            for(int cont = 0; cont < livro.getNumChapters(); cont++)
            {       if( livro.getChapter(cont).getTitle().contains(txt) || livro.getChapter(cont).getText().contains(txt)   )
                    {   listaAchados.add(livro);  }                    
            }            
        }
                        
      return listaAchados.iterator();
    }    
    
    /**
    * Método que desempilha conteúdo da pilha de livros, joga numa lista e copia o conteúdo
    * para outra pilha auxiliar. Ao final empilha de volta o conteúdo da pilha original.
    * retorna o iterator da pilha de livros. 
    * @return iterator da pilha de livros.
    * @see MyStack
    * @see MyLinkedList
    */
    public Iterator books() {
        MyStack pilhaAux = new MyStack();
        MyLinkedList pilhaLista = new MyLinkedList();
        
        while(!pilhaLivros.isEmpty())
        {   pilhaAux.push(pilhaLivros.pop());
            pilhaLista.addInicio(pilhaAux.peek());
        }
        
        while(!pilhaAux.isEmpty())
        {   pilhaLivros.push(pilhaAux.pop());   }
        
        if(!pilhaLista.iterator().hasNext())
        {   return null;      }
        
        return pilhaLista.iterator();
    }

    /**
    * Método que remove o livro da pilha que tiver mesmo título passado por 
    * parâmetro. Enquanto procura e joga o conteúdo da pilha original para uma auxiliar,
    * caso o topo da auxiliar tiver mesmo título, guarda o livro a ser excluído num livro auxiliar.
    * Ao final, empilha na pilha original todo o conteúdo mas sem o livro auxiliar.
    * @param title título buscado para ser removido.
    * @see MyStack
    * @see MyLinkedList
    * @see Book
    */
    public void deleteBook(String title) {
         MyStack pilhaAux = new MyStack();
         
         while(!pilhaLivros.isEmpty())
         {  pilhaAux.push(pilhaLivros.pop());
            
             if( ((Book)pilhaAux.peek()).getTitle().equals(title)  )
                { Book excluido = ((Book)pilhaAux.pop()); }
         }
         
         while(!pilhaAux.isEmpty())
         {  pilhaLivros.push(pilhaAux.pop());       }
    }
    
    /**
     * Método que texta se o conteúdo de duas String são iguais. 
     * @param txt1
     * @param txt2
     * @return 'true' se expressão for verdadeira. 'false' caso contrário.
     */
    public boolean assertEquals(String txt1, String txt2){
        return(txt1.equals(txt2));        
    }
        
    /**
     * Método que checa se os dois objetos involvidos são de mesmo tipo
     * e se o título é igual.
     * @param obj segundo objeto a ser comparado. O primeiro é o retorno da função 
     * que chama esta função. 
     * @return 'false' se os dois objetos comparados não forem iguais, 
     * 'true' caso contrário 
     */ 
    public boolean equals(Object obj){
        if(obj instanceof Author)
        {   if(((Author) obj).assertEquals(((Author) obj).getName(), name))
            {  if (((Author) obj).assertEquals(((Author) obj).getSurname(), surname)) 
                    {   return true;  }              
            }                                 
        }
        return false;
    }
}