package com.viber.voip.messages.conversation.adapter.a.c.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.LongSparseArray;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.plurals;
import com.viber.voip.R.string;
import com.viber.voip.backgrounds.m;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.e.h.a;
import com.viber.voip.messages.conversation.adapter.x;
import com.viber.voip.messages.conversation.ah;
import com.viber.voip.messages.j;
import com.viber.voip.messages.j.a;
import com.viber.voip.util.at;
import com.viber.voip.util.cj;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.p;

public abstract class i extends com.viber.voip.ui.g.a.a
  implements com.viber.voip.messages.conversation.adapter.a.c.a
{
  private Drawable A;
  private Drawable B;
  private Drawable C;
  private BitmapDrawable D;
  private Drawable E;
  private Drawable F;
  private Drawable G;
  private Drawable H;
  private Drawable I;
  private Drawable J;
  private Drawable K;
  private Drawable L;
  private Drawable M;
  private Drawable N;
  private Drawable O;
  private Drawable P;
  private Drawable Q;
  private Drawable R;
  private Drawable S;
  private Drawable T;
  private Drawable U;
  private int V;
  private int W;
  private int X;
  private a Y;
  private d Z;
  protected int a;
  private final x aA;
  private final ah aB;
  private a aC;
  private a aD;
  private a aE;
  private final j aF;
  private final com.viber.voip.messages.controller.ai aG;
  private final com.viber.voip.messages.conversation.adapter.b.a aH;
  private Spannable aI;
  private ShapeDrawable aJ;
  private final float aK;
  private final float aL;
  private final b aM;
  private final dagger.a<Boolean> aN;
  private final dagger.a<ConversationItemLoaderEntity> aO;
  private h aa;
  private long ab = -1L;
  private long ac = -1L;
  private String ad;
  private int ae = -1;
  private boolean af = false;
  private boolean ag = true;
  private boolean ah = true;
  private boolean ai;
  private boolean aj;
  private boolean ak = false;
  private LongSparseArray<Integer> al = new LongSparseArray();
  private b am = new b(null);
  private int an;
  private final int ao;
  private final int ap;
  private final int aq;
  private final int ar;
  private int as = -1;
  private boolean at;
  private SparseArray<ColorStateList> au = new SparseArray();
  private boolean av = true;
  private long aw;
  private final e ax;
  private final com.viber.voip.messages.d.b ay;
  private final com.viber.voip.messages.ui.ai az;
  protected Drawable b;
  protected Drawable c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  public final int n;
  public final int o;
  public final int p;
  public final int q;
  public final int r;
  public final int s;
  public final int t;
  public final int u;
  private final String w;
  private boolean x;
  private Drawable y;
  private Drawable z;

  public i(Context paramContext, e parame, com.viber.voip.messages.d.b paramb, com.viber.voip.messages.ui.ai paramai, x paramx, j paramj, ah paramah, com.viber.voip.messages.controller.ai paramai1, boolean paramBoolean, com.viber.voip.messages.conversation.adapter.b.a parama, dagger.a<Boolean> parama1, dagger.a<ConversationItemLoaderEntity> parama2)
  {
    super(paramContext);
    this.ax = parame;
    this.ay = paramb;
    this.az = paramai;
    this.aA = paramx;
    this.aB = paramah;
    this.aG = paramai1;
    this.x = paramBoolean;
    this.aH = parama;
    this.aN = parama1;
    this.aO = parama2;
    Resources localResources = this.v.getResources();
    this.aF = paramj;
    this.w = localResources.getString(R.string.message_type_location);
    this.i = localResources.getDimensionPixelSize(R.dimen.conversation_user_photo_size);
    this.j = localResources.getDimensionPixelSize(R.dimen.sent_via_reserved_height);
    this.ao = ContextCompat.getColor(paramContext, R.color.solid_40);
    this.ap = ContextCompat.getColor(paramContext, R.color.negative);
    this.aq = ContextCompat.getColor(paramContext, R.color.link_text);
    this.ar = ContextCompat.getColor(paramContext, R.color.url_span_color);
    this.W = ContextCompat.getColor(paramContext, R.color.msg_list_date_header_text_color);
    this.Y = new a(paramContext);
    this.Z = new d(paramContext);
    this.aa = new h(this.v, this);
    this.at = cj.b(this.v);
    this.V = localResources.getDimensionPixelOffset(R.dimen.referral_icon_top_inset);
    this.r = localResources.getDimensionPixelOffset(R.dimen.reply_message_balloon_thumb_margin);
    this.n = localResources.getDimensionPixelSize(R.dimen.reply_balloon_area_height);
    this.o = localResources.getDimensionPixelOffset(R.dimen.reply_message_balloon_location_thumb_width);
    this.p = localResources.getDimensionPixelOffset(R.dimen.reply_message_balloon_file_thumb_width);
    this.q = localResources.getDimensionPixelOffset(R.dimen.reply_message_balloon_default_thumb_width);
    this.s = localResources.getDimensionPixelOffset(R.dimen.message_balloon_side_padding);
    this.aK = localResources.getDimensionPixelOffset(R.dimen.balloon_view_corner_radius);
    this.aL = localResources.getDimensionPixelOffset(R.dimen.msg_list_deleted_msg_bg_corner_radius);
    if (dc.a());
    for (Object localObject = new f(ContextCompat.getColor(paramContext, R.color.solid), this.ap, ContextCompat.getColor(paramContext, R.color.msu_green)); ; localObject = new b()
    {
      public int a(int paramAnonymousInt)
      {
        return c.a(this, paramAnonymousInt);
      }
    })
    {
      this.aM = ((b)localObject);
      this.X = dc.d(this.v, R.attr.conversationListItemIconTintColor);
      this.t = localResources.getDimensionPixelSize(R.dimen.location_touch_area);
      this.u = localResources.getDimensionPixelSize(R.dimen.forward_touch_area);
      return;
    }
  }

  private Drawable a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
      return null;
    return df.a(paramDrawable, dc.d(this.v, R.attr.messageBalloonItemTimestampTextColor), true);
  }

  private com.viber.voip.messages.ui.a.c aE()
  {
    Drawable[] arrayOfDrawable = new Drawable[4];
    arrayOfDrawable[0] = an();
    arrayOfDrawable[1] = ao();
    arrayOfDrawable[2] = ap();
    arrayOfDrawable[3] = aq();
    return new com.viber.voip.messages.ui.a.b(arrayOfDrawable);
  }

  private int b(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default:
      if (paramBoolean)
        return R.drawable.reply_balloon_image_incoming;
      break;
    case 9:
      if (paramBoolean)
        return R.drawable.reply_balloon_contact_incoming;
      return R.drawable.reply_balloon_contact_outgoing;
    }
    return R.drawable.reply_balloon_image_outgoing;
  }

  private Drawable b(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, 0, this.V, 0, 0);
  }

  public boolean A()
  {
    return this.av;
  }

  public long B()
  {
    return this.aw;
  }

  public int C()
  {
    return 570425344;
  }

  public int D()
  {
    return 178;
  }

  public boolean E()
  {
    return !dj.c(this.v);
  }

  public a F()
  {
    return this.Y;
  }

  public int G()
  {
    return this.W;
  }

  public Drawable H()
  {
    if (this.D == null)
    {
      this.D = new BitmapDrawable(this.v.getResources(), BitmapFactory.decodeResource(this.v.getResources(), R.drawable.bg_load_more_button_tile));
      this.D.setTileModeX(Shader.TileMode.REPEAT);
    }
    return this.D;
  }

  public a I()
  {
    if (m.b(this.v, l()))
      return J();
    return L();
  }

  public a J()
  {
    if (this.aD == null)
      this.aD = new a(m.a(this.v), 0.0F, 0.0F, 0.0F, 0, true);
    return this.aD;
  }

  public a K()
  {
    if (this.aE == null)
      this.aE = new a(dc.d(this.v, R.attr.messageBalloonItemTimestampTextColor), 0.0F, 0.0F, 0.0F, 0, true);
    return this.aE;
  }

  public a L()
  {
    if (this.aC == null)
      this.aC = new a(this.ap, 1.0F, 0.0F, 1.0F, s(), false);
    return this.aC;
  }

  public Drawable M()
  {
    if (m.b(this.v, l()))
      return O();
    return P();
  }

  public Drawable N()
  {
    if (this.A == null)
    {
      this.A = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_location_white);
      this.A = a(this.A);
    }
    return this.A;
  }

  public Drawable O()
  {
    if (this.y == null)
    {
      this.y = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_location_white);
      int i1 = m.a(this.v);
      this.y = df.a(this.y, i1, true);
    }
    return this.y;
  }

  public Drawable P()
  {
    if (this.z == null)
      this.z = ContextCompat.getDrawable(this.v, R.drawable.ic_location_white);
    return this.z;
  }

  public Drawable Q()
  {
    if (m.b(this.v, l()))
      return R();
    return S();
  }

  public Drawable R()
  {
    if (this.b == null)
    {
      this.b = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_broadcast_white);
      this.b = a(this.b);
    }
    return this.b;
  }

  public Drawable S()
  {
    if (this.c == null)
      this.c = ContextCompat.getDrawable(this.v, R.drawable.broadcast_list_icon_white);
    return this.c;
  }

  public e T()
  {
    return this.ax;
  }

  public com.viber.voip.messages.d.b U()
  {
    return this.ay;
  }

  public com.viber.voip.messages.ui.ai V()
  {
    return this.az;
  }

  public x W()
  {
    return this.aA;
  }

  public int X()
  {
    return this.X;
  }

  public ColorStateList Y()
  {
    if (this.X == 0)
      return null;
    return ColorStateList.valueOf(this.X);
  }

  public Drawable Z()
  {
    if (this.Q == null)
      this.Q = df.a(ContextCompat.getDrawable(this.v, R.drawable.voice_msg_control_play), dc.f(this.v, R.attr.conversationPttControlIconTintColor), false);
    return this.Q;
  }

  public Uri a(j.a parama, aa paramaa)
  {
    if (parama.c)
    {
      Uri localUri1 = parama.d;
      Uri localUri2 = null;
      if (localUri1 != null)
        localUri2 = parama.d;
      return localUri2;
    }
    return U().a(paramaa.u());
  }

  public com.viber.voip.messages.conversation.adapter.e.h<Integer> a(long paramLong, Integer[] paramArrayOfInteger)
  {
    return this.am.a(paramLong, paramArrayOfInteger);
  }

  public com.viber.voip.util.e.f a(int paramInt1, int paramInt2)
  {
    return this.Z.a(paramInt1, paramInt2);
  }

  public com.viber.voip.util.e.f a(int paramInt, boolean paramBoolean)
  {
    return com.viber.voip.util.e.f.c().f().b(Integer.valueOf(b(paramInt, paramBoolean))).c();
  }

  public com.viber.voip.util.e.f a(aa paramaa)
  {
    return a(paramaa, false);
  }

  public com.viber.voip.util.e.f a(aa paramaa, boolean paramBoolean)
  {
    if ((paramaa.aD()) || ((paramaa.ag()) && (!paramaa.ay())));
    for (int i1 = 1; ; i1 = 0)
    {
      d locald = this.Z;
      int i2 = paramaa.q();
      boolean bool1 = paramaa.W();
      boolean bool2;
      if (i1 == 0)
      {
        bool2 = false;
        if (!paramBoolean);
      }
      else
      {
        bool2 = true;
      }
      return locald.a(i2, bool1, bool2);
    }
  }

  public String a(String paramString)
  {
    return this.aF.k(paramString);
  }

  public void a(long paramLong)
  {
    this.ab = paramLong;
  }

  public void a(long paramLong, String paramString)
  {
    this.ac = paramLong;
    this.ad = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.at = paramBoolean;
  }

  public boolean a(int paramInt)
  {
    if (this.ae != paramInt)
    {
      this.ae = paramInt;
      return true;
    }
    return false;
  }

  public LongSparseArray<Integer> aA()
  {
    return this.al;
  }

  public com.viber.voip.messages.conversation.adapter.b.a aB()
  {
    return this.aH;
  }

  public dagger.a<ConversationItemLoaderEntity> aC()
  {
    return this.aO;
  }

  public dagger.a<Boolean> aD()
  {
    return this.aN;
  }

  public Drawable aa()
  {
    if (this.R == null)
      this.R = df.a(ContextCompat.getDrawable(this.v, R.drawable.voice_msg_control_play_unread), dc.f(this.v, R.attr.conversationPttControlUnreadIconTintColor), false);
    return this.R;
  }

  public Drawable ab()
  {
    if (this.S == null)
      this.S = df.a(ContextCompat.getDrawable(this.v, R.drawable.voice_msg_control_pause), dc.f(this.v, R.attr.conversationPttControlIconTintColor), false);
    return this.S;
  }

  public Drawable ac()
  {
    if (this.T == null)
    {
      int i1 = dc.a(this.v, R.attr.conversationReferralIcon);
      this.T = b(ContextCompat.getDrawable(this.v, i1));
    }
    return this.T;
  }

  public Drawable ad()
  {
    if (this.U == null)
      this.U = b(ContextCompat.getDrawable(this.v, R.drawable.ic_referral_arrow_white));
    return this.U;
  }

  public Drawable ae()
  {
    return dc.g(this.v, R.attr.conversationMissedCallRedialBackground);
  }

  public Drawable af()
  {
    return dc.g(this.v, R.attr.conversationRegularCallRedialBackground);
  }

  public h ag()
  {
    return this.aa;
  }

  public com.viber.voip.messages.ui.a.c ah()
  {
    if (m.b(this.v, l()))
      return aE();
    return aj();
  }

  public com.viber.voip.messages.ui.a.c ai()
  {
    Drawable[] arrayOfDrawable = new Drawable[4];
    arrayOfDrawable[0] = ak();
    arrayOfDrawable[1] = al();
    arrayOfDrawable[2] = am();
    arrayOfDrawable[3] = aq();
    return new com.viber.voip.messages.ui.a.b(arrayOfDrawable);
  }

  public com.viber.voip.messages.ui.a.c aj()
  {
    Drawable[] arrayOfDrawable = new Drawable[4];
    arrayOfDrawable[0] = ar();
    arrayOfDrawable[1] = as();
    arrayOfDrawable[2] = at();
    arrayOfDrawable[3] = au();
    return new com.viber.voip.messages.ui.a.a(arrayOfDrawable);
  }

  public Drawable ak()
  {
    if (this.N == null)
    {
      this.N = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_pending_status_white);
      this.N = a(this.N);
    }
    return this.N;
  }

  public Drawable al()
  {
    if (this.O == null)
    {
      this.O = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_sent_status_white);
      this.O = a(this.O);
    }
    return this.O;
  }

  public Drawable am()
  {
    if (this.P == null)
    {
      this.P = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_delivered_status_white);
      this.P = a(this.P);
    }
    return this.P;
  }

  public Drawable an()
  {
    if (this.E == null)
    {
      this.E = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_pending_status_white);
      int i1 = m.a(this.v);
      this.E = df.a(this.E, i1, true);
    }
    return this.E;
  }

  public Drawable ao()
  {
    if (this.F == null)
    {
      this.F = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_sent_status_white);
      int i1 = m.a(this.v);
      this.F = df.a(this.F, i1, true);
    }
    return this.F;
  }

  public Drawable ap()
  {
    if (this.G == null)
    {
      this.G = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_delivered_status_white);
      int i1 = m.a(this.v);
      this.G = df.a(this.G, i1, true);
    }
    return this.G;
  }

  public Drawable aq()
  {
    if (this.L == null)
    {
      this.L = android.support.v7.a.a.a.b(this.v, R.drawable.ic_message_balloon_item_delivered_status_white);
      int i1 = ContextCompat.getColor(this.v, R.color.medium_slate_blue);
      this.L = df.a(this.L, i1, true);
    }
    return this.L;
  }

  public Drawable ar()
  {
    if (this.H == null)
      this.H = android.support.v7.a.a.a.b(this.v, R.drawable.ic_status_pending_inverse);
    return this.H;
  }

  public Drawable as()
  {
    if (this.I == null)
      this.I = android.support.v7.a.a.a.b(this.v, R.drawable.ic_status_check_inverse);
    return this.I;
  }

  public Drawable at()
  {
    if (this.J == null)
      this.J = android.support.v7.a.a.a.b(this.v, R.drawable.ic_status_double_check_inverse);
    return this.J;
  }

  public Drawable au()
  {
    if (this.K == null)
      this.K = android.support.v7.a.a.a.b(this.v, R.drawable.ic_status_double_check_seen);
    return this.K;
  }

  public ah av()
  {
    return this.aB;
  }

  public com.viber.voip.messages.controller.ai aw()
  {
    return this.aG;
  }

  public Drawable ax()
  {
    if (this.M == null)
      this.M = dj.a(dc.d(this.v, R.attr.conversationNotificationBackgroundColor));
    return this.M;
  }

  public b ay()
  {
    return this.aM;
  }

  public Context az()
  {
    return this.v;
  }

  public j.a b(aa paramaa)
  {
    String str1;
    if (paramaa.ap())
    {
      str1 = this.v.getString(R.string.conversation_you);
      if (!paramaa.ba())
        break label87;
      if (!paramaa.ap())
        break label65;
    }
    label65: for (String str2 = this.v.getString(R.string.your_pinned_msg_notification); ; str2 = this.v.getString(R.string.unpinned_msg_notification, new Object[] { str1 }))
    {
      return new j.a(str2, true);
      str1 = paramaa.c(h());
      break;
    }
    label87: return this.aF.a(paramaa.h(), paramaa.A(), h(), str1);
  }

  public String b(String paramString)
  {
    return this.v.getResources().getString(R.string.share_screenshot_message_description_text, new Object[] { paramString });
  }

  public void b(int paramInt)
  {
    this.an = paramInt;
  }

  public void b(long paramLong)
  {
    this.aw = paramLong;
  }

  public void b(boolean paramBoolean)
  {
    this.af = paramBoolean;
  }

  public String c(aa paramaa)
  {
    return at.a(paramaa.bz().getFileSize());
  }

  public void c(int paramInt)
  {
    this.as = paramInt;
  }

  public void c(boolean paramBoolean)
  {
    this.aj = paramBoolean;
  }

  public boolean c(long paramLong)
  {
    return (e() > 0L) && (paramLong == e());
  }

  public com.viber.voip.messages.conversation.adapter.e.h<Integer> d(long paramLong)
  {
    return this.am.a(paramLong);
  }

  public com.viber.voip.util.e.f d(int paramInt)
  {
    return this.Z.b(paramInt);
  }

  public String d(aa paramaa)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramaa.m());
    return String.format("(%s)", arrayOfObject);
  }

  public void d(boolean paramBoolean)
  {
    this.ak = paramBoolean;
  }

  public boolean d()
  {
    return this.at;
  }

  public long e()
  {
    return this.ac;
  }

  public ColorStateList e(int paramInt)
  {
    ColorStateList localColorStateList = (ColorStateList)this.au.get(paramInt);
    int i1;
    if (localColorStateList == null)
    {
      i1 = 0;
      switch (paramInt)
      {
      default:
      case 1:
      case 0:
      case 3:
      case 4:
      case 5:
      case 2:
      }
    }
    while (true)
    {
      localColorStateList = dc.e(this.v, i1);
      this.au.put(paramInt, localColorStateList);
      return localColorStateList;
      i1 = R.attr.conversationBalloonErrorBackground;
      continue;
      i1 = R.attr.conversationBalloonIncomingBackground;
      continue;
      i1 = R.attr.conversationBalloonOutgoingBackground;
      continue;
      i1 = R.attr.conversationReplyOutgoingBackground;
      continue;
      i1 = R.attr.conversationReplyIncomingBackground;
      continue;
      i1 = R.attr.conversationWinkBalloonBackground;
    }
  }

  public CharSequence e(aa paramaa)
  {
    if ("answ_another_dev_group".equals(paramaa.h()))
      return this.v.getResources().getQuantityString(R.plurals.plural_msg_call_answered_on_another_device, paramaa.m());
    boolean bool = "missed_call_group".equals(paramaa.h());
    Resources localResources = this.v.getResources();
    if (bool);
    for (int i1 = R.plurals.plural_msg_group_call_missed; ; i1 = R.plurals.plural_msg_group_call_incoming)
    {
      int i2 = paramaa.m();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Html.escapeHtml(paramaa.bp());
      return Html.fromHtml(localResources.getQuantityString(i1, i2, arrayOfObject));
    }
  }

  public void e(long paramLong)
  {
    this.am.b(paramLong);
  }

  public void e(boolean paramBoolean)
  {
    this.ag = paramBoolean;
  }

  public Drawable f(int paramInt)
  {
    if (this.aJ == null)
      this.aJ = new ShapeDrawable(new com.viber.common.ui.a.a(this.v.getResources().getDimensionPixelSize(R.dimen.unread_messages_bubble_corner_radius), 15, this.v.getResources().getDimensionPixelSize(R.dimen.unread_messages_bubble_stroke_width)));
    this.aJ.getPaint().setColor(paramInt);
    return this.aJ;
  }

  public CharSequence f(aa paramaa)
  {
    if (paramaa.bL())
    {
      Resources localResources = this.v.getResources();
      int i1 = R.string.and_items;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = p.a(paramaa.bM(), paramaa.d());
      return localResources.getString(i1, arrayOfObject);
    }
    return "";
  }

  public String f()
  {
    return this.ad;
  }

  public void f(boolean paramBoolean)
  {
    this.ah = paramBoolean;
  }

  public long g()
  {
    return this.ab;
  }

  public void g(boolean paramBoolean)
  {
    this.ai = paramBoolean;
  }

  public int h()
  {
    return this.ae;
  }

  public void h(boolean paramBoolean)
  {
    this.av = paramBoolean;
  }

  public Drawable i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.C == null)
        this.C = ContextCompat.getDrawable(this.v, R.drawable.ic_rakuten_message);
      return this.C;
    }
    if (this.B == null)
      this.B = ContextCompat.getDrawable(this.v, R.drawable.icon_viber_message);
    return this.B;
  }

  public boolean i()
  {
    return this.x;
  }

  public float j(boolean paramBoolean)
  {
    if (paramBoolean)
      return this.aL;
    return this.aK;
  }

  public boolean j()
  {
    return this.af;
  }

  public boolean k()
  {
    return this.aj;
  }

  public int l()
  {
    return this.an;
  }

  public String m()
  {
    return this.w;
  }

  public boolean n()
  {
    return this.ak;
  }

  public boolean o()
  {
    return this.ag;
  }

  public boolean p()
  {
    return this.ah;
  }

  public boolean q()
  {
    return this.ai;
  }

  public int r()
  {
    return this.ap;
  }

  public int s()
  {
    return this.ao;
  }

  public int t()
  {
    return this.aq;
  }

  public int u()
  {
    return this.ar;
  }

  public Spannable v()
  {
    if (this.aI == null)
    {
      String str = this.v.getString(R.string.translated_by_google);
      this.aI = SpannableString.valueOf(str);
      int i1 = str.indexOf("Google");
      if (i1 >= 0)
        this.aI.setSpan(new com.viber.voip.ui.style.b(), i1, i1 + "Google".length(), 0);
    }
    return this.aI;
  }

  public int w()
  {
    return this.as;
  }

  public com.viber.voip.util.e.f x()
  {
    return this.Z.a(dc.a(this.v, R.attr.contactDefaultPhotoSmall));
  }

  public com.viber.voip.util.e.f y()
  {
    return this.Z.a();
  }

  public com.viber.voip.util.e.f z()
  {
    return this.Z.b();
  }

  public static class a
  {
    public final int a;
    public final float b;
    public final float c;
    public final float d;
    public final int e;
    public final boolean f;

    a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, boolean paramBoolean)
    {
      this.a = paramInt1;
      this.b = paramFloat1;
      this.c = paramFloat2;
      this.d = paramFloat3;
      this.e = paramInt2;
      this.f = paramBoolean;
    }

    public String toString()
    {
      return "BackgroundText{textColor=" + this.a + ", shadowRadius=" + this.b + ", shadowDx=" + this.c + ", shadowDy=" + this.d + ", shadowColor=" + this.e + ", isDefault=" + this.f + '}';
    }
  }

  private static class b
    implements h.a
  {
    private LongSparseArray<com.viber.voip.messages.conversation.adapter.e.h<Integer>> a = new LongSparseArray();

    com.viber.voip.messages.conversation.adapter.e.h<Integer> a(long paramLong)
    {
      return (com.viber.voip.messages.conversation.adapter.e.h)this.a.get(paramLong);
    }

    com.viber.voip.messages.conversation.adapter.e.h<Integer> a(long paramLong, Integer[] paramArrayOfInteger)
    {
      com.viber.voip.messages.conversation.adapter.e.h localh = new com.viber.voip.messages.conversation.adapter.e.h(null, paramLong, this, paramArrayOfInteger);
      localh.setDuration(400L);
      this.a.put(paramLong, localh);
      return localh;
    }

    void b(long paramLong)
    {
      this.a.remove(paramLong);
    }

    public void c(long paramLong)
    {
      b(paramLong);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.c.a.i
 * JD-Core Version:    0.6.2
 */