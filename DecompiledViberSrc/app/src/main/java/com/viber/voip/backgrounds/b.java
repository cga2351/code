package com.viber.voip.backgrounds;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.settings.d.i;
import com.viber.voip.util.ap;
import com.viber.voip.util.at;
import com.viber.voip.util.bj;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.j;
import com.viber.voip.util.upload.ObjectId;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile b b;
  private Handler c = av.a(av.e.j);
  private com.viber.voip.backgrounds.c.c d = new com.viber.voip.backgrounds.c.c(this.c, this, new f()
  {
    public void a(a paramAnonymousa)
    {
      Iterator localIterator = new HashSet(b.a(b.this)).iterator();
      while (localIterator.hasNext())
        ((f)localIterator.next()).a(paramAnonymousa);
    }

    public void a(l paramAnonymousl)
    {
      b.a(b.this, paramAnonymousl);
      Iterator localIterator = new HashSet(b.a(b.this)).iterator();
      while (localIterator.hasNext())
        ((f)localIterator.next()).a(paramAnonymousl);
    }

    public void a(l paramAnonymousl, int paramAnonymousInt)
    {
      Iterator localIterator = new HashSet(b.a(b.this)).iterator();
      while (localIterator.hasNext())
        ((f)localIterator.next()).a(paramAnonymousl, paramAnonymousInt);
    }

    public void a(l paramAnonymousl, p paramAnonymousp)
    {
      com.viber.voip.util.e.e.a(ViberApplication.getApplication()).b(Uri.parse(paramAnonymousp.i.getPath()));
      Iterator localIterator = new HashSet(b.a(b.this)).iterator();
      while (localIterator.hasNext())
        ((f)localIterator.next()).a(paramAnonymousl, paramAnonymousp);
    }

    public void b(l paramAnonymousl)
    {
      Iterator localIterator = new HashSet(b.a(b.this)).iterator();
      while (localIterator.hasNext())
        ((f)localIterator.next()).b(paramAnonymousl);
    }
  }
  , this.f);
  private Set<f> e = new HashSet();
  private final com.viber.voip.backgrounds.b.a f = new com.viber.voip.backgrounds.b.a();
  private final com.viber.voip.b.a.b<Uri> g = (com.viber.voip.b.a.b)ViberApplication.getInstance().getCacheManager().a(com.viber.voip.b.a.b);
  private ServiceStateDelegate.ServiceState h;
  private ServiceStateDelegate i = new ServiceStateDelegate()
  {
    public void onServiceStateChanged(int paramAnonymousInt)
    {
      ServiceStateDelegate.ServiceState localServiceState = ServiceStateDelegate.ServiceState.resolveEnum(paramAnonymousInt);
      if (localServiceState == b.b(b.this))
        return;
      switch (b.7.a[localServiceState.ordinal()])
      {
      case 1:
      default:
      case 2:
      }
      while (true)
      {
        b.a(b.this, localServiceState);
        return;
        b.c(b.this).a();
      }
    }
  };

  public static b a()
  {
    if (b == null);
    try
    {
      if (b == null)
      {
        b localb = new b();
        localb.i();
        b = localb;
      }
      return b;
    }
    finally
    {
    }
  }

  private void b(l paraml)
  {
    d.i.c.a(paraml.a().size());
  }

  public static void b(p paramp)
    throws b.a, IllegalArgumentException
  {
    com.viber.voip.backgrounds.c.a.a(Color.parseColor(paramp.c), paramp.d, paramp.e, paramp.h.getPath());
  }

  public static int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    for (String str = "0"; ; str = String.valueOf(paramString))
    {
      String[] arrayOfString = new String[1];
      ViberApplication.getInstance().getEngine(true).getPhoneController().lengthenStandartBackgroundID(str, arrayOfString);
      return Integer.valueOf(arrayOfString[0]).intValue();
    }
  }

  public static ObjectId c(int paramInt)
  {
    String str = String.valueOf(paramInt);
    long[] arrayOfLong = new long[1];
    ViberApplication.getInstance().getEngine(true).getPhoneController().shortenStandardBackgroundID(str, arrayOfLong);
    return ObjectId.fromLong(arrayOfLong[0]);
  }

  private static boolean c(p paramp)
  {
    Uri localUri1 = paramp.a(false);
    Uri localUri2 = paramp.a(true);
    return (localUri2 != null) && (new File(localUri2.getPath()).exists()) && (localUri1 != null) && (new File(localUri1.getPath()).exists());
  }

  private ArrayList<p> d(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = m.b(paramInt, ViberApplication.getApplication()).listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      for (int k = 0; k < j; k++)
      {
        p localp = m.a(arrayOfFile[k].getPath(), paramInt);
        if (localp != null)
          localArrayList.add(localp);
      }
      a(localArrayList);
    }
    return localArrayList;
  }

  private static boolean d(p paramp)
  {
    if (paramp.c());
    try
    {
      b(paramp);
      return true;
    }
    catch (a locala1)
    {
      String str = m.a(paramp.a, g.a, paramp.d());
      try
      {
        paramp.e();
        new com.viber.voip.util.upload.b(str, paramp.h.getPath(), paramp.h.getPath() + ".tmp").f();
        return true;
      }
      catch (com.viber.voip.util.upload.b.a locala)
      {
        return false;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label15: break label15;
    }
  }

  private Uri[] e(int paramInt)
  {
    int j = d.i.a.d();
    List localList = this.f.a();
    Iterator localIterator = localList.iterator();
    p localp2;
    do
    {
      if (!localIterator.hasNext())
        break;
      localp2 = (p)localIterator.next();
    }
    while (localp2.a != paramInt);
    for (String str = localp2.c; ; str = null)
    {
      int k;
      int m;
      label80: s[] arrayOfs;
      Object localObject;
      int n;
      int i1;
      if (!TextUtils.isEmpty(str))
      {
        k = 1;
        if (k == 0)
          break label209;
        m = 3;
        arrayOfs = new s[m];
        arrayOfs[0] = new s(paramInt, j, false, null);
        arrayOfs[1] = new s(paramInt, j, true, null);
        if (k != 0)
          arrayOfs[2] = new s(paramInt, j, true, str);
        localObject = arrayOfs[0];
        n = arrayOfs.length;
        i1 = 0;
      }
      while (true)
      {
        if (i1 >= n)
          break label225;
        s locals = arrayOfs[i1];
        if (c(locals))
        {
          Uri[] arrayOfUri3 = new Uri[2];
          arrayOfUri3[0] = locals.a(false);
          arrayOfUri3[1] = locals.a(true);
          return arrayOfUri3;
          k = 0;
          break;
          label209: m = 2;
          break label80;
        }
        i1++;
        localObject = locals;
      }
      label225: int i3;
      if (!new File(((s)localObject).h.getPath()).exists())
      {
        int i2 = arrayOfs.length;
        i3 = 0;
        if (i3 >= i2)
          break label396;
        localObject = arrayOfs[i3];
        if (!d((p)localObject))
          break label377;
      }
      label396: for (int i4 = 1; ; i4 = 0)
      {
        if (i4 == 0)
        {
          p localp1 = m.a(j, localList);
          localObject = new s(localp1.a, localp1.f, localp1.b(), localp1.c);
        }
        Uri[] arrayOfUri1 = a().a(ViberApplication.getApplication(), (q)localObject);
        if ((arrayOfUri1 != null) && (arrayOfUri1[0] != null) && (arrayOfUri1[1] != null))
        {
          Uri[] arrayOfUri2 = new Uri[2];
          arrayOfUri2[0] = arrayOfUri1[0];
          arrayOfUri2[1] = arrayOfUri1[1];
          return arrayOfUri2;
          label377: i3++;
          break;
        }
        return new Uri[] { null, null };
      }
    }
  }

  private void i()
  {
    k();
  }

  private int j()
  {
    return d.i.c.d();
  }

  private void k()
  {
    ServiceStateListener localServiceStateListener = ViberApplication.getInstance().getEngine(false).getDelegatesManager().getServiceStateListener();
    ServiceStateDelegate[] arrayOfServiceStateDelegate = new ServiceStateDelegate[1];
    arrayOfServiceStateDelegate[0] = this.i;
    localServiceStateListener.registerDelegate(arrayOfServiceStateDelegate);
  }

  public Bitmap a(Uri paramUri)
  {
    Object localObject2;
    if (paramUri == null)
      localObject2 = null;
    while (true)
    {
      return localObject2;
      Application localApplication;
      int[] arrayOfInt;
      synchronized (this.g)
      {
        localObject2 = this.g.a(paramUri);
        localApplication = ViberApplication.getApplication();
        if ((localObject2 != null) || (!com.viber.voip.util.upload.o.c()))
          continue;
        arrayOfInt = j.a(localApplication, false);
      }
      try
      {
        Bitmap localBitmap = j.a(localApplication, paramUri, arrayOfInt[0], arrayOfInt[1], true);
        localObject2 = localBitmap;
        label76: if (localObject2 == null)
          continue;
        synchronized (this.g)
        {
          this.g.a(paramUri, (Bitmap)localObject2);
          return localObject2;
        }
        localObject1 = finally;
        throw localObject1;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          String str1 = d.i.d.d();
          String str2 = d.i.e.d();
          if ((str1.equals(paramUri.toString())) || (str2.equals(paramUri.toString())))
          {
            d.i.d.e();
            b();
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (true)
          a.a(localOutOfMemoryError, "getBackgroundBitmap OutOfMemoryError");
      }
      catch (Exception localException)
      {
        break label76;
      }
    }
  }

  public Uri a(Bitmap paramBitmap, int paramInt1, int paramInt2, Uri paramUri)
  {
    Uri localUri;
    if (paramUri == null)
      localUri = null;
    Bitmap localBitmap;
    do
    {
      return localUri;
      localBitmap = j.b(paramBitmap, paramInt1, paramInt2, false);
      localUri = j.a(localBitmap, new File(paramUri.getPath()));
    }
    while (paramBitmap == localBitmap);
    localBitmap.recycle();
    return localUri;
  }

  public l a(int paramInt)
  {
    if (com.viber.voip.util.upload.o.c())
    {
      Application localApplication = ViberApplication.getApplication();
      File[] arrayOfFile1 = m.b(localApplication).listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return (paramAnonymousFile.isDirectory()) && (TextUtils.isDigitsOnly(paramAnonymousFile.getName()));
        }
      });
      if (arrayOfFile1 != null)
      {
        int j = arrayOfFile1.length;
        int k = 0;
        while (k < j)
        {
          File localFile1 = arrayOfFile1[k];
          try
          {
            int m = Integer.parseInt(localFile1.getName());
            if (m == paramInt)
            {
              l locall = new l(m);
              locall.a(d(m));
              int n = j();
              File localFile2 = m.a(locall, localApplication);
              boolean bool1 = localFile2.exists();
              File[] arrayOfFile2 = null;
              if (bool1)
                arrayOfFile2 = localFile2.listFiles();
              if (arrayOfFile2 == null);
              for (int i1 = 0; ; i1 = arrayOfFile2.length)
              {
                boolean bool2 = false;
                if (n > 0)
                {
                  bool2 = false;
                  if (i1 >= n)
                  {
                    int i2 = locall.a().size();
                    bool2 = false;
                    if (i2 >= n)
                      bool2 = true;
                  }
                }
                locall.a(bool2);
                return locall;
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            k++;
          }
        }
      }
    }
    return null;
  }

  public void a(int paramInt, String paramString1, String paramString2)
  {
    boolean bool = m.a(paramInt);
    d.i.f.a(bool);
    d.i.d.a(paramString1);
    d.i.e.a(paramString2);
    ViberApplication.getInstance().getMessagesManager().c().e();
  }

  // ERROR //
  public void a(android.content.res.AssetManager paramAssetManager, q paramq, String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: aload_3
    //   5: invokevirtual 491	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore 7
    //   10: new 231	java/io/File
    //   13: dup
    //   14: aload_2
    //   15: invokeinterface 496 1 0
    //   20: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   23: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 8
    //   28: aload 8
    //   30: invokestatic 501	com/viber/voip/util/at:d	(Ljava/io/File;)Z
    //   33: pop
    //   34: aload 8
    //   36: invokevirtual 504	java/io/File:createNewFile	()Z
    //   39: pop
    //   40: new 506	java/io/FileOutputStream
    //   43: dup
    //   44: aload 8
    //   46: invokespecial 509	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: astore 6
    //   51: aload 7
    //   53: aload 6
    //   55: invokestatic 514	com/viber/voip/util/bj:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   58: aload 6
    //   60: invokevirtual 519	java/io/OutputStream:flush	()V
    //   63: iconst_2
    //   64: anewarray 521	java/io/Closeable
    //   67: dup
    //   68: iconst_0
    //   69: aload 7
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload 6
    //   76: aastore
    //   77: invokestatic 524	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   80: return
    //   81: astore 5
    //   83: aconst_null
    //   84: astore 6
    //   86: iconst_2
    //   87: anewarray 521	java/io/Closeable
    //   90: dup
    //   91: iconst_0
    //   92: aload 4
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload 6
    //   99: aastore
    //   100: invokestatic 524	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   103: aload 5
    //   105: athrow
    //   106: astore 5
    //   108: aload 7
    //   110: astore 4
    //   112: aconst_null
    //   113: astore 6
    //   115: goto -29 -> 86
    //   118: astore 5
    //   120: aload 7
    //   122: astore 4
    //   124: goto -38 -> 86
    //
    // Exception table:
    //   from	to	target	type
    //   3	10	81	finally
    //   10	51	106	finally
    //   51	63	118	finally
  }

  public void a(f paramf)
  {
    if (!this.e.contains(paramf))
      this.e.add(paramf);
  }

  void a(l paraml)
  {
    boolean bool = paraml.b();
    com.viber.voip.backgrounds.c.g local3 = new com.viber.voip.backgrounds.c.g(paraml.a)
    {
      protected void a(int paramAnonymousInt)
      {
        b.this.b(this);
      }

      protected void b(int paramAnonymousInt)
      {
        b.this.b(this);
      }
    };
    if (e())
    {
      str = m.a();
      if (ViberApplication.getInstance().getDownloadValve().c(str))
        if ((this.d.a(paraml)) && (bool))
        {
          a(local3);
          local3.a();
        }
    }
    while (!bool)
    {
      String str;
      do
        return;
      while (!bool);
      local3.b(paraml);
      return;
    }
    local3.b(paraml);
  }

  public void a(p paramp)
    throws b.a
  {
    if (com.viber.voip.util.upload.o.a());
    try
    {
      j.a(ViberApplication.getApplication(), paramp.h, paramp.i, null, paramp.d, paramp.e, true);
      return;
      throw new a();
    }
    catch (IOException localIOException)
    {
    }
  }

  public void a(ArrayList<p> paramArrayList)
  {
    Pair localPair = m.e(d.i.g.d());
    int j = paramArrayList.indexOf(new p(((Integer)localPair.first).intValue(), d.i.a.d(), ((Boolean)localPair.second).booleanValue(), null));
    if (j >= 0)
      paramArrayList.add(0, (p)paramArrayList.remove(j));
  }

  public void a(boolean paramBoolean)
  {
    long l = d.i.b.d();
    if ((e()) && ((System.currentTimeMillis() - l > 43200000L) || (d.i.a.d() == 0)))
    {
      a(new e()
      {
        public void a(a paramAnonymousa)
        {
          d.i.b.a(System.currentTimeMillis());
          b.this.b(this);
        }

        public void b(l paramAnonymousl)
        {
          b.this.b(this);
        }
      });
      this.d.b();
    }
    while (!paramBoolean)
      return;
    av.a(av.e.f).post(new d(this));
  }

  public Uri[] a(Context paramContext, q paramq)
  {
    Uri localUri2;
    File localFile;
    if (paramq.b())
    {
      Uri localUri1 = paramq.a(true);
      localUri2 = paramq.a();
      if ((localUri1 == null) || (localUri2 == null))
        return null;
      localFile = new File(localUri1.getPath());
    }
    try
    {
      bj.a(new File(localUri2.getPath()), localFile);
      Uri[] arrayOfUri = new Uri[2];
      arrayOfUri[0] = Uri.fromFile(localFile);
      arrayOfUri[1] = Uri.fromFile(localFile);
      return arrayOfUri;
      return a(paramContext, paramq, null);
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  // ERROR //
  public Uri[] a(Context paramContext, q paramq, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +623 -> 624
    //   4: aload_2
    //   5: invokeinterface 496 1 0
    //   10: ifnull +614 -> 624
    //   13: new 231	java/io/File
    //   16: dup
    //   17: aload_2
    //   18: invokeinterface 496 1 0
    //   23: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   26: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 4
    //   31: aload_1
    //   32: invokestatic 645	com/viber/voip/util/e/j:b	(Landroid/content/Context;)[I
    //   35: astore 6
    //   37: aload_1
    //   38: invokestatic 650	com/viber/voip/messages/extras/image/b:a	(Landroid/content/Context;)I
    //   41: istore 7
    //   43: aload 6
    //   45: iconst_0
    //   46: iaload
    //   47: istore 8
    //   49: aload 6
    //   51: iconst_1
    //   52: iaload
    //   53: istore 9
    //   55: invokestatic 654	com/viber/voip/util/dj:c	()I
    //   58: istore 10
    //   60: aload_1
    //   61: ldc_w 655
    //   64: invokestatic 658	com/viber/voip/util/e/j:a	(Landroid/content/Context;F)I
    //   67: istore 11
    //   69: iload 9
    //   71: iload 7
    //   73: isub
    //   74: iload 10
    //   76: isub
    //   77: iconst_0
    //   78: isub
    //   79: istore 12
    //   81: iload 11
    //   83: iload 8
    //   85: iload 7
    //   87: isub
    //   88: iload 10
    //   90: isub
    //   91: iconst_0
    //   92: isub
    //   93: iadd
    //   94: istore 13
    //   96: aload_1
    //   97: invokestatic 662	com/viber/voip/ViberApplication:isTablet	(Landroid/content/Context;)Z
    //   100: ifeq +39 -> 139
    //   103: new 664	android/util/TypedValue
    //   106: dup
    //   107: invokespecial 665	android/util/TypedValue:<init>	()V
    //   110: astore 14
    //   112: aload_1
    //   113: invokevirtual 671	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   116: getstatic 676	com/viber/voip/R$dimen:home_weight_right_land	I
    //   119: aload 14
    //   121: iconst_1
    //   122: invokevirtual 682	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   125: aload 14
    //   127: invokevirtual 686	android/util/TypedValue:getFloat	()F
    //   130: iload 9
    //   132: i2f
    //   133: fmul
    //   134: invokestatic 692	java/lang/Math:round	(F)I
    //   137: istore 9
    //   139: aload_3
    //   140: ifnonnull +24 -> 164
    //   143: aload_1
    //   144: aload 4
    //   146: invokestatic 639	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   149: sipush 1000
    //   152: sipush 1000
    //   155: iconst_0
    //   156: invokestatic 392	com/viber/voip/util/e/j:a	(Landroid/content/Context;Landroid/net/Uri;IIZ)Landroid/graphics/Bitmap;
    //   159: astore 15
    //   161: aload 15
    //   163: astore_3
    //   164: aload_2
    //   165: iconst_0
    //   166: invokeinterface 632 2 0
    //   171: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   174: astore 31
    //   176: aload_2
    //   177: iconst_1
    //   178: invokeinterface 632 2 0
    //   183: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   186: astore 32
    //   188: new 289	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   195: aload 31
    //   197: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 296
    //   203: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 696	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   212: astore 33
    //   214: aload 33
    //   216: astore 18
    //   218: new 289	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   225: aload 32
    //   227: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc_w 296
    //   233: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 696	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   242: astore 34
    //   244: aload 34
    //   246: astore 17
    //   248: aload_0
    //   249: aload_3
    //   250: iload 8
    //   252: iload 12
    //   254: aload 18
    //   256: invokevirtual 698	com/viber/voip/backgrounds/b:a	(Landroid/graphics/Bitmap;IILandroid/net/Uri;)Landroid/net/Uri;
    //   259: astore 18
    //   261: aload_0
    //   262: aload_3
    //   263: iload 9
    //   265: iload 13
    //   267: aload 17
    //   269: invokevirtual 698	com/viber/voip/backgrounds/b:a	(Landroid/graphics/Bitmap;IILandroid/net/Uri;)Landroid/net/Uri;
    //   272: astore 17
    //   274: new 231	java/io/File
    //   277: dup
    //   278: aload 18
    //   280: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   283: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   286: astore 35
    //   288: new 231	java/io/File
    //   291: dup
    //   292: aload 17
    //   294: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   297: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   300: astore 36
    //   302: aload 35
    //   304: new 231	java/io/File
    //   307: dup
    //   308: aload 31
    //   310: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   313: invokevirtual 701	java/io/File:renameTo	(Ljava/io/File;)Z
    //   316: ifeq +360 -> 676
    //   319: aload 36
    //   321: new 231	java/io/File
    //   324: dup
    //   325: aload 32
    //   327: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   330: invokevirtual 701	java/io/File:renameTo	(Ljava/io/File;)Z
    //   333: ifeq +343 -> 676
    //   336: aload 31
    //   338: invokestatic 696	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   341: astore 42
    //   343: aload 42
    //   345: astore 24
    //   347: aload 32
    //   349: invokestatic 696	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   352: astore 43
    //   354: aload 43
    //   356: astore 37
    //   358: aconst_null
    //   359: astore 17
    //   361: aconst_null
    //   362: astore 18
    //   364: aload 18
    //   366: ifnull +303 -> 669
    //   369: aload 17
    //   371: ifnull +298 -> 669
    //   374: new 231	java/io/File
    //   377: dup
    //   378: aload 18
    //   380: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   383: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   386: astore 38
    //   388: aload 38
    //   390: invokevirtual 238	java/io/File:exists	()Z
    //   393: ifeq +9 -> 402
    //   396: aload 38
    //   398: invokestatic 703	com/viber/voip/util/at:f	(Ljava/io/File;)Z
    //   401: pop
    //   402: new 231	java/io/File
    //   405: dup
    //   406: aload 17
    //   408: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   411: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   414: astore 39
    //   416: aload 39
    //   418: invokevirtual 238	java/io/File:exists	()Z
    //   421: ifeq +264 -> 685
    //   424: aload 39
    //   426: invokestatic 703	com/viber/voip/util/at:f	(Ljava/io/File;)Z
    //   429: pop
    //   430: goto +255 -> 685
    //   433: aload_3
    //   434: ifnull +7 -> 441
    //   437: aload_3
    //   438: invokevirtual 429	android/graphics/Bitmap:recycle	()V
    //   441: iconst_2
    //   442: anewarray 163	android/net/Uri
    //   445: dup
    //   446: iconst_0
    //   447: aload 24
    //   449: aastore
    //   450: dup
    //   451: iconst_1
    //   452: aload 25
    //   454: aastore
    //   455: astore 26
    //   457: aload 26
    //   459: areturn
    //   460: astore 23
    //   462: aconst_null
    //   463: astore 17
    //   465: aconst_null
    //   466: astore 18
    //   468: aconst_null
    //   469: astore 24
    //   471: getstatic 34	com/viber/voip/backgrounds/b:a	Lcom/viber/dexshared/Logger;
    //   474: aload 23
    //   476: ldc_w 705
    //   479: invokeinterface 417 3 0
    //   484: aload 18
    //   486: ifnull +177 -> 663
    //   489: aload 17
    //   491: ifnull +172 -> 663
    //   494: new 231	java/io/File
    //   497: dup
    //   498: aload 18
    //   500: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   503: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   506: astore 27
    //   508: aload 27
    //   510: invokevirtual 238	java/io/File:exists	()Z
    //   513: ifeq +9 -> 522
    //   516: aload 27
    //   518: invokestatic 703	com/viber/voip/util/at:f	(Ljava/io/File;)Z
    //   521: pop
    //   522: new 231	java/io/File
    //   525: dup
    //   526: aload 17
    //   528: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   531: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   534: astore 28
    //   536: aload 28
    //   538: invokevirtual 238	java/io/File:exists	()Z
    //   541: ifeq +151 -> 692
    //   544: aload 28
    //   546: invokestatic 703	com/viber/voip/util/at:f	(Ljava/io/File;)Z
    //   549: pop
    //   550: goto +142 -> 692
    //   553: aload 18
    //   555: ifnull +64 -> 619
    //   558: aload 17
    //   560: ifnull +59 -> 619
    //   563: new 231	java/io/File
    //   566: dup
    //   567: aload 18
    //   569: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   572: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   575: astore 19
    //   577: aload 19
    //   579: invokevirtual 238	java/io/File:exists	()Z
    //   582: ifeq +9 -> 591
    //   585: aload 19
    //   587: invokestatic 703	com/viber/voip/util/at:f	(Ljava/io/File;)Z
    //   590: pop
    //   591: new 231	java/io/File
    //   594: dup
    //   595: aload 17
    //   597: invokevirtual 167	android/net/Uri:getPath	()Ljava/lang/String;
    //   600: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   603: astore 20
    //   605: aload 20
    //   607: invokevirtual 238	java/io/File:exists	()Z
    //   610: ifeq +9 -> 619
    //   613: aload 20
    //   615: invokestatic 703	com/viber/voip/util/at:f	(Ljava/io/File;)Z
    //   618: pop
    //   619: aload 16
    //   621: athrow
    //   622: astore 5
    //   624: aconst_null
    //   625: areturn
    //   626: astore 16
    //   628: aconst_null
    //   629: astore 17
    //   631: goto -78 -> 553
    //   634: astore 16
    //   636: goto -83 -> 553
    //   639: astore 23
    //   641: aconst_null
    //   642: astore 17
    //   644: aconst_null
    //   645: astore 24
    //   647: goto -176 -> 471
    //   650: astore 23
    //   652: aconst_null
    //   653: astore 24
    //   655: goto -184 -> 471
    //   658: astore 23
    //   660: goto -189 -> 471
    //   663: aconst_null
    //   664: astore 25
    //   666: goto -233 -> 433
    //   669: aload 37
    //   671: astore 25
    //   673: goto -240 -> 433
    //   676: aconst_null
    //   677: astore 37
    //   679: aconst_null
    //   680: astore 24
    //   682: goto -318 -> 364
    //   685: aload 37
    //   687: astore 25
    //   689: goto -256 -> 433
    //   692: aconst_null
    //   693: astore 25
    //   695: goto -262 -> 433
    //   698: astore 16
    //   700: aconst_null
    //   701: astore 17
    //   703: aconst_null
    //   704: astore 18
    //   706: goto -153 -> 553
    //
    // Exception table:
    //   from	to	target	type
    //   164	214	460	java/lang/OutOfMemoryError
    //   31	69	622	java/lang/Exception
    //   96	139	622	java/lang/Exception
    //   143	161	622	java/lang/Exception
    //   374	402	622	java/lang/Exception
    //   402	430	622	java/lang/Exception
    //   437	441	622	java/lang/Exception
    //   441	457	622	java/lang/Exception
    //   494	522	622	java/lang/Exception
    //   522	550	622	java/lang/Exception
    //   563	591	622	java/lang/Exception
    //   591	619	622	java/lang/Exception
    //   619	622	622	java/lang/Exception
    //   218	244	626	finally
    //   248	343	634	finally
    //   347	354	634	finally
    //   471	484	634	finally
    //   218	244	639	java/lang/OutOfMemoryError
    //   248	343	650	java/lang/OutOfMemoryError
    //   347	354	658	java/lang/OutOfMemoryError
    //   164	214	698	finally
  }

  public Uri[] a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (ViberApplication.getInstance().getEngine(true).getPhoneController().isShortStandardBackgroundID(paramString))
        return e(c(paramString));
      String str = com.viber.voip.util.e.e.a(dx.f(paramString));
      if (str != null)
      {
        File localFile = new File(str);
        Uri[] arrayOfUri1 = a(ViberApplication.getApplication(), new r(Uri.fromFile(localFile)));
        if ((arrayOfUri1 != null) && (arrayOfUri1[0] != null) && (arrayOfUri1[1] != null))
        {
          Uri[] arrayOfUri2 = new Uri[2];
          arrayOfUri2[0] = arrayOfUri1[0];
          arrayOfUri2[1] = arrayOfUri1[1];
          return arrayOfUri2;
        }
      }
    }
    return new Uri[] { null, null };
  }

  public void b()
  {
    this.c.post(new c(this));
  }

  public void b(int paramInt)
  {
    l locall1;
    Iterator localIterator;
    try
    {
      l locall2 = a(paramInt);
      locall1 = locall2;
      if ((locall1 == null) || (!locall1.c()))
      {
        a(new l(paramInt));
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
        locall1 = null;
      localIterator = this.e.iterator();
    }
    while (localIterator.hasNext())
      ((f)localIterator.next()).a(locall1);
  }

  public void b(f paramf)
  {
    this.e.remove(paramf);
  }

  public Uri[] b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = com.viber.voip.util.e.e.a(Uri.parse(paramString));
      if (str != null)
      {
        File localFile = new File(str);
        Uri[] arrayOfUri1 = a(ViberApplication.getApplication(), new r(Uri.fromFile(localFile)));
        if ((arrayOfUri1 != null) && (arrayOfUri1[0] != null) && (arrayOfUri1[1] != null))
        {
          Uri[] arrayOfUri2 = new Uri[2];
          arrayOfUri2[0] = arrayOfUri1[0];
          arrayOfUri2[1] = arrayOfUri1[1];
          return arrayOfUri2;
        }
      }
    }
    return new Uri[] { null, null };
  }

  public void c()
  {
    ViberApplication.getInstance().getMessagesManager().c().e();
  }

  public void d()
  {
    Iterator localIterator = ViberApplication.getInstance().getMessagesManager().a().i().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if (localLong.longValue() > 0L)
        com.viber.voip.messages.controller.manager.o.a().a(Collections.singleton(localLong), 0, false, false);
    }
  }

  public boolean e()
  {
    return (com.viber.voip.util.upload.o.b()) && (com.viber.voip.util.upload.o.a());
  }

  public void f()
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        if (com.viber.voip.util.upload.o.c())
        {
          b.c(b.this).a();
          File localFile = m.b(ViberApplication.getApplication());
          if (at.h(localFile))
            localFile.mkdirs();
          d.i.g.e();
          d.i.a.e();
          d.i.i.e();
          d.i.b.e();
          d.i.c.e();
          d.i.e.e();
          d.i.d.e();
          b.d(b.this).evictAll();
          b.this.b();
          b.this.a(true);
        }
      }
    });
  }

  public static class a extends Exception
  {
    public a()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.b
 * JD-Core Version:    0.6.2
 */