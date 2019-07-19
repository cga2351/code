package com.viber.voip.notif.b.f.b;

import android.content.Context;
import android.text.SpannableString;
import com.viber.voip.R.string;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.da;
import dagger.a;

class m
  implements h
{
  private final a<ai> a;
  private final a<b> b;

  m(a<ai> parama, a<b> parama1)
  {
    this.a = parama;
    this.b = parama1;
  }

  public String a(Context paramContext, com.viber.voip.notif.h.m paramm)
  {
    com.viber.voip.model.entity.h localh = paramm.e();
    SpannableString localSpannableString = da.a(paramm.c().getBody(), (ai)this.a.get(), (b)this.b.get(), paramm.c().getSpans(), false, false, false, false, aj.b, localh.j(), localh.p());
    if (da.a(localSpannableString))
      return paramContext.getString(R.string.message);
    return localSpannableString.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.m
 * JD-Core Version:    0.6.2
 */