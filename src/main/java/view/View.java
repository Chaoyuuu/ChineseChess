package view;

public interface View {

    void addObserver(ViewObserver observer);

    void removeObserver(ViewObserver observer);

}
