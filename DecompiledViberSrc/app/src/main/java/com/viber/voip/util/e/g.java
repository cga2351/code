package com.viber.voip.util.e;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.da;
import com.viber.voip.util.dk;
import com.viber.voip.util.dq;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.b.a;
import java.io.FileNotFoundException;
import java.io.IOException;

public class g extends i
{
  private static final Logger d = ViberEnv.getLogger();
  private static final String[] e = { "_data" };
  private final boolean f;
  private final ContentResolver g;

  @Deprecated
  public g(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.g = paramContext.getContentResolver();
    this.f = paramBoolean;
  }

  private static Bitmap a(Uri paramUri, f paramf, d paramd, Context paramContext)
  {
    try
    {
      Bitmap localBitmap = a(paramUri, paramf, paramContext);
      return localBitmap;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.d.c("FetchThumbBitmap", "FILE_NOT_FOUND_ERROR"));
      return null;
    }
    catch (IOException localIOException)
    {
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.d.c("FetchThumbBitmap", "IO_ERROR"));
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.d.c("FetchThumbBitmap", "NULL_POINTER"));
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.d.c("FetchThumbBitmap", "OUT_OF_MEMORY_ERROR"));
      ViberApplication.getInstance().onOutOfMemory();
      return null;
    }
    catch (RuntimeException localRuntimeException)
    {
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.d.a("FetchThumbBitmap", "RUNTIME_EXCEPTION", localRuntimeException.getClass().getCanonicalName(), localRuntimeException.getMessage()));
      return null;
    }
    catch (b.a locala)
    {
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.d.a("FetchThumbBitmap", locala.a()));
    }
    return null;
  }

  private int c(Uri paramUri)
  {
    if ((paramUri == null) || (dx.q(paramUri)) || (dk.a(paramUri)));
    String str;
    do
    {
      return 0;
      str = paramUri.getPath();
    }
    while (da.a(str));
    return j.a(str);
  }

  protected Bitmap a(String paramString)
  {
    if (this.f)
      return super.a(paramString);
    return null;
  }

  // ERROR //
  public Uri a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/viber/voip/util/e/g:g	Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: getstatic 28	com/viber/voip/util/e/g:e	[Ljava/lang/String;
    //   8: invokestatic 156	android/provider/MediaStore$Images$Media:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;)Landroid/database/Cursor;
    //   11: astore 5
    //   13: aload 5
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 6
    //   19: aload_3
    //   20: ifnull +47 -> 67
    //   23: aload_3
    //   24: invokeinterface 162 1 0
    //   29: istore 7
    //   31: aconst_null
    //   32: astore 6
    //   34: iload 7
    //   36: ifeq +31 -> 67
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 166 2 0
    //   46: astore 8
    //   48: aconst_null
    //   49: astore 6
    //   51: aload 8
    //   53: ifnull +14 -> 67
    //   56: aload 8
    //   58: invokestatic 170	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   61: astore 9
    //   63: aload 9
    //   65: astore 6
    //   67: aload_3
    //   68: invokestatic 175	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   71: aload 6
    //   73: areturn
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_3
    //   77: aload_2
    //   78: astore 4
    //   80: aload_3
    //   81: invokestatic 175	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   84: aload 4
    //   86: athrow
    //   87: astore 4
    //   89: goto -9 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   0	13	74	finally
    //   23	31	87	finally
    //   39	48	87	finally
    //   56	63	87	finally
  }

  protected k.d a(Uri paramUri, f paramf)
  {
    int i = -2;
    if (paramUri == null)
      return new k.d(-1, null);
    boolean bool1 = dk.a(paramUri);
    boolean bool2 = j.e(paramUri);
    Uri localUri;
    long l;
    Bitmap localBitmap2;
    label85: Bitmap localBitmap3;
    if (bool1)
    {
      localUri = a(paramUri);
      if (((!this.f) && (!bool2)) || (!bool1))
        break label147;
      l = Long.parseLong(paramUri.getLastPathSegment());
      if (!bool2)
        break label125;
      localBitmap2 = dq.a(this.g, l, 1, null);
      localBitmap3 = j.a(localBitmap2, c(localUri), true);
      if (localBitmap3 != null)
        break label141;
    }
    label141: for (int j = i; ; j = 0)
    {
      return new k.d(j, localBitmap3);
      localUri = paramUri;
      break;
      label125: localBitmap2 = dq.b(this.g, l, 1, null);
      break label85;
    }
    label147: Bitmap localBitmap1 = j.a(a(localUri, paramf, null, this.c), c(localUri), paramf.g());
    if (localBitmap1 == null);
    while (true)
    {
      return new k.d(i, localBitmap1);
      i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.g
 * JD-Core Version:    0.6.2
 */