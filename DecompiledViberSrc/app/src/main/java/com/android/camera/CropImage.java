package com.android.camera;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Toast;
import com.android.camera.a.c;
import com.android.camera.a.d;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dj;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class CropImage extends MonitoredActivity
{
  private static final Logger e = ViberEnv.getLogger();
  private static final Bitmap.Config f = Bitmap.Config.ARGB_8888;
  boolean a;
  boolean b;
  b c;
  Runnable d = new Runnable()
  {
    float a = 1.0F;
    Matrix b;
    FaceDetector.Face[] c = new FaceDetector.Face[3];
    int d;

    private void a()
    {
      b localb = new b(CropImage.d(CropImage.this));
      int i = CropImage.c(CropImage.this).getWidth();
      int j = CropImage.c(CropImage.this).getHeight();
      Rect localRect = new Rect(0, 0, i, j);
      int k = 4 * Math.min(i, j) / 5;
      int m;
      int n;
      if ((CropImage.g(CropImage.this) != 0) && (CropImage.h(CropImage.this) != 0))
        if (CropImage.g(CropImage.this) > CropImage.h(CropImage.this))
        {
          m = k * CropImage.h(CropImage.this) / CropImage.g(CropImage.this);
          n = k;
        }
      while (true)
      {
        int i1 = (i - n) / 2;
        int i2 = (j - m) / 2;
        RectF localRectF = new RectF(i1, i2, n + i1, m + i2);
        Matrix localMatrix = this.b;
        boolean bool1 = CropImage.f(CropImage.this);
        int i3 = CropImage.g(CropImage.this);
        boolean bool2 = false;
        if (i3 != 0)
        {
          int i4 = CropImage.h(CropImage.this);
          bool2 = false;
          if (i4 != 0)
            bool2 = true;
        }
        localb.a(localMatrix, localRect, localRectF, bool1, bool2);
        CropImage.d(CropImage.this).a(localb);
        return;
        n = k * CropImage.g(CropImage.this) / CropImage.h(CropImage.this);
        m = k;
        continue;
        m = k;
        n = k;
      }
    }

    private void a(FaceDetector.Face paramAnonymousFace)
    {
      PointF localPointF = new PointF();
      int i = 2 * (int)(paramAnonymousFace.eyesDistance() * this.a);
      paramAnonymousFace.getMidPoint(localPointF);
      localPointF.x *= this.a;
      localPointF.y *= this.a;
      int j = (int)localPointF.x;
      int k = (int)localPointF.y;
      b localb = new b(CropImage.d(CropImage.this));
      Rect localRect = new Rect(0, 0, CropImage.c(CropImage.this).getWidth(), CropImage.c(CropImage.this).getHeight());
      RectF localRectF = new RectF(j, k, j, k);
      localRectF.inset(-i, -i);
      if (localRectF.left < 0.0F)
        localRectF.inset(-localRectF.left, -localRectF.left);
      if (localRectF.top < 0.0F)
        localRectF.inset(-localRectF.top, -localRectF.top);
      if (localRectF.right > localRect.right)
        localRectF.inset(localRectF.right - localRect.right, localRectF.right - localRect.right);
      if (localRectF.bottom > localRect.bottom)
        localRectF.inset(localRectF.bottom - localRect.bottom, localRectF.bottom - localRect.bottom);
      Matrix localMatrix = this.b;
      boolean bool1 = CropImage.f(CropImage.this);
      int m = CropImage.g(CropImage.this);
      boolean bool2 = false;
      if (m != 0)
      {
        int n = CropImage.h(CropImage.this);
        bool2 = false;
        if (n != 0)
          bool2 = true;
      }
      localb.a(localMatrix, localRect, localRectF, bool1, bool2);
      CropImage.d(CropImage.this).a(localb);
    }

    private Bitmap b()
    {
      if (CropImage.c(CropImage.this) == null)
        return null;
      if (CropImage.c(CropImage.this).getWidth() > 256)
        this.a = (256.0F / CropImage.c(CropImage.this).getWidth());
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(this.a, this.a);
      return Bitmap.createBitmap(CropImage.c(CropImage.this), 0, 0, CropImage.c(CropImage.this).getWidth(), CropImage.c(CropImage.this).getHeight(), localMatrix, true);
    }

    public void run()
    {
      this.b = CropImage.d(CropImage.this).getImageMatrix();
      Bitmap localBitmap = b();
      this.a = (1.0F / this.a);
      if ((localBitmap != null) && (CropImage.i(CropImage.this)))
        this.d = new FaceDetector(localBitmap.getWidth(), localBitmap.getHeight(), this.c.length).findFaces(localBitmap, this.c);
      if ((localBitmap != null) && (localBitmap != CropImage.c(CropImage.this)))
        localBitmap.recycle();
      CropImage.e(CropImage.this).post(new Runnable()
      {
        public void run()
        {
          CropImage localCropImage = CropImage.this;
          if (CropImage.6.this.d > 1);
          for (boolean bool = true; ; bool = false)
          {
            localCropImage.a = bool;
            if (CropImage.6.this.d <= 0)
              break;
            for (int i = 0; i < CropImage.6.this.d; i++)
              CropImage.6.a(CropImage.6.this, CropImage.6.this.c[i]);
          }
          CropImage.6.a(CropImage.6.this);
          CropImage.d(CropImage.this).invalidate();
          if (CropImage.d(CropImage.this).a.size() == 1)
          {
            CropImage.this.c = ((b)CropImage.d(CropImage.this).a.get(0));
            CropImage.this.c.a(true);
          }
          if (CropImage.6.this.d > 1)
            Toast.makeText(CropImage.this, R.string.multiface_crop_help, 0).show();
        }
      });
    }
  };
  private Bitmap.CompressFormat g = Bitmap.CompressFormat.JPEG;
  private Uri h = null;
  private int i;
  private int j;
  private boolean k = true;
  private boolean l = false;
  private final Handler m = new Handler();
  private int n;
  private int o;
  private boolean p;
  private boolean q = true;
  private CropImageView r;
  private ContentResolver s;
  private Bitmap t;
  private d u;
  private c v;
  private Uri w;

  private Bitmap a(c paramc, Bitmap paramBitmap)
  {
    if (paramc != null)
      paramBitmap = paramc.a(-1, 1048576);
    return paramBitmap;
  }

  private void a()
  {
    if (isFinishing())
      return;
    this.r.a(this.t, true);
    e.a(this, null, getResources().getString(R.string.runningFaceDetection), new Runnable()
    {
      public void run()
      {
        final CountDownLatch localCountDownLatch = new CountDownLatch(1);
        final Bitmap localBitmap = CropImage.a(CropImage.this, CropImage.b(CropImage.this), CropImage.c(CropImage.this));
        CropImage.e(CropImage.this).post(new Runnable()
        {
          public void run()
          {
            if ((localBitmap != CropImage.c(CropImage.this)) && (localBitmap != null))
            {
              CropImage.d(CropImage.this).a(localBitmap, true);
              CropImage.c(CropImage.this).recycle();
              CropImage.a(CropImage.this, localBitmap);
            }
            if (CropImage.d(CropImage.this).getScale() == 1.0F)
              CropImage.d(CropImage.this).a(true, true);
            localCountDownLatch.countDown();
          }
        });
        try
        {
          localCountDownLatch.await();
          CropImage.this.d.run();
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new RuntimeException(localInterruptedException);
        }
      }
    }
    , this.m);
  }

  private void a(final Bitmap paramBitmap)
  {
    OutputStream localOutputStream;
    if (this.h != null)
      localOutputStream = null;
    try
    {
      localOutputStream = this.s.openOutputStream(this.h);
      if (localOutputStream != null)
        paramBitmap.compress(this.g, 80, localOutputStream);
      e.a(localOutputStream);
      Bundle localBundle = new Bundle();
      localBundle.putString("portraitUri", this.h.toString());
      if (this.w != null)
        localBundle.putString("landscapeUri", this.w.toString());
      Intent localIntent = getIntent();
      String str = localIntent.getStringExtra("image_change_type");
      if (str != null)
        localBundle.putString("image_change_type", str);
      localBundle.putParcelable("originalUri", localIntent.getData());
      setResult(-1, new Intent(this.h.toString()).putExtras(localBundle));
      this.m.post(new Runnable()
      {
        public void run()
        {
          CropImage.d(CropImage.this).a();
          paramBitmap.recycle();
        }
      });
      finish();
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        Logger localLogger = e;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.h;
        arrayOfObject[1] = localIOException;
        localLogger.d("Cannot open file: ?", arrayOfObject);
        e.a(localOutputStream);
      }
    }
    finally
    {
      e.a(localOutputStream);
    }
  }

  private void b()
  {
    if (this.c == null);
    while (this.b)
      return;
    this.b = true;
    Object localObject;
    if ((this.n != 0) && (this.o != 0) && (!this.p))
    {
      localObject = Bitmap.createBitmap(this.n, this.o, Bitmap.Config.RGB_565);
      Canvas localCanvas3 = new Canvas((Bitmap)localObject);
      Rect localRect3 = this.c.b();
      Rect localRect4 = new Rect(0, 0, this.n, this.o);
      int i3 = (localRect3.width() - localRect4.width()) / 2;
      int i4 = (localRect3.height() - localRect4.height()) / 2;
      localRect3.inset(Math.max(0, i3), Math.max(0, i4));
      localRect4.inset(Math.max(0, -i3), Math.max(0, -i4));
      localCanvas3.drawBitmap(this.t, localRect3, localRect4, null);
      this.r.a();
      this.t.recycle();
    }
    while (true)
    {
      this.r.a((Bitmap)localObject, true);
      this.r.a(true, true);
      this.r.a.clear();
      Bundle localBundle1 = getIntent().getExtras();
      Bitmap localBitmap;
      if ((localBundle1 != null) && ((localBundle1.getParcelable("data") != null) || (localBundle1.getBoolean("return-data"))))
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putParcelable("data", (Parcelable)localObject);
        setResult(-1, new Intent().setAction("inline-data").putExtras(localBundle2));
        finish();
        return;
        Rect localRect1 = this.c.b();
        int i1 = localRect1.width();
        int i2 = localRect1.height();
        localBitmap = Bitmap.createBitmap(i1, i2, f);
        if (this.w != null)
          if ((this.n == 0) || (this.o == 0) || (!this.p))
            break label549;
        label549: for (boolean bool = true; ; bool = false)
        {
          com.android.camera.b.a.a(this, this.t, localRect1, bool, this.q, this.w);
          Canvas localCanvas1 = new Canvas(localBitmap);
          Rect localRect2 = new Rect(0, 0, i1, i2);
          localCanvas1.drawBitmap(this.t, localRect1, localRect2, null);
          this.r.a();
          this.t.recycle();
          if (this.l)
          {
            Canvas localCanvas2 = new Canvas(localBitmap);
            Path localPath = new Path();
            localPath.addCircle(i1 / 2.0F, i2 / 2.0F, i1 / 2.0F, Path.Direction.CW);
            localCanvas2.clipPath(localPath, Region.Op.DIFFERENCE);
            localCanvas2.drawColor(0, PorterDuff.Mode.CLEAR);
          }
          if ((this.n == 0) || (this.o == 0) || (!this.p))
            break label585;
          localObject = e.a(new Matrix(), localBitmap, this.n, this.o, this.q, true);
          break;
        }
      }
      e.a(this, null, getResources().getString(R.string.savingImage), new Runnable()
      {
        public void run()
        {
          CropImage.b(CropImage.this, this.a);
        }
      }
      , this.m);
      return;
      label585: localObject = localBitmap;
    }
  }

  @SuppressLint({"NewApi"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.s = getContentResolver();
    setContentView(R.layout.cropimage);
    setActionBarTitle(R.string.crop_label);
    dj.c(this, false);
    this.r = ((CropImageView)findViewById(R.id.image));
    if (!com.viber.common.d.a.c())
      this.r.setLayerType(1, null);
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    if (localBundle != null)
    {
      if (localBundle.getString("circleCrop") != null)
      {
        this.l = true;
        this.i = 1;
        this.j = 1;
      }
      this.h = ((Uri)localBundle.getParcelable("output"));
      if (this.h != null)
      {
        String str = localBundle.getString("outputFormat");
        if (str != null)
          this.g = Bitmap.CompressFormat.valueOf(str);
      }
      this.t = ((Bitmap)localBundle.getParcelable("data"));
      this.i = localBundle.getInt("aspectX");
      this.j = localBundle.getInt("aspectY");
      this.n = localBundle.getInt("outputX");
      this.o = localBundle.getInt("outputY");
      this.p = localBundle.getBoolean("scale", true);
      this.q = localBundle.getBoolean("scaleUpIfNeeded", true);
      this.w = ((Uri)localBundle.getParcelable("landscapeUri"));
      if ((!localBundle.containsKey("noFaceDetection")) || (localBundle.getBoolean("noFaceDetection")))
        break label367;
    }
    label367: for (boolean bool = true; ; bool = false)
    {
      this.k = bool;
      if (this.t == null)
      {
        Uri localUri = localIntent.getData();
        this.u = ImageManager.a(getApplicationContext(), this.s, localUri, 1);
        this.v = this.u.a(localUri);
        if (this.v != null)
          this.t = this.v.a(true);
      }
      if (this.t == null)
        this.t = com.viber.voip.util.e.e.a(this, localIntent.getData(), false);
      if (this.t != null)
        break;
      finish();
      return;
    }
    getWindow().addFlags(1024);
    findViewById(R.id.discard).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CropImage.this.setResult(0);
        CropImage.this.finish();
      }
    });
    findViewById(R.id.save).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CropImage.a(CropImage.this);
      }
    });
    a();
  }

  protected void onDestroy()
  {
    if (this.u != null)
      this.u.a();
    super.onDestroy();
  }

  protected void onPause()
  {
    super.onPause();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.CropImage
 * JD-Core Version:    0.6.2
 */