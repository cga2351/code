package com.viber.voip.util.e;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.viber.common.b.d;
import com.viber.common.d.a;
import com.viber.common.d.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.e.a.c;
import com.viber.voip.settings.d.ax;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.f;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.w;
import com.viber.voip.stickers.x;
import com.viber.voip.util.at;
import com.viber.voip.util.bg.a;
import com.viber.voip.util.bj;
import com.viber.voip.util.da;
import com.viber.voip.util.dk;
import com.viber.voip.util.dq;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j
{
  public static int a;
  private static final Logger b = ViberEnv.getLogger();
  private static final Pattern c = Pattern.compile("file://");

  static
  {
    a();
  }

  public static int a(float paramFloat)
  {
    return a(ViberApplication.getApplication(), paramFloat);
  }

  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      if (paramInt2 == 0)
        return R.drawable.generic_image_half;
      if (paramInt2 == 1)
        return R.drawable.generic_image_quarter_right_top;
      if (paramInt2 == 2)
        return R.drawable.generic_image_quarter_right_bottom;
    }
    else
    {
      if (paramInt2 == 0)
        return R.drawable.generic_image_quarter_left_top;
      if (paramInt2 == 1)
        return R.drawable.generic_image_quarter_right_top;
      if (paramInt2 == 2)
        return R.drawable.generic_image_quarter_left_bottom;
      if (paramInt2 == 3)
        return R.drawable.generic_image_quarter_right_bottom;
    }
    return R.drawable.generic_image_half;
  }

  public static int a(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }

  public static int a(Context paramContext, a parama)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int i;
    int j;
    if (a.b())
    {
      DisplayMetrics localDisplayMetrics2 = a(localDisplay);
      i = localDisplayMetrics2.heightPixels;
      j = localDisplayMetrics2.widthPixels;
    }
    while (parama == a.a)
    {
      return j;
      try
      {
        Method localMethod1 = Display.class.getMethod("getRawHeight", new Class[0]);
        Method localMethod2 = Display.class.getMethod("getRawWidth", new Class[0]);
        i = ((Integer)localMethod1.invoke(localDisplay, new Object[0])).intValue();
        int k = ((Integer)localMethod2.invoke(localDisplay, new Object[0])).intValue();
        j = k;
      }
      catch (Exception localException)
      {
        DisplayMetrics localDisplayMetrics1 = new DisplayMetrics();
        localDisplay.getMetrics(localDisplayMetrics1);
        i = localDisplayMetrics1.heightPixels;
        j = localDisplayMetrics1.widthPixels;
      }
    }
    return i;
  }

  public static int a(dv paramdv, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = 1;
    while (true)
    {
      if (paramdv == dv.q)
      {
        if ((paramInt1 / 2 >= paramFloat1) && (paramInt2 / 2 >= paramFloat2));
      }
      else
        while ((paramInt1 / 2 < paramFloat1) && (paramInt2 / 2 < paramFloat2))
          return i;
      paramInt1 /= 2;
      paramInt2 /= 2;
      i *= 2;
    }
  }

  public static int a(String paramString)
  {
    if (paramString == null)
      return 0;
    try
    {
      int i = new ExifInterface(c.matcher(paramString).replaceAll("")).getAttributeInt("Orientation", 0);
      switch (i)
      {
      case 4:
      case 5:
      case 7:
      default:
        return 0;
      case 3:
        return 180;
      case 6:
        return 90;
      case 8:
      }
      return 270;
    }
    catch (Throwable localThrowable)
    {
    }
    return 0;
  }

  public static int a(pl.droidsonroids.gif.b paramb)
  {
    if (paramb != null)
      return (int)paramb.f();
    return 0;
  }

  public static Bitmap a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, Uri[] paramArrayOfUri)
  {
    if ((paramArrayOfUri.length == 1) || (paramArrayOfUri.length == 2))
      return b(paramContext, paramArrayOfUri[0], paramInt1);
    if (paramArrayOfUri.length > 2)
      return a(paramContext, paramInt2, paramInt3, paramArrayOfUri);
    return null;
  }

  // ERROR //
  public static Bitmap a(Context paramContext, int paramInt1, int paramInt2, Uri paramUri, dv paramdv, int paramInt3, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 202	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   9: ldc 204
    //   11: ldc 206
    //   13: invokeinterface 211 3 0
    //   18: aload_3
    //   19: invokevirtual 217	android/net/Uri:getScheme	()Ljava/lang/String;
    //   22: ifnonnull +16 -> 38
    //   25: aload_3
    //   26: invokevirtual 221	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   29: ldc 223
    //   31: invokevirtual 229	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   34: invokevirtual 233	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   37: astore_3
    //   38: iload 7
    //   40: bipush 90
    //   42: if_icmpeq +11 -> 53
    //   45: iload 7
    //   47: sipush 180
    //   50: if_icmpne +15 -> 65
    //   53: iload 5
    //   55: istore 8
    //   57: iload 6
    //   59: istore 5
    //   61: iload 8
    //   63: istore 6
    //   65: iload 5
    //   67: i2f
    //   68: iload_1
    //   69: i2f
    //   70: fdiv
    //   71: fstore 9
    //   73: iload 6
    //   75: i2f
    //   76: iload_2
    //   77: i2f
    //   78: fdiv
    //   79: fstore 10
    //   81: aload 4
    //   83: iload 5
    //   85: i2f
    //   86: iload 6
    //   88: i2f
    //   89: iload_1
    //   90: iload_2
    //   91: invokestatic 235	com/viber/voip/util/e/j:a	(Lcom/viber/voip/util/dv;FFII)I
    //   94: istore 11
    //   96: fload 10
    //   98: fload 9
    //   100: fcmpg
    //   101: ifge +200 -> 301
    //   104: iload 11
    //   106: fload 10
    //   108: iload_1
    //   109: i2f
    //   110: fmul
    //   111: invokestatic 240	java/lang/Math:round	(F)I
    //   114: imul
    //   115: istore 12
    //   117: new 242	android/graphics/BitmapFactory$Options
    //   120: dup
    //   121: invokespecial 243	android/graphics/BitmapFactory$Options:<init>	()V
    //   124: astore 13
    //   126: aload 13
    //   128: iload 11
    //   130: putfield 246	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   133: aload 13
    //   135: iconst_0
    //   136: putfield 250	android/graphics/BitmapFactory$Options:inDither	Z
    //   139: aload 13
    //   141: iconst_0
    //   142: putfield 253	android/graphics/BitmapFactory$Options:inMutable	Z
    //   145: invokestatic 256	com/viber/common/d/a:d	()Z
    //   148: ifne +15 -> 163
    //   151: aload 13
    //   153: iconst_1
    //   154: putfield 259	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   157: aload 13
    //   159: iconst_1
    //   160: putfield 262	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   163: aload 13
    //   165: getstatic 268	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   168: putfield 271	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   171: iload_1
    //   172: iload 12
    //   174: if_icmpeq +27 -> 201
    //   177: iload 7
    //   179: ifne +22 -> 201
    //   182: aload 13
    //   184: iconst_1
    //   185: putfield 274	android/graphics/BitmapFactory$Options:inScaled	Z
    //   188: aload 13
    //   190: iload_1
    //   191: putfield 277	android/graphics/BitmapFactory$Options:inDensity	I
    //   194: aload 13
    //   196: iload 12
    //   198: putfield 280	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   201: aload_0
    //   202: invokevirtual 284	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   205: astore 14
    //   207: aconst_null
    //   208: astore 15
    //   210: aload 14
    //   212: aload_3
    //   213: invokevirtual 290	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   216: astore 21
    //   218: aload 21
    //   220: astore 18
    //   222: invokestatic 202	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   225: ldc 204
    //   227: ldc_w 292
    //   230: invokeinterface 211 3 0
    //   235: aload 18
    //   237: aload 13
    //   239: invokestatic 297	com/viber/voip/util/dq:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   242: astore 24
    //   244: invokestatic 202	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   247: ldc 204
    //   249: ldc_w 292
    //   252: invokeinterface 299 3 0
    //   257: aload 18
    //   259: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   262: iload 7
    //   264: ifeq +22 -> 286
    //   267: aload 24
    //   269: iload 5
    //   271: iload 6
    //   273: invokestatic 307	java/lang/Math:max	(II)I
    //   276: iconst_1
    //   277: iconst_0
    //   278: iload 7
    //   280: iconst_1
    //   281: invokestatic 310	com/viber/voip/util/e/j:a	(Landroid/graphics/Bitmap;IIZIZ)Landroid/graphics/Bitmap;
    //   284: astore 24
    //   286: invokestatic 202	com/viber/voip/e/a/e:b	()Lcom/viber/voip/e/a/c;
    //   289: ldc 204
    //   291: ldc 206
    //   293: invokeinterface 299 3 0
    //   298: aload 24
    //   300: areturn
    //   301: iload 5
    //   303: iload 11
    //   305: imul
    //   306: istore 12
    //   308: goto -191 -> 117
    //   311: astore 20
    //   313: aload 15
    //   315: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   318: aconst_null
    //   319: areturn
    //   320: astore 17
    //   322: aconst_null
    //   323: astore 18
    //   325: aload 17
    //   327: astore 19
    //   329: aload 18
    //   331: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   334: aload 19
    //   336: athrow
    //   337: astore 19
    //   339: goto -10 -> 329
    //   342: astore 23
    //   344: aload 18
    //   346: astore 15
    //   348: goto -35 -> 313
    //   351: astore 16
    //   353: aconst_null
    //   354: astore 15
    //   356: goto -43 -> 313
    //   359: astore 22
    //   361: aload 18
    //   363: astore 15
    //   365: goto -52 -> 313
    //
    // Exception table:
    //   from	to	target	type
    //   210	218	311	java/io/FileNotFoundException
    //   210	218	320	finally
    //   222	257	337	finally
    //   222	257	342	java/io/FileNotFoundException
    //   210	218	351	java/lang/NullPointerException
    //   222	257	359	java/lang/NullPointerException
  }

  public static Bitmap a(Context paramContext, int paramInt1, int paramInt2, Uri[] paramArrayOfUri)
  {
    if ((paramInt2 == 0) || (paramInt1 == 0))
      return null;
    int i = a(paramContext, 30.0F);
    int j = Math.min(paramArrayOfUri.length, 4);
    if ((j == 3) && (dx.b(paramArrayOfUri[0])) && ((paramInt2 > 222) || (paramInt1 > 222)))
      paramArrayOfUri[0] = dx.b(paramArrayOfUri[0].getLastPathSegment());
    Bitmap[] arrayOfBitmap = new Bitmap[j];
    for (int k = 0; k < j; k++)
    {
      arrayOfBitmap[k] = e.a(paramContext, paramArrayOfUri[k], false);
      if (arrayOfBitmap[k] == null)
        arrayOfBitmap[k] = c(dq.a(paramContext.getResources(), a(j, k)), i, i);
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(paramContext.getResources().getColor(R.color.grey_light));
    if (j == 3)
    {
      arrayOfBitmap[0] = Bitmap.createScaledBitmap(arrayOfBitmap[0], paramInt1, paramInt2, true);
      arrayOfBitmap[0] = Bitmap.createBitmap(arrayOfBitmap[0], paramInt1 / 4, 0, paramInt1 / 2, paramInt2);
    }
    while (true)
    {
      arrayOfBitmap[1] = Bitmap.createScaledBitmap(arrayOfBitmap[1], paramInt1 / 2, paramInt2 / 2, true);
      arrayOfBitmap[2] = Bitmap.createScaledBitmap(arrayOfBitmap[2], paramInt1 / 2, paramInt2 / 2, true);
      if (j != 3)
        break;
      localCanvas.drawBitmap(arrayOfBitmap[0], 0.0F, 0.0F, new Paint(1));
      localCanvas.drawBitmap(arrayOfBitmap[1], paramInt1 / 2, 0.0F, new Paint(1));
      localCanvas.drawBitmap(arrayOfBitmap[2], paramInt1 / 2, paramInt2 / 2, new Paint(1));
      return localBitmap;
      arrayOfBitmap[0] = Bitmap.createScaledBitmap(arrayOfBitmap[0], paramInt1 / 2, paramInt2 / 2, true);
      arrayOfBitmap[3] = Bitmap.createScaledBitmap(arrayOfBitmap[3], paramInt1 / 2, paramInt2 / 2, true);
    }
    localCanvas.drawBitmap(arrayOfBitmap[0], 0.0F, 0.0F, new Paint(1));
    localCanvas.drawBitmap(arrayOfBitmap[1], paramInt1 / 2, 0.0F, new Paint(1));
    localCanvas.drawBitmap(arrayOfBitmap[2], 0.0F, paramInt2 / 2, new Paint(1));
    localCanvas.drawBitmap(arrayOfBitmap[3], paramInt1 / 2, paramInt2 / 2, new Paint(1));
    return localBitmap;
  }

  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      int i = b(paramInt1, paramInt2);
      if (i == 0)
      {
        if (paramBoolean)
          return paramBitmap;
        return null;
      }
      Paint localPaint1 = new Paint(3);
      Path localPath = new Path();
      h.c(i, i, localPath);
      Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawPath(localPath, localPaint1);
      localPaint1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, i, i), localPaint1);
      String str = da.f(paramString);
      if ((paramBoolean) && (!da.a(str)))
      {
        Rect localRect1 = new Rect();
        localRect1.set(0, 0, i, i);
        Paint localPaint2 = new Paint(1);
        localPaint2.setColor(paramContext.getResources().getColor(R.color.link_text));
        localPaint2.setTextSize(paramContext.getResources().getDimension(R.dimen.initals_text_size_in_notifications));
        localPaint2.setTypeface(Typeface.create("sans-serif-light", 0));
        Rect localRect2 = new Rect();
        a(localCanvas, str, localRect1, localPaint2, ContextCompat.getDrawable(paramContext, R.drawable.generic_image_sixty_x_sixty_gray), localRect2);
      }
      return localBitmap;
    }
    return null;
  }

  public static Bitmap a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean)
    throws FileNotFoundException, IOException
  {
    return a(paramContext, paramUri, paramInt1, paramInt2, paramBoolean, false);
  }

  public static Bitmap a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    throws FileNotFoundException, IOException
  {
    return a(paramContext, paramUri, null, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }

  // ERROR //
  private static Bitmap a(Context paramContext, Uri paramUri, dv paramdv, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: invokevirtual 217	android/net/Uri:getScheme	()Ljava/lang/String;
    //   10: ifnonnull +16 -> 26
    //   13: aload_1
    //   14: invokevirtual 221	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   17: ldc 223
    //   19: invokevirtual 229	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   22: invokevirtual 233	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   25: astore_1
    //   26: iload 4
    //   28: bipush 254
    //   30: if_icmpne +253 -> 283
    //   33: iconst_1
    //   34: istore 7
    //   36: iload 7
    //   38: ifeq +8 -> 46
    //   41: sipush 400
    //   44: istore 4
    //   46: aload_0
    //   47: aload_1
    //   48: invokestatic 496	com/viber/voip/util/at:a	(Landroid/content/Context;Landroid/net/Uri;)Ljava/io/File;
    //   51: astore 8
    //   53: aload 8
    //   55: ifnull +234 -> 289
    //   58: aload 8
    //   60: invokevirtual 501	java/io/File:getPath	()Ljava/lang/String;
    //   63: astore 9
    //   65: aload 9
    //   67: invokestatic 503	com/viber/voip/util/e/j:a	(Ljava/lang/String;)I
    //   70: istore 10
    //   72: iload 10
    //   74: bipush 90
    //   76: if_icmpeq +11 -> 87
    //   79: iload 10
    //   81: sipush 180
    //   84: if_icmpne +661 -> 745
    //   87: iload_3
    //   88: istore 11
    //   90: iload 4
    //   92: istore 12
    //   94: iconst_1
    //   95: istore 13
    //   97: iload 12
    //   99: iconst_m1
    //   100: if_icmple +46 -> 146
    //   103: iload 11
    //   105: iconst_m1
    //   106: if_icmple +40 -> 146
    //   109: aload_0
    //   110: aload_1
    //   111: invokestatic 506	com/viber/voip/util/e/j:a	(Landroid/content/Context;Landroid/net/Uri;)Landroid/graphics/BitmapFactory$Options;
    //   114: astore 39
    //   116: aload 39
    //   118: getfield 509	android/graphics/BitmapFactory$Options:outWidth	I
    //   121: istore 40
    //   123: aload 39
    //   125: getfield 512	android/graphics/BitmapFactory$Options:outHeight	I
    //   128: istore 41
    //   130: aload_2
    //   131: iload 12
    //   133: i2f
    //   134: iload 11
    //   136: i2f
    //   137: iload 40
    //   139: iload 41
    //   141: invokestatic 235	com/viber/voip/util/e/j:a	(Lcom/viber/voip/util/dv;FFII)I
    //   144: istore 13
    //   146: new 242	android/graphics/BitmapFactory$Options
    //   149: dup
    //   150: invokespecial 243	android/graphics/BitmapFactory$Options:<init>	()V
    //   153: astore 14
    //   155: aload 14
    //   157: iload 13
    //   159: putfield 246	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   162: aload 14
    //   164: iconst_0
    //   165: putfield 250	android/graphics/BitmapFactory$Options:inDither	Z
    //   168: aload 14
    //   170: iload 6
    //   172: putfield 253	android/graphics/BitmapFactory$Options:inMutable	Z
    //   175: invokestatic 256	com/viber/common/d/a:d	()Z
    //   178: ifne +15 -> 193
    //   181: aload 14
    //   183: iconst_1
    //   184: putfield 259	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   187: aload 14
    //   189: iconst_1
    //   190: putfield 262	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   193: aload 14
    //   195: getstatic 268	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   198: putfield 271	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   201: aload_0
    //   202: invokevirtual 284	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   205: astore 15
    //   207: aload_2
    //   208: ifnull +10 -> 218
    //   211: aload_2
    //   212: getstatic 152	com/viber/voip/util/dv:q	Lcom/viber/voip/util/dv;
    //   215: if_acmpeq +80 -> 295
    //   218: iconst_1
    //   219: istore 16
    //   221: iload 16
    //   223: ifeq +324 -> 547
    //   226: iconst_0
    //   227: istore 23
    //   229: ldc 242
    //   231: ldc_w 514
    //   234: invokevirtual 518	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   237: aload 14
    //   239: iconst_1
    //   240: invokevirtual 524	java/lang/reflect/Field:setBoolean	(Ljava/lang/Object;Z)V
    //   243: iload 23
    //   245: ifeq +276 -> 521
    //   248: aconst_null
    //   249: astore 26
    //   251: aload 15
    //   253: aload_1
    //   254: ldc_w 526
    //   257: invokevirtual 530	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   260: astore 32
    //   262: aload 32
    //   264: astore 29
    //   266: aload 29
    //   268: ifnonnull +41 -> 309
    //   271: aload 29
    //   273: ifnull -269 -> 4
    //   276: aload 29
    //   278: invokevirtual 535	android/os/ParcelFileDescriptor:close	()V
    //   281: aconst_null
    //   282: areturn
    //   283: iconst_0
    //   284: istore 7
    //   286: goto -250 -> 36
    //   289: aconst_null
    //   290: astore 9
    //   292: goto -227 -> 65
    //   295: iconst_0
    //   296: istore 16
    //   298: goto -77 -> 221
    //   301: astore 38
    //   303: iconst_1
    //   304: istore 23
    //   306: goto -63 -> 243
    //   309: aload 29
    //   311: invokevirtual 539	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   314: aconst_null
    //   315: aload 14
    //   317: invokestatic 542	com/viber/voip/util/dq:a	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   320: astore 35
    //   322: aload 35
    //   324: astore 18
    //   326: aload 29
    //   328: ifnull +8 -> 336
    //   331: aload 29
    //   333: invokevirtual 535	android/os/ParcelFileDescriptor:close	()V
    //   336: aload 18
    //   338: ifnull +3 -> 341
    //   341: aload 18
    //   343: ifnull +325 -> 668
    //   346: aload 18
    //   348: invokevirtual 545	android/graphics/Bitmap:getHeight	()I
    //   351: iload 11
    //   353: if_icmpgt +20 -> 373
    //   356: aload 18
    //   358: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   361: iload 12
    //   363: if_icmpgt +10 -> 373
    //   366: aload_2
    //   367: getstatic 152	com/viber/voip/util/dv:q	Lcom/viber/voip/util/dv;
    //   370: if_acmpne +298 -> 668
    //   373: aload_2
    //   374: getstatic 152	com/viber/voip/util/dv:q	Lcom/viber/voip/util/dv;
    //   377: if_acmpne +196 -> 573
    //   380: iconst_2
    //   381: istore 19
    //   383: iload 19
    //   385: iconst_1
    //   386: if_icmpne +193 -> 579
    //   389: iload 11
    //   391: iload 12
    //   393: invokestatic 307	java/lang/Math:max	(II)I
    //   396: istore 20
    //   398: iload 7
    //   400: ifeq +201 -> 601
    //   403: iload 11
    //   405: i2f
    //   406: aload 18
    //   408: invokevirtual 545	android/graphics/Bitmap:getHeight	()I
    //   411: i2f
    //   412: fdiv
    //   413: iload 12
    //   415: i2f
    //   416: aload 18
    //   418: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   421: i2f
    //   422: fdiv
    //   423: fcmpg
    //   424: ifge +167 -> 591
    //   427: iconst_4
    //   428: istore 19
    //   430: iload 11
    //   432: istore 20
    //   434: iload 5
    //   436: ifeq +232 -> 668
    //   439: aload_2
    //   440: getstatic 152	com/viber/voip/util/dv:q	Lcom/viber/voip/util/dv;
    //   443: if_acmpeq +10 -> 453
    //   446: aload_2
    //   447: getstatic 550	com/viber/voip/util/dv:f	Lcom/viber/voip/util/dv;
    //   450: if_acmpne +183 -> 633
    //   453: aload 18
    //   455: iload 12
    //   457: iload 11
    //   459: iload 10
    //   461: invokestatic 553	com/viber/voip/util/e/j:a	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   464: astore 21
    //   466: aload 18
    //   468: aload 21
    //   470: if_acmpeq +8 -> 478
    //   473: aload 18
    //   475: invokestatic 555	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   478: aload 21
    //   480: areturn
    //   481: astore 31
    //   483: aload 26
    //   485: ifnull +254 -> 739
    //   488: aload 26
    //   490: invokevirtual 535	android/os/ParcelFileDescriptor:close	()V
    //   493: aconst_null
    //   494: astore 18
    //   496: goto -160 -> 336
    //   499: astore 28
    //   501: aconst_null
    //   502: astore 29
    //   504: aload 28
    //   506: astore 30
    //   508: aload 29
    //   510: ifnull +8 -> 518
    //   513: aload 29
    //   515: invokevirtual 535	android/os/ParcelFileDescriptor:close	()V
    //   518: aload 30
    //   520: athrow
    //   521: aload 15
    //   523: aload_1
    //   524: invokevirtual 290	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   527: astore 25
    //   529: aload 25
    //   531: aconst_null
    //   532: aload 14
    //   534: invokestatic 558	com/viber/voip/util/dq:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   537: astore 18
    //   539: aload 25
    //   541: invokevirtual 561	java/io/InputStream:close	()V
    //   544: goto -208 -> 336
    //   547: aload 15
    //   549: aload_1
    //   550: invokevirtual 290	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   553: astore 17
    //   555: aload 17
    //   557: aconst_null
    //   558: aload 14
    //   560: invokestatic 558	com/viber/voip/util/dq:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   563: astore 18
    //   565: aload 17
    //   567: invokevirtual 561	java/io/InputStream:close	()V
    //   570: goto -234 -> 336
    //   573: iconst_1
    //   574: istore 19
    //   576: goto -193 -> 383
    //   579: iload 11
    //   581: iload 12
    //   583: invokestatic 314	java/lang/Math:min	(II)I
    //   586: istore 20
    //   588: goto -190 -> 398
    //   591: iconst_3
    //   592: istore 19
    //   594: iload 12
    //   596: istore 20
    //   598: goto -164 -> 434
    //   601: iload 11
    //   603: iconst_m1
    //   604: if_icmpne +13 -> 617
    //   607: iconst_3
    //   608: istore 19
    //   610: iload 12
    //   612: istore 20
    //   614: goto -180 -> 434
    //   617: iload 12
    //   619: iconst_m1
    //   620: if_icmpne -186 -> 434
    //   623: iconst_4
    //   624: istore 19
    //   626: iload 11
    //   628: istore 20
    //   630: goto -196 -> 434
    //   633: aload_2
    //   634: getstatic 152	com/viber/voip/util/dv:q	Lcom/viber/voip/util/dv;
    //   637: if_acmpne +25 -> 662
    //   640: iconst_1
    //   641: istore 22
    //   643: aload 18
    //   645: iload 20
    //   647: iload 19
    //   649: iload 22
    //   651: iload 10
    //   653: iconst_1
    //   654: invokestatic 310	com/viber/voip/util/e/j:a	(Landroid/graphics/Bitmap;IIZIZ)Landroid/graphics/Bitmap;
    //   657: astore 21
    //   659: goto -193 -> 466
    //   662: iconst_0
    //   663: istore 22
    //   665: goto -22 -> 643
    //   668: aload 18
    //   670: ifnull +12 -> 682
    //   673: aload 18
    //   675: iload 10
    //   677: iconst_1
    //   678: invokestatic 564	com/viber/voip/util/e/j:a	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   681: areturn
    //   682: aconst_null
    //   683: areturn
    //   684: astore 30
    //   686: goto -178 -> 508
    //   689: astore 34
    //   691: aload 29
    //   693: astore 26
    //   695: goto -212 -> 483
    //   698: astore 27
    //   700: aconst_null
    //   701: astore 26
    //   703: goto -220 -> 483
    //   706: astore 33
    //   708: aload 29
    //   710: astore 26
    //   712: goto -229 -> 483
    //   715: astore 37
    //   717: iconst_0
    //   718: istore 23
    //   720: goto -477 -> 243
    //   723: astore 36
    //   725: iconst_0
    //   726: istore 23
    //   728: goto -485 -> 243
    //   731: astore 24
    //   733: iconst_0
    //   734: istore 23
    //   736: goto -493 -> 243
    //   739: aconst_null
    //   740: astore 18
    //   742: goto -406 -> 336
    //   745: iload 4
    //   747: istore 11
    //   749: iload_3
    //   750: istore 12
    //   752: goto -658 -> 94
    //
    // Exception table:
    //   from	to	target	type
    //   229	243	301	java/lang/NoSuchFieldException
    //   251	262	481	java/lang/Exception
    //   251	262	499	finally
    //   309	322	684	finally
    //   309	322	689	java/lang/Exception
    //   251	262	698	java/lang/OutOfMemoryError
    //   309	322	706	java/lang/OutOfMemoryError
    //   229	243	715	java/lang/IllegalAccessException
    //   229	243	723	java/lang/SecurityException
    //   229	243	731	java/lang/IllegalArgumentException
  }

  public static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap != null);
    while (true)
    {
      try
      {
        if (paramBitmap.getWidth() > paramBitmap.getHeight())
        {
          int k = (paramBitmap.getWidth() - paramBitmap.getHeight()) / 2;
          int m = 0;
          if (k > 0)
            m = k - 1;
          Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap, m, 0, paramBitmap.getHeight(), paramBitmap.getHeight());
          localObject = localBitmap2;
          if (localObject != paramBitmap)
            c(paramBitmap);
          return localObject;
        }
        if (paramBitmap.getHeight() > paramBitmap.getWidth())
        {
          int i = (paramBitmap.getHeight() - paramBitmap.getWidth()) / 2;
          int j = 0;
          if (i > 0)
            j = i - 1;
          Bitmap localBitmap1 = Bitmap.createBitmap(paramBitmap, 0, j, paramBitmap.getWidth(), paramBitmap.getWidth());
          localObject = localBitmap1;
          continue;
        }
      }
      catch (Exception localException)
      {
        localObject = paramBitmap;
        continue;
      }
      Object localObject = paramBitmap;
    }
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramBitmap == null));
    while (true)
    {
      return paramBitmap;
      Matrix localMatrix = new Matrix();
      localMatrix.postRotate(paramInt1);
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int i3;
      if (i > j)
        i3 = i - j;
      try
      {
        int i4 = i3 / 2;
        if (i4 > 0)
        {
          i5 = i4 - 1;
          break label243;
          float f = paramInt2 / j;
          if (f < 1.0F)
            localMatrix.postScale(f, f);
          Bitmap localBitmap3 = Bitmap.createBitmap(paramBitmap, k, m, j, j, localMatrix, true);
          localBitmap1 = localBitmap3;
          if (localBitmap1 == paramBitmap);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        while (true)
        {
          int i5;
          try
          {
            c(paramBitmap);
            Bitmap localBitmap2 = localBitmap1;
            if (localBitmap2 == null)
              break;
            return localBitmap2;
            i5 = 0;
            break label243;
            if (j > i)
            {
              int n = j - i;
              int i1 = n / 2;
              if (i1 > 0)
              {
                i2 = i1 - 1;
                j = i;
                m = i2;
                k = 0;
                continue;
              }
              int i2 = 0;
              continue;
            }
            j = i;
            k = 0;
            m = 0;
            continue;
            localOutOfMemoryError1 = localOutOfMemoryError1;
            Bitmap localBitmap1 = null;
            b.a(localOutOfMemoryError1, "Not enough memory to rotate bitmap.");
            ViberApplication.getInstance().onOutOfMemory();
            localBitmap2 = localBitmap1;
            continue;
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            continue;
          }
          label243: int k = i5;
          int m = 0;
        }
      }
    }
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramBitmap, paramInt1, paramInt2, paramInt3, true);
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Bitmap localBitmap;
    if (paramBitmap == null)
      localBitmap = null;
    label77: 
    do
    {
      return localBitmap;
      if ((paramBitmap.getWidth() < paramInt1) && (paramBitmap.getHeight() < paramInt2))
      {
        int i;
        if (paramInt1 / paramBitmap.getWidth() > paramInt2 / paramBitmap.getHeight())
        {
          i = 4;
          if (i != 4)
            break label77;
        }
        for (int j = paramInt2; ; j = paramInt1)
        {
          return a(paramBitmap, j, i, true, paramInt3, paramBoolean);
          i = 3;
          break;
        }
      }
      if ((paramBitmap.getWidth() < paramInt1) && (paramBitmap.getHeight() > paramInt2))
        return a(paramBitmap, paramBitmap.getWidth(), paramInt2, true, paramBoolean);
      localBitmap = a(paramBitmap, paramInt1, 3, false, paramInt3, paramBoolean);
    }
    while (localBitmap.getHeight() <= paramInt2);
    return a(localBitmap, localBitmap.getWidth(), paramInt2, true, paramBoolean);
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(paramBitmap, paramInt1, paramInt2, paramBoolean, 0, true);
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBitmap == null)
      localObject = null;
    while (true)
    {
      return localObject;
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      float f;
      Matrix localMatrix;
      if (a(i, j, paramInt2))
      {
        f = paramInt1 / j;
        if ((f >= 1.0F) && (!paramBoolean1))
          break label164;
        localMatrix = new Matrix();
        localMatrix.postScale(f, f);
        if (paramInt3 != 0)
          localMatrix.postRotate(paramInt3);
      }
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
        localObject = localBitmap;
        if ((paramBoolean2) && (paramBitmap != localObject))
        {
          c(paramBitmap);
          return localObject;
          f = paramInt1 / i;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (true)
        {
          b.a(localOutOfMemoryError, "Not enough memory to resize image");
          ViberApplication.getInstance().onOutOfMemory();
          localObject = null;
        }
      }
    }
    label164: return a(paramBitmap, paramInt3, paramBoolean2);
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBitmap != null)
    {
      int i;
      if ((paramBoolean1) && (paramBitmap.getWidth() > paramInt1))
        i = (paramBitmap.getWidth() - paramInt1) / 2;
      while (true)
      {
        int j = 0;
        if (paramBoolean1)
        {
          int k = paramBitmap.getHeight();
          j = 0;
          if (k > paramInt2)
            j = (paramBitmap.getHeight() - paramInt2) / 2;
        }
        try
        {
          Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap, i, j, paramInt1, paramInt2);
          localBitmap1 = localBitmap2;
          if ((paramBoolean2) && (localBitmap1 != null) && (localBitmap1 != paramBitmap))
            c(paramBitmap);
          return localBitmap1;
          i = 0;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          while (true)
          {
            ViberApplication.getInstance().onOutOfMemory();
            b.a(localOutOfMemoryError, "Not enough memory to crop image.");
            Bitmap localBitmap1 = null;
          }
        }
      }
    }
    return null;
  }

  // ERROR //
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +7 -> 8
    //   4: aload_0
    //   5: ifnonnull +5 -> 10
    //   8: aload_0
    //   9: areturn
    //   10: new 567	android/graphics/Matrix
    //   13: dup
    //   14: invokespecial 568	android/graphics/Matrix:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: iload_1
    //   20: i2f
    //   21: invokevirtual 572	android/graphics/Matrix:postRotate	(F)Z
    //   24: pop
    //   25: aload_0
    //   26: iconst_0
    //   27: iconst_0
    //   28: aload_0
    //   29: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   32: aload_0
    //   33: invokevirtual 545	android/graphics/Bitmap:getHeight	()I
    //   36: aload_3
    //   37: iconst_1
    //   38: invokestatic 579	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   41: astore 8
    //   43: aload 8
    //   45: astore 6
    //   47: iload_2
    //   48: ifeq +13 -> 61
    //   51: aload 6
    //   53: aload_0
    //   54: if_acmpeq +7 -> 61
    //   57: aload_0
    //   58: invokestatic 555	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   61: aload 6
    //   63: astore 7
    //   65: aload 7
    //   67: ifnull -59 -> 8
    //   70: aload 7
    //   72: areturn
    //   73: astore 5
    //   75: aconst_null
    //   76: astore 6
    //   78: getstatic 20	com/viber/voip/util/e/j:b	Lcom/viber/dexshared/Logger;
    //   81: aload 5
    //   83: ldc_w 581
    //   86: invokeinterface 586 3 0
    //   91: invokestatic 590	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   94: invokevirtual 593	com/viber/voip/ViberApplication:onOutOfMemory	()V
    //   97: aload 6
    //   99: astore 7
    //   101: goto -36 -> 65
    //   104: astore 5
    //   106: goto -28 -> 78
    //
    // Exception table:
    //   from	to	target	type
    //   25	43	73	java/lang/OutOfMemoryError
    //   57	61	104	java/lang/OutOfMemoryError
  }

  public static Bitmap a(Path paramPath, Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(1);
    localPaint.setStyle(Paint.Style.FILL);
    localCanvas.drawPath(paramPath, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    paramBitmap.recycle();
    return localBitmap;
  }

  public static Bitmap a(Sticker paramSticker)
  {
    if ((paramSticker == null) || (!paramSticker.isReady()));
    com.viber.voip.b.a.a.a.b localb;
    do
    {
      return null;
      if (paramSticker.isSvg())
      {
        Picture localPicture = i.a().f().a(paramSticker, paramSticker.getConversationWidth(), paramSticker.getConversationHeight(), paramSticker.getOrigPath(), true, w.a, false);
        Bitmap localBitmap = Bitmap.createBitmap(paramSticker.getConversationWidth(), paramSticker.getConversationHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(localBitmap).drawPicture(localPicture);
        return localBitmap;
      }
      localb = i.a().e().a(paramSticker, false, true, w.a);
    }
    while (localb == null);
    return localb.a();
  }

  // ERROR //
  public static Bitmap a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 679	com/google/e/h/b
    //   3: dup
    //   4: invokespecial 680	com/google/e/h/b:<init>	()V
    //   7: aload_0
    //   8: getstatic 686	com/google/e/a:l	Lcom/google/e/a;
    //   11: iload_1
    //   12: iload_1
    //   13: invokevirtual 689	com/google/e/h/b:a	(Ljava/lang/String;Lcom/google/e/a;II)Lcom/google/e/c/b;
    //   16: astore 7
    //   18: aload 7
    //   20: invokevirtual 693	com/google/e/c/b:e	()I
    //   23: istore 8
    //   25: aload 7
    //   27: invokevirtual 695	com/google/e/c/b:f	()I
    //   30: istore 9
    //   32: iload 8
    //   34: iload 9
    //   36: imul
    //   37: newarray int
    //   39: astore 10
    //   41: iconst_0
    //   42: istore 11
    //   44: goto +143 -> 187
    //   47: iload 14
    //   49: iload 8
    //   51: if_icmpge +162 -> 213
    //   54: iload 13
    //   56: iload 14
    //   58: iadd
    //   59: istore 15
    //   61: aload 7
    //   63: iload 14
    //   65: iload 11
    //   67: invokevirtual 698	com/google/e/c/b:a	(II)Z
    //   70: ifeq +137 -> 207
    //   73: ldc_w 699
    //   76: istore 16
    //   78: aload 10
    //   80: iload 15
    //   82: iload 16
    //   84: iastore
    //   85: iinc 14 1
    //   88: goto -41 -> 47
    //   91: iload 8
    //   93: iload 9
    //   95: getstatic 268	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   98: invokestatic 344	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   101: astore 12
    //   103: aload 12
    //   105: astore 4
    //   107: aload 4
    //   109: aload 10
    //   111: iconst_0
    //   112: iload 8
    //   114: iconst_0
    //   115: iconst_0
    //   116: iload 8
    //   118: iload 9
    //   120: invokevirtual 703	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   123: aload 4
    //   125: areturn
    //   126: astore 5
    //   128: aload 5
    //   130: astore 6
    //   132: aconst_null
    //   133: astore 4
    //   135: getstatic 20	com/viber/voip/util/e/j:b	Lcom/viber/dexshared/Logger;
    //   138: aload 6
    //   140: ldc_w 705
    //   143: invokeinterface 586 3 0
    //   148: aload 4
    //   150: areturn
    //   151: astore_2
    //   152: aload_2
    //   153: astore_3
    //   154: aconst_null
    //   155: astore 4
    //   157: getstatic 20	com/viber/voip/util/e/j:b	Lcom/viber/dexshared/Logger;
    //   160: aload_3
    //   161: ldc_w 707
    //   164: invokeinterface 586 3 0
    //   169: invokestatic 590	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   172: invokevirtual 593	com/viber/voip/ViberApplication:onOutOfMemory	()V
    //   175: aload 4
    //   177: areturn
    //   178: astore_3
    //   179: goto -22 -> 157
    //   182: astore 6
    //   184: goto -49 -> 135
    //   187: iload 11
    //   189: iload 9
    //   191: if_icmpge -100 -> 91
    //   194: iload 11
    //   196: iload 8
    //   198: imul
    //   199: istore 13
    //   201: iconst_0
    //   202: istore 14
    //   204: goto -157 -> 47
    //   207: iconst_0
    //   208: istore 16
    //   210: goto -132 -> 78
    //   213: iinc 11 1
    //   216: goto -29 -> 187
    //
    // Exception table:
    //   from	to	target	type
    //   0	41	126	com/google/e/r
    //   61	73	126	com/google/e/r
    //   78	85	126	com/google/e/r
    //   91	103	126	com/google/e/r
    //   0	41	151	java/lang/OutOfMemoryError
    //   61	73	151	java/lang/OutOfMemoryError
    //   78	85	151	java/lang/OutOfMemoryError
    //   91	103	151	java/lang/OutOfMemoryError
    //   107	123	178	java/lang/OutOfMemoryError
    //   107	123	182	com/google/e/r
  }

  // ERROR //
  public static BitmapFactory.Options a(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 284	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_2
    //   5: new 242	android/graphics/BitmapFactory$Options
    //   8: dup
    //   9: invokespecial 243	android/graphics/BitmapFactory$Options:<init>	()V
    //   12: astore_3
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual 290	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   21: astore 17
    //   23: aload 17
    //   25: astore 4
    //   27: aload 4
    //   29: aload_3
    //   30: invokestatic 710	com/viber/voip/util/e/j:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/BitmapFactory$Options;
    //   33: pop
    //   34: aload 4
    //   36: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   39: aload_3
    //   40: areturn
    //   41: astore 16
    //   43: aload 4
    //   45: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   48: aload_3
    //   49: areturn
    //   50: astore 14
    //   52: aconst_null
    //   53: astore 6
    //   55: aload 14
    //   57: astore 15
    //   59: getstatic 20	com/viber/voip/util/e/j:b	Lcom/viber/dexshared/Logger;
    //   62: aload 15
    //   64: new 712	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 713	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 715
    //   74: invokevirtual 719	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: invokevirtual 720	android/net/Uri:getPath	()Ljava/lang/String;
    //   81: invokevirtual 719	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 723	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokeinterface 586 3 0
    //   92: aload 6
    //   94: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   97: aload_3
    //   98: areturn
    //   99: astore 8
    //   101: aconst_null
    //   102: astore 6
    //   104: aload 8
    //   106: astore 9
    //   108: getstatic 20	com/viber/voip/util/e/j:b	Lcom/viber/dexshared/Logger;
    //   111: astore 10
    //   113: new 712	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 713	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 725
    //   123: invokevirtual 719	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: astore 11
    //   128: aload_1
    //   129: ifnonnull +34 -> 163
    //   132: ldc_w 727
    //   135: astore 13
    //   137: aload 10
    //   139: aload 9
    //   141: aload 11
    //   143: aload 13
    //   145: invokevirtual 719	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 723	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokeinterface 586 3 0
    //   156: aload 6
    //   158: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   161: aload_3
    //   162: areturn
    //   163: aload_1
    //   164: invokevirtual 720	android/net/Uri:getPath	()Ljava/lang/String;
    //   167: astore 12
    //   169: aload 12
    //   171: astore 13
    //   173: goto -36 -> 137
    //   176: astore 5
    //   178: aconst_null
    //   179: astore 6
    //   181: aload 5
    //   183: astore 7
    //   185: aload 6
    //   187: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   190: aload 7
    //   192: athrow
    //   193: astore 20
    //   195: aload 4
    //   197: astore 6
    //   199: aload 20
    //   201: astore 7
    //   203: goto -18 -> 185
    //   206: astore 7
    //   208: goto -23 -> 185
    //   211: astore 19
    //   213: aload 4
    //   215: astore 6
    //   217: aload 19
    //   219: astore 9
    //   221: goto -113 -> 108
    //   224: astore 18
    //   226: aload 4
    //   228: astore 6
    //   230: aload 18
    //   232: astore 15
    //   234: goto -175 -> 59
    //
    // Exception table:
    //   from	to	target	type
    //   16	23	41	java/io/FileNotFoundException
    //   27	34	41	java/io/FileNotFoundException
    //   16	23	50	java/lang/SecurityException
    //   16	23	99	java/lang/NullPointerException
    //   16	23	176	finally
    //   27	34	193	finally
    //   59	92	206	finally
    //   108	128	206	finally
    //   137	156	206	finally
    //   163	169	206	finally
    //   27	34	211	java/lang/NullPointerException
    //   27	34	224	java/lang/SecurityException
  }

  public static BitmapFactory.Options a(Context paramContext, Uri paramUri, int paramInt)
  {
    return c(paramContext, paramUri, paramInt);
  }

  // ERROR //
  private static BitmapFactory.Options a(InputStream paramInputStream, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: iconst_1
    //   6: putfield 733	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   9: aload_0
    //   10: aconst_null
    //   11: aload_1
    //   12: invokestatic 558	com/viber/voip/util/dq:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   15: pop
    //   16: aload_0
    //   17: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   20: aload_1
    //   21: areturn
    //   22: astore_3
    //   23: aload_0
    //   24: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   27: aload_1
    //   28: areturn
    //   29: astore_2
    //   30: aload_0
    //   31: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   34: aload_2
    //   35: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	16	22	java/lang/Exception
    //   9	16	29	finally
  }

  public static Canvas a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Rect paramRect, Paint paramPaint, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(paramRect);
      paramDrawable.draw(paramCanvas);
    }
    paramCanvas.drawText(paramString, paramRect.centerX() - paramFloat1 / 2.0F, paramRect.centerY() + paramFloat2 / 2.0F, paramPaint);
    return paramCanvas;
  }

  public static Canvas a(Canvas paramCanvas, String paramString, Rect paramRect1, Paint paramPaint, Drawable paramDrawable, Rect paramRect2)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(paramRect1);
      paramDrawable.draw(paramCanvas);
    }
    paramPaint.getTextBounds(paramString, 0, paramString.length(), paramRect2);
    float f1 = paramPaint.measureText(paramString);
    float f2 = paramRect2.height();
    paramCanvas.drawText(paramString, paramRect1.centerX() - f1 / 2.0F, paramRect1.centerY() + f2 / 2.0F, paramPaint);
    return paramCanvas;
  }

  public static Drawable a(Resources paramResources, int paramInt)
  {
    try
    {
      Drawable localDrawable = paramResources.getDrawable(paramInt);
      return localDrawable;
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable, "Error has occurred while decoding image resource.");
    }
    return null;
  }

  public static Uri a(int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_4444);
    new Canvas(localBitmap).drawColor(paramInt);
    Uri localUri = dv.h.a(ViberApplication.getApplication(), String.valueOf(paramInt), true);
    if (localUri != null)
      return a(localBitmap, new File(localUri.getPath()));
    return null;
  }

  public static Uri a(long paramLong)
  {
    return Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Long.toString(paramLong));
  }

  public static Uri a(Context paramContext, Uri paramUri1, Uri paramUri2, dv paramdv, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    return a(paramContext, paramUri1, paramUri2, paramdv, paramInt1, paramInt2, paramBoolean, 80);
  }

  public static Uri a(Context paramContext, Uri paramUri1, Uri paramUri2, dv paramdv, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    throws IOException
  {
    Bitmap localBitmap = a(paramContext, paramUri1, paramdv, paramInt1, paramInt2, paramBoolean, false);
    if (localBitmap != null)
    {
      a(localBitmap, new File(paramUri2.getPath()), paramInt3);
      return paramUri2;
    }
    return null;
  }

  public static Uri a(Context paramContext, Uri paramUri, dv paramdv, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    throws IOException
  {
    if (!a(paramContext, paramUri, paramInt1, paramInt2, paramInt3))
    {
      com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "ImageUtils resizeImageAndStore copy");
      Uri localUri2 = paramdv.a(paramContext, paramUri.toString(), true);
      if (localUri2 != null)
      {
        ContentResolver localContentResolver = paramContext.getContentResolver();
        InputStream localInputStream = localContentResolver.openInputStream(paramUri);
        OutputStream localOutputStream2 = localContentResolver.openOutputStream(localUri2);
        bj.a(localInputStream, localOutputStream2);
        bj.a(new Closeable[] { localInputStream, localOutputStream2 });
        com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "ImageUtils resizeImageAndStore copy");
      }
      return localUri2;
    }
    com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "ImageUtils resizeImageAndStore cropImage");
    Bitmap localBitmap = a(paramContext, paramUri, paramdv, paramInt1, paramInt2, paramBoolean, false);
    com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "ImageUtils resizeImageAndStore cropImage");
    if (localBitmap != null)
    {
      com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "ImageUtils resizeImageAndStore compressImage");
      Uri localUri1 = paramdv.a(paramContext, paramUri.toString(), true);
      if (localUri1 != null)
      {
        OutputStream localOutputStream1 = paramContext.getContentResolver().openOutputStream(localUri1);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localOutputStream1.write(a(localBitmap, paramInt3, localByteArrayOutputStream));
        localOutputStream1.flush();
        bj.a(localOutputStream1);
        bj.a(localByteArrayOutputStream);
        c(localBitmap);
      }
      com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "ImageUtils resizeImageAndStore compressImage");
      return localUri1;
    }
    return null;
  }

  // ERROR //
  public static Uri a(Context paramContext, Uri paramUri, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 284	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: invokevirtual 290	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   8: astore 9
    //   10: aload 9
    //   12: astore 5
    //   14: aload 5
    //   16: ifnonnull +21 -> 37
    //   19: iconst_2
    //   20: anewarray 833	java/io/Closeable
    //   23: dup
    //   24: iconst_0
    //   25: aload 5
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aconst_null
    //   31: aastore
    //   32: invokestatic 836	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   35: aconst_null
    //   36: areturn
    //   37: new 858	java/io/FileOutputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 861	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore 4
    //   47: aload 5
    //   49: aload 4
    //   51: invokestatic 831	com/viber/voip/util/bj:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   54: aload_2
    //   55: invokestatic 865	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   58: astore 10
    //   60: iconst_2
    //   61: anewarray 833	java/io/Closeable
    //   64: dup
    //   65: iconst_0
    //   66: aload 5
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: aload 4
    //   73: aastore
    //   74: invokestatic 836	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   77: aload 10
    //   79: areturn
    //   80: astore 8
    //   82: aconst_null
    //   83: astore 4
    //   85: aconst_null
    //   86: astore 5
    //   88: getstatic 20	com/viber/voip/util/e/j:b	Lcom/viber/dexshared/Logger;
    //   91: aload 8
    //   93: ldc_w 867
    //   96: invokeinterface 586 3 0
    //   101: iconst_2
    //   102: anewarray 833	java/io/Closeable
    //   105: dup
    //   106: iconst_0
    //   107: aload 5
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload 4
    //   114: aastore
    //   115: invokestatic 836	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   118: aconst_null
    //   119: areturn
    //   120: astore 7
    //   122: aconst_null
    //   123: astore 4
    //   125: aconst_null
    //   126: astore 5
    //   128: getstatic 20	com/viber/voip/util/e/j:b	Lcom/viber/dexshared/Logger;
    //   131: aload 7
    //   133: ldc_w 869
    //   136: invokeinterface 586 3 0
    //   141: iconst_2
    //   142: anewarray 833	java/io/Closeable
    //   145: dup
    //   146: iconst_0
    //   147: aload 5
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload 4
    //   154: aastore
    //   155: invokestatic 836	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_3
    //   161: aconst_null
    //   162: astore 4
    //   164: aconst_null
    //   165: astore 5
    //   167: aload_3
    //   168: astore 6
    //   170: iconst_2
    //   171: anewarray 833	java/io/Closeable
    //   174: dup
    //   175: iconst_0
    //   176: aload 5
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload 4
    //   183: aastore
    //   184: invokestatic 836	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   187: aload 6
    //   189: athrow
    //   190: astore 11
    //   192: aload 11
    //   194: astore 6
    //   196: aconst_null
    //   197: astore 4
    //   199: goto -29 -> 170
    //   202: astore 6
    //   204: goto -34 -> 170
    //   207: astore 7
    //   209: aconst_null
    //   210: astore 4
    //   212: goto -84 -> 128
    //   215: astore 7
    //   217: goto -89 -> 128
    //   220: astore 8
    //   222: aconst_null
    //   223: astore 4
    //   225: goto -137 -> 88
    //   228: astore 8
    //   230: goto -142 -> 88
    //
    // Exception table:
    //   from	to	target	type
    //   0	10	80	java/io/IOException
    //   0	10	120	java/lang/SecurityException
    //   0	10	160	finally
    //   37	47	190	finally
    //   47	60	202	finally
    //   88	101	202	finally
    //   128	141	202	finally
    //   37	47	207	java/lang/SecurityException
    //   47	60	215	java/lang/SecurityException
    //   37	47	220	java/io/IOException
    //   47	60	228	java/io/IOException
  }

  // ERROR //
  public static Uri a(Context paramContext, Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual 284	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_1
    //   13: invokevirtual 290	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   16: astore 12
    //   18: aload 12
    //   20: astore 11
    //   22: aload 11
    //   24: ifnonnull +21 -> 45
    //   27: iconst_2
    //   28: anewarray 833	java/io/Closeable
    //   31: dup
    //   32: iconst_0
    //   33: aload 11
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aconst_null
    //   39: aastore
    //   40: invokestatic 836	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   43: aconst_null
    //   44: areturn
    //   45: aload_2
    //   46: ifnull +439 -> 485
    //   49: aload_2
    //   50: ldc_w 874
    //   53: invokevirtual 877	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +145 -> 201
    //   59: ldc_w 879
    //   62: aload_1
    //   63: invokestatic 882	com/viber/voip/util/at:f	(Landroid/net/Uri;)[Ljava/lang/String;
    //   66: iconst_0
    //   67: aaload
    //   68: invokevirtual 886	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: ifeq +87 -> 158
    //   74: getstatic 889	com/viber/voip/util/dv:v	Lcom/viber/voip/util/dv;
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 824	android/net/Uri:toString	()Ljava/lang/String;
    //   82: invokevirtual 892	com/viber/voip/util/dv:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   85: astore 30
    //   87: iconst_0
    //   88: istore 29
    //   90: goto +404 -> 494
    //   93: aload 14
    //   95: ifnull +219 -> 314
    //   98: new 858	java/io/FileOutputStream
    //   101: dup
    //   102: aload 14
    //   104: invokespecial 861	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   107: astore 5
    //   109: iload 13
    //   111: ifeq +182 -> 293
    //   114: aload 11
    //   116: aload 5
    //   118: ldc2_w 893
    //   121: invokestatic 897	com/viber/voip/util/bj:a	(Ljava/io/InputStream;Ljava/io/OutputStream;J)Z
    //   124: ifeq +132 -> 256
    //   127: aload 14
    //   129: invokestatic 865	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   132: astore 23
    //   134: aload 23
    //   136: astore 20
    //   138: iconst_2
    //   139: anewarray 833	java/io/Closeable
    //   142: dup
    //   143: iconst_0
    //   144: aload 11
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload 5
    //   151: aastore
    //   152: invokestatic 836	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   155: aload 20
    //   157: areturn
    //   158: aload_1
    //   159: invokestatic 899	com/viber/voip/util/e/j:d	(Landroid/net/Uri;)Z
    //   162: istore 29
    //   164: iload 29
    //   166: ifeq +19 -> 185
    //   169: getstatic 902	com/viber/voip/util/dv:u	Lcom/viber/voip/util/dv;
    //   172: aload_0
    //   173: aload_1
    //   174: invokevirtual 824	android/net/Uri:toString	()Ljava/lang/String;
    //   177: invokevirtual 892	com/viber/voip/util/dv:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   180: astore 30
    //   182: goto +312 -> 494
    //   185: getstatic 905	com/viber/voip/util/dv:j	Lcom/viber/voip/util/dv;
    //   188: aload_0
    //   189: aload_1
    //   190: invokevirtual 824	android/net/Uri:toString	()Ljava/lang/String;
    //   193: invokevirtual 892	com/viber/voip/util/dv:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   196: astore 30
    //   198: goto +296 -> 494
    //   201: aload_2
    //   202: ldc_w 907
    //   205: invokevirtual 877	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   208: ifeq +22 -> 230
    //   211: getstatic 910	com/viber/voip/util/dv:k	Lcom/viber/voip/util/dv;
    //   214: aload_0
    //   215: aload_1
    //   216: invokevirtual 824	android/net/Uri:toString	()Ljava/lang/String;
    //   219: invokevirtual 892	com/viber/voip/util/dv:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   222: astore 14
    //   224: iconst_0
    //   225: istore 13
    //   227: goto -134 -> 93
    //   230: aload_2
    //   231: ldc 223
    //   233: invokevirtual 877	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   236: ifeq +249 -> 485
    //   239: aload_0
    //   240: aload_1
    //   241: invokestatic 912	com/viber/voip/util/e/j:d	(Landroid/content/Context;Landroid/net/Uri;)Ljava/io/File;
    //   244: astore 28
    //   246: aload 28
    //   248: astore 14
    //   250: iconst_0
    //   251: istore 13
    //   253: goto -160 -> 93
    //   256: aload 14
    //   258: invokevirtual 915	java/io/File:delete	()Z
    //   261: pop
    //   262: aconst_null
    //   263: astore 20
    //   265: goto -127 -> 138
    //   268: astore 21
    //   270: aload 11
    //   272: astore 6
    //   274: iconst_2
    //   275: anewarray 833	java/io/Closeable
    //   278: dup
    //   279: iconst_0
    //   280: aload 6
    //   282: aastore
    //   283: dup
    //   284: iconst_1
    //   285: aload 5
    //   287: aastore
    //   288: invokestatic 836	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   291: aconst_null
    //   292: areturn
    //   293: aload 11
    //   295: aload 5
    //   297: invokestatic 831	com/viber/voip/util/bj:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   300: aload 14
    //   302: invokestatic 865	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   305: astore 19
    //   307: aload 19
    //   309: astore 20
    //   311: goto -173 -> 138
    //   314: aconst_null
    //   315: astore 5
    //   317: aconst_null
    //   318: astore 20
    //   320: goto -182 -> 138
    //   323: astore 10
    //   325: aconst_null
    //   326: astore 11
    //   328: iconst_2
    //   329: anewarray 833	java/io/Closeable
    //   332: dup
    //   333: iconst_0
    //   334: aload 11
    //   336: aastore
    //   337: dup
    //   338: iconst_1
    //   339: aload_3
    //   340: aastore
    //   341: invokestatic 836	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   344: aload 10
    //   346: athrow
    //   347: astore 10
    //   349: aconst_null
    //   350: astore_3
    //   351: goto -23 -> 328
    //   354: astore 18
    //   356: aload 5
    //   358: astore_3
    //   359: aload 18
    //   361: astore 10
    //   363: goto -35 -> 328
    //   366: astore 9
    //   368: aconst_null
    //   369: astore 5
    //   371: aconst_null
    //   372: astore 6
    //   374: goto -100 -> 274
    //   377: astore 27
    //   379: aload 11
    //   381: astore 6
    //   383: aconst_null
    //   384: astore 5
    //   386: goto -112 -> 274
    //   389: astore 17
    //   391: aload 11
    //   393: astore 6
    //   395: goto -121 -> 274
    //   398: astore 8
    //   400: aconst_null
    //   401: astore 5
    //   403: aconst_null
    //   404: astore 6
    //   406: goto -132 -> 274
    //   409: astore 26
    //   411: aload 11
    //   413: astore 6
    //   415: aconst_null
    //   416: astore 5
    //   418: goto -144 -> 274
    //   421: astore 16
    //   423: aload 11
    //   425: astore 6
    //   427: goto -153 -> 274
    //   430: astore 7
    //   432: aconst_null
    //   433: astore 5
    //   435: aconst_null
    //   436: astore 6
    //   438: goto -164 -> 274
    //   441: astore 25
    //   443: aload 11
    //   445: astore 6
    //   447: aconst_null
    //   448: astore 5
    //   450: goto -176 -> 274
    //   453: astore 4
    //   455: aconst_null
    //   456: astore 5
    //   458: aconst_null
    //   459: astore 6
    //   461: goto -187 -> 274
    //   464: astore 24
    //   466: aload 11
    //   468: astore 6
    //   470: aconst_null
    //   471: astore 5
    //   473: goto -199 -> 274
    //   476: astore 15
    //   478: aload 11
    //   480: astore 6
    //   482: goto -208 -> 274
    //   485: iconst_0
    //   486: istore 13
    //   488: aconst_null
    //   489: astore 14
    //   491: goto -398 -> 93
    //   494: aload 30
    //   496: astore 14
    //   498: iload 29
    //   500: istore 13
    //   502: goto -409 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   114	134	268	java/io/IOException
    //   256	262	268	java/io/IOException
    //   293	307	268	java/io/IOException
    //   8	18	323	finally
    //   49	87	347	finally
    //   98	109	347	finally
    //   158	164	347	finally
    //   169	182	347	finally
    //   185	198	347	finally
    //   201	224	347	finally
    //   230	246	347	finally
    //   114	134	354	finally
    //   256	262	354	finally
    //   293	307	354	finally
    //   8	18	366	java/lang/NullPointerException
    //   49	87	377	java/lang/NullPointerException
    //   98	109	377	java/lang/NullPointerException
    //   158	164	377	java/lang/NullPointerException
    //   169	182	377	java/lang/NullPointerException
    //   185	198	377	java/lang/NullPointerException
    //   201	224	377	java/lang/NullPointerException
    //   230	246	377	java/lang/NullPointerException
    //   114	134	389	java/lang/NullPointerException
    //   256	262	389	java/lang/NullPointerException
    //   293	307	389	java/lang/NullPointerException
    //   8	18	398	java/lang/IllegalStateException
    //   49	87	409	java/lang/IllegalStateException
    //   98	109	409	java/lang/IllegalStateException
    //   158	164	409	java/lang/IllegalStateException
    //   169	182	409	java/lang/IllegalStateException
    //   185	198	409	java/lang/IllegalStateException
    //   201	224	409	java/lang/IllegalStateException
    //   230	246	409	java/lang/IllegalStateException
    //   114	134	421	java/lang/IllegalStateException
    //   256	262	421	java/lang/IllegalStateException
    //   293	307	421	java/lang/IllegalStateException
    //   8	18	430	java/io/IOException
    //   49	87	441	java/io/IOException
    //   98	109	441	java/io/IOException
    //   158	164	441	java/io/IOException
    //   169	182	441	java/io/IOException
    //   185	198	441	java/io/IOException
    //   201	224	441	java/io/IOException
    //   230	246	441	java/io/IOException
    //   8	18	453	java/lang/SecurityException
    //   49	87	464	java/lang/SecurityException
    //   98	109	464	java/lang/SecurityException
    //   158	164	464	java/lang/SecurityException
    //   169	182	464	java/lang/SecurityException
    //   185	198	464	java/lang/SecurityException
    //   201	224	464	java/lang/SecurityException
    //   230	246	464	java/lang/SecurityException
    //   114	134	476	java/lang/SecurityException
    //   256	262	476	java/lang/SecurityException
    //   293	307	476	java/lang/SecurityException
  }

  public static Uri a(Context paramContext, String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      Uri localUri = a(paramContext, Uri.parse(paramString), dv.h, 1280, 1280, true, 256000);
      return localUri;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static Uri a(Bitmap paramBitmap, dv paramdv)
  {
    return a(paramBitmap, paramdv.a(ViberApplication.getApplication(), null));
  }

  public static Uri a(Bitmap paramBitmap, File paramFile)
  {
    return a(paramBitmap, paramFile, 80);
  }

  public static Uri a(Bitmap paramBitmap, File paramFile, int paramInt)
  {
    return a(paramBitmap, paramFile, paramInt, true);
  }

  // ERROR //
  public static Uri a(Bitmap paramBitmap, File paramFile, int paramInt, Bitmap.CompressFormat paramCompressFormat, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnull +10 -> 14
    //   7: aconst_null
    //   8: astore 5
    //   10: aload_0
    //   11: ifnonnull +6 -> 17
    //   14: aload 5
    //   16: areturn
    //   17: aload_1
    //   18: invokevirtual 930	java/io/File:exists	()Z
    //   21: ifne +13 -> 34
    //   24: aload_1
    //   25: invokestatic 933	com/viber/voip/util/at:d	(Ljava/io/File;)Z
    //   28: pop
    //   29: aload_1
    //   30: invokevirtual 936	java/io/File:createNewFile	()Z
    //   33: pop
    //   34: new 858	java/io/FileOutputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 861	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   42: astore 7
    //   44: aload_0
    //   45: aload_3
    //   46: iload_2
    //   47: aload 7
    //   49: invokestatic 939	com/viber/voip/util/dq:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   52: pop
    //   53: aload_1
    //   54: invokestatic 865	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   57: astore 11
    //   59: aload 11
    //   61: astore 5
    //   63: aload 7
    //   65: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   68: iload 4
    //   70: ifeq -56 -> 14
    //   73: aload_0
    //   74: invokestatic 555	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   77: aload 5
    //   79: areturn
    //   80: astore 9
    //   82: aconst_null
    //   83: astore 7
    //   85: getstatic 20	com/viber/voip/util/e/j:b	Lcom/viber/dexshared/Logger;
    //   88: aload 9
    //   90: ldc_w 941
    //   93: invokeinterface 586 3 0
    //   98: aload 7
    //   100: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   103: aconst_null
    //   104: astore 5
    //   106: iload 4
    //   108: ifeq -94 -> 14
    //   111: aload_0
    //   112: invokestatic 555	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   115: aconst_null
    //   116: areturn
    //   117: astore 6
    //   119: aconst_null
    //   120: astore 7
    //   122: aload 6
    //   124: astore 8
    //   126: aload 7
    //   128: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   131: iload 4
    //   133: ifeq +7 -> 140
    //   136: aload_0
    //   137: invokestatic 555	com/viber/voip/util/e/j:c	(Landroid/graphics/Bitmap;)V
    //   140: aload 8
    //   142: athrow
    //   143: astore 8
    //   145: goto -19 -> 126
    //   148: astore 9
    //   150: goto -65 -> 85
    //
    // Exception table:
    //   from	to	target	type
    //   17	34	80	java/io/IOException
    //   34	44	80	java/io/IOException
    //   17	34	117	finally
    //   34	44	117	finally
    //   44	59	143	finally
    //   85	98	143	finally
    //   44	59	148	java/io/IOException
  }

  public static Uri a(Bitmap paramBitmap, File paramFile, int paramInt, boolean paramBoolean)
  {
    return a(paramBitmap, paramFile, paramInt, Bitmap.CompressFormat.JPEG, paramBoolean);
  }

  public static Uri a(Uri paramUri, String paramString)
    throws IllegalArgumentException
  {
    if (!dk.b(paramUri))
      return null;
    return a(new File(paramUri.getPath()), paramString);
  }

  public static Uri a(File paramFile, String paramString)
  {
    File localFile = dv.d(paramString).a(ViberApplication.getApplication(), null);
    if (localFile == null)
      return null;
    try
    {
      bj.a(paramFile, localFile);
      Uri localUri = Uri.parse(localFile.toURI().toString());
      return localUri;
    }
    catch (IOException localIOException)
    {
      b.a(localIOException, "Unable to copy source image to temp file " + paramFile + " to " + localFile);
    }
    return null;
  }

  @TargetApi(17)
  public static DisplayMetrics a(Display paramDisplay)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramDisplay.getRealMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }

  private static void a()
  {
    int i = a(640.0F);
    if (i <= 1280);
    while (true)
    {
      a = i;
      return;
      i = 1280;
    }
  }

  public static void a(Drawable paramDrawable)
  {
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    if (((paramDrawable instanceof InsetDrawable)) && (!a.h()))
    {
      Rect localRect = new Rect();
      paramDrawable.getPadding(localRect);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth() + localRect.left + localRect.right, paramDrawable.getIntrinsicHeight() + localRect.top + localRect.bottom);
    }
  }

  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 1)
      if (paramInt1 >= paramInt2);
    do
    {
      do
      {
        return true;
        return false;
        if (paramInt3 != 2)
          break;
      }
      while (paramInt1 > paramInt2);
      return false;
      if (paramInt3 == 3)
        return false;
    }
    while (paramInt3 == 4);
    return false;
  }

  private static boolean a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, int paramInt3)
  {
    File localFile;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      BitmapFactory.Options localOptions = a(paramContext, paramUri);
      if ((localOptions.outWidth <= paramInt1) && (localOptions.outHeight <= paramInt2))
      {
        localFile = at.a(paramContext, paramUri);
        if (localFile != null)
          break label47;
      }
    }
    label47: 
    while (localFile.length() > paramInt3)
      return true;
    return false;
  }

  public static boolean a(Uri paramUri)
  {
    return (paramUri != null) && ((paramUri.toString().contains("provider/picasa")) || (f(paramUri)) || (g(paramUri)) || (paramUri.toString().startsWith("content://com.android.providers.media.documents/document/")));
  }

  public static boolean a(String paramString, Uri paramUri)
  {
    return ((paramString.contains("image")) || (paramString.contains("file"))) && (d(paramUri));
  }

  public static byte[] a(Bitmap paramBitmap, int paramInt, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    int i = 90;
    paramByteArrayOutputStream.reset();
    dq.a(paramBitmap, Bitmap.CompressFormat.JPEG, i, paramByteArrayOutputStream);
    if ((paramInt != -1) && (paramByteArrayOutputStream.size() > paramInt))
      while ((paramByteArrayOutputStream.size() >= paramInt) && (i > 0))
      {
        i -= 7;
        paramByteArrayOutputStream.reset();
        dq.a(paramBitmap, Bitmap.CompressFormat.JPEG, i, paramByteArrayOutputStream);
      }
    return paramByteArrayOutputStream.toByteArray();
  }

  public static byte[] a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    return dq.a(paramBitmap, paramCompressFormat, 100);
  }

  public static float[] a(float[] paramArrayOfFloat, String paramString, Paint paramPaint, Rect paramRect)
  {
    paramPaint.getTextBounds(paramString, 0, paramString.length(), paramRect);
    paramArrayOfFloat[0] = paramPaint.measureText(paramString);
    paramArrayOfFloat[1] = paramRect.height();
    return paramArrayOfFloat;
  }

  public static int[] a(Context paramContext)
  {
    int i = d.ax.d.d();
    int j = d.ax.e.d();
    if ((i == 0) || (j == 0))
    {
      int[] arrayOfInt = b(paramContext);
      i = arrayOfInt[0];
      j = arrayOfInt[1];
      if (i == 0)
        i = 720;
      if (j == 0)
        j = 1280;
      d.ax.d.a(i);
      d.ax.e.a(j);
    }
    return new int[] { i, j };
  }

  public static int[] a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
      return null;
    int[] arrayOfInt = new int[2];
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int j;
    int i;
    if (a.b())
    {
      DisplayMetrics localDisplayMetrics2 = a(localDisplay);
      j = localDisplayMetrics2.heightPixels;
      i = localDisplayMetrics2.widthPixels;
    }
    while (true)
    {
      if ((j == 0) || (i == 0));
      try
      {
        Method localMethod1 = Display.class.getMethod("getRawHeight", new Class[0]);
        Method localMethod2 = Display.class.getMethod("getRawWidth", new Class[0]);
        j = ((Integer)localMethod1.invoke(localDisplay, new Object[0])).intValue();
        int k = ((Integer)localMethod2.invoke(localDisplay, new Object[0])).intValue();
        i = k;
        if ((j == 0) || (i == 0))
        {
          DisplayMetrics localDisplayMetrics1 = new DisplayMetrics();
          localDisplay.getMetrics(localDisplayMetrics1);
          j = localDisplayMetrics1.heightPixels;
          i = localDisplayMetrics1.widthPixels;
        }
        if ((paramBoolean) && (j < i))
        {
          arrayOfInt[0] = j;
          arrayOfInt[1] = i;
          return arrayOfInt;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          i = 0;
          j = 0;
          continue;
          arrayOfInt[0] = i;
          arrayOfInt[1] = j;
        }
      }
      i = 0;
      j = 0;
    }
  }

  private static int b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
      paramInt2 = Math.min(paramInt1, paramInt2);
    while (paramInt1 == 0)
      return paramInt2;
    return paramInt1;
  }

  public static Bitmap b(Context paramContext, Uri paramUri, int paramInt)
  {
    if ((paramUri == null) && (paramInt <= 0))
      return null;
    Bitmap localBitmap = e.a(paramContext, paramUri, false);
    if (localBitmap != null);
    while (true)
    {
      return localBitmap;
      if (paramInt > 0)
        localBitmap = dq.a(paramContext.getResources(), paramInt);
      else
        localBitmap = null;
    }
  }

  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0));
    int i;
    int j;
    Matrix localMatrix;
    int k;
    int m;
    do
    {
      do
      {
        return paramBitmap;
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
      }
      while ((paramInt1 == i) && (paramInt2 == j));
      localMatrix = new Matrix();
      float f = Math.max(paramInt1 / i, paramInt2 / j);
      localMatrix.setScale(f, f);
      k = Math.round(paramInt1 / f);
      m = Math.round(paramInt2 / f);
    }
    while ((k == 0) || (m == 0));
    int n = (int)(0.5F * i - k / 2);
    int i1 = (int)(0.5F * j - m / 2);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, Math.max(Math.min(n, i - k), 0), Math.max(Math.min(i1, j - m), 0), k, m, localMatrix, true);
    if (paramBitmap != localBitmap)
      c(paramBitmap);
    return localBitmap;
  }

  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    float f = Math.max(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight());
    int i = Math.min(Math.round(paramInt1 / f), paramBitmap.getWidth());
    int j = Math.min(Math.round(paramInt2 / f), paramBitmap.getHeight());
    int k = (int)((paramBitmap.getWidth() - i) / 2.0F);
    int m = (int)((paramBitmap.getHeight() - j) / 2.0F);
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(f, f);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, k, m, i, j, localMatrix, true);
    if ((paramBitmap != localBitmap) && (paramBoolean))
      paramBitmap.recycle();
    return localBitmap;
  }

  public static Bitmap b(Drawable paramDrawable)
  {
    boolean bool = paramDrawable instanceof BitmapDrawable;
    Bitmap localBitmap = null;
    if (bool)
      localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
    return localBitmap;
  }

  public static Uri b(long paramLong)
  {
    return Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, Long.toString(paramLong));
  }

  // ERROR //
  public static b b(String paramString)
  {
    // Byte code:
    //   0: new 242	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 243	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_1
    //   8: lconst_0
    //   9: lstore_2
    //   10: invokestatic 590	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   13: invokevirtual 1085	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   16: aload_0
    //   17: invokevirtual 1089	com/viber/voip/util/ap:c	(Ljava/lang/String;)Z
    //   20: ifne +14 -> 34
    //   23: new 1091	com/viber/voip/util/e/j$b
    //   26: dup
    //   27: aload_1
    //   28: lload_2
    //   29: aconst_null
    //   30: invokespecial 1094	com/viber/voip/util/e/j$b:<init>	(Landroid/graphics/BitmapFactory$Options;JLjava/lang/String;)V
    //   33: areturn
    //   34: invokestatic 1098	com/viber/voip/ViberEnv:getOkHttpClientFactory	()Lcom/viber/voip/util/http/OkHttpClientFactory;
    //   37: invokeinterface 1104 1 0
    //   42: getstatic 1107	com/viber/voip/util/aw:a	I
    //   45: i2l
    //   46: getstatic 1113	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   49: invokevirtual 1119	okhttp3/OkHttpClient$Builder:connectTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   52: getstatic 1107	com/viber/voip/util/aw:a	I
    //   55: i2l
    //   56: getstatic 1113	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   59: invokevirtual 1122	okhttp3/OkHttpClient$Builder:writeTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   62: astore 9
    //   64: new 1124	okhttp3/Request$Builder
    //   67: dup
    //   68: invokespecial 1125	okhttp3/Request$Builder:<init>	()V
    //   71: aload_0
    //   72: invokevirtual 1129	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   75: astore 10
    //   77: aload 9
    //   79: invokevirtual 1132	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   82: aload 10
    //   84: invokevirtual 1135	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   87: invokevirtual 1141	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   90: invokeinterface 1147 1 0
    //   95: astore 11
    //   97: aload 11
    //   99: invokevirtual 1153	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   102: invokevirtual 1159	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   105: astore 12
    //   107: aload 12
    //   109: astore 5
    //   111: aload 5
    //   113: aload_1
    //   114: invokestatic 710	com/viber/voip/util/e/j:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/BitmapFactory$Options;
    //   117: pop
    //   118: aload 11
    //   120: invokevirtual 1153	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   123: invokevirtual 1162	okhttp3/ResponseBody:contentLength	()J
    //   126: lstore_2
    //   127: aload 11
    //   129: invokevirtual 1153	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   132: invokevirtual 1166	okhttp3/ResponseBody:contentType	()Lokhttp3/MediaType;
    //   135: astore 15
    //   137: aconst_null
    //   138: astore 8
    //   140: aload 15
    //   142: ifnull +14 -> 156
    //   145: aload 15
    //   147: invokevirtual 1171	okhttp3/MediaType:subtype	()Ljava/lang/String;
    //   150: astore 16
    //   152: aload 16
    //   154: astore 8
    //   156: aload 5
    //   158: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   161: new 1091	com/viber/voip/util/e/j$b
    //   164: dup
    //   165: aload_1
    //   166: lload_2
    //   167: aload 8
    //   169: invokespecial 1094	com/viber/voip/util/e/j$b:<init>	(Landroid/graphics/BitmapFactory$Options;JLjava/lang/String;)V
    //   172: areturn
    //   173: astore 7
    //   175: aconst_null
    //   176: astore 5
    //   178: invokestatic 590	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   181: invokevirtual 1085	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   184: aload_0
    //   185: invokevirtual 1173	com/viber/voip/util/ap:a	(Ljava/lang/String;)V
    //   188: aload 5
    //   190: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   193: aconst_null
    //   194: astore 8
    //   196: goto -35 -> 161
    //   199: astore 4
    //   201: aconst_null
    //   202: astore 5
    //   204: aload 4
    //   206: astore 6
    //   208: aload 5
    //   210: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   213: aload 6
    //   215: athrow
    //   216: astore 6
    //   218: goto -10 -> 208
    //   221: astore 13
    //   223: goto -45 -> 178
    //
    // Exception table:
    //   from	to	target	type
    //   34	107	173	java/lang/Exception
    //   34	107	199	finally
    //   111	137	216	finally
    //   145	152	216	finally
    //   178	188	216	finally
    //   111	137	221	java/lang/Exception
    //   145	152	221	java/lang/Exception
  }

  public static boolean b(Uri paramUri)
  {
    if (paramUri != null)
    {
      String str = paramUri.toString();
      if ((str.contains("googleusercontent.com")) && ((str.startsWith("https://")) || (str.startsWith("http://"))))
        return true;
    }
    return false;
  }

  // ERROR //
  public static byte[] b(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: new 842	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 843	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 284	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore_3
    //   13: aload_3
    //   14: aload_1
    //   15: invokevirtual 290	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   18: astore 5
    //   20: aload 5
    //   22: ifnonnull +36 -> 58
    //   25: aload 5
    //   27: ifnull +12 -> 39
    //   30: iconst_0
    //   31: ifeq +20 -> 51
    //   34: aload 5
    //   36: invokevirtual 561	java/io/InputStream:close	()V
    //   39: aconst_null
    //   40: areturn
    //   41: astore 13
    //   43: aconst_null
    //   44: aload 13
    //   46: invokevirtual 1184	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload 5
    //   53: invokevirtual 561	java/io/InputStream:close	()V
    //   56: aconst_null
    //   57: areturn
    //   58: aload 5
    //   60: aload_2
    //   61: invokestatic 831	com/viber/voip/util/bj:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   64: aload_2
    //   65: invokevirtual 1041	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   68: astore 11
    //   70: aload 5
    //   72: ifnull +12 -> 84
    //   75: iconst_0
    //   76: ifeq +22 -> 98
    //   79: aload 5
    //   81: invokevirtual 561	java/io/InputStream:close	()V
    //   84: aload 11
    //   86: areturn
    //   87: astore 12
    //   89: aconst_null
    //   90: aload 12
    //   92: invokevirtual 1184	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   95: goto -11 -> 84
    //   98: aload 5
    //   100: invokevirtual 561	java/io/InputStream:close	()V
    //   103: goto -19 -> 84
    //   106: astore 9
    //   108: aload 9
    //   110: athrow
    //   111: astore 10
    //   113: aload 9
    //   115: astore 7
    //   117: aload 10
    //   119: astore 6
    //   121: aload 5
    //   123: ifnull +13 -> 136
    //   126: aload 7
    //   128: ifnull +23 -> 151
    //   131: aload 5
    //   133: invokevirtual 561	java/io/InputStream:close	()V
    //   136: aload 6
    //   138: athrow
    //   139: astore 8
    //   141: aload 7
    //   143: aload 8
    //   145: invokevirtual 1184	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   148: goto -12 -> 136
    //   151: aload 5
    //   153: invokevirtual 561	java/io/InputStream:close	()V
    //   156: goto -20 -> 136
    //   159: astore 6
    //   161: aconst_null
    //   162: astore 7
    //   164: goto -43 -> 121
    //   167: astore 4
    //   169: aconst_null
    //   170: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   34	39	41	java/lang/Throwable
    //   79	84	87	java/lang/Throwable
    //   58	70	106	java/lang/Throwable
    //   108	111	111	finally
    //   131	136	139	java/lang/Throwable
    //   58	70	159	finally
    //   13	20	167	java/io/IOException
    //   34	39	167	java/io/IOException
    //   43	49	167	java/io/IOException
    //   51	56	167	java/io/IOException
    //   79	84	167	java/io/IOException
    //   89	95	167	java/io/IOException
    //   98	103	167	java/io/IOException
    //   131	136	167	java/io/IOException
    //   136	139	167	java/io/IOException
    //   141	148	167	java/io/IOException
    //   151	156	167	java/io/IOException
  }

  public static byte[] b(Bitmap paramBitmap)
  {
    return a(paramBitmap, Bitmap.CompressFormat.JPEG);
  }

  public static int[] b(Context paramContext)
  {
    return a(paramContext, true);
  }

  public static Bitmap c(Context paramContext, Uri paramUri)
  {
    if (paramUri == null)
      return null;
    return e.a(paramContext, paramUri, false);
  }

  public static Bitmap c(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null)
      return null;
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = Math.max(paramInt1 / i, paramInt2 / j);
    float f2 = f1 * i;
    float f3 = f1 * j;
    float f4 = (paramInt1 - f2) / 2.0F;
    float f5 = (paramInt2 - f3) / 2.0F;
    RectF localRectF = new RectF(f4, f5, f2 + f4, f3 + f5);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramBitmap.getConfig());
    new Canvas(localBitmap).drawBitmap(paramBitmap, null, localRectF, null);
    return localBitmap;
  }

  private static BitmapFactory.Options c(Context paramContext, Uri paramUri, int paramInt)
  {
    BitmapFactory.Options localOptions = a(paramContext, paramUri);
    if (localOptions == null)
      return null;
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if (paramInt > 0);
    while (true)
    {
      if ((i / 2 < paramInt) && (j / 2 < paramInt))
      {
        File localFile = at.a(paramContext, paramUri);
        String str = null;
        if (localFile != null)
          str = localFile.getPath();
        int k = a(str);
        if ((k == 90) || (k == 270))
        {
          int m = i;
          i = j;
          j = m;
        }
        localOptions.outHeight = j;
        localOptions.outWidth = i;
        return localOptions;
      }
      j /= 2;
      i /= 2;
    }
  }

  // ERROR //
  public static Uri c(Uri paramUri)
  {
    // Byte code:
    //   0: invokestatic 1098	com/viber/voip/ViberEnv:getOkHttpClientFactory	()Lcom/viber/voip/util/http/OkHttpClientFactory;
    //   3: invokeinterface 1104 1 0
    //   8: astore 5
    //   10: new 1124	okhttp3/Request$Builder
    //   13: dup
    //   14: invokespecial 1125	okhttp3/Request$Builder:<init>	()V
    //   17: aload_0
    //   18: invokevirtual 824	android/net/Uri:toString	()Ljava/lang/String;
    //   21: invokevirtual 1129	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   24: astore 6
    //   26: aload 5
    //   28: invokevirtual 1132	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   31: aload 6
    //   33: invokevirtual 1135	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   36: invokevirtual 1141	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   39: invokeinterface 1147 1 0
    //   44: invokevirtual 1153	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   47: invokevirtual 1159	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   50: astore 7
    //   52: aload 7
    //   54: astore_2
    //   55: aload_2
    //   56: invokestatic 1206	com/viber/voip/util/dq:a	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   59: astore 8
    //   61: aload_0
    //   62: invokevirtual 824	android/net/Uri:toString	()Ljava/lang/String;
    //   65: aload_2
    //   66: invokevirtual 1209	java/io/InputStream:available	()I
    //   69: i2l
    //   70: invokestatic 1214	com/viber/voip/util/de:a	(Ljava/lang/String;J)V
    //   73: aload 8
    //   75: ifnonnull +9 -> 84
    //   78: aload_2
    //   79: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   82: aconst_null
    //   83: areturn
    //   84: aload 8
    //   86: getstatic 1216	com/viber/voip/util/dv:a	Lcom/viber/voip/util/dv;
    //   89: invokestatic 1218	com/viber/voip/util/e/j:a	(Landroid/graphics/Bitmap;Lcom/viber/voip/util/dv;)Landroid/net/Uri;
    //   92: astore 9
    //   94: aload_2
    //   95: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   98: aload 9
    //   100: areturn
    //   101: astore 4
    //   103: aconst_null
    //   104: astore_2
    //   105: getstatic 20	com/viber/voip/util/e/j:b	Lcom/viber/dexshared/Logger;
    //   108: aload 4
    //   110: ldc_w 1220
    //   113: invokeinterface 586 3 0
    //   118: aload_2
    //   119: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_2
    //   127: aload_1
    //   128: astore_3
    //   129: aload_2
    //   130: invokestatic 304	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: goto -7 -> 129
    //   139: astore 4
    //   141: goto -36 -> 105
    //
    // Exception table:
    //   from	to	target	type
    //   0	52	101	java/io/IOException
    //   0	52	124	finally
    //   55	73	135	finally
    //   84	94	135	finally
    //   105	118	135	finally
    //   55	73	139	java/io/IOException
    //   84	94	139	java/io/IOException
  }

  public static void c(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
      paramBitmap.recycle();
  }

  public static int d(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }

  // ERROR //
  private static File d(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 952	com/viber/voip/util/dk:b	(Landroid/net/Uri;)Z
    //   4: ifeq +29 -> 33
    //   7: aload_1
    //   8: invokevirtual 322	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   11: astore 11
    //   13: aload 11
    //   15: invokestatic 425	com/viber/voip/util/da:a	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +160 -> 178
    //   21: getstatic 1226	com/viber/voip/util/dv:l	Lcom/viber/voip/util/dv;
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 824	android/net/Uri:toString	()Ljava/lang/String;
    //   29: invokevirtual 892	com/viber/voip/util/dv:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   32: areturn
    //   33: aload_0
    //   34: invokevirtual 284	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   37: aload_1
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 1230	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 13
    //   47: aload 13
    //   49: astore_3
    //   50: aload_3
    //   51: invokestatic 1235	com/viber/voip/util/af:b	(Landroid/database/Cursor;)Z
    //   54: ifne +174 -> 228
    //   57: aload_3
    //   58: invokeinterface 1240 1 0
    //   63: ifeq +165 -> 228
    //   66: aload_3
    //   67: aload_3
    //   68: ldc_w 1242
    //   71: invokeinterface 1245 2 0
    //   76: invokeinterface 1248 2 0
    //   81: astore 15
    //   83: aload 15
    //   85: astore 11
    //   87: aload_3
    //   88: invokestatic 1251	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   91: goto -78 -> 13
    //   94: astore 4
    //   96: aconst_null
    //   97: astore 5
    //   99: aload_1
    //   100: invokestatic 1254	com/viber/voip/util/at:e	(Landroid/net/Uri;)Ljava/lang/String;
    //   103: astore 7
    //   105: aload 7
    //   107: invokestatic 425	com/viber/voip/util/da:a	(Ljava/lang/CharSequence;)Z
    //   110: istore 8
    //   112: aconst_null
    //   113: astore 9
    //   115: iload 8
    //   117: ifne +40 -> 157
    //   120: new 712	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 713	java/lang/StringBuilder:<init>	()V
    //   127: aload_0
    //   128: getstatic 1259	com/viber/voip/R$string:default_file_message_name	I
    //   131: invokevirtual 1260	android/content/Context:getString	(I)Ljava/lang/String;
    //   134: invokevirtual 719	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 1262
    //   140: invokevirtual 719	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 7
    //   145: invokevirtual 719	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 723	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore 10
    //   153: aload 10
    //   155: astore 9
    //   157: aload 5
    //   159: invokestatic 1251	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   162: aload 9
    //   164: astore 11
    //   166: goto -153 -> 13
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_3
    //   172: aload_3
    //   173: invokestatic 1251	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   176: aload_2
    //   177: athrow
    //   178: getstatic 783	com/viber/voip/util/dv:h	Lcom/viber/voip/util/dv;
    //   181: aload_0
    //   182: invokevirtual 1265	com/viber/voip/util/dv:a	(Landroid/content/Context;)Ljava/io/File;
    //   185: astore 12
    //   187: aload 12
    //   189: aload 12
    //   191: aload 11
    //   193: iconst_1
    //   194: invokestatic 1268	com/viber/voip/util/at:b	(Ljava/io/File;Ljava/lang/String;Z)Ljava/io/File;
    //   197: invokevirtual 1271	java/io/File:getName	()Ljava/lang/String;
    //   200: iconst_1
    //   201: invokestatic 1273	com/viber/voip/util/at:a	(Ljava/io/File;Ljava/lang/String;Z)Ljava/io/File;
    //   204: areturn
    //   205: astore_2
    //   206: goto -34 -> 172
    //   209: astore 6
    //   211: aload 5
    //   213: astore_3
    //   214: aload 6
    //   216: astore_2
    //   217: goto -45 -> 172
    //   220: astore 14
    //   222: aload_3
    //   223: astore 5
    //   225: goto -126 -> 99
    //   228: aconst_null
    //   229: astore 11
    //   231: goto -144 -> 87
    //
    // Exception table:
    //   from	to	target	type
    //   33	47	94	java/lang/Exception
    //   33	47	169	finally
    //   50	83	205	finally
    //   99	112	209	finally
    //   120	153	209	finally
    //   50	83	220	java/lang/Exception
  }

  public static boolean d(Uri paramUri)
  {
    String[] arrayOfString = at.f(paramUri);
    boolean bool1 = false;
    if (arrayOfString != null)
    {
      boolean bool2 = bg.a.d(arrayOfString[0]);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  public static Bitmap e(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Path localPath = new Path();
      int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
      h.c(i, i, localPath);
      return a(localPath, paramBitmap);
    }
    return null;
  }

  public static boolean e(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString()));
  }

  public static float f(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      return 0.0F;
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int[] arrayOfInt = new int[j * i];
    paramBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    int k = 0;
    float f2;
    for (float f1 = 0.0F; k < j; f1 = f2)
    {
      f2 = f1;
      for (int m = 0; m < i; m += 3)
      {
        int n = arrayOfInt[(m + i * k)];
        int i1 = Color.red(n);
        int i2 = Color.green(n);
        f2 += (i2 + (i2 + (i2 + (i2 + (Color.blue(n) + (i1 + (i1 + i1)))))) >> 3);
      }
      k += 3;
    }
    return f1 / (j * i / 9) / 255.0F;
  }

  private static boolean f(Uri paramUri)
  {
    if (paramUri != null)
    {
      String str = paramUri.toString();
      if ((str.contains("googleusercontent.com")) && (str.startsWith("content://")))
        return true;
    }
    return false;
  }

  public static Bitmap g(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(-1.0F, 1.0F, i / 2.0F, j / 2.0F);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }

  private static boolean g(Uri paramUri)
  {
    if (paramUri != null)
    {
      String str = paramUri.toString();
      if ((str.contains("content://com.google.android.apps")) && (str.startsWith("content://")))
        return true;
    }
    return false;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }

  public static class b
  {
    public final BitmapFactory.Options a;
    public final long b;
    public final String c;

    public b(BitmapFactory.Options paramOptions, long paramLong, String paramString)
    {
      this.a = paramOptions;
      this.b = paramLong;
      this.c = paramString;
    }
  }

  public static class c
  {
    private Bitmap a;
    private int b;
    private int c;

    public c(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = dq.a(ViberApplication.getApplication().getResources(), paramInt1);
      this.b = paramInt2;
      this.c = paramInt3;
    }

    public c(Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
      this.a = paramBitmap;
      this.b = paramInt1;
      this.c = paramInt2;
    }

    public Bitmap a(Bitmap paramBitmap)
    {
      return a(paramBitmap, false, 1.0F);
    }

    public Bitmap a(Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
    {
      Bitmap localBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
      Canvas localCanvas = new Canvas(localBitmap);
      int i;
      int j;
      if ((!paramBoolean) || ((this.a.getWidth() <= paramBitmap.getWidth()) && (this.a.getHeight() <= paramBitmap.getHeight())))
      {
        i = this.b;
        j = this.c;
        if (-2 == (0xFFFFFFFE & this.b))
          i = localBitmap.getWidth() / 2 - this.a.getWidth() / 2;
        if (-2 == (0xFFFFFFFE & this.c))
          j = localBitmap.getHeight() / 2 - this.a.getHeight() / 2;
        if (-3 == (0xFFFFFFFD & this.c))
          j -= this.a.getHeight() / 2;
      }
      try
      {
        localCanvas.drawBitmap(this.a, i, j, new Paint());
        return localBitmap;
        float f = paramFloat * Math.min(paramBitmap.getWidth() / this.a.getWidth(), paramBitmap.getHeight() / this.a.getHeight());
        int k = (int)(f * this.a.getWidth());
        int m = (int)(f * this.a.getHeight());
        int n = (paramBitmap.getWidth() - k) / 2;
        int i1 = (paramBitmap.getHeight() - m) / 2;
        try
        {
          localCanvas.drawBitmap(this.a, null, new Rect(n, i1, k + n, m + i1), new Paint(2));
          return localBitmap;
        }
        catch (Exception localException2)
        {
          return localBitmap;
        }
      }
      catch (Exception localException1)
      {
      }
      return localBitmap;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.j
 * JD-Core Version:    0.6.2
 */