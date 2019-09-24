package com.example.hotsoon_user_profiiles.Json;



import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxj
 */

public class UserHonor {

    public static final int NUM_31 = 31;
    public static final int NUM_32 = 32;
    @SerializedName("diamond_icon")
    private ImageModel diamondIcon;

    @SerializedName("icon")
    private ImageModel currentHonorIcon;

    @SerializedName("next_icon")
    private ImageModel nextHonorIcon;

    @SerializedName("next_name")
    private String nextHonorName;

    @SerializedName("name")
    private String currentHonorName;

    @SerializedName("total_diamond_count")
    private long totalDiamond;

    @SerializedName("now_diamond")
    private long currentDiamond;

    @SerializedName("next_diamond")
    private long nextDiamond;

    @SerializedName("im_icon")
    private ImageModel imIcon;

    @SerializedName("im_icon_with_level")
    private ImageModel imIconWithLevel;

    @SerializedName("new_im_icon_with_level")
    private ImageModel newImIconWithLevel;

    @SerializedName("live_icon")
    private ImageModel liveIcon;

    @SerializedName("new_live_icon")
    private ImageModel newLiveIcon;

    @SerializedName("new_nav_live_icon")
    private ImageModel newHonorIcon; // 新的消费荣誉等级icon

    @SerializedName("level")
    private int level;

    @SerializedName("grade_icon_list")
    private List<GradeIcon> gradeIconList;

    @SerializedName("grade_describe")
    private String gradeDescribe;

    @SerializedName("upgrade_need_consume")
    private long upgradeNeedConsume;

    @SerializedName("grade_banner")
    private String gradeBanner;

    @SerializedName("this_grade_max_diamond")
    private long thisGradeMaxDiamond;

    @SerializedName("this_grade_min_diamond")
    private long thisGradeMinDiamond;

    @SerializedName("profile_dialog_bg")
    private ImageModel profileDialogBg;

    @SerializedName("profile_dialog_bg_back")
    private ImageModel profileDialogBackBg;


    public long getUpgradeNeedConsume() {
        return upgradeNeedConsume;
    }


    public ImageModel getNewImIconWithLevel() {
        if (newImIconWithLevel != null) {
            return newImIconWithLevel;
        } else {
            return imIconWithLevel;
        }
    }


    public ImageModel getNewLiveIcon() {
        if (newLiveIcon != null) {
            return newLiveIcon;
        } else {
            return liveIcon;
        }
    }


    public ImageModel getNewHonorIcon() {
        return newHonorIcon;
    }

    public void setNewHonorIcon(ImageModel newHonorIcon) {
        this.newHonorIcon = newHonorIcon;
    }


    public String getGradeBanner() {
        return gradeBanner;
    }

    public void setGradeBanner(String gradeBanner) {
        this.gradeBanner = gradeBanner;
    }

    public ImageModel getDiamondIcon() {
        return diamondIcon;
    }

    public void setDiamondIcon(ImageModel diamondIcon) {
        this.diamondIcon = diamondIcon;
    }

    public ImageModel getCurrentHonorIcon() {
        return currentHonorIcon;
    }

    public void setCurrentHonorIcon(ImageModel currentHonorIcon) {
        this.currentHonorIcon = currentHonorIcon;
    }

    public ImageModel getNextHonorIcon() {
        return nextHonorIcon;
    }

    public void setNextHonorIcon(ImageModel nextHonorIcon) {
        this.nextHonorIcon = nextHonorIcon;
    }

    public String getNextHonorName() {
        return nextHonorName;
    }

    public void setNextHonorName(String nextHonorName) {
        this.nextHonorName = nextHonorName;
    }

    public String getCurrentHonorName() {
        return currentHonorName;
    }

    public void setCurrentHonorName(String currentHonorName) {
        this.currentHonorName = currentHonorName;
    }

    public long getTotalDiamond() {
        return totalDiamond;
    }

    public void setTotalDiamond(long totalDiamond) {
        this.totalDiamond = totalDiamond;
    }

    public long getCurrentDiamond() {
        return currentDiamond;
    }

    public void setCurrentDiamond(long currentDiamond) {
        this.currentDiamond = currentDiamond;
    }

    public long getNextDiamond() {
        return nextDiamond;
    }

    public void setNextDiamond(long nextDiamond) {
        this.nextDiamond = nextDiamond;
    }

    public ImageModel getImIcon() {
        return imIcon;
    }

    public void setImIcon(ImageModel imIcon) {
        this.imIcon = imIcon;
    }

    public ImageModel getImIconWithLevel() {
        return imIconWithLevel;
    }

    public void setImIconWithLevel(ImageModel imIconWithLevel) {
        this.imIconWithLevel = imIconWithLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ImageModel getLiveIcon() {
        return liveIcon;
    }

    public void setLiveIcon(ImageModel liveIcon) {
        this.liveIcon = liveIcon;
    }

    public List<GradeIcon> getGradeIconList() {
        return gradeIconList;
    }

    public void setGradeIconList(List<GradeIcon> gradeIconList) {
        this.gradeIconList = gradeIconList;
    }

    public String getGradeDescribe() {
        return gradeDescribe;
    }

    public void setGradeDescribe(String gradeDescribe) {
        this.gradeDescribe = gradeDescribe;
    }


    public long getThisGradeMaxDiamond() {
        return thisGradeMaxDiamond;
    }


    public long getThisGradeMinDiamond() {
        return thisGradeMinDiamond;
    }


    public ImageModel getProfileDialogBg() {
        return profileDialogBg;
    }


    public ImageModel getProfileDialogBackBg() {
        return profileDialogBackBg;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserHonor userHonor = (UserHonor) o;

        if (totalDiamond != userHonor.totalDiamond) {
            return false;
        }
        if (currentDiamond != userHonor.currentDiamond) {
            return false;
        }
        if (nextDiamond != userHonor.nextDiamond) {
            return false;
        }
        if (level != userHonor.level) {
            return false;
        }
        if (diamondIcon != null ? !diamondIcon.equals(userHonor.diamondIcon) : userHonor.diamondIcon != null) {
            return false;
        }
        if (currentHonorIcon != null ? !currentHonorIcon.equals(userHonor.currentHonorIcon) : userHonor.currentHonorIcon != null) {
            return false;
        }
        if (nextHonorIcon != null ? !nextHonorIcon.equals(userHonor.nextHonorIcon) : userHonor.nextHonorIcon != null) {
            return false;
        }
        if (nextHonorName != null ? !nextHonorName.equals(userHonor.nextHonorName) : userHonor.nextHonorName != null) {
            return false;
        }
        if (currentHonorName != null ? !currentHonorName.equals(userHonor.currentHonorName) : userHonor.currentHonorName != null) {
            return false;
        }
        if (imIcon != null ? !imIcon.equals(userHonor.imIcon) : userHonor.imIcon != null) {
            return false;
        }
        if (imIconWithLevel != null ? !imIconWithLevel.equals(userHonor.imIconWithLevel) : userHonor.imIconWithLevel != null) {
            return false;
        }
        if (newImIconWithLevel != null ? !newImIconWithLevel.equals(userHonor.newImIconWithLevel) : userHonor.newImIconWithLevel != null) {
            return false;
        }
        if (liveIcon != null ? !liveIcon.equals(userHonor.liveIcon) : userHonor.liveIcon != null) {
            return false;
        }
        if (newLiveIcon != null ? !newLiveIcon.equals(userHonor.newLiveIcon) : userHonor.newLiveIcon != null) {
            return false;
        }
        if (newHonorIcon != null ? !newHonorIcon.equals(userHonor.newHonorIcon) : userHonor.newHonorIcon != null) {
            return false;
        }
        if (gradeIconList != null ? !gradeIconList.equals(userHonor.gradeIconList) : userHonor.gradeIconList != null) {
            return false;
        }
        if (thisGradeMinDiamond != userHonor.thisGradeMinDiamond) {
            return false;
        }
        if (thisGradeMaxDiamond != userHonor.thisGradeMaxDiamond) {
            return false;
        }
        if (profileDialogBg != null ? !profileDialogBg.equals(userHonor.profileDialogBg) : userHonor.profileDialogBg != null) {
            return false;
        }
        if (profileDialogBackBg != null ? !profileDialogBackBg.equals(userHonor.profileDialogBackBg) : userHonor.profileDialogBackBg != null) {
            return false;
        }
        return gradeDescribe != null ? gradeDescribe.equals(userHonor.gradeDescribe) : userHonor.gradeDescribe == null;
    }

    @Override
    public int hashCode() {
        int result = diamondIcon != null ? diamondIcon.hashCode() : 0;
        result = NUM_31 * result + (currentHonorIcon != null ? currentHonorIcon.hashCode() : 0);
        result = NUM_31 * result + (nextHonorIcon != null ? nextHonorIcon.hashCode() : 0);
        result = NUM_31 * result + (nextHonorName != null ? nextHonorName.hashCode() : 0);
        result = NUM_31 * result + (currentHonorName != null ? currentHonorName.hashCode() : 0);
        result = NUM_31 * result + (int) (totalDiamond ^ (totalDiamond >>> NUM_32));
        result = NUM_31 * result + (int) (currentDiamond ^ (currentDiamond >>> NUM_32));
        result = NUM_31 * result + (int) (nextDiamond ^ (nextDiamond >>> NUM_32));
        result = NUM_31 * result + (imIcon != null ? imIcon.hashCode() : 0);
        result = NUM_31 * result + (imIconWithLevel != null ? imIconWithLevel.hashCode() : 0);
        result = NUM_31 * result + (newImIconWithLevel != null ? newImIconWithLevel.hashCode() : 0);
        result = NUM_31 * result + (liveIcon != null ? liveIcon.hashCode() : 0);
        result = NUM_31 * result + (newLiveIcon != null ? newLiveIcon.hashCode() : 0);
        result = NUM_31 * result + (newHonorIcon != null ? newHonorIcon.hashCode() : 0);
        result = NUM_31 * result + level;
        result = NUM_31 * result + (gradeIconList != null ? gradeIconList.hashCode() : 0);
        result = NUM_31 * result + (gradeDescribe != null ? gradeDescribe.hashCode() : 0);
        result = NUM_31 * result + (int) (thisGradeMaxDiamond ^ (thisGradeMaxDiamond >>> NUM_32));
        result = NUM_31 * result + (int) (thisGradeMinDiamond ^ (thisGradeMinDiamond >>> NUM_32));
        result = NUM_31 * result + (profileDialogBg != null ? profileDialogBg.hashCode() : 0);
        result = NUM_31 * result + (profileDialogBackBg != null ? profileDialogBackBg.hashCode() : 0);
        return result;
    }
}
