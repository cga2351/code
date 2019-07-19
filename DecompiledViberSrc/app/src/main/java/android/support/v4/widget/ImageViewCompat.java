package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

public class ImageViewCompat
{
  public static ColorStateList getImageTintList(ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramImageView.getImageTintList();
    if ((paramImageView instanceof TintableImageSourceView))
      return ((TintableImageSourceView)paramImageView).getSupportImageTintList();
    return null;
  }

  public static PorterDuff.Mode getImageTintMode(ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramImageView.getImageTintMode();
    if ((paramImageView instanceof TintableImageSourceView))
      return ((TintableImageSourceView)paramImageView).getSupportImageTintMode();
    return null;
  }

  public static void setImageTintList(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        localDrawable = paramImageView.getDrawable();
        if ((paramImageView.getImageTintList() == null) || (paramImageView.getImageTintMode() == null))
          break label72;
        i = 1;
        if ((localDrawable != null) && (i != 0))
        {
          if (localDrawable.isStateful())
            localDrawable.setState(paramImageView.getDrawableState());
          paramImageView.setImageDrawable(localDrawable);
        }
      }
    }
    label72: 
    while (!(paramImageView instanceof TintableImageSourceView))
      while (true)
      {
        Drawable localDrawable;
        return;
        int i = 0;
      }
    ((TintableImageSourceView)paramImageView).setSupportImageTintList(paramColorStateList);
  }

  public static void setImageTintMode(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        localDrawable = paramImageView.getDrawable();
        if ((paramImageView.getImageTintList() == null) || (paramImageView.getImageTintMode() == null))
          break label72;
        i = 1;
        if ((localDrawable != null) && (i != 0))
        {
          if (localDrawable.isStateful())
            localDrawable.setState(paramImageView.getDrawableState());
          paramImageView.setImageDrawable(localDrawable);
        }
      }
    }
    label72: 
    while (!(paramImageView instanceof TintableImageSourceView))
      while (true)
      {
        Drawable localDrawable;
        return;
        int i = 0;
      }
    ((TintableImageSourceView)paramImageView).setSupportImageTintMode(paramMode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ImageViewCompat
 * JD-Core Version:    0.6.2
 */