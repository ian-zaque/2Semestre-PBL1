package br.uefs.ecomp.organizer.model;

import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes de unidade para a classe {@link Book}
 */
public class BookTest {
    private Book book;
    private Chapter c1, c2, c3;
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        book = new Book("Programação com Java");     
        c1 = new Chapter("Introducao", "Java e uma linguagem de programacao.");
        c2 = new Chapter("Maquina Virtual", "Java possui uma maquina virtual chamada JVM.");
        c3 = new Chapter("Objetos", "Tudo em Java é um objeto.");    
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
   
    /**
     * Teste de unidade que verifica se os atributos de um livro são 
     * atribuídos e modificados corretamente.
     */
    @Test
    public void testBasic(){
        assertEquals("Programação com Java", book.getTitle());        
        book.setTitle("Estrutura de Dados");        
        assertEquals("Estrutura de Dados", book.getTitle());                
    }
    
    
    /**
     * Teste de unidade que verifica se o método 
     * que compara dois livros foi implementado corretamente.
     */
    @Test
    public void testEquals(){
        Book temp = new Book("Programação com Java");
        assertTrue(temp.equals(book));

        book.setTitle("Estrutura de Dados");        
        
        assertFalse(temp.equals(book));
    }
    
    /**
     * Teste de unidade que verifica se os capítulos estão sendo inseridos 
     * corretamente
     */
    @Test
    public void testInsert(){  
        
        book.addChapter(0, c2);
        book.addChapter(1, c3);
        book.addChapter(0, c1);
        
        assertEquals(c1, book.getChapter(0));
        assertEquals(c2, book.getChapter(1));
        assertEquals(c3, book.getChapter(2));
    }
    
    /**
     * Teste de unidade que verifica se um capítulo está sendo modificado corretamente
     */
    @Test
    public void testUpdate(){        
        book.addChapter(0, c1);
        book.addChapter(1, c2);
        book.addChapter(2, c3);
        
        book.updateChapter(1, "JVM", c2.getText());
                
        Chapter temp = new Chapter("JVM", c2.getText());
        assertTrue(temp.equals(book.getChapter(1)));
    }
    
    /**
     * Teste de unidade que verifica a inserção e remoção dos capítulos
     */
    @Test
    public void testDelete(){
    	book.addChapter(0, c3);
        book.addChapter(0, c2);
        book.addChapter(0, c1);
        
        assertEquals(c3, book.getChapter(2));
                        
        
        book.removeChapter(0);
        book.removeChapter(0);
        
        assertEquals(c3, book.getChapter(0));        
        book.removeChapter(0);        
           
        assertNull(book.removeChapter(0));
    }    
    
    /**
     * Teste que verifica se os capítulos estão sendo listados corretamente.
     */
    @Test
    public void testIterator(){
        book.addChapter(0, c1);
        book.addChapter(1, c2);
        book.addChapter(2, c3);
        
        Iterator it = book.chapters();
        assertTrue(it.hasNext());
        assertEquals(c1, it.next());
        
        assertTrue(it.hasNext());assertTrue(it.hasNext());
        assertEquals(c2, it.next());
        
        assertTrue(it.hasNext());assertTrue(it.hasNext());
        assertEquals(c3, it.next());
        
        assertFalse(it.hasNext());
        assertNull(it.next());
    }

    /**
     * Test of getTitle method, of class Book.
     */
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumChapters method, of class Book.
     */
    public void testGetNumChapters() {
        System.out.println("getNumChapters");
        Book instance = null;
        int expResult = 0;
        int result = instance.getNumChapters();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumPages method, of class Book.
     */
    public void testGetNumPages() {
        System.out.println("getNumPages");
        Book instance = null;
        int expResult = 0;
        int result = instance.getNumPages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Book.
     */
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Book instance = null;
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumChapters method, of class Book.
     */
    public void testSetNumChapters() {
        System.out.println("setNumChapters");
        int numChapters = 0;
        Book instance = null;
        instance.setNumChapters(numChapters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumPages method, of class Book.
     */
    public void testSetNumPages() {
        System.out.println("setNumPages");
        int numPages = 0;
        Book instance = null;
        instance.setNumPages(numPages);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addChapter method, of class Book.
     */
    public void testAddChapter() {
        System.out.println("addChapter");
        int num = 0;
        Chapter chapter = null;
        Book instance = null;
        instance.addChapter(num, chapter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChapter method, of class Book.
     */
    public void testGetChapter() {
        System.out.println("getChapter");
        Object obj = null;
        Book instance = null;
        Object expResult = null;
        Object result = instance.getChapter(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assertEquals method, of class Book.
     */
    public void testAssertEquals() {
        System.out.println("assertEquals");
        String txt1 = "";
        String txt2 = "";
        Book instance = null;
        boolean expResult = false;
        boolean result = instance.assertEquals(txt1, txt2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateChapter method, of class Book.
     */
    public void testUpdateChapter() {
        System.out.println("updateChapter");
        int i = 0;
        String tit = "";
        String txt = "";
        Book instance = null;
        instance.updateChapter(i, tit, txt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
