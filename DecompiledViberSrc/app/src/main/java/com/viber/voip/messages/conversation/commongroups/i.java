package com.viber.voip.messages.conversation.commongroups;

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
  implements d.a, j
{
  private static final Logger a = ViberEnv.getLogger();
  private static final a b = (a)cl.b(a.class);
  private final e c;
  private a d = b;

  public i(Context paramContext, LoaderManager paramLoaderManager, a<bv> parama, String paramString)
  {
    this.c = new e(paramContext, paramLoaderManager, parama, this, paramString);
  }

  public f a(int paramInt)
  {
    return this.c.e(paramInt);
  }

  public void a()
  {
    this.d = b;
    this.c.q();
    this.c.j();
  }

  public void a(a parama)
  {
    this.d = parama;
    this.c.p();
    this.c.i();
  }

  public int b()
  {
    return this.c.getCount();
  }

  public long b(int paramInt)
  {
    return this.c.a(paramInt);
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }

  public void onLoaderReset(d paramd)
  {
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.commongroups.i
 * JD-Core Version:    0.6.2
 */