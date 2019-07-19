package com.viber.jni;

import android.os.Bundle;

public class DeleteAllUserMessagesInfo
{
  private int mSeqInPG;
  private long mToken;
  private String mUser;

  public DeleteAllUserMessagesInfo(long paramLong, int paramInt, String paramString)
  {
    this.mToken = paramLong;
    this.mSeqInPG = paramInt;
    this.mUser = paramString;
  }

  public DeleteAllUserMessagesInfo(Bundle paramBundle)
  {
    this.mToken = paramBundle.getLong("Token");
    this.mSeqInPG = paramBundle.getInt("SeqInPG");
    this.mUser = paramBundle.getString("User");
  }

  public int getSeqInPG()
  {
    return this.mSeqInPG;
  }

  public long getToken()
  {
    return this.mToken;
  }

  public String getUser()
  {
    return this.mUser;
  }

  public String toString()
  {
    return "DeleteAllUserMessagesInfo{Token=" + this.mToken + ", SeqInPG=" + this.mSeqInPG + ", User='" + this.mUser + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.DeleteAllUserMessagesInfo
 * JD-Core Version:    0.6.2
 */