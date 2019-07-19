package com.viber.voip.ads.b.c.a;

import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class b
{
  private final e a;
  private final f b;
  private final f c;

  public b(e parame, f paramf1, f paramf2)
  {
    this.a = parame;
    this.b = paramf1;
    this.c = paramf2;
  }

  public a<com.viber.voip.ads.b.c.c.c> a(com.viber.voip.ads.b.b.b.c paramc, ViewGroup paramViewGroup, i parami)
  {
    switch (1.a[paramc.ordinal()])
    {
    default:
      return null;
    case 1:
      return new d(paramViewGroup, parami, this.a, this.b, this.c, R.layout.view_business_inbox_ad, R.layout.view_business_inbox_ad_google_content, R.layout.view_business_inbox_ad_google_app_install);
    case 2:
      return new d(paramViewGroup, parami, this.a, this.b, this.c, R.layout.view_calls_tab_list_ad, R.layout.view_calls_tab_list_ad_google_content, R.layout.view_calls_tab_list_ad_google_app_install);
    case 3:
      return new d(paramViewGroup, parami, this.a, this.b, this.c, R.layout.view_chats_list_ad, R.layout.view_chats_list_ad_google_content, R.layout.view_chats_list_ad_google_app_install);
    case 4:
    }
    return new d(paramViewGroup, parami, this.a, this.b, this.c, R.layout.view_chats_ext_ad, R.layout.view_chats_ext_ad_google_content, R.layout.view_chats_ext_ad_google_app_install);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.a.b
 * JD-Core Version:    0.6.2
 */