package online.cunho.blog.service.impl;

import online.cunho.blog.dao.*;
import online.cunho.blog.dto.SysMenuDto;
import online.cunho.blog.dto.SysRoleDto;
import online.cunho.blog.dto.SysRoleMenuDto;
import online.cunho.blog.dto.SysUserDto;
import online.cunho.blog.entity.SysMenu;
import online.cunho.blog.entity.SysRole;
import online.cunho.blog.entity.SysUser;
import online.cunho.blog.service.RoleMenuService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    public List<SysMenuDto> getAllSysMenuList() {
        return sysMenuMapper.getAllSysMenuList();
    }

    public Boolean existMenuName(Map<String, Object> mapParams) {
        Integer existMenuName = sysMenuMapper.existMenuName(mapParams);
        if (existMenuName == null) {
            return false; // menuName不存在
        }
        return true;
    }

    public Boolean insertSysMenu(SysMenu sysMenu) {
        int insertCount = sysMenuMapper.insertSelective(sysMenu);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateSysMenu(SysMenu sysMenu) {
        int updateCount = sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    public List<SysRoleDto> getAllSysRoleList() {
        return sysRoleMapper.getAllSysRoleList();
    }

    public Boolean existRoleName(Map<String, Object> mapParams) {
        Integer existRoleName = sysRoleMapper.existRoleName(mapParams);
        if (existRoleName == null) {
            return false; // menuName不存在
        }
        return true;
    }

    public Boolean insertSysRole(SysRole sysRole) {
        int insertCount = sysRoleMapper.insertSelective(sysRole);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateSysRole(SysRole sysRole) {
        int updateCount = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    public List<SysRoleMenuDto> getSysRoleMenuByRoleId(Integer roleId) {
        return sysRoleMenuMapper.getSysRoleMenuByRoleId(roleId);
    }

    @Transactional
    public void deleteSysRoleMenuByRoleId(Integer roleId) {
        sysRoleMenuMapper.deleteSysRoleMenuByRoleId(roleId);
    }

    @Transactional
    public Boolean insertSysRoleMenuByRoleIdMenuIds(Map<String, Object> mapParams) {
        int insertCount = sysRoleMenuMapper.insertSysRoleMenuByRoleIdMenuIds(mapParams);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    public List<SysUserDto> getAllSysUserList() {
        return sysUserMapper.getAllSysUserList();
    }

    public Boolean existUserName(Map<String, Object> mapParams) {
        Integer existUserName = sysUserMapper.existUserName(mapParams);
        if (existUserName == null) {
            return false; // USERNAME不存在
        }
        return true;
    }

    public Boolean insertSysUser(SysUser sysUser) {
        int insertCount = sysUserMapper.insertSelective(sysUser);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateSysUser(SysUser sysUser) {
        int updateCount = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    public List<SysUserDto> getRoleListByUserSeq(Integer userSeq) {
        return sysUserMapper.getRoleListByUserSeq(userSeq);
    }

    @Transactional
    public void deleteSysUserRoleByUserSeq(Integer userSeq) {
        sysUserRoleMapper.deleteSysUserRoleByUserSeq(userSeq);
    }

    @Transactional
    public Boolean insertSysUserRoleByUserSeqRoleIds(Map<String, Object> mapParams) {
        int insertCount = sysUserRoleMapper.insertSysUserRoleByUserSeqRoleIds(mapParams);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

}
