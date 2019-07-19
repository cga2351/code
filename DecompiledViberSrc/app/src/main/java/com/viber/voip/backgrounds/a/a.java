package com.viber.voip.backgrounds.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backgrounds.b;
import com.viber.voip.backgrounds.g;
import com.viber.voip.backgrounds.l;
import com.viber.voip.backgrounds.m;
import com.viber.voip.backgrounds.o;
import com.viber.voip.backgrounds.p;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f.a;
import java.util.ArrayList;

public class a extends BaseAdapter
  implements com.viber.voip.backgrounds.f
{
  private final b a;
  private l b;
  private final e c;
  private final com.viber.voip.util.e.f d;
  private final boolean e;
  private int f;

  public a(Context paramContext)
  {
    this.f = g.b(paramContext, null);
    this.c = e.a(paramContext);
    this.d = new f.a().b(false).a(true).c();
    this.a = b.a();
    this.a.a(this);
    this.e = dc.a();
  }

  public p a(int paramInt)
  {
    if ((this.b == null) || (this.b.a() == null))
      return null;
    return (p)this.b.a().get(paramInt);
  }

  public void a()
  {
    this.a.b(this);
  }

  public void a(com.viber.voip.backgrounds.a parama)
  {
  }

  public void a(final l paraml)
  {
    if ((this.b == null) || (this.b.a().size() == 0))
      av.a(av.e.a).post(new Runnable()
      {
        public void run()
        {
          a.a(a.this, paraml);
          a.this.notifyDataSetChanged();
        }
      });
  }

  public void a(l paraml, int paramInt)
  {
  }

  public void a(l paraml, p paramp)
  {
  }

  public void b(int paramInt)
  {
    this.f = paramInt;
  }

  public void b(l paraml)
  {
  }

  public void c(l paraml)
  {
    if (this.b != null)
      this.b.a().clear();
    this.b = paraml;
    notifyDataSetChanged();
  }

  public int getCount()
  {
    if (this.b == null)
      return 0;
    return this.b.a().size();
  }

  public long getItemId(int paramInt)
  {
    if (this.b == null)
      return -1L;
    return ((p)this.b.a().get(paramInt)).a;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ImageView localImageView;
    if (paramView == null)
    {
      localImageView = new ImageView(paramViewGroup.getContext());
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localImageView.setLayoutParams(new AbsListView.LayoutParams(this.f, this.f));
    }
    p localp;
    while (true)
    {
      localp = a(paramInt);
      if ((!this.e) || (!m.a(localp.a)))
        break;
      this.c.a(new o().a(), localImageView, this.d);
      return localImageView;
      localImageView = (ImageView)paramView;
    }
    this.c.a(localp.i, localImageView, this.d);
    return localImageView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.a.a
 * JD-Core Version:    0.6.2
 */