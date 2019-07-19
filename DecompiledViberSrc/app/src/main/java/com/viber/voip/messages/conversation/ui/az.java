package com.viber.voip.messages.conversation.ui;

import android.content.res.ColorStateList;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.o;
import com.viber.voip.messages.conversation.adapter.d.p;
import com.viber.voip.messages.ui.ar;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.util.cd;
import com.viber.voip.util.dj;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class az extends ar<Long, aa>
  implements View.OnClickListener, o
{
  private static final Logger b = ViberEnv.getLogger();
  private LayoutInflater c;
  private a d;
  private ViberFragmentActivity e;
  private View f;
  private ViewStub g;
  private ImageButton h;
  private ImageButton i;
  private ImageButton j;
  private ImageButton k;
  private View l;
  private View m;
  private View n;
  private boolean o = false;
  private boolean p = true;
  private ConversationItemLoaderEntity q;
  private at r;
  private Set<Long> s = new HashSet();

  az(a parama, ViberFragmentActivity paramViberFragmentActivity, at paramat, ViewStub paramViewStub, LayoutInflater paramLayoutInflater)
  {
    this.e = paramViberFragmentActivity;
    this.d = parama;
    this.r = paramat;
    this.g = paramViewStub;
    this.c = paramLayoutInflater;
  }

  private View a(View paramView1, View paramView2, boolean paramBoolean, View paramView3)
  {
    if (paramBoolean);
    for (int i1 = 0; ; i1 = 8)
    {
      paramView1.setVisibility(i1);
      if (paramView2 != null)
      {
        paramView2.setVisibility(paramView1.getVisibility());
        if (paramView2.getVisibility() == 0)
          paramView3 = paramView2;
      }
      return paramView3;
    }
  }

  private void b(Map<Long, aa> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
      this.s.clear();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((aa)localEntry.getValue()).bi())
        this.s.add(localEntry.getKey());
    }
  }

  private View j()
  {
    if (this.f == null)
    {
      this.f = this.g.inflate();
      this.h = ((ImageButton)this.f.findViewById(R.id.btn_delete));
      this.h.setOnClickListener(this);
      this.j = ((ImageButton)this.f.findViewById(R.id.btn_info));
      this.j.setOnClickListener(this);
      this.i = ((ImageButton)this.f.findViewById(R.id.btn_copy));
      this.i.setOnClickListener(this);
      this.k = ((ImageButton)this.f.findViewById(R.id.btn_forward));
      this.k.setOnClickListener(this);
      this.l = this.f.findViewById(R.id.space_delete);
      this.m = this.f.findViewById(R.id.space_copy);
      this.n = this.f.findViewById(R.id.space_info);
    }
    ColorStateList localColorStateList = this.r.p();
    ImageViewCompat.setImageTintList(this.h, localColorStateList);
    ImageViewCompat.setImageTintList(this.j, localColorStateList);
    ImageViewCompat.setImageTintList(this.i, localColorStateList);
    ImageViewCompat.setImageTintList(this.k, localColorStateList);
    dj.a(this.f, this.r.o());
    return this.f;
  }

  private void k()
  {
    int i1 = 1;
    if ((this.f == null) || (this.q == null))
      return;
    int i2 = g();
    int i3 = this.s.size();
    label110: label240: View localView5;
    label173: ImageButton localImageButton3;
    if (i2 > 0)
    {
      int i4 = i1;
      if (this.q.isPublicGroupBehavior())
      {
        int i10 = this.q.getGroupRole();
        if ((i2 != i1) || ((!cd.c(i10)) && ((!this.q.canWrite()) || (!((aa)f().values().iterator().next()).ap()))))
          break label293;
        i4 = i1;
      }
      View localView1 = a(this.h, this.l, i4, null);
      ImageButton localImageButton1 = this.j;
      View localView2 = this.n;
      if ((i2 != i1) || (!((aa)f().values().iterator().next()).bl()))
        break label299;
      int i6 = i1;
      View localView3 = a(localImageButton1, localView2, i6, localView1);
      ImageButton localImageButton2 = this.i;
      View localView4 = this.m;
      if ((!this.p) || (i2 != i1) || (!((aa)f().values().iterator().next()).bh()))
        break label305;
      int i8 = i1;
      localView5 = a(localImageButton2, localView4, i8, localView3);
      localImageButton3 = this.k;
      if ((!this.p) || (i3 != 0) || (i2 <= 0))
        break label311;
    }
    while (true)
    {
      a(localImageButton3, localView5, i1, null);
      return;
      int i5 = 0;
      break;
      label293: i5 = 0;
      break label110;
      label299: int i7 = 0;
      break label173;
      label305: int i9 = 0;
      break label240;
      label311: i1 = 0;
    }
  }

  protected b a(b.a parama)
  {
    return this.e.startSupportActionMode(parama);
  }

  public void a(b paramb)
  {
    j().setVisibility(8);
    this.o = false;
    d();
    this.d.Y();
  }

  void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    boolean bool1 = true;
    this.q = paramConversationItemLoaderEntity;
    boolean bool2;
    if (!paramConversationItemLoaderEntity.isNotShareablePublicAccount())
    {
      bool2 = bool1;
      if (this.p == bool2)
        break label43;
    }
    while (true)
    {
      this.p = bool2;
      if (bool1)
        k();
      return;
      bool2 = false;
      break;
      label43: bool1 = false;
    }
  }

  public void a(aa paramaa)
  {
    if (a())
      return;
    b(true);
    b(paramaa);
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    if (!a())
      return;
    if (paramBoolean)
    {
      a(Long.valueOf(paramaa.a()), paramaa);
      return;
    }
    a(Long.valueOf(paramaa.a()));
  }

  public void a(at paramat)
  {
    this.r = paramat;
  }

  public void a(Long paramLong)
  {
    this.s.remove(paramLong);
    super.a(paramLong);
  }

  public void a(Long paramLong, aa paramaa)
  {
    if (!paramaa.bi())
      this.s.add(paramLong);
    super.b(paramLong, paramaa);
  }

  public void a(Map<Long, aa> paramMap)
  {
    b(paramMap, false);
    super.a(paramMap);
  }

  public void a(Map<Long, aa> paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    super.a(paramMap, paramBoolean);
  }

  public void a(boolean paramBoolean)
  {
    p.a(this, paramBoolean);
  }

  public boolean a()
  {
    return this.o;
  }

  public boolean a(b paramb, Menu paramMenu)
  {
    this.d.X();
    j().setVisibility(0);
    b(paramb);
    k();
    c();
    return true;
  }

  public boolean a(b paramb, MenuItem paramMenuItem)
  {
    return false;
  }

  public void b()
  {
    p.a(this);
  }

  public void b(Long paramLong, aa paramaa)
  {
    if (!paramaa.bi())
      this.s.add(paramLong);
    super.a(paramLong, paramaa);
  }

  void b(boolean paramBoolean)
  {
    if (paramBoolean)
      h();
    while (true)
    {
      this.o = paramBoolean;
      this.d.W();
      return;
      i();
    }
  }

  public boolean b(b paramb, Menu paramMenu)
  {
    return false;
  }

  public boolean b(aa paramaa)
  {
    if (b(Long.valueOf(paramaa.a())))
    {
      a(Long.valueOf(paramaa.a()));
      return false;
    }
    a(Long.valueOf(paramaa.a()), paramaa);
    return true;
  }

  public void c()
  {
    a(this.e.getString(R.string.msg_mass_toggle_bar_text), g(), this.c);
    if (this.a != null);
    for (View localView = this.a.i(); ; localView = null)
    {
      ViewParent localViewParent = null;
      if (localView != null)
        localViewParent = localView.getParent();
      if ((localViewParent instanceof View))
      {
        dj.a((View)localViewParent, this.r.l());
        int i1 = this.r.q();
        ((TextView)localView.findViewById(R.id.title)).setTextColor(i1);
        ((TextView)localView.findViewById(R.id.count)).setTextColor(i1);
        ImageView localImageView = (ImageView)((View)localViewParent).findViewById(R.id.action_mode_close_button);
        if (localImageView != null)
          ImageViewCompat.setImageTintList(localImageView, this.r.p());
      }
      return;
    }
  }

  public void d()
  {
    this.s.clear();
    super.d();
  }

  protected void e()
  {
    this.d.W();
    c();
    k();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.h)
      if (this.q.isPublicGroupBehavior())
        r.a(this.d, new LinkedList(f().keySet())).a(this.e);
    do
    {
      return;
      ad.a(this.d, new LinkedList(f().keySet())).a(this.e);
      return;
      if (paramView == this.i)
      {
        this.d.c((aa)f().values().iterator().next());
        return;
      }
      if (paramView == this.j)
      {
        this.d.d((aa)f().values().iterator().next());
        return;
      }
    }
    while (paramView != this.k);
    this.d.a(f().values());
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    p.a(this, paramContextMenu, paramView, paramContextMenuInfo);
  }

  public static abstract interface a
  {
    public abstract void W();

    public abstract void X();

    public abstract void Y();

    public abstract void a(Collection<aa> paramCollection);

    public abstract void a(List<Long> paramList, boolean paramBoolean);

    public abstract void c(aa paramaa);

    public abstract void d(aa paramaa);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.az
 * JD-Core Version:    0.6.2
 */