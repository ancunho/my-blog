package online.cunho.blog.dao;

import online.cunho.blog.dto.SysRoleDto;
import online.cunho.blog.entity.SysRole;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRoleDto> getAllSysRoleList();

    Integer existRoleName(Map<String, Object> mapParams);



}