package com.tsmyk.wechatproject.wechat.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.StringJoiner;

/**
 * 响应消息体
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseMsgBody {
    /**接收方帐号（收到的OpenID）*/
    private String ToUserName;
    /** 开发者微信号 */
    private String FromUserName;
    /** 消息创建时间 */
    private long CreateTime;
    /** 消息类型*/
    private String MsgType;
    /** 文本消息的消息体 */
    private String Content;

    /** 标题 */
    private String Title;
    /** 描述 */
    private String Description;
    /** 音乐链接 */
    private String MusicURL;
    /** 高质量音乐链接 */
    private String HQMusicUrl;
    /** 缩略图的媒体id */
    private String ThumbMediaId;
    /** 图片消息的图片链接（由系统生成） */
    private String PicUrl;
    /** url */
    private String Url;
    /** 图文消息个数 */
    private String ArticleCount;
    /** 图文消息信息 */
    private String Articles;

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

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
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

    public String getMusicURL() {
        return MusicURL;
    }

    public void setMusicURL(String musicURL) {
        MusicURL = musicURL;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(String articleCount) {
        ArticleCount = articleCount;
    }

    public String getArticles() {
        return Articles;
    }

    public void setArticles(String articles) {
        Articles = articles;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResponseMsgBody.class.getSimpleName() + "[", "]")
                .add("ToUserName='" + ToUserName + "'")
                .add("FromUserName='" + FromUserName + "'")
                .add("CreateTime=" + CreateTime)
                .add("MsgType='" + MsgType + "'")
                .add("Content='" + Content + "'")
                .add("Title='" + Title + "'")
                .add("Description='" + Description + "'")
                .add("MusicURL='" + MusicURL + "'")
                .add("HQMusicUrl='" + HQMusicUrl + "'")
                .add("ThumbMediaId='" + ThumbMediaId + "'")
                .add("PicUrl='" + PicUrl + "'")
                .add("Url='" + Url + "'")
                .add("ArticleCount='" + ArticleCount + "'")
                .add("Articles='" + Articles + "'")
                .toString();
    }
}
