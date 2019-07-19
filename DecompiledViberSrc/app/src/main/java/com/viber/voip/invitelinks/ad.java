package com.viber.voip.invitelinks;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.h;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.util.ViberActionRunner;

public class ad
{
  private static final Logger a = ViberEnv.getLogger();
  protected final Context i;
  protected final ab j;
  protected final Handler k;
  protected final long l;
  protected final int m;

  public ad(Context paramContext, ab paramab, Handler paramHandler, long paramLong, int paramInt)
  {
    this.i = paramContext;
    this.j = paramab;
    this.k = paramHandler;
    this.l = paramLong;
    this.m = paramInt;
  }

  protected void c(h paramh)
  {
    d(paramh);
  }

  protected void d(h paramh)
  {
    Intent localIntent = m.a(paramh.getId(), paramh.j(), paramh.R(), paramh.aj(), paramh.ao(), false);
    localIntent.putExtra("community_view_source", this.m);
    ViberActionRunner.b(this.i, localIntent);
  }

  protected void e()
  {
    k.n().d();
  }

  public void h()
  {
    this.k.post(new Runnable()
    {
      public void run()
      {
        h localh = ad.this.j.b(ad.this.l);
        if (localh != null)
        {
          ad.this.c(localh);
          return;
        }
        ad.this.e();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.ad
 * JD-Core Version:    0.6.2
 */