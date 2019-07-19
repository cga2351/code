package com.microsoft.codepush.react;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CodePushDialog extends ReactContextBaseJavaModule
{
  public CodePushDialog(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private void showDialogInternal(String paramString1, String paramString2, String paramString3, String paramString4, final Callback paramCallback, Activity paramActivity)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setCancelable(false);
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        try
        {
          paramAnonymousDialogInterface.cancel();
          switch (paramAnonymousInt)
          {
          default:
            throw new f("Unknown button ID pressed.");
          case -1:
          case -2:
          }
        }
        catch (Throwable localThrowable)
        {
          j.a(localThrowable);
          return;
        }
        Callback localCallback2 = paramCallback;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(0);
        localCallback2.invoke(arrayOfObject2);
        return;
        Callback localCallback1 = paramCallback;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(1);
        localCallback1.invoke(arrayOfObject1);
      }
    };
    if (paramString1 != null)
      localBuilder.setTitle(paramString1);
    if (paramString2 != null)
      localBuilder.setMessage(paramString2);
    if (paramString3 != null)
      localBuilder.setPositiveButton(paramString3, local2);
    if (paramString4 != null)
      localBuilder.setNegativeButton(paramString4, local2);
    localBuilder.create().show();
  }

  public String getName()
  {
    return "CodePushDialog";
  }

  @ReactMethod
  public void showDialog(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final Callback paramCallback1, Callback paramCallback2)
  {
    Activity localActivity = getCurrentActivity();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      getReactApplicationContext().addLifecycleEventListener(new LifecycleEventListener()
      {
        public void onHostDestroy()
        {
        }

        public void onHostPause()
        {
        }

        public void onHostResume()
        {
          Activity localActivity = CodePushDialog.this.getCurrentActivity();
          if (localActivity != null)
          {
            CodePushDialog.this.getReactApplicationContext().removeLifecycleEventListener(this);
            CodePushDialog.this.showDialogInternal(paramString1, paramString2, paramString3, paramString4, paramCallback1, localActivity);
          }
        }
      });
      return;
    }
    showDialogInternal(paramString1, paramString2, paramString3, paramString4, paramCallback1, localActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.CodePushDialog
 * JD-Core Version:    0.6.2
 */