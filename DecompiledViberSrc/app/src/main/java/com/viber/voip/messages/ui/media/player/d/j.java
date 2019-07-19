package com.viber.voip.messages.ui.media.player.d;

import android.os.Handler;
import android.view.View;
import com.viber.voip.util.dj;
import java.lang.ref.WeakReference;

public class j
{
  private final Handler a;
  private final WeakReference<View> b;

  public j(Handler paramHandler, View paramView)
  {
    this.a = paramHandler;
    this.b = new WeakReference(paramView);
  }

  public void a()
  {
    dj.c((View)this.b.get(), 4);
  }

  public void b()
  {
    this.a.postDelayed(new Runnable()
    {
      public void run()
      {
        dj.c((View)j.a(j.this).get(), 0);
      }
    }
    , 500L);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.d.j
 * JD-Core Version:    0.6.2
 */