package com.viber.voip.invitelinks.linkscreen;

import com.viber.voip.invitelinks.n;
import com.viber.voip.invitelinks.n.b;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.util.cj;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public final class k extends BaseShareLinkPresenter<ScreenView>
{
  protected final n j;

  public k(InviteLinkData paramInviteLinkData, g paramg, i parami, a parama, n paramn, cj paramcj)
  {
    super(paramInviteLinkData, paramg, parami, parama, paramn.c(), paramcj);
    this.j = paramn;
  }

  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 2:
    case 3:
      this.e.a();
      return;
    case 1:
    }
    this.e.b();
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

  protected ScreenView.Error d()
  {
    return new ScreenView.Error(0, 1);
  }

  protected void f()
  {
    this.f.a(true);
    this.j.a(this.b.groupId);
  }

  protected void h()
  {
    a(new BaseShareLinkPresenter.a()
    {
      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        k.this.f.a(true);
        k.this.j.a(k.this.b.groupId, paramAnonymousConversationItemLoaderEntity.getGroupName());
      }
    });
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onGroupLinkReceived(final n.b paramb)
  {
    a(new BaseShareLinkPresenter.b(paramb)
    {
      protected boolean a(ScreenView.Error paramAnonymousError)
      {
        return (paramAnonymousError.operation != 2) || ((paramAnonymousError.status != 1) && (paramAnonymousError.status != 2));
      }

      protected boolean b()
      {
        return k.this.a(paramb.a);
      }

      protected boolean b(ScreenView.Error paramAnonymousError)
      {
        int i;
        if ((paramAnonymousError.operation == 0) && (paramAnonymousError.status == 2))
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
        return paramb.c == 0;
      }

      protected String d()
      {
        return paramb.d;
      }

      protected ScreenView.Error e()
      {
        return new ScreenView.Error(paramb.b, paramb.c);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.k
 * JD-Core Version:    0.6.2
 */