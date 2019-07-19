package com.viber.voip.messages.conversation;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.dexshared.Logger;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.util.cl;
import dagger.a;

public class i
  implements d.a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final a b = (a)cl.b(a.class);
  private boolean c;
  private final h d = new h(paramContext, paramLoaderManager, parama, this);
  private a e = b;

  public i(Context paramContext, LoaderManager paramLoaderManager, a<bv> parama)
  {
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean == this.c)
      return;
    this.c = paramBoolean;
    if (this.c)
    {
      this.d.p();
      return;
    }
    this.d.q();
  }

  public void a()
  {
    this.e = b;
    a(false);
    this.d.j();
  }

  public void a(a parama)
  {
    this.e = parama;
  }

  public void a(String paramString)
  {
    this.d.f(paramString);
    this.d.i();
    a(true);
  }

  public long b()
  {
    Long localLong = this.d.e(0);
    if (localLong != null)
      return localLong.longValue();
    return 0L;
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    this.e.a(b());
  }

  public void onLoaderReset(d paramd)
  {
  }

  public static abstract interface a
  {
    public abstract void a(long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.i
 * JD-Core Version:    0.6.2
 */