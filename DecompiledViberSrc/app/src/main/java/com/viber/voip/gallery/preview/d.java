package com.viber.voip.gallery.preview;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.an;
import com.viber.voip.an.a;
import com.viber.voip.an.c;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.gallery.a.c;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.extras.image.imagezoom.ImageViewTouch;
import com.viber.voip.messages.extras.image.imagezoom.ImageViewTouch.b;
import com.viber.voip.messages.ui.view.ViewPagerWithPagingEnable;
import com.viber.voip.util.e.j;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pl.droidsonroids.gif.b;

public class d extends c
{
  private static final Logger f = ViberEnv.getLogger();
  final float b;
  final float c;
  final float d;
  final float e;
  private final List<GalleryItem> g;
  private final Set<Integer> h;
  private ViewPagerWithPagingEnable i;
  private an j;
  private boolean k;
  private Pair<Integer, GalleryItem> l;
  private int m;
  private Handler n;
  private b o;
  private y p;

  public d(Context paramContext, List<GalleryItem> paramList, ViewPagerWithPagingEnable paramViewPagerWithPagingEnable)
  {
    super(paramContext);
    this.i = paramViewPagerWithPagingEnable;
    this.g = paramList;
    this.h = new HashSet();
    this.n = av.a(av.e.g);
    this.p = y.a();
    Resources localResources = this.a.getResources();
    this.b = localResources.getDimension(R.dimen.gallery_left_right_paddings);
    this.c = localResources.getDimension(R.dimen.gallery_top_paddings);
    this.d = localResources.getDimension(R.dimen.gallery_left_right_paddings);
    this.e = localResources.getDimension(R.dimen.gallery_bottom_paddings);
  }

  private b a(int paramInt, boolean paramBoolean)
  {
    a locala = new a(this.a, null);
    locala.setId(R.id.container);
    locala.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ImageViewTouch localImageViewTouch = new ImageViewTouch(this.a);
    localImageViewTouch.setId(R.id.image);
    localImageViewTouch.a(this.b, this.c, this.d, this.e);
    localImageViewTouch.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    localImageViewTouch.setExternalScrollListener(new ImageViewTouch.b()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        d.a(d.this).setPagingEnabled(paramAnonymousBoolean);
      }
    });
    locala.addView(localImageViewTouch);
    ImageView localImageView1 = new ImageView(this.a);
    localImageView1.setId(R.id.scroll_image);
    localImageView1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    locala.addView(localImageView1);
    if (paramBoolean)
    {
      ImageView localImageView2 = new ImageView(this.a);
      localImageView2.setId(R.id.play_btn);
      localImageView2.setBackgroundResource(R.drawable.ic_preview_media_play);
      localImageView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
      locala.addView(localImageView2);
    }
    return new b(paramInt, locala, localImageViewTouch, localImageView1);
  }

  private void a(b paramb, an.c paramc)
  {
    if (paramc.a)
    {
      paramb.d.setImageBitmap(null);
      paramb.d.setVisibility(8);
      paramb.c.setVisibility(0);
      if (paramc.e.b != null)
      {
        paramb.c.a(null, false);
        paramb.c.c();
        paramb.c.setImageDrawable(paramc.e.b);
        paramb.c.setAdjustViewBounds(true);
        paramb.c.setPadding((int)this.b, (int)this.c, (int)this.d, (int)this.e);
        this.o = paramc.e.b;
        if (!this.o.isPlaying())
          this.o.start();
        return;
      }
      paramb.c.setAdjustViewBounds(false);
      paramb.c.a(paramc.e.a, true);
      paramb.c.setPadding(0, 0, 0, 0);
      this.o = null;
      return;
    }
    paramb.d.setImageBitmap(paramc.e.a);
    paramb.d.setVisibility(0);
    if (paramc.e.a())
    {
      paramb.d.getLayoutParams().height = -1;
      paramb.d.getLayoutParams().width = -1;
      paramb.d.setPadding((int)this.b, (int)this.c, (int)this.d, (int)this.e);
    }
    while (true)
    {
      paramb.c.setVisibility(8);
      paramb.c.setImageDrawable(null);
      paramb.c.a(null, true);
      return;
      paramb.d.getLayoutParams().height = paramc.c;
      paramb.d.getLayoutParams().width = paramc.b;
      paramb.d.setPadding(0, 0, 0, 0);
      this.o = null;
    }
  }

  public void a()
  {
    this.k = true;
    this.j.c();
    if (this.o != null)
      this.o.pause();
  }

  public void a(int paramInt)
  {
    this.k = false;
    for (int i1 = 0; i1 < this.i.getChildCount(); i1++)
    {
      View localView = this.i.getChildAt(i1).findViewById(R.id.container);
      if (localView != null)
      {
        b localb = (b)localView.getTag();
        if (paramInt != localb.a)
        {
          localb.c.b(1.0F);
          if ((localb.c.getDrawable() instanceof b))
            ((b)localb.c.getDrawable()).seekTo(0);
        }
      }
    }
    if ((paramInt < this.g.size()) && (!this.h.contains(Integer.valueOf(paramInt))))
    {
      if ((this.m == paramInt) && (this.o != null) && (!this.o.isPlaying()))
        this.o.start();
      this.m = paramInt;
      GalleryItem localGalleryItem = (GalleryItem)this.g.get(paramInt);
      this.j.d(paramInt, localGalleryItem.getItemUri(), localGalleryItem.getMimeType());
    }
  }

  public void a(int paramInt, View paramView)
  {
    if (this.l != null)
    {
      this.g.add(paramInt, this.l.second);
      this.l = null;
    }
  }

  public void a(int paramInt, an.c paramc)
  {
    int i1 = this.i.getChildCount();
    for (int i2 = 0; ; i2++)
      if (i2 < i1)
      {
        View localView = this.i.getChildAt(i2).findViewById(R.id.container);
        if (localView != null)
        {
          b localb = (b)localView.getTag();
          if (localb.a == paramInt)
            a(localb, paramc);
        }
      }
      else
      {
        return;
      }
  }

  public void a(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
      this.h.add(Integer.valueOf(paramInt));
    if (paramBoolean1)
      this.j.c();
    while ((this.l != null) || (paramBoolean2))
      return;
    GalleryItem localGalleryItem = (GalleryItem)this.g.get(paramInt);
    this.j.d(paramInt, localGalleryItem.getItemUri(), localGalleryItem.getMimeType());
  }

  public void a(an paraman)
  {
    this.j = paraman;
  }

  public void b(int paramInt, View paramView)
  {
    this.l = new Pair(Integer.valueOf(paramInt), this.g.remove(paramInt));
  }

  public void c(int paramInt, View paramView)
  {
    this.j.a();
    this.h.remove(Integer.valueOf(paramInt));
    GalleryItem localGalleryItem;
    if (this.l != null)
    {
      localGalleryItem = (GalleryItem)this.l.second;
      this.l = null;
    }
    while (true)
    {
      if (localGalleryItem.hasDoodle())
      {
        Handler localHandler = this.n;
        Uri[] arrayOfUri = new Uri[1];
        arrayOfUri[0] = localGalleryItem.getOriginalUri();
        localHandler.post(new a(arrayOfUri));
      }
      return;
      localGalleryItem = (GalleryItem)this.g.remove(paramInt);
    }
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramObject == null);
    b localb;
    do
    {
      return;
      localb = (b)((View)paramObject).getTag();
    }
    while (localb == null);
    localb.c.setImageBitmap(null);
    localb.d.setImageBitmap(null);
  }

  public int getCount()
  {
    int i1 = this.g.size();
    if (this.l != null)
      i1++;
    return i1;
  }

  public int getItemPosition(Object paramObject)
  {
    return -2;
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.j == null)
      throw new IllegalStateException("mImageFetcher is not set to adapter. Use setImageFetcher() to assign image fetcher.");
    GalleryItem localGalleryItem;
    Uri localUri;
    b localb;
    if ((this.l != null) && (paramInt == ((Integer)this.l.first).intValue()))
    {
      localGalleryItem = (GalleryItem)this.l.second;
      localUri = localGalleryItem.getItemUri();
      localb = a(paramInt, j.e(localUri));
      localb.b.setTag(localb);
      if (paramInt != this.m)
        break label175;
      a(localb, this.j.c(paramInt, localUri, localGalleryItem.getMimeType()));
    }
    while (true)
    {
      return localb.b;
      if ((this.l != null) && (paramInt > ((Integer)this.l.first).intValue()))
      {
        localGalleryItem = (GalleryItem)this.g.get(paramInt - 1);
        break;
      }
      localGalleryItem = (GalleryItem)this.g.get(paramInt);
      break;
      label175: this.j.b(paramInt, localUri, localGalleryItem.getMimeType());
    }
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }

  public void notifyDataSetChanged()
  {
    if (!this.k)
      super.notifyDataSetChanged();
  }

  private static class a extends FrameLayout
  {
    private a(Context paramContext)
    {
      super();
    }

    public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
    {
      super.setOnTouchListener(paramOnTouchListener);
      findViewById(R.id.image).setOnTouchListener(paramOnTouchListener);
    }
  }

  static class b
  {
    final int a;
    final View b;
    final ImageViewTouch c;
    final ImageView d;

    b(int paramInt, View paramView, ImageViewTouch paramImageViewTouch, ImageView paramImageView)
    {
      this.a = paramInt;
      this.b = paramView;
      this.c = paramImageViewTouch;
      this.d = paramImageView;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.preview.d
 * JD-Core Version:    0.6.2
 */