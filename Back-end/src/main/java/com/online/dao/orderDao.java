package com.online.dao;

import com.online.model.OrderDetail;

public interface orderDao {

	public boolean payment(OrderDetail orderDetail);

	public boolean updateCartItemStatus(String username, int orderId);
}
