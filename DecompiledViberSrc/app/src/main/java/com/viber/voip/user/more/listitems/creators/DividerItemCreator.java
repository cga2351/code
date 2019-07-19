package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.id;
import com.viber.voip.settings.a.a;
import com.viber.voip.settings.a.a.b;

public class DividerItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;

  public DividerItemCreator(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public a create()
  {
    return new a.b(this.mContext, R.id.more_section_separator, 1).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.DividerItemCreator
 * JD-Core Version:    0.6.2
 */