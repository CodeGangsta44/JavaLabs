package controller;

public interface Controller {
    void execute();
    void menu();
    void makeRequest() throws Exception;
    void loadData() throws Exception;
    void saveData();
}
