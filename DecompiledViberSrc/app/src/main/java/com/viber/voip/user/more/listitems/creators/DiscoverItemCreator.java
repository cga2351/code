package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.settings.a.a.b;

public class DiscoverItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;
  private final com.viber.voip.publicaccount.d.a mController;

  public DiscoverItemCreator(Context paramContext, com.viber.voip.publicaccount.d.a parama)
  {
    this.mContext = paramContext;
    this.mController = parama;
  }

  public com.viber.voip.settings.a.a create()
  {
    a.b localb = new a.b(this.mContext, R.id.discover).a(R.string.more_discover_title).b(R.string.more_discover_subtitle).c(R.drawable.more_discover_icon);
    com.viber.voip.publicaccount.d.a locala = this.mController;
    locala.getClass();
    return localb.a(DiscoverItemCreator..Lambda.0.get$Lambda(locala)).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.DiscoverItemCreator
 * JD-Core Version:    0.6.2
 */