package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.j.c;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.model.h;
import com.viber.voip.registration.ao;
import com.viber.voip.registration.changephonenumber.d.a;
import com.viber.voip.util.ViberActionRunner.al;
import com.viber.voip.util.cg;
import com.viber.voip.util.dd;

public class bm
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final d.a c;
  private final com.viber.voip.contacts.c.d.m d;
  private boolean e;
  private boolean f;

  public bm(Context paramContext, d.a parama, com.viber.voip.contacts.c.d.m paramm)
  {
    this.b = paramContext;
    this.c = parama;
    this.d = paramm;
  }

  private void a(Uri paramUri, String paramString)
  {
    if ((!this.e) && (!cg.c(paramString)))
      ViberActionRunner.al.a(this.b, paramUri, paramString);
  }

  private boolean a(long paramLong, final String paramString, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((ao.f()) || (this.f) || (paramString == null) || (paramConversationItemLoaderEntity == null) || (!paramConversationItemLoaderEntity.isConversation1on1()))
      return false;
    this.f = true;
    this.c.a(paramLong, this.d, new j.c()
    {
      public void a(final Uri paramAnonymousUri)
      {
        dd.a(new Runnable()
        {
          public void run()
          {
            bm.a(bm.this, false);
            bm.a(bm.this, paramAnonymousUri, bm.1.this.a);
          }
        });
      }
    });
    return true;
  }

  public void a()
  {
    this.e = true;
  }

  public boolean a(com.viber.voip.model.entity.m paramm, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((paramm != null) && (paramm.q()))
      return a(paramm.getId(), paramm.getNumber(), paramConversationItemLoaderEntity);
    return false;
  }

  public boolean a(h paramh, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((paramh != null) && (paramh.n()))
      return a(paramh.d(), paramh.getNumber(), paramConversationItemLoaderEntity);
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bm
 * JD-Core Version:    0.6.2
 */