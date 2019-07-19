package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import org.greenrobot.eventbus.EventBus;

public class ErrorDialogFragments
{
  public static int ERROR_DIALOG_ICON = 0;
  public static Class<?> EVENT_TYPE_ON_CLICK;

  public static Dialog createDialog(Context paramContext, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle(paramBundle.getString("de.greenrobot.eventbus.errordialog.title"));
    localBuilder.setMessage(paramBundle.getString("de.greenrobot.eventbus.errordialog.message"));
    if (ERROR_DIALOG_ICON != 0)
      localBuilder.setIcon(ERROR_DIALOG_ICON);
    localBuilder.setPositiveButton(17039370, paramOnClickListener);
    return localBuilder.create();
  }

  public static void handleOnClick(DialogInterface paramDialogInterface, int paramInt, Activity paramActivity, Bundle paramBundle)
  {
    if (EVENT_TYPE_ON_CLICK != null);
    try
    {
      Object localObject = EVENT_TYPE_ON_CLICK.newInstance();
      ErrorDialogManager.factory.config.getEventBus().post(localObject);
      if ((paramBundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false)) && (paramActivity != null))
        paramActivity.finish();
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Event cannot be constructed", localException);
    }
  }

  @TargetApi(11)
  public static class Honeycomb extends android.app.DialogFragment
    implements DialogInterface.OnClickListener
  {
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      ErrorDialogFragments.handleOnClick(paramDialogInterface, paramInt, getActivity(), getArguments());
    }

    public Dialog onCreateDialog(Bundle paramBundle)
    {
      return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
    }
  }

  public static class Support extends android.support.v4.app.DialogFragment
    implements DialogInterface.OnClickListener
  {
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      ErrorDialogFragments.handleOnClick(paramDialogInterface, paramInt, getActivity(), getArguments());
    }

    public Dialog onCreateDialog(Bundle paramBundle)
    {
      return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.util.ErrorDialogFragments
 * JD-Core Version:    0.6.2
 */