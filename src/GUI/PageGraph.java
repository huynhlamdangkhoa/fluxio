package GUI;

import java.util.*;

public class PageGraph {
    private Map<String, List<String>> adjacencyList;

    public PageGraph() {
        adjacencyList = new HashMap<>();
        // Khởi tạo các mối quan hệ giữa các trang
        addPageRelations();
    }

    // Thêm mối quan hệ giữa các trang
    public void addEdge(String page1, String page2) {
        adjacencyList.putIfAbsent(page1, new ArrayList<>());
        adjacencyList.putIfAbsent(page2, new ArrayList<>());
        adjacencyList.get(page1).add(page2);
        adjacencyList.get(page2).add(page1);
    }

    // Thêm các mối quan hệ giữa các trang mặc định
    private void addPageRelations() {
        // Ví dụ các trang và các mối quan hệ
        addEdge("SignUpPage", "LoginPage");//0
        addEdge("LoginPage", "HomePage");//1
        addEdge("HomePage", "UserPage");//2
        addEdge("HomePage", "CategoryPage");//3
        addEdge("HomePage", "ProductPage");//4
        addEdge("HomePage", "OrderPage");//5
        addEdge("UserPage", "HomePage");//6
        addEdge("CategoryPage", "HomePage");//7
        addEdge("ProductPage", "HomePage");//8
        addEdge("OrderPage", "HomePage");//9
        addEdge("HomePage", "LoginPage");//10
    }

    // Lấy các trang liên quan đến một trang cụ thể
    public List<String> getAdjacentPages(String page) {
        return adjacencyList.getOrDefault(page, new ArrayList<>());
    }
}

