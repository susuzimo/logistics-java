package org.wtm.logistics.mapper;


import org.wtm.logistics.model.Contact;

public interface ContactMapper {
    int deleteByPrimaryKey(Integer contactid);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(Integer contactid);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);
}