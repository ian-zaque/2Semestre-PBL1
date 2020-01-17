package br.uefs.ecomp.organizer.model;

import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class SystemTest {
    private System sys;
    private Author a1, a2, a3;    

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        sys = new System();
               
        a1 = new Author("João", "Rocha-Junior");
        a2 = new Author("Carlos", "Rodrigues");
        a3 = new Author("Rodrigo", "Tripodi");         
    }
    
    /**
     * Teste de unidade que verifica a inserção de autores no sistema. 
     */
    @Test
    public void testAdd() {
        sys.add(a1);
        sys.add(a2);
        sys.add(a3);
        
        assertEquals(a1, sys.get(0));
        assertEquals(a2, sys.get(1));
        assertEquals(a3, sys.get(2));                                       
    }
    
    /**
     * Teste de unidade que verifica a remoção de autores no sistema. 
     */
    @Test
    public void testRemove() {
        sys.add(a1);
        sys.add(a2);
        sys.add(a3);
        
        sys.remove("Carlos", "Rodrigues");
        assertEquals(a1, sys.get(0));        
        assertEquals(a3, sys.get(1));
        
        sys.remove("Rodrigo", "Tripodi");
        assertEquals(a1, sys.get(0));
        
        sys.remove("João", "Rocha-Junior");
        assertTrue(0 == sys.size());
    }
    
    /**
     * Teste de unidade que verifica o iterador do sistema. 
     */
    @Test
    public void testIterator() {
        sys.add(a1);
        sys.add(a2);
        sys.add(a3);
        
        Iterator it = sys.iterator();
        
        assertTrue(it.hasNext());
        assertEquals(a1, it.next());
        
        assertTrue(it.hasNext());
        assertEquals(a2, it.next());
        
        assertTrue(it.hasNext());
        assertEquals(a3, it.next());
        
        assertFalse(it.hasNext());        
    }
}
