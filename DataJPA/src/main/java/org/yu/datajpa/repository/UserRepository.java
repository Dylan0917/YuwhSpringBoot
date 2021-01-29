package org.yu.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yu.datajpa.entity.User;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/29 14:10
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
