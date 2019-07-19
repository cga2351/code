package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.widget.Button;
import android.widget.PopupMenu;
import com.yandex.mobile.ads.nativeads.af;
import com.yandex.mobile.ads.nativeads.aj;
import com.yandex.mobile.ads.nativeads.q;
import java.util.List;

public final class nj
{
  private final bz a;
  private final af b;
  private final ni c;
  private final q d;

  public nj(bz parambz, af paramaf, q paramq)
  {
    this.a = parambz;
    this.b = paramaf;
    this.d = paramq;
    this.c = new ni();
  }

  public final void a(Context paramContext, lq paramlq)
  {
    Button localButton = this.b.c().h();
    List localList;
    if ((localButton != null) && (Build.VERSION.SDK_INT >= 11))
    {
      localList = paramlq.b();
      if (localList.isEmpty());
    }
    try
    {
      cj localcj = new cj(paramContext);
      if (Build.VERSION.SDK_INT >= 19);
      for (PopupMenu localPopupMenu = new PopupMenu(paramContext, localButton, 5); ; localPopupMenu = new PopupMenu(paramContext, localButton))
      {
        Menu localMenu = localPopupMenu.getMenu();
        for (int i = 0; i < localList.size(); i++)
          localMenu.add(0, i, 0, ((lq.a)localList.get(i)).a());
      }
      localPopupMenu.setOnMenuItemClickListener(new nk(paramContext, localcj, localList, this.a, this.d));
      localPopupMenu.show();
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.nj
 * JD-Core Version:    0.6.2
 */