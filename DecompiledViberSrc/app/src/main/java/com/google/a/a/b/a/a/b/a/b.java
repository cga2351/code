package com.google.a.a.b.a.a.b.a;

import com.google.a.a.f.z;
import com.google.android.gms.auth.GoogleAuthException;
import java.io.IOException;

public class b extends IOException
{
  public b(GoogleAuthException paramGoogleAuthException)
  {
    initCause((Throwable)z.a(paramGoogleAuthException));
  }

  public GoogleAuthException a()
  {
    return (GoogleAuthException)super.getCause();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.b.a.a.b.a.b
 * JD-Core Version:    0.6.2
 */