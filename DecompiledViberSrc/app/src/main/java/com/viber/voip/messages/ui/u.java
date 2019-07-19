package com.viber.voip.messages.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.group.participants.settings.b;
import com.viber.voip.invitelinks.d;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.messages.conversation.ui.view.e;
import com.viber.voip.messages.extensions.c;
import java.util.ArrayList;
import java.util.Iterator;

public class u
{
  private static final Logger a = ViberEnv.getLogger("buildCustomMenu");
  private static final Logger b = ViberEnv.getLogger("buildCustomPasteMenu");
  private final Activity c;
  private Uri d;
  private ConversationFragment e;
  private final c f;
  private final ai g;
  private final d h;
  private as i;
  private bg j;
  private bf k;

  public u(Activity paramActivity, ConversationFragment paramConversationFragment, c paramc, ai paramai, d paramd)
  {
    this.c = paramActivity;
    this.e = paramConversationFragment;
    this.f = paramc;
    this.g = paramai;
    this.h = paramd;
  }

  private int a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity != null)
    {
      if (paramConversationItemLoaderEntity.isInBusinessInbox())
        return 2;
      if (paramConversationItemLoaderEntity.isSecret())
        return 1;
      if (paramConversationItemLoaderEntity.isVlnConversation())
        return 3;
    }
    return 0;
  }

  private void a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("Parameter " + paramString + " must be not null");
  }

  private int b()
  {
    return a(this.e.ah().j());
  }

  public void a()
  {
    if (this.i != null)
      this.i.c();
  }

  public void a(int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    if (this.i != null)
      this.i.a(paramInt, paramArrayOfString, paramObject);
    if (this.j != null)
      this.j.a(paramInt, paramArrayOfString, paramObject);
    if (this.k != null)
      this.k.a(paramInt, paramArrayOfString, paramObject);
  }

  @SuppressLint({"NewApi"})
  public void a(ContextMenu paramContextMenu, MenuInflater paramMenuInflater, View paramView, j paramj)
  {
    a(paramContextMenu, "menu");
    a(paramMenuInflater, "menuInflater");
    a(paramView, "view");
    this.d = ((Uri)paramView.getTag());
    if (this.d == null)
      return;
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.e.ah().j();
    Activity localActivity = this.c;
    int m = a(localConversationItemLoaderEntity);
    Uri localUri = this.d;
    if ((localConversationItemLoaderEntity != null) && (localConversationItemLoaderEntity.isSecret()));
    for (boolean bool = true; ; bool = false)
    {
      this.j = new bg(localActivity, paramContextMenu, m, localUri, bool, paramj);
      return;
    }
  }

  @SuppressLint({"NewApi"})
  public void a(ContextMenu paramContextMenu, aa paramaa, ConversationItemLoaderEntity paramConversationItemLoaderEntity, j paramj, b paramb, boolean paramBoolean, e parame)
  {
    paramContextMenu.removeItem(16908321);
    if ((paramaa.aD()) && (paramaa.ao()))
      return;
    this.i = new as(this.c, paramContextMenu, b(), paramaa, paramConversationItemLoaderEntity.getGroupRole(), paramConversationItemLoaderEntity.isSystemConversation(), paramConversationItemLoaderEntity.isDisabledConversation(), paramBoolean, paramConversationItemLoaderEntity.isNotShareablePublicAccount(), paramConversationItemLoaderEntity.isCommunityBlocked(), paramConversationItemLoaderEntity.isBroadcastListType(), paramConversationItemLoaderEntity.getAppId(), paramj, this.e.B(), paramb, paramConversationItemLoaderEntity.isVlnConversation(), parame, this.f, this.g, this.h);
    this.i.a(this.e);
  }

  public boolean a(MenuItem paramMenuItem)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.i != null)
      localArrayList.add(this.i);
    if (this.j != null)
      localArrayList.add(this.j);
    if (this.k != null)
      localArrayList.add(this.k);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
      if (((bc)localIterator.next()).a(paramMenuItem.getItemId()))
        return true;
    return false;
  }

  @SuppressLint({"NewApi"})
  public void b(ContextMenu paramContextMenu, MenuInflater paramMenuInflater, View paramView, j paramj)
  {
    a(paramContextMenu, "menu");
    a(paramMenuInflater, "menuInflater");
    a(paramView, "view");
    this.k = new bf(this.c, paramContextMenu, b(), paramj);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.u
 * JD-Core Version:    0.6.2
 */