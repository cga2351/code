package com.viber.voip.messages.ui.d.a;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.cv.c;
import com.viber.voip.stickers.c.g;
import com.viber.voip.stickers.p;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.dq;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class b extends RecyclerView.Adapter<c>
{
  private static final Logger a = ViberEnv.getLogger();
  private Context b;
  private com.viber.voip.util.e.e c;
  private f d;
  private com.viber.voip.b.c<Integer, b> e;
  private List<a.d> f = new ArrayList();
  private int g;
  private final int h;
  private final int i;
  private final View.OnClickListener j;
  private final View.OnLongClickListener k;
  private cv.c l;

  public b(Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, cv.c paramc)
  {
    this.b = paramContext;
    this.c = com.viber.voip.util.e.e.a(paramContext);
    this.d = f.a();
    this.l = paramc;
    this.e = new a("TabListIndicatorAdapter.IconCache");
    this.j = paramOnClickListener;
    this.k = paramOnLongClickListener;
    this.l = paramc;
    this.h = paramContext.getResources().getDimensionPixelSize(R.dimen.sticker_menu_height);
    this.i = paramContext.getResources().getDimensionPixelSize(R.dimen.sticker_menu_item_padding);
  }

  private b a(String paramString)
  {
    try
    {
      Bitmap localBitmap = dq.a(ViberApplication.getApplication().getAssets().open(paramString));
      b localb = new b(this.b, localBitmap);
      return localb;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  private boolean b(int paramInt)
  {
    return (this.f != null) && (paramInt >= 0) && (paramInt < this.f.size());
  }

  private boolean c(int paramInt)
  {
    return (paramInt == 400) || (paramInt == 1) || (paramInt == 143700) || (paramInt == 2) || (paramInt == 5) || (3 == paramInt) || (4 == paramInt);
  }

  private Drawable d(int paramInt)
  {
    b localb1 = (b)this.e.get(Integer.valueOf(paramInt));
    if (localb1 != null)
      return localb1;
    b localb2;
    if (paramInt == 400)
    {
      localb2 = a("stickers_package_icons/400.png");
      if (localb2 == null)
        return null;
    }
    else if ((paramInt == 1) || (paramInt == 143700))
    {
      localb2 = a("emoticons/(smiley).png");
      if (localb2 == null)
        return null;
    }
    else
    {
      if (paramInt != 2)
        break label136;
      Bitmap localBitmap7 = dq.a(this.b.getResources(), R.drawable.ic_stickers_menu_download_normal);
      Bitmap localBitmap8 = dq.a(this.b.getResources(), R.drawable.ic_stickers_menu_download_pressed);
      localb2 = new b(this.b, localBitmap7, localBitmap8);
    }
    while (true)
    {
      this.e.put(Integer.valueOf(paramInt), localb2);
      return localb2;
      label136: if (paramInt == 5)
      {
        Bitmap localBitmap5 = dq.a(this.b.getResources(), R.drawable.ic_stickers_menu_settings_normal);
        Bitmap localBitmap6 = dq.a(this.b.getResources(), R.drawable.ic_stickers_menu_settings_pressed);
        localb2 = new b(this.b, localBitmap5, localBitmap6, dc.f(this.b, R.attr.conversationStickerMenuIconDefaultTint));
      }
      else if (paramInt == 3)
      {
        Bitmap localBitmap3 = dq.a(this.b.getResources(), R.drawable.ic_msg_options_stickers_mode);
        Bitmap localBitmap4 = dq.a(this.b.getResources(), R.drawable.ic_msg_options_stickers_mode);
        localb2 = new b(this.b, localBitmap3, localBitmap4);
      }
      else
      {
        if (paramInt != 4)
          break;
        Bitmap localBitmap1 = dq.a(this.b.getResources(), R.drawable.ic_msg_options_custom_sticker);
        Bitmap localBitmap2 = dq.a(this.b.getResources(), R.drawable.ic_msg_options_custom_sticker);
        localb2 = new b(this.b, localBitmap1, localBitmap2);
      }
    }
    return null;
  }

  public int a()
  {
    return this.g;
  }

  public c a(ViewGroup paramViewGroup, int paramInt)
  {
    c localc = new c(paramViewGroup.getContext());
    localc.setLayoutParams(new RecyclerView.LayoutParams(this.h, this.h));
    localc.setPadding(this.i, this.i, this.i, this.i);
    localc.setOnClickListener(this.j);
    if (this.k != null)
      localc.setOnLongClickListener(this.k);
    return new c(localc);
  }

  public void a(int paramInt)
  {
    int m = this.g;
    this.g = paramInt;
    if (b(m))
      notifyItemChanged(m);
    if (b(this.g))
      notifyItemChanged(this.g);
  }

  void a(cv.c paramc)
  {
    this.l = paramc;
    notifyItemRangeChanged(0, getItemCount());
  }

  public void a(c paramc, int paramInt)
  {
    a.d locald = (a.d)this.f.get(paramInt);
    int m = locald.b();
    c localc = (c)paramc.itemView;
    Drawable localDrawable = this.l.c();
    if ((2 == m) || (5 == m) || (3 == m) || (4 == m))
    {
      dj.a(localc, null);
      localc.setPadding(this.i, this.i, this.i, this.i);
      if (!c(m))
        break label218;
      localc.setImageDrawable(d(m));
      label109: localc.a(locald.a(), locald.d(), locald.e());
      if (this.g != paramInt)
        break label245;
    }
    label218: label245: for (boolean bool = true; ; bool = false)
    {
      localc.setChecked(bool);
      dg.a(localc, "sp" + m);
      localc.setTag(locald);
      localc.setTag(R.id.list_item_id, Integer.valueOf(paramInt));
      return;
      if (localDrawable.getConstantState() == null)
        break;
      dj.a(localc, localDrawable.getConstantState().newDrawable(localc.getResources()));
      break;
      this.c.a(Uri.parse(g.b(m, p.c)), localc, this.d);
      break label109;
    }
  }

  public void a(List<a.d> paramList, int paramInt)
  {
    this.g = paramInt;
    this.f = paramList;
    notifyDataSetChanged();
  }

  public int b()
  {
    return this.h;
  }

  public int getItemCount()
  {
    return this.f.size();
  }

  public long getItemId(int paramInt)
  {
    return ((a.d)this.f.get(paramInt)).b();
  }

  private class a extends com.viber.voip.b.e<Integer, b.b>
  {
    public a(String arg2)
    {
      super(0.01041667F, 0.02083333F);
    }

    protected int a(Integer paramInteger, b.b paramb)
    {
      return b.b.a(paramb);
    }
  }

  private class b extends StateListDrawable
  {
    private final int b;

    b(Context paramBitmap, Bitmap arg3)
    {
      this(paramBitmap, localBitmap, (ColorStateList)null);
    }

    b(Context paramBitmap, Bitmap paramColorStateList, ColorStateList arg4)
    {
      this.b = j.d(paramColorStateList);
      ColorStateList localColorStateList;
      addState(new int[0], df.a(new BitmapDrawable(paramBitmap.getResources(), paramColorStateList), localColorStateList, false));
    }

    b(Context paramBitmap1, Bitmap paramBitmap2, Bitmap arg4)
    {
      this(paramBitmap1, paramBitmap2, localBitmap, null);
    }

    b(Context paramBitmap1, Bitmap paramBitmap2, Bitmap paramColorStateList, ColorStateList arg5)
    {
      int i = j.d(paramBitmap2);
      if (paramBitmap2 != paramColorStateList);
      for (int j = j.d(paramColorStateList); ; j = 0)
      {
        this.b = (j + i);
        ColorStateList localColorStateList;
        Drawable localDrawable1 = df.a(new BitmapDrawable(paramBitmap1.getResources(), paramBitmap2), localColorStateList, false);
        Drawable localDrawable2 = df.a(new BitmapDrawable(paramBitmap1.getResources(), paramColorStateList), localColorStateList, false);
        addState(new int[] { 16842912 }, localDrawable2);
        addState(new int[] { 16842919 }, localDrawable2);
        addState(new int[0], localDrawable1);
        return;
      }
    }
  }

  public static class c extends RecyclerView.ViewHolder
  {
    public c(View paramView)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.a.b
 * JD-Core Version:    0.6.2
 */