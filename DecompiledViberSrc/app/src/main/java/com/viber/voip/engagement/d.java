package com.viber.voip.engagement;

import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.OnlineContactInfo;
import com.viber.voip.ViberEnv;
import com.viber.voip.user.OnlineUserActivityHelper.UiOnlineUserInfoDelegate;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
  implements OnlineUserActivityHelper.UiOnlineUserInfoDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private final int b;
  private final List<String> c;
  private final CountDownLatch d;
  private final a e;
  private AtomicBoolean f = new AtomicBoolean(false);

  public d(int paramInt, List<String> paramList, CountDownLatch paramCountDownLatch, a parama)
  {
    this.b = paramInt;
    this.c = paramList;
    this.d = paramCountDownLatch;
    this.e = parama;
  }

  public List<String> a()
  {
    this.f.set(true);
    synchronized (this.c)
    {
      List localList2 = this.c;
      return localList2;
    }
  }

  public void onOnlineStatusActivityReady(int paramInt, OnlineContactInfo[] paramArrayOfOnlineContactInfo)
  {
    if ((paramInt != this.b) || (this.f.get()))
      return;
    while (true)
    {
      int j;
      synchronized (this.c)
      {
        int i = paramArrayOfOnlineContactInfo.length;
        j = 0;
        if (j < i)
        {
          OnlineContactInfo localOnlineContactInfo = paramArrayOfOnlineContactInfo[j];
          if ((this.e.a(localOnlineContactInfo)) && (!TextUtils.isEmpty(localOnlineContactInfo.memberId)))
            this.c.add(localOnlineContactInfo.memberId);
        }
        else
        {
          this.d.countDown();
          return;
        }
      }
      j++;
    }
  }

  public static abstract interface a
  {
    public abstract boolean a(OnlineContactInfo paramOnlineContactInfo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d
 * JD-Core Version:    0.6.2
 */