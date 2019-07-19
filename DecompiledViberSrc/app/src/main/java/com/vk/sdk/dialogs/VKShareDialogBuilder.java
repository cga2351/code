package com.vk.sdk.dialogs;

import android.annotation.TargetApi;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.photo.VKUploadImage;

public class VKShareDialogBuilder
{
  VKUploadImage[] attachmentImages;
  CharSequence attachmentText;
  VKPhotoArray existingPhotos;
  String linkTitle;
  String linkUrl;
  VKShareDialogListener listener;

  public VKShareDialogBuilder setAttachmentImages(VKUploadImage[] paramArrayOfVKUploadImage)
  {
    this.attachmentImages = paramArrayOfVKUploadImage;
    return this;
  }

  public VKShareDialogBuilder setAttachmentLink(String paramString1, String paramString2)
  {
    this.linkTitle = paramString1;
    this.linkUrl = paramString2;
    return this;
  }

  public VKShareDialogBuilder setShareDialogListener(VKShareDialogListener paramVKShareDialogListener)
  {
    this.listener = paramVKShareDialogListener;
    return this;
  }

  public VKShareDialogBuilder setText(CharSequence paramCharSequence)
  {
    this.attachmentText = paramCharSequence;
    return this;
  }

  public VKShareDialogBuilder setUploadedPhotos(VKPhotoArray paramVKPhotoArray)
  {
    this.existingPhotos = paramVKPhotoArray;
    return this;
  }

  @TargetApi(11)
  public void show(android.app.FragmentManager paramFragmentManager, String paramString)
  {
    new VKShareDialogNative(this).show(paramFragmentManager, paramString);
  }

  public void show(android.support.v4.app.FragmentManager paramFragmentManager, String paramString)
  {
    new VKShareDialog(this).show(paramFragmentManager, paramString);
  }

  public static abstract interface VKShareDialogListener
  {
    public abstract void onVkShareCancel();

    public abstract void onVkShareComplete(int paramInt);

    public abstract void onVkShareError(VKError paramVKError);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.dialogs.VKShareDialogBuilder
 * JD-Core Version:    0.6.2
 */