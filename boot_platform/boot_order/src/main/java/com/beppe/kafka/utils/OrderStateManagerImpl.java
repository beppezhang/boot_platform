package com.beppe.kafka.utils;

import com.beppe.kafka.fuse.OrderEvent;
import com.beppe.kafka.fuse.OrderEventHandler;
import com.beppe.kafka.fuse.OrderStateManager;
import com.beppe.kafka.fuse.OrderStateTransitionListener;

import java.util.List;
import java.util.Map;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 3:09 下午
 */
public class OrderStateManagerImpl implements OrderStateManager {

    // 初始化 由配置文件搞定
    private final Map<String, OrderEventHandler> handlers;

    private final Map<String, List<? extends OrderStateTransitionListener>> beforeListenersMap;

    private final Map<String, List<? extends OrderStateTransitionListener>> afterListenersMap;

    public OrderStateManagerImpl(
            final Map<String, OrderEventHandler> handlers,
            final Map<String, List<? extends OrderStateTransitionListener>> beforeListenersMap,
            final Map<String, List<? extends OrderStateTransitionListener>> afterListenersMap) {
        this.handlers = handlers;
        this.beforeListenersMap = beforeListenersMap;
        this.afterListenersMap = afterListenersMap;
    }

    @Override
    public boolean fireTransition(final OrderEvent orderEvent) {
        // 根据 eventId 拿到对应的 OrderEventHandler  在配置文件中配置的
        final OrderEventHandler handler = handlers.get(orderEvent.getEventId());
        if (handler == null) {

        } else {
            // 前置监听
            fireEventListeners(beforeListenersMap, orderEvent);
            boolean result;
            try {
                result = handler.handle(orderEvent);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
            fireEventListeners(afterListenersMap, orderEvent);
        }
        return false;
    }

    private void fireEventListeners(final Map<String, List<? extends OrderStateTransitionListener>> map,
                                    final OrderEvent event) {
        if (map != null) {
            final List<? extends OrderStateTransitionListener> beforeListeners = map.get(event.getEventId());
            if (beforeListeners != null) {
                for (OrderStateTransitionListener listener : beforeListeners) {
                    try {
                        listener.onEvent(event);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

}
