package com.learning.cloud.taco.repository.impl;

import com.learning.cloud.taco.domain.Order;
import com.learning.cloud.taco.domain.Taco;
import com.learning.cloud.taco.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private final SimpleJdbcInsert orderInserter;
    private final SimpleJdbcInsert tacoInOrderInserter;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate template) {

        orderInserter = new SimpleJdbcInsert(template)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id");

        tacoInOrderInserter = new SimpleJdbcInsert(template)
                .withTableName("Taco_Order_Tacos");

    }

    @Override
    public Order save(Order order) {

        order.setPlacedAt(new Date());
        long orderId = saveOrderBasicDetails(order);
        order.setId(orderId);

        List<Taco> tacosInThisOrder = order.getTacos();
        for (Taco createdTaco : tacosInThisOrder) {
            saveTacoPlacedInOrder(createdTaco, orderId);
        }

        return order;

    }

    private long saveOrderBasicDetails(Order order) {

        Map<String, Object> columnToValuesMap = new HashMap<>();

        columnToValuesMap.put("placedAt", order.getPlacedAt());
        columnToValuesMap.put("deliveryName", order.getName());
        columnToValuesMap.put("deliveryStreet", order.getStreet());
        columnToValuesMap.put("deliveryCity", order.getCity());

        columnToValuesMap.put("deliveryState", order.getState());
        columnToValuesMap.put("deliveryZip", order.getZip());
        columnToValuesMap.put("ccNumber", order.getCcNumber());
        columnToValuesMap.put("ccExpiration", order.getCcExpiry());

        columnToValuesMap.put("ccCvv", order.getCcCvv());

        return this.orderInserter.executeAndReturnKey(columnToValuesMap)
                .longValue();

    }

    private void saveTacoPlacedInOrder(Taco taco, long orderId) {

        Map<String, Object> columnToValuesMap = new HashMap<>();
        columnToValuesMap.put("taco", taco.getId());
        columnToValuesMap.put("tacoOrder", orderId);

        tacoInOrderInserter.execute(columnToValuesMap);

    }
}
