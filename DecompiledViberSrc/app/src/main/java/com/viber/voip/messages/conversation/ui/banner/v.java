package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.util.dj;

public class v extends q
  implements View.OnClickListener
{
  private a a;
  private TextView b;

  public v(Context paramContext, ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.participant_new_number_banner_layout, paramViewGroup, paramLayoutInflater);
    this.a = parama;
    this.b = ((TextView)this.layout.findViewById(R.id.alert_text));
    int i = paramContext.getResources().getDimensionPixelSize(R.dimen.conversation_spam_banner_close_btn_top_margin);
    View localView1 = this.layout.findViewById(R.id.close_btn);
    dj.a(localView1, i);
    localView1.setOnClickListener(this);
    View localView2 = this.layout.findViewById(R.id.save_new_number_btn);
    dj.a(localView2, 0, i, 0, i);
    localView2.setOnClickListener(this);
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.h;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    TextView localTextView = this.b;
    Context localContext = this.b.getContext();
    int i = R.string.change_phone_number_conversation_banner_msg;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramConversationItemLoaderEntity.getParticipantName();
    localTextView.setText(localContext.getString(i, arrayOfObject));
  }

  public void onClick(View paramView)
  {
    if (R.id.close_btn == paramView.getId())
      this.a.b();
    while (R.id.save_new_number_btn != paramView.getId())
      return;
    this.a.c();
  }

  public static abstract interface a
  {
    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.v
 * JD-Core Version:    0.6.2
 */