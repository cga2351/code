package com.viber.voip.messages.conversation.ui;

import com.viber.common.b.b;
import com.viber.common.dialogs.h.a;
import com.viber.voip.ViberApplication;
import com.viber.voip.camrecorder.preview.d;
import com.viber.voip.camrecorder.preview.d.b;
import com.viber.voip.camrecorder.preview.d.c;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.b.v;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.ui.d.j;
import com.viber.voip.settings.d.bm.a;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.ui.t.a;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;
import com.viber.voip.util.ViberActionRunner.br;
import com.viber.voip.util.ViberActionRunner.br.a;
import com.viber.voip.util.cg;
import com.viber.voip.util.cj;
import com.viber.voip.viberwallet.ViberWalletWebActivity;
import com.viber.voip.wallet.a;
import com.viber.voip.wallet.a.a;
import com.viber.voip.wallet.a.b;
import com.viber.voip.wallet.a.c;
import java.util.ArrayList;

public class i
  implements d.j, t.a
{
  private final ConversationFragment a;
  private final v b;
  private d c;
  private int d = 0;
  private a.a e = new a.a()
  {
    public void a(int paramAnonymousInt, a.c paramAnonymousc, String paramAnonymousString, a.b paramAnonymousb)
    {
      if (i.a(i.this) == paramAnonymousInt)
      {
        i.a(i.this, 0);
        i.b(i.this).a(t.c.b, t.b.a.b);
        if (paramAnonymousc == a.c.a)
        {
          ConversationItemLoaderEntity localConversationItemLoaderEntity = i.c(i.this).ah().j();
          boolean bool1 = false;
          if (localConversationItemLoaderEntity != null)
          {
            boolean bool2 = localConversationItemLoaderEntity.isSecret();
            bool1 = false;
            if (bool2)
              bool1 = true;
          }
          ViberActionRunner.br.a(i.c(i.this).getActivity(), paramAnonymousString, ViberActionRunner.br.a.d, bool1);
        }
      }
      else
      {
        return;
      }
      f.d().b(i.c(i.this));
    }
  };

  public i(ConversationFragment paramConversationFragment, v paramv)
  {
    this.a = paramConversationFragment;
    this.b = paramv;
  }

  private d n()
  {
    if (this.c == null)
      this.c = new d(new d.b(this.a))
      {
        protected int a()
        {
          return 10;
        }

        protected int b()
        {
          return 9;
        }

        protected int c()
        {
          return 104;
        }
      };
    return this.c;
  }

  public void H_()
  {
  }

  public void a()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.a.ah().j();
    a locala = ViberApplication.getInstance().getWalletController();
    String str = localConversationItemLoaderEntity.getNumber();
    if (locala.f())
      ViberWalletWebActivity.a(cg.b(str), 1, localConversationItemLoaderEntity.isSecret());
    do
    {
      do
      {
        return;
        if (!locala.g())
          break;
        ViberActionRunner.br.a(ViberApplication.getApplication(), localConversationItemLoaderEntity.getParticipantName(), 1);
      }
      while (!d.bm.a.a.d());
      d.bm.a.a.a(false);
      return;
    }
    while ((this.d != 0) || (!cj.a(true)) || (!locala.a(str)));
    this.b.a(t.c.b, t.b.a.a, 1000L);
    if (localConversationItemLoaderEntity.getContactId() > 0L)
    {
      this.d = locala.a(str, localConversationItemLoaderEntity.getParticipantName(), a.b.e, this.e);
      return;
    }
    this.d = locala.a(str, localConversationItemLoaderEntity.getParticipantName(), a.b.f, this.e);
  }

  public void a(t.c paramc)
  {
    if (paramc == t.c.b)
    {
      ViberApplication.getInstance().getWalletController().a(this.d);
      this.d = 0;
    }
  }

  public void a(ArrayList<GalleryItem> paramArrayList)
  {
    ConversationData localConversationData = this.a.P();
    if (localConversationData != null)
      n().a(localConversationData, paramArrayList, null);
  }

  public void a(boolean paramBoolean, String paramString1, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString2)
  {
  }

  public void b()
  {
  }

  public void c()
  {
  }

  public void d()
  {
  }

  public void e()
  {
  }

  public void f()
  {
  }

  public void g()
  {
  }

  public void h()
  {
  }

  public void j()
  {
  }

  public void k()
  {
  }

  public void l()
  {
  }

  public void m()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.i
 * JD-Core Version:    0.6.2
 */