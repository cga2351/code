package com.viber.voip.messages.adapters.a;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.messages.adapters.p;
import com.viber.voip.messages.conversation.w;
import com.viber.voip.messages.m;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.x;
import com.viber.voip.widget.AvatarWithInitialsView;

public class g extends com.viber.voip.messages.adapters.i
{
  View a;
  AvatarWithInitialsView b;
  TextView c;
  TextView d;
  ImageView e;
  View f;
  private final Context g;
  private final e h;
  private final f i;
  private final com.viber.voip.messages.i j;
  private final boolean k;
  private int l;
  private int m;

  public g(Context paramContext, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramView);
    this.l = paramInt1;
    this.m = paramInt2;
    this.g = paramContext.getApplicationContext();
    this.h = e.a(paramContext);
    this.i = f.b(paramContext);
    this.j = new com.viber.voip.messages.i();
    this.k = paramBoolean;
    this.a = paramView;
    this.b = ((AvatarWithInitialsView)paramView.findViewById(R.id.icon));
    this.c = ((TextView)paramView.findViewById(R.id.name));
    this.d = ((TextView)paramView.findViewById(R.id.date));
    this.e = ((ImageView)paramView.findViewById(R.id.like_indicator));
    this.f = paramView.findViewById(R.id.adminIndicator);
  }

  public void a(p paramp)
  {
    super.a(paramp);
    w localw = (w)paramp;
    Uri localUri = cd.a(localw.isOwner(), localw.j(), localw.k(), localw.a(), false);
    String str1 = dg.b(localw, this.l, this.m);
    if (localw.isOwner())
      str1 = this.g.getString(R.string.conversation_info_your_list_item, new Object[] { str1 });
    this.c.setText(str1);
    String str2 = da.f(str1);
    if (da.a(str2))
    {
      this.b.a(null, false);
      if ((localw.h() <= 0L) || (localw.isOwner()))
        break label257;
      if (!this.k)
        break label236;
      this.d.setText(x.a(this.g, localw.h(), System.currentTimeMillis()));
    }
    while (true)
    {
      ImageView localImageView = this.e;
      boolean bool1 = localw.e() < 0L;
      boolean bool2 = false;
      if (bool1)
        bool2 = true;
      dj.b(localImageView, bool2);
      if (m.b(this.l))
        dj.b(this.f, cd.b(localw.f()));
      this.h.a(localUri, this.b, this.i);
      return;
      this.b.a(str2, true);
      break;
      label236: this.d.setText(this.j.c(localw.h()));
      continue;
      label257: this.d.setText("");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.g
 * JD-Core Version:    0.6.2
 */