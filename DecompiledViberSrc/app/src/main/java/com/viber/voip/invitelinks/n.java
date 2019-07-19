package com.viber.voip.invitelinks;

import com.viber.jni.group.GroupInfoListener;
import org.greenrobot.eventbus.EventBus;

public abstract interface n extends p
{
  public abstract void a(long paramLong);

  public abstract void a(long paramLong, String paramString);

  public abstract void a(GroupInfoListener paramGroupInfoListener, EventBus paramEventBus);

  public abstract void a(String paramString);

  public static class a
  {
    public final long a;
    public final int b;
    public final String c;

    public a(long paramLong, int paramInt, String paramString)
    {
      this.a = paramLong;
      this.b = paramInt;
      this.c = paramString;
    }

    public String toString()
    {
      return "GroupInviteAccepted{groupId=" + this.a + ", status=" + this.b + ", groupLink='" + this.c + '\'' + '}';
    }
  }

  public static class b
  {
    public final long a;
    public final int b;
    public final int c;
    public final String d;
    public final boolean e;

    public b(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
    {
      this.a = paramLong;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramString;
      this.e = paramBoolean;
    }

    public String toString()
    {
      return "GroupLinkReceived{groupId=" + this.a + ", operation=" + this.b + ", status=" + this.c + ", link='" + this.d + '\'' + ", revoked=" + this.e + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.n
 * JD-Core Version:    0.6.2
 */