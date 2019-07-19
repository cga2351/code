package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.adapter.a.a.a;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.messages.conversation.publicaccount.k.b;
import com.viber.voip.messages.conversation.ui.at;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ConversationAlertView extends AlertView
  implements k.b, p.a
{
  private static final Logger b = ViberEnv.getLogger();
  private b c;
  private p d;
  private b e;
  private b f;
  private b g;
  private s.a h;
  private g.a i;
  private b j;
  private a k;
  private at l;

  public ConversationAlertView(Context paramContext)
  {
    super(paramContext);
  }

  public ConversationAlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ConversationAlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private b a(Bundle paramBundle)
  {
    if (this.c == null)
      this.c = new s(this, this.h, getLayoutInflater());
    this.c.setBundle(paramBundle);
    return this.c;
  }

  private b a(a parama, Bundle paramBundle)
  {
    if (a.a == parama)
      return a(paramBundle);
    if (a.b == parama)
      return getFollowerIncreaseAlert();
    if (a.k == parama)
      return b(paramBundle);
    if (a.l == parama)
      return getTranslateMessagesPromoAlert();
    if (a.q == parama)
      return getSwipeToReplyAlert();
    return null;
  }

  private b b(Bundle paramBundle)
  {
    if (this.e == null)
      this.e = new g(this, paramBundle, this.i, getLayoutInflater());
    this.e.setBundle(paramBundle);
    return this.e;
  }

  private b getFollowerIncreaseAlert()
  {
    if (this.d == null)
      this.d = new p(this, this, getLayoutInflater());
    return this.d;
  }

  private LayoutInflater getLayoutInflater()
  {
    return LayoutInflater.from(getContext());
  }

  private b getSwipeToReplyAlert()
  {
    if (this.g == null)
      this.g = new ab(this, getLayoutInflater());
    return this.g;
  }

  private b getTranslateMessagesPromoAlert()
  {
    if (this.f == null)
      this.f = new ac(getContext(), this, getLayoutInflater());
    return this.f;
  }

  public void a(int paramInt, String paramString)
  {
    p localp = (p)a(a.b, Bundle.EMPTY);
    if (localp != null)
      localp.a(paramInt, paramString);
    b(localp, true);
  }

  public void a(at paramat)
  {
    this.l = paramat;
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).applyUiSettings(paramat);
  }

  @Deprecated
  public void a(a parama, Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool = paramBoolean & true;
    b(a(parama, paramBundle), bool);
  }

  protected void b(AlertView.a parama)
  {
    super.b(parama);
    if ((this.a.isEmpty()) && (this.k.d() > 0))
    {
      this.k.b(0);
      if (this.j != null)
        this.j.K_();
      this.k.a(true);
    }
  }

  public void c()
  {
    b(a.b);
  }

  protected void c(b paramb, boolean paramBoolean)
  {
    paramb.applyUiSettings(this.l);
    int m = this.k.d();
    int n;
    if (paramb.isLaidNextOrOver(getAlertTopAppearanceOrder()))
    {
      n = paramb.getMeasuredHeight();
      if (getChildCount() != 0)
        break label89;
      this.k.a(n);
    }
    while (true)
    {
      super.c(paramb, paramBoolean);
      if ((this.j != null) && (m != this.k.d()))
        this.j.K_();
      return;
      n = 0;
      break;
      label89: if (paramb.isPriorityAlert())
        this.k.b(n + this.k.d());
      else
        this.k.b(n + this.k.d());
    }
  }

  public int getBannersHeight()
  {
    int m = this.k.d();
    if ((m > 0) && (this.a.isEmpty()))
      m = 0;
    return m;
  }

  public void onGlobalLayout()
  {
    super.onGlobalLayout();
    int m = getAlertTopAppearanceOrder();
    Iterator localIterator = this.a.values().iterator();
    int n = 0;
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.isLaidNextOrOver(m));
      for (int i2 = localb.getEmptyViewHeight(); ; i2 = 0)
      {
        n = i2 + n;
        break;
      }
    }
    int i1 = this.k.d();
    this.k.b(n);
    if ((this.j != null) && (i1 != n))
      this.j.K_();
  }

  public void setBlockListener(g.a parama)
  {
    this.i = parama;
  }

  public void setEmptyViewAdapter(k paramk)
  {
    this.k = new a(paramk);
  }

  public void setNoParticipantsBannerListener(s.a parama)
  {
    this.h = parama;
  }

  public void setSizeChangeListener(b paramb)
  {
    this.j = paramb;
  }

  public static enum a
    implements AlertView.a
  {
    static
    {
      a[] arrayOfa = new a[18];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      arrayOfa[10] = k;
      arrayOfa[11] = l;
      arrayOfa[12] = m;
      arrayOfa[13] = n;
      arrayOfa[14] = o;
      arrayOfa[15] = p;
      arrayOfa[16] = q;
      arrayOfa[17] = r;
    }
  }

  public static abstract interface b
  {
    public abstract void K_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.ConversationAlertView
 * JD-Core Version:    0.6.2
 */