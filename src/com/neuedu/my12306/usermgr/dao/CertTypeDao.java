package com.neuedu.my12306.usermgr.dao;

import com.neuedu.my12306.usermgr.domain.CertType;
import java.sql.SQLException;
import java.util.List;

public interface CertTypeDao {
	List<CertType> getCertType() throws SQLException; //查找所有记录
	boolean addCertType(CertType ct);  //增
	boolean deleteCertType(CertType ct); //删
	CertType findJQ(String s, Object o);   //精确查找
	List<CertType> findMH(String s, Object o); //模糊查找
    boolean ModifyCertType(CertType ct); //改
}
