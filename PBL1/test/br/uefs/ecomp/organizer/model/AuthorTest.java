package br.uefs.ecomp.organizer.model;

import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes de unidade para a classe {@link Author}
 */
public class AuthorTest {

    private Author author;
    private Book b1, b2, b3;
    private Chapter c1, c2, c3;

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        author = new Author("João", "Rocha-Junior");
        
        b1 = new Book("Programação em Java");
        b2 = new Book("Estrutura de Dados");
        b3 = new Book("Projeto de Sistemas");  
        
        c1 = new Chapter("Introducao", "Introducao a Projetos.");
        c2 = new Chapter("JVM", "Maquina Virtual Java.");
        c3 = new Chapter("Objetos", "Tudo em Java e um objeto.");
    }

    /**
     * Teste de unidade que verifica se os atributos de um autor são
     * atribuídos e modificados corretamente. 
     */
    @Test
    public void testBasic() {
        assertEquals("João", author.getName());
        assertEquals("Rocha-Junior", author.getSurname());                                
    }
    
    /**
     * Teste de unidade que verifica se o método
     * que compara dois autores foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        Author temp = new Author("João", "Rocha-Junior");
        assertTrue(temp.equals(author));
        
        temp = new Author("Paulo", "Rocha-Junior");        
        assertFalse(temp.equals(author));
        
        
        temp = new Author("João", "Rocha-Filho");        
        assertFalse(temp.equals(author));
    }

    /**
     * Teste de unidade que verifica se os livros estão sendo inseridos corretamente.
     */
    @Test
    public void testAddRemove() {
        author.addBook(b2);
        author.addBook(b3);
        author.addBook(b1);

        assertEquals(b1, author.getLastBook());
        
        author.deleteBook("Programação em Java");
        
        assertEquals(b3, author.getLastBook());
        
        author.deleteBook("Estrutura de Dados");
        assertEquals(b3, author.getLastBook());
        
    }
    
    /**
     * Verifica se os métodos que recuperam livros estão sendo executados corretamente.
     */
    @Test
    public void testUpdateLastBook() {
        author.addBook(b2);
        author.addBook(b3);                
        author.addBook(b1);
        
        assertEquals(b1, author.getLastBook());
        
        author.getLastBook().addChapter(0, c1);
        author.getLastBook().addChapter(1, c2);
        author.getLastBook().addChapter(2, c3);
        
        assertEquals(c1, author.getLastBook().getChapter(0));
        assertEquals(c2, author.getLastBook().getChapter(1));
        assertEquals(c3, author.getLastBook().getChapter(2));
    }

   
    
    /**
     * Teste que verifica se os livros dos usuários estão�sendo listadas 
     * corretamente.
     */
    @Test
    public void testBooksIterator(){
        author.addBook(b1);
        author.addBook(b2);
        author.addBook(b3);
        
        Iterator it = author.books();
        assertTrue(it.hasNext());
        assertEquals(b1, it.next());
        
        assertTrue(it.hasNext());
        assertEquals(b2, it.next());
        
        assertTrue(it.hasNext());
        assertEquals(b3, it.next());
        
        assertFalse(it.hasNext());        
        
        assertEquals(3, author.numBooks());
        
        assertEquals(b3, author.getLastBook());
    }
         
    /**
     * Teste que verifica verifica se é possível recuperar um livro pelo conteúdo
     * (título ou texto).
     */  
    @Test
    public void testSearchByContent(){
        author.addBook(b1);
        b1.addChapter(0, new Chapter("Introducao", "Introducao a Java."));
        b1.addChapter(1, new Chapter("JVM", "Maquina Virtual Java."));
        b1.addChapter(2, new Chapter("Objetos", "Tudo em Java e um objeto."));
        
        author.addBook(b2);
        b2.addChapter(0, new Chapter("Introducao", "Introducao a Estruturas."));
        b2.addChapter(1, new Chapter("Fila", "Insere inicio, remove final."));
        b2.addChapter(2, new Chapter("Pilha", "Insere e remove do topo."));
                
        author.addBook(b3);  
        b3.addChapter(0, new Chapter("Introducao", "Introducao a Projetos."));
        b3.addChapter(1, new Chapter("UML", "Modelo conceitual."));
        b3.addChapter(2, new Chapter("UML", "Diagrama de classes."));
        
        Iterator it = author.searchBookByContent("JVM");    
        assertTrue(it.hasNext());
        assertEquals(b1, it.next());
        
        
        it = author.searchBookByContent("JVM");        
        assertTrue(it.hasNext());
        assertEquals(b1, it.next());
        
        it = author.searchBookByContent("remove do topo");
        assertTrue(it.hasNext());
        assertEquals(b2, it.next());
        
        it = author.searchBookByContent("Diagrama");
        assertTrue(it.hasNext());
        assertEquals(b3, it.next());
        
        it = author.searchBookByContent("Introducao");        
        assertTrue(it.hasNext());
        assertEquals(b1, it.next());
        
        assertTrue(it.hasNext());
        assertEquals(b2, it.next());
        
        assertTrue(it.hasNext());
        assertEquals(b3, it.next());
        
        it = author.searchBookByContent("UML");        
        assertTrue(it.hasNext());
        assertEquals(b3, it.next());
        
        assertFalse(it.hasNext());
        assertNull(it.next());
        
        
        it = author.searchBookByContent("Circuitos");
        assertFalse(it.hasNext());
        assertNull(it.next());
    }
}
