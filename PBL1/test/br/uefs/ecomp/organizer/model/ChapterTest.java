package br.uefs.ecomp.organizer.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes de unidade para a classe {@link Chapter}
 */
public class ChapterTest {

    private Chapter chapter;

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        chapter = new Chapter("Winter is comming", "O príncipe exilado Viserys Targaryen...");
    }

    /**
     * Teste de unidade que verifica se os atributos de um capítulo são atribuídos e 
     * modificados corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("Winter is comming", chapter.getTitle());
        assertEquals("O príncipe exilado Viserys Targaryen...", chapter.getText());
        chapter.setTitle("Novo");
        chapter.setText("Diferente");
        assertEquals("Novo", chapter.getTitle());
        assertEquals("Diferente", chapter.getText());       
    }
    
    /**
     * Testa se o método equals foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        Chapter temp = new Chapter("Winter is comming", "O príncipe exilado Viserys Targaryen...");
        assertTrue(temp.equals(chapter));
        
        temp.setText("Winter is not comming");
        assertFalse(temp.equals(chapter));        
    }
}
