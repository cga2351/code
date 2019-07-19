package com.facebook.drawee.interfaces;

import android.net.Uri;
import javax.annotation.Nullable;

public abstract interface SimpleDraweeControllerBuilder
{
  public abstract DraweeController build();

  public abstract SimpleDraweeControllerBuilder setCallerContext(Object paramObject);

  public abstract SimpleDraweeControllerBuilder setOldController(@Nullable DraweeController paramDraweeController);

  public abstract SimpleDraweeControllerBuilder setUri(Uri paramUri);

  public abstract SimpleDraweeControllerBuilder setUri(@Nullable String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
 * JD-Core Version:    0.6.2
 */