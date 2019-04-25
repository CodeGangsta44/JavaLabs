package controller.DataManager;

public interface DataManager<T> {
    T[] readData(String path) throws Exception;
    void writeData(String path, T[] data);
}
