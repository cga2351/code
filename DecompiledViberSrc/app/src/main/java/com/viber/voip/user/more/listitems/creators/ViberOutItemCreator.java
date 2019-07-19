package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.settings.a.a;
import com.viber.voip.settings.a.a.b;
import com.viber.voip.user.more.listitems.providers.ViberOutInfoProvider;

public class ViberOutItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;
  private final ViberOutInfoProvider mViberOutInfoProvider;

  public ViberOutItemCreator(Context paramContext, ViberOutInfoProvider paramViberOutInfoProvider)
  {
    this.mContext = paramContext;
    this.mViberOutInfoProvider = paramViberOutInfoProvider;
  }

  public a create()
  {
    return new a.b(this.mContext, R.id.viber_out).a(R.string.viber_out).c(R.drawable.more_viber_out_icon).b(this.mViberOutInfoProvider).d(this.mViberOutInfoProvider).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.ViberOutItemCreator
 * JD-Core Version:    0.6.2
 */