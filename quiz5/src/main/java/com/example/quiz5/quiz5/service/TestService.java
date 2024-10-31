package com.example.quiz5.quiz5.service;



package com.example.q5.service;

import com.example.q5.entity.Test;
import com.example.q5.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    // Tüm test kayıtlarını getir
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    // ID'ye göre test kaydı getir
    public Optional<Test> getTestById(Long id) {
        return testRepository.findById(id);
    }

    // Yeni test kaydı oluştur
    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    // Test kaydını güncelle
    public Test updateTest(Long id, Test testDetails) {
        Test test = testRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Test bulunamadı"));
        test.setName(testDetails.getName());
        test.setSurname(testDetails.getSurname());
        test.setPassword(testDetails.getPassword());
        return testRepository.save(test);
    }

    // Test kaydını sil
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }
}
