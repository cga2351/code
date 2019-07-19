package com.viber.voip.api.scheme.action;

import android.content.Context;
import android.os.Handler;
import com.viber.voip.ViberApplication;
import com.viber.voip.apps.b;
import com.viber.voip.apps.h;
import com.viber.voip.apps.h.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.user.UserManager;
import java.util.ArrayList;
import java.util.List;

public class e extends f
{
  private int f;
  private a g;

  public e(int paramInt, a parama)
  {
    this.f = paramInt;
    this.g = parama;
  }

  public void a(Context paramContext, final c.a parama)
  {
    av.a(av.e.g).post(new Runnable()
    {
      public void run()
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(Integer.valueOf(e.a(e.this)));
        UserManager.from(ViberApplication.getApplication()).getAppsController().a(localArrayList, true, new h.a()
        {
          public void onAppInfoFailed()
          {
            if (e.b(e.this) != null)
              e.b(e.this).a();
            e.1.this.a.b();
          }

          public void onAppInfoReady(List<b> paramAnonymous2List, boolean paramAnonymous2Boolean)
          {
            if (e.b(e.this) != null)
            {
              if (!paramAnonymous2List.isEmpty())
                break label52;
              e.b(e.this).a(null, paramAnonymous2Boolean);
            }
            while (true)
            {
              e.1.this.a.b();
              return;
              label52: e.b(e.this).a((b)paramAnonymous2List.get(0), paramAnonymous2Boolean);
            }
          }
        });
      }
    });
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(b paramb, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.e
 * JD-Core Version:    0.6.2
 */