package com.viber.voip.messages.conversation.ui.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.util.dj;

public class y extends q
  implements View.OnClickListener
{
  private a a;
  private TextView b;

  public y(ViewGroup paramViewGroup, boolean paramBoolean, a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.public_account_follow_banner_layout, paramViewGroup, paramLayoutInflater);
    this.a = parama;
    this.layout.findViewById(R.id.close_btn).setOnClickListener(this);
    if (paramBoolean)
      this.layout.findViewById(R.id.follow).setOnClickListener(this);
    while (true)
    {
      this.b = ((TextView)this.layout.findViewById(R.id.description));
      return;
      dj.b(this.layout.findViewById(R.id.follow), false);
    }
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.d;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.b.setText(paramConversationItemLoaderEntity.getPublicAccountTagsLine());
  }

  public boolean isPriorityAlert()
  {
    return true;
  }

  public void onClick(View paramView)
  {
    if (R.id.close_btn == paramView.getId())
      this.a.c();
    while (R.id.follow != paramView.getId())
      return;
    this.a.d();
  }

  public static abstract interface a
  {
    public abstract void c();

    public abstract void d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.y
 * JD-Core Version:    0.6.2
 */