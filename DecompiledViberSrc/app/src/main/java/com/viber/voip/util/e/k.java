package com.viber.voip.util.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.f;
import com.viber.voip.model.j;
import com.viber.voip.util.at;
import com.viber.voip.util.bj;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import com.viber.voip.util.dx.b;
import com.viber.voip.util.dx.c;
import com.viber.voip.util.dx.d;
import com.viber.voip.util.dx.e;
import com.viber.voip.util.upload.i.c;
import com.viber.voip.util.upload.i.o;
import com.viber.voip.widget.GroupIconView;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k
  implements h
{
  private static final Logger d = ViberEnv.getLogger();
  private static final Object h = new Object();
  private static final Set<String> j = Collections.synchronizedSet(new HashSet());
  boolean a = false;
  Resources b;
  protected Context c;
  private d e;
  private boolean f = false;
  private final Object g = new Object();
  private h.a i;
  private final AtomicInteger k = new AtomicInteger();

  protected k(Context paramContext)
  {
    this.b = paramContext.getResources();
    this.c = paramContext.getApplicationContext();
  }

  public static Bitmap a(f paramf)
  {
    Integer localInteger = paramf.b;
    Bitmap localBitmap = null;
    if (localInteger != null)
      localBitmap = ((com.viber.voip.b.a.b)ViberApplication.getInstance().getCacheManager().a(paramf.l)).a(paramf.b);
    return localBitmap;
  }

  static a a(int paramInt, l paraml)
  {
    if (paraml != null)
    {
      Drawable localDrawable = paraml.b(paramInt);
      if ((localDrawable instanceof a))
        return (a)((a)localDrawable).a();
    }
    return null;
  }

  private static String a(Uri paramUri)
  {
    if (paramUri != null)
      return paramUri.getLastPathSegment();
    return "";
  }

  private void a(int paramInt, l paraml, Drawable paramDrawable, f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = 0;
    if (paramf.g)
      paramDrawable.setDither(true);
    if ((paramBoolean1) && (paramf.d))
    {
      TransitionDrawable localTransitionDrawable = new TransitionDrawable(new Drawable[] { paraml.a(b(paramf), this.c, true), paramDrawable });
      int n = localTransitionDrawable.getNumberOfLayers();
      while (m < n)
      {
        localTransitionDrawable.setId(m, m);
        m++;
      }
      paraml.b(paramInt, localTransitionDrawable);
      localTransitionDrawable.startTransition(200);
      return;
    }
    if (paramBoolean2)
    {
      paraml.b(paramInt, paramDrawable);
      return;
    }
    paraml.a(paramInt, paramDrawable);
  }

  private void a(int paramInt, l paraml, f paramf, h.a parama)
  {
    Bitmap localBitmap = a(paramf);
    if (paraml != null)
    {
      if (localBitmap == null)
        break label54;
      a(paramInt, paraml, paraml.a(localBitmap, this.c, true), paramf, false, true);
    }
    while (true)
    {
      if (parama != null)
        parama.onLoadComplete(null, localBitmap, true);
      return;
      label54: paraml.b(paramInt, null);
    }
  }

  private void a(Uri paramUri, l paraml, f paramf, h.a parama, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    if (paramf == null)
      throw new IllegalArgumentException("ImageFetcherConfig can't be null");
    int m = this.k.incrementAndGet();
    if (paraml != null)
      paraml.a(m);
    if ((paramUri == null) || (paramUri.getPath() == null))
    {
      a(m, paraml, paramf, parama);
      return;
    }
    String str = b(paramUri, paramf, true);
    if ((this.e != null) && (paramf.e) && (!paramf.i));
    for (Bitmap localBitmap = this.e.c(str); ; localBitmap = null)
    {
      if (localBitmap != null)
      {
        if (paraml != null)
          a(m, paraml, paraml.a(localBitmap, this.c, false), paramf, false, true);
        if (parama == null)
          break;
        parama.onLoadComplete(paramUri, localBitmap, false);
        return;
      }
      if (!a(paramUri, m, paraml))
        break;
      if (paramLong == -1L)
      {
        a(paramUri, m, paraml, null, paramf, parama, str);
        return;
      }
      a(paramUri, m, paraml, null, paramf, parama, str, paramLong, paramString1, paramString2, paramInt, paramString3, paramBoolean);
      return;
    }
  }

  static boolean a(Uri paramUri, int paramInt, l paraml)
  {
    if (paraml == null);
    a locala;
    do
    {
      do
        return true;
      while ((paraml instanceof com.viber.voip.util.e.c.c));
      locala = a(paramInt, paraml);
    }
    while (locala == null);
    Uri localUri = locala.a;
    if ((localUri == null) || (!localUri.equals(paramUri)))
    {
      locala.cancel(true);
      return true;
    }
    return false;
  }

  public static boolean a(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if ((localDrawable instanceof a));
    for (a locala = (a)((a)localDrawable).a(); ; locala = null)
    {
      if (locala != null)
      {
        locala.cancel(true);
        return true;
      }
      return false;
    }
  }

  private static Bitmap b(f paramf)
  {
    Integer localInteger = paramf.a;
    Bitmap localBitmap = null;
    if (localInteger != null)
      localBitmap = ((com.viber.voip.b.a.b)ViberApplication.getInstance().getCacheManager().a(paramf.l)).a(paramf.a);
    return localBitmap;
  }

  private static String b(Uri paramUri, f paramf, boolean paramBoolean)
  {
    if (paramUri == null)
      return "null";
    return c(paramUri, paramf, paramBoolean);
  }

  private void b(Uri paramUri, l paraml, f paramf, h.a parama)
  {
    a(paramUri, paraml, paramf, parama, -1L, null, null, -1, null, false);
  }

  private static String c(Uri paramUri, f paramf, boolean paramBoolean)
  {
    String str1 = paramUri.getPath();
    String str2 = paramUri.getHost();
    String str3 = paramUri.getQuery();
    String str4 = paramUri.getFragment();
    String str5 = paramf.k.a();
    int m = str1.length();
    if (paramBoolean);
    for (int n = str5.length(); ; n = 0)
    {
      int i1 = n + m;
      if (str2 != null)
        i1 += str2.length();
      if (str3 != null)
        i1 += 1 + str3.length();
      if (str4 != null)
        i1 += 1 + str4.length();
      StringBuilder localStringBuilder = new StringBuilder(i1);
      if (paramBoolean)
        localStringBuilder.append(str5);
      if (paramf.j != null)
        localStringBuilder.append(paramf.j.a());
      if (!TextUtils.isEmpty(str2))
        localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      if (!TextUtils.isEmpty(str3))
        localStringBuilder.append('?').append(str3);
      if (!TextUtils.isEmpty(str4))
        localStringBuilder.append('#').append(str4);
      return localStringBuilder.toString();
    }
  }

  protected Bitmap a(String paramString)
  {
    System.currentTimeMillis();
    try
    {
      Bitmap localBitmap2 = this.e.d(paramString);
      localBitmap1 = localBitmap2;
      System.currentTimeMillis();
      return localBitmap1;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        this.e.b(paramString);
        localBitmap1 = null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        d.a(localOutOfMemoryError, "Not enough memory to decode file from disk cache");
        ViberApplication.getInstance().onOutOfMemory();
        Bitmap localBitmap1 = null;
      }
    }
  }

  protected abstract d a(Uri paramUri, f paramf);

  void a()
  {
    if (this.e != null)
      this.e.a();
  }

  void a(Uri paramUri, int paramInt, l paraml, Bitmap paramBitmap, f paramf, h.a parama, String paramString)
  {
    a locala = new a(paraml, paramInt, parama);
    if (paramBitmap == null)
      paramBitmap = b(paramf);
    if (paraml != null)
      a(paramInt, paraml, paraml.a(paramBitmap, this.c, locala), paramf, false, false);
    locala.executeOnExecutor(av.f.c, new Object[] { paramUri, paramf, paramString });
  }

  void a(Uri paramUri, int paramInt1, l paraml, Bitmap paramBitmap, f paramf, h.a parama, String paramString1, long paramLong, String paramString2, String paramString3, int paramInt2, String paramString4, boolean paramBoolean)
  {
    e locale = new e(paraml, paramInt1, parama, paramLong, paramString2, paramString3, paramInt2, paramString4, paramBoolean);
    if (paramBitmap == null)
      paramBitmap = b(paramf);
    if (paraml != null)
    {
      Context localContext = this.c;
      a(paramInt1, paraml, paraml.a(paramBitmap, localContext, locale), paramf, false, false);
    }
    locale.executeOnExecutor(av.f.c, new Object[] { paramUri, paramf, paramString1 });
  }

  public void a(Uri paramUri, ImageView paramImageView, f paramf)
  {
    a(paramUri, paramImageView, paramf, null);
  }

  public void a(Uri paramUri, ImageView paramImageView, f paramf, h.a parama)
  {
    if (paramImageView != null);
    for (com.viber.voip.util.e.c.d locald = new com.viber.voip.util.e.c.d(paramImageView); ; locald = null)
    {
      b(paramUri, locald, paramf, parama);
      return;
    }
  }

  public void a(Uri paramUri, ImageView paramImageView, f paramf, h.a parama, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    com.viber.voip.util.e.c.d locald = new com.viber.voip.util.e.c.d(paramImageView);
    int m = this.k.incrementAndGet();
    locald.a(m);
    int n = 0;
    Object localObject;
    Bitmap localBitmap;
    label136: dx.b localb;
    Uri localUri1;
    int i1;
    if (dx.d(paramUri))
    {
      try
      {
        dx.d locald1 = dx.p(paramUri);
        boolean bool = TextUtils.isEmpty(locald1.e);
        Uri localUri2 = null;
        if (!bool)
        {
          paramUri = paramUri.buildUpon().clearQuery().build();
          localUri2 = Uri.parse(locald1.e);
        }
        localObject = localUri2;
        if ((n == 0) && (!bj.a((Uri)localObject)))
          break label372;
        if ((this.e == null) || (!paramf.e) || (paramf.i))
          break label395;
        localBitmap = this.e.c(b(paramUri, paramf, true));
        if (localBitmap == null)
          break label337;
        if (paramImageView != null)
          a(m, locald, locald.a(localBitmap, this.c, false), paramf, false, true);
        if (parama != null)
          parama.onLoadComplete(paramUri, localBitmap, false);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        do
          d.a(localIllegalArgumentException, "Can't download image");
        while (parama == null);
        parama.onLoadComplete(null, null, true);
        return;
      }
    }
    else if (dx.l(paramUri))
    {
      localb = dx.m(paramUri);
      if (!TextUtils.isEmpty(localb.d))
      {
        localUri1 = Uri.parse(localb.d);
        i1 = 0;
      }
    }
    while (true)
    {
      localObject = localUri1;
      n = i1;
      break;
      if (!TextUtils.isEmpty(localb.e))
      {
        localUri1 = Uri.parse(localb.e);
        i1 = 1;
        continue;
        if (dx.f(paramUri))
        {
          dx.c localc = new dx.c(paramUri);
          if (!TextUtils.isEmpty(localc.b))
          {
            localObject = Uri.parse(localc.b);
            n = 0;
            break;
            label337: this.i = new c(paramUri, m, locald, paramf, parama, true);
            b((Uri)localObject, locald, paramf, this.i);
            return;
            label372: a(paramUri, locald, paramf, parama, paramLong, paramString1, paramString2, paramInt, paramString3, paramBoolean);
            return;
            label395: localBitmap = null;
            break label136;
          }
        }
        n = 0;
        localObject = null;
        break;
      }
      i1 = 0;
      localUri1 = null;
    }
  }

  public void a(Uri paramUri, f paramf, h.a parama)
  {
    b(paramUri, null, paramf, parama);
  }

  public void a(Uri paramUri, l paraml, f paramf)
  {
    a(paramUri, paraml, paramf, null);
  }

  public void a(Uri paramUri, l paraml, f paramf, h.a parama)
  {
    b(paramUri, paraml, paramf, parama);
  }

  public void a(Uri paramUri, GroupIconView paramGroupIconView, f paramf)
  {
    a(paramUri, paramGroupIconView, paramf, null);
  }

  public void a(Uri paramUri, GroupIconView paramGroupIconView, f paramf, h.a parama)
  {
    if (paramGroupIconView != null);
    for (com.viber.voip.util.e.c.c localc = new com.viber.voip.util.e.c.c(paramGroupIconView); ; localc = null)
    {
      b(paramUri, localc, paramf, parama);
      return;
    }
  }

  public void a(com.viber.voip.model.b paramb, Uri paramUri, ImageView paramImageView, f paramf)
  {
    a(paramb, paramUri, paramImageView, paramf, null);
  }

  public void a(com.viber.voip.model.b paramb, Uri paramUri, ImageView paramImageView, f paramf, h.a parama)
  {
    a(paramb, paramUri, paramImageView, paramf, parama, null);
  }

  public void a(com.viber.voip.model.b paramb, Uri paramUri, ImageView paramImageView, f paramf, h.a parama, String paramString)
  {
    if (paramImageView != null);
    int m;
    for (com.viber.voip.util.e.c.d locald = new com.viber.voip.util.e.c.d(paramImageView); ; locald = null)
    {
      m = this.k.incrementAndGet();
      if (locald != null)
        locald.a(m);
      if (paramb != null)
        paramUri = paramb.o();
      if (paramUri != null)
        break;
      a(m, locald, paramf, parama);
      return;
    }
    String str;
    label136: Uri localUri;
    if (paramb != null)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramb.a(paramString) != null))
      {
        str = paramb.a(paramString).d();
        if (TextUtils.isEmpty(str))
          a(m, locald, paramf, parama);
      }
      else
      {
        str = paramb.b();
      }
      if (TextUtils.isEmpty(str))
        break label266;
      localUri = dx.b(str);
      label151: if ((this.e == null) || (!paramf.e) || (paramf.i))
        break label309;
    }
    label266: label309: for (Bitmap localBitmap = this.e.c(b(localUri, paramf, true)); ; localBitmap = null)
    {
      if (localBitmap != null)
      {
        if (locald != null)
          a(m, locald, locald.a(localBitmap, this.c, false), paramf, false, true);
        if (parama == null)
          break;
        parama.onLoadComplete(localUri, localBitmap, false);
        return;
        boolean bool = dx.b(paramUri);
        str = null;
        if (!bool)
          break label136;
        str = a(paramUri);
        break label136;
        localUri = null;
        break label151;
      }
      this.i = new c(localUri, m, locald, paramf, parama, false);
      b(paramUri, locald, paramf, this.i);
      return;
    }
  }

  public void a(d.a parama)
  {
    this.e = new d(parama);
    if (parama.f)
    {
      b localb = new b();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(1);
      localb.execute(arrayOfObject);
    }
  }

  void a(Object paramObject, f[] paramArrayOff)
  {
    int m = 0;
    if (this.e != null)
    {
      if ((paramObject instanceof Collection))
      {
        Iterator localIterator = ((Collection)paramObject).iterator();
        while (localIterator.hasNext())
        {
          Uri localUri = (Uri)localIterator.next();
          int i1 = paramArrayOff.length;
          for (int i2 = 0; i2 < i1; i2++)
          {
            f localf2 = paramArrayOff[i2];
            this.e.b(b(localUri, localf2, true));
          }
        }
      }
      if ((paramObject instanceof Uri))
      {
        int n = paramArrayOff.length;
        while (m < n)
        {
          f localf1 = paramArrayOff[m];
          this.e.b(b((Uri)paramObject, localf1, true));
          m++;
        }
      }
    }
  }

  public void a(Collection<Uri> paramCollection)
  {
    f.a locala = new f.a();
    f[] arrayOff = new f[f.b.values().length];
    for (int m = 0; m < f.b.values().length; m++)
      arrayOff[m] = locala.a(f.b.values()[m]).c();
    a(paramCollection, arrayOff);
  }

  public void a(Collection<Uri> paramCollection, f[] paramArrayOff)
  {
    if (paramCollection == null)
      return;
    if (this.e != null)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Uri localUri = (Uri)localIterator.next();
        int m = paramArrayOff.length;
        for (int n = 0; n < m; n++)
        {
          f localf = paramArrayOff[n];
          this.e.a(b(localUri, localf, true));
        }
      }
    }
    b localb = new b();
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(4);
    arrayOfObject[1] = paramCollection;
    arrayOfObject[2] = paramArrayOff;
    localb.execute(arrayOfObject);
  }

  void b()
  {
    if (this.e != null)
      this.e.b();
  }

  public void b(Uri paramUri)
  {
    a(Collections.singleton(paramUri));
  }

  public void b(Uri paramUri, ImageView paramImageView, f paramf, h.a parama)
  {
    a(paramUri, paramImageView, paramf, parama, -1L, null, null, com.viber.voip.messages.l.a(at.g(paramUri)), null, false);
  }

  public void b(Uri paramUri, f paramf)
  {
    b(paramUri, null, paramf, null);
  }

  @Deprecated
  public void c()
  {
    b localb = new b();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0);
    localb.execute(arrayOfObject);
  }

  class a extends AsyncTask<Object, Void, Bitmap>
  {
    Uri a;
    f b;
    final int c;
    final l d;
    final WeakReference<h.a> e;
    final boolean f;

    public a(l paramInt, int parama, h.a arg4)
    {
      this.d = paramInt;
      this.c = parama;
      Object localObject;
      this.e = new WeakReference(localObject);
      if (paramInt != null);
      for (boolean bool = true; ; bool = false)
      {
        this.f = bool;
        return;
      }
    }

    protected Bitmap a(String paramString)
    {
      if ((!isCancelled()) && ((!this.f) || (a() != null)) && (!k.a(k.this)) && (!this.b.i));
      for (int i = 1; (k.b(k.this) != null) && (this.b.e) && (i != 0); i = 0)
        return k.b(k.this).c(paramString);
      return null;
    }

    protected Bitmap a(Object[] paramArrayOfObject)
    {
      boolean bool1 = true;
      int i = 0;
      System.currentTimeMillis();
      this.a = ((Uri)paramArrayOfObject[0]);
      this.b = ((f)paramArrayOfObject[bool1]);
      String str1 = (String)paramArrayOfObject[2];
      if (TextUtils.isEmpty(str1))
        str1 = k.a(this.a, this.b, bool1);
      Bitmap localBitmap1 = a(str1);
      if (localBitmap1 != null)
        return localBitmap1;
      String str2 = k.a(this.a, this.b, false);
      if (k.e().contains(str2))
        synchronized (k.d())
        {
          while (k.e().contains(str2))
          {
            boolean bool7 = isCancelled();
            if (bool7)
              break;
            try
            {
              k.d().wait();
            }
            catch (InterruptedException localInterruptedException2)
            {
            }
          }
          k.e().add(str2);
        }
      synchronized (k.c(k.this))
      {
        while (k.this.a)
        {
          boolean bool6 = isCancelled();
          if (bool6)
            break;
          try
          {
            k.c(k.this).wait();
          }
          catch (InterruptedException localInterruptedException1)
          {
          }
          continue;
          localObject4 = finally;
          throw localObject4;
          k.e().add(str2);
        }
        Bitmap localBitmap2 = a(str1);
        if (localBitmap2 != null)
        {
          b(str2);
          return localBitmap2;
        }
      }
      boolean bool2;
      Bitmap localBitmap3;
      Bitmap localBitmap4;
      if ((!isCancelled()) && ((!this.f) || (a() != null)) && (!k.a(k.this)))
      {
        bool2 = bool1;
        d locald = k.b(k.this);
        localBitmap3 = null;
        if (locald != null)
        {
          boolean bool4 = this.b.f;
          localBitmap3 = null;
          if (bool4)
          {
            boolean bool5 = this.b.e;
            localBitmap3 = null;
            if (bool5)
            {
              localBitmap3 = null;
              if (bool2)
                localBitmap3 = k.this.a(str1);
            }
          }
        }
        if (((localBitmap3 != null) && (!this.b.i)) || (!bool2))
          break label583;
        Bitmap localBitmap5 = a(this.a, this.b).a;
        if (localBitmap5 == null)
          break label576;
        localBitmap4 = localBitmap5;
        label417: if (localBitmap5 == null)
          break label565;
      }
      while (true)
      {
        label422: if ((bool1) && (this.b.j != null))
          localBitmap4 = this.b.j.a(localBitmap4);
        boolean bool3 = this.b.e;
        if (localBitmap4 == null)
          localBitmap4 = k.a(this.b);
        while (true)
        {
          if ((localBitmap4 != null) && (i != 0) && (k.b(k.this) != null))
          {
            k.b(k.this).a(str1, localBitmap4, this.b.i);
            if (this.b.f)
              k.b(k.this).b(str1, localBitmap4, this.b.i);
          }
          b(str2);
          System.currentTimeMillis();
          return localBitmap4;
          bool2 = false;
          break;
          label565: bool1 = false;
          break label422;
          i = bool3;
        }
        label576: localBitmap4 = localBitmap3;
        break label417;
        label583: localBitmap4 = localBitmap3;
        bool1 = false;
      }
    }

    protected k.d a(Uri paramUri, f paramf)
    {
      return k.this.a(paramUri, paramf);
    }

    protected l a()
    {
      if (this == k.a(this.c, this.d))
        return this.d;
      return null;
    }

    protected void a(Bitmap paramBitmap)
    {
      if ((isCancelled()) || (k.a(k.this)))
        paramBitmap = null;
      boolean bool1;
      l locall;
      if (paramBitmap == k.a(this.b))
      {
        bool1 = true;
        locall = a();
        if ((this.f) && (locall != null))
        {
          if (paramBitmap == null)
            break label159;
          Drawable localDrawable2 = locall.a(paramBitmap, k.this.c, bool1);
          k localk = k.this;
          int i = this.c;
          f localf = this.b;
          boolean bool2 = false;
          if (!bool1)
            bool2 = true;
          k.a(localk, i, locall, localDrawable2, localf, bool2, true);
        }
      }
      while (true)
      {
        h.a locala = (h.a)this.e.get();
        if ((locala != null) && ((!this.f) || (locall != null)))
          locala.onLoadComplete(this.a, paramBitmap, bool1);
        return;
        bool1 = false;
        break;
        label159: Drawable localDrawable1 = locall.b(this.c);
        if ((localDrawable1 instanceof a))
          localDrawable1 = locall.a(((a)localDrawable1).b(), k.this.c, true);
        locall.b(this.c, localDrawable1);
      }
    }

    protected void b(Bitmap paramBitmap)
    {
      super.onCancelled(paramBitmap);
      synchronized (k.c(k.this))
      {
        k.c(k.this).notifyAll();
        return;
      }
    }

    protected void b(String paramString)
    {
      synchronized (k.d())
      {
        k.e().remove(paramString);
        k.d().notifyAll();
        return;
      }
    }
  }

  class b extends AsyncTask<Object, Void, Void>
  {
    b()
    {
    }

    protected Void a(Object[] paramArrayOfObject)
    {
      switch (((Integer)paramArrayOfObject[0]).intValue())
      {
      case 2:
      case 3:
      default:
      case 0:
      case 1:
      case 4:
      }
      while (true)
      {
        return null;
        k.this.b();
        continue;
        k.this.a();
        continue;
        k.this.a(paramArrayOfObject[1], (f[])paramArrayOfObject[2]);
      }
    }
  }

  private class c
    implements h.a
  {
    private final int b;
    private final h.a c;
    private final f d;
    private final Uri e;
    private final l f;
    private final boolean g;

    public c(Uri paramInt, int paraml, l paramf, f parama, h.a paramBoolean, boolean arg7)
    {
      this.b = paraml;
      this.e = paramInt;
      this.f = paramf;
      this.d = parama;
      this.c = paramBoolean;
      boolean bool;
      this.g = bool;
    }

    public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
    {
      k.a(k.this, null);
      if (this.c != null)
        this.c.onLoadComplete(paramUri, paramBitmap, paramBoolean);
      if ((paramUri == null) || ((paramBoolean) && (!this.g)));
      f localf;
      do
      {
        do
          return;
        while (this.e == null);
        localf = this.d.f().b(false).b().c();
      }
      while (!k.a(this.e, this.b, this.f));
      if (this.f != null)
        this.f.a(this.b);
      k.this.a(this.e, this.b, this.f, paramBitmap, localf, this.c, null);
    }
  }

  public static class d
  {
    Bitmap a;
    int b;

    public d(int paramInt, Bitmap paramBitmap)
    {
      this.b = paramInt;
      this.a = paramBitmap;
    }
  }

  class e extends k.a
  {
    private final long i;
    private final String j;
    private final String k;
    private final int l;
    private final String m;
    private final boolean n;

    public e(l paramInt1, int parama, h.a paramLong, long arg5, String paramString2, String paramInt2, int paramString3, String paramBoolean, boolean arg11)
    {
      super(paramInt1, parama, paramLong);
      this.j = paramString2;
      this.i = ???;
      this.k = paramInt2;
      this.l = paramString3;
      this.m = paramBoolean;
      boolean bool1;
      this.n = bool1;
    }

    protected k.d a(Uri paramUri, f paramf)
    {
      k.d locald = super.a(this.a, this.b);
      int i1;
      if (this.l == -1)
      {
        i1 = com.viber.voip.messages.l.a(at.g(paramUri));
        if (locald.a != null)
          break label200;
        if (this.k == null)
          break label131;
        if (!dx.n(paramUri))
          break label119;
      }
      label119: for (String str = dx.o(paramUri).a(); ; str = this.a.toString())
      {
        Uri localUri2 = com.viber.voip.messages.extras.image.c.a(k.this.c, Uri.parse(this.k), dv.q.a(ViberApplication.getApplication(), str, false), i1, false);
        if (localUri2 == null)
          break label200;
        return super.a(localUri2, this.b);
        i1 = this.l;
        break;
      }
      label131: if ((this.j != null) && (locald.b != -5) && (dx.f(paramUri)))
      {
        Uri localUri1 = dx.a(this.j, null, EncryptionParams.unserializeEncryptionParams(this.m), i.c.b, i.o.a, Boolean.valueOf(this.n));
        if (localUri1 != null)
          return super.a(localUri1, this.b);
      }
      label200: return locald;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.k
 * JD-Core Version:    0.6.2
 */