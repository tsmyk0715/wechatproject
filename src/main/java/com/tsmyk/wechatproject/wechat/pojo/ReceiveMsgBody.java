package com.tsmyk.wechatproject.wechat.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.StringJoiner;

/**
 * 接收消息实体
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiveMsgBody {
    /**开发者微信号*/
    private String ToUserName;
    /** 发送消息用户的openId */
    private String FromUserName;
    /** 消息创建时间 */
    private long CreateTime;
    /**消息类型*/
    private String MsgType;
    /** 消息ID，根据该字段来判重处理 */
    private long MsgId;
    /** 文本消息的消息体 */
    private String Content;

    /** 媒体ID */
    private String MediaId;
    /** 图片消息的图片链接（由系统生成） */
    private String PicUrl;
    /** 语音消息的语音格式 */
    private String Format;
    /** 语音消息的语音识别结果 */
    private String Recognition;
    /** 视频消息的缩略图的媒体id */
    private String ThumbMediaId;
    /** 位置消息的纬度 */
    private String Location_X;
    /** 位置消息的经度 */
    private String Location_Y;
    /** 地图缩放大小 */
    private String Scale;
    /** 地理位置信息 */
    private String Label;
    /** 链接消息的标题 */
    private String Title;
    /** 链接消息的描述 */
    private String Description;
    /** 链接消息的url */
    private String Url;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReceiveMsgBody.class.getSimpleName() + "[", "]")
                .add("ToUserName='" + ToUserName + "'")
                .add("FromUserName='" + FromUserName + "'")
                .add("CreateTime=" + CreateTime)
                .add("MsgType='" + MsgType + "'")
                .add("MsgId=" + MsgId)
                .add("MediaId='" + MediaId + "'")
                .add("Content='" + Content + "'")
                .add("PicUrl='" + PicUrl + "'")
                .add("Format='" + Format + "'")
                .add("Recognition='" + Recognition + "'")
                .add("ThumbMediaId='" + ThumbMediaId + "'")
                .add("Location_X='" + Location_X + "'")
                .add("Location_Y='" + Location_Y + "'")
                .add("Scale='" + Scale + "'")
                .add("Label='" + Label + "'")
                .add("Title='" + Title + "'")
                .add("Description='" + Description + "'")
                .add("Url='" + Url + "'")
                .toString();
    }
}
