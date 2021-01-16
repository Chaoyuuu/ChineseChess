package controller;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {
    private List<Observer<T>> observerList = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        observerList.add(observer);
    }

    public void unSubscribe(Observer<T> observer) {
        observerList.remove(observer);
    }

    public void update(T t) {
        observerList.forEach(e -> e.onUpdate(t));
    }
}
