package com.viber.voip.p;

import android.content.Context;
import android.os.Handler;
import com.viber.voip.av.e;

class d extends a
  implements e.a
{
  private boolean c = false;

  d(Context paramContext)
  {
    a(new e(paramContext, this));
  }

  public void onProximityChanged(boolean paramBoolean)
  {
    if (paramBoolean == this.c);
    final a.a locala;
    do
    {
      return;
      this.c = paramBoolean;
      locala = a();
    }
    while (locala == null);
    av.e.a.a().post(new Runnable()
    {
      public void run()
      {
        locala.enableBlackScreen(d.a(d.this));
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.p.d
 * JD-Core Version:    0.6.2
 */