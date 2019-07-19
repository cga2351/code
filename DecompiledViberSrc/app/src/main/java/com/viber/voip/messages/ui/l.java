package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseIntArray;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.n;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;
import com.viber.voip.util.e.j.a;

public class l
{
  protected static final Logger a = ViberEnv.getLogger();
  private com.viber.voip.messages.extensions.ui.c b;
  private boolean c = false;
  private boolean d = false;
  private final Context e;
  private final Resources f;
  private final com.viber.voip.messages.extensions.c g;

  public l(Context paramContext, com.viber.voip.messages.extensions.c paramc)
  {
    this.e = paramContext;
    this.f = paramContext.getResources();
    this.g = paramc;
  }

  private void a(String paramString)
  {
    int i = this.b.b(paramString);
    if (-1 == i);
    int j;
    int k;
    do
    {
      do
      {
        return;
        j = j.a(this.e, j.a.a);
      }
      while (j <= 0);
      k = this.b.getItemCount();
    }
    while (k <= 0);
    int m = this.f.getDimensionPixelSize(R.dimen.keyboard_extension_filter_item_width);
    int n = m * (k - i);
    int i7;
    int i8;
    if (n < j)
    {
      int i6 = j - n;
      i7 = i - i6 / m;
      if (i6 % m > 0)
        i8 = 1;
    }
    for (int i1 = i7 - i8; ; i1 = i)
    {
      int i2 = Math.max(0, i1);
      int i3 = Math.min(i2 + j / m, k - 1);
      SparseIntArray localSparseIntArray = new SparseIntArray(1 + (i3 - i2));
      int i4 = 0;
      int i5 = i2;
      while (true)
        if (i5 <= i3)
        {
          if (i != i5)
          {
            i4 = (int)(200L + i4);
            localSparseIntArray.put(i5, i4);
          }
          i5++;
          continue;
          i8 = 0;
          break;
        }
      this.b.a(localSparseIntArray);
      return;
    }
  }

  private void a(boolean paramBoolean)
  {
    if (this.c)
    {
      this.c = false;
      this.b.a(this.g.c());
      if (!paramBoolean)
        this.b.notifyDataSetChanged();
    }
    while (!paramBoolean)
      return;
    this.b.a(this.g.c());
  }

  private void b(boolean paramBoolean, String paramString)
  {
    if ((this.d) && (b()));
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
      {
        this.d = false;
        a(paramString);
      }
      return;
    }
  }

  private boolean b()
  {
    return (!ViberApplication.isTablet(this.e)) && (!dj.c(this.e)) && (d.n.a.d());
  }

  void a()
  {
    this.c = true;
    this.d = b();
  }

  void a(com.viber.voip.messages.extensions.ui.c paramc)
  {
    this.b = paramc;
  }

  void a(boolean paramBoolean, String paramString)
  {
    if (this.b == null)
      return;
    a(paramBoolean);
    b(paramBoolean, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.l
 * JD-Core Version:    0.6.2
 */