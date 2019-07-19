package com.facebook.react.modules.clipboard;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="Clipboard")
public class ClipboardModule extends ContextBaseJavaModule
{
  public static final String NAME = "Clipboard";

  public ClipboardModule(Context paramContext)
  {
    super(paramContext);
  }

  private ClipboardManager getClipboardService()
  {
    Context localContext = getContext();
    getContext();
    return (ClipboardManager)localContext.getSystemService("clipboard");
  }

  public String getName()
  {
    return "Clipboard";
  }

  @ReactMethod
  public void getString(Promise paramPromise)
  {
    try
    {
      ClipboardManager localClipboardManager = getClipboardService();
      ClipData localClipData = localClipboardManager.getPrimaryClip();
      if (localClipData == null)
      {
        paramPromise.resolve("");
        return;
      }
      if (localClipData.getItemCount() >= 1)
      {
        ClipData.Item localItem = localClipboardManager.getPrimaryClip().getItemAt(0);
        paramPromise.resolve("" + localItem.getText());
        return;
      }
    }
    catch (Exception localException)
    {
      paramPromise.reject(localException);
      return;
    }
    paramPromise.resolve("");
  }

  @ReactMethod
  public void setString(String paramString)
  {
    ClipData localClipData = ClipData.newPlainText(null, paramString);
    getClipboardService().setPrimaryClip(localClipData);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.clipboard.ClipboardModule
 * JD-Core Version:    0.6.2
 */