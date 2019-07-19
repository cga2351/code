package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public final class FallbackJSBundleLoader extends JSBundleLoader
{
  static final String RECOVERABLE = "facebook::react::Recoverable";
  static final String TAG = "FallbackJSBundleLoader";
  private Stack<JSBundleLoader> mLoaders = new Stack();
  private final ArrayList<Exception> mRecoveredErrors = new ArrayList();

  public FallbackJSBundleLoader(List<JSBundleLoader> paramList)
  {
    ListIterator localListIterator = paramList.listIterator(paramList.size());
    while (localListIterator.hasPrevious())
      this.mLoaders.push(localListIterator.previous());
  }

  private JSBundleLoader getDelegateLoader()
  {
    if (!this.mLoaders.empty())
      return (JSBundleLoader)this.mLoaders.peek();
    RuntimeException localRuntimeException = new RuntimeException("No fallback options available");
    Iterator localIterator = this.mRecoveredErrors.iterator();
    Object localObject2;
    for (Object localObject1 = localRuntimeException; localIterator.hasNext(); localObject1 = localObject2)
    {
      ((Throwable)localObject1).initCause((Exception)localIterator.next());
      for (localObject2 = localObject1; ((Throwable)localObject2).getCause() != null; localObject2 = ((Throwable)localObject2).getCause());
    }
    throw localRuntimeException;
  }

  public String loadScript(JSBundleLoaderDelegate paramJSBundleLoaderDelegate)
  {
    while (true)
      try
      {
        String str = getDelegateLoader().loadScript(paramJSBundleLoaderDelegate);
        return str;
      }
      catch (Exception localException)
      {
        if ((localException.getMessage() == null) || (!localException.getMessage().startsWith("facebook::react::Recoverable")))
          throw localException;
        this.mLoaders.pop();
        this.mRecoveredErrors.add(localException);
        FLog.wtf("FallbackJSBundleLoader", "Falling back from recoverable error", localException);
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.FallbackJSBundleLoader
 * JD-Core Version:    0.6.2
 */