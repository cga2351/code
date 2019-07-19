package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.util.dj;

class ac extends b
  implements View.OnClickListener
{
  ac(Context paramContext, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.alertbaner_translate_messages_layout, paramViewGroup, paramLayoutInflater);
    this.layout.setOnClickListener(this);
    ((TextView)this.layout.findViewById(R.id.alert_message)).setText(Html.fromHtml(paramContext.getString(R.string.translation_ftue_text)));
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.l;
  }

  public void onClick(View paramView)
  {
    dj.c(this.layout, 8);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.ac
 * JD-Core Version:    0.6.2
 */