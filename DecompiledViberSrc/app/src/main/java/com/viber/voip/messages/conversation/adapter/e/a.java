package com.viber.voip.messages.conversation.adapter.e;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.common.ui.ShapeImageView;
import com.viber.voip.messages.controller.ca;
import com.viber.voip.messages.conversation.adapter.t;
import com.viber.voip.messages.conversation.adapter.viewbinders.aa;
import com.viber.voip.messages.conversation.adapter.viewbinders.ab;
import com.viber.voip.messages.conversation.adapter.viewbinders.ac;
import com.viber.voip.messages.conversation.adapter.viewbinders.ad;
import com.viber.voip.messages.conversation.adapter.viewbinders.ag;
import com.viber.voip.messages.conversation.adapter.viewbinders.ah;
import com.viber.voip.messages.conversation.adapter.viewbinders.aj;
import com.viber.voip.messages.conversation.adapter.viewbinders.ak;
import com.viber.voip.messages.conversation.adapter.viewbinders.am;
import com.viber.voip.messages.conversation.adapter.viewbinders.ap;
import com.viber.voip.messages.conversation.adapter.viewbinders.au;
import com.viber.voip.messages.conversation.adapter.viewbinders.av;
import com.viber.voip.messages.conversation.adapter.viewbinders.aw;
import com.viber.voip.messages.conversation.adapter.viewbinders.ax;
import com.viber.voip.messages.conversation.adapter.viewbinders.ay;
import com.viber.voip.messages.conversation.adapter.viewbinders.ba;
import com.viber.voip.messages.conversation.adapter.viewbinders.bb;
import com.viber.voip.messages.conversation.adapter.viewbinders.bc;
import com.viber.voip.messages.conversation.adapter.viewbinders.bg;
import com.viber.voip.messages.conversation.adapter.viewbinders.bh;
import com.viber.voip.messages.conversation.adapter.viewbinders.bi;
import com.viber.voip.messages.conversation.adapter.viewbinders.bj;
import com.viber.voip.messages.conversation.adapter.viewbinders.bk;
import com.viber.voip.messages.conversation.adapter.viewbinders.bl;
import com.viber.voip.messages.conversation.adapter.viewbinders.bm;
import com.viber.voip.messages.conversation.adapter.viewbinders.h;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm.FormattedMessageConstraintHelper;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.notification.NotificationBackgroundConstraintHelper;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.rm.RichMessageBottomConstraintHelper;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker.StickerClickerConstraintHelper;
import com.viber.voip.messages.conversation.adapter.viewbinders.k;
import com.viber.voip.messages.conversation.adapter.viewbinders.m;
import com.viber.voip.messages.conversation.adapter.viewbinders.n;
import com.viber.voip.messages.conversation.adapter.viewbinders.o;
import com.viber.voip.messages.conversation.adapter.viewbinders.p;
import com.viber.voip.messages.conversation.adapter.viewbinders.q;
import com.viber.voip.messages.conversation.adapter.viewbinders.v;
import com.viber.voip.messages.conversation.adapter.viewbinders.w;
import com.viber.voip.messages.conversation.adapter.viewbinders.x;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.messages.ui.view.AnimatedSoundIconView;
import com.viber.voip.messages.ui.view.AudioPttVolumeBarsView;
import com.viber.voip.stickers.ui.StickerSvgContainer;
import com.viber.voip.ui.bf;
import com.viber.voip.widget.AudioPttControlView;
import com.viber.voip.widget.AvatarWithInitialsView;
import com.viber.voip.widget.ClickGroup;
import com.viber.voip.widget.FileIconView;
import com.viber.voip.widget.FormattedMessageLayout;
import com.viber.voip.widget.PlayableImageView;
import com.viber.voip.widget.ProgressBar;
import com.viber.voip.widget.VideoPttMessageLayout;

public class a
{
  private final b a;
  private final com.viber.voip.messages.conversation.adapter.a.c.a.g b;
  private final com.viber.voip.messages.conversation.adapter.z<MessageType> c;
  private final com.viber.voip.messages.conversation.adapter.z<t> d;
  private final com.viber.voip.messages.extensions.c e;
  private final com.viber.voip.stickers.b f;
  private final com.viber.voip.stickers.i g;
  private final com.viber.voip.app.b h;
  private final com.viber.voip.stickers.f i;
  private final com.viber.voip.stickers.a.a j;
  private final com.viber.voip.ui.b.d k;
  private final com.viber.voip.widget.b.d l;
  private final com.viber.voip.messages.controller.ai m;
  private final ca n;
  private final com.viber.voip.messages.controller.y o;
  private final com.viber.voip.bot.e p;
  private final com.viber.voip.bot.b q;
  private final com.viber.voip.messages.conversation.ui.j r;
  private final com.viber.voip.bot.a.e s;
  private final com.viber.voip.q.i t;
  private final Handler u;
  private final com.viber.voip.messages.conversation.adapter.a.c.a.i v;

  public a(b paramb, com.viber.voip.messages.conversation.adapter.a.c.a.g paramg, com.viber.voip.messages.conversation.adapter.z<MessageType> paramz, com.viber.voip.messages.conversation.adapter.z<t> paramz1, com.viber.voip.messages.extensions.c paramc, com.viber.voip.stickers.b paramb1, com.viber.voip.stickers.i parami, com.viber.voip.app.b paramb2, com.viber.voip.stickers.f paramf, com.viber.voip.stickers.a.a parama, com.viber.voip.ui.b.d paramd, com.viber.voip.widget.b.d paramd1, com.viber.voip.messages.controller.ai paramai, ca paramca, com.viber.voip.messages.controller.y paramy, com.viber.voip.bot.a.e parame, com.viber.voip.bot.b paramb3, com.viber.voip.messages.conversation.ui.j paramj, com.viber.voip.q.i parami1, Handler paramHandler, com.viber.voip.messages.conversation.adapter.a.c.a.i parami2)
  {
    this.a = paramb;
    this.b = paramg;
    this.c = paramz;
    this.d = paramz1;
    this.e = paramc;
    this.f = paramb1;
    this.g = parami;
    this.h = paramb2;
    this.i = paramf;
    this.j = parama;
    this.k = paramd;
    this.l = paramd1;
    this.m = paramai;
    this.n = paramca;
    this.o = paramy;
    this.q = paramb3;
    this.r = paramj;
    this.s = parame;
    this.p = new com.viber.voip.bot.e(paramb.o());
    this.t = parami1;
    this.u = paramHandler;
    this.v = parami2;
  }

  public final bl a(ImageView paramImageView, AudioPttVolumeBarsView paramAudioPttVolumeBarsView, View paramView1, AudioPttControlView paramAudioPttControlView, TextView paramTextView, View paramView2)
  {
    return new bl(new bf(paramImageView, paramAudioPttVolumeBarsView, paramView1, paramAudioPttControlView, paramTextView, this.m, this.t, this.u, paramImageView.getContext(), this.a.z(), this.v.Z(), this.v.aa(), this.v.ab()), this.a.o(), new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.d(paramView2));
  }

  public final com.viber.voip.messages.conversation.adapter.viewbinders.r a(FileIconView paramFileIconView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.r(new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file.c(paramFileIconView, this.a.r()));
  }

  public final com.viber.voip.messages.conversation.adapter.viewbinders.y a(com.viber.voip.widget.al paramal, ShapeImageView paramShapeImageView, View paramView)
  {
    com.viber.voip.messages.conversation.adapter.viewbinders.y localy = new com.viber.voip.messages.conversation.adapter.viewbinders.y(paramShapeImageView, new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b.a());
    paramal.a(localy, paramView);
    return localy;
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(final RecyclerView paramRecyclerView, RichMessageBottomConstraintHelper paramRichMessageBottomConstraintHelper)
  {
    LinearLayoutManager local1 = new LinearLayoutManager(paramRecyclerView.getContext(), 0, false)
    {
      public void onLayoutChildren(RecyclerView.Recycler paramAnonymousRecycler, RecyclerView.State paramAnonymousState)
      {
        super.onLayoutChildren(paramAnonymousRecycler, paramAnonymousState);
        a.a(a.this).a(getItemCount(), findFirstCompletelyVisibleItemPosition(), findLastCompletelyVisibleItemPosition(), paramRecyclerView);
      }
    };
    com.viber.voip.bot.d locald = new com.viber.voip.bot.d(this.q, local1);
    return new aw(paramRecyclerView, this.a, local1, this.r, this.s, locald, paramRichMessageBottomConstraintHelper);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(View paramView)
  {
    return new au(paramView, this.a.x(), this.a.c()).a();
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(View paramView1, View paramView2)
  {
    return new ac(paramView1, paramView2);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(View paramView1, View paramView2, View paramView3, com.viber.voip.widget.b.c paramc)
  {
    return a(paramView1, paramView2, paramView3, paramc, null);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(View paramView1, View paramView2, View paramView3, com.viber.voip.widget.b.c paramc, RecyclerView paramRecyclerView)
  {
    com.viber.voip.widget.b.b localb = (com.viber.voip.widget.b.b)this.l.a(paramView1, this.a.F(), paramRecyclerView);
    k localk = new k(paramView1, paramView2, paramView3, this.a.b(), this.a.E(), paramc, this.a.o(), localb);
    com.viber.voip.messages.conversation.ui.a.r localr = new com.viber.voip.messages.conversation.ui.a.r();
    localr.a(this.a.b());
    localr.a(localk);
    localb.a(localr);
    return localk;
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(View paramView, com.viber.voip.messages.conversation.adapter.d.g paramg)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.c(paramView, new com.viber.voip.messages.conversation.adapter.a.b.a(), this.a.c(), paramg);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(ImageView paramImageView)
  {
    return new av(paramImageView, this.a.l());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(ImageView paramImageView, StickerClickerConstraintHelper paramStickerClickerConstraintHelper)
  {
    return new ba(paramImageView, paramStickerClickerConstraintHelper, this.k, this.j, this.a.t());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(ImageView paramImageView1, StickerSvgContainer paramStickerSvgContainer, ImageView paramImageView2, ProgressBar paramProgressBar, ClickGroup paramClickGroup, AnimatedSoundIconView paramAnimatedSoundIconView)
  {
    com.viber.voip.stickers.ui.f localf = new com.viber.voip.stickers.ui.f(this.i, paramImageView1, paramImageView2);
    com.viber.voip.ui.ae localae = new com.viber.voip.ui.ae(paramStickerSvgContainer, paramAnimatedSoundIconView, localf, this.h);
    return new bc(paramImageView1, paramStickerSvgContainer, paramImageView2, paramProgressBar, paramClickGroup, this.f, localf, localae, this.g, this.a.s(), this.h, this.a.c());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(ImageView paramImageView, com.viber.voip.widget.b.c paramc)
  {
    paramc.a(this.l.a(paramImageView, this.v.t));
    return new ad(paramImageView, this.a.g());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2, View paramView)
  {
    return new bm(paramLinearLayout, paramTextView1, paramTextView2, this.d, this.a.C(), new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f(paramView));
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(TextView paramTextView)
  {
    return new m(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(TextView paramTextView, View paramView)
  {
    return new bg(paramTextView, new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f(paramView));
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(TextView paramTextView1, TextView paramTextView2)
  {
    return new v(paramTextView1, paramTextView2);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(TextView paramTextView1, TextView paramTextView2, Button paramButton)
  {
    return new ax(paramTextView1, paramTextView2, paramButton, this.a.y());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.g(paramTextView1, paramTextView2, paramTextView3);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(NotificationBackgroundConstraintHelper paramNotificationBackgroundConstraintHelper)
  {
    return new aj(paramNotificationBackgroundConstraintHelper);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(AnimatedLikesView paramAnimatedLikesView)
  {
    return new aa(paramAnimatedLikesView, this.a.f());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(AnimatedSoundIconView paramAnimatedSoundIconView)
  {
    return new bb(paramAnimatedSoundIconView, this.f);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(AvatarWithInitialsView paramAvatarWithInitialsView, View paramView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.b(paramAvatarWithInitialsView, paramView, this.a.e());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(FormattedMessageLayout paramFormattedMessageLayout, FormattedMessageConstraintHelper paramFormattedMessageConstraintHelper, View paramView)
  {
    return new w(paramFormattedMessageLayout, paramFormattedMessageConstraintHelper, this.b, this.c, this.a, new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f(paramView), this.e);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(PlayableImageView paramPlayableImageView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.ae(paramPlayableImageView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> a(VideoPttMessageLayout paramVideoPttMessageLayout)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.z(paramVideoPttMessageLayout, this.a.c(), this.a.B());
  }

  public final com.viber.voip.messages.conversation.adapter.viewbinders.r b(FileIconView paramFileIconView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.r(new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a.c(paramFileIconView, this.a.n()), new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media.b(this.m, paramFileIconView.getContext()));
  }

  public final com.viber.voip.messages.conversation.adapter.viewbinders.y b(com.viber.voip.widget.al paramal, ShapeImageView paramShapeImageView, View paramView)
  {
    com.viber.voip.messages.conversation.adapter.viewbinders.y localy = new com.viber.voip.messages.conversation.adapter.viewbinders.y(paramShapeImageView, new com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a.a(this.o));
    paramal.a(localy, paramView);
    return localy;
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> b(View paramView)
  {
    return a(paramView, null);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> b(ImageView paramImageView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.e(paramImageView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> b(ImageView paramImageView, com.viber.voip.widget.b.c paramc)
  {
    paramc.a(this.l.a(paramImageView, this.v.u));
    return new x(paramImageView, this.a.h());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> b(TextView paramTextView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.ai(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> b(TextView paramTextView1, TextView paramTextView2)
  {
    return new bj(paramTextView1, paramTextView2);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> c(View paramView)
  {
    return a(paramView, this.a.d());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> c(ImageView paramImageView)
  {
    return new ag(paramImageView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> c(TextView paramTextView)
  {
    return new ab(paramTextView, this.a.a());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> d(View paramView)
  {
    return a(paramView, this.a.k());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> d(ImageView paramImageView)
  {
    return new am(paramImageView, this.k, this.n, this.a.t());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> d(TextView paramTextView)
  {
    return new ah(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> e(View paramView)
  {
    return a(paramView, this.a.i());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> e(ImageView paramImageView)
  {
    return new h(paramImageView, this.a.m());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> e(TextView paramTextView)
  {
    return new bi(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> f(View paramView)
  {
    return a(paramView, this.a.j());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> f(ImageView paramImageView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.d(paramImageView, this.a.c());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> f(TextView paramTextView)
  {
    return new bh(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> g(View paramView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.c(paramView, new com.viber.voip.messages.conversation.adapter.a.b.a());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> g(TextView paramTextView)
  {
    return new bk(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> h(View paramView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.f(paramView, this.a.m(), this.a.c());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> h(TextView paramTextView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.j(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> i(View paramView)
  {
    return new q(paramView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> i(TextView paramTextView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.i(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> j(TextView paramTextView)
  {
    return new n(paramTextView, this.a.c());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> k(TextView paramTextView)
  {
    return new o(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> l(TextView paramTextView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.al(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> m(TextView paramTextView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.al(paramTextView, this.a.d(), this.a.c());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> n(TextView paramTextView)
  {
    return new p(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> o(TextView paramTextView)
  {
    return new com.viber.voip.messages.conversation.adapter.viewbinders.a(paramTextView);
  }

  public final ay p(TextView paramTextView)
  {
    return new ay(paramTextView, this.e, this.a.p());
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> q(TextView paramTextView)
  {
    return new ak(paramTextView);
  }

  public final com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, com.viber.voip.messages.conversation.adapter.a.c.a.i> r(TextView paramTextView)
  {
    return new ap(paramTextView, this.a.D());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.a
 * JD-Core Version:    0.6.2
 */