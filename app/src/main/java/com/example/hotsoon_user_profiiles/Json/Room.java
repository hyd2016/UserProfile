package com.example.hotsoon_user_profiiles.Json;




import com.google.gson.annotations.SerializedName;

/**
 * @Date 2018/9/14
 * @Author xuyue
 * @Description 直播房间信息
 */
public class Room {

    public static final long USER_FROM_PUSH = 4;
    public static final long USER_FROM_WEB = 5;

    @SerializedName("id")
    private long id;

    @SerializedName("id_str")
    private String idStr;

    @SerializedName("user_count")
    private long userCount;

    @SerializedName("stream_id")
    private long streamId;

    @SerializedName("enable_room_perspective")
    private boolean enableRoomPerspective;

    @SerializedName("new_cell_style")
    private int newCellStyle;

    @SerializedName("status")
    private int status;

    @SerializedName("cover")
    private ImageModel cover;

    @SerializedName("owner")
    private User owner;

    @SerializedName("stream_url")
    public String streamUrl;

    @SerializedName("os_type")
    public int platform;

    @SerializedName("client_version")
    public String clientVersion;

    @SerializedName("title")
    private String title;

    @SerializedName("hide_nickname")
    private boolean hideNickName;

    @SerializedName("hide_status_tag")
    private boolean hideStatusTag;

    @SerializedName("hide_title")
    private boolean hideTitle;

    @SerializedName("hide_user_count")
    private boolean hideUserCount;

    @SerializedName("create_time")
    private long createTime;

    @Deprecated
    @SerializedName("live_type_audio")
    private boolean liveTypeAudio = false;

    @Deprecated

    @SerializedName("live_type_screenshot")
    public boolean isScreenshot;

    @Deprecated
    @SerializedName("live_type_third_party")
    public boolean isThirdParty;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public long getUserCount() {
        return userCount;
    }

    public void setUserCount(long userCount) {
        this.userCount = userCount;
    }

    public long getStreamId() {
        return streamId;
    }

    public void setStreamId(long streamId) {
        this.streamId = streamId;
    }

    public boolean isEnableRoomPerspective() {
        return enableRoomPerspective;
    }

    public void setEnableRoomPerspective(boolean enableRoomPerspective) {
        this.enableRoomPerspective = enableRoomPerspective;
    }

    public boolean isLiveTypeAudio() {
        return liveTypeAudio;
    }

    public void setLiveTypeAudio(boolean liveTypeAudio) {
        this.liveTypeAudio = liveTypeAudio;
    }

    public int getNewCellStyle() {
        return newCellStyle;
    }

    public void setNewCellStyle(int newCellStyle) {
        this.newCellStyle = newCellStyle;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ImageModel getCover() {
        return cover;
    }

    public void setCover(ImageModel cover) {
        this.cover = cover;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHideNickName() {
        return hideNickName;
    }

    public void setHideNickName(boolean hideNickName) {
        this.hideNickName = hideNickName;
    }

    public boolean isHideStatusTag() {
        return hideStatusTag;
    }

    public void setHideStatusTag(boolean hideStatusTag) {
        this.hideStatusTag = hideStatusTag;
    }

    public boolean isHideTitle() {
        return hideTitle;
    }

    public void setHideTitle(boolean hideTitle) {
        this.hideTitle = hideTitle;
    }

    public boolean isHideUserCount() {
        return hideUserCount;
    }

    public void setHideUserCount(boolean hideUserCount) {
        this.hideUserCount = hideUserCount;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }



}

