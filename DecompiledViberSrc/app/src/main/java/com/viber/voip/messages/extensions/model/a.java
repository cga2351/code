package com.viber.voip.messages.extensions.model;

import com.viber.jni.slashkey.ServiceDescription;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class a
{
  private static final a[] a = new a[0];
  private static final a[] b = new a[0];
  private String c;
  private a d = a.d();
  private String e;
  private String f;
  private String g;
  private String h;
  private int i;
  private boolean j;
  private a[] k = b;

  public static a a(ServiceDescription paramServiceDescription, int paramInt)
  {
    a locala = new a();
    locala.a(paramServiceDescription.getSearchName(), paramServiceDescription.getDisplayName(), paramInt, paramServiceDescription.getId());
    locala.a(paramServiceDescription.getAliases(), paramInt, paramServiceDescription.getId());
    locala.h = paramServiceDescription.getDescription();
    locala.i = paramServiceDescription.getAuthType();
    locala.j = paramServiceDescription.isHidden();
    return locala;
  }

  public static String a(String paramString)
  {
    return da.c(paramString);
  }

  private void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.c = paramString1;
    if (paramString2 == null)
      paramString2 = "";
    this.e = paramString2;
    this.d = new a(this.e, paramInt, paramString3, null);
    this.f = ('@' + this.e);
    this.g = this.e.toLowerCase(Locale.ENGLISH);
  }

  private void a(String[] paramArrayOfString, int paramInt, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      this.k = b;
      return;
    }
    this.k = new a[paramArrayOfString.length];
    int m = 0;
    label29: a[] arrayOfa;
    if (m < paramArrayOfString.length)
    {
      arrayOfa = this.k;
      if (paramArrayOfString[m] != null)
        break label76;
    }
    label76: for (String str = ""; ; str = paramArrayOfString[m])
    {
      arrayOfa[m] = new a(str, paramInt, paramString, null);
      m++;
      break label29;
      break;
    }
  }

  public static a[] a(ServiceDescription[] paramArrayOfServiceDescription, Set<String> paramSet)
  {
    int m = 0;
    if ((paramArrayOfServiceDescription == null) || (paramArrayOfServiceDescription.length == 0))
      return a;
    ArrayList localArrayList = new ArrayList(paramArrayOfServiceDescription.length);
    int n = paramArrayOfServiceDescription.length;
    for (int i1 = 0; i1 < n; i1++)
    {
      ServiceDescription localServiceDescription = paramArrayOfServiceDescription[i1];
      if (paramSet.contains(localServiceDescription.getId()))
      {
        m++;
        localArrayList.add(a(localServiceDescription, m));
      }
    }
    return (a[])localArrayList.toArray(new a[localArrayList.size()]);
  }

  public String a()
  {
    return this.d.c();
  }

  public String b()
  {
    return this.c;
  }

  public a c()
  {
    return this.d;
  }

  public String toString()
  {
    return "KeyboardExtensionDescription{mSearchName='" + this.c + '\'' + ", mTrigger=" + this.d + ", mDisplayName='" + this.e + '\'' + ", mDisplayTriggerName='" + this.f + '\'' + ", mNameForFilter='" + this.g + '\'' + ", mDescription='" + this.h + '\'' + ", mAuthType=" + this.i + ", mIsHidden=" + this.j + ", mAliases=" + Arrays.toString(this.k) + '}';
  }

  public static final class a
  {
    private static final a a = new a("", -1, "");
    private final String b;
    private final String c;
    private int d;
    private String e;

    private a(String paramString1, int paramInt, String paramString2)
    {
      this.b = paramString1.toLowerCase(Locale.ENGLISH);
      this.c = ('@' + this.b);
      this.d = paramInt;
      this.e = paramString2;
    }

    public String a()
    {
      return this.b;
    }

    public int b()
    {
      return this.d;
    }

    public String c()
    {
      return this.e;
    }

    public String toString()
    {
      return "Trigger{mNameWithoutTrigger='" + this.b + '\'' + ", mName='" + this.c + '\'' + ", mListIndex=" + this.d + ", mId='" + this.e + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.model.a
 * JD-Core Version:    0.6.2
 */