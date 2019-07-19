package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.common.d.c;
import com.viber.voip.R.string;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.ca;

class w extends a
{
  w(Context paramContext, m paramm, dagger.a<aj> parama, h paramh)
  {
    super(paramContext, paramm, parama, paramh);
  }

  private String c(String paramString1, String paramString2)
  {
    Context localContext = this.a;
    int i = R.string.message_notification_vote_text_with_question;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = ca.a(paramString1, "");
    arrayOfObject[1] = ca.a(paramString2, "");
    return c.a(localContext, i, arrayOfObject);
  }

  public e a(boolean paramBoolean)
  {
    return new e(this.g, c(this.f, this.i), c(this.h, this.i), null, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.w
 * JD-Core Version:    0.6.2
 */