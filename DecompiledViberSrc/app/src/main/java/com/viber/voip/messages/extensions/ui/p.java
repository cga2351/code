package com.viber.voip.messages.extensions.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.extensions.c.d;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.ui.a.a;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class p extends RecyclerView.Adapter<a>
{
  private final a a;
  private final LayoutInflater b;
  private final e c;
  private final f d;
  private final d e;

  public p(Context paramContext, e parame, d paramd, a parama)
  {
    this.b = LayoutInflater.from(paramContext);
    this.c = parame;
    this.a = parama;
    this.d = f.c(paramContext);
    this.e = paramd;
  }

  public ChatExtensionLoaderEntity a(int paramInt)
  {
    return this.e.e(paramInt);
  }

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(this.b.inflate(R.layout.list_item_chat_extensions_horizontal, paramViewGroup, false), this.a);
  }

  public void a(a parama, int paramInt)
  {
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity = a(paramInt);
    if (localChatExtensionLoaderEntity == null)
      return;
    this.c.a(localChatExtensionLoaderEntity.getIcon(), parama.a, this.d);
    parama.b.setText(localChatExtensionLoaderEntity.getName());
  }

  public int getItemCount()
  {
    return this.e.getCount();
  }

  public static class a extends RecyclerView.ViewHolder
  {
    ImageView a;
    TextView b;

    public a(View paramView, a parama)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(R.id.chatexIconView));
      this.b = ((TextView)paramView.findViewById(R.id.chatexNameView));
      if (parama != null)
        paramView.setOnClickListener(new q(this, parama));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.p
 * JD-Core Version:    0.6.2
 */