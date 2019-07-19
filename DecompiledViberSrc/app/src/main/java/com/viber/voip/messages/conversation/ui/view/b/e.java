package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.viber.common.dialogs.h.a;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.messages.MessageEditText;
import com.viber.voip.messages.adapters.BotKeyboardView.a;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.presenter.ChatExtentionPresenter;
import com.viber.voip.messages.extensions.ui.c.a;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.an;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.messages.ui.l;
import com.viber.voip.messages.ui.m;
import com.viber.voip.messages.ui.x;
import com.viber.voip.ui.dialogs.h;
import javax.annotation.Nullable;

public class e extends a<ChatExtentionPresenter>
  implements com.viber.voip.messages.conversation.ui.view.c
{
  private final MessageComposerView a;
  private com.viber.voip.messages.conversation.ui.e b;
  private m g;
  private ExpandablePanelLayout h;
  private x i;
  private final com.viber.voip.messages.extensions.c j;

  @Nullable
  private final ICdrController k;
  private LayoutInflater l;

  public e(ChatExtentionPresenter paramChatExtentionPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, MessageComposerView paramMessageComposerView, x paramx, ICdrController paramICdrController, com.viber.voip.messages.extensions.c paramc)
  {
    super(paramChatExtentionPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.a = paramMessageComposerView;
    this.k = paramICdrController;
    this.i = paramx;
    this.j = paramc;
    this.l = paramConversationFragment.getLayoutInflater();
    c();
    d();
  }

  private m a(Context paramContext)
  {
    an localan = new an(paramContext);
    localan.a(new f(this));
    ChatExtentionPresenter localChatExtentionPresenter = (ChatExtentionPresenter)this.mPresenter;
    localChatExtentionPresenter.getClass();
    c.a locala = g.a(localChatExtentionPresenter);
    return new m(paramContext, 3, localan, new a(R.id.options_menu_open_old_chat_extensions), this.k, locala, new l(paramContext, this.j), this.j, this.l);
  }

  private void c()
  {
    this.h = ((ExpandablePanelLayout)this.mRootView.findViewById(R.id.conversation_menu));
  }

  private void d()
  {
    this.b = e();
    this.g = a(this.c);
  }

  private com.viber.voip.messages.conversation.ui.e e()
  {
    return new com.viber.voip.messages.conversation.ui.e(this.h, this.i)
    {
      public void a(boolean paramAnonymousBoolean1, int paramAnonymousInt, boolean paramAnonymousBoolean2)
      {
        ((ChatExtentionPresenter)e.a(e.this)).a(paramAnonymousBoolean1, paramAnonymousInt);
        super.a(paramAnonymousBoolean1, paramAnonymousInt, paramAnonymousBoolean2);
      }
    };
  }

  public void a()
  {
    this.b.a();
  }

  public void a(int paramInt)
  {
    this.g.b(paramInt);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    ExpandablePanelLayout localExpandablePanelLayout;
    if (this.h.getVisibility() == 0)
    {
      localExpandablePanelLayout = this.h;
      if (this.h.getVisibility() != 0)
        break label36;
    }
    label36: for (boolean bool = true; ; bool = false)
    {
      localExpandablePanelLayout.b(paramInt, bool);
      return;
    }
  }

  public void a(CharSequence paramCharSequence)
  {
    this.a.getMessageEdit().setHint(paramCharSequence);
  }

  public void a(String paramString1, String paramString2)
  {
    this.a.a(paramString1, paramString2);
  }

  public void b()
  {
    this.g.d();
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.i.n();
  }

  public class a
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
      ((ChatExtentionPresenter)e.c(e.this)).a(paramBotReplyConfig, com.viber.voip.messages.ui.expanel.f.a(this.b));
      ((ChatExtentionPresenter)e.d(e.this)).a(this.b, e.b(e.this).getVisibility());
    }

    public void a(String paramString1, String paramString2, boolean paramBoolean)
    {
      if (e.b(e.this).getPanelId() != this.b);
      while (this.b != R.id.options_menu_open_share_and_shop)
        return;
      h.b().b(e.this.d);
      e.b(e.this).c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.e
 * JD-Core Version:    0.6.2
 */