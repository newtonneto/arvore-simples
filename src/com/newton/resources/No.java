package com.newton.resources;

import java.util.Iterator;
import java.util.ArrayList;

public class No {
    private Object o;
    private No pai;
    private ArrayList filhos = new ArrayList();
    public No(No pai, Object o)
    {
        this.pai = pai;
        this.o = o;
    }
    public Object element()
    {
        return o;
    }
    public No parent()
    {
        return pai;
    }
    public void setElement(Object o)
    {
        this.o = o;
    }
    public void addChild(No o)
    {
        filhos.add(o);
    }
    public void removeChild(No o)
    {
        filhos.remove(o);
    }
    public int childrenNumber()
    {
        return filhos.size();
    }
    public Iterator children()
    {
        return filhos.iterator();
    }
}
