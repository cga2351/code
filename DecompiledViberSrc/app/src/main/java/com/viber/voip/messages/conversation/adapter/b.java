package com.viber.voip.messages.conversation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.adapter.a.b.c;
import com.viber.voip.messages.conversation.adapter.a.b.d;
import com.viber.voip.ui.a.a;
import com.viber.voip.util.e.f;
import java.util.Map;

public class b extends RecyclerView.Adapter<r>
  implements com.viber.voip.messages.conversation.chatinfo.presentation.a.b
{
  protected final LayoutInflater a;
  protected final com.viber.voip.util.e.e b;
  private final f c;
  private final a d;
  private final com.viber.voip.messages.conversation.adapter.a.c.a.e e;
  private m f;

  public b(Context paramContext, int paramInt1, int paramInt2, a parama, LayoutInflater paramLayoutInflater)
  {
    this.d = parama;
    this.a = paramLayoutInflater;
    this.b = com.viber.voip.util.e.e.a(paramContext);
    this.c = f.b(paramContext);
    this.e = new com.viber.voip.messages.conversation.adapter.a.c.a.e(paramContext, paramInt1, paramInt2);
    this.f = new m(null);
  }

  public r a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    case 5:
    case 6:
    case 7:
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 8:
    case 9:
    }
    while (true)
    {
      if (localObject != null)
        ((r)localObject).a(this.d);
      return localObject;
      View localView = this.a.inflate(R.layout.participants_list_item, paramViewGroup, false);
      localObject = new c(this.b, this.c, this.e, localView);
      continue;
      localObject = new com.viber.voip.messages.conversation.adapter.a.b.e(this.a.inflate(R.layout.chat_info_item_header, paramViewGroup, false));
      continue;
      localObject = new com.viber.voip.messages.conversation.adapter.a.b.e(this.a.inflate(R.layout.chat_info_item_header, paramViewGroup, false));
      continue;
      localObject = new com.viber.voip.messages.conversation.adapter.a.b.b(this.a.inflate(R.layout.chat_info_item_left_text_header, paramViewGroup, false));
      continue;
      localObject = new d(this.a.inflate(R.layout.chat_info_item_left_text_header, paramViewGroup, false), false);
      continue;
      localObject = new r(this.a.inflate(R.layout.chat_info_item_divider, paramViewGroup, false));
      continue;
      localObject = new p(this.a.inflate(R.layout.participants_list_item_add_participants, paramViewGroup, false));
    }
  }

  public s a(int paramInt)
  {
    return this.f.b(paramInt);
  }

  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.e.a(paramInt1);
    this.e.b(paramInt2);
    this.e.a(paramBoolean);
    this.e.a(paramLong);
  }

  public void a(m paramm)
  {
    int i = this.f.a();
    this.f = paramm;
    int j = getItemCount();
    if (i > j)
      notifyItemRangeRemoved(j, i - j);
    notifyItemRangeChanged(0, j);
  }

  public void a(r paramr, int paramInt)
  {
    paramr.a(a(paramInt));
  }

  public void a(Map<String, OnlineContactInfo> paramMap)
  {
    this.e.b(paramMap);
    notifyDataSetChanged();
  }

  public void b(Map<String, PeerTrustState.PeerTrustEnum> paramMap)
  {
    this.e.c(paramMap);
    notifyDataSetChanged();
  }

  public int getItemCount()
  {
    return this.f.a();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return a(paramInt).m();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.b
 * JD-Core Version:    0.6.2
 */