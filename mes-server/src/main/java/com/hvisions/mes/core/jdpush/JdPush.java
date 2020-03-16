package com.hvisions.mes.core.jdpush;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 极光推送
 * @author: Bruce
 * @version:
 * @date: 2020-02-25 13:01
 */
public class JdPush {


    /**
     * Android版
     * @param parm
     */
    public static void jpushAndroid(Map<String, String> parm) {
        // 设置好账号的app_key和masterSecret
        String appKey = "cd49a2263e783fc9422b84ee";
        String masterSecret = "d9bfebdde1daeabce2d3c7a6";
        //创建JPushClient
        JPushClient jpushClient = new JPushClient(masterSecret, appKey);
        //推送的关键,构造一个payload
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android())//指定android平台的用户
                .setAudience(Audience.all())//你项目中的所有用户
                .setNotification(Notification.android(parm.get("msg"), "这是title", parm))
                //发送内容,这里不要盲目复制粘贴,这里是我从controller层中拿过来的参数)
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                //这里是指定开发环境,不用设置也没关系
                .setMessage(Message.content(parm.get("msg")))//自定义信息
                .build();

        try {
            PushResult pu = jpushClient.sendPush(payload);

        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * iOS版
     * @param parm
     */
    public static  void jpushIOS(Map<String, String> parm) {
        // 设置好账号的app_key和masterSecret是必须的
        String appKey = "cd49a2263e783fc9422b84ee";
        String masterSecret = "d9bfebdde1daeabce2d3c7a6";

        //创建JPushClient
        JPushClient jpushClient = new JPushClient(masterSecret, appKey);
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.ios())//ios平台的用户
                .setAudience(Audience.all())//所有用户
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(parm.get("msg"))
                                .setBadge(+1)
                                .setSound("happy")
                                .addExtras(parm)
                                .build())
                        .build())
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                .setMessage(Message.newBuilder().setMsgContent(parm.get("msg")).addExtras(parm).build())//自定义信息
                .build();

        try {
            PushResult pu = jpushClient.sendPush(payload);

        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, String> parm = new HashMap<String, String>();
        //这里的id是,移动端集成极光并登陆后,极光用户的rid
        parm.put("id", "13165ffa4e594a31ed0");
        //设置提示信息,内容是文章标题
        parm.put("msg","测试测试,收到请联系发送人");
        jpushIOS(parm);
    }
}
