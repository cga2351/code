package com.viber.voip.messages.ui.forward.sharelink;

import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.a;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.ai;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ShareLinkPresenter extends BaseMvpPresenter<h, ShareLinkState>
  implements d.a
{
  protected static final Logger a = ViberEnv.getLogger();
  private final a b;
  private final String c;
  private final String d;
  private final d e;
  private final e f;
  private final f g;
  private TreeSet<RegularConversationLoaderEntity> h = new TreeSet(g.a);
  private int i;
  private ai j;

  public ShareLinkPresenter(a parama, String paramString1, String paramString2, d paramd, e parame, f paramf)
  {
    this.b = parama;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramd;
    this.f = parame;
    this.g = paramf;
  }

  protected ShareLinkState a()
  {
    ShareLinkState localShareLinkState = new ShareLinkState();
    localShareLinkState.setSelectedConversations((RegularConversationLoaderEntity[])this.h.toArray(new RegularConversationLoaderEntity[0]));
    return localShareLinkState;
  }

  public void a(RegularConversationLoaderEntity paramRegularConversationLoaderEntity)
  {
    if (!b(paramRegularConversationLoaderEntity))
      if (this.i < 10)
        this.h.add(paramRegularConversationLoaderEntity);
    while (true)
    {
      this.i = this.h.size();
      c();
      ((h)this.mView).a(this.i, 10);
      ((h)this.mView).b();
      return;
      this.h.remove(paramRegularConversationLoaderEntity);
    }
  }

  protected void a(ShareLinkState paramShareLinkState)
  {
    super.onViewAttached(paramShareLinkState);
    this.e.a(this);
    this.j = this.e.b();
    ((h)this.mView).a(this.j, this.f, this.g, paramShareLinkState);
    if ((paramShareLinkState != null) && (paramShareLinkState.getSelectedConversations() != null))
    {
      this.h.addAll(Arrays.asList(paramShareLinkState.getSelectedConversations()));
      this.i = this.h.size();
    }
    ((h)this.mView).a(this.i, 10);
  }

  public void a(String paramString)
  {
    ((h)this.mView).a(paramString);
  }

  public void b()
  {
    HashSet localHashSet = new HashSet();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      RegularConversationLoaderEntity localRegularConversationLoaderEntity = (RegularConversationLoaderEntity)localIterator.next();
      if (localRegularConversationLoaderEntity.isGroupBehavior())
        localHashMap.put(Long.valueOf(localRegularConversationLoaderEntity.getGroupId()), Integer.valueOf(localRegularConversationLoaderEntity.getConversationType()));
      else
        localHashSet.add(localRegularConversationLoaderEntity.getParticipantMemberId());
    }
    this.b.a(this.c, this.d, (String[])localHashSet.toArray(new String[0]), localHashMap);
    ((h)this.mView).a();
  }

  public void b(String paramString)
  {
    this.j.f(paramString);
  }

  public boolean b(RegularConversationLoaderEntity paramRegularConversationLoaderEntity)
  {
    return this.h.contains(paramRegularConversationLoaderEntity);
  }

  public void c()
  {
    h localh = (h)this.mView;
    if (this.i > 0);
    for (boolean bool = true; ; bool = false)
    {
      localh.a(bool);
      return;
    }
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.e.b(this);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    ((h)this.mView).b();
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.sharelink.ShareLinkPresenter
 * JD-Core Version:    0.6.2
 */