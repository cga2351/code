package com.viber.voip.contacts.adapters;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.string;
import com.viber.voip.contacts.a;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.model.c;
import com.viber.voip.model.j;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.widget.AvatarWithInitialsView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class l extends g
  implements n
{
  private Set<ParticipantSelector.Participant> j;
  private Set<ParticipantSelector.Participant> k;
  private boolean l;
  private boolean m;
  private final int n;
  private final int o;
  private final int p;
  private final int q;
  private final boolean r;

  public l(Activity paramActivity, boolean paramBoolean1, a parama, boolean paramBoolean2, LayoutInflater paramLayoutInflater)
  {
    super(paramActivity, paramBoolean1, parama, paramLayoutInflater);
    this.a = parama;
    this.r = paramBoolean2;
    this.g = true;
    this.m = false;
    Resources localResources = paramActivity.getResources();
    this.n = localResources.getDimensionPixelSize(R.dimen.contacts_item_top_bottom_margin);
    this.o = localResources.getDimensionPixelSize(R.dimen.recently_joined_avatar_margin_left);
    this.p = localResources.getDimensionPixelSize(R.dimen.recently_joined_badge_margin_left);
    this.q = localResources.getDimensionPixelSize(R.dimen.recently_joined_margin_right);
  }

  private void a(View paramView)
  {
    g.a locala = (g.a)paramView.getTag();
    ((ViewGroup.MarginLayoutParams)locala.o.getLayoutParams()).topMargin = 0;
    if (!this.r)
      locala.f.setVisibility(8);
    locala.e.setVisibility(0);
    locala.g.setVisibility(8);
    locala.h.setText(a());
  }

  private void a(c paramc, g.a parama)
  {
    boolean bool1 = true;
    boolean bool3;
    boolean bool5;
    boolean bool2;
    if (this.j != null)
    {
      Iterator localIterator = paramc.s().iterator();
      bool3 = bool1;
      boolean bool4 = bool1;
      while (localIterator.hasNext())
      {
        ParticipantSelector.Participant localParticipant = ParticipantSelector.Participant.from((j)localIterator.next(), paramc);
        if (!this.j.contains(localParticipant))
          bool4 = false;
        if (this.k.contains(localParticipant))
          break label161;
        bool5 = false;
        bool3 = bool5;
      }
      if (bool4)
      {
        bool2 = bool1;
        label103: if ((!this.m) && ((bool3) || ((!bool2) && (this.l))))
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
      break label103;
      label161: bool5 = bool3;
      break;
      bool2 = false;
    }
  }

  protected String a()
  {
    return this.f.getString(R.string.recent_section_title);
  }

  protected void a(int paramInt, View paramView, c paramc)
  {
    super.a(paramInt, paramView, paramc);
    if (paramInt == 0)
      a(paramView);
    g.a locala = (g.a)paramView.getTag();
    ((ViewGroup.MarginLayoutParams)locala.b.getLayoutParams()).leftMargin = this.o;
    ((ViewGroup.MarginLayoutParams)locala.r.getLayoutParams()).leftMargin = this.p;
    ((ViewGroup.MarginLayoutParams)locala.r.getLayoutParams()).rightMargin = this.q;
  }

  public void a(Set<ParticipantSelector.Participant> paramSet1, Set<ParticipantSelector.Participant> paramSet2, boolean paramBoolean)
  {
    this.j = paramSet1;
    this.k = paramSet2;
    this.l = paramBoolean;
  }

  public boolean a(int paramInt, ParticipantSelector.Participant paramParticipant)
  {
    c localc = c(paramInt);
    if (localc == null)
      return false;
    Iterator localIterator = localc.s().iterator();
    while (localIterator.hasNext())
      if (paramParticipant.equals(ParticipantSelector.Participant.from((j)localIterator.next(), localc)))
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

  public boolean e_(int paramInt)
  {
    return false;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
      return 1;
    return 0;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    g.a locala = (g.a)localView.getTag();
    locala.n.setVisibility(8);
    ViewGroup localViewGroup = (ViewGroup)locala.b.getParent();
    int i = localViewGroup.getPaddingLeft();
    int i1 = localViewGroup.getPaddingTop();
    int i2 = localViewGroup.getPaddingRight();
    if (paramInt == -1 + getCount());
    for (int i3 = this.n; ; i3 = 0)
    {
      localViewGroup.setPadding(i, i1, i2, i3);
      a(this.a.c(paramInt), locala);
      return localView;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.l
 * JD-Core Version:    0.6.2
 */