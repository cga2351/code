package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.o;
import java.util.Locale;

public class b
  implements h
{
  private final Resources a;

  public b(Resources paramResources)
  {
    this.a = ((Resources)a.a(paramResources));
  }

  private String a(String paramString)
  {
    if (ag.a >= 21);
    for (Locale localLocale = Locale.forLanguageTag(paramString); ; localLocale = new Locale(paramString))
      return localLocale.getDisplayLanguage();
  }

  private String a(String[] paramArrayOfString)
  {
    Object localObject1 = "";
    int i = paramArrayOfString.length;
    int j = 0;
    Object localObject2;
    if (j < i)
    {
      localObject2 = paramArrayOfString[j];
      if (((String)localObject2).length() <= 0)
        break label75;
      if (!TextUtils.isEmpty((CharSequence)localObject1));
    }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      break;
      localObject2 = this.a.getString(R.string.exo_item_list, new Object[] { localObject1, localObject2 });
      continue;
      return localObject1;
      label75: localObject2 = localObject1;
    }
  }

  private String b(Format paramFormat)
  {
    int i = paramFormat.width;
    int j = paramFormat.height;
    if ((i == -1) || (j == -1))
      return "";
    Resources localResources = this.a;
    int k = R.string.exo_track_resolution;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(i);
    arrayOfObject[1] = Integer.valueOf(j);
    return localResources.getString(k, arrayOfObject);
  }

  private String c(Format paramFormat)
  {
    int i = paramFormat.bitrate;
    if (i == -1)
      return "";
    Resources localResources = this.a;
    int j = R.string.exo_track_bitrate;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Float.valueOf(i / 1000000.0F);
    return localResources.getString(j, arrayOfObject);
  }

  private String d(Format paramFormat)
  {
    int i = paramFormat.channelCount;
    if ((i == -1) || (i < 1))
      return "";
    switch (i)
    {
    case 3:
    case 4:
    case 5:
    default:
      return this.a.getString(R.string.exo_track_surround);
    case 1:
      return this.a.getString(R.string.exo_track_mono);
    case 2:
      return this.a.getString(R.string.exo_track_stereo);
    case 6:
    case 7:
      return this.a.getString(R.string.exo_track_surround_5_point_1);
    case 8:
    }
    return this.a.getString(R.string.exo_track_surround_7_point_1);
  }

  private String e(Format paramFormat)
  {
    if (!TextUtils.isEmpty(paramFormat.label))
      return paramFormat.label;
    String str = paramFormat.language;
    if ((TextUtils.isEmpty(str)) || ("und".equals(str)))
      return "";
    return a(str);
  }

  private static int f(Format paramFormat)
  {
    int i = o.g(paramFormat.sampleMimeType);
    if (i != -1)
      return i;
    if (o.d(paramFormat.codecs) != null)
      return 2;
    if (o.e(paramFormat.codecs) != null)
      return 1;
    if ((paramFormat.width != -1) || (paramFormat.height != -1))
      return 2;
    if ((paramFormat.channelCount != -1) || (paramFormat.sampleRate != -1))
      return 1;
    return -1;
  }

  public String a(Format paramFormat)
  {
    int i = f(paramFormat);
    String str;
    if (i == 2)
    {
      String[] arrayOfString2 = new String[2];
      arrayOfString2[0] = b(paramFormat);
      arrayOfString2[1] = c(paramFormat);
      str = a(arrayOfString2);
    }
    while (true)
    {
      if (str.length() == 0)
        str = this.a.getString(R.string.exo_track_unknown);
      return str;
      if (i == 1)
      {
        String[] arrayOfString1 = new String[3];
        arrayOfString1[0] = e(paramFormat);
        arrayOfString1[1] = d(paramFormat);
        arrayOfString1[2] = c(paramFormat);
        str = a(arrayOfString1);
      }
      else
      {
        str = e(paramFormat);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.b
 * JD-Core Version:    0.6.2
 */