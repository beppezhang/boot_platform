package com.beppe.order;

import com.beppe.fuse.command.Command;
import com.beppe.fuse.command.CommandContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Mon co
 * @description
 * @time 2021/5/6 9:03 下午
 */
@Slf4j
@Component("persistOrderCommand")  // 在配置文件中配置的 persistOrderCommand
public class PersistOrderCommandImpl extends AbstractOrderCommandImpl {

    @Override
    public void execute(CommandContext context) {

        log.info("交由下游服务执行持久化，本服务数据组装完毕");

    }

    @Override
    public String getCmdKey() {
        return Command.COMMAND_PERSIST_ORDER;
    }
}
