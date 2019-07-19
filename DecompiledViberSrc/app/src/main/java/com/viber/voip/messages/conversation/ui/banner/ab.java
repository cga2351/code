package com.viber.voip.messages.conversation.ui.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.b.d;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.settings.d.ba;
import com.viber.voip.util.dj;

public class ab extends b
  implements View.OnClickListener
{
  ab(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.alertbaner_translate_messages_layout, paramViewGroup, paramLayoutInflater);
    ((ImageView)this.layout.findViewById(R.id.icon)).setImageResource(R.drawable.msg_list_icon_forward);
    ((TextView)this.layout.findViewById(R.id.alert_message)).setText(R.string.swipe_to_reply_ftue_text);
    this.layout.findViewById(R.id.close_btn).setOnClickListener(this);
  }

  public AlertView.a getMode()
  {
    return ConversationAlertView.a.q;
  }

  public void onClick(View paramView)
  {
    dj.c(this.layout, 8);
    d.ba.a.a(3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.ab
 * JD-Core Version:    0.6.2
 */