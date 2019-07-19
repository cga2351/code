package com.viber.voip.messages.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.df;
import com.viber.voip.widget.ag;
import com.viber.voip.widget.ag.b;
import com.viber.voip.widget.ag.f;
import com.viber.voip.widget.ag.g;

public class AnimatedSoundIconView extends ag
{
  private static Logger c = ViberEnv.getLogger();
  private final ag.g d = new ag.g("svg/sound_icon.svg");
  private int e;
  private int f;

  public AnimatedSoundIconView(Context paramContext)
  {
    super(paramContext);
    d();
  }

  public AnimatedSoundIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }

  public AnimatedSoundIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }

  private void d()
  {
    this.e = df.a(null, getContext(), R.color.sent_via_dark).intValue();
    this.f = df.a(null, getContext(), R.color.sent_via_light).intValue();
  }

  public void a()
  {
    this.a[0] = this.d;
    this.a[0].setClock(new ag.b(this.a[0].a()));
    this.a[0].a(this.e);
    invalidate();
  }

  public void a(boolean paramBoolean)
  {
    this.a[0] = this.d;
    this.a[0].setClock(new ag.f(1.5D));
    ag.g localg = this.a[0];
    if (paramBoolean);
    for (int i = this.f; ; i = this.e)
    {
      localg.a(i);
      invalidate();
      return;
    }
  }

  public void b()
  {
    this.a[0] = this.d;
    this.a[0].setClock(new ag.b(this.a[0].a()));
    this.a[0].a(this.f);
    invalidate();
  }

  public void c()
  {
    this.a[0] = null;
    invalidate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.view.AnimatedSoundIconView
 * JD-Core Version:    0.6.2
 */