package com.baomidou.po.room;

import java.math.BigDecimal;
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
 * 房间表
 * </p>
 *
 * @author zhangkun
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("house_room_base")
public class HouseRoomBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("room_id")
    private String roomId;

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
     * 楼层id
     */
    @TableField("storeys_id")
    private String storeysId;

    @TableField("storeys_name")
    private String storeysName;

    /**
     * 房间号
     */
    @TableField("room_no")
    private String roomNo;

    /**
     * 建筑面积
     */
    @TableField("build_area")
    private BigDecimal buildArea;

    /**
     * 使用面积
     */
    @TableField("user_area")
    private BigDecimal userArea;

    /**
     * 房间名称
     */
    @TableField("room_name")
    private String roomName;

    /**
     * 使用状态：INUSE在用;IDLE闲置
     */
    @TableField("use_status")
    private String useStatus;

    /**
     * 用户平台使用的状态,只有在用和空置两种EMPTY/USE
     */
    @TableField("use_client_status")
    private String useClientStatus;

    /**
     * 房间类型分类,办公室,服务用房,设备用房属于基本办公用房
     */
    @TableField("room_type_status")
    private String roomTypeStatus;

    /**
     * 删除区分
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

    /**
     * 颜色代码
     */
    @TableField("color_code")
    private String colorCode;

    /**
     * 矩形宽度
     */
    @TableField("width")
    private BigDecimal width;

    /**
     * 矩形高度
     */
    @TableField("height")
    private BigDecimal height;

    /**
     * 矩形横坐标
     */
    @TableField("pageX")
    private Integer pageX;

    /**
     * 矩形纵坐标
     */
    @TableField("pageY")
    private Integer pageY;

    /**
     * 多边形坐标
     */
    @TableField("house_room_points")
    private String houseRoomPoints;


}
