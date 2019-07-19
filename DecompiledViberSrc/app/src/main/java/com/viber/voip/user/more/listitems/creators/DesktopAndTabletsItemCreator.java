package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.a.a;
import com.viber.voip.settings.a.a.b;

public class DesktopAndTabletsItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;

  public DesktopAndTabletsItemCreator(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public a create()
  {
    a.b localb = new a.b(this.mContext, R.id.desktop_and_tablets).a(R.string.more_desktop_and_tablets).c(R.drawable.more_viber_for_desktop_icon);
    if (!ao.f());
    for (boolean bool = true; ; bool = false)
      return localb.a(bool).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.DesktopAndTabletsItemCreator
 * JD-Core Version:    0.6.2
 */