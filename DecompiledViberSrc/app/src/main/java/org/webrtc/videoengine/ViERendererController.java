package org.webrtc.videoengine;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class ViERendererController
{
  private static final Logger L = ViberEnv.getLogger();
  private static SurfaceHolder g_localRenderer = null;
  private static SurfaceView g_localSurface = null;
  private static long g_nativeObject = 0L;
  private static SurfaceView g_remoteSurface = null;
  private static Surface g_remoteWindow = null;
  private static SurfaceHolder.Callback remoteSurfaceCallback = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      ViERendererController.access$002(paramAnonymousSurfaceHolder.getSurface());
      if (ViERendererController.g_nativeObject != 0L)
        ViERendererController.setSurface(ViERendererController.g_remoteWindow, ViERendererController.g_nativeObject);
    }

    public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
    }

    public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      ViERendererController.access$002(null);
      if (ViERendererController.g_nativeObject != 0L)
        ViERendererController.setSurface(null, ViERendererController.g_nativeObject);
    }
  };

  public static SurfaceView CreateLocalRenderView(Context paramContext)
  {
    if (g_localSurface == null)
      g_localSurface = new SurfaceView(paramContext);
    if (g_localRenderer == null)
      g_localRenderer = SurfaceHolderWrapper.getWrapper(g_localSurface);
    return g_localSurface;
  }

  public static SurfaceView CreateRemoteRenderView(Context paramContext)
  {
    if (g_remoteSurface != null)
      return g_remoteSurface;
    g_remoteSurface = new SurfaceView(paramContext);
    g_remoteSurface.getHolder().addCallback(remoteSurfaceCallback);
    return g_remoteSurface;
  }

  public static SurfaceHolder GetLocalRenderer()
  {
    return g_localRenderer;
  }

  public static Object GetSurface()
  {
    return g_remoteWindow;
  }

  public static void RegisterNativeRenderer(long paramLong)
  {
    g_nativeObject = paramLong;
  }

  public static void UnregisterNativeRenderer()
  {
    g_nativeObject = 0L;
  }

  public static native void setSurface(Surface paramSurface, long paramLong);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.ViERendererController
 * JD-Core Version:    0.6.2
 */