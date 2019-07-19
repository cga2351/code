package com.viber.voip.util.upload;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.GifMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.sound.ptt.PttUtils;
import com.viber.voip.util.as;
import com.viber.voip.util.at;
import com.viber.voip.util.bu;
import com.viber.voip.util.da;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import com.viber.voip.util.dx.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class s extends l
{
  private static final Logger a = ViberEnv.getLogger();
  private static Handler b = av.a(av.e.i);
  private static Handler c = av.a(av.e.d);
  private static final Set<Uri> d = Collections.synchronizedSet(new HashSet());
  private static final Map<String, c> e = new HashMap();

  public static b a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, EncryptionParams paramEncryptionParams)
  {
    return new d(paramContext, paramString3, paramBoolean, paramString1, paramString2, paramEncryptionParams);
  }

  public static b a(t.d paramd, String paramString1, String paramString2, EncryptionParams paramEncryptionParams, int paramInt, String paramString3, String paramString4)
  {
    i.c localc = i.a(paramString1);
    i.e locale = new i.e(paramString3, paramString4, paramString2, paramEncryptionParams, paramd, localc, i.o.a(paramInt));
    if (localc == i.c.d)
      locale.a(true);
    return locale;
  }

  public static b a(String paramString1, String paramString2, String paramString3)
  {
    return new i.e(paramString1, paramString2, paramString3, null, t.d.c, i.c.b, i.o.c);
  }

  private static a a(MessageEntity paramMessageEntity, File paramFile1, File paramFile2)
  {
    return new i.e(paramFile1.getPath(), paramFile2.getPath(), paramMessageEntity.getDownloadId(), null, t.d.b, i.c.c, i.o.c);
  }

  private static a a(File paramFile1, File paramFile2, MessageEntity paramMessageEntity)
  {
    boolean bool1 = true;
    int i;
    if ((paramMessageEntity.isFile()) || (paramMessageEntity.isVideoPtt()))
    {
      i = bool1;
      if (((!paramMessageEntity.isPublicGroupBehavior()) || (paramMessageEntity.isPublicAccount())) && (!paramMessageEntity.isPgForwardedMessage()))
        break label125;
      label40: if ((!paramMessageEntity.isForwardedMessage()) || (paramMessageEntity.isForwardedFromPG()))
        break label161;
    }
    label161: for (boolean bool2 = false; ; bool2 = bool1)
    {
      Object localObject;
      i.c localc;
      if (i != 0)
      {
        localObject = t.d.h;
        localc = i.c.d;
        i.e locale = new i.e(paramFile1.getPath(), paramFile2.getPath(), paramMessageEntity.getDownloadId(), paramMessageEntity.getEncryptionParams(), (t.d)localObject, localc, i.o.c);
        if (i != 0)
          locale.a(bool2);
        return locale;
        i = 0;
        break;
        label125: bool1 = false;
        break label40;
      }
      if (bool2);
      for (t.d locald = t.d.g; ; locald = t.d.a)
      {
        localc = i.a(paramMessageEntity);
        localObject = locald;
        break;
      }
    }
  }

  private static a a(File paramFile1, File paramFile2, MessageEntity paramMessageEntity, String paramString)
  {
    if (((paramMessageEntity.isPublicGroupType()) && (!paramMessageEntity.isPublicAccount())) || (paramMessageEntity.isPgForwardedMessage()));
    for (boolean bool = true; ; bool = false)
    {
      t.d locald = t.d.h;
      i.c localc = i.c.d;
      i.e locale = new i.e(paramFile1.getPath(), paramFile2.getPath(), paramString, paramMessageEntity.getEncryptionParams(), locald, localc, i.o.c);
      locale.a(bool);
      return locale;
    }
  }

  private static File a(MessageEntity paramMessageEntity, Context paramContext)
  {
    if (3 == paramMessageEntity.getMimeType());
    for (dv localdv = dv.K; ; localdv = dv.J)
      return localdv.b(paramContext, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl(), false);
  }

  private static String a(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.isConvertedFromPublicAccountFormat())
      return bu.a(paramMessageEntity.getPublicAccountMediaUrl());
    return paramMessageEntity.getDownloadId();
  }

  public static Set<String> a()
  {
    synchronized (e)
    {
      HashSet localHashSet = new HashSet(e.keySet());
      return localHashSet;
    }
  }

  private static void a(long paramLong, a parama)
  {
    a(dx.a(paramLong), parama);
  }

  private static void a(Uri paramUri, a parama)
  {
    d.remove(paramUri);
    parama.a(null, d.a);
  }

  public static void a(aa paramaa, boolean paramBoolean)
  {
    d.remove(dx.a(paramaa.a()));
    a(paramaa.C(), paramBoolean);
  }

  public static void a(MessageEntity paramMessageEntity, a parama)
  {
    Application localApplication = ViberApplication.getApplication();
    ViberApplication.getInstance();
    if (paramMessageEntity.isFile())
    {
      if (paramMessageEntity.isGifFile())
      {
        f(paramMessageEntity, parama);
        return;
      }
      if (paramMessageEntity.isVoiceMessage())
      {
        g(paramMessageEntity, parama);
        return;
      }
      d(paramMessageEntity, parama);
      return;
    }
    if (((paramMessageEntity.isPublicGroupBehavior()) && (!paramMessageEntity.isPublicAccount())) || (paramMessageEntity.isPgForwardedMessage()))
    {
      c(paramMessageEntity, parama);
      return;
    }
    if (paramMessageEntity.isVideoPtt())
    {
      h(paramMessageEntity, parama);
      return;
    }
    if (paramMessageEntity.isAudioPtt())
    {
      b(paramMessageEntity, parama);
      return;
    }
    if ((paramMessageEntity.isHiddenContent()) && (!paramMessageEntity.isWink()))
    {
      File localFile3 = dv.p.b(localApplication, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl(), false);
      a(localFile3, at.g(localFile3), paramMessageEntity, parama);
      return;
    }
    if (paramMessageEntity.isFormattedMessage())
    {
      e(paramMessageEntity, parama);
      return;
    }
    String str = paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl();
    File localFile1;
    if (paramMessageEntity.isPublicGroupBehavior())
      localFile1 = a(paramMessageEntity, localApplication);
    for (File localFile2 = at.g(localFile1); ; localFile2 = o.b(str, paramMessageEntity.getMimeType(), localApplication))
    {
      a(localFile1, localFile2, paramMessageEntity, parama);
      return;
      localFile1 = o.a(str, paramMessageEntity.getMimeType(), localApplication);
    }
  }

  private static void a(MessageEntity paramMessageEntity, String paramString, a parama)
  {
    File localFile1 = dv.u.b(ViberApplication.getApplication(), paramString, false);
    File localFile2 = at.g(localFile1);
    if ((localFile1 == null) || (localFile2 == null))
    {
      i(paramMessageEntity, parama);
      return;
    }
    b(new c(a(localFile1, localFile2, paramMessageEntity, paramString), dx.a(paramMessageEntity), parama));
  }

  private static void a(File paramFile1, File paramFile2, MessageEntity paramMessageEntity, a parama)
  {
    if ((paramFile1 == null) || (paramFile2 == null))
    {
      i(paramMessageEntity, parama);
      return;
    }
    if (paramMessageEntity.isConvertedFromPublicAccountFormat());
    for (Object localObject = new f(paramMessageEntity.getPublicAccountMediaUrl(), paramFile1.getPath(), paramFile2.getPath(), paramMessageEntity.getMimeType()); ; localObject = a(paramFile1, paramFile2, paramMessageEntity))
    {
      b(new c((a)localObject, dx.a(paramMessageEntity), parama));
      return;
    }
  }

  public static void a(String paramString1, String paramString2, long paramLong, a parama)
  {
    if (a(paramString2))
    {
      c localc = (c)e.get(paramString2);
      if (localc != null)
        localc.a(parama);
      return;
    }
    ViberApplication.getInstance();
    File localFile1 = dv.u.b(ViberApplication.getApplication(), paramString1, false);
    File localFile2 = at.g(localFile1);
    if ((localFile1 == null) || (localFile2 == null))
    {
      a(paramLong, parama);
      return;
    }
    b(new c(new e(paramString1, localFile1.getPath(), localFile2.getPath(), paramString2, null), dx.a(paramLong), parama));
  }

  public static void a(String paramString1, String paramString2, a parama)
  {
    if (a(paramString2))
    {
      c localc = (c)e.get(paramString2);
      if (localc != null)
        localc.a(parama);
      return;
    }
    File localFile1 = dv.i.b(ViberApplication.getApplication(), paramString1, false);
    File localFile2 = at.g(localFile1);
    if ((localFile1 == null) || (localFile2 == null))
    {
      a(Uri.parse(paramString1), parama);
      return;
    }
    b(new c(new e(paramString1, localFile1.getPath(), localFile2.getPath(), paramString2, null), Uri.parse(paramString1), parama));
  }

  public static void a(String paramString, final boolean paramBoolean)
  {
    c.post(new Runnable()
    {
      public void run()
      {
        synchronized (s.b())
        {
          s.c localc = (s.c)s.b().get(this.a);
          if ((localc != null) && (!localc.b()))
          {
            localc.c();
            if ((paramBoolean) && (s.c.c(localc).m != null))
              l.d(s.c.d(localc));
          }
          return;
        }
      }
    });
  }

  public static boolean a(Uri paramUri)
  {
    return d.contains(paramUri);
  }

  public static boolean a(String paramString)
  {
    while (true)
    {
      synchronized (e)
      {
        c localc = (c)e.get(paramString);
        if ((localc != null) && (!localc.b()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public static b b(String paramString1, String paramString2, String paramString3)
  {
    return new i.e(paramString1, paramString2, paramString3, null, t.d.c, i.c.b, i.o.b);
  }

  private static a b(MessageEntity paramMessageEntity, File paramFile1, File paramFile2)
  {
    return new g.a(paramMessageEntity.getDownloadId(), paramFile1.getPath(), paramFile2.getPath());
  }

  public static void b(Uri paramUri)
  {
    d.add(paramUri);
  }

  public static void b(MessageEntity paramMessageEntity, a parama)
  {
    File localFile1 = new File(PttUtils.generateLegacyPttFileName(paramMessageEntity.getDownloadId(), ViberApplication.getApplication()));
    File localFile2 = at.g(localFile1);
    int i;
    if (paramMessageEntity.getMessageInfo().getPttVersion() == 2)
    {
      i = 1;
      if (i == 0)
        break label74;
    }
    label74: for (a locala = a(paramMessageEntity, localFile1, localFile2); ; locala = b(paramMessageEntity, localFile1, localFile2))
    {
      b(new c(locala, dx.a(paramMessageEntity), parama));
      return;
      i = 0;
      break;
    }
  }

  private static void b(c paramc)
  {
    if ((a(c.a(paramc))) && (!c.b(paramc).isEmpty()))
      synchronized (e)
      {
        c localc = (c)e.get(c.a(paramc));
        if (localc != null)
          localc.a((a)c.b(paramc).iterator().next());
        return;
      }
    synchronized (e)
    {
      e.put(c.a(paramc), paramc);
      b.post(paramc);
      return;
    }
  }

  private static void c(MessageEntity paramMessageEntity, a parama)
  {
    File localFile1 = a(paramMessageEntity, ViberApplication.getApplication());
    File localFile2 = at.g(localFile1);
    if ((localFile1 == null) || (localFile2 == null))
    {
      i(paramMessageEntity, parama);
      return;
    }
    b(new c(a(localFile1, localFile2, paramMessageEntity), dx.a(paramMessageEntity), parama)
    {
      public void run()
      {
        o.d();
        super.run();
      }
    });
  }

  private static void c(c paramc)
  {
    synchronized (e)
    {
      e.remove(c.a(paramc));
      d.remove(c.d(paramc));
      return;
    }
  }

  private static void d(MessageEntity paramMessageEntity, a parama)
  {
    if ((!o.b()) || (!o.a()))
    {
      i(paramMessageEntity, parama);
      return;
    }
    FileInfo localFileInfo = paramMessageEntity.getMsgInfoFileInfo();
    File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    localFile.mkdirs();
    String str1 = at.b(localFile, localFileInfo.getFileName(), false).getPath();
    String str2 = as.i.a(str1 + a(paramMessageEntity));
    if (paramMessageEntity.isConvertedFromPublicAccountFormat());
    for (Object localObject = new f(paramMessageEntity.getPublicAccountMediaUrl(), str1, str2, paramMessageEntity.getMimeType()); ; localObject = a(new File(str1), new File(str2), paramMessageEntity))
    {
      b(new c((a)localObject, dx.a(paramMessageEntity), parama));
      return;
    }
  }

  private static void e(MessageEntity paramMessageEntity, a parama)
  {
    Iterator localIterator = paramMessageEntity.getFormattedMessage().getMessage().iterator();
    while (localIterator.hasNext())
    {
      BaseMessage localBaseMessage = (BaseMessage)localIterator.next();
      if (localBaseMessage.getType() == MessageType.GIF)
      {
        Uri localUri = Uri.parse(((GifMessage)localBaseMessage).getGifUrl());
        if (dx.l(localUri))
          a(paramMessageEntity, dx.m(localUri).a, parama);
      }
    }
  }

  private static void f(MessageEntity paramMessageEntity, a parama)
  {
    File localFile1 = dv.u.b(ViberApplication.getApplication(), paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl(), false);
    File localFile2 = at.g(localFile1);
    if ((localFile1 == null) || (localFile2 == null))
    {
      i(paramMessageEntity, parama);
      return;
    }
    if (paramMessageEntity.isPublicAccount());
    for (Object localObject = new f(paramMessageEntity.getPublicAccountMediaUrl(), localFile1.getPath(), localFile2.getPath(), paramMessageEntity.getMimeType()); ; localObject = a(localFile1, localFile2, paramMessageEntity))
    {
      b(new c((a)localObject, dx.a(paramMessageEntity), parama));
      return;
    }
  }

  private static void g(MessageEntity paramMessageEntity, a parama)
  {
    if ((!o.b()) || (!o.a()))
    {
      i(paramMessageEntity, parama);
      return;
    }
    File localFile1 = dv.x.b(ViberApplication.getApplication(), paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl(), false);
    File localFile2 = at.g(localFile1);
    if ((localFile1 == null) || (localFile2 == null))
    {
      i(paramMessageEntity, parama);
      return;
    }
    if (paramMessageEntity.isPublicAccount());
    for (Object localObject = new f(paramMessageEntity.getPublicAccountMediaUrl(), localFile1.getPath(), localFile2.getPath(), paramMessageEntity.getMimeType()); ; localObject = a(localFile1, localFile2, paramMessageEntity))
    {
      b(new c((a)localObject, dx.a(paramMessageEntity), parama));
      return;
    }
  }

  private static void h(MessageEntity paramMessageEntity, a parama)
  {
    if ((!o.b()) || (!o.a()))
    {
      i(paramMessageEntity, parama);
      return;
    }
    File localFile1 = dv.A.b(ViberApplication.getApplication(), paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl(), false);
    File localFile2 = at.g(localFile1);
    if ((localFile1 == null) || (localFile2 == null))
    {
      i(paramMessageEntity, parama);
      return;
    }
    if (paramMessageEntity.isConvertedFromPublicAccountFormat());
    for (Object localObject = new f(paramMessageEntity.getPublicAccountMediaUrl(), localFile1.getPath(), localFile2.getPath(), paramMessageEntity.getMimeType()); ; localObject = a(localFile1, localFile2, paramMessageEntity))
    {
      b(new c((a)localObject, dx.a(paramMessageEntity), parama));
      return;
    }
  }

  private static void i(MessageEntity paramMessageEntity, a parama)
  {
    a(paramMessageEntity.getId(), parama);
  }

  static abstract class a extends b
  {
    public a(String paramString1, String paramString2, String paramString3)
    {
      super(paramString2, paramString3);
    }

    abstract String p();
  }

  static class b extends s.a
  {
    protected b(String paramString1, String paramString2, String paramString3)
    {
      super(paramString2, paramString3);
    }

    String p()
    {
      return this.d;
    }
  }

  private static class c
    implements m, Runnable
  {
    private Uri a;
    private String b;
    private s.a c;
    private final Set<a> d;
    private volatile boolean e = false;

    public c(s.a parama, Uri paramUri, a parama1)
    {
      this.b = parama.p();
      this.c = parama;
      this.c.a(this);
      this.d = new HashSet();
      if (parama1 != null)
      {
        this.d.add(parama1);
        parama.a(parama1);
      }
      this.a = paramUri;
    }

    private void a(Uri paramUri)
    {
      synchronized (this.d)
      {
        Iterator localIterator = this.d.iterator();
        if (localIterator.hasNext())
          ((a)localIterator.next()).a(paramUri);
      }
    }

    private void a(s.d paramd)
    {
      synchronized (this.d)
      {
        Iterator localIterator = this.d.iterator();
        if (localIterator.hasNext())
          ((a)localIterator.next()).a(null, paramd);
      }
    }

    protected void a()
    {
      String str = this.c.d();
      Uri localUri = null;
      if (str != null)
        localUri = Uri.fromFile(new File(this.c.d()));
      a(localUri);
    }

    public void a(Uri paramUri, int paramInt)
    {
      if (this.a != null)
        l.b(this.a, paramInt);
    }

    public void a(a parama)
    {
      if (parama != null)
        synchronized (this.d)
        {
          this.d.add(parama);
          return;
        }
    }

    public boolean b()
    {
      return this.e;
    }

    public void c()
    {
      try
      {
        this.e = true;
        if (this.c != null)
          this.c.g();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: invokestatic 115	com/viber/voip/util/upload/s:b	()Ljava/util/Map;
      //   3: astore_1
      //   4: aload_1
      //   5: monitorenter
      //   6: aload_0
      //   7: getfield 34	com/viber/voip/util/upload/s$c:b	Ljava/lang/String;
      //   10: invokestatic 118	com/viber/voip/util/upload/s:a	(Ljava/lang/String;)Z
      //   13: ifne +183 -> 196
      //   16: iconst_1
      //   17: istore_3
      //   18: iload_3
      //   19: ifeq +17 -> 36
      //   22: aload_0
      //   23: getfield 34	com/viber/voip/util/upload/s$c:b	Ljava/lang/String;
      //   26: ifnull +10 -> 36
      //   29: aload_0
      //   30: invokestatic 121	com/viber/voip/util/upload/s:a	(Lcom/viber/voip/util/upload/s$c;)V
      //   33: aload_1
      //   34: monitorexit
      //   35: return
      //   36: aload_1
      //   37: monitorexit
      //   38: aload_0
      //   39: getfield 26	com/viber/voip/util/upload/s$c:e	Z
      //   42: ifne +24 -> 66
      //   45: aload_0
      //   46: getfield 36	com/viber/voip/util/upload/s$c:c	Lcom/viber/voip/util/upload/s$a;
      //   49: invokevirtual 124	com/viber/voip/util/upload/s$a:f	()V
      //   52: aload_0
      //   53: invokevirtual 126	com/viber/voip/util/upload/s$c:a	()V
      //   56: aload_0
      //   57: invokestatic 121	com/viber/voip/util/upload/s:a	(Lcom/viber/voip/util/upload/s$c;)V
      //   60: return
      //   61: astore_2
      //   62: aload_1
      //   63: monitorexit
      //   64: aload_2
      //   65: athrow
      //   66: aload_0
      //   67: getstatic 131	com/viber/voip/util/upload/s$d:b	Lcom/viber/voip/util/upload/s$d;
      //   70: invokespecial 133	com/viber/voip/util/upload/s$c:a	(Lcom/viber/voip/util/upload/s$d;)V
      //   73: goto -17 -> 56
      //   76: astore 6
      //   78: aload_0
      //   79: getfield 26	com/viber/voip/util/upload/s$c:e	Z
      //   82: ifeq +15 -> 97
      //   85: aload_0
      //   86: getstatic 131	com/viber/voip/util/upload/s$d:b	Lcom/viber/voip/util/upload/s$d;
      //   89: invokespecial 133	com/viber/voip/util/upload/s$c:a	(Lcom/viber/voip/util/upload/s$d;)V
      //   92: aload_0
      //   93: invokestatic 121	com/viber/voip/util/upload/s:a	(Lcom/viber/voip/util/upload/s$c;)V
      //   96: return
      //   97: getstatic 138	com/viber/voip/util/upload/b$b:f	Lcom/viber/voip/util/upload/b$b;
      //   100: aload 6
      //   102: invokevirtual 141	com/viber/voip/util/upload/b$a:a	()Lcom/viber/voip/util/upload/b$b;
      //   105: invokevirtual 144	com/viber/voip/util/upload/b$b:equals	(Ljava/lang/Object;)Z
      //   108: ifeq +22 -> 130
      //   111: aload_0
      //   112: getstatic 146	com/viber/voip/util/upload/s$d:c	Lcom/viber/voip/util/upload/s$d;
      //   115: invokespecial 133	com/viber/voip/util/upload/s$c:a	(Lcom/viber/voip/util/upload/s$d;)V
      //   118: goto -26 -> 92
      //   121: astore 5
      //   123: aload_0
      //   124: invokestatic 121	com/viber/voip/util/upload/s:a	(Lcom/viber/voip/util/upload/s$c;)V
      //   127: aload 5
      //   129: athrow
      //   130: getstatic 149	com/viber/voip/util/upload/b$b:h	Lcom/viber/voip/util/upload/b$b;
      //   133: aload 6
      //   135: invokevirtual 141	com/viber/voip/util/upload/b$a:a	()Lcom/viber/voip/util/upload/b$b;
      //   138: invokevirtual 144	com/viber/voip/util/upload/b$b:equals	(Ljava/lang/Object;)Z
      //   141: ifeq +13 -> 154
      //   144: aload_0
      //   145: getstatic 151	com/viber/voip/util/upload/s$d:d	Lcom/viber/voip/util/upload/s$d;
      //   148: invokespecial 133	com/viber/voip/util/upload/s$c:a	(Lcom/viber/voip/util/upload/s$d;)V
      //   151: goto -59 -> 92
      //   154: aload_0
      //   155: getstatic 153	com/viber/voip/util/upload/s$d:a	Lcom/viber/voip/util/upload/s$d;
      //   158: invokespecial 133	com/viber/voip/util/upload/s$c:a	(Lcom/viber/voip/util/upload/s$d;)V
      //   161: goto -69 -> 92
      //   164: astore 4
      //   166: invokestatic 159	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
      //   169: invokevirtual 162	com/viber/voip/ViberApplication:onOutOfMemory	()V
      //   172: invokestatic 165	com/viber/voip/util/upload/s:c	()Lcom/viber/dexshared/Logger;
      //   175: aload 4
      //   177: ldc 167
      //   179: invokeinterface 172 3 0
      //   184: aload_0
      //   185: getstatic 153	com/viber/voip/util/upload/s$d:a	Lcom/viber/voip/util/upload/s$d;
      //   188: invokespecial 133	com/viber/voip/util/upload/s$c:a	(Lcom/viber/voip/util/upload/s$d;)V
      //   191: aload_0
      //   192: invokestatic 121	com/viber/voip/util/upload/s:a	(Lcom/viber/voip/util/upload/s$c;)V
      //   195: return
      //   196: iconst_0
      //   197: istore_3
      //   198: goto -180 -> 18
      //
      // Exception table:
      //   from	to	target	type
      //   6	16	61	finally
      //   22	35	61	finally
      //   36	38	61	finally
      //   62	64	61	finally
      //   38	56	76	com/viber/voip/util/upload/b$a
      //   66	73	76	com/viber/voip/util/upload/b$a
      //   38	56	121	finally
      //   66	73	121	finally
      //   78	92	121	finally
      //   97	118	121	finally
      //   130	151	121	finally
      //   154	161	121	finally
      //   166	191	121	finally
      //   38	56	164	java/lang/OutOfMemoryError
      //   66	73	164	java/lang/OutOfMemoryError
    }
  }

  public static enum d
  {
    static
    {
      d[] arrayOfd = new d[4];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
      arrayOfd[2] = c;
      arrayOfd[3] = d;
    }
  }

  static class e extends s.a
  {
    private EncryptionParams p;
    protected String q;
    private k r;

    protected e(String paramString1, String paramString2, String paramString3, String paramString4, EncryptionParams paramEncryptionParams)
    {
      super(paramString2, paramString3);
      this.q = paramString4;
      if (EncryptionParams.contentIsEncrypted(paramEncryptionParams))
        this.p = paramEncryptionParams;
      this.q = paramString4;
    }

    private double a(long paramLong1, long paramLong2, long paramLong3)
    {
      return (paramLong2 + paramLong3) / (2L * paramLong1);
    }

    // ERROR //
    private void q()
      throws b.a
    {
      // Byte code:
      //   0: new 36	java/util/concurrent/CountDownLatch
      //   3: dup
      //   4: iconst_1
      //   5: invokespecial 39	java/util/concurrent/CountDownLatch:<init>	(I)V
      //   8: astore_1
      //   9: iconst_1
      //   10: anewarray 41	java/lang/Exception
      //   13: astore_2
      //   14: aload_0
      //   15: new 43	com/viber/voip/util/upload/s$e$1
      //   18: dup
      //   19: aload_0
      //   20: aload_0
      //   21: invokevirtual 47	com/viber/voip/util/upload/s$e:n	()Lcom/viber/voip/util/upload/e;
      //   24: aload_0
      //   25: getfield 25	com/viber/voip/util/upload/s$e:p	Lcom/viber/jni/EncryptionParams;
      //   28: new 49	java/io/File
      //   31: dup
      //   32: aload_0
      //   33: getfield 52	com/viber/voip/util/upload/s$e:e	Ljava/lang/String;
      //   36: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
      //   39: new 49	java/io/File
      //   42: dup
      //   43: new 57	java/lang/StringBuilder
      //   46: dup
      //   47: invokespecial 59	java/lang/StringBuilder:<init>	()V
      //   50: aload_0
      //   51: getfield 52	com/viber/voip/util/upload/s$e:e	Ljava/lang/String;
      //   54: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   57: ldc 65
      //   59: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   62: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   65: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
      //   68: new 49	java/io/File
      //   71: dup
      //   72: aload_0
      //   73: getfield 72	com/viber/voip/util/upload/s$e:f	Ljava/lang/String;
      //   76: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
      //   79: aload_2
      //   80: aload_1
      //   81: invokespecial 75	com/viber/voip/util/upload/s$e$1:<init>	(Lcom/viber/voip/util/upload/s$e;Ljava/io/InputStream;Lcom/viber/jni/EncryptionParams;Ljava/io/File;Ljava/io/File;Ljava/io/File;[Ljava/lang/Exception;Ljava/util/concurrent/CountDownLatch;)V
      //   84: putfield 77	com/viber/voip/util/upload/s$e:r	Lcom/viber/voip/util/upload/k;
      //   87: aload_0
      //   88: getfield 77	com/viber/voip/util/upload/s$e:r	Lcom/viber/voip/util/upload/k;
      //   91: aload_0
      //   92: getfield 80	com/viber/voip/util/upload/s$e:a	Lcom/viber/dexshared/Logger;
      //   95: invokevirtual 85	com/viber/voip/util/upload/k:a	(Lcom/viber/dexshared/Logger;)V
      //   98: new 87	java/lang/Thread
      //   101: dup
      //   102: aload_0
      //   103: getfield 77	com/viber/voip/util/upload/s$e:r	Lcom/viber/voip/util/upload/k;
      //   106: invokespecial 90	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
      //   109: invokevirtual 93	java/lang/Thread:start	()V
      //   112: aload_0
      //   113: invokespecial 95	com/viber/voip/util/upload/s$a:f	()V
      //   116: aload_1
      //   117: invokevirtual 98	java/util/concurrent/CountDownLatch:await	()V
      //   120: aload_2
      //   121: iconst_0
      //   122: aaload
      //   123: ifnull +36 -> 159
      //   126: new 32	com/viber/voip/util/upload/b$a
      //   129: dup
      //   130: aload_2
      //   131: iconst_0
      //   132: aaload
      //   133: invokespecial 101	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;)V
      //   136: athrow
      //   137: astore_3
      //   138: aload_2
      //   139: iconst_0
      //   140: aaload
      //   141: ifnonnull -25 -> 116
      //   144: aload_3
      //   145: athrow
      //   146: astore 4
      //   148: new 32	com/viber/voip/util/upload/b$a
      //   151: dup
      //   152: getstatic 107	com/viber/voip/util/upload/b$b:c	Lcom/viber/voip/util/upload/b$b;
      //   155: invokespecial 110	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;)V
      //   158: athrow
      //   159: return
      //
      // Exception table:
      //   from	to	target	type
      //   112	116	137	com/viber/voip/util/upload/b$a
      //   116	120	146	java/lang/InterruptedException
    }

    protected void a(File paramFile)
      throws IOException
    {
      if (EncryptionParams.contentIsEncrypted(this.p))
        return;
      super.a(paramFile);
    }

    public void f()
      throws b.a
    {
      if (da.a(this.q))
        throw new b.a(b.b.j);
      if (i.c(this.q))
        throw new b.a(b.b.i);
      if (o())
      {
        q();
        return;
      }
      super.f();
    }

    protected double m()
    {
      if (this.r != null)
        return a(this.g, this.h, this.r.a());
      return super.m();
    }

    protected boolean o()
    {
      return EncryptionParams.contentIsEncrypted(this.p);
    }

    String p()
    {
      return this.q;
    }
  }

  static class f extends s.b
  {
    private static final List<String> p = Arrays.asList(new String[] { "apk" });
    private static final List<String> q = Arrays.asList(new String[] { "mp4" });
    private static final List<String> r = Arrays.asList(new String[] { "", "jpg", "jpeg", "jpe", "jif", "jfif", "jfi" });
    private final int s;

    protected f(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      super(paramString2, paramString3);
      this.s = paramInt;
    }

    private void c(URL paramURL)
      throws b.a
    {
      String str1 = paramURL.getPath();
      if (da.a(str1))
        throw new b.a(b.b.f);
      String str2 = at.d(Uri.parse(str1).getLastPathSegment());
      if (((1 == this.s) && (!r.contains(str2.toLowerCase()))) || ((3 == this.s) && (!q.contains(str2.toLowerCase()))) || ((10 == this.s) && (p.contains(str2.toLowerCase()))))
        throw new b.a(b.b.f);
    }

    private int o()
    {
      if (1 == this.s);
      do
      {
        return 3145728;
        if (3 == this.s)
          return 52428800;
      }
      while (10 != this.s);
      return 52428800;
    }

    protected void b(URL paramURL)
      throws IOException, b.a
    {
      c(paramURL);
      a(paramURL);
      int i = o();
      if ((a(this.g)) && (i < this.g))
        throw new b.a(b.b.f);
      b((int)(1.1F * i));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.s
 * JD-Core Version:    0.6.2
 */