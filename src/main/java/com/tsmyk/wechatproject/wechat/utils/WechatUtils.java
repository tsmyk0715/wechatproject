package com.tsmyk.wechatproject.wechat.utils;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 微信工具类
 */
@Component
public class WechatUtils {
    @Value("${wechat.interface.config.token}")
    private String token;
    @Value("${wechat.appid}")
    private String appid;
    @Value("${wechat.appsecret}")
    private String appsecret;

    public String getToken() { return token; }
    public String getAppid() {
        return appid;
    }
    public String getAppsecret() {
        return appsecret;
    }

    /**
     * 调用微信接口
     */
    private WxMpService wxMpService;

    /**
     * 初始化
     */
    @PostConstruct
    private void init() {
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(appid);
        wxMpConfigStorage.setSecret(appsecret);
        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);
    }

    /**
     * 获取 access_token 不刷新
     *
     * @return access_token
     * @throws WxErrorException
     */
    public String getAccessToken() throws WxErrorException {
        return wxMpService.getAccessToken();
    }

    /**
     * 获取微信服务器IP列表
     * @param accessToken accessToken
     * @return IP
     * @throws WxErrorException e
     */
    public String[] getWechatServerIp(String accessToken) throws WxErrorException {
        return wxMpService.getCallbackIP();
    }

    /**
     * 获取关注者列表
     * @return 关注者列表
     * @throws WxErrorException e
     */
    public WxMpUserList getUserList() throws WxErrorException {
        return wxMpService.userList(null);
    }

    /**
     * 获取用户基本信息
     * @return 用户基本信息
     * @throws WxErrorException e
     */
    public WxMpUser getUserInfo(String openId) throws WxErrorException {
        return wxMpService.userInfo(openId, "zh_CN");
    }
}
