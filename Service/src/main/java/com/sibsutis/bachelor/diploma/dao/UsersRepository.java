package com.sibsutis.bachelor.diploma.dao;

import com.sibsutis.bachelor.diploma.entity.InternalUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<InternalUser, Long> {
    List<InternalUser> findTop5ByOrderByIdDesc();
}
