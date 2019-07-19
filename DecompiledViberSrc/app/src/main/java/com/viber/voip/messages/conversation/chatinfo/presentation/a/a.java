package com.viber.voip.messages.conversation.chatinfo.presentation.a;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.c;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.h;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.i;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.j;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.l;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.n;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.p;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.r;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.t;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.v;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.x;
import com.viber.voip.messages.conversation.chatinfo.presentation.c.z;
import com.viber.voip.util.dj;
import java.util.Map;

public class a extends RecyclerView.Adapter<com.viber.voip.messages.conversation.chatinfo.presentation.c.g<? super com.viber.voip.messages.conversation.chatinfo.d.d>>
  implements b
{
  private com.viber.voip.messages.conversation.chatinfo.c.a<com.viber.voip.messages.conversation.chatinfo.d.d> a;
  private final LayoutInflater b;
  private final com.viber.voip.messages.conversation.chatinfo.presentation.b.g c;
  private final com.viber.voip.messages.conversation.chatinfo.e.e d;

  public a(LayoutInflater paramLayoutInflater, com.viber.voip.messages.conversation.chatinfo.presentation.b.g paramg, com.viber.voip.messages.conversation.chatinfo.e.e parame)
  {
    this.b = paramLayoutInflater;
    this.c = paramg;
    this.d = parame;
  }

  public Pair<Integer, com.viber.voip.messages.conversation.chatinfo.d.d> a(d paramd, int paramInt)
  {
    if (this.a != null)
      return this.a.a(paramd, paramInt);
    return null;
  }

  public com.viber.voip.messages.conversation.chatinfo.presentation.c.g a(ViewGroup paramViewGroup, int paramInt)
  {
    d locald = d.a(paramInt);
    int i = locald.a();
    if (i != 0)
    {
      localView = this.b.inflate(i, paramViewGroup, false);
      switch (1.a[locald.ordinal()])
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      }
    }
    while (locald != d.b)
    {
      View localView;
      return new i(new View(paramViewGroup.getContext()));
      return new j(localView, this.c);
      return new v(localView, this.c);
      return new l(localView, this.c);
      return new com.viber.voip.messages.conversation.chatinfo.presentation.c.e(localView, this.c);
      return new t(localView, this.c);
      return new com.viber.voip.messages.conversation.chatinfo.presentation.c.a(localView, this.c);
      return new z(localView);
      return new r(localView, this.c, this.d.b());
      return new x(localView, this.c);
      return new n(localView, this.c);
      return new c(localView, this.c);
      return new p(localView, this.c);
    }
    return new h(dj.n(paramViewGroup.getContext()));
  }

  public void a(com.viber.voip.messages.conversation.chatinfo.c.a<com.viber.voip.messages.conversation.chatinfo.d.d> parama)
  {
    int i = getItemCount();
    this.a = parama;
    int j = getItemCount();
    if (i > j)
      notifyItemRangeRemoved(j, i - j);
    notifyItemRangeChanged(0, j);
  }

  public void a(com.viber.voip.messages.conversation.chatinfo.presentation.c.g<? super com.viber.voip.messages.conversation.chatinfo.d.d> paramg, int paramInt)
  {
    paramg.a((com.viber.voip.messages.conversation.chatinfo.d.d)this.a.d(paramInt), this.d);
  }

  public void a(Map<String, OnlineContactInfo> paramMap)
  {
    this.d.a(paramMap);
    notifyDataSetChanged();
  }

  public void b(Map<String, PeerTrustState.PeerTrustEnum> paramMap)
  {
    notifyDataSetChanged();
  }

  public int getItemCount()
  {
    if (this.a == null)
      return 0;
    return this.a.a();
  }

  public int getItemViewType(int paramInt)
  {
    if (this.a == null)
      return d.a.ordinal();
    return ((com.viber.voip.messages.conversation.chatinfo.d.d)this.a.d(paramInt)).d().ordinal();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.a.a
 * JD-Core Version:    0.6.2
 */