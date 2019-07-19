package com.vk.sdk.dialogs;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.photo.VKUploadImage;

public class VKShareDialog extends DialogFragment
  implements VKShareDialogDelegate.DialogFragmentI
{
  private VKShareDialogDelegate mDelegate = new VKShareDialogDelegate(this);

  @Deprecated
  public VKShareDialog()
  {
  }

  @SuppressLint({"ValidFragment"})
  VKShareDialog(VKShareDialogBuilder paramVKShareDialogBuilder)
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

  public VKShareDialog setAttachmentImages(VKUploadImage[] paramArrayOfVKUploadImage)
  {
    this.mDelegate.setAttachmentImages(paramArrayOfVKUploadImage);
    return this;
  }

  public VKShareDialog setAttachmentLink(String paramString1, String paramString2)
  {
    this.mDelegate.setAttachmentLink(paramString1, paramString2);
    return this;
  }

  public VKShareDialog setShareDialogListener(VKShareDialogListener paramVKShareDialogListener)
  {
    this.mDelegate.setShareDialogListener(paramVKShareDialogListener);
    return this;
  }

  public VKShareDialog setText(CharSequence paramCharSequence)
  {
    this.mDelegate.setText(paramCharSequence);
    return this;
  }

  public VKShareDialog setUploadedPhotos(VKPhotoArray paramVKPhotoArray)
  {
    this.mDelegate.setUploadedPhotos(paramVKPhotoArray);
    return this;
  }

  public static abstract interface VKShareDialogListener extends VKShareDialogBuilder.VKShareDialogListener
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.dialogs.VKShareDialog
 * JD-Core Version:    0.6.2
 */