package com.viber.voip.messages.conversation.ui.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;

public class x extends q
  implements View.OnClickListener
{
  private final TextView a;
  private final a b;

  public x(ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.promoted_banner_layout, paramViewGroup, paramLayoutInflater);
    this.b = parama;
    this.a = ((TextView)this.layout.findViewById(R.id.message));
    this.layout.findViewById(R.id.close_btn).setOnClickListener(this);
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.m;
  }

  public void a(boolean paramBoolean)
  {
    TextView localTextView = this.a;
    if (paramBoolean);
    for (int i = R.string.community_superadmin_promoted_banner_msg; ; i = R.string.community_admin_promoted_banner_msg)
    {
      localTextView.setText(i);
      return;
    }
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.close_btn)
      this.b.b();
  }

  public static abstract interface a
  {
    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.x
 * JD-Core Version:    0.6.2
 */