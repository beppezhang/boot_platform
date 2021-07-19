package com.beppe.command;

public interface Command {

    String COMMAND_INITIALIZE_ORDER="initialize.order";

    String COMMAND_VALIDATE_WEIGHT="validate.weight";

    String COMMAND_SET_ORDER_ID="set.order.id";

    String COMMAND_CALCULATE_PROMOTION="calculate.promotion";

    String COMMAND_VALIDATE_COUPON="validate.coupon";

    String COMMAND_VALIDATE_DELIVER_TIME="validate.deliver.time";

    String COMMAND_CALCULATE_POINT="calculate.point";

    String COMMAND_VALIDATE_BALANCE="validate.balance";

    String COMMAND_USE_POINT="use.point";

    String COMMAND_USE_COUPON="use_coupon";

    String getCmdKey();

    void execute(OrderCommandContext commandContext);
}
