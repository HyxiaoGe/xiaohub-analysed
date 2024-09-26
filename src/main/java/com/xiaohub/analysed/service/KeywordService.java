package com.xiaohub.analysed.service;

import com.xiaohub.analysed.dao.entity.Keyword;
import com.xiaohub.analysed.dao.repo.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    @Transactional
    public Keyword createKeyword(Keyword keyword) {
        return keywordRepository.save(keyword);
    }

    public Optional<Keyword> getKeywordById(Long id) {
        return keywordRepository.findById(id);
    }

    public List<Keyword> getAllKeywords() {
        return keywordRepository.findAll();
    }

    @Transactional
    public Keyword updateKeyword(Keyword keyword) {
        return keywordRepository.save(keyword);
    }

    @Transactional
    public void deleteKeyword(Long id) {
        keywordRepository.deleteById(id);
    }

    public List<Keyword> getKeywordsByCategory(String category) {
        return keywordRepository.findByCategory(category);
    }

}
