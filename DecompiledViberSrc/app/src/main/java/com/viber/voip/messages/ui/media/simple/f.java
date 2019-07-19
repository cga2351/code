package com.viber.voip.messages.ui.media.simple;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.viber.voip.R.anim;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.ui.media.e.d;
import com.viber.voip.messages.ui.media.e.e;
import com.viber.voip.messages.ui.media.h;
import com.viber.voip.ui.b.a.a;
import com.viber.voip.util.at;
import com.viber.voip.util.bu;
import com.viber.voip.util.dv;
import com.viber.voip.util.upload.m;
import com.viber.voip.util.upload.s;
import com.viber.voip.util.upload.s.d;
import com.viber.voip.widget.PlayableImageView;
import java.io.File;

public class f extends e
  implements e.e
{
  private Handler c;
  private Animation d;
  private Animation e;
  private String f;
  private Uri g;
  private String h;
  private com.viber.voip.messages.ui.media.e i;
  private View j;
  private final m k = new m()
  {
    public void a(Uri paramAnonymousUri, int paramAnonymousInt)
    {
      if (f.a(f.this) == null);
      while (!f.b(f.this).equals(paramAnonymousUri))
        return;
      f.a(f.this).a(paramAnonymousInt);
    }
  };
  private com.viber.voip.util.upload.a l = new com.viber.voip.util.upload.a()
  {
    public void a(long paramAnonymousLong)
    {
    }

    public void a(final Uri paramAnonymousUri)
    {
      av.a(av.e.a).post(new Runnable()
      {
        public void run()
        {
          f.this.b.a(f.c(f.this), paramAnonymousUri);
          f.a(f.this).a(paramAnonymousUri);
        }
      });
    }

    public void a(Uri paramAnonymousUri, s.d paramAnonymousd)
    {
      f.this.b.a(f.c(f.this));
    }
  };
  private View.OnClickListener m = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (f.this.a.h())
      {
        f.a(f.this, 0);
        return;
      }
      f.b(f.this, 0);
    }
  };
  private Runnable n = new Runnable()
  {
    public void run()
    {
      f.this.a.f();
      if (((f.a(f.this).q()) || (e.d.g == f.a(f.this).d())) && (f.a(f.this).e()))
      {
        if (f.d(f.this).getVisibility() == 8)
        {
          f.d(f.this).setVisibility(0);
          f.d(f.this).startAnimation(f.e(f.this));
        }
        f.a(f.this).a(true, true);
      }
      if (f.a(f.this).l())
        f.a(f.this, 1500);
    }
  };
  private Runnable o = new Runnable()
  {
    public void run()
    {
      f.this.a.g();
      if (((f.a(f.this).q()) || (e.d.g == f.a(f.this).d())) && (f.a(f.this).e()))
      {
        if (f.d(f.this).getVisibility() == 0)
        {
          f.f(f.this).setAnimationListener(new a.a()
          {
            public void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              paramAnonymous2Animation.setAnimationListener(null);
              f.d(f.this).setVisibility(8);
            }
          });
          f.d(f.this).startAnimation(f.f(f.this));
        }
        f.a(f.this).a(false, true);
      }
    }
  };

  private void a(int paramInt)
  {
    h();
    this.c.postDelayed(this.n, paramInt);
  }

  public static f b(String paramString)
  {
    f localf = new f();
    Bundle localBundle = new Bundle();
    localBundle.putString("media_url", paramString);
    localf.setArguments(localBundle);
    return localf;
  }

  private void b(int paramInt)
  {
    h();
    this.c.postDelayed(this.o, paramInt);
  }

  private void g()
  {
    File localFile1 = dv.b.b(getActivity(), this.f, false);
    File localFile2 = dv.i.b(getActivity(), this.f, false);
    Uri localUri;
    if (at.a(localFile1))
      localUri = Uri.fromFile(localFile1);
    while (true)
      if (localUri != null)
      {
        this.b.a(this.f, localUri);
        this.i.a(localUri);
        return;
        if (at.a(localFile2))
          localUri = Uri.fromFile(localFile2);
      }
      else
      {
        this.i.a(null, this.h);
        return;
        localUri = null;
      }
  }

  private void h()
  {
    this.c.removeCallbacks(this.n);
    this.c.removeCallbacks(this.o);
  }

  public void a()
  {
    s.a(this.f, this.h, this.l);
  }

  public void a(long paramLong1, long paramLong2)
  {
  }

  public void a(String paramString)
  {
  }

  public void a(boolean paramBoolean)
  {
    if (getUserVisibleHint())
    {
      if (paramBoolean)
        b(0);
    }
    else
      return;
    a(0);
  }

  public void b()
  {
    s.a(this.h, false);
  }

  public void c()
  {
  }

  public void d()
  {
  }

  public void e()
  {
  }

  public void f()
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = av.a(av.e.a);
    this.d = AnimationUtils.loadAnimation(getActivity(), R.anim.bottom_slide_in);
    this.e = AnimationUtils.loadAnimation(getActivity(), R.anim.bottom_slide_out);
    this.d.setDuration(150L);
    this.e.setDuration(150L);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_view_video_simple, paramViewGroup, false);
    localView.findViewById(R.id.root).setOnClickListener(this.m);
    SimpleExoPlayerView localSimpleExoPlayerView = (SimpleExoPlayerView)localView.findViewById(R.id.video);
    TextView localTextView1 = (TextView)localView.findViewById(R.id.current_time);
    TextView localTextView2 = (TextView)localView.findViewById(R.id.all_time);
    SeekBar localSeekBar = (SeekBar)localView.findViewById(R.id.seekBar);
    PlayableImageView localPlayableImageView = (PlayableImageView)localView.findViewById(R.id.control);
    this.j = localView.findViewById(R.id.seekbar_panel);
    this.i = new com.viber.voip.messages.ui.media.e(new h(getContext()), localSimpleExoPlayerView, localPlayableImageView, localSeekBar, localTextView1, localTextView2, com.viber.voip.messages.ui.media.e.a.g)
    {
    };
    this.i.a(this);
    this.f = getArguments().getString("media_url");
    this.g = Uri.parse(this.f);
    this.h = bu.a(this.f);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    h();
    if (this.i != null)
      this.i.r();
  }

  public void onPause()
  {
    super.onPause();
    if (this.i != null)
      this.i.k();
  }

  public void onStart()
  {
    super.onStart();
    s.a(this.k);
    g();
  }

  public void onStop()
  {
    s.b(this.k);
    super.onStop();
    if (this.i != null)
    {
      this.i.j();
      this.i.r();
    }
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((!getUserVisibleHint()) && (this.i != null))
    {
      this.i.b(0);
      this.i.j();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.simple.f
 * JD-Core Version:    0.6.2
 */