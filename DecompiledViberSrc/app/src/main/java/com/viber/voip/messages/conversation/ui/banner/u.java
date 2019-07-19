package com.viber.voip.messages.conversation.ui.banner;

import android.content.res.Resources;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;

public class u extends q
  implements View.OnClickListener
{
  private TextView a;
  private TextView b;
  private View c;
  private a d;
  private Resources e;
  private View f;

  public u(ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater, Resources paramResources)
  {
    super(R.layout.layout_not_joined_community_banner, paramViewGroup, paramLayoutInflater);
    this.e = paramResources;
    this.d = parama;
    this.a = ((TextView)this.layout.findViewById(R.id.title));
    this.b = ((TextView)this.layout.findViewById(R.id.blockText));
    this.c = this.layout.findViewById(R.id.blockAndReportText);
    this.f = this.layout.findViewById(R.id.button_holder);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.a.setOnClickListener(this);
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.p;
  }

  public void a(m paramm, int paramInt, boolean paramBoolean)
  {
    String str1;
    View localView;
    if (paramm != null)
    {
      str1 = dg.a(paramm, 5, paramInt);
      String str2 = c.a(da.d(str1));
      String str3 = this.e.getString(R.string.invited_you_to_join_community_title, new Object[] { str2 });
      this.a.setText(Html.fromHtml(str3));
      String str4 = this.e.getString(R.string.block_community_banner_title, new Object[] { str2 });
      this.b.setText(Html.fromHtml(str4));
      localView = this.f;
      if (paramBoolean)
        break label124;
    }
    label124: for (boolean bool = true; ; bool = false)
    {
      dj.b(localView, bool);
      return;
      str1 = this.e.getString(R.string.unknown);
      break;
    }
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.blockText)
      this.d.a(false);
    do
    {
      return;
      if (i == R.id.blockAndReportText)
      {
        this.d.a(true);
        return;
      }
    }
    while (i != R.id.title);
    this.d.a();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.u
 * JD-Core Version:    0.6.2
 */