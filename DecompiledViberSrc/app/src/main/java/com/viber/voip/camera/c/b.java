package com.viber.voip.camera.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import com.viber.voip.camera.R.string;
import com.viber.voip.camera.a.a.b;
import com.viber.voip.camera.a.a.c;
import com.viber.voip.camera.a.a.d;
import com.viber.voip.camera.a.a.e;
import com.viber.voip.camera.a.a.f;
import com.viber.voip.camera.a.a.g;
import com.viber.voip.camera.a.a.h;
import com.viber.voip.camera.a.a.i;
import com.viber.voip.camera.a.c;
import com.viber.voip.camera.a.d;
import com.viber.voip.camera.a.e;
import com.viber.voip.camera.activity.ViberCcamActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class b
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener
{
  private static final String h = com.viber.voip.camera.e.a.a(b.class);
  private MediaRecorder A = null;
  private boolean B = false;
  private long C = 0L;
  private int D = 0;
  private Uri E = null;
  private String F = null;
  private int G = 0;
  private Timer H = new Timer();
  private TimerTask I = null;
  private Timer J = new Timer();
  private TimerTask K = null;
  private Timer L = new Timer();
  private TimerTask M = null;
  private Timer N = new Timer();
  private TimerTask O = null;
  private long P = 0L;
  private int Q = 0;
  private int R = 0;
  private boolean S = false;
  private int T = 0;
  private int U = 0;
  private boolean V = false;
  private int W = 0;
  private GestureDetector X = null;
  private ScaleGestureDetector Y = null;
  private List<Integer> Z = null;
  public int a = 0;
  private List<a.h> aA = null;
  private int aB = -1;
  private List<String> aC = null;
  private int aD = -1;
  private List<a.h> aE = null;
  private int aF = 0;
  private boolean aG = false;
  private boolean aH = false;
  private a.e[] aI = null;
  private boolean aJ = false;
  private boolean aK = false;
  private boolean aL = false;
  private int aM = 0;
  private int aN = 0;
  private long aO = -1L;
  private int aP = 3;
  private String aQ = "";
  private boolean aR = false;
  private boolean aS = false;
  private long aT = -1L;
  private float aa = 0.0F;
  private boolean ab = false;
  private float ac = 0.0F;
  private float ad = 0.0F;
  private List<String> ae = null;
  private int af = -1;
  private List<String> ag = null;
  private int ah = -1;
  private int ai = 0;
  private boolean aj = false;
  private boolean ak = false;
  private List<String> al = null;
  private List<String> am = null;
  private List<String> an = null;
  private List<String> ao = null;
  private boolean ap = false;
  private int aq = 0;
  private int ar = 0;
  private boolean as = false;
  private long at = 0L;
  private long au = 0L;
  private List<String> av = null;
  private int aw = 0;
  private int ax = 0;
  private float ay = 0.0F;
  private List<a.h> az = null;
  public int b = 0;
  public int c = 0;
  public boolean d = false;
  public boolean e = false;
  public ViewGroup f;
  public int g = -1;
  private a i = null;
  private com.viber.voip.camera.c.a.a j = null;
  private boolean k = false;
  private int l = 0;
  private int m = 0;
  private boolean n = false;
  private int o = 0;
  private int p = 0;
  private Matrix q = new Matrix();
  private Matrix r = new Matrix();
  private double s = 0.0D;
  private boolean t = true;
  private boolean u = false;
  private boolean v = false;
  private double w = 0.0D;
  private c x = null;
  private com.viber.voip.camera.a.a y = null;
  private boolean z = false;

  public b(a parama, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.i = parama;
    this.j = new com.viber.voip.camera.c.a.b(b(), paramBundle, this);
    this.x = new d();
    this.X = new GestureDetector(b(), new GestureDetector.SimpleOnGestureListener());
    this.X.setOnDoubleTapListener(new d(null));
    this.Y = new ScaleGestureDetector(b(), new h(null));
    this.f = paramViewGroup;
    paramViewGroup.addView(this.j.getView());
  }

  private double a(Point paramPoint)
  {
    double d1;
    if ((this.i.A().equals("preference_preview_size_wysiwyg")) || (this.z))
      if (this.z)
      {
        CamcorderProfile localCamcorderProfile = e();
        d1 = localCamcorderProfile.videoFrameWidth / localCamcorderProfile.videoFrameHeight;
      }
    while (true)
    {
      this.s = d1;
      return d1;
      a.h localh = this.y.i();
      d1 = localh.a / localh.b;
      continue;
      d1 = paramPoint.x / paramPoint.y;
    }
  }

  public static String a(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 * paramInt2 / 1000000.0F;
    return c(f1) + "MP";
  }

  private ArrayList<com.viber.voip.camera.a.a.a> a(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = { paramFloat1, paramFloat2 };
    am();
    this.r.mapPoints(arrayOfFloat);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    Rect localRect = new Rect();
    localRect.left = ((int)f1 - 50);
    localRect.right = (50 + (int)f1);
    localRect.top = ((int)f2 - 50);
    localRect.bottom = (50 + (int)f2);
    if (localRect.left < -1000)
    {
      localRect.left = -1000;
      localRect.right = (100 + localRect.left);
      if (localRect.top >= -1000)
        break label216;
      localRect.top = -1000;
      localRect.bottom = (100 + localRect.top);
    }
    while (true)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new com.viber.voip.camera.a.a.a(localRect, 1000));
      return localArrayList;
      if (localRect.right <= 1000)
        break;
      localRect.right = 1000;
      localRect.left = (-100 + localRect.right);
      break;
      label216: if (localRect.bottom > 1000)
      {
        localRect.bottom = 1000;
        localRect.top = (-100 + localRect.bottom);
      }
    }
  }

  private void a(double paramDouble)
  {
    if (paramDouble <= 0.0D)
      throw new IllegalArgumentException();
    this.v = true;
    if (this.w != paramDouble)
    {
      this.w = paramDouble;
      this.j.getView().requestLayout();
    }
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((this.ae != null) && (paramInt != this.af))
    {
      if (this.af != -1)
        break label84;
      bool2 = bool1;
      this.af = paramInt;
      String str = (String)this.ae.get(this.af);
      f(str);
      if (paramBoolean)
        this.i.a(str);
      if (bool2)
        break label90;
    }
    while (true)
    {
      g(bool1);
      return;
      label84: bool2 = false;
      break;
      label90: bool1 = false;
    }
  }

  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.ag != null) && (paramInt != this.ah))
    {
      this.ah = paramInt;
      String str = (String)this.ag.get(this.ah);
      b(str, paramBoolean3);
      if (paramBoolean2)
        this.i.a(str, this.z);
    }
  }

  private void a(final long paramLong, boolean paramBoolean)
  {
    this.G = 1;
    this.P = (paramLong + System.currentTimeMillis());
    Timer localTimer1 = this.H;
    c localc = new c();
    this.I = localc;
    localTimer1.schedule(localc, paramLong);
    Timer localTimer2 = this.J;
    a locala = new a(paramLong);
    this.K = locala;
    localTimer2.schedule(locala, 0L, 1000L);
  }

  private void a(CamcorderProfile paramCamcorderProfile)
  {
    this.i.a(paramCamcorderProfile);
    this.A.reset();
    this.A.release();
    this.A = null;
    this.G = 0;
    this.i.c(false);
    d(true);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3)
      this.aP = 3;
    while (true)
    {
      if ((paramBoolean1) && (!paramBoolean3) && (paramBoolean2))
      {
        this.aS = true;
        this.aT = this.aO;
      }
      aL();
      if ((this.aH) && (!paramBoolean3) && (this.y != null))
        this.y.z();
      try
      {
        if (this.aR)
        {
          this.aR = false;
          aJ();
        }
        return;
        if (paramBoolean2);
        for (int i1 = 1; ; i1 = 2)
        {
          this.aP = i1;
          this.aO = System.currentTimeMillis();
          break;
        }
      }
      finally
      {
      }
    }
  }

  private void a(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.aE == null)
      return;
    int i1 = 0;
    label11: if (i1 < this.aE.size())
      if (paramArrayOfBoolean[i1] == 0)
        break label38;
    while (true)
    {
      i1++;
      break label11;
      break;
      label38: a.h localh = (a.h)this.aE.get(i1);
      if ((localh.a == paramInt2) && (localh.b == paramInt3))
      {
        String str2 = "" + paramInt1;
        this.aC.add(str2);
        paramArrayOfBoolean[i1] = true;
      }
      else if ((paramInt1 == 0) || (localh.a * localh.b >= paramInt2 * paramInt3))
      {
        String str1 = "" + paramInt1 + "_r" + localh.a + "x" + localh.b;
        this.aC.add(str1);
        paramArrayOfBoolean[i1] = true;
      }
    }
  }

  private boolean a(String paramString, boolean paramBoolean)
  {
    if (this.ae != null)
    {
      int i1 = this.ae.indexOf(paramString);
      if (i1 != -1)
      {
        a(i1, paramBoolean);
        return true;
      }
    }
    return false;
  }

  @TargetApi(21)
  private void aA()
  {
    int i1 = this.y.d();
    SparseArray localSparseArray = new SparseArray();
    if (CamcorderProfile.hasProfile(i1, 1))
    {
      CamcorderProfile localCamcorderProfile9 = CamcorderProfile.get(i1, 1);
      localSparseArray.put(1, new Pair(Integer.valueOf(localCamcorderProfile9.videoFrameWidth), Integer.valueOf(localCamcorderProfile9.videoFrameHeight)));
    }
    if ((Build.VERSION.SDK_INT >= 21) && (CamcorderProfile.hasProfile(i1, 8)))
    {
      CamcorderProfile localCamcorderProfile8 = CamcorderProfile.get(i1, 8);
      localSparseArray.put(8, new Pair(Integer.valueOf(localCamcorderProfile8.videoFrameWidth), Integer.valueOf(localCamcorderProfile8.videoFrameHeight)));
    }
    if (CamcorderProfile.hasProfile(i1, 6))
    {
      CamcorderProfile localCamcorderProfile7 = CamcorderProfile.get(i1, 6);
      localSparseArray.put(6, new Pair(Integer.valueOf(localCamcorderProfile7.videoFrameWidth), Integer.valueOf(localCamcorderProfile7.videoFrameHeight)));
    }
    if (CamcorderProfile.hasProfile(i1, 5))
    {
      CamcorderProfile localCamcorderProfile6 = CamcorderProfile.get(i1, 5);
      localSparseArray.put(5, new Pair(Integer.valueOf(localCamcorderProfile6.videoFrameWidth), Integer.valueOf(localCamcorderProfile6.videoFrameHeight)));
    }
    if (CamcorderProfile.hasProfile(i1, 4))
    {
      CamcorderProfile localCamcorderProfile5 = CamcorderProfile.get(i1, 4);
      localSparseArray.put(4, new Pair(Integer.valueOf(localCamcorderProfile5.videoFrameWidth), Integer.valueOf(localCamcorderProfile5.videoFrameHeight)));
    }
    if (CamcorderProfile.hasProfile(i1, 3))
    {
      CamcorderProfile localCamcorderProfile4 = CamcorderProfile.get(i1, 3);
      localSparseArray.put(3, new Pair(Integer.valueOf(localCamcorderProfile4.videoFrameWidth), Integer.valueOf(localCamcorderProfile4.videoFrameHeight)));
    }
    if (CamcorderProfile.hasProfile(i1, 7))
    {
      CamcorderProfile localCamcorderProfile3 = CamcorderProfile.get(i1, 7);
      localSparseArray.put(7, new Pair(Integer.valueOf(localCamcorderProfile3.videoFrameWidth), Integer.valueOf(localCamcorderProfile3.videoFrameHeight)));
    }
    if (CamcorderProfile.hasProfile(i1, 2))
    {
      CamcorderProfile localCamcorderProfile2 = CamcorderProfile.get(i1, 2);
      localSparseArray.put(2, new Pair(Integer.valueOf(localCamcorderProfile2.videoFrameWidth), Integer.valueOf(localCamcorderProfile2.videoFrameHeight)));
    }
    if (CamcorderProfile.hasProfile(i1, 0))
    {
      CamcorderProfile localCamcorderProfile1 = CamcorderProfile.get(i1, 0);
      localSparseArray.put(0, new Pair(Integer.valueOf(localCamcorderProfile1.videoFrameWidth), Integer.valueOf(localCamcorderProfile1.videoFrameHeight)));
    }
    a(localSparseArray);
  }

  private boolean aB()
  {
    return this.v;
  }

  private double aC()
  {
    return this.w;
  }

  private int aD()
  {
    WindowManager localWindowManager = (WindowManager)b().getSystemService("window");
    Configuration localConfiguration = ak().getConfiguration();
    int i1 = localWindowManager.getDefaultDisplay().getRotation();
    if (((i1 != 0) && (i1 != 2)) || ((localConfiguration.orientation == 2) || (((i1 == 1) || (i1 == 3)) && (localConfiguration.orientation == 1))))
      return 2;
    return 1;
  }

  private int aE()
  {
    String str = this.i.C();
    int i1;
    if (str.equals("landscape"))
    {
      i1 = this.y.B();
      if (aD() == 1)
      {
        if (!this.y.C())
          break label57;
        i1 = (i1 + 90) % 360;
      }
    }
    label57: 
    do
    {
      return i1;
      return (i1 + 270) % 360;
      if (!str.equals("portrait"))
        break;
      i1 = this.y.B();
    }
    while (aD() == 1);
    if (this.y.C())
      return (i1 + 270) % 360;
    return (i1 + 90) % 360;
    return this.U;
  }

  private void aF()
  {
    CamcorderProfile localCamcorderProfile = e();
    List localList = this.y.l();
    if ((localList == null) || (localList.size() == 0))
      return;
    int i1;
    int[] arrayOfInt;
    if (this.z)
      if ((Build.MODEL.equals("Nexus 5")) || (Build.MODEL.equals("Nexus 6")))
      {
        i1 = 1;
        if ((!this.i.v().equals("default")) || (i1 == 0))
          break label110;
        arrayOfInt = b(localList);
      }
    while (true)
    {
      this.y.c(arrayOfInt[0], arrayOfInt[1]);
      return;
      i1 = 0;
      break;
      label110: arrayOfInt = a(localList, 1000 * localCamcorderProfile.videoFrameRate);
      continue;
      arrayOfInt = b(localList);
    }
  }

  private com.viber.voip.camera.b.a aG()
  {
    if ((this.i.b() instanceof com.viber.voip.camera.b.a.a))
      return ((com.viber.voip.camera.b.a.a)this.i.b()).c();
    return null;
  }

  private void aH()
  {
    String str1 = this.y.r();
    if (str1.length() == 0);
    String str2;
    do
    {
      return;
      str2 = j();
    }
    while ((str2 == null) || (str2.equals("flash_torch")));
    if (str1.equals("flash_torch"))
    {
      aK();
      this.y.f(str2);
      return;
    }
    aK();
    this.y.f("flash_torch");
    try
    {
      Thread.sleep(100L);
      label78: aK();
      this.y.f(str2);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label78;
    }
  }

  // ERROR //
  @TargetApi(21)
  private void aI()
  {
    // Byte code:
    //   0: invokestatic 753	com/viber/voip/camera/e/d:a	()Lcom/viber/voip/camera/e/d;
    //   3: astore_1
    //   4: aload_0
    //   5: iconst_2
    //   6: putfield 190	com/viber/voip/camera/c/b:G	I
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 323	com/viber/voip/camera/c/b:aR	Z
    //   14: aload_0
    //   15: getfield 174	com/viber/voip/camera/c/b:y	Lcom/viber/voip/camera/a/a;
    //   18: ifnonnull +19 -> 37
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 190	com/viber/voip/camera/c/b:G	I
    //   26: aload_0
    //   27: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   30: iconst_0
    //   31: invokeinterface 551 2 0
    //   36: return
    //   37: aload_0
    //   38: getfield 166	com/viber/voip/camera/c/b:u	Z
    //   41: ifne +19 -> 60
    //   44: aload_0
    //   45: iconst_0
    //   46: putfield 190	com/viber/voip/camera/c/b:G	I
    //   49: aload_0
    //   50: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   53: iconst_0
    //   54: invokeinterface 551 2 0
    //   59: return
    //   60: aload_0
    //   61: getfield 176	com/viber/voip/camera/c/b:z	Z
    //   64: ifeq +1030 -> 1094
    //   67: aload_0
    //   68: invokevirtual 344	com/viber/voip/camera/c/b:b	()Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   71: astore 5
    //   73: aload 5
    //   75: instanceof 755
    //   78: ifeq +13 -> 91
    //   81: aload 5
    //   83: checkcast 755	com/viber/voip/camera/c/b$f
    //   86: invokeinterface 757 1 0
    //   91: aload_0
    //   92: iconst_3
    //   93: putfield 317	com/viber/voip/camera/c/b:aP	I
    //   96: iconst_0
    //   97: istore 6
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 184	com/viber/voip/camera/c/b:D	I
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 186	com/viber/voip/camera/c/b:E	Landroid/net/Uri;
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 188	com/viber/voip/camera/c/b:F	Ljava/lang/String;
    //   114: aconst_null
    //   115: astore 7
    //   117: aload_0
    //   118: aload_0
    //   119: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   122: invokeinterface 759 1 0
    //   127: putfield 184	com/viber/voip/camera/c/b:D	I
    //   130: aload_0
    //   131: getfield 184	com/viber/voip/camera/c/b:D	I
    //   134: istore 24
    //   136: iconst_0
    //   137: istore 6
    //   139: iload 24
    //   141: ifne +517 -> 658
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   149: invokeinterface 762 1 0
    //   154: invokevirtual 767	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   157: putfield 188	com/viber/voip/camera/c/b:F	Ljava/lang/String;
    //   160: iconst_1
    //   161: istore 6
    //   163: aload 7
    //   165: astore 9
    //   167: iload 6
    //   169: ifeq -133 -> 36
    //   172: aload_0
    //   173: invokevirtual 406	com/viber/voip/camera/c/b:e	()Landroid/media/CamcorderProfile;
    //   176: astore 10
    //   178: aload_0
    //   179: new 543	android/media/MediaRecorder
    //   182: dup
    //   183: invokespecial 768	android/media/MediaRecorder:<init>	()V
    //   186: putfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   189: aload_0
    //   190: getfield 174	com/viber/voip/camera/c/b:y	Lcom/viber/voip/camera/a/a;
    //   193: invokevirtual 770	com/viber/voip/camera/a/a:D	()V
    //   196: aload_0
    //   197: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   200: new 772	com/viber/voip/camera/c/b$7
    //   203: dup
    //   204: aload_0
    //   205: invokespecial 773	com/viber/voip/camera/c/b$7:<init>	(Lcom/viber/voip/camera/c/b;)V
    //   208: invokevirtual 777	android/media/MediaRecorder:setOnInfoListener	(Landroid/media/MediaRecorder$OnInfoListener;)V
    //   211: aload_0
    //   212: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   215: new 779	com/viber/voip/camera/c/b$8
    //   218: dup
    //   219: aload_0
    //   220: invokespecial 780	com/viber/voip/camera/c/b$8:<init>	(Lcom/viber/voip/camera/c/b;)V
    //   223: invokevirtual 784	android/media/MediaRecorder:setOnErrorListener	(Landroid/media/MediaRecorder$OnErrorListener;)V
    //   226: aload_0
    //   227: getfield 174	com/viber/voip/camera/c/b:y	Lcom/viber/voip/camera/a/a;
    //   230: aload_0
    //   231: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   234: invokevirtual 787	com/viber/voip/camera/a/a:a	(Landroid/media/MediaRecorder;)V
    //   237: aload_0
    //   238: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   241: invokeinterface 789 1 0
    //   246: istore 11
    //   248: aload_0
    //   249: invokevirtual 344	com/viber/voip/camera/c/b:b	()Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   252: ldc_w 791
    //   255: invokestatic 797	android/support/v4/content/ContextCompat:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   258: ifeq +1002 -> 1260
    //   261: iconst_0
    //   262: istore 12
    //   264: iload 12
    //   266: ifeq +40 -> 306
    //   269: aload_0
    //   270: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   273: invokeinterface 799 1 0
    //   278: astore 22
    //   280: iconst_5
    //   281: istore 23
    //   283: aload 22
    //   285: ldc_w 801
    //   288: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifeq +468 -> 759
    //   294: iconst_1
    //   295: istore 23
    //   297: aload_0
    //   298: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   301: iload 23
    //   303: invokevirtual 804	android/media/MediaRecorder:setAudioSource	(I)V
    //   306: aload_0
    //   307: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   310: iconst_1
    //   311: invokevirtual 807	android/media/MediaRecorder:setVideoSource	(I)V
    //   314: iload 12
    //   316: ifeq +551 -> 867
    //   319: aload_0
    //   320: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   323: aload 10
    //   325: getfield 810	android/media/CamcorderProfile:fileFormat	I
    //   328: invokevirtual 813	android/media/MediaRecorder:setOutputFormat	(I)V
    //   331: invokestatic 817	com/viber/voip/camera/e/b:a	()Z
    //   334: ifeq +12 -> 346
    //   337: aload_0
    //   338: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   341: bipush 30
    //   343: invokevirtual 820	android/media/MediaRecorder:setVideoFrameRate	(I)V
    //   346: aload_0
    //   347: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   350: aload 10
    //   352: getfield 411	android/media/CamcorderProfile:videoFrameWidth	I
    //   355: aload 10
    //   357: getfield 414	android/media/CamcorderProfile:videoFrameHeight	I
    //   360: invokevirtual 823	android/media/MediaRecorder:setVideoSize	(II)V
    //   363: aload_0
    //   364: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   367: aload 10
    //   369: getfield 826	android/media/CamcorderProfile:videoBitRate	I
    //   372: invokevirtual 829	android/media/MediaRecorder:setVideoEncodingBitRate	(I)V
    //   375: aload_0
    //   376: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   379: iconst_2
    //   380: invokevirtual 832	android/media/MediaRecorder:setVideoEncoder	(I)V
    //   383: aload 10
    //   385: getfield 835	android/media/CamcorderProfile:quality	I
    //   388: sipush 1000
    //   391: if_icmplt +403 -> 794
    //   394: aload 10
    //   396: getfield 835	android/media/CamcorderProfile:quality	I
    //   399: sipush 1007
    //   402: if_icmpgt +392 -> 794
    //   405: aload_0
    //   406: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   409: invokeinterface 837 1 0
    //   414: astore 21
    //   416: aload 21
    //   418: ldc_w 839
    //   421: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   424: ifeq +421 -> 845
    //   427: aload_0
    //   428: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   431: iconst_1
    //   432: invokevirtual 842	android/media/MediaRecorder:setAudioChannels	(I)V
    //   435: aload_0
    //   436: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   439: invokeinterface 844 1 0
    //   444: istore 13
    //   446: aload_0
    //   447: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   450: invokeinterface 846 1 0
    //   455: lstore 14
    //   457: lload 14
    //   459: lconst_0
    //   460: lcmp
    //   461: ifle +45 -> 506
    //   464: iload 13
    //   466: ifne +40 -> 506
    //   469: aload_0
    //   470: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   473: lload 14
    //   475: l2i
    //   476: invokevirtual 849	android/media/MediaRecorder:setMaxDuration	(I)V
    //   479: aload_0
    //   480: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   483: invokeinterface 851 1 0
    //   488: lstore 19
    //   490: lload 19
    //   492: lconst_0
    //   493: lcmp
    //   494: iflt +12 -> 506
    //   497: aload_0
    //   498: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   501: lload 19
    //   503: invokevirtual 854	android/media/MediaRecorder:setMaxFileSize	(J)V
    //   506: aload_0
    //   507: getfield 184	com/viber/voip/camera/c/b:D	I
    //   510: ifne +424 -> 934
    //   513: aload_0
    //   514: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   517: aload_0
    //   518: getfield 188	com/viber/voip/camera/c/b:F	Ljava/lang/String;
    //   521: invokevirtual 857	android/media/MediaRecorder:setOutputFile	(Ljava/lang/String;)V
    //   524: aload_0
    //   525: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   528: iconst_1
    //   529: invokeinterface 551 2 0
    //   534: aload_0
    //   535: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   538: invokeinterface 859 1 0
    //   543: aload_0
    //   544: getfield 141	com/viber/voip/camera/c/b:j	Lcom/viber/voip/camera/c/a/a;
    //   547: aload_0
    //   548: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   551: invokeinterface 862 2 0
    //   556: aload_0
    //   557: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   560: aload_0
    //   561: invokespecial 864	com/viber/voip/camera/c/b:aE	()I
    //   564: invokevirtual 867	android/media/MediaRecorder:setOrientationHint	(I)V
    //   567: aload_0
    //   568: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   571: invokevirtual 870	android/media/MediaRecorder:prepare	()V
    //   574: aload_0
    //   575: getfield 174	com/viber/voip/camera/c/b:y	Lcom/viber/voip/camera/a/a;
    //   578: aload_0
    //   579: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   582: invokevirtual 872	com/viber/voip/camera/a/a:b	(Landroid/media/MediaRecorder;)V
    //   585: aload_0
    //   586: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   589: invokevirtual 875	android/media/MediaRecorder:start	()V
    //   592: aload_0
    //   593: getfield 337	com/viber/voip/camera/c/b:e	Z
    //   596: ifeq +353 -> 949
    //   599: new 746	java/lang/RuntimeException
    //   602: dup
    //   603: invokespecial 876	java/lang/RuntimeException:<init>	()V
    //   606: athrow
    //   607: astore 18
    //   609: aload_0
    //   610: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   613: invokeinterface 878 1 0
    //   618: aload_0
    //   619: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   622: invokevirtual 546	android/media/MediaRecorder:reset	()V
    //   625: aload_0
    //   626: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   629: invokevirtual 549	android/media/MediaRecorder:release	()V
    //   632: aload_0
    //   633: aconst_null
    //   634: putfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   637: aload_0
    //   638: iconst_0
    //   639: putfield 190	com/viber/voip/camera/c/b:G	I
    //   642: aload_0
    //   643: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   646: iconst_0
    //   647: invokeinterface 551 2 0
    //   652: aload_0
    //   653: iconst_1
    //   654: invokespecial 553	com/viber/voip/camera/c/b:d	(Z)V
    //   657: return
    //   658: aload_0
    //   659: getfield 184	com/viber/voip/camera/c/b:D	I
    //   662: istore 25
    //   664: iconst_0
    //   665: istore 6
    //   667: iload 25
    //   669: iconst_1
    //   670: if_icmpne +41 -> 711
    //   673: aload_0
    //   674: aload_0
    //   675: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   678: invokeinterface 881 1 0
    //   683: putfield 186	com/viber/voip/camera/c/b:E	Landroid/net/Uri;
    //   686: iconst_1
    //   687: istore 6
    //   689: aload_0
    //   690: invokevirtual 344	com/viber/voip/camera/c/b:b	()Lcom/viber/voip/camera/activity/ViberCcamActivity;
    //   693: invokevirtual 885	com/viber/voip/camera/activity/ViberCcamActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   696: aload_0
    //   697: getfield 186	com/viber/voip/camera/c/b:E	Landroid/net/Uri;
    //   700: ldc_w 887
    //   703: invokevirtual 893	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   706: astore 7
    //   708: goto -545 -> 163
    //   711: aload_0
    //   712: aload_0
    //   713: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   716: invokeinterface 895 1 0
    //   721: putfield 186	com/viber/voip/camera/c/b:E	Landroid/net/Uri;
    //   724: goto -38 -> 686
    //   727: astore 8
    //   729: aload_0
    //   730: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   733: invokeinterface 878 1 0
    //   738: aload_0
    //   739: iconst_0
    //   740: putfield 190	com/viber/voip/camera/c/b:G	I
    //   743: aload_0
    //   744: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   747: iconst_0
    //   748: invokeinterface 551 2 0
    //   753: aconst_null
    //   754: astore 9
    //   756: goto -589 -> 167
    //   759: aload 22
    //   761: ldc_w 897
    //   764: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   767: ifeq +9 -> 776
    //   770: iconst_0
    //   771: istore 23
    //   773: goto -476 -> 297
    //   776: aload 22
    //   778: ldc_w 899
    //   781: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   784: ifeq -487 -> 297
    //   787: bipush 7
    //   789: istore 23
    //   791: goto -494 -> 297
    //   794: aload_0
    //   795: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   798: aload 10
    //   800: getfield 902	android/media/CamcorderProfile:audioBitRate	I
    //   803: invokevirtual 905	android/media/MediaRecorder:setAudioEncodingBitRate	(I)V
    //   806: aload_0
    //   807: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   810: aload 10
    //   812: getfield 908	android/media/CamcorderProfile:audioChannels	I
    //   815: invokevirtual 842	android/media/MediaRecorder:setAudioChannels	(I)V
    //   818: aload_0
    //   819: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   822: aload 10
    //   824: getfield 911	android/media/CamcorderProfile:audioSampleRate	I
    //   827: invokevirtual 914	android/media/MediaRecorder:setAudioSamplingRate	(I)V
    //   830: aload_0
    //   831: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   834: aload 10
    //   836: getfield 917	android/media/CamcorderProfile:audioCodec	I
    //   839: invokevirtual 920	android/media/MediaRecorder:setAudioEncoder	(I)V
    //   842: goto -437 -> 405
    //   845: aload 21
    //   847: ldc_w 922
    //   850: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   853: ifeq -418 -> 435
    //   856: aload_0
    //   857: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   860: iconst_2
    //   861: invokevirtual 842	android/media/MediaRecorder:setAudioChannels	(I)V
    //   864: goto -429 -> 435
    //   867: aload_0
    //   868: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   871: aload 10
    //   873: getfield 810	android/media/CamcorderProfile:fileFormat	I
    //   876: invokevirtual 813	android/media/MediaRecorder:setOutputFormat	(I)V
    //   879: invokestatic 817	com/viber/voip/camera/e/b:a	()Z
    //   882: ifeq +12 -> 894
    //   885: aload_0
    //   886: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   889: bipush 30
    //   891: invokevirtual 820	android/media/MediaRecorder:setVideoFrameRate	(I)V
    //   894: aload_0
    //   895: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   898: aload 10
    //   900: getfield 411	android/media/CamcorderProfile:videoFrameWidth	I
    //   903: aload 10
    //   905: getfield 414	android/media/CamcorderProfile:videoFrameHeight	I
    //   908: invokevirtual 823	android/media/MediaRecorder:setVideoSize	(II)V
    //   911: aload_0
    //   912: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   915: aload 10
    //   917: getfield 826	android/media/CamcorderProfile:videoBitRate	I
    //   920: invokevirtual 829	android/media/MediaRecorder:setVideoEncodingBitRate	(I)V
    //   923: aload_0
    //   924: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   927: iconst_2
    //   928: invokevirtual 832	android/media/MediaRecorder:setVideoEncoder	(I)V
    //   931: goto -496 -> 435
    //   934: aload_0
    //   935: getfield 178	com/viber/voip/camera/c/b:A	Landroid/media/MediaRecorder;
    //   938: aload 9
    //   940: invokevirtual 928	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   943: invokevirtual 931	android/media/MediaRecorder:setOutputFile	(Ljava/io/FileDescriptor;)V
    //   946: goto -422 -> 524
    //   949: aload_0
    //   950: invokestatic 519	java/lang/System:currentTimeMillis	()J
    //   953: putfield 182	com/viber/voip/camera/c/b:C	J
    //   956: aload_0
    //   957: iconst_1
    //   958: putfield 180	com/viber/voip/camera/c/b:B	Z
    //   961: lload 14
    //   963: lconst_0
    //   964: lcmp
    //   965: ifle +46 -> 1011
    //   968: iload 13
    //   970: ifle +41 -> 1011
    //   973: aload_0
    //   974: getfield 215	com/viber/voip/camera/c/b:R	I
    //   977: ifne +9 -> 986
    //   980: aload_0
    //   981: iload 13
    //   983: putfield 215	com/viber/voip/camera/c/b:R	I
    //   986: aload_0
    //   987: new 933	com/viber/voip/camera/c/b$g
    //   990: dup
    //   991: aload_0
    //   992: invokespecial 934	com/viber/voip/camera/c/b$g:<init>	(Lcom/viber/voip/camera/c/b;)V
    //   995: putfield 205	com/viber/voip/camera/c/b:M	Ljava/util/TimerTask;
    //   998: aload_0
    //   999: getfield 203	com/viber/voip/camera/c/b:L	Ljava/util/Timer;
    //   1002: aload_0
    //   1003: getfield 205	com/viber/voip/camera/c/b:M	Ljava/util/TimerTask;
    //   1006: lload 14
    //   1008: invokevirtual 528	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   1011: aload_0
    //   1012: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   1015: invokeinterface 936 1 0
    //   1020: ifeq +37 -> 1057
    //   1023: aload_0
    //   1024: invokevirtual 938	com/viber/voip/camera/c/b:ae	()Z
    //   1027: ifeq +30 -> 1057
    //   1030: aload_0
    //   1031: new 940	com/viber/voip/camera/c/b$e
    //   1034: dup
    //   1035: aload_0
    //   1036: invokespecial 941	com/viber/voip/camera/c/b$e:<init>	(Lcom/viber/voip/camera/c/b;)V
    //   1039: putfield 209	com/viber/voip/camera/c/b:O	Ljava/util/TimerTask;
    //   1042: aload_0
    //   1043: getfield 207	com/viber/voip/camera/c/b:N	Ljava/util/Timer;
    //   1046: aload_0
    //   1047: getfield 209	com/viber/voip/camera/c/b:O	Ljava/util/TimerTask;
    //   1050: lconst_0
    //   1051: ldc2_w 534
    //   1054: invokevirtual 538	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   1057: aload 5
    //   1059: instanceof 755
    //   1062: ifeq -1026 -> 36
    //   1065: aload 5
    //   1067: checkcast 755	com/viber/voip/camera/c/b$f
    //   1070: invokeinterface 943 1 0
    //   1075: return
    //   1076: astore 17
    //   1078: aload_0
    //   1079: aload 10
    //   1081: invokespecial 944	com/viber/voip/camera/c/b:a	(Landroid/media/CamcorderProfile;)V
    //   1084: return
    //   1085: astore 16
    //   1087: aload_0
    //   1088: aload 10
    //   1090: invokespecial 944	com/viber/voip/camera/c/b:a	(Landroid/media/CamcorderProfile;)V
    //   1093: return
    //   1094: aload_0
    //   1095: getfield 139	com/viber/voip/camera/c/b:i	Lcom/viber/voip/camera/c/a;
    //   1098: iconst_1
    //   1099: invokeinterface 551 2 0
    //   1104: aload_0
    //   1105: getfield 247	com/viber/voip/camera/c/b:ah	I
    //   1108: iconst_m1
    //   1109: if_icmpeq +54 -> 1163
    //   1112: aload_0
    //   1113: getfield 245	com/viber/voip/camera/c/b:ag	Ljava/util/List;
    //   1116: aload_0
    //   1117: getfield 247	com/viber/voip/camera/c/b:ah	I
    //   1120: invokeinterface 497 2 0
    //   1125: checkcast 399	java/lang/String
    //   1128: astore_2
    //   1129: aload_0
    //   1130: getfield 325	com/viber/voip/camera/c/b:aS	Z
    //   1133: ifeq +35 -> 1168
    //   1136: invokestatic 519	java/lang/System:currentTimeMillis	()J
    //   1139: ldc2_w 945
    //   1142: aload_0
    //   1143: getfield 327	com/viber/voip/camera/c/b:aT	J
    //   1146: ladd
    //   1147: lcmp
    //   1148: ifge +20 -> 1168
    //   1151: aload_0
    //   1152: invokespecial 578	com/viber/voip/camera/c/b:aJ	()V
    //   1155: aload_1
    //   1156: getstatic 133	com/viber/voip/camera/c/b:h	Ljava/lang/String;
    //   1159: invokevirtual 947	com/viber/voip/camera/e/d:a	(Ljava/lang/String;)V
    //   1162: return
    //   1163: aconst_null
    //   1164: astore_2
    //   1165: goto -36 -> 1129
    //   1168: aload_2
    //   1169: ifnull +84 -> 1253
    //   1172: aload_2
    //   1173: ldc_w 949
    //   1176: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1179: ifne +13 -> 1192
    //   1182: aload_2
    //   1183: ldc_w 951
    //   1186: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1189: ifeq +64 -> 1253
    //   1192: aload_0
    //   1193: monitorenter
    //   1194: aload_0
    //   1195: getfield 317	com/viber/voip/camera/c/b:aP	I
    //   1198: ifne +18 -> 1216
    //   1201: aload_0
    //   1202: iconst_1
    //   1203: putfield 323	com/viber/voip/camera/c/b:aR	Z
    //   1206: aload_0
    //   1207: monitorexit
    //   1208: goto -53 -> 1155
    //   1211: astore_3
    //   1212: aload_0
    //   1213: monitorexit
    //   1214: aload_3
    //   1215: athrow
    //   1216: aload_0
    //   1217: iconst_3
    //   1218: putfield 317	com/viber/voip/camera/c/b:aP	I
    //   1221: new 953	com/viber/voip/camera/c/b$9
    //   1224: dup
    //   1225: aload_0
    //   1226: invokespecial 954	com/viber/voip/camera/c/b$9:<init>	(Lcom/viber/voip/camera/c/b;)V
    //   1229: astore 4
    //   1231: aload_0
    //   1232: getfield 174	com/viber/voip/camera/c/b:y	Lcom/viber/voip/camera/a/a;
    //   1235: aload 4
    //   1237: invokevirtual 957	com/viber/voip/camera/a/a:a	(Lcom/viber/voip/camera/a/a$b;)V
    //   1240: aload_0
    //   1241: iconst_1
    //   1242: aload_0
    //   1243: getfield 331	com/viber/voip/camera/c/b:b	I
    //   1246: iadd
    //   1247: putfield 331	com/viber/voip/camera/c/b:b	I
    //   1250: goto -44 -> 1206
    //   1253: aload_0
    //   1254: invokespecial 578	com/viber/voip/camera/c/b:aJ	()V
    //   1257: goto -102 -> 1155
    //   1260: iload 11
    //   1262: istore 12
    //   1264: goto -1000 -> 264
    //
    // Exception table:
    //   from	to	target	type
    //   524	607	607	java/io/IOException
    //   949	961	607	java/io/IOException
    //   973	986	607	java/io/IOException
    //   986	1011	607	java/io/IOException
    //   1011	1057	607	java/io/IOException
    //   1057	1075	607	java/io/IOException
    //   117	136	727	java/io/IOException
    //   144	160	727	java/io/IOException
    //   658	664	727	java/io/IOException
    //   673	686	727	java/io/IOException
    //   689	708	727	java/io/IOException
    //   711	724	727	java/io/IOException
    //   524	607	1076	java/lang/RuntimeException
    //   949	961	1076	java/lang/RuntimeException
    //   973	986	1076	java/lang/RuntimeException
    //   986	1011	1076	java/lang/RuntimeException
    //   1011	1057	1076	java/lang/RuntimeException
    //   1057	1075	1076	java/lang/RuntimeException
    //   524	607	1085	com/viber/voip/camera/a/b
    //   949	961	1085	com/viber/voip/camera/a/b
    //   973	986	1085	com/viber/voip/camera/a/b
    //   986	1011	1085	com/viber/voip/camera/a/b
    //   1011	1057	1085	com/viber/voip/camera/a/b
    //   1057	1075	1085	com/viber/voip/camera/a/b
    //   1194	1206	1211	finally
    //   1206	1208	1211	finally
    //   1212	1214	1211	finally
    //   1216	1250	1211	finally
  }

  private void aJ()
  {
    if (this.y == null)
    {
      this.G = 0;
      this.i.c(false);
      return;
    }
    if (!this.u)
    {
      this.G = 0;
      this.i.c(false);
      return;
    }
    String str;
    a.g local10;
    a.d local11;
    ViberCcamActivity localViberCcamActivity;
    if (this.ah != -1)
    {
      str = (String)this.ag.get(this.ah);
      if ((str != null) && (str.equals("focus_mode_locked")) && (this.aP == 0))
        aK();
      this.aP = 3;
      this.aS = false;
      local10 = new a.g()
      {
        public void a(byte[] paramAnonymousArrayOfByte)
        {
          boolean bool = b.d(b.this).a(paramAnonymousArrayOfByte);
          b.a(b.this, false);
          b.b(b.this, 0);
          if ((b.o(b.this) == -1) || (b.o(b.this) > 0))
            if (!b.p(b.this))
              b.this.n();
          long l;
          while (true)
          {
            if ((b.o(b.this) == -1) || (b.o(b.this) > 0))
            {
              if (b.o(b.this) > 0)
                b.q(b.this);
              l = b.d(b.this).J();
              if (l != 0L)
                break;
              b.b(b.this, 2);
              b.d(b.this).c(true);
              b.j(b.this);
            }
            return;
            b.b(b.this, 0);
            if ((b.d(b.this).F()) && (bool))
            {
              if (b.p(b.this))
              {
                b.a(b.this).x();
                b.a(b.this, false);
              }
              b.b(b.this, true);
            }
            else
            {
              if (!b.p(b.this))
                b.this.n();
              b.d(b.this).c(false);
            }
          }
          b.a(b.this, l, true);
        }
      };
      local11 = new a.d()
      {
        public void a()
        {
          b localb = b.this;
          localb.c = (-1 + localb.c);
          b.d(b.this).U();
          b.b(b.this, 0);
          b.this.n();
          b.d(b.this).c(false);
        }
      };
      this.y.e(aE());
      localViberCcamActivity = b();
      if (!(localViberCcamActivity instanceof f))
        break label198;
    }
    label198: for (boolean bool = ((f)localViberCcamActivity).A(); ; bool = this.i.G())
    {
      this.y.c(bool);
      this.y.a(bool, null, local10, local11);
      this.c = (1 + this.c);
      return;
      str = null;
      break;
    }
  }

  private void aK()
  {
    if (this.y != null)
    {
      this.y.z();
      a(false, false, true);
    }
  }

  private void aL()
  {
    if ((this.aQ.length() > 0) && (this.y != null))
    {
      this.y.f(this.aQ);
      this.aQ = "";
    }
  }

  private Resources ak()
  {
    return this.j.getView().getResources();
  }

  private void al()
  {
    if (this.y == null)
      return;
    this.q.reset();
    boolean bool = this.y.C();
    Matrix localMatrix = this.q;
    if (bool);
    for (float f1 = -1.0F; ; f1 = 1.0F)
    {
      localMatrix.setScale(f1, 1.0F);
      this.q.postRotate(this.y.A());
      this.q.postScale(this.j.getView().getWidth() / 2000.0F, this.j.getView().getHeight() / 2000.0F);
      this.q.postTranslate(this.j.getView().getWidth() / 2.0F, this.j.getView().getHeight() / 2.0F);
      return;
    }
  }

  private void am()
  {
    if (this.y == null);
    do
    {
      return;
      al();
    }
    while (this.q.invert(this.r));
  }

  private void an()
  {
    this.u = true;
    e(true);
  }

  private void ao()
  {
    this.u = false;
    as();
  }

  private void ap()
  {
    if (this.y == null)
      return;
    this.i.Y();
  }

  private void aq()
  {
    if ((this.y == null) || (!this.k) || (!this.n))
      return;
    int i1 = f();
    Matrix localMatrix = new Matrix();
    RectF localRectF1 = new RectF(0.0F, 0.0F, this.o, this.p);
    RectF localRectF2 = new RectF(0.0F, 0.0F, this.m, this.l);
    float f1 = localRectF1.centerX();
    float f2 = localRectF1.centerY();
    if ((1 == i1) || (3 == i1))
    {
      localRectF2.offset(f1 - localRectF2.centerX(), f2 - localRectF2.centerY());
      localMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.FILL);
      float f3 = Math.max(this.p / this.m, this.o / this.l);
      localMatrix.postScale(f3, f3, f1, f2);
      localMatrix.postRotate(90 * (i1 - 2), f1, f2);
    }
    this.j.setTransform(localMatrix);
  }

  private void ar()
  {
    if (this.A != null)
    {
      a(true);
      if (this.R > 0)
      {
        if (!this.z)
          break label41;
        aI();
        this.R = (-1 + this.R);
      }
    }
    return;
    label41: this.R = 0;
  }

  private void as()
  {
    this.aL = false;
    this.aP = 3;
    this.aR = false;
    this.aQ = "";
    this.aS = false;
    this.s = 0.0D;
    this.i.X();
    c();
    if (this.y != null)
    {
      if (this.A != null)
        a(false);
      if (this.z)
        c(false);
      if (this.y != null)
      {
        d();
        this.y.a();
        this.y = null;
      }
    }
  }

  private void at()
  {
    e(false);
  }

  private void au()
  {
    this.af = -1;
    if ((this.ae != null) && (this.ae.size() > 1))
    {
      String str = this.i.h();
      if (str.length() > 0)
      {
        if (!a(str, false))
          a(0, true);
        return;
      }
      a("flash_auto", true);
      return;
    }
    this.ae = null;
  }

  private void av()
  {
    String str1 = this.i.j();
    a.i locali1 = this.y.a(str1);
    label268: label367: a.i locali4;
    if (locali1 != null)
    {
      this.am = locali1.a;
      this.i.b(locali1.b);
      a.c localc = this.y.c();
      this.V = localc.a;
      if (this.V)
      {
        this.W = localc.b;
        this.Z = localc.c;
      }
      this.aa = localc.k;
      this.aG = localc.d;
      this.aA = localc.e;
      this.ae = localc.h;
      this.ag = localc.i;
      this.ai = localc.j;
      this.aj = localc.l;
      this.aJ = localc.m;
      this.aK = localc.w;
      this.ap = localc.n;
      this.aq = localc.o;
      this.ar = localc.p;
      this.as = localc.q;
      this.at = localc.r;
      this.au = localc.s;
      this.aw = localc.t;
      this.ax = localc.u;
      this.ay = localc.v;
      this.aE = localc.f;
      this.az = localc.g;
      this.aI = null;
      if (!this.aG)
        break label642;
      this.aH = this.i.q();
      if (this.aH)
        this.y.a(new b());
      if (this.aJ)
      {
        boolean bool = this.i.s();
        this.y.a(bool);
      }
      String str2 = this.i.k();
      a.i locali2 = this.y.b(str2);
      if (locali2 == null)
        break label650;
      this.al = locali2.a;
      this.i.c(locali2.b);
      String str3 = this.i.l();
      a.i locali3 = this.y.c(str3);
      if (locali3 == null)
        break label662;
      this.an = locali3.a;
      this.i.d(locali3.b);
      label417: String str4 = this.i.m();
      locali4 = this.y.d(str4);
      if (locali4 == null)
        break label705;
      this.ao = locali4.a;
      if (locali4.b.equals(this.y.p()))
        break label1472;
    }
    label527: label662: label674: label693: label1466: label1472: for (int i1 = 1; ; i1 = 0)
    {
      this.i.e(locali4.b);
      long l1;
      if (i1 != 0)
      {
        if (!this.as)
          break label693;
        l1 = this.i.O();
        if (l1 >= this.at)
          break label674;
        l1 = this.at;
        this.y.a(l1);
        this.i.b(l1);
      }
      while (true)
      {
        this.av = null;
        if ((this.aw == 0) && (this.ax == 0))
          break label973;
        this.av = new Vector();
        for (int i2 = this.aw; i2 <= this.ax; i2++)
          this.av.add("" + i2);
        this.i.Z();
        break;
        this.aH = false;
        break label268;
        this.i.aa();
        break label367;
        this.i.ab();
        break label417;
        if (l1 <= this.au)
          break label527;
        l1 = this.au;
        break label527;
        this.i.ae();
        continue;
        label705: this.i.ac();
        i1 = 0;
      }
      if (i1 == 0)
      {
        i9 = this.i.n();
        if ((i9 < this.aw) || (i9 > this.ax))
          if ((this.aw >= 0) && (this.ax <= 0))
            break label1466;
      }
      for (int i9 = this.aw; ; i9 = 0)
      {
        this.y.d(i9);
        this.i.c(i9);
        az();
        aA();
        Pair localPair1 = new Pair(Integer.valueOf(-1), Integer.valueOf(-1));
        if ((this.i.o() == null) || (TextUtils.isEmpty(this.i.r())));
        for (Pair localPair2 = aw(); ; localPair2 = localPair1)
        {
          this.aB = -1;
          Pair localPair3 = this.i.o();
          if (localPair3 != null)
          {
            int i6 = ((Integer)localPair3.first).intValue();
            int i7 = ((Integer)localPair3.second).intValue();
            int i8 = 0;
            while (true)
              if ((i8 < this.aA.size()) && (this.aB == -1))
              {
                a.h localh2 = (a.h)this.aA.get(i8);
                if ((localh2.a == i6) && (localh2.b == i7))
                  this.aB = i8;
                i8++;
                continue;
                label973: this.i.ad();
                break;
              }
            if (this.aB != -1);
          }
          if (-1 == this.aB)
            this.aB = ((Integer)localPair2.first).intValue();
          int i5;
          Object localObject1;
          Object localObject2;
          if (this.aB == -1)
          {
            i5 = 0;
            localObject1 = null;
            if (i5 < this.aA.size())
            {
              localObject2 = (a.h)this.aA.get(i5);
              if ((localObject1 != null) && (((a.h)localObject2).a * ((a.h)localObject2).b <= localObject1.a * localObject1.b))
                break label1452;
              this.aB = i5;
            }
          }
          while (true)
          {
            i5++;
            localObject1 = localObject2;
            break;
            if (this.aB != -1)
            {
              a.h localh1 = (a.h)this.aA.get(this.aB);
              this.i.c(localh1.a, localh1.b);
            }
            int i3 = this.i.p();
            this.y.b(i3);
            String str5 = this.i.r();
            if (str5.length() > 0)
            {
              for (int i4 = 0; (i4 < this.aC.size()) && (this.aD == -1); i4++)
                if (((String)this.aC.get(i4)).equals(str5))
                  this.aD = i4;
              if (this.aD != -1);
            }
            if (-1 == this.aD)
              this.aD = ((Integer)localPair2.second).intValue();
            if ((this.aD == -1) && (this.aC.size() > 0))
              this.aD = 0;
            if (this.aD != -1)
              this.i.f((String)this.aC.get(this.aD));
            au();
            this.ah = -1;
            float f1;
            if ((this.ag != null) && (this.ag.size() > 1))
            {
              f(true);
              f1 = this.i.P();
              if (f1 >= 0.0F)
                break label1433;
              f1 = 0.0F;
            }
            while (true)
            {
              this.y.a(f1);
              this.i.a(f1);
              this.ak = false;
              g(false);
              return;
              this.ag = null;
              break;
              if (f1 > this.aa)
                f1 = this.aa;
            }
            localObject2 = localObject1;
          }
        }
      }
    }
  }

  private Pair<Integer, Integer> aw()
  {
    Context localContext = this.i.b();
    if ((localContext instanceof f));
    for (Pair localPair = ((f)localContext).a(this, this.aA, this.aC); ; localPair = null)
    {
      if (localPair != null)
        return localPair;
      return new Pair(Integer.valueOf(-1), Integer.valueOf(-1));
    }
  }

  private void ax()
  {
    if (this.y == null)
      return;
    if (this.S)
      throw new RuntimeException();
    aK();
    a.h localh1;
    if (this.z)
    {
      CamcorderProfile localCamcorderProfile = e();
      double d1 = localCamcorderProfile.videoFrameWidth / localCamcorderProfile.videoFrameHeight;
      localh1 = b(this.aA, d1);
    }
    while (true)
    {
      if (localh1 != null)
        this.y.a(localh1.a, localh1.b);
      if ((this.az == null) || (this.az.size() <= 0))
        break;
      a.h localh2 = a(this.az);
      this.y.b(localh2.a, localh2.b);
      this.k = true;
      this.l = localh2.a;
      this.m = localh2.b;
      a(localh2.a / localh2.b);
      return;
      int i1 = this.aB;
      localh1 = null;
      if (i1 != -1)
        localh1 = (a.h)this.aA.get(this.aB);
    }
  }

  private void ay()
  {
    Collections.sort(this.aE, new Comparator()
    {
      public int a(a.h paramAnonymoush1, a.h paramAnonymoush2)
      {
        return paramAnonymoush2.a * paramAnonymoush2.b - paramAnonymoush1.a * paramAnonymoush1.b;
      }
    });
  }

  private void az()
  {
    if (this.y == null)
      return;
    ay();
  }

  public static String b(int paramInt1, int paramInt2)
  {
    return "(" + d(paramInt1, paramInt2) + ", " + a(paramInt1, paramInt2) + ")";
  }

  private void b(String paramString, boolean paramBoolean)
  {
    if (this.y == null);
    do
    {
      return;
      aK();
      this.y.e(paramString);
      a();
    }
    while ((!paramBoolean) || (paramString.equals("focus_mode_locked")));
    b(false, false);
  }

  private void b(boolean paramBoolean1, final boolean paramBoolean2)
  {
    if (this.y == null);
    do
    {
      do
        return;
      while ((!this.u) || (!this.S) || (((!paramBoolean2) || (!this.z)) && (ah())));
      ViberCcamActivity localViberCcamActivity = b();
      if ((localViberCcamActivity instanceof f))
        ((f)localViberCcamActivity).a(paramBoolean1, paramBoolean2);
      if (this.y.t())
      {
        this.aQ = "";
        String str = this.y.r();
        if ((paramBoolean1) && (str.length() > 0) && (!str.equals("flash_off")) && (!str.equals("flash_torch")))
        {
          this.aQ = str;
          this.y.f("flash_off");
        }
        a.b local2 = new a.b()
        {
          public void a(boolean paramAnonymousBoolean)
          {
            b.a(b.this, paramBoolean2, paramAnonymousBoolean, false);
          }
        };
        this.aP = 0;
        this.aO = -1L;
        this.aS = false;
        this.y.a(local2);
        this.b = (1 + this.b);
        return;
      }
    }
    while (!this.aL);
    this.aP = 1;
    this.aO = System.currentTimeMillis();
  }

  private static int c(int paramInt1, int paramInt2)
  {
    while (paramInt2 > 0)
    {
      int i1 = paramInt1 % paramInt2;
      paramInt1 = paramInt2;
      paramInt2 = i1;
    }
    return paramInt1;
  }

  private static String c(float paramFloat)
  {
    int i1 = (int)paramFloat;
    if (paramFloat == i1)
      return Integer.toString(i1);
    Locale localLocale = Locale.getDefault();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Float.valueOf(paramFloat);
    return String.format(localLocale, "%.2f", arrayOfObject);
  }

  private static String d(int paramInt1, int paramInt2)
  {
    int i1 = c(paramInt1, paramInt2);
    if (i1 > 0)
    {
      paramInt1 /= i1;
      paramInt2 /= i1;
    }
    return paramInt1 + ":" + paramInt2;
  }

  private void d(boolean paramBoolean)
  {
    if (this.y != null);
    try
    {
      this.y.v();
      h(false);
    }
    catch (com.viber.voip.camera.a.b localb)
    {
      try
      {
        while (true)
        {
          b(false, false);
          return;
          localb = localb;
          this.i.V();
          as();
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        this.S = false;
        if (!paramBoolean)
        {
          CamcorderProfile localCamcorderProfile = e();
          this.i.b(localCamcorderProfile);
        }
        this.y.a();
        this.y = null;
        at();
      }
    }
  }

  private void e(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 800) || (paramInt1 == 801))
      a(false);
    this.i.a(paramInt1, paramInt2);
  }

  private void e(boolean paramBoolean)
  {
    this.S = false;
    this.k = false;
    this.l = 0;
    this.m = 0;
    this.aL = false;
    this.aP = 3;
    this.aR = false;
    this.aQ = "";
    this.aS = false;
    this.s = 0.0D;
    this.am = null;
    this.V = false;
    this.W = 0;
    this.aa = 0.0F;
    this.Z = null;
    this.aI = null;
    this.aG = false;
    this.aH = false;
    this.aJ = false;
    this.aK = false;
    this.al = null;
    this.an = null;
    this.ao = null;
    this.ap = false;
    this.aq = 0;
    this.ar = 0;
    this.as = false;
    this.at = 0L;
    this.au = 0L;
    this.av = null;
    this.aw = 0;
    this.ax = 0;
    this.ay = 0.0F;
    this.aA = null;
    this.aB = -1;
    this.aC = null;
    this.aD = -1;
    this.ae = null;
    this.af = -1;
    this.ag = null;
    this.ah = -1;
    this.ai = 0;
    this.i.c(false);
    if (!this.u);
    com.viber.voip.camera.b.a locala;
    do
      while (true)
      {
        return;
        if (!this.t)
          try
          {
            i1 = this.i.g();
            if ((i1 < 0) || (i1 >= this.x.a()))
            {
              this.i.a(0);
              i1 = 0;
            }
            if (this.d)
              throw new com.viber.voip.camera.a.b();
          }
          catch (com.viber.voip.camera.a.b localb)
          {
            int i1;
            this.y = null;
            if (paramBoolean)
              e(R.string.cam_error_notice_unable_to_open_camera);
            if (this.y != null);
            try
            {
              g();
              if (this.y != null)
              {
                new OrientationEventListener(b())
                {
                  public void onOrientationChanged(int paramAnonymousInt)
                  {
                    b.a(b.this, paramAnonymousInt);
                  }
                }
                .enable();
                this.j.setPreviewDisplay(this.y);
                b(false);
              }
              if (this.y != null)
              {
                ViberCcamActivity localViberCcamActivity = b();
                if (!(localViberCcamActivity instanceof f))
                  continue;
                ((f)localViberCcamActivity).H();
                return;
                this.y = new e(i1);
              }
            }
            catch (RuntimeException localRuntimeException)
            {
              while (true)
              {
                this.y = null;
                if (paramBoolean)
                  e(R.string.cam_error_notice_unable_to_open_camera);
              }
              locala = aG();
            }
          }
      }
    while (locala == null);
    locala.a("", false);
  }

  private void f(int paramInt)
  {
    if (paramInt == -1);
    while (true)
    {
      return;
      if (this.y != null)
      {
        int i1 = 90 * ((paramInt + 45) / 90);
        this.T = (i1 % 360);
        int i2 = this.y.B();
        if (this.y.C());
        for (int i3 = (360 + (i2 - i1)) % 360; i3 != this.U; i3 = (i1 + i2) % 360)
        {
          this.U = i3;
          return;
        }
      }
    }
  }

  private void f(int paramInt1, int paramInt2)
  {
    a(false);
    this.i.b(paramInt1, paramInt2);
  }

  private void f(boolean paramBoolean)
  {
    String str1 = this.i.a(this.z);
    if (str1.length() > 0)
    {
      if (!a(str1, true, false, paramBoolean))
        a(0, true, true, paramBoolean);
      return;
    }
    if (this.z);
    for (String str2 = "focus_mode_continuous_video"; ; str2 = "focus_mode_auto")
    {
      a(str2, true, true, paramBoolean);
      return;
    }
  }

  private boolean f(String paramString)
  {
    this.aQ = "";
    if (this.y == null)
      return false;
    aK();
    this.y.f(paramString);
    return true;
  }

  private void g(boolean paramBoolean)
  {
    com.viber.voip.camera.b.a locala = aG();
    if (locala != null)
      locala.a(paramBoolean);
  }

  private void h(boolean paramBoolean)
  {
    this.i.b(paramBoolean);
    if (paramBoolean)
    {
      this.G = 3;
      return;
    }
    this.G = 0;
    this.i.c(false);
  }

  public int A()
  {
    return this.ar;
  }

  public float B()
  {
    return this.aa;
  }

  public boolean C()
  {
    return this.as;
  }

  public long D()
  {
    return this.at;
  }

  public long E()
  {
    return this.au;
  }

  public boolean F()
  {
    return this.av != null;
  }

  public int G()
  {
    return this.aw;
  }

  public int H()
  {
    return this.ax;
  }

  public int I()
  {
    if (this.y == null)
      return 0;
    return this.y.k();
  }

  public List<a.h> J()
  {
    return this.az;
  }

  public a.h K()
  {
    return new a.h(this.l, this.m);
  }

  public List<a.h> L()
  {
    return this.aA;
  }

  public int M()
  {
    return this.aB;
  }

  public a.h N()
  {
    if ((this.aB == -1) || (this.aA == null))
      return null;
    return (a.h)this.aA.get(this.aB);
  }

  public List<String> O()
  {
    return this.aC;
  }

  public int P()
  {
    return this.aD;
  }

  public String Q()
  {
    if (this.aD == -1)
      return null;
    return (String)this.aC.get(this.aD);
  }

  public List<a.h> R()
  {
    return this.aE;
  }

  public List<String> S()
  {
    return this.ae;
  }

  public List<String> T()
  {
    return this.ag;
  }

  public int U()
  {
    if (this.y == null)
      return 0;
    return this.y.d();
  }

  public String V()
  {
    if (this.y == null)
      return "None";
    return this.y.b();
  }

  public void W()
  {
    this.t = false;
    at();
  }

  public void X()
  {
    this.t = true;
    as();
  }

  public boolean Y()
  {
    return this.z;
  }

  public boolean Z()
  {
    return (this.A != null) && (this.B);
  }

  public CamcorderProfile a(String paramString)
  {
    if (this.y == null)
    {
      localCamcorderProfile = CamcorderProfile.get(0, 1);
      return localCamcorderProfile;
    }
    int i1 = this.y.d();
    CamcorderProfile localCamcorderProfile = CamcorderProfile.get(i1, 1);
    while (true)
    {
      try
      {
        int i2 = paramString.indexOf('_');
        if (i2 != -1)
        {
          str1 = paramString.substring(0, i2);
          localCamcorderProfile = CamcorderProfile.get(i1, Integer.parseInt(str1));
          if ((i2 == -1) || (i2 + 1 >= paramString.length()))
            break;
          String str2 = paramString.substring(i2 + 1);
          if ((str2.charAt(0) != 'r') || (str2.length() < 4))
            break;
          int i3 = str2.indexOf('x');
          if (i3 == -1)
            break;
          String str3 = str2.substring(1, i3);
          String str4 = str2.substring(i3 + 1);
          int i4 = Integer.parseInt(str3);
          int i5 = Integer.parseInt(str4);
          localCamcorderProfile.videoFrameWidth = i4;
          localCamcorderProfile.videoFrameHeight = i5;
          return localCamcorderProfile;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return localCamcorderProfile;
      }
      String str1 = paramString;
    }
  }

  public a.h a(List<a.h> paramList)
  {
    Object localObject1 = null;
    if (paramList == null)
      return localObject1;
    double d1 = 1.7976931348623157E+308D;
    Point localPoint = new Point();
    b().getWindowManager().getDefaultDisplay().getSize(localPoint);
    double d2 = a(localPoint);
    int i1 = Math.min(localPoint.y, localPoint.x);
    if (i1 <= 0);
    for (int i2 = localPoint.y; ; i2 = i1)
    {
      Iterator localIterator = paramList.iterator();
      label81: Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (a.h)localIterator.next();
        if (Math.abs(((a.h)localObject2).a / ((a.h)localObject2).b - d2) <= 0.05D)
        {
          if (Math.abs(((a.h)localObject2).b - i2) >= d1)
            break label177;
          d1 = Math.abs(((a.h)localObject2).b - i2);
        }
      }
      while (true)
      {
        localObject1 = localObject2;
        break label81;
        if (localObject1 != null)
          break;
        return a(paramList, d2);
        label177: localObject2 = localObject1;
      }
    }
  }

  public a.h a(List<a.h> paramList, double paramDouble)
  {
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    double d6;
    Object localObject2;
    if (localIterator.hasNext())
    {
      a.h localh = (a.h)localIterator.next();
      double d2 = localh.a / localh.b;
      if (Math.abs(d2 - paramDouble) >= d1)
        break label101;
      d6 = Math.abs(d2 - paramDouble);
      localObject2 = localh;
    }
    label101: double d3;
    for (double d4 = d6; ; d4 = d3)
    {
      double d5 = d4;
      localObject1 = localObject2;
      d1 = d5;
      break;
      return localObject1;
      d3 = d1;
      localObject2 = localObject1;
    }
  }

  public void a()
  {
    if (this.y == null)
      return;
    aK();
    this.y.s();
    this.aL = false;
    this.aP = 3;
    this.aS = false;
  }

  public void a(float paramFloat)
  {
    int i1;
    float f1;
    int i2;
    if ((this.y != null) && (this.V))
    {
      i1 = this.y.j();
      f1 = paramFloat * (((Integer)this.Z.get(i1)).intValue() / 100.0F);
      if (f1 > 1.0F)
        break label73;
      i2 = 0;
    }
    while (true)
    {
      a(i2);
      this.i.b(i2);
      return;
      label73: if (f1 >= ((Integer)this.Z.get(this.W)).intValue() / 100.0F)
      {
        i2 = this.W;
      }
      else
      {
        if (paramFloat > 1.0F)
          for (i2 = i1; ; i2++)
          {
            if (i2 >= this.Z.size())
              break label208;
            if (((Integer)this.Z.get(i2)).intValue() / 100.0F >= f1)
              break;
          }
        for (i2 = i1; ; i2--)
        {
          if (i2 < 0)
            break label208;
          if (((Integer)this.Z.get(i2)).intValue() / 100.0F <= f1)
            break;
        }
        label208: i2 = i1;
      }
    }
  }

  public void a(int paramInt)
  {
    if ((this.y == null) || (!this.V))
      return;
    if (paramInt < 0)
      paramInt = 0;
    while (true)
    {
      if (this.g < 0)
        this.g = this.y.j();
      if (paramInt == this.g)
        break;
      this.g = paramInt;
      this.y.c(paramInt);
      this.i.d(paramInt);
      a();
      return;
      if (paramInt > this.W)
        paramInt = this.W;
    }
  }

  public void a(long paramLong)
  {
    if ((this.y != null) && (this.as))
    {
      if (paramLong >= this.at)
        break label50;
      paramLong = this.at;
    }
    while (true)
    {
      if (this.y.a(paramLong))
        this.i.b(paramLong);
      return;
      label50: if (paramLong > this.au)
        paramLong = this.au;
    }
  }

  public void a(Canvas paramCanvas)
  {
    if (this.t)
      return;
    if ((this.aP != 3) && (this.aO != -1L) && (System.currentTimeMillis() > 1000L + this.aO))
      this.aP = 3;
    this.i.a(paramCanvas);
  }

  public void a(Bundle paramBundle)
  {
  }

  public void a(SparseArray<Pair<Integer, Integer>> paramSparseArray)
  {
    this.aC = new Vector();
    boolean[] arrayOfBoolean2;
    if (this.aE != null)
    {
      arrayOfBoolean2 = new boolean[this.aE.size()];
      for (int i1 = 0; i1 < this.aE.size(); i1++)
        arrayOfBoolean2[i1] = false;
    }
    for (boolean[] arrayOfBoolean1 = arrayOfBoolean2; ; arrayOfBoolean1 = null)
    {
      if (paramSparseArray.get(1) != null)
      {
        Pair localPair8 = (Pair)paramSparseArray.get(1);
        a(arrayOfBoolean1, 1, ((Integer)localPair8.first).intValue(), ((Integer)localPair8.second).intValue());
      }
      if (paramSparseArray.get(6) != null)
      {
        Pair localPair7 = (Pair)paramSparseArray.get(6);
        a(arrayOfBoolean1, 6, ((Integer)localPair7.first).intValue(), ((Integer)localPair7.second).intValue());
      }
      if (paramSparseArray.get(5) != null)
      {
        Pair localPair6 = (Pair)paramSparseArray.get(5);
        a(arrayOfBoolean1, 5, ((Integer)localPair6.first).intValue(), ((Integer)localPair6.second).intValue());
      }
      if (paramSparseArray.get(4) != null)
      {
        Pair localPair5 = (Pair)paramSparseArray.get(4);
        a(arrayOfBoolean1, 4, ((Integer)localPair5.first).intValue(), ((Integer)localPair5.second).intValue());
      }
      if (paramSparseArray.get(3) != null)
      {
        Pair localPair4 = (Pair)paramSparseArray.get(3);
        a(arrayOfBoolean1, 3, ((Integer)localPair4.first).intValue(), ((Integer)localPair4.second).intValue());
      }
      if (paramSparseArray.get(7) != null)
      {
        Pair localPair3 = (Pair)paramSparseArray.get(7);
        a(arrayOfBoolean1, 7, ((Integer)localPair3.first).intValue(), ((Integer)localPair3.second).intValue());
      }
      if (paramSparseArray.get(2) != null)
      {
        Pair localPair2 = (Pair)paramSparseArray.get(2);
        a(arrayOfBoolean1, 2, ((Integer)localPair2.first).intValue(), ((Integer)localPair2.second).intValue());
      }
      if (paramSparseArray.get(0) != null)
      {
        Pair localPair1 = (Pair)paramSparseArray.get(0);
        a(arrayOfBoolean1, 0, ((Integer)localPair1.first).intValue(), ((Integer)localPair1.second).intValue());
      }
      return;
    }
  }

  @TargetApi(21)
  public void a(boolean paramBoolean)
  {
    if (this.A == null);
    do
    {
      return;
      this.i.S();
      if (this.M != null)
      {
        this.M.cancel();
        this.M = null;
      }
      if (this.O != null)
      {
        this.O.cancel();
        this.O = null;
      }
      if (!paramBoolean)
        this.R = 0;
    }
    while (this.A == null);
    this.G = 0;
    try
    {
      this.A.setOnErrorListener(null);
      this.A.setOnInfoListener(null);
      this.A.stop();
      this.A.reset();
      this.A.release();
      this.A = null;
      d(false);
      ViberCcamActivity localViberCcamActivity = b();
      if ((localViberCcamActivity instanceof f))
        ((f)localViberCcamActivity).c(this.F);
      this.i.a(this.D, this.E, this.F);
      this.D = 0;
      this.E = null;
      this.F = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.D != 1)
        break label295;
    }
    if (this.E != null);
    while (true)
    {
      try
      {
        DocumentsContract.deleteDocument(b().getContentResolver(), this.E);
        this.D = 0;
        this.E = null;
        this.F = null;
        if ((this.B) && (System.currentTimeMillis() - this.C <= 2000L))
          break;
        CamcorderProfile localCamcorderProfile = e();
        this.i.b(localCamcorderProfile);
      }
      catch (Exception localException)
      {
        Log.e(h, "deleteDocument", localException);
        continue;
      }
      label295: if ((this.D == 0) && (this.F != null))
      {
        File localFile = new File(this.F);
        if (localFile != null)
          localFile.delete();
      }
    }
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.y == null)
      return;
    boolean bool = this.z;
    if (this.z)
    {
      if (this.A != null)
        a(false);
      this.z = false;
    }
    while (true)
    {
      if (this.z != bool)
      {
        f(false);
        c(false);
        if (paramBoolean1)
          this.i.d(this.z);
        if (paramBoolean2)
        {
          if (this.S)
          {
            this.y.x();
            this.S = false;
          }
          ax();
          n();
        }
      }
      g(false);
      return;
      if (ai())
      {
        c();
        this.z = true;
      }
      else if (this.G != 2)
      {
        this.z = true;
      }
    }
  }

  public void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (!aB())
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt2;
      return;
    }
    double d1 = aC();
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int i3 = this.j.getView().getPaddingLeft() + this.j.getView().getPaddingRight();
    int i4 = this.j.getView().getPaddingTop() + this.j.getView().getPaddingBottom();
    int i5 = i1 - i3;
    int i6 = i2 - i4;
    int i7;
    int i8;
    if (i5 > i6)
    {
      i7 = 1;
      if (i7 == 0)
        break label196;
      i8 = i5;
      label121: if (i7 == 0)
        break label203;
      label126: if (i8 <= d1 * i6)
        break label210;
      i8 = (int)(d1 * i6);
      label148: if (i7 == 0)
        break label222;
    }
    while (true)
    {
      int i10 = i8 + i3;
      int i11 = i6 + i4;
      paramArrayOfInt[0] = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
      paramArrayOfInt[1] = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
      return;
      i7 = 0;
      break;
      label196: i8 = i6;
      break label121;
      label203: i6 = i5;
      break label126;
      label210: i6 = (int)(i8 / d1);
      break label148;
      label222: int i9 = i8;
      i8 = i6;
      i6 = i9;
    }
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    if (Z())
      return false;
    ViberCcamActivity localViberCcamActivity = b();
    if ((localViberCcamActivity instanceof f))
      ((f)localViberCcamActivity).a(paramMotionEvent);
    if (this.X.onTouchEvent(paramMotionEvent))
      return true;
    this.Y.onTouchEvent(paramMotionEvent);
    if (this.y == null)
    {
      at();
      return true;
    }
    this.i.a(paramMotionEvent);
    if (paramMotionEvent.getPointerCount() != 1)
    {
      this.ab = true;
      return true;
    }
    if (paramMotionEvent.getAction() != 1)
    {
      if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getPointerCount() == 1))
      {
        this.ab = false;
        if (paramMotionEvent.getAction() == 0)
        {
          this.ac = paramMotionEvent.getX();
          this.ad = paramMotionEvent.getY();
        }
      }
      return true;
    }
    if (this.ab)
      return true;
    if ((!this.z) && (ah()))
      return true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = f1 - this.ac;
    float f4 = f2 - this.ad;
    float f5 = f3 * f3 + f4 * f4;
    float f6 = 0.5F + 31.0F * ak().getDisplayMetrics().density;
    if (f5 > f6 * f6)
      return true;
    if (!this.z)
      n();
    aK();
    if ((this.y != null) && (!this.aH))
    {
      this.aL = false;
      ArrayList localArrayList = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.y.a(localArrayList))
      {
        this.aL = true;
        this.aM = ((int)paramMotionEvent.getX());
        this.aN = ((int)paramMotionEvent.getY());
      }
    }
    if ((!this.z) && (this.i.D()))
    {
      l();
      return true;
    }
    b(false, true);
    return true;
  }

  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.G == 2)
      return false;
    return a(paramString, paramBoolean1, true, paramBoolean2);
  }

  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.ag != null)
    {
      int i1 = this.ag.indexOf(paramString);
      if (i1 != -1)
      {
        a(i1, paramBoolean1, paramBoolean2, paramBoolean3);
        return true;
      }
    }
    return false;
  }

  public int[] a(List<int[]> paramList, int paramInt)
  {
    Iterator localIterator1 = paramList.iterator();
    int i1 = -1;
    int i2 = -1;
    int i3 = -1;
    int i15;
    int i17;
    int i18;
    if (localIterator1.hasNext())
    {
      int[] arrayOfInt2 = (int[])localIterator1.next();
      i15 = arrayOfInt2[0];
      int i16 = arrayOfInt2[1];
      if ((i15 > paramInt) || (i16 < paramInt))
        break label295;
      i17 = i16 - i15;
      if ((i1 != -1) && (i17 >= i1))
        break label295;
      i18 = i16;
    }
    for (int i19 = i15; ; i19 = i3)
    {
      i3 = i19;
      i2 = i18;
      i1 = i17;
      break;
      if (i3 != -1);
      while (true)
      {
        return new int[] { i3, i2 };
        Iterator localIterator2 = paramList.iterator();
        int i4 = -1;
        int i5 = i3;
        int i6 = i2;
        int i7 = -1;
        if (localIterator2.hasNext())
        {
          int[] arrayOfInt1 = (int[])localIterator2.next();
          int i8 = arrayOfInt1[0];
          int i9 = arrayOfInt1[1];
          int i10 = i9 - i8;
          int i11;
          label198: int i12;
          int i13;
          if (i9 < paramInt)
          {
            i11 = paramInt - i9;
            if ((i4 != -1) && (i11 >= i4) && ((i11 != i4) || (i10 >= i7)))
              break label265;
            i12 = i10;
            i13 = i9;
          }
          for (int i14 = i8; ; i14 = i5)
          {
            i5 = i14;
            i6 = i13;
            i7 = i12;
            i4 = i11;
            break;
            i11 = i8 - paramInt;
            break label198;
            label265: i11 = i4;
            i12 = i7;
            i13 = i6;
          }
        }
        i2 = i6;
        i3 = i5;
      }
      label295: i17 = i1;
      i18 = i2;
    }
  }

  public long aa()
  {
    return System.currentTimeMillis() - this.C;
  }

  public boolean ab()
  {
    return this.G == 2;
  }

  public com.viber.voip.camera.a.a ac()
  {
    return this.y;
  }

  public c ad()
  {
    return this.x;
  }

  public boolean ae()
  {
    return this.ae != null;
  }

  public boolean af()
  {
    return this.V;
  }

  public int ag()
  {
    return this.W;
  }

  public boolean ah()
  {
    return (this.G == 2) || (this.G == 1);
  }

  public boolean ai()
  {
    return this.G == 1;
  }

  public boolean aj()
  {
    return this.aP == 0;
  }

  public a.h b(List<a.h> paramList, double paramDouble)
  {
    Object localObject1 = null;
    if (paramList == null)
      return localObject1;
    Iterator localIterator = paramList.iterator();
    label18: Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (a.h)localIterator.next();
      if (Math.abs(((a.h)localObject2).a / ((a.h)localObject2).b - paramDouble) <= 0.05D)
        if ((localObject1 != null) && (((a.h)localObject2).a * ((a.h)localObject2).b <= ((a.h)localObject1).a * ((a.h)localObject1).b))
          break label114;
    }
    while (true)
    {
      localObject1 = localObject2;
      break label18;
      if (localObject1 != null)
        break;
      return a(paramList, paramDouble);
      label114: localObject2 = localObject1;
    }
  }

  public ViberCcamActivity b()
  {
    return (ViberCcamActivity)this.i.b();
  }

  public String b(String paramString)
  {
    if (this.y == null)
      return "";
    CamcorderProfile localCamcorderProfile = a(paramString);
    return localCamcorderProfile.videoFrameWidth + "x" + localCamcorderProfile.videoFrameHeight + " " + a(localCamcorderProfile.videoFrameWidth, localCamcorderProfile.videoFrameHeight);
  }

  public void b(float paramFloat)
  {
    if (this.y != null)
    {
      if (paramFloat >= 0.0F)
        break label37;
      paramFloat = 0.0F;
    }
    while (true)
    {
      if (this.y.a(paramFloat))
        this.i.a(paramFloat);
      return;
      label37: if (paramFloat > this.aa)
        paramFloat = this.aa;
    }
  }

  public void b(int paramInt)
  {
    if ((this.y != null) && ((this.aw != 0) || (this.ax != 0)))
    {
      aK();
      if (paramInt >= this.aw)
        break label60;
      paramInt = this.aw;
    }
    while (true)
    {
      if (this.y.d(paramInt))
        this.i.c(paramInt);
      return;
      label60: if (paramInt > this.ax)
        paramInt = this.ax;
    }
  }

  public void b(boolean paramBoolean)
  {
    if (this.y == null);
    do
    {
      return;
      if (this.z)
        c(false);
      av();
      if (this.i.i() != this.z)
        a(false, false);
      ax();
      n();
      if ((this.V) && (this.i.N() != 0))
        a(this.i.N());
      if (paramBoolean)
      {
        if (this.z)
          a(true, true);
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            b.e(b.this);
          }
        }
        , 500L);
      }
      this.i.Q();
    }
    while (paramBoolean);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        b.a(b.this, true, false);
      }
    }
    , 500L);
  }

  public int[] b(List<int[]> paramList)
  {
    Iterator localIterator1 = paramList.iterator();
    int i1 = -1;
    int i2 = -1;
    int i11;
    int i12;
    int i13;
    if (localIterator1.hasNext())
    {
      int[] arrayOfInt2 = (int[])localIterator1.next();
      i11 = arrayOfInt2[0];
      i12 = arrayOfInt2[1];
      if (i12 < 30000)
        break label263;
      if ((i2 == -1) || (i11 < i2))
        i13 = i11;
    }
    while (true)
    {
      i2 = i13;
      i1 = i12;
      break;
      if ((i11 == i2) && (i12 > i1))
      {
        i13 = i11;
        continue;
        if (i2 != -1);
        while (true)
        {
          return new int[] { i2, i1 };
          Iterator localIterator2 = paramList.iterator();
          int i3 = i2;
          int i4 = i1;
          int i5 = -1;
          if (localIterator2.hasNext())
          {
            int[] arrayOfInt1 = (int[])localIterator2.next();
            int i6 = arrayOfInt1[0];
            int i7 = arrayOfInt1[1];
            int i8 = i7 - i6;
            int i9;
            int i10;
            if ((i5 == -1) || (i8 > i5))
            {
              i9 = i7;
              i10 = i6;
            }
            while (true)
            {
              i3 = i10;
              i4 = i9;
              i5 = i8;
              break;
              if ((i8 == i5) && (i7 > i4))
              {
                i9 = i7;
                i10 = i6;
              }
              else
              {
                i8 = i5;
                i9 = i4;
                i10 = i3;
              }
            }
          }
          i1 = i4;
          i2 = i3;
        }
      }
      else
      {
        label263: i12 = i1;
        i13 = i2;
      }
    }
  }

  public String c(String paramString)
  {
    if (this.y == null)
      return "";
    CamcorderProfile localCamcorderProfile = a(paramString);
    String str1 = "";
    if (localCamcorderProfile.quality == 1)
      str1 = "Highest: ";
    String str2 = "";
    if ((localCamcorderProfile.videoFrameWidth == 3840) && (localCamcorderProfile.videoFrameHeight == 2160))
      str2 = "4K Ultra HD ";
    while (true)
    {
      return str1 + str2 + localCamcorderProfile.videoFrameWidth + "x" + localCamcorderProfile.videoFrameHeight + " " + b(localCamcorderProfile.videoFrameWidth, localCamcorderProfile.videoFrameHeight);
      if ((localCamcorderProfile.videoFrameWidth == 1920) && (localCamcorderProfile.videoFrameHeight == 1080))
        str2 = "Full HD ";
      else if ((localCamcorderProfile.videoFrameWidth == 1280) && (localCamcorderProfile.videoFrameHeight == 720))
        str2 = "HD ";
      else if ((localCamcorderProfile.videoFrameWidth == 720) && (localCamcorderProfile.videoFrameHeight == 480))
        str2 = "SD ";
      else if ((localCamcorderProfile.videoFrameWidth == 640) && (localCamcorderProfile.videoFrameHeight == 480))
        str2 = "VGA ";
      else if ((localCamcorderProfile.videoFrameWidth == 352) && (localCamcorderProfile.videoFrameHeight == 288))
        str2 = "CIF ";
      else if ((localCamcorderProfile.videoFrameWidth == 320) && (localCamcorderProfile.videoFrameHeight == 240))
        str2 = "QVGA ";
      else if ((localCamcorderProfile.videoFrameWidth == 176) && (localCamcorderProfile.videoFrameHeight == 144))
        str2 = "QCIF ";
    }
  }

  public void c()
  {
    if (ai())
    {
      this.I.cancel();
      this.I = null;
      if (this.K != null)
      {
        this.K.cancel();
        this.K = null;
      }
      this.G = 0;
    }
  }

  public void c(int paramInt)
  {
    if ((this.y != null) && (this.ap))
    {
      if (paramInt >= this.aq)
        break label68;
      paramInt = this.aq;
    }
    while (true)
    {
      if (this.y.a(paramInt))
        this.i.e("" + paramInt);
      return;
      label68: if (paramInt > this.ar)
        paramInt = this.ar;
    }
  }

  public void c(boolean paramBoolean)
  {
    if ((this.ag != null) && (this.y != null) && (this.z) && (i() != this.z))
      if (!this.z)
        break label53;
    label53: for (String str = "focus_mode_continuous_video"; ; str = "focus_mode_auto")
    {
      a(str, true, true, paramBoolean);
      return;
    }
  }

  public void d()
  {
    if (this.y == null)
      return;
    if (this.z)
      c(false);
    h(false);
    this.y.x();
    this.G = 0;
    this.S = false;
    this.i.c(false);
  }

  public void d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.x.a()))
      paramInt = 0;
    if (h())
    {
      as();
      this.i.a(paramInt);
      at();
    }
  }

  public boolean d(String paramString)
  {
    if ((this.G == 2) && (!this.z))
      return false;
    return a(paramString, true);
  }

  public CamcorderProfile e()
  {
    CamcorderProfile localCamcorderProfile;
    if (this.y == null)
      localCamcorderProfile = CamcorderProfile.get(0, 1);
    while (true)
    {
      return localCamcorderProfile;
      int i1 = this.y.d();
      label69: String str1;
      if (this.i.t())
      {
        localCamcorderProfile = CamcorderProfile.get(i1, 1);
        localCamcorderProfile.videoFrameWidth = 3840;
        localCamcorderProfile.videoFrameHeight = 2160;
        localCamcorderProfile.videoBitRate = ((int)(2.8D * localCamcorderProfile.videoBitRate));
        str1 = this.i.u();
        if (str1.equals("default"));
      }
      try
      {
        localCamcorderProfile.videoBitRate = Integer.parseInt(str1);
        label97: String str2 = this.i.v();
        if (str2.equals("default"))
          continue;
        try
        {
          localCamcorderProfile.videoFrameRate = Integer.parseInt(str2);
          return localCamcorderProfile;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          return localCamcorderProfile;
        }
        if (this.aD != -1)
        {
          localCamcorderProfile = a((String)this.aC.get(this.aD));
          break label69;
        }
        localCamcorderProfile = CamcorderProfile.get(i1, 1);
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        break label97;
      }
    }
  }

  public void e(int paramInt)
  {
    ViberCcamActivity localViberCcamActivity = b();
    if (localViberCcamActivity != null)
      e(localViberCcamActivity.getResources().getString(paramInt));
  }

  public void e(final String paramString)
  {
    final ViberCcamActivity localViberCcamActivity = b();
    if (localViberCcamActivity != null)
      localViberCcamActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Toast.makeText(localViberCcamActivity, paramString, 0).show();
        }
      });
  }

  public int f()
  {
    int i1 = b().getWindowManager().getDefaultDisplay().getRotation();
    if (this.i.B().equals("180"));
    switch (i1)
    {
    default:
      return i1;
    case 0:
      return 2;
    case 1:
      return 3;
    case 2:
      return 0;
    case 3:
    }
    return 1;
  }

  public void g()
  {
    if (this.y == null)
      return;
    int i1 = f();
    int i2 = 0;
    switch (i1)
    {
    case 0:
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      this.y.f(i2);
      return;
      i2 = 90;
      continue;
      i2 = 180;
      continue;
      i2 = 270;
    }
  }

  public boolean h()
  {
    if (this.G == 2);
    while (this.x.a() == 0)
      return false;
    return true;
  }

  public boolean i()
  {
    return (this.y != null) && (this.y.u());
  }

  public String j()
  {
    if (this.af == -1)
      return null;
    return (String)this.ae.get(this.af);
  }

  public String k()
  {
    if (this.y == null);
    while ((this.ag == null) || (this.ah == -1))
      return null;
    return (String)this.ag.get(this.ah);
  }

  public void l()
  {
    if (this.y == null)
      this.G = 0;
    do
    {
      do
      {
        return;
        if (!this.u)
        {
          this.G = 0;
          return;
        }
        if (ai())
        {
          c();
          return;
        }
        if (this.G != 2)
          break label94;
        if (!this.z)
          break;
      }
      while ((!this.B) || (System.currentTimeMillis() - this.C < 500L));
      a(false);
      return;
    }
    while (this.Q == 0);
    this.Q = 0;
    return;
    label94: n();
    long l1 = this.i.H();
    String str = this.i.I();
    if (str.equals("unlimited"))
      this.Q = -1;
    while (true)
      if (l1 == 0L)
      {
        aI();
        return;
        try
        {
          int i2 = Integer.parseInt(str);
          i1 = i2;
          this.Q = (i1 - 1);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          while (true)
            int i1 = 1;
        }
      }
    a(l1, false);
  }

  public void m()
  {
    aK();
    b(false, true);
  }

  public void n()
  {
    if ((this.y != null) && (!ah()) && (!this.S))
    {
      this.y.b(this.z);
      aF();
    }
    try
    {
      this.y.w();
      this.a = (1 + this.a);
      this.S = true;
      if (this.aH)
      {
        this.y.y();
        this.aI = null;
      }
      h(false);
      return;
    }
    catch (com.viber.voip.camera.a.b localb)
    {
      this.i.T();
    }
  }

  public boolean o()
  {
    return false;
  }

  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.n = true;
    this.o = paramInt1;
    this.p = paramInt2;
    an();
    aq();
  }

  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.n = false;
    this.o = 0;
    this.p = 0;
    ao();
    return true;
  }

  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.n = true;
    this.o = paramInt1;
    this.p = paramInt2;
    ap();
    aq();
  }

  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
  }

  public boolean p()
  {
    return false;
  }

  public boolean q()
  {
    return this.aG;
  }

  public boolean r()
  {
    return this.aJ;
  }

  public boolean s()
  {
    return this.aK;
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramSurfaceHolder.getSurface() == null)
      return;
    ap();
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    an();
    this.j.getView().setWillNotDraw(false);
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    ao();
  }

  public List<String> t()
  {
    return this.al;
  }

  public List<String> u()
  {
    return this.am;
  }

  public List<String> v()
  {
    return this.an;
  }

  public String w()
  {
    if (this.y == null)
      return "";
    return this.y.f();
  }

  public List<String> x()
  {
    return this.ao;
  }

  public boolean y()
  {
    return this.ap;
  }

  public int z()
  {
    return this.aq;
  }

  class a extends TimerTask
  {
    long a = paramLong;

    public void run()
    {
      if (this.a > 0L)
        b.d(this.c).a(this.a);
      this.a -= 1000L;
    }
  }

  class b
    implements a.f
  {
    b()
    {
    }

    public void a(a.e[] paramArrayOfe)
    {
      b.a(b.this, new a.e[paramArrayOfe.length]);
      System.arraycopy(paramArrayOfe, 0, b.f(b.this), 0, paramArrayOfe.length);
    }
  }

  class c extends TimerTask
  {
    c()
    {
    }

    public void run()
    {
      if (b.g(b.this) != null)
      {
        b.g(b.this).cancel();
        b.a(b.this, null);
      }
      b.this.b().runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((b.a(b.this) != null) && (b.h(b.this) != null))
            b.e(b.this);
        }
      });
    }
  }

  private class d extends GestureDetector.SimpleOnGestureListener
  {
    private d()
    {
    }

    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      if ((!b.c(b.this)) && (b.d(b.this).E()))
        b.this.l();
      return true;
    }
  }

  class e extends TimerTask
  {
    e()
    {
    }

    public void run()
    {
      b.this.b().runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((b.a(b.this) != null) && (b.m(b.this) != null))
            b.n(b.this);
        }
      });
    }
  }

  public static abstract interface f
  {
    public abstract boolean A();

    public abstract void H();

    public abstract void I();

    public abstract void J();

    public abstract void M();

    public abstract void N();

    public abstract Pair<Integer, Integer> a(b paramb, List<a.h> paramList, List<String> paramList1);

    public abstract void a(MotionEvent paramMotionEvent);

    public abstract void a(boolean paramBoolean1, boolean paramBoolean2);

    public abstract void b(boolean paramBoolean);

    public abstract void c(String paramString);
  }

  class g extends TimerTask
  {
    g()
    {
    }

    public void run()
    {
      b.this.b().runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((b.a(b.this) != null) && (b.k(b.this) != null))
            b.l(b.this);
        }
      });
    }
  }

  private class h extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private h()
    {
    }

    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      if ((b.a(b.this) != null) && (b.b(b.this)))
        b.this.a(paramScaleGestureDetector.getScaleFactor());
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.c.b
 * JD-Core Version:    0.6.2
 */