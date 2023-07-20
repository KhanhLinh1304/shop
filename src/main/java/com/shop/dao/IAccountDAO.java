package com.shop.dao;

import java.util.List;

import com.shop.model.AccountModel;

public interface IAccountDAO {
	AccountModel checkAccount(String email);
	List<AccountModel> listAccount();
	void DeleteAccount(String email);

}
