package com.baomidou.po.courtyard;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 院落表
 * </p>
 *
 * @author zhangkun
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("house_courtyard_base")
public class HouseCourtyardBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键UUID
     */
    @TableId("courtyard_id")
    private String courtyardId;

    /**
     * 管理单位ID
     */
    @TableField("organ_id")
    private String organId;

    /**
     * 院落名称
     */
    @TableField("courtyard_name")
    private String courtyardName;

    /**
     * 院落地址
     */
    @TableField("courtyard_address")
    private String courtyardAddress;

    /**
     * 经度
     */
    @TableField("longitude")
    private String longitude;

    /**
     * 纬度
     */
    @TableField("latitude")
    private String latitude;

    /**
     * YES表示删除NO表示未删除
     */
    @TableField("logic_delete")
    private String logicDelete;

    /**
     * 所属地区
     */
    @TableField("area_id")
    private String areaId;

    /**
     * 创建者ID
     */
    @TableField("create_user_id")
    private String createUserId;

    /**
     * 创建时间
     */
    @TableField("date_created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDateTime dateCreated;

    /**
     * 更新时间
     */
    @TableField("date_updated")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDateTime dateUpdated;


}
