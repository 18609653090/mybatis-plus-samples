package com.baomidou.po.floor;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 楼座表
 * </p>
 *
 * @author zhangkun
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("house_floor_base")
public class HouseFloorBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("floor_id")
    private String floorId;

    /**
     * 管理单位ID
     */
    @TableField("organ_id")
    private String organId;

    /**
     * 所属院落Id
     */
    @TableField("courtyard_id")
    private String courtyardId;

    @TableField("courtyard_name")
    private String courtyardName;

    /**
     * 楼座名称
     */
    @TableField("floor_name")
    private String floorName;

    /**
     * 建筑结构ONE("钢结构") ,TWO("砖木结构"),THREE("钢筋混凝土结构"),FOUR("钢筋混凝土混合结构")
     */
    @TableField("house_structure")
    private String houseStructure;

    /**
     * 建筑面积
     */
    @TableField("built_area")
    private BigDecimal builtArea;

    /**
     * 建造年份
     */
    @TableField("architectural_date")
    private String architecturalDate;

    /**
     * 地上建筑层数
     */
    @TableField("up_floor_number")
    private Integer upFloorNumber;

    /**
     * 地下建筑层数
     */
    @TableField("down_floor_number")
    private Integer downFloorNumber;

    /**
     * 竣工日期
     */
    @TableField("completion_date")
    private LocalDate completionDate;

    /**
     * 投入使用日期
     */
    @TableField("put_use_date")
    private LocalDate putUseDate;

    /**
     * 创建者ID
     */
    @TableField("create_user_id")
    private String createUserId;

    /**
     * 删除区分 YES已删除 NO未删除
     */
    @TableField("logic_delete")
    private String logicDelete;

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
