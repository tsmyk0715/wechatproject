package com.tsmyk.wechatproject.wechat.pojo;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 语音消息响应实体类
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseVoiceMsg extends ResponseMsgBody{
    /** 图片媒体ID */
    @XmlElementWrapper(name = "Voice")
    private String[] MediaId;
    public String[] getMediaId() {
        return MediaId;
    }
    public void setMediaId(String[] mediaId) {MediaId = mediaId; }
}
