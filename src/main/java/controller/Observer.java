package controller;

public interface Observer<T> {
    void onUpdate(T t);
}
