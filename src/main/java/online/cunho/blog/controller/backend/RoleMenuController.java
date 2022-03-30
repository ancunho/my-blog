package online.cunho.blog.controller.backend;

import online.cunho.blog.annotation.AdminUserLogin;
import online.cunho.blog.common.BaseResponse;
import online.cunho.blog.common.ResponseCode;
import online.cunho.blog.dto.*;
import online.cunho.blog.entity.SysMenu;
import online.cunho.blog.entity.SysRole;
import online.cunho.blog.entity.SysUser;
import online.cunho.blog.service.RoleMenuService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.cunho.blog.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/backend/config")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 메뉴 리스트 가져오기
     * @return
     */
    @GetMapping("/menu/list")
    @AdminUserLogin
    public BaseResponse getAllSysMenuList(HttpServletRequest request, BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPage(),baseRequest.getLimit());
        List<SysMenuDto> result = roleMenuService.getAllSysMenuList();
        return BaseResponse.valueOfSuccessList(result);
    }

    /**
     * 메뉴편집
     * 메뉴ID가 없으면 -> 신규추가
     * 메뉴ID가 있으면 -> 수정/편집
     * @param sysMenuDto
     * @return
     */
    @PostMapping(value = "/menu/modify")
    @AdminUserLogin
    public BaseResponse modifySysMenu(HttpServletRequest request, @RequestBody SysMenuDto sysMenuDto) {
        if (StringUtils.isEmpty(sysMenuDto.getName())
            || sysMenuDto.getType() == null
            || StringUtils.isEmpty(String.valueOf(sysMenuDto.getType()))
            || StringUtils.isEmpty(sysMenuDto.getStatus())
        ) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        if (sysMenuDto.getId() == null || String.valueOf(sysMenuDto.getId()) == "") {
            // insert New
            // 1. check menu name repeat
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("menuName", sysMenuDto.getName());
            mapParams.put("menuPerms", sysMenuDto.getPerms());
            boolean isExistMenuName = roleMenuService.existMenuName(mapParams);
            if (isExistMenuName) {
                return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ERROR.getCode(), "菜单名,权限码不能重复,请使用其他名称");
            }

            // 2. SysMenu 저장
            SysMenu sysMenu = new SysMenu();
            sysMenu.setName(sysMenuDto.getName());
            sysMenu.setParentId((sysMenuDto.getParentId() == null || String.valueOf(sysMenuDto.getParentId()) == "") ? 0 : sysMenuDto.getParentId());
            sysMenu.setStatus(sysMenuDto.getStatus());
            sysMenu.setPath(sysMenuDto.getPath());
            sysMenu.setPerms(sysMenuDto.getPerms());
            sysMenu.setComponent(sysMenuDto.getComponent());
            sysMenu.setType(sysMenuDto.getType());
            sysMenu.setIcon(sysMenuDto.getIcon());
            sysMenu.setOrderNum(sysMenuDto.getOrderNum());
            sysMenu.setOption01(sysMenuDto.getOption01());
            sysMenu.setOption02(sysMenuDto.getOption02());
            sysMenu.setOption03(sysMenuDto.getOption03());
            sysMenu.setOption04(sysMenuDto.getOption04());
            sysMenu.setOption05(sysMenuDto.getOption05());
            boolean isSuccessInsert = roleMenuService.insertSysMenu(sysMenu);
            if (isSuccessInsert) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
        } else {
            // modify origin
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("menuId", sysMenuDto.getId());
            mapParams.put("menuName", sysMenuDto.getName());
            mapParams.put("menuPerms", sysMenuDto.getPerms());
            boolean isExistMenuName = roleMenuService.existMenuName(mapParams);
            if (isExistMenuName) {
                return BaseResponse.valueOfFailureMessage("菜单名,权限码不能重复,请使用其他名称");
            }

            SysMenu sysMenu = new SysMenu();
            sysMenu.setId(sysMenuDto.getId());
            sysMenu.setName(sysMenuDto.getName());
            sysMenu.setParentId((sysMenuDto.getParentId() == null || String.valueOf(sysMenuDto.getParentId()) == "") ? 0 : sysMenuDto.getParentId());
            sysMenu.setStatus(sysMenuDto.getStatus());
            sysMenu.setPath(sysMenuDto.getPath());
            sysMenu.setPerms(sysMenuDto.getPerms());
            sysMenu.setComponent(sysMenuDto.getComponent());
            sysMenu.setType(sysMenuDto.getType());
            sysMenu.setIcon(sysMenuDto.getIcon());
            sysMenu.setOrderNum(sysMenuDto.getOrderNum());
            sysMenu.setOption01(sysMenuDto.getOption01());
            sysMenu.setOption02(sysMenuDto.getOption02());
            sysMenu.setOption03(sysMenuDto.getOption03());
            sysMenu.setOption04(sysMenuDto.getOption04());
            sysMenu.setOption05(sysMenuDto.getOption05());

            boolean isSuccessUpdate = roleMenuService.updateSysMenu(sysMenu);
            if (isSuccessUpdate) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }
    }

    /**
     * 권한 리스트가져오기
     * @return
     */
    @GetMapping("/role/list")
    @AdminUserLogin
    public BaseResponse getAllSysRoleList(HttpServletRequest request, BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<SysRoleDto> returnData = roleMenuService.getAllSysRoleList();
        return BaseResponse.valueOfSuccessList(returnData);
    }

    /**
     * 권한 편집
     * 권한ID가 없으면 -> 신규추가
     * 권한ID가 있으면 -> 수정/편집
     * @param sysRoleDto
     * @return
     */
    @PostMapping(value = "/role/modify")
    @AdminUserLogin
    public BaseResponse modifySysRole(HttpServletRequest request, @RequestBody SysRoleDto sysRoleDto) {
        if (StringUtils.isEmpty(sysRoleDto.getName())
            || StringUtils.isEmpty(sysRoleDto.getCode())
            || StringUtils.isEmpty(sysRoleDto.getRemark())
            || StringUtils.isEmpty(sysRoleDto.getStatus())
        ) {
            return BaseResponse.valueOfSuccessMessage("权限名称,Code,备注,状态是必填项,请确认！");
        }

        if (sysRoleDto.getId() == null || String.valueOf(sysRoleDto.getId()) == "") {
            // insert New
            // 1. check role name repeat
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("roleName", sysRoleDto.getName());
            mapParams.put("roleCode", sysRoleDto.getCode());
            boolean isExistRoleName = roleMenuService.existRoleName(mapParams);
            if (isExistRoleName) {
                return BaseResponse.valueOfFailureMessage("权限名，权限Code不能重复, 请使用其他名称");
            }

            // 2. SysRole 저장
            SysRole sysRole = new SysRole();
            sysRole.setName(sysRoleDto.getName());
            sysRole.setCode(sysRoleDto.getCode());
            sysRole.setRemark(sysRoleDto.getRemark());
            sysRole.setStatus(sysRoleDto.getStatus());

            boolean isSuccessInsert = roleMenuService.insertSysRole(sysRole);
            if (isSuccessInsert) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
        } else {
            // modify origin
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("roleId", sysRoleDto.getId());
            mapParams.put("roleName", sysRoleDto.getName());
            mapParams.put("roleCode", sysRoleDto.getCode());
            boolean isExistRoleName = roleMenuService.existRoleName(mapParams);
            if (isExistRoleName) {
                return BaseResponse.valueOfFailureMessage("权限名，权限Code不能重复, 请使用其他名称");
            }

            // 2. SysRole 저장
            SysRole sysRole = new SysRole();
            sysRole.setId(sysRoleDto.getId());
            sysRole.setName(sysRoleDto.getName());
            sysRole.setCode(sysRoleDto.getCode());
            sysRole.setRemark(sysRoleDto.getRemark());
            sysRole.setStatus(sysRoleDto.getStatus());
            boolean isSuccessUpdate = roleMenuService.updateSysRole(sysRole);
            if (isSuccessUpdate) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }

    }

    /**
     * 권한ID로 해당권한에 부여된 메뉴리스트 가져오기
     * @param roleId
     * @return
     */
    @GetMapping("/rolemenu/detail")
    @AdminUserLogin
    public BaseResponse<List<SysRoleMenuDto>> getSysRoleMenuByRoleId(HttpServletRequest request, @RequestParam("roleId") Integer roleId) {
        if (roleId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<SysRoleMenuDto> resultList = roleMenuService.getSysRoleMenuByRoleId(roleId);
        return BaseResponse.valueOfSuccess(resultList);
    }

    /**
     * 권한ID와 메뉴배열로 권한<->메뉴 관계데이타 편집
     * 1단계: 해당roleId로 데이타 삭제
     * 2단계: roleId, menuIds배열로 데이타 Insert
     * @param roleId
     * @param menuIds
     * @return
     */
    @PostMapping(value = "/rolemenu/modify")
    @AdminUserLogin
    public BaseResponse modifySysRoleMenu(HttpServletRequest request, @RequestParam("roleId") Integer roleId, @RequestParam("menuIds") String menuIds) {
        if (roleId == null || "".equals(menuIds)) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            // 1단계
            roleMenuService.deleteSysRoleMenuByRoleId(roleId);
            // 2단계
            List<String> lstMenuIds = Arrays.asList(menuIds.split(","));
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("roleId", roleId);
            mapParams.put("lstMenuIds", lstMenuIds);
            Boolean isSuccessInsert = roleMenuService.insertSysRoleMenuByRoleIdMenuIds(mapParams);
            if (isSuccessInsert) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
            } else {
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }

    }

    /**
     * 권한 리스트가져오기
     * @return
     */
    @GetMapping("/user/list")
    @AdminUserLogin
    public BaseResponse getAllSysUserList(HttpServletRequest request, BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<SysUserDto> returnData = roleMenuService.getAllSysUserList();
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @PostMapping("/user/modify")
    @AdminUserLogin
    public BaseResponse modifySysUser(HttpServletRequest request, @RequestBody SysUserDto sysUserDto) {
        if (StringUtils.isEmpty(sysUserDto.getUsername())
            || StringUtils.isEmpty(sysUserDto.getRealname())
        ) {
            return BaseResponse.valueOfFailureMessage("用户名和姓名必填");
        }

        if (sysUserDto.getUserSeq() == null || String.valueOf(sysUserDto.getUserSeq()) == "") {
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("username", sysUserDto.getUsername());
            boolean isExistUsername = roleMenuService.existUserName(mapParams);
            if (isExistUsername) {
                return BaseResponse.valueOfFailureMessage("Username重复,请使用其他用户名");
            }

            SysUser sysUser = new SysUser();
            sysUser.setUsername(sysUserDto.getUsername());
            if (StringUtils.isEmpty(sysUserDto.getPassword())) {
                sysUser.setPassword(MD5Util.MD5EncodeUtf8("g12345678"));
            } else {
                sysUser.setPassword(MD5Util.MD5EncodeUtf8(sysUserDto.getPassword()));
            }
            sysUser.setRoleNo(sysUserDto.getRoleNo());
            sysUser.setRole(sysUserDto.getRole());
            sysUser.setStatus(sysUserDto.getStatus());
            sysUser.setUserType(sysUserDto.getUserType());
            sysUser.setRealname(sysUserDto.getRealname());
            sysUser.setCompany(sysUserDto.getCompany());
            sysUser.setCompanyType(sysUserDto.getCompanyType());
            sysUser.setMobileNo(sysUserDto.getMobileNo());
            sysUser.setEmail(sysUserDto.getEmail());
            sysUser.setSex(sysUserDto.getSex());
            sysUser.setBirthday(sysUserDto.getBirthday());
            sysUser.setWechat(sysUserDto.getWechat());
            sysUser.setProvinceCode(sysUserDto.getProvinceCode());
            sysUser.setCityCode(sysUserDto.getCityCode());
            sysUser.setDistrictCode(sysUserDto.getDistrictCode());
            sysUser.setAddress(sysUserDto.getAddress());
            sysUser.setQuestion(sysUserDto.getQuestion());
            sysUser.setAnswer(sysUserDto.getAnswer());
            sysUser.setImagePhoto(sysUserDto.getImagePhoto());
            sysUser.setOption01(sysUserDto.getOption01());
            sysUser.setOption02(sysUserDto.getOption02());
            sysUser.setOption03(sysUserDto.getOption03());
            sysUser.setOption04(sysUserDto.getOption04());
            sysUser.setOption05(sysUserDto.getOption05());
            sysUser.setUseYn(sysUserDto.getUseYn());

            boolean isSuccessInsert = roleMenuService.insertSysUser(sysUser);
            if (isSuccessInsert) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
        } else {
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("username", sysUserDto.getUsername());
            mapParams.put("userSeq", sysUserDto.getUserSeq());
            boolean isExistUsername = roleMenuService.existUserName(mapParams);
            if (isExistUsername) {
                return BaseResponse.valueOfFailureMessage("Username重复,请使用其他用户名");
            }

            SysUser sysUser = new SysUser();
            sysUser.setUserSeq(sysUserDto.getUserSeq());
            sysUser.setUsername(sysUserDto.getUsername());
            sysUser.setPassword(MD5Util.MD5EncodeUtf8(sysUserDto.getPassword()));
            sysUser.setRoleNo(sysUserDto.getRoleNo());
            sysUser.setRole(sysUserDto.getRole());
            sysUser.setStatus(sysUserDto.getStatus());
            sysUser.setUserType(sysUserDto.getUserType());
            sysUser.setRealname(sysUserDto.getRealname());
            sysUser.setCompany(sysUserDto.getCompany());
            sysUser.setCompanyType(sysUserDto.getCompanyType());
            sysUser.setMobileNo(sysUserDto.getMobileNo());
            sysUser.setEmail(sysUserDto.getEmail());
            sysUser.setSex(sysUserDto.getSex());
            sysUser.setBirthday(sysUserDto.getBirthday());
            sysUser.setWechat(sysUserDto.getWechat());
            sysUser.setProvinceCode(sysUserDto.getProvinceCode());
            sysUser.setCityCode(sysUserDto.getCityCode());
            sysUser.setDistrictCode(sysUserDto.getDistrictCode());
            sysUser.setAddress(sysUserDto.getAddress());
            sysUser.setQuestion(sysUserDto.getQuestion());
            sysUser.setAnswer(sysUserDto.getAnswer());
            sysUser.setImagePhoto(sysUserDto.getImagePhoto());
            sysUser.setOption01(sysUserDto.getOption01());
            sysUser.setOption02(sysUserDto.getOption02());
            sysUser.setOption03(sysUserDto.getOption03());
            sysUser.setOption04(sysUserDto.getOption04());
            sysUser.setOption05(sysUserDto.getOption05());
            sysUser.setUseYn(sysUserDto.getUseYn());

            boolean isSuccessUpdate = roleMenuService.updateSysUser(sysUser);
            if (isSuccessUpdate) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
            }
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }

    }

    @GetMapping("/user/role")
    @AdminUserLogin
    public BaseResponse getRoleListByUserSeq(HttpServletRequest request, @RequestParam("userSeq") Integer userSeq) {
        if (userSeq == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<SysUserDto> reutrnData = roleMenuService.getRoleListByUserSeq(userSeq);
        return BaseResponse.valueOfSuccessList(reutrnData);
    }

    @PostMapping("/user/role/modify")
    @AdminUserLogin
    public BaseResponse modifySysUserRoleByUserSeq(HttpServletRequest request, @RequestParam("userSeq") Integer userSeq, @RequestParam("roleIds") String roleIds) {
        if (userSeq == null || "".equals(roleIds)) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            // 1. Delete sys_user_role by userSeq
            roleMenuService.deleteSysUserRoleByUserSeq(userSeq);

            // 2. Insert new data to sys_user_role
            List<String> lstRoleIds = Arrays.asList(roleIds.split(","));
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("userSeq", userSeq);
            mapParams.put("lstRoleIds", lstRoleIds);
            Boolean isSuccessInsert = roleMenuService.insertSysUserRoleByUserSeqRoleIds(mapParams);
            if (isSuccessInsert) {
                return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
            } else {
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }

            // TODO 유저의 권한을 수정했을때 유저테이블의 updatetime도 바꿔줘야됨
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_SUCCESS.getDesc());
        }
    }

}
