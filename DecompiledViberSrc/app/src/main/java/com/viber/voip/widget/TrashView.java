package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.TimeAware.Clock;
import com.viber.voip.ViberEnv;

public class TrashView extends ag
  implements ag.c.a
{
  private static final Logger c = ViberEnv.getLogger();
  private ag.g d;
  private a e;
  private Runnable f;

  public TrashView(Context paramContext)
  {
    super(paramContext);
    b();
  }

  public TrashView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }

  public TrashView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }

  private void a(a parama)
  {
    if (this.e != parama)
    {
      this.a[0] = this.d;
      TimeAware.Clock localClock = b(parama);
      if ((localClock instanceof ag.c))
      {
        ag.c localc = (ag.c)localClock;
        localc.b();
        localc.a(this);
      }
      this.a[0].setClock(localClock);
      this.e = parama;
      invalidate();
    }
  }

  private TimeAware.Clock b(a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      return new ag.f(0.44D);
    case 1:
    }
    return new ag.c(0.44D, 1.0D);
  }

  private void b()
  {
    this.d = new ag.g("svg/trash_icon.svg");
    a(a.a);
  }

  public void a()
  {
    a(a.b);
  }

  public void onAnimationEnd()
  {
    a(a.a);
    if (this.f != null)
      this.f.run();
  }

  public void setAnimationEndCallback(Runnable paramRunnable)
  {
    this.f = paramRunnable;
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.TrashView
 * JD-Core Version:    0.6.2
 */