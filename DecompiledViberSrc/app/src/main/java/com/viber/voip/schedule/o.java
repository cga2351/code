package com.viber.voip.schedule;

import android.content.Context;
import com.viber.common.b.d;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.l.f;
import com.viber.voip.market.a;
import com.viber.voip.settings.d.ax;

public class o extends a
{
  o(Context paramContext, d.a parama)
  {
    super(paramContext, parama);
  }

  protected String a()
  {
    return "com.viber.voip.stickers.notification.UPDATE_STICKER_PACKAGES_COUNT_ACTION";
  }

  protected String b()
  {
    return "on_sticker_market_opened";
  }

  protected d c()
  {
    return d.ax.n;
  }

  protected d d()
  {
    return d.ax.o;
  }

  protected void e()
  {
    g.a().a(f.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.o
 * JD-Core Version:    0.6.2
 */