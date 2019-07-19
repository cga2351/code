package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.settings.a.a.b;

public class RakutenItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;
  private final com.viber.voip.rakuten.a mRakutenController;

  public RakutenItemCreator(Context paramContext, com.viber.voip.rakuten.a parama)
  {
    this.mContext = paramContext;
    this.mRakutenController = parama;
  }

  public com.viber.voip.settings.a.a create()
  {
    return new a.b(this.mContext, R.id.rakuten_account).a(R.string.rakuten_connect_title).c(R.drawable.more_rakuten_icon).a(this.mRakutenController.b()).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.RakutenItemCreator
 * JD-Core Version:    0.6.2
 */