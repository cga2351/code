package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class PlayableImageView extends ag
{
  private static Logger c = ViberEnv.getLogger();
  private final ag.g d = new ag.g("svg/media-loader.svg");
  private final ag.g e = new ag.g("svg/media-loaderinfinite.svg");
  private final ag.g f = new ag.g("svg/media-x2play.svg");
  private final ag.g g = new ag.g("svg/media-download2pause.svg");
  private final ag.g h = new ag.g("svg/media-pause2download.svg");
  private final ag.g i = new ag.g("svg/media-retry2x.svg");
  private final ag.g j = new ag.g("svg/media-play.svg");
  private final ag.g k = new ag.g("svg/media-pause2play.svg");

  public PlayableImageView(Context paramContext)
  {
    super(paramContext);
  }

  public PlayableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PlayableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a()
  {
    this.a[0] = null;
    invalidate();
  }

  public void a(double paramDouble)
  {
    if (this.a[(-1 + this.a.length)] != this.d)
    {
      this.a[(-1 + this.a.length)] = this.d;
      this.d.setClock(new ag.d(this.d.a()));
    }
    ((ag.d)this.d.b()).b(paramDouble);
    invalidate();
  }

  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) || ((this.a[0] != this.k) && (this.a[0] != this.f)))
    {
      this.a[0] = this.j;
      if (!paramBoolean)
        break label104;
      this.a[0].setClock(new ag.c(this.a[0].a()));
    }
    while (true)
    {
      invalidate();
      return;
      if ((!paramBoolean) || (this.a[0] != this.i))
        break;
      this.a[0] = this.f;
      break;
      label104: this.a[0].setClock(new ag.d(this.a[0].a()).b(1.0D));
    }
  }

  public void b()
  {
    this.a[(-1 + this.a.length)] = this.e;
    this.e.setClock(b(this.e.a()));
    invalidate();
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
      if ((this.a[0] == this.h) || (this.a[0] == this.g))
      {
        this.a[0] = this.g;
        this.a[0].setClock(new ag.c(this.a[0].a()));
      }
    while (true)
    {
      invalidate();
      return;
      if ((this.a[0] == this.k) || (this.a[0] == this.j))
      {
        this.a[0] = this.k;
        this.a[0].setClock(new ag.e(this.a[0].a()));
      }
      else
      {
        this.a[0] = this.k;
        this.a[0].setClock(new ag.d(this.a[0].a()));
        continue;
        this.a[0] = this.k;
        this.a[0].setClock(new ag.d(this.a[0].a()));
      }
    }
  }

  public void c()
  {
    this.a[(-1 + this.a.length)] = null;
    invalidate();
  }

  public void c(boolean paramBoolean)
  {
    this.a[0] = this.i;
    if (paramBoolean)
      this.a[0].setClock(new ag.e(this.a[0].a()));
    while (true)
    {
      invalidate();
      return;
      this.a[0].setClock(new ag.d(this.a[0].a()));
    }
  }

  public void d(boolean paramBoolean)
  {
    if ((this.a[0] == this.g) && (paramBoolean))
    {
      this.a[0] = this.h;
      this.a[0].setClock(new ag.c(this.a[0].a()));
    }
    while (true)
    {
      invalidate();
      return;
      this.a[0] = this.g;
      this.a[0].setClock(new ag.d(this.a[0].a()));
    }
  }

  public void e(boolean paramBoolean)
  {
    if ((this.a[0] != this.i) || (!paramBoolean))
    {
      this.a[0] = this.f;
      this.a[0].setClock(new ag.d(this.a[0].a()));
    }
    while (true)
    {
      invalidate();
      return;
      this.a[0].setClock(new ag.c(this.a[0].a()));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PlayableImageView
 * JD-Core Version:    0.6.2
 */