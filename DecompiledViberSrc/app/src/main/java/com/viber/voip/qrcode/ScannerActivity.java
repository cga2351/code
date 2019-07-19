package com.viber.voip.qrcode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.b.d;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.permission.b;
import com.viber.dexshared.Logger;
import com.viber.voip.BaseAddFriendActivity;
import com.viber.voip.BaseAddFriendActivity.ContactDetails;
import com.viber.voip.BaseAddFriendActivity.b;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.i;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.ak;
import com.viber.voip.util.ViberActionRunner.bt;
import com.viber.voip.util.ViberActionRunner.c;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.dj;
import com.viber.voip.util.dk;
import java.io.IOException;

public class ScannerActivity extends BaseAddFriendActivity
  implements SurfaceHolder.Callback, View.OnClickListener, m.c, BaseAddFriendActivity.b
{
  private static final Logger a = ViberEnv.getLogger();
  private SurfaceView b;
  private ViewFinder c;
  private View d;
  private c e;
  private f f;
  private View g;
  private boolean h;
  private Handler i;
  private h j;
  private UserData k;
  private boolean l = true;
  private String m;
  private String n;
  private com.viber.common.permission.c o;
  private final b p;
  private final Runnable q;

  public ScannerActivity()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(1);
    this.p = new com.viber.voip.permissions.h(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        ScannerActivity.this.supportInvalidateOptionsMenu();
      }
    };
    this.q = new Runnable()
    {
      private int b;

      public void run()
      {
        this.b = (1 + this.b);
        if (dj.h(ScannerActivity.this.getApplicationContext()))
        {
          ScannerActivity.a(ScannerActivity.this).setVisibility(0);
          this.b = 0;
          return;
        }
        if (this.b <= 3)
        {
          ScannerActivity.b(ScannerActivity.this).postDelayed(this, 100L);
          return;
        }
        ScannerActivity.c(ScannerActivity.this);
      }
    };
  }

  private void a(Intent paramIntent)
  {
    if (!paramIntent.getBooleanExtra("show_my_qr_code_link", true))
      this.g.setVisibility(8);
    this.m = paramIntent.getStringExtra("analytics_add_contact_entry_point");
    this.n = paramIntent.getStringExtra("analytics_connect_secondary_entry_point");
  }

  private void a(SurfaceHolder paramSurfaceHolder)
  {
    if (paramSurfaceHolder == null)
      throw new IllegalStateException("No SurfaceHolder provided");
    if (this.e.a());
    while (true)
    {
      return;
      try
      {
        Rect localRect = o();
        this.e.a(localRect.width(), localRect.height());
        this.e.a(d.ad.J.d());
        this.e.a(paramSurfaceHolder);
        if (this.j == null)
        {
          this.j = new h(this, this.e);
          i();
          return;
        }
      }
      catch (IOException localIOException)
      {
        p();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        p();
      }
    }
  }

  private void k()
  {
    findViewById(R.id.button_request_permission).setOnClickListener(this);
    ((ImageView)findViewById(R.id.permission_icon)).setImageResource(R.drawable.ic_permission_camera);
    ((TextView)findViewById(R.id.permission_description)).setText(R.string.scan_qr_permission_description);
  }

  private void l()
  {
    getWindow().addFlags(4194432);
    if (!dj.h(this))
      getWindow().addFlags(2097152);
  }

  private void m()
  {
    if (this.m == null)
      return;
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(d.ad.J.d(), localCameraInfo);
  }

  private void n()
  {
    if ((!this.h) || (!this.o.a(com.viber.voip.permissions.n.a)))
      return;
    h();
    this.e.b(this.b.getHolder());
    i();
  }

  private Rect o()
  {
    Rect localRect = new Rect();
    Display localDisplay = ((WindowManager)getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    int i1 = Math.round(0.7F * localPoint.x);
    localRect.set(0, 0, i1, i1);
    return localRect;
  }

  private void p()
  {
    h.a locala = k.n();
    int i1 = R.string.dialog_339_message_with_reason;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getString(R.string.dialog_339_reason_camera);
    locala.b(i1, arrayOfObject).a(this).a(this);
  }

  void a()
  {
    SurfaceHolder localSurfaceHolder = this.b.getHolder();
    if (this.h)
      a(localSurfaceHolder);
    while (true)
    {
      if (!this.h)
      {
        if (!dj.h(this))
          break;
        this.b.setVisibility(0);
      }
      return;
      localSurfaceHolder.addCallback(this);
    }
    this.i.postDelayed(this.q, 100L);
  }

  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 2:
    case 3:
    case 4:
    default:
      k.p().a(this).a(this);
      return;
    case 1:
    case 5:
    case 6:
    case 7:
    }
    ViberActionRunner.c.a(this, paramString, "QR Scan", "More - Add Contact");
    finish();
  }

  public void a(com.google.e.n paramn, Bitmap paramBitmap, float paramFloat)
  {
    this.f.a();
    Uri localUri = Uri.parse(paramn.a());
    if (dk.g(localUri))
    {
      if (com.viber.voip.api.scheme.c.h.a(localUri, com.viber.voip.api.scheme.c.a))
      {
        String str = i.f(localUri);
        if ((!ao.f()) && (!TextUtils.isEmpty(str)))
        {
          if (!str.startsWith("+"))
            str = "+" + str;
          a(null, str, false, this);
          m();
          return;
        }
        k.p().a(this).a(this);
        return;
      }
      if (i.b(localUri))
      {
        i.a(localUri, this.n);
        finish();
        return;
      }
      Intent localIntent2 = new Intent("android.intent.action.VIEW", localUri);
      if (ViberActionRunner.a(localIntent2, this))
      {
        startActivity(localIntent2);
        finish();
        return;
      }
      k.p().a(this).a(this);
      return;
    }
    Intent localIntent1 = new Intent("android.intent.action.VIEW", localUri);
    if (ViberActionRunner.a(localIntent1, this))
    {
      k.o().a(localUri.toString()).a(this).a(localIntent1).a(this);
      return;
    }
    k.p().a(this).a(this);
  }

  public void a(BaseAddFriendActivity.ContactDetails paramContactDetails, boolean paramBoolean)
  {
    if (paramBoolean)
      ViberActionRunner.o.a(this, ViberApplication.isTablet(this), paramContactDetails.getContactId(), paramContactDetails.getDisplayName(), paramContactDetails.getLookupKey(), paramContactDetails.getPhotoUri());
    while (true)
    {
      finish();
      return;
      ViberActionRunner.c.b(this, paramContactDetails.getPhoneNumber(), paramContactDetails, "QR Scan", "More - Add Contact");
    }
  }

  public void b()
  {
    k.p().a(this).a(this);
  }

  Handler e()
  {
    return this.j;
  }

  c f()
  {
    return this.e;
  }

  void g()
  {
    this.c.invalidate();
  }

  void h()
  {
    if (this.j != null)
      this.j.sendEmptyMessage(R.id.pause_decoding);
  }

  void i()
  {
    if (this.j != null)
      this.j.sendEmptyMessage(R.id.restart_preview);
  }

  void j()
  {
    Rect localRect = f().e();
    if (localRect != null)
    {
      int i1 = localRect.top;
      View localView = findViewById(R.id.help_text_wrapper);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      if ((this.l) && (getSupportActionBar() != null))
      {
        localMarginLayoutParams.topMargin = getSupportActionBar().e();
        i1 -= getSupportActionBar().e();
      }
      localMarginLayoutParams.height = i1;
      localView.requestLayout();
      localView.setVisibility(0);
    }
  }

  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.my_qrcode)
      if ((TextUtils.isEmpty(this.k.getViberName())) || (TextUtils.isEmpty(this.k.getViberImage())))
      {
        if (this.j != null)
          this.j.sendEmptyMessage(R.id.pause_decoding);
        k.q().a(this).a(this);
      }
    while (i1 != R.id.button_request_permission)
    {
      return;
      ViberActionRunner.ak.a(this, this.m);
      return;
    }
    this.o.a(this, 1, com.viber.voip.permissions.n.a);
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    if (!com.viber.common.d.a.g())
      ViberApplication.getInstance().logToCrashlytics("open Scanner Activity");
    l();
    this.i = av.a(av.e.a);
    if (this.l)
      supportRequestWindowFeature(9);
    setContentView(R.layout.scanner_activity);
    setActionBarTitle(R.string.add_friend_scanner_title);
    getSupportActionBar().b(true);
    dj.c(this, false);
    this.k = UserManager.from(this).getUserData();
    this.o = com.viber.common.permission.c.a(this);
    this.h = false;
    this.f = new f(this);
    this.b = ((SurfaceView)findViewById(R.id.camera_preview));
    this.c = ((ViewFinder)findViewById(R.id.viewfinder));
    this.d = findViewById(R.id.empty_view);
    k();
    if (!dj.h(this))
      this.b.setVisibility(8);
    this.g = findViewById(R.id.my_qrcode);
    this.g.setOnClickListener(this);
    a(getIntent());
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_scanner, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(R.id.flip_camera);
    if ((Camera.getNumberOfCameras() > 1) && (this.o.a(com.viber.voip.permissions.n.a)));
    for (boolean bool = true; ; bool = false)
    {
      localMenuItem.setVisible(bool);
      return true;
    }
  }

  protected void onDestroy()
  {
    this.f.d();
    super.onDestroy();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D339))
      finish();
    Intent localIntent;
    do
    {
      do
      {
        return;
        if (paramm.a(DialogCode.D384))
        {
          i();
          return;
        }
        if (paramm.a(DialogCode.D392))
        {
          switch (paramInt)
          {
          default:
            i();
            return;
          case -1:
          }
          ViberActionRunner.bt.e(this);
          return;
        }
      }
      while (!paramm.a(DialogCode.D383));
      switch (paramInt)
      {
      default:
        i();
        return;
      case -1:
      }
      localIntent = (Intent)paramm.d();
    }
    while (localIntent == null);
    startActivity(localIntent);
    finish();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.flip_camera)
    {
      n();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onPause()
  {
    if (this.j != null)
    {
      this.j.a();
      this.j = null;
    }
    this.f.b();
    this.e.b();
    if (!this.h)
    {
      this.b.getHolder().removeCallback(this);
      this.i.removeCallbacks(this.q);
      this.b.setVisibility(8);
    }
    super.onPause();
  }

  protected void onResume()
  {
    super.onResume();
    this.e = new c(getApplication());
    this.c.setCameraManager(this.e);
    if (this.o.a(com.viber.voip.permissions.n.a))
    {
      this.d.setVisibility(8);
      supportInvalidateOptionsMenu();
      a();
    }
    while (true)
    {
      this.f.c();
      return;
      this.d.setVisibility(0);
    }
  }

  protected void onStart()
  {
    super.onStart();
    this.o.a(this.p);
  }

  protected void onStop()
  {
    super.onStop();
    this.o.b(this.p);
  }

  public boolean onSupportNavigateUp()
  {
    onBackPressed();
    return true;
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if ((paramSurfaceHolder != null) || (!this.h))
    {
      this.h = true;
      a(paramSurfaceHolder);
    }
    j();
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.h = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.qrcode.ScannerActivity
 * JD-Core Version:    0.6.2
 */