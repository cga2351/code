package com.viber.voip.contacts.ui.list;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ui.h.b;
import com.viber.voip.ui.h.d;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.widget.AvatarWithInitialsView;

public class o extends b<n, a>
{
  private e a;
  private com.viber.voip.util.e.f b;

  public o(d paramd, e parame, com.viber.voip.util.e.f paramf)
  {
    super(paramd);
    this.a = parame;
    this.b = paramf;
  }

  public a a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return new a(paramLayoutInflater.inflate(R.layout.group_call_start_participant_list_item, paramViewGroup, false));
  }

  public void a(a parama, n paramn, int paramInt)
  {
    this.a.a(paramn.b, a.a(parama), this.b);
    a.b(parama).setText(paramn.c);
    if (!TextUtils.isEmpty(paramn.d))
    {
      a.c(parama).setText(paramn.d);
      dj.b(a.c(parama), true);
      return;
    }
    dj.b(a.c(parama), false);
  }

  public boolean a(Object paramObject)
  {
    return paramObject instanceof n;
  }

  static class a extends com.viber.voip.ui.h.f<n>
  {
    private AvatarWithInitialsView a;
    private TextView b;
    private TextView c;

    public a(View paramView)
    {
      super();
      this.a = ((AvatarWithInitialsView)paramView.findViewById(R.id.icon));
      this.b = ((TextView)paramView.findViewById(R.id.name));
      this.c = ((TextView)paramView.findViewById(R.id.onlineStatus));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.o
 * JD-Core Version:    0.6.2
 */