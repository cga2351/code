package com.viber.voip.messages.conversation.ui.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.util.dj;

public abstract class aa extends q
  implements View.OnClickListener
{
  final a a;
  TextView b;
  TextView c;
  private View d;

  aa(int paramInt, ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater)
  {
    super(paramInt, paramViewGroup, paramLayoutInflater);
    this.a = parama;
    this.b = ((TextView)this.layout.findViewById(R.id.alert_message));
    this.d = this.layout.findViewById(R.id.separator);
    this.layout.findViewById(R.id.close_btn).setOnClickListener(this);
    this.c = ((TextView)this.layout.findViewById(R.id.block_btn));
    this.c.setOnClickListener(this);
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.c;
  }

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean1, boolean paramBoolean2);

  protected void a(boolean paramBoolean)
  {
    dj.b(this.c, paramBoolean);
    dj.b(this.d, paramBoolean);
  }

  public void onClick(View paramView)
  {
    if (R.id.close_btn == paramView.getId())
    {
      this.a.f();
      return;
    }
    if (R.id.block_btn == paramView.getId())
    {
      this.a.g();
      return;
    }
    this.a.i();
  }

  public static abstract interface a
  {
    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.aa
 * JD-Core Version:    0.6.2
 */