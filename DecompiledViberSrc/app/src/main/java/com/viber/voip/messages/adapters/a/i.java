package com.viber.voip.messages.adapters.a;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.messages.adapters.p;
import com.viber.voip.messages.conversation.y;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.widget.AvatarWithInitialsView;

public class i extends com.viber.voip.messages.adapters.i
{
  View a;
  AvatarWithInitialsView b;
  TextView c;
  private final Context d;
  private final e e;
  private final f f;
  private final com.viber.voip.messages.i g;
  private TextView h;
  private int i;
  private int j;

  public i(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView);
    this.i = paramInt1;
    this.j = paramInt2;
    this.d = paramContext.getApplicationContext();
    this.e = e.a(paramContext);
    this.f = f.b(paramContext);
    this.g = new com.viber.voip.messages.i();
    this.a = paramView;
    this.b = ((AvatarWithInitialsView)paramView.findViewById(R.id.icon));
    this.c = ((TextView)paramView.findViewById(R.id.name));
    this.h = ((TextView)paramView.findViewById(R.id.date));
  }

  public void a(p paramp)
  {
    super.a(paramp);
    y localy = (y)paramp;
    Uri localUri = cd.a(localy.isOwner(), localy.h(), localy.j(), localy.g(), false);
    String str1 = dg.b(localy, this.i, this.j);
    if (localy.isOwner())
      str1 = this.d.getString(R.string.conversation_info_your_list_item, new Object[] { str1 });
    this.c.setText(c.b(str1));
    String str2 = da.f(str1);
    if (da.a(str2))
      this.b.a(null, false);
    while (true)
    {
      if (this.h != null)
        this.h.setText(this.g.c(localy.a()));
      this.e.a(localUri, this.b, this.f);
      return;
      this.b.a(str2, true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.i
 * JD-Core Version:    0.6.2
 */