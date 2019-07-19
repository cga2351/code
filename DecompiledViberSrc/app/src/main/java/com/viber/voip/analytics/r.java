package com.viber.voip.analytics;

import android.support.v4.util.Pair;
import com.google.firebase.messaging.RemoteMessage;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.e;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.j;

public abstract class r
  implements p
{
  protected y a;

  public r(y paramy)
  {
    this.a = paramy;
  }

  public void a(RemoteMessage paramRemoteMessage)
  {
    this.a.a(paramRemoteMessage);
  }

  public void a(e parame)
  {
    this.a.a(parame);
  }

  public void a(f paramf, g paramg)
  {
    this.a.a(Pair.create(paramf, paramg));
  }

  public void a(j paramj)
  {
    this.a.a(paramj);
  }

  public void b(e parame)
  {
    q.a(this, parame);
  }

  public void b(j paramj)
  {
    this.a.b(paramj);
  }

  public y c()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.r
 * JD-Core Version:    0.6.2
 */