package app.demo.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import app.demo.core.models.TestItem;

public interface TestItemRepository extends MongoRepository<TestItem, String> {
}
