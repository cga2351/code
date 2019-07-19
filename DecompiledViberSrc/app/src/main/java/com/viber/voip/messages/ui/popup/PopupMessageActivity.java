package com.viber.voip.messages.ui.popup;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.c.a;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.im2.CGroupUserIsTypingMsg;
import com.viber.jni.im2.CUserIsTypingMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.provider.d;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.controller.ai.e;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.x;
import com.viber.voip.messages.conversation.ag;
import com.viber.voip.messages.conversation.ag.a;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.m;
import com.viber.voip.messages.ui.popup.a.e;
import com.viber.voip.messages.ui.popup.a.f;
import com.viber.voip.messages.ui.popup.view.PopupStickerQuickReply;
import com.viber.voip.messages.ui.popup.view.PopupStickerQuickReply.a;
import com.viber.voip.messages.ui.popup.view.PopupViewPagerRoot;
import com.viber.voip.messages.ui.popup.view.PopupViewPagerRoot.a;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.settings.d.ag;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.user.OnlineUserActivityHelper.UiOnlineUserInfoDelegate;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.bu;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.upload.ObjectId;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

public class PopupMessageActivity extends ViberFragmentActivity
  implements View.OnClickListener, View.OnLongClickListener, TextView.OnEditorActionListener, ag.a, PopupViewPagerRoot.a
{
  private static final Logger d = ViberEnv.getLogger();
  private final com.viber.voip.q.h A = new com.viber.voip.q.h()
  {
    public void a(String paramAnonymousString, int paramAnonymousInt)
    {
      PopupMessageActivity.a(PopupMessageActivity.this, false);
    }

    public void a(String paramAnonymousString, long paramAnonymousLong)
    {
      PopupMessageActivity.a(PopupMessageActivity.this, true);
    }

    public void b(String paramAnonymousString, long paramAnonymousLong)
    {
      PopupMessageActivity.a(PopupMessageActivity.this, false);
    }

    public void c(String paramAnonymousString, long paramAnonymousLong)
    {
      PopupMessageActivity.a(PopupMessageActivity.this, true);
    }
  };
  private Runnable B = new d(this, null);
  private AtomicBoolean C = new AtomicBoolean(true);
  private final OnlineUserActivityHelper.UiOnlineUserInfoDelegate D = new OnlineUserActivityHelper.UiOnlineUserInfoDelegate()
  {
    public void onOnlineStatusActivityReady(int paramAnonymousInt, OnlineContactInfo[] paramAnonymousArrayOfOnlineContactInfo)
    {
      if ((paramAnonymousArrayOfOnlineContactInfo != null) && (paramAnonymousArrayOfOnlineContactInfo.length > 0))
        PopupMessageActivity.m(PopupMessageActivity.this).post(new Runnable()
        {
          public void run()
          {
            PopupMessageActivity.c(PopupMessageActivity.this);
          }
        });
    }
  };
  private com.viber.voip.stickers.e.b E = new com.viber.voip.stickers.n()
  {
    public void onStickerDeployed(Sticker paramAnonymousSticker)
    {
      if (!paramAnonymousSticker.isOwned())
        PopupMessageActivity.s(PopupMessageActivity.this);
    }
  };
  public int a;

  @Inject
  UserManager b;

  @Inject
  com.viber.voip.messages.controller.ai c;
  private com.viber.voip.messages.ui.popup.a.a e;
  private f f;
  private com.viber.voip.messages.ui.popup.a.c g;
  private ag h;
  private Set<aa> i = new HashSet();
  private Handler j = new Handler();
  private com.viber.voip.messages.k k;
  private ConversationItemLoaderEntity l;
  private BroadcastReceiver m;
  private c n;
  private boolean o;
  private boolean p;
  private boolean q = true;
  private a r;
  private boolean s;
  private int t;
  private Rect u = new Rect();
  private com.viber.voip.q.i v;
  private com.viber.voip.messages.ui.ai w;
  private com.viber.voip.messages.j x;
  private x y;
  private final Runnable z = new b(this, null);

  private Intent a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    long l1 = paramConversationItemLoaderEntity.getId();
    long l2 = paramConversationItemLoaderEntity.getGroupId();
    String str1 = paramConversationItemLoaderEntity.getParticipantMemberId();
    String str2 = paramConversationItemLoaderEntity.getNumber();
    int i1 = paramConversationItemLoaderEntity.getConversationType();
    if (paramConversationItemLoaderEntity.isGroupBehavior());
    for (String str3 = paramConversationItemLoaderEntity.getGroupName(); ; str3 = "")
    {
      Intent localIntent = m.a(l1, l2, str1, str2, i1, str3, true, paramConversationItemLoaderEntity.isSecret(), paramConversationItemLoaderEntity.isInBusinessInbox(), paramConversationItemLoaderEntity.isVlnConversation(), false);
      localIntent.putExtra("from_notification", 1);
      String str4 = m();
      if (str4 != null)
        localIntent.putExtra("forward _draft", str4);
      return localIntent;
    }
  }

  private void a(boolean paramBoolean)
  {
    if ((this.n != null) && (this.n.g != null))
      this.n.g.setKeepScreenOn(paramBoolean);
  }

  private void a(ViewPager[] paramArrayOfViewPager)
  {
    if (paramArrayOfViewPager == null);
    while (true)
    {
      return;
      int i1 = paramArrayOfViewPager.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        ViewPager localViewPager = paramArrayOfViewPager[i2];
        if ((localViewPager != null) && (localViewPager.getAdapter() != null))
          localViewPager.getAdapter().notifyDataSetChanged();
      }
    }
  }

  private void a(com.viber.voip.messages.ui.popup.a.g[] paramArrayOfg)
  {
    if (paramArrayOfg == null);
    while (true)
    {
      return;
      int i1 = paramArrayOfg.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        com.viber.voip.messages.ui.popup.a.g localg = paramArrayOfg[i2];
        if (localg != null)
          localg.a();
      }
    }
  }

  private boolean a(String paramString)
  {
    if ((this.l != null) && (paramString != null))
    {
      this.k.c().a(this.l.getId(), this.l.getConversationType(), paramString);
      return true;
    }
    return false;
  }

  private void e()
  {
    if ((this.h != null) && (this.h.f(0) != null))
    {
      da.b(this.h.f(0).h());
      this.a = this.h.getCount();
      if (this.n.a.getAdapter() != null)
        break label81;
      g();
      f();
    }
    while (true)
    {
      h();
      this.C.set(true);
      return;
      break;
      label81: this.j.removeCallbacks(this.B);
      this.j.postDelayed(this.B, 700L);
    }
  }

  private void f()
  {
    this.e = new com.viber.voip.messages.ui.popup.a.a(this, this.h, com.viber.voip.messages.d.c.c(), this.w, this.y, this.x, a.a, this.c, new b(this));
    this.e.a(this.o);
    this.e.b(this.p);
    this.e.a(this);
    this.n.a.setAdapter(new e(this.e));
  }

  private void g()
  {
    this.f = new f(this, this.h, this.l);
    this.g = new com.viber.voip.messages.ui.popup.a.c(this, this.h, this.l);
    this.n.b.setAdapter(new e(this.f));
    this.n.c.setAdapter(new e(this.g));
  }

  private void h()
  {
    com.viber.voip.messages.ui.popup.a.g[] arrayOfg = new com.viber.voip.messages.ui.popup.a.g[3];
    arrayOfg[0] = this.e;
    arrayOfg[1] = this.g;
    arrayOfg[2] = this.f;
    a(arrayOfg);
    ViewPager[] arrayOfViewPager = new ViewPager[3];
    arrayOfViewPager[0] = this.n.a;
    arrayOfViewPager[1] = this.n.c;
    arrayOfViewPager[2] = this.n.b;
    a(arrayOfViewPager);
  }

  private void i()
  {
    this.j.removeCallbacks(this.z);
    this.j.postDelayed(this.z, 15000L);
  }

  private void j()
  {
    PopupViewPagerRoot localPopupViewPagerRoot = this.n.a;
    for (int i1 = 0; i1 < localPopupViewPagerRoot.getChildCount(); i1++)
      com.viber.voip.messages.ui.popup.a.a.a(localPopupViewPagerRoot.getChildAt(i1));
  }

  private void k()
  {
    com.viber.voip.notif.g.a(this).h();
  }

  private void l()
  {
    if (getIntent().getBooleanExtra("open_keyboard_extra", false))
    {
      this.n.i.requestFocus();
      getWindow().setSoftInputMode(37);
      this.q = false;
    }
  }

  private String m()
  {
    if (this.n == null);
    Editable localEditable;
    do
    {
      do
        return null;
      while (this.n.i == null);
      localEditable = this.n.i.getText();
    }
    while (localEditable == null);
    return localEditable.toString().trim();
  }

  private void n()
  {
    try
    {
      String str = this.n.i.getText().toString();
      if ((!TextUtils.isEmpty(str.trim())) && (this.k != null) && (this.l != null))
      {
        MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.b(this.l).a(0, str, 0, null, this.l.getTimebombTime());
        localMessageEntity.setConversationId(this.l.getId());
        localMessageEntity.addExtraFlag(13);
        if ((this.l.isShareLocation()) && ((localMessageEntity.getLat() == 0) || (localMessageEntity.getLng() == 0)))
          localMessageEntity.setExtraStatus(0);
        if (this.l.isSecret())
          localMessageEntity.addExtraFlag(27);
        this.k.c().a(localMessageEntity, com.viber.voip.analytics.story.n.a(null, "Popup"));
        this.k.c().a(this.l.getId(), this.l.getConversationType(), "");
        this.n.i.setText("");
        a.a(this.r);
      }
      return;
    }
    catch (Exception localException)
    {
    }
    finally
    {
      dj.c(this.n.i);
    }
  }

  private void o()
  {
    if (this.h != null)
    {
      aa localaa = this.h.f(-1 + this.h.getCount());
      if (localaa != null)
        ViberApplication.getInstance().getMessagesManager().c().a(localaa);
    }
  }

  private void p()
  {
    this.n.m.setVisibility(0);
    if ((dj.c(this)) && (!ViberApplication.isTablet(this)))
      this.n.l.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.pop_up_max_width), getResources().getDimensionPixelSize(R.dimen.pop_up_height)));
  }

  private void q()
  {
    ImageButton localImageButton = this.n.h;
    if (!TextUtils.isEmpty(this.n.i.getText()));
    for (boolean bool = true; ; bool = false)
    {
      localImageButton.setEnabled(bool);
      return;
    }
  }

  public void a()
  {
    if (!ViberApplication.getInstance().getMessagesManager().l().a())
      finish();
  }

  public void a(int paramInt)
  {
    if ((this.h != null) && (paramInt == -1 + this.h.getCount()))
      this.n.g.setVisibility(0);
    b(paramInt);
  }

  public void a(int paramInt1, int paramInt2)
  {
  }

  public void b()
  {
    if ("1".equals("0"))
    {
      this.n.i.setVisibility(0);
      this.n.h.setVisibility(0);
      l();
    }
    do
    {
      return;
      if ("1".equals("1"))
      {
        this.n.i.setVisibility(0);
        this.n.h.setVisibility(0);
        l();
        return;
      }
    }
    while (!"1".equals("2"));
    c();
  }

  public void b(int paramInt)
  {
    if (this.e != null)
    {
      aa localaa = this.e.a(this.n.a, this);
      if (localaa != null)
        this.i.add(localaa);
    }
  }

  public void c()
  {
    this.n.i.setVisibility(8);
    this.n.h.setVisibility(8);
  }

  public void onClick(View paramView)
  {
    com.viber.voip.messages.ui.popup.a.a locala = this.e;
    aa localaa = null;
    if (locala != null)
      localaa = this.e.a(this.n.a, this);
    if (localaa == null);
    do
    {
      return;
      if (paramView == this.n.i)
      {
        k();
        return;
      }
      if (paramView == this.n.h)
      {
        if (TextUtils.isEmpty(this.n.i.getText()))
        {
          p();
          q();
          return;
        }
        n();
        k();
        finish();
        return;
      }
      if (paramView == this.n.d)
      {
        finish();
        return;
      }
      if (paramView.getId() == R.id.left_arrow)
      {
        this.n.a.b();
        return;
      }
      if (paramView.getId() == R.id.right_arrow)
      {
        this.n.a.a();
        return;
      }
    }
    while (paramView == null);
    k();
    if (this.l != null)
      startActivity(a(this.l));
    finish();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.n == null) || (this.n.l == null) || (this.n.m == null))
      return;
    int i1 = (int)getResources().getDimension(R.dimen.pop_up_height);
    int i2 = (int)getResources().getDimension(R.dimen.pop_up_stickers_height);
    if ((!dj.c(this)) && (!ViberApplication.isTablet(this)));
    for (int i3 = -1; ; i3 = (int)getResources().getDimension(R.dimen.pop_up_max_width))
    {
      this.n.l.setLayoutParams(new LinearLayout.LayoutParams(i3, i1));
      this.n.m.setLayoutParams(new LinearLayout.LayoutParams(i3, i2));
      this.n.l.requestLayout();
      this.n.m.requestLayout();
      return;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    this.k = ViberApplication.getInstance().getMessagesManager();
    this.v = this.k.m();
    this.w = new com.viber.voip.messages.ui.ai(this);
    this.x = new com.viber.voip.messages.j(this);
    this.y = new com.viber.voip.messages.conversation.ui.spam.b();
    KeyguardManager localKeyguardManager = (KeyguardManager)getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)getSystemService("power");
    boolean bool = localKeyguardManager.inKeyguardRestrictedInputMode();
    int i1;
    LinearLayout localLinearLayout;
    if ((localPowerManager.isScreenOn()) && (!bool))
    {
      i1 = 1;
      dj.c(this);
      setContentView(R.layout.hc_popup);
      this.r = new a(null);
      this.n = new c(null);
      localLinearLayout = this.n.g;
      if (!bool)
        break label431;
    }
    label431: for (int i2 = 17170444; ; i2 = R.color.solid_50)
    {
      localLinearLayout.setBackgroundResource(i2);
      this.n.f.setOnClickListener(this);
      this.n.i.setOnClickListener(this);
      this.n.i.setOnEditorActionListener(this);
      this.n.h.setOnClickListener(this);
      this.n.d.setOnClickListener(this);
      this.n.e.setOnClickListener(this);
      this.n.j.setOnClickListener(this);
      this.n.a.a(this.n.b);
      this.n.a.a(this.n.c);
      this.n.a.setOnPagerChangingListener(this);
      this.n.n.setStickerSelectListener(new PopupStickerQuickReply.a()
      {
        public void a(int paramAnonymousInt)
        {
          if (PopupMessageActivity.h(PopupMessageActivity.this).a(PopupMessageActivity.d(PopupMessageActivity.this).a, PopupMessageActivity.this) != null)
          {
            MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.b(PopupMessageActivity.i(PopupMessageActivity.this)).a(4, ObjectId.fromLong(paramAnonymousInt), PopupMessageActivity.i(PopupMessageActivity.this).getTimebombTime());
            localMessageEntity.addExtraFlag(13);
            ViberApplication.getInstance().getMessagesManager().c().a(localMessageEntity, com.viber.voip.analytics.story.n.a(null, "Popup"));
            PopupMessageActivity.j(PopupMessageActivity.this);
          }
          PopupMessageActivity.this.finish();
        }
      });
      this.n.o.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          PopupMessageActivity.d(PopupMessageActivity.this).o.setVisibility(8);
        }
      });
      if (!d.ag.b.d())
        this.n.m.setVisibility(8);
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      if (i1 != 0)
        localIntentFilter.addAction("com.viber.voip.action.CLOSE_POPUP");
      this.m = new ScreenReceiver();
      registerReceiver(this.m, localIntentFilter);
      i();
      b();
      return;
      i1 = 0;
      break;
    }
  }

  public void onDestroy()
  {
    a(m());
    if (this.m != null)
    {
      unregisterReceiver(this.m);
      this.m = null;
    }
    if (this.h != null)
      this.h.q();
    super.onDestroy();
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.n.h.getVisibility() == 0) && (this.n.h.isEnabled()))
    {
      this.n.h.performClick();
      return true;
    }
    return false;
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    if ((paramd == this.h) && (this.h.getCount() != 0))
    {
      if (this.v.c(this.v.b()))
        return;
      if (paramBoolean)
      {
        this.n.i.addTextChangedListener(this.r);
        this.s = false;
        e();
        this.n.a.c();
        this.n.g.setVisibility(0);
        i();
        return;
      }
      e();
      return;
    }
    finish();
  }

  public void onLoaderReset(d paramd)
  {
  }

  public boolean onLongClick(View paramView)
  {
    if (this.e != null)
    {
      aa localaa = this.e.a(this.n.a, this);
      if (localaa != null)
      {
        c.a locala = new c.a(new ContextThemeWrapper(this, R.style.Theme_Viber)).a("System info");
        StringBuilder localStringBuilder = new StringBuilder().append(localaa.bF().replace("-[", "\n").replace("[", "#\n").replace(",", "\n")).append("\n tempFile: ");
        if (localaa.o() == null);
        for (String str = "null"; ; str = bu.a(Uri.parse(localaa.o()).getPath()))
        {
          locala.b(str.replace("-[", "\n").replace("[", "#\n").replace(",", "\n").replace("]", "").replace(" ", "")).a(false).a("Close", null).b().show();
          return true;
        }
      }
    }
    return false;
  }

  protected void onPause()
  {
    com.viber.voip.stickers.b.e().a(false);
    com.viber.voip.stickers.i.a().b(this.E);
    ViberApplication.getInstance().getEngine(false).getOnlineUserActivityHelper().removeListener(this.D);
    super.onPause();
  }

  protected void onResume()
  {
    com.viber.voip.stickers.b.e().a(true);
    if (this.h == null)
    {
      this.n.g.setVisibility(4);
      this.c.a(getIntent().getLongExtra("conversation_id_extra", -1L), new ai.e()
      {
        public void a(final ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
        {
          PopupMessageActivity.a(PopupMessageActivity.this, paramAnonymousConversationItemLoaderEntity);
          if (paramAnonymousConversationItemLoaderEntity != null)
          {
            if ((!paramAnonymousConversationItemLoaderEntity.isGroupBehavior()) && (OnlineUserActivityHelper.canFetchOnlineInfo(paramAnonymousConversationItemLoaderEntity)))
              ViberApplication.getInstance().getEngine(false).getOnlineUserActivityHelper().obtainInfo(paramAnonymousConversationItemLoaderEntity.getParticipantMemberId(), (int)(System.currentTimeMillis() / 1000L), PopupMessageActivity.n(PopupMessageActivity.this));
            PopupMessageActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                PopupMessageActivity.b(PopupMessageActivity.this, SpamController.a(paramAnonymousConversationItemLoaderEntity));
                int k;
                int m;
                if (paramAnonymousConversationItemLoaderEntity.isSystemConversation())
                {
                  Button localButton2 = PopupMessageActivity.d(PopupMessageActivity.this).j;
                  if (PopupMessageActivity.o(PopupMessageActivity.this))
                  {
                    k = 8;
                    localButton2.setVisibility(k);
                    if (!paramAnonymousConversationItemLoaderEntity.isSystemReplyableChat())
                      break label378;
                    View localView2 = PopupMessageActivity.d(PopupMessageActivity.this).k;
                    boolean bool2 = PopupMessageActivity.o(PopupMessageActivity.this);
                    m = 0;
                    if (!bool2)
                      break label371;
                    label112: localView2.setVisibility(m);
                    label119: PopupMessageActivity.d(PopupMessageActivity.this).m.setVisibility(8);
                    if ((PopupMessageActivity.d(PopupMessageActivity.this).k.getVisibility() != 0) || (PopupMessageActivity.d(PopupMessageActivity.this).m.getVisibility() == 0))
                      break label525;
                    PopupMessageActivity.d(PopupMessageActivity.this).k.setBackgroundResource(R.drawable.popup_message_bottom_bg);
                  }
                }
                while (true)
                {
                  PopupMessageActivity.a(PopupMessageActivity.this, new ag(PopupMessageActivity.this.getApplicationContext(), PopupMessageActivity.this.getSupportLoaderManager(), ViberApplication.getInstance().getLazyMessagesManager(), PopupMessageActivity.this, com.viber.voip.h.a.b()));
                  PopupMessageActivity.d(PopupMessageActivity.this).i.setText(paramAnonymousConversationItemLoaderEntity.getMessageDraft());
                  PopupMessageActivity.d(PopupMessageActivity.this).i.setSelection(PopupMessageActivity.d(PopupMessageActivity.this).i.getText().length());
                  PopupMessageActivity.p(PopupMessageActivity.this);
                  PopupMessageActivity.e(PopupMessageActivity.this).a(paramAnonymousConversationItemLoaderEntity.getId());
                  PopupMessageActivity.e(PopupMessageActivity.this).i();
                  PopupMessageActivity.e(PopupMessageActivity.this).p();
                  return;
                  k = 0;
                  break;
                  label371: m = 8;
                  break label112;
                  label378: PopupMessageActivity.d(PopupMessageActivity.this).k.setVisibility(8);
                  break label119;
                  boolean bool1 = paramAnonymousConversationItemLoaderEntity.canSendMessages(0);
                  Button localButton1 = PopupMessageActivity.d(PopupMessageActivity.this).j;
                  int i;
                  label439: View localView1;
                  int j;
                  if (PopupMessageActivity.o(PopupMessageActivity.this))
                  {
                    i = 8;
                    localButton1.setVisibility(i);
                    localView1 = PopupMessageActivity.d(PopupMessageActivity.this).k;
                    if (!PopupMessageActivity.o(PopupMessageActivity.this))
                      break label518;
                    j = 0;
                    if (!bool1)
                      break label518;
                  }
                  while (true)
                  {
                    localView1.setVisibility(j);
                    if (bool1)
                      break;
                    PopupMessageActivity.d(PopupMessageActivity.this).m.setVisibility(8);
                    break;
                    i = 0;
                    break label439;
                    label518: j = 8;
                  }
                  label525: PopupMessageActivity.d(PopupMessageActivity.this).k.setBackgroundResource(R.color.negative);
                }
              }
            });
            return;
          }
          PopupMessageActivity.this.finish();
        }
      });
    }
    while (true)
    {
      com.viber.voip.stickers.i.a().a(this.E);
      j();
      super.onResume();
      return;
      this.n.g.setVisibility(0);
    }
  }

  protected void onStart()
  {
    super.onStart();
    this.o = d.ag.b.d();
    this.v.a(this.A);
  }

  protected void onStop()
  {
    super.onStop();
    this.v.b(this.A);
    this.v.a();
  }

  public void onUserInteraction()
  {
    super.onUserInteraction();
    this.q = false;
  }

  public class ScreenReceiver extends BroadcastReceiver
  {
    public ScreenReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
        PopupMessageActivity.this.getWindow().clearFlags(4194304);
      do
      {
        do
        {
          do
            return;
          while (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"));
          if (!paramIntent.getAction().equals("android.intent.action.USER_PRESENT"))
            break;
        }
        while ((PopupMessageActivity.e(PopupMessageActivity.this) == null) || (!PopupMessageActivity.e(PopupMessageActivity.this).d()) || (PopupMessageActivity.this.a == PopupMessageActivity.e(PopupMessageActivity.this).getCount()));
        PopupMessageActivity.f(PopupMessageActivity.this);
        return;
      }
      while ((!paramIntent.getAction().equals("com.viber.voip.action.CLOSE_POPUP")) || (PopupMessageActivity.this.isFinishing()));
      if (paramIntent.getBooleanExtra("hidenotify", false))
        PopupMessageActivity.g(PopupMessageActivity.this);
      PopupMessageActivity.this.finish();
    }
  }

  private class a
    implements TextWatcher
  {
    private int b = 0;
    private boolean c;
    private boolean d = true;
    private final Runnable e = new Runnable()
    {
      public void run()
      {
        PopupMessageActivity.a.a(PopupMessageActivity.a.this, false);
        PopupMessageActivity.a.b(PopupMessageActivity.a.this, true);
      }
    };
    private final Runnable f = new Runnable()
    {
      public void run()
      {
        if (PopupMessageActivity.a.b(PopupMessageActivity.a.this))
        {
          PopupMessageActivity.a.a(PopupMessageActivity.a.this, false);
          PopupMessageActivity.a.b(PopupMessageActivity.a.this, true);
          PopupMessageActivity.a.c(PopupMessageActivity.a.this);
        }
      }
    };

    private a()
    {
    }

    private void a()
    {
      if (PopupMessageActivity.i(PopupMessageActivity.this) != null)
      {
        if (PopupMessageActivity.i(PopupMessageActivity.this).isGroupBehavior())
          break label68;
        ViberApplication.getInstance().getEngine(true).getExchanger().handleCUserIsTypingMsg(new CUserIsTypingMsg(PopupMessageActivity.i(PopupMessageActivity.this).getParticipantMemberId(), this.c, PopupMessageActivity.i(PopupMessageActivity.this).getNativeChatType()));
      }
      label68: 
      while (PopupMessageActivity.i(PopupMessageActivity.this).getGroupId() == 0L)
        return;
      ViberApplication.getInstance().getEngine(true).getExchanger().handleCGroupUserIsTypingMsg(new CGroupUserIsTypingMsg(PopupMessageActivity.i(PopupMessageActivity.this).getGroupId(), this.c));
    }

    private void b()
    {
      PopupMessageActivity.m(PopupMessageActivity.this).removeCallbacks(this.e);
      PopupMessageActivity.m(PopupMessageActivity.this).removeCallbacks(this.f);
      PopupMessageActivity.m(PopupMessageActivity.this).post(this.f);
    }

    public void afterTextChanged(Editable paramEditable)
    {
      if (TextUtils.isEmpty(paramEditable.toString()))
      {
        PopupMessageActivity.m(PopupMessageActivity.this).removeCallbacks(this.e);
        PopupMessageActivity.m(PopupMessageActivity.this).removeCallbacks(this.f);
        PopupMessageActivity.m(PopupMessageActivity.this).postDelayed(this.f, 2000L);
      }
      if (this.d)
        this.d = false;
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((!PopupMessageActivity.q(PopupMessageActivity.this)) && (TextUtils.getTrimmedLength(paramCharSequence) > 1))
        PopupMessageActivity.c(PopupMessageActivity.this, true);
      if (PopupMessageActivity.r(PopupMessageActivity.this).get())
      {
        PopupMessageActivity.j(PopupMessageActivity.this);
        PopupMessageActivity.r(PopupMessageActivity.this).set(false);
      }
      int i = 1 + this.b;
      this.b = i;
      if (i == 3)
      {
        this.b = 0;
        if (!this.c)
        {
          this.c = true;
          a();
          PopupMessageActivity.m(PopupMessageActivity.this).removeCallbacks(this.f);
          PopupMessageActivity.m(PopupMessageActivity.this).removeCallbacks(this.e);
          PopupMessageActivity.m(PopupMessageActivity.this).postDelayed(this.e, 10000L);
        }
      }
      PopupMessageActivity.p(PopupMessageActivity.this);
    }
  }

  private static class b extends com.viber.voip.d.b<PopupMessageActivity>
  {
    private b(PopupMessageActivity paramPopupMessageActivity)
    {
      super();
    }

    public void a(PopupMessageActivity paramPopupMessageActivity)
    {
      com.viber.voip.messages.k localk = ViberApplication.getInstance().getMessagesManager();
      if ((PopupMessageActivity.a(paramPopupMessageActivity)) && (!localk.l().a()))
        paramPopupMessageActivity.finish();
    }
  }

  public class c
  {
    public final PopupViewPagerRoot a;
    public final ViewPager b;
    public final ViewPager c;
    public final ImageButton d;
    public final ImageButton e;
    public final LinearLayout f;
    public final LinearLayout g = (LinearLayout)PopupMessageActivity.this.findViewById(R.id.mainLayout);
    public final ImageButton h;
    public final EditText i;
    public final Button j;
    public final View k;
    public final View l;
    public final View m;
    public final PopupStickerQuickReply n;
    public final View o;
    protected int p;

    private c()
    {
      dj.a(this.g, new Runnable()
      {
        public void run()
        {
          PopupMessageActivity.c.this.g.getWindowVisibleDisplayFrame(PopupMessageActivity.k(PopupMessageActivity.this));
          int i = PopupMessageActivity.this.getResources().getDisplayMetrics().heightPixels - PopupMessageActivity.k(PopupMessageActivity.this).bottom;
          if (i > PopupMessageActivity.c.this.p)
            PopupMessageActivity.a(PopupMessageActivity.this, 1);
          while (true)
          {
            PopupMessageActivity.c.this.p = i;
            if ((PopupMessageActivity.l(PopupMessageActivity.this) == 1) || (PopupMessageActivity.l(PopupMessageActivity.this) == 2))
              PopupMessageActivity.m(PopupMessageActivity.this).postDelayed(new Runnable()
              {
                public void run()
                {
                  PopupMessageActivity.c.this.g.scrollBy(0, com.viber.voip.util.e.j.a(10.0F));
                }
              }
              , 100L);
            return;
            if ((i == PopupMessageActivity.c.this.p) && (i != 0))
              PopupMessageActivity.a(PopupMessageActivity.this, 2);
          }
        }
      });
      this.i = ((EditText)PopupMessageActivity.this.findViewById(R.id.text_editor));
      this.h = ((ImageButton)PopupMessageActivity.this.findViewById(R.id.reply_button));
      this.a = ((PopupViewPagerRoot)PopupMessageActivity.this.findViewById(R.id.switcher));
      this.b = ((ViewPager)PopupMessageActivity.this.findViewById(R.id.switcherName));
      this.c = ((ViewPager)PopupMessageActivity.this.findViewById(R.id.switcherGroup));
      this.f = ((LinearLayout)PopupMessageActivity.this.findViewById(R.id.header));
      this.d = ((ImageButton)PopupMessageActivity.this.findViewById(R.id.closeImageButton));
      this.e = ((ImageButton)PopupMessageActivity.this.findViewById(R.id.openImageButton));
      this.j = ((Button)PopupMessageActivity.this.findViewById(R.id.open_conversation));
      this.k = PopupMessageActivity.this.findViewById(R.id.bottom_panel_popup);
      this.l = PopupMessageActivity.this.findViewById(R.id.popup_panel);
      this.m = PopupMessageActivity.this.findViewById(R.id.sticker_panel_container);
      this.n = ((PopupStickerQuickReply)PopupMessageActivity.this.findViewById(R.id.sticker_panel));
      this.o = PopupMessageActivity.this.findViewById(R.id.sticker_panel_overlay);
    }
  }

  private static class d extends com.viber.voip.d.b<PopupMessageActivity>
  {
    private d(PopupMessageActivity paramPopupMessageActivity)
    {
      super();
    }

    public void a(PopupMessageActivity paramPopupMessageActivity)
    {
      PopupMessageActivity.b(paramPopupMessageActivity);
      PopupMessageActivity.c(paramPopupMessageActivity);
      PopupMessageActivity.d(paramPopupMessageActivity).a.c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.PopupMessageActivity
 * JD-Core Version:    0.6.2
 */