package com.hefshine.ecom.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hefshine.ecom.entity.Seller;
import com.hefshine.ecom.repository.SellerRepository;
import com.hefshine.ecom.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerRepository sellerRepository;

	@Override
	public Seller registerSeller(Seller seller) {
		Seller sel = sellerRepository.save(seller);
		return sel;
	}

	@Override
	public Seller authenticateSeller(Object username, Object password) {
	    String usernameStr = username.toString();
	    String passwordStr = password.toString();
	    System.out.println("Authenticating user: " + usernameStr); // Add this line
	    Seller seller = sellerRepository.findByUsernameAndPassword(usernameStr, passwordStr);
	    System.out.println("Seller found: " + seller); // Add this line
	    return seller;
	}

}
