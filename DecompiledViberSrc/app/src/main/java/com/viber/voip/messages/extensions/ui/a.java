package com.viber.voip.messages.extensions.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.extensions.c.c;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final boolean a;
  private final com.viber.voip.ui.a.a b;
  private final e c;
  private final f d;
  private final LayoutInflater e;
  private final c f;

  public a(Context paramContext, e parame, com.viber.voip.app.b paramb, c paramc, com.viber.voip.ui.a.a parama)
  {
    this.e = LayoutInflater.from(paramContext);
    this.c = parame;
    if ((paramb.a(paramContext)) || (!paramb.a()));
    for (boolean bool = true; ; bool = false)
    {
      this.a = bool;
      this.b = parama;
      this.d = f.c(paramContext);
      this.f = paramc;
      return;
    }
  }

  public ChatExtensionLoaderEntity a(int paramInt)
  {
    if (this.a)
      paramInt--;
    return this.f.e(paramInt);
  }

  public int getItemCount()
  {
    int i = this.f.getCount();
    if ((this.a) && (i > 0))
      i++;
    return i;
  }

  public int getItemViewType(int paramInt)
  {
    if (this.a)
    {
      if (paramInt == 0)
        return 0;
      return 1;
    }
    return 2;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder.getItemViewType() == 0);
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity;
    do
    {
      return;
      localChatExtensionLoaderEntity = a(paramInt);
    }
    while (localChatExtensionLoaderEntity == null);
    ((c)paramViewHolder).a(localChatExtensionLoaderEntity);
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    default:
      return new d(this.e.inflate(R.layout.list_item_chat_extensions_vertical, paramViewGroup, false), this.c, this.d, this.b);
    case 0:
      return new a(this.e.inflate(R.layout.list_item_chat_extensions_header, paramViewGroup, false));
    case 2:
    }
    return new b(this.e.inflate(R.layout.list_item_chat_extensions_horizontal, paramViewGroup, false), this.c, this.d, this.b);
  }

  public static class a extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
    }
  }

  public static class b extends a.c
  {
    public b(View paramView, e parame, f paramf, com.viber.voip.ui.a.a parama)
    {
      super(parame, paramf, parama);
    }
  }

  static abstract class c extends RecyclerView.ViewHolder
  {
    private final ImageView a;
    private final TextView b;
    private final e c;
    private final f d;

    public c(View paramView, e parame, f paramf, com.viber.voip.ui.a.a parama)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(R.id.chatexIconView));
      this.b = ((TextView)paramView.findViewById(R.id.chatexNameView));
      this.c = parame;
      this.d = paramf;
      if (parama != null)
        paramView.setOnClickListener(new b(this, parama));
    }

    public void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity)
    {
      this.c.a(paramChatExtensionLoaderEntity.getIcon(), this.a, this.d);
      this.b.setText(paramChatExtensionLoaderEntity.getName());
      this.itemView.setTag(paramChatExtensionLoaderEntity);
    }
  }

  public static class d extends a.c
  {
    private final TextView a;

    public d(View paramView, e parame, f paramf, com.viber.voip.ui.a.a parama)
    {
      super(parame, paramf, parama);
      this.a = ((TextView)paramView.findViewById(R.id.chatexDescriptionView));
    }

    public void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity)
    {
      super.a(paramChatExtensionLoaderEntity);
      String str = paramChatExtensionLoaderEntity.getSearchHint();
      TextView localTextView = this.a;
      if (!TextUtils.isEmpty(str));
      for (boolean bool = true; ; bool = false)
      {
        dj.b(localTextView, bool);
        this.a.setText(str);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.a
 * JD-Core Version:    0.6.2
 */