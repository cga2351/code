package com.viber.voip.messages.controller;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.ArraySet;
import com.google.d.f;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.community.search.CommunitySearchResult;
import com.viber.voip.util.cj;
import com.viber.voip.util.dd;
import com.viber.voip.util.http.OkHttpClientFactory;
import dagger.a;
import java.util.Iterator;
import java.util.Set;

public class r
{
  private static final Logger a = ViberEnv.getLogger();
  private final cj b;
  private final Handler c;
  private final a<f> d;
  private final String e;
  private final OkHttpClientFactory f;
  private final Set<String> g = new ArraySet();

  public r(cj paramcj, Handler paramHandler, a<f> parama, String paramString, OkHttpClientFactory paramOkHttpClientFactory)
  {
    this.b = paramcj;
    this.c = paramHandler;
    this.d = parama;
    this.e = paramString;
    this.f = paramOkHttpClientFactory;
  }

  private void a(String paramString, int paramInt, a parama, CommunitySearchResult paramCommunitySearchResult, boolean paramBoolean)
  {
    dd.a(new t(this, paramString, paramCommunitySearchResult, parama, paramBoolean, paramInt));
  }

  private boolean a(String paramString, a parama)
  {
    boolean bool1 = b();
    boolean bool2 = false;
    if (!bool1)
    {
      a(paramString, 0, parama, null, false);
      bool2 = true;
    }
    return bool2;
  }

  private boolean b()
  {
    return this.b.a() != -1;
  }

  public void a()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.c.removeCallbacksAndMessages(str);
    }
    this.g.clear();
  }

  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, a parama)
  {
    if (paramString.length() < paramInt3)
      parama.a(paramString, b());
    while ((a(paramString, parama)) || (this.g.contains(paramString)))
      return;
    this.g.add(paramString);
    this.c.postAtTime(new s(this, paramString, parama, paramInt2, paramInt1), paramString, SystemClock.uptimeMillis());
  }

  public static abstract interface a
  {
    public abstract void a(String paramString, CommunitySearchResult paramCommunitySearchResult, boolean paramBoolean);

    public abstract void a(String paramString, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.r
 * JD-Core Version:    0.6.2
 */