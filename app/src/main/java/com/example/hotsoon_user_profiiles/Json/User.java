package com.example.hotsoon_user_profiiles.Json;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


/**
 * Created by dreamtale on 16/2/18.
 */

public class User {

    private static final int HASH_31 = 31;
    private static final int HASH_32 = 32;


    @SerializedName("nickname")
    private String nickName = "";

    @SerializedName("gender")
    private int gender;

    @SerializedName("signature")
    private String signature;

    @SerializedName("level")
    private int level;

    @SerializedName("id")
    private long id;

    @SerializedName("encrypted_id")
    private String encryptedId = "";

    @SerializedName("account_type")
    private int accountType = 0;


    @SerializedName("create_time")
    private long createTime;

    @SerializedName("constellation")
    private String constellation;


    @SerializedName("birthday_description")
    private String ageLevelDescription;


    @SerializedName("city")
    private String city;


    @SerializedName("birthday")
    private long birthday;

    @SerializedName("birthday_valid")
    private boolean birthdayValid;

    @SerializedName("avatar_thumb")
    private ImageModel avatarThumb;

    @SerializedName("avatar_medium")
    private ImageModel avatarMedium;

    @SerializedName("avatar_large")
    private ImageModel avatarLarge;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("market_border_detail")
    private ImageModel marketBorderDetail;

    @SerializedName("market_border_profile")
    private ImageModel marketBorderProfile;


    @SerializedName("rocket_info")
    private RocketInfo rocketInfo;

    @SerializedName("follow_status")
    private int followStatus;

    @SerializedName("is_follower")
    private boolean isFollower;

    @SerializedName("stats")
    private UserStats stats;

    @SerializedName("top_fans")
    private List<User> topFans;

    @SerializedName("top_fans_weekly")
    private List<User> topFansWeekly;

    @SerializedName("allow_status")
    private int allowStatus;

    @SerializedName("allow_video_status")
    private int allowVideoStatus;

    @SerializedName("id_str")
    private String idStr;

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }


    @SerializedName("is_new_user")
    private boolean isNewUser;


    @SerializedName("third_name")
    private String thirdName;


    @SerializedName("short_id")
    private long shortId;


    @SerializedName("fan_ticket_count")
    private long fanTicketCount;


    @SerializedName("verify_status")
    private int verifyStatus;

    //目前为新浪微博认证
    @SerializedName("verified")
    private boolean isVerified;


    @SerializedName("is_author")
    private boolean isAuthor;


    @SerializedName("verified_reason")
    private String verifiedReason;

    //目前为火山达人认证
    @SerializedName("hotsoon_verified")
    private boolean isHotSoonVerified;

    //职业认证
    @SerializedName("profession_name")
    private String professionName;

    @SerializedName("hotsoon_verified_reason")
    private String hotSoonVerifiedReason;


    @SerializedName("profile_guide_prompts")
    private String profileGuidePrompts;

    /**
     * 关注主播的开播提醒开关
     */
    @SerializedName("push_status")
    private boolean enableLivePush;

    /**
     * 评论的提醒开关
     */

    @SerializedName("push_comment_status")
    private boolean enableCommentPush;

    /**
     * 相对当前用户的开播提醒开关
     */

    @SerializedName("push_relative_status")
    private boolean enableRelativeLivePush;


    @SerializedName("push_digg")
    private boolean enableDiggPush;


    @SerializedName("push_follow")
    private boolean enableFollowPush;

    @SerializedName("push_friend_action")
    private boolean enableFriendActionPush;


    @SerializedName("push_video_recommend")
    private boolean enableVideoRecommendPush;


    @SerializedName("push_video_post")
    private boolean enableVideoRecommendFollowPush;


    @SerializedName("top_vip_no")
    private int topVipNo;


    @SerializedName("ugc_verify")
    private String ugcVerify;


    @SerializedName("share_url")
    private String shareUrl;


    @SerializedName("share_title")
    private String shareTitle;


    @SerializedName("pay_grade")
    private UserHonor userHonor;


    @SerializedName("anchor_level")
    private AnchorLevel anchorLevel;

    // 荣誉说明url
    @SerializedName("pay_grade_detail_url")
    private String payGradeExplanationUrl;

    public void setPayGradeExplanationUrl(String payGradeExplanationUrl) {
        this.payGradeExplanationUrl = payGradeExplanationUrl;
    }


    public String getPayGradeExplanationUrl() {
        return payGradeExplanationUrl;
    }


    @SerializedName("share_desc")
    private String shareDesc;


    @SerializedName("allow_others_download_video")
    private boolean allowDownloadVideo;


    @SerializedName("allow_others_download_when_sharing_video")
    private boolean allowOthersDownloadWhenSharingVideo;


    @SerializedName("allow_find_by_contacts")
    private boolean allowFindByContacts;


    @SerializedName("allow_show_in_gossip")
    private boolean allowShowInGossip;

    @SerializedName("allow_show_my_action")
    private boolean allowShowMyAction;

    @SerializedName("allow_be_located")
    private boolean allowShowLocation;


    @SerializedName("hide_visit_profile_history")
    private boolean hideVisitProfileHistory; // 隐藏访问他人主页记录


    @SerializedName("fold_stranger_chat")
    private boolean foldStrangerChat;


    @SerializedName("enable_ichat_img")
    private int enableChatImage;


    @SerializedName("push_ichat")
    private boolean receiveChatPush;

    @SerializedName("disable_ichat")
    private int disableIchat;

    @SerializedName("block_status")
    private int blockStatus;

    @SerializedName("allow_strange_comment")
    private boolean allowStrangeComment; //允许非作者的关注评论

    @SerializedName("allow_unfollower_comment")
    private boolean allowUnFollowerComment; //允许非作者的粉丝评论

    //评论权限:0:无限制; 1:仅作者关注的人可以评论 3:仅作者的粉丝可以评论 4:仅和作者互关的人可以评论
    @SerializedName("comment_restrict")
    private int commentRestrict;


    @SerializedName("follow_info")
    private UserFollowInfo userFollowInfo;


    @SerializedName("common_friends")
    private CommonFriends commonFriends; //和我一起关注该用户的昵称列表


    //服务器返回数据时的时间
    @SerializedName("now_time")
    public volatile long nowTime;
    //本地获取到数据时的时间
    @SerializedName("start_time")
    public volatile long startTime;

    @SerializedName("allow_sync_to_other_platform")
    private boolean allowSyncToOtherPlatform; //允许同步内容至其他平台

    private boolean isRefuseSyncPlatformDialog; //弹出同步内容至其他平台的弹窗后，是否点击了拒绝

    @SerializedName("real_time_icons")
    private List<ImageModel> userBadges;


    @SerializedName("new_real_time_icons")
    private List<ImageModel> newUserBadges;


    @SerializedName("grade_icon")
    private ImageModel gradeIcon;


    @SerializedName("grade_level")
    private int gradeLevel;


    @SerializedName("pay_scores")
    private long payScores;


    public long getPayScores() {
        return payScores;
    }

    public void setPayScores(long payScores) {
        this.payScores = payScores;
    }

    @SerializedName("enable_wallet_bubble")
    private boolean showWalletInviteTips;


    @SerializedName("need_profile_guide")
    private boolean needProfileGuide;


    @SerializedName("live_room_id")
    private long liveRoomId;


    @SerializedName("room_title")
    private String roomTitle;


    @SerializedName("social_relation")
    private UserSocialRelation userSocialRelation;

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    // 粉丝团
    @SerializedName("fansclub")
    private String fansClub;



    @SerializedName("living_room_stats")
    private RoomStats roomStats;

    @SerializedName("comment_recommend_commander")
    private String mCommentFlameCommander;


    @SerializedName("living_room_attrs")
    private String roomAttrs;

    public RoomStats getRoomStats() {
        return roomStats;
    }

    public String getRoomAttrs() {
        return roomAttrs;
    }

    public void setRoomStats(RoomStats roomStats) {
        this.roomStats = roomStats;
    }

    @SerializedName("allow_use_linkmic")
    private boolean allowUseLinkMic;


    @SerializedName("linkmic_share_percent")
    private int linkMicPercent;


    @SerializedName("link_mic_stats")
    private int linkMicStats;

    @SerializedName("realname_verify_status")
    private int realNameVerifyStatus; //云账户实名认证 0: 未认证 1:已认证


    @SerializedName("toutiao_info")
    private String toutiaoInfo;

    public String getToutiaoInfo() {
        return toutiaoInfo;
    }

    public void setToutiaoInfo(String toutiaoInfo) {
        this.toutiaoInfo = toutiaoInfo;
    }


    @SerializedName("luckymoney_num")
    private int luckMoneyNum;


    @SerializedName("luckymoney_num")
    public int getLuckMoneyNum() {
        return luckMoneyNum;
    }


    @SerializedName("luckymoney_num")
    public void setLuckMoneyNum(int luckMoneyNum) {
        this.luckMoneyNum = luckMoneyNum;
    }


    @SerializedName("cluster_follower_count")
    private int clusterFollowerCount = -1;


    @SerializedName("toutaio_bind_info")
    private String toutiaoBindInfo; //允许同步内容至其他平台


    @SerializedName("aweme_bind_info")
    private String awemeBindInfo; //允许同步内容至其他平台


    @SerializedName("total_fans_count")
    private long totalFansCount = 0;

    public long getTotalFansCount() {
        return totalFansCount;
    }

    public void setTotalFansCount(int totalFansCount) {
        this.totalFansCount = totalFansCount;
    }


    public int getHasPrivateItem() {
        return 0;
    }

    public int getClusterFollowerCount() {
        return clusterFollowerCount;
    }


    public void setClusterFollowerCount(int clusterFollowerCount) {
        this.clusterFollowerCount = clusterFollowerCount;
    }



    public long getNowTime() {
        return nowTime;
    }


    public long getStartTime() {
        return startTime;
    }


    @SerializedName("sync_to_other_platform_refresh_count")
    private int syncToOtherPlatformRefreshCount = -1;

    //私信限制开关

    @SerializedName("ichat_restrict_type")
    private int chatRestriction;

    //火苗排行榜

    @SerializedName("flame_rank_info")
    private String flameRankInfo;


    // 火苗flash 贡献排行榜

    @SerializedName("flash_contribute_rank_info")
    private String flashContributeRankStruct;

    // 用户使用的语言

    @SerializedName("language")
    private String language;


    @SerializedName("social_medias")
    private List<String> socialMediaList;


    @SerializedName("is_media_enabled")
    private boolean isEnableEditSocialMedia; // 是否可以编辑社交媒体信息

    // 盛典用户边框

    @SerializedName("border")
    private String border;

    //靓号

    @SerializedName("special_id")
    private String specialId;

    //靓号头像边框

    @SerializedName("avatar_border")
    private ImageModel avatarBorder;

    // 靓号勋章

    @SerializedName("medal")
    private ImageModel medal;


    @SerializedName("has_circle_item")
    private boolean hasMomentItem; //是否有圈子投稿作品（新字段）

    @SerializedName("manager_level")
    private int circleManagerLevel; // 圈主等级(1级为实习圈主，若圈主存在但没下发该字段，默认为正式圈主)


    @SerializedName("description_at_users")
    //个人简介at的人
    private List<String> atUsers;

    //vigo flash info

    @SerializedName("flash_info")
    private String flashInfo;



    @SerializedName("flash_cell_info")
    private String flashCellInfo;


    @SerializedName("flame_info")
    private FlameInfo flameInfo;


    @SerializedName("allow_show_ads")
    private boolean allowShowAds; // 他人页draw流广告是否开启开关


    @SerializedName("author_flame_rank")
    private String flameDecoration;


    public String getFlameDecoration() {
        return flameDecoration;
    }



    public boolean isAllowShowAds() {
        return allowShowAds;
    }

    public void setAllowShowAds(boolean allowShowAds) {
        this.allowShowAds = allowShowAds;
    }


    public String getSimpleRoom() {
        return simpleRoom;
    }

    public void setSimpleRoom(String simpleRoom) {
        this.simpleRoom = simpleRoom;
    }

    public FlameInfo getFlameInfo() {
        return flameInfo;
    }

    public void setFlameInfo(FlameInfo flameInfo) {
        this.flameInfo = flameInfo;
    }



    public void setFlashCellInfo(String flashCellInfo) {
        this.flashCellInfo = flashCellInfo;
    }


    public void setFlashInfo(String flashInfo) {
        this.flashInfo = flashInfo;
    }

    public boolean isHasMomentItem() {
        return hasMomentItem;
    }

    public void setHasMomentItem(boolean hasMomentItem) {
        this.hasMomentItem = hasMomentItem;
    }


    public int getCircleManagerLevel() {
        return circleManagerLevel;
    }

    public void setCircleManagerLevel(int circleManagerLevel) {
        this.circleManagerLevel = circleManagerLevel;
    }

    public List<String> getAtUsers() {
        return atUsers;
    }

    public void setAtUsers(List<String> atUsers) {
        this.atUsers = atUsers;
    }

    public String getFlameRankInfo() {
        return flameRankInfo;
    }

    public void setFlameRankInfo(String flameRankInfo) {
        this.flameRankInfo = flameRankInfo;
    }

    public boolean enableEditSocialMedia() {
        return isEnableEditSocialMedia;
    }

    //本地解析问题
    private String mAvatarThumbStr;
    private String mAvatarMediumStr;
    private String mAvatarLargeStr;
    private String mAvatarBorderStr;
    private String mMedalStr;
    private String mMarketBorderDetailStr;
    private String mMarketBorderProfileStr;
    private String userStatStr;

    public void setAvatarThumbStr(String mAvatarThumbStr) {
        this.mAvatarThumbStr = mAvatarThumbStr;
    }

    public void setAVatarMediumStr(String mAvatarMediumStr) {
        this.mAvatarMediumStr = mAvatarMediumStr;
    }

    public void setAvatarLargeStr(String mAvatarLargeStr) {
        this.mAvatarLargeStr = mAvatarLargeStr;
    }

    public void setAvatarBorderStr(String avatarBorderStr) {
        this.mAvatarBorderStr = avatarBorderStr;
    }

    public void setMedalStr(String medalStr) {
        this.mMedalStr = medalStr;
    }

    public void setMarketBorderDetailStr(String marketBorderDetailStr) {
        mMarketBorderDetailStr = marketBorderDetailStr;
    }

    public void setMarketBorderProfileStr(String marketBorderProfileStr) {
        mMarketBorderProfileStr = marketBorderProfileStr;
    }

    public void setUserStatStr(String userStats) {
        this.userStatStr = userStats;
    }

    private String mRocketInfoStr;

    public void setRocketInfoStr(String mRocketInfoStr) {
        this.mRocketInfoStr = mRocketInfoStr;
    }

    public int getSyncToOtherPlatformRefreshCount() {
        return syncToOtherPlatformRefreshCount;
    }

    public void setSyncToOtherPlatformRefreshCount(int syncToOtherPlatformRefreshCount) {
        this.syncToOtherPlatformRefreshCount = syncToOtherPlatformRefreshCount;
    }



    @SerializedName("verified_mobile")
    private boolean verifiedMobile; // 用户是否验证手机


    @SerializedName("enable_generate_useful_vote")
    private boolean enableGenerateUsefulVote;


    @SerializedName("room")
    private String simpleRoom;

    public boolean isEnableGenerateUsefulVote() {
        return enableGenerateUsefulVote;
    }

    public User setEnableGenerateUsefulVote(boolean enableGenerateUsefulVote) {
        this.enableGenerateUsefulVote = enableGenerateUsefulVote;
        return this;
    }


    public static final int REALNAME_VERIFIED = 1;
    public static final int REALNAME_UNVERIFIED = 0;

    public int getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(int verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public long getFanTicketCount() {
        return fanTicketCount;
    }

    public void setFanTicketCount(long fanTicketCount) {
        this.fanTicketCount = fanTicketCount;
    }

    public long getShortId() {
        return shortId;
    }

    public void setShortId(long shortId) {
        this.shortId = shortId;
    }

    public int getAllowStatus() {
        return allowStatus;
    }

    public void setAllowStatus(int allowStatus) {
        this.allowStatus = allowStatus;
    }

    public static final int NOT_FOLLOWING = 0;
    public static final int HAS_FOLLOWED = 1;
    public static final int FOLLOW_EACH_OTHER = 2;

    public int getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(int followStatus) {
        this.followStatus = followStatus;
    }

    public boolean isFollower() {
        return isFollower;
    }

    public void setFollower(boolean follower) {
        isFollower = follower;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public ImageModel getAvatarThumb() {
        try {
            if (avatarThumb == null && !TextUtils.isEmpty(mAvatarThumbStr)) {
                avatarThumb = new Gson().fromJson(mAvatarThumbStr, ImageModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avatarThumb;
    }

    public void setAvatarThumb(ImageModel avatarThumb) {
        this.avatarThumb = avatarThumb;
    }

    public ImageModel getAvatarMedium() {
        try {
            if (avatarMedium == null && !TextUtils.isEmpty(mAvatarMediumStr)) {
                avatarMedium = new Gson().fromJson(mAvatarMediumStr, ImageModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avatarMedium;
    }

    public void setAvatarMedium(ImageModel avatarMedium) {
        this.avatarMedium = avatarMedium;
    }

    public ImageModel getAvatarLarge() {
        try {
            if (avatarLarge == null && !TextUtils.isEmpty(mAvatarLargeStr)) {
                avatarLarge = new Gson().fromJson(mAvatarLargeStr, ImageModel.class);
                prefetchImageIfNeed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avatarLarge;
    }

    public void prefetchImageIfNeed() {
//        if (avatarLarge != null) {
//            String uri = avatarLarge.urls == null || avatarLarge.urls.isEmpty() ? "" : avatarLarge.urls.get(0);
//            Fresco.getImagePipeline().prefetchToDiskCache(
//                    ImageRequest.fromUri(uri), this);
//        }
    }

    public void setAvatarLarge(ImageModel avatarLarge) {
        this.avatarLarge = avatarLarge;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public static final int UNKNOW = 0;
    public static final int MALE = 1;
    public static final int FEMALE = 2;
    public static final int OTHER_GENDER = 3;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEncryptedId() {
        return encryptedId;
    }

    public User setEncryptedId(String encryptedId) {
        this.encryptedId = encryptedId;
        return this;
    }


    public int getAccountType() {
        return accountType;
    }

    public User setAccountType(int accountType) {
        this.accountType = accountType;
        return this;
    }


    public boolean isVisitorAccount() {
        return accountType == 1;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getAgeLevelDescription() {
        return ageLevelDescription;
    }

    public void setAgeLevelDescription(String ageLevelDescription) {
        this.ageLevelDescription = ageLevelDescription;
    }

    public UserStats getStats() {
        try {
            if (stats == null && !TextUtils.isEmpty(userStatStr)) {
                stats = new Gson().fromJson(userStatStr, UserStats.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stats;
    }

    public void setStats(UserStats stats) {
        this.stats = stats;
    }

    public List<User> getTopFans() {
        return topFans;
    }

    public void setTopFans(List<User> topFans) {
        this.topFans = topFans;
    }

    public List<User> getTopFansWeekly() {
        return topFansWeekly;
    }

    public void setTopFansWeekly(List<User> topFansWeekly) {
        this.topFansWeekly = topFansWeekly;
    }

    public boolean isBirthdayValid() {
        return birthdayValid;
    }

    public void setBirthdayValid(boolean birthdayValid) {
        this.birthdayValid = birthdayValid;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isAuthor() {
        return isAuthor;
    }

    public void setAuthor(boolean author) {
        isAuthor = author;
    }

    public String getVerifiedReason() {
        return verifiedReason;
    }

    public void setVerifiedReason(String verifiedReason) {
        this.verifiedReason = verifiedReason;
    }

    public boolean isHotSoonVerified() {
        return isHotSoonVerified;
    }

    public void setHotSoonVerified(boolean hotSoonVerified) {
        isHotSoonVerified = hotSoonVerified;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }


    public String getHotSoonVerifiedReason() {
        return hotSoonVerifiedReason;
    }

    public void setHotSoonVerifiedReason(String hotSoonVerifiedReason) {
        this.hotSoonVerifiedReason = hotSoonVerifiedReason;
    }

    public boolean isEnableLivePush() {
        return enableLivePush;
    }

    public void setEnableLivePush(boolean enableLivePush) {
        this.enableLivePush = enableLivePush;
    }

    public boolean isEnableCommentPush() {
        return enableCommentPush;
    }

    public void setEnableCommentPush(boolean enableCommentPush) {
        this.enableCommentPush = enableCommentPush;
    }

    public boolean isEnableRelativeLivePush() {
        return enableRelativeLivePush;
    }

    public void setEnableRelativeLivePush(boolean enableRelativeLivePush) {
        this.enableRelativeLivePush = enableRelativeLivePush;
    }

    public boolean isEnableDiggPush() {
        return enableDiggPush;
    }

    public void setEnableDiggPush(boolean enableDiggPush) {
        this.enableDiggPush = enableDiggPush;
    }

    public boolean isEnableFollowPush() {
        return enableFollowPush;
    }

    public void setEnableFollowPush(boolean enableFollowPush) {
        this.enableFollowPush = enableFollowPush;
    }


    public boolean isEnableFriendActionPush() {
        return enableFriendActionPush;
    }


    public void setEnableFriendActionPush(boolean enableFriendActionPush) {
        this.enableFriendActionPush = enableFriendActionPush;
    }

    public boolean isEnableVideoRecommendPush() {
        return enableVideoRecommendPush;
    }

    public void setEnableVideoRecommendPush(boolean enableVideoRecommendPush) {
        this.enableVideoRecommendPush = enableVideoRecommendPush;
    }

    public boolean isEnableVideoRecommendFollowPush() {
        return enableVideoRecommendFollowPush;
    }

    public void setEnableVideoRecommendFollowPush(boolean enableVideoRecommendFollowPush) {
        this.enableVideoRecommendFollowPush = enableVideoRecommendFollowPush;
    }

    public int getTopVipNo() {
        return topVipNo;
    }

    public void setTopVipNo(int topVipNo) {
        this.topVipNo = topVipNo;
    }

    public int getAllowVideoStatus() {
        return allowVideoStatus;
    }

    public void setAllowVideoStatus(int allowVideoStatus) {
        this.allowVideoStatus = allowVideoStatus;
    }

    public String getUgcVerify() {
        return ugcVerify;
    }

    public void setUgcVerify(String ugcVerify) {
        this.ugcVerify = ugcVerify;
    }


    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareDesc() {
        return shareDesc;
    }

    public void setShareDesc(String shareDesc) {
        this.shareDesc = shareDesc;
    }

    public boolean isAllowDownloadVideo() {
        return allowDownloadVideo;
    }

    public void setAllowDownloadVideo(boolean allowDownloadVideo) {
        this.allowDownloadVideo = allowDownloadVideo;
    }

    public boolean isAllowOthersDownloadWhenSharingVideo() {
        return allowOthersDownloadWhenSharingVideo;
    }

    public void setAllowOthersDownloadWhenSharingVideo(boolean allowOthersDownloadWhenSharingVideo) {
        this.allowOthersDownloadWhenSharingVideo = allowOthersDownloadWhenSharingVideo;
    }


    public boolean isAllowFindByContacts() {
        return allowFindByContacts;
    }

    public void setAllowFindByContacts(boolean allowFindByContacts) {
        this.allowFindByContacts = allowFindByContacts;
    }

    public boolean isNewUser() {
        return isNewUser;
    }

    public void setNewUser(boolean newUser) {
        isNewUser = newUser;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }


    public ImageModel getGradeIcon() {
        return gradeIcon;
    }

    public void setGradeIcon(ImageModel gradeIcon) {
        this.gradeIcon = gradeIcon;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public boolean isShowWalletInviteTips() {
        return showWalletInviteTips;
    }

    public void setShowWalletInviteTips(boolean showWalletInviteTips) {
        this.showWalletInviteTips = showWalletInviteTips;
    }

    public boolean isAllowSyncToOtherPlatform() {
        return allowSyncToOtherPlatform;
    }

    public void setAllowSyncToOtherPlatform(boolean allowSyncToOtherPlatform) {
        this.allowSyncToOtherPlatform = allowSyncToOtherPlatform;
    }

    public boolean isAllowShowInGossip() {
        return allowShowInGossip;
    }

    public void setAllowShowInGossip(boolean allowShowInGossip) {
        this.allowShowInGossip = allowShowInGossip;
    }

    public boolean isAllowShowMyAction() {
        return allowShowMyAction;
    }

    public void setAllowShowMyAction(boolean allowShowMyAction) {
        this.allowShowMyAction = allowShowMyAction;
    }

    public boolean isNeedProfileGuide() {
        return needProfileGuide;
    }

    public void setNeedProfileGuide(boolean needProfileGuide) {
        this.needProfileGuide = needProfileGuide;
    }

    public boolean isAllowShowLocation() {
        return allowShowLocation;
    }

    public void setAllowShowLocation(boolean allowShowLocation) {
        this.allowShowLocation = allowShowLocation;
    }

    public boolean isHideVisitProfileHistory() {
        return hideVisitProfileHistory;
    }

    public void setHideVisitProfileHistory(boolean hideVisitProfileHistory) {
        this.hideVisitProfileHistory = hideVisitProfileHistory;
    }

    public boolean isVerifiedMobile() {
        return verifiedMobile;
    }

    public void setVerifiedMobile(boolean verifiedMobile) {
        this.verifiedMobile = verifiedMobile;
    }

    public String getProfileGuidePrompts() {
        return profileGuidePrompts;
    }

    public void setProfileGuidePrompts(String profileGuidePrompts) {
        this.profileGuidePrompts = profileGuidePrompts;
    }

    public long getLiveRoomId() {
        return liveRoomId;
    }

    public void setLiveRoomId(long liveRoomId) {
        this.liveRoomId = liveRoomId;
    }

    public boolean isAllowStrangeComment() {
        return allowStrangeComment;
    }

    public void setAllowStrangeComment(boolean allowStrangeComment) {
        this.allowStrangeComment = allowStrangeComment;
    }

    public boolean isAllowUnFollowerComment() {
        return allowUnFollowerComment;
    }

    public void setAllowUnFollowerComment(boolean allowUnFollowerComment) {
        this.allowUnFollowerComment = allowUnFollowerComment;
    }


    public int getCommentRestrict() {
        return commentRestrict;
    }


    public void setCommentRestrict(int commentRestrict) {
        this.commentRestrict = commentRestrict;
    }



    public void setUserFollowInfo(UserFollowInfo userFollowInfo) {
        this.userFollowInfo = userFollowInfo;
    }

    private String userFollowInfoStr;

    public void setUserFollowInfoStr(String json) {
        userFollowInfoStr = json;
    }

    public boolean isFoldStrangerChat() {
        return true;
    }

    public void setFoldStrangerChat(boolean foldStrangerChat) {
        this.foldStrangerChat = foldStrangerChat;
    }


    public int getEnableChatImage() {
        return enableChatImage;
    }

    public void setEnableChatImage(int enableChatImage) {
        this.enableChatImage = enableChatImage;
    }

    public boolean isReceiveChatPush() {
        return receiveChatPush;
    }

    public void setReceiveChatPush(boolean receiveChatPush) {
        this.receiveChatPush = receiveChatPush;
    }

    public int getDisableIchat() {
        return disableIchat;
    }

    public void setDisableIchat(int disableIchat) {
        this.disableIchat = disableIchat;
    }

    public int getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(int blockStatus) {
        this.blockStatus = blockStatus;
    }

    public boolean isAllowUseLinkMic() {
        return allowUseLinkMic;
    }

    @SerializedName("allow_use_linkmic")
    public void setAllowUseLinkMic(boolean allowUseLinkMic) {
        this.allowUseLinkMic = allowUseLinkMic;
    }

    public int getLinkMicPercent() {
        return linkMicPercent;
    }

    @SerializedName("linkmic_share_percent")
    public void setLinkMicPercent(int linkMicPercent) {
        this.linkMicPercent = linkMicPercent;
    }


    public int getLinkMicStats() {
        return linkMicStats;
    }

    @SerializedName("link_mic_stats")
    public void setLinkMicStats(int linkMicStats) {
        this.linkMicStats = linkMicStats;
    }

    public int getRealNameVerifyStatus() {
        return realNameVerifyStatus;
    }

    public void setRealNameVerifyStatus(int realNameVerifyStatus) {
        this.realNameVerifyStatus = realNameVerifyStatus;
    }

    public boolean isRefuseSyncPlatformDialog() {
        return isRefuseSyncPlatformDialog;
    }

    public void setRefuseSyncPlatformDialog(boolean refuseSyncPlatformDialog) {
        isRefuseSyncPlatformDialog = refuseSyncPlatformDialog;
    }


    public UserSocialRelation getUserSocialRelation() {
        return userSocialRelation;
    }

    public void setUserSocialRelation(UserSocialRelation userSocialRelation) {
        this.userSocialRelation = userSocialRelation;
    }

    public CommonFriends getCommonFriends() {
        return commonFriends;
    }

    public void setCommonFriends(CommonFriends commonFriends) {
        this.commonFriends = commonFriends;
    }

    public List<ImageModel> getUserBadges() {
        return userBadges;
    }

    public List<ImageModel> getNewUserBadges() {
        if (newUserBadges != null) {
            return newUserBadges;
        } else {
            return userBadges;
        }
    }

    public void setUserBadges(List<ImageModel> userBadges) {
        this.userBadges = userBadges;
    }



    public UserHonor getUserHonor() {
        return userHonor;
    }

    public void setUserHonor(UserHonor userHonor) {
        this.userHonor = userHonor;
    }

    public void setAnchorLevel(AnchorLevel anchorLevel) {
        this.anchorLevel = anchorLevel;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (gender != user.gender) {
            return false;
        }
        if (level != user.level) {
            return false;
        }
        if (id != user.id) {
            return false;
        }
        if (!encryptedId.equals(user.encryptedId)) {
            return false;
        }
        if (accountType != user.accountType) {
            return false;
        }
        if (createTime != user.createTime) {
            return false;
        }
        if (birthday != user.birthday) {
            return false;
        }
        if (birthdayValid != user.birthdayValid) {
            return false;
        }
        if (followStatus != user.followStatus) {
            return false;
        }
        if (isFollower != user.isFollower) {
            return false;
        }
        if (allowStatus != user.allowStatus) {
            return false;
        }
        if (allowVideoStatus != user.allowVideoStatus) {
            return false;
        }
        if (isNewUser != user.isNewUser) {
            return false;
        }
        if (shortId != user.shortId) {
            return false;
        }
        if (fanTicketCount != user.fanTicketCount) {
            return false;
        }
        if (verifyStatus != user.verifyStatus) {
            return false;
        }
        if (isVerified != user.isVerified) {
            return false;
        }
        if (isAuthor != user.isAuthor) {
            return false;
        }
        if (isHotSoonVerified != user.isHotSoonVerified) {
            return false;
        }
        if (professionName != null
                ? !professionName.equals(user.professionName)
                : user.professionName != null) {
            return false;
        }
        if (enableLivePush != user.enableLivePush) {
            return false;
        }
        if (enableCommentPush != user.enableCommentPush) {
            return false;
        }
        if (enableRelativeLivePush != user.enableRelativeLivePush) {
            return false;
        }
        if (enableDiggPush != user.enableDiggPush) {
            return false;
        }
        if (enableFollowPush != user.enableFollowPush) {
            return false;
        }
        if (enableFriendActionPush != user.enableFriendActionPush) {
            return false;
        }
        if (enableVideoRecommendPush != user.enableVideoRecommendPush) {
            return false;
        }
        if (enableVideoRecommendFollowPush != user.enableVideoRecommendFollowPush) {
            return false;
        }
        if (topVipNo != user.topVipNo) {
            return false;
        }
        if (allowDownloadVideo != user.allowDownloadVideo) {
            return false;
        }
        if (allowOthersDownloadWhenSharingVideo != user.allowOthersDownloadWhenSharingVideo) {
            return false;
        }
        if (allowFindByContacts != user.allowFindByContacts) {
            return false;
        }
        if (allowShowInGossip != user.allowShowInGossip) {
            return false;
        }
        if (allowShowMyAction != user.isAllowShowMyAction()) {
            return false;
        }
        if (allowShowLocation != user.allowShowLocation) {
            return false;
        }
        if (hideVisitProfileHistory != user.hideVisitProfileHistory) {
            return false;
        }
        if (foldStrangerChat != user.foldStrangerChat) {
            return false;
        }
        if (allowShowAds != user.allowShowAds) {
            return false;
        }
        if (enableChatImage != user.enableChatImage) {
            return false;
        }
        if (receiveChatPush != user.receiveChatPush) {
            return false;
        }
        if (disableIchat != user.disableIchat) {
            return false;
        }
        if (blockStatus != user.blockStatus) {
            return false;
        }
        if (allowStrangeComment != user.allowStrangeComment) {
            return false;
        }
        if (allowUnFollowerComment != user.allowUnFollowerComment) {
            return false;
        }
        if (commentRestrict != user.commentRestrict) {
            return false;
        }
        if (userFollowInfo != null ? !userFollowInfo.equals(user.userFollowInfo) : user.userFollowInfo != null) {
            return false;
        }
        if (allowSyncToOtherPlatform != user.allowSyncToOtherPlatform) {
            return false;
        }
        if (isRefuseSyncPlatformDialog != user.isRefuseSyncPlatformDialog) {
            return false;
        }
        if (hasMomentItem != user.isHasMomentItem()) {
            return false;
        }
        if (circleManagerLevel != user.circleManagerLevel) {
            return false;
        }
        if (gradeLevel != user.gradeLevel) {
            return false;
        }
        if (showWalletInviteTips != user.showWalletInviteTips) {
            return false;
        }
        if (needProfileGuide != user.needProfileGuide) {
            return false;
        }
        if (liveRoomId != user.liveRoomId) {
            return false;
        }
        if (allowUseLinkMic != user.allowUseLinkMic) {
            return false;
        }
        if (linkMicPercent != user.linkMicPercent) {
            return false;
        }
        if (linkMicStats != user.linkMicStats) {
            return false;
        }
        if (realNameVerifyStatus != user.realNameVerifyStatus) {
            return false;
        }
        if (syncToOtherPlatformRefreshCount != user.syncToOtherPlatformRefreshCount) {
            return false;
        }
        if (verifiedMobile != user.verifiedMobile) {
            return false;
        }
        if (nickName != null ? !nickName.equals(user.nickName) : user.nickName != null) {
            return false;
        }
        if (signature != null ? !signature.equals(user.signature) : user.signature != null) {
            return false;
        }
        if (constellation != null ? !constellation.equals(user.constellation) : user.constellation != null) {
            return false;
        }
        if (ageLevelDescription != null
                ? !ageLevelDescription.equals(user.ageLevelDescription)
                : user.ageLevelDescription != null) {
            return false;
        }
        if (city != null ? !city.equals(user.city) : user.city != null) {
            return false;
        }
        if (avatarThumb != null ? !avatarThumb.equals(user.avatarThumb) : user.avatarThumb != null) {
            return false;
        }
        if (avatarMedium != null ? !avatarMedium.equals(user.avatarMedium) : user.avatarMedium != null) {
            return false;
        }
        if (avatarLarge != null ? !avatarLarge.equals(user.avatarLarge) : user.avatarLarge != null) {
            return false;
        }
        if (avatarUrl != null ? !avatarUrl.equals(user.avatarUrl) : user.avatarUrl != null) {
            return false;
        }
        if (stats != null ? !stats.equals(user.stats) : user.stats != null) {
            return false;
        }
        if (topFans != null ? !topFans.equals(user.topFans) : user.topFans != null) {
            return false;
        }
        if (atUsers != null ? !atUsers.equals(user.atUsers) : user.atUsers != null) {
            return false;
        }
        if (idStr != null ? !idStr.equals(user.idStr) : user.idStr != null) {
            return false;
        }
        if (thirdName != null ? !thirdName.equals(user.thirdName) : user.thirdName != null) {
            return false;
        }
        if (verifiedReason != null ? !verifiedReason.equals(user.verifiedReason) : user.verifiedReason != null) {
            return false;
        }
        if (hotSoonVerifiedReason != null
                ? !hotSoonVerifiedReason.equals(user.hotSoonVerifiedReason)
                : user.hotSoonVerifiedReason != null) {
            return false;
        }
        if (profileGuidePrompts != null
                ? !profileGuidePrompts.equals(user.profileGuidePrompts)
                : user.profileGuidePrompts != null) {
            return false;
        }
        if (ugcVerify != null ? !ugcVerify.equals(user.ugcVerify) : user.ugcVerify != null) {
            return false;
        }
        if (shareUrl != null ? !shareUrl.equals(user.shareUrl) : user.shareUrl != null) {
            return false;
        }
        if (shareTitle != null ? !shareTitle.equals(user.shareTitle) : user.shareTitle != null) {
            return false;
        }
        if (shareDesc != null ? !shareDesc.equals(user.shareDesc) : user.shareDesc != null) {
            return false;
        }
        if (commonFriends != null ? !commonFriends.equals(user.commonFriends) : user.commonFriends != null) {
            return false;
        }
        if (userBadges != null ? !userBadges.equals(user.userBadges) : user.userBadges != null) {
            return false;
        }
        if (newUserBadges != null ? !newUserBadges.equals(user.newUserBadges) : user.newUserBadges != null) {
            return false;
        }
        if (gradeIcon != null ? !gradeIcon.equals(user.gradeIcon) : user.gradeIcon != null) {
            return false;
        }
        if (marketBorderDetail != null ? !marketBorderDetail.equals(user.marketBorderDetail)
                : user.marketBorderDetail != null) {
            return false;
        }
        if (marketBorderProfile != null ? !marketBorderProfile.equals(user.marketBorderProfile)
                : user.marketBorderProfile != null) {
            return false;
        }
        if (rocketInfo != null ? !rocketInfo.equals(user.rocketInfo) : user.rocketInfo != null) {
            return false;
        }
        if (userHonor != null ? !userHonor.equals(user.userHonor) : user.userHonor != null) {
            return false;
        }
        if (anchorLevel != null ? !anchorLevel.equals(user.anchorLevel) : user.anchorLevel != null) {
            return false;
        }


        if (mCommentFlameCommander != null ? !mCommentFlameCommander.equals(user.mCommentFlameCommander) : user.mCommentFlameCommander != null) {
            return false;
        }

        // 机构号、企业号相关
        if (headerImage != null ? !headerImage.equals(user.headerImage) : user.headerImage != null) {
            return false;
        }

        if (needRemind != user.needRemind) {
            return false;
        }

        if (totalFansCount != user.totalFansCount) {
            return false;
        }
        if (enableGenerateUsefulVote != user.enableGenerateUsefulVote) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = nickName != null ? nickName.hashCode() : 0;
        result = HASH_31 * result + gender;
        result = HASH_31 * result + (signature != null ? signature.hashCode() : 0);
        result = HASH_31 * result + level;
        result = HASH_31 * result + (int) (id ^ (id >>> HASH_32));
        result = HASH_31 * result + (TextUtils.isEmpty(encryptedId) ? 0 : encryptedId.hashCode());
        result = HASH_31 * result + accountType;
        result = HASH_31 * result + (int) (createTime ^ (createTime >>> HASH_32));
        result = HASH_31 * result + (constellation != null ? constellation.hashCode() : 0);
        result = HASH_31 * result + (ageLevelDescription != null ? ageLevelDescription.hashCode() : 0);
        result = HASH_31 * result + (city != null ? city.hashCode() : 0);
        result = HASH_31 * result + (int) (birthday ^ (birthday >>> HASH_32));
        result = HASH_31 * result + (birthdayValid ? 1 : 0);
        result = HASH_31 * result + (avatarThumb != null ? avatarThumb.hashCode() : 0);
        result = HASH_31 * result + (avatarMedium != null ? avatarMedium.hashCode() : 0);
        result = HASH_31 * result + (avatarLarge != null ? avatarLarge.hashCode() : 0);
        result = HASH_31 * result + (avatarUrl != null ? avatarUrl.hashCode() : 0);
        result = HASH_31 * result + followStatus;
        result = HASH_31 * result + (isFollower ? 1 : 0);
        result = HASH_31 * result + (stats != null ? stats.hashCode() : 0);
        result = HASH_31 * result + (topFans != null ? topFans.hashCode() : 0);
        result = HASH_31 * result + (atUsers != null ? atUsers.hashCode() : 0);
        result = HASH_31 * result + allowStatus;
        result = HASH_31 * result + allowVideoStatus;
        result = HASH_31 * result + (idStr != null ? idStr.hashCode() : 0);
        result = HASH_31 * result + (isNewUser ? 1 : 0);
        result = HASH_31 * result + (thirdName != null ? thirdName.hashCode() : 0);
        result = HASH_31 * result + (int) (shortId ^ (shortId >>> HASH_32));
        result = HASH_31 * result + (int) (fanTicketCount ^ (fanTicketCount >>> HASH_32));
        result = HASH_31 * result + verifyStatus;
        result = HASH_31 * result + (isVerified ? 1 : 0);
        result = HASH_31 * result + (isAuthor ? 1 : 0);
        result = HASH_31 * result + (verifiedReason != null ? verifiedReason.hashCode() : 0);
        result = HASH_31 * result + (isHotSoonVerified ? 1 : 0);
        result = HASH_31 * result + (professionName != null ? professionName.hashCode() : 0);
        result = HASH_31 * result + (hotSoonVerifiedReason != null ? hotSoonVerifiedReason.hashCode() : 0);
        result = HASH_31 * result + (profileGuidePrompts != null ? profileGuidePrompts.hashCode() : 0);
        result = HASH_31 * result + (enableLivePush ? 1 : 0);
        result = HASH_31 * result + (enableCommentPush ? 1 : 0);
        result = HASH_31 * result + (enableRelativeLivePush ? 1 : 0);
        result = HASH_31 * result + (enableDiggPush ? 1 : 0);
        result = HASH_31 * result + (enableFollowPush ? 1 : 0);
        result = HASH_31 * result + (enableFriendActionPush ? 1 : 0);
        result = HASH_31 * result + (enableVideoRecommendPush ? 1 : 0);
        result = HASH_31 * result + (enableVideoRecommendFollowPush ? 1 : 0);
        result = HASH_31 * result + topVipNo;
        result = HASH_31 * result + (ugcVerify != null ? ugcVerify.hashCode() : 0);
        result = HASH_31 * result + (shareUrl != null ? shareUrl.hashCode() : 0);
        result = HASH_31 * result + (shareTitle != null ? shareTitle.hashCode() : 0);
        result = HASH_31 * result + (shareDesc != null ? shareDesc.hashCode() : 0);
        result = HASH_31 * result + (allowDownloadVideo ? 1 : 0);
        result = HASH_31 * result + (allowOthersDownloadWhenSharingVideo ? 1 : 0);
        result = HASH_31 * result + (allowFindByContacts ? 1 : 0);
        result = HASH_31 * result + (allowShowInGossip ? 1 : 0);
        result = HASH_31 * result + (allowShowMyAction ? 1 : 0);
        result = HASH_31 * result + (allowShowLocation ? 1 : 0);
        result = HASH_31 * result + (hideVisitProfileHistory ? 1 : 0);
        result = HASH_31 * result + (foldStrangerChat ? 1 : 0);
        result = HASH_31 * result + (allowShowAds ? 1 : 0);
        result = HASH_31 * result + enableChatImage;
        result = HASH_31 * result + (receiveChatPush ? 1 : 0);
        result = HASH_31 * result + disableIchat;
        result = HASH_31 * result + blockStatus;
        result = HASH_31 * result + (allowStrangeComment ? 1 : 0);
        result = HASH_31 * result + (allowUnFollowerComment ? 1 : 0);
        result = HASH_31 * result + commentRestrict;
        result = HASH_31 * result + (commonFriends != null ? commonFriends.hashCode() : 0);
        result = HASH_31 * result + (allowSyncToOtherPlatform ? 1 : 0);
        result = HASH_31 * result + (isRefuseSyncPlatformDialog ? 1 : 0);
        result = HASH_31 * result + (hasMomentItem ? 1 : 0);
        result = HASH_31 * result + circleManagerLevel;
        result = HASH_31 * result + (userBadges != null ? userBadges.hashCode() : 0);
        result = HASH_31 * result + (newUserBadges != null ? newUserBadges.hashCode() : 0);
        result = HASH_31 * result + (gradeIcon != null ? gradeIcon.hashCode() : 0);
        result = HASH_31 * result + (marketBorderDetail != null ? marketBorderDetail.hashCode() : 0);
        result = HASH_31 * result + (marketBorderProfile != null ? marketBorderProfile.hashCode() : 0);
        result = HASH_31 * result + (rocketInfo != null ? rocketInfo.hashCode() : 0);
        result = HASH_31 * result + gradeLevel;
        result = HASH_31 * result + (showWalletInviteTips ? 1 : 0);
        result = HASH_31 * result + (needProfileGuide ? 1 : 0);
        result = HASH_31 * result + (int) (liveRoomId ^ (liveRoomId >>> HASH_32));
        result = HASH_31 * result + (allowUseLinkMic ? 1 : 0);
        result = HASH_31 * result + linkMicPercent;
        result = HASH_31 * result + linkMicStats;
        result = HASH_31 * result + realNameVerifyStatus;
        result = HASH_31 * result + syncToOtherPlatformRefreshCount;
        result = HASH_31 * result + (verifiedMobile ? 1 : 0);
        result = HASH_31 * result + (userHonor != null ? userHonor.hashCode() : 0);
        result = HASH_31 * result + (anchorLevel != null ? anchorLevel.hashCode() : 0);
        result = HASH_31 * result + (!TextUtils.isEmpty(requestId) ? requestId.hashCode() : 0);
        result = HASH_31 * result + (!TextUtils.isEmpty(logPb) ? logPb.hashCode() : 0);
        result = HASH_31 * result + (mCommentFlameCommander != null ? mCommentFlameCommander.hashCode() : 0);

        // 机构号、企业号相关
        result = HASH_31 * result + (headerImage != null ? headerImage.hashCode() : 0);


        result = HASH_31 * result + (needRemind ? 1 : 0);
        result = HASH_31 * result + (enableGenerateUsefulVote ? 1 : 0);

        return result;
    }

    private String toutiaoBindInfoStr;

    public void setToutiaoBindInfoStr(String json) {
        this.toutiaoBindInfoStr = json;
    }




    private String awemeBindInfoStr;

    public void setAwemeBindInfoStr(String json) {
        this.awemeBindInfoStr = json;
    }



    private String requestId;


    public String getRequestId() {
        return requestId;
    }


    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    private String logPb;


    public String getLogPb() {
        return logPb;
    }


    public void setLogPb(String logPb) {
        this.logPb = logPb;
    }



    public static final int PROFILE_STATUS_NORMAL = 0;
    public static final int PROFILE_STATUS_VERIFYING = 1;
    public static final int PROFILE_STATUS_FORBID_EDIT = 2;

    @SerializedName("user_profile_status")
    private int userProfileStatus;

    public int getUserProfileStatus() {
        return userProfileStatus;
    }

    public void setUserProfileStatus(int userProfileStatus) {
        this.userProfileStatus = userProfileStatus;
    }

    public RocketInfo getRocketInfo() {
        try {
            if (rocketInfo == null && !TextUtils.isEmpty(mRocketInfoStr)) {
                rocketInfo = new Gson().fromJson(mRocketInfoStr, RocketInfo.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rocketInfo;
    }

    public void setRocketInfo(RocketInfo rocketInfo) {
        this.rocketInfo = rocketInfo;
    }




    @SerializedName("minor_control")
    private String minorControlInfo;

    private String childrenManagerInfoStr;

    public void setChildrenManagerInfoStr(String json) {
        childrenManagerInfoStr = json;
    }


    @SerializedName("allow_share_show_profile")
    private boolean shareWithAvatar = true;


    public boolean isAllowShareWithAvatar() {
        return shareWithAvatar;
    }


    public void setShareWithAvatar(boolean shareWithAvatar) {
        this.shareWithAvatar = shareWithAvatar;
    }


    @SerializedName("ts_disable_comment_until")
    private int tsDisableCommentUntil;

    public int getTsDisableCommentUntil() {
        return tsDisableCommentUntil;
    }

    public void setTsDisableCommentUntil(int tsDisableCommentUntil) {
        this.tsDisableCommentUntil = tsDisableCommentUntil;
    }

    @SerializedName("room_auto_gift_thanks")
    private boolean roomAutoGiftThanks;


    public ImageModel getMarketBorderDetail() {
        try {
            if (marketBorderDetail == null && !TextUtils.isEmpty(mMarketBorderDetailStr)) {
                marketBorderDetail = new Gson().fromJson(mMarketBorderDetailStr, ImageModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marketBorderDetail;
    }

    public void setMarketBorderDetail(ImageModel marketBorderDetail) {
        this.marketBorderDetail = marketBorderDetail;
    }

    public ImageModel getMarketBorderProfile() {
        try {
            if (marketBorderProfile == null && !TextUtils.isEmpty(mMarketBorderProfileStr)) {
                marketBorderProfile = new Gson().fromJson(mMarketBorderProfileStr, ImageModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marketBorderProfile;
    }

    public void setMarketBorderProfile(ImageModel marketBorderProfile) {
        this.marketBorderProfile = marketBorderProfile;
    }

    /**
     * 是否需要提醒直播
     */

    @SerializedName("need_remind")
    private boolean needRemind;

    /**
     * 上次直播时间
     */

    @SerializedName("last_live_time")
    private long lastLiveTime;

    /**
     * 距上次直播时长
     */
    @SerializedName("last_live_seconds_from_now")
    private long lastLiveSecondsFromNow;


    public long getLastLiveTime() {
        return lastLiveTime;
    }


    public boolean isNeedRemind() {
        return needRemind;
    }


    public void setNeedRemind(boolean needRemind) {
        this.needRemind = needRemind;
    }

    public boolean getRoomAutoGiftThanks() {
        return roomAutoGiftThanks;
    }

    public void setRoomAutoGiftThanks(boolean roomAutoGiftThanks) {
        this.roomAutoGiftThanks = roomAutoGiftThanks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // 机构号、企业号相关
    // 机构号、企业号头图
    @SerializedName("header_image")
    private ImageModel headerImage;
    private String mHeaderImageStr; // 本地解析


    public void setHeaderImage(ImageModel headerImage) {
        this.headerImage = headerImage;
    }

    public void setHeaderImageStr(String mHeaderImageStr) {
        this.mHeaderImageStr = mHeaderImageStr;
    }


    public int getChatRestriction() {
        return chatRestriction;
    }

    public void setChatRestriction(int chatRestriction) {
        this.chatRestriction = chatRestriction;
    }

    public String getSpecialId() {
        return specialId;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }


    public ImageModel getAvatarBorder() {
        try {
            if (avatarBorder == null && !TextUtils.isEmpty(mAvatarBorderStr)) {
                avatarBorder = new Gson().fromJson(mAvatarBorderStr, ImageModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avatarBorder;
    }



    public void setAvatarBorder(ImageModel avatarBorder) {
        this.avatarBorder = avatarBorder;
    }


    public ImageModel getMedal() {
        try {
            if (medal == null && !TextUtils.isEmpty(mMedalStr)) {
                medal = new Gson().fromJson(mMedalStr, ImageModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medal;
    }

    public void setMedal(ImageModel medal) {
        this.medal = medal;
    }


    @SerializedName("follow_icon")
    private String liveFollowIcon;


    public String getLiveFollowIcon() {
        return liveFollowIcon;
    }



}
