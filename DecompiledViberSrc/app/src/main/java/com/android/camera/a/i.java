package com.android.camera.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;

public class i
  implements d
{
  private c a;
  private Uri b;

  public i(Context paramContext, ContentResolver paramContentResolver, Uri paramUri)
  {
    this.b = paramUri;
    this.a = new j(this, paramContext, paramContentResolver, paramUri);
  }

  public c a(int paramInt)
  {
    if (paramInt == 0)
      return this.a;
    return null;
  }

  public c a(Uri paramUri)
  {
    if (paramUri.equals(this.b))
      return this.a;
    return null;
  }

  public void a()
  {
    this.a = null;
    this.b = null;
  }

  public int b()
  {
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.a.i
 * JD-Core Version:    0.6.2
 */