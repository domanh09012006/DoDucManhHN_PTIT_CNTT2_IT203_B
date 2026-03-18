package SESSION08.BT4;

interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}
