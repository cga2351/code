package com.viber.voip.invitelinks.linkscreen;

import android.annotation.SuppressLint;
import com.viber.voip.invitelinks.d;
import com.viber.voip.invitelinks.d.a;
import com.viber.voip.invitelinks.d.c;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class j extends BaseShareLinkPresenter<e>
{
  protected final d j;

  public j(InviteLinkData paramInviteLinkData, g paramg, i parami, a parama, d paramd, cj paramcj)
  {
    super(paramInviteLinkData, paramg, parami, parama, paramd.c(), paramcj);
    this.j = paramd;
  }

  private void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    ((e)this.f).b(cd.c(paramPublicGroupConversationItemLoaderEntity.getGroupRole()));
    ((e)this.f).c(paramPublicGroupConversationItemLoaderEntity.isDisplayInvitationLinkToAll());
  }

  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
    case 2:
      this.e.a();
      return;
    case 3:
    }
    this.e.b();
  }

  @SuppressLint({"SwitchIntDef"})
  public void a(ScreenView.Error paramError)
  {
    switch (paramError.operation)
    {
    default:
      super.a(paramError);
      return;
    case 4:
    }
    d(paramError.status);
  }

  public void a(e parame)
  {
    super.a(parame);
    this.d.a();
  }

  protected void b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
    case 2:
    case 5:
      this.e.a();
      return;
    case 3:
    case 4:
    }
    this.e.b();
  }

  protected void c(int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    case 2:
    default:
      return;
    case 5:
      this.e.a();
      return;
    case 3:
    case 4:
    }
    this.e.b();
  }

  void c(final boolean paramBoolean)
  {
    a(new BaseShareLinkPresenter.a()
    {
      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        boolean bool = ((PublicGroupConversationItemLoaderEntity)paramAnonymousConversationItemLoaderEntity).isDisplayInvitationLinkToAll();
        if ((!paramBoolean) && (bool))
        {
          ((e)j.this.f).D_();
          return;
        }
        ((e)j.this.f).a(true);
        if (bool);
        for (byte b1 = 0; ; b1 = 1)
        {
          j.this.j.a(paramAnonymousConversationItemLoaderEntity.getGroupId(), b1);
          return;
        }
      }
    });
  }

  protected ScreenView.Error d()
  {
    return new ScreenView.Error(0, 3);
  }

  protected void d(int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    case 2:
    default:
      return;
    case 4:
      this.e.a();
      return;
    case 3:
    }
    this.e.b();
  }

  protected void f()
  {
    ((e)this.f).a(true);
    a(new BaseShareLinkPresenter.a()
    {
      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        j.this.j.a(j.this.b.groupId, paramAnonymousConversationItemLoaderEntity.getGroupRole());
      }
    });
  }

  protected void h()
  {
    a(new BaseShareLinkPresenter.a()
    {
      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        ((e)j.this.f).a(true);
        j.this.j.b(j.this.b.groupId, paramAnonymousConversationItemLoaderEntity.getGroupRole());
      }
    });
  }

  public void onConversationReceived(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity.isCommunityBlocked())
    {
      this.e.a();
      return;
    }
    super.onConversationReceived(paramConversationItemLoaderEntity);
    a((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onDisplayInvitationLinkChanged(d.a parama)
  {
    int i = 1;
    if (a(parama.a));
    do
    {
      return;
      ((e)this.f).a(false);
      if (parama.d != 0)
        break;
      this.c = null;
    }
    while (parama.b != 0);
    this.b = new InviteLinkData(this.b, parama.c);
    ((e)this.f).a(this.b.shareUrl);
    return;
    ScreenView.Error localError1 = new ScreenView.Error(4, parama.d);
    int k;
    int m;
    label120: ScreenView.Error localError2;
    if (parama.d == 2)
    {
      k = i;
      if (parama.d != i)
        break label179;
      m = i;
      if ((k != 0) || (m != 0))
        break label185;
      localError2 = localError1;
      label133: this.c = localError2;
      if (this.i.a() != -1)
        break label191;
    }
    while (true)
    {
      if ((m == 0) || (i == 0))
        break label196;
      ((e)this.f).c(localError1);
      return;
      k = 0;
      break;
      label179: m = 0;
      break label120;
      label185: localError2 = null;
      break label133;
      label191: i = 0;
    }
    label196: ((e)this.f).a(localError1);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onInviteLinkReceived(final d.c paramc)
  {
    a(new BaseShareLinkPresenter.b(paramc)
    {
      protected boolean a(ScreenView.Error paramAnonymousError)
      {
        return (paramAnonymousError.operation != 2) || ((paramAnonymousError.status != 1) && (paramAnonymousError.status != 2));
      }

      protected boolean b()
      {
        return j.this.a(paramc.a);
      }

      protected boolean b(ScreenView.Error paramAnonymousError)
      {
        int i;
        if ((paramAnonymousError.operation == 0) && (paramAnonymousError.status == 1))
        {
          i = 1;
          if ((paramAnonymousError.operation != 1) || (paramAnonymousError.status != 2))
            break label58;
        }
        label58: for (int j = 1; ; j = 0)
        {
          if (((i == 0) && (j == 0)) || (!super.b(paramAnonymousError)))
            break label63;
          return true;
          i = 0;
          break;
        }
        label63: return false;
      }

      protected boolean c()
      {
        return paramc.c == 0;
      }

      protected String d()
      {
        return paramc.d;
      }

      protected ScreenView.Error e()
      {
        return new ScreenView.Error(paramc.b, paramc.c);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.j
 * JD-Core Version:    0.6.2
 */