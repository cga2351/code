package com.viber.voip.storage.manage;

import android.content.Context;
import android.support.v7.d.c.c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.util.e.e;

class b extends android.support.v7.recyclerview.a.c<ConversationWithMediaSizesEntity, j>
{
  private static final c.c<ConversationWithMediaSizesEntity> a = new c.c()
  {
    public boolean a(ConversationWithMediaSizesEntity paramAnonymousConversationWithMediaSizesEntity1, ConversationWithMediaSizesEntity paramAnonymousConversationWithMediaSizesEntity2)
    {
      return paramAnonymousConversationWithMediaSizesEntity1.getId() == paramAnonymousConversationWithMediaSizesEntity2.getId();
    }

    public boolean b(ConversationWithMediaSizesEntity paramAnonymousConversationWithMediaSizesEntity1, ConversationWithMediaSizesEntity paramAnonymousConversationWithMediaSizesEntity2)
    {
      return paramAnonymousConversationWithMediaSizesEntity1.getSummaryMediaSizeBytes() == paramAnonymousConversationWithMediaSizesEntity2.getSummaryMediaSizeBytes();
    }
  };
  private final LayoutInflater b;
  private final e c;
  private final com.viber.voip.messages.adapters.a.c.a d;
  private final com.viber.voip.storage.b<ConversationWithMediaSizesEntity> e;
  private final com.viber.voip.ui.a.a f;

  b(Context paramContext, a parama)
  {
    super(a);
    this.b = LayoutInflater.from(paramContext);
    this.c = e.a(paramContext);
    this.d = new com.viber.voip.messages.adapters.a.c.a(paramContext, null, false, false, false);
    this.e = new com.viber.voip.storage.b(this.d);
    this.f = new c(this, parama);
    setHasStableIds(true);
  }

  public j a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.b.inflate(paramInt, paramViewGroup, false);
    com.viber.voip.storage.a locala = new com.viber.voip.storage.a(localView, this.d, this.c);
    return new j(localView, this.f, this.e, locala);
  }

  public void a(j paramj, int paramInt)
  {
    paramj.a((ConversationWithMediaSizesEntity)a(paramInt));
  }

  public long getItemId(int paramInt)
  {
    return ((ConversationWithMediaSizesEntity)a(paramInt)).getId();
  }

  public int getItemViewType(int paramInt)
  {
    return R.layout.list_item_manage_storage_conversation;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.b
 * JD-Core Version:    0.6.2
 */