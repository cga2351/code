package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.video.a.a;
import com.google.android.exoplayer2.video.d;
import com.google.android.exoplayer2.video.f;

public abstract interface aa
{
  public abstract TrackGroupArray A();

  public abstract g B();

  public abstract ak C();

  public abstract void a(int paramInt);

  public abstract void a(int paramInt, long paramLong);

  public abstract void a(a parama);

  public abstract void a(boolean paramBoolean);

  public abstract boolean a();

  public abstract int b(int paramInt);

  public abstract void b(a parama);

  public abstract void b(boolean paramBoolean);

  public abstract boolean b();

  public abstract void c(boolean paramBoolean);

  public abstract int d();

  public abstract int e();

  public abstract c g();

  public abstract b h();

  public abstract Looper i();

  public abstract int j();

  public abstract i k();

  public abstract boolean l();

  public abstract int m();

  public abstract boolean n();

  public abstract y o();

  public abstract int r();

  public abstract long s();

  public abstract long t();

  public abstract long u();

  public abstract boolean v();

  public abstract int w();

  public abstract int x();

  public abstract long y();

  public abstract long z();

  public static abstract interface a
  {
    public abstract void onLoadingChanged(boolean paramBoolean);

    public abstract void onPlaybackParametersChanged(y paramy);

    public abstract void onPlayerError(i parami);

    public abstract void onPlayerStateChanged(boolean paramBoolean, int paramInt);

    public abstract void onPositionDiscontinuity(int paramInt);

    public abstract void onRepeatModeChanged(int paramInt);

    public abstract void onSeekProcessed();

    public abstract void onShuffleModeEnabledChanged(boolean paramBoolean);

    public abstract void onTimelineChanged(ak paramak, Object paramObject, int paramInt);

    public abstract void onTracksChanged(TrackGroupArray paramTrackGroupArray, g paramg);
  }

  public static abstract interface b
  {
    public abstract void a(k paramk);

    public abstract void b(k paramk);
  }

  public static abstract interface c
  {
    public abstract void a(Surface paramSurface);

    public abstract void a(SurfaceView paramSurfaceView);

    public abstract void a(TextureView paramTextureView);

    public abstract void a(a parama);

    public abstract void a(d paramd);

    public abstract void a(f paramf);

    public abstract void b(Surface paramSurface);

    public abstract void b(SurfaceView paramSurfaceView);

    public abstract void b(TextureView paramTextureView);

    public abstract void b(a parama);

    public abstract void b(d paramd);

    public abstract void b(f paramf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.aa
 * JD-Core Version:    0.6.2
 */