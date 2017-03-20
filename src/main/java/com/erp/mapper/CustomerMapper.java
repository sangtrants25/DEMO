package com.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.erp.model.Customer;

@Mapper
public interface CustomerMapper {
	@Insert("insert into [customer](name,CustomerNo) values(#{name},#{CustomerNo})")
	@SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = Integer.class)
	void insertCustomer(Customer cus);

	@Select("select id, name, CustomerNo from [customer] WHERE id=#{id}")
	Customer FindCustomerById(String id);

	@Select("select id, name, CustomerNo from [customer]")
	List<Customer> FindAllCustomer();
	
	@Update("update [customer] set Name = #{name} WHERE id=#{id}")
	void UpdateCustomer(Customer cus);

}
