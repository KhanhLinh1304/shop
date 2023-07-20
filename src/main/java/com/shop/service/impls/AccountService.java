package com.shop.service.impls;

import java.util.List;

import javax.inject.Inject;

import com.shop.dao.IAccountDAO;
import com.shop.model.AccountModel;
import com.shop.service.IAccountService;

public class AccountService implements IAccountService {
	@Inject
	private IAccountDAO accountDao;

	@Override
	public AccountModel checkAccount(String email) {
		// TODO Auto-generated method stub
		return accountDao.checkAccount(email);
	}

	@Override
	public List<AccountModel> listAccount() {
		// TODO Auto-generated method stub
		return accountDao.listAccount();
	}

	@Override
	public void DeleteAccount(String email) {
		accountDao.DeleteAccount(email);
		
	}

}
