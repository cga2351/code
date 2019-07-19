package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.util.z_T4JInternalStringUtil;

public final class OEmbedRequest
  implements Serializable
{
  private static final long serialVersionUID = -4330607167106242987L;
  private Align align = Align.NONE;
  private boolean hideMedia = true;
  private boolean hideThread = true;
  private String lang;
  private int maxWidth;
  private boolean omitScript = false;
  private String[] related = new String[0];
  private final long statusId;
  private final String url;

  public OEmbedRequest(long paramLong, String paramString)
  {
    this.statusId = paramLong;
    this.url = paramString;
  }

  private void appendParameter(String paramString, long paramLong, List<HttpParameter> paramList)
  {
    if (0L <= paramLong)
      paramList.add(new HttpParameter(paramString, String.valueOf(paramLong)));
  }

  private void appendParameter(String paramString1, String paramString2, List<HttpParameter> paramList)
  {
    if (paramString2 != null)
      paramList.add(new HttpParameter(paramString1, paramString2));
  }

  public OEmbedRequest HideMedia(boolean paramBoolean)
  {
    this.hideMedia = paramBoolean;
    return this;
  }

  public OEmbedRequest HideThread(boolean paramBoolean)
  {
    this.hideThread = paramBoolean;
    return this;
  }

  public OEmbedRequest MaxWidth(int paramInt)
  {
    this.maxWidth = paramInt;
    return this;
  }

  public OEmbedRequest align(Align paramAlign)
  {
    this.align = paramAlign;
    return this;
  }

  HttpParameter[] asHttpParameterArray()
  {
    ArrayList localArrayList = new ArrayList(12);
    appendParameter("id", this.statusId, localArrayList);
    appendParameter("url", this.url, localArrayList);
    appendParameter("maxwidth", this.maxWidth, localArrayList);
    localArrayList.add(new HttpParameter("hide_media", this.hideMedia));
    localArrayList.add(new HttpParameter("hide_thread", this.hideThread));
    localArrayList.add(new HttpParameter("omit_script", this.omitScript));
    localArrayList.add(new HttpParameter("align", this.align.name().toLowerCase()));
    if (this.related.length > 0)
      appendParameter("related", z_T4JInternalStringUtil.join(this.related), localArrayList);
    appendParameter("lang", this.lang, localArrayList);
    return (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()]);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    OEmbedRequest localOEmbedRequest;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localOEmbedRequest = (OEmbedRequest)paramObject;
      if (this.hideMedia != localOEmbedRequest.hideMedia)
        return false;
      if (this.hideThread != localOEmbedRequest.hideThread)
        return false;
      if (this.maxWidth != localOEmbedRequest.maxWidth)
        return false;
      if (this.omitScript != localOEmbedRequest.omitScript)
        return false;
      if (this.statusId != localOEmbedRequest.statusId)
        return false;
      if (this.align != localOEmbedRequest.align)
        return false;
      if (this.lang != null)
      {
        if (this.lang.equals(localOEmbedRequest.lang));
      }
      else
        while (localOEmbedRequest.lang != null)
          return false;
      if (!Arrays.equals(this.related, localOEmbedRequest.related))
        return false;
      if (this.url == null)
        break;
    }
    while (this.url.equals(localOEmbedRequest.url));
    while (true)
    {
      return false;
      if (localOEmbedRequest.url == null)
        break;
    }
  }

  public int hashCode()
  {
    int i = 1;
    int j = 31 * (int)(this.statusId ^ this.statusId >>> 32);
    int k;
    int n;
    label60: int i2;
    label80: label97: int i5;
    label122: int i6;
    if (this.url != null)
    {
      k = this.url.hashCode();
      int m = 31 * (31 * (k + j) + this.maxWidth);
      if (!this.hideMedia)
        break label192;
      n = i;
      int i1 = 31 * (n + m);
      if (!this.hideThread)
        break label198;
      i2 = i;
      int i3 = 31 * (i2 + i1);
      if (!this.omitScript)
        break label204;
      int i4 = 31 * (i3 + i);
      if (this.align == null)
        break label209;
      i5 = this.align.hashCode();
      i6 = 31 * (i5 + i4);
      if (this.related == null)
        break label215;
    }
    label192: label198: label204: label209: label215: for (int i7 = Arrays.hashCode(this.related); ; i7 = 0)
    {
      int i8 = 31 * (i7 + i6);
      String str = this.lang;
      int i9 = 0;
      if (str != null)
        i9 = this.lang.hashCode();
      return i8 + i9;
      k = 0;
      break;
      n = 0;
      break label60;
      i2 = 0;
      break label80;
      i = 0;
      break label97;
      i5 = 0;
      break label122;
    }
  }

  public OEmbedRequest lang(String paramString)
  {
    this.lang = paramString;
    return this;
  }

  public OEmbedRequest omitScript(boolean paramBoolean)
  {
    this.omitScript = paramBoolean;
    return this;
  }

  public OEmbedRequest related(String[] paramArrayOfString)
  {
    this.related = paramArrayOfString;
    return this;
  }

  public void setAlign(Align paramAlign)
  {
    this.align = paramAlign;
  }

  public void setHideMedia(boolean paramBoolean)
  {
    this.hideMedia = paramBoolean;
  }

  public void setHideThread(boolean paramBoolean)
  {
    this.hideThread = paramBoolean;
  }

  public void setLang(String paramString)
  {
    this.lang = paramString;
  }

  public void setMaxWidth(int paramInt)
  {
    this.maxWidth = paramInt;
  }

  public void setOmitScript(boolean paramBoolean)
  {
    this.omitScript = paramBoolean;
  }

  public void setRelated(String[] paramArrayOfString)
  {
    this.related = paramArrayOfString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("OEmbedRequest{statusId=").append(this.statusId).append(", url='").append(this.url).append('\'').append(", maxWidth=").append(this.maxWidth).append(", hideMedia=").append(this.hideMedia).append(", hideThread=").append(this.hideThread).append(", omitScript=").append(this.omitScript).append(", align=").append(this.align).append(", related=");
    if (this.related == null);
    for (Object localObject = null; ; localObject = Arrays.asList(this.related))
      return localObject + ", lang='" + this.lang + '\'' + '}';
  }

  public static enum Align
  {
    static
    {
      CENTER = new Align("CENTER", 1);
      RIGHT = new Align("RIGHT", 2);
      NONE = new Align("NONE", 3);
      Align[] arrayOfAlign = new Align[4];
      arrayOfAlign[0] = LEFT;
      arrayOfAlign[1] = CENTER;
      arrayOfAlign[2] = RIGHT;
      arrayOfAlign[3] = NONE;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.OEmbedRequest
 * JD-Core Version:    0.6.2
 */