package id.co.djinggoo.introkafka.repository.categoryproduct;

import id.co.djinggoo.introkafka.model.categoryproduct.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, UUID> {

}
