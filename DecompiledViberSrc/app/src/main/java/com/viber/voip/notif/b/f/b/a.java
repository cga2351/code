package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.common.d.c;
import com.viber.voip.R.string;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.ca;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;

abstract class a
  implements g
{
  final Context a;
  final m b;
  final boolean c;
  final boolean d;
  final String e;
  final String f;
  final CharSequence g;
  final String h;
  final String i;
  final String j;

  a(Context paramContext, m paramm, dagger.a<aj> parama, h paramh)
  {
    this.a = paramContext;
    this.b = paramm;
    this.c = paramm.e().b();
    this.d = paramm.c().hasQuote();
    this.e = dg.b(paramm.e().o());
    this.f = dg.a(paramm.d(), paramm.e().j(), paramm.e().p());
    String str1;
    if (this.c)
    {
      str1 = this.e;
      this.g = str1;
      this.h = c(this.f, this.e);
      this.i = da.a((aj)parama.get(), paramh.a(this.a, this.b));
      if (!da.a(this.b.c().getDescription()))
        break label190;
    }
    label190: for (String str2 = null; ; str2 = da.a((aj)parama.get(), c.a(this.b.c().getDescription())))
    {
      this.j = str2;
      return;
      str1 = this.f;
      break;
    }
  }

  private String c(String paramString1, String paramString2)
  {
    Context localContext = this.a;
    int k = R.string.message_notification_user_in_group;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = ca.a(paramString1, "");
    arrayOfObject[1] = ca.a(paramString2, "");
    return c.a(localContext, k, arrayOfObject);
  }

  String a(String paramString1, String paramString2)
  {
    return c.a(ca.a(paramString1, "")) + ": " + c.a(ca.a(paramString2, ""));
  }

  String b(String paramString1, String paramString2)
  {
    Context localContext = this.a;
    int k = R.string.reply_notification_body;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = ca.a(paramString1, "");
    arrayOfObject[1] = ca.a(paramString2, "");
    return c.a(localContext, k, arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.a
 * JD-Core Version:    0.6.2
 */