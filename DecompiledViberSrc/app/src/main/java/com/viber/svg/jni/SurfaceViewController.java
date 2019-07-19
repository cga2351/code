package com.viber.svg.jni;

import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Iterator;

public class SurfaceViewController
  implements Runnable
{
  private static final Logger L = Logger.create(SurfaceViewController.class.getSimpleName());
  private ArrayList<SurfaceView> renderViews = new ArrayList();
  private Thread thread = new Thread(this);
  private ArrayList<SurfaceView> views = new ArrayList();

  private SurfaceViewController()
  {
    this.thread.start();
  }

  public static SurfaceViewController getInstance()
  {
    return InstanceHolder.instance;
  }

  public void addView(SurfaceView paramSurfaceView)
  {
    L.debug("addView");
    synchronized (this.renderViews)
    {
      this.views.add(paramSurfaceView);
      this.renderViews.notifyAll();
      return;
    }
  }

  public void removeView(SurfaceView paramSurfaceView)
  {
    L.debug("removeView");
    synchronized (this.renderViews)
    {
      this.views.remove(paramSurfaceView);
      return;
    }
  }

  public void run()
  {
    while (true)
    {
      synchronized (this.renderViews)
      {
        this.renderViews.clear();
        this.renderViews.addAll(this.views);
        int i = this.renderViews.size();
        if (i != 0);
      }
      try
      {
        wait();
        label44: continue;
        localObject = finally;
        throw localObject;
        Iterator localIterator = this.renderViews.iterator();
        while (localIterator.hasNext())
        {
          SurfaceView localSurfaceView = (SurfaceView)localIterator.next();
          SurfaceHolder localSurfaceHolder = localSurfaceView.getHolder();
          if (localSurfaceHolder.getSurface().isValid())
          {
            Canvas localCanvas = localSurfaceHolder.lockCanvas();
            if (localCanvas != null)
            {
              localSurfaceView.draw(localCanvas);
              localSurfaceHolder.unlockCanvasAndPost(localCanvas);
            }
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label44;
      }
    }
  }

  private static class InstanceHolder
  {
    private static final SurfaceViewController instance = new SurfaceViewController(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.SurfaceViewController
 * JD-Core Version:    0.6.2
 */