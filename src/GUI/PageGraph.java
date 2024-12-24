package GUI;

import java.util.*;

public class PageGraph {
    private static PageGraph instance;
    private Map<String, List<String>> adjacencyList;

    public PageGraph() {
        adjacencyList = new HashMap<>();
        addPageRelations();
    }

    public static PageGraph getInstance() {
        if (instance == null) {
            instance = new PageGraph();
        }
        return instance;
    }

    private void addPageRelations() {
        addEdge("SignUpPage", "LoginPage");  
        addEdge("LoginPage", "HomePage");   
        addEdge("HomePage", "UserPage");   
        addEdge("HomePage", "CategoryPage");
        addEdge("HomePage", "ProductPage"); 
        addEdge("HomePage", "OrderPage");   
        addEdge("UserPage", "HomePage");    
        addEdge("CategoryPage", "HomePage");
        addEdge("ProductPage", "HomePage"); 
        addEdge("OrderPage", "HomePage");   
        addEdge("HomePage", "LoginPage");   
    }

    public void addEdge(String page1, String page2) {
        adjacencyList.putIfAbsent(page1, new ArrayList<>());
        adjacencyList.putIfAbsent(page2, new ArrayList<>());
        adjacencyList.get(page1).add(page2);
        adjacencyList.get(page2).add(page1);
    }

    public List<String> getAdjacentPages(String page) {
        List<String> pages = adjacencyList.getOrDefault(page, new ArrayList<>());
        Collections.sort(pages); // Ensure deterministic order
        return pages;
    }
}
