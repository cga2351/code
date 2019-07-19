package com.viber.voip.messages.conversation.ui.banner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;

public class s extends q
  implements View.OnClickListener
{
  public View a;
  public TextView b;
  private a c;

  s(ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.alertbaner_noparticipants_layout, paramViewGroup, paramLayoutInflater);
    this.c = parama;
    this.b = ((TextView)this.layout.findViewById(R.id.alert_message));
    this.a = this.layout.findViewById(R.id.alert_add_participants);
    this.a.setOnClickListener(this);
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.a;
  }

  public void onClick(View paramView)
  {
    this.c.f();
  }

  public void setBundle(Bundle paramBundle)
  {
    if (paramBundle != null)
      this.b.setText(paramBundle.getString("alert_text_extra"));
  }

  public static abstract interface a
  {
    public abstract void f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.s
 * JD-Core Version:    0.6.2
 */