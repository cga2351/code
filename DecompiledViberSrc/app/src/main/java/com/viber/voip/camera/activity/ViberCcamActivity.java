package com.viber.voip.camera.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.CamcorderProfile;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.viber.voip.camera.R.id;
import com.viber.voip.camera.R.layout;
import com.viber.voip.camera.R.raw;
import com.viber.voip.camera.R.xml;
import com.viber.voip.camera.a.a.h;
import com.viber.voip.camera.a.c;
import com.viber.voip.camera.d.a.a.a;
import com.viber.voip.camera.e.d;
import java.util.Iterator;
import java.util.List;

public abstract class ViberCcamActivity extends ViberCcamBaseActivity
  implements com.viber.voip.camera.b.a.a
{
  private static final String D = com.viber.voip.camera.e.a.a(ViberCcamActivity.class);
  public SeekBar A;
  public SeekBar B;
  protected Handler a;
  protected com.viber.voip.camera.a b = null;
  protected com.viber.voip.camera.b.a c = null;
  protected com.viber.voip.camera.c.b d = null;
  protected OrientationEventListener e = null;
  protected int f = 0;
  protected boolean g = false;
  protected boolean h = false;
  protected boolean i = false;
  protected boolean j = false;
  protected SoundPool k = null;
  protected SparseIntArray l = null;
  protected com.viber.voip.camera.f.b m = null;
  public boolean n = false;
  public View o;
  public ImageView p;
  public ImageView q;
  public View r;
  public ViewGroup s;
  public ViewGroup t;
  public ViewGroup u;
  public View v;
  public View w;
  public SeekBar x;
  public SeekBar y;
  public SeekBar z;

  private void A()
  {
    SharedPreferences localSharedPreferences = com.viber.voip.camera.d.a.a(this);
    label50: WindowManager.LayoutParams localLayoutParams;
    if (localSharedPreferences.getBoolean(com.viber.voip.camera.d.a.r(), true))
    {
      getWindow().addFlags(128);
      if (!localSharedPreferences.getBoolean(com.viber.voip.camera.d.a.q(), true))
        break label103;
      getWindow().addFlags(524288);
      localLayoutParams = getWindow().getAttributes();
      if (!localSharedPreferences.getBoolean(com.viber.voip.camera.d.a.s(), true))
        break label115;
    }
    label103: label115: for (localLayoutParams.screenBrightness = 1.0F; ; localLayoutParams.screenBrightness = -1.0F)
    {
      getWindow().setAttributes(localLayoutParams);
      this.j = false;
      return;
      getWindow().clearFlags(128);
      break;
      getWindow().clearFlags(524288);
      break label50;
    }
  }

  private void B()
  {
    getWindow().clearFlags(128);
    getWindow().clearFlags(524288);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.screenBrightness = -1.0F;
    getWindow().setAttributes(localLayoutParams);
    this.j = true;
  }

  @TargetApi(21)
  private void C()
  {
    AudioAttributes localAudioAttributes;
    if (this.k == null)
    {
      if (Build.VERSION.SDK_INT < 21)
        break label68;
      localAudioAttributes = new AudioAttributes.Builder().setLegacyStreamType(1).setContentType(4).build();
    }
    label68: for (this.k = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(localAudioAttributes).build(); ; this.k = new SoundPool(1, 1, 0))
    {
      this.l = new SparseIntArray();
      return;
    }
  }

  private void D()
  {
    if (this.k != null)
    {
      this.k.release();
      this.k = null;
      this.l = null;
    }
  }

  @TargetApi(21)
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 42);
  }

  private static void a(Bundle paramBundle, String paramString, List<String> paramList)
  {
    if (paramList != null)
    {
      String[] arrayOfString = new String[paramList.size()];
      Iterator localIterator = paramList.iterator();
      for (int i1 = 0; localIterator.hasNext(); i1++)
        arrayOfString[i1] = ((String)localIterator.next());
      paramBundle.putStringArray(paramString, arrayOfString);
    }
  }

  private void a(SeekBar paramSeekBar, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    int i1 = 100;
    paramSeekBar.setMax(i1);
    int i2 = (int)(0.5D + 100.0D * c((paramDouble3 - paramDouble1) / (paramDouble2 - paramDouble1)));
    if (i2 < 0)
      i1 = 0;
    while (true)
    {
      paramSeekBar.setProgress(i1);
      return;
      if (i2 <= i1)
        i1 = i2;
    }
  }

  private void a(SeekBar paramSeekBar, int paramInt)
  {
    int i1 = paramSeekBar.getProgress();
    int i2 = i1 + paramInt;
    if (i2 < 0)
      i2 = 0;
    while (true)
    {
      if (i2 != i1)
        paramSeekBar.setProgress(i2);
      return;
      if (i2 > paramSeekBar.getMax())
        i2 = paramSeekBar.getMax();
    }
  }

  private static double b(double paramDouble)
  {
    return (Math.pow(100.0D, paramDouble) - 1.0D) / 99.0D;
  }

  private static double c(double paramDouble)
  {
    return Math.log(1.0D + 99.0D * paramDouble) / Math.log(100.0D);
  }

  private void h(int paramInt)
  {
    if (paramInt == -1);
    int i2;
    do
    {
      int i1;
      do
      {
        return;
        i1 = Math.abs(paramInt - this.f);
        if (i1 > 180)
          i1 = 360 - i1;
      }
      while (i1 <= 60);
      i2 = 90 * ((paramInt + 45) / 90) % 360;
    }
    while (i2 == this.f);
    this.f = i2;
    j();
  }

  protected void a()
  {
    this.t = ((ViewGroup)g(R.id.root_container));
    this.s = ((ViewGroup)g(R.id.preview));
    this.x = new SeekBar(this);
    this.y = new SeekBar(this);
    this.z = new SeekBar(this);
    this.A = new SeekBar(this);
    this.B = new SeekBar(this);
  }

  public void a(int paramInt)
  {
    a(this.x, paramInt);
  }

  protected void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
  }

  protected void a(View paramView)
  {
    x();
  }

  protected void a(a parama)
  {
  }

  protected void a(b paramb)
  {
  }

  public final boolean a(String paramString)
  {
    return a(paramString, true);
  }

  public final boolean a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, true);
  }

  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    com.viber.voip.camera.c.b localb = s();
    return (localb != null) && (localb.a(paramString, true, paramBoolean2, paramBoolean1));
  }

  public ViewGroup b()
  {
    if (this.u == null)
      this.u = ((ViewGroup)((ViewStub)findViewById(R.id.stub_popup_container)).inflate());
    return this.u;
  }

  public void b(int paramInt)
  {
    a(this.y, paramInt);
  }

  public com.viber.voip.camera.b.a c()
  {
    return this.c;
  }

  void c(int paramInt)
  {
    a(this.B, paramInt);
  }

  protected com.viber.voip.camera.d.a.a d()
  {
    return new a.a.a().a(10).a(null).a(false).a();
  }

  protected void d(int paramInt)
  {
  }

  protected void e()
  {
    com.viber.voip.camera.d.a.a locala = d();
    SharedPreferences.Editor localEditor = com.viber.voip.camera.d.a.a(this).edit();
    if (!TextUtils.isEmpty(locala.d()))
      localEditor.putString(com.viber.voip.camera.d.a.u(), locala.d());
    if (locala.b() >= 0)
    {
      String str4 = String.valueOf(locala.b());
      localEditor.putString(com.viber.voip.camera.d.a.F(), str4);
    }
    if (locala.e() >= 0)
    {
      String str3 = String.valueOf(locala.e());
      localEditor.putString(com.viber.voip.camera.d.a.E(), str3);
    }
    if (locala.f() >= 0)
    {
      String str2 = String.valueOf(locala.f());
      localEditor.putString(com.viber.voip.camera.d.a.C(), str2);
    }
    if (locala.g() >= 0L)
    {
      String str1 = String.valueOf(locala.g());
      localEditor.putString(com.viber.voip.camera.d.a.D(), str1);
    }
    if (!TextUtils.isEmpty(locala.a()))
      localEditor.putString(com.viber.voip.camera.d.a.k(), locala.a());
    localEditor.putBoolean(com.viber.voip.camera.d.a.b(), locala.c());
    localEditor.putBoolean(com.viber.voip.camera.d.a.s(), locala.j());
    localEditor.putBoolean(com.viber.voip.camera.d.a.q(), locala.k());
    localEditor.putBoolean(com.viber.voip.camera.d.a.d(), locala.i());
    if (locala.h())
      for (int i1 = 0; i1 < Camera.getNumberOfCameras(); i1++)
      {
        localEditor.remove(com.viber.voip.camera.d.a.c(i1));
        localEditor.remove(com.viber.voip.camera.d.a.b(i1));
      }
    localEditor.apply();
  }

  void e(int paramInt)
  {
    if (this.k != null)
      this.l.put(paramInt, this.k.load(this, paramInt, 1));
  }

  protected int f()
  {
    return R.layout.activity_camera_preview;
  }

  public void f(int paramInt)
  {
    if ((this.k == null) || (this.l.indexOfKey(paramInt) < 0))
      return;
    this.k.play(this.l.get(paramInt), 1.0F, 1.0F, 0, 0, 1.0F);
  }

  public void g()
  {
    this.A.setProgress(this.d.ag() - this.d.ac().j());
  }

  public void h()
  {
    a(this.A, -1);
  }

  public void i()
  {
    a(this.A, 1);
  }

  public void j()
  {
    int i1 = getWindowManager().getDefaultDisplay().getRotation();
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
      d((360 - (i2 + this.f) % 360) % 360);
      return;
      i2 = 90;
      continue;
      i2 = 180;
      continue;
      i2 = 270;
    }
  }

  public boolean k()
  {
    return this.m != null;
  }

  public void l()
  {
    if (k())
    {
      b().removeAllViews();
      this.m.a();
      this.m = null;
    }
  }

  protected void m()
  {
    int i1 = 0;
    l();
    this.d.c();
    this.d.a(false);
    Bundle localBundle = new Bundle();
    localBundle.putInt("cameraId", this.d.U());
    localBundle.putString("camera_api", this.d.V());
    localBundle.putBoolean("supports_auto_stabilise", this.g);
    localBundle.putBoolean("supports_force_video_4k", this.h);
    localBundle.putBoolean("supports_camera2", this.i);
    localBundle.putBoolean("supports_face_detection", this.d.q());
    localBundle.putBoolean("supports_video_stabilization", this.d.r());
    localBundle.putBoolean("can_disable_shutter_sound", this.d.s());
    a(localBundle, "color_effects", this.d.t());
    a(localBundle, "scene_modes", this.d.u());
    a(localBundle, "white_balances", this.d.v());
    a(localBundle, "isos", this.d.x());
    localBundle.putString("iso_key", this.d.w());
    if (this.d.ac() != null)
      localBundle.putString("parameters_string", this.d.ac().E());
    List localList1 = this.d.J();
    if (localList1 != null)
    {
      int[] arrayOfInt5 = new int[localList1.size()];
      int[] arrayOfInt6 = new int[localList1.size()];
      Iterator localIterator4 = localList1.iterator();
      for (int i4 = 0; localIterator4.hasNext(); i4++)
      {
        a.h localh3 = (a.h)localIterator4.next();
        arrayOfInt5[i4] = localh3.a;
        arrayOfInt6[i4] = localh3.b;
      }
      localBundle.putIntArray("preview_widths", arrayOfInt5);
      localBundle.putIntArray("preview_heights", arrayOfInt6);
    }
    localBundle.putInt("preview_width", this.d.K().a);
    localBundle.putInt("preview_height", this.d.K().b);
    List localList2 = this.d.L();
    if (localList2 != null)
    {
      int[] arrayOfInt3 = new int[localList2.size()];
      int[] arrayOfInt4 = new int[localList2.size()];
      Iterator localIterator3 = localList2.iterator();
      for (int i3 = 0; localIterator3.hasNext(); i3++)
      {
        a.h localh2 = (a.h)localIterator3.next();
        arrayOfInt3[i3] = localh2.a;
        arrayOfInt4[i3] = localh2.b;
      }
      localBundle.putIntArray("resolution_widths", arrayOfInt3);
      localBundle.putIntArray("resolution_heights", arrayOfInt4);
    }
    if (this.d.N() != null)
    {
      localBundle.putInt("resolution_width", this.d.N().a);
      localBundle.putInt("resolution_height", this.d.N().b);
    }
    List localList3 = this.d.O();
    if ((localList3 != null) && (this.d.ac() != null))
    {
      String[] arrayOfString1 = new String[localList3.size()];
      String[] arrayOfString2 = new String[localList3.size()];
      Iterator localIterator2 = localList3.iterator();
      for (int i2 = 0; localIterator2.hasNext(); i2++)
      {
        String str = (String)localIterator2.next();
        arrayOfString1[i2] = str;
        arrayOfString2[i2] = this.d.c(str);
      }
      localBundle.putStringArray("video_quality", arrayOfString1);
      localBundle.putStringArray("video_quality_string", arrayOfString2);
    }
    if (this.d.Q() != null)
      localBundle.putString("current_video_quality", this.d.Q());
    CamcorderProfile localCamcorderProfile = this.d.e();
    localBundle.putInt("video_frame_width", localCamcorderProfile.videoFrameWidth);
    localBundle.putInt("video_frame_height", localCamcorderProfile.videoFrameHeight);
    localBundle.putInt("video_bit_rate", localCamcorderProfile.videoBitRate);
    localBundle.putInt("video_frame_rate", localCamcorderProfile.videoFrameRate);
    List localList4 = this.d.R();
    if (localList4 != null)
    {
      int[] arrayOfInt1 = new int[localList4.size()];
      int[] arrayOfInt2 = new int[localList4.size()];
      Iterator localIterator1 = localList4.iterator();
      while (localIterator1.hasNext())
      {
        a.h localh1 = (a.h)localIterator1.next();
        arrayOfInt1[i1] = localh1.a;
        arrayOfInt2[i1] = localh1.b;
        i1++;
      }
      localBundle.putIntArray("video_widths", arrayOfInt1);
      localBundle.putIntArray("video_heights", arrayOfInt2);
    }
    a(localBundle, "flash_values", this.d.S());
    a(localBundle, "focus_values", this.d.T());
    B();
    startActivity(new Intent(this, ViberCcamInternalSettingsActivity.class).putExtras(localBundle));
  }

  public void n()
  {
    com.viber.voip.camera.a.a locala = this.d.ac();
    String str1 = null;
    if (locala != null)
    {
      boolean bool1 = this.d.Y();
      str1 = null;
      if (bool1)
      {
        boolean bool2 = this.d.i();
        str1 = null;
        if (!bool2)
        {
          str1 = this.d.k();
          this.d.c(false);
        }
      }
    }
    if (this.d.ac() != null)
    {
      String str2 = this.d.ac().e();
      String str3 = com.viber.voip.camera.d.a.g();
      if (com.viber.voip.camera.d.a.a(this).getString(str3, this.d.ac().m()).equals(str2));
    }
    for (int i1 = 1; ; i1 = 0)
    {
      j();
      if ((i1 != 0) || (this.d.ac() == null))
      {
        this.d.X();
        this.d.W();
      }
      while (true)
      {
        if (str1 != null)
          this.d.a(str1, true, false);
        return;
        this.d.g();
        this.d.d();
        this.d.b(false);
      }
    }
  }

  public void o()
  {
    if ((q()) && (this.d.R() != null))
    {
      Iterator localIterator = this.d.R().iterator();
      while (localIterator.hasNext())
      {
        a.h localh = (a.h)localIterator.next();
        if ((localh.a >= 3840) && (localh.b >= 2160))
          r();
      }
    }
    if (this.d.af())
    {
      this.A.setOnSeekBarChangeListener(null);
      this.A.setMax(this.d.ag());
      this.A.setProgress(this.d.ag() - this.d.ac().j());
      this.A.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          ViberCcamActivity.this.d.a(ViberCcamActivity.this.d.ag() - paramAnonymousInt);
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      });
    }
    this.B.setOnSeekBarChangeListener(null);
    a(this.B, 0.0D, this.d.B(), this.d.ac().q());
    this.B.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        float f = (float)(ViberCcamActivity.a(paramAnonymousInt / 100.0D) * ViberCcamActivity.this.d.B());
        ViberCcamActivity.this.d.b(f);
      }

      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
      }

      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
      }
    });
    if (this.d.y())
    {
      this.y.setOnSeekBarChangeListener(null);
      a(this.y, this.d.z(), this.d.A(), this.d.ac().g());
      this.y.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          double d = ViberCcamActivity.a(paramAnonymousInt / 100.0D);
          int i = ViberCcamActivity.this.d.z();
          int j = i + (int)(d * (ViberCcamActivity.this.d.A() - i));
          ViberCcamActivity.this.d.c(j);
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      });
      if (this.d.C())
      {
        this.z.setOnSeekBarChangeListener(null);
        a(this.z, this.d.D(), this.d.E(), this.d.ac().h());
        this.z.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
          public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
          {
            double d = ViberCcamActivity.a(paramAnonymousInt / 100.0D);
            long l1 = ViberCcamActivity.this.d.D();
            long l2 = l1 + ()(d * (ViberCcamActivity.this.d.E() - l1));
            ViberCcamActivity.this.d.a(l2);
          }

          public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
          {
          }

          public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
          {
          }
        });
      }
    }
    if (this.d.F())
    {
      final int i1 = this.d.G();
      this.x.setOnSeekBarChangeListener(null);
      this.x.setMax(this.d.H() - i1);
      this.x.setProgress(this.d.I() - i1);
      this.x.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          ViberCcamActivity.this.d.b(paramAnonymousInt + i1);
        }

        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }

        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
        }
      });
    }
  }

  @TargetApi(21)
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 42) && (paramInt2 == -1) && (paramIntent != null))
    {
      Uri localUri = paramIntent.getData();
      int i1 = 0x3 & paramIntent.getFlags();
      getContentResolver().takePersistableUriPermission(localUri, i1);
      SharedPreferences.Editor localEditor2 = com.viber.voip.camera.d.a.a(this).edit();
      localEditor2.putString(com.viber.voip.camera.d.a.v(), localUri.toString());
      localEditor2.apply();
      this.b.a().f();
    }
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return;
        if (paramInt1 != 42)
          break;
        localSharedPreferences = com.viber.voip.camera.d.a.a(this);
      }
      while (localSharedPreferences.getString(com.viber.voip.camera.d.a.v(), "").length() != 0);
      SharedPreferences.Editor localEditor1 = localSharedPreferences.edit();
      localEditor1.putBoolean(com.viber.voip.camera.d.a.t(), false);
      localEditor1.apply();
      return;
    }
    while ((43 != paramInt1) || (-1 != paramInt2) || (paramIntent == null));
    a(-1, paramIntent);
    finish();
  }

  public void onBackPressed()
  {
    if (k())
    {
      l();
      return;
    }
    super.onBackPressed();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.d.g();
    super.onConfigurationChanged(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    d locald = d.a();
    this.a = new Handler();
    super.onCreate(paramBundle);
    setContentView(f());
    PreferenceManager.setDefaultValues(this, "com_viber_voip_camera_pref_file", 0, R.xml.preferences, false);
    e();
    ActivityManager localActivityManager = (ActivityManager)getSystemService("activity");
    if (localActivityManager.getLargeMemoryClass() >= 128)
      this.g = true;
    if ((localActivityManager.getMemoryClass() >= 128) || (localActivityManager.getLargeMemoryClass() >= 512))
      this.h = true;
    this.b = new com.viber.voip.camera.a(this, paramBundle);
    A();
    this.d = new com.viber.voip.camera.c.b(this.b, paramBundle, this.s);
    int i1 = this.d.ad().a();
    ImageView localImageView = this.q;
    if (i1 > 1);
    for (int i2 = 0; ; i2 = 8)
    {
      localImageView.setVisibility(i2);
      this.e = new OrientationEventListener(this)
      {
        public void onOrientationChanged(int paramAnonymousInt)
        {
          ViberCcamActivity.a((ViberCcamActivity)ViberCcamActivity.this.y(), paramAnonymousInt);
        }
      };
      this.c = new com.viber.voip.camera.b.a(this);
      locald.a(D);
      return;
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i1 = 1;
    switch (paramInt)
    {
    default:
    case 82:
    case 24:
    case 25:
    case 85:
    case 86:
    case 88:
    case 27:
    case 130:
      do
      {
        String str;
        do
        {
          i1 = super.onKeyDown(paramInt, paramKeyEvent);
          do
          {
            do
            {
              int i4;
              do
              {
                do
                {
                  do
                  {
                    return i1;
                    str = com.viber.voip.camera.d.a.a(this).getString(com.viber.voip.camera.d.a.k(), "volume_really_nothing");
                    if (((paramInt == 88) || (paramInt == 85) || (paramInt == 86)) && (!str.equals("volume_take_photo")))
                    {
                      AudioManager localAudioManager = (AudioManager)getSystemService("audio");
                      if ((localAudioManager == null) || (!localAudioManager.isWiredHeadsetOn()))
                        break;
                    }
                    if (str.equals("volume_take_photo"))
                    {
                      x();
                      return i1;
                    }
                    if (!str.equals("volume_focus"))
                      break label265;
                    if ((this.d.k() != null) && (this.d.k().equals("focus_mode_manual2")))
                    {
                      if (paramInt == 24)
                      {
                        c(-1);
                        return i1;
                      }
                      c(i1);
                      return i1;
                    }
                  }
                  while (this.d.aj());
                  this.d.m();
                  return i1;
                  if (str.equals("volume_zoom"))
                  {
                    if (paramInt == 24)
                    {
                      h();
                      return i1;
                    }
                    i();
                    return i1;
                  }
                  if (!str.equals("volume_exposure"))
                    break label427;
                }
                while (this.d.ac() == null);
                boolean bool = com.viber.voip.camera.d.a.a(this).getString(com.viber.voip.camera.d.a.i(), this.d.ac().p()).equals(this.d.ac().p());
                i4 = 0;
                if (!bool)
                  i4 = i1;
                if (paramInt != 24)
                  break label398;
                if (i4 == 0)
                  break label391;
              }
              while (!this.d.y());
              b(i1);
              return i1;
              a(i1);
              return i1;
              if (i4 == 0)
                break label420;
            }
            while (!this.d.y());
            b(-1);
            return i1;
            a(-1);
            return i1;
            if (!str.equals("volume_auto_stabilise"))
              break label496;
          }
          while (!this.g);
          if (!com.viber.voip.camera.d.a.a(this).getBoolean(com.viber.voip.camera.d.a.m(), false));
          int i3;
          for (int i2 = i1; ; i3 = 0)
          {
            com.viber.voip.camera.d.a.a(this).edit().putBoolean(com.viber.voip.camera.d.a.m(), i2).apply();
            return i1;
          }
        }
        while (!str.equals("volume_really_nothing"));
        return i1;
      }
      while ((!com.viber.voip.camera.d.a.a(this).getBoolean(com.viber.voip.camera.d.a.d(), false)) || (paramKeyEvent.getRepeatCount() != 0));
      x();
      return i1;
    case 168:
      label265: label398: label420: label427: label496: h();
      label391: return i1;
    case 169:
    }
    i();
    return i1;
  }

  public final void onOpenAppSettings(View paramView)
  {
    m();
  }

  public final void onOpenExtensions(View paramView)
  {
    if (k())
      l();
    while (this.d.ac() == null)
      return;
    this.d.c();
    b().setBackgroundColor(-16777216);
    this.u.setAlpha(0.9F);
    this.m = new com.viber.voip.camera.f.b(this);
    this.u.addView(this.m);
    this.u.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      @TargetApi(16)
      public void onGlobalLayout()
      {
        ViberCcamActivity.this.j();
        if (Build.VERSION.SDK_INT > 15)
        {
          ViberCcamActivity.this.u.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          return;
        }
        ViberCcamActivity.this.u.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
    });
  }

  protected void onPause()
  {
    super.onPause();
    l();
    this.e.disable();
    D();
    this.d.X();
  }

  protected void onResume()
  {
    d locald = d.a();
    super.onResume();
    getWindow().getDecorView().getRootView().setBackgroundColor(-16777216);
    this.e.enable();
    C();
    e(R.raw.beep);
    e(R.raw.beep_hi);
    j();
    this.d.W();
    locald.a(D);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.d != null)
      this.d.a(paramBundle);
    if (this.b != null)
      this.b.a(paramBundle);
  }

  public final void onSwitchCameraSide(View paramView)
  {
    l();
    if (this.d.h())
    {
      int i1 = this.d.U();
      int i2 = this.d.ad().a();
      int i3 = (i1 + 1) % i2;
      this.q.setEnabled(false);
      this.d.d(i3);
      this.q.setEnabled(true);
      a(t());
    }
  }

  public final void onSwitchFlashMode(View paramView)
  {
    this.c.a();
    a(u());
  }

  public boolean p()
  {
    return this.g;
  }

  public boolean q()
  {
    return this.h;
  }

  void r()
  {
    this.h = false;
  }

  public com.viber.voip.camera.c.b s()
  {
    return this.d;
  }

  protected final a t()
  {
    if (this.d.ad().a(this.d.U()))
      return a.b;
    return a.a;
  }

  protected final b u()
  {
    String str = this.d.j();
    label12: label52: int i1;
    if (str != null)
      switch (str.hashCode())
      {
      default:
        i1 = -1;
      case -1146923872:
      case 1625570446:
      case -1195303778:
      }
    while (true)
      switch (i1)
      {
      default:
        return b.c;
        str = "";
        break label12;
        if (!str.equals("flash_off"))
          break label52;
        i1 = 0;
        continue;
        if (!str.equals("flash_on"))
          break label52;
        i1 = 1;
        continue;
        if (!str.equals("flash_auto"))
          break label52;
        i1 = 2;
      case 0:
      case 1:
      case 2:
      }
    return b.c;
    return b.b;
    return b.a;
  }

  public void v()
  {
  }

  public void w()
  {
    l();
    this.d.a(true, true);
  }

  protected void x()
  {
    l();
    this.d.l();
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

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }
  }

  public static abstract interface c
  {
    public abstract void a(String paramString, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2);

    public abstract void a(String paramString, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.activity.ViberCcamActivity
 * JD-Core Version:    0.6.2
 */