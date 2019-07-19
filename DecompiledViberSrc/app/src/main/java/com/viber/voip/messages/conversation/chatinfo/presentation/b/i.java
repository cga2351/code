package com.viber.voip.messages.conversation.chatinfo.presentation.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.market.CommunityInsightsActivity;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.user.PhotoSelectionActivity;
import com.viber.voip.util.ViberActionRunner.an;
import com.viber.voip.util.ay;
import com.viber.voip.util.cj;
import com.viber.voip.util.dg;
import com.viber.voip.util.dz;

@SuppressLint({"SwitchIntDef"})
public class i extends h
{
  private final j b;

  public i(Context paramContext, j paramj, ICdrController paramICdrController)
  {
    super(paramContext, paramj, paramICdrController);
    this.b = paramj;
  }

  private void h()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null);
    View localView2;
    do
    {
      View localView1;
      do
      {
        return;
        if (localConversationItemLoaderEntity.getIconUri() == null);
        for (int i = 1; i != 0; i = 0)
        {
          ay.a(this.b.r(), false);
          return;
        }
        localView1 = this.b.getView();
      }
      while (localView1 == null);
      localView2 = localView1.findViewById(R.id.group_icon);
    }
    while (localView2 == null);
    Intent localIntent = PhotoSelectionActivity.buildIntent(localConversationItemLoaderEntity.getIconUri(), localView2, 2, true);
    this.b.startActivityForResult(localIntent, 1233);
  }

  private PublicAccount i()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if ((localConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity))
      return new PublicAccount((PublicGroupConversationItemLoaderEntity)localConversationItemLoaderEntity);
    return null;
  }

  public void a()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null);
    while (!cj.a(true))
      return;
    l.a(localConversationItemLoaderEntity.getPublicAccountTagsLine(), i()).b(this.b.r());
  }

  public void a(int paramInt)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null)
      return;
    switch (paramInt)
    {
    default:
      super.a(paramInt);
      return;
    case 2:
      Intent localIntent = CommunityInsightsActivity.a(localConversationItemLoaderEntity.getPublicAccountGroupId());
      dz.a(this.a, localIntent);
      return;
    case 3:
      this.b.a(localConversationItemLoaderEntity.getGroupRole());
      return;
    case 4:
    }
    this.b.b("Participants List");
  }

  public void b(int paramInt)
  {
    if (this.b.s() == null)
      return;
    switch (paramInt)
    {
    case 2:
    case 3:
    case 5:
    default:
      super.b(paramInt);
      return;
    case 1:
      this.b.u();
      return;
    case 4:
      this.b.w();
      return;
    case 6:
    }
    this.b.K();
  }

  public void c()
  {
    boolean bool1 = true;
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null);
    do
    {
      return;
      if (localConversationItemLoaderEntity.isBroadcastListType())
      {
        l.a(localConversationItemLoaderEntity.getId(), localConversationItemLoaderEntity.getGroupName()).b(this.b.r());
        return;
      }
    }
    while (!cj.a(bool1));
    long l = localConversationItemLoaderEntity.getGroupId();
    String str = localConversationItemLoaderEntity.getGroupName();
    boolean bool2 = localConversationItemLoaderEntity.isHiddenConversation();
    if (localConversationItemLoaderEntity.getIconUri() != null);
    while (true)
    {
      l.a(l, str, bool2, bool1, i()).b(this.b.r());
      return;
      bool1 = false;
    }
  }

  public void c(int paramInt)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null)
      return;
    switch (paramInt)
    {
    default:
      super.c(paramInt);
      return;
    case 1:
      if ((localConversationItemLoaderEntity.isGroupType()) || (localConversationItemLoaderEntity.isCommunityType()))
      {
        this.b.L();
        return;
      }
      if (localConversationItemLoaderEntity.isBroadcastListType())
      {
        l.b(dg.c(localConversationItemLoaderEntity.getGroupName())).a(this.b.r()).b(this.b.r());
        return;
      }
      super.c(paramInt);
      return;
    case 3:
      ViberActionRunner.an.a(this.a, localConversationItemLoaderEntity.getId());
      return;
    case 5:
      GenericWebViewActivity.a(this.a, this.a.getString(R.string.communities_faq_link), null);
      return;
    case 8:
      ViberActionRunner.an.a(this.a, localConversationItemLoaderEntity);
      return;
    case 13:
    }
    this.b.b(localConversationItemLoaderEntity.getGroupId());
  }

  public void d()
  {
    h();
  }

  public void e()
  {
    h();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.b.i
 * JD-Core Version:    0.6.2
 */