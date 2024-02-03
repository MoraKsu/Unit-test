package seminars.first.Shop;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

public class ShopTest {
    private Shop shop;

    public void setUp() {
        // Создаем магазин с тестовыми продуктами перед каждым тестом
        shop = new Shop();
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setTitle("Product 1");
        product1.setCost(10);
        Product product2 = new Product();
        product2.setTitle("Product 2");
        product2.setCost(20);
        Product product3 = new Product();
        product3.setTitle("Product 3");
        product3.setCost(5);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        shop.setProducts(products);
    }

    public void testSortProductsByPrice() {
        setUp();
        // Проверяем правильность сортировки продуктов по цене
        List<Product> sortedProducts = shop.sortProductsByPrice();
        assertThat(sortedProducts).extracting(Product::getCost).isSorted();
    }

    public void testGetMostExpensiveProduct() {
        setUp();
        // Проверяем получение самого дорогого продукта
        Product mostExpensiveProduct = shop.getMostExpensiveProduct();
        assertThat(mostExpensiveProduct).isNotNull();
        assertThat(mostExpensiveProduct.getTitle()).isEqualTo("Product 2");
    }

    public void testEmptyShop() {
        setUp();
        // Проверяем работу методов на пустом магазине
        shop.setProducts(new ArrayList<>());
        assertThat(shop.sortProductsByPrice()).isEmpty();
        assertThat(shop.getMostExpensiveProduct()).isNull();
    }

    public static void main(String[] args) {
        ShopTest tester = new ShopTest();
        tester.testSortProductsByPrice();
        tester.testGetMostExpensiveProduct();
        tester.testEmptyShop();
    }
}