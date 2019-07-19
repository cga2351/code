package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.aa.a;
import com.google.android.exoplayer2.aa.b;
import com.google.android.exoplayer2.aa.c;
import com.google.android.exoplayer2.ab;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.ui.a.f.c;
import com.google.android.exoplayer2.y;
import com.google.android.exoplayer2.z;
import java.util.List;

public class PlayerView extends FrameLayout
{
  private final AspectRatioFrameLayout a;
  private final View b;
  private final View c;
  private final ImageView d;
  private final SubtitleView e;
  private final View f;
  private final TextView g;
  private final c h;
  private final a i;
  private final FrameLayout j;
  private aa k;
  private boolean l;
  private boolean m;
  private Drawable n;
  private int o;
  private boolean p;
  private com.google.android.exoplayer2.g.g<? super i> q;
  private CharSequence r;
  private int s;
  private boolean t;
  private boolean u;
  private boolean v;
  private int w;

  public PlayerView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PlayerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PlayerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
    {
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = null;
      this.g = null;
      this.h = null;
      this.i = null;
      this.j = null;
      ImageView localImageView = new ImageView(paramContext);
      if (ag.a >= 23)
        a(getResources(), localImageView);
      while (true)
      {
        addView(localImageView);
        return;
        b(getResources(), localImageView);
      }
    }
    int i1 = R.layout.exo_player_view;
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
      localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.PlayerView, 0, 0);
    label949: label955: 
    while (true)
    {
      boolean bool6;
      int i8;
      int i2;
      boolean bool1;
      int i7;
      boolean bool2;
      int i3;
      int i6;
      int i4;
      boolean bool3;
      boolean bool4;
      boolean bool5;
      int i5;
      View localView;
      boolean bool8;
      try
      {
        bool6 = localTypedArray.hasValue(R.styleable.PlayerView_shutter_background_color);
        i8 = localTypedArray.getColor(R.styleable.PlayerView_shutter_background_color, 0);
        int i10 = localTypedArray.getResourceId(R.styleable.PlayerView_player_layout_id, i1);
        boolean bool10 = localTypedArray.getBoolean(R.styleable.PlayerView_use_artwork, true);
        int i11 = localTypedArray.getResourceId(R.styleable.PlayerView_default_artwork, 0);
        boolean bool11 = localTypedArray.getBoolean(R.styleable.PlayerView_use_controller, true);
        int i12 = localTypedArray.getInt(R.styleable.PlayerView_surface_type, 1);
        int i13 = localTypedArray.getInt(R.styleable.PlayerView_resize_mode, 0);
        int i14 = localTypedArray.getInt(R.styleable.PlayerView_show_timeout, 5000);
        boolean bool12 = localTypedArray.getBoolean(R.styleable.PlayerView_hide_on_touch, true);
        boolean bool13 = localTypedArray.getBoolean(R.styleable.PlayerView_auto_show, true);
        int i15 = localTypedArray.getInteger(R.styleable.PlayerView_show_buffering, 0);
        this.p = localTypedArray.getBoolean(R.styleable.PlayerView_keep_content_on_player_reset, this.p);
        boolean bool14 = localTypedArray.getBoolean(R.styleable.PlayerView_hide_during_ads, true);
        localTypedArray.recycle();
        i2 = i10;
        bool1 = bool10;
        i7 = i11;
        bool2 = bool11;
        i3 = i12;
        i6 = i13;
        i4 = i14;
        bool3 = bool12;
        bool4 = bool13;
        bool5 = bool14;
        i5 = i15;
        LayoutInflater.from(paramContext).inflate(i2, this);
        this.i = new a(null);
        setDescendantFocusability(262144);
        this.a = ((AspectRatioFrameLayout)findViewById(R.id.exo_content_frame));
        if (this.a != null)
          a(this.a, i6);
        this.b = findViewById(R.id.exo_shutter);
        if ((this.b != null) && (bool6))
          this.b.setBackgroundColor(i8);
        if ((this.a == null) || (i3 == 0))
          break label855;
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        switch (i3)
        {
        default:
          this.c = new SurfaceView(paramContext);
          this.c.setLayoutParams(localLayoutParams);
          this.a.addView(this.c, 0);
          this.j = ((FrameLayout)findViewById(R.id.exo_overlay));
          this.d = ((ImageView)findViewById(R.id.exo_artwork));
          if ((!bool1) || (this.d == null))
            break label863;
          bool7 = true;
          this.m = bool7;
          if (i7 != 0)
            this.n = ContextCompat.getDrawable(getContext(), i7);
          this.e = ((SubtitleView)findViewById(R.id.exo_subtitles));
          if (this.e != null)
          {
            this.e.b();
            this.e.a();
          }
          this.f = findViewById(R.id.exo_buffering);
          if (this.f != null)
            this.f.setVisibility(8);
          this.o = i5;
          this.g = ((TextView)findViewById(R.id.exo_error_message));
          if (this.g != null)
            this.g.setVisibility(8);
          c localc = (c)findViewById(R.id.exo_controller);
          localView = findViewById(R.id.exo_controller_placeholder);
          if (localc == null)
            break label869;
          this.h = localc;
          if (this.h == null)
            break label949;
          this.s = i4;
          this.v = bool3;
          this.t = bool4;
          this.u = bool5;
          if ((!bool2) || (this.h == null))
            break label955;
          bool8 = true;
          this.l = bool8;
          return;
        case 2:
        case 3:
        }
      }
      finally
      {
        localTypedArray.recycle();
      }
      this.c = new TextureView(paramContext);
      continue;
      if (ag.a >= 15);
      for (boolean bool9 = true; ; bool9 = false)
      {
        a.b(bool9);
        com.google.android.exoplayer2.ui.a.f localf = new com.google.android.exoplayer2.ui.a.f(paramContext);
        localf.setSurfaceListener(this.i);
        localf.setSingleTapListener(this.i);
        this.c = localf;
        break;
      }
      label855: this.c = null;
      continue;
      label863: boolean bool7 = false;
      continue;
      label869: if (localView != null)
      {
        this.h = new c(paramContext, null, 0, paramAttributeSet);
        this.h.setLayoutParams(localView.getLayoutParams());
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        int i9 = localViewGroup.indexOfChild(localView);
        localViewGroup.removeView(localView);
        localViewGroup.addView(this.h, i9);
      }
      else
      {
        this.h = null;
        continue;
        i4 = 0;
        continue;
        bool8 = false;
        continue;
        i2 = i1;
        bool1 = true;
        bool2 = true;
        i3 = 1;
        i4 = 5000;
        bool3 = true;
        bool4 = true;
        bool5 = true;
        i5 = 0;
        i6 = 0;
        i7 = 0;
        i8 = 0;
        bool6 = false;
      }
    }
  }

  @TargetApi(23)
  private static void a(Resources paramResources, ImageView paramImageView)
  {
    paramImageView.setImageDrawable(paramResources.getDrawable(R.drawable.exo_edit_mode_logo, null));
    paramImageView.setBackgroundColor(paramResources.getColor(R.color.exo_edit_mode_background_color, null));
  }

  private static void a(AspectRatioFrameLayout paramAspectRatioFrameLayout, int paramInt)
  {
    paramAspectRatioFrameLayout.setResizeMode(paramInt);
  }

  private void a(boolean paramBoolean)
  {
    if ((e()) && (this.u))
      break label14;
    label14: 
    while (!this.l)
      return;
    if ((this.h.c()) && (this.h.getShowTimeoutMs() <= 0));
    for (int i1 = 1; ; i1 = 0)
    {
      boolean bool = d();
      if ((!paramBoolean) && (i1 == 0) && (!bool))
        break;
      b(bool);
      return;
    }
  }

  @SuppressLint({"InlinedApi"})
  private boolean a(int paramInt)
  {
    return (paramInt == 19) || (paramInt == 270) || (paramInt == 22) || (paramInt == 271) || (paramInt == 20) || (paramInt == 269) || (paramInt == 21) || (paramInt == 268) || (paramInt == 23);
  }

  private boolean a(Drawable paramDrawable)
  {
    boolean bool = false;
    if (paramDrawable != null)
    {
      int i1 = paramDrawable.getIntrinsicWidth();
      int i2 = paramDrawable.getIntrinsicHeight();
      bool = false;
      if (i1 > 0)
      {
        bool = false;
        if (i2 > 0)
        {
          a(i1 / i2, this.a, this.d);
          this.d.setImageDrawable(paramDrawable);
          this.d.setVisibility(0);
          bool = true;
        }
      }
    }
    return bool;
  }

  private boolean a(Metadata paramMetadata)
  {
    for (int i1 = 0; ; i1++)
    {
      int i2 = paramMetadata.length();
      boolean bool = false;
      if (i1 < i2)
      {
        Metadata.Entry localEntry = paramMetadata.get(i1);
        if ((localEntry instanceof ApicFrame))
        {
          byte[] arrayOfByte = ((ApicFrame)localEntry).pictureData;
          Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
          bool = a(new BitmapDrawable(getResources(), localBitmap));
        }
      }
      else
      {
        return bool;
      }
    }
  }

  private static void b(Resources paramResources, ImageView paramImageView)
  {
    paramImageView.setImageDrawable(paramResources.getDrawable(R.drawable.exo_edit_mode_logo));
    paramImageView.setBackgroundColor(paramResources.getColor(R.color.exo_edit_mode_background_color));
  }

  private static void b(TextureView paramTextureView, int paramInt)
  {
    float f1 = paramTextureView.getWidth();
    float f2 = paramTextureView.getHeight();
    if ((f1 == 0.0F) || (f2 == 0.0F) || (paramInt == 0))
    {
      paramTextureView.setTransform(null);
      return;
    }
    Matrix localMatrix = new Matrix();
    float f3 = f1 / 2.0F;
    float f4 = f2 / 2.0F;
    localMatrix.postRotate(paramInt, f3, f4);
    RectF localRectF1 = new RectF(0.0F, 0.0F, f1, f2);
    RectF localRectF2 = new RectF();
    localMatrix.mapRect(localRectF2, localRectF1);
    localMatrix.postScale(f1 / localRectF2.width(), f2 / localRectF2.height(), f3, f4);
    paramTextureView.setTransform(localMatrix);
  }

  private void b(boolean paramBoolean)
  {
    if (!this.l)
      return;
    c localc = this.h;
    if (paramBoolean);
    for (int i1 = 0; ; i1 = this.s)
    {
      localc.setShowTimeoutMs(i1);
      this.h.a();
      return;
    }
  }

  private void c(boolean paramBoolean)
  {
    if ((this.k == null) || (this.k.A().isEmpty()))
      if (!this.p)
      {
        f();
        g();
      }
    label191: label197: 
    do
    {
      return;
      if ((paramBoolean) && (!this.p))
        g();
      com.google.android.exoplayer2.trackselection.g localg = this.k.B();
      for (int i1 = 0; i1 < localg.a; i1++)
        if ((this.k.b(i1) == 2) && (localg.a(i1) != null))
        {
          f();
          return;
        }
      g();
      if (!this.m)
        break;
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= localg.a)
          break label197;
        com.google.android.exoplayer2.trackselection.e locale = localg.a(i2);
        if (locale != null)
          for (int i3 = 0; ; i3++)
          {
            if (i3 >= locale.g())
              break label191;
            Metadata localMetadata = locale.a(i3).metadata;
            if ((localMetadata != null) && (a(localMetadata)))
              break;
          }
      }
    }
    while (a(this.n));
    f();
  }

  private boolean c()
  {
    boolean bool = true;
    if ((!this.l) || (this.k == null))
      bool = false;
    do
    {
      return bool;
      if (!this.h.c())
      {
        a(bool);
        return bool;
      }
    }
    while (!this.v);
    this.h.b();
    return bool;
  }

  private boolean d()
  {
    if (this.k == null);
    int i1;
    do
    {
      return true;
      i1 = this.k.j();
    }
    while ((this.t) && ((i1 == 1) || (i1 == 4) || (!this.k.l())));
    return false;
  }

  private boolean e()
  {
    return (this.k != null) && (this.k.v()) && (this.k.l());
  }

  private void f()
  {
    if (this.d != null)
    {
      this.d.setImageResource(17170445);
      this.d.setVisibility(4);
    }
  }

  private void g()
  {
    if (this.b != null)
      this.b.setVisibility(0);
  }

  private void h()
  {
    int i1 = 1;
    View localView;
    int i2;
    if (this.f != null)
    {
      if ((this.k == null) || (this.k.j() != 2) || ((this.o != 2) && ((this.o != i1) || (!this.k.l()))))
        break label74;
      localView = this.f;
      i2 = 0;
      if (i1 == 0)
        break label79;
    }
    while (true)
    {
      localView.setVisibility(i2);
      return;
      label74: i1 = 0;
      break;
      label79: i2 = 8;
    }
  }

  private void i()
  {
    if (this.g != null)
    {
      if (this.r != null)
      {
        this.g.setText(this.r);
        this.g.setVisibility(0);
      }
    }
    else
      return;
    aa localaa = this.k;
    i locali = null;
    if (localaa != null)
    {
      int i1 = this.k.j();
      locali = null;
      if (i1 == 1)
      {
        com.google.android.exoplayer2.g.g localg = this.q;
        locali = null;
        if (localg != null)
          locali = this.k.k();
      }
    }
    if (locali != null)
    {
      CharSequence localCharSequence = (CharSequence)this.q.a(locali).second;
      this.g.setText(localCharSequence);
      this.g.setVisibility(0);
      return;
    }
    this.g.setVisibility(8);
  }

  public void a()
  {
    b(d());
  }

  protected void a(float paramFloat, AspectRatioFrameLayout paramAspectRatioFrameLayout, View paramView)
  {
    if (paramAspectRatioFrameLayout != null)
    {
      if ((paramView instanceof com.google.android.exoplayer2.ui.a.f))
        paramFloat = 0.0F;
      paramAspectRatioFrameLayout.setAspectRatio(paramFloat);
    }
  }

  public boolean a(KeyEvent paramKeyEvent)
  {
    return (this.l) && (this.h.a(paramKeyEvent));
  }

  public void b()
  {
    if (this.h != null)
      this.h.b();
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool1;
    if ((this.k != null) && (this.k.v()))
    {
      this.j.requestFocus();
      bool1 = super.dispatchKeyEvent(paramKeyEvent);
      return bool1;
    }
    if ((a(paramKeyEvent.getKeyCode())) && (this.l) && (!this.h.c()));
    for (int i1 = 1; ; i1 = 0)
    {
      if ((i1 == 0) && (!a(paramKeyEvent)))
      {
        boolean bool2 = super.dispatchKeyEvent(paramKeyEvent);
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = true;
      }
      if (!bool1)
        break;
      a(true);
      return bool1;
    }
  }

  public boolean getControllerAutoShow()
  {
    return this.t;
  }

  public boolean getControllerHideOnTouch()
  {
    return this.v;
  }

  public int getControllerShowTimeoutMs()
  {
    return this.s;
  }

  public Drawable getDefaultArtwork()
  {
    return this.n;
  }

  public FrameLayout getOverlayFrameLayout()
  {
    return this.j;
  }

  public aa getPlayer()
  {
    return this.k;
  }

  public int getResizeMode()
  {
    if (this.a != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      return this.a.getResizeMode();
    }
  }

  public SubtitleView getSubtitleView()
  {
    return this.e;
  }

  public boolean getUseArtwork()
  {
    return this.m;
  }

  public boolean getUseController()
  {
    return this.l;
  }

  public View getVideoSurfaceView()
  {
    return this.c;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() != 0)
      return false;
    return c();
  }

  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.l) || (this.k == null))
      return false;
    a(true);
    return true;
  }

  public void setAspectRatioListener(AspectRatioFrameLayout.a parama)
  {
    if (this.a != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.a.setAspectRatioListener(parama);
      return;
    }
  }

  public void setControlDispatcher(d paramd)
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.h.setControlDispatcher(paramd);
      return;
    }
  }

  public void setControllerAutoShow(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }

  public void setControllerHideDuringAds(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }

  public void setControllerHideOnTouch(boolean paramBoolean)
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.v = paramBoolean;
      return;
    }
  }

  public void setControllerShowTimeoutMs(int paramInt)
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.s = paramInt;
      if (this.h.c())
        a();
      return;
    }
  }

  public void setControllerVisibilityListener(c.b paramb)
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.h.setVisibilityListener(paramb);
      return;
    }
  }

  public void setCustomErrorMessage(CharSequence paramCharSequence)
  {
    if (this.g != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.r = paramCharSequence;
      i();
      return;
    }
  }

  @Deprecated
  public void setDefaultArtwork(Bitmap paramBitmap)
  {
    if (paramBitmap == null);
    for (Object localObject = null; ; localObject = new BitmapDrawable(getResources(), paramBitmap))
    {
      setDefaultArtwork((Drawable)localObject);
      return;
    }
  }

  public void setDefaultArtwork(Drawable paramDrawable)
  {
    if (this.n != paramDrawable)
    {
      this.n = paramDrawable;
      c(false);
    }
  }

  public void setErrorMessageProvider(com.google.android.exoplayer2.g.g<? super i> paramg)
  {
    if (this.q != paramg)
    {
      this.q = paramg;
      i();
    }
  }

  public void setFastForwardIncrementMs(int paramInt)
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.h.setFastForwardIncrementMs(paramInt);
      return;
    }
  }

  public void setKeepContentOnPlayerReset(boolean paramBoolean)
  {
    if (this.p != paramBoolean)
    {
      this.p = paramBoolean;
      c(false);
    }
  }

  public void setPlaybackPreparer(z paramz)
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.h.setPlaybackPreparer(paramz);
      return;
    }
  }

  public void setPlayer(aa paramaa)
  {
    boolean bool1;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      bool1 = true;
      a.b(bool1);
      if ((paramaa != null) && (paramaa.i() != Looper.getMainLooper()))
        break label51;
    }
    label51: for (boolean bool2 = true; ; bool2 = false)
    {
      a.a(bool2);
      if (this.k != paramaa)
        break label56;
      return;
      bool1 = false;
      break;
    }
    label56: aa.c localc2;
    if (this.k != null)
    {
      this.k.b(this.i);
      localc2 = this.k.g();
      if (localc2 != null)
      {
        localc2.b(this.i);
        if (!(this.c instanceof TextureView))
          break label294;
        localc2.b((TextureView)this.c);
      }
      aa.b localb2 = this.k.h();
      if (localb2 != null)
        localb2.b(this.i);
    }
    this.k = paramaa;
    if (this.l)
      this.h.setPlayer(paramaa);
    if (this.e != null)
      this.e.setCues(null);
    h();
    i();
    c(true);
    if (paramaa != null)
    {
      aa.c localc1 = paramaa.g();
      if (localc1 != null)
      {
        if (!(this.c instanceof TextureView))
          break label345;
        localc1.a((TextureView)this.c);
      }
      while (true)
      {
        localc1.a(this.i);
        aa.b localb1 = paramaa.h();
        if (localb1 != null)
          localb1.a(this.i);
        paramaa.a(this.i);
        a(false);
        return;
        label294: if ((this.c instanceof com.google.android.exoplayer2.ui.a.f))
        {
          ((com.google.android.exoplayer2.ui.a.f)this.c).setVideoComponent(null);
          break;
        }
        if (!(this.c instanceof SurfaceView))
          break;
        localc2.b((SurfaceView)this.c);
        break;
        label345: if ((this.c instanceof com.google.android.exoplayer2.ui.a.f))
          ((com.google.android.exoplayer2.ui.a.f)this.c).setVideoComponent(localc1);
        else if ((this.c instanceof SurfaceView))
          localc1.a((SurfaceView)this.c);
      }
    }
    b();
  }

  public void setRepeatToggleModes(int paramInt)
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.h.setRepeatToggleModes(paramInt);
      return;
    }
  }

  public void setResizeMode(int paramInt)
  {
    if (this.a != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.a.setResizeMode(paramInt);
      return;
    }
  }

  public void setRewindIncrementMs(int paramInt)
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.h.setRewindIncrementMs(paramInt);
      return;
    }
  }

  public void setShowBuffering(int paramInt)
  {
    if (this.o != paramInt)
    {
      this.o = paramInt;
      h();
    }
  }

  @Deprecated
  public void setShowBuffering(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 1; ; i1 = 0)
    {
      setShowBuffering(i1);
      return;
    }
  }

  public void setShowMultiWindowTimeBar(boolean paramBoolean)
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.h.setShowMultiWindowTimeBar(paramBoolean);
      return;
    }
  }

  public void setShowShuffleButton(boolean paramBoolean)
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.h.setShowShuffleButton(paramBoolean);
      return;
    }
  }

  public void setShutterBackgroundColor(int paramInt)
  {
    if (this.b != null)
      this.b.setBackgroundColor(paramInt);
  }

  public void setUseArtwork(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.d != null));
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      if (this.m != paramBoolean)
      {
        this.m = paramBoolean;
        c(false);
      }
      return;
    }
  }

  public void setUseController(boolean paramBoolean)
  {
    boolean bool;
    if ((!paramBoolean) || (this.h != null))
    {
      bool = true;
      a.b(bool);
      if (this.l != paramBoolean)
        break label31;
    }
    label31: 
    do
    {
      return;
      bool = false;
      break;
      this.l = paramBoolean;
      if (paramBoolean)
      {
        this.h.setPlayer(this.k);
        return;
      }
    }
    while (this.h == null);
    this.h.b();
    this.h.setPlayer(null);
  }

  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((this.c instanceof SurfaceView))
      this.c.setVisibility(paramInt);
  }

  private final class a
    implements View.OnLayoutChangeListener, aa.a, k, com.google.android.exoplayer2.ui.a.e, f.c, com.google.android.exoplayer2.video.f
  {
    private a()
    {
    }

    public void a(Surface paramSurface)
    {
      if (PlayerView.j(PlayerView.this) != null)
      {
        aa.c localc = PlayerView.j(PlayerView.this).g();
        if (localc != null)
          localc.b(paramSurface);
      }
    }

    public void a(List<b> paramList)
    {
      if (PlayerView.a(PlayerView.this) != null)
        PlayerView.a(PlayerView.this).a(paramList);
    }

    public boolean a(MotionEvent paramMotionEvent)
    {
      return PlayerView.k(PlayerView.this);
    }

    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      PlayerView.a((TextureView)paramView, PlayerView.c(PlayerView.this));
    }

    public void onLoadingChanged(boolean paramBoolean)
    {
      ab.a(this, paramBoolean);
    }

    public void onPlaybackParametersChanged(y paramy)
    {
      ab.a(this, paramy);
    }

    public void onPlayerError(i parami)
    {
      ab.a(this, parami);
    }

    public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
    {
      PlayerView.f(PlayerView.this);
      PlayerView.g(PlayerView.this);
      if ((PlayerView.h(PlayerView.this)) && (PlayerView.i(PlayerView.this)))
      {
        PlayerView.this.b();
        return;
      }
      PlayerView.b(PlayerView.this, false);
    }

    public void onPositionDiscontinuity(int paramInt)
    {
      if ((PlayerView.h(PlayerView.this)) && (PlayerView.i(PlayerView.this)))
        PlayerView.this.b();
    }

    public void onRenderedFirstFrame()
    {
      if (PlayerView.e(PlayerView.this) != null)
        PlayerView.e(PlayerView.this).setVisibility(4);
    }

    public void onRepeatModeChanged(int paramInt)
    {
      ab.a(this, paramInt);
    }

    public void onSeekProcessed()
    {
      ab.a(this);
    }

    public void onShuffleModeEnabledChanged(boolean paramBoolean)
    {
      ab.b(this, paramBoolean);
    }

    public void onSurfaceSizeChanged(int paramInt1, int paramInt2)
    {
      com.google.android.exoplayer2.video.g.a(this, paramInt1, paramInt2);
    }

    public void onTimelineChanged(ak paramak, Object paramObject, int paramInt)
    {
      ab.a(this, paramak, paramObject, paramInt);
    }

    public void onTracksChanged(TrackGroupArray paramTrackGroupArray, com.google.android.exoplayer2.trackselection.g paramg)
    {
      PlayerView.a(PlayerView.this, false);
    }

    public void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      float f1;
      float f2;
      if ((paramInt2 == 0) || (paramInt1 == 0))
      {
        f1 = 1.0F;
        if (!(PlayerView.b(PlayerView.this) instanceof TextureView))
          break label158;
        if ((paramInt3 != 90) && (paramInt3 != 270))
          break label151;
        f2 = 1.0F / f1;
        label43: if (PlayerView.c(PlayerView.this) != 0)
          PlayerView.b(PlayerView.this).removeOnLayoutChangeListener(this);
        PlayerView.a(PlayerView.this, paramInt3);
        if (PlayerView.c(PlayerView.this) != 0)
          PlayerView.b(PlayerView.this).addOnLayoutChangeListener(this);
        PlayerView.a((TextureView)PlayerView.b(PlayerView.this), PlayerView.c(PlayerView.this));
      }
      while (true)
      {
        PlayerView.this.a(f2, PlayerView.d(PlayerView.this), PlayerView.b(PlayerView.this));
        return;
        f1 = paramFloat * paramInt1 / paramInt2;
        break;
        label151: f2 = f1;
        break label43;
        label158: f2 = f1;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.PlayerView
 * JD-Core Version:    0.6.2
 */