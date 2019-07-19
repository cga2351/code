package com.viber.voip.storage.manage;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.storage.b;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.util.at;
import com.viber.voip.util.dj;

class j extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private final com.viber.voip.ui.a.a a;
  private final b<ConversationWithMediaSizesEntity> b;
  private final com.viber.voip.storage.a<ConversationWithMediaSizesEntity> c;
  private final TextView d;
  private final TextView e;
  private final TextView f;

  j(View paramView, com.viber.voip.ui.a.a parama, b<ConversationWithMediaSizesEntity> paramb, com.viber.voip.storage.a<ConversationWithMediaSizesEntity> parama1)
  {
    super(paramView);
    this.a = parama;
    this.b = paramb;
    this.c = parama1;
    this.d = ((TextView)paramView.findViewById(R.id.name));
    this.e = ((TextView)paramView.findViewById(R.id.subtitle));
    this.f = ((TextView)paramView.findViewById(R.id.media_size));
    paramView.setOnClickListener(this);
  }

  private int b(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity)
  {
    if (paramConversationWithMediaSizesEntity.isCommunityType())
      return R.string.manage_storage_conversation_subtitle_community;
    if (paramConversationWithMediaSizesEntity.isPublicGroupType())
      return R.string.manage_storage_conversation_subtitle_public_chat;
    if (paramConversationWithMediaSizesEntity.isPublicAccount())
      return R.string.manage_storage_conversation_subtitle_1on1_wit_pa;
    return 0;
  }

  public void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity)
  {
    this.c.a(paramConversationWithMediaSizesEntity);
    this.d.setText(this.b.a(paramConversationWithMediaSizesEntity));
    int i = b(paramConversationWithMediaSizesEntity);
    if (i != 0)
    {
      this.e.setText(i);
      dj.b(this.e, true);
    }
    while (true)
    {
      this.f.setText(at.a(paramConversationWithMediaSizesEntity.getSummaryMediaSizeBytes(), false));
      return;
      dj.b(this.e, false);
    }
  }

  public void onClick(View paramView)
  {
    this.a.a(getAdapterPosition(), paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.j
 * JD-Core Version:    0.6.2
 */