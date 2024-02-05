package com.p1k.p1kGram.domain.tag;

import org.springframework.data.jpa.repository.JpaRepository;

// Tag, integer → jpaRepository를 그대로 따옴
public interface TagRepository extends JpaRepository<Tag, Integer>{

}