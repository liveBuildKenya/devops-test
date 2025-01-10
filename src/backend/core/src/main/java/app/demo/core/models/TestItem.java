package app.demo.core.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TestItem")
public class TestItem {
    @Id
    public String id;
    public String name;
    public String category;

    public TestItem(String id, String name, String category){
        super();
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
