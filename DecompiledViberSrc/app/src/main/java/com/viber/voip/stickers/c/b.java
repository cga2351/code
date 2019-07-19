package com.viber.voip.stickers.c;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.Sticker.a;
import com.viber.voip.stickers.f;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.i.c;
import com.viber.voip.stickers.p;
import com.viber.voip.stickers.w;
import com.viber.voip.stickers.x;
import com.viber.voip.ui.dialogs.n;
import com.viber.voip.util.ap;
import com.viber.voip.util.at;
import com.viber.voip.util.bu;
import com.viber.voip.util.upload.b.a;
import com.viber.voip.util.upload.b.b;
import com.viber.voip.util.upload.m;
import com.viber.voip.util.upload.o;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public abstract class b extends a
  implements m, Runnable
{
  private static final Logger d = ViberEnv.getLogger();
  private static Pattern e = Pattern.compile("(^|/)([0-9]{8})\\.(png|svg)$", 2);
  private static Pattern f = Pattern.compile("(^|/)([0-9]{8})\\_frame.(png|svg)$", 2);
  private static Pattern g = Pattern.compile("(^|/)([0-9]{8})\\.(mp3)$", 2);
  private com.viber.voip.stickers.entity.b h;
  private String i;
  private File j;
  private File k;
  private String l;
  private int m;
  private com.viber.voip.util.upload.b n;
  private long o;
  private Map<Integer, Sticker> p = new LinkedHashMap();
  private boolean q;
  private Runnable r = new Runnable()
  {
    public void run()
    {
      b.this.b();
      if (ViberApplication.getInstance().getDownloadValve().b(b.b(b.this)) > 1L)
      {
        n.a().d();
        return;
      }
      ViberApplication.getInstance().getDownloadValve().f(b.b(b.this));
      b.a(b.this, true);
    }
  };

  public b(com.viber.voip.stickers.entity.b paramb, i parami, com.viber.voip.stickers.e.b paramb1)
  {
    super(paramb1, parami);
    this.h = paramb;
    paramb1.onStickerPackageDownloadScheduled(paramb);
  }

  public static int a(String paramString)
  {
    Matcher localMatcher = e.matcher(paramString);
    if (localMatcher.find())
      return Integer.parseInt(localMatcher.group(2), 10);
    return -1;
  }

  private com.viber.voip.stickers.entity.a a(InputStream paramInputStream)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList(100);
    ZipInputStream localZipInputStream = new ZipInputStream(paramInputStream);
    ZipEntry localZipEntry = localZipInputStream.getNextEntry();
    if (localZipEntry != null)
    {
      int i2;
      int i3;
      int i4;
      int i5;
      label78: int i6;
      label86: int i7;
      label94: int i8;
      label112: label117: Sticker localSticker2;
      if (!localZipEntry.isDirectory())
      {
        i2 = a(localZipEntry.getName());
        i3 = b(localZipEntry.getName());
        i4 = c(localZipEntry.getName());
        if (i3 < 0)
          break label249;
        i5 = 1;
        if (i4 < 0)
          break label255;
        i6 = 1;
        if (i2 < 0)
          break label261;
        i7 = 1;
        if ((i7 == 0) && (i5 == 0) && (i6 == 0))
          break label267;
        i8 = 1;
        if (i6 == 0)
          break label273;
        if (i8 != 0)
        {
          if (g.f(i4) != this.h.e())
            break label292;
          i8 = 1;
        }
        label140: if (i8 != 0)
        {
          localSticker2 = (Sticker)this.p.get(Integer.valueOf(i4));
          if (localSticker2 == null)
          {
            localSticker2 = new Sticker(i4, this.h.e());
            this.p.put(Integer.valueOf(i4), localSticker2);
          }
          if (!d(localZipEntry.getName()))
            break label298;
          localSticker2.setIsSvg(true);
          label222: if (i6 == 0)
            break label319;
          g.a(localSticker2.getOrigSoundPath(), localZipInputStream);
        }
      }
      while (true)
      {
        localZipInputStream.closeEntry();
        localZipEntry = localZipInputStream.getNextEntry();
        break;
        label249: i5 = 0;
        break label78;
        label255: i6 = 0;
        break label86;
        label261: i7 = 0;
        break label94;
        label267: i8 = 0;
        break label112;
        label273: if (i7 != 0)
        {
          i4 = i2;
          break label117;
        }
        i4 = i3;
        break label117;
        label292: i8 = 0;
        break label140;
        label298: if (!e(localZipEntry.getName()))
          break label222;
        localSticker2.setHasSound(true);
        break label222;
        label319: if (i5 != 0)
          g.a(localSticker2.getOrigFramePath(), localZipInputStream);
        else if (i4 >= 0)
          g.a(localSticker2.getOrigPath(), localZipInputStream);
      }
    }
    localZipInputStream.close();
    i();
    Iterator localIterator = this.p.values().iterator();
    while (localIterator.hasNext())
    {
      Sticker localSticker1 = (Sticker)localIterator.next();
      a(localSticker1);
      this.a.e().b(localSticker1);
      if (localSticker1.isSvg())
      {
        b(localSticker1);
        this.a.A().a(localSticker1);
      }
      if (localSticker1.type == Sticker.a.a)
        this.c.onStickerDeployed(localSticker1);
      localSticker1.checkStatus();
      localArrayList.add(localSticker1);
    }
    if (localArrayList.size() == 0)
      throw new IOException("Unzip, no stickes unzipped, generating an exception");
    a(localArrayList);
    this.h.c(false);
    com.viber.voip.stickers.entity.b localb1 = this.h;
    if (143700 == this.h.e());
    for (boolean bool1 = true; ; bool1 = false)
    {
      localb1.d(bool1);
      com.viber.voip.stickers.entity.b localb2 = this.h;
      int i1 = this.h.e();
      boolean bool2 = false;
      if (133600 == i1)
        bool2 = true;
      localb2.e(bool2);
      boolean bool3 = this.h.g();
      if ((!bool3) && (!this.h.l()))
        this.h.a(true);
      this.h.b(true);
      this.h.a(localArrayList);
      this.a.a(this.h, bool3);
      this.c.onStickerPackageDeployed(this.h);
      return this.h;
    }
  }

  private void a(Exception paramException)
  {
    i();
    boolean bool;
    if ((paramException instanceof b.a))
    {
      b.b localb = ((b.a)paramException).a();
      if ((localb == b.b.f) || (localb == b.b.h))
        bool = true;
    }
    while (true)
    {
      this.c.onStickerPackageDownloadError(bool, this.h);
      if ((this.n != null) && (this.n.j()))
        g();
      this.h.b(false);
      this.a.a(this.h);
      return;
      bool = false;
      continue;
      bool = false;
    }
  }

  private void a(ArrayList<Sticker> paramArrayList)
    throws IOException
  {
    Collections.sort(paramArrayList);
    p localp = p.a(this.h.e());
    new com.viber.voip.bot.item.d(localp.e(), localp.d()).a(paramArrayList);
    this.a.d(paramArrayList);
    int i1 = paramArrayList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      Sticker localSticker = (Sticker)paramArrayList.get(i2);
      this.a.u(localSticker.id).checkStatus();
    }
    try
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
        f.a((Sticker)localIterator.next(), w.c, true);
    }
    catch (i.c localc)
    {
      throw new IOException("Low storage during deployment! Aborting");
    }
  }

  private int b(String paramString)
  {
    Matcher localMatcher = f.matcher(paramString);
    if (localMatcher.find())
      return Integer.parseInt(localMatcher.group(2), 10);
    return -1;
  }

  private void b(Sticker paramSticker)
  {
    this.a.e().a(paramSticker.getScaledPathKey(true, true, w.a));
    this.a.e().a(paramSticker.getScaledPathKey(true, false, w.a));
    this.a.e().a(paramSticker.getScaledPathKey(false, true, w.a));
    this.a.e().a(paramSticker.getScaledPathKey(false, false, w.a));
    this.a.e().a(paramSticker.getScaledPathKey(true, w.b));
  }

  private int c(String paramString)
  {
    Matcher localMatcher = g.matcher(paramString);
    if (localMatcher.find())
      return Integer.parseInt(localMatcher.group(2), 10);
    return -1;
  }

  private boolean d(String paramString)
  {
    return paramString.endsWith(".svg");
  }

  private boolean e()
  {
    return this.h.e() != 400;
  }

  private boolean e(String paramString)
  {
    return paramString.endsWith(".mp3");
  }

  private File f(String paramString)
  {
    return new File(g.a(ViberApplication.getApplication()), bu.a(paramString) + ".zip");
  }

  private void f()
  {
    if (!this.h.u())
      new d(this.h.e(), null).c();
  }

  private void g()
  {
    if ("mounted".equals(o.e()))
    {
      at.f(this.j);
      at.f(this.k);
      ViberApplication.getInstance().getDownloadValve().b(this.i);
    }
  }

  private void h()
  {
    av.a(av.e.f).postDelayed(this.r, 600000L);
  }

  private void i()
  {
    av.a(av.e.f).removeCallbacks(this.r);
  }

  // ERROR //
  public com.viber.voip.stickers.entity.a a()
    throws b.a
  {
    // Byte code:
    //   0: invokestatic 509	com/viber/voip/util/upload/o:a	()Z
    //   3: ifne +14 -> 17
    //   6: new 315	com/viber/voip/util/upload/b$a
    //   9: dup
    //   10: getstatic 325	com/viber/voip/util/upload/b$b:h	Lcom/viber/voip/util/upload/b$b;
    //   13: invokespecial 512	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;)V
    //   16: athrow
    //   17: aload_0
    //   18: getfield 262	com/viber/voip/stickers/c/b:c	Lcom/viber/voip/stickers/e/b;
    //   21: aload_0
    //   22: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   25: invokeinterface 515 2 0
    //   30: new 167	com/viber/voip/stickers/entity/Sticker
    //   33: dup
    //   34: aload_0
    //   35: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   38: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   41: aload_0
    //   42: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   45: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   48: invokespecial 170	com/viber/voip/stickers/entity/Sticker:<init>	(II)V
    //   51: invokevirtual 518	com/viber/voip/stickers/entity/Sticker:createFolder	()V
    //   54: aload_0
    //   55: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   58: pop
    //   59: aload_0
    //   60: invokespecial 520	com/viber/voip/stickers/c/b:e	()Z
    //   63: ifeq +21 -> 84
    //   66: aload_0
    //   67: invokespecial 522	com/viber/voip/stickers/c/b:f	()V
    //   70: aload_0
    //   71: getfield 231	com/viber/voip/stickers/c/b:a	Lcom/viber/voip/stickers/i;
    //   74: aload_0
    //   75: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   78: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   81: invokevirtual 524	com/viber/voip/stickers/i:a	(I)V
    //   84: aload_0
    //   85: monitorenter
    //   86: aload_0
    //   87: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   90: invokevirtual 527	com/viber/voip/util/upload/b:n	()Lcom/viber/voip/util/upload/e;
    //   93: astore 5
    //   95: new 529	com/viber/voip/stickers/c/b$1
    //   98: dup
    //   99: aload_0
    //   100: aload 5
    //   102: invokespecial 532	com/viber/voip/stickers/c/b$1:<init>	(Lcom/viber/voip/stickers/c/b;Ljava/io/InputStream;)V
    //   105: invokevirtual 535	com/viber/voip/stickers/c/b$1:start	()V
    //   108: aload_0
    //   109: aload 5
    //   111: invokespecial 537	com/viber/voip/stickers/c/b:a	(Ljava/io/InputStream;)Lcom/viber/voip/stickers/entity/a;
    //   114: astore 8
    //   116: aload_0
    //   117: invokevirtual 542	java/lang/Object:wait	()V
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_0
    //   123: getfield 462	com/viber/voip/stickers/c/b:j	Ljava/io/File;
    //   126: invokestatic 467	com/viber/voip/util/at:f	(Ljava/io/File;)Z
    //   129: pop
    //   130: aload 8
    //   132: areturn
    //   133: astore 6
    //   135: aload_0
    //   136: invokevirtual 542	java/lang/Object:wait	()V
    //   139: aload 6
    //   141: athrow
    //   142: astore 4
    //   144: aload_0
    //   145: monitorexit
    //   146: aload 4
    //   148: athrow
    //   149: astore_3
    //   150: aload_0
    //   151: aload_3
    //   152: invokespecial 313	com/viber/voip/stickers/c/b:a	(Ljava/lang/Exception;)V
    //   155: new 315	com/viber/voip/util/upload/b$a
    //   158: dup
    //   159: aload_3
    //   160: invokespecial 545	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;)V
    //   163: athrow
    //   164: astore_2
    //   165: aload_0
    //   166: aload_2
    //   167: invokespecial 313	com/viber/voip/stickers/c/b:a	(Ljava/lang/Exception;)V
    //   170: aload_2
    //   171: athrow
    //   172: astore 9
    //   174: goto -54 -> 120
    //   177: astore 7
    //   179: goto -40 -> 139
    //
    // Exception table:
    //   from	to	target	type
    //   108	116	133	finally
    //   86	108	142	finally
    //   116	120	142	finally
    //   120	122	142	finally
    //   135	139	142	finally
    //   139	142	142	finally
    //   144	146	142	finally
    //   59	84	149	java/io/IOException
    //   84	86	149	java/io/IOException
    //   122	130	149	java/io/IOException
    //   146	149	149	java/io/IOException
    //   59	84	164	com/viber/voip/util/upload/b$a
    //   84	86	164	com/viber/voip/util/upload/b$a
    //   122	130	164	com/viber/voip/util/upload/b$a
    //   146	149	164	com/viber/voip/util/upload/b$a
    //   116	120	172	java/lang/InterruptedException
    //   135	139	177	java/lang/InterruptedException
  }

  public void a(Uri paramUri, int paramInt)
  {
    this.m = paramInt;
    long l1 = SystemClock.elapsedRealtime();
    long l2 = l1 - this.o;
    if ((paramInt == 100) || (l2 > 2000L))
    {
      this.c.onStickerPackageDownloading(this.h, paramInt);
      this.o = l1;
    }
  }

  public void b()
  {
    if (this.n != null)
      this.n.g();
  }

  public abstract void b(int paramInt);

  public com.viber.voip.stickers.entity.a c()
  {
    return this.h;
  }

  public int d()
  {
    return this.m;
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   5: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   8: invokevirtual 566	com/viber/voip/stickers/c/b:b	(I)V
    //   11: aload_0
    //   12: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   15: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   18: invokestatic 571	com/viber/voip/stickers/u:a	(I)Lcom/viber/voip/market/g;
    //   21: astore 10
    //   23: aload 10
    //   25: astore 4
    //   27: aload 4
    //   29: ifnonnull +140 -> 169
    //   32: aload_0
    //   33: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   36: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   39: sipush 400
    //   42: if_icmpeq +185 -> 227
    //   45: aload_0
    //   46: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   49: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   52: invokestatic 573	com/viber/voip/stickers/c/g:g	(I)Ljava/lang/String;
    //   55: astore 9
    //   57: invokestatic 473	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   60: invokevirtual 477	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   63: aload 9
    //   65: invokevirtual 574	com/viber/voip/util/ap:a	(Ljava/lang/String;)V
    //   68: new 315	com/viber/voip/util/upload/b$a
    //   71: dup
    //   72: new 576	java/lang/Exception
    //   75: dup
    //   76: ldc_w 578
    //   79: invokespecial 579	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 545	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;)V
    //   85: athrow
    //   86: astore_2
    //   87: aload_0
    //   88: aload_2
    //   89: invokespecial 313	com/viber/voip/stickers/c/b:a	(Ljava/lang/Exception;)V
    //   92: aload_0
    //   93: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   96: ifnull +36 -> 132
    //   99: aload_0
    //   100: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   103: invokevirtual 581	com/viber/voip/util/upload/b:i	()I
    //   106: ifeq +26 -> 132
    //   109: invokestatic 473	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   112: invokevirtual 477	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   115: aload_0
    //   116: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   119: invokevirtual 583	com/viber/voip/util/upload/b:b	()Ljava/lang/String;
    //   122: aload_0
    //   123: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   126: invokevirtual 581	com/viber/voip/util/upload/b:i	()I
    //   129: invokevirtual 586	com/viber/voip/util/ap:a	(Ljava/lang/String;I)V
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   137: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   140: invokevirtual 587	com/viber/voip/stickers/c/b:a	(I)V
    //   143: aload_0
    //   144: getfield 385	com/viber/voip/stickers/c/b:q	Z
    //   147: ifeq +14 -> 161
    //   150: aload_0
    //   151: getfield 231	com/viber/voip/stickers/c/b:a	Lcom/viber/voip/stickers/i;
    //   154: aload_0
    //   155: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   158: invokevirtual 589	com/viber/voip/stickers/i:b	(Lcom/viber/voip/stickers/entity/a;)V
    //   161: return
    //   162: astore_3
    //   163: aconst_null
    //   164: astore 4
    //   166: goto -139 -> 27
    //   169: aload 4
    //   171: getfield 594	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   174: astore 5
    //   176: aconst_null
    //   177: astore 6
    //   179: aload 5
    //   181: ifnull +14 -> 195
    //   184: aload 4
    //   186: getfield 594	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   189: arraylength
    //   190: anewarray 405	java/lang/String
    //   193: astore 6
    //   195: aload 6
    //   197: ifnull +21 -> 218
    //   200: aload 4
    //   202: getfield 594	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   205: iconst_0
    //   206: aload 6
    //   208: iconst_0
    //   209: aload 4
    //   211: getfield 594	com/viber/voip/market/g:f	[Ljava/lang/String;
    //   214: arraylength
    //   215: invokestatic 600	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   218: aload_0
    //   219: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   222: aload 6
    //   224: invokevirtual 603	com/viber/voip/stickers/entity/b:a	([Ljava/lang/String;)V
    //   227: aload_0
    //   228: getstatic 605	com/viber/voip/stickers/p:a	I
    //   231: invokestatic 607	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   234: putfield 609	com/viber/voip/stickers/c/b:l	Ljava/lang/String;
    //   237: aload_0
    //   238: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   241: invokevirtual 613	com/viber/voip/stickers/entity/b:x	()[Ljava/lang/String;
    //   244: ifnull +37 -> 281
    //   247: aload_0
    //   248: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   251: invokevirtual 613	com/viber/voip/stickers/entity/b:x	()[Ljava/lang/String;
    //   254: arraylength
    //   255: ifle +26 -> 281
    //   258: aload_0
    //   259: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   262: invokevirtual 613	com/viber/voip/stickers/entity/b:x	()[Ljava/lang/String;
    //   265: ldc_w 615
    //   268: invokestatic 620	com/viber/voip/util/n:a	([Ljava/lang/Object;Ljava/lang/Object;)Z
    //   271: ifeq +190 -> 461
    //   274: aload_0
    //   275: ldc_w 622
    //   278: putfield 609	com/viber/voip/stickers/c/b:l	Ljava/lang/String;
    //   281: aload_0
    //   282: getfield 231	com/viber/voip/stickers/c/b:a	Lcom/viber/voip/stickers/i;
    //   285: aload_0
    //   286: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   289: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   292: invokevirtual 626	com/viber/voip/stickers/i:w	(I)Ljava/lang/Float;
    //   295: astore 7
    //   297: aload 7
    //   299: ifnull +15 -> 314
    //   302: aload_0
    //   303: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   306: aload 7
    //   308: invokevirtual 632	java/lang/Float:floatValue	()F
    //   311: invokevirtual 635	com/viber/voip/stickers/entity/b:a	(F)V
    //   314: aload_0
    //   315: aload_0
    //   316: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   319: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   322: aload_0
    //   323: getfield 609	com/viber/voip/stickers/c/b:l	Ljava/lang/String;
    //   326: invokestatic 638	com/viber/voip/stickers/c/g:b	(ILjava/lang/String;)Ljava/lang/String;
    //   329: putfield 388	com/viber/voip/stickers/c/b:i	Ljava/lang/String;
    //   332: invokestatic 473	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   335: invokevirtual 477	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   338: aload_0
    //   339: getfield 388	com/viber/voip/stickers/c/b:i	Ljava/lang/String;
    //   342: invokevirtual 640	com/viber/voip/util/ap:c	(Ljava/lang/String;)Z
    //   345: ifne +142 -> 487
    //   348: new 315	com/viber/voip/util/upload/b$a
    //   351: dup
    //   352: new 576	java/lang/Exception
    //   355: dup
    //   356: new 424	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 425	java/lang/StringBuilder:<init>	()V
    //   363: ldc_w 642
    //   366: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_0
    //   370: getfield 388	com/viber/voip/stickers/c/b:i	Ljava/lang/String;
    //   373: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 439	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokespecial 579	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   382: ldc_w 644
    //   385: invokespecial 647	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   388: athrow
    //   389: astore_1
    //   390: aload_0
    //   391: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   394: ifnull +36 -> 430
    //   397: aload_0
    //   398: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   401: invokevirtual 581	com/viber/voip/util/upload/b:i	()I
    //   404: ifeq +26 -> 430
    //   407: invokestatic 473	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   410: invokevirtual 477	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   413: aload_0
    //   414: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   417: invokevirtual 583	com/viber/voip/util/upload/b:b	()Ljava/lang/String;
    //   420: aload_0
    //   421: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   424: invokevirtual 581	com/viber/voip/util/upload/b:i	()I
    //   427: invokevirtual 586	com/viber/voip/util/ap:a	(Ljava/lang/String;I)V
    //   430: aload_0
    //   431: aload_0
    //   432: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   435: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   438: invokevirtual 587	com/viber/voip/stickers/c/b:a	(I)V
    //   441: aload_0
    //   442: getfield 385	com/viber/voip/stickers/c/b:q	Z
    //   445: ifeq +14 -> 459
    //   448: aload_0
    //   449: getfield 231	com/viber/voip/stickers/c/b:a	Lcom/viber/voip/stickers/i;
    //   452: aload_0
    //   453: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   456: invokevirtual 589	com/viber/voip/stickers/i:b	(Lcom/viber/voip/stickers/entity/a;)V
    //   459: aload_1
    //   460: athrow
    //   461: aload_0
    //   462: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   465: invokevirtual 613	com/viber/voip/stickers/entity/b:x	()[Ljava/lang/String;
    //   468: ldc_w 649
    //   471: invokestatic 620	com/viber/voip/util/n:a	([Ljava/lang/Object;Ljava/lang/Object;)Z
    //   474: ifeq -193 -> 281
    //   477: aload_0
    //   478: ldc_w 651
    //   481: putfield 609	com/viber/voip/stickers/c/b:l	Ljava/lang/String;
    //   484: goto -203 -> 281
    //   487: aload_0
    //   488: aload_0
    //   489: aload_0
    //   490: getfield 388	com/viber/voip/stickers/c/b:i	Ljava/lang/String;
    //   493: invokespecial 653	com/viber/voip/stickers/c/b:f	(Ljava/lang/String;)Ljava/io/File;
    //   496: putfield 462	com/viber/voip/stickers/c/b:j	Ljava/io/File;
    //   499: aload_0
    //   500: aload_0
    //   501: getfield 462	com/viber/voip/stickers/c/b:j	Ljava/io/File;
    //   504: invokestatic 656	com/viber/voip/util/at:g	(Ljava/io/File;)Ljava/io/File;
    //   507: putfield 469	com/viber/voip/stickers/c/b:k	Ljava/io/File;
    //   510: aload_0
    //   511: getfield 462	com/viber/voip/stickers/c/b:j	Ljava/io/File;
    //   514: ifnonnull +44 -> 558
    //   517: new 315	com/viber/voip/util/upload/b$a
    //   520: dup
    //   521: new 576	java/lang/Exception
    //   524: dup
    //   525: new 424	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 425	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 658
    //   535: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: getfield 388	com/viber/voip/stickers/c/b:i	Ljava/lang/String;
    //   542: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 439	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokespecial 579	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   551: ldc_w 644
    //   554: invokespecial 647	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   557: athrow
    //   558: aload_0
    //   559: getfield 469	com/viber/voip/stickers/c/b:k	Ljava/io/File;
    //   562: ifnonnull +44 -> 606
    //   565: new 315	com/viber/voip/util/upload/b$a
    //   568: dup
    //   569: new 576	java/lang/Exception
    //   572: dup
    //   573: new 424	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 425	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 660
    //   583: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload_0
    //   587: getfield 469	com/viber/voip/stickers/c/b:k	Ljava/io/File;
    //   590: invokevirtual 663	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 439	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokespecial 579	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   599: ldc_w 644
    //   602: invokespecial 647	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   605: athrow
    //   606: aload_0
    //   607: new 331	com/viber/voip/util/upload/b
    //   610: dup
    //   611: aload_0
    //   612: getfield 388	com/viber/voip/stickers/c/b:i	Ljava/lang/String;
    //   615: aload_0
    //   616: getfield 462	com/viber/voip/stickers/c/b:j	Ljava/io/File;
    //   619: invokevirtual 666	java/io/File:getPath	()Ljava/lang/String;
    //   622: aload_0
    //   623: getfield 469	com/viber/voip/stickers/c/b:k	Ljava/io/File;
    //   626: invokevirtual 666	java/io/File:getPath	()Ljava/lang/String;
    //   629: invokespecial 669	com/viber/voip/util/upload/b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   632: putfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   635: aload_0
    //   636: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   639: aload_0
    //   640: invokevirtual 672	com/viber/voip/util/upload/b:a	(Lcom/viber/voip/util/upload/m;)V
    //   643: aload_0
    //   644: invokespecial 674	com/viber/voip/stickers/c/b:h	()V
    //   647: aload_0
    //   648: invokevirtual 676	com/viber/voip/stickers/c/b:a	()Lcom/viber/voip/stickers/entity/a;
    //   651: pop
    //   652: invokestatic 473	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   655: invokevirtual 477	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   658: aload_0
    //   659: getfield 388	com/viber/voip/stickers/c/b:i	Ljava/lang/String;
    //   662: invokevirtual 678	com/viber/voip/util/ap:d	(Ljava/lang/String;)V
    //   665: aload_0
    //   666: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   669: ifnull +36 -> 705
    //   672: aload_0
    //   673: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   676: invokevirtual 581	com/viber/voip/util/upload/b:i	()I
    //   679: ifeq +26 -> 705
    //   682: invokestatic 473	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   685: invokevirtual 477	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   688: aload_0
    //   689: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   692: invokevirtual 583	com/viber/voip/util/upload/b:b	()Ljava/lang/String;
    //   695: aload_0
    //   696: getfield 309	com/viber/voip/stickers/c/b:n	Lcom/viber/voip/util/upload/b;
    //   699: invokevirtual 581	com/viber/voip/util/upload/b:i	()I
    //   702: invokevirtual 586	com/viber/voip/util/ap:a	(Ljava/lang/String;I)V
    //   705: aload_0
    //   706: aload_0
    //   707: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   710: invokevirtual 155	com/viber/voip/stickers/entity/b:e	()I
    //   713: invokevirtual 587	com/viber/voip/stickers/c/b:a	(I)V
    //   716: aload_0
    //   717: getfield 385	com/viber/voip/stickers/c/b:q	Z
    //   720: ifeq -559 -> 161
    //   723: aload_0
    //   724: getfield 231	com/viber/voip/stickers/c/b:a	Lcom/viber/voip/stickers/i;
    //   727: aload_0
    //   728: getfield 83	com/viber/voip/stickers/c/b:h	Lcom/viber/voip/stickers/entity/b;
    //   731: invokevirtual 589	com/viber/voip/stickers/i:b	(Lcom/viber/voip/stickers/entity/a;)V
    //   734: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	11	86	com/viber/voip/util/upload/b$a
    //   11	23	86	com/viber/voip/util/upload/b$a
    //   32	86	86	com/viber/voip/util/upload/b$a
    //   169	176	86	com/viber/voip/util/upload/b$a
    //   184	195	86	com/viber/voip/util/upload/b$a
    //   200	218	86	com/viber/voip/util/upload/b$a
    //   218	227	86	com/viber/voip/util/upload/b$a
    //   227	281	86	com/viber/voip/util/upload/b$a
    //   281	297	86	com/viber/voip/util/upload/b$a
    //   302	314	86	com/viber/voip/util/upload/b$a
    //   314	389	86	com/viber/voip/util/upload/b$a
    //   461	484	86	com/viber/voip/util/upload/b$a
    //   487	558	86	com/viber/voip/util/upload/b$a
    //   558	606	86	com/viber/voip/util/upload/b$a
    //   606	665	86	com/viber/voip/util/upload/b$a
    //   11	23	162	java/io/IOException
    //   0	11	389	finally
    //   11	23	389	finally
    //   32	86	389	finally
    //   87	92	389	finally
    //   169	176	389	finally
    //   184	195	389	finally
    //   200	218	389	finally
    //   218	227	389	finally
    //   227	281	389	finally
    //   281	297	389	finally
    //   302	314	389	finally
    //   314	389	389	finally
    //   461	484	389	finally
    //   487	558	389	finally
    //   558	606	389	finally
    //   606	665	389	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.c.b
 * JD-Core Version:    0.6.2
 */