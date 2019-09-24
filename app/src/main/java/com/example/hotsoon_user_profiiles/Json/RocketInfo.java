package com.example.hotsoon_user_profiiles.Json;


import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhangxin on 2019/1/7.
 * rocket 粉丝群相关 info
 */
public class RocketInfo {

    @SerializedName("group_chat_schema_url")
    String groupChatSchemaUrl; // 粉丝群跳转链接


    @SerializedName("clipboard_text")
    String clipboardText; // 复制到剪切板text


    @SerializedName("title")
    String title; // 文案

    public String getGroupChatSchemaUrl() {
        return groupChatSchemaUrl;
    }

    public void setGroupChatSchemaUrl(String groupChatSchemaUrl) {
        this.groupChatSchemaUrl = groupChatSchemaUrl;
    }

    public String getClipboardText() {
        return clipboardText;
    }

    public void setClipboardText(String clipboardText) {
        this.clipboardText = clipboardText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RocketInfo)) {
            return false;
        }
        RocketInfo that = (RocketInfo) o;

        return TextUtils.equals(getGroupChatSchemaUrl(), that.getGroupChatSchemaUrl())
                && TextUtils.equals(getClipboardText(), that.getClipboardText())
                && TextUtils.equals(getTitle(), that.getTitle());
    }

    private static final int HASHCODEOFFSET = 31;

    @Override
    public int hashCode() {
        int hashCode = 0;
        if (!TextUtils.isEmpty(groupChatSchemaUrl)) {
            hashCode = groupChatSchemaUrl.hashCode();
        }
        if (!TextUtils.isEmpty(clipboardText)) {
            if (hashCode == 0) {
                hashCode = clipboardText.hashCode();
            } else {
                hashCode = HASHCODEOFFSET * hashCode + clipboardText.hashCode();
            }
        }
        if (!TextUtils.isEmpty(title)) {
            if (hashCode == 0) {
                hashCode = title.hashCode();
            } else {
                hashCode = HASHCODEOFFSET * hashCode + title.hashCode();
            }
        }
        return hashCode;
    }
}
