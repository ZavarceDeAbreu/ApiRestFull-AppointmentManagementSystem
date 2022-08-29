package com.kodo.inventorysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodo.inventorysystem.models.Article;

@Repository
public interface ArticleRepository  extends  JpaRepository<Article, Long>{

}
