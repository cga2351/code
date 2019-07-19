package com.mopub.mraid;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener;

public class MraidVideoViewController extends BaseVideoViewController
{
  private final VideoView a;
  private ImageButton b;
  private int c;
  private int d;

  public MraidVideoViewController(Context paramContext, Bundle paramBundle1, Bundle paramBundle2, BaseVideoViewController.BaseVideoViewControllerListener paramBaseVideoViewControllerListener)
  {
    super(paramContext, null, paramBaseVideoViewControllerListener);
    this.a = new VideoView(paramContext);
    this.a.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        MraidVideoViewController.a(MraidVideoViewController.this).setVisibility(0);
        MraidVideoViewController.a(MraidVideoViewController.this, true);
      }
    });
    this.a.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        MraidVideoViewController.a(MraidVideoViewController.this).setVisibility(0);
        MraidVideoViewController.b(MraidVideoViewController.this, false);
        return false;
      }
    });
    this.a.setVideoPath(paramBundle1.getString("video_url"));
  }

  private void i()
  {
    this.b = new ImageButton(h());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { -16842919 }, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(h()));
    localStateListDrawable.addState(new int[] { 16842919 }, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(h()));
    this.b.setImageDrawable(localStateListDrawable);
    this.b.setBackgroundDrawable(null);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MraidVideoViewController.b(MraidVideoViewController.this).onFinish();
      }
    });
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.d, this.d);
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(this.c, 0, this.c, 0);
    getLayout().addView(this.b, localLayoutParams);
  }

  protected void a()
  {
    super.a();
    this.d = Dips.asIntPixels(50.0F, h());
    this.c = Dips.asIntPixels(8.0F, h());
    i();
    this.b.setVisibility(8);
    this.a.start();
  }

  protected void a(Configuration paramConfiguration)
  {
  }

  protected void a(Bundle paramBundle)
  {
  }

  protected VideoView b()
  {
    return this.a;
  }

  protected void c()
  {
  }

  protected void d()
  {
  }

  protected void e()
  {
  }

  protected void f()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.MraidVideoViewController
 * JD-Core Version:    0.6.2
 */