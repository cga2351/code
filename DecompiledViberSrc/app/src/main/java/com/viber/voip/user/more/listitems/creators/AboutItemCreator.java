package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.settings.a.a;
import com.viber.voip.settings.a.a.b;

public class AboutItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;

  public AboutItemCreator(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public a create()
  {
    return new a.b(this.mContext, R.id.about).a(R.string.more_tab_about_title).c(R.drawable.more_about_icon).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.AboutItemCreator
 * JD-Core Version:    0.6.2
 */