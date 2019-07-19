package com.viber.voip.messages.conversation.ui.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.voip.R.anim;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.ui.banner.a.a;
import com.viber.voip.messages.conversation.ui.banner.a.c;

public class o extends q
  implements View.OnClickListener
{
  public static final a a = new c();
  private b b;

  public o(ViewGroup paramViewGroup, b paramb, a parama, b.b paramb1, LayoutInflater paramLayoutInflater)
  {
    super(parama.c(), paramViewGroup, parama, paramb1, paramLayoutInflater);
    this.b = paramb;
    View localView = this.layout.findViewById(parama.d());
    if (localView != null)
    {
      localView.setOnClickListener(this);
      return;
    }
    this.layout.setOnClickListener(this);
  }

  protected a createAlertViewUiCustomizer()
  {
    return new c();
  }

  public AlertView.a getMode()
  {
    return AlertView.c.a;
  }

  public void onClick(View paramView)
  {
    if (this.b != null)
      this.b.c();
  }

  public static abstract interface a extends b.a
  {
    public abstract int c();

    public abstract int d();
  }

  public static abstract interface b
  {
    public abstract void c();
  }

  public static class c
    implements o.a
  {
    public int a()
    {
      return R.anim.media_viewer_favorite_links_bot_alert_slide_in;
    }

    public int b()
    {
      return R.anim.media_viewer_favorite_links_bot_alert_slide_out;
    }

    public int c()
    {
      return R.layout.media_viewer_favorite_links_bot_banner;
    }

    public int d()
    {
      return R.id.alert_action_button;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.o
 * JD-Core Version:    0.6.2
 */