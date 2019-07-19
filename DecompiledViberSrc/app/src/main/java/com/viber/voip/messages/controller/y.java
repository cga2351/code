package com.viber.voip.messages.controller;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.f;
import com.viber.voip.b.a;
import com.viber.voip.b.a.c;
import com.viber.voip.b.d;
import com.viber.voip.messages.d.l;
import com.viber.voip.util.ap;
import com.viber.voip.util.bu;
import com.viber.voip.util.dv;
import com.viber.voip.util.upload.b.a;
import com.viber.voip.util.upload.b.b;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import pl.droidsonroids.gif.b;

public class y
{
  private static final Logger a = ViberEnv.getLogger();
  private Map<String, aa> b = new HashMap();
  private Set<d> c = new HashSet();
  private Map<String, b> d = new HashMap();
  private c<String> e = (c)ViberApplication.getInstance().getCacheManager().a(a.f);
  private final Object f = new Object();
  private final Set<Uri> g = Collections.synchronizedSet(new HashSet());

  public static y a()
  {
    return c.a();
  }

  public static String a(l paraml)
  {
    return bu.a(String.valueOf(paraml.hashCode()));
  }

  private void a(b paramb)
  {
    if (paramb.c() == 0)
      paramb.pause();
  }

  private void b(b paramb)
  {
    if (paramb.c() == 0)
      paramb.start();
  }

  public aa a(String paramString)
  {
    return (aa)this.b.get(paramString);
  }

  public aa a(String paramString, aa paramaa)
  {
    if (this.b.get(paramString) == null)
      this.b.put(paramString, paramaa);
    return a(paramString);
  }

  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return;
      Iterator localIterator2 = this.c.iterator();
      while (localIterator2.hasNext())
        ((d)localIterator2.next()).O_();
      continue;
      Iterator localIterator1 = this.c.iterator();
      while (localIterator1.hasNext())
        ((d)localIterator1.next()).g();
    }
  }

  public void a(Uri paramUri, ImageView paramImageView, a parama)
  {
    a(null, paramUri, paramImageView, parama, -1, dv.u);
  }

  public void a(Uri paramUri, a parama)
  {
    a(paramUri, parama, -1, dv.u);
  }

  public void a(Uri paramUri, a parama, int paramInt, dv paramdv)
  {
    new b(null, paramUri, parama, "", paramInt, paramdv).executeOnExecutor(av.f.c, new Object[0]);
  }

  public void a(ImageView paramImageView)
  {
    if (paramImageView == null);
    String str;
    do
    {
      return;
      str = (String)paramImageView.getTag();
    }
    while ((str == null) || ((b)this.d.get(str) == null));
    paramImageView.setTag(null);
    this.d.remove(str);
  }

  public void a(d paramd)
  {
    this.c.add(paramd);
  }

  public void a(l paraml, Uri paramUri, ImageView paramImageView, a parama)
  {
    a(a(paraml), paramUri, paramImageView, parama, -1, dv.u);
  }

  public void a(String paramString, Drawable paramDrawable)
  {
    aa localaa = a(paramString);
    if ((localaa != null) && (localaa.b))
    {
      if ((paramDrawable instanceof b))
        b((b)paramDrawable);
      localaa.b = false;
      localaa.a = true;
      b(paramString, localaa);
    }
  }

  public void a(String paramString, Uri paramUri, ImageView paramImageView, a parama, int paramInt, dv paramdv)
  {
    a(paramString, paramUri, paramImageView, parama, paramInt, paramdv, true);
  }

  public void a(String paramString, Uri paramUri, ImageView paramImageView, a parama, int paramInt, dv paramdv, boolean paramBoolean)
  {
    String str = (String)paramImageView.getTag();
    if ((paramString != null) && (paramString.equals(str)))
      return;
    a(paramImageView);
    if (paramString != null);
    for (b localb = this.e.a(paramString); (localb == null) || (!paramBoolean); localb = null)
    {
      paramImageView.setImageDrawable(null);
      b localb1 = new b(paramImageView, paramUri, parama, paramString, paramInt, paramdv);
      this.d.put(paramString, localb1);
      localb1.executeOnExecutor(av.f.c, new Object[0]);
      return;
    }
    if (parama != null)
    {
      parama.b(localb, paramString, paramUri);
      parama.a(paramImageView, localb);
      parama.a(localb, paramString, paramUri);
      return;
    }
    paramImageView.setTag(null);
    paramImageView.setImageDrawable(localb);
  }

  public void a(String paramString, Uri paramUri, ImageView paramImageView, a parama, boolean paramBoolean)
  {
    a(paramString, paramUri, paramImageView, parama, -1, dv.u, paramBoolean);
  }

  public void a(b paramb, String paramString)
  {
    if (paramb == null);
    aa localaa;
    do
    {
      return;
      localaa = a(paramString);
      if (localaa == null)
        localaa = a(paramString, new aa(true));
    }
    while (localaa == null);
    if ((!localaa.a) || (localaa.b))
    {
      a(paramb);
      return;
    }
    b(paramb);
  }

  public void b()
  {
    this.b.clear();
    this.c.clear();
    this.d.clear();
  }

  public void b(d paramd)
  {
    this.c.remove(paramd);
  }

  public void b(String paramString, Drawable paramDrawable)
  {
    aa localaa = a(paramString);
    if ((localaa != null) && (localaa.a))
    {
      if ((paramDrawable instanceof b))
        a((b)paramDrawable);
      localaa.b = true;
      b(paramString, localaa);
    }
  }

  public void b(String paramString, aa paramaa)
  {
    if (this.b.get(paramString) != null)
      this.b.put(paramString, paramaa);
  }

  public void c()
  {
    this.b.clear();
    this.c.clear();
  }

  public static abstract interface a
  {
    public abstract void a(ImageView paramImageView, b paramb);

    public abstract void a(b paramb, String paramString, Uri paramUri);

    public abstract void b(b paramb, String paramString, Uri paramUri);
  }

  private class b extends AsyncTask<Object, Void, b>
  {
    private final WeakReference<ImageView> b;
    private final WeakReference<y.a> c;
    private final Uri d;
    private final String e;
    private final int f;
    private dv g;

    public b(ImageView paramUri, Uri parama, y.a paramString, String paramInt, int paramdv, dv arg7)
    {
      this.e = paramInt;
      if (paramUri != null)
        paramUri.setTag(paramInt);
      this.b = new WeakReference(paramUri);
      this.c = new WeakReference(paramString);
      this.f = paramdv;
      Object localObject;
      this.g = localObject;
      this.d = parama;
    }

    private void a(Uri paramUri)
    {
      synchronized (y.b(y.this))
      {
        y.a(y.this).remove(paramUri);
        y.b(y.this).notifyAll();
        return;
      }
    }

    private void a(b.a parama, String paramString)
    {
      if ((parama.a() != null) && (parama.a().a()))
        ViberApplication.getInstance().getDownloadValve().a(paramString);
    }

    // ERROR //
    protected b a(Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   4: astore_2
      //   5: invokestatic 106	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
      //   8: astore_3
      //   9: invokestatic 86	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
      //   12: astore 4
      //   14: aload_0
      //   15: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   18: invokevirtual 112	android/net/Uri:getScheme	()Ljava/lang/String;
      //   21: ifnull +344 -> 365
      //   24: aload_0
      //   25: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   28: invokevirtual 112	android/net/Uri:getScheme	()Ljava/lang/String;
      //   31: ldc 114
      //   33: invokevirtual 120	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   36: ifeq +329 -> 365
      //   39: aload_0
      //   40: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   43: invokevirtual 123	android/net/Uri:toString	()Ljava/lang/String;
      //   46: astore 15
      //   48: aload_0
      //   49: getfield 47	com/viber/voip/messages/controller/y$b:g	Lcom/viber/voip/util/dv;
      //   52: aload_3
      //   53: aload 15
      //   55: iconst_0
      //   56: invokevirtual 128	com/viber/voip/util/dv:b	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/io/File;
      //   59: astore 16
      //   61: aconst_null
      //   62: astore 8
      //   64: aload 16
      //   66: ifnonnull +6 -> 72
      //   69: aload 8
      //   71: areturn
      //   72: aload 16
      //   74: invokevirtual 133	java/io/File:getPath	()Ljava/lang/String;
      //   77: astore 17
      //   79: new 130	java/io/File
      //   82: dup
      //   83: aload 17
      //   85: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
      //   88: astore 18
      //   90: aload 18
      //   92: invokevirtual 138	java/io/File:exists	()Z
      //   95: ifne +264 -> 359
      //   98: aload 4
      //   100: invokevirtual 90	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
      //   103: aload 15
      //   105: invokevirtual 140	com/viber/voip/util/ap:c	(Ljava/lang/String;)Z
      //   108: ifeq +251 -> 359
      //   111: aload_0
      //   112: getfield 24	com/viber/voip/messages/controller/y$b:a	Lcom/viber/voip/messages/controller/y;
      //   115: invokestatic 58	com/viber/voip/messages/controller/y:a	(Lcom/viber/voip/messages/controller/y;)Ljava/util/Set;
      //   118: aload_0
      //   119: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   122: invokeinterface 143 2 0
      //   127: ifeq +181 -> 308
      //   130: aload_0
      //   131: getfield 24	com/viber/voip/messages/controller/y$b:a	Lcom/viber/voip/messages/controller/y;
      //   134: invokestatic 55	com/viber/voip/messages/controller/y:b	(Lcom/viber/voip/messages/controller/y;)Ljava/lang/Object;
      //   137: astore 23
      //   139: aload 23
      //   141: monitorenter
      //   142: aload_0
      //   143: getfield 24	com/viber/voip/messages/controller/y$b:a	Lcom/viber/voip/messages/controller/y;
      //   146: invokestatic 58	com/viber/voip/messages/controller/y:a	(Lcom/viber/voip/messages/controller/y;)Ljava/util/Set;
      //   149: aload_0
      //   150: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   153: invokeinterface 143 2 0
      //   158: ifeq +32 -> 190
      //   161: aload_0
      //   162: invokevirtual 146	com/viber/voip/messages/controller/y$b:isCancelled	()Z
      //   165: istore 26
      //   167: iload 26
      //   169: ifne +21 -> 190
      //   172: aload_0
      //   173: getfield 24	com/viber/voip/messages/controller/y$b:a	Lcom/viber/voip/messages/controller/y;
      //   176: invokestatic 55	com/viber/voip/messages/controller/y:b	(Lcom/viber/voip/messages/controller/y;)Ljava/lang/Object;
      //   179: invokevirtual 149	java/lang/Object:wait	()V
      //   182: goto -40 -> 142
      //   185: astore 27
      //   187: goto -45 -> 142
      //   190: aload_0
      //   191: getfield 24	com/viber/voip/messages/controller/y$b:a	Lcom/viber/voip/messages/controller/y;
      //   194: invokestatic 58	com/viber/voip/messages/controller/y:a	(Lcom/viber/voip/messages/controller/y;)Ljava/util/Set;
      //   197: aload_0
      //   198: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   201: invokeinterface 152 2 0
      //   206: pop
      //   207: aload 23
      //   209: monitorexit
      //   210: aload 18
      //   212: invokevirtual 138	java/io/File:exists	()Z
      //   215: ifne +136 -> 351
      //   218: aload 4
      //   220: invokevirtual 90	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
      //   223: aload 15
      //   225: invokevirtual 140	com/viber/voip/util/ap:c	(Ljava/lang/String;)Z
      //   228: ifeq +123 -> 351
      //   231: aload 16
      //   233: invokestatic 157	com/viber/voip/util/at:g	(Ljava/io/File;)Ljava/io/File;
      //   236: astore 22
      //   238: aload 22
      //   240: ifnonnull +88 -> 328
      //   243: new 72	com/viber/voip/util/upload/b$a
      //   246: dup
      //   247: new 159	java/lang/Exception
      //   250: dup
      //   251: new 161	java/lang/StringBuilder
      //   254: dup
      //   255: invokespecial 162	java/lang/StringBuilder:<init>	()V
      //   258: ldc 164
      //   260: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: aload 22
      //   265: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   268: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   271: invokespecial 173	java/lang/Exception:<init>	(Ljava/lang/String;)V
      //   274: ldc 175
      //   276: invokespecial 178	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;Ljava/lang/String;)V
      //   279: athrow
      //   280: astore 21
      //   282: aload_0
      //   283: aload 21
      //   285: aload 15
      //   287: invokespecial 180	com/viber/voip/messages/controller/y$b:a	(Lcom/viber/voip/util/upload/b$a;Ljava/lang/String;)V
      //   290: aload_0
      //   291: aload_0
      //   292: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   295: invokespecial 182	com/viber/voip/messages/controller/y$b:a	(Landroid/net/Uri;)V
      //   298: aconst_null
      //   299: areturn
      //   300: astore 24
      //   302: aload 23
      //   304: monitorexit
      //   305: aload 24
      //   307: athrow
      //   308: aload_0
      //   309: getfield 24	com/viber/voip/messages/controller/y$b:a	Lcom/viber/voip/messages/controller/y;
      //   312: invokestatic 58	com/viber/voip/messages/controller/y:a	(Lcom/viber/voip/messages/controller/y;)Ljava/util/Set;
      //   315: aload_0
      //   316: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   319: invokeinterface 152 2 0
      //   324: pop
      //   325: goto -115 -> 210
      //   328: new 184	com/viber/voip/util/upload/b
      //   331: dup
      //   332: aload 15
      //   334: aload 17
      //   336: aload 22
      //   338: invokevirtual 133	java/io/File:getPath	()Ljava/lang/String;
      //   341: aload_0
      //   342: getfield 45	com/viber/voip/messages/controller/y$b:f	I
      //   345: invokespecial 187	com/viber/voip/util/upload/b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
      //   348: invokevirtual 189	com/viber/voip/util/upload/b:f	()V
      //   351: aload_0
      //   352: aload_0
      //   353: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   356: invokespecial 182	com/viber/voip/messages/controller/y$b:a	(Landroid/net/Uri;)V
      //   359: aload 18
      //   361: invokestatic 193	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
      //   364: astore_2
      //   365: new 195	pl/droidsonroids/gif/f
      //   368: dup
      //   369: invokespecial 196	pl/droidsonroids/gif/f:<init>	()V
      //   372: astore 5
      //   374: aload 5
      //   376: aload_2
      //   377: sipush 400
      //   380: sipush 960
      //   383: invokestatic 201	com/viber/voip/util/aw:a	(Landroid/net/Uri;II)I
      //   386: invokevirtual 204	pl/droidsonroids/gif/f:a	(I)V
      //   389: new 206	com/viber/voip/util/e/m
      //   392: dup
      //   393: invokespecial 207	com/viber/voip/util/e/m:<init>	()V
      //   396: aload_3
      //   397: invokevirtual 213	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   400: aload_2
      //   401: invokevirtual 216	com/viber/voip/util/e/m:a	(Landroid/content/ContentResolver;Landroid/net/Uri;)Lpl/droidsonroids/gif/d;
      //   404: checkcast 218	pl/droidsonroids/gif/c
      //   407: aload 5
      //   409: invokevirtual 221	pl/droidsonroids/gif/c:a	(Lpl/droidsonroids/gif/f;)Lpl/droidsonroids/gif/d;
      //   412: checkcast 218	pl/droidsonroids/gif/c
      //   415: invokevirtual 224	pl/droidsonroids/gif/c:c	()Lpl/droidsonroids/gif/b;
      //   418: astore 11
      //   420: aload 11
      //   422: astore 7
      //   424: aload 7
      //   426: iconst_0
      //   427: invokevirtual 227	pl/droidsonroids/gif/b:a	(I)V
      //   430: aload_0
      //   431: getfield 29	com/viber/voip/messages/controller/y$b:e	Ljava/lang/String;
      //   434: ifnull +22 -> 456
      //   437: aload_0
      //   438: getfield 24	com/viber/voip/messages/controller/y$b:a	Lcom/viber/voip/messages/controller/y;
      //   441: invokestatic 230	com/viber/voip/messages/controller/y:c	(Lcom/viber/voip/messages/controller/y;)Lcom/viber/voip/b/a/c;
      //   444: aload_0
      //   445: getfield 29	com/viber/voip/messages/controller/y$b:e	Ljava/lang/String;
      //   448: aload 7
      //   450: invokeinterface 235 3 0
      //   455: pop
      //   456: aload 7
      //   458: astore 8
      //   460: aload_0
      //   461: getfield 43	com/viber/voip/messages/controller/y$b:c	Ljava/lang/ref/WeakReference;
      //   464: invokevirtual 239	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   467: checkcast 241	com/viber/voip/messages/controller/y$a
      //   470: astore 9
      //   472: aload 9
      //   474: ifnull -405 -> 69
      //   477: aload 9
      //   479: aload 8
      //   481: aload_0
      //   482: getfield 29	com/viber/voip/messages/controller/y$b:e	Ljava/lang/String;
      //   485: aload_0
      //   486: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   489: invokeinterface 244 4 0
      //   494: aload 8
      //   496: areturn
      //   497: astore 20
      //   499: aload_0
      //   500: aload_0
      //   501: getfield 49	com/viber/voip/messages/controller/y$b:d	Landroid/net/Uri;
      //   504: invokespecial 182	com/viber/voip/messages/controller/y$b:a	(Landroid/net/Uri;)V
      //   507: aload 20
      //   509: athrow
      //   510: astore 10
      //   512: aconst_null
      //   513: astore 7
      //   515: aload 7
      //   517: astore 8
      //   519: goto -59 -> 460
      //   522: astore 13
      //   524: goto -9 -> 515
      //   527: astore 6
      //   529: aconst_null
      //   530: astore 7
      //   532: goto -17 -> 515
      //   535: astore 12
      //   537: goto -22 -> 515
      //
      // Exception table:
      //   from	to	target	type
      //   172	182	185	java/lang/InterruptedException
      //   210	238	280	com/viber/voip/util/upload/b$a
      //   243	280	280	com/viber/voip/util/upload/b$a
      //   328	351	280	com/viber/voip/util/upload/b$a
      //   142	167	300	finally
      //   172	182	300	finally
      //   190	210	300	finally
      //   302	305	300	finally
      //   210	238	497	finally
      //   243	280	497	finally
      //   282	290	497	finally
      //   328	351	497	finally
      //   365	420	510	java/lang/RuntimeException
      //   424	456	522	java/lang/RuntimeException
      //   365	420	527	java/io/IOException
      //   424	456	535	java/io/IOException
    }

    protected void a(b paramb)
    {
      if (isCancelled());
      y.a locala;
      ImageView localImageView;
      do
      {
        return;
        y.d(y.this).remove(this.e);
        locala = (y.a)this.c.get();
        localImageView = (ImageView)this.b.get();
        if (localImageView == null)
          break;
      }
      while ((this.e != null) && (!this.e.equals(localImageView.getTag())));
      if (locala != null)
      {
        locala.a(localImageView, paramb);
        if (locala == null)
          break label128;
        locala.a(paramb, this.e, this.d);
      }
      while (true)
      {
        super.onPostExecute(paramb);
        return;
        localImageView.setTag(null);
        localImageView.setImageDrawable(paramb);
        break;
        label128: if (localImageView != null)
        {
          localImageView.setTag(null);
          localImageView.setImageDrawable(paramb);
        }
      }
    }

    protected void b(b paramb)
    {
      super.onCancelled(paramb);
      y.d(y.this).remove(this.e);
    }
  }

  private static final class c
  {
    private static final y a = new y(null);
  }

  public static abstract interface d
  {
    public abstract void O_();

    public abstract void g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.y
 * JD-Core Version:    0.6.2
 */