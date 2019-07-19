package com.vk.sdk.dialogs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

@TargetApi(11)
public class VKShareDialogNative extends DialogFragment
  implements VKShareDialogDelegate.DialogFragmentI
{
  private VKShareDialogDelegate mDelegate = new VKShareDialogDelegate(this);

  public VKShareDialogNative()
  {
  }

  @SuppressLint({"ValidFragment"})
  VKShareDialogNative(VKShareDialogBuilder paramVKShareDialogBuilder)
  {
    this.mDelegate.setAttachmentImages(paramVKShareDialogBuilder.attachmentImages);
    this.mDelegate.setText(paramVKShareDialogBuilder.attachmentText);
    if ((paramVKShareDialogBuilder.linkTitle != null) && (paramVKShareDialogBuilder.linkUrl != null))
      this.mDelegate.setAttachmentLink(paramVKShareDialogBuilder.linkTitle, paramVKShareDialogBuilder.linkUrl);
    this.mDelegate.setUploadedPhotos(paramVKShareDialogBuilder.existingPhotos);
    this.mDelegate.setShareDialogListener(paramVKShareDialogBuilder.listener);
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    this.mDelegate.onCancel(paramDialogInterface);
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return this.mDelegate.onCreateDialog(paramBundle);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mDelegate.onSaveInstanceState(paramBundle);
  }

  @SuppressLint({"NewApi"})
  public void onStart()
  {
    super.onStart();
    this.mDelegate.onStart();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.dialogs.VKShareDialogNative
 * JD-Core Version:    0.6.2
 */