//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.coda.springboot.Entity.Product;
//import com.coda.springboot.Service.ProductService;
//
//public class ProductTest {
//	public static void main (String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//		ProductService service = (ProductService)context.getBean("productService");
//		Product p = new Product("grape", "fruit","bangalore blue grape is the best!");
//		System.out.println(service.insertProduct(p));
//	}
//}
