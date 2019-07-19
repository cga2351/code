package com.viber.voip.publicaccount.entity;

import com.viber.jni.Group2LatestParams;
import com.viber.jni.PGLatestParams;
import com.viber.jni.PGLatestParamsWithRole;
import com.viber.jni.PGRole;

public class c
{
  private long a;
  private int b;
  private int c;
  private int d;
  private int e;
  private String f;
  private String g;
  private String h;
  private String i;
  private long j;
  private long k;
  private int l;
  private int m;
  private int n;

  public c(Group2LatestParams paramGroup2LatestParams)
  {
    PGRole localPGRole = paramGroup2LatestParams.getPgRole();
    this.a = paramGroup2LatestParams.getGroupID();
    this.b = paramGroup2LatestParams.getRevision();
    this.c = paramGroup2LatestParams.getNumWatchers();
    this.d = paramGroup2LatestParams.getLastMsgID();
    this.e = paramGroup2LatestParams.getLastMediaType();
    this.f = paramGroup2LatestParams.getLastMsgText();
    this.g = paramGroup2LatestParams.getSenderEncryptedPhone();
    this.h = paramGroup2LatestParams.getMoreInfo(4);
    this.i = paramGroup2LatestParams.getMoreInfo(3);
    this.j = paramGroup2LatestParams.getLastTokenOfMsgs();
    this.k = paramGroup2LatestParams.getLastTimestampOfMsgs();
    this.l = localPGRole.getGroupRole();
    this.m = localPGRole.getUserSubscribeState();
    this.n = 3;
  }

  public c(PGLatestParamsWithRole paramPGLatestParamsWithRole)
  {
    PGLatestParams localPGLatestParams = paramPGLatestParamsWithRole.getPGLatestParams();
    PGRole localPGRole = paramPGLatestParamsWithRole.getPGRole();
    this.a = localPGLatestParams.getGroupID();
    this.b = localPGLatestParams.getRevision();
    this.c = localPGLatestParams.getNumWatchers();
    this.d = localPGLatestParams.getLastMsgID();
    this.e = localPGLatestParams.getLastMediaType();
    this.f = localPGLatestParams.getLastMsgText();
    this.g = localPGLatestParams.getSenderEncryptedPhone();
    this.h = null;
    this.i = null;
    this.j = localPGLatestParams.getLastTokenOfMsgs();
    this.k = localPGLatestParams.getLastTimestampOfMsgs();
    this.l = localPGRole.getGroupRole();
    this.m = localPGRole.getUserSubscribeState();
    this.n = 1;
  }

  public long a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public String f()
  {
    return this.f;
  }

  public String g()
  {
    return this.g;
  }

  public String h()
  {
    return this.h;
  }

  public String i()
  {
    return this.i;
  }

  public long j()
  {
    return this.k;
  }

  public int k()
  {
    return this.l;
  }

  public int l()
  {
    return this.m;
  }

  public int m()
  {
    return this.n;
  }

  public String toString()
  {
    return "PublicAccountLatestParams{mGroupID=" + this.a + ", mRevision=" + this.b + ", mNumWatchers=" + this.c + ", mLastMsgID=" + this.d + ", mLastMediaType=" + this.e + ", mLastMsgText='" + this.f + '\'' + ", mSenderEncryptedPhone='" + this.g + '\'' + ", mSenderName='" + this.h + '\'' + ", mSenderPhotoId='" + this.i + '\'' + ", mLastTokenOfMsgs=" + this.j + ", mLastTimestampOfMsgs=" + this.k + ", mGroupRole=" + this.l + ", mUserSubscribeState=" + this.m + ", mGroupType=" + this.n + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.entity.c
 * JD-Core Version:    0.6.2
 */