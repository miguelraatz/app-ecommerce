package com.sovis.ecommerce.database;

import com.sovis.ecommerce.models.entities.Product;
import com.sovis.ecommerce.models.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * LoadUsers
 */
@Component
public class LoadProducts {
  ProductRepository productRepository;

  /**
   * Constructor.
   */
  @Autowired
  public LoadProducts(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @PostConstruct
  public void fillProductTable() {
    Product product1 = new Product(
        "Notebook Positivo",
        "Intel Celeron N4000, 4GB RAM, 64GB eMMC,"
            + "Tela LCD 14” HD",
        1199.00,
        "https://http2.mlstatic.com/D_NQ_NP_804656-MLU69497665313_052023-O.webp"
    );

    Product product2 = new Product(
        "Notebook Vaio Ryzen7",
        "Fe15 Ryzen7 16gb 512gb Ssd Linux Prata Titânio",
        3199.00,
        "https://http2.mlstatic.com/D_NQ_NP_700017-MLU71486439814_092023-O.webp"
    );

    Product product3 = new Product(
        "Notebook Gamer Acer",
        "Amd Ryzen 7 Windows 11 Home 8gb 512gb Ssd Gtx 1650 15.6 Polegadas",
        4169.00,
        "https://http2.mlstatic.com/D_NQ_NP_823086-MLB52180217297_102022-O.webp"
    );

    Product product4 = new Product(
        "Notebook Ideapad Gaming",
        "3i I5 16gb 512gb Rtx3050 15.6 W11 Cor Shadow black",
        5000.00,
        "https://http2.mlstatic.com/D_NQ_NP_744125-MLU71486577684_092023-O.webp"
    );

    Product product5 = new Product(
        "Notebook Acer Aspire",
        "Intel Core i3 1115G4 8GB de RAM 256GB SSD",
        2699.00,
        "https://http2.mlstatic.com/D_NQ_NP_834448-MLU69484224730_052023-O.webp"
    );

    Product product6 = new Product(
        "Notebook Samsung",
        "Book Celeron Cinza 4gb 256gb Ssd 15,6'' W11 Cor Cinza/Chumbo",
        1699.00,
        "https://http2.mlstatic.com/D_NQ_NP_649496-MLU69483884986_052023-O.webp"
    );
    if (!productRepository.findAll().isEmpty()) {
      return;
    }
    productRepository.saveAll(List.of(product1, product2, product3, product4, product5, product6));
  }
}
