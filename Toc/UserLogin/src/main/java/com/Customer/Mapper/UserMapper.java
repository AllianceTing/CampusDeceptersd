package com.Customer.Mapper;

import com.Customer.PO.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Lenovo
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2023-01-29 15:59:33
 * @Entity generator.domain.Customer
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




