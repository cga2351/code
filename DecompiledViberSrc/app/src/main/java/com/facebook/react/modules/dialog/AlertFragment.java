package com.facebook.react.modules.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import javax.annotation.Nullable;

public class AlertFragment extends DialogFragment
  implements DialogInterface.OnClickListener
{
  static final String ARG_BUTTON_NEGATIVE = "button_negative";
  static final String ARG_BUTTON_NEUTRAL = "button_neutral";
  static final String ARG_BUTTON_POSITIVE = "button_positive";
  static final String ARG_ITEMS = "items";
  static final String ARG_MESSAGE = "message";
  static final String ARG_TITLE = "title";

  @Nullable
  private final DialogModule.AlertFragmentListener mListener;

  public AlertFragment()
  {
    this.mListener = null;
  }

  @SuppressLint({"ValidFragment"})
  public AlertFragment(@Nullable DialogModule.AlertFragmentListener paramAlertFragmentListener, Bundle paramBundle)
  {
    this.mListener = paramAlertFragmentListener;
    setArguments(paramBundle);
  }

  public static Dialog createDialog(Context paramContext, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext).setTitle(paramBundle.getString("title"));
    if (paramBundle.containsKey("button_positive"))
      localBuilder.setPositiveButton(paramBundle.getString("button_positive"), paramOnClickListener);
    if (paramBundle.containsKey("button_negative"))
      localBuilder.setNegativeButton(paramBundle.getString("button_negative"), paramOnClickListener);
    if (paramBundle.containsKey("button_neutral"))
      localBuilder.setNeutralButton(paramBundle.getString("button_neutral"), paramOnClickListener);
    if (paramBundle.containsKey("message"))
      localBuilder.setMessage(paramBundle.getString("message"));
    if (paramBundle.containsKey("items"))
      localBuilder.setItems(paramBundle.getCharSequenceArray("items"), paramOnClickListener);
    return localBuilder.create();
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.mListener != null)
      this.mListener.onClick(paramDialogInterface, paramInt);
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return createDialog(getActivity(), getArguments(), this);
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.mListener != null)
      this.mListener.onDismiss(paramDialogInterface);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.dialog.AlertFragment
 * JD-Core Version:    0.6.2
 */