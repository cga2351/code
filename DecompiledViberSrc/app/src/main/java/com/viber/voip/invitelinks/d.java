package com.viber.voip.invitelinks;

import com.viber.jni.publicaccount.PublicAccountInfoReceiverListener;

public abstract interface d extends p
{
  public abstract void a(long paramLong, byte paramByte);

  public abstract void a(long paramLong, int paramInt);

  public abstract void a(PublicAccountInfoReceiverListener paramPublicAccountInfoReceiverListener);

  public abstract void a(String paramString);

  public abstract void b(long paramLong, int paramInt);

  public static class a
  {
    public final long a;
    public final byte b;
    public final String c;
    public final int d;

    public a(long paramLong, byte paramByte, String paramString, int paramInt)
    {
      this.a = paramLong;
      this.b = paramByte;
      this.c = paramString;
      this.d = paramInt;
    }

    public String toString()
    {
      return "DisplayInvitationLinkChanged{groupId=" + this.a + ", displayInvitationLink=" + this.b + ", invitationLink='" + this.c + '\'' + ", status=" + this.d + '}';
    }
  }

  public static class b
  {
    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final int f;
    public final int g;
    public final String h;

    public b(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, String paramString4)
    {
      this.a = paramLong1;
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramString3;
      this.e = paramLong2;
      this.f = paramInt1;
      this.g = paramInt2;
      this.h = paramString4;
    }

    public String toString()
    {
      return "FollowerInviteLinkAccepted{groupId=" + this.a + ", groupName='" + this.b + '\'' + ", iconDownloadId='" + this.c + '\'' + ", tagLine='" + this.d + '\'' + ", inviteToken=" + this.e + ", status=" + this.f + ", groupFlags=" + this.g + ", inviteLinkData='" + this.h + '\'' + '}';
    }
  }

  public static class c
  {
    public final long a;
    public final int b;
    public final int c;
    public final String d;
    public final int e;

    public c(long paramLong, int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      this.a = paramLong;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramString;
      this.e = paramInt3;
    }

    public String toString()
    {
      return "FollowerInviteLinkReceived{groupId=" + this.a + ", operation=" + this.b + ", status=" + this.c + ", link='" + this.d + '\'' + ", mainOperation=" + this.e + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.d
 * JD-Core Version:    0.6.2
 */