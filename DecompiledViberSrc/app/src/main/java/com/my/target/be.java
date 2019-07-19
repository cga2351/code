package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.my.target.common.a.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class be
{
  private static final WeakHashMap<ImageView, b> a = new WeakHashMap();
  private final List<b> b;
  private a c;
  private boolean d;

  private be(List<b> paramList)
  {
    this.b = paramList;
  }

  public static be a(b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramb);
    return new be(localArrayList);
  }

  public static be a(List<b> paramList)
  {
    return new be(paramList);
  }

  public static void a(final b paramb, ImageView paramImageView)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
      dp.b("[ImageLoader] method loadAndDisplay called from worker thread");
    while (a.get(paramImageView) == paramb)
      return;
    a.remove(paramImageView);
    if (paramb.e() != null)
    {
      b(paramb.e(), paramImageView);
      return;
    }
    a.put(paramImageView, paramb);
    WeakReference localWeakReference = new WeakReference(paramImageView);
    a(paramb).a(new a()
    {
      public void a()
      {
        ImageView localImageView = (ImageView)this.a.get();
        if (localImageView != null)
        {
          b localb = (b)be.a().get(localImageView);
          if (paramb == localb)
          {
            be.a().remove(localImageView);
            Bitmap localBitmap = paramb.e();
            if (localBitmap != null)
              be.a(localBitmap, localImageView);
          }
        }
      }
    }).a(paramImageView.getContext());
  }

  private void b()
  {
    if (this.c == null)
      return;
    dq.c(new Runnable()
    {
      public void run()
      {
        if (be.b(be.this) != null)
        {
          be.b(be.this).a();
          be.a(be.this, null);
        }
      }
    });
  }

  private static void b(Bitmap paramBitmap, ImageView paramImageView)
  {
    if ((paramImageView instanceof ax))
    {
      ((ax)paramImageView).a(paramBitmap, true);
      return;
    }
    paramImageView.setImageBitmap(paramBitmap);
  }

  public static void b(b paramb, ImageView paramImageView)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
      dp.b("[ImageLoader] method cancel called from worker thread");
    while (a.get(paramImageView) != paramb)
      return;
    a.remove(paramImageView);
  }

  public be a(a parama)
  {
    this.c = parama;
    return this;
  }

  public void a(Context paramContext)
  {
    if (this.b.isEmpty())
    {
      b();
      return;
    }
    dq.a(new Runnable()
    {
      public void run()
      {
        be.this.b(this.a);
        be.a(be.this);
      }
    });
  }

  public void b(Context paramContext)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      dp.b("[ImageLoader] method loadSync called from main thread");
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if (this.d);
    for (t localt = t.b(); ; localt = t.a())
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.e() == null)
        {
          Bitmap localBitmap = (Bitmap)localt.c(localb.a(), localContext);
          if (localBitmap != null)
          {
            localb.a(localBitmap);
            if ((localb.c() == 0) || (localb.b() == 0))
            {
              localb.b(localBitmap.getHeight());
              localb.a(localBitmap.getWidth());
            }
          }
        }
      }
      break;
    }
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.be
 * JD-Core Version:    0.6.2
 */