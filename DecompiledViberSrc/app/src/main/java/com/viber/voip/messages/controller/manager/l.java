package com.viber.voip.messages.controller.manager;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PgGeneralQueryReplyListener;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PausedControllerListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.group.GroupAssignRoleListener;
import com.viber.jni.group.GroupCreateListener;
import com.viber.jni.group.GroupInfoListener;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.im2.Im2ReceiverBase;
import com.viber.jni.like.GroupLikesListener;
import com.viber.jni.like.LikeControllerDelegate.GroupLikes;
import com.viber.jni.like.PublicGroupLikesListener;
import com.viber.jni.messenger.DeleteMessageListener;
import com.viber.jni.messenger.FormattedReceiverListener;
import com.viber.jni.messenger.MediaReceiverListener;
import com.viber.jni.messenger.MessageSenderListener;
import com.viber.jni.messenger.MessengerDelegate.SyncConversations;
import com.viber.jni.messenger.MessengerDelegate.SyncConversationsReply;
import com.viber.jni.messenger.MessengerDelegate.SyncMessages;
import com.viber.jni.messenger.MessengerDelegate.SyncMessagesReply;
import com.viber.jni.messenger.PttReceiverListener;
import com.viber.jni.messenger.RecentMessagesEndedListener;
import com.viber.jni.messenger.TextReceiverListener;
import com.viber.jni.messenger.VideoReceiverListener;
import com.viber.jni.ptt.VideoPttPlayerListener;
import com.viber.jni.publicaccount.PublicAccountCallbackListener;
import com.viber.jni.publicaccount.PublicAccountInfoReceiverListener;
import com.viber.jni.publicaccount.PublicAccountRefreshTokenListener;
import com.viber.jni.publicgroup.PublicGroupGetMessagesListener;
import com.viber.jni.secure.SecureMessagesDelegate;
import com.viber.jni.secure.SecureMessagesListener;
import com.viber.jni.secure.SecurityAvailableDelegate;
import com.viber.jni.secure.SecurityAvailableListener;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateListener;
import com.viber.jni.settings.Im2ChangeSettingsSender;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.t;
import com.viber.voip.ap.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.a.a.h;
import com.viber.voip.gdpr.a.d.a;
import com.viber.voip.i.c.j;
import com.viber.voip.i.c.n;
import com.viber.voip.i.c.q;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.b.ac;
import com.viber.voip.messages.controller.b.ac.a;
import com.viber.voip.messages.controller.b.q;
import com.viber.voip.messages.controller.b.u;
import com.viber.voip.messages.controller.b.x;
import com.viber.voip.messages.controller.bc;
import com.viber.voip.messages.controller.bk;
import com.viber.voip.messages.controller.bl;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.cc;
import com.viber.voip.messages.controller.cd;
import com.viber.voip.messages.controller.ce;
import com.viber.voip.messages.controller.cg;
import com.viber.voip.messages.controller.ch;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.cl;
import com.viber.voip.messages.controller.publicaccount.w;
import com.viber.voip.messages.controller.v;
import com.viber.voip.phone.MinimizedCallManager;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.q.i;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.at;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.l;
import com.viber.voip.settings.d.o;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.d.v;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.audiofocus.AudioFocusManager;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.am;
import com.viber.voip.ui.z;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.age.UserAgeController;
import com.viber.voip.util.ViberActionRunner.bq;
import com.viber.voip.util.ap;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

@Singleton
public class l
  implements com.viber.voip.messages.k
{
  private final com.viber.voip.u.e A;
  private final i B;
  private final com.viber.voip.u.d C;
  private final k D;
  private final ac E;
  private final cd F;
  private final com.viber.voip.messages.controller.publicaccount.d G;
  private final com.viber.voip.banner.a.a.f H;
  private final com.viber.voip.messages.extensions.a.b I;
  private final an J;
  private final ah K;
  private final ao L;
  private final c M;
  private final au N;
  private final com.viber.voip.publicaccount.a.a O;
  private final com.viber.voip.invitelinks.n P;
  private final com.viber.voip.invitelinks.d Q;
  private final com.viber.voip.messages.controller.a.a R;
  private final com.viber.voip.gdpr.a.e S;
  private final com.viber.voip.messages.controller.r T;
  private final com.viber.voip.messages.controller.a U;
  private final UserAgeController V;
  private final com.viber.voip.contacts.c.d.p W;
  private final g X;
  private final cl Y;
  private final Context d;
  private final Handler e;
  private final Handler f;
  private final Handler g;
  private final EventBus h;
  private final Engine i;
  private final EngineDelegatesManager j;
  private final com.viber.voip.util.d k;
  private final PhoneController l;
  private final Im2Exchanger m;
  private final dagger.a<com.viber.voip.util.e.e> n;
  private final dagger.a<com.google.d.f> o;
  private final com.viber.voip.messages.controller.ai p;
  private final GroupController q;
  private final ci r;
  private final q s;
  private final com.viber.voip.messages.controller.b.p t;
  private final com.viber.voip.messages.controller.b.g u;
  private final u v;
  private final com.viber.voip.messages.controller.b.ak w;
  private final x x;
  private final LikeControllerDelegate.GroupLikes y;
  private final com.viber.voip.q.k z;

  @Inject
  l(Context paramContext, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, Handler paramHandler4, Handler paramHandler5, Handler paramHandler6, Handler paramHandler7, Engine paramEngine, EngineDelegatesManager paramEngineDelegatesManager, com.viber.voip.app.b paramb, EventBus paramEventBus, ab paramab, UserManager paramUserManager, com.viber.voip.registration.af paramaf, o paramo, bn parambn, com.viber.voip.util.d paramd, al paramal, ak paramak, com.viber.voip.messages.d.b paramb1, com.viber.voip.analytics.g paramg, com.viber.voip.messages.extensions.c paramc, com.viber.voip.stickers.a.a parama, com.viber.voip.messages.ui.ai paramai, CallHandler paramCallHandler, ap.a parama1, PhoneController paramPhoneController, ICdrController paramICdrController, ap paramap, ActivationController paramActivationController, Im2Exchanger paramIm2Exchanger, com.viber.common.permission.c paramc1, com.viber.voip.messages.extras.b.a parama2, dagger.a<com.viber.voip.notif.e.m> parama3, dagger.a<com.viber.voip.contacts.c.d.g> parama4, dagger.a<com.viber.voip.messages.extensions.f> parama5, dagger.a<com.viber.voip.util.e.e> parama6, dagger.a<bs> parama7, dagger.a<com.viber.voip.model.a.d> parama8, dagger.a<ConferenceCallsRepository> parama9, dagger.a<com.google.d.f> parama10, dagger.a<IRingtonePlayer> parama11, dagger.a<ISoundService> parama12)
  {
    this.d = paramContext.getApplicationContext();
    this.e = paramHandler1;
    this.f = paramHandler2;
    this.g = paramHandler7;
    this.h = paramEventBus;
    this.i = paramEngine;
    this.j = paramEngineDelegatesManager;
    this.k = paramd;
    this.l = paramPhoneController;
    this.m = paramIm2Exchanger;
    this.n = parama6;
    this.o = parama10;
    com.viber.voip.analytics.story.e.c localc = paramg.c().g();
    com.viber.voip.analytics.story.a.a locala = paramg.c().k();
    com.viber.voip.analytics.story.g.a locala1 = paramg.c().c();
    this.D = new k(paramd);
    this.F = new ce(this.f, new v());
    com.viber.voip.messages.controller.publicaccount.e locale = new com.viber.voip.messages.controller.publicaccount.e(this.f, paramHandler5, new w(this.d, paramEngine, this.f, paramHandler5, paramHandler1, paramab, paramal, paramak, parama5, paramc));
    this.G = locale;
    this.I = new com.viber.voip.messages.extensions.a.b(new com.viber.voip.messages.extensions.a.c(paramEngine), this.f);
    c.a locala2 = c.a.a();
    this.H = new h(paramContext, this.f, paramHandler3, paramHandler1, paramPhoneController, paramICdrController, new com.viber.voip.ads.r(paramap), new t(paramContext, this.f), new com.viber.voip.banner.a.a.g(0), locala2, paramb.a(paramContext));
    this.R = new com.viber.voip.messages.controller.a.a(this.d, new com.viber.voip.messages.controller.a.d(), paramab, parama7, paramo, this.f, c.q.b.e(), d.l.a, d.l.b, paramb.a(paramContext));
    this.p = new com.viber.voip.messages.controller.aj(this.f, new bc(this.d, paramEventBus, paramHandler2, paramHandler1, paramHandler3, paramo, paramab, parama7, this.D, this.F, parama4, paramaf, paramICdrController, paramEngine, parama10, localc, locala, locala1, parama8, paramg));
    cc localcc = new cc(this.p, paramUserManager.getAppsController(), paramab);
    this.v = new u(this.d, this.p, paramo, paramaf, paramab, parama7, parambn, localcc, paramEventBus, localc, parama, paramai, parama6);
    this.w = new com.viber.voip.messages.controller.b.ak(this.d);
    Context localContext1 = this.d;
    com.viber.voip.messages.d.j localj1 = new com.viber.voip.messages.d.j(paramo, parama7, paramab, paramaf);
    com.viber.voip.messages.controller.af localaf = new com.viber.voip.messages.controller.af(localContext1, paramEventBus, localj1, paramal, parama7, paramab, paramo, paramEngine, locala1, localc);
    this.q = new com.viber.voip.messages.controller.ab(this.f, localaf);
    Context localContext2 = this.d;
    com.viber.voip.messages.controller.b.ak localak = this.w;
    bl localbl = new bl(paramHandler2, paramContext);
    bk localbk = new bk(paramContext, paramHandler2, paramo, paramab);
    this.x = new x(localContext2, paramHandler2, paramaf, paramab, parama7, paramak, localak, paramo, parama2, localbl, parambn, localbk, new com.viber.voip.messages.extras.image.c(), paramc1, paramICdrController, this.q, localc, paramai, parama8);
    paramEventBus.register(this.x);
    com.viber.voip.q.f localf = new com.viber.voip.q.f(paramEventBus, parama12, paramEngine.getDelegatesManager(), paramEngine.getCallHandler().getCallNotifier(), paramContext);
    this.B = new i(localf, new AudioFocusManager(paramContext), paramHandler6, paramHandler1, paramo, paramab);
    this.C = new com.viber.voip.u.d(paramPhoneController, new AudioFocusManager(paramContext), paramHandler2, paramHandler1, paramo, paramab, paramEventBus);
    this.z = new com.viber.voip.q.k(localf, parama11, paramHandler4, paramEventBus, paramContext);
    this.A = new com.viber.voip.u.e(this.d, paramHandler4, localf, this.C, paramEventBus);
    this.y = new com.viber.voip.messages.controller.b.n(paramContext, paramaf, parambn);
    com.viber.voip.flatbuffers.b.d locald = com.viber.voip.flatbuffers.b.e.e();
    com.viber.voip.messages.d.j localj2 = new com.viber.voip.messages.d.j(paramo, parama7, paramab, paramaf);
    this.U = new com.viber.voip.messages.controller.a(paramIm2Exchanger, paramPhoneController, localj2, paramb1, paramo, paramab, parama7, paramak, paramal, paramaf, locald.b(), locald.a(), m.a, d.o.e, paramEventBus, this.f, locala1, parama8, com.viber.voip.flatbuffers.b.e.a().b(), this.q, parama3, localc, this.p);
    paramEventBus.register(this.U);
    this.s = new q(this.d, localaf, paramaf, this.p, paramd, parambn, this.U, parama7, parambn);
    this.t = new com.viber.voip.messages.controller.b.p(this.d, localaf, paramaf, paramPhoneController, this.U, parama7, parambn);
    this.u = new com.viber.voip.messages.controller.b.g(paramo, localaf, this.U, parama7, paramab, paramPhoneController, paramal, locala1, localc);
    this.r = new com.viber.voip.messages.controller.cj(this.f, this.w);
    this.X = new g(paramContext, paramak, paramal, paramab, this.D, parama9, paramo);
    this.T = new com.viber.voip.messages.controller.r(com.viber.voip.util.cj.a(this.d), this.f, parama10, parama1.aT, ViberEnv.getOkHttpClientFactory());
    this.K = new ai(paramo, this.f);
    Handler localHandler1 = this.f;
    boolean bool1;
    com.viber.voip.messages.controller.b.ai localai;
    com.viber.jni.messenger.paused.SyncConversationsListener localSyncConversationsListener;
    com.viber.jni.messenger.paused.SyncConversationsReplyListener localSyncConversationsReplyListener;
    com.viber.jni.messenger.paused.SyncMessagesListener localSyncMessagesListener;
    com.viber.jni.messenger.paused.SyncMessagesReplyListener localSyncMessagesReplyListener;
    DeleteMessageListener localDeleteMessageListener;
    MessageSenderListener localMessageSenderListener;
    PublicGroupLikesListener localPublicGroupLikesListener;
    com.viber.voip.util.i.c localc1;
    aw localaw;
    at localat;
    ax localax;
    ConnectionController localConnectionController;
    Handler localHandler3;
    com.viber.common.b.d locald1;
    com.viber.common.b.d locald2;
    com.viber.voip.messages.controller.ai localai1;
    com.viber.voip.model.a.d locald3;
    if (!com.viber.voip.registration.ao.f())
    {
      bool1 = true;
      this.L = new ao(paramo, localHandler1, paramEventBus, bool1);
      com.viber.voip.messages.controller.b.o localo = new com.viber.voip.messages.controller.b.o(this.d, paramUserManager, paramo, paramab, parama7, paramCallHandler, parama6, paramEventBus, this.p);
      Context localContext3 = this.d;
      Handler localHandler2 = this.f;
      com.viber.voip.messages.controller.b.l[] arrayOfl = new com.viber.voip.messages.controller.b.l[5];
      arrayOfl[0] = this.v;
      arrayOfl[1] = this.s;
      arrayOfl[2] = localo;
      arrayOfl[3] = this.x;
      arrayOfl[4] = this.w;
      localai = new com.viber.voip.messages.controller.b.ai(localContext3, localHandler2, arrayOfl);
      localai.a(paramEngine);
      localSyncConversationsListener = new com.viber.jni.messenger.paused.SyncConversationsListener(new MessengerDelegate.SyncConversations[0]);
      localSyncConversationsListener.registerDelegate(localo, this.f);
      localSyncConversationsReplyListener = new com.viber.jni.messenger.paused.SyncConversationsReplyListener(new MessengerDelegate.SyncConversationsReply[0]);
      localSyncConversationsReplyListener.registerDelegate(localo, this.f);
      localSyncMessagesListener = new com.viber.jni.messenger.paused.SyncMessagesListener(new MessengerDelegate.SyncMessages[0]);
      localSyncMessagesListener.registerDelegate(localo, this.f);
      localSyncMessagesReplyListener = new com.viber.jni.messenger.paused.SyncMessagesReplyListener(new MessengerDelegate.SyncMessagesReply[0]);
      localSyncMessagesReplyListener.registerDelegate(localo, this.f);
      localDeleteMessageListener = new DeleteMessageListener();
      localDeleteMessageListener.registerDelegate(localo, this.f);
      localMessageSenderListener = new MessageSenderListener();
      localMessageSenderListener.registerDelegate(this.x, this.f);
      localPublicGroupLikesListener = new PublicGroupLikesListener();
      localPublicGroupLikesListener.registerDelegate(new com.viber.voip.messages.controller.b.r(), this.f);
      localc1 = new com.viber.voip.util.i.c();
      localaw = new aw();
      com.viber.voip.i.f localf1 = c.n.a;
      Context localContext4 = this.d;
      com.viber.voip.util.az localaz = new com.viber.voip.util.az(paramHandler1, this.f);
      com.viber.voip.backup.g localg = com.viber.voip.backup.g.a();
      Context localContext5 = this.d;
      com.viber.voip.ui.d[] arrayOfd = new com.viber.voip.ui.d[1];
      arrayOfd[0] = MinimizedCallManager.getInstance();
      z localz = new z(paramContext, arrayOfd);
      am localam = new am(localContext5, localz, new ViberActionRunner.bq(this.d));
      localat = new at(parama10, localf1, localc1, localContext4, paramaf, paramIm2Exchanger, paramEngine, paramd, localaz, localg, localam);
      j localj = new j(d.v.o);
      localax = new ax(localj, parama10, localc1, paramIm2Exchanger, paramPhoneController, paramEngine.getConnectionController(), paramActivationController, this.f, d.v.j, d.v.k, d.v.m, d.v.n, d.v.l, d.f.b, d.f.c, d.f.d, d.f.e, d.v.q);
      localConnectionController = paramEngine.getConnectionController();
      localHandler3 = this.f;
      locald1 = d.o.c;
      locald2 = d.o.d;
      localai1 = this.p;
      locald3 = com.viber.voip.model.a.b.c();
      if (com.viber.voip.registration.ao.f())
        break label2988;
    }
    label2988: for (boolean bool2 = true; ; bool2 = false)
    {
      az localaz1 = new az(parama10, paramIm2Exchanger, paramPhoneController, localConnectionController, localHandler3, paramab, locald1, locald2, paramEventBus, localai1, locald3, bool2);
      am.a[] arrayOfa1 = new am.a[4];
      arrayOfa1[0] = au.a(as.a.a, localat);
      arrayOfa1[1] = au.a(as.a.b, localaw);
      arrayOfa1[2] = au.a(as.a.c, localax);
      arrayOfa1[3] = au.a(as.a.d, localaz1);
      this.N = new au(arrayOfa1);
      as localas = new as(this.N, paramIm2Exchanger);
      paramIm2Exchanger.registerDelegate(localas, this.f);
      am.a[] arrayOfa2 = new am.a[1];
      arrayOfa2[0] = E();
      this.M = new c(arrayOfa2);
      paramIm2Exchanger.registerDelegate(new b(this.M), this.f);
      ac localac = new ac(this.d, new PausedControllerListener[] { localSyncConversationsListener, localSyncConversationsReplyListener, localSyncMessagesListener, localSyncMessagesReplyListener, localDeleteMessageListener, localMessageSenderListener, localPublicGroupLikesListener, localas });
      localac.a(this.v, this.f);
      localac.registerDelegate(this.v, this.f);
      localac.a(this.y, this.f);
      localac.registerDelegate((ac.a)this.y, this.f);
      localac.a(this.v, this.f);
      localac.a(this.v, this.f);
      paramEngineDelegatesManager.getSyncConversationsListener().registerDelegate(localSyncConversationsListener, this.f);
      paramEngineDelegatesManager.getSyncConversationsReplyListener().registerDelegate(localSyncConversationsReplyListener, this.f);
      paramEngineDelegatesManager.getSyncMessagesListener().registerDelegate(localSyncMessagesListener, this.f);
      paramEngineDelegatesManager.getSyncMessagesReplyListener().registerDelegate(localSyncMessagesReplyListener, this.f);
      this.A.a(paramEngineDelegatesManager);
      paramEngineDelegatesManager.getPublicAccountInfoReceiverListener().registerDelegate(this.t, this.f);
      paramEngineDelegatesManager.getPublicAccountCallbackListener().registerDelegate(this.t, this.f);
      paramEngineDelegatesManager.getPublicAccountCallbackListener().registerDelegate(this.u, this.f);
      paramEngineDelegatesManager.getPublicAccountRefreshTokenListener().registerDelegate(this.t, this.f);
      paramIm2Exchanger.registerDelegate(this.t, this.f);
      paramEngineDelegatesManager.getPublicGroupLikesListener().registerDelegate(localPublicGroupLikesListener, this.f);
      paramIm2Exchanger.registerDelegate(this.s, this.f);
      paramEngineDelegatesManager.getGroupAssignRoleListener().registerDelegate(this.s, this.f);
      paramEngineDelegatesManager.getGroupInfoListener().registerDelegate(this.s, this.f);
      paramEngineDelegatesManager.getGroupCreateListener().registerDelegate(this.s, this.f);
      paramEngineDelegatesManager.getGroupCreateListener().registerDelegate(this.u, this.f);
      paramIm2Exchanger.registerDelegate(this.u, this.f);
      paramEngineDelegatesManager.registerDelegate(localai, null);
      paramEngineDelegatesManager.getServiceStateListener().registerDelegate(new ServiceStateDelegate[] { localai });
      paramEngineDelegatesManager.getPublicGroupGetMessagesListener().registerDelegate(localac, null);
      paramEngineDelegatesManager.getMessengerPttReceiverListener().registerDelegate(localac, null);
      paramEngineDelegatesManager.getMessengerTextReceiverListener().registerDelegate(localac, null);
      paramEngineDelegatesManager.getMessengerMediaReceiverListener().registerDelegate(localac, null);
      paramEngineDelegatesManager.getMessengerVideoReceiverListener().registerDelegate(localac, null);
      paramEngineDelegatesManager.getMessengerFormattedReceiverListener().registerDelegate(localac, null);
      paramEngineDelegatesManager.getMessengerRecentMessagesEndedListener().registerDelegate(localac, null);
      paramEngineDelegatesManager.getGroupLikesListener().registerDelegate(localac, null);
      paramIm2Exchanger.registerDelegate(localac, null);
      ConnectionListener localConnectionListener = paramEngineDelegatesManager.getConnectionListener();
      localConnectionListener.registerDelegate(localac, null);
      localConnectionListener.registerDelegate(localcc, null);
      localat.a(localConnectionListener);
      localax.a(localConnectionListener);
      localaz1.a(localConnectionListener);
      paramEngineDelegatesManager.getMessageSenderListener().registerDelegate(localMessageSenderListener, paramHandler2);
      paramEngineDelegatesManager.getDeleteMessageListener().registerDelegate(localDeleteMessageListener, this.f);
      com.viber.voip.messages.controller.b.aj localaj = new com.viber.voip.messages.controller.b.aj(paramContext);
      paramEngineDelegatesManager.getSecureMessagesListener().registerDelegate(new SecureMessagesDelegate[] { localaj });
      paramEngineDelegatesManager.getSecurityAvailableListener().registerDelegate(new SecurityAvailableDelegate[] { localaj });
      paramEngineDelegatesManager.getVideoPttPlayerListener().registerDelegate(this.C, paramHandler1);
      this.Y = new cl(paramEventBus, av.a(av.e.b));
      Im2ReceiverBase[] arrayOfIm2ReceiverBase = new Im2ReceiverBase[1];
      arrayOfIm2ReceiverBase[0] = this.Y;
      paramIm2Exchanger.registerDelegate(arrayOfIm2ReceiverBase);
      this.J = new an();
      localConnectionListener.registerDelegate(this.J, this.f);
      paramIm2Exchanger.registerDelegate(this.J, this.f);
      this.P = new com.viber.voip.invitelinks.o(paramPhoneController, d(), paramIm2Exchanger, paramab, parama7, paramEventBus, this.f, paramg);
      this.P.a(paramEngineDelegatesManager.getGroupInfoListener(), this.s.a());
      this.Q = new com.viber.voip.invitelinks.e(paramPhoneController, d(), this.U, paramIm2Exchanger, paramab, parama7, paramo, paramEventBus, this.f);
      this.Q.a(paramEngineDelegatesManager.getPublicAccountInfoReceiverListener());
      this.W = new com.viber.voip.contacts.c.d.p(paramIm2Exchanger, d.p.t, d.p.s, paramak, paramPhoneController, this.f);
      this.W.a(paramo, localConnectionListener);
      this.E = localac;
      this.O = new com.viber.voip.publicaccount.a.a(this.d, paramPhoneController, paramICdrController, paramHandler3, locala2, paramHandler1);
      cg localcg = new cg(new ch(d.ad.S), localc1, d.ad.T, paramEventBus);
      paramEngineDelegatesManager.getConnectionListener().registerDelegate(localcg, this.f);
      paramEngineDelegatesManager.getPgGeneralQueryReplyListener().registerDelegate(this.U, this.f);
      paramEngineDelegatesManager.getConnectionListener().registerDelegate(this.U, this.f);
      paramIm2Exchanger.registerDelegate(this.U, this.f);
      am.a[] arrayOfa3 = new am.a[2];
      arrayOfa3[0] = F();
      arrayOfa3[1] = G();
      this.S = new com.viber.voip.gdpr.a.e(arrayOfa3);
      paramIm2Exchanger.registerDelegate(new com.viber.voip.gdpr.a.d(this.S), this.f);
      Im2ChangeSettingsSender localIm2ChangeSettingsSender = new Im2ChangeSettingsSender(paramIm2Exchanger, paramPhoneController, paramEngine.getConnectionController(), this.f);
      paramIm2Exchanger.registerDelegate(localIm2ChangeSettingsSender, this.f);
      localIm2ChangeSettingsSender.init(localConnectionListener);
      this.V = new UserAgeController(paramIm2Exchanger, paramPhoneController, paramEngine.getConnectionController(), this.f, c.j.c, d.v.i, d.bf.l, d.bf.m, d.bf.n, d.at.b, com.viber.voip.gdpr.f.a(this.d));
      this.V.init(localConnectionListener);
      return;
      bool1 = false;
      break;
    }
  }

  private am.a<a, b.a> E()
  {
    return new am.a()
    {
      public b.a a()
      {
        return b.a.a;
      }

      public a b()
      {
        return new d(l.a(l.this), l.b(l.this), l.c(l.this), new com.viber.voip.util.az(l.d(l.this), l.e(l.this)), new com.viber.voip.ui.g(), l.f(l.this).getConnectionListener(), l.g(l.this), l.this.h(), new com.viber.voip.util.links.c(new com.viber.voip.util.az(l.e(l.this), l.h(l.this)), new com.viber.voip.util.links.a()));
      }
    };
  }

  private am.a<com.viber.voip.gdpr.a.c, d.a> F()
  {
    return new am.a()
    {
      public d.a a()
      {
        return d.a.a;
      }

      public com.viber.voip.gdpr.a.c b()
      {
        return new com.viber.voip.gdpr.a.a.b.a(new com.viber.voip.util.az(l.d(l.this), l.e(l.this)), l.i(l.this), l.j(l.this), new com.viber.voip.gdpr.ui.a.b.a(l.k(l.this)), l.b(l.this), com.viber.voip.gdpr.a.a.c.a());
      }
    };
  }

  private am.a<com.viber.voip.gdpr.a.c, d.a> G()
  {
    return new am.a()
    {
      public d.a a()
      {
        return d.a.b;
      }

      public com.viber.voip.gdpr.a.c b()
      {
        ViberApplication localViberApplication = ViberApplication.getInstance();
        return new com.viber.voip.gdpr.a.a.a.a(new com.viber.voip.util.az(l.d(l.this), l.e(l.this)), l.i(l.this), l.j(l.this), new com.viber.voip.gdpr.ui.a.a.a(l.k(l.this)), l.b(l.this), com.viber.voip.gdpr.a.a.c.b(), d.v.g, l.this.e(), localViberApplication.getFacebookManager(), localViberApplication.getVKManager(), localViberApplication.getUserManager().getUserData(), (com.viber.voip.util.e.e)l.l(l.this).get(), d.v.i);
      }
    };
  }

  public UserAgeController A()
  {
    return this.V;
  }

  public g B()
  {
    return this.X;
  }

  public cl C()
  {
    return this.Y;
  }

  public com.viber.voip.messages.extensions.a.b D()
  {
    return this.I;
  }

  public k a()
  {
    return this.D;
  }

  public bv b()
  {
    return o.a();
  }

  public com.viber.voip.messages.controller.ai c()
  {
    return this.p;
  }

  public GroupController d()
  {
    return this.q;
  }

  public ci e()
  {
    return this.r;
  }

  public x f()
  {
    return this.x;
  }

  public cd g()
  {
    return this.F;
  }

  public com.viber.voip.messages.controller.publicaccount.d h()
  {
    return this.G;
  }

  public com.viber.voip.banner.a.a.f i()
  {
    return this.H;
  }

  public ac k()
  {
    return this.E;
  }

  public com.viber.voip.q.k l()
  {
    return this.z;
  }

  public i m()
  {
    return this.B;
  }

  public com.viber.voip.u.d n()
  {
    return this.C;
  }

  public com.viber.voip.u.e o()
  {
    return this.A;
  }

  public ah p()
  {
    return this.K;
  }

  public ao q()
  {
    return this.L;
  }

  public com.viber.voip.publicaccount.a.a r()
  {
    return this.O;
  }

  public com.viber.voip.invitelinks.n s()
  {
    return this.P;
  }

  public c t()
  {
    return this.M;
  }

  public com.viber.voip.invitelinks.d u()
  {
    return this.Q;
  }

  public au v()
  {
    return this.N;
  }

  public com.viber.voip.messages.controller.a.a w()
  {
    return this.R;
  }

  public com.viber.voip.gdpr.a.e x()
  {
    return this.S;
  }

  public com.viber.voip.messages.controller.r y()
  {
    return this.T;
  }

  public com.viber.voip.messages.controller.a z()
  {
    return this.U;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.l
 * JD-Core Version:    0.6.2
 */