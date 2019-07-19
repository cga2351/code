package com.viber.jni;

import android.os.Bundle;
import java.util.Arrays;

public class PublicGroupChangeEvent
{
  private String actor;
  private String actorPhoneNumber;
  CGroupAttributesChanged attributes;
  private int eventId;
  private long eventToken;
  private int flags;
  PublicGroupUserInfo[] members;
  private int msgType;
  private int numWatchers;
  private long timeSent;

  PublicGroupChangeEvent(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, PublicGroupUserInfo[] paramArrayOfPublicGroupUserInfo, CGroupAttributesChanged paramCGroupAttributesChanged, int paramInt4)
  {
    this.timeSent = paramLong1;
    this.eventToken = paramLong2;
    this.eventId = paramInt1;
    this.actor = paramString1;
    this.actorPhoneNumber = paramString2;
    this.flags = paramInt2;
    this.msgType = paramInt3;
    this.members = paramArrayOfPublicGroupUserInfo;
    this.attributes = paramCGroupAttributesChanged;
    this.numWatchers = paramInt4;
  }

  PublicGroupChangeEvent(Bundle paramBundle)
  {
    this.timeSent = paramBundle.getLong("Timesent");
    this.eventToken = paramBundle.getLong("EventToken");
    this.eventId = paramBundle.getInt("EventID");
    this.actor = paramBundle.getString("Actor");
    this.actorPhoneNumber = paramBundle.getString("ActorPhoneNumber");
    this.flags = paramBundle.getInt("Flags");
    this.msgType = paramBundle.getInt("MsgType");
    this.numWatchers = paramBundle.getInt("NumWatchers");
    int i = paramBundle.getInt("MembersSize");
    if (i > 0)
    {
      this.members = new PublicGroupUserInfo[i];
      for (int j = 0; j < i; j++)
      {
        Bundle localBundle2 = paramBundle.getBundle("Member" + j);
        String str1 = localBundle2.getString("PhoneNumber");
        String str2 = localBundle2.getString("ClientName");
        String str3 = localBundle2.getString("DownloadID");
        String str4 = localBundle2.getString("EncryptedPhoneNumber");
        int k = localBundle2.getInt("GroupRole");
        this.members[j] = new PublicGroupUserInfo(str1, str4, str2, str3, k);
      }
    }
    Bundle localBundle1 = paramBundle.getBundle("Attributes");
    if (localBundle1 != null)
      this.attributes = new CGroupAttributesChanged(localBundle1);
  }

  public String getActor()
  {
    return this.actor;
  }

  public String getActorPhoneNumber()
  {
    return this.actorPhoneNumber;
  }

  public CGroupAttributesChanged getAttributes()
  {
    return this.attributes;
  }

  public int getEventId()
  {
    return this.eventId;
  }

  public long getEventToken()
  {
    return this.eventToken;
  }

  public int getFlags()
  {
    return this.flags;
  }

  public PublicGroupUserInfo[] getMembers()
  {
    return this.members;
  }

  public int getMsgType()
  {
    return this.msgType;
  }

  public int getNumWatchers()
  {
    return this.numWatchers;
  }

  public long getTimeSent()
  {
    return this.timeSent;
  }

  public String toString()
  {
    return "PublicGroupChangeEvent [timeSent=" + this.timeSent + ", eventToken=" + this.eventToken + ", eventId=" + this.eventId + ", actor=" + this.actor + ", actorPhoneNumber=" + this.actorPhoneNumber + ", flags=" + this.flags + ", msgType=" + this.msgType + ", members=" + Arrays.toString(this.members) + ", attributes=" + this.attributes + ", numWatchers=" + this.numWatchers + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PublicGroupChangeEvent
 * JD-Core Version:    0.6.2
 */