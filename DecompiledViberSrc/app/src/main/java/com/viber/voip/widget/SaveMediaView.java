package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.TimeAware.Clock;
import com.viber.voip.ViberEnv;

public class SaveMediaView extends ag
  implements ag.c.a
{
  private static final Logger c = ViberEnv.getLogger();
  private ag.g d;
  private a e;

  public SaveMediaView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public SaveMediaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public SaveMediaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    this.e = a.a;
    this.d = new ag.g("svg/preview_save_to_gallery_icon.svg");
  }

  private void b(a parama)
  {
    if (this.e != parama)
    {
      this.a[0] = this.d;
      TimeAware.Clock localClock = c(parama);
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

  private TimeAware.Clock c(a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      return null;
    case 1:
      return new ag.f(0.35D);
    case 2:
      return new ag.f(0.64D);
    case 3:
      return new ag.e(0.35D, 0.29D);
    case 4:
    }
    return new ag.c(0.35D, 0.29D);
  }

  protected a a(a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      return null;
    case 4:
      return a.c;
    case 3:
    }
    return a.b;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (a locala = a.e; ; locala = a.b)
    {
      b(locala);
      return;
    }
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean);
    for (a locala = a.d; ; locala = a.c)
    {
      b(locala);
      return;
    }
  }

  public void onAnimationEnd()
  {
    a locala = a(this.e);
    if (locala != null)
    {
      this.e = a.a;
      b(locala);
    }
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.SaveMediaView
 * JD-Core Version:    0.6.2
 */