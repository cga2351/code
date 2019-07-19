package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ForwardingControllerListener<INFO>
  implements ControllerListener<INFO>
{
  private static final String TAG = "FdingControllerListener";
  private final List<ControllerListener<? super INFO>> mListeners = new ArrayList(2);

  public static <INFO> ForwardingControllerListener<INFO> create()
  {
    return new ForwardingControllerListener();
  }

  public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> paramControllerListener)
  {
    ForwardingControllerListener localForwardingControllerListener = create();
    localForwardingControllerListener.addListener(paramControllerListener);
    return localForwardingControllerListener;
  }

  public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> paramControllerListener1, ControllerListener<? super INFO> paramControllerListener2)
  {
    ForwardingControllerListener localForwardingControllerListener = create();
    localForwardingControllerListener.addListener(paramControllerListener1);
    localForwardingControllerListener.addListener(paramControllerListener2);
    return localForwardingControllerListener;
  }

  private void onException(String paramString, Throwable paramThrowable)
  {
    try
    {
      Log.e("FdingControllerListener", paramString, paramThrowable);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void addListener(ControllerListener<? super INFO> paramControllerListener)
  {
    try
    {
      this.mListeners.add(paramControllerListener);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void clearListeners()
  {
    try
    {
      this.mListeners.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onFailure(String paramString, Throwable paramThrowable)
  {
    try
    {
      int i = this.mListeners.size();
      int j = 0;
      while (true)
        if (j < i)
          try
          {
            ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(j);
            if (localControllerListener != null)
              localControllerListener.onFailure(paramString, paramThrowable);
            j++;
          }
          catch (Exception localException)
          {
            while (true)
              onException("InternalListener exception in onFailure", localException);
          }
    }
    finally
    {
    }
  }

  public void onFinalImageSet(String paramString, @Nullable INFO paramINFO, @Nullable Animatable paramAnimatable)
  {
    try
    {
      int i = this.mListeners.size();
      int j = 0;
      while (true)
        if (j < i)
          try
          {
            ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(j);
            if (localControllerListener != null)
              localControllerListener.onFinalImageSet(paramString, paramINFO, paramAnimatable);
            j++;
          }
          catch (Exception localException)
          {
            while (true)
              onException("InternalListener exception in onFinalImageSet", localException);
          }
    }
    finally
    {
    }
  }

  public void onIntermediateImageFailed(String paramString, Throwable paramThrowable)
  {
    int i = this.mListeners.size();
    int j = 0;
    while (true)
      if (j < i)
        try
        {
          ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(j);
          if (localControllerListener != null)
            localControllerListener.onIntermediateImageFailed(paramString, paramThrowable);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onIntermediateImageFailed", localException);
        }
  }

  public void onIntermediateImageSet(String paramString, @Nullable INFO paramINFO)
  {
    int i = this.mListeners.size();
    int j = 0;
    while (true)
      if (j < i)
        try
        {
          ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(j);
          if (localControllerListener != null)
            localControllerListener.onIntermediateImageSet(paramString, paramINFO);
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            onException("InternalListener exception in onIntermediateImageSet", localException);
        }
  }

  public void onRelease(String paramString)
  {
    try
    {
      int i = this.mListeners.size();
      int j = 0;
      while (true)
        if (j < i)
          try
          {
            ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(j);
            if (localControllerListener != null)
              localControllerListener.onRelease(paramString);
            j++;
          }
          catch (Exception localException)
          {
            while (true)
              onException("InternalListener exception in onRelease", localException);
          }
    }
    finally
    {
    }
  }

  public void onSubmit(String paramString, Object paramObject)
  {
    try
    {
      int i = this.mListeners.size();
      int j = 0;
      while (true)
        if (j < i)
          try
          {
            ControllerListener localControllerListener = (ControllerListener)this.mListeners.get(j);
            if (localControllerListener != null)
              localControllerListener.onSubmit(paramString, paramObject);
            j++;
          }
          catch (Exception localException)
          {
            while (true)
              onException("InternalListener exception in onSubmit", localException);
          }
    }
    finally
    {
    }
  }

  public void removeListener(ControllerListener<? super INFO> paramControllerListener)
  {
    try
    {
      int i = this.mListeners.indexOf(paramControllerListener);
      if (i != -1)
        this.mListeners.set(i, null);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.controller.ForwardingControllerListener
 * JD-Core Version:    0.6.2
 */