package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

class n
  implements Serializable
{
  private static final List<String> a = Arrays.asList(new String[] { "image/jpeg", "image/png", "image/bmp", "image/gif" });
  private static final List<String> b = Arrays.asList(new String[] { "application/x-javascript" });
  private String c;
  private b d;
  private a e;
  private int f;
  private int g;

  n(String paramString, b paramb, a parama, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramb);
    Preconditions.checkNotNull(parama);
    this.c = paramString;
    this.d = paramb;
    this.e = parama;
    this.f = paramInt1;
    this.g = paramInt2;
  }

  static n a(VastResourceXmlManager paramVastResourceXmlManager, b paramb, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramVastResourceXmlManager);
    Preconditions.checkNotNull(paramb);
    String str1 = paramVastResourceXmlManager.c();
    String str2 = paramVastResourceXmlManager.d();
    String str3 = paramVastResourceXmlManager.a();
    String str4 = paramVastResourceXmlManager.b();
    a locala;
    if ((paramb == b.STATIC_RESOURCE) && (str3 != null) && (str4 != null) && ((a.contains(str4)) || (b.contains(str4))))
      if (a.contains(str4))
        locala = a.IMAGE;
    while (true)
    {
      return new n(str3, paramb, locala, paramInt1, paramInt2);
      locala = a.JAVASCRIPT;
      continue;
      if ((paramb == b.HTML_RESOURCE) && (str2 != null))
      {
        locala = a.NONE;
        str3 = str2;
      }
      else
      {
        if ((paramb != b.IFRAME_RESOURCE) || (str1 == null))
          break;
        locala = a.NONE;
        str3 = str1;
      }
    }
    return null;
  }

  public String getCorrectClickThroughUrl(String paramString1, String paramString2)
  {
    switch (1.a[this.d.ordinal()])
    {
    default:
      paramString2 = null;
    case 2:
    case 3:
    case 1:
    }
    do
    {
      return paramString2;
      if (a.IMAGE == this.e)
        return paramString1;
    }
    while (a.JAVASCRIPT == this.e);
    return null;
  }

  public a getCreativeType()
  {
    return this.e;
  }

  public String getResource()
  {
    return this.c;
  }

  public b getType()
  {
    return this.d;
  }

  public void initializeWebView(o paramo)
  {
    Preconditions.checkNotNull(paramo);
    if (this.d == b.IFRAME_RESOURCE)
      paramo.a("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.f + "\" height=\"" + this.g + "\" src=\"" + this.c + "\"></iframe>");
    do
    {
      do
      {
        return;
        if (this.d == b.HTML_RESOURCE)
        {
          paramo.a(this.c);
          return;
        }
      }
      while (this.d != b.STATIC_RESOURCE);
      if (this.e == a.IMAGE)
      {
        paramo.a("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.c + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>");
        return;
      }
    }
    while (this.e != a.JAVASCRIPT);
    paramo.a("<script src=\"" + this.c + "\"></script>");
  }

  static enum a
  {
    static
    {
      IMAGE = new a("IMAGE", 1);
      JAVASCRIPT = new a("JAVASCRIPT", 2);
      a[] arrayOfa = new a[3];
      arrayOfa[0] = NONE;
      arrayOfa[1] = IMAGE;
      arrayOfa[2] = JAVASCRIPT;
    }
  }

  static enum b
  {
    static
    {
      HTML_RESOURCE = new b("HTML_RESOURCE", 1);
      IFRAME_RESOURCE = new b("IFRAME_RESOURCE", 2);
      b[] arrayOfb = new b[3];
      arrayOfb[0] = STATIC_RESOURCE;
      arrayOfb[1] = HTML_RESOURCE;
      arrayOfb[2] = IFRAME_RESOURCE;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.n
 * JD-Core Version:    0.6.2
 */