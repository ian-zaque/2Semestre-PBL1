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

public class Chapter {
    private String title;
    private String text;
    private int numPages;    
    
    /**
     * Construtor da classe Chapter.
     * Inicializa o texto do capítulo sendo o texto passado por parâmetro.
     * Inicializa o título do capítulo sendo o título passado por parâmetro.
     * @param text     
     * @param title
     */ 
    public Chapter(String title, String text){
        this.text = text;
        this.title = title;        
    }    
           
    /**
     * Método que retorna o título do objeto analisado.
     * @return título do objeto 
     */ 
    public String getTitle()
    {  return title;  }

    /**
     * Método que retorna o texto do objeto analisado.
     * @return texto do objeto 
     */ 
    public String getText()
    {     return text;  }

    /**
     * Método que retorna o número de páginas do objeto analisado.
     * @return número de páginas do objeto 
     */ 
    public int getNumPages()
    {   return numPages;  }

    /**
     * Método que modifica o título do objeto analisado.
     * @param title novo título do objeto 
     */ 
    public void setTitle(String title)
    {    this.title = title;  }
    
    /**
     * Método que modifica o texto do objeto analisado.
     * @param text novo texto do objeto 
     */ 
    public void setText(String text)
    { this.text = text;  }

    /**
     * Método que modifica o número de páginas do objeto analisado.
     * @param numPages número de páginas do objeto 
     */ 
    public void setNumPages(int numPages)
    {   this.numPages = numPages;   }
    
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
     * Método que cecha se os dois objetos involvidos são de mesmo tipo
     * e se o título e texto são iguais.
     * @param obj segundo objeto a ser comparado. O primeiro é o retorno da função 
     * que chama esta função. 
     * @return 'false' se os dois objetos comparados não forem iguais, 
     * 'true' caso contrário 
     */ 
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Chapter)
        {   if(((Chapter) obj).assertEquals(((Chapter) obj).getTitle(), title))
            {  if (((Chapter) obj).assertEquals(((Chapter) obj).getText(), text)) 
                    {   return true;  }              
            }                                 
        }
        return false;
    }    
}
        
      
    

