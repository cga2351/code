package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;

public final class eg<T extends View,  extends gb.a>
{
  private final T a;
  private final Handler b;
  private final ef c;
  private final eh d;
  private Runnable e;

  public eg(T paramT, ef paramef, eh parameh)
  {
    this.a = paramT;
    this.c = paramef;
    this.d = parameh;
    this.b = new Handler(Looper.getMainLooper());
  }

  public final void a()
  {
    if (this.e == null)
    {
      this.e = new a(this.a, this.d, this.b, this.c);
      this.b.post(this.e);
    }
  }

  public final void b()
  {
    this.b.removeCallbacksAndMessages(null);
    this.e = null;
  }

  static final class a<T extends View,  extends gb.a>
    implements Runnable
  {
    private final WeakReference<eh> a;
    private final WeakReference<T> b;
    private final Handler c;
    private final ef d;

    a(T paramT, eh parameh, Handler paramHandler, ef paramef)
    {
      this.b = new WeakReference(paramT);
      this.a = new WeakReference(parameh);
      this.c = paramHandler;
      this.d = paramef;
    }

    public final void run()
    {
      View localView = (View)this.b.get();
      eh localeh = (eh)this.a.get();
      if ((localView != null) && (localeh != null))
      {
        localeh.a(ef.a(localView));
        this.c.postDelayed(this, 200L);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.eg
 * JD-Core Version:    0.6.2
 */