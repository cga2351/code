package com.facebook.react.modules.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import javax.annotation.Nullable;

public class SupportAlertFragment extends DialogFragment
  implements DialogInterface.OnClickListener
{

  @Nullable
  private final DialogModule.AlertFragmentListener mListener;

  public SupportAlertFragment()
  {
    this.mListener = null;
  }

  @SuppressLint({"ValidFragment"})
  public SupportAlertFragment(@Nullable DialogModule.AlertFragmentListener paramAlertFragmentListener, Bundle paramBundle)
  {
    this.mListener = paramAlertFragmentListener;
    setArguments(paramBundle);
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.mListener != null)
      this.mListener.onClick(paramDialogInterface, paramInt);
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return AlertFragment.createDialog(getActivity(), getArguments(), this);
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.mListener != null)
      this.mListener.onDismiss(paramDialogInterface);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.dialog.SupportAlertFragment
 * JD-Core Version:    0.6.2
 */