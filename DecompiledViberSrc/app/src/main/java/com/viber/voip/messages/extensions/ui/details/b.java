package com.viber.voip.messages.extensions.ui.details;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.Map;
import com.viber.voip.messages.MessageEditText.a;
import com.viber.voip.messages.adapters.BotKeyboardView;
import com.viber.voip.messages.adapters.BotKeyboardView.a;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.extensions.b.b.a;
import com.viber.voip.messages.ui.an;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.util.ViberActionRunner.ai;
import com.viber.voip.util.db;
import com.viber.voip.util.dj;

public class b extends com.viber.voip.mvp.core.d<ChatExtensionDetailsPresenter>
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Fragment b;
  private TextView c;
  private ImageView d;
  private View e;
  private EditText f;
  private ImageView g;
  private BotKeyboardView h;
  private View i;
  private an j;
  private com.viber.common.ui.c k;
  private Drawable l;
  private final com.viber.voip.util.e.e m;
  private final com.viber.voip.util.e.f n;
  private final b.a o;
  private final TextWatcher p = new db()
  {
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      ((ChatExtensionDetailsPresenter)b.a(b.this)).a(paramAnonymousCharSequence.toString());
    }
  };
  private final BotKeyboardView.a q = new BotKeyboardView.a()
  {
    public void a()
    {
    }

    public void a(String paramAnonymousString1, String paramAnonymousString2, BotReplyConfig paramAnonymousBotReplyConfig, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      b.a(b.this, paramAnonymousBoolean1, paramAnonymousBotReplyConfig);
    }

    public void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
    {
      b.a(b.this, false, null);
      if (b.b(b.this) != null)
        b.c(b.this).a(b.b(b.this));
    }
  };
  private final com.viber.voip.bot.item.a r;

  public b(ChatExtensionDetailsPresenter paramChatExtensionDetailsPresenter, View paramView, Fragment paramFragment, com.viber.voip.util.e.e parame, b.a parama)
  {
    super(paramChatExtensionDetailsPresenter, paramView);
    ChatExtensionDetailsPresenter localChatExtensionDetailsPresenter = (ChatExtensionDetailsPresenter)this.mPresenter;
    localChatExtensionDetailsPresenter.getClass();
    this.r = c.a(localChatExtensionDetailsPresenter);
    this.b = paramFragment;
    Context localContext = paramView.getContext();
    this.n = com.viber.voip.util.e.f.c(localContext);
    this.m = parame;
    this.o = parama;
    Toolbar localToolbar = (Toolbar)paramView.findViewById(R.id.toolbar);
    this.c = ((TextView)paramView.findViewById(R.id.chatexNameView));
    this.d = ((ImageView)paramView.findViewById(R.id.chatexIconView));
    this.f = ((EditText)paramView.findViewById(R.id.searchViewInputText));
    this.e = paramView.findViewById(R.id.searchViewGroup);
    this.g = ((ImageView)paramView.findViewById(R.id.clearSearchView));
    this.h = ((BotKeyboardView)paramView.findViewById(R.id.botKeyboardView));
    this.l = DrawableCompat.wrap(ContextCompat.getDrawable(localContext, R.drawable.ic_ab_theme_dark_search).mutate());
    this.j = new an(localContext);
    localToolbar.setNavigationOnClickListener(new d(this));
  }

  private void a(Intent paramIntent)
  {
    BotReplyRequest localBotReplyRequest = (BotReplyRequest)paramIntent.getParcelableExtra("extra_bot_reply_pending_request");
    double d1 = paramIntent.getIntExtra("extra_location_lat", 0) / 1000000.0D;
    double d2 = paramIntent.getIntExtra("extra_location_lon", 0) / 1000000.0D;
    String str = paramIntent.getStringExtra("extra_location_text");
    ((ChatExtensionDetailsPresenter)this.mPresenter).a(localBotReplyRequest, d1, d2, str);
  }

  private void a(boolean paramBoolean, BotReplyConfig paramBotReplyConfig)
  {
    if (paramBotReplyConfig != null)
    {
      g();
      this.h.a(paramBotReplyConfig, paramBoolean);
      return;
    }
    g();
    this.h.addView(this.j.b(f()), 2);
    this.h.a();
  }

  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.f.setText(paramString);
      this.f.setSelection(paramString.length());
    }
  }

  private String d()
  {
    return this.f.getText().toString().trim();
  }

  private void e()
  {
    this.f.setText(null);
    dj.c(this.f);
    ((ChatExtensionDetailsPresenter)this.mPresenter).a(null, "Keyboard");
  }

  private View f()
  {
    if (this.i == null)
      this.i = this.j.a();
    return this.i;
  }

  private void g()
  {
    if (this.i == null)
      return;
    this.j.c(this.i);
    if (this.i != null);
    for (ViewGroup localViewGroup = (ViewGroup)this.i.getParent(); ; localViewGroup = null)
    {
      if (localViewGroup != null)
        localViewGroup.removeView(this.i);
      this.i = null;
      return;
    }
  }

  private void h()
  {
    if ((this.k != null) && (this.k.d()))
      this.k.b();
  }

  public void a()
  {
    this.o.a();
  }

  public void a(Map paramMap)
  {
    ViberActionRunner.ai.a(this.b.requireContext(), paramMap);
  }

  public void a(BotReplyRequest paramBotReplyRequest)
  {
    ViberActionRunner.ai.a(this.b, paramBotReplyRequest);
  }

  public void a(i parami, boolean paramBoolean)
  {
    Resources localResources = this.mRootView.getResources();
    Context localContext = this.mRootView.getContext();
    this.f.addTextChangedListener(this.p);
    this.f.setHint(parami.b);
    this.g.setOnClickListener(new f(this));
    dj.a(this.g, localResources.getDimensionPixelSize(R.dimen.small_button_touch_area));
    b(parami.a);
    if (parami.d)
    {
      DrawableCompat.setTint(this.l, ContextCompat.getColor(localContext, R.color.dark_gray));
      this.f.setCompoundDrawablesWithIntrinsicBounds(this.l, null, null, null);
    }
    MessageEditText.a locala = parami.c;
    EditText localEditText = this.f;
    if (paramBoolean);
    for (int i1 = locala.f; ; i1 = locala.g)
    {
      localEditText.setImeOptions(i1);
      this.f.setOnEditorActionListener(new g(this));
      a(true, null);
      return;
    }
  }

  public void a(String paramString)
  {
    this.h.a(3);
    this.h.setPublicAccountId(paramString);
    this.h.setBotKeyboardActionListener(this.r);
    this.h.setKeyboardStateListener(this.q);
    this.j.a(new e(this));
  }

  public void a(String paramString, Uri paramUri)
  {
    this.c.setText(paramString);
    this.m.a(paramUri, this.d, this.n);
  }

  public void a(String paramString, BotReplyRequest paramBotReplyRequest)
  {
    r.a(paramString, paramBotReplyRequest).b(this.b);
  }

  public void a(boolean paramBoolean)
  {
    dj.b(this.g, paramBoolean);
  }

  public void b()
  {
    if (this.k == null)
      this.k = com.viber.voip.ui.k.a.a(this.b.requireContext(), this.f);
    if ((ViewCompat.isAttachedToWindow(this.f)) && (this.f.getWidth() > 0) && (this.f.getHeight() > 0))
    {
      this.k.a();
      return;
    }
    dj.a(this.f, new h(this));
  }

  public void b(boolean paramBoolean)
  {
    dj.b(this.e, paramBoolean);
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 105) && (paramInt2 == -1))
    {
      a(paramIntent);
      return true;
    }
    return false;
  }

  public boolean onBackPressed()
  {
    h();
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.details.b
 * JD-Core Version:    0.6.2
 */