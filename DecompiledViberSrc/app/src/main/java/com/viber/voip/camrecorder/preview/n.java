package com.viber.voip.camrecorder.preview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.media.e.a;
import com.viber.voip.messages.ui.media.e.d;
import com.viber.voip.messages.ui.media.e.e;
import com.viber.voip.messages.ui.media.h;
import com.viber.voip.util.at;
import com.viber.voip.util.bl;
import com.viber.voip.util.dj;
import com.viber.voip.util.dj.a;
import com.viber.voip.util.dv;
import com.viber.voip.util.upload.o;
import com.viber.voip.widget.PlayableImageView;
import java.io.File;

public class n extends f
{
  private static final Logger a = ViberEnv.getLogger();
  private ImageView i;
  private int j = 0;
  private PlayerView k;
  private TextView l;
  private SeekBar m;
  private TextView n;
  private ImageView o;
  private View p;
  private com.viber.voip.messages.ui.media.e q;
  private com.viber.voip.messages.ui.media.player.a.a.e r;
  private long s = 0L;
  private boolean t;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private View.OnTouchListener x = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if ((n.b(n.this) != null) && (n.b(n.this).l()) && (paramAnonymousMotionEvent.getAction() == 0))
        n.h(n.this).a(true);
      return false;
    }
  };
  private ViewTreeObserver.OnGlobalLayoutListener y = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      Rect localRect = new Rect();
      n.this.f.getWindowVisibleDisplayFrame(localRect);
      View localView = ((ViewGroup)n.this.f.getRootView()).getChildAt(0);
      if (localView.getHeight() - localRect.bottom > bl.a(localView.getContext().getApplicationContext()))
      {
        if (!n.i(n.this))
          n.h(n.this).c(false);
        n.a(n.this, true);
        if ((n.b(n.this) != null) && (n.b(n.this).l()))
        {
          n.a(n.this, R.drawable.preview_media_play_selector);
          n.b(n.this).j();
        }
        n.j(n.this).setVisibility(8);
        return;
      }
      if (n.i(n.this))
      {
        n.h(n.this).b(false);
        n.this.f.postDelayed(new Runnable()
        {
          public void run()
          {
            n.k(n.this).requestLayout();
          }
        }
        , 100L);
      }
      n.a(n.this, false);
      n.l(n.this);
    }
  };

  private void a(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      this.i.setImageResource(paramInt);
    }
  }

  private void a(View paramView)
  {
    paramView.setOnTouchListener(this.x);
    this.o = ((ImageView)paramView.findViewById(R.id.customcam_preview_edit_area));
    this.k = ((PlayerView)paramView.findViewById(R.id.customcam_preview_video_playback));
    this.p = paramView.findViewById(R.id.progress_bar_container);
    this.m = ((SeekBar)paramView.findViewById(R.id.seek_bar));
    this.l = ((TextView)paramView.findViewById(R.id.current_time));
    this.n = ((TextView)paramView.findViewById(R.id.all_time));
    this.i = ((ImageView)paramView.findViewById(R.id.customcam_preview_play_control));
    this.i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        n.this.e();
      }
    });
  }

  private void p()
  {
    if (this.g != null)
      dj.a(this.i, new dj.a()
      {
        public boolean onGlobalLayout()
        {
          int i = n.this.f.getHeight();
          int j = n.this.g.getHeight();
          int k = n.a(n.this).getHeight();
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)n.a(n.this).getLayoutParams();
          localLayoutParams.topMargin = ((i - j) / 2 - k / 2);
          n.a(n.this).setLayoutParams(localLayoutParams);
          return true;
        }
      });
  }

  private void q()
  {
    if (this.r == null)
      this.r = new com.viber.voip.messages.ui.media.player.a.a.e(this.i)
      {
        protected boolean a()
        {
          return n.b(n.this) != null;
        }

        protected boolean b()
        {
          return (n.b(n.this) != null) && (n.b(n.this).l());
        }
      };
  }

  private void r()
  {
    if (this.t)
      this.p.setVisibility(0);
  }

  private void s()
  {
    this.t = true;
    this.p.setVisibility(0);
  }

  private void t()
  {
    this.q = new com.viber.voip.messages.ui.media.e(new h(getContext()), this.k, null, this.m, this.l, this.n, e.a.h)
    {
    };
    this.q.a(new e.e()
    {
      public void a()
      {
      }

      public void a(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        n.a(n.this, paramAnonymousLong2);
      }

      public void a(String paramAnonymousString)
      {
      }

      public void a(boolean paramAnonymousBoolean)
      {
        n.b(n.this).b(paramAnonymousBoolean);
        if (paramAnonymousBoolean)
        {
          n.a(n.this, R.drawable.preview_media_pause_selector);
          n.h(n.this).d();
        }
        do
        {
          return;
          n.a(n.this, R.drawable.preview_media_play_selector);
        }
        while (n.i(n.this));
        n.h(n.this).b(true);
      }

      public void b()
      {
      }

      public void c()
      {
        n.c(n.this).setVisibility(8);
        if (n.d(n.this) != 0L)
          n.b(n.this).b((int)n.d(n.this));
        if (n.e(n.this))
        {
          n.f(n.this);
          n.a(n.this, R.drawable.preview_media_pause_selector);
          n.b(n.this).i();
        }
      }

      public void d()
      {
      }

      public void e()
      {
        if (n.g(n.this))
        {
          n.this.e();
          return;
        }
        n.a(n.this, R.drawable.preview_media_play_selector);
        n.h(n.this).b(true);
      }

      public void f()
      {
      }
    });
    this.q.a(this.d);
  }

  protected Bitmap a(Context paramContext)
  {
    File localFile = at.a(paramContext.getApplicationContext(), this.d);
    if (localFile == null)
      return null;
    return ThumbnailUtils.createVideoThumbnail(localFile.getAbsolutePath(), 2);
  }

  protected Uri a(Uri paramUri)
  {
    return null;
  }

  protected Uri a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = at.e(getActivity(), paramUri);
    Object localObject = null;
    if (str == null)
      return localObject;
    if (paramBoolean1)
      localObject = at.f(getContext(), paramUri);
    while (true)
    {
      int i1;
      if (!paramBoolean2)
      {
        i1 = 0;
        if (paramBoolean1);
      }
      else
      {
        i1 = 1;
      }
      if ((i1 == 0) || (localObject == null))
        break;
      o.a(((Uri)localObject).getPath());
      return localObject;
      Uri localUri = dv.b.a(getActivity(), str, false);
      boolean bool = at.b(this.d, localUri);
      localObject = null;
      if (bool)
        localObject = localUri;
    }
  }

  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.activity_customcam_preview_video_fragment, paramViewGroup, false);
    localView.getViewTreeObserver().addOnGlobalLayoutListener(this.y);
    boolean bool1 = false;
    if (paramBundle == null)
    {
      boolean bool2 = getArguments().getBoolean("com.viber.voip.custom_cam_media_preview_from_camera");
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    this.v = bool1;
    a(localView);
    return localView;
  }

  protected void a(Bitmap paramBitmap)
  {
    this.o.setImageBitmap(paramBitmap);
  }

  protected void b(int paramInt)
  {
    if (paramInt != 0);
    for (int i1 = (int)(com.viber.voip.messages.extras.image.c.c(ViberApplication.getApplication(), this.d, 3) / 1000L); ; i1 = paramInt)
    {
      ViberApplication.getInstance().getEngine(false).getCdrController().handleReportMediaScreenSend(3, "", 0, 0, i1);
      return;
    }
  }

  public void e()
  {
    if (this.q == null)
    {
      t();
      this.u = true;
    }
    while (this.q.d() == e.d.a)
      return;
    this.v = false;
    this.q.h();
  }

  protected int f()
  {
    return 3;
  }

  protected com.viber.voip.ui.doodle.scene.c j()
  {
    return new com.viber.voip.ui.doodle.scene.c();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    q();
    if (this.v)
    {
      this.r.c(false);
      return;
    }
    this.r.b(false);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    p();
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.r.g();
    dj.b(this.f, this.y);
    if (this.q != null)
      this.q.r();
  }

  public void onPause()
  {
    super.onPause();
    if (this.q != null)
    {
      a(R.drawable.preview_media_play_selector);
      this.u = this.q.l();
      this.q.j();
    }
  }

  public void onResume()
  {
    super.onResume();
    if (this.v)
      e();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    p();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.n
 * JD-Core Version:    0.6.2
 */