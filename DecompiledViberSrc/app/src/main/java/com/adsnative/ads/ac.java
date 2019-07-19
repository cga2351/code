package com.adsnative.ads;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.adsnative.c.e;
import com.adsnative.c.e.b;
import com.adsnative.c.e.c;
import com.adsnative.c.i;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ac extends SurfaceView
  implements MediaPlayer.OnPreparedListener, SurfaceHolder.Callback, x.a
{
  private static int L = 0;
  private static boolean M = false;
  private HashMap<String, Object> A;
  private ImageView B;
  private RotateAnimation C;
  private ImageButton D;
  private boolean E = false;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private boolean I = true;
  private CountDownTimer J;
  private ac K;
  private MediaPlayer.OnCompletionListener N = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      ac.a(ac.this, 5);
      ac.b(ac.this, 5);
      if ((ac.j(ac.this) == null) || (ac.m(ac.this) != null))
        ac.m(ac.this).onCompletion(ac.a(ac.this));
    }
  };
  private MediaPlayer.OnInfoListener O = new MediaPlayer.OnInfoListener()
  {
    public boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (ac.n(ac.this) != null)
        ac.n(ac.this).onInfo(paramAnonymousMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
      return true;
    }
  };
  private MediaPlayer.OnErrorListener P = new MediaPlayer.OnErrorListener()
  {
    public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      Log.d(ac.o(ac.this), "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      i.e("PMVideoView -> MediaPlayer.OnErrorListener -> onError()");
      ac.d(ac.this).a(ac.c(ac.this));
      ac.a(ac.this, -1);
      ac.b(ac.this, -1);
      if ((ac.j(ac.this) == null) || ((ac.p(ac.this) != null) && (ac.p(ac.this).onError(ac.a(ac.this), paramAnonymousInt1, paramAnonymousInt2))));
      return true;
    }
  };
  private MediaPlayer.OnBufferingUpdateListener Q = new MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      ac.e(ac.this, paramAnonymousInt);
    }
  };
  MediaPlayer.OnVideoSizeChangedListener a = new MediaPlayer.OnVideoSizeChangedListener()
  {
    public void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ac.c(ac.this, paramAnonymousMediaPlayer.getVideoWidth());
      ac.d(ac.this, paramAnonymousMediaPlayer.getVideoHeight());
      if ((ac.k(ac.this) != 0) && (ac.l(ac.this) != 0))
      {
        ac.this.getHolder().setFixedSize(ac.k(ac.this), ac.l(ac.this));
        ac.this.requestLayout();
      }
    }
  };
  private String b = "PMVideoView";
  private final e c;
  private boolean d = false;
  private Handler e = new a(this);
  private h.c f;
  private HashMap<String, Boolean> g;
  private HashMap<String, JSONArray> h;
  private ArrayList<String> i;
  private ArrayList<String> j;
  private h.a k;
  private int l = 0;
  private int m = 0;
  private Context n;
  private int o;
  private int p;
  private int q;
  private Uri r;
  private x s;
  private MediaPlayer.OnCompletionListener t;
  private MediaPlayer.OnPreparedListener u;
  private int v;
  private MediaPlayer.OnErrorListener w;
  private MediaPlayer.OnInfoListener x;
  private MediaPlayer y = null;
  private SurfaceHolder z = null;

  public ac(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    super(paramContext);
    this.n = paramContext;
    this.c = e.a(this.n);
    if (paramHashMap != null);
    for (this.A = paramHashMap; ; this.A = new HashMap())
    {
      l();
      return;
    }
  }

  public static void a(int paramInt, boolean paramBoolean)
  {
    L = paramInt;
    M = paramBoolean;
  }

  private void b(boolean paramBoolean)
  {
    if (this.y != null)
    {
      this.y.reset();
      this.y.release();
      this.y = null;
      this.l = 0;
      if (paramBoolean)
        this.m = 0;
    }
  }

  private long getProgressPercentage()
  {
    if (this.y != null)
    {
      int i1 = this.y.getCurrentPosition();
      int i2 = this.y.getDuration();
      return 100L * i1 / i2;
    }
    return 0L;
  }

  private String getQuartileTrackingDataForFullscreen()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Boolean localBoolean = (Boolean)this.g.get(str);
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
          localJSONObject.put(str, this.h.get(str));
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }

  private String getVideoCompleteTrackingDataForFullscreen()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
      localJSONArray.put((String)localIterator.next());
    return localJSONArray.toString();
  }

  private HashMap<String, Boolean> getVideoQuartiles()
  {
    HashMap localHashMap = new HashMap();
    if (this.h != null)
    {
      Iterator localIterator = this.h.keySet().iterator();
      while (localIterator.hasNext())
        localHashMap.put((String)localIterator.next(), new Boolean(false));
    }
    return localHashMap;
  }

  private void l()
  {
    this.K = this;
    this.p = 0;
    this.q = 0;
    getHolder().addCallback(this);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    this.l = 0;
    this.m = 0;
    e();
    f();
  }

  private void m()
  {
    if ((this.r == null) || (this.z == null))
      return;
    ((AudioManager)this.n.getSystemService("audio")).requestAudioFocus(null, 3, 1);
    b(false);
    try
    {
      this.y = new MediaPlayer();
      if (this.o != 0)
      {
        this.y.setAudioSessionId(this.o);
        this.y.setOnPreparedListener(this);
        this.y.setOnVideoSizeChangedListener(this.a);
        this.y.setOnCompletionListener(this.N);
        this.y.setOnErrorListener(this.P);
        this.y.setOnInfoListener(this.O);
        this.y.setOnBufferingUpdateListener(this.Q);
        this.v = 0;
        this.y.setDataSource(this.r.toString());
        if (this.z != null)
          this.y.setDisplay(this.z);
        this.y.setAudioStreamType(3);
        this.y.setScreenOnWhilePlaying(true);
        this.y.prepareAsync();
        if (this.l != 2)
          this.l = 1;
        n();
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        this.l = -1;
        this.m = -1;
        localIllegalArgumentException.printStackTrace();
        return;
        this.o = this.y.getAudioSessionId();
      }
    }
    catch (IOException localIOException)
    {
      this.l = -1;
      this.m = -1;
      localIOException.printStackTrace();
    }
  }

  private void n()
  {
    if ((this.y != null) && (this.s != null))
    {
      this.s.setMediaPlayer(this);
      if ((this.s.getAnchorView() != null) && (!this.s.a()))
        this.s.b();
      this.s.setEnabled(o());
    }
  }

  private boolean o()
  {
    return (this.y != null) && (this.l != -1) && (this.l != 0) && (this.l != 1);
  }

  private void p()
  {
    this.d = true;
    this.e.sendEmptyMessage(1);
  }

  public void a()
  {
    if ((o()) && (this.y.isPlaying()))
    {
      this.y.pause();
      if ((this.D.getVisibility() == 8) || (this.D.getVisibility() == 4))
        this.D.setVisibility(0);
      this.l = 4;
      L = this.y.getCurrentPosition();
    }
    this.m = 4;
  }

  public void a(int paramInt)
  {
    if (this.y != null)
      this.y.seekTo(paramInt);
  }

  public void a(boolean paramBoolean)
  {
    if (o())
    {
      this.y.start();
      if (this.D.getVisibility() == 0)
        this.D.setVisibility(8);
      if (paramBoolean)
        this.y.setVolume(0.0F, 0.0F);
      this.l = 3;
    }
    this.m = 3;
  }

  public boolean b()
  {
    MediaPlayer localMediaPlayer = this.y;
    boolean bool1 = false;
    if (localMediaPlayer != null)
    {
      boolean bool2 = o();
      bool1 = false;
      if (bool2)
      {
        boolean bool3 = this.y.isPlaying();
        bool1 = false;
        if (bool3)
          bool1 = true;
      }
    }
    return bool1;
  }

  public boolean c()
  {
    return this.G;
  }

  public void d()
  {
    if (this.J != null)
      this.J.cancel();
    Intent localIntent = new Intent(this.n, FullscreenVideoActivity.class);
    localIntent.putExtra("videoUrl", this.r.toString());
    localIntent.putExtra("seekTo", getCurrentPosition());
    if (this.l == 3);
    for (boolean bool = true; ; bool = false)
    {
      localIntent.putExtra("targetState", bool);
      localIntent.putExtra("quartileTrackingData", getQuartileTrackingDataForFullscreen());
      localIntent.putExtra("vidCompleteTrackingData", getVideoCompleteTrackingDataForFullscreen());
      localIntent.putExtra("playButtonUrl", (String)this.A.get("playButtonUrl"));
      localIntent.putExtra("expandButtonUrl", (String)this.A.get("expandButtonUrl"));
      localIntent.putExtra("closeButtonUrl", (String)this.A.get("closeButtonUrl"));
      this.n.startActivity(localIntent);
      return;
    }
  }

  public void e()
  {
    this.B = new ImageView(this.n);
    this.B.setLayoutParams(new FrameLayout.LayoutParams((int)TypedValue.applyDimension(1, 25.0F, getResources().getDisplayMetrics()), (int)TypedValue.applyDimension(1, 25.0F, getResources().getDisplayMetrics()), 17));
    try
    {
      InputStream localInputStream = this.n.getAssets().open("video_spinner.png");
      this.B.setImageDrawable(Drawable.createFromStream(localInputStream, null));
      this.B.setBackgroundColor(-16777216);
      this.B.setVisibility(0);
      this.C = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      this.C.setInterpolator(new LinearInterpolator());
      this.C.setDuration(5000L);
      this.C.setRepeatCount(-1);
      this.C.setRepeatMode(1);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        i.e("Failed to load default spinner image for PMVideoView");
        localIOException.printStackTrace();
      }
    }
  }

  public void f()
  {
    this.D = new ImageButton(this.n);
    this.D.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    try
    {
      this.c.a((String)this.A.get("playButtonUrl"), new e.c()
      {
        public void a()
        {
          try
          {
            InputStream localInputStream = ac.f(ac.this).getAssets().open("video_play.png");
            ac.e(ac.this).setImageDrawable(Drawable.createFromStream(localInputStream, null));
            return;
          }
          catch (IOException localIOException)
          {
            i.e("Failed to load default play button in PMVideoView");
            localIOException.printStackTrace();
          }
        }

        public void a(e.b paramAnonymousb)
        {
          ac.e(ac.this).setImageBitmap(paramAnonymousb.a());
        }
      });
      this.D.setBackgroundColor(Color.parseColor("#66000000"));
      this.D.setVisibility(8);
      this.D.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ac.g(ac.this).c();
          if (ac.h(ac.this))
          {
            if (!ac.a(ac.this).isPlaying())
              break label113;
            if (ac.i(ac.this))
            {
              ac.this.k();
              ac.a(ac.this, false);
            }
          }
          else
          {
            return;
          }
          ac.a(ac.this).pause();
          ac.a(ac.this, 4);
          ac.b(ac.this, 4);
          ac.e(ac.this).setVisibility(0);
          h.a(ac.c(ac.this), false);
          return;
          label113: ac.a(ac.this).start();
          ac.a(ac.this, 3);
          ac.b(ac.this, 3);
          ac.e(ac.this).setVisibility(8);
          if (ac.j(ac.this) != null)
            ac.j(ac.this).d();
          h.a(ac.c(ac.this), true);
        }
      });
      return;
    }
    catch (IOException localIOException1)
    {
      while (true)
        try
        {
          InputStream localInputStream = this.n.getAssets().open("video_play.png");
          this.D.setImageDrawable(Drawable.createFromStream(localInputStream, null));
        }
        catch (IOException localIOException2)
        {
          i.e("Failed to load default play button in PMVideoView");
          localIOException2.printStackTrace();
        }
    }
  }

  public void g()
  {
    h();
    L = 0;
    this.s = null;
  }

  public int getAudioSessionId()
  {
    if (this.o == 0)
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      this.o = localMediaPlayer.getAudioSessionId();
      localMediaPlayer.release();
    }
    return this.o;
  }

  public int getBufferPercentage()
  {
    if (this.y != null)
      return this.v;
    return 0;
  }

  public int getCurrentPosition()
  {
    if (this.y != null)
      return this.y.getCurrentPosition();
    return 0;
  }

  public int getDuration()
  {
    if (this.y != null)
      return this.y.getDuration();
    return 0;
  }

  public void h()
  {
    if (this.y != null)
    {
      this.y.stop();
      this.y.release();
      this.y = null;
      this.l = 0;
      this.m = 0;
    }
  }

  public void i()
  {
    if (this.I)
    {
      this.H = true;
      this.I = false;
      a(true);
      this.f.b();
    }
  }

  public void j()
  {
    if ((this.y != null) && (this.y.isPlaying()))
    {
      this.I = true;
      a();
    }
  }

  public void k()
  {
    if (this.y != null)
      this.y.setVolume(1.0F, 1.0F);
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ac.class.getName());
  }

  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(ac.class.getName());
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getDefaultSize(this.p, paramInt1);
    int i2 = getDefaultSize(this.q, paramInt2);
    int i3;
    int i4;
    int i5;
    if ((this.p > 0) && (this.q > 0))
    {
      i3 = View.MeasureSpec.getMode(paramInt1);
      i4 = View.MeasureSpec.getSize(paramInt1);
      i5 = View.MeasureSpec.getMode(paramInt2);
      i2 = View.MeasureSpec.getSize(paramInt2);
      if ((i3 != 1073741824) || (i5 != 1073741824))
        break label148;
      if (i2 * this.p >= i4 * this.q)
        break label111;
      i1 = i2 * this.p / this.q;
    }
    label148: label314: 
    while (true)
    {
      setMeasuredDimension(i1, i2);
      return;
      label111: if (i2 * this.p > i4 * this.q)
      {
        i2 = i4 * this.q / this.p;
        i1 = i4;
        continue;
        int i8;
        if (i3 == 1073741824)
        {
          i8 = i4 * this.q / this.p;
          if ((i5 == -2147483648) && (i8 > i2))
            i1 = i4;
        }
        else if (i5 == 1073741824)
        {
          i1 = i2 * this.p / this.q;
          if ((i3 == -2147483648) && (i1 > i4))
            i1 = i4;
        }
        else
        {
          int i6 = this.p;
          int i7 = this.q;
          if ((i5 == -2147483648) && (i7 > i2));
          for (i1 = i2 * this.p / this.q; ; i1 = i6)
          {
            if ((i3 != -2147483648) || (i1 <= i4))
              break label314;
            i2 = i4 * this.q / this.p;
            i1 = i4;
            break;
            i2 = i7;
          }
          continue;
          i2 = i8;
          i1 = i4;
        }
      }
      else
      {
        i1 = i4;
      }
    }
  }

  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.l = 2;
    this.f.a();
    if (this.u != null)
      this.u.onPrepared(this.y);
    this.p = paramMediaPlayer.getVideoWidth();
    this.q = paramMediaPlayer.getVideoHeight();
    if ((this.p != 0) && (this.q != 0))
      getHolder().setFixedSize(this.p, this.q);
    if (this.E)
    {
      FrameLayout localFrameLayout2 = (FrameLayout)getParent();
      if (localFrameLayout2 != null)
      {
        this.C.cancel();
        this.C.reset();
        this.C = null;
        this.B.clearAnimation();
        this.B.setVisibility(8);
        localFrameLayout2.removeView(this.B);
        this.B = null;
        this.E = false;
      }
    }
    if (!this.F)
    {
      FrameLayout localFrameLayout1 = (FrameLayout)getParent();
      if (localFrameLayout1 != null)
      {
        localFrameLayout1.addView(this.D);
        this.F = true;
      }
    }
    if (!M)
    {
      L = 0;
      if ((L != 0) && (this.y != null))
      {
        if (this.m != 3)
        {
          this.y.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
          {
            public void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
            {
              ac.a(ac.this).pause();
            }
          });
          this.y.start();
        }
        this.y.seekTo(L);
      }
      if (this.m != 3)
        break label330;
      if (L != 0)
        a(L);
      if (!this.H)
        break label322;
      a(true);
    }
    while (true)
    {
      if (this.s != null)
      {
        this.s.setEnabled(true);
        this.s.d();
      }
      if (!this.d)
        p();
      return;
      M = false;
      break;
      label322: a(false);
      continue;
      label330: this.D.setVisibility(0);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.f.c();
    if (o())
    {
      if (!this.y.isPlaying())
        break label79;
      if (this.H)
      {
        k();
        this.H = false;
      }
    }
    else
    {
      return false;
    }
    this.y.pause();
    this.l = 4;
    this.m = 4;
    this.D.setVisibility(0);
    h.a(this.K, false);
    return false;
    label79: this.y.start();
    this.l = 3;
    this.m = 3;
    this.D.setVisibility(8);
    if (this.s != null)
      this.s.d();
    h.a(this.K, true);
    return false;
  }

  public void setFullScreenByDefault(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }

  public void setMediaController(x paramx)
  {
    if (this.s != null);
    this.s = paramx;
    n();
  }

  public void setMediaLoadListener(h.a parama)
  {
    this.k = parama;
  }

  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.t = paramOnCompletionListener;
  }

  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.w = paramOnErrorListener;
  }

  public void setOnInfoListener(MediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.x = paramOnInfoListener;
  }

  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.u = paramOnPreparedListener;
  }

  public void setQuartilesToTrack(HashMap<String, JSONArray> paramHashMap)
  {
    this.h = paramHashMap;
    this.g = getVideoQuartiles();
    this.i = new ArrayList(this.g.keySet());
    Collections.sort(this.i);
  }

  public void setTargetStateToPlay(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.m = 3;
      return;
    }
    this.m = 4;
  }

  public void setTrackersListener(h.c paramc)
  {
    this.f = paramc;
  }

  public void setVideoCompleteTrackers(ArrayList<String> paramArrayList)
  {
    this.j = paramArrayList;
  }

  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }

  public void setVideoURI(Uri paramUri)
  {
    this.r = paramUri;
    if (!this.E)
    {
      FrameLayout localFrameLayout = (FrameLayout)getParent();
      if (localFrameLayout != null)
      {
        localFrameLayout.addView(this.B);
        this.B.startAnimation(this.C);
        this.E = true;
      }
    }
    m();
    requestLayout();
    invalidate();
    this.J = new CountDownTimer(5000L, 5000L)
    {
      public void onFinish()
      {
        if ((ac.a(ac.this) == null) || (ac.b(ac.this) == -1) || (ac.b(ac.this) == 0) || (ac.b(ac.this) == 1))
        {
          ac.this.g();
          ac.d(ac.this).a(ac.c(ac.this));
        }
      }

      public void onTick(long paramAnonymousLong)
      {
      }
    };
    this.J.start();
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.z = paramSurfaceHolder;
    m();
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.z = null;
    if (this.s != null);
    b(true);
  }

  private static class a extends Handler
  {
    private final WeakReference<ac> a;

    a(ac paramac)
    {
      this.a = new WeakReference(paramac);
    }

    public void handleMessage(Message paramMessage)
    {
      ac localac = (ac)this.a.get();
      if ((localac == null) || (ac.a(localac) == null))
        return;
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
      }
      long l = ac.q(localac);
      Iterator localIterator = ac.r(localac).iterator();
      while (true)
        while (true)
        {
          String str;
          if (localIterator.hasNext())
            str = (String)localIterator.next();
          try
          {
            if (l >= Integer.parseInt(str))
            {
              Boolean localBoolean = (Boolean)ac.s(localac).get(str);
              if ((localBoolean == null) || (!localBoolean.booleanValue()))
              {
                ac.g(localac).a(str);
                ac.s(localac).put(str, new Boolean(true));
                if (l < 100L)
                  sendMessageDelayed(obtainMessage(1), 500L);
                if (l < 100L)
                  break;
                ac.g(localac).a("100");
                return;
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            i.e("Video percentage tracker is not a valid Integer or Double + " + str);
            localNumberFormatException.printStackTrace();
          }
        }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.ac
 * JD-Core Version:    0.6.2
 */