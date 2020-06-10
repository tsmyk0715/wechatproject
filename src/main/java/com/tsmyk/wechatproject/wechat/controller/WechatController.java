package com.tsmyk.wechatproject.wechat.controller;

import com.tsmyk.wechatproject.wechat.pojo.*;
import com.tsmyk.wechatproject.wechat.utils.WechatUtils;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class WechatController {
    /** 日志 */
    private Logger logger = LoggerFactory.getLogger(getClass());
    /** 工具类 */
    @Autowired
    private WechatUtils wechatUtils;

    /**
     * 微信公众号接口配置验证
     * @return
     */
    @RequestMapping(value = "/wechat", method = RequestMethod.GET)
    public String checkSignature(String signature, String timestamp, String nonce, String echostr) {
        logger.info("signature = {}", signature);
        logger.info("timestamp = {}", timestamp);
        logger.info("nonce = {}", nonce);
        logger.info("echostr = {}", echostr);
        // 第一步：自然排序
        String[] tmp = {wechatUtils.getToken(), timestamp, nonce};
        Arrays.sort(tmp);
        // 第二步：sha1 加密
        String sourceStr = StringUtils.join(tmp);
        String localSignature = DigestUtils.sha1Hex(sourceStr);
        // 第三步：验证签名
        if (signature.equals(localSignature)) {
            return echostr;
        }
        return null;
    }


    /**
     * 接收用户下消息
     * @param receiveMsgBody 消息
     * @return
     */
    @RequestMapping(value = "/wechat", method = RequestMethod.POST, produces = {"application/xml; charset=UTF-8"})
    @ResponseBody
    public Object getUserMessage(@RequestBody ReceiveMsgBody receiveMsgBody) {
        logger.info("接收到的消息：{}", receiveMsgBody);
        MsgType msgType = MsgType.getMsgType(receiveMsgBody.getMsgType());
        switch (msgType) {
            case text:
                logger.info("接收到的消息类型为{}", MsgType.text.getMsgTypeDesc());
                ResponseMsgBody textMsg = new ResponseMsgBody();
                textMsg.setToUserName(receiveMsgBody.getFromUserName());
                textMsg.setFromUserName(receiveMsgBody.getToUserName());
                textMsg.setCreateTime(new Date().getTime());
                textMsg.setMsgType(MsgType.text.getMsgType());
                textMsg.setContent(receiveMsgBody.getContent());
                return textMsg;
            case image:
                logger.info("接收到的消息类型为{}", MsgType.image.getMsgTypeDesc());
                ResponseImageMsg imageMsg = new ResponseImageMsg();
                imageMsg.setToUserName(receiveMsgBody.getFromUserName());
                imageMsg.setFromUserName(receiveMsgBody.getToUserName());
                imageMsg.setCreateTime(new Date().getTime());
                imageMsg.setMsgType(MsgType.image.getMsgType());
                imageMsg.setMediaId(new String[]{receiveMsgBody.getMediaId()});
                return imageMsg;
            case voice:
                logger.info("接收到的消息类型为{}", MsgType.voice.getMsgTypeDesc());
                ResponseVoiceMsg voiceMsg = new ResponseVoiceMsg();
                voiceMsg.setToUserName(receiveMsgBody.getFromUserName());
                voiceMsg.setFromUserName(receiveMsgBody.getToUserName());
                voiceMsg.setCreateTime(new Date().getTime());
                voiceMsg.setMsgType(MsgType.voice.getMsgType());
                voiceMsg.setMediaId(new String[]{receiveMsgBody.getMediaId()});
                return voiceMsg;
            default:
                // 其他类型
                break;
        }
       return null;
    }

    @RequestMapping("/getAccessToken")
    public void getAccessToken() {
        try {
            String accessToken = wechatUtils.getAccessToken();
            logger.info("access_token = {}", accessToken);
        } catch (WxErrorException e) {
            logger.error("获取access_token失败。", e);
        }
    }

    @RequestMapping("/getWechatServerIp")
    public void getWechatServerIp() {
        try {
            String accessToken = wechatUtils.getAccessToken();
            logger.info("access_token = {}", accessToken);
            String[] ipsArr = wechatUtils.getWechatServerIp(accessToken);
            List<String> ips = Arrays.stream(ipsArr).collect(Collectors.toList());
            logger.info("wechat server ip list = {}", ips.toString());
        } catch (WxErrorException e) {
            logger.error("获取access_token失败。", e);
        }
    }

    @RequestMapping("getUserList")
    public void getUserList() {
        try {
            WxMpUserList userList = wechatUtils.getUserList();
            List<String> openIds = userList.getOpenIds();
            logger.info("关注者openId列表 = {}", openIds.toString());
        } catch (WxErrorException e) {
            logger.error("获取关注者列表失败", e);
        }
    }

    @RequestMapping("getUserInfo")
    public void getUserInfo() {
        try {
            WxMpUserList userList = wechatUtils.getUserList();
            if (userList == null || userList.getOpenIds().isEmpty()) {
                logger.warn("关注者openId列表为空");
                return;
            }
            List<String> openIds = userList.getOpenIds();
            logger.info("关注者openId列表 = {}", openIds.toString());

            String openId = openIds.get(0);
            logger.info("开始获取 {} 的基本信息", openId);
            WxMpUser userInfo = wechatUtils.getUserInfo(openId);
            if (userInfo == null) {
                logger.warn("获取 {} 的基本信息为空", openId);
                return;
            }
            String city = userInfo.getCity();
            String nickname = userInfo.getNickname();
            logger.info("{} 的昵称为：{}, 城市为：{}", openId, nickname, city);

        } catch (WxErrorException e) {
            logger.error("获取用户消息失败:", e);
        }
    }
}
