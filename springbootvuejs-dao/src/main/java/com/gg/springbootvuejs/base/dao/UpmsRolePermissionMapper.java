package com.gg.springbootvuejs.base.dao;

import com.gg.springbootvuejs.base.entity.UpmsRolePermission;
import com.gg.springbootvuejs.base.entity.UpmsRolePermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpmsRolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    long countByExample(UpmsRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    int deleteByExample(UpmsRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    int deleteByPrimaryKey(Integer rolePermissionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    int insert(UpmsRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    int insertSelective(UpmsRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    List<UpmsRolePermission> selectByExample(UpmsRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    UpmsRolePermission selectByPrimaryKey(Integer rolePermissionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    int updateByExampleSelective(@Param("record") UpmsRolePermission record, @Param("example") UpmsRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    int updateByExample(@Param("record") UpmsRolePermission record, @Param("example") UpmsRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    int updateByPrimaryKeySelective(UpmsRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table upms_role_permission
     *
     * @mbg.generated Sat Apr 21 22:51:18 CST 2018
     */
    int updateByPrimaryKey(UpmsRolePermission record);
}