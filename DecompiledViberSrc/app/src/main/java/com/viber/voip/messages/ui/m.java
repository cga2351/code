package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.messages.adapters.BotKeyboardView;
import com.viber.voip.messages.adapters.BotKeyboardView.a;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.extensions.ui.c.a;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.util.j.a.a;
import com.viber.voip.widget.ListViewWithAnimatedView;
import java.util.concurrent.TimeUnit;

public class m extends t
{
  protected static final Logger a = ViberEnv.getLogger();
  private static final long f = TimeUnit.SECONDS.toMillis(6L);
  private final l g;
  private final com.viber.voip.util.e.e h;
  private final int i;
  private final com.viber.voip.messages.extensions.c j;
  private View k;
  private RecyclerView l;
  private com.viber.voip.messages.extensions.ui.c m;
  private an n;
  private final c.a o;
  private LayoutInflater p;

  public m(Context paramContext, int paramInt, an paraman, BotKeyboardView.a parama, ICdrController paramICdrController, c.a parama1, l paraml, com.viber.voip.messages.extensions.c paramc, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramInt, paraman, paramICdrController, parama);
    this.h = com.viber.voip.util.e.e.a(paramContext);
    this.o = parama1;
    this.n = paraman;
    this.g = paraml;
    this.i = paramContext.getResources().getDimensionPixelSize(R.dimen.keyboard_extension_filter_item_height);
    this.j = paramc;
    this.p = paramLayoutInflater;
  }

  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ICdrController localICdrController;
    int i1;
    String str;
    if ((this.e != null) && (paramBoolean2))
    {
      localICdrController = this.e;
      i1 = 1 + e(paramString1);
      str = da.e(paramString2);
      if (!paramBoolean1)
        break label57;
    }
    label57: for (int i2 = 0; ; i2 = 1)
    {
      localICdrController.handleReportShiftKeySearch(null, i1, str, i2, paramString1);
      return;
    }
  }

  private void b(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity)
  {
    if (paramChatExtensionLoaderEntity == null)
      return;
    String str1 = paramChatExtensionLoaderEntity.getPublicAccountId();
    this.j.f(str1);
    this.c.setPublicAccountId(str1);
    if (!str1.equals(this.m.a()))
    {
      String str2 = this.m.a();
      b(str1);
      c(str2);
      c(str1);
      a(null, true);
    }
    while (true)
    {
      this.o.a(paramChatExtensionLoaderEntity);
      return;
      if (this.d != null)
        this.n.b(this.d);
    }
  }

  private void b(String paramString)
  {
    if ((this.k == null) || (this.m == null))
      return;
    if (this.j.e(paramString))
    {
      this.k.setSelected(true);
      this.m.a(null);
      return;
    }
    this.m.a(paramString);
    this.k.setSelected(false);
  }

  private void c(String paramString)
  {
    int i1 = e(paramString);
    if (-1 != i1)
      this.m.notifyItemChanged(i1, com.viber.voip.messages.extensions.ui.c.a);
  }

  private ChatExtensionLoaderEntity d(String paramString)
  {
    int i1 = e(paramString);
    if (-1 != i1)
      return this.m.a(i1);
    return null;
  }

  private int e(String paramString)
  {
    return this.m.b(paramString);
  }

  private void l()
  {
    String str = this.j.k();
    if (this.j.e(str))
      return;
    a.a(this.l, e(str));
  }

  private com.viber.voip.messages.extensions.ui.c m()
  {
    return new com.viber.voip.messages.extensions.ui.c(new o(this), this.p);
  }

  public View a(View paramView)
  {
    String str = this.j.k();
    if (paramView == null)
    {
      View localView1 = super.a(null);
      this.p.inflate(R.layout.keyboard_extension_filter_layout, (FrameLayout)localView1);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView1.findViewById(R.id.progress).getLayoutParams();
      localLayoutParams.bottomMargin += this.i;
      View localView2 = dj.d(localView1, R.id.keyboardExtensionContainerView);
      this.k = dj.d(localView1, R.id.favoriteLinksView);
      ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.j.d();
      if (localChatExtensionLoaderEntity != null)
      {
        ImageView localImageView = (ImageView)this.k.findViewById(R.id.keyboard_extension_logo_icon);
        TextView localTextView = (TextView)this.k.findViewById(R.id.keyboard_extension_name);
        this.h.a(localChatExtensionLoaderEntity.getIconOld(), localImageView, f.a());
        localTextView.setText(localChatExtensionLoaderEntity.getName());
      }
      View localView3 = this.k;
      if (localChatExtensionLoaderEntity != null);
      for (boolean bool = true; ; bool = false)
      {
        dj.b(localView3, bool);
        this.k.setOnClickListener(new n(this, localChatExtensionLoaderEntity));
        this.l = ((RecyclerView)dj.d(localView1, R.id.keyboard_extension_filter_items));
        this.l.setItemAnimator(null);
        this.m = m();
        b(str);
        this.g.a(this.m);
        this.g.a(true, str);
        l();
        this.l.setAdapter(this.m);
        ((ListViewWithAnimatedView)dj.d(localView1, R.id.list_view)).setAnimatedView(localView2);
        return localView1;
      }
    }
    this.g.a(false, str);
    l();
    return paramView;
  }

  protected void a(int paramInt)
  {
    if (this.e != null)
      this.e.handleReportInstantKeyboardOpen(paramInt, null, 1 + e(this.c.getPublicAccountId()), 2, this.c.getPublicAccountId());
  }

  public void a(String paramString)
  {
  }

  public void a(String paramString1, ReplyButton paramReplyButton, String paramString2)
  {
    if ((this.e != null) && (paramReplyButton.getReplyType() == ReplyButton.b.MESSAGE) && (com.viber.voip.publicaccount.d.e.a(paramReplyButton.getActionType())))
    {
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.d(Boolean.TRUE));
      this.e.handleReportShiftKeyMessageSent(null, 1 + e(paramString1), null, da.e(paramString2), paramString1);
    }
  }

  public void a(String paramString1, String paramString2, BotReplyConfig paramBotReplyConfig, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramString1, paramString2, paramBotReplyConfig, paramBoolean1, paramBoolean2);
    a(paramString1, paramString2, false, paramBoolean2);
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(null);
    if (this.d != null)
      this.n.a(this.d);
    a(paramString1, paramString2, true, paramBoolean);
  }

  protected void b()
  {
    View localView = new View(this.b);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, this.i));
    this.c.a(localView);
    this.c.setTimeoutTime(f);
    super.b();
  }

  public String c()
  {
    return this.j.k();
  }

  public void d()
  {
    this.g.a();
  }

  public void i()
  {
    String str = this.j.k();
    if (this.j.e(str))
      b(this.j.d());
    while (true)
    {
      a(e());
      b(5);
      return;
      b(d(str));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.m
 * JD-Core Version:    0.6.2
 */