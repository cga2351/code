package com.viber.jni;

import android.os.Bundle;
import java.util.Arrays;

public class PublicAccountInfo
{
  int GroupFlags;
  String[] Tags;
  String mAuthToken;
  String mBackgroundDownloadID;
  String mCategory;
  String mChatBackground;
  long mCommunityPrivileges;
  String mCountry;
  String mCrmName;
  DeleteAllUserMessagesInfo[] mDeleteAllUserMessagesInfos;
  int mDisplayInvitationLink;
  String mEmail;
  String mGroup2AccessToken;
  String mGroupName;
  int mGroupType;
  String mGroupUri;
  String mIconDownloadID;
  String mInvitationLink;
  JokerButton[] mJokerButtons;
  int mLastMsgSeqID;
  LocationInfo mLocation;
  ChatUserInfo[] mMembers;
  PinInfo[] mPinInfos;
  String mPublicAccountID;
  long mPublicChatId;
  int mRevision;
  String mSubCategory;
  int mSubscribersCount;
  String mTagLine;
  int mUserFlags;
  int mUserRole;
  int mWatchersCount;
  String mWebSite;
  boolean mWebhookExists;

  public PublicAccountInfo(long paramLong1, String paramString1, int paramInt1, ChatUserInfo[] paramArrayOfChatUserInfo, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, LocationInfo paramLocationInfo, String paramString7, int paramInt8, String paramString8, String paramString9, String paramString10, boolean paramBoolean, JokerButton[] paramArrayOfJokerButton, String paramString11, String paramString12, String paramString13, PinInfo[] paramArrayOfPinInfo, String paramString14, DeleteAllUserMessagesInfo[] paramArrayOfDeleteAllUserMessagesInfo, int paramInt9, long paramLong2, String paramString15, String paramString16)
  {
    this.mPublicChatId = paramLong1;
    this.mPublicAccountID = paramString1;
    this.mGroupType = paramInt1;
    this.mMembers = paramArrayOfChatUserInfo;
    this.mUserRole = paramInt2;
    this.mUserFlags = paramInt3;
    this.mWatchersCount = paramInt4;
    this.mSubscribersCount = paramInt5;
    this.mLastMsgSeqID = paramInt6;
    this.mRevision = paramInt7;
    this.mGroupName = paramString2;
    this.mGroupUri = paramString3;
    this.mIconDownloadID = paramString4;
    this.mBackgroundDownloadID = paramString5;
    this.mTagLine = paramString6;
    this.Tags = paramArrayOfString;
    this.mLocation = paramLocationInfo;
    this.mCountry = paramString7;
    this.GroupFlags = paramInt8;
    this.mCategory = paramString8;
    this.mSubCategory = paramString9;
    this.mAuthToken = paramString10;
    this.mWebhookExists = paramBoolean;
    this.mJokerButtons = paramArrayOfJokerButton;
    this.mCrmName = paramString11;
    this.mWebSite = paramString12;
    this.mEmail = paramString13;
    this.mPinInfos = paramArrayOfPinInfo;
    this.mInvitationLink = paramString14;
    this.mDeleteAllUserMessagesInfos = paramArrayOfDeleteAllUserMessagesInfo;
    this.mDisplayInvitationLink = paramInt9;
    this.mCommunityPrivileges = paramLong2;
    this.mGroup2AccessToken = paramString15;
    this.mChatBackground = paramString16;
  }

  private PublicAccountInfo(Bundle paramBundle)
  {
    this.mPublicChatId = paramBundle.getLong("PublicChatId");
    this.mPublicAccountID = paramBundle.getString("PublicAccountID");
    this.mGroupType = paramBundle.getInt("GroupType");
    int i = paramBundle.getInt("ChatUserInfoSize");
    this.mMembers = new ChatUserInfo[i];
    for (int j = 0; j < i; j++)
    {
      Bundle localBundle4 = paramBundle.getBundle("Member" + j);
      this.mMembers[j] = new ChatUserInfo(localBundle4);
    }
    int k = paramBundle.getInt("JokerButtonsSize");
    this.mJokerButtons = new JokerButton[k];
    for (int m = 0; m < k; m++)
    {
      Bundle localBundle3 = paramBundle.getBundle("JokerButton" + m);
      this.mJokerButtons[m] = new JokerButton(localBundle3);
    }
    this.mUserRole = paramBundle.getInt("UserRole");
    this.mUserFlags = paramBundle.getInt("UserFlags");
    this.mWatchersCount = paramBundle.getInt("WatchersCount");
    this.mSubscribersCount = paramBundle.getInt("SubscribersCount");
    this.mLastMsgSeqID = paramBundle.getInt("LastMsgSeqID");
    this.mRevision = paramBundle.getInt("Revision");
    this.mGroupName = paramBundle.getString("GroupName");
    this.mGroupUri = paramBundle.getString("GroupUri");
    this.mIconDownloadID = paramBundle.getString("IconDownloadID");
    this.mBackgroundDownloadID = paramBundle.getString("BackgroundDownloadID");
    this.mTagLine = paramBundle.getString("TagLine");
    this.Tags = paramBundle.getStringArray("Tags");
    this.mLocation = new LocationInfo(paramBundle.getInt("LocationLat"), paramBundle.getInt("LocationLong"));
    this.mCountry = paramBundle.getString("Country");
    this.GroupFlags = paramBundle.getInt("GroupFlags");
    this.mCategory = paramBundle.getString("Category");
    this.mSubCategory = paramBundle.getString("SubCategory");
    this.mAuthToken = paramBundle.getString("AuthToken");
    this.mWebhookExists = paramBundle.getBoolean("WebhookExists");
    this.mCrmName = paramBundle.getString("CrmName");
    this.mWebSite = paramBundle.getString("Website");
    this.mEmail = paramBundle.getString("Email");
    int n = paramBundle.getInt("PinInfoSize");
    this.mPinInfos = new PinInfo[n];
    for (int i1 = 0; i1 < n; i1++)
    {
      Bundle localBundle2 = paramBundle.getBundle("PinInfo" + i1);
      this.mPinInfos[i1] = ((PinInfo)JniUtils.fromBundle(localBundle2));
    }
    this.mInvitationLink = paramBundle.getString("InvitationLink");
    int i2 = paramBundle.getInt("DeleteAllUserMessagesInfoSize");
    this.mDeleteAllUserMessagesInfos = new DeleteAllUserMessagesInfo[i2];
    for (int i3 = 0; i3 < i2; i3++)
    {
      Bundle localBundle1 = paramBundle.getBundle("DeleteAllUserMessagesInfo" + i3);
      this.mDeleteAllUserMessagesInfos[i3] = new DeleteAllUserMessagesInfo(localBundle1);
    }
    this.mDisplayInvitationLink = paramBundle.getInt("DisplayInvitationLink");
    this.mCommunityPrivileges = paramBundle.getLong("CommunityPrivileges");
    this.mChatBackground = paramBundle.getString("ChatBackground");
  }

  public String getAuthToken()
  {
    return this.mAuthToken;
  }

  public String getBackgroundDownloadID()
  {
    return this.mBackgroundDownloadID;
  }

  public String getCategory()
  {
    return this.mCategory;
  }

  public String getChatBackground()
  {
    return this.mChatBackground;
  }

  public long getCommunityPrivileges()
  {
    return this.mCommunityPrivileges;
  }

  public String getCountry()
  {
    return this.mCountry;
  }

  public String getCrmName()
  {
    return this.mCrmName;
  }

  public DeleteAllUserMessagesInfo[] getDeleteAllUserMessagesInfos()
  {
    return this.mDeleteAllUserMessagesInfos;
  }

  public int getDisplayInvitationLink()
  {
    return this.mDisplayInvitationLink;
  }

  public String getEmail()
  {
    return this.mEmail;
  }

  public int getGroupFlags()
  {
    return this.GroupFlags;
  }

  public String getGroupName()
  {
    return this.mGroupName;
  }

  public int getGroupType()
  {
    return this.mGroupType;
  }

  public String getGroupUri()
  {
    return this.mGroupUri;
  }

  public String getIconDownloadID()
  {
    return this.mIconDownloadID;
  }

  public String getInvitationLink()
  {
    return this.mInvitationLink;
  }

  public JokerButton[] getJokerButtons()
  {
    return this.mJokerButtons;
  }

  public int getLastMsgSeqID()
  {
    return this.mLastMsgSeqID;
  }

  public LocationInfo getLocation()
  {
    return this.mLocation;
  }

  public ChatUserInfo[] getMembers()
  {
    return this.mMembers;
  }

  public PinInfo[] getPinInfos()
  {
    return this.mPinInfos;
  }

  public String getPublicAccountID()
  {
    return this.mPublicAccountID;
  }

  public long getPublicChatId()
  {
    return this.mPublicChatId;
  }

  public int getRevision()
  {
    return this.mRevision;
  }

  public String getSubCategory()
  {
    return this.mSubCategory;
  }

  public int getSubscribersCount()
  {
    return this.mSubscribersCount;
  }

  public String getTagLine()
  {
    return this.mTagLine;
  }

  public String[] getTags()
  {
    return this.Tags;
  }

  public int getUserFlags()
  {
    return this.mUserFlags;
  }

  public int getUserRole()
  {
    return this.mUserRole;
  }

  public int getWatchersCount()
  {
    return this.mWatchersCount;
  }

  public String getWebSite()
  {
    return this.mWebSite;
  }

  public boolean isWebhookExists()
  {
    return this.mWebhookExists;
  }

  public String toString()
  {
    return "PublicAccountInfo{mPublicChatId=" + this.mPublicChatId + ", mPublicAccountID='" + this.mPublicAccountID + '\'' + ", mGroupType=" + this.mGroupType + ", mMembers=" + Arrays.toString(this.mMembers) + ", mUserRole=" + this.mUserRole + ", mUserFlags=" + this.mUserFlags + ", mWatchersCount=" + this.mWatchersCount + ", mSubscribersCount=" + this.mSubscribersCount + ", mLastMsgSeqID=" + this.mLastMsgSeqID + ", mRevision=" + this.mRevision + ", mGroupName='" + this.mGroupName + '\'' + ", mGroupUri='" + this.mGroupUri + '\'' + ", mIconDownloadID='" + this.mIconDownloadID + '\'' + ", mBackgroundDownloadID='" + this.mBackgroundDownloadID + '\'' + ", mTagLine='" + this.mTagLine + '\'' + ", Tags=" + Arrays.toString(this.Tags) + ", mLocation=" + this.mLocation + ", mCountry='" + this.mCountry + '\'' + ", GroupFlags=" + this.GroupFlags + ", mCategory='" + this.mCategory + '\'' + ", mSubCategory='" + this.mSubCategory + '\'' + ", mAuthToken='" + this.mAuthToken + '\'' + ", mWebhookExists=" + this.mWebhookExists + ", mJokerButtons=" + Arrays.toString(this.mJokerButtons) + ", mCrmName='" + this.mCrmName + '\'' + ", mWebSite='" + this.mWebSite + '\'' + ", mEmail='" + this.mEmail + '\'' + ", mPinInfos=" + Arrays.toString(this.mPinInfos) + ", mInvitationLink='" + this.mInvitationLink + '\'' + ", mDeleteAllUserMessagesInfos=" + Arrays.toString(this.mDeleteAllUserMessagesInfos) + ", mCommunityPrivileges=" + this.mCommunityPrivileges + ", mDisplayInvitationLink=" + this.mDisplayInvitationLink + ", mChatBackground=" + this.mChatBackground + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PublicAccountInfo
 * JD-Core Version:    0.6.2
 */