package com.shop.service;

import java.util.List;

import com.shop.model.AccountModel;

public interface IAccountService {
	AccountModel checkAccount(String email);
	List<AccountModel> listAccount();
	void DeleteAccount(String email);

}
