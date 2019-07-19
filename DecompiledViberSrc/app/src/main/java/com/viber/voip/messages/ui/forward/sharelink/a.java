package com.viber.voip.messages.ui.forward.sharelink;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.ai;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.e.e;

public class a extends RecyclerView.Adapter<i>
{
  private final ai a;
  private final e b;
  private final LayoutInflater c;
  private final com.viber.voip.util.e.f d;
  private final Context e;
  private final ShareLinkPresenter f;
  private f g;

  public a(e parame, ai paramai, LayoutInflater paramLayoutInflater, com.viber.voip.util.e.f paramf, Context paramContext, ShareLinkPresenter paramShareLinkPresenter)
  {
    this.a = paramai;
    this.b = parame;
    this.c = paramLayoutInflater;
    this.d = paramf;
    this.e = paramContext;
    this.f = paramShareLinkPresenter;
  }

  private String a()
  {
    return this.e.getResources().getString(R.string.recent_section_title).toUpperCase();
  }

  public RegularConversationLoaderEntity a(int paramInt)
  {
    return (RegularConversationLoaderEntity)this.a.e(paramInt);
  }

  public i a(ViewGroup paramViewGroup, int paramInt)
  {
    return new i(this.c.inflate(R.layout.share_community_list_item, paramViewGroup, false), this.g, this.b, this.d, a());
  }

  public void a(f paramf)
  {
    this.g = paramf;
  }

  public void a(i parami, int paramInt)
  {
    RegularConversationLoaderEntity localRegularConversationLoaderEntity = (RegularConversationLoaderEntity)this.a.e(paramInt);
    String str = dg.b(localRegularConversationLoaderEntity);
    Uri localUri;
    if (localRegularConversationLoaderEntity.isGroupBehavior())
    {
      localUri = localRegularConversationLoaderEntity.getIconUriOrDefault();
      if ((paramInt != 0) || (!da.a(this.a.K())))
        break label86;
    }
    label86: for (boolean bool = true; ; bool = false)
    {
      parami.a(str, localUri, this.f.b(localRegularConversationLoaderEntity), bool, this.a.K());
      return;
      localUri = localRegularConversationLoaderEntity.getParticipantPhoto();
      break;
    }
  }

  public int getItemCount()
  {
    return this.a.getCount();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.sharelink.a
 * JD-Core Version:    0.6.2
 */