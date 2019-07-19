package com.viber.voip.messages.extensions.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.i;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser.b;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser.c;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.messages.a.f.a;
import com.viber.voip.messages.a.f.a.a;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage.a;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest.a;
import com.viber.voip.messages.controller.publicaccount.SendRichMessageRequest;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.l;
import com.viber.voip.messages.conversation.l.a;
import com.viber.voip.messages.conversation.ui.banner.AlertView;
import com.viber.voip.messages.conversation.ui.banner.AlertView.b;
import com.viber.voip.messages.conversation.ui.banner.o;
import com.viber.voip.messages.conversation.ui.bd;
import com.viber.voip.messages.k;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.ui.GenericWebViewActivity.a;
import com.viber.voip.ui.ao;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.az;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.dl;
import com.viber.voip.util.dv;
import com.viber.voip.widget.ProgressBar;
import com.viber.voip.widget.ViberWebView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class ChatExInternalBrowserActivity extends GenericWebViewActivity
  implements AlertView.b
{
  private static final Logger e = ViberEnv.getLogger();
  private BotReplyRequest A;
  private ao B;
  private final com.viber.common.permission.b C;
  private final d.a D;
  private final l.a E;
  protected InternalBrowser a;

  @Inject
  com.viber.voip.messages.extensions.c b;

  @Inject
  dagger.a<com.viber.voip.analytics.story.e.c> c;

  @Inject
  ScheduledExecutorService d;
  private Menu f;
  private long g = -1L;
  private int m = -1;
  private ConversationItemLoaderEntity n;
  private l o;
  private TextView p;
  private ProgressBar q;
  private SwipeRefreshLayout r;
  private ValueCallback<Uri[]> s;
  private ValueCallback<Uri> t;
  private Uri u;
  private WebChromeClient.FileChooserParams v;
  private com.viber.common.permission.c w;
  private bd x;
  private com.viber.voip.messages.controller.manager.f y;
  private a z;

  public ChatExInternalBrowserActivity()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(21);
    this.C = new com.viber.voip.permissions.f(this, arrayOfPair)
    {
      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        switch (paramAnonymousInt1)
        {
        case 22:
        default:
        case 21:
        case 23:
        case 24:
        }
        do
          return;
        while ((!DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString)) && (!DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString)));
        ChatExInternalBrowserActivity.a(ChatExInternalBrowserActivity.this, null);
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        case 22:
        default:
          return;
        case 21:
          ChatExInternalBrowserActivity.a(ChatExInternalBrowserActivity.this);
          return;
        case 24:
          ChatExInternalBrowserActivity.a(ChatExInternalBrowserActivity.this, ChatExInternalBrowserActivity.b(ChatExInternalBrowserActivity.this), true);
          return;
        case 23:
        }
        ChatExInternalBrowserActivity.b(ChatExInternalBrowserActivity.this, ChatExInternalBrowserActivity.b(ChatExInternalBrowserActivity.this), true);
      }
    };
    this.D = new d.a()
    {
      public void onLoadFinished(com.viber.provider.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        ChatExInternalBrowserActivity.a(ChatExInternalBrowserActivity.this, ChatExInternalBrowserActivity.c(ChatExInternalBrowserActivity.this).e(0));
        ChatExInternalBrowserActivity.this.supportInvalidateOptionsMenu();
      }

      public void onLoaderReset(com.viber.provider.d paramAnonymousd)
      {
      }
    };
    this.E = new l.a()
    {
      public void c_(long paramAnonymousLong)
      {
        if ((ChatExInternalBrowserActivity.c(ChatExInternalBrowserActivity.this) != null) && (ChatExInternalBrowserActivity.c(ChatExInternalBrowserActivity.this).r() == paramAnonymousLong))
        {
          ChatExInternalBrowserActivity.a(ChatExInternalBrowserActivity.this, null);
          ChatExInternalBrowserActivity.this.supportInvalidateOptionsMenu();
        }
      }
    };
  }

  private int a(Menu paramMenu)
  {
    InternalBrowser.a locala = this.a.getActionButton();
    if (locala == null)
    {
      if (paramMenu.findItem(R.id.chat_ex_browser_menu_favorite) != null)
        return R.id.chat_ex_browser_menu_favorite;
      return R.id.chat_ex_browser_menu_forward;
    }
    if (locala == InternalBrowser.a.FORWARD)
      return R.id.chat_ex_browser_menu_forward;
    if ((locala == InternalBrowser.a.SEND) || (locala == InternalBrowser.a.SEND_TO_BOT))
      return R.id.chat_ex_browser_menu_send;
    if (locala == InternalBrowser.a.OPEN_EXTERNALLY)
      return R.id.chat_ex_browser_menu_open_externally;
    return 0;
  }

  private Intent a(CharSequence paramCharSequence, Intent paramIntent, List<Intent> paramList)
  {
    Intent localIntent = Intent.createChooser(paramIntent, paramCharSequence);
    localIntent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])paramList.toArray(new Parcelable[0]));
    return localIntent;
  }

  private Uri a(dv paramdv, Intent paramIntent)
  {
    Uri localUri = paramdv.a(this, null, false);
    if (localUri != null)
    {
      localUri = com.viber.common.d.d.a(localUri, this, "com.viber.voip.provider.file");
      ViberActionRunner.a(this, paramIntent, localUri);
    }
    return localUri;
  }

  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.g = paramIntent.getLongExtra("extra_conversation_id", -1L);
      this.m = paramIntent.getIntExtra("extra_conversation_type", -1);
      this.a = ((InternalBrowser)paramIntent.getParcelableExtra("extra_browser_config"));
    }
    for (this.A = ((BotReplyRequest)paramIntent.getParcelableExtra("extra_pending_bot_reply_request")); ; this.A = null)
    {
      if (this.a == null)
        this.a = new InternalBrowser();
      return;
      this.g = -1L;
      this.m = -1;
      this.a = new InternalBrowser();
    }
  }

  @TargetApi(21)
  private void a(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    startActivityForResult(paramFileChooserParams.createIntent(), 100);
  }

  @TargetApi(21)
  private void a(WebChromeClient.FileChooserParams paramFileChooserParams, boolean paramBoolean)
  {
    if (paramFileChooserParams == null)
    {
      a(null);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramFileChooserParams.getTitle();
    if (da.a((CharSequence)localObject))
      localObject = getString(R.string.msg_options_take_video);
    Intent localIntent = c(paramBoolean);
    if (localIntent != null)
      localArrayList.add(localIntent);
    localArrayList.add(b(paramBoolean));
    startActivityForResult(a((CharSequence)localObject, paramFileChooserParams.createIntent(), localArrayList), 100);
  }

  private void a(Uri[] paramArrayOfUri)
  {
    if (this.s != null)
      if (paramArrayOfUri == null)
      {
        this.s.onReceiveValue(new Uri[0]);
        this.s = null;
      }
    while (this.t == null)
      while (true)
      {
        return;
        this.s.onReceiveValue(paramArrayOfUri);
      }
    if ((paramArrayOfUri != null) && (paramArrayOfUri.length > 0))
      this.t.onReceiveValue(paramArrayOfUri[0]);
    while (true)
    {
      this.t = null;
      return;
      this.t.onReceiveValue(null);
    }
  }

  private Intent b(boolean paramBoolean)
  {
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    if (!paramBoolean)
      localIntent.setTypeAndNormalize("video/*");
    return localIntent;
  }

  @SuppressLint({"MissingPermission"})
  @TargetApi(21)
  private void b(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    int i = 0;
    String[] arrayOfString = paramFileChooserParams.getAcceptTypes();
    int j;
    int i2;
    label41: String str;
    if ((paramFileChooserParams.getMode() == 0) && (arrayOfString != null) && (arrayOfString.length > 0))
    {
      j = 1;
      if (j == 0)
        break label96;
      int i1 = arrayOfString.length;
      i2 = 0;
      k = 0;
      if (i2 >= i1)
        break label99;
      str = arrayOfString[i2];
      if (!str.startsWith("image/"))
        break label79;
      i = 1;
    }
    while (true)
    {
      i2++;
      break label41;
      j = 0;
      break;
      label79: if (str.startsWith("video/"))
        k = 1;
    }
    label96: int k = 0;
    label99: if ((k != 0) && (i != 0))
    {
      if (this.w.a(com.viber.voip.permissions.n.d))
      {
        a(paramFileChooserParams, true);
        return;
      }
      this.w.a(this, 24, com.viber.voip.permissions.n.d);
      return;
    }
    if (i != 0)
    {
      if (this.w.a(com.viber.voip.permissions.n.c))
      {
        w();
        return;
      }
      this.w.a(this, 21, com.viber.voip.permissions.n.c);
      return;
    }
    if (k != 0)
    {
      if (this.w.a(com.viber.voip.permissions.n.d))
      {
        b(paramFileChooserParams, true);
        return;
      }
      this.w.a(this, 23, com.viber.voip.permissions.n.d);
      return;
    }
    a(paramFileChooserParams);
  }

  @TargetApi(21)
  private void b(WebChromeClient.FileChooserParams paramFileChooserParams, boolean paramBoolean)
  {
    if (paramFileChooserParams == null)
    {
      a(null);
      return;
    }
    Object localObject = paramFileChooserParams.getTitle();
    if (da.a((CharSequence)localObject))
      localObject = getString(R.string.msg_options_take_video);
    Intent localIntent1 = b(paramBoolean);
    if (paramFileChooserParams.isCaptureEnabled())
      if (localIntent1.resolveActivity(getPackageManager()) == null)
      {
        a(null);
        return;
      }
    ArrayList localArrayList;
    for (Intent localIntent2 = localIntent1; ; localIntent2 = a((CharSequence)localObject, paramFileChooserParams.createIntent(), localArrayList))
    {
      startActivityForResult(localIntent2, 100);
      return;
      localArrayList = new ArrayList();
      localArrayList.add(localIntent1);
    }
  }

  private void b(String paramString)
  {
    if ((isFinishing()) || (this.f == null));
    MenuItem localMenuItem;
    do
    {
      return;
      localMenuItem = this.f.findItem(R.id.chat_ex_browser_menu_favorite);
    }
    while (localMenuItem == null);
    if (this.y.b(paramString));
    for (int i = R.drawable.ic_media_preview_favorites_highlighted; ; i = R.drawable.ic_internal_browser_favorites)
    {
      localMenuItem.setIcon(i);
      return;
    }
  }

  @SuppressLint({"NewApi"})
  private Uri[] b(Intent paramIntent)
  {
    Uri localUri = this.u;
    this.u = null;
    Uri[] arrayOfUri1;
    Uri[] arrayOfUri2;
    if ((paramIntent != null) && (com.viber.common.d.a.g()))
    {
      arrayOfUri1 = WebChromeClient.FileChooserParams.parseResult(100, paramIntent);
      if (arrayOfUri1 != null)
        break label80;
      if ((paramIntent == null) || (paramIntent.getData() == null))
        break label64;
      arrayOfUri2 = new Uri[1];
      arrayOfUri2[0] = paramIntent.getData();
    }
    label64: 
    do
    {
      return arrayOfUri2;
      arrayOfUri1 = null;
      break;
      arrayOfUri2 = null;
    }
    while (localUri == null);
    return new Uri[] { localUri };
    label80: return arrayOfUri1;
  }

  private Intent c(boolean paramBoolean)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    if (!paramBoolean)
      localIntent.setTypeAndNormalize("image/*");
    this.u = a(dv.h, localIntent);
    if (this.u == null)
      return null;
    localIntent.putExtra("output", this.u);
    return localIntent;
  }

  private void k()
  {
    if (-1L == this.g)
      return;
    if (com.viber.voip.messages.m.e(this.m));
    for (this.o = new com.viber.voip.messages.conversation.publicaccount.n(this, getSupportLoaderManager(), ViberApplication.getInstance().getLazyMessagesManager(), this.E, this.D); ; this.o = new l(this, getSupportLoaderManager(), ViberApplication.getInstance().getLazyMessagesManager(), this.E, this.D))
    {
      this.o.a(this.g);
      this.o.p();
      this.o.i();
      return;
    }
  }

  private void l()
  {
    this.q.setVisibility(8);
    this.r.setRefreshing(false);
  }

  private void m()
  {
    switch (4.b[this.a.getOpenMode().ordinal()])
    {
    default:
      return;
    case 1:
      com.viber.voip.n.a.a(this, 6);
      return;
    case 2:
    }
    com.viber.voip.n.a.a(this, 7);
  }

  private void n()
  {
    if (this.p == null)
      return;
    this.p.setOnClickListener(new c(this));
  }

  private void o()
  {
    if (this.p == null)
      return;
    if (q().startsWith("https"))
    {
      Drawable localDrawable = ContextCompat.getDrawable(this, R.drawable.ic_secret);
      this.p.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.p.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.verified_icon_padding));
      return;
    }
    this.p.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.p.setCompoundDrawablePadding(0);
  }

  private String p()
  {
    String str = this.a.getActionPredefinedUrl();
    if (!da.a(str))
      return str;
    return q();
  }

  private String q()
  {
    if (this.h != null);
    for (String str = this.h.getUrl(); (!da.a(str)) && (!"about:blank".equals(str)); str = null)
      return str;
    return this.j;
  }

  private void r()
  {
    if (this.n == null);
    while (this.A == null)
      return;
    this.A = BotReplyRequest.a.a(this.A).a(true).a(ReplyButton.a.OPEN_URL, ReplyButton.b.MESSAGE).a();
    String str = q();
    SendRichMessageRequest localSendRichMessageRequest = new SendRichMessageRequest(this.A, str, this.i, this.a.getActionReplyData(), i.a(this.j, str));
    ViberApplication.getInstance().getMessagesManager().h().a(localSendRichMessageRequest);
    finish();
  }

  private void s()
  {
    if (this.n == null)
      return;
    long l1 = this.n.getId();
    long l2 = this.n.getGroupId();
    String str1 = this.n.getParticipantMemberId();
    String str2 = this.n.getNumber();
    int i = this.n.getConversationType();
    if (this.n.isGroupBehavior());
    for (String str3 = this.n.getGroupName(); ; str3 = "")
    {
      Intent localIntent = com.viber.voip.messages.m.a(l1, l2, str1, str2, i, str3, true, this.n.isSecret(), this.n.isInBusinessInbox(), this.n.isVlnConversation(), false);
      localIntent.putExtra("share_text", p());
      startActivity(localIntent);
      finish();
      return;
    }
  }

  private void t()
  {
    String str1 = q();
    if (this.y.b(str1))
      return;
    String str2 = this.y.a(str1);
    BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage = BotFavoriteLinksCommunicator.SaveLinkActionMessage.builder().a(str1).e(this.b.e()).a(2).h("Internal Browser").f(str2).c(true).b();
    b(str1);
    ViberApplication.getInstance().getMessagesManager().t().a().a(localSaveLinkActionMessage);
    this.d.execute(new d(this, localSaveLinkActionMessage));
  }

  private void u()
  {
    if ((isFinishing()) || (this.f == null));
    MenuItem localMenuItem;
    do
    {
      return;
      localMenuItem = this.f.findItem(R.id.chat_ex_browser_menu_send);
    }
    while (localMenuItem == null);
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.n;
    boolean bool1 = false;
    if (localConversationItemLoaderEntity != null)
    {
      boolean bool2 = this.n.canSendMessages(0);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    localMenuItem.setVisible(bool1);
  }

  private void v()
  {
    da.a(this, q(), getString(R.string.link_copied));
  }

  @TargetApi(21)
  private void w()
  {
    ArrayList localArrayList = new ArrayList();
    Intent localIntent1 = c(true);
    if (localIntent1 == null)
    {
      a(null);
      return;
    }
    localArrayList.add(localIntent1);
    Intent localIntent2 = new Intent().setType("image/*").setAction("android.intent.action.PICK");
    startActivityForResult(a(getString(R.string.msg_options_take_photo), localIntent2, localArrayList), 100);
  }

  public AlertView M_()
  {
    return (AlertView)dj.e(getWindow().getDecorView().getRootView(), R.id.bottom_alert_banner);
  }

  public void a()
  {
    super.a();
    l();
    a(this.i);
    b(q());
  }

  protected void a(String paramString)
  {
    String str1 = this.a.getCustomTitle();
    String str2;
    if (!da.a(str1))
      str2 = str1;
    while (true)
    {
      super.a(da.b(str2, paramString));
      o();
      return;
      switch (4.a[this.a.getTitleType().ordinal()])
      {
      default:
        str2 = null;
        break;
      case 1:
        str2 = dl.o(q());
        break;
      case 2:
        ViberWebView localViberWebView = this.h;
        str2 = null;
        if (localViberWebView != null)
          str2 = this.h.getTitle();
        if ("about:blank".equals(str2))
          str2 = getSupportActionBar().b().toString();
        break;
      }
    }
  }

  protected void b()
  {
    super.b();
    l();
  }

  protected int c()
  {
    return R.layout.chat_ex_internal_web_view;
  }

  protected void d()
  {
    a(false);
  }

  protected String e()
  {
    return q();
  }

  protected void f()
  {
    startActivity(ViberActionRunner.u.a(p(), false));
    finish();
  }

  protected void g()
  {
    ViberActionRunner.az.a(this, 8, 0L, null, "", "", "", q(), null, false, null, null, null);
  }

  protected WebChromeClient h()
  {
    return new b();
  }

  protected WebViewClient i()
  {
    return new c(new e(this));
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (100 == paramInt1)
    {
      Uri[] arrayOfUri = b(paramIntent);
      if ((-1 == paramInt2) && (arrayOfUri != null))
        a(arrayOfUri);
    }
    else
    {
      return;
    }
    a(null);
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    a(getIntent());
    super.onCreate(paramBundle);
    this.w = com.viber.common.permission.c.a(this);
    this.y = new com.viber.voip.messages.controller.manager.f(50);
    this.z = new a(this, 2);
    com.viber.voip.h.a.b().register(this.z);
    this.x = new bd(this, this, av.e.a.a(), com.viber.voip.h.a.b(), 2, o.a, getLayoutInflater());
    this.l.setNavigationIcon(R.drawable.close_internal_browser_icon);
    this.p = dj.f(this.l);
    this.B = new ao(this.l);
    this.q = ((ProgressBar)findViewById(R.id.progress));
    this.r = ((SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout));
    this.r.setProgressBackgroundColorSchemeResource(dc.a(this, R.attr.swipeToRefreshBackground));
    SwipeRefreshLayout localSwipeRefreshLayout = this.r;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = dc.a(this, R.attr.swipeToRefreshArrowColor);
    localSwipeRefreshLayout.setColorSchemeResources(arrayOfInt);
    this.r.setOnRefreshListener(new a(this));
    this.r.setEnabled(false);
    this.h.setScrollListener(new b(this));
    n();
    m();
    k();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    if (this.b.f())
      paramMenu.add(0, R.id.chat_ex_browser_menu_favorite, 2, R.string.menu_save_to_favorites).setIcon(R.drawable.ic_internal_browser_favorites);
    paramMenu.add(0, R.id.chat_ex_browser_menu_forward, 2, R.string.forward_action).setIcon(R.drawable.ic_internal_browser_forward);
    paramMenu.add(0, R.id.chat_ex_browser_menu_send, 2, R.string.btn_msg_send).setIcon(R.drawable.ic_internal_browser_send);
    paramMenu.add(0, R.id.chat_ex_browser_menu_share, 2, R.string.menu_message_share);
    paramMenu.add(0, R.id.chat_ex_browser_menu_copy_link, 2, R.string.pg_copy_to_clipboard);
    paramMenu.add(0, R.id.chat_ex_browser_menu_open_externally, 2, R.string.open_externally).setIcon(R.drawable.ic_internal_browser_open);
    int i = a(paramMenu);
    if (i != 0)
    {
      MenuItem localMenuItem = paramMenu.findItem(i);
      if (localMenuItem != null)
      {
        CharSequence localCharSequence = localMenuItem.getTitle();
        Drawable localDrawable = localMenuItem.getIcon();
        paramMenu.removeItem(i);
        paramMenu.add(0, i, 1, localCharSequence).setIcon(localDrawable).setShowAsAction(2);
      }
    }
    this.f = paramMenu;
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    com.viber.voip.h.a.b().unregister(this.z);
    if (this.o != null)
    {
      this.o.q();
      this.o.j();
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == R.id.chat_ex_browser_menu_send)
    {
      if (this.a.getActionButton() == InternalBrowser.a.SEND_TO_BOT)
      {
        r();
        return true;
      }
      s();
      return true;
    }
    if (i == R.id.chat_ex_browser_menu_forward)
    {
      f();
      return true;
    }
    if (i == R.id.chat_ex_browser_menu_share)
    {
      g();
      return true;
    }
    if (i == R.id.chat_ex_browser_menu_open_externally)
    {
      ViberActionRunner.b(this, new Intent("android.intent.action.VIEW", Uri.parse(q())));
      return true;
    }
    if (i == R.id.chat_ex_browser_menu_copy_link)
    {
      v();
      return true;
    }
    if (i == 16908332)
    {
      finish();
      return true;
    }
    if (i == R.id.chat_ex_browser_menu_favorite)
    {
      t();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    b(q());
    u();
    if (this.B != null)
      this.B.a();
    return super.onPrepareOptionsMenu(paramMenu);
  }

  protected void onStart()
  {
    super.onStart();
    this.x.a();
    this.w.a(this.C);
  }

  protected void onStop()
  {
    super.onStop();
    this.x.b();
    this.w.b(this.C);
  }

  private static final class a extends f.a.a<ChatExInternalBrowserActivity>
  {
    public a(ChatExInternalBrowserActivity paramChatExInternalBrowserActivity, int paramInt)
    {
      super(paramInt);
    }

    protected void a(ChatExInternalBrowserActivity paramChatExInternalBrowserActivity, f.a parama)
    {
      if ((ChatExInternalBrowserActivity.i(paramChatExInternalBrowserActivity).a(parama.a, parama.c)) && (!paramChatExInternalBrowserActivity.isFinishing()))
        paramChatExInternalBrowserActivity.supportInvalidateOptionsMenu();
    }
  }

  protected class b extends GenericWebViewActivity.a
  {
    protected b()
    {
      super();
    }

    @TargetApi(21)
    private void a(ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, WebChromeClient.FileChooserParams paramFileChooserParams, boolean paramBoolean)
    {
      if (ChatExInternalBrowserActivity.g(ChatExInternalBrowserActivity.this) != null)
        ChatExInternalBrowserActivity.g(ChatExInternalBrowserActivity.this).onReceiveValue(null);
      ChatExInternalBrowserActivity.a(ChatExInternalBrowserActivity.this, paramValueCallback);
      if (ChatExInternalBrowserActivity.h(ChatExInternalBrowserActivity.this) != null)
        ChatExInternalBrowserActivity.h(ChatExInternalBrowserActivity.this).onReceiveValue(new Uri[0]);
      ChatExInternalBrowserActivity.b(ChatExInternalBrowserActivity.this, paramValueCallback1);
      ChatExInternalBrowserActivity.a(ChatExInternalBrowserActivity.this, paramFileChooserParams);
      ChatExInternalBrowserActivity.b(ChatExInternalBrowserActivity.this, paramFileChooserParams);
    }

    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      super.onProgressChanged(paramWebView, paramInt);
      if ((da.a(paramWebView.getUrl())) || ("about:blank".equals(paramWebView.getUrl())))
        return;
      if (paramInt == 100)
      {
        ChatExInternalBrowserActivity.e(ChatExInternalBrowserActivity.this);
        return;
      }
      ChatExInternalBrowserActivity.f(ChatExInternalBrowserActivity.this).setVisibility(0);
      ChatExInternalBrowserActivity.f(ChatExInternalBrowserActivity.this).setProgress(paramInt);
    }

    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      super.onReceivedTitle(paramWebView, paramString);
      ChatExInternalBrowserActivity.this.a(ChatExInternalBrowserActivity.d(ChatExInternalBrowserActivity.this));
    }

    @TargetApi(21)
    public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
    {
      if (paramFileChooserParams.getMode() == 1);
      for (boolean bool = true; ; bool = false)
      {
        a(null, paramValueCallback, paramFileChooserParams, bool);
        return true;
      }
    }
  }

  protected class c extends com.viber.voip.util.k.b
  {
    public c(Runnable arg2)
    {
      super();
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      av.e.a.a().post(new f(this, paramString));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.activity.ChatExInternalBrowserActivity
 * JD-Core Version:    0.6.2
 */