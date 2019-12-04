package com.baomidou.po.storeys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 楼层表
 * </p>
 *
 * @author zhangkun
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("house_storeys_base")
public class HouseStoreysBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("storeys_id")
    private String storeysId;

    /**
     * 管理单位ID
     */
    @TableField("organ_id")
    private String organId;

    /**
     * 院落ID
     */
    @TableField("courtyard_id")
    private String courtyardId;

    @TableField("courtyard_name")
    private String courtyardName;

    /**
     * 楼座id
     */
    @TableField("floor_id")
    private String floorId;

    @TableField("floor_name")
    private String floorName;

    /**
     * 楼层名称
     */
    @TableField("storeys_name")
    private String storeysName;

    /**
     * 楼层排序值，越大越靠后
     */
    @TableField("sort_no")
    private Integer sortNo;

    /**
     * 是否上传楼层平面图YES|NO
     */
    @TableField("floor_plan")
    private String floorPlan;

    /**
     * 是否上传楼层CAD图YES|NO
     */
    @TableField("floor_cad")
    private String floorCad;

    /**
     * 删除区分 YES已删除 NO未删除
     */
    @TableField("logic_delete")
    private String logicDelete;

    /**
     * 创建者ID
     */
    @TableField("create_user_id")
    private String createUserId;

    /**
     * 创建时间
     */
    @TableField("date_created")
    private LocalDateTime dateCreated;

    /**
     * 修改时间
     */
    @TableField("last_updated")
    private LocalDateTime lastUpdated;


}
