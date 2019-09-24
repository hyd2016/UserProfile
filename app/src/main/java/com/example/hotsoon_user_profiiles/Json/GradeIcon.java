package com.example.hotsoon_user_profiiles.Json;


/**
 * @author lujunming
 * Created by lujunming on 2017/9/15.
 */

public class GradeIcon {
    private static final int NUM_31 = 31;


    private String levelStr;


    private int iconDiamond;


    private ImageModel icon;


    private int level;

    public String getLevelStr() {
        return levelStr;
    }

    public void setLevelStr(String levelStr) {
        this.levelStr = levelStr;
    }

    public int getIconDiamond() {
        return iconDiamond;
    }

    public void setIconDiamond(int iconDiamond) {
        this.iconDiamond = iconDiamond;
    }

    public ImageModel getIcon() {
        return icon;
    }

    public void setIcon(ImageModel icon) {
        this.icon = icon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GradeIcon gradeIcon = (GradeIcon) o;

        if (iconDiamond != gradeIcon.iconDiamond) {
            return false;
        }
        if (level != gradeIcon.level) {
            return false;
        }
        if (levelStr != null ? !levelStr.equals(gradeIcon.levelStr) : gradeIcon.levelStr != null) {
            return false;
        }
        return icon != null ? icon.equals(gradeIcon.icon) : gradeIcon.icon == null;
    }

    @Override
    public int hashCode() {
        int result = levelStr != null ? levelStr.hashCode() : 0;
        result = NUM_31 * result + iconDiamond;
        result = NUM_31 * result + (icon != null ? icon.hashCode() : 0);
        result = NUM_31 * result + level;
        return result;
    }
}
