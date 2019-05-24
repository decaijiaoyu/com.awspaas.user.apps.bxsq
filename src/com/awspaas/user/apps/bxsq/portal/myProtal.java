package com.awspaas.user.apps.bxsq.portal;

import com.actionsoft.bpms.commons.portal.skins.notifier.PortletNotificationMessage;
import com.actionsoft.bpms.commons.portal.skins.notifier.PortletNotifierInterface;
import com.actionsoft.bpms.server.UserContext;

import java.util.Map;

public class myProtal implements PortletNotifierInterface {
    @Override
    public PortletNotificationMessage flash(UserContext userContext, Map<String, String> map) {
        PortletNotificationMessage msg=new PortletNotificationMessage();

        String userName = userContext.getUserName();
        System.out.println("用户名："+userName);
        msg.setMetroBoxType(PortletNotificationMessage.METRO_BOX_1X2);
        msg.setContent("123456");
        msg.setBubble("hai");
        return msg;
    }

    @Override
    public String getMetroBoxType() {
        return PortletNotificationMessage.METRO_BOX_1X2;
    }
}
