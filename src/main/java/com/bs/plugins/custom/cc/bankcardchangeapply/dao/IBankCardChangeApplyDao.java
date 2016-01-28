package com.bs.plugins.custom.cc.bankcardchangeapply.dao;

import java.util.List;

import com.bs.plugins.custom.cc.bankcardchangeapply.base.BaseBankCardChangeApplyDao;
import com.bs.plugins.custom.cc.bankcardchangeapply.entity.BankCardChangeApply;

public interface IBankCardChangeApplyDao extends BaseBankCardChangeApplyDao<BankCardChangeApply>{
	public List<BankCardChangeApply> selectAllPaginatedList(BankCardChangeApply bankCardChangeApply);
}
