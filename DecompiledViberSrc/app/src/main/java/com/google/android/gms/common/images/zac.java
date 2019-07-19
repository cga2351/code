package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zaj;
import java.lang.ref.WeakReference;

public final class zac extends zaa
{
  private WeakReference<ImageView> zanb;

  public zac(ImageView paramImageView, int paramInt)
  {
    super(null, paramInt);
    Asserts.checkNotNull(paramImageView);
    this.zanb = new WeakReference(paramImageView);
  }

  public zac(ImageView paramImageView, Uri paramUri)
  {
    super(paramUri, 0);
    Asserts.checkNotNull(paramImageView);
    this.zanb = new WeakReference(paramImageView);
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zac))
      return false;
    if (this == paramObject)
      return true;
    zac localzac = (zac)paramObject;
    ImageView localImageView1 = (ImageView)this.zanb.get();
    ImageView localImageView2 = (ImageView)localzac.zanb.get();
    return (localImageView2 != null) && (localImageView1 != null) && (Objects.equal(localImageView2, localImageView1));
  }

  public final int hashCode()
  {
    return 0;
  }

  protected final void zaa(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ImageView localImageView = (ImageView)this.zanb.get();
    int i;
    boolean bool;
    Drawable localDrawable;
    if (localImageView != null)
    {
      if ((paramBoolean2) || (paramBoolean3))
        break label188;
      i = 1;
      if ((i != 0) && ((localImageView instanceof zaj)))
      {
        int k = zaj.zach();
        if ((this.zamw != 0) && (k == this.zamw));
      }
      else
      {
        bool = zaa(paramBoolean1, paramBoolean2);
        if (!bool)
          break label206;
        localDrawable = localImageView.getDrawable();
        if (localDrawable == null)
          break label200;
        if ((localDrawable instanceof zae))
          localDrawable = ((zae)localDrawable).zacf();
      }
    }
    label106: for (Object localObject = new zae(localDrawable, paramDrawable); ; localObject = paramDrawable)
    {
      localImageView.setImageDrawable((Drawable)localObject);
      if ((localImageView instanceof zaj))
      {
        Uri localUri = null;
        if (paramBoolean3)
          localUri = this.zamu.uri;
        zaj.zaa(localUri);
        if (i == 0)
          break label194;
      }
      for (int j = this.zamw; ; j = 0)
      {
        zaj.zai(j);
        if (bool)
          ((zae)localObject).startTransition(250);
        return;
        i = 0;
        break;
      }
      localDrawable = null;
      break label106;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.zac
 * JD-Core Version:    0.6.2
 */