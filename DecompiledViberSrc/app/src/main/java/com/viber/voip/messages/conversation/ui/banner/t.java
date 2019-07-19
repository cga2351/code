package com.viber.voip.messages.conversation.ui.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.ui.at;

public class t extends q
  implements View.OnClickListener
{
  private a a;

  public t(ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.public_account_non_published_banner_layout, paramViewGroup, paramLayoutInflater);
    this.a = parama;
    this.layout.findViewById(R.id.publish_public_account_btn).setOnClickListener(this);
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.e;
  }

  protected void applyUiSettings(at paramat)
  {
  }

  public void onClick(View paramView)
  {
    if (R.id.publish_public_account_btn == paramView.getId())
      this.a.a();
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.t
 * JD-Core Version:    0.6.2
 */