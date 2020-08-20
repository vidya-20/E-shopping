package com.online.dao;

import java.util.List;

import com.online.model.Cart;

public interface cartDao {
	public boolean addToCart(Cart cartItem);

	public boolean deleteCartItem(Cart cartItem);

	public boolean updateCartItem(Cart cartItem);

	public List<Cart> listCartItems(String username);

	public Cart getCartItem(int cartItemId);
}
