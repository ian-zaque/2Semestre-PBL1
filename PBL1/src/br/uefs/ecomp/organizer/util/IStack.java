package br.uefs.ecomp.organizer.util;

public interface IStack {

    public void push(Object data);

    public Object pop();

    public Object peek();
    
    public int size();

    public boolean isEmpty();
}
