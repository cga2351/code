package com.viber.voip.invitelinks;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class f
{
  private static final Logger a = ViberEnv.getLogger();
  private final d b;
  private final EventBus c;
  private cj d;
  private PublicGroupConversationItemLoaderEntity e;
  private long f;
  private a g;

  @Inject
  public f(d paramd, cj paramcj)
  {
    this.b = paramd;
    this.c = paramd.c();
    this.d = paramcj;
  }

  public void a(long paramLong, int paramInt, boolean paramBoolean, a parama)
  {
    this.f = paramLong;
    this.g = parama;
    if (!this.c.isRegistered(this))
      this.c.register(this);
    if ((paramBoolean) && (this.d.a() == -1))
    {
      this.c.unregister(this);
      this.g.a();
      return;
    }
    this.b.a(paramLong, paramInt);
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, boolean paramBoolean, a parama)
  {
    this.e = paramPublicGroupConversationItemLoaderEntity;
    a(paramPublicGroupConversationItemLoaderEntity.getGroupId(), paramPublicGroupConversationItemLoaderEntity.getGroupRole(), paramBoolean, parama);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onInviteLinkReceived(d.c paramc)
  {
    int i = 1;
    this.c.unregister(this);
    if (paramc.c == 0)
    {
      if (this.f == paramc.a)
      {
        String str = paramc.d;
        if (!da.a(str))
        {
          if (this.e == null)
          {
            this.g.a(this.f, str);
            return;
          }
          this.g.a(this.e, str);
          return;
        }
        this.g.d();
        return;
      }
      this.g.c();
      return;
    }
    int j;
    int k;
    label138: int m;
    if ((paramc.b == 0) && (paramc.c == i))
    {
      j = i;
      if ((paramc.b != i) || (paramc.c != 2))
        break label219;
      k = i;
      if (((paramc.b != 0) || (paramc.c != 3)) && (((paramc.b != i) && (paramc.b != 2)) || (paramc.c != 4)))
        break label225;
      m = i;
      label180: if (this.d.a() != -1)
        break label231;
    }
    while (true)
    {
      if (((j == 0) && (k == 0)) || (i == 0))
        break label236;
      this.g.a();
      return;
      j = 0;
      break;
      label219: k = 0;
      break label138;
      label225: m = 0;
      break label180;
      label231: i = 0;
    }
    label236: if (m != 0)
    {
      this.g.b();
      return;
    }
    this.g.c();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(long paramLong, String paramString);

    public abstract void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, String paramString);

    public abstract void b();

    public abstract void c();

    public abstract void d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.f
 * JD-Core Version:    0.6.2
 */