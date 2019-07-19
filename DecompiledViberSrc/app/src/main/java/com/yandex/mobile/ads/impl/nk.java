package com.yandex.mobile.ads.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MenuItem;
import android.widget.PopupMenu.OnMenuItemClickListener;
import com.yandex.mobile.ads.nativeads.q;
import java.util.List;

@TargetApi(11)
final class nk
  implements PopupMenu.OnMenuItemClickListener
{
  private final Context a;
  private final bz b;
  private final cj c;
  private final List<lq.a> d;
  private final q e;

  nk(Context paramContext, cj paramcj, List<lq.a> paramList, bz parambz, q paramq)
  {
    this.d = paramList;
    this.c = paramcj;
    this.b = parambz;
    this.a = paramContext.getApplicationContext();
    this.e = paramq;
  }

  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i < this.d.size())
    {
      String str = ((lq.a)this.d.get(i)).b();
      this.c.a(str);
      this.b.a(fd.b.v);
      this.e.g();
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.nk
 * JD-Core Version:    0.6.2
 */