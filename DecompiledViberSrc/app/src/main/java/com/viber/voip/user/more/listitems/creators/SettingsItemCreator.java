package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.notif.f;
import com.viber.voip.settings.a.a.b;

public class SettingsItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;
  private final dagger.a<f> mNotificationManager;

  public SettingsItemCreator(Context paramContext, dagger.a<f> parama)
  {
    this.mContext = paramContext;
    this.mNotificationManager = parama;
  }

  public com.viber.voip.settings.a.a create()
  {
    return new a.b(this.mContext, R.id.settings).a(R.string.pref_settings_title).c(R.drawable.more_settings_icon).c(new SettingsItemCreator..Lambda.0(this)).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.SettingsItemCreator
 * JD-Core Version:    0.6.2
 */