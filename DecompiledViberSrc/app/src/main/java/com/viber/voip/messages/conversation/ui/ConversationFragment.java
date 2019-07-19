package com.viber.voip.messages.conversation.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.h;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av.e;
import com.viber.voip.banner.notificationsoff.f.a;
import com.viber.voip.block.k.b;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.i.c.h;
import com.viber.voip.messages.MessageEditText;
import com.viber.voip.messages.controller.ai.b;
import com.viber.voip.messages.controller.bv.m;
import com.viber.voip.messages.controller.ca;
import com.viber.voip.messages.controller.cl;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aj.b;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.presenter.BottomPanelPresenter;
import com.viber.voip.messages.conversation.ui.presenter.ChatExtentionPresenter;
import com.viber.voip.messages.conversation.ui.presenter.GeneralConversationPresenter;
import com.viber.voip.messages.conversation.ui.presenter.GeneralRegularConversationPresenter;
import com.viber.voip.messages.conversation.ui.presenter.MessagesActionsPresenter;
import com.viber.voip.messages.conversation.ui.presenter.OptionsMenuPresenter;
import com.viber.voip.messages.conversation.ui.presenter.RegularMessagesActionsPresenter;
import com.viber.voip.messages.conversation.ui.presenter.SearchMessagesOptionMenuPresenter;
import com.viber.voip.messages.conversation.ui.presenter.SendMessagePresenter;
import com.viber.voip.messages.conversation.ui.presenter.TranslateMessagePresenter;
import com.viber.voip.messages.conversation.ui.presenter.banners.bottom.BottomBannerPresenter;
import com.viber.voip.messages.conversation.ui.presenter.banners.bottom.RegularGroupBottomBannerPresenter;
import com.viber.voip.messages.conversation.ui.presenter.banners.center.CenterBannerPresenter;
import com.viber.voip.messages.conversation.ui.presenter.banners.top.RegularGroupTopBannerPresenter;
import com.viber.voip.messages.conversation.ui.presenter.banners.top.TopBannerPresenter;
import com.viber.voip.messages.conversation.ui.presenter.input.InputFieldPresenter.b;
import com.viber.voip.messages.conversation.ui.presenter.input.RegularConversationsInputFieldPresenter;
import com.viber.voip.messages.conversation.ui.presenter.theme.ConversationThemePresenter;
import com.viber.voip.messages.conversation.ui.spam.RegularPotentialSpamController;
import com.viber.voip.messages.extensions.b.i.a;
import com.viber.voip.messages.o.a;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.messages.ui.CallerContainer;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.by;
import com.viber.voip.messages.ui.cy.a;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.messages.ui.input.MessageComposerInputManager;
import com.viber.voip.messages.ui.input.handlers.ChatExInputHandler;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.bm;
import com.viber.voip.settings.d.n;
import com.viber.voip.settings.d.r;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.e.b;
import com.viber.voip.ui.t.a;
import com.viber.voip.ui.t.b;
import com.viber.voip.ui.t.c;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ParcelableUtils;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.aa;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.az.c;
import com.viber.voip.util.ViberActionRunner.bf;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.at.a;
import com.viber.voip.util.cj;
import com.viber.voip.util.cq;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity.a;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class ConversationFragment extends com.viber.voip.mvp.core.c<com.viber.voip.messages.conversation.ui.view.b.a, com.viber.voip.messages.conversation.ui.view.e>
  implements SwipeRefreshLayout.OnRefreshListener, m.c, m.h, k.b, com.viber.voip.gallery.selection.q.a, bv.m, com.viber.voip.messages.conversation.ab, com.viber.voip.messages.conversation.adapter.d.k, com.viber.voip.messages.conversation.adapter.d.r, aj.b, aq.a, aq.b, az.a, com.viber.voip.messages.conversation.ui.b.ag, com.viber.voip.messages.conversation.ui.b.g, com.viber.voip.messages.conversation.ui.b.l, com.viber.voip.messages.conversation.ui.b.o, ba, com.viber.voip.messages.conversation.ui.view.b.q.a, i.a, com.viber.voip.messages.shopchat.b.a, cy.a, t.a, t.b
{
  protected static final Logger y = ViberEnv.getLogger();

  @Inject
  com.viber.voip.stickers.f A;

  @Inject
  com.viber.voip.stickers.a.a B;

  @Inject
  com.viber.voip.stickers.i C;

  @Inject
  com.viber.voip.messages.controller.y D;

  @Inject
  com.viber.voip.q.i E;

  @Inject
  com.viber.voip.u.d F;

  @Inject
  protected com.viber.voip.analytics.g G;

  @Inject
  protected com.viber.voip.analytics.story.d.c H;

  @Inject
  protected com.viber.voip.analytics.story.e.c I;

  @Inject
  protected com.viber.voip.analytics.story.a.a J;

  @Inject
  protected com.viber.voip.analytics.story.b.c K;

  @Inject
  protected com.viber.voip.analytics.story.f.d L;

  @Inject
  UserData M;

  @Inject
  protected com.viber.voip.messages.d.b N;

  @Inject
  com.viber.voip.contacts.c.d.m O;

  @Inject
  com.viber.voip.messages.controller.ai P;

  @Inject
  com.viber.voip.invitelinks.d Q;

  @Inject
  protected com.viber.voip.app.b R;

  @Inject
  protected Engine S;

  @Inject
  protected PhoneController T;

  @Inject
  protected Im2Exchanger U;

  @Inject
  ICdrController V;

  @Inject
  protected dagger.a<com.viber.voip.messages.k> W;

  @Inject
  protected dagger.a<com.viber.voip.messages.controller.publicaccount.d> X;

  @Inject
  protected com.viber.voip.banner.i Y;

  @Inject
  protected com.viber.voip.messages.controller.manager.o Z;
  private com.viber.voip.messages.controller.w a;
  protected com.viber.voip.messages.ui.ai aA;
  protected ConversationData aB;
  public boolean aC;
  protected a aD;
  protected Handler aE;
  protected Handler aF;
  protected Handler aG;
  protected TopBannerPresenter aH;
  protected com.viber.voip.messages.conversation.ui.view.a.c.f aI;
  protected BottomBannerPresenter aJ;
  public com.viber.voip.messages.conversation.ui.view.a.a.a aK;
  protected com.viber.voip.messages.conversation.ui.view.b.j aL;
  protected GeneralConversationPresenter<com.viber.voip.messages.conversation.ui.view.h> aM;
  protected com.viber.voip.messages.conversation.ui.b.a aN;
  protected com.viber.voip.messages.conversation.ui.b.b aO;
  protected com.viber.voip.messages.conversation.ui.b.e aP;
  protected com.viber.voip.messages.conversation.ui.b.x aQ;
  protected com.viber.voip.messages.conversation.ui.b.aj aR;
  protected com.viber.voip.messages.conversation.ui.b.z aS;
  protected InputFieldPresenter.b aT;
  protected com.viber.voip.messages.conversation.ui.b.ac aU;
  public BottomPanelPresenter aV;
  public com.viber.voip.messages.conversation.ui.view.b.b aW;
  protected com.viber.voip.messages.conversation.ui.b.u aX;
  protected com.viber.voip.messages.conversation.ui.b.t aY;
  protected com.viber.voip.messages.conversation.ui.b.f aZ;

  @Inject
  protected com.viber.common.permission.c aa;

  @Inject
  protected com.viber.voip.messages.extensions.c ab;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.a.h> ac;

  @Inject
  UserManager ad;

  @Inject
  protected dagger.a<com.viber.voip.messages.controller.a> ae;

  @Inject
  protected com.viber.voip.messages.extensions.i af;

  @Inject
  protected dagger.a<com.viber.voip.notif.f> ag;

  @Inject
  protected EventBus ah;

  @Inject
  protected com.viber.voip.util.e.g ai;

  @Inject
  protected dagger.a<com.viber.voip.invitelinks.q> aj;

  @Inject
  dagger.a<cl> ak;
  protected av al;
  protected ConversationListView am;
  protected ConversationAlertView an;
  protected ConversationBannerView ao;
  protected SwipeRefreshLayout ap;
  protected SpamController aq;
  protected com.viber.voip.messages.conversation.adapter.a.c.a.i ar;
  protected aq as;
  protected j at;
  protected com.viber.voip.messages.conversation.adapter.d au;
  protected MessageComposerView av;
  protected com.viber.voip.messages.conversation.adapter.k aw;
  protected com.viber.voip.u.a.f ax;
  protected i ay;
  protected com.viber.voip.messages.conversation.s az;
  private com.viber.voip.messages.conversation.adapter.e.c b;
  private com.viber.voip.messages.conversation.ui.a.f bA;
  private com.viber.voip.messages.conversation.ui.a.w bB;
  private com.viber.voip.messages.conversation.ui.a.u bC;
  private com.viber.voip.messages.conversation.ui.a.q bD;
  private com.viber.voip.messages.conversation.adapter.d.z bE = m.a;
  private com.viber.voip.messages.conversation.ui.a.i bF;
  private final com.viber.common.permission.b bG;
  private final com.viber.common.permission.b bH;
  protected com.viber.voip.messages.conversation.ui.b.n ba;
  protected com.viber.voip.messages.conversation.ui.b.i bb;
  protected com.viber.voip.messages.conversation.ui.b.af bc;
  protected com.viber.voip.messages.ui.t bd;

  @Inject
  protected dagger.a<ConferenceCallsRepository> be;

  @Inject
  protected CallHandler bf;

  @Inject
  protected dagger.a<com.viber.voip.notif.g> bg;
  protected com.viber.voip.messages.conversation.ui.a.v bh;
  protected final ai.b bi;
  private com.viber.voip.messages.conversation.ui.a.h bj;
  private com.viber.voip.messages.conversation.ui.a.h bk;
  private com.viber.voip.messages.conversation.ui.a.h bl;
  private com.viber.voip.messages.conversation.ui.a.l bm;
  private com.viber.voip.messages.conversation.ui.a.k bn;
  private com.viber.voip.messages.conversation.ui.a.j bo;
  private com.viber.voip.messages.conversation.ui.a.d bp;
  private com.viber.voip.messages.conversation.ui.a.e bq;
  private com.viber.voip.messages.conversation.ui.a.p br;
  private com.viber.voip.messages.conversation.ui.a.m bs;
  private com.viber.voip.messages.conversation.ui.a.n bt;
  private com.viber.voip.messages.conversation.ui.a.o bu;
  private com.viber.voip.messages.conversation.ui.a.s bv;
  private com.viber.voip.messages.conversation.ui.a.t bw;
  private com.viber.voip.messages.conversation.ui.a.g bx;
  private com.viber.voip.messages.conversation.ui.a.f by;
  private com.viber.voip.messages.conversation.ui.a.c bz;
  private bg c;
  private com.viber.voip.messages.ui.u d;
  private az e;
  private com.viber.voip.publicaccount.d.b f;
  private ExpandablePanelLayout g;
  private com.viber.voip.messages.ui.x h;
  private long i;
  private boolean j = false;
  private boolean k;
  private int l;
  private View m;
  private TranslateMessagePresenter n;
  private com.viber.voip.registration.af o;
  private com.viber.voip.messages.conversation.ui.spam.a p;
  private Set<Long> q = new HashSet();
  private com.viber.voip.messages.conversation.ui.view.a.b.a r;
  private com.viber.voip.messages.conversation.ui.view.b.u s;
  private com.viber.voip.messages.ui.d t;
  private com.viber.voip.messages.ui.w u;
  private f.a v;
  private final by w = new l(this);
  private com.viber.voip.messages.conversation.ui.a.h x;

  @Inject
  com.viber.voip.stickers.b z;

  public ConversationFragment()
  {
    Pair[] arrayOfPair1 = new Pair[10];
    arrayOfPair1[0] = com.viber.voip.permissions.m.a(29);
    arrayOfPair1[1] = com.viber.voip.permissions.m.a(50);
    arrayOfPair1[2] = com.viber.voip.permissions.m.a(40);
    arrayOfPair1[3] = com.viber.voip.permissions.m.a(109);
    arrayOfPair1[4] = com.viber.voip.permissions.m.a(111);
    arrayOfPair1[5] = com.viber.voip.permissions.m.a(117);
    arrayOfPair1[6] = com.viber.voip.permissions.m.a(118);
    arrayOfPair1[7] = com.viber.voip.permissions.m.a(137);
    arrayOfPair1[8] = com.viber.voip.permissions.m.a(140);
    arrayOfPair1[9] = com.viber.voip.permissions.m.a(143);
    this.bG = new com.viber.voip.permissions.e(this, arrayOfPair1)
    {
      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        switch (paramAnonymousInt1)
        {
        default:
        case 140:
        }
        do
          return;
        while (((!DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString)) || (paramAnonymousInt2 == -1)) && (!DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString)));
        ConversationFragment.this.aU.b_(false);
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        boolean bool;
        if ((paramAnonymousObject instanceof Boolean))
        {
          bool = ((Boolean)paramAnonymousObject).booleanValue();
          switch (paramAnonymousInt)
          {
          default:
          case 29:
          case 50:
          case 40:
          case 109:
          case 111:
          case 117:
          case 118:
          case 137:
          case 140:
          case 143:
          }
        }
        do
        {
          do
          {
            do
            {
              return;
              bool = false;
              break;
              ConversationFragment.this.aU.a(true, false, bool);
              return;
              ConversationFragment.this.aU.a(false, false, bool);
              return;
              ConversationFragment.this.aU.a(false, true, bool);
              return;
            }
            while (!(paramAnonymousObject instanceof Bundle));
            Bundle localBundle3 = (Bundle)paramAnonymousObject;
            ConversationFragment.this.a(localBundle3.getBoolean("is_wink"), localBundle3.getLong("message_id"));
            return;
            if ((paramAnonymousObject instanceof Bundle))
            {
              Bundle localBundle2 = (Bundle)paramAnonymousObject;
              ((com.viber.voip.messages.k)ConversationFragment.this.W.get()).c().a(localBundle2.getLong("message_id"), localBundle2.getString("download_id"));
            }
            ConversationFragment.this.W();
            return;
          }
          while (!(paramAnonymousObject instanceof String));
          ConversationFragment.this.aU.c_((String)paramAnonymousObject);
          return;
          ConversationFragment.this.W();
          return;
          ConversationFragment.this.aU.b_(true);
        }
        while (!(paramAnonymousObject instanceof Bundle));
        Bundle localBundle1 = (Bundle)paramAnonymousObject;
        ConversationFragment.a(ConversationFragment.this, localBundle1.getLong("message_id"), localBundle1.getString("download_id"));
      }
    };
    Pair[] arrayOfPair2 = new Pair[6];
    arrayOfPair2[0] = com.viber.voip.permissions.m.a(57);
    arrayOfPair2[1] = com.viber.voip.permissions.m.a(38);
    arrayOfPair2[2] = com.viber.voip.permissions.m.a(76);
    arrayOfPair2[3] = com.viber.voip.permissions.m.a(135);
    arrayOfPair2[4] = com.viber.voip.permissions.m.a(136);
    arrayOfPair2[5] = com.viber.voip.permissions.m.a(139);
    this.bH = new com.viber.voip.permissions.e(this, arrayOfPair2)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        ConversationFragment.a(ConversationFragment.this).a(paramAnonymousInt, paramAnonymousArrayOfString, paramAnonymousObject);
      }
    };
    this.bi = new ai.b()
    {
      public void a(Set<Long> paramAnonymousSet)
      {
        ConversationFragment.a(ConversationFragment.this, new ao(this));
      }
    };
  }

  private com.viber.voip.messages.conversation.adapter.d a(LayoutInflater paramLayoutInflater, com.viber.voip.messages.conversation.q paramq, com.viber.voip.messages.controller.w paramw, com.viber.voip.messages.conversation.adapter.a.c.a.i parami, Context paramContext, com.viber.voip.messages.conversation.adapter.e.b paramb)
  {
    com.viber.voip.messages.conversation.adapter.v localv1 = new com.viber.voip.messages.conversation.adapter.v(MessageType.class);
    com.viber.voip.messages.conversation.adapter.v localv2 = new com.viber.voip.messages.conversation.adapter.v(com.viber.voip.messages.conversation.adapter.t.class);
    az localaz = this.e;
    com.viber.voip.messages.conversation.ui.b.u localu = this.aX;
    com.viber.voip.messages.conversation.ui.spam.a locala = this.p;
    Handler localHandler = this.aE;
    UserData localUserData = this.M;
    com.viber.voip.messages.controller.manager.o localo = this.Z;
    com.viber.voip.messages.conversation.adapter.a.c.a.g localg = new com.viber.voip.messages.conversation.adapter.a.c.a.g(paramContext);
    com.viber.voip.messages.extensions.c localc = this.ab;
    com.viber.voip.stickers.b localb = this.z;
    com.viber.voip.stickers.i locali = this.C;
    com.viber.voip.app.b localb1 = this.R;
    com.viber.voip.stickers.f localf = this.A;
    com.viber.voip.stickers.a.a locala1 = this.B;
    com.viber.voip.ui.b.d locald = com.viber.voip.ui.b.e.a();
    com.viber.voip.widget.b.d locald1 = new com.viber.voip.widget.b.d();
    com.viber.voip.messages.controller.ai localai = this.P;
    com.viber.voip.messages.controller.y localy = this.D;
    com.viber.voip.bot.a.e locale = new com.viber.voip.bot.a.e(paramContext);
    com.viber.voip.messages.conversation.adapter.d locald2 = new com.viber.voip.messages.conversation.adapter.d(this, paramLayoutInflater, paramq, localaz, localu, locala, localHandler, parami, localUserData, localo, localv1, localv2, new com.viber.voip.messages.conversation.adapter.e.a(paramb, localg, localv1, localv2, localc, localb, locali, localb1, localf, locala1, locald, locald1, localai, paramw, localy, locale, com.viber.voip.bot.b.a(), this.at, this.E, this.aE, parami));
    return locald2;
  }

  private com.viber.voip.messages.conversation.adapter.e.c a(ConversationListView paramConversationListView, com.viber.voip.messages.conversation.q paramq, com.viber.voip.messages.conversation.aj paramaj, com.viber.voip.messages.controller.w paramw, com.viber.voip.messages.conversation.adapter.a.c.a.i parami)
  {
    com.viber.voip.widget.u localu = new com.viber.voip.widget.u(paramConversationListView);
    Handler localHandler = this.aE;
    com.viber.voip.stickers.b localb = this.z;
    com.viber.voip.u.d locald = this.F;
    com.viber.voip.q.i locali = this.E;
    com.viber.voip.messages.controller.y localy = this.D;
    com.viber.voip.stickers.f localf = this.A;
    com.viber.voip.messages.conversation.adapter.e.q[] arrayOfq = new com.viber.voip.messages.conversation.adapter.e.q[4];
    arrayOfq[0] = new com.viber.voip.messages.conversation.adapter.e.g(this.F, localu);
    arrayOfq[1] = new com.viber.voip.messages.conversation.adapter.e.p(this.z, paramaj, parami, localu);
    arrayOfq[2] = new com.viber.voip.messages.conversation.adapter.e.r(this.E);
    arrayOfq[3] = new com.viber.voip.messages.conversation.adapter.e.e(this.G);
    return new com.viber.voip.messages.conversation.adapter.e.c(localHandler, paramConversationListView, localb, paramaj, paramw, locald, locali, localy, localf, paramq, parami, arrayOfq);
  }

  private void a()
  {
    this.aT = new InputFieldPresenter.b();
    com.viber.voip.messages.ui.input.handlers.a locala = new com.viber.voip.messages.ui.input.handlers.a(this.aT);
    com.viber.voip.messages.ui.input.handlers.b[] arrayOfb = new com.viber.voip.messages.ui.input.handlers.b[1];
    arrayOfb[0] = new ChatExInputHandler(this.aA, this.aT);
    MessageComposerInputManager localMessageComposerInputManager = new MessageComposerInputManager(locala, arrayOfb);
    this.e = new az(this, (ViberFragmentActivity)getActivity(), (at)this.al.a(), (ViewStub)this.m, getLayoutInflater());
    this.aS = new com.viber.voip.messages.conversation.ui.b.z(this.av.j(), d.r.a, d.n.c, this.av.g(), localMessageComposerInputManager, this.aA, getContext(), this.e, ViberApplication.getInstance().getMessagesManager().h(), this.ab, this.bd, this.G, this.g);
  }

  private void a(long paramLong, String paramString)
  {
    this.q.add(Long.valueOf(paramLong));
    this.Z.a(this);
    if (this.au != null)
    {
      this.au.b().b(paramLong);
      this.au.notifyDataSetChanged();
    }
    ((com.viber.voip.messages.k)this.W.get()).c().a(paramLong, paramString);
  }

  private void a(ContextMenu paramContextMenu, com.viber.voip.ui.g.a<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i, com.viber.voip.ui.g.f> parama)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = C();
    if (localConversationItemLoaderEntity == null);
    Sticker localSticker;
    do
    {
      com.viber.voip.messages.conversation.aa localaa;
      do
      {
        com.viber.voip.messages.conversation.adapter.a.a locala;
        do
        {
          return;
          locala = (com.viber.voip.messages.conversation.adapter.a.a)parama.a().d();
        }
        while (locala == null);
        localaa = locala.c();
        this.d.a(paramContextMenu, localaa, localConversationItemLoaderEntity, this.at, localConversationItemLoaderEntity, s(), (com.viber.voip.messages.conversation.ui.view.e)getCompositeView());
      }
      while (localaa.q() != 4);
      localSticker = localaa.bn();
    }
    while (localSticker == null);
    this.I.a(localSticker);
  }

  private void a(ConversationData paramConversationData, boolean paramBoolean)
  {
    boolean bool1 = com.viber.voip.messages.m.a(this.o, paramConversationData.memberId);
    int i1;
    int i2;
    label77: int i3;
    if ((paramConversationData.conversationId > 0L) || (paramConversationData.groupId > 0L) || (!da.a(paramConversationData.memberId)))
    {
      i1 = 1;
      if ((this.az == null) || (paramConversationData.conversationId <= 0L) || (this.az.r() != paramConversationData.conversationId))
        break label201;
      i2 = 1;
      if ((this.aB == null) || (paramConversationData.conversationId <= 0L) || (this.aB.conversationId != paramConversationData.conversationId))
        break label207;
      i3 = 1;
      label111: int i4 = 0;
      if (bool1)
      {
        int i5 = paramConversationData.conversationType;
        i4 = 0;
        if (i5 == 0)
        {
          boolean bool2 = paramConversationData.isInSmsInbox;
          i4 = 0;
          if (!bool2)
            i4 = 1;
        }
      }
      if ((i4 == 0) && (i1 != 0))
        break label213;
      if (i4 != 0)
        ViberApplication.getInstance().showToast(getString(R.string.dialog_514_message));
      if (this.aD != null)
        this.aD.c(true);
    }
    label201: label207: label213: 
    do
    {
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label77;
      i3 = 0;
      break label111;
      if ((this.j) || ((i2 == 0) && ((i3 == 0) || (paramBoolean))))
      {
        a(paramConversationData);
        if (paramConversationData.isBroadcastListType())
          this.l = paramConversationData.broadcastListParticipantsCount;
        if (B())
          N();
        q();
        this.aX.a(paramConversationData);
        return;
      }
      if (this.as != null)
        this.as.a(this.s);
    }
    while ((paramBoolean) || (this.aD == null));
    this.aD.m();
  }

  private void a(e.b paramb, int paramInt)
  {
    if (this.aa.a(com.viber.voip.permissions.n.m))
    {
      a(paramb.a, paramb.b);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("message_id", paramb.a);
    localBundle.putString("download_id", paramb.b);
    this.aa.a(this, paramInt, com.viber.voip.permissions.n.m, localBundle);
  }

  private boolean c(MessageEntity[] paramArrayOfMessageEntity, Bundle paramBundle)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = C();
    if ((localConversationItemLoaderEntity == null) || (!localConversationItemLoaderEntity.isOneToOneWithPublicAccount()));
    while ((!localConversationItemLoaderEntity.isAgeRestrictedPublicAccount()) || (localConversationItemLoaderEntity.hasOutgoingMessages()) || (localConversationItemLoaderEntity.hasPublicAccountSubscription()))
      return false;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("pending_messages", ParcelableUtils.a(paramArrayOfMessageEntity));
    localBundle.putParcelable("options", paramBundle);
    localBundle.putSerializable("follow_source", com.viber.voip.messages.controller.publicaccount.ae.c);
    com.viber.voip.ui.dialogs.r.m().a(this).a(localBundle).b(this);
    return true;
  }

  private ca e(com.viber.voip.messages.conversation.aa paramaa)
  {
    com.viber.voip.stickers.a.a locala;
    if (paramaa.ax())
      locala = this.B;
    boolean bool;
    do
    {
      return locala;
      bool = paramaa.aE();
      locala = null;
    }
    while (!bool);
    return this.a;
  }

  private boolean h(com.viber.voip.messages.conversation.aa paramaa)
  {
    return (com.viber.voip.util.at.d(getContext(), paramaa.o())) || (com.viber.voip.util.at.a(com.viber.voip.util.upload.o.a(paramaa.C(), paramaa.q(), getContext())));
  }

  private boolean i(com.viber.voip.messages.conversation.aa paramaa)
  {
    return (paramaa.ap()) && (paramaa.f() == -1) && ((0x10 & paramaa.E()) == 0);
  }

  public void A()
  {
    if (this.az != null)
    {
      a(null);
      this.az.a();
      b(null);
      c(null);
      this.aX.G_();
    }
  }

  public boolean B()
  {
    return (this.e != null) && (this.e.a());
  }

  protected ConversationItemLoaderEntity C()
  {
    if (this.az != null)
      return this.az.j();
    return null;
  }

  public void D()
  {
    ((com.viber.voip.messages.conversation.ui.view.e)getCompositeView()).b();
  }

  public void E()
  {
    this.s.i();
  }

  public void F()
  {
    this.s.i();
  }

  public void G()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = C();
    if ((localConversationItemLoaderEntity == null) || (!localConversationItemLoaderEntity.isOneToOneWithPublicAccount()))
      return;
    if (com.viber.voip.publicaccount.d.e.a(localConversationItemLoaderEntity))
    {
      com.viber.voip.ui.dialogs.r.b((int)SystemClock.elapsedRealtime(), -1L, localConversationItemLoaderEntity.getPublicAccountGroupId(), null, localConversationItemLoaderEntity.getPublicAccountGroupUri(), localConversationItemLoaderEntity.getGroupName(), 0L, "", TermsAndConditionsActivity.a.a, null).d();
      return;
    }
    startActivity(ViberActionRunner.aq.a(getContext(), false, localConversationItemLoaderEntity.hasPublicAccountPublicChat(), new PublicGroupConversationData(localConversationItemLoaderEntity.getPublicAccountGroupId(), localConversationItemLoaderEntity.getPublicAccountGroupUri())));
  }

  public void H()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = C();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localConversationItemLoaderEntity != null) && (localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
      ViberActionRunner.b(localFragmentActivity, localConversationItemLoaderEntity.getPublicAccountGroupId(), localConversationItemLoaderEntity.getPublicAccountGroupUri());
  }

  public boolean I()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return ((localFragmentActivity instanceof aq.b)) && (((aq.b)localFragmentActivity).I());
  }

  public void J()
  {
    ViberActionRunner.aa.a(this, getChildFragmentManager(), o.a.h);
  }

  public void K()
  {
    if (isAdded())
      com.viber.common.dialogs.z.a(getChildFragmentManager(), DialogCode.D_PIN);
  }

  public void L()
  {
    if (this.aD != null)
      this.aD.c(true);
  }

  public void M()
  {
    if (this.az != null)
      this.az.n();
    if (this.b != null)
      this.b.e();
  }

  public void N()
  {
    az localaz = this.e;
    if (!this.e.a());
    for (boolean bool = true; ; bool = false)
    {
      localaz.b(bool);
      this.e.c();
      this.as.j.c();
      W();
      dj.c(Z());
      return;
    }
  }

  public void O()
  {
    this.at.l();
  }

  public ConversationData P()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = C();
    if (localConversationItemLoaderEntity != null)
    {
      this.aB.conversationId = localConversationItemLoaderEntity.getId();
      this.aB.groupName = localConversationItemLoaderEntity.getGroupName();
      this.aB.contactName = localConversationItemLoaderEntity.getContactName();
      this.aB.viberName = localConversationItemLoaderEntity.getViberName();
      this.aB.canSendTimeBomb = localConversationItemLoaderEntity.canSendTimeBomb();
    }
    return this.aB;
  }

  public void Q()
  {
    com.viber.voip.ui.dialogs.k.e().a(this).b(this);
  }

  public void R()
  {
    if (this.aD != null)
      this.aD.a(ah().j(), 1, "Add participant Icon - Chat");
  }

  public void S()
  {
    if (this.aD != null)
      this.aD.p();
  }

  public void T()
  {
    com.viber.voip.av.a(av.e.f).post(new ad(this));
  }

  public void U()
  {
    com.viber.voip.av.a(av.e.d).post(new af(this));
  }

  public void V()
  {
    ((ConferenceCallsRepository)this.be.get()).makeConferencesWithConversationIdsUnavailable(Collections.singleton(Long.valueOf(this.az.r())));
  }

  public void W()
  {
    if (this.au != null)
      this.au.notifyDataSetChanged();
  }

  public void X()
  {
    ((com.viber.voip.messages.conversation.ui.view.e)getCompositeView()).a(true);
    if (this.au != null)
    {
      this.au.b().d(true);
      W();
    }
  }

  public void Y()
  {
    ((com.viber.voip.messages.conversation.ui.view.e)getCompositeView()).a(false);
    if (this.au != null)
    {
      this.au.b().d(false);
      W();
    }
  }

  public MessageComposerView Z()
  {
    return this.av;
  }

  protected com.viber.voip.messages.conversation.s a(Context paramContext, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, EventBus paramEventBus, Bundle paramBundle)
  {
    return new com.viber.voip.messages.conversation.s(paramContext, paramLoaderManager, parama, this.aZ, this.ba, this.bb, this.bc, paramEventBus, 1, paramBundle);
  }

  protected MessagesActionsPresenter a(SpamController paramSpamController, com.viber.voip.messages.conversation.ui.b.f paramf, com.viber.voip.messages.conversation.ui.b.ac paramac, com.viber.voip.messages.conversation.ui.b.i parami, com.viber.voip.messages.controller.ai paramai, com.viber.common.permission.c paramc, j paramj, Engine paramEngine, com.viber.voip.registration.af paramaf, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, com.viber.voip.analytics.g paramg, IRingtonePlayer paramIRingtonePlayer, com.viber.voip.messages.controller.publicaccount.d paramd, com.viber.voip.messages.conversation.ui.b.a parama, com.viber.voip.messages.d.b paramb, com.viber.voip.messages.controller.manager.o paramo, Handler paramHandler4, bm parambm, com.viber.voip.messages.conversation.ui.b.x paramx, com.viber.voip.messages.conversation.ui.b.aj paramaj, com.viber.voip.stickers.b paramb1, com.viber.voip.stickers.i parami1, com.viber.voip.stickers.a.a parama1, com.viber.voip.messages.conversation.ui.b.n paramn, com.viber.voip.messages.conversation.ui.b.u paramu, ActivationController paramActivationController, com.viber.voip.messages.conversation.ui.b.z paramz, com.viber.voip.messages.extensions.c paramc1, dagger.a<com.viber.voip.invitelinks.q> parama2)
  {
    return new RegularMessagesActionsPresenter(paramSpamController, paramf, paramac, parami, paramai, paramc, paramj, paramEngine, paramaf, paramHandler1, paramHandler2, paramHandler3, paramg, paramIRingtonePlayer, paramd, parama, paramb, this.mIsTablet, paramo, paramHandler4, parambm, paramx, paramaj, paramb1, parami1, parama1, paramn, paramu, paramActivationController, paramz, d.r.D, paramc1, parama2);
  }

  protected com.viber.voip.messages.conversation.ui.spam.a a(Bundle paramBundle)
  {
    RegularPotentialSpamController localRegularPotentialSpamController = new RegularPotentialSpamController(com.viber.voip.messages.controller.manager.ab.b(), av.e.f.a(), this.aE, new com.viber.voip.messages.conversation.ui.spam.a.a()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        ConversationFragment.this.W();
      }
    });
    if (paramBundle != null)
      localRegularPotentialSpamController.a(paramBundle.getParcelable("potential_spam_controller_state"));
    return localRegularPotentialSpamController;
  }

  protected com.viber.voip.messages.conversation.ui.view.a.c.f a(View paramView, ConversationAlertView paramConversationAlertView, SwipeRefreshLayout paramSwipeRefreshLayout, Bundle paramBundle)
  {
    RegularGroupTopBannerPresenter localRegularGroupTopBannerPresenter = new RegularGroupTopBannerPresenter(this.aZ, this.ba, this.bb, this.aX, this.bc, this.az, this.at, this.aE, cj.a(ViberApplication.getApplication()), this.S, com.viber.voip.contacts.c.c.a.b.a(), com.viber.voip.block.b.a(), this.H, this.K, this.aR, this.aq, this.be, this.bf, this.aP, this.P, this.bg, this.Z);
    com.viber.voip.messages.conversation.ui.view.a.c.g localg = new com.viber.voip.messages.conversation.ui.view.a.c.g(localRegularGroupTopBannerPresenter, getActivity(), this, paramView, this.mIsTablet, paramConversationAlertView, this.aw, paramSwipeRefreshLayout, this.at, this.av, new bp(ag(), this.an, getLayoutInflater()), this.G, this.I, this.J, this.N);
    addMvpView(localg, localRegularGroupTopBannerPresenter, paramBundle);
    this.bh.a(localRegularGroupTopBannerPresenter);
    this.aH = localRegularGroupTopBannerPresenter;
    return localg;
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramLong1, paramInt, paramLong2);
  }

  protected void a(View paramView, Bundle paramBundle)
  {
    OptionsMenuPresenter localOptionsMenuPresenter = new OptionsMenuPresenter(this.aX, this.ba, this.bb, this.aZ, this.al, this.aU);
    addMvpView(new com.viber.voip.messages.conversation.ui.view.b.q(localOptionsMenuPresenter, getActivity(), this, paramView, this.mIsTablet, this, this), localOptionsMenuPresenter, paramBundle);
    SearchMessagesOptionMenuPresenter localSearchMessagesOptionMenuPresenter = new SearchMessagesOptionMenuPresenter(this.aX, this.bb, this.aZ, this.W, this.I, this.al, this.mIsTablet);
    com.viber.voip.messages.conversation.ui.view.b.t localt = new com.viber.voip.messages.conversation.ui.view.b.t(localSearchMessagesOptionMenuPresenter, getActivity(), this, paramView, this, this.mIsTablet);
    this.bh.a(localt);
    addMvpView(localt, localSearchMessagesOptionMenuPresenter, paramBundle);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    boolean bool1 = true;
    BT.a("DATA", "load conversation", "onConversationLoad");
    if ((!isAdded()) || (getActivity().isFinishing()))
      return;
    boolean bool3;
    boolean bool4;
    label166: label297: com.viber.voip.model.entity.m localm;
    if ((paramConversationItemLoaderEntity != null) && ((!paramConversationItemLoaderEntity.isConversation1on1()) || (!paramConversationItemLoaderEntity.isPendingRemoveParticipant())))
    {
      this.at.a(paramConversationItemLoaderEntity, paramBoolean);
      if (this.au != null)
      {
        boolean bool2 = SpamController.b(paramConversationItemLoaderEntity);
        com.viber.voip.messages.conversation.adapter.d locald1 = this.au;
        if ((!paramConversationItemLoaderEntity.isSystemConversation()) && (bool2))
        {
          bool3 = bool1;
          locald1.d(bool3);
          this.au.c(paramConversationItemLoaderEntity.getGroupRole());
          this.au.b(paramConversationItemLoaderEntity.isDisabledConversation());
          this.au.c(paramConversationItemLoaderEntity.hasNewSpamHandlingLogic());
          this.au.d(paramConversationItemLoaderEntity.getBackgroundTextColor());
          com.viber.voip.messages.conversation.adapter.d locald2 = this.au;
          if (paramConversationItemLoaderEntity.isNotShareablePublicAccount())
            break label371;
          bool4 = bool1;
          locald2.e(bool4);
        }
      }
      else
      {
        if (this.b != null)
          this.b.a(paramConversationItemLoaderEntity.getId());
        this.as.a(paramConversationItemLoaderEntity, paramBoolean);
        this.aw.a(paramConversationItemLoaderEntity);
        W();
        this.f.a(paramConversationItemLoaderEntity);
        if (paramBoolean)
        {
          ((com.viber.voip.messages.k)this.W.get()).a().b(paramConversationItemLoaderEntity.getId());
          this.as.a(this.aD.n());
          com.viber.voip.notif.g.a(getActivity()).a().a(paramConversationItemLoaderEntity.getContactId());
          if (this.aC)
          {
            if (a(paramConversationItemLoaderEntity, null))
              break label377;
            this.aC = bool1;
          }
        }
        this.e.a(paramConversationItemLoaderEntity);
        if (this.p != null)
        {
          if (!paramConversationItemLoaderEntity.isGroupType())
            break label382;
          localm = com.viber.voip.messages.d.c.c().b(paramConversationItemLoaderEntity.getCreatorParticipantInfoId());
          label338: this.p.a(paramConversationItemLoaderEntity, localm);
        }
      }
    }
    while (true)
    {
      BT.b("DATA", "load conversation");
      return;
      bool3 = false;
      break;
      label371: bool4 = false;
      break label166;
      label377: bool1 = false;
      break label297;
      label382: localm = null;
      break label338;
      b(ah().r());
    }
  }

  public void a(com.viber.voip.messages.conversation.aa paramaa)
  {
    W();
  }

  public void a(com.viber.voip.messages.conversation.ac paramac, boolean paramBoolean)
  {
    BT.a("DATA", "load conversation participants", "onParticipantsLoad");
    if (C() == null)
      return;
    this.l = paramac.getCount();
    if (this.p != null)
      this.p.a();
    BT.c("DATA", "load conversation participants");
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.b.f paramf, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.ah.a(this, paramf, paramBoolean);
  }

  public void a(com.viber.voip.messages.conversation.q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    BT.a("DATA", "load conversation messages", "onLoadFinished");
    W();
    int i1;
    com.viber.voip.messages.conversation.aa localaa;
    if ((this.aB != null) && (com.viber.voip.messages.m.e(this.aB.conversationType)))
    {
      if (this.as.g.isEnabled())
        this.as.g.setEnabled(false);
      i1 = paramq.getCount();
      localaa = paramq.f(i1 - 1);
      if ((paramBoolean1) || (this.k))
      {
        this.k = false;
        c(paramq.t());
      }
      if (!paramBoolean1)
        break label221;
      this.as.e.a(this.c);
      this.as.e.a(this.c);
      this.j = false;
      ConversationItemLoaderEntity localConversationItemLoaderEntity = C();
      if ((localConversationItemLoaderEntity != null) && (localConversationItemLoaderEntity.isHiddenConversation()))
        this.as.f();
      this.at.a();
      label175: if (i1 <= 0)
        break label285;
    }
    label285: for (this.i = localaa.e(); ; this.i = 0L)
    {
      BT.b("DATA", "load conversation messages");
      return;
      this.as.g.setEnabled(paramq.B());
      break;
      label221: if (this.j)
      {
        this.j = false;
        break label175;
      }
      if ((i1 <= 0) || (this.as.e.a(true)) || (this.i == localaa.e()) || (!paramq.t()))
        break label175;
      this.aL.k();
      break label175;
    }
  }

  protected void a(ConversationData paramConversationData)
  {
    this.aB = paramConversationData;
    this.aZ.a(paramConversationData);
    if (this.aD != null)
      this.aD.a(paramConversationData);
  }

  public void a(MessageEntity paramMessageEntity, int paramInt)
  {
    this.Z.b(this);
    runOnUiThread(new ag(this));
    boolean bool = this.q.remove(Long.valueOf(paramMessageEntity.getId()));
    if ((paramInt == 0) && (bool))
      new ViberActionRunner.az.c(getActivity(), this.P, new com.viber.voip.invitelinks.f(this.Q, cj.a(getActivity()))).a(this.aB.conversationId, new com.viber.voip.messages.conversation.aa(paramMessageEntity), false, null);
  }

  public void a(MessageEntity paramMessageEntity, int paramInt, String paramString)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramMessageEntity, paramInt, paramString);
  }

  public void a(final MessageEntity paramMessageEntity, final Bundle paramBundle, com.viber.voip.u.a.b paramb)
  {
    if (c(new MessageEntity[] { paramMessageEntity }, paramBundle))
      return;
    paramMessageEntity.setMessageSeq(this.T.generateSequence());
    paramb.a(this.as.e, new com.viber.voip.u.a.b.a()
    {
      public long a()
      {
        return paramMessageEntity.getMessageSeq();
      }

      public void b()
      {
        com.viber.voip.messages.conversation.s locals = ConversationFragment.this.az;
        MessageEntity[] arrayOfMessageEntity = new MessageEntity[1];
        arrayOfMessageEntity[0] = paramMessageEntity;
        locals.a(arrayOfMessageEntity, paramBundle);
        ConversationFragment.this.aX.a(true);
        ConversationFragment.this.c(false);
      }
    });
  }

  public void a(t.c paramc)
  {
    this.ay.a(paramc);
  }

  public void a(Collection<com.viber.voip.messages.conversation.aa> paramCollection)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      com.viber.voip.messages.conversation.aa localaa = (com.viber.voip.messages.conversation.aa)localIterator.next();
      if ((!localaa.aG()) || (com.viber.voip.util.at.b(localaa.bz().getFileSize()) != at.a.d))
        localHashSet.add(localaa);
    }
    if (localHashSet.size() > 0)
      this.at.a(localHashSet);
    this.e.b(false);
  }

  public void a(List<Long> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((com.viber.voip.messages.k)this.W.get()).c().a(new HashSet(paramList));
      return;
    }
    ((com.viber.voip.messages.k)this.W.get()).c().a(new HashSet(paramList), false, this.bi);
  }

  public void a(boolean paramBoolean, long paramLong)
  {
    if ((paramBoolean) && (d.r.k.d()))
      com.viber.voip.ui.dialogs.ad.n().a(Long.valueOf(paramLong)).a(this).b(this);
    FragmentActivity localFragmentActivity;
    ConversationItemLoaderEntity localConversationItemLoaderEntity;
    do
    {
      do
      {
        return;
        localFragmentActivity = getActivity();
      }
      while ((this.az == null) || (localFragmentActivity == null) || (localFragmentActivity.isFinishing()));
      localConversationItemLoaderEntity = C();
    }
    while (localConversationItemLoaderEntity == null);
    this.aU.b(paramBoolean);
    ViberActionRunner.bm.a(localFragmentActivity, paramBoolean, paramLong, localConversationItemLoaderEntity);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramBoolean1, paramBoolean2);
  }

  public void a(MessageEntity[] paramArrayOfMessageEntity, Bundle paramBundle)
  {
    if (c(paramArrayOfMessageEntity, paramBundle))
      return;
    b(paramArrayOfMessageEntity, paramBundle);
  }

  public boolean a(Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent != null)
      paramIntent.setExtrasClassLoader(ConversationData.class.getClassLoader());
    while (true)
    {
      try
      {
        localConversationData = (ConversationData)paramIntent.getParcelableExtra("extra_conversation_data");
        this.aL.a(paramIntent, paramBoolean);
        if ((paramIntent == null) || ((!"com.viber.voip.action.CONVERSATION".equals(paramIntent.getAction())) && (!"com.viber.voip.action.COMMUNITY_CONVERSATION".equals(paramIntent.getAction()))) || (!com.viber.voip.notif.g.a(paramIntent)))
          break label347;
        if (!"com.viber.voip.action.COMMUNITY_CONVERSATION".equals(paramIntent.getAction()))
          break label341;
        this.V.setCommunityViewSource(1);
        i1 = 1;
        paramIntent.removeExtra("from_notification");
        bool = false;
        if (paramIntent != null)
        {
          Bundle localBundle = paramIntent.getExtras();
          bool = false;
          if (localBundle != null)
          {
            this.j = paramIntent.getBooleanExtra("extra_search_message", false);
            this.aC = paramIntent.getBooleanExtra("open_conversation_info", false);
            if (paramIntent.hasExtra("open_custom_menu"))
              Z().a(paramIntent.getStringExtra("open_custom_menu"));
            if (paramIntent.hasExtra("community_view_source"))
            {
              if (i1 == 0)
              {
                this.V.setCommunityViewSource(paramIntent.getIntExtra("community_view_source", 0));
                i1 = 1;
              }
              paramIntent.removeExtra("community_view_source");
            }
            com.viber.voip.messages.conversation.ui.b.f localf = this.aZ;
            if (localConversationData == null)
              break label333;
            l1 = localConversationData.conversationId;
            localf.b_(l1);
            bool = false;
            if (localConversationData != null)
            {
              this.as.a(paramIntent, this.s);
              if ((i1 == 0) && (com.viber.voip.messages.m.b(localConversationData.conversationType)))
                this.V.setCommunityViewSource(0);
              a(localConversationData, paramBoolean);
              bool = true;
            }
          }
        }
        return bool;
      }
      catch (RuntimeException localRuntimeException)
      {
        y.a(localRuntimeException, null);
        a locala = this.aD;
        boolean bool = false;
        if (locala == null)
          continue;
        this.aD.c(false);
        return false;
      }
      label333: long l1 = -1L;
      continue;
      label341: int i1 = 0;
      continue;
      label347: i1 = 0;
      continue;
      ConversationData localConversationData = null;
    }
  }

  public boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString)
  {
    if ((this.aD != null) && (paramConversationItemLoaderEntity != null))
    {
      dj.c(Z());
      return this.aD.a(paramConversationItemLoaderEntity, paramString);
    }
    return false;
  }

  public View aa()
  {
    return this.g;
  }

  public void ab()
  {
    this.as.e.g();
  }

  public int ac()
  {
    return this.l;
  }

  public boolean ad()
  {
    return this.j;
  }

  public void addConversationIgnoredView(View paramView)
  {
    if (this.aD != null)
      this.aD.addConversationIgnoredView(paramView);
  }

  public void ae()
  {
    this.r.g();
  }

  public aq af()
  {
    return this.as;
  }

  public View ag()
  {
    return getActivity().getWindow().getDecorView();
  }

  public com.viber.voip.messages.conversation.s ah()
  {
    return this.az;
  }

  public void ai()
  {
    this.aM.a(C());
  }

  protected dagger.a<com.viber.voip.messages.k> aj()
  {
    return this.W;
  }

  protected com.viber.voip.messages.conversation.ui.view.a.a.a b(View paramView, bd parambd, Bundle paramBundle)
  {
    RegularGroupBottomBannerPresenter localRegularGroupBottomBannerPresenter = new RegularGroupBottomBannerPresenter(this.aZ, com.viber.voip.contacts.c.c.a.b.a(), com.viber.voip.block.b.a().b(), this.aE, this.W);
    this.aJ = localRegularGroupBottomBannerPresenter;
    com.viber.voip.messages.conversation.ui.view.a.a.b localb = new com.viber.voip.messages.conversation.ui.view.a.a.b(localRegularGroupBottomBannerPresenter, getActivity(), this, paramView, this.mIsTablet, this.ao, parambd);
    addMvpView(localb, localRegularGroupBottomBannerPresenter, paramBundle);
    return localb;
  }

  protected com.viber.voip.messages.conversation.ui.view.i b(View paramView, Bundle paramBundle)
  {
    RegularConversationsInputFieldPresenter localRegularConversationsInputFieldPresenter = new RegularConversationsInputFieldPresenter(this.aS, this.aN, this.aZ, this.ba, this.bb, this.aY, this.aX, this.av.getReplyBannerViewController(), this.av.getMentionsViewController(), com.viber.voip.flatbuffers.b.e.b().a(), com.viber.voip.flatbuffers.b.e.b().b(), com.viber.voip.bot.b.a(), this.U, av.e.a.a(), av.e.f.a(), com.viber.voip.h.a.b(), this.ab, this.N, this.P, this.mIsTablet, dj.c(getContext()), this.L);
    this.bh.a(localRegularConversationsInputFieldPresenter);
    this.aT.a(localRegularConversationsInputFieldPresenter);
    com.viber.voip.messages.conversation.ui.view.b.n localn = new com.viber.voip.messages.conversation.ui.view.b.n(localRegularConversationsInputFieldPresenter, getActivity(), this, paramView, this.mIsTablet, this.av, this.aA);
    addMvpView(localn, localRegularConversationsInputFieldPresenter, paramBundle);
    return localn;
  }

  public void b(int paramInt)
  {
    if (-1 == paramInt)
      this.az.c();
    while (-1001 == paramInt)
      return;
    L();
  }

  public void b(long paramLong)
  {
    if (this.aD != null)
      this.aD.c(false);
    com.viber.voip.block.b.a().b().b(this);
  }

  public void b(Bundle paramBundle)
  {
    String str = paramBundle.getString("pa_id");
    BotReplyConfig localBotReplyConfig = (BotReplyConfig)paramBundle.getParcelable("bot_config");
    ReplyButton localReplyButton = (ReplyButton)paramBundle.getParcelable("reply_btn");
    boolean bool = paramBundle.getBoolean("open_keyboard");
    int i1 = paramBundle.getInt("bot_reply_source");
    this.aU.a(str, localBotReplyConfig, localReplyButton, bool, i1);
    if (i1 == 1)
      this.as.e.a(false);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((!paramConversationItemLoaderEntity.isHiddenConversation()) || (this.az.d()))
      this.as.a(this.s);
    this.aD.a(paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b(com.viber.voip.messages.conversation.aa paramaa)
  {
    ca localca = e(paramaa);
    if (localca != null)
      localca.a(getContext(), paramaa, 0);
  }

  public void b(com.viber.voip.model.h paramh)
  {
    com.viber.voip.messages.conversation.ui.b.p.a(this, paramh);
  }

  public void b(String paramString)
  {
    dj.a((AppCompatActivity)getActivity(), paramString);
  }

  public void b(boolean paramBoolean)
  {
    if (this.au != null)
      this.au.b().a(paramBoolean);
    if ((paramBoolean) && (this.az.g().f()))
      W();
  }

  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.viber.voip.av.a(av.e.d).post(new ae(this, paramBoolean1, paramBoolean2));
  }

  public final void b(MessageEntity[] paramArrayOfMessageEntity, Bundle paramBundle)
  {
    this.s.a(paramArrayOfMessageEntity, paramBundle);
    this.aX.a(true);
    ((com.viber.voip.messages.conversation.ui.view.e)getCompositeView()).a();
  }

  public void b_(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramLong);
  }

  public void c(long paramLong)
  {
    if (cj.c(getActivity()))
      this.n.c(paramLong);
  }

  public void c(com.viber.voip.messages.conversation.aa paramaa)
  {
    this.at.c(paramaa);
    this.e.b(false);
  }

  public void c(boolean paramBoolean)
  {
    if (this.au != null)
      this.au.a(paramBoolean);
  }

  public boolean c(String paramString)
  {
    return dj.b((AppCompatActivity)getActivity(), paramString);
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    ViberApplication localViberApplication = ViberApplication.getInstance();
    this.aM = p();
    this.aL = new com.viber.voip.messages.conversation.ui.view.b.j(this.aM, this.av, getActivity(), this, paramView, this.mIsTablet, this.aE, this.au);
    addMvpView(this.aL, this.aM, paramBundle);
    this.n = new TranslateMessagePresenter(this.S, new com.viber.voip.messages.conversation.ui.c.a(paramView.getContext(), this.o), com.viber.voip.messages.controller.manager.ab.b(), this.Z, ViberEnv.getOkHttpClientFactory(), com.viber.voip.av.a(av.e.d), ap.c().aP, this.aZ, this.I);
    addMvpView(new com.viber.voip.messages.conversation.ui.view.b.ab(this.n, getActivity(), this, paramView, this.mIsTablet, this.an), this.n, paramBundle);
    this.aV = new BottomPanelPresenter(this.aN, this.aZ, this.aS, this.aq, this.C);
    BottomPanelPresenter localBottomPanelPresenter = this.aV;
    FragmentActivity localFragmentActivity = getActivity();
    boolean bool = this.mIsTablet;
    com.viber.voip.messages.conversation.ui.b.a locala1 = this.aN;
    com.viber.voip.messages.conversation.ui.b.z localz = this.aS;
    com.viber.voip.messages.ui.w localw = this.u;
    com.viber.voip.messages.ui.d locald = this.t;
    com.viber.voip.messages.ui.t localt = this.bd;
    MessageComposerView localMessageComposerView = this.av;
    com.viber.voip.messages.ui.x localx = this.h;
    ICdrController localICdrController = this.V;
    be localbe = new be(av.e.a.a());
    this.aW = new com.viber.voip.messages.conversation.ui.view.b.b(localBottomPanelPresenter, localFragmentActivity, this, paramView, bool, locala1, localz, localw, locald, localt, localMessageComposerView, localx, localICdrController, localbe, this.aU, this.ab);
    addMvpView(this.aW, this.aV, paramBundle);
    ChatExtentionPresenter localChatExtentionPresenter = new ChatExtentionPresenter(this.aN, d.n.d, this.aS);
    addMvpView(new com.viber.voip.messages.conversation.ui.view.b.e(localChatExtentionPresenter, getActivity(), this, paramView, this.mIsTablet, this.av, this.h, this.V, this.ab), localChatExtentionPresenter, paramBundle);
    this.aK = b(paramView, new bd(getContext(), new ai(paramView), this.aE, com.viber.voip.h.a.b(), 9, com.viber.voip.messages.conversation.ui.banner.o.a, getLayoutInflater()), paramBundle);
    this.aI = a(paramView, this.an, this.ap, paramBundle);
    CenterBannerPresenter localCenterBannerPresenter = new CenterBannerPresenter(this.aZ, this.bb, com.viber.voip.contacts.c.c.a.b.a(), com.viber.voip.block.b.a().b(), this.aE, this.aO, this.aP);
    com.viber.voip.messages.conversation.ui.view.a.b.b localb = new com.viber.voip.messages.conversation.ui.view.a.b.b(localCenterBannerPresenter, getActivity(), this, paramView, this.mIsTablet, this.aq);
    this.r = localb;
    com.viber.voip.banner.notificationsoff.b localb1 = new com.viber.voip.banner.notificationsoff.b(this.aI, this.v, this.ag);
    this.r.a(localb1);
    this.r.a(this.aw);
    addMvpView(localb, localCenterBannerPresenter, paramBundle);
    com.viber.voip.messages.conversation.ui.b.ai localai = new com.viber.voip.messages.conversation.ui.b.ai(getContext(), this.ay);
    SendMessagePresenter localSendMessagePresenter = new SendMessagePresenter(this.aZ, this.aX, localai, this.aS, this.P, d.bm.j, (com.viber.voip.messages.controller.publicaccount.d)this.X.get(), ViberApplication.getApplication(), this.Y, this.aa, this.ab, this.af, this.ah, av.e.f.a(), ((com.viber.voip.messages.k)this.W.get()).a(), d.r.K, d.ad.j, c.h.d);
    this.s = new com.viber.voip.messages.conversation.ui.view.b.u(localSendMessagePresenter, getActivity(), this, paramView, this.mIsTablet, this.t, this.u, this.au, av.e.a.a());
    addMvpView(this.s, localSendMessagePresenter, paramBundle);
    a(paramView, paramBundle);
    b(paramView, paramBundle);
    SpamController localSpamController = this.aq;
    com.viber.voip.messages.conversation.ui.b.f localf = this.aZ;
    com.viber.voip.messages.conversation.ui.b.ac localac = this.aU;
    com.viber.voip.messages.conversation.ui.b.i locali = this.bb;
    com.viber.voip.messages.controller.ai localai1 = this.P;
    com.viber.common.permission.c localc = this.aa;
    j localj = this.at;
    Engine localEngine = this.S;
    com.viber.voip.registration.af localaf = this.o;
    Handler localHandler1 = this.aF;
    Handler localHandler2 = this.aE;
    Handler localHandler3 = this.aG;
    com.viber.voip.analytics.g localg = this.G;
    IRingtonePlayer localIRingtonePlayer = localViberApplication.getRingtonePlayer();
    com.viber.voip.messages.controller.publicaccount.d locald1 = (com.viber.voip.messages.controller.publicaccount.d)this.X.get();
    com.viber.voip.messages.conversation.ui.b.a locala2 = this.aN;
    com.viber.voip.messages.d.b localb2 = this.N;
    com.viber.voip.messages.controller.manager.o localo = this.Z;
    Handler localHandler4 = av.e.d.a();
    bm localbm = new bm(getActivity(), localViberApplication.getChangePhoneNumberController().b(), this.O);
    MessagesActionsPresenter localMessagesActionsPresenter = a(localSpamController, localf, localac, locali, localai1, localc, localj, localEngine, localaf, localHandler1, localHandler2, localHandler3, localg, localIRingtonePlayer, locald1, locala2, localb2, localo, localHandler4, localbm, this.aQ, this.aR, this.z, this.C, this.B, this.ba, this.aX, localViberApplication.getActivationController(), this.aS, this.ab, this.aj);
    com.viber.voip.messages.conversation.ui.view.b.p localp = new com.viber.voip.messages.conversation.ui.view.b.p(localMessagesActionsPresenter, getActivity(), this, paramView, this.au, this.mIsTablet, this.av);
    com.viber.voip.messages.conversation.ui.a.h localh1 = this.x;
    localp.getClass();
    localh1.a(aj.a(localp));
    com.viber.voip.messages.conversation.ui.a.h localh2 = this.bj;
    localp.getClass();
    localh2.a(ak.a(localp));
    com.viber.voip.messages.conversation.ui.a.h localh3 = this.bk;
    localp.getClass();
    localh3.a(al.a(localp));
    com.viber.voip.messages.conversation.ui.a.h localh4 = this.bl;
    localp.getClass();
    localh4.a(am.a(localp));
    com.viber.voip.messages.conversation.ui.a.l locall = this.bm;
    localp.getClass();
    locall.a(an.a(localp));
    com.viber.voip.messages.conversation.ui.a.k localk = this.bn;
    localp.getClass();
    localk.a(n.a(localp));
    com.viber.voip.messages.conversation.ui.a.j localj1 = this.bo;
    localp.getClass();
    localj1.a(o.a(localp));
    com.viber.voip.messages.conversation.ui.a.d locald2 = this.bp;
    localp.getClass();
    locald2.a(p.a(localp));
    com.viber.voip.messages.conversation.ui.a.e locale = this.bq;
    localp.getClass();
    locale.a(q.a(localp));
    com.viber.voip.messages.conversation.ui.a.p localp1 = this.br;
    localp.getClass();
    localp1.a(r.a(localp));
    com.viber.voip.messages.conversation.ui.a.m localm = this.bs;
    localp.getClass();
    localm.a(s.a(localp));
    com.viber.voip.messages.conversation.ui.a.n localn = this.bt;
    localp.getClass();
    localn.a(t.a(localp));
    com.viber.voip.messages.conversation.ui.a.o localo1 = this.bu;
    localp.getClass();
    localo1.a(u.a(localp));
    com.viber.voip.messages.conversation.ui.a.s locals = this.bv;
    localp.getClass();
    locals.a(v.a(localp));
    com.viber.voip.messages.conversation.ui.a.t localt1 = this.bw;
    localp.getClass();
    localt1.a(w.a(localp));
    com.viber.voip.messages.conversation.ui.a.g localg1 = this.bx;
    localp.getClass();
    localg1.a(y.a(localp));
    com.viber.voip.messages.conversation.ui.a.f localf1 = this.by;
    localp.getClass();
    localf1.a(z.a(localp));
    com.viber.voip.messages.conversation.ui.a.c localc1 = this.bz;
    localp.getClass();
    localc1.a(aa.a(localp));
    com.viber.voip.messages.conversation.ui.a.f localf2 = this.bA;
    localp.getClass();
    localf2.a(ab.a(localp));
    com.viber.voip.messages.conversation.ui.a.u localu = this.bC;
    localp.getClass();
    localu.a(ac.a(localp));
    this.bB.a(localp);
    this.bD.a(localp);
    this.bF.a(localp);
    addMvpView(localp, localMessagesActionsPresenter, paramBundle);
    ConversationThemePresenter localConversationThemePresenter = new ConversationThemePresenter(this.aX, this.aZ, this.al);
    addMvpView(new com.viber.voip.messages.conversation.ui.view.b.h(localConversationThemePresenter, getActivity(), this, paramView, this.mIsTablet, this.av, this.h, this.an, this.aw, this.e, this.ao), localConversationThemePresenter, paramBundle);
  }

  public void d(com.viber.voip.messages.conversation.aa paramaa)
  {
    this.at.a(paramaa, ac(), 0);
    this.e.b(false);
  }

  public void d(boolean paramBoolean)
  {
    this.aL.d(paramBoolean);
  }

  public void f(com.viber.voip.messages.conversation.aa paramaa)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = C();
    if (localConversationItemLoaderEntity == null);
    label74: 
    do
    {
      do
      {
        do
        {
          return;
          if (paramaa.o() != null)
          {
            if (h(paramaa))
              break label74;
            Toast.makeText(getContext(), R.string.file_not_found, 1).show();
          }
          while (i(paramaa))
          {
            ((com.viber.voip.messages.k)this.W.get()).c().b(paramaa.a());
            return;
            if ((paramaa.aq()) && (getActivity() != null))
            {
              ViberActionRunner.bm.a(getActivity(), paramaa.o(), 1005, paramaa.b(), paramaa.a(), paramaa.e(), paramaa.g(), paramaa.ag());
              this.I.a(localConversationItemLoaderEntity, paramaa);
            }
          }
          if (paramaa.o() != null)
            break;
          String str = paramaa.C();
          if (da.a(str))
          {
            ViberApplication.getInstance().showToast(R.string.file_not_found);
            return;
          }
          if (com.viber.voip.util.upload.s.a(str))
          {
            com.viber.voip.util.upload.s.a(paramaa, false);
            return;
          }
        }
        while (!cj.a(true));
        ((com.viber.voip.messages.k)this.W.get()).c().a(paramaa.a(), paramaa.C());
        return;
      }
      while (!paramaa.ap());
      if (!paramaa.aq())
      {
        ((com.viber.voip.messages.k)this.W.get()).c().c(paramaa.a());
        return;
      }
    }
    while ((paramaa.f() != 2) || (this.aa.a(com.viber.voip.permissions.n.m)));
    this.aa.a(this, 137, com.viber.voip.permissions.n.m);
  }

  public void g(com.viber.voip.messages.conversation.aa paramaa)
  {
  }

  public void i()
  {
    W();
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
    this.aq = new SpamController(this.mIsTablet, this.az.g(), this, this.an, this.T, this.P, (com.viber.voip.messages.controller.a)this.ae.get(), com.viber.voip.h.a.b());
    if (paramBundle != null)
      this.aq.a(paramBundle.getParcelable("spam_controller_state"));
    this.ay = new i(this, this.aX);
    this.aO = new com.viber.voip.messages.conversation.ui.b.b();
    this.aQ = new com.viber.voip.messages.conversation.ui.b.x();
    this.aR = new com.viber.voip.messages.conversation.ui.b.aj();
    this.d = new com.viber.voip.messages.ui.u(getActivity(), this, this.ab, this.P, this.Q);
    this.aP = new com.viber.voip.messages.conversation.ui.b.e();
    this.t = new com.viber.voip.messages.ui.aa(getActivity(), getLayoutInflater());
    this.u = new com.viber.voip.messages.ui.w(this, paramBundle, this.aa, this.ai, this);
    this.h = new com.viber.voip.messages.ui.x(getActivity(), this.g, getLayoutInflater(), (at)this.al.a(), this.av, this.av);
    this.as = new aq(this, this.av, this, this.at, paramView, paramBundle, this.bd, this.mIsTablet, this.an, this.ap, this.aO, this.t, this.u, this.aS, this.aN, this.m, this.ab, this.ad);
    this.as.a(this.aD);
    this.at.a(this.as);
    Z().setMessageSender(this);
    this.ax = new com.viber.voip.u.a.f(getContext());
    this.av.setVideoPttViewAnimationController(this.ax);
    this.aw = new com.viber.voip.messages.conversation.adapter.k(this.au, (at)this.al.a());
    this.aw.c(new com.viber.voip.messages.conversation.adapter.u());
    this.an.setEmptyViewAdapter(this.aw);
    this.an.a((at)this.al.a());
    this.ax.a(this.au);
    this.ax.a(this.az);
    this.f = new com.viber.voip.publicaccount.d.b(ag());
    this.as.e.setAdapter(this.aw);
    this.v = new f.a()
    {
      public boolean a()
      {
        ConversationItemLoaderEntity localConversationItemLoaderEntity = ConversationFragment.this.C();
        if (ConversationFragment.b(ConversationFragment.this));
        while ((!b()) || (ConversationFragment.this.aq.j()) || ((localConversationItemLoaderEntity.isNewSpamBanner()) && (ConversationFragment.this.an.a(ConversationAlertView.a.c))) || (localConversationItemLoaderEntity.isMuteConversation()) || (ConversationFragment.this.an.a(ConversationAlertView.a.n)))
          return false;
        return true;
      }

      public boolean b()
      {
        ConversationItemLoaderEntity localConversationItemLoaderEntity = ConversationFragment.this.C();
        if (localConversationItemLoaderEntity == null);
        while ((localConversationItemLoaderEntity.isBroadcastListType()) || (localConversationItemLoaderEntity.isPublicGroupBehavior()) || (localConversationItemLoaderEntity.isSecret()) || (localConversationItemLoaderEntity.isSystemReplyableChat()) || (localConversationItemLoaderEntity.isRakutenSystemConversation()) || (localConversationItemLoaderEntity.isSystemConversation()) || (localConversationItemLoaderEntity.isHiddenConversation()) || (localConversationItemLoaderEntity.isOneToOneWithPublicAccount()))
          return false;
        return true;
      }
    };
    this.c = new bg(this.as.e, this.at);
    this.at.a(this.c);
  }

  public void j()
  {
    if (this.as.g.isRefreshing())
    {
      this.as.g.setRefreshing(false);
      ConversationListView localConversationListView = this.as.e;
      boolean bool1 = this.mIsTablet;
      boolean bool2 = false;
      if (bool1)
      {
        CallInfo localCallInfo = this.S.getCallHandler().getCallInfo();
        bool2 = false;
        if (localCallInfo != null)
          bool2 = true;
      }
      localConversationListView.setPushdownEnabled(bool2);
      this.as.e.e();
    }
  }

  public void j(com.viber.voip.messages.conversation.aa paramaa)
  {
    if ((da.a(paramaa.o())) && (paramaa.C() != null) && (paramaa.f() != -2) && (!this.q.contains(Long.valueOf(paramaa.a()))))
    {
      a(new e.b(paramaa), 143);
      return;
    }
    if (com.viber.voip.util.at.d(getActivity(), paramaa.o()))
    {
      new ViberActionRunner.az.c(getActivity(), this.P, new com.viber.voip.invitelinks.f(((com.viber.voip.messages.k)this.W.get()).u(), cj.a(getActivity()))).a(this.aB.conversationId, paramaa, false, null);
      return;
    }
    com.viber.voip.ui.dialogs.t.a(getString(R.string.app_name)).b(this);
  }

  protected void k()
  {
    if (this.d != null)
      this.d.a();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((this.mIsTablet) && (!dj.c(getActivity())))
    {
      CallerContainer localCallerContainer = (CallerContainer)getActivity().findViewById(R.id.home_dialer_container);
      if (localCallerContainer != null)
        localCallerContainer.a(this);
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.as.a(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    this.aD = ((a)getActivity());
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof ViberFragmentActivity))
      ((ViberFragmentActivity)localFragmentActivity).setupAndShowPinDialog(this);
    if (this.au != null)
      this.au.a(paramConfiguration);
    super.onConfigurationChanged(paramConfiguration);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = super.onContextItemSelected(paramMenuItem);
    return (this.d.a(paramMenuItem)) || (bool);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.aE = com.viber.voip.av.a(av.e.a);
    this.aF = com.viber.voip.av.a(av.e.f);
    this.aG = com.viber.voip.av.a(av.e.g);
    this.o = ViberApplication.getInstance().getUserManager().getRegistrationValues();
    this.p = a(paramBundle);
    this.aZ = new com.viber.voip.messages.conversation.ui.b.f(this, this.N);
    this.bb = new com.viber.voip.messages.conversation.ui.b.i(this, com.viber.voip.messages.controller.manager.ab.b(), new com.viber.voip.util.az(com.viber.voip.av.a(av.e.a), com.viber.voip.av.a(av.e.d)));
    this.ba = new com.viber.voip.messages.conversation.ui.b.n(this);
    this.bc = new com.viber.voip.messages.conversation.ui.b.af(this);
    this.az = a(ViberApplication.getApplication(), getLoaderManager(), this.W, com.viber.voip.h.a.b(), paramBundle);
    this.aX = new com.viber.voip.messages.conversation.ui.b.u();
    this.aY = new com.viber.voip.messages.conversation.ui.b.t(ViberApplication.getInstance().getPlayerWindowManager());
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    if (this.d == null)
      return;
    if ((paramView.getTag() instanceof Uri))
    {
      this.d.a(paramContextMenu, getActivity().getMenuInflater(), paramView, this.at);
      return;
    }
    if ((paramView instanceof MessageEditText))
    {
      this.d.b(paramContextMenu, getActivity().getMenuInflater(), paramView, this.at);
      return;
    }
    View localView;
    do
    {
      paramView = localView;
      if (paramView.getParent() == null)
        break;
      localView = (View)paramView.getParent();
    }
    while (!(localView.getTag() instanceof com.viber.voip.ui.g.a));
    a(paramContextMenu, (com.viber.voip.ui.g.a)localView.getTag());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.msg_conversation_list_content, paramViewGroup, false);
    this.am = ((ConversationListView)localView.findViewById(R.id.conversation_list));
    this.an = ((ConversationAlertView)localView.findViewById(R.id.alert_banner));
    this.ao = ((ConversationBannerView)localView.findViewById(R.id.remote_banner_container_wrapper_bottom));
    this.ap = ((SwipeRefreshLayout)localView.findViewById(R.id.swipe_refresh_layout));
    this.m = localView.findViewById(R.id.edit_options);
    this.av = ((MessageComposerView)localView.findViewById(R.id.message_composer));
    this.g = ((ExpandablePanelLayout)localView.findViewById(R.id.conversation_menu));
    this.bd = new com.viber.voip.messages.ui.t(getActivity());
    this.al = new av(getContext());
    this.aA = new com.viber.voip.messages.ui.ai(getContext());
    a();
    this.aN = new com.viber.voip.messages.conversation.ui.b.a();
    this.aU = new com.viber.voip.messages.conversation.ui.b.ac(getActivity().getApplicationContext(), com.viber.voip.messages.controller.manager.ab.b(), this.Z);
    this.av.setInputFieldInteractor(this.aS);
    this.at = new j(this, ViberApplication.getInstance().getChangePhoneNumberController().b(), this.O, this.aX, this.az.h(), (cl)this.ak.get(), this.ac, this.ah);
    this.a = new com.viber.voip.messages.controller.w(this, this.aS, this.ab, this.aN);
    com.viber.voip.messages.conversation.aj localaj = new com.viber.voip.messages.conversation.aj(this.B);
    localaj.a(this);
    com.viber.voip.messages.conversation.q localq = this.az.g();
    Context localContext = getContext();
    this.ar = new com.viber.voip.messages.conversation.adapter.a.c.a.j(localContext, com.viber.voip.util.e.e.a(localContext), this.N, new com.viber.voip.messages.ui.ai(localContext), this.p, new com.viber.voip.messages.j(localContext), ah(), this.P, this.mIsTablet, new com.viber.voip.messages.conversation.adapter.b.a.a(), new x(this), new ah(this));
    this.x = new com.viber.voip.messages.conversation.ui.a.h();
    this.bj = new com.viber.voip.messages.conversation.ui.a.h();
    this.bk = new com.viber.voip.messages.conversation.ui.a.h();
    this.bl = new com.viber.voip.messages.conversation.ui.a.h();
    this.bm = new com.viber.voip.messages.conversation.ui.a.l();
    this.bn = new com.viber.voip.messages.conversation.ui.a.k();
    this.bo = new com.viber.voip.messages.conversation.ui.a.j();
    this.bp = new com.viber.voip.messages.conversation.ui.a.d();
    this.bq = new com.viber.voip.messages.conversation.ui.a.e();
    this.br = new com.viber.voip.messages.conversation.ui.a.p();
    this.bs = new com.viber.voip.messages.conversation.ui.a.m();
    this.bt = new com.viber.voip.messages.conversation.ui.a.n();
    this.bu = new com.viber.voip.messages.conversation.ui.a.o();
    this.bv = new com.viber.voip.messages.conversation.ui.a.s();
    this.bw = new com.viber.voip.messages.conversation.ui.a.t();
    this.bx = new com.viber.voip.messages.conversation.ui.a.g();
    this.by = new com.viber.voip.messages.conversation.ui.a.f();
    this.bz = new com.viber.voip.messages.conversation.ui.a.c();
    this.bA = new com.viber.voip.messages.conversation.ui.a.f();
    this.bB = new com.viber.voip.messages.conversation.ui.a.w();
    this.bC = new com.viber.voip.messages.conversation.ui.a.u();
    this.bD = new com.viber.voip.messages.conversation.ui.a.q();
    this.bh = new com.viber.voip.messages.conversation.ui.a.v();
    this.bF = new com.viber.voip.messages.conversation.ui.a.i();
    com.viber.voip.messages.conversation.ui.a.a locala = new com.viber.voip.messages.conversation.ui.a.a(this.e, this, this.aE);
    new com.viber.voip.messages.conversation.ui.a.r().a(locala);
    com.viber.voip.messages.conversation.adapter.e.b localb = new com.viber.voip.messages.conversation.adapter.e.b(this, this, this.w, this.x, this.bj, this.bk, this.bl, this.bm, this.bn, this.bo, this.bp, this.bq, this.br, this.bs, this.bt, this.bu, this.bv, this.bw, this.bx, this.by, this.bz, this.bA, this.bB, this.bC, this.bD, this.bh, locala, this.bE, this.bF);
    this.b = a(this.am, localq, localaj, this.a, this.ar);
    this.au = a(paramLayoutInflater, localq, this.a, this.ar, localContext, localb);
    this.am.a(this.au);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.d != null)
      this.d.a();
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.at.j();
    this.as.c();
    if (this.b != null)
      this.b.c();
    if (this.au != null)
    {
      this.au.c();
      this.au = null;
    }
    if (this.az != null)
      this.az.f();
    com.viber.voip.block.b.a().b().b(this);
    this.Z.b(this);
    if (this.aw != null)
      this.aw.b();
    this.aI.onDestroy();
    this.aq.d();
    this.f.a();
    this.ax.b(this.au);
    this.ax.b(this.az);
  }

  public void onDetach()
  {
    super.onDetach();
    this.aD = null;
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    super.onDialogAction(paramm, paramInt);
    if (paramm.a(DialogCode.D_PIN))
      b(paramInt);
    do
    {
      do
      {
        ConversationItemLoaderEntity localConversationItemLoaderEntity;
        do
        {
          Bundle localBundle2;
          LinkedList localLinkedList;
          do
          {
            return;
            if ((!paramm.a(DialogCode.D377a)) && (!paramm.a(DialogCode.D377b)))
              break;
            Bundle localBundle1 = (Bundle)paramm.d();
            localBundle2 = (Bundle)localBundle1.getParcelable("options");
            localLinkedList = (LinkedList)localBundle1.getSerializable("extra_conversation_data");
            File localFile = (File)localLinkedList.poll();
            if ((paramm.a(DialogCode.D377a)) && (-1 == paramInt))
              Z().a(Uri.fromFile(localFile), localBundle2);
          }
          while (localLinkedList.size() <= 0);
          this.as.a(localLinkedList, localBundle2);
          return;
          if ((paramm.a(DialogCode.D2103)) && (-1 == paramInt))
          {
            ViberApplication.getInstance().getUpdateViberManager().a(paramm.getActivity());
            return;
          }
          if ((!paramm.a(DialogCode.D330a)) || (-1 != paramInt))
            break;
          localConversationItemLoaderEntity = C();
        }
        while (localConversationItemLoaderEntity == null);
        ((com.viber.voip.messages.k)this.W.get()).c().b(localConversationItemLoaderEntity.getId(), null);
        Z().u();
        return;
      }
      while ((!paramm.a(DialogCode.D1012a)) && (!paramm.a(DialogCode.D1012c)));
      if (-1 == paramInt)
      {
        Bundle localBundle3 = new Bundle(2);
        localBundle3.putString("extra_entry_point", "Other");
        localBundle3.putInt("extra_action", 2);
        ViberActionRunner.bf.a(paramm.getActivity(), localBundle3);
        return;
      }
    }
    while ((this.mIsTablet) || (this.aZ.b() == null) || (this.aZ.b().isNotJoinedCommunity()));
    getActivity().finish();
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    if (this.b != null)
      this.b.a(paramBoolean);
  }

  public void onPause()
  {
    this.as.b();
    this.at.i();
    super.onPause();
  }

  public void onRefresh()
  {
    com.viber.voip.av.a(av.e.g).postDelayed(new b(this, null), 500L);
  }

  public void onRemoteBannerVisibilityChange(boolean paramBoolean, com.viber.voip.banner.d.c paramc, com.viber.voip.banner.view.b paramb)
  {
    super.onRemoteBannerVisibilityChange(paramBoolean, paramc, paramb);
    Z().v();
  }

  public void onResume()
  {
    this.as.a();
    this.at.h();
    this.az.e();
    super.onResume();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.as.a(paramBundle);
    this.az.a(paramBundle);
    Parcelable localParcelable1 = this.p.c();
    if (localParcelable1 != null)
      paramBundle.putParcelable("potential_spam_controller_state", localParcelable1);
    Parcelable localParcelable2 = this.aq.a();
    if (localParcelable2 != null)
      paramBundle.putParcelable("spam_controller_state", localParcelable2);
  }

  public void onStart()
  {
    super.onStart();
    if ((this.at.f()) && ((!this.mIsTablet) || (this.aD.a(this))))
      ((com.viber.voip.messages.k)this.W.get()).a().b(this.at.b());
    if (this.b != null)
      this.b.a();
    if (this.as != null)
      this.as.d();
    this.aa.a(this.bG);
    this.aa.a(this.bH);
    this.aq.b();
  }

  public void onStop()
  {
    super.onStop();
    this.k = true;
    if (this.az != null)
    {
      this.az.g().G();
      ((com.viber.voip.messages.k)this.W.get()).a().b(C());
    }
    if (this.b != null)
      this.b.b();
    if (this.p != null)
      this.p.b();
    if (this.as != null)
      this.as.e();
    this.aa.b(this.bG);
    this.aa.b(this.bH);
    this.aq.c();
  }

  public void onVisibilityChanged(int paramInt)
  {
    ConversationListView localConversationListView = this.as.e;
    if ((!dj.c(getActivity())) && (paramInt == 0));
    for (boolean bool = true; ; bool = false)
    {
      localConversationListView.setPushdownEnabled(bool);
      return;
    }
  }

  protected GeneralConversationPresenter p()
  {
    if (this.aM == null)
      this.aM = new GeneralRegularConversationPresenter(this.aN, this.aZ, this.aX, this.aY, this.bb, cj.a(getContext()), ViberApplication.getInstance().getMediaMountManager(), this.bc, this.ba, this.mIsTablet, com.viber.voip.h.a.b(), this.aQ, this.aS, this.P, this.R, com.viber.voip.av.a(av.e.g), this.aE, new cq(getContext()), this.I, ((com.viber.voip.messages.k)this.W.get()).h());
    return this.aM;
  }

  public void q()
  {
    BT.a("DATA", "load conversation messages");
    BT.a("DATA", "load conversation");
    if (this.as != null)
    {
      this.as.e.b(this.c);
      this.as.e.b(this.c);
    }
    if (this.aB.conversationType == 1)
      BT.a("DATA", "load conversation participants");
    this.az.l();
    com.viber.voip.block.b.a().b().a(this);
    this.az.a(this.aB, this.j);
    this.E.a();
  }

  public void removeConversationIgnoredView(View paramView)
  {
    if (this.aD != null)
      this.aD.removeConversationIgnoredView(paramView);
  }

  protected boolean s()
  {
    return false;
  }

  protected com.viber.voip.messages.conversation.ui.view.e z()
  {
    return new com.viber.voip.messages.conversation.ui.view.e();
  }

  public static abstract interface a extends ba
  {
    public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt, String paramString);

    public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean);

    public abstract void a(ConversationData paramConversationData);

    public abstract boolean a(Fragment paramFragment);

    public abstract boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString);

    public abstract void c(boolean paramBoolean);

    public abstract void m();

    public abstract TextView n();

    public abstract TextView o();

    public abstract void p();
  }

  private static class b extends com.viber.voip.d.b<aq.a>
  {
    private b(aq.a parama)
    {
      super();
    }

    public void a(aq.a parama)
    {
      parama.M();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.ConversationFragment
 * JD-Core Version:    0.6.2
 */