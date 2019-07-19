package com.viber.voip.messages.ui;

import com.viber.common.b.d;
import com.viber.voip.settings.d.bl;
import com.viber.voip.sound.ptt.PttUtils;

public class cm
{
  private static final int c = (int)PttUtils.MAX_PTT_DURATION_IN_MS / 1000;
  private static final int d = -5 + c;
  private static final int e = c;
  private static final int f = d;
  public final int a;
  public final int b;

  public cm()
  {
    this(c, d);
  }

  public cm(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public static cm a()
  {
    return new cm(e, f);
  }

  public static cm b()
  {
    return new cm(d.bl.e.d() / 1000, (-5000 + d.bl.e.d()) / 1000);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.cm
 * JD-Core Version:    0.6.2
 */