package com.viber.voip.market.a.a;

import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.i;
import java.util.List;

public class b
  implements g.a, com.viber.voip.stickers.e.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final i b;
  private final f c;
  private final h d;
  private boolean e;
  private boolean f;

  public b(i parami, f paramf, h paramh)
  {
    this.b = parami;
    this.c = paramf;
    this.d = paramh;
  }

  public void a()
  {
    this.f = false;
    if (this.e)
    {
      a(this.b.i());
      this.e = false;
    }
  }

  public void a(View paramView, int paramInt)
  {
    this.f = true;
  }

  public void a(List<com.viber.voip.stickers.entity.a> paramList)
  {
    this.c.a(paramList);
    this.d.notifyDataSetChanged();
  }

  public void onStickerPackageChanged(List<com.viber.voip.stickers.entity.a> paramList1, List<com.viber.voip.stickers.entity.a> paramList2)
  {
    if ((this.c != null) && (this.b != null) && (this.d != null))
    {
      if (!this.f)
        a(paramList2);
    }
    else
      return;
    this.e = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.a.a.b
 * JD-Core Version:    0.6.2
 */