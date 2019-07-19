package com.viber.voip.camera;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.media.CamcorderProfile;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import com.viber.voip.camera.activity.ViberCcamActivity;
import com.viber.voip.camera.c.b.f;
import java.io.File;
import java.io.IOException;

public class a
  implements com.viber.voip.camera.c.a
{
  private static final String a = com.viber.voip.camera.e.a.a(a.class);
  private ViberCcamActivity b = null;
  private com.viber.voip.camera.b.b c = null;
  private int d = 0;
  private int e = 0;
  private float f = 0.0F;

  public a(ViberCcamActivity paramViberCcamActivity, Bundle paramBundle)
  {
    this.b = paramViberCcamActivity;
    this.c = new com.viber.voip.camera.b.b(paramViberCcamActivity);
    if (paramBundle != null)
    {
      this.d = paramBundle.getInt("cameraId", 0);
      this.e = paramBundle.getInt("zoom_factor", 0);
      this.f = paramBundle.getFloat("focus_distance", 0.0F);
    }
  }

  private void a(ExifInterface paramExifInterface)
  {
    if ((this.b.s().p()) && (af()));
  }

  private boolean af()
  {
    return com.viber.voip.camera.d.a.a(b()).getBoolean(com.viber.voip.camera.d.a.n(), false);
  }

  private boolean ag()
  {
    boolean bool1 = com.viber.voip.camera.d.a.a(b()).getBoolean(com.viber.voip.camera.d.a.m(), false);
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = this.b.p();
      bool2 = false;
      if (bool3)
        bool2 = true;
    }
    return bool2;
  }

  private boolean ah()
  {
    return false;
  }

  private void b(ExifInterface paramExifInterface)
  {
    String str = paramExifInterface.getAttribute("DateTime");
    if (str != null)
    {
      paramExifInterface.setAttribute("DateTimeOriginal", str);
      paramExifInterface.setAttribute("DateTimeDigitized", str);
    }
  }

  private void c(ExifInterface paramExifInterface)
  {
    paramExifInterface.setAttribute("GPSTimeStamp", Long.toString(System.currentTimeMillis()));
  }

  private void e(final boolean paramBoolean)
  {
    this.b.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!paramBoolean)
          a.a(a.this).l();
      }
    });
  }

  public String A()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.L(), "preference_preview_size_wysiwyg");
  }

  public String B()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.M(), "0");
  }

  public String C()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.N(), "none");
  }

  public boolean D()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.o(), "none").equals("single");
  }

  public boolean E()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.o(), "none").equals("double");
  }

  public boolean F()
  {
    return com.viber.voip.camera.d.a.a(b()).getBoolean(com.viber.voip.camera.d.a.p(), false);
  }

  public boolean G()
  {
    return com.viber.voip.camera.d.a.a(b()).getBoolean(com.viber.voip.camera.d.a.S(), true);
  }

  public long H()
  {
    String str = com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.O(), "0");
    try
    {
      int i = Integer.parseInt(str);
      return i * 1000;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0L;
  }

  public String I()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.Q(), "1");
  }

  public long J()
  {
    String str = com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.R(), "0");
    try
    {
      int i = Integer.parseInt(str);
      return i * 1000;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0L;
  }

  public boolean K()
  {
    return com.viber.voip.camera.d.a.a(b()).getBoolean(com.viber.voip.camera.d.a.I(), true);
  }

  public String L()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.J(), "audio_default");
  }

  public String M()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.K(), "audio_src_camcorder");
  }

  public int N()
  {
    return this.e;
  }

  public long O()
  {
    return com.viber.voip.camera.d.a.a(b()).getLong(com.viber.voip.camera.d.a.j(), 33333333L);
  }

  public float P()
  {
    return this.f;
  }

  public void Q()
  {
    this.b.o();
  }

  public void R()
  {
  }

  public void S()
  {
    ViberCcamActivity localViberCcamActivity = this.b;
    if ((localViberCcamActivity instanceof b.f))
      ((b.f)localViberCcamActivity).N();
  }

  public void T()
  {
    this.b.s().e(R.string.cam_error_notice_failed_to_start_camera_preview);
  }

  public void U()
  {
    this.b.s().e(R.string.cam_error_notice_failed_to_take_picture);
  }

  public void V()
  {
    this.b.s().e(R.string.cam_error_notice_unable_to_open_camera);
  }

  public void W()
  {
    this.b.s().e(R.string.cam_error_notice_failed_to_save_video_file);
    Context localContext = b();
    if ((localContext instanceof b.f))
      ((b.f)localContext).J();
  }

  public void X()
  {
  }

  public void Y()
  {
    this.b.j();
  }

  public void Z()
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.remove(com.viber.voip.camera.d.a.g());
    localEditor.apply();
  }

  public com.viber.voip.camera.b.b a()
  {
    return this.c;
  }

  public String a(boolean paramBoolean)
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.a(this.d, paramBoolean), "");
  }

  public void a(float paramFloat)
  {
    this.f = paramFloat;
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putInt(com.viber.voip.camera.d.a.c(), paramInt);
    localEditor.apply();
  }

  public void a(int paramInt1, int paramInt2)
  {
  }

  public void a(int paramInt, Uri paramUri, String paramString)
  {
    int i;
    if (paramInt == 0)
    {
      if (paramString == null)
        break label147;
      File localFile = new File(paramString);
      this.c.a(localFile, false, true);
      i = 1;
    }
    while (true)
      if ((!"android.media.action.VIDEO_CAPTURE".equals(this.b.getIntent().getAction())) || ((i != 0) && (paramInt == 0)))
      {
        return;
        if (paramUri != null)
        {
          this.c.a(paramUri, false, true);
          i = 1;
        }
      }
      else
      {
        Intent localIntent;
        if ((i != 0) && (paramInt == 1))
        {
          localIntent = new Intent();
          localIntent.setData(paramUri);
        }
        while (true)
        {
          ViberCcamActivity localViberCcamActivity = this.b;
          int j = 0;
          if (i != 0)
            j = -1;
          localViberCcamActivity.setResult(j, localIntent);
          this.b.finish();
          return;
          localIntent = null;
        }
        label147: i = 0;
      }
  }

  public void a(long paramLong)
  {
    boolean bool = true;
    ViberCcamActivity localViberCcamActivity;
    if (com.viber.voip.camera.d.a.a(b()).getBoolean(com.viber.voip.camera.d.a.P(), bool))
    {
      if (paramLong > 1000L)
        break label52;
      localViberCcamActivity = this.b;
      if (!bool)
        break label57;
    }
    label52: label57: for (int i = R.raw.beep_hi; ; i = R.raw.beep)
    {
      localViberCcamActivity.f(i);
      return;
      bool = false;
      break;
    }
  }

  public void a(Canvas paramCanvas)
  {
  }

  public void a(CamcorderProfile paramCamcorderProfile)
  {
    this.b.s().e(R.string.cam_error_notice_failed_to_record_video);
    Context localContext = b();
    if ((localContext instanceof b.f))
      ((b.f)localContext).J();
  }

  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("cameraId", this.d);
    paramBundle.putInt("zoom_factor", this.e);
    paramBundle.putFloat("focus_distance", this.f);
  }

  public void a(MotionEvent paramMotionEvent)
  {
    this.b.l();
  }

  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putString(com.viber.voip.camera.d.a.a(this.d), paramString);
    localEditor.apply();
  }

  public void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putString(com.viber.voip.camera.d.a.a(this.d, paramBoolean), paramString);
    localEditor.apply();
  }

  // ERROR //
  @android.annotation.SuppressLint({"SimpleDateFormat"})
  public boolean a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 380	java/lang/System:gc	()V
    //   3: aload_0
    //   4: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   7: invokevirtual 309	com/viber/voip/camera/activity/ViberCcamActivity:getIntent	()Landroid/content/Intent;
    //   10: invokevirtual 314	android/content/Intent:getAction	()Ljava/lang/String;
    //   13: astore_2
    //   14: ldc_w 382
    //   17: aload_2
    //   18: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifne +19 -> 40
    //   24: ldc_w 384
    //   27: aload_2
    //   28: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: istore 79
    //   33: iconst_0
    //   34: istore_3
    //   35: iload 79
    //   37: ifeq +1557 -> 1594
    //   40: iconst_1
    //   41: istore_3
    //   42: aload_0
    //   43: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   46: invokevirtual 309	com/viber/voip/camera/activity/ViberCcamActivity:getIntent	()Landroid/content/Intent;
    //   49: invokevirtual 388	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   52: astore 4
    //   54: aload 4
    //   56: ifnull +1538 -> 1594
    //   59: aload 4
    //   61: ldc_w 390
    //   64: invokevirtual 394	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   67: checkcast 396	android/net/Uri
    //   70: astore 6
    //   72: iload_3
    //   73: istore 5
    //   75: aload_0
    //   76: invokespecial 398	com/viber/voip/camera/a:ag	()Z
    //   79: ifeq +16 -> 95
    //   82: aload_0
    //   83: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   86: invokevirtual 69	com/viber/voip/camera/activity/ViberCcamActivity:s	()Lcom/viber/voip/camera/c/b;
    //   89: invokevirtual 400	com/viber/voip/camera/c/b:o	()Z
    //   92: ifeq +3 -> 95
    //   95: iload 5
    //   97: ifeq +1064 -> 1161
    //   100: aload 6
    //   102: ifnull +881 -> 983
    //   105: aconst_null
    //   106: astore 20
    //   108: aconst_null
    //   109: astore 12
    //   111: aload 6
    //   113: astore 14
    //   115: aconst_null
    //   116: astore 19
    //   118: aload 14
    //   120: ifnull +1453 -> 1573
    //   123: aload 19
    //   125: ifnonnull +1448 -> 1573
    //   128: ldc_w 402
    //   131: ldc_w 404
    //   134: aload_0
    //   135: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   138: invokevirtual 408	com/viber/voip/camera/activity/ViberCcamActivity:getCacheDir	()Ljava/io/File;
    //   141: invokestatic 412	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   144: astore 19
    //   146: new 414	java/io/FileOutputStream
    //   149: dup
    //   150: aload 19
    //   152: invokespecial 417	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   155: astore 65
    //   157: aload 19
    //   159: astore 13
    //   161: aload 65
    //   163: astore 22
    //   165: aload 22
    //   167: ifnull +1400 -> 1567
    //   170: aload 12
    //   172: ifnull +1055 -> 1227
    //   175: aload_0
    //   176: invokevirtual 419	com/viber/voip/camera/a:p	()I
    //   179: istore 60
    //   181: aload 12
    //   183: getstatic 425	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   186: iload 60
    //   188: aload 22
    //   190: invokevirtual 431	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   193: pop
    //   194: aload 22
    //   196: invokevirtual 436	java/io/OutputStream:close	()V
    //   199: aload 14
    //   201: ifnonnull +1360 -> 1561
    //   204: iconst_1
    //   205: istore 15
    //   207: aload 13
    //   209: ifnull +594 -> 803
    //   212: aload 12
    //   214: ifnull +1042 -> 1256
    //   217: ldc_w 438
    //   220: ldc_w 286
    //   223: invokestatic 441	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   226: astore 37
    //   228: new 414	java/io/FileOutputStream
    //   231: dup
    //   232: aload 37
    //   234: invokespecial 417	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   237: astore 38
    //   239: aload 38
    //   241: aload_1
    //   242: invokevirtual 445	java/io/OutputStream:write	([B)V
    //   245: aload 38
    //   247: invokevirtual 436	java/io/OutputStream:close	()V
    //   250: new 106	android/media/ExifInterface
    //   253: dup
    //   254: aload 37
    //   256: invokevirtual 448	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   259: invokespecial 449	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   262: astore 39
    //   264: aload 39
    //   266: ldc_w 451
    //   269: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   272: astore 40
    //   274: aload 39
    //   276: ldc 104
    //   278: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   281: astore 41
    //   283: aload 39
    //   285: ldc_w 453
    //   288: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 42
    //   293: aload 39
    //   295: ldc_w 455
    //   298: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   301: astore 43
    //   303: aload 39
    //   305: ldc_w 457
    //   308: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   311: astore 44
    //   313: aload 39
    //   315: ldc_w 459
    //   318: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   321: astore 45
    //   323: aload 39
    //   325: ldc_w 461
    //   328: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   331: astore 46
    //   333: aload 39
    //   335: ldc_w 463
    //   338: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   341: astore 47
    //   343: aload 39
    //   345: ldc_w 465
    //   348: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   351: astore 48
    //   353: aload 39
    //   355: ldc_w 467
    //   358: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore 49
    //   363: aload 39
    //   365: ldc_w 469
    //   368: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   371: astore 50
    //   373: aload 39
    //   375: ldc_w 471
    //   378: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   381: astore 51
    //   383: aload 39
    //   385: ldc_w 473
    //   388: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   391: astore 52
    //   393: aload 39
    //   395: ldc 120
    //   397: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   400: astore 53
    //   402: aload 39
    //   404: ldc_w 475
    //   407: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   410: astore 54
    //   412: aload 39
    //   414: ldc_w 477
    //   417: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   420: astore 55
    //   422: aload 39
    //   424: ldc_w 479
    //   427: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   430: astore 56
    //   432: aload 39
    //   434: ldc_w 481
    //   437: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   440: astore 57
    //   442: aload 39
    //   444: ldc_w 483
    //   447: invokevirtual 110	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   450: astore 58
    //   452: aload 37
    //   454: invokevirtual 486	java/io/File:delete	()Z
    //   457: ifne +3 -> 460
    //   460: new 106	android/media/ExifInterface
    //   463: dup
    //   464: aload 13
    //   466: invokevirtual 448	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   469: invokespecial 449	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   472: astore 59
    //   474: aload 40
    //   476: ifnull +13 -> 489
    //   479: aload 59
    //   481: ldc_w 451
    //   484: aload 40
    //   486: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload 41
    //   491: ifnull +12 -> 503
    //   494: aload 59
    //   496: ldc 104
    //   498: aload 41
    //   500: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload 42
    //   505: ifnull +13 -> 518
    //   508: aload 59
    //   510: ldc_w 453
    //   513: aload 42
    //   515: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: aload 43
    //   520: ifnull +13 -> 533
    //   523: aload 59
    //   525: ldc_w 455
    //   528: aload 43
    //   530: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload 44
    //   535: ifnull +13 -> 548
    //   538: aload 59
    //   540: ldc_w 457
    //   543: aload 44
    //   545: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload 45
    //   550: ifnull +13 -> 563
    //   553: aload 59
    //   555: ldc_w 459
    //   558: aload 45
    //   560: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: aload 46
    //   565: ifnull +13 -> 578
    //   568: aload 59
    //   570: ldc_w 461
    //   573: aload 46
    //   575: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: aload 47
    //   580: ifnull +13 -> 593
    //   583: aload 59
    //   585: ldc_w 463
    //   588: aload 47
    //   590: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: aload 48
    //   595: ifnull +13 -> 608
    //   598: aload 59
    //   600: ldc_w 465
    //   603: aload 48
    //   605: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload 49
    //   610: ifnull +13 -> 623
    //   613: aload 59
    //   615: ldc_w 467
    //   618: aload 49
    //   620: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: aload 50
    //   625: ifnull +13 -> 638
    //   628: aload 59
    //   630: ldc_w 469
    //   633: aload 50
    //   635: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: aload 51
    //   640: ifnull +13 -> 653
    //   643: aload 59
    //   645: ldc_w 471
    //   648: aload 51
    //   650: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   653: aload 52
    //   655: ifnull +13 -> 668
    //   658: aload 59
    //   660: ldc_w 473
    //   663: aload 52
    //   665: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: aload 53
    //   670: ifnull +12 -> 682
    //   673: aload 59
    //   675: ldc 120
    //   677: aload 53
    //   679: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: aload 54
    //   684: ifnull +13 -> 697
    //   687: aload 59
    //   689: ldc_w 475
    //   692: aload 54
    //   694: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload 55
    //   699: ifnull +13 -> 712
    //   702: aload 59
    //   704: ldc_w 477
    //   707: aload 55
    //   709: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   712: aload 56
    //   714: ifnull +13 -> 727
    //   717: aload 59
    //   719: ldc_w 479
    //   722: aload 56
    //   724: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   727: aload 57
    //   729: ifnull +13 -> 742
    //   732: aload 59
    //   734: ldc_w 481
    //   737: aload 57
    //   739: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   742: aload 58
    //   744: ifnull +13 -> 757
    //   747: aload 59
    //   749: ldc_w 483
    //   752: aload 58
    //   754: invokevirtual 116	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: aload_0
    //   758: aload 59
    //   760: invokespecial 488	com/viber/voip/camera/a:a	(Landroid/media/ExifInterface;)V
    //   763: aload_0
    //   764: aload 59
    //   766: invokespecial 490	com/viber/voip/camera/a:b	(Landroid/media/ExifInterface;)V
    //   769: aload_0
    //   770: invokespecial 492	com/viber/voip/camera/a:ah	()Z
    //   773: ifeq +9 -> 782
    //   776: aload_0
    //   777: aload 59
    //   779: invokespecial 494	com/viber/voip/camera/a:c	(Landroid/media/ExifInterface;)V
    //   782: aload 59
    //   784: invokevirtual 497	android/media/ExifInterface:saveAttributes	()V
    //   787: aload 14
    //   789: ifnonnull +14 -> 803
    //   792: aload_0
    //   793: getfield 34	com/viber/voip/camera/a:c	Lcom/viber/voip/camera/b/b;
    //   796: aload 13
    //   798: iconst_1
    //   799: iconst_0
    //   800: invokevirtual 303	com/viber/voip/camera/b/b:a	(Ljava/io/File;ZZ)V
    //   803: iload 5
    //   805: ifeq +18 -> 823
    //   808: aload_0
    //   809: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   812: iconst_m1
    //   813: invokevirtual 499	com/viber/voip/camera/activity/ViberCcamActivity:setResult	(I)V
    //   816: aload_0
    //   817: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   820: invokevirtual 329	com/viber/voip/camera/activity/ViberCcamActivity:finish	()V
    //   823: aload_0
    //   824: getfield 34	com/viber/voip/camera/a:c	Lcom/viber/voip/camera/b/b;
    //   827: invokevirtual 501	com/viber/voip/camera/b/b:b	()Z
    //   830: ifeq +10 -> 840
    //   833: aload_0
    //   834: getfield 34	com/viber/voip/camera/a:c	Lcom/viber/voip/camera/b/b;
    //   837: invokevirtual 503	com/viber/voip/camera/b/b:a	()V
    //   840: aload 14
    //   842: ifnull +109 -> 951
    //   845: new 505	java/io/FileInputStream
    //   848: dup
    //   849: aload 13
    //   851: invokespecial 506	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   854: astore 27
    //   856: aload_0
    //   857: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   860: invokevirtual 510	com/viber/voip/camera/activity/ViberCcamActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   863: aload 14
    //   865: invokevirtual 516	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   868: astore 28
    //   870: sipush 1024
    //   873: newarray byte
    //   875: astore 29
    //   877: aload 27
    //   879: aload 29
    //   881: invokevirtual 522	java/io/InputStream:read	([B)I
    //   884: istore 30
    //   886: iload 30
    //   888: ifle +496 -> 1384
    //   891: aload 28
    //   893: aload 29
    //   895: iconst_0
    //   896: iload 30
    //   898: invokevirtual 525	java/io/OutputStream:write	([BII)V
    //   901: goto -24 -> 877
    //   904: astore 26
    //   906: iload 15
    //   908: istore 11
    //   910: aload 14
    //   912: astore 8
    //   914: aload 13
    //   916: astore 9
    //   918: aload 12
    //   920: astore 10
    //   922: aload_0
    //   923: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   926: invokevirtual 69	com/viber/voip/camera/activity/ViberCcamActivity:s	()Lcom/viber/voip/camera/c/b;
    //   929: getstatic 528	com/viber/voip/camera/R$string:cam_error_notice_failed_to_save_photo	I
    //   932: invokevirtual 244	com/viber/voip/camera/c/b:e	(I)V
    //   935: aload 10
    //   937: astore 12
    //   939: aload 9
    //   941: astore 13
    //   943: aload 8
    //   945: astore 14
    //   947: iload 11
    //   949: istore 15
    //   951: aload 12
    //   953: ifnull +8 -> 961
    //   956: aload 12
    //   958: invokevirtual 531	android/graphics/Bitmap:recycle	()V
    //   961: aload 13
    //   963: ifnull +14 -> 977
    //   966: aload 14
    //   968: ifnull +9 -> 977
    //   971: aload 13
    //   973: invokevirtual 486	java/io/File:delete	()Z
    //   976: pop
    //   977: invokestatic 380	java/lang/System:gc	()V
    //   980: iload 15
    //   982: ireturn
    //   983: iconst_0
    //   984: ifne +604 -> 1588
    //   987: new 533	android/graphics/BitmapFactory$Options
    //   990: dup
    //   991: invokespecial 534	android/graphics/BitmapFactory$Options:<init>	()V
    //   994: astore 77
    //   996: getstatic 539	android/os/Build$VERSION:SDK_INT	I
    //   999: bipush 19
    //   1001: if_icmpgt +9 -> 1010
    //   1004: aload 77
    //   1006: iconst_1
    //   1007: putfield 542	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   1010: aload_1
    //   1011: iconst_0
    //   1012: aload_1
    //   1013: arraylength
    //   1014: aload 77
    //   1016: invokestatic 548	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1019: astore 78
    //   1021: aload 78
    //   1023: astore 68
    //   1025: aload 68
    //   1027: ifnull +85 -> 1112
    //   1030: aload 68
    //   1032: invokevirtual 551	android/graphics/Bitmap:getWidth	()I
    //   1035: istore 71
    //   1037: aload 68
    //   1039: invokevirtual 554	android/graphics/Bitmap:getHeight	()I
    //   1042: istore 72
    //   1044: iload 71
    //   1046: sipush 128
    //   1049: if_icmple +63 -> 1112
    //   1052: ldc_w 555
    //   1055: iload 71
    //   1057: i2f
    //   1058: fdiv
    //   1059: fstore 73
    //   1061: new 557	android/graphics/Matrix
    //   1064: dup
    //   1065: invokespecial 558	android/graphics/Matrix:<init>	()V
    //   1068: astore 74
    //   1070: aload 74
    //   1072: fload 73
    //   1074: fload 73
    //   1076: invokevirtual 562	android/graphics/Matrix:postScale	(FF)Z
    //   1079: pop
    //   1080: aload 68
    //   1082: iconst_0
    //   1083: iconst_0
    //   1084: iload 71
    //   1086: iload 72
    //   1088: aload 74
    //   1090: iconst_1
    //   1091: invokestatic 566	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   1094: astore 76
    //   1096: aload 76
    //   1098: aload 68
    //   1100: if_acmpeq +12 -> 1112
    //   1103: aload 68
    //   1105: invokevirtual 531	android/graphics/Bitmap:recycle	()V
    //   1108: aload 76
    //   1110: astore 68
    //   1112: aload_0
    //   1113: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   1116: iconst_m1
    //   1117: new 311	android/content/Intent
    //   1120: dup
    //   1121: ldc_w 568
    //   1124: invokespecial 569	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1127: ldc_w 571
    //   1130: aload 68
    //   1132: invokevirtual 575	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1135: invokevirtual 326	com/viber/voip/camera/activity/ViberCcamActivity:setResult	(ILandroid/content/Intent;)V
    //   1138: aload_0
    //   1139: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   1142: invokevirtual 329	com/viber/voip/camera/activity/ViberCcamActivity:finish	()V
    //   1145: aload 68
    //   1147: astore 12
    //   1149: aconst_null
    //   1150: astore 19
    //   1152: aconst_null
    //   1153: astore 14
    //   1155: aconst_null
    //   1156: astore 20
    //   1158: goto -1040 -> 118
    //   1161: aload_0
    //   1162: getfield 34	com/viber/voip/camera/a:c	Lcom/viber/voip/camera/b/b;
    //   1165: invokevirtual 501	com/viber/voip/camera/b/b:b	()Z
    //   1168: ifeq +25 -> 1193
    //   1171: aload_0
    //   1172: getfield 34	com/viber/voip/camera/a:c	Lcom/viber/voip/camera/b/b;
    //   1175: iconst_1
    //   1176: invokevirtual 578	com/viber/voip/camera/b/b:b	(I)Landroid/net/Uri;
    //   1179: astore 14
    //   1181: aconst_null
    //   1182: astore 19
    //   1184: aconst_null
    //   1185: astore 20
    //   1187: aconst_null
    //   1188: astore 12
    //   1190: goto -1072 -> 118
    //   1193: aload_0
    //   1194: getfield 34	com/viber/voip/camera/a:c	Lcom/viber/voip/camera/b/b;
    //   1197: iconst_1
    //   1198: invokevirtual 581	com/viber/voip/camera/b/b:a	(I)Ljava/io/File;
    //   1201: astore 18
    //   1203: aload 18
    //   1205: astore 19
    //   1207: new 414	java/io/FileOutputStream
    //   1210: dup
    //   1211: aload 19
    //   1213: invokespecial 417	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1216: astore 20
    //   1218: aconst_null
    //   1219: astore 14
    //   1221: aconst_null
    //   1222: astore 12
    //   1224: goto -1106 -> 118
    //   1227: aload 22
    //   1229: aload_1
    //   1230: invokevirtual 445	java/io/OutputStream:write	([B)V
    //   1233: goto -1039 -> 194
    //   1236: astore 24
    //   1238: aload 14
    //   1240: astore 8
    //   1242: aload 13
    //   1244: astore 9
    //   1246: aload 12
    //   1248: astore 10
    //   1250: iconst_0
    //   1251: istore 11
    //   1253: goto -331 -> 922
    //   1256: aload_0
    //   1257: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   1260: invokevirtual 69	com/viber/voip/camera/activity/ViberCcamActivity:s	()Lcom/viber/voip/camera/c/b;
    //   1263: invokevirtual 75	com/viber/voip/camera/c/b:p	()Z
    //   1266: ifeq +79 -> 1345
    //   1269: aload_0
    //   1270: invokespecial 78	com/viber/voip/camera/a:af	()Z
    //   1273: ifeq +72 -> 1345
    //   1276: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   1279: pop2
    //   1280: new 106	android/media/ExifInterface
    //   1283: dup
    //   1284: aload 13
    //   1286: invokevirtual 448	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1289: invokespecial 449	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   1292: astore 36
    //   1294: aload_0
    //   1295: aload 36
    //   1297: invokespecial 488	com/viber/voip/camera/a:a	(Landroid/media/ExifInterface;)V
    //   1300: aload_0
    //   1301: aload 36
    //   1303: invokespecial 490	com/viber/voip/camera/a:b	(Landroid/media/ExifInterface;)V
    //   1306: aload_0
    //   1307: invokespecial 492	com/viber/voip/camera/a:ah	()Z
    //   1310: ifeq +9 -> 1319
    //   1313: aload_0
    //   1314: aload 36
    //   1316: invokespecial 494	com/viber/voip/camera/a:c	(Landroid/media/ExifInterface;)V
    //   1319: aload 36
    //   1321: invokevirtual 497	android/media/ExifInterface:saveAttributes	()V
    //   1324: goto -537 -> 787
    //   1327: astore 25
    //   1329: aload_0
    //   1330: getfield 32	com/viber/voip/camera/a:b	Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   1333: invokevirtual 69	com/viber/voip/camera/activity/ViberCcamActivity:s	()Lcom/viber/voip/camera/c/b;
    //   1336: getstatic 528	com/viber/voip/camera/R$string:cam_error_notice_failed_to_save_photo	I
    //   1339: invokevirtual 244	com/viber/voip/camera/c/b:e	(I)V
    //   1342: goto -391 -> 951
    //   1345: aload_0
    //   1346: invokespecial 492	com/viber/voip/camera/a:ah	()Z
    //   1349: ifeq -562 -> 787
    //   1352: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   1355: pop2
    //   1356: new 106	android/media/ExifInterface
    //   1359: dup
    //   1360: aload 13
    //   1362: invokevirtual 448	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1365: invokespecial 449	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   1368: astore 33
    //   1370: aload_0
    //   1371: aload 33
    //   1373: invokespecial 494	com/viber/voip/camera/a:c	(Landroid/media/ExifInterface;)V
    //   1376: aload 33
    //   1378: invokevirtual 497	android/media/ExifInterface:saveAttributes	()V
    //   1381: goto -594 -> 787
    //   1384: aload 27
    //   1386: invokevirtual 582	java/io/InputStream:close	()V
    //   1389: aload 28
    //   1391: invokevirtual 436	java/io/OutputStream:close	()V
    //   1394: iconst_1
    //   1395: istore 15
    //   1397: aload_0
    //   1398: getfield 34	com/viber/voip/camera/a:c	Lcom/viber/voip/camera/b/b;
    //   1401: aload 14
    //   1403: iconst_1
    //   1404: iconst_0
    //   1405: invokevirtual 317	com/viber/voip/camera/b/b:a	(Landroid/net/Uri;ZZ)V
    //   1408: goto -457 -> 951
    //   1411: astore 17
    //   1413: iconst_0
    //   1414: istore 15
    //   1416: aconst_null
    //   1417: astore 14
    //   1419: aconst_null
    //   1420: astore 13
    //   1422: aconst_null
    //   1423: astore 12
    //   1425: goto -96 -> 1329
    //   1428: astore 70
    //   1430: aload 68
    //   1432: astore 12
    //   1434: iconst_0
    //   1435: istore 15
    //   1437: aconst_null
    //   1438: astore 14
    //   1440: aconst_null
    //   1441: astore 13
    //   1443: goto -114 -> 1329
    //   1446: astore 67
    //   1448: aload 19
    //   1450: astore 13
    //   1452: iconst_0
    //   1453: istore 15
    //   1455: aconst_null
    //   1456: astore 14
    //   1458: aconst_null
    //   1459: astore 12
    //   1461: goto -132 -> 1329
    //   1464: astore 64
    //   1466: aload 19
    //   1468: astore 13
    //   1470: iconst_0
    //   1471: istore 15
    //   1473: goto -144 -> 1329
    //   1476: astore 23
    //   1478: iconst_0
    //   1479: istore 15
    //   1481: goto -152 -> 1329
    //   1484: astore 7
    //   1486: aconst_null
    //   1487: astore 8
    //   1489: aconst_null
    //   1490: astore 9
    //   1492: aconst_null
    //   1493: astore 10
    //   1495: iconst_0
    //   1496: istore 11
    //   1498: goto -576 -> 922
    //   1501: astore 69
    //   1503: aload 68
    //   1505: astore 10
    //   1507: aconst_null
    //   1508: astore 8
    //   1510: aconst_null
    //   1511: astore 9
    //   1513: iconst_0
    //   1514: istore 11
    //   1516: goto -594 -> 922
    //   1519: astore 66
    //   1521: aload 19
    //   1523: astore 9
    //   1525: aconst_null
    //   1526: astore 8
    //   1528: aconst_null
    //   1529: astore 10
    //   1531: iconst_0
    //   1532: istore 11
    //   1534: goto -612 -> 922
    //   1537: astore 62
    //   1539: aload 12
    //   1541: astore 10
    //   1543: aload 19
    //   1545: astore 63
    //   1547: aload 14
    //   1549: astore 8
    //   1551: aload 63
    //   1553: astore 9
    //   1555: iconst_0
    //   1556: istore 11
    //   1558: goto -636 -> 922
    //   1561: iconst_0
    //   1562: istore 15
    //   1564: goto -1357 -> 207
    //   1567: iconst_0
    //   1568: istore 15
    //   1570: goto -619 -> 951
    //   1573: aload 20
    //   1575: astore 21
    //   1577: aload 19
    //   1579: astore 13
    //   1581: aload 21
    //   1583: astore 22
    //   1585: goto -1420 -> 165
    //   1588: aconst_null
    //   1589: astore 68
    //   1591: goto -566 -> 1025
    //   1594: iload_3
    //   1595: istore 5
    //   1597: aconst_null
    //   1598: astore 6
    //   1600: goto -1525 -> 75
    //
    // Exception table:
    //   from	to	target	type
    //   217	460	904	java/io/FileNotFoundException
    //   460	474	904	java/io/FileNotFoundException
    //   479	489	904	java/io/FileNotFoundException
    //   494	503	904	java/io/FileNotFoundException
    //   508	518	904	java/io/FileNotFoundException
    //   523	533	904	java/io/FileNotFoundException
    //   538	548	904	java/io/FileNotFoundException
    //   553	563	904	java/io/FileNotFoundException
    //   568	578	904	java/io/FileNotFoundException
    //   583	593	904	java/io/FileNotFoundException
    //   598	608	904	java/io/FileNotFoundException
    //   613	623	904	java/io/FileNotFoundException
    //   628	638	904	java/io/FileNotFoundException
    //   643	653	904	java/io/FileNotFoundException
    //   658	668	904	java/io/FileNotFoundException
    //   673	682	904	java/io/FileNotFoundException
    //   687	697	904	java/io/FileNotFoundException
    //   702	712	904	java/io/FileNotFoundException
    //   717	727	904	java/io/FileNotFoundException
    //   732	742	904	java/io/FileNotFoundException
    //   747	757	904	java/io/FileNotFoundException
    //   757	782	904	java/io/FileNotFoundException
    //   782	787	904	java/io/FileNotFoundException
    //   792	803	904	java/io/FileNotFoundException
    //   808	823	904	java/io/FileNotFoundException
    //   823	840	904	java/io/FileNotFoundException
    //   845	877	904	java/io/FileNotFoundException
    //   877	886	904	java/io/FileNotFoundException
    //   891	901	904	java/io/FileNotFoundException
    //   1256	1319	904	java/io/FileNotFoundException
    //   1319	1324	904	java/io/FileNotFoundException
    //   1345	1381	904	java/io/FileNotFoundException
    //   1384	1394	904	java/io/FileNotFoundException
    //   1397	1408	904	java/io/FileNotFoundException
    //   175	194	1236	java/io/FileNotFoundException
    //   194	199	1236	java/io/FileNotFoundException
    //   1227	1233	1236	java/io/FileNotFoundException
    //   217	460	1327	java/io/IOException
    //   460	474	1327	java/io/IOException
    //   479	489	1327	java/io/IOException
    //   494	503	1327	java/io/IOException
    //   508	518	1327	java/io/IOException
    //   523	533	1327	java/io/IOException
    //   538	548	1327	java/io/IOException
    //   553	563	1327	java/io/IOException
    //   568	578	1327	java/io/IOException
    //   583	593	1327	java/io/IOException
    //   598	608	1327	java/io/IOException
    //   613	623	1327	java/io/IOException
    //   628	638	1327	java/io/IOException
    //   643	653	1327	java/io/IOException
    //   658	668	1327	java/io/IOException
    //   673	682	1327	java/io/IOException
    //   687	697	1327	java/io/IOException
    //   702	712	1327	java/io/IOException
    //   717	727	1327	java/io/IOException
    //   732	742	1327	java/io/IOException
    //   747	757	1327	java/io/IOException
    //   757	782	1327	java/io/IOException
    //   782	787	1327	java/io/IOException
    //   792	803	1327	java/io/IOException
    //   808	823	1327	java/io/IOException
    //   823	840	1327	java/io/IOException
    //   845	877	1327	java/io/IOException
    //   877	886	1327	java/io/IOException
    //   891	901	1327	java/io/IOException
    //   1256	1319	1327	java/io/IOException
    //   1319	1324	1327	java/io/IOException
    //   1345	1381	1327	java/io/IOException
    //   1384	1394	1327	java/io/IOException
    //   1397	1408	1327	java/io/IOException
    //   987	1010	1411	java/io/IOException
    //   1010	1021	1411	java/io/IOException
    //   1161	1181	1411	java/io/IOException
    //   1193	1203	1411	java/io/IOException
    //   1030	1044	1428	java/io/IOException
    //   1052	1096	1428	java/io/IOException
    //   1103	1108	1428	java/io/IOException
    //   1112	1145	1428	java/io/IOException
    //   1207	1218	1446	java/io/IOException
    //   128	157	1464	java/io/IOException
    //   175	194	1476	java/io/IOException
    //   194	199	1476	java/io/IOException
    //   1227	1233	1476	java/io/IOException
    //   987	1010	1484	java/io/FileNotFoundException
    //   1010	1021	1484	java/io/FileNotFoundException
    //   1161	1181	1484	java/io/FileNotFoundException
    //   1193	1203	1484	java/io/FileNotFoundException
    //   1030	1044	1501	java/io/FileNotFoundException
    //   1052	1096	1501	java/io/FileNotFoundException
    //   1103	1108	1501	java/io/FileNotFoundException
    //   1112	1145	1501	java/io/FileNotFoundException
    //   1207	1218	1519	java/io/FileNotFoundException
    //   128	157	1537	java/io/FileNotFoundException
  }

  public void aa()
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.remove(com.viber.voip.camera.d.a.f());
    localEditor.apply();
  }

  public void ab()
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.remove(com.viber.voip.camera.d.a.h());
    localEditor.apply();
  }

  public void ac()
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.remove(com.viber.voip.camera.d.a.i());
    localEditor.apply();
  }

  public void ad()
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.remove(com.viber.voip.camera.d.a.e());
    localEditor.apply();
  }

  public void ae()
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.remove(com.viber.voip.camera.d.a.j());
    localEditor.apply();
  }

  public Context b()
  {
    return this.b;
  }

  public void b(int paramInt)
  {
    this.b.g();
  }

  public void b(int paramInt1, int paramInt2)
  {
    this.b.s().e(R.string.cam_error_notice_video_error_unknown);
  }

  public void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putLong(com.viber.voip.camera.d.a.j(), paramLong);
    localEditor.apply();
  }

  public void b(CamcorderProfile paramCamcorderProfile)
  {
  }

  public void b(String paramString)
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putString(com.viber.voip.camera.d.a.g(), paramString);
    localEditor.apply();
  }

  public void b(boolean paramBoolean)
  {
  }

  public int c()
  {
    if ("android.media.action.VIDEO_CAPTURE".equals(this.b.getIntent().getAction()))
    {
      Bundle localBundle = this.b.getIntent().getExtras();
      int j = 0;
      if (localBundle != null)
      {
        Uri localUri = (Uri)localBundle.getParcelable("output");
        j = 0;
        if (localUri != null)
          j = 2;
      }
      return j;
    }
    if (this.c.b());
    for (int i = 1; ; i = 0)
      return i;
  }

  public void c(int paramInt)
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putString(com.viber.voip.camera.d.a.e(), "" + paramInt);
    localEditor.apply();
  }

  public void c(int paramInt1, int paramInt2)
  {
    String str = paramInt1 + " " + paramInt2;
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putString(com.viber.voip.camera.d.a.b(this.d), str);
    localEditor.apply();
  }

  public void c(String paramString)
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putString(com.viber.voip.camera.d.a.f(), paramString);
    localEditor.apply();
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      e(bool);
      Context localContext = b();
      if ((localContext instanceof b.f))
        ((b.f)localContext).b(paramBoolean);
      return;
    }
  }

  public File d()
    throws IOException
  {
    return this.c.a(2);
  }

  public void d(int paramInt)
  {
    Log.d(a, "setZoomPref: " + paramInt);
    this.e = paramInt;
  }

  public void d(String paramString)
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putString(com.viber.voip.camera.d.a.h(), paramString);
    localEditor.apply();
  }

  public void d(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putBoolean(com.viber.voip.camera.d.a.b(), paramBoolean);
    localEditor.apply();
  }

  public Uri e()
    throws IOException
  {
    return this.c.b(2);
  }

  public void e(String paramString)
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putString(com.viber.voip.camera.d.a.i(), paramString);
    localEditor.apply();
  }

  public Uri f()
    throws IOException
  {
    if ("android.media.action.VIDEO_CAPTURE".equals(this.b.getIntent().getAction()))
    {
      Bundle localBundle = this.b.getIntent().getExtras();
      if (localBundle != null)
      {
        Uri localUri = (Uri)localBundle.getParcelable("output");
        if (localUri != null)
          return localUri;
      }
    }
    throw new RuntimeException();
  }

  public void f(String paramString)
  {
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(b()).edit();
    localEditor.putString(com.viber.voip.camera.d.a.c(this.d), paramString);
    localEditor.apply();
  }

  public int g()
  {
    this.d = com.viber.voip.camera.d.a.a(b()).getInt(com.viber.voip.camera.d.a.c(), this.d);
    return this.d;
  }

  public String h()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.a(this.d), "");
  }

  public boolean i()
  {
    String str = this.b.getIntent().getAction();
    boolean bool1;
    if (("android.media.action.VIDEO_CAMERA".equals(str)) || ("android.media.action.VIDEO_CAPTURE".equals(str)))
      bool1 = true;
    boolean bool5;
    do
    {
      boolean bool4;
      do
      {
        boolean bool3;
        do
        {
          boolean bool2;
          do
          {
            return bool1;
            bool2 = "android.media.action.IMAGE_CAPTURE".equals(str);
            bool1 = false;
          }
          while (bool2);
          bool3 = "android.media.action.IMAGE_CAPTURE_SECURE".equals(str);
          bool1 = false;
        }
        while (bool3);
        bool4 = "android.media.action.STILL_IMAGE_CAMERA".equals(str);
        bool1 = false;
      }
      while (bool4);
      bool5 = "android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(str);
      bool1 = false;
    }
    while (bool5);
    return com.viber.voip.camera.d.a.a(b()).getBoolean(com.viber.voip.camera.d.a.b(), false);
  }

  public String j()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.g(), "auto");
  }

  public String k()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.f(), "none");
  }

  public String l()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.h(), "auto");
  }

  public String m()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.i(), "auto");
  }

  public int n()
  {
    String str = com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.e(), "0");
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0;
  }

  public Pair<Integer, Integer> o()
  {
    String str1 = com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.b(this.d), "");
    int i;
    if (str1.length() > 0)
    {
      i = str1.indexOf(' ');
      if (i != -1)
        break label44;
    }
    while (true)
    {
      return null;
      label44: String str2 = str1.substring(0, i);
      String str3 = str1.substring(i + 1);
      try
      {
        int j = Integer.parseInt(str2);
        int k = Integer.parseInt(str3);
        Pair localPair = new Pair(Integer.valueOf(j), Integer.valueOf(k));
        return localPair;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }

  public int p()
  {
    String str = com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.l(), "100");
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 100;
  }

  public boolean q()
  {
    return com.viber.voip.camera.d.a.a(b()).getBoolean(com.viber.voip.camera.d.a.z(), false);
  }

  public String r()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.c(this.d), "");
  }

  public boolean s()
  {
    return com.viber.voip.camera.d.a.a(b()).getBoolean(com.viber.voip.camera.d.a.A(), false);
  }

  public boolean t()
  {
    SharedPreferences localSharedPreferences = com.viber.voip.camera.d.a.a(b());
    int i = this.d;
    boolean bool1 = false;
    if (i == 0)
    {
      boolean bool2 = localSharedPreferences.getBoolean(com.viber.voip.camera.d.a.B(), false);
      bool1 = false;
      if (bool2)
      {
        boolean bool3 = this.b.q();
        bool1 = false;
        if (bool3)
          bool1 = true;
      }
    }
    return bool1;
  }

  public String u()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.C(), "default");
  }

  public String v()
  {
    return com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.E(), "default");
  }

  public long w()
  {
    String str = com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.F(), "0");
    try
    {
      int i = Integer.parseInt(str);
      return i * 1000;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0L;
  }

  public long x()
  {
    String str = com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.D(), "-1");
    long l1;
    try
    {
      long l2 = Long.parseLong(str);
      l1 = 1024L * (l2 * 1024L);
      if (l1 < 0L)
        return -1L;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        l1 = -1L;
    }
    return l1;
  }

  public int y()
  {
    String str = com.viber.voip.camera.d.a.a(b()).getString(com.viber.voip.camera.d.a.G(), "0");
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0;
  }

  public boolean z()
  {
    return com.viber.voip.camera.d.a.a(b()).getBoolean(com.viber.voip.camera.d.a.H(), false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.a
 * JD-Core Version:    0.6.2
 */