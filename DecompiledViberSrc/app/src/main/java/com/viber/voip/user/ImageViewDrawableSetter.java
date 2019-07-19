package com.viber.voip.user;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dc;
import com.viber.voip.util.dq;

public class ImageViewDrawableSetter
{
  private static final Logger L = ViberEnv.getLogger();
  private byte[] mCompressed;
  private int mDurationInMillis = 0;
  private Drawable mPreviousDrawable;
  private ImageView mTarget;

  public ImageViewDrawableSetter()
  {
  }

  public ImageViewDrawableSetter(ImageView paramImageView)
  {
    this.mTarget = paramImageView;
  }

  private BitmapDrawable decodedBitmapDrawable(byte[] paramArrayOfByte)
  {
    return new BitmapDrawable(this.mTarget.getResources(), dq.a(paramArrayOfByte, 0, paramArrayOfByte.length));
  }

  private Drawable defaultDrawable()
  {
    Resources localResources = this.mTarget.getResources();
    int i = dc.a(this.mTarget.getContext(), R.attr.contactDetailsDefaultPhoto);
    try
    {
      Drawable localDrawable = localResources.getDrawable(i);
      return localDrawable;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
    }
    return null;
  }

  private Bitmap previousBitmap()
  {
    if (this.mPreviousDrawable == null)
      return null;
    return ((BitmapDrawable)this.mPreviousDrawable).getBitmap();
  }

  protected byte[] getCompressedImage()
  {
    return this.mCompressed;
  }

  public ImageView getTarget()
  {
    return this.mTarget;
  }

  protected void setCompressedImage(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.mTarget.setImageBitmap(paramBitmap);
      return;
    }
    this.mTarget.setImageDrawable(defaultDrawable());
  }

  protected void setTarget(ImageView paramImageView)
  {
    if (this.mTarget != paramImageView)
    {
      this.mTarget = paramImageView;
      this.mCompressed = null;
      this.mPreviousDrawable = null;
    }
  }

  public void setTransitionDuration(int paramInt)
  {
    this.mDurationInMillis = paramInt;
  }

  public void setupContactPhoto(Bitmap paramBitmap, ImageView paramImageView)
  {
    setTarget(paramImageView);
    setCompressedImage(paramBitmap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.ImageViewDrawableSetter
 * JD-Core Version:    0.6.2
 */