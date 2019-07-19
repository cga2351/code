package com.vk.sdk.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.vk.sdk.R.id;
import com.vk.sdk.R.layout;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKImageOperation;
import com.vk.sdk.api.httpClient.VKImageOperation.VKImageOperationListener;

public class VKCaptchaDialog
{
  private EditText mCaptchaAnswer;
  private final VKError mCaptchaError;
  private ImageView mCaptchaImage;
  private float mDensity;
  private ProgressBar mProgressBar;

  static
  {
    if (!VKCaptchaDialog.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  public VKCaptchaDialog(VKError paramVKError)
  {
    this.mCaptchaError = paramVKError;
  }

  private void loadImage()
  {
    VKImageOperation localVKImageOperation = new VKImageOperation(this.mCaptchaError.captchaImg);
    localVKImageOperation.imageDensity = this.mDensity;
    localVKImageOperation.setImageOperationListener(new VKImageOperation.VKImageOperationListener()
    {
      public void onComplete(VKImageOperation paramAnonymousVKImageOperation, Bitmap paramAnonymousBitmap)
      {
        VKCaptchaDialog.this.mCaptchaImage.setImageBitmap(paramAnonymousBitmap);
        VKCaptchaDialog.this.mCaptchaImage.setVisibility(0);
        VKCaptchaDialog.this.mProgressBar.setVisibility(8);
      }

      public void onError(VKImageOperation paramAnonymousVKImageOperation, VKError paramAnonymousVKError)
      {
        VKCaptchaDialog.this.loadImage();
      }
    });
    VKHttpClient.enqueueOperation(localVKImageOperation);
  }

  private void sendAnswer()
  {
    VKError localVKError = this.mCaptchaError;
    if (this.mCaptchaAnswer.getText() != null);
    for (String str = this.mCaptchaAnswer.getText().toString(); ; str = "")
    {
      localVKError.answerCaptcha(str);
      return;
    }
  }

  public void show(Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    View localView = View.inflate(paramContext, R.layout.vk_captcha_dialog, null);
    assert (localView != null);
    this.mCaptchaAnswer = ((EditText)localView.findViewById(R.id.captchaAnswer));
    this.mCaptchaImage = ((ImageView)localView.findViewById(R.id.imageView));
    this.mProgressBar = ((ProgressBar)localView.findViewById(R.id.progressBar));
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    final AlertDialog localAlertDialog = new AlertDialog.Builder(paramContext).setView(localView).create();
    this.mCaptchaAnswer.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
          localAlertDialog.getWindow().setSoftInputMode(5);
      }
    });
    this.mCaptchaAnswer.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 4)
        {
          VKCaptchaDialog.this.sendAnswer();
          localAlertDialog.dismiss();
          return true;
        }
        return false;
      }
    });
    localAlertDialog.setButton(-2, paramContext.getString(17039370), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        VKCaptchaDialog.this.sendAnswer();
        paramAnonymousDialogInterface.dismiss();
      }
    });
    localAlertDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localAlertDialog.dismiss();
        VKCaptchaDialog.this.mCaptchaError.request.cancel();
      }
    });
    if (paramOnDismissListener != null)
      localAlertDialog.setOnDismissListener(paramOnDismissListener);
    loadImage();
    localAlertDialog.show();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.dialogs.VKCaptchaDialog
 * JD-Core Version:    0.6.2
 */