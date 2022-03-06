import tester.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

// Task 1.0 Make Queue generic
// Edit the following class declaration
class Queue<E> {
    
    // Task 1.0: Set up Fields
    // Your code here
    List<E> contents;
    Comparator<E> comp;
    Queue(List<E> contents, Comparator<E> comp) {
        this.contents = contents;
        this.comp = comp;
    }

    // Task 1.1: add() method
    // Your code here
    void add(E toAdd) {
        this.contents.add(toAdd);
        this.contents.sort(comp);
    }

    // Task 1.2: contains() method
    // Your code here
    boolean contains(E doContain) {
        for(int i = 0; i < this.contents.size(); i ++) {
            if(this.contents.get(i).equals(doContain) == true) {
                return true;
            }
        }
        return false;
    }

    // Task 1.3: remove() method
    // Your code here
    boolean remove(E toRemove) {
        if(this.contents.contains(toRemove) == false) {
            throw new NoSuchElementException();
        }

        this.contents.remove(toRemove);
        this.contents.sort(comp);

        for(int i = 0; i < this.contents.size(); i ++) {
            if(this.contents.get(i).equals(toRemove)) {
                return false;
            }
        }
        return true;
    }

    // Task 1.4: poll() method
    // Your code here
    E poll() {
        if(this.contents.size() == 0) {
            return null;
        } else {
            E pollOut = this.contents.get(0);
            this.contents.remove(0);
            this.contents.sort(comp);
            return pollOut;
        }
    }
}

