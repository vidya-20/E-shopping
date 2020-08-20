package com.online.dao;

import java.util.List;

import com.online.model.Supplier;

public interface supplierDao {
	public boolean addSupplier(Supplier supplier);

	public boolean deleteSupplier(Supplier supplier);

	public boolean updateSupplier(Supplier supplier);

	public List<Supplier> listSuppliers();

	public Supplier getSupplier(int supplierId);
}
