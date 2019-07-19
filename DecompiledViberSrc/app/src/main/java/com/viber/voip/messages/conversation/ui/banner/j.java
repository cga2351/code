package com.viber.voip.messages.conversation.ui.banner;

import android.content.res.Resources;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;

public class j extends q
{
  private TextView a;
  private View b;
  private a c;
  private Resources d;

  public j(ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater, Resources paramResources)
  {
    super(R.layout.layout_community_you_invited_banner, paramViewGroup, paramLayoutInflater);
    this.d = paramResources;
    this.c = parama;
    this.a = ((TextView)this.layout.findViewById(R.id.title));
    this.b = this.layout.findViewById(R.id.close);
    this.b.setOnClickListener(new k(this));
    this.a.setOnClickListener(new l(this));
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.o;
  }

  public void a(m paramm, int paramInt)
  {
    if (paramm != null);
    for (String str1 = dg.a(paramm, 5, paramInt); ; str1 = this.d.getString(R.string.unknown))
    {
      String str2 = da.d(str1);
      String str3 = this.d.getString(R.string.invited_you_to_community_title, new Object[] { str2 });
      this.a.setText(Html.fromHtml(str3));
      return;
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.j
 * JD-Core Version:    0.6.2
 */