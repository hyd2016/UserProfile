package com.example.hotsoon_user_profiiles.Json;



import com.google.gson.annotations.SerializedName;


/**
 * @author lipenglin
 */
public class AnchorLevel  {

    private static final int HASH_31 = 31;
    private static final int HASH_32 = 32;

    @SerializedName("level")
    private int level;

    // 当前经验值
    @SerializedName("experience")
    private long experience;

    // 当前等级最低经验值
    @SerializedName("lowest_experience_this_level")
    private long lowestExperienceThisLevel;

    // 当前等级最高经验值
    @SerializedName("highest_experience_this_level")
    private long highestExperienceThisLevel;

    // 保级任务开始时经验值
    @SerializedName("task_start_experience")
    private long taskStartExperience;

    // 保级任务开始时间
    @SerializedName("task_start_time")
    private long taskStartTime;

    // 级任务没完成的话掉的经验值
    @SerializedName("task_decrease_experience")
    private long taskDecreaseExperience;

    // 保级任务目标经验值
    @SerializedName("task_target_experience")
    private long taskTargetExperience;

    // 保级任务结束时间的时间戳(秒)
    @SerializedName("task_end_time")
    private long taskEndTime;

    // 直播间内资料卡上，主播等级的背景图
    @SerializedName("profile_dialog_bg")
    private ImageModel profileDialogBg;

    // 直播间内资料卡上，主播经验的背景图
    @SerializedName("profile_dialog_bg_back")
    private ImageModel profileDialogBackBg;

    // 天王巨星那个图
    @SerializedName("stage_level")
    private ImageModel stageLevelIcon;

    // 等级图标
    @SerializedName("small_icon")
    private ImageModel levelIcon;


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }


    public long getLowestExperienceThisLevel() {
        return lowestExperienceThisLevel;
    }

    public void setLowestExperienceThisLevel(long lowestExperienceThisLevel) {
        this.lowestExperienceThisLevel = lowestExperienceThisLevel;
    }


    public long getHighestExperienceThisLevel() {
        return highestExperienceThisLevel;
    }

    public void setHighestExperienceThisLevel(long highestExperienceThisLevel) {
        this.highestExperienceThisLevel = highestExperienceThisLevel;
    }


    public long getTaskStartExperience() {
        return taskStartExperience;
    }

    public void setTaskStartExperience(long taskStartExperience) {
        this.taskStartExperience = taskStartExperience;
    }


    public long getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(long taskStartTime) {
        this.taskStartTime = taskStartTime;
    }


    public long getTaskDecreaseExperience() {
        return taskDecreaseExperience;
    }

    public void setTaskDecreaseExperience(long taskDecreaseExperience) {
        this.taskDecreaseExperience = taskDecreaseExperience;
    }


    public long getTaskTargetExperience() {
        return taskTargetExperience;
    }

    public void setTaskTargetExperience(long taskTargetExperience) {
        this.taskTargetExperience = taskTargetExperience;
    }


    public long getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(long taskEndTime) {
        this.taskEndTime = taskEndTime;
    }


    public ImageModel getProfileDialogBg() {
        return profileDialogBg;
    }

    public void setProfileDialogBg(ImageModel profileDialogBg) {
        this.profileDialogBg = profileDialogBg;
    }


    public ImageModel getProfileDialogBackBg() {
        return profileDialogBackBg;
    }

    public void setProfileDialogBackBg(ImageModel profileDialogBackBg) {
        this.profileDialogBackBg = profileDialogBackBg;
    }


    public ImageModel getStageLevelIcon() {
        return stageLevelIcon;
    }

    public void setStageLevelIcon(ImageModel stageLevelIcon) {
        this.stageLevelIcon = stageLevelIcon;
    }

    public ImageModel getLevelIcon() {
        return levelIcon;
    }

    public void setLevelIcon(ImageModel levelIcon) {
        this.levelIcon = levelIcon;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AnchorLevel anchorLevel = (AnchorLevel) o;

        if (level != anchorLevel.level) {
            return false;
        }
        if (experience != anchorLevel.experience) {
            return false;
        }
        if (lowestExperienceThisLevel != anchorLevel.lowestExperienceThisLevel) {
            return false;
        }
        if (highestExperienceThisLevel != anchorLevel.highestExperienceThisLevel) {
            return false;
        }
        if (taskStartExperience != anchorLevel.taskStartExperience) {
            return false;
        }
        if (taskStartTime != anchorLevel.taskStartTime) {
            return false;
        }
        if (taskDecreaseExperience != anchorLevel.taskDecreaseExperience) {
            return false;
        }
        if (taskTargetExperience != anchorLevel.taskTargetExperience) {
            return false;
        }
        if (taskEndTime != anchorLevel.taskEndTime) {
            return false;
        }
        if (profileDialogBg != null ? !profileDialogBg.equals(anchorLevel.profileDialogBg) : anchorLevel.profileDialogBg != null) {
            return false;
        }
        if (profileDialogBackBg != null ? !profileDialogBackBg.equals(anchorLevel.profileDialogBackBg) : anchorLevel.profileDialogBackBg != null) {
            return false;
        }
        if (stageLevelIcon != null ? !stageLevelIcon.equals(anchorLevel.stageLevelIcon) : anchorLevel.stageLevelIcon != null) {
            return false;
        }
        return levelIcon != null ? levelIcon.equals(anchorLevel.levelIcon) : anchorLevel.levelIcon == null;
    }

    @Override
    public int hashCode() {
        int result = levelIcon != null ? levelIcon.hashCode() : 0;
        result = HASH_31 * result + level;
        result = HASH_31 * result + (int) (experience ^ (experience >>> HASH_32));
        result = HASH_31 * result + (int) (lowestExperienceThisLevel ^ (lowestExperienceThisLevel >>> HASH_32));
        result = HASH_31 * result + (int) (highestExperienceThisLevel ^ (highestExperienceThisLevel >>> HASH_32));
        result = HASH_31 * result + (int) (taskStartExperience ^ (taskStartExperience >>> HASH_32));
        result = HASH_31 * result + (int) (taskStartTime ^ (taskStartTime >>> HASH_32));
        result = HASH_31 * result + (int) (taskDecreaseExperience ^ (taskDecreaseExperience >>> HASH_32));
        result = HASH_31 * result + (int) (taskTargetExperience ^ (taskTargetExperience >>> HASH_32));
        result = HASH_31 * result + (int) (taskEndTime ^ (taskEndTime >>> HASH_32));
        result = HASH_31 * result + (profileDialogBg != null ? profileDialogBg.hashCode() : 0);
        result = HASH_31 * result + (profileDialogBackBg != null ? profileDialogBackBg.hashCode() : 0);
        result = HASH_31 * result + (stageLevelIcon != null ? stageLevelIcon.hashCode() : 0);
        result = HASH_31 * result + (levelIcon != null ? levelIcon.hashCode() : 0);
        return result;
    }
}
