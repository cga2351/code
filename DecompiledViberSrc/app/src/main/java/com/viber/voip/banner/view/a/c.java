package com.viber.voip.banner.view.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.banner.d.g;
import com.viber.voip.banner.datatype.Banner;
import com.viber.voip.banner.datatype.BannerItem;
import com.viber.voip.banner.datatype.BannerItem.Type;
import com.viber.voip.banner.datatype.DismissBannerItem;
import com.viber.voip.banner.datatype.ImageBannerItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c extends a<a>
{
  private static final Logger b = ViberEnv.getLogger();
  private long c;

  public c(Context paramContext)
  {
    super(paramContext);
  }

  public static c b(Context paramContext)
  {
    return new c(paramContext);
  }

  public void a(com.viber.voip.banner.d.f paramf, a parama)
  {
    this.c = paramf.b();
    com.viber.voip.banner.view.f localf = paramf.a().b(this.a);
    localf.setRemoteBanner(paramf);
    localf.setTag(paramf.e());
    a(paramf.c(), parama, localf);
  }

  protected void a(Banner paramBanner)
  {
    if (paramBanner == null)
      return;
    if (paramBanner.getItems() == null)
      paramBanner.setItems(new ArrayList());
    List localList = paramBanner.getItems();
    int i = 0;
    label30: int j;
    if (i < localList.size())
      if (((BannerItem)localList.get(i)).getType() == BannerItem.Type.DISMISS_BUTTON)
        if (i == 0)
          j = 1;
    label66: for (int k = 1; ; k = 0)
    {
      if (k != 0)
      {
        if (j != 0)
          ((BannerItem)localList.get(0)).setMargins(DismissBannerItem.MARGINS_WHEN_ON_LEFT);
        label95: if ((localList.size() != 4) || (((BannerItem)localList.get(0)).getType() != BannerItem.Type.DISMISS_BUTTON) || (((BannerItem)localList.get(1)).getType() != BannerItem.Type.IMAGE) || (((BannerItem)localList.get(2)).getType() != BannerItem.Type.TEXT) || (((BannerItem)localList.get(3)).getType() != BannerItem.Type.BUTTON))
          break label305;
      }
      for (int m = 1; ; m = 0)
      {
        if (m != 0)
        {
          ((BannerItem)localList.get(0)).setMargins(DismissBannerItem.MARGINS_WHEN_4_ITEMS);
          ((BannerItem)localList.get(1)).setMargins(ImageBannerItem.MARGINS_WHEN_4_ITEMS);
        }
        if ((localList.size() == 1) && (((BannerItem)localList.get(0)).getType() == BannerItem.Type.DISMISS_BUTTON) && (k == 0))
          localList.add(0, Banner.BLANK_BANNER_ITEM);
        if (!com.viber.common.d.c.a())
          break;
        Collections.reverse(localList);
        return;
        j = 0;
        break label66;
        i++;
        break label30;
        localList.add(new DismissBannerItem());
        break label95;
      }
      j = 0;
    }
  }

  protected void e()
  {
    super.e();
    if (b() != null)
      ((a)b()).onRemoteBannerReady(this.c, (com.viber.voip.banner.view.f)c());
  }

  protected void f()
  {
    super.f();
    if (b() != null)
      ((a)b()).onRemoteBannerError(this.c, (com.viber.voip.banner.view.f)c(), 2);
  }

  protected void g()
  {
    super.g();
    if (b() != null)
      ((a)b()).onRemoteBannerError(this.c, (com.viber.voip.banner.view.f)c(), 1);
  }

  public static abstract interface a
  {
    public abstract void onRemoteBannerError(long paramLong, com.viber.voip.banner.view.f paramf, int paramInt);

    public abstract void onRemoteBannerReady(long paramLong, com.viber.voip.banner.view.f paramf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.view.a.c
 * JD-Core Version:    0.6.2
 */