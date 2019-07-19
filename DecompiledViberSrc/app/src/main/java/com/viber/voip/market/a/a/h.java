package com.viber.voip.market.a.a;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.stickers.c.g;
import com.viber.voip.stickers.p;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.k;
import com.viber.voip.widget.dslv.DragSortListView.h;

public class h extends BaseAdapter
  implements View.OnClickListener, DragSortListView.h
{
  private c a;
  private k b;
  private LayoutInflater c;

  public h(Context paramContext, c paramc)
  {
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.a = paramc;
    this.b = e.a(paramContext);
  }

  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    View localView = this.c.inflate(R.layout.market_settings_package_item, paramViewGroup, false);
    if (paramInt == 0);
    for (Object localObject = new b(localView, this); ; localObject = new a(localView, this))
    {
      localView.setTag(localObject);
      ((a)localObject).h.setTag(localObject);
      return localView;
    }
  }

  public a a(int paramInt)
  {
    return this.a.a(paramInt);
  }

  public void a_(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      this.a.a(paramInt1, paramInt2);
      notifyDataSetChanged();
    }
  }

  public int getCount()
  {
    return this.a.b();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (!a(paramInt).c())
      return 0;
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = a(getItemViewType(paramInt), paramViewGroup);
    a locala = (a)paramView.getTag();
    a.a(locala, a(paramInt), this.b);
    View localView = locala.g;
    if (paramInt > 0);
    for (int i = 0; ; i = 4)
    {
      localView.setVisibility(i);
      return paramView;
    }
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  public void onClick(View paramView)
  {
    a locala = ((a)paramView.getTag()).a();
    if (!locala.c());
    for (boolean bool = true; ; bool = false)
    {
      locala.a(bool);
      notifyDataSetChanged();
      return;
    }
  }

  public static class a
  {
    protected a a;
    protected final View b;
    protected final ImageView c;
    protected final CheckBox d;
    protected final TextView e;
    protected final View f;
    protected final View g;
    protected final View h;

    protected a(View paramView, View.OnClickListener paramOnClickListener)
    {
      this.c = ((ImageView)paramView.findViewById(R.id.icon));
      this.d = ((CheckBox)paramView.findViewById(R.id.check_box));
      this.e = ((TextView)paramView.findViewById(R.id.text));
      this.f = paramView.findViewById(R.id.drag_handle);
      this.b = paramView;
      this.b.setSelected(true);
      this.g = paramView.findViewById(R.id.bottom_divider);
      this.h = paramView.findViewById(R.id.clickable_view);
      this.h.setOnClickListener(paramOnClickListener);
    }

    private void a(a parama, k paramk)
    {
      this.a = parama;
      this.e.setText(parama.f());
      this.d.setChecked(parama.c());
      int i = p.c;
      paramk.a(Uri.parse(g.b(parama.e(), i)), this.c, f.a());
    }

    public a a()
    {
      return this.a;
    }
  }

  public static class b extends h.a
  {
    protected b(View paramView, View.OnClickListener paramOnClickListener)
    {
      super(paramOnClickListener);
      this.b.setSelected(false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.a.a.h
 * JD-Core Version:    0.6.2
 */