package com.learning.cloud.taco.repository;

import com.learning.cloud.taco.domain.Order;

public interface OrderRepository {

    Order save( Order order );

}
