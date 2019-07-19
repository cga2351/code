package com.viber.voip.messages.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.bot.a.b;
import com.viber.voip.bot.item.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.a;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.DefaultHeightSpec;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.HeightSpec;
import com.viber.voip.util.dj;
import java.util.concurrent.TimeUnit;

public class BotKeyboardView extends FrameLayout
  implements bv.a
{
  protected static final Logger a = ViberEnv.getLogger();
  private static final BotReplyConfig e = new BotReplyConfig();
  private static final long f = TimeUnit.SECONDS.toMillis(15L);
  protected a b;
  protected View c = LayoutInflater.from(getContext()).inflate(R.layout.bot_keyboard_layout, this);
  protected int d = 0;
  private ListView g = (ListView)findViewById(R.id.list_view);
  private d h;
  private e i;
  private View j = findViewById(R.id.progress);
  private bv k;
  private String l;
  private boolean m;
  private String n;
  private long o = f;
  private final Runnable p = new Runnable()
  {
    public void run()
    {
      BotKeyboardView.a(BotKeyboardView.this).smoothScrollToPositionFromTop(0, 0);
      BotKeyboardView.a(BotKeyboardView.this).setSelectionFromTop(0, 0);
    }
  };
  private final Runnable q = new Runnable()
  {
    public void run()
    {
      dj.b(BotKeyboardView.c(BotKeyboardView.this), true);
    }
  };
  private final Runnable r = new Runnable()
  {
    public void run()
    {
      BotKeyboardView.this.a(BotKeyboardView.b(BotKeyboardView.this));
    }
  };

  static
  {
    e.setButtons(new ReplyButton[0]);
  }

  public BotKeyboardView(Context paramContext)
  {
    this(paramContext, null);
  }

  public BotKeyboardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public BotKeyboardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private boolean b()
  {
    return (dj.c(getContext())) || (ViberApplication.isTablet(getContext()));
  }

  private void c()
  {
    if (this.h.getCount() > 1)
      av.a(av.e.a).postDelayed(this.q, 500L);
  }

  private void d()
  {
    if (this.d == 3)
      this.k.a(this);
  }

  private void e()
  {
    this.k.b(this);
  }

  public void a()
  {
    dj.b(this.g, false);
    dj.b(this.j, false);
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
    if (b())
      this.g.getLayoutParams().width = getContext().getResources().getDimensionPixelSize(R.dimen.share_and_shop_landscape_width);
    this.h = new d(getContext(), new b(getContext()), LayoutInflater.from(getContext()));
    this.h.c(paramInt);
    this.g.setAdapter(this.h);
    this.k = ViberApplication.getInstance().getMessagesManager().b();
    d();
  }

  public void a(View paramView)
  {
    this.g.addFooterView(paramView);
  }

  public void a(BotReplyConfig paramBotReplyConfig, boolean paramBoolean)
  {
    dj.b(this.j, paramBoolean);
    av.a(av.e.a).removeCallbacks(this.q);
    av.a(av.e.a).removeCallbacks(this.r);
    dj.b(this.g, true);
    this.h.a(paramBotReplyConfig);
    av.a(av.e.a).post(this.p);
    int i1 = paramBotReplyConfig.getBgColor().intValue();
    if (i1 != 0);
    while (true)
    {
      setBackgroundColor(i1);
      this.i = new e(paramBotReplyConfig);
      return;
      i1 = 15987699;
    }
  }

  public void a(String paramString)
  {
    if (!paramString.equals(this.n));
    do
    {
      return;
      dj.b(this.j, false);
      setBackgroundColor(ContextCompat.getColor(getContext(), R.color.dark_background));
    }
    while (this.b == null);
    this.b.a(this.n, this.l, this.m);
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig)
  {
    if (!paramString.equals(this.n));
    boolean bool;
    do
    {
      return;
      bool = ViberApplication.getInstance().getMessagesManager().h().c(paramString);
      dj.b(this.j, false);
    }
    while (this.b == null);
    this.b.a(this.n, this.l, paramBotReplyConfig, bool, this.m);
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramString2.equals(this.n))
      return;
    av.a(av.e.a).removeCallbacks(this.r);
    av.a(av.e.a).postDelayed(this.r, this.o);
    c();
    if (this.b != null)
      this.b.a();
    this.l = paramString1;
    this.m = paramBoolean;
  }

  public ExpandablePanelLayout.HeightSpec getFullHeightSpec()
  {
    return new ExpandablePanelLayout.DefaultHeightSpec((int)this.i.a(), (int)this.i.b());
  }

  public String getPublicAccountId()
  {
    return this.n;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    e();
    this.b = null;
    av.a(av.e.a).removeCallbacks(this.r);
    av.a(av.e.a).removeCallbacks(this.q);
  }

  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (b())
    {
      this.h.d(getContext().getResources().getDimensionPixelSize(R.dimen.share_and_shop_landscape_width));
      return;
    }
    this.h.d(paramInt1);
  }

  public void setBotKeyboardActionListener(final a parama)
  {
    this.h.a(new a()
    {
      public void a(String paramAnonymousString, BotReplyConfig paramAnonymousBotReplyConfig, ReplyButton paramAnonymousReplyButton)
      {
        parama.a(BotKeyboardView.b(BotKeyboardView.this), null, paramAnonymousReplyButton);
      }
    });
  }

  public void setKeyboardStateListener(a parama)
  {
    this.b = parama;
  }

  public void setPublicAccountId(String paramString)
  {
    if (!paramString.equals(this.n))
    {
      this.n = paramString;
      this.h.a(e);
      setBackgroundColor(ContextCompat.getColor(getContext(), R.color.dark_background));
    }
  }

  public void setTimeoutTime(long paramLong)
  {
    this.o = paramLong;
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(String paramString1, String paramString2, BotReplyConfig paramBotReplyConfig, boolean paramBoolean1, boolean paramBoolean2);

    public abstract void a(String paramString1, String paramString2, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.BotKeyboardView
 * JD-Core Version:    0.6.2
 */