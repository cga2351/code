package com.vk.sdk.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.vk.sdk.R.dimen;
import com.vk.sdk.R.id;
import com.vk.sdk.R.layout;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKRequest.VKRequestListener;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKImageOperation;
import com.vk.sdk.api.httpClient.VKImageOperation.VKImageOperationListener;
import com.vk.sdk.api.methods.VKApiWall;
import com.vk.sdk.api.model.VKApiLink;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.model.VKPhotoSizes;
import com.vk.sdk.api.model.VKWallPostResult;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.api.photo.VKUploadWallPhotoRequest;
import com.vk.sdk.util.VKStringJoiner;
import com.vk.sdk.util.VKUtil;
import java.util.ArrayList;
import java.util.Iterator;

class VKShareDialogDelegate
{
  private static final String SHARE_IMAGES_KEY = "ShareImages";
  private static final String SHARE_LINK_KEY = "ShareLink";
  private static final int SHARE_PHOTO_CORNER_RADIUS = 3;
  private static final int SHARE_PHOTO_HEIGHT = 100;
  private static final int SHARE_PHOTO_MARGIN_LEFT = 10;
  private static final String SHARE_TEXT_KEY = "ShareText";
  private static final String SHARE_UPLOADED_IMAGES_KEY = "ShareUploadedImages";
  private final DialogFragmentI dialogFragmentI;
  private VKUploadImage[] mAttachmentImages;
  private UploadingLink mAttachmentLink;
  private CharSequence mAttachmentText;
  private VKPhotoArray mExistingPhotos;
  private VKShareDialogBuilder.VKShareDialogListener mListener;
  private LinearLayout mPhotoLayout;
  private HorizontalScrollView mPhotoScroll;
  private Button mSendButton;
  private ProgressBar mSendProgress;
  private EditText mShareTextField;
  View.OnClickListener sendButtonPress = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      VKShareDialogDelegate.this.setIsLoading(true);
      if ((VKShareDialogDelegate.this.mAttachmentImages != null) && (VKSdk.getAccessToken() != null))
      {
        Long localLong = Long.valueOf(Long.parseLong(VKSdk.getAccessToken().userId));
        new VKUploadWallPhotoRequest(VKShareDialogDelegate.this.mAttachmentImages, localLong.longValue(), 0).executeWithListener(new VKRequest.VKRequestListener()
        {
          public void onComplete(VKResponse paramAnonymous2VKResponse)
          {
            VKAttachments localVKAttachments = new VKAttachments((VKPhotoArray)paramAnonymous2VKResponse.parsedModel);
            VKShareDialogDelegate.this.makePostWithAttachments(localVKAttachments);
          }

          public void onError(VKError paramAnonymous2VKError)
          {
            VKShareDialogDelegate.this.setIsLoading(false);
            if (VKShareDialogDelegate.this.mListener != null)
              VKShareDialogDelegate.this.mListener.onVkShareError(paramAnonymous2VKError);
          }
        });
        return;
      }
      VKShareDialogDelegate.this.makePostWithAttachments(null);
    }
  };

  static
  {
    if (!VKShareDialogDelegate.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  public VKShareDialogDelegate(DialogFragmentI paramDialogFragmentI)
  {
    this.dialogFragmentI = paramDialogFragmentI;
  }

  private void addBitmapToPreview(Bitmap paramBitmap)
  {
    if (this.dialogFragmentI.getActivity() == null);
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = VKUIHelper.getRoundedCornerBitmap(paramBitmap, 100, 3);
    }
    while (localBitmap == null);
    ImageView localImageView = new ImageView(this.dialogFragmentI.getActivity());
    localImageView.setImageBitmap(localBitmap);
    localImageView.setAdjustViewBounds(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    if (this.mPhotoLayout.getChildCount() > 0);
    for (int i = 10; ; i = 0)
    {
      localLayoutParams.setMargins(i, 0, 0, 0);
      this.mPhotoLayout.addView(localImageView, localLayoutParams);
      this.mPhotoLayout.invalidate();
      this.mPhotoScroll.invalidate();
      return;
    }
  }

  private void loadAndAddPhoto(String paramString)
  {
    loadAndAddPhoto(paramString, 0);
  }

  private void loadAndAddPhoto(final String paramString, final int paramInt)
  {
    if (paramInt > 10)
      return;
    VKImageOperation localVKImageOperation = new VKImageOperation(paramString);
    localVKImageOperation.setImageOperationListener(new VKImageOperation.VKImageOperationListener()
    {
      public void onComplete(VKImageOperation paramAnonymousVKImageOperation, Bitmap paramAnonymousBitmap)
      {
        if (paramAnonymousBitmap == null)
        {
          new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public void run()
            {
              VKShareDialogDelegate.this.loadAndAddPhoto(VKShareDialogDelegate.2.this.val$photoUrl, 1 + VKShareDialogDelegate.2.this.val$attempt);
            }
          }
          , 1000L);
          return;
        }
        VKShareDialogDelegate.this.addBitmapToPreview(paramAnonymousBitmap);
      }

      public void onError(VKImageOperation paramAnonymousVKImageOperation, VKError paramAnonymousVKError)
      {
      }
    });
    VKHttpClient.enqueueOperation(localVKImageOperation);
  }

  private void makePostWithAttachments(VKAttachments paramVKAttachments)
  {
    if (paramVKAttachments == null)
      paramVKAttachments = new VKAttachments();
    if (this.mExistingPhotos != null)
      paramVKAttachments.addAll(this.mExistingPhotos);
    if (this.mAttachmentLink != null)
      paramVKAttachments.add(new VKApiLink(this.mAttachmentLink.linkUrl));
    String str = this.mShareTextField.getText().toString();
    Long localLong = Long.valueOf(Long.parseLong(VKSdk.getAccessToken().userId));
    VKApiWall localVKApiWall = VKApi.wall();
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = "owner_id";
    arrayOfObject[1] = localLong;
    arrayOfObject[2] = "message";
    arrayOfObject[3] = str;
    arrayOfObject[4] = "attachments";
    arrayOfObject[5] = paramVKAttachments.toAttachmentsString();
    localVKApiWall.post(VKParameters.from(arrayOfObject)).executeWithListener(new VKRequest.VKRequestListener()
    {
      public void onComplete(VKResponse paramAnonymousVKResponse)
      {
        VKShareDialogDelegate.this.setIsLoading(false);
        VKWallPostResult localVKWallPostResult = (VKWallPostResult)paramAnonymousVKResponse.parsedModel;
        if (VKShareDialogDelegate.this.mListener != null)
          VKShareDialogDelegate.this.mListener.onVkShareComplete(localVKWallPostResult.post_id);
        VKShareDialogDelegate.this.dialogFragmentI.dismissAllowingStateLoss();
      }

      public void onError(VKError paramAnonymousVKError)
      {
        VKShareDialogDelegate.this.setIsLoading(false);
        if (VKShareDialogDelegate.this.mListener != null)
          VKShareDialogDelegate.this.mListener.onVkShareError(paramAnonymousVKError);
      }
    });
  }

  private void processExistingPhotos()
  {
    ArrayList localArrayList = new ArrayList(this.mExistingPhotos.size());
    Iterator localIterator = this.mExistingPhotos.iterator();
    while (localIterator.hasNext())
    {
      VKApiPhoto localVKApiPhoto = (VKApiPhoto)localIterator.next();
      localArrayList.add("" + localVKApiPhoto.owner_id + '_' + localVKApiPhoto.id);
    }
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "photo_sizes";
    arrayOfObject[1] = Integer.valueOf(1);
    arrayOfObject[2] = "photos";
    arrayOfObject[3] = VKStringJoiner.join(localArrayList, ",");
    new VKRequest("photos.getById", VKParameters.from(arrayOfObject), VKPhotoArray.class).executeWithListener(new VKRequest.VKRequestListener()
    {
      public void onComplete(VKResponse paramAnonymousVKResponse)
      {
        Iterator localIterator = ((VKPhotoArray)paramAnonymousVKResponse.parsedModel).iterator();
        while (localIterator.hasNext())
        {
          VKApiPhoto localVKApiPhoto = (VKApiPhoto)localIterator.next();
          if (localVKApiPhoto.src.getByType('q') != null)
            VKShareDialogDelegate.this.loadAndAddPhoto(localVKApiPhoto.src.getByType('q'));
          else if (localVKApiPhoto.src.getByType('p') != null)
            VKShareDialogDelegate.this.loadAndAddPhoto(localVKApiPhoto.src.getByType('p'));
          else if (localVKApiPhoto.src.getByType('m') != null)
            VKShareDialogDelegate.this.loadAndAddPhoto(localVKApiPhoto.src.getByType('m'));
        }
      }

      public void onError(VKError paramAnonymousVKError)
      {
        if (VKShareDialogDelegate.this.mListener != null)
          VKShareDialogDelegate.this.mListener.onVkShareError(paramAnonymousVKError);
      }
    });
  }

  private void setIsLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mSendButton.setVisibility(8);
      this.mSendProgress.setVisibility(0);
      this.mShareTextField.setEnabled(false);
      this.mPhotoLayout.setEnabled(false);
      return;
    }
    this.mSendButton.setVisibility(0);
    this.mSendProgress.setVisibility(8);
    this.mShareTextField.setEnabled(true);
    this.mPhotoLayout.setEnabled(true);
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.mListener != null)
      this.mListener.onVkShareCancel();
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    Activity localActivity = this.dialogFragmentI.getActivity();
    View localView = View.inflate(localActivity, R.layout.vk_share_dialog, null);
    assert (localView != null);
    this.mSendButton = ((Button)localView.findViewById(R.id.sendButton));
    this.mSendProgress = ((ProgressBar)localView.findViewById(R.id.sendProgress));
    this.mPhotoLayout = ((LinearLayout)localView.findViewById(R.id.imagesContainer));
    this.mShareTextField = ((EditText)localView.findViewById(R.id.shareText));
    this.mPhotoScroll = ((HorizontalScrollView)localView.findViewById(R.id.imagesScrollView));
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(R.id.attachmentLinkLayout);
    this.mSendButton.setOnClickListener(this.sendButtonPress);
    if (paramBundle != null)
    {
      this.mShareTextField.setText(paramBundle.getString("ShareText"));
      this.mAttachmentLink = ((UploadingLink)paramBundle.getParcelable("ShareLink"));
      this.mAttachmentImages = ((VKUploadImage[])paramBundle.getParcelableArray("ShareImages"));
      this.mExistingPhotos = ((VKPhotoArray)paramBundle.getParcelable("ShareUploadedImages"));
    }
    while (true)
    {
      this.mPhotoLayout.removeAllViews();
      if (this.mAttachmentImages == null)
        break label271;
      VKUploadImage[] arrayOfVKUploadImage = this.mAttachmentImages;
      int i = arrayOfVKUploadImage.length;
      for (int j = 0; j < i; j++)
        addBitmapToPreview(arrayOfVKUploadImage[j].mImageData);
      if (this.mAttachmentText != null)
        this.mShareTextField.setText(this.mAttachmentText);
    }
    this.mPhotoLayout.setVisibility(0);
    label271: if (this.mExistingPhotos != null)
      processExistingPhotos();
    if ((this.mExistingPhotos == null) && (this.mAttachmentImages == null))
      this.mPhotoLayout.setVisibility(8);
    if (this.mAttachmentLink != null)
    {
      TextView localTextView1 = (TextView)localLinearLayout.findViewById(R.id.linkTitle);
      TextView localTextView2 = (TextView)localLinearLayout.findViewById(R.id.linkHost);
      localTextView1.setText(this.mAttachmentLink.linkTitle);
      localTextView2.setText(VKUtil.getHost(this.mAttachmentLink.linkUrl));
      localLinearLayout.setVisibility(0);
    }
    while (true)
    {
      Dialog localDialog = new Dialog(localActivity);
      localDialog.requestWindowFeature(1);
      localDialog.setContentView(localView);
      localDialog.setCancelable(true);
      return localDialog;
      localLinearLayout.setVisibility(8);
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putString("ShareText", this.mShareTextField.getText().toString());
    if (this.mAttachmentLink != null)
      paramBundle.putParcelable("ShareLink", this.mAttachmentLink);
    if (this.mAttachmentImages != null)
      paramBundle.putParcelableArray("ShareImages", this.mAttachmentImages);
    if (this.mExistingPhotos != null)
      paramBundle.putParcelable("ShareUploadedImages", this.mExistingPhotos);
  }

  public void onStart()
  {
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      Display localDisplay = ((WindowManager)this.dialogFragmentI.getActivity().getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      localDisplay.getSize(localPoint);
    }
    for (int i = localPoint.x - 2 * this.dialogFragmentI.getResources().getDimensionPixelSize(R.dimen.vk_share_dialog_view_padding); ; i = -2)
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.copyFrom(this.dialogFragmentI.getDialog().getWindow().getAttributes());
      localLayoutParams.height = -2;
      localLayoutParams.width = i;
      this.dialogFragmentI.getDialog().getWindow().setAttributes(localLayoutParams);
      return;
    }
  }

  public void setAttachmentImages(VKUploadImage[] paramArrayOfVKUploadImage)
  {
    this.mAttachmentImages = paramArrayOfVKUploadImage;
  }

  public void setAttachmentLink(String paramString1, String paramString2)
  {
    this.mAttachmentLink = new UploadingLink(paramString1, paramString2);
  }

  public void setShareDialogListener(VKShareDialogBuilder.VKShareDialogListener paramVKShareDialogListener)
  {
    this.mListener = paramVKShareDialogListener;
  }

  public void setText(CharSequence paramCharSequence)
  {
    this.mAttachmentText = paramCharSequence;
  }

  public void setUploadedPhotos(VKPhotoArray paramVKPhotoArray)
  {
    this.mExistingPhotos = paramVKPhotoArray;
  }

  public static abstract interface DialogFragmentI
  {
    public abstract void dismissAllowingStateLoss();

    public abstract Activity getActivity();

    public abstract Dialog getDialog();

    public abstract Resources getResources();
  }

  private static class UploadingLink
    implements Parcelable
  {
    public static final Parcelable.Creator<UploadingLink> CREATOR = new Parcelable.Creator()
    {
      public VKShareDialogDelegate.UploadingLink createFromParcel(Parcel paramAnonymousParcel)
      {
        return new VKShareDialogDelegate.UploadingLink(paramAnonymousParcel, null);
      }

      public VKShareDialogDelegate.UploadingLink[] newArray(int paramAnonymousInt)
      {
        return new VKShareDialogDelegate.UploadingLink[paramAnonymousInt];
      }
    };
    public String linkTitle;
    public String linkUrl;

    private UploadingLink(Parcel paramParcel)
    {
      this.linkTitle = paramParcel.readString();
      this.linkUrl = paramParcel.readString();
    }

    public UploadingLink(String paramString1, String paramString2)
    {
      this.linkTitle = paramString1;
      this.linkUrl = paramString2;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.linkTitle);
      paramParcel.writeString(this.linkUrl);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.dialogs.VKShareDialogDelegate
 * JD-Core Version:    0.6.2
 */