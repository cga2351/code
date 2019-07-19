package com.viber.voip.contacts.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.common.permission.c;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ui.ac;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class x extends ak
{
  public TextView a;
  public LinearLayout b;
  public View c;
  public LinearLayout d;
  public TextView e;
  public EditText f;
  public ViewGroup g;
  public View h;
  public TextView i;
  public TextView j;
  private boolean o;
  private TextView p;
  private TextView q;
  private TextView r;
  private View s;
  private boolean t;
  private boolean u;
  private boolean v;
  private int w;
  private long x;

  public x(View paramView, c paramc)
  {
    super(paramView, paramc);
  }

  private void c()
  {
    if ((this.o) && (this.w == 0));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(this.h, bool);
      return;
    }
  }

  private void d()
  {
    if ((this.t) && (this.w == 0));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(this.p, bool);
      return;
    }
  }

  private void e(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    label52: View localView;
    if ((this.u) && (this.w == 0) && (this.x == 0L))
    {
      bool2 = bool1;
      dj.b(this.q, bool2);
      TextView localTextView = this.r;
      if ((!bool2) || (!paramBoolean))
        break label85;
      bool3 = bool1;
      dj.b(localTextView, bool3);
      localView = this.s;
      if ((!bool2) || (!paramBoolean))
        break label91;
    }
    while (true)
    {
      dj.b(localView, bool1);
      return;
      bool2 = false;
      break;
      label85: bool3 = false;
      break label52;
      label91: bool1 = false;
    }
  }

  public void a()
  {
    if (this.c != null)
      this.c.requestLayout();
  }

  public void a(long paramLong)
  {
    this.x = paramLong;
  }

  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.w = paramInt1;
    if ((!e()) || (paramContext == null))
      return;
    int k;
    if (paramInt1 >= 0)
    {
      if (paramInt2 != -1)
        break label113;
      k = 1;
      if (k == 0)
        break label119;
      TextView localTextView2 = this.e;
      int i1 = 0;
      if (paramInt1 == 0)
        i1 = 8;
      localTextView2.setVisibility(i1);
      this.e.setText(String.valueOf(paramInt1));
      label69: if ((k != 0) || (paramInt1 < paramInt2))
        break label168;
    }
    label168: for (int n = -65536; ; n = dc.d(paramContext, R.attr.contactsListComposeHeaderCountTextColor))
    {
      this.e.setTextColor(n);
      a();
      c();
      d();
      e(this.v);
      return;
      label113: k = 0;
      break;
      label119: TextView localTextView1 = this.e;
      int m = R.string.participants_count;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      localTextView1.setText(paramContext.getString(m, arrayOfObject));
      break label69;
    }
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    if (this.r != null)
      this.r.setOnClickListener(paramOnClickListener);
  }

  public void a(boolean paramBoolean)
  {
    dj.b(this.c, paramBoolean);
  }

  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.u = paramBoolean;
    if (!da.a(paramString));
    for (boolean bool = true; ; bool = false)
    {
      this.v = bool;
      e(this.v);
      if (!this.u)
        break;
      this.i.setText(R.string.join_community_link_msg_title);
      this.j.setText(R.string.join_community_link_msg);
      this.q.setText(paramInt);
      if (this.v)
        this.r.setText(paramString);
      return;
    }
    this.i.setText(R.string.share_group_link);
    this.j.setText(R.string.link_explanation_text);
  }

  public void a(boolean paramBoolean, ac paramac)
  {
  }

  public void a(boolean paramBoolean, String paramString)
  {
    if (!e())
      return;
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      this.a.setText(paramString);
      return;
    }
    this.b.setVisibility(8);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.l != null)
    {
      ImageView localImageView = this.l;
      if (!paramBoolean1)
      {
        View[] arrayOfView = new View[1];
        arrayOfView[0] = this.c;
        if (dj.a(arrayOfView))
        {
          bool = false;
          if (paramBoolean2)
            break label48;
        }
      }
      boolean bool = true;
      label48: dj.b(localImageView, bool);
    }
  }

  public boolean a(View paramView, View.OnClickListener paramOnClickListener, int paramInt)
  {
    if (!super.a(paramView, paramOnClickListener, paramInt))
      return false;
    this.b = ((LinearLayout)paramView.findViewById(R.id.new_num_root_layout));
    this.c = paramView.findViewById(R.id.to_participants_bar);
    this.e = ((TextView)paramView.findViewById(R.id.to_participants_count));
    this.f = ((EditText)paramView.findViewById(R.id.participant_search));
    this.f.setHint(R.string.to_participants);
    this.a = ((TextView)paramView.findViewById(R.id.searched_number));
    this.d = ((LinearLayout)paramView.findViewById(R.id.new_num_layout));
    this.d.setOnClickListener(paramOnClickListener);
    this.g = ((ViewGroup)paramView.findViewById(R.id.top_2_frame));
    this.h = paramView.findViewById(R.id.share_group_link);
    this.h.setOnClickListener(paramOnClickListener);
    this.i = ((TextView)paramView.findViewById(R.id.share_group_link_title));
    this.j = ((TextView)paramView.findViewById(R.id.share_group_link_subtitle));
    this.p = ((TextView)paramView.findViewById(R.id.participants_explanation));
    this.q = ((TextView)paramView.findViewById(R.id.community_explanation));
    this.r = ((TextView)paramView.findViewById(R.id.community_share_link));
    this.s = paramView.findViewById(R.id.community_link_container);
    dj.a(this.r);
    return true;
  }

  public void b(boolean paramBoolean)
  {
    this.o = paramBoolean;
    c();
  }

  public void c(boolean paramBoolean)
  {
    this.t = paramBoolean;
    d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.x
 * JD-Core Version:    0.6.2
 */