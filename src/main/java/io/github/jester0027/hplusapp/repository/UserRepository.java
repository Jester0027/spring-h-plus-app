package io.github.jester0027.hplusapp.repository;

import io.github.jester0027.hplusapp.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
