package com.viber.voip.notif.b.f.d;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.registration.af;

public class a extends d
{
  private final dagger.a<b> h;
  private final af i;
  private final String j;
  private CharSequence k;

  public a(com.viber.voip.notif.h.m paramm, dagger.a<b> parama, af paramaf, String paramString)
  {
    super(paramm);
    this.h = parama;
    this.i = paramaf;
    this.j = paramString;
  }

  private CharSequence i(Context paramContext)
  {
    if (com.viber.voip.messages.m.a(this.i, this.j))
    {
      if (com.viber.voip.messages.m.b(this.a.c().getConversationType()));
      for (int n = R.string.message_notification_you_added_as_superadmin; ; n = R.string.message_notification_you_added_as_admin)
        return paramContext.getString(n);
    }
    String str = a(this.i, this.h, paramContext, this.j, this.a.e().j(), this.a.e().p());
    if (com.viber.voip.messages.m.b(this.a.c().getConversationType()));
    for (int m = R.string.message_notification_added_as_superadmin; ; m = R.string.message_notification_added_as_admin)
      return paramContext.getString(m, new Object[] { str });
  }

  public String R_()
  {
    return "added_as_admin";
  }

  public CharSequence b(Context paramContext)
  {
    if (this.k == null)
      this.k = i(paramContext);
    return this.k;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.a
 * JD-Core Version:    0.6.2
 */