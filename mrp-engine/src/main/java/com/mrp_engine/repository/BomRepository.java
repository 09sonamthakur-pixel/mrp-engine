package com.mrp_engine.repository;

import com.mrp_engine.entity.BomLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BomRepository extends JpaRepository<BomLink,Long> {

    List<BomLink> findByParentItemId(Long parentId);
}
