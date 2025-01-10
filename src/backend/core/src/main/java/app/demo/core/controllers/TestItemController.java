package app.demo.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.demo.core.models.TestItem;
import app.demo.core.repository.TestItemRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/test")
public class TestItemController {
    @Autowired
    private TestItemRepository testItemRepository;

    @GetMapping
    public List<TestItem> getAll(){
        return testItemRepository.findAll();
    }

    @GetMapping("/init")
    public void init(){
        testItemRepository.save(new TestItem("3575e736-fe60-4bf4-b148-ede5c621b92a","Test", "Test Category"));
        testItemRepository.save(new TestItem("3575e736-fe60-4bf4-b148-ede5c621b92b","Test1", "Test Category"));
        testItemRepository.save(new TestItem("3575e736-fe60-4bf4-b148-ede5c621b92c","Test2", "Test Category"));
    }

    @PostMapping
    public TestItem createTestItem(@RequestBody TestItem testItem){
        return testItemRepository.save(testItem);
    }
}
