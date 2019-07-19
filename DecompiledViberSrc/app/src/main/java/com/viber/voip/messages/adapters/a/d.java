package com.viber.voip.messages.adapters.a;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.adapters.i;
import com.viber.voip.messages.adapters.p;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.e.f;
import com.viber.voip.widget.AvatarWithInitialsView;

public class d extends i
{
  private final com.viber.voip.util.e.e a;
  private final f b;
  private AvatarWithInitialsView c;
  private TextView d;
  private b e;

  public d(Context paramContext, View paramView, b paramb)
  {
    super(paramView);
    this.e = paramb;
    this.a = com.viber.voip.util.e.e.a(paramContext);
    this.b = f.b(paramContext);
    this.c = ((AvatarWithInitialsView)paramView.findViewById(R.id.icon));
    this.d = ((TextView)paramView.findViewById(R.id.name));
  }

  public void a(p paramp)
  {
    super.a(paramp);
    com.viber.voip.messages.conversation.e locale = (com.viber.voip.messages.conversation.e)paramp;
    m localm = this.e.b(locale.d());
    String str1 = locale.g();
    Uri localUri;
    if (localm != null)
    {
      localUri = localm.p();
      str1 = dg.a(localm, 1, 0);
    }
    while (true)
    {
      this.d.setText(str1);
      String str2 = locale.h();
      if (da.a(str2))
        this.c.a(null, false);
      while (true)
      {
        this.a.a(localUri, this.c, this.b);
        return;
        this.c.a(str2, true);
      }
      localUri = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.d
 * JD-Core Version:    0.6.2
 */