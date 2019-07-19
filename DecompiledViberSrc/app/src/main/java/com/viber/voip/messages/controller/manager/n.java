package com.viber.voip.messages.controller.manager;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ap.a;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.notif.e.m;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.af;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ap;
import com.viber.voip.util.e.e;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;

public final class n
  implements dagger.a.d<l>
{
  private final Provider<ap.a> A;
  private final Provider<PhoneController> B;
  private final Provider<ICdrController> C;
  private final Provider<ap> D;
  private final Provider<ActivationController> E;
  private final Provider<Im2Exchanger> F;
  private final Provider<com.viber.common.permission.c> G;
  private final Provider<com.viber.voip.messages.extras.b.a> H;
  private final Provider<m> I;
  private final Provider<com.viber.voip.contacts.c.d.g> J;
  private final Provider<com.viber.voip.messages.extensions.f> K;
  private final Provider<e> L;
  private final Provider<bs> M;
  private final Provider<com.viber.voip.model.a.d> N;
  private final Provider<ConferenceCallsRepository> O;
  private final Provider<com.google.d.f> P;
  private final Provider<IRingtonePlayer> Q;
  private final Provider<ISoundService> R;
  private final Provider<Context> a;
  private final Provider<Handler> b;
  private final Provider<Handler> c;
  private final Provider<Handler> d;
  private final Provider<Handler> e;
  private final Provider<Handler> f;
  private final Provider<Handler> g;
  private final Provider<Handler> h;
  private final Provider<Engine> i;
  private final Provider<EngineDelegatesManager> j;
  private final Provider<com.viber.voip.app.b> k;
  private final Provider<EventBus> l;
  private final Provider<ab> m;
  private final Provider<UserManager> n;
  private final Provider<af> o;
  private final Provider<o> p;
  private final Provider<bn> q;
  private final Provider<com.viber.voip.util.d> r;
  private final Provider<al> s;
  private final Provider<ak> t;
  private final Provider<com.viber.voip.messages.d.b> u;
  private final Provider<com.viber.voip.analytics.g> v;
  private final Provider<com.viber.voip.messages.extensions.c> w;
  private final Provider<com.viber.voip.stickers.a.a> x;
  private final Provider<ai> y;
  private final Provider<CallHandler> z;

  public n(Provider<Context> paramProvider, Provider<Handler> paramProvider1, Provider<Handler> paramProvider2, Provider<Handler> paramProvider3, Provider<Handler> paramProvider4, Provider<Handler> paramProvider5, Provider<Handler> paramProvider6, Provider<Handler> paramProvider7, Provider<Engine> paramProvider8, Provider<EngineDelegatesManager> paramProvider9, Provider<com.viber.voip.app.b> paramProvider10, Provider<EventBus> paramProvider11, Provider<ab> paramProvider12, Provider<UserManager> paramProvider13, Provider<af> paramProvider14, Provider<o> paramProvider15, Provider<bn> paramProvider16, Provider<com.viber.voip.util.d> paramProvider17, Provider<al> paramProvider18, Provider<ak> paramProvider19, Provider<com.viber.voip.messages.d.b> paramProvider20, Provider<com.viber.voip.analytics.g> paramProvider21, Provider<com.viber.voip.messages.extensions.c> paramProvider22, Provider<com.viber.voip.stickers.a.a> paramProvider23, Provider<ai> paramProvider24, Provider<CallHandler> paramProvider25, Provider<ap.a> paramProvider26, Provider<PhoneController> paramProvider27, Provider<ICdrController> paramProvider28, Provider<ap> paramProvider29, Provider<ActivationController> paramProvider30, Provider<Im2Exchanger> paramProvider31, Provider<com.viber.common.permission.c> paramProvider32, Provider<com.viber.voip.messages.extras.b.a> paramProvider33, Provider<m> paramProvider34, Provider<com.viber.voip.contacts.c.d.g> paramProvider35, Provider<com.viber.voip.messages.extensions.f> paramProvider36, Provider<e> paramProvider37, Provider<bs> paramProvider38, Provider<com.viber.voip.model.a.d> paramProvider39, Provider<ConferenceCallsRepository> paramProvider40, Provider<com.google.d.f> paramProvider41, Provider<IRingtonePlayer> paramProvider42, Provider<ISoundService> paramProvider43)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
    this.e = paramProvider4;
    this.f = paramProvider5;
    this.g = paramProvider6;
    this.h = paramProvider7;
    this.i = paramProvider8;
    this.j = paramProvider9;
    this.k = paramProvider10;
    this.l = paramProvider11;
    this.m = paramProvider12;
    this.n = paramProvider13;
    this.o = paramProvider14;
    this.p = paramProvider15;
    this.q = paramProvider16;
    this.r = paramProvider17;
    this.s = paramProvider18;
    this.t = paramProvider19;
    this.u = paramProvider20;
    this.v = paramProvider21;
    this.w = paramProvider22;
    this.x = paramProvider23;
    this.y = paramProvider24;
    this.z = paramProvider25;
    this.A = paramProvider26;
    this.B = paramProvider27;
    this.C = paramProvider28;
    this.D = paramProvider29;
    this.E = paramProvider30;
    this.F = paramProvider31;
    this.G = paramProvider32;
    this.H = paramProvider33;
    this.I = paramProvider34;
    this.J = paramProvider35;
    this.K = paramProvider36;
    this.L = paramProvider37;
    this.M = paramProvider38;
    this.N = paramProvider39;
    this.O = paramProvider40;
    this.P = paramProvider41;
    this.Q = paramProvider42;
    this.R = paramProvider43;
  }

  public static n a(Provider<Context> paramProvider, Provider<Handler> paramProvider1, Provider<Handler> paramProvider2, Provider<Handler> paramProvider3, Provider<Handler> paramProvider4, Provider<Handler> paramProvider5, Provider<Handler> paramProvider6, Provider<Handler> paramProvider7, Provider<Engine> paramProvider8, Provider<EngineDelegatesManager> paramProvider9, Provider<com.viber.voip.app.b> paramProvider10, Provider<EventBus> paramProvider11, Provider<ab> paramProvider12, Provider<UserManager> paramProvider13, Provider<af> paramProvider14, Provider<o> paramProvider15, Provider<bn> paramProvider16, Provider<com.viber.voip.util.d> paramProvider17, Provider<al> paramProvider18, Provider<ak> paramProvider19, Provider<com.viber.voip.messages.d.b> paramProvider20, Provider<com.viber.voip.analytics.g> paramProvider21, Provider<com.viber.voip.messages.extensions.c> paramProvider22, Provider<com.viber.voip.stickers.a.a> paramProvider23, Provider<ai> paramProvider24, Provider<CallHandler> paramProvider25, Provider<ap.a> paramProvider26, Provider<PhoneController> paramProvider27, Provider<ICdrController> paramProvider28, Provider<ap> paramProvider29, Provider<ActivationController> paramProvider30, Provider<Im2Exchanger> paramProvider31, Provider<com.viber.common.permission.c> paramProvider32, Provider<com.viber.voip.messages.extras.b.a> paramProvider33, Provider<m> paramProvider34, Provider<com.viber.voip.contacts.c.d.g> paramProvider35, Provider<com.viber.voip.messages.extensions.f> paramProvider36, Provider<e> paramProvider37, Provider<bs> paramProvider38, Provider<com.viber.voip.model.a.d> paramProvider39, Provider<ConferenceCallsRepository> paramProvider40, Provider<com.google.d.f> paramProvider41, Provider<IRingtonePlayer> paramProvider42, Provider<ISoundService> paramProvider43)
  {
    return new n(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9, paramProvider10, paramProvider11, paramProvider12, paramProvider13, paramProvider14, paramProvider15, paramProvider16, paramProvider17, paramProvider18, paramProvider19, paramProvider20, paramProvider21, paramProvider22, paramProvider23, paramProvider24, paramProvider25, paramProvider26, paramProvider27, paramProvider28, paramProvider29, paramProvider30, paramProvider31, paramProvider32, paramProvider33, paramProvider34, paramProvider35, paramProvider36, paramProvider37, paramProvider38, paramProvider39, paramProvider40, paramProvider41, paramProvider42, paramProvider43);
  }

  public l a()
  {
    return new l((Context)this.a.get(), (Handler)this.b.get(), (Handler)this.c.get(), (Handler)this.d.get(), (Handler)this.e.get(), (Handler)this.f.get(), (Handler)this.g.get(), (Handler)this.h.get(), (Engine)this.i.get(), (EngineDelegatesManager)this.j.get(), (com.viber.voip.app.b)this.k.get(), (EventBus)this.l.get(), (ab)this.m.get(), (UserManager)this.n.get(), (af)this.o.get(), (o)this.p.get(), (bn)this.q.get(), (com.viber.voip.util.d)this.r.get(), (al)this.s.get(), (ak)this.t.get(), (com.viber.voip.messages.d.b)this.u.get(), (com.viber.voip.analytics.g)this.v.get(), (com.viber.voip.messages.extensions.c)this.w.get(), (com.viber.voip.stickers.a.a)this.x.get(), (ai)this.y.get(), (CallHandler)this.z.get(), (ap.a)this.A.get(), (PhoneController)this.B.get(), (ICdrController)this.C.get(), (ap)this.D.get(), (ActivationController)this.E.get(), (Im2Exchanger)this.F.get(), (com.viber.common.permission.c)this.G.get(), (com.viber.voip.messages.extras.b.a)this.H.get(), dagger.a.c.b(this.I), dagger.a.c.b(this.J), dagger.a.c.b(this.K), dagger.a.c.b(this.L), dagger.a.c.b(this.M), dagger.a.c.b(this.N), dagger.a.c.b(this.O), dagger.a.c.b(this.P), dagger.a.c.b(this.Q), dagger.a.c.b(this.R));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.n
 * JD-Core Version:    0.6.2
 */