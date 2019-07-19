package com.viber.jni;

import android.os.Bundle;
import java.util.HashMap;

public class Group2LatestParams
{
  private String mGroup2AccessToken;
  private long mGroupID;
  private int mLastMediaType;
  private int mLastMsgID;
  private String mLastMsgText;
  private long mLastTimestampOfMsgs;
  private long mLastTokenOfMsgs;
  private HashMap<Integer, String> mMoreInfo;
  private int mNumWatchers;
  private PGRole mPgRole;
  private int mRevision;
  private String mSenderEncryptedPhone;

  private Group2LatestParams(Bundle paramBundle)
  {
    this.mGroupID = paramBundle.getLong("GroupID");
    this.mRevision = paramBundle.getInt("Revision");
    this.mNumWatchers = paramBundle.getInt("NumWatchers");
    this.mLastMsgID = paramBundle.getInt("LastMsgID");
    this.mLastMediaType = paramBundle.getInt("LastMediaType");
    this.mLastMsgText = paramBundle.getString("LastMsgText");
    this.mSenderEncryptedPhone = paramBundle.getString("SenderEncryptedPhone");
    this.mLastTokenOfMsgs = paramBundle.getLong("LastTokenOfMsgs");
    this.mLastTimestampOfMsgs = paramBundle.getLong("LastTimestampOfMsgs");
    this.mPgRole = new PGRole(paramBundle.getInt("GroupRole"), paramBundle.getInt("UserSubscribeState"));
    this.mGroup2AccessToken = paramBundle.getString("Group2AccessToken");
    this.mMoreInfo = ((HashMap)paramBundle.getSerializable("MoreUserInfo"));
  }

  public String getGroup2AccessToken()
  {
    return this.mGroup2AccessToken;
  }

  public long getGroupID()
  {
    return this.mGroupID;
  }

  public int getLastMediaType()
  {
    return this.mLastMediaType;
  }

  public int getLastMsgID()
  {
    return this.mLastMsgID;
  }

  public String getLastMsgText()
  {
    return this.mLastMsgText;
  }

  public long getLastTimestampOfMsgs()
  {
    return this.mLastTimestampOfMsgs;
  }

  public long getLastTokenOfMsgs()
  {
    return this.mLastTokenOfMsgs;
  }

  public String getMoreInfo(int paramInt)
  {
    if ((this.mMoreInfo != null) && (this.mMoreInfo.containsKey(Integer.valueOf(paramInt))))
      return (String)this.mMoreInfo.get(Integer.valueOf(paramInt));
    return "";
  }

  public int getNumWatchers()
  {
    return this.mNumWatchers;
  }

  public PGRole getPgRole()
  {
    return this.mPgRole;
  }

  public int getRevision()
  {
    return this.mRevision;
  }

  public String getSenderEncryptedPhone()
  {
    return this.mSenderEncryptedPhone;
  }

  public String toString()
  {
    return "Group2LatestParams{mGroupID=" + this.mGroupID + ", mRevision=" + this.mRevision + ", mNumWatchers=" + this.mNumWatchers + ", mLastMsgID=" + this.mLastMsgID + ", mLastMediaType=" + this.mLastMediaType + ", mLastMsgText='" + this.mLastMsgText + '\'' + ", mSenderEncryptedPhone='" + this.mSenderEncryptedPhone + '\'' + ", mLastTokenOfMsgs=" + this.mLastTokenOfMsgs + ", mLastTimestampOfMsgs=" + this.mLastTimestampOfMsgs + ", mpgRole=" + this.mPgRole + '\'' + ", mGroup2AccessToken='" + this.mGroup2AccessToken + '\'' + ", mMoreInfo='" + this.mMoreInfo + '}';
  }

  public static class MoreInfoKeys
  {
    public static final int DownloadID = 3;
    public static final int EncryptedMID = 2;
    public static final int EncryptedPhoneNumber = 1;
    public static final int SenderName = 4;
    public static final int UserType;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.Group2LatestParams
 * JD-Core Version:    0.6.2
 */