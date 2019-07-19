package com.viber.voip.messages.extensions.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

final class d extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private final View a;
  private final TextView b;
  private final ImageView c;
  private final c.a d;
  private ChatExtensionLoaderEntity e;
  private e f;

  public d(View paramView, c.a parama)
  {
    super(paramView);
    this.d = parama;
    this.a = paramView.findViewById(R.id.keyboard_extension_item_root);
    this.c = ((ImageView)paramView.findViewById(R.id.keyboard_extension_logo_icon));
    this.b = ((TextView)paramView.findViewById(R.id.keyboard_extension_name));
    this.f = e.a(ViberApplication.getApplication());
  }

  private void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity)
  {
    this.b.setText(paramChatExtensionLoaderEntity.getName());
  }

  private void b(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity)
  {
    this.f.a(paramChatExtensionLoaderEntity.getIconOld(), this.c, f.a());
  }

  public void a()
  {
    this.a.animate().cancel();
    this.a.setScaleX(1.0F);
    this.a.setScaleY(1.0F);
  }

  public void a(long paramLong)
  {
    this.a.setScaleX(0.0F);
    this.a.setScaleY(0.0F);
    this.a.animate().setStartDelay(paramLong).setDuration(300L).scaleX(1.2F).scaleY(1.2F).withEndAction(new Runnable()
    {
      public void run()
      {
        d.a(d.this).animate().setStartDelay(0L).setDuration(100L).scaleX(1.0F).scaleY(1.0F).start();
      }
    }).start();
  }

  public void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, boolean paramBoolean)
  {
    this.e = paramChatExtensionLoaderEntity;
    a(paramChatExtensionLoaderEntity);
    b(paramChatExtensionLoaderEntity);
    this.itemView.setOnClickListener(this);
    this.itemView.setSelected(paramBoolean);
  }

  public void a(boolean paramBoolean)
  {
    this.itemView.setSelected(paramBoolean);
  }

  public void onClick(View paramView)
  {
    if (this.d != null)
      this.d.a(this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.d
 * JD-Core Version:    0.6.2
 */