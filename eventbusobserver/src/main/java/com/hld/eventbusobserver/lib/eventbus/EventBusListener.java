package com.hld.eventbusobserver.lib.eventbus;

public interface EventBusListener {
	void onEvent(String action,Object obj);
}
