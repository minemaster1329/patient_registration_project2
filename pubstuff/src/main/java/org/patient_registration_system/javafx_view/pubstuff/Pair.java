package org.patient_registration_system.javafx_view.pubstuff;

public class Pair<A,B> {
    public A element1;
    public B element2;

    public Pair(A element1, B element2){
        this.element1 = element1;
        this.element2 = element2;
    }

    public Pair(){
        element2 = null;
        element1 = null;
    }
}
