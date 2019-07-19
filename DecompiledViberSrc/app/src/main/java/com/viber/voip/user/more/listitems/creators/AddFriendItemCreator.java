package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.a.a;
import com.viber.voip.settings.a.a.b;

public class AddFriendItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;

  public AddFriendItemCreator(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public a create()
  {
    a.b localb = new a.b(this.mContext, R.id.add_friend).a(R.string.more_add_contact).c(R.drawable.more_add_contact_icon);
    if (!ao.f());
    for (boolean bool = true; ; bool = false)
      return localb.a(bool).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.AddFriendItemCreator
 * JD-Core Version:    0.6.2
 */