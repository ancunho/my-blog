package online.cunho.blog.dao;

import online.cunho.blog.entity.SysUserRole;

import java.util.Map;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    void deleteSysUserRoleByUserSeq(Integer userSeq);

    int insertSysUserRoleByUserSeqRoleIds(Map<String, Object> mapParams);
}