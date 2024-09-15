package com.hefshine.ecom.service;

import com.hefshine.ecom.entity.Seller;

public interface SellerService {

	Seller registerSeller(Seller seller);

	Seller authenticateSeller(Object username, Object password);

}
