package com.sommelier.wine4you.repository;

import com.sommelier.wine4you.model.ShoppingCart;
import com.sommelier.wine4you.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUser(User user);

    List<ShoppingCart> findAllByUser(User user);

    List<ShoppingCart> deleteByUser(User user);
}
