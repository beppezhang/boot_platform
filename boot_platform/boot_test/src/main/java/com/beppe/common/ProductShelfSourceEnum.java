package com.beppe.common;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 上下架来源枚举类
 *
 * @author linxiaocheng
 * @Date 2021-11-19 11:27
 */
public enum ProductShelfSourceEnum {
    INVENTORY_CHANGES(1, "库存变动", "inventory", "inventory"),
    INVENTORY_COMPENSATE(2, "补偿上架", "compensate_task", "compensate_task"),
    SHELF_PROCESS(3, "商品上架流程", "", ""),
    STOCK_CHANGE(4, "存货变更", "stock_change", "stock_change"),
    AUTO_CHANGE(5, "自动上架配置变更", "auto_change", "auto_change"),
    REPLACE_PROCESS(6, "汰换且库存为0", "汰换且库存为0", "汰换且库存为0"),
    MANUAL_OPERATE(7, "后管手动操作", "", ""),
    EMERGENCY_REMOVAL(8, "紧急下架", "", ""),
    PRODUCT_FORMAL_STATUS(9, "正式品", "product_formal_status", "product_formal_status"),
    SHARED_STAION_ADD(10, "共享仓新增商品", "shared_staion_add", "shared_staion_add"),
    SHARED_STAION_REMOVE(11, "共享仓删除前仓", "shared_staion_remove", "shared_staion_remove"),
    AGGREGATE_INVENTORY_CHANGE(12, "聚合库存变动", "aggregate_inventory_change", "aggregate_inventory_change"),
    SECONDARY_REPLACE(13, "二次汰换", "", ""),
    RESTORE_SHELVES(14, "恢复上架", "", ""),
    OLD_PRODUCTS_RESUME_SALE(15, "老品售卖", "", ""),
    SPECIAL_SHELF_PRODUCT(16, "特殊商品上下架", "special_shelf_product", "special_shelf_product"),
    GROUP_CHILD_PRODUCT_SHELF_OFF(17, "组合子品下架联动下架组合品", "", ""),
    UNKNOWN_SOURCE(-1, "未知来源", "unknown_source", "unknown_source");

    private final Integer code;
    private final String desc;
    private final String operator;
    private final String operatorName;

    ProductShelfSourceEnum(Integer code, String desc, String operator, String operatorName) {
        this.code = code;
        this.desc = desc;
        this.operator = operator;
        this.operatorName = operatorName;
    }

    public static ProductShelfSourceEnum getEnum(Integer code) {
        if (code == null) {
            return null;
        }
        Optional<ProductShelfSourceEnum> optional =
                Stream.of(ProductShelfSourceEnum.values()).filter(t -> t.getCode().equals(code)).findFirst();
        return optional.orElseGet(null);
    }

    public static ProductShelfSourceEnum getEnumByDesc(String desc) {
        if (desc == null) {
            return null;
        }
        Optional<ProductShelfSourceEnum> optional =
                Stream.of(ProductShelfSourceEnum.values()).filter(t -> t.getDesc().equals(desc)).findFirst();
        return optional.orElseGet(null);
    }

    public static ProductShelfSourceEnum getEnumByEnumsName(String enumName) {
        if (StringUtils.isBlank(enumName)) {
            return null;
        }
        Optional<ProductShelfSourceEnum> optional =
                Stream.of(ProductShelfSourceEnum.values()).filter(t -> t.toString().equals(enumName)).findFirst();
        return optional.orElseGet(null);
    }

    public Integer getCode() {
        return code;
    }

    public String getOperator() {
        return operator;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public String getDesc() {
        return desc;
    }


}
