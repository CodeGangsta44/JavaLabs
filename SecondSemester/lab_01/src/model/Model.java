package model;

public interface Model<T> {
    void receiveData(String data);
    T[] getAllInfo();
    T[] makeRequest();
}
