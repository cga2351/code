package com.viber.voip.messages.conversation.adapter;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;
import com.viber.dexshared.Logger;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.aq;
import com.viber.voip.messages.conversation.ui.az;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.u.a.f.a;
import com.viber.voip.user.UserData;
import com.viber.voip.util.ae;
import com.viber.voip.util.da;
import com.viber.voip.widget.b;

public class d extends BaseAdapter
  implements AbsListView.RecyclerListener, f.a
{
  private static final Logger b = ViberEnv.getLogger();
  private final Runnable a = new e(this);
  private ConversationFragment c;
  private q d;
  private az e;
  private h f;
  private final a g;
  private com.viber.voip.messages.conversation.adapter.a.c.a.i h;
  private final com.viber.voip.messages.conversation.adapter.e.o i;
  private final Handler j;
  private final UserData k;
  private final com.viber.voip.messages.controller.manager.o l;
  private long m = 2000L;
  private boolean n;
  private final z o;
  private final z p;

  public d(ConversationFragment paramConversationFragment, LayoutInflater paramLayoutInflater, q paramq, az paramaz, a parama, x paramx, Handler paramHandler, com.viber.voip.messages.conversation.adapter.a.c.a.i parami, UserData paramUserData, com.viber.voip.messages.controller.manager.o paramo, z<MessageType> paramz, z<t> paramz1, com.viber.voip.messages.conversation.adapter.e.a parama1)
  {
    this.d = paramq;
    this.c = paramConversationFragment;
    this.e = paramaz;
    this.k = paramUserData;
    this.h = parami;
    this.g = parama;
    this.l = paramo;
    long[] arrayOfLong = new long[11];
    arrayOfLong[0] = R.id.newMessageHeaderView;
    arrayOfLong[1] = R.id.balloonView;
    arrayOfLong[2] = R.id.dateHeaderView;
    arrayOfLong[3] = R.id.loadMoreMessagesView;
    arrayOfLong[4] = R.id.loadingMessagesLabelView;
    arrayOfLong[5] = R.id.loadingMessagesAnimationView;
    arrayOfLong[6] = R.id.headersSpace;
    arrayOfLong[7] = R.id.selectionView;
    arrayOfLong[8] = R.id.avatarView;
    arrayOfLong[9] = R.id.likeView;
    arrayOfLong[10] = R.id.forwardView;
    this.i = new com.viber.voip.messages.conversation.adapter.e.o(parami, paramx, arrayOfLong);
    this.n = false;
    this.j = paramHandler;
    this.o = paramz;
    this.p = paramz1;
    this.f = new h(paramLayoutInflater, parama1);
  }

  private boolean a(aa paramaa)
  {
    return (this.h.p()) || ((paramaa != null) && ((paramaa.Z()) || (paramaa.aV())));
  }

  private boolean a(aa paramaa1, aa paramaa2)
  {
    if ((paramaa1 == null) || (paramaa2 == null) || (paramaa1.as()) || (paramaa2.as()) || (paramaa1.at()) || (paramaa2.at()) || (paramaa1.av()) || (paramaa2.av()) || (paramaa1.g() != paramaa2.g()))
      return false;
    if (paramaa1.ap())
      return true;
    if (paramaa1.ao())
    {
      String str1 = paramaa2.bq();
      if (da.a(str1))
        str1 = paramaa2.d();
      String str2 = paramaa1.bq();
      if (da.a(str2))
        str2 = paramaa1.d();
      String str3 = paramaa2.bs();
      if (da.a(str3))
        str3 = "";
      String str4 = paramaa1.bs();
      if (da.a(str4))
        str4 = "";
      if ((str2.equals(str1)) && (str4.equals(str3)) && (!paramaa2.bc()))
        return true;
    }
    return false;
  }

  private int b(aa paramaa)
  {
    int i1 = 16;
    if (paramaa == null)
      return 17;
    int i2 = paramaa.au();
    if (i2 >= 0)
      return i2;
    if (paramaa.as())
      i1 = 0;
    while (true)
    {
      paramaa.a(i1);
      return i1;
      if (paramaa.ba())
      {
        if (!this.n)
          i1 = 17;
      }
      else if (paramaa.bc())
      {
        if (!this.n)
          i1 = 17;
      }
      else if (paramaa.ao())
      {
        if (paramaa.an())
          i1 = 39;
        else if (paramaa.at())
          i1 = 33;
        else if ((paramaa.aY()) && (!paramaa.aj()) && (!paramaa.aF()) && (!paramaa.al()))
          i1 = 1;
        else if ((paramaa.aY()) && (paramaa.al()))
          i1 = 35;
        else if ((paramaa.aD()) && (paramaa.aA()))
          i1 = 22;
        else if ((paramaa.aD()) && (paramaa.az()))
          i1 = 20;
        else if (paramaa.aj())
          i1 = 31;
        else if (paramaa.ax())
          i1 = 9;
        else if (paramaa.aJ())
          i1 = 12;
        else if (paramaa.aK())
          i1 = 27;
        else if (paramaa.av())
          i1 = 11;
        else if ((paramaa.aE()) || (paramaa.aF()) || (paramaa.aL()))
          i1 = 14;
        else if (paramaa.aG())
          i1 = 18;
        else if (paramaa.aH())
          i1 = 25;
        else if (paramaa.bN())
          i1 = 37;
        else if (paramaa.az())
          i1 = 3;
        else if (paramaa.aA())
          i1 = 5;
        else if (paramaa.aZ())
          i1 = 29;
        else
          i1 = 7;
      }
      else if (paramaa.an())
        i1 = 40;
      else if (paramaa.at())
        i1 = 34;
      else if ((paramaa.aY()) && (!paramaa.aj()) && (!paramaa.aF()) && (!paramaa.al()))
        i1 = 2;
      else if ((paramaa.aY()) && (paramaa.al()))
        i1 = 36;
      else if ((paramaa.aD()) && (paramaa.bA()))
        i1 = 24;
      else if ((paramaa.aD()) && (paramaa.aA()))
        i1 = 23;
      else if ((paramaa.aD()) && (paramaa.az()))
        i1 = 21;
      else if (paramaa.aj())
        i1 = 32;
      else if (paramaa.ax())
        i1 = 10;
      else if (paramaa.aJ())
        i1 = 13;
      else if (paramaa.aK())
        i1 = 28;
      else if (paramaa.av())
        i1 = 11;
      else if ((paramaa.aE()) || (paramaa.aF()) || (paramaa.aL()))
        i1 = 15;
      else if (paramaa.aG())
        i1 = 19;
      else if (paramaa.aH())
        i1 = 26;
      else if (paramaa.bN())
        i1 = 38;
      else if (paramaa.az())
        i1 = 4;
      else if (paramaa.aA())
        i1 = 6;
      else if (paramaa.aZ())
        i1 = 30;
      else
        i1 = 8;
    }
  }

  private void b(long paramLong)
  {
    this.j.removeCallbacks(this.a);
    if (paramLong > -1L)
      this.j.postDelayed(this.a, paramLong);
  }

  public int a()
  {
    return this.d.y();
  }

  public void a(int paramInt)
  {
    this.h.c(paramInt);
    notifyDataSetChanged();
  }

  public void a(long paramLong)
  {
    if (this.h.g() != paramLong)
    {
      this.h.a(paramLong);
      notifyDataSetChanged();
    }
  }

  public void a(long paramLong1, String paramString, long paramLong2)
  {
    if ((paramLong1 != this.h.e()) || (!da.a(paramString, this.h.f())))
    {
      this.m = paramLong2;
      this.h.a(paramLong1, paramString);
      notifyDataSetChanged();
    }
  }

  public void a(Configuration paramConfiguration)
  {
    this.o.a();
    this.p.a();
  }

  public void a(boolean paramBoolean)
  {
    this.h.f(paramBoolean);
  }

  public com.viber.voip.messages.conversation.adapter.a.a b(int paramInt)
  {
    int i1 = getCount();
    aa localaa1 = this.d.f(paramInt - 1);
    aa localaa2 = this.d.f(paramInt);
    aa localaa3;
    long l1;
    label53: boolean bool1;
    label69: long l3;
    label130: boolean bool2;
    label141: boolean bool3;
    label176: boolean bool4;
    label199: boolean bool5;
    label232: boolean bool6;
    label246: boolean bool7;
    label260: boolean bool8;
    label274: int i2;
    label300: boolean bool14;
    boolean bool13;
    UserData localUserData2;
    boolean bool15;
    boolean bool16;
    if (i1 > paramInt + 1)
    {
      localaa3 = this.d.f(paramInt + 1);
      if (localaa2 != null)
        break label388;
      l1 = 0L;
      if (this.d.D() > l1)
        break label417;
      bool1 = true;
      if ((!a(localaa2)) || (this.d.D() == 0L) || (this.d.D() > l1))
        break label432;
      if (localaa1 != null)
      {
        long l2 = this.d.D();
        if (!localaa1.aS())
          break label423;
        l3 = localaa1.F();
        if (l2 <= l3)
          break label432;
      }
      bool2 = true;
      if ((localaa2 == null) || (localaa2.bc()) || ((localaa1 != null) && (!ae.a(localaa2.e(), localaa1.e()))))
        break label438;
      bool3 = true;
      if ((bool3) || (bool2) || (!a(localaa2, localaa1)))
        break label444;
      bool4 = true;
      if ((this.e == null) || (localaa2 == null) || (!this.e.b(Long.valueOf(localaa2.a()))))
        break label450;
      bool5 = true;
      if ((localaa1 == null) || (!localaa1.av()))
        break label456;
      bool6 = true;
      if ((localaa1 == null) || (!localaa1.as()))
        break label462;
      bool7 = true;
      if ((localaa1 == null) || (!localaa1.ax()))
        break label468;
      bool8 = true;
      if (localaa2 == null)
        break label705;
      if (!localaa2.aS())
        break label626;
      if (this.h.j())
        break label474;
      i2 = 1;
      if (i2 != 0)
        break label480;
      bool14 = false;
      bool13 = false;
      localUserData2 = this.k;
      bool15 = a(localaa3, localaa2);
      if (paramInt != 0)
        break label614;
      bool16 = true;
      label334: if (paramInt != i1 - 1)
        break label620;
    }
    label388: label417: label423: label432: label438: label444: label450: label456: label462: label468: label474: label480: label614: label620: for (boolean bool17 = true; ; bool17 = false)
    {
      return new g(localaa2, localUserData2, bool2, bool3, bool14, bool13, bool4, bool15, bool1, bool16, bool17, bool5, bool6, bool7, bool8);
      localaa3 = null;
      break;
      if (localaa2.aS())
      {
        l1 = localaa2.F();
        break label53;
      }
      l1 = localaa2.y();
      break label53;
      bool1 = false;
      break label69;
      l3 = localaa1.y();
      break label130;
      bool2 = false;
      break label141;
      bool3 = false;
      break label176;
      bool4 = false;
      break label199;
      bool5 = false;
      break label232;
      bool6 = false;
      break label246;
      bool7 = false;
      break label260;
      bool8 = false;
      break label274;
      i2 = 0;
      break label300;
      if (localaa1 != null)
      {
        int i3 = m.a(localaa2);
        int i4;
        if (i3 - localaa1.F() > 1)
        {
          i4 = 1;
          label505: if ((i4 == 0) || (!this.l.a(localaa2.c(), localaa1.F(), i3)))
            break label570;
          bool13 = true;
          if ((bool13) || (i4 == 0) || (this.d.E()))
            break label576;
        }
        for (boolean bool18 = true; ; bool18 = false)
        {
          bool14 = bool18;
          break;
          i4 = 0;
          break label505;
          bool13 = false;
          break label534;
        }
      }
      if ((paramInt == 0) && (m.a(localaa2) > 1));
      for (boolean bool12 = true; ; bool12 = false)
      {
        bool13 = bool12;
        bool14 = false;
        break;
      }
      bool16 = false;
      break label334;
    }
    label534: label570: label576: label626: UserData localUserData1 = this.k;
    boolean bool9 = a(localaa3, localaa2);
    boolean bool10;
    if (paramInt == 0)
    {
      bool10 = true;
      if (paramInt != i1 - 1)
        break label699;
    }
    label699: for (boolean bool11 = true; ; bool11 = false)
    {
      return new i(localaa2, localUserData1, bool2, bool3, bool4, bool9, bool1, bool10, bool11, bool5, bool6, bool7, bool8);
      bool10 = false;
      break;
    }
    label705: return null;
  }

  public com.viber.voip.messages.conversation.adapter.a.c.a.i b()
  {
    return this.h;
  }

  public void b(boolean paramBoolean)
  {
    this.h.b(paramBoolean);
  }

  public void c()
  {
    this.c = null;
    this.e = null;
  }

  public void c(boolean paramBoolean)
  {
    this.h.c(paramBoolean);
  }

  public boolean c(int paramInt)
  {
    return this.h.a(paramInt);
  }

  public void d(int paramInt)
  {
    this.h.b(paramInt);
  }

  public void d(boolean paramBoolean)
  {
    this.h.g(paramBoolean);
  }

  public void e(boolean paramBoolean)
  {
    this.h.h(paramBoolean);
  }

  public int getCount()
  {
    if (this.d == null)
      return 0;
    return this.d.getCount();
  }

  public long getItemId(int paramInt)
  {
    return this.d.a(paramInt);
  }

  public int getItemViewType(int paramInt)
  {
    return b(this.d.f(paramInt));
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.conversation.adapter.a.a locala = b(paramInt);
    if (locala == null);
    for (aa localaa = null; localaa == null; localaa = locala.c())
      return this.f.a(17, paramViewGroup);
    if ((paramView == null) || (paramView.getTag() == null));
    for (View localView = this.f.a(b(localaa), paramViewGroup); ; localView = paramView)
    {
      com.viber.voip.ui.g.d locald = ((com.viber.voip.ui.g.a)localView.getTag()).a();
      if ((localaa.au() != 17) && (localaa.au() > 0))
        this.i.a((b)localView, localaa);
      if (locala.k())
        this.g.a(localaa);
      locald.a(locala, this.h);
      if ((this.m > 0L) && (this.h.c(localaa.y())))
      {
        b(this.m);
        this.m = 0L;
      }
      localView.setTag(R.id.list_item_id, Long.valueOf(localaa.a()));
      return localView;
    }
  }

  public int getViewTypeCount()
  {
    return 41;
  }

  public void notifyDataSetChanged()
  {
    if (this.c != null);
    for (ConversationListView localConversationListView = this.c.af().e; ; localConversationListView = null)
    {
      if (localConversationListView != null)
      {
        localConversationListView.d();
        super.notifyDataSetChanged();
        localConversationListView.f();
      }
      return;
    }
  }

  public void onMovedToScrapHeap(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof com.viber.voip.ui.g.a))
      ((com.viber.voip.ui.g.a)localObject).a().a();
  }

  public void s()
  {
  }

  public void t()
  {
    this.h.c(-1);
    notifyDataSetChanged();
  }

  public static abstract interface a
  {
    public abstract void a(aa paramaa);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.d
 * JD-Core Version:    0.6.2
 */