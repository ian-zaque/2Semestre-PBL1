/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.organizer.util;

import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author joao
 */
public class StackTest {
    IStack stack;
    Object data1, data2, data3;

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp(){
        stack = (IStack) new MyStack();
        data1 = 1;
        data2 = 2;
        data3 = 3;
    }    

    /**
     * Teste de unidade que verifica se a inserção de objetos na pilha está� 
     * ocorrendo de forma correta, e verifica o tamanho da pilha.
     */
    @Test
    public void testPush(){
        stack.push(data1);
        assertEquals(data1, stack.peek());
        assertEquals(1, stack.size());
        
        stack.push(data2);
        assertEquals(data2, stack.peek());
        assertEquals(2, stack.size());
        
        stack.push(data3);
        assertEquals(data3, stack.peek());
        assertEquals(3, stack.size());              
    }
    
    /**
     * Teste de unidade que verifica se a remoção está correta.
     */
    @Test    
    public void testPop() {
        stack.push(data1);
        stack.push(data2);
        stack.push(data3);        
        assertEquals(3, stack.size());
        
        assertEquals(data3, stack.pop());
        assertEquals(2, stack.size());
        
        assertEquals(data2, stack.pop());
        assertEquals(1, stack.size());
        
        assertEquals(data1, stack.pop());               
        assertEquals(0, stack.size());              
    }                
    
    /**
     * Teste de unidade que verifica se a pilha está vazia ou não.
     */
    @Test
    public void testisEmpty() {
        assertTrue(stack.isEmpty());
        
        stack.push(data1);
        assertFalse(stack.isEmpty());
        
        stack.pop();
        assertTrue(stack.isEmpty());
    }        
}
