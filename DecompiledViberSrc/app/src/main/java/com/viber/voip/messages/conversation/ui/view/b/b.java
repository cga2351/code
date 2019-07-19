package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.util.SparseArrayCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.i.c.h;
import com.viber.voip.i.c.m;
import com.viber.voip.messages.MessageEditText;
import com.viber.voip.messages.adapters.BotKeyboardView;
import com.viber.voip.messages.adapters.BotKeyboardView.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.be;
import com.viber.voip.messages.conversation.ui.presenter.BottomPanelPresenter;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.an;
import com.viber.voip.messages.ui.ao;
import com.viber.voip.messages.ui.cv.a;
import com.viber.voip.messages.ui.d.h;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.BotKeyboardAbsolutePercentHeightSpec;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.HeightSpec;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.a;
import com.viber.voip.messages.ui.l;
import com.viber.voip.messages.ui.m;
import com.viber.voip.messages.ui.t;
import com.viber.voip.messages.ui.w;
import com.viber.voip.messages.ui.x;
import com.viber.voip.settings.d.n;
import com.viber.voip.ui.dialogs.h;
import com.viber.voip.util.ViberActionRunner.m;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;

public class b extends a<BottomPanelPresenter>
  implements com.viber.voip.messages.conversation.ui.view.b
{
  private static final Logger a = ViberEnv.getLogger();
  private ExpandablePanelLayout b;
  private final com.viber.voip.messages.conversation.ui.b.a g;
  private final z h;
  private final w i;
  private final com.viber.voip.messages.ui.d j;
  private final t k;
  private com.viber.voip.messages.ui.view.k l;
  private final MessageComposerView m;
  private final x n;
  private m o;
  private ICdrController p;
  private com.viber.voip.messages.conversation.ui.e q;
  private be r;
  private com.viber.voip.bot.item.a s;
  private com.viber.voip.messages.extensions.c t;
  private LayoutInflater u;

  public b(BottomPanelPresenter paramBottomPanelPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, com.viber.voip.messages.conversation.ui.b.a parama, z paramz, w paramw, com.viber.voip.messages.ui.d paramd, t paramt, MessageComposerView paramMessageComposerView, x paramx, ICdrController paramICdrController, be parambe, com.viber.voip.bot.item.a parama1, com.viber.voip.messages.extensions.c paramc)
  {
    super(paramBottomPanelPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.g = parama;
    this.h = paramz;
    this.i = paramw;
    this.j = paramd;
    this.k = paramt;
    this.m = paramMessageComposerView;
    this.n = paramx;
    this.p = paramICdrController;
    this.r = parambe;
    this.s = parama1;
    this.t = paramc;
    this.u = paramConversationFragment.getLayoutInflater();
    l();
    m();
  }

  private m a(Context paramContext)
  {
    an localan = new an(paramContext);
    localan.a(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (cj.a(true))
        {
          String str = b.d(b.this).k();
          b.e(b.this).a(str, b.a(b.this).a(str));
        }
      }
    });
    d locald = new d(this);
    return new m(paramContext, 3, localan, new a(R.id.options_menu_open_old_chat_extensions), this.p, locald, new l(paramContext, this.t), this.t, this.u);
  }

  private void a(final com.viber.voip.bot.item.a parama)
  {
    this.k.a(parama);
    this.o.a(new com.viber.voip.bot.item.a()
    {
      public void a(String paramAnonymousString, BotReplyConfig paramAnonymousBotReplyConfig, ReplyButton paramAnonymousReplyButton)
      {
        b.b(b.this).a(paramAnonymousString, paramAnonymousReplyButton, b.a(b.this).a(paramAnonymousString));
        parama.a(paramAnonymousString, paramAnonymousBotReplyConfig, paramAnonymousReplyButton);
        ((BottomPanelPresenter)b.c(b.this)).a(paramAnonymousReplyButton);
      }
    });
  }

  private void l()
  {
    this.b = ((ExpandablePanelLayout)this.mRootView.findViewById(R.id.conversation_menu));
    this.l = new com.viber.voip.messages.ui.view.k(this.mRootView, this.m);
    this.o = a(this.c);
    this.q = o();
  }

  private void m()
  {
    this.n.a(this.m.getMessageEdit());
    this.j.a((d.h)this.mPresenter);
    this.m.setOnButtonsListener(this.q);
    a(this.s);
    SparseArrayCompat localSparseArrayCompat = new SparseArrayCompat(6);
    localSparseArrayCompat.put(R.id.options_menu_open_extra_section, this.j);
    localSparseArrayCompat.put(R.id.options_menu_open_stickers, this.n);
    localSparseArrayCompat.put(R.id.options_menu_open_gallery, this.i);
    localSparseArrayCompat.put(R.id.bot_keyboard, this.k);
    localSparseArrayCompat.put(R.id.options_menu_open_old_chat_extensions, this.o);
    this.b.setAdapter(new ao(new ExpandablePanelLayout.a(this.b), localSparseArrayCompat));
    this.b.setStateListener(this.g);
    k();
  }

  private void n()
  {
    if (!this.b.b(R.id.options_menu_open_stickers))
      this.b.a(R.id.options_menu_open_stickers, true);
  }

  private com.viber.voip.messages.conversation.ui.e o()
  {
    return new com.viber.voip.messages.conversation.ui.e(this.b, this.n)
    {
      public void a(boolean paramAnonymousBoolean1, int paramAnonymousInt, boolean paramAnonymousBoolean2)
      {
        if ((paramAnonymousBoolean1) && (!b.f(b.this).b(R.id.options_menu_open_old_chat_extensions)) && (paramAnonymousBoolean2) && (c.m.a.e()) && (d.n.h.d()) && (cj.a(ViberApplication.getApplication()).a() == 0))
        {
          com.viber.voip.ui.dialogs.k.A().a(false).a(new com.viber.voip.ui.dialogs.a.a.a(paramAnonymousInt, this)).b(b.this.d);
          return;
        }
        if (paramAnonymousBoolean1)
        {
          if (2 != paramAnonymousInt)
            break label141;
          b.b(b.this).b(11);
        }
        while (true)
        {
          if ((paramAnonymousBoolean1) && (!b.a(b.this).m()))
            b.b(b.this).d();
          super.a(paramAnonymousBoolean1, paramAnonymousInt, paramAnonymousBoolean2);
          return;
          label141: if (3 == paramAnonymousInt)
            b.b(b.this).b(13);
        }
      }
    };
  }

  public void a()
  {
    this.i.a();
  }

  public void a(int paramInt)
  {
    this.m.a(paramInt);
  }

  public void a(int paramInt1, int paramInt2, View paramView)
  {
    this.l.a(paramInt1, paramInt2, paramView);
  }

  public void a(BotReplyConfig paramBotReplyConfig)
  {
    if (paramBotReplyConfig != null)
      this.l.a(paramBotReplyConfig.getInputFieldState());
  }

  public void a(BotReplyConfig paramBotReplyConfig, com.viber.voip.messages.ui.expanel.d paramd)
  {
    Object localObject = paramd.b();
    if ((paramd.c()) && (paramBotReplyConfig != null))
    {
      if (paramBotReplyConfig.getCustomDefaultHeightPercent() == null)
        break label52;
      localObject = new ExpandablePanelLayout.BotKeyboardAbsolutePercentHeightSpec(paramBotReplyConfig.getCustomDefaultHeightPercent().intValue());
    }
    while (true)
    {
      this.b.a((ExpandablePanelLayout.HeightSpec)localObject, paramd);
      return;
      label52: if (!paramBotReplyConfig.isDefaultHeight())
        localObject = ((BotKeyboardView)this.b.a(paramd.a())).getFullHeightSpec();
    }
  }

  public void a(BotReplyConfig paramBotReplyConfig, String paramString, boolean paramBoolean)
  {
    int i1 = 1;
    this.k.a(paramString);
    this.k.a(paramBotReplyConfig);
    label92: ExpandablePanelLayout localExpandablePanelLayout1;
    int i2;
    if (paramBoolean)
    {
      this.g.a(paramBotReplyConfig, com.viber.voip.messages.ui.expanel.f.a(R.id.bot_keyboard));
      if (!this.b.b(R.id.bot_keyboard))
      {
        this.b.a(R.id.bot_keyboard, false);
        dj.c(this.m);
      }
    }
    else
    {
      if ((this.b.getPanelState() != 3) && (this.b.getPanelState() != i1))
        break label164;
      localExpandablePanelLayout1 = this.b;
      i2 = 0;
      if (i1 == 0)
        break label170;
    }
    while (true)
    {
      localExpandablePanelLayout1.setVisibility(i2);
      this.m.q();
      return;
      ExpandablePanelLayout localExpandablePanelLayout2 = this.b;
      int i3 = R.id.bot_keyboard;
      if (this.b.getVisibility() == 0);
      int i5;
      for (int i4 = i1; ; i5 = 0)
      {
        localExpandablePanelLayout2.b(i3, i4);
        break;
      }
      label164: i1 = 0;
      break label92;
      label170: i2 = 8;
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString1, int paramInt, String paramString2)
  {
    a(paramConversationItemLoaderEntity, paramString1, null, paramInt, paramString2);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    int i1 = -1;
    if ((com.viber.voip.messages.d.a.d(paramConversationItemLoaderEntity)) && (com.viber.voip.publicaccount.d.e.b(paramString1)))
      i1 = R.id.options_menu_open_share_and_shop;
    while (i1 < 0)
    {
      h.a().b(this.d);
      return;
      if ((com.viber.voip.messages.d.a.a(paramConversationItemLoaderEntity, this.t)) && (this.t.c(paramString1)))
      {
        if (c.h.f.e())
        {
          ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.t.a(paramString1);
          ViberActionRunner.m.a(this.d, paramConversationItemLoaderEntity, localChatExtensionLoaderEntity, paramString2, this.f, paramString3);
          dj.c(this.m);
          return;
        }
        i1 = R.id.options_menu_open_chat_extensions;
        this.t.f(paramString1);
        this.o.b(paramInt);
        if (this.b.b(R.id.options_menu_open_chat_extensions))
          this.o.i();
      }
    }
    if (i1 == R.id.options_menu_open_chat_extensions)
      this.q.a(true, 0, true);
    while (true)
    {
      dj.c(this.m);
      return;
      this.b.a(i1, true);
    }
  }

  public void a(com.viber.voip.stickers.entity.a parama)
  {
    dj.c(this.m);
    if (!this.n.d())
    {
      this.n.r().a(parama.e(), false);
      this.n.a(parama.e(), null);
      this.n.g();
      n();
      return;
    }
    this.n.g();
    this.n.a(parama.e(), new c(this, parama));
  }

  public int b()
  {
    return this.l.a();
  }

  public void b(int paramInt)
  {
    this.l.b(paramInt);
  }

  public void c()
  {
    this.k.f();
    this.m.q();
    this.q.b(false);
  }

  public void c(int paramInt)
  {
    this.o.b(paramInt);
  }

  public void d()
  {
    this.k.f();
  }

  public void e()
  {
    this.i.a();
  }

  public void f()
  {
    this.m.c();
  }

  public void g()
  {
    this.b.c();
  }

  public void h()
  {
    if (this.b.b(R.id.options_menu_open_gallery))
      this.b.c();
  }

  public void i()
  {
    dj.c(this.m);
  }

  public void j()
  {
    this.m.w();
  }

  public void k()
  {
    Resources localResources;
    int i1;
    int i2;
    if (!this.f)
    {
      localResources = this.d.getResources();
      i1 = MessageEditText.a(5, localResources.getDimensionPixelSize(R.dimen.msg_edit_text_height_three_line), localResources.getDimensionPixelSize(R.dimen.msg_edit_text_height_two_line));
      i2 = localResources.getDimensionPixelSize(R.dimen.msg_edit_text_height_one_line) / 3;
      if (!dj.c(this.d.getActivity()))
        break label116;
    }
    label116: for (int i3 = Math.max(localResources.getDimensionPixelSize(R.dimen.msg_edit_text_height_one_line) + (localResources.getDimensionPixelSize(R.dimen.video_ptt_record_landscape_min_size) + 2 * localResources.getDimensionPixelSize(R.dimen.video_ptt_record_landscape_vertical_margin)), i1 + i2); ; i3 = i1 + i2)
    {
      this.b.setTopMargin(i3 + localResources.getDimensionPixelSize(R.dimen.composer_btn_height) + localResources.getDimensionPixelSize(R.dimen.composer_btn_margin_bottom));
      return;
    }
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ((BottomPanelPresenter)this.mPresenter).g();
    return false;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    k();
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.i.f();
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.m.l();
    if (this.b != null)
    {
      if (!paramBoolean)
        break label38;
      this.b.a();
    }
    while (true)
    {
      this.r.a(paramBoolean);
      return;
      label38: this.b.b();
    }
  }

  public void onPause()
  {
    this.n.p();
  }

  public void onResume()
  {
    this.n.o();
  }

  public void onStart()
  {
    this.i.d();
  }

  public void onStop()
  {
    this.i.e();
  }

  private class a
    implements BotKeyboardView.a
  {
    private final int b;

    public a(int arg2)
    {
      int i;
      this.b = i;
    }

    public void a()
    {
    }

    public void a(String paramString1, String paramString2, BotReplyConfig paramBotReplyConfig, boolean paramBoolean1, boolean paramBoolean2)
    {
      b.g(b.this).a(paramBotReplyConfig, com.viber.voip.messages.ui.expanel.f.a(this.b));
      ExpandablePanelLayout localExpandablePanelLayout;
      int i;
      if (b.f(b.this).getVisibility() == 0)
      {
        localExpandablePanelLayout = b.f(b.this);
        i = this.b;
        if (b.f(b.this).getVisibility() != 0)
          break label72;
      }
      label72: for (boolean bool = true; ; bool = false)
      {
        localExpandablePanelLayout.b(i, bool);
        return;
      }
    }

    public void a(String paramString1, String paramString2, boolean paramBoolean)
    {
      if (b.f(b.this).getPanelId() != this.b);
      while (this.b != R.id.options_menu_open_share_and_shop)
        return;
      h.b().b(b.this.d);
      b.f(b.this).c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.b
 * JD-Core Version:    0.6.2
 */