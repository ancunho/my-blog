package online.cunho.blog.dao;

import online.cunho.blog.dto.SysUserDto;
import online.cunho.blog.entity.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userSeq);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userSeq);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUserDto> getAllSysUserList();

    Integer existUserName(Map<String, Object> mapParams);

    List<SysUserDto> getRoleListByUserSeq(Integer userSeq);

    SysUserDto getSysUserByUsernameAndPassword(SysUserDto sysUserDto);
}