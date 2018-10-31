package com.hld.eventbusobserver.eventbus;

public interface EventBusListener {
	void onEvent(String action,Object obj);
}
