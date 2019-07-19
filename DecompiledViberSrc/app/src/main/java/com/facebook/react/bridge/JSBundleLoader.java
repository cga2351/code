package com.facebook.react.bridge;

import android.content.Context;
import com.facebook.react.common.DebugServerException;

public abstract class JSBundleLoader
{
  public static JSBundleLoader createAssetLoader(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    return new JSBundleLoader()
    {
      public String loadScript(JSBundleLoaderDelegate paramAnonymousJSBundleLoaderDelegate)
      {
        paramAnonymousJSBundleLoaderDelegate.loadScriptFromAssets(this.val$context.getAssets(), paramString, paramBoolean);
        return paramString;
      }
    };
  }

  public static JSBundleLoader createCachedBundleFromNetworkLoader(final String paramString1, String paramString2)
  {
    return new JSBundleLoader()
    {
      public String loadScript(JSBundleLoaderDelegate paramAnonymousJSBundleLoaderDelegate)
      {
        try
        {
          paramAnonymousJSBundleLoaderDelegate.loadScriptFromFile(this.val$cachedFileLocation, paramString1, false);
          String str = paramString1;
          return str;
        }
        catch (Exception localException)
        {
          throw DebugServerException.makeGeneric(localException.getMessage(), localException);
        }
      }
    };
  }

  public static JSBundleLoader createDeltaFromNetworkLoader(String paramString, final NativeDeltaClient paramNativeDeltaClient)
  {
    return new JSBundleLoader()
    {
      public String loadScript(JSBundleLoaderDelegate paramAnonymousJSBundleLoaderDelegate)
      {
        try
        {
          paramAnonymousJSBundleLoaderDelegate.loadScriptFromDeltaBundle(this.val$sourceURL, paramNativeDeltaClient, false);
          String str = this.val$sourceURL;
          return str;
        }
        catch (Exception localException)
        {
          throw DebugServerException.makeGeneric(localException.getMessage(), localException);
        }
      }
    };
  }

  public static JSBundleLoader createFileLoader(String paramString)
  {
    return createFileLoader(paramString, paramString, false);
  }

  public static JSBundleLoader createFileLoader(String paramString1, final String paramString2, final boolean paramBoolean)
  {
    return new JSBundleLoader()
    {
      public String loadScript(JSBundleLoaderDelegate paramAnonymousJSBundleLoaderDelegate)
      {
        paramAnonymousJSBundleLoaderDelegate.loadScriptFromFile(this.val$fileName, paramString2, paramBoolean);
        return this.val$fileName;
      }
    };
  }

  public static JSBundleLoader createRemoteDebuggerBundleLoader(final String paramString1, String paramString2)
  {
    return new JSBundleLoader()
    {
      public String loadScript(JSBundleLoaderDelegate paramAnonymousJSBundleLoaderDelegate)
      {
        paramAnonymousJSBundleLoaderDelegate.setSourceURLs(this.val$realSourceURL, paramString1);
        return this.val$realSourceURL;
      }
    };
  }

  public abstract String loadScript(JSBundleLoaderDelegate paramJSBundleLoaderDelegate);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSBundleLoader
 * JD-Core Version:    0.6.2
 */