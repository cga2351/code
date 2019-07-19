package com.viber.voip.messages.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.bot.item.BotKeyboardItem;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.viewbinders.ah;
import com.viber.voip.messages.conversation.adapter.viewbinders.ap;
import com.viber.voip.messages.conversation.ui.bs;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.stickers.ui.a.a;
import com.viber.voip.widget.AvatarWithInitialsView;
import java.util.ArrayList;
import java.util.List;

public class x extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();
  private final LayoutInflater b;
  private List<c> c = new ArrayList();
  private final f d;
  private int e;
  private int f;
  private final com.viber.voip.messages.conversation.adapter.e.b g;
  private int h;
  private int i;
  private com.viber.voip.messages.conversation.adapter.a.a j;
  private i k;
  private boolean l;
  private final com.viber.voip.bot.a.e m;
  private boolean n;
  private final int o;

  public x(Context paramContext, com.viber.voip.messages.conversation.adapter.e.b paramb, boolean paramBoolean, com.viber.voip.bot.a.e parame, LayoutInflater paramLayoutInflater)
  {
    this.g = paramb;
    this.b = paramLayoutInflater;
    this.m = parame;
    this.d = new f(paramContext, parame);
    this.l = paramBoolean;
    this.o = paramContext.getResources().getDimensionPixelOffset(R.dimen.rich_message_name_bottom_margin);
  }

  private void a(int paramInt, View[] paramArrayOfView)
  {
    int i1 = paramArrayOfView.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramArrayOfView[i2].getLayoutParams();
      localLayoutParams.addRule(5, paramInt);
      localLayoutParams.addRule(7, paramInt);
    }
  }

  private void a(ViewGroup paramViewGroup, com.viber.voip.stickers.ui.d paramd, View paramView1, View paramView2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramd.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(localLayoutParams.width, localLayoutParams.height);
    localLayoutParams1.addRule(3, R.id.referralView);
    paramd.setLayoutParams(localLayoutParams1);
    paramd.setId(R.id.rich_message_grid_id);
    paramViewGroup.addView(paramd);
    a(paramd.getId(), new View[] { paramView1, paramView2 });
  }

  private void a(com.viber.voip.bot.item.b<BotKeyboardItem>[] paramArrayOfb)
  {
    this.c = b(paramArrayOfb);
    int i1;
    int i3;
    int i4;
    label30: int i5;
    if (this.l)
    {
      i1 = this.e;
      int i2 = paramArrayOfb.length;
      i3 = 0;
      i4 = i1;
      if (i3 >= i2)
        break label72;
      i5 = paramArrayOfb[i3].a().size();
      if (i5 <= i4)
        break label79;
    }
    while (true)
    {
      i3++;
      i4 = i5;
      break label30;
      i1 = 0;
      break;
      label72: this.e = i4;
      return;
      label79: i5 = i4;
    }
  }

  private ArrayList<c> b(com.viber.voip.bot.item.b<BotKeyboardItem>[] paramArrayOfb)
  {
    if (this.n);
    ArrayList localArrayList;
    for (int i1 = 1; ; i1 = 2)
    {
      localArrayList = new ArrayList(i1 + paramArrayOfb.length);
      int i2 = paramArrayOfb.length;
      for (int i3 = 0; i3 < i2; i3++)
        localArrayList.add(new c(paramArrayOfb[i3]));
    }
    if (this.n)
    {
      localArrayList.add(0, new c(new e(null)));
      return localArrayList;
    }
    localArrayList.add(0, new c(new b(null)));
    localArrayList.add(new c(new e(null)));
    return localArrayList;
  }

  public int a()
  {
    return this.e;
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.a parama, i parami)
  {
    this.j = parama;
    this.n = parama.c().ap();
    this.k = parami;
    com.viber.voip.messages.conversation.aa localaa = parama.c();
    BotReplyConfig localBotReplyConfig = localaa.bx().getPublicAccountMsgInfo().getRichMedia();
    if (localBotReplyConfig == null);
    int i1;
    ReplyButton[] arrayOfReplyButton;
    do
    {
      return;
      this.f = localBotReplyConfig.getBgColor().intValue();
      this.h = localBotReplyConfig.getButtonsGroupColumns();
      this.i = (2 * this.h);
      this.d.a(localBotReplyConfig.getHeightScalePercent() / 100.0F);
      com.viber.voip.bot.item.c localc1 = localaa.bB();
      if (localc1 != null)
      {
        this.f = localBotReplyConfig.getBgColor().intValue();
        a(localc1.a());
        return;
      }
      i1 = localBotReplyConfig.getButtonsGroupRows();
      arrayOfReplyButton = localBotReplyConfig.getButtons();
    }
    while ((arrayOfReplyButton == null) || (i1 <= 0) || (this.h <= 0));
    ArrayList localArrayList = new ArrayList(arrayOfReplyButton.length);
    int i2 = arrayOfReplyButton.length;
    for (int i3 = 0; i3 < i2; i3++)
      localArrayList.add(new BotKeyboardItem(arrayOfReplyButton[i3]));
    new com.viber.voip.bot.item.d(i1, this.h).a(localArrayList);
    com.viber.voip.bot.item.c localc2 = new com.viber.voip.bot.item.c(localArrayList, this.h);
    localaa.a(localc2);
    a(localc2.a());
  }

  public int getItemCount()
  {
    return this.c.size();
  }

  public int getItemViewType(int paramInt)
  {
    int i1 = getItemCount();
    if (((c)this.c.get(paramInt)).c())
      return 5;
    if (((c)this.c.get(paramInt)).b())
      return 4;
    if (((!this.n) && (i1 == 3)) || ((this.n) && (i1 == 2)))
      return 3;
    if (paramInt == 1)
      return 1;
    if (((!this.n) && (paramInt == i1 - 2)) || ((this.n) && (paramInt == i1 - 1)))
      return 2;
    return 0;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (getItemViewType(paramInt) == 4)
    {
      ((d)paramViewHolder).a.a(this.j, this.k);
      return;
    }
    if (getItemViewType(paramInt) == 5)
    {
      ((a)paramViewHolder).a.a(this.j, this.k);
      return;
    }
    if (this.j != null);
    for (long l1 = this.j.c().a(); ; l1 = 0L)
    {
      g localg = ((h)paramViewHolder).a;
      localg.c(this.f);
      localg.a(this.j);
      localg.a(((c)this.c.get(paramInt)).a(), paramInt, getItemCount(), l1, this.i, this.m);
      return;
    }
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 4)
      return new d(this.b.inflate(R.layout.rich_message_like_view, paramViewGroup, false));
    if (paramInt == 5)
      return new a(this.b.inflate(R.layout.rich_message_avatar_view, paramViewGroup, false).findViewById(R.id.avatarContainer), this.g.e());
    ViewGroup localViewGroup = (ViewGroup)this.b.inflate(R.layout.rich_message_content_item, paramViewGroup, false);
    TextView localTextView1 = (TextView)localViewGroup.findViewById(R.id.contactName);
    ah localah = new ah(localTextView1);
    TextView localTextView2 = (TextView)localViewGroup.findViewById(R.id.referralView);
    ap localap = new ap(localTextView2, this.g.D());
    g localg = new g(this.b, this.d, localViewGroup, this.e, this.g.c(), new bs(this.g.q()), this.f, paramInt, this.m, this.k, localTextView1, localah, this.o, localTextView2, localap);
    localg.a();
    a(localViewGroup, localg.b, localTextView1, localTextView2);
    return new h(localg, localViewGroup);
  }

  private class a extends RecyclerView.ViewHolder
  {
    com.viber.voip.messages.conversation.adapter.viewbinders.b a;

    a(View paramf, com.viber.voip.messages.conversation.adapter.d.f arg3)
    {
      super();
      com.viber.voip.messages.conversation.adapter.d.f localf;
      this.a = new com.viber.voip.messages.conversation.adapter.viewbinders.b((AvatarWithInitialsView)paramf.findViewById(R.id.avatarView), paramf.findViewById(R.id.adminIndicatorView), localf);
    }
  }

  private class b
  {
    private b()
    {
    }
  }

  private class c
  {
    x.b a;
    x.e b;
    com.viber.voip.bot.item.b<BotKeyboardItem> c;

    c()
    {
      Object localObject;
      this.c = localObject;
    }

    c(x.b arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    c(x.e arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    com.viber.voip.bot.item.b<BotKeyboardItem> a()
    {
      return this.c;
    }

    boolean b()
    {
      return this.b != null;
    }

    boolean c()
    {
      return this.a != null;
    }
  }

  private class d extends RecyclerView.ViewHolder
  {
    com.viber.voip.messages.conversation.adapter.viewbinders.aa a;

    d(View arg2)
    {
      super();
      this.a = new com.viber.voip.messages.conversation.adapter.viewbinders.aa((AnimatedLikesView)localView, x.a(x.this).f());
    }
  }

  private class e
  {
    private e()
    {
    }
  }

  private static class f extends com.viber.voip.stickers.ui.a<BotKeyboardItem>
  {
    protected float a = 1.0F;
    private final com.viber.voip.bot.a.e d;

    f(Context paramContext, com.viber.voip.bot.a.e parame)
    {
      super();
      this.d = parame;
    }

    protected a.a a()
    {
      a.a locala = new a.a();
      int i = this.d.f();
      locala.f(this.d.e());
      locala.e(this.d.e() * this.a);
      locala.a(i);
      return locala;
    }

    public void a(float paramFloat)
    {
      if (paramFloat != this.a)
      {
        this.a = paramFloat;
        e();
      }
    }
  }

  private static class g extends f
  {
    private int i;
    private int j = 0;
    private int k;
    private com.viber.voip.messages.conversation.adapter.a.a l;
    private final View.OnCreateContextMenuListener m;
    private final bs n;
    private final com.viber.voip.bot.a.e o;
    private final View p;
    private final com.viber.voip.ui.g.d q;
    private final int r;
    private final View s;
    private final com.viber.voip.ui.g.d t;
    private final i u;
    private ViewGroup v;

    g(LayoutInflater paramLayoutInflater, com.viber.voip.stickers.ui.a parama, ViewGroup paramViewGroup, int paramInt1, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, bs parambs, int paramInt2, int paramInt3, com.viber.voip.bot.a.e parame, i parami, View paramView1, com.viber.voip.ui.g.d paramd1, int paramInt4, View paramView2, com.viber.voip.ui.g.d paramd2)
    {
      super(parama, paramViewGroup, paramInt1, parambs, 2);
      this.i = paramInt2;
      this.k = paramInt3;
      this.m = paramOnCreateContextMenuListener;
      this.n = parambs;
      this.o = parame;
      this.p = paramView1;
      this.q = paramd1;
      this.r = paramInt4;
      this.s = paramView2;
      this.t = paramd2;
      this.u = parami;
      this.v = paramViewGroup;
    }

    protected com.viber.voip.stickers.ui.d a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      this.j = 0;
      Object localObject;
      if (this.k == 0)
        localObject = new com.viber.voip.stickers.ui.d(paramViewGroup.getContext());
      while (true)
      {
        ((com.viber.voip.stickers.ui.d)localObject).setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ((com.viber.voip.stickers.ui.d)localObject).setBackgroundColor(this.i);
        return localObject;
        localObject = new com.viber.voip.widget.aa(paramViewGroup.getContext());
        ((com.viber.voip.widget.aa)localObject).setCornerRadiusPx(this.o.g());
        if (this.k == 1)
        {
          ((com.viber.voip.widget.aa)localObject).setRoundMode(1);
          this.j = 5;
        }
        else if (this.k == 2)
        {
          ((com.viber.voip.widget.aa)localObject).setRoundMode(2);
          this.j = 10;
        }
        else
        {
          ((com.viber.voip.widget.aa)localObject).setRoundMode(0);
          this.j = 15;
        }
      }
    }

    public void a(com.viber.voip.bot.item.b<BotKeyboardItem> paramb, int paramInt1, int paramInt2, long paramLong, int paramInt3, c paramc)
    {
      super.a(paramb, paramInt1, paramInt2, paramLong, paramInt3, paramc);
      boolean bool1;
      boolean bool2;
      int i6;
      label262: int i3;
      if (this.l != null)
      {
        com.viber.voip.messages.conversation.aa localaa = this.l.c();
        this.n.a(localaa);
        BotReplyConfig localBotReplyConfig = localaa.bx().getPublicAccountMsgInfo().getRichMedia();
        int i1 = (int)this.f.c(localBotReplyConfig.getButtonsGroupColumns());
        int i2 = (int)this.f.d(localBotReplyConfig.getButtonsGroupRows());
        this.b.setForeground(this.o.a(this.j, i1, i2));
        ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
        if ((localLayoutParams.width != i1) || (localLayoutParams.height != i2))
        {
          localLayoutParams.width = i1;
          localLayoutParams.height = i2;
          this.b.invalidate();
        }
        bool1 = this.l.q();
        bool2 = this.l.c().bO();
        if (bool1)
        {
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.p.getLayoutParams();
          if (bool2)
          {
            i6 = 0;
            localMarginLayoutParams.bottomMargin = i6;
          }
        }
        else
        {
          if ((this.k != 1) && (this.k != 3))
            break label332;
          this.q.a(this.l, this.u);
          this.t.a(this.l, this.u);
          if (((this.k != 2) && (this.k != 3)) || (paramInt1 != paramInt2 - 1))
            break label406;
          i3 = this.o.h();
          label294: this.v.setPadding(0, 0, i3, 0);
        }
      }
      while (true)
      {
        this.n.a(paramInt1);
        this.n.b(paramInt2);
        return;
        i6 = this.r;
        break;
        label332: if ((this.k != 0) && (this.k != 2))
          break label262;
        View localView1 = this.p;
        int i4;
        label361: View localView2;
        if (bool1)
        {
          i4 = 4;
          localView1.setVisibility(i4);
          localView2 = this.s;
          if (!bool2)
            break label399;
        }
        label399: for (int i5 = 4; ; i5 = 8)
        {
          localView2.setVisibility(i5);
          break;
          i4 = 8;
          break label361;
        }
        label406: i3 = 0;
        break label294;
        this.n.a(null);
      }
    }

    public void a(com.viber.voip.messages.conversation.adapter.a.a parama)
    {
      this.l = parama;
    }

    protected void a(com.viber.voip.stickers.ui.d paramd, int paramInt1, int paramInt2)
    {
      paramd.setPadding(0, 0, 0, 0);
    }

    protected com.viber.voip.bot.a.a b(ViewGroup paramViewGroup)
    {
      com.viber.voip.bot.a.a locala = super.b(paramViewGroup);
      locala.c.setOnCreateContextMenuListener(this.m);
      locala.c.setOnClickListener(new y(this, locala));
      return locala;
    }

    public void c(int paramInt)
    {
      if (this.i != paramInt)
      {
        this.i = paramInt;
        this.b.setBackgroundColor(this.i);
      }
    }
  }

  private class h extends RecyclerView.ViewHolder
  {
    public x.g a;

    h(x.g paramView, View arg3)
    {
      super();
      this.a = paramView;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.x
 * JD-Core Version:    0.6.2
 */