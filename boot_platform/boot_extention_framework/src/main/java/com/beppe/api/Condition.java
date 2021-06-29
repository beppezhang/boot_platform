package com.beppe.api;

import com.beppe.common.DomainModel;

/**
 * 使用限制
 * @param <Model>
 */
public interface Condition<Model extends DomainModel> extends ExtensionPoint {

    boolean isApply(Model model);

}
