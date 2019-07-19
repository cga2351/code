package com.viber.voip.contacts.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.contacts.a;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.c;
import com.viber.voip.model.j;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class h extends i
  implements n
{
  private final boolean k;
  private Set<ParticipantSelector.Participant> l;
  private Set<ParticipantSelector.Participant> m;
  private boolean n;
  private boolean o;

  public h(Context paramContext, boolean paramBoolean1, a parama1, boolean paramBoolean2, a parama2, boolean paramBoolean3, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramBoolean1, parama1, parama2, paramLayoutInflater);
    this.k = paramBoolean3;
    this.a = parama1;
    this.g = true;
    this.o = paramBoolean2;
  }

  private Collection<ParticipantSelector.Participant> a(c paramc)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramc.s().iterator();
    while (localIterator1.hasNext())
    {
      j localj = (j)localIterator1.next();
      localHashMap.put(localj.c(), ParticipantSelector.Participant.from(localj, paramc));
    }
    if (this.k)
    {
      Iterator localIterator2 = paramc.t().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        if (!localHashMap.containsKey(str))
          localHashMap.put(str, ParticipantSelector.Participant.from(Member.fromVln(str)));
      }
    }
    return localHashMap.values();
  }

  private void a(c paramc, g.a parama)
  {
    boolean bool1 = true;
    boolean bool3;
    boolean bool5;
    boolean bool2;
    if (this.l != null)
    {
      Iterator localIterator = a(paramc).iterator();
      bool3 = bool1;
      boolean bool4 = bool1;
      while (localIterator.hasNext())
      {
        ParticipantSelector.Participant localParticipant = (ParticipantSelector.Participant)localIterator.next();
        if (!this.l.contains(localParticipant))
          bool4 = false;
        if (this.m.contains(localParticipant))
          break label156;
        bool5 = false;
        bool3 = bool5;
      }
      if (bool4)
      {
        bool2 = bool1;
        label98: if ((!this.o) && ((bool3) || ((!bool2) && (this.n))))
          bool1 = false;
      }
    }
    while (true)
    {
      parama.m.setEnabled(bool1);
      dj.b(parama.m, bool2);
      parama.s.setEnabled(bool1);
      return;
      bool2 = false;
      break label98;
      label156: bool5 = bool3;
      break;
      bool2 = false;
    }
  }

  public void a(Set<ParticipantSelector.Participant> paramSet1, Set<ParticipantSelector.Participant> paramSet2, boolean paramBoolean)
  {
    this.l = paramSet1;
    this.m = paramSet2;
    this.n = paramBoolean;
  }

  public boolean a(int paramInt, ParticipantSelector.Participant paramParticipant)
  {
    c localc = c(paramInt);
    if (localc == null)
      return false;
    Iterator localIterator = a(localc).iterator();
    while (localIterator.hasNext())
      if (paramParticipant.equals((ParticipantSelector.Participant)localIterator.next()))
        return true;
    return false;
  }

  protected View d(int paramInt)
  {
    View localView = super.d(paramInt);
    g.a locala = (g.a)localView.getTag();
    boolean bool1 = locala.m.isEnabled();
    Drawable localDrawable = null;
    if (bool1)
      if (locala.m.getVisibility() != 0)
        break label73;
    label73: for (boolean bool2 = true; ; bool2 = false)
    {
      localView.setActivated(bool2);
      localDrawable = dc.g(this.c, R.attr.listItemActivatedBackground);
      locala.b.setBackground(localDrawable);
      return localView;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    g.a locala = (g.a)localView.getTag();
    a(locala.p, locala);
    return localView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.h
 * JD-Core Version:    0.6.2
 */