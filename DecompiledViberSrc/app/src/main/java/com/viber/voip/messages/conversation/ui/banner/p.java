package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import java.text.NumberFormat;
import java.util.Locale;

class p extends b
  implements View.OnClickListener
{
  public TextView a;
  public TextView b;
  private a c;

  p(ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.conversation_alertbanner_layout_pg, paramViewGroup, paramLayoutInflater);
    this.c = parama;
    this.a = ((TextView)this.layout.findViewById(R.id.alert_message));
    this.b = ((TextView)this.layout.findViewById(R.id.alert_message2));
    this.layout.setOnClickListener(this);
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.b;
  }

  protected void a(int paramInt, String paramString)
  {
    Locale localLocale = this.a.getContext().getResources().getConfiguration().locale;
    this.a.setText(NumberFormat.getNumberInstance(localLocale).format(paramInt));
    this.b.setText(paramString);
  }

  public void onClick(View paramView)
  {
    this.c.c();
  }

  public static abstract interface a
  {
    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.p
 * JD-Core Version:    0.6.2
 */