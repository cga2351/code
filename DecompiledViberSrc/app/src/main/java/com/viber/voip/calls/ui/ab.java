package com.viber.voip.calls.ui;

import android.content.Context;
import android.view.View;
import com.viber.voip.R.attr;
import com.viber.voip.ViberApplication;
import com.viber.voip.ui.h.b;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public abstract class ab<M, I extends View, VH extends ac<M, I>> extends b<M, VH>
{
  protected final Context a;
  protected final boolean b;
  protected final a c;
  protected final e d;
  protected final f e;
  protected final boolean f;
  protected final int g;
  protected final int h;

  public ab(Context paramContext, boolean paramBoolean, a parama, e parame, f paramf)
  {
    this.a = paramContext;
    this.b = paramBoolean;
    this.c = parama;
    this.d = parame;
    this.e = paramf;
    this.f = ViberApplication.isTablet(paramContext);
    this.h = dc.d(this.a, R.attr.textPrimaryColor);
    this.g = dc.d(this.a, R.attr.callsRecentItemTypeMissedColor);
  }

  public static abstract interface a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.ab
 * JD-Core Version:    0.6.2
 */