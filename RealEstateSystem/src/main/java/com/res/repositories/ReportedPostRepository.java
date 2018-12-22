package com.res.repositories;

import com.res.models.ReportedPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportedPostRepository extends JpaRepository<ReportedPost, Integer> {
}
