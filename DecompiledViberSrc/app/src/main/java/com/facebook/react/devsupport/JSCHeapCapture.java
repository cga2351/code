package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.io.File;
import javax.annotation.Nullable;

@ReactModule(name="JSCHeapCapture", needsEagerInit=true)
public class JSCHeapCapture extends ReactContextBaseJavaModule
{

  @Nullable
  private CaptureCallback mCaptureInProgress = null;

  public JSCHeapCapture(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @ReactMethod
  public void captureComplete(String paramString1, String paramString2)
  {
    try
    {
      if (this.mCaptureInProgress != null)
      {
        if (paramString2 != null)
          break label38;
        this.mCaptureInProgress.onSuccess(new File(paramString1));
      }
      while (true)
      {
        this.mCaptureInProgress = null;
        return;
        label38: this.mCaptureInProgress.onFailure(new CaptureException(paramString2));
      }
    }
    finally
    {
    }
  }

  public void captureHeap(String paramString, CaptureCallback paramCaptureCallback)
  {
    while (true)
    {
      File localFile;
      HeapCapture localHeapCapture;
      try
      {
        if (this.mCaptureInProgress != null)
        {
          paramCaptureCallback.onFailure(new CaptureException("Heap capture already in progress."));
          return;
        }
        localFile = new File(paramString + "/capture.json");
        localFile.delete();
        localHeapCapture = (HeapCapture)getReactApplicationContext().getJSModule(HeapCapture.class);
        if (localHeapCapture == null)
        {
          paramCaptureCallback.onFailure(new CaptureException("Heap capture js module not registered."));
          continue;
        }
      }
      finally
      {
      }
      this.mCaptureInProgress = paramCaptureCallback;
      localHeapCapture.captureHeap(localFile.getPath());
    }
  }

  public String getName()
  {
    return "JSCHeapCapture";
  }

  public static abstract interface CaptureCallback
  {
    public abstract void onFailure(JSCHeapCapture.CaptureException paramCaptureException);

    public abstract void onSuccess(File paramFile);
  }

  public static class CaptureException extends Exception
  {
    CaptureException(String paramString)
    {
      super();
    }

    CaptureException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }

  public static abstract interface HeapCapture extends JavaScriptModule
  {
    public abstract void captureHeap(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.JSCHeapCapture
 * JD-Core Version:    0.6.2
 */