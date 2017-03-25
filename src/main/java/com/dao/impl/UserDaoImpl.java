package com.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.dao.UserDao;
import com.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer , User> implements UserDao{
	public User findById(int id){
		return getByKey(id);
	}
	public User findByuserName(String userName){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("userName", userName));
		return (User) crit.uniqueResult();
	}
}