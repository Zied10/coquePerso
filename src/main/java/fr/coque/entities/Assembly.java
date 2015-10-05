package fr.coque.entities;

/**
 * Created by marcd on 04/10/2015.
 */
public class Assembly {
    private final static Assembly instance = new Assembly();

    private Assembly(){};

    public final static Assembly getInstance(){
        return instance;
    }
}
