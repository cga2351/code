package com.viber.voip.messages.ui.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.text.TextUtils;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.provider.d.a;
import com.viber.voip.R.anim;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.an;
import com.viber.voip.an.c;
import com.viber.voip.an.d;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.camrecorder.preview.DoodleActivity;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.invitelinks.f;
import com.viber.voip.invitelinks.linkscreen.g.a;
import com.viber.voip.messages.a.l.b;
import com.viber.voip.messages.adapters.t;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai.b;
import com.viber.voip.messages.controller.ai.e;
import com.viber.voip.messages.controller.bv.m;
import com.viber.voip.messages.controller.manager.ah;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.v;
import com.viber.voip.messages.extras.a.e.b;
import com.viber.voip.messages.extras.wink.WinkDescription;
import com.viber.voip.messages.forward.GroupReferralForwardInfo;
import com.viber.voip.messages.ui.ConversationGalleryActivity;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.messages.ui.view.AnimatedLikesView.a;
import com.viber.voip.messages.ui.view.AnimatedLikesView.b;
import com.viber.voip.messages.ui.view.ViewPagerWithPagingEnable;
import com.viber.voip.messages.ui.view.ViewPagerWithPagingEnable.a;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.phone.call.CallHandler.CallInfoReadyListener;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.sound.tones.SampleTone;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.ui.style.InternalURLSpan;
import com.viber.voip.ui.style.InternalURLSpan.a;
import com.viber.voip.util.ViberActionRunner.az.c;
import com.viber.voip.util.ViberActionRunner.be;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.at;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import com.viber.voip.util.cq;
import com.viber.voip.util.cq.a;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.j;
import com.viber.voip.util.upload.s;
import com.viber.voip.widget.PlayableImageView;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class ViewMediaActivity extends ViberFragmentActivity
  implements ViewPager.OnPageChangeListener, m.c, d.a, an.d, g.a, bv.m, e.e, k.a, n.b, CallHandler.CallInfoReadyListener, cq.a
{
  private static final Logger r = ViberEnv.getLogger();
  private com.viber.voip.messages.i A;
  private aa B;
  private int C = -1;
  private long D = -1L;
  private com.viber.voip.invitelinks.linkscreen.g E;
  private int F = 0;
  private boolean G;
  private int H = -1;
  private b I;
  private t J;
  private Map<Long, Integer> K;
  private boolean L;
  private boolean M;
  private boolean N;
  private boolean O;
  private boolean P;
  private BroadcastReceiver Q;
  private com.viber.voip.messages.ui.ai R;
  private Menu S;
  private an T;
  private cq U;
  private boolean V = true;
  private View W;
  private boolean X;
  private com.viber.common.permission.b Y;
  private int Z;
  protected android.support.v7.app.a a;
  private Set<Long> aa;
  private final com.viber.voip.util.upload.m ab;
  private Map<Integer, a> ac;
  private final InternalURLSpan.a ad;
  protected TextView b;
  protected TextView c;
  protected View d;
  protected e e;
  protected v f;
  protected boolean g;
  protected boolean h;

  @Inject
  Engine i;

  @Inject
  com.viber.voip.messages.d.b j;

  @Inject
  c k;

  @Inject
  com.viber.voip.messages.controller.ai l;

  @Inject
  com.viber.voip.invitelinks.d m;

  @Inject
  dagger.a<com.viber.voip.messages.k> n;

  @Inject
  com.viber.voip.messages.extras.a.e o;

  @Inject
  ah p;
  final e.b q;
  private ViewPagerWithPagingEnable s;
  private TextView t;
  private AnimatedLikesView u;
  private View v;
  private long w = -1L;
  private int x = 0;
  private boolean y;
  private boolean z = true;

  public ViewMediaActivity()
  {
    android.util.Pair[] arrayOfPair = new android.util.Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(138);
    this.Y = new com.viber.voip.permissions.h(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        ViewMediaActivity.a(ViewMediaActivity.this);
      }
    };
    this.aa = new HashSet();
    this.ab = new com.viber.voip.util.upload.m()
    {
      public void a(Uri paramAnonymousUri, int paramAnonymousInt)
      {
        if ((ViewMediaActivity.b(ViewMediaActivity.this) == null) || (ViewMediaActivity.this.e == null));
        while (!Uri.fromFile(com.viber.voip.util.upload.o.b(ViewMediaActivity.b(ViewMediaActivity.this).C(), ViewMediaActivity.b(ViewMediaActivity.this).q(), ViewMediaActivity.this.getApplicationContext())).equals(paramAnonymousUri))
          return;
        ViewMediaActivity.this.e.a(paramAnonymousInt);
      }
    };
    this.ac = Collections.synchronizedMap(new HashMap());
    this.q = new e.b()
    {
    };
    this.ad = new InternalURLSpan.a()
    {
      public void a(String paramAnonymousString, aa paramAnonymousaa)
      {
        if (!paramAnonymousString.startsWith("tel:"))
          ViberActionRunner.be.a(ViewMediaActivity.this, paramAnonymousString, true);
      }
    };
  }

  private boolean A()
  {
    return getIntent().getBooleanExtra("navigated_to_conversation_after_send_doodle", false);
  }

  private void B()
  {
    if (this.B != null)
    {
      Intent localIntent = com.viber.voip.messages.m.a(this.w, this.B.A(), false, false, false, false);
      localIntent.putExtra("go_up", true);
      startActivity(localIntent);
    }
  }

  private ConversationItemLoaderEntity C()
  {
    if (this.E != null)
      return this.E.b();
    return null;
  }

  private void D()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = C();
    if ((this.J == null) || (this.C > this.J.getCount()) || (localConversationItemLoaderEntity == null))
      return;
    if (localConversationItemLoaderEntity.isCommunityBlocked())
    {
      com.viber.voip.ui.dialogs.d.r().a(this);
      return;
    }
    aa localaa = this.J.a(this.C);
    android.support.v4.util.Pair localPair = this.J.b(localaa);
    if (((Boolean)localPair.first).booleanValue())
    {
      if (((Integer)localPair.second).intValue() <= 1)
        this.u.a(AnimatedLikesView.a.b);
      while (true)
      {
        ViberApplication.getInstance().getRingtonePlayer().playSample(SampleTone.LIKE);
        a(((Boolean)localPair.first).booleanValue(), localaa.ac(), ((Integer)localPair.second).intValue());
        return;
        this.u.a(AnimatedLikesView.a.f);
      }
    }
    AnimatedLikesView localAnimatedLikesView = this.u;
    if (((Integer)localPair.second).intValue() < 1);
    for (AnimatedLikesView.a locala = AnimatedLikesView.a.a; ; locala = AnimatedLikesView.a.e)
    {
      localAnimatedLikesView.a(locala);
      break;
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    this.B = this.J.a(paramInt1);
    this.a.b(paramInt2 - paramInt1 + "/" + paramInt2);
  }

  private void a(Uri paramUri1, Uri paramUri2)
  {
    if ((paramUri1 != null) && (paramUri2 != null))
    {
      ViberApplication.getInstance().getMessagesManager().d().a(this.w, 0, paramUri1.toString(), paramUri2.toString());
      Toast.makeText(this, getString(R.string.conversation_info_bg_changed), 1).show();
    }
  }

  private void a(Menu paramMenu)
  {
    boolean bool1 = true;
    aa localaa;
    boolean bool2;
    boolean bool3;
    boolean bool5;
    label101: boolean bool6;
    label128: Uri localUri;
    label142: boolean bool7;
    boolean bool8;
    if ((this.J != null) && (paramMenu != null))
    {
      localaa = this.J.a(this.C);
      bool2 = this.k.a(com.viber.voip.permissions.n.m);
      if (TextUtils.isEmpty(localaa.o()))
        break label317;
      bool3 = bool1;
      boolean bool4 = localaa.az();
      if ((!bool3) || (!bool4) || (!bool2) || ((localaa.aS()) && (!cd.c(this.H)) && (!cd.d(this.H))))
        break label323;
      bool5 = bool1;
      if ((!bool3) || ((!localaa.aS()) && (!localaa.X())) || (!bool2))
        break label329;
      bool6 = bool1;
      if (!bool3)
        break label335;
      localUri = Uri.parse(localaa.o());
      if (!localaa.ag())
        break label341;
      bool7 = false;
      bool8 = false;
    }
    while (true)
    {
      label155: boolean bool9;
      label170: MenuItem localMenuItem;
      if ((!localaa.ag()) && (bool2))
      {
        bool9 = bool1;
        this.P = bool9;
        dj.a(paramMenu.findItem(R.id.menu_set_lock_screen), bool8);
        dj.a(paramMenu.findItem(R.id.menu_set_wallpaper_screen), bool8);
        localMenuItem = paramMenu.findItem(R.id.menu_view_image_background);
        if ((!bool8) || (localaa.aS()) || (localaa.U()))
          break label429;
      }
      while (true)
      {
        dj.a(localMenuItem, bool1);
        dj.a(paramMenu.findItem(R.id.menu_save_to_gallery), bool7);
        dj.a(paramMenu.findItem(R.id.menu_doodle), bool8);
        dj.a(paramMenu.findItem(R.id.delete_menu), this.G);
        dj.a(paramMenu.findItem(R.id.menu_view_image_forward), u());
        dj.a(paramMenu.findItem(R.id.menu_social), u());
        return;
        label317: bool3 = false;
        break;
        label323: bool5 = false;
        break label101;
        label329: bool6 = false;
        break label128;
        label335: localUri = null;
        break label142;
        label341: if ((bool3) && (localaa.aS()))
        {
          if ((dv.a(localUri, dv.J, this)) || (dv.a(localUri, dv.K, this)));
          for (bool7 = bool1; ; bool7 = false)
          {
            bool8 = bool5;
            break;
          }
        }
        if ((!bool3) || (!localaa.X()))
          break label434;
        bool7 = dv.a(localUri, dv.p, this);
        bool8 = bool5;
        break label155;
        bool9 = false;
        break label170;
        label429: bool1 = false;
      }
      label434: bool7 = bool6;
      bool8 = bool5;
    }
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramBoolean2)
    {
      this.u.setVisibility(0);
      String str;
      if (paramInt > 0)
      {
        str = da.b(paramInt);
        if ((!paramBoolean1) || (paramInt <= 0))
          break label70;
      }
      label70: for (AnimatedLikesView.b localb = AnimatedLikesView.b.b; ; localb = AnimatedLikesView.b.a)
      {
        this.u.a(str, localb);
        this.u.setLikesClickListener(new i(this));
        return;
        str = "";
        break;
      }
    }
    this.u.setVisibility(8);
  }

  private void b(String paramString)
  {
    this.a.a(paramString);
  }

  private boolean c(int paramInt)
  {
    return (this.ac != null) && (this.ac.get(Integer.valueOf(paramInt)) != null);
  }

  private void w()
  {
    if (this.f.d())
      this.f.l();
    while (true)
    {
      this.W.setVisibility(8);
      return;
      this.f.i();
    }
  }

  private boolean x()
  {
    return (this.B == null) || (TextUtils.isEmpty(this.B.o()));
  }

  private void y()
  {
    this.s = ((ViewPagerWithPagingEnable)findViewById(R.id.media_pager));
    this.s.setPageMargin(j.a(15.0F));
    this.a = getSupportActionBar();
    if (this.a != null)
      this.a.a("");
    this.v = findViewById(R.id.message_info);
    this.t = ((TextView)findViewById(R.id.contact_name));
    this.b = ((TextView)findViewById(R.id.description_text));
    this.c = ((TextView)findViewById(R.id.received_time));
    this.u = ((AnimatedLikesView)findViewById(R.id.like_view));
    this.d = findViewById(R.id.seekbar_panel);
    this.W = findViewById(R.id.empty_permissions_container);
    ((TextView)findViewById(R.id.permission_description)).setText(R.string.storage_permission_description);
    ((ImageView)findViewById(R.id.permission_icon)).setImageResource(R.drawable.ic_permission_storage);
    findViewById(R.id.button_request_permission).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ViewMediaActivity.this.k.a(ViewMediaActivity.this, 138, com.viber.voip.permissions.n.m);
      }
    });
  }

  private boolean z()
  {
    return getIntent().getBooleanExtra("navigated_to_conversation_on_back", false);
  }

  public int a(long paramLong, int paramInt, v paramv)
  {
    int i1 = paramv.getCount();
    int i2;
    if ((paramInt > i1 - 1) || (-1 == paramInt))
    {
      i2 = i1 - 1;
      if (paramLong == -1L);
    }
    else
    {
      for (int i3 = 0; ; i3++)
      {
        if (i3 >= i1)
          break label74;
        if (paramv.f(i3).a() == paramLong)
        {
          return i3;
          i2 = paramInt;
          break;
        }
      }
    }
    label74: return i2;
  }

  public an.c a(int paramInt, Uri paramUri, String paramString)
  {
    if (this.T != null)
      return this.T.c(paramInt, paramUri, paramString);
    return null;
  }

  public void a()
  {
    ViberApplication.getInstance().getMessagesManager().c().a(this.B.a(), this.B.C());
  }

  public void a(int paramInt)
  {
    if (this.ac != null)
      this.ac.remove(Integer.valueOf(paramInt));
  }

  public void a(int paramInt, Uri paramUri)
  {
  }

  public void a(int paramInt, an.c paramc)
  {
  }

  public void a(int paramInt, a parama)
  {
    this.ac.put(Integer.valueOf(paramInt), parama);
  }

  public void a(long paramLong1, long paramLong2)
  {
    if (c(this.C))
    {
      ((a)this.ac.get(Integer.valueOf(this.C))).a(paramLong1, paramLong2);
      this.F = ((int)paramLong2);
    }
  }

  public void a(MessageEntity paramMessageEntity, int paramInt)
  {
    if ((paramInt == 4) && (this.w == paramMessageEntity.getConversationId()))
      com.viber.voip.ui.dialogs.k.m().d();
  }

  public void a(String paramString)
  {
    if (c(this.C))
      ((a)this.ac.get(Integer.valueOf(this.C))).a(paramString);
    this.I.b();
    if (TextUtils.isEmpty(paramString))
      com.viber.voip.ui.dialogs.o.e().a(this);
  }

  public void a(boolean paramBoolean)
  {
    if (c(this.C))
      ((a)this.ac.get(Integer.valueOf(this.C))).a();
    if (paramBoolean)
    {
      this.I.b(1500);
      return;
    }
    this.I.a(0);
  }

  protected boolean a(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if ((localBundle != null) && (paramIntent.getLongExtra("thread_id", -1L) != -1L))
    {
      this.w = localBundle.getLong("thread_id");
      this.x = localBundle.getInt("conversation_type", 0);
      this.y = localBundle.getBoolean("is_secret_conversation", false);
      this.z = localBundle.getBoolean("is_share_and_forward_available", true);
      b(paramIntent.getStringExtra("screen_title"));
      this.M = com.viber.voip.notif.g.a(paramIntent);
      boolean bool1 = this.M;
      boolean bool2 = false;
      if (bool1)
      {
        boolean bool3 = localBundle.getBoolean("extra_play", false);
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
      this.h = bool2;
      this.H = paramIntent.getIntExtra("participant_role", -1);
      return true;
    }
    finish();
    return false;
  }

  public void b()
  {
    s.a(this.B, false);
  }

  protected void b(int paramInt)
  {
    int i1 = 1;
    aa localaa = this.J.a(paramInt);
    this.g = localaa.aA();
    this.D = localaa.a();
    String str = localaa.o();
    if ((this.g) && (!TextUtils.isEmpty(str)));
    for (Uri localUri = Uri.parse(str); ; localUri = null)
    {
      ViewPagerWithPagingEnable localViewPagerWithPagingEnable = this.s;
      int i5;
      if (this.J.getCount() > i1)
      {
        int i3 = i1;
        localViewPagerWithPagingEnable.setPagingEnabled(i3);
        TextView localTextView = this.b;
        if ((!this.a.h()) || (TextUtils.isEmpty(localaa.i())))
          break label429;
        i5 = 0;
        label111: localTextView.setVisibility(i5);
        this.b.setText(localaa.a(this.R, this.j, false, false, this.H));
        com.viber.voip.util.links.e.a(this.b);
        this.t.setText(dg.a(localaa, this.H));
        this.c.setText(this.A.e(localaa.e()));
        dj.b(this.c, i1);
        a(localaa.ab(), localaa.ac(), localaa.n());
        if (!this.g)
          break label441;
        if (this.D != getIntent().getLongExtra("msg_id", -1L))
          break label436;
        label235: this.h = i1;
        if (this.e == null)
          m();
        if ((localUri == null) || (this.e.c() == null) || (!localUri.getPath().equals(this.e.c().getPath())) || (this.e.d() == e.d.d))
          this.e.a(localUri, localaa.B());
        label313: if ((this.e == null) || (this.e.l()) || (this.e.d().equals(e.d.f)) || (!this.e.e()) || (localUri == null))
          break label563;
        this.I.b();
      }
      while (true)
      {
        this.G = com.viber.voip.messages.m.a(localaa, this.H, null);
        if (localaa.aV())
          this.G = cd.a(this.H, localaa.ap(), localaa.bG());
        this.C = paramInt;
        a(this.S);
        return;
        int i4 = 0;
        break;
        label429: i5 = 8;
        break label111;
        label436: int i2 = 0;
        break label235;
        label441: if ((TextUtils.isEmpty(localaa.o())) && (localaa.C() != null) && (!s.a(dx.a(localaa))) && (localaa.f() != -2) && (!this.aa.contains(Long.valueOf(localaa.a()))) && (cj.b(this)))
        {
          this.aa.add(Long.valueOf(localaa.a()));
          ViberApplication.getInstance().getMessagesManager().c().a(localaa.a(), localaa.C());
        }
        if (this.e == null)
          break label313;
        this.e.a(false, false);
        break label313;
        label563: this.I.c();
      }
    }
  }

  public void b(int paramInt, an.c paramc)
  {
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
      if (!this.f.b())
        this.f.y_();
    while (!this.f.b())
      return;
    this.f.c();
  }

  public void c()
  {
    if ((!c(this.C)) || (this.e.l()));
    do
    {
      return;
      ((a)this.ac.get(Integer.valueOf(this.C))).a(this.F);
      if ((this.h) && (!this.L) && (this.F <= 0))
      {
        this.L = true;
        this.e.i();
        return;
      }
      this.e.b(this.F);
    }
    while ((!this.h) || (this.F <= 0));
    this.e.i();
  }

  public void c(boolean paramBoolean)
  {
    this.s.setPagingEnabled(paramBoolean);
  }

  public void d()
  {
    if (c(this.C));
  }

  public void d(final boolean paramBoolean)
  {
    ai.b local10 = new ai.b()
    {
      public void a(Set<Long> paramAnonymousSet)
      {
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            ViewMediaActivity.a(ViewMediaActivity.this, true);
            ViewMediaActivity.this.f.l();
            if ((ViewMediaActivity.this.g) && (ViewMediaActivity.this.e != null))
            {
              if (ViewMediaActivity.this.e.l())
                ViewMediaActivity.this.e.j();
              ViewMediaActivity.this.e.a(false);
            }
            if (ViewMediaActivity.10.this.a)
              ViewMediaActivity.this.finish();
          }
        });
      }
    };
    com.viber.voip.messages.controller.ai localai = ViberApplication.getInstance().getMessagesManager().c();
    if (this.B.aS())
    {
      localai.a(this.B.a(), local10);
      return;
    }
    localai.a(Collections.singleton(Long.valueOf(this.B.a())), false, local10);
  }

  public void e()
  {
    if (c(this.C))
      ((a)this.ac.get(Integer.valueOf(this.C))).c();
    this.I.b(0);
    this.F = 0;
  }

  public void e(boolean paramBoolean)
  {
    if (this.B.aS())
    {
      r.l().a(this).a(Boolean.valueOf(paramBoolean)).a(this);
      return;
    }
    com.viber.voip.ui.dialogs.o.a().a(this).a(Boolean.valueOf(paramBoolean)).a(this);
  }

  public void f()
  {
    if (c(this.C))
      ((a)this.ac.get(Integer.valueOf(this.C))).b();
    this.I.c();
    dj.a(this.S.findItem(R.id.menu_view_image_forward), false);
    dj.a(this.S.findItem(R.id.menu_social), false);
    dj.a(this.S.findItem(R.id.delete_menu), false);
  }

  public void f(boolean paramBoolean)
  {
    Intent localIntent1 = ViberActionRunner.u.a(this.B);
    Intent localIntent2 = ViberActionRunner.bm.a(this, this.w, this.x, this.B.a(), getIntent().getStringExtra("screen_title"), this.H, false, u(), A());
    localIntent2.putExtra("with_splash", paramBoolean);
    localIntent1.putExtra("back_intent", localIntent2);
    ConversationItemLoaderEntity localConversationItemLoaderEntity = C();
    if ((com.viber.voip.messages.m.c(localConversationItemLoaderEntity)) && (this.B.bx().getGroupReferralInfo() == null))
    {
      Bundle localBundle = new Bundle(1);
      localBundle.putParcelable("group_referral_extra_info", new GroupReferralForwardInfo(localConversationItemLoaderEntity.getGroupId(), localConversationItemLoaderEntity.getGroupRole(), localConversationItemLoaderEntity.getGroupName()));
      ViberActionRunner.u.a(localIntent1, localBundle);
    }
    finish();
    startActivity(localIntent1);
  }

  public void finish()
  {
    if (z())
      B();
    super.finish();
  }

  public void g(boolean paramBoolean)
  {
    aa localaa = this.J.a(this.C);
    new ViberActionRunner.az.c(this, this.l, new f(this.m, cj.a(this))).a(this.w, localaa, paramBoolean, null);
  }

  public boolean g()
  {
    return (this.e != null) && (this.e.m());
  }

  public void h()
  {
    this.Z = this.f.getCount();
    if (this.Z == 0)
    {
      if (this.J != null)
        this.J.notifyDataSetChanged();
      finish();
    }
    while (this.s == null)
      return;
    if (this.J == null)
    {
      if (this.C == -1)
      {
        this.D = getIntent().getLongExtra("msg_id", -1L);
        this.C = a(this.D, -1, this.f);
      }
      if ((this.M) && (this.C != -1))
      {
        aa localaa = this.f.f(this.C);
        if (localaa != null)
          ViberApplication.getInstance().getMessagesManager().c().a(localaa);
      }
      this.K = new HashMap();
      this.T.a(this.s.getWidth(), this.s.getHeight());
      this.J = new t(this, getSupportFragmentManager(), this.f, p(), this.T);
      this.s.setOnSizeChangeListener(new ViewPagerWithPagingEnable.a()
      {
        public void a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          ViewMediaActivity.e(ViewMediaActivity.this).a(paramAnonymousInt1, paramAnonymousInt2);
          ViewMediaActivity.f(ViewMediaActivity.this).post(new Runnable()
          {
            public void run()
            {
              ViewMediaActivity.c(ViewMediaActivity.this).notifyDataSetChanged();
            }
          });
        }
      });
      this.s.setAdapter(this.J);
      this.s.addOnPageChangeListener(this);
      this.J.notifyDataSetChanged();
      this.s.setCurrentItem(this.C, false);
    }
    while (true)
    {
      b(this.C);
      if (this.N)
      {
        this.J.d();
        this.N = false;
      }
      a(this.S);
      this.J.b(this.C);
      a(this.C, this.Z);
      this.s.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
      {
        private int b;

        public void onPageScrollStateChanged(int paramAnonymousInt)
        {
          ViewMediaActivity.b(ViewMediaActivity.this, 0);
          if (ViewMediaActivity.c(ViewMediaActivity.this) == null)
            return;
          label34: boolean bool1;
          if (paramAnonymousInt != 0)
          {
            ViewMediaActivity.c(ViewMediaActivity.this).a();
            if (paramAnonymousInt != 1)
              break label302;
            this.b = ViewMediaActivity.d(ViewMediaActivity.this);
            if (ViewMediaActivity.this.e == null)
              break label405;
            ViewMediaActivity.this.e.o();
            if (ViewMediaActivity.this.e.d().equals(e.a.e))
              break label291;
            bool1 = true;
          }
          while (true)
          {
            label91: Iterator localIterator = ViewMediaActivity.h(ViewMediaActivity.this).entrySet().iterator();
            boolean bool2 = bool1;
            label113: Map.Entry localEntry;
            if (localIterator.hasNext())
            {
              localEntry = (Map.Entry)localIterator.next();
              if (localEntry.getValue() != null)
                if (ViewMediaActivity.this.b.getVisibility() != 8)
                  break label296;
            }
            label291: label296: for (boolean bool3 = true; ; bool3 = false)
            {
              bool2 &= bool3;
              ((ViewMediaActivity.a)localEntry.getValue()).a(bool2);
              break label113;
              break;
              ViewMediaActivity.c(ViewMediaActivity.this).b(ViewMediaActivity.d(ViewMediaActivity.this));
              if ((this.b == ViewMediaActivity.d(ViewMediaActivity.this)) || (ViewMediaActivity.this.e == null) || (!ViewMediaActivity.c(ViewMediaActivity.this, this.b)))
                break label34;
              ((ViewMediaActivity.a)ViewMediaActivity.h(ViewMediaActivity.this).get(Integer.valueOf(this.b))).b(this.b);
              ViewMediaActivity.i(ViewMediaActivity.this).a();
              break label34;
              bool1 = false;
              break label91;
            }
            label302: if ((ViewMediaActivity.d(ViewMediaActivity.this) != this.b) || (paramAnonymousInt != 0) || (!ViewMediaActivity.c(ViewMediaActivity.this).a(ViewMediaActivity.d(ViewMediaActivity.this)).aA()))
              break;
            if (ViewMediaActivity.c(ViewMediaActivity.this, ViewMediaActivity.d(ViewMediaActivity.this)));
            ViewMediaActivity.this.b(ViewMediaActivity.d(ViewMediaActivity.this));
            if ((!ViewMediaActivity.j(ViewMediaActivity.this)) || (ViewMediaActivity.this.e == null))
              break;
            ViewMediaActivity.this.e.p();
            return;
            label405: bool1 = false;
          }
        }

        public void onPageSelected(int paramAnonymousInt)
        {
          if (paramAnonymousInt != ViewMediaActivity.d(ViewMediaActivity.this));
          for (int i = 1; ; i = 0)
          {
            ViewMediaActivity.a(ViewMediaActivity.this, paramAnonymousInt, ViewMediaActivity.g(ViewMediaActivity.this));
            ViewMediaActivity.a(ViewMediaActivity.this, paramAnonymousInt);
            if (i != 0)
            {
              if (ViewMediaActivity.this.e != null)
                ViewMediaActivity.this.e.p();
              ViewMediaActivity.this.b(paramAnonymousInt);
            }
            return;
          }
        }
      });
      return;
      int i1 = this.C;
      this.C = a(this.D, this.C, this.f);
      this.J.a(this.f);
      this.J.notifyDataSetChanged();
      if (i1 != this.C)
        this.s.setCurrentItem(this.C, false);
      else if ((c(this.C)) && (this.e != null) && (!this.e.q()))
        ((a)this.ac.get(Integer.valueOf(this.C))).b(this.e.l());
    }
  }

  public void h(boolean paramBoolean)
  {
    this.O = paramBoolean;
    if (this.O)
      this.I.b(0);
    while ((this.e == null) || (this.e.d().equals(e.d.f)) || (!this.e.e()) || (this.e.l()))
      return;
    this.I.a(0);
  }

  public int i()
  {
    return this.C;
  }

  public int j()
  {
    return this.x;
  }

  public void k()
  {
    if (this.a.h())
    {
      this.I.b(0);
      return;
    }
    this.I.a(0);
  }

  public void l()
  {
    ViberApplication.getInstance().getMessagesManager().c().a(this.w, new ai.e()
    {
      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        com.viber.voip.h.a.b().post(new l.b(paramAnonymousConversationItemLoaderEntity.getId(), paramAnonymousConversationItemLoaderEntity.getParticipantMemberId(), paramAnonymousConversationItemLoaderEntity.getGroupId(), paramAnonymousConversationItemLoaderEntity.getTimebombTime()));
      }
    });
  }

  protected void m()
  {
    TextView localTextView1 = (TextView)findViewById(R.id.current_time);
    TextView localTextView2 = (TextView)findViewById(R.id.all_time);
    SeekBar localSeekBar = (SeekBar)findViewById(R.id.seekBar);
    PlayableImageView localPlayableImageView = (PlayableImageView)findViewById(R.id.control);
    if (c(this.C))
      ((a)this.ac.get(Integer.valueOf(this.C))).b(false);
    h localh = new h(getApplicationContext());
    SimpleExoPlayerView localSimpleExoPlayerView = (SimpleExoPlayerView)findViewById(R.id.videoView);
    if (this.h);
    for (e.a locala = e.a.h; ; locala = e.a.g)
    {
      this.e = new e(localh, localSimpleExoPlayerView, localPlayableImageView, localSeekBar, localTextView1, localTextView2, locala)
      {
        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
          super.onStartTrackingTouch(paramAnonymousSeekBar);
          ViewMediaActivity.i(ViewMediaActivity.this).a(0);
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
          super.onStopTrackingTouch(paramAnonymousSeekBar);
          ViewMediaActivity.i(ViewMediaActivity.this).b(1500);
        }
      };
      this.e.a(this);
      return;
    }
  }

  protected b n()
  {
    return new c(this, null);
  }

  protected v o()
  {
    return new v(this, getSupportLoaderManager(), ViberApplication.getInstance().getLazyMessagesManager(), this, com.viber.voip.h.a.b());
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ViberApplication.getInstance().getFacebookManager().a(this, paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
      switch (paramInt1)
      {
      default:
      case 800:
      case 778:
      }
    do
    {
      return;
      if ((A()) && (!z()))
        B();
      finish();
      final SendMediaDataContainer localSendMediaDataContainer = (SendMediaDataContainer)paramIntent.getParcelableExtra("com.viber.voip.custom_cam_media_preview_media_data");
      ViberApplication.getInstance().getMessagesManager().c().a(this.w, new ai.e()
      {
        public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
        {
          if (localSendMediaDataContainer.winkDescription != null);
          for (MsgInfo localMsgInfo = localSendMediaDataContainer.winkDescription.toMessageInfo(); ; localMsgInfo = null)
          {
            if ((localSendMediaDataContainer.mediaInfo != null) && (localSendMediaDataContainer.mediaInfo.getMediaType() == MediaInfo.a.IMAGE))
            {
              if (localMsgInfo == null)
                localMsgInfo = new MsgInfo();
              FileInfo localFileInfo = localMsgInfo.getFileInfo();
              localFileInfo.setMediaInfo(localSendMediaDataContainer.mediaInfo);
              localFileInfo.setContentType(FileInfo.a.IMAGE);
              File localFile = at.a(ViewMediaActivity.this, localSendMediaDataContainer.fileUri);
              if (localFile != null)
              {
                localFileInfo.setFileName(localFile.getName());
                localFileInfo.setFileExt(at.j(localFile));
              }
              localMsgInfo.setFileInfo(localFileInfo);
            }
            if (localMsgInfo != null);
            for (String str1 = com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo); ; str1 = "")
            {
              com.viber.voip.messages.controller.c.b localb = new com.viber.voip.messages.controller.c.b(paramAnonymousConversationItemLoaderEntity.getId(), paramAnonymousConversationItemLoaderEntity.getGroupId(), paramAnonymousConversationItemLoaderEntity.getParticipantMemberId(), paramAnonymousConversationItemLoaderEntity.getConversationType(), paramAnonymousConversationItemLoaderEntity.getNativeChatType());
              int i = localSendMediaDataContainer.type;
              String str2 = localSendMediaDataContainer.fileUri.toString();
              String str3 = localSendMediaDataContainer.description;
              int j = paramAnonymousConversationItemLoaderEntity.getTimebombTime();
              MessageEntity localMessageEntity = localb.a(i, str2, str3, str1, j);
              localMessageEntity.setExtraStatus(2);
              localMessageEntity.addExtraFlag(localSendMediaDataContainer.mediaFlag);
              if ((localSendMediaDataContainer.winkDescription != null) && (localMsgInfo != null))
                if (!localMsgInfo.getFileInfo().isWinkImage())
                  break label340;
              label340: for (int k = 1003; ; k = 1004)
              {
                localMessageEntity.setMimeType(k);
                localMessageEntity.setConversationId(paramAnonymousConversationItemLoaderEntity.getId());
                if (localSendMediaDataContainer.thumbnailUri != null)
                  localMessageEntity.setBody(localSendMediaDataContainer.thumbnailUri.toString());
                ViberApplication.getInstance().getMessagesManager().c().a(localMessageEntity, null);
                return;
              }
            }
          }
        }
      });
      return;
    }
    while (paramIntent.getExtras() == null);
    a(Uri.parse(paramIntent.getAction()), Uri.parse(paramIntent.getStringExtra("landscapeUri")));
  }

  public void onBackPressed()
  {
    if ((this.O) && (this.g) && (this.ac.get(Integer.valueOf(this.C)) != null))
    {
      this.e.b();
      ((a)this.ac.get(Integer.valueOf(this.C))).d();
      return;
    }
    super.onBackPressed();
  }

  public void onCallInfoReady(CallInfo paramCallInfo)
  {
    if (this.e != null)
      this.e.j();
  }

  public void onConversationDeleted()
  {
    finish();
  }

  public void onConversationReceived(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    AnimatedLikesView localAnimatedLikesView = this.u;
    if (!paramConversationItemLoaderEntity.isDisabledConversation());
    for (boolean bool = true; ; bool = false)
    {
      localAnimatedLikesView.setEnabled(bool);
      return;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    this.A = new com.viber.voip.messages.i();
    getWindow().setFlags(1024, 1024);
    supportRequestWindowFeature(9);
    super.onCreate(paramBundle);
    dj.c(this, false);
    setContentView(R.layout.view_media_layout);
    this.i.addCallInfoListener(this);
    this.I = n();
    this.Q = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (ViewMediaActivity.c(ViewMediaActivity.this) != null)
        {
          ViewMediaActivity.c(ViewMediaActivity.this).notifyDataSetChanged();
          ViewMediaActivity.this.b(ViewMediaActivity.d(ViewMediaActivity.this));
        }
      }
    };
    this.R = new com.viber.voip.messages.ui.ai(this);
    this.X = this.k.a(com.viber.voip.permissions.n.m);
    y();
    Point localPoint = new Point();
    getWindowManager().getDefaultDisplay().getSize(localPoint);
    this.T = new an(this, localPoint.x, localPoint.y, 0.2F);
    this.T.a(this);
    if (a(getIntent()))
    {
      this.E = new com.viber.voip.invitelinks.linkscreen.g(this.w, new com.viber.voip.messages.conversation.m(this.x, this, getSupportLoaderManager(), this.n));
      this.E.a(this);
      this.f = o();
      this.f.p();
      this.f.a(this.w);
      if (!this.k.a(com.viber.voip.permissions.n.m))
        break label297;
      this.f.i();
    }
    while (true)
    {
      this.o.a(this.q);
      this.U = new cq(this);
      this.U.a(this);
      return;
      label297: this.W.setVisibility(0);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_media_view, paramMenu);
    this.S = paramMenu;
    return true;
  }

  protected void onDestroy()
  {
    ViberApplication.getInstance().getEngine(false).removeCallInfoListener(this);
    this.ac.clear();
    this.ac = null;
    if (this.J != null)
    {
      this.K.clear();
      this.J.c();
    }
    if (this.E != null)
      this.E.d();
    if (this.f != null)
      this.f.q();
    if (this.ac != null)
      this.ac.clear();
    if (this.e != null)
    {
      this.e.r();
      this.e = null;
    }
    ViberApplication.getInstance().getFacebookManager().b(this.q);
    super.onDestroy();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (((paramm.a(DialogCode.D245)) || (paramm.a(DialogCode.D1028))) && (-1 == paramInt) && ((paramm.d() instanceof Boolean)))
      d(((Boolean)paramm.d()).booleanValue());
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    h();
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
      finish();
    int i1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                if (this.J == null)
                  return false;
                i1 = paramMenuItem.getItemId();
                if (i1 != R.id.menu_social)
                  break;
              }
              while (x());
              g(false);
              return true;
              if (i1 == R.id.menu_view_image_forward)
              {
                f(false);
                return true;
              }
              if (i1 != R.id.menu_set_wallpaper_screen)
                break;
            }
            while (x());
            com.viber.voip.messages.extras.image.b.a(this, Uri.parse(this.B.o()));
            return true;
            if (i1 != R.id.menu_set_lock_screen)
              break;
          }
          while (x());
          com.viber.voip.messages.extras.image.b.b(this, Uri.parse(this.B.o()));
          return true;
          if (i1 != R.id.menu_view_image_background)
            break;
        }
        while (x());
        startActivityForResult(com.viber.voip.messages.extras.image.b.a(this, new com.viber.voip.backgrounds.n(Uri.parse(this.B.o()))), 778);
        return true;
        if (i1 == R.id.delete_menu)
        {
          e(false);
          return true;
        }
        if (i1 != R.id.menu_doodle)
          break;
      }
      while (x());
      int i2 = this.B.A();
      boolean bool1 = this.B.V();
      boolean bool2 = false;
      if (!bool1)
        if (i2 != 0)
        {
          bool2 = false;
          if (i2 != 1);
        }
        else
        {
          bool2 = true;
        }
      DoodleActivity.a(this, this.B.b(), this.B.o(), Uri.parse(this.B.o()), 800, bool2, null);
      return true;
    }
    while (i1 != R.id.menu_save_to_gallery);
    if ((com.viber.voip.util.upload.o.b(true)) && (com.viber.voip.util.upload.o.a(true)))
    {
      ViberApplication.getInstance().getMessagesManager().c().b(this.B.a(), Uri.fromFile(com.viber.voip.util.upload.o.a(this.B.C(), this.B.q(), this)));
      return true;
    }
    com.viber.voip.ui.dialogs.k.g().d();
    return true;
  }

  public void onPageScrollStateChanged(int paramInt)
  {
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void onPageSelected(int paramInt)
  {
    k localk = (k)this.J.getItem(paramInt);
    aa localaa = this.J.a(paramInt);
    int i1 = localk.f();
    if ((1 == i1) && (!this.K.containsValue(Integer.valueOf(i1))) && (!localaa.ad()))
    {
      this.K.put(Long.valueOf(localaa.a()), Integer.valueOf(i1));
      ad.a().d();
    }
  }

  protected void onPause()
  {
    unregisterReceiver(this.Q);
    com.viber.voip.messages.controller.manager.o.a().b(this);
    if ((this.g) && (this.e != null))
    {
      getIntent().putExtra("current_played_duration", this.e.s());
      getIntent().putExtra("msg_id", this.B.a());
      this.e.k();
    }
    super.onPause();
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    a(paramMenu);
    return super.onPrepareOptionsMenu(paramMenu);
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }

  protected void onResume()
  {
    if (this.V)
      this.h = false;
    while (true)
    {
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
      localIntentFilter.addDataScheme("file");
      registerReceiver(this.Q, localIntentFilter);
      com.viber.voip.messages.controller.manager.o.a().a(this);
      this.F = getIntent().getIntExtra("current_played_duration", 0);
      super.onResume();
      return;
      this.V = true;
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("position", this.C);
    super.onSaveInstanceState(paramBundle);
  }

  protected void onStart()
  {
    InternalURLSpan.addClickListener(this.ad);
    s.a(this.ab);
    this.p.a(this.w);
    this.k.a(this.Y);
    if (this.y)
      this.U.a();
    if ((!this.X) && (this.k.a(com.viber.voip.permissions.n.m)))
    {
      this.X = true;
      w();
    }
    super.onStart();
  }

  protected void onStop()
  {
    if (this.J != null)
      this.J.a();
    InternalURLSpan.removeClickListener(this.ad);
    s.b(this.ab);
    this.p.b(this.w);
    this.U.b();
    this.k.b(this.Y);
    if ((this.e != null) && (this.e.m()))
    {
      this.e.j();
      this.e.r();
      this.e = null;
    }
    super.onStop();
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!isFinishing())
      com.viber.voip.util.links.e.a().a(paramBoolean, hashCode());
  }

  protected e p()
  {
    return new d();
  }

  public CharSequence q()
  {
    return this.a.b();
  }

  public void r()
  {
    this.e.i();
    this.I.b();
  }

  public int s()
  {
    return this.Z;
  }

  public boolean t()
  {
    return this.G;
  }

  public boolean u()
  {
    return (this.z) && (this.P);
  }

  public void v()
  {
    Intent localIntent = ConversationGalleryActivity.a(this.w, this.B.A(), this.z, true, this.a.b().toString(), this.H);
    localIntent.setFlags(1073741824);
    startActivity(localIntent);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void a(long paramLong1, long paramLong2);

    public abstract void a(String paramString);

    public abstract void a(boolean paramBoolean);

    public abstract void b();

    public abstract void b(int paramInt);

    public abstract void b(boolean paramBoolean);

    public abstract void c();

    public abstract void d();
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void b();

    public abstract void b(int paramInt);

    public abstract void c();
  }

  private class c
    implements ViewMediaActivity.b
  {
    private final Handler b = av.a(av.e.a);
    private Animation c;
    private Animation d;
    private Animation e;
    private Animation f;
    private Runnable g = new Runnable()
    {
      public void run()
      {
        if (ViewMediaActivity.this.isFinishing());
        do
        {
          do
          {
            do
            {
              return;
              ViewMediaActivity.c.this.a();
            }
            while ((!ViewMediaActivity.this.g) || (ViewMediaActivity.this.d.getVisibility() != 8));
            if ((ViewMediaActivity.this.e != null) && (ViewMediaActivity.this.e.e()))
            {
              ViewMediaActivity.this.d.setVisibility(0);
              ViewMediaActivity.this.d.startAnimation(ViewMediaActivity.c.a(ViewMediaActivity.c.this));
            }
          }
          while ((ViewMediaActivity.this.e == null) || (ViewMediaActivity.this.e.d() == e.d.a));
          ViewMediaActivity.this.e.a(true, true);
        }
        while (!ViewMediaActivity.this.e.l());
        ViewMediaActivity.c.this.b(1500);
      }
    };
    private Runnable h = new Runnable()
    {
      public void run()
      {
        if (ViewMediaActivity.this.isFinishing());
        do
        {
          do
          {
            return;
            if (ViewMediaActivity.this.a.h())
            {
              ViewMediaActivity.k(ViewMediaActivity.this).startAnimation(ViewMediaActivity.c.b(ViewMediaActivity.c.this));
              ViewMediaActivity.k(ViewMediaActivity.this).setVisibility(8);
              ViewMediaActivity.this.a.g();
            }
          }
          while (!ViewMediaActivity.this.g);
          if (ViewMediaActivity.this.d.getVisibility() == 0)
          {
            ViewMediaActivity.this.d.setVisibility(8);
            ViewMediaActivity.this.d.startAnimation(ViewMediaActivity.c.c(ViewMediaActivity.c.this));
          }
        }
        while (ViewMediaActivity.this.e == null);
        ViewMediaActivity.this.e.a(false, true);
      }
    };

    private c(Context arg2)
    {
      Context localContext;
      this.c = AnimationUtils.loadAnimation(localContext, R.anim.bottom_slide_in);
      this.d = AnimationUtils.loadAnimation(localContext, R.anim.bottom_slide_out);
      this.c.setDuration(150L);
      this.d.setDuration(150L);
      this.e = this.c;
      this.f = this.d;
    }

    public void a()
    {
      if (!ViewMediaActivity.this.a.h())
      {
        ViewMediaActivity.k(ViewMediaActivity.this).startAnimation(this.e);
        ViewMediaActivity.k(ViewMediaActivity.this).setVisibility(0);
        ViewMediaActivity.this.a.f();
      }
    }

    public void a(int paramInt)
    {
      this.b.removeCallbacks(this.h);
      this.b.postDelayed(this.g, paramInt);
    }

    public void b()
    {
      this.b.removeCallbacks(this.h);
      if ((ViewMediaActivity.this.g) && (!ViewMediaActivity.j(ViewMediaActivity.this)) && (ViewMediaActivity.this.d.getVisibility() == 8) && (ViewMediaActivity.this.b.getVisibility() == 0))
      {
        ViewMediaActivity.this.d.setVisibility(0);
        ViewMediaActivity.this.d.startAnimation(this.c);
      }
      while ((ViewMediaActivity.this.g) || (ViewMediaActivity.this.d.getVisibility() != 0))
        return;
      ViewMediaActivity.this.d.setVisibility(8);
      ViewMediaActivity.this.d.startAnimation(this.d);
    }

    public void b(int paramInt)
    {
      this.b.removeCallbacks(this.g);
      this.b.postDelayed(this.h, paramInt);
    }

    public void c()
    {
      ViewMediaActivity.this.d.setVisibility(8);
    }
  }

  protected static class d
    implements ViewMediaActivity.e
  {
    public n a(Bundle paramBundle)
    {
      n localn = new n();
      localn.setArguments(paramBundle);
      return localn;
    }

    public o b(Bundle paramBundle)
    {
      o localo = new o();
      localo.setArguments(paramBundle);
      return localo;
    }
  }

  public static abstract interface e
  {
    public abstract n a(Bundle paramBundle);

    public abstract o b(Bundle paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.ViewMediaActivity
 * JD-Core Version:    0.6.2
 */