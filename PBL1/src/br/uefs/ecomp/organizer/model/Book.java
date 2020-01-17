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

public class Book {
    private String title;
    private int numChapters;
    private int numPages;
    private MyLinkedList listaCap;
    
    /**
     * Construtor da classe Book.
     * Inicializa o título do livro sendo o título passado por parâmetro.    
     * @param title
     * @see MyLinkedList
     */ 
    public Book(String title){
        this.title = title;
        listaCap = new MyLinkedList();
    }

    /**
     * Método que retorna o título do objeto analisado.
     * @return título do objeto 
     */ 
    public String getTitle() {
        return title;
    }

    /**
     * Método que retorna o número de capítulos do objeto analisado.
     * @return número de capítulos do objeto 
     */ 
    public int getNumChapters() {
        return numChapters;
    }

     /**
     * Método que retorna o número de páginas do objeto analisado.
     * @return número de páginas do objeto 
     */ 
    public int getNumPages() {
        return numPages;
    }

    /**
     * Método que modifica o título do objeto analisado.
     * @param title novo título do objeto 
     */ 
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Método que modifica o número de capítulos do objeto analisado.
     * @param numChapters número de páginas do objeto 
     */
    public void setNumChapters(int numChapters) {
        this.numChapters = numChapters;
    }

    /**
     * Método que modifica o número de páginas do objeto analisado.
     * @param numPages número de páginas do objeto 
     */
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    /**
     * Método que adiciona capítulo em uma posição desejada.
     * @param pos. Posição onde quer que adicione o capítulo.
     * @param chapter. Capítulo a ser adicionado. 
     * @see Chapter
     * @see MyLinkedList
     */
    public void addChapter(int pos, Chapter chapter) {
        listaCap.add(pos, chapter);
        this.numChapters++;        
    }

    /**
     * Método que retorna capítulo de uma posição desejada.
     * @param pos. Posição onde quer que retorne o capítulo. 
     * @return retorna livro da posição escolhida. 
     * @see Chapter
     * @see MyLinkedList
     */
    public Chapter getChapter(int pos) {
       return (Chapter)listaCap.get(pos);
    }
    
    /**
     * Método que adiciona capítulo em uma posição desejada.
     * @param num. Posição onde quer que modifique o capítulo.
     * @param tit. Nova String que virará título do livro.
     * @param txt. Nova String que virará texto do livro.
     * @see MyLinkedList
     */
    public void updateChapter(int num, String tit, String txt) {
        ((Chapter)listaCap.get(num)).setText(txt);
        ((Chapter)listaCap.get(num)).setTitle(tit);        
    }

    /**
     * Método que remove capítulo de uma posição desejada. Quando remove a quantidade 
     * de capítulos é diminuída.
     * @param index. Posição onde quer que remove o capítulo.
     * @return retorna capítulo removido.
     * @see Chapter
     * @see MyLinkedList
     */
    public Object removeChapter(int index) {
       if(listaCap.get(index) == null)
            { return null; }
       
        else if(listaCap.isEmpty())
            {  return null; }
       
       else
            this.numChapters--;
            return listaCap.remove(index);
    }

    /**
     * Método que testa se o conteúdo de duas String são iguais. 
     * @param txt1
     * @param txt2
     * @return 'true' se expressão for verdadeira, 'false' caso contrário.
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
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Book)
        {   if(((Book) obj).assertEquals(((Book) obj).getTitle(),title))
            {     return true;  }                                
        }
        return false;
    }
    
    /**
    * Método que retorna o iterator da lista de capítulos. 
    * @return iterator da lista de capítulos.
    * @see Chapter
    * @see MyLinkedList
    */
    public Iterator chapters() {       
        return listaCap.iterator();
    }        
}
