package com.viber.voip.messages.conversation.ui;

import android.content.res.Resources;
import com.viber.voip.registration.o;

public class ck
{
  private String a;
  private int b;
  private boolean c;

  public ck(String paramString, int paramInt, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramBoolean;
  }

  public String a()
  {
    return this.a;
  }

  public String a(Resources paramResources)
  {
    return o.a(this.b, paramResources);
  }

  public boolean b()
  {
    return this.c;
  }

  public boolean c()
  {
    return (b()) && (o.a(this.b));
  }

  public String toString()
  {
    return "UserDeviceInfo{mMemberId='" + this.a + '\'' + ", mDeviceId=" + this.b + ", mIsSecondary=" + this.c + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.ck
 * JD-Core Version:    0.6.2
 */