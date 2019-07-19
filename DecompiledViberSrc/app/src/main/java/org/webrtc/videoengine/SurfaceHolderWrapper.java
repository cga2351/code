package org.webrtc.videoengine;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SurfaceHolderWrapper
  implements SurfaceHolder
{
  private static final Logger L = ViberEnv.getLogger();
  private static final int SurfaceState_Changed = 2;
  private static final int SurfaceState_Created = 1;
  private static final int SurfaceState_Destroyed = 3;
  private static final int SurfaceState_Unknown;
  private static final Map<SurfaceHolder, SurfaceHolderWrapper> _wrapMap = new HashMap();
  private final Set<SurfaceHolder.Callback> _callbacks = new HashSet();
  private AtomicInteger _currentState = new AtomicInteger(0);
  private AtomicReference<SurfaceHolder> _holderRef = new AtomicReference(null);
  private final SurfaceHolder.Callback _internal = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      SurfaceHolderWrapper.access$002(SurfaceHolderWrapper.this, paramAnonymousInt1);
      SurfaceHolderWrapper.access$102(SurfaceHolderWrapper.this, paramAnonymousInt2);
      SurfaceHolderWrapper.access$202(SurfaceHolderWrapper.this, paramAnonymousInt3);
      SurfaceHolderWrapper.this._currentState.set(2);
      SurfaceHolderWrapper.this._holderRef.set(paramAnonymousSurfaceHolder);
      SurfaceHolderWrapper.this.broadcastStateChange(SurfaceHolderWrapper.this._currentState.get());
    }

    public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      SurfaceHolderWrapper.this._currentState.set(1);
      SurfaceHolderWrapper.this._holderRef.set(paramAnonymousSurfaceHolder);
      SurfaceHolderWrapper.this.broadcastStateChange(SurfaceHolderWrapper.this._currentState.get());
    }

    public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      SurfaceHolderWrapper.this._currentState.set(3);
      SurfaceHolderWrapper.this._holderRef.set(paramAnonymousSurfaceHolder);
      SurfaceHolderWrapper.this.broadcastStateChange(SurfaceHolderWrapper.this._currentState.get());
    }
  };
  private final SurfaceView _view;
  private final SurfaceHolder _wrap;
  private int format = -1;
  private int height = -1;
  private int width = -1;

  private SurfaceHolderWrapper(SurfaceView paramSurfaceView, SurfaceHolder paramSurfaceHolder)
  {
    this._view = paramSurfaceView;
    this._wrap = paramSurfaceHolder;
    paramSurfaceHolder.addCallback(this._internal);
  }

  private void broadcastStateForSingleCallback(SurfaceHolder.Callback paramCallback, int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      try
      {
        paramCallback.surfaceCreated((SurfaceHolder)this._holderRef.get());
        continue;
      }
      finally
      {
      }
      paramCallback.surfaceChanged((SurfaceHolder)this._holderRef.get(), this.format, this.width, this.height);
      continue;
      if ((paramCallback instanceof Callback))
        ((Callback)paramCallback).surfaceDestroyed((SurfaceHolder)this._holderRef.get(), this._view);
      else
        paramCallback.surfaceDestroyed((SurfaceHolder)this._holderRef.get());
    }
  }

  public static SurfaceHolderWrapper getWrapper(SurfaceView paramSurfaceView)
  {
    return getWrapper(paramSurfaceView, paramSurfaceView.getHolder());
  }

  private static SurfaceHolderWrapper getWrapper(SurfaceView paramSurfaceView, SurfaceHolder paramSurfaceHolder)
  {
    synchronized (_wrapMap)
    {
      SurfaceHolderWrapper localSurfaceHolderWrapper = (SurfaceHolderWrapper)_wrapMap.get(paramSurfaceHolder);
      if (localSurfaceHolderWrapper == null)
      {
        Map localMap2 = _wrapMap;
        localSurfaceHolderWrapper = new SurfaceHolderWrapper(paramSurfaceView, paramSurfaceHolder);
        localMap2.put(paramSurfaceHolder, localSurfaceHolderWrapper);
      }
      return localSurfaceHolderWrapper;
    }
  }

  public static boolean releaseWrapper(SurfaceHolder paramSurfaceHolder)
  {
    if ((paramSurfaceHolder instanceof SurfaceHolderWrapper))
      while (true)
      {
        synchronized (_wrapMap)
        {
          SurfaceHolderWrapper localSurfaceHolderWrapper = (SurfaceHolderWrapper)_wrapMap.remove(((SurfaceHolderWrapper)paramSurfaceHolder)._wrap);
          if (localSurfaceHolderWrapper != null);
          synchronized (localSurfaceHolderWrapper._currentState)
          {
            if (localSurfaceHolderWrapper._currentState.get() != 3)
              localSurfaceHolderWrapper.broadcastStateChange(3);
            if (localSurfaceHolderWrapper != null)
            {
              bool = true;
              return bool;
            }
          }
        }
        boolean bool = false;
      }
    return false;
  }

  public void addCallback(SurfaceHolder.Callback paramCallback)
  {
    synchronized (this._currentState)
    {
      boolean bool = this._callbacks.add(paramCallback);
      if (bool)
        broadcastStateForSingleCallback(paramCallback, this._currentState.get());
      return;
    }
  }

  // ERROR //
  protected void broadcastStateChange(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	org/webrtc/videoengine/SurfaceHolderWrapper:_currentState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: astore_3
    //   7: aload_3
    //   8: monitorenter
    //   9: new 57	java/util/HashSet
    //   12: dup
    //   13: aload_0
    //   14: getfield 60	org/webrtc/videoengine/SurfaceHolderWrapper:_callbacks	Ljava/util/Set;
    //   17: invokespecial 171	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   20: astore 4
    //   22: aload_3
    //   23: monitorexit
    //   24: aload 4
    //   26: invokeinterface 175 1 0
    //   31: astore 6
    //   33: aload 6
    //   35: invokeinterface 181 1 0
    //   40: ifeq +33 -> 73
    //   43: aload_0
    //   44: aload 6
    //   46: invokeinterface 184 1 0
    //   51: checkcast 111	android/view/SurfaceHolder$Callback
    //   54: iload_1
    //   55: invokespecial 168	org/webrtc/videoengine/SurfaceHolderWrapper:broadcastStateForSingleCallback	(Landroid/view/SurfaceHolder$Callback;I)V
    //   58: goto -25 -> 33
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    //   66: astore 5
    //   68: aload_3
    //   69: monitorexit
    //   70: aload 5
    //   72: athrow
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //
    // Exception table:
    //   from	to	target	type
    //   2	9	61	finally
    //   24	33	61	finally
    //   33	58	61	finally
    //   70	73	61	finally
    //   9	24	66	finally
    //   68	70	66	finally
  }

  public boolean equals(Object paramObject)
  {
    return this._wrap.equals(paramObject);
  }

  public SurfaceHolder getHolder()
  {
    return this._wrap;
  }

  public Surface getSurface()
  {
    return this._wrap.getSurface();
  }

  public Rect getSurfaceFrame()
  {
    return this._wrap.getSurfaceFrame();
  }

  public final SurfaceView getView()
  {
    return this._view;
  }

  public int hashCode()
  {
    return super.hashCode();
  }

  public boolean isCreating()
  {
    return this._wrap.isCreating();
  }

  public Canvas lockCanvas()
  {
    return this._wrap.lockCanvas();
  }

  public Canvas lockCanvas(Rect paramRect)
  {
    return this._wrap.lockCanvas(paramRect);
  }

  public void removeCallback(SurfaceHolder.Callback paramCallback)
  {
    synchronized (this._currentState)
    {
      if (!this._callbacks.remove(paramCallback))
        this._wrap.removeCallback(paramCallback);
      return;
    }
  }

  public void setFixedSize(int paramInt1, int paramInt2)
  {
    this._wrap.setFixedSize(paramInt1, paramInt2);
  }

  public void setFormat(int paramInt)
  {
    this._wrap.setFormat(paramInt);
  }

  public void setKeepScreenOn(boolean paramBoolean)
  {
    this._wrap.setKeepScreenOn(paramBoolean);
  }

  public void setSizeFromLayout()
  {
    this._wrap.setSizeFromLayout();
  }

  public void setType(int paramInt)
  {
    this._wrap.setType(paramInt);
  }

  public String toString()
  {
    return this._wrap.toString();
  }

  public void unlockCanvasAndPost(Canvas paramCanvas)
  {
    this._wrap.unlockCanvasAndPost(paramCanvas);
  }

  public static abstract class Callback
    implements SurfaceHolder.Callback
  {
    public abstract void surfaceDestroyed(SurfaceHolder paramSurfaceHolder, SurfaceView paramSurfaceView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.SurfaceHolderWrapper
 * JD-Core Version:    0.6.2
 */