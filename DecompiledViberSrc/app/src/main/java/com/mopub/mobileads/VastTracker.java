package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;

public class VastTracker
  implements Serializable
{
  private final a a;
  private final String b;
  private boolean c;
  private boolean d;

  public VastTracker(a parama, String paramString)
  {
    Preconditions.checkNotNull(parama);
    Preconditions.checkNotNull(paramString);
    this.a = parama;
    this.b = paramString;
  }

  public VastTracker(String paramString)
  {
    this(a.TRACKING_URL, paramString);
  }

  public VastTracker(String paramString, boolean paramBoolean)
  {
    this(paramString);
    this.d = paramBoolean;
  }

  public String getContent()
  {
    return this.b;
  }

  public a getMessageType()
  {
    return this.a;
  }

  public boolean isRepeatable()
  {
    return this.d;
  }

  public boolean isTracked()
  {
    return this.c;
  }

  public void setTracked()
  {
    this.c = true;
  }

  static enum a
  {
    static
    {
      QUARTILE_EVENT = new a("QUARTILE_EVENT", 1);
      a[] arrayOfa = new a[2];
      arrayOfa[0] = TRACKING_URL;
      arrayOfa[1] = QUARTILE_EVENT;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastTracker
 * JD-Core Version:    0.6.2
 */