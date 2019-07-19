package com.viber.voip.registration;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import c.b.a.a.b;
import c.b.a.a.j;

public class r
  implements TextWatcher
{
  j a;
  Editable b = null;
  private boolean c = false;
  private boolean d;
  private b e;
  private String f;
  private int g;
  private boolean h = false;

  public r(Context paramContext, String paramString, int paramInt)
  {
    this.a = j.a(paramContext);
    a(paramString, paramInt);
  }

  public r(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, a(paramString2));
  }

  private static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    return 0;
  }

  private String a(CharSequence paramCharSequence)
  {
    this.e.a();
    String str1 = "+" + this.g;
    String str2 = str1 + paramCharSequence;
    int i = str2.length();
    int j = 0;
    char c1 = '\000';
    Object localObject1 = "";
    char c2;
    Object localObject2;
    if (j < i)
    {
      c2 = str2.charAt(j);
      if (!PhoneNumberUtils.isNonSeparator(c2))
        break label228;
      if (c1 != 0)
        localObject1 = this.e.a(c1);
      localObject2 = localObject1;
    }
    for (char c3 = c2; ; c3 = c1)
    {
      j++;
      c1 = c3;
      localObject1 = localObject2;
      break;
      if (c1 != 0)
        localObject1 = this.e.a(c1);
      String str3 = ((String)localObject1).trim();
      String str4;
      if (str3.length() > str1.length())
        if (str3.charAt(str1.length()) == ' ')
          str4 = str3.substring(1 + str1.length());
      while (true)
      {
        if (TextUtils.isEmpty(str4))
          str4 = "";
        return str4;
        str4 = str3.substring(str1.length());
        continue;
        str4 = "";
      }
      label228: localObject2 = localObject1;
    }
  }

  private void a()
  {
    this.d = true;
    this.e.a();
  }

  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++)
      if (!PhoneNumberUtils.isNonSeparator(paramCharSequence.charAt(i)))
        return true;
    return false;
  }

  public void a(String paramString, int paramInt)
  {
    this.f = paramString;
    this.g = paramInt;
    this.e = this.a.d(paramString);
    this.e.a();
    if (this.b != null)
    {
      this.h = true;
      String str = j.c(this.b);
      this.b.replace(0, this.b.length(), str, 0, str.length());
      this.h = false;
    }
  }

  public void a(String paramString1, String paramString2)
  {
    a(paramString1, a(paramString2));
  }

  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool = true;
    while (true)
    {
      int j;
      int i1;
      int i3;
      int i2;
      int n;
      try
      {
        if (this.d)
        {
          if (paramEditable.length() != 0)
          {
            this.d = bool;
            return;
          }
          bool = false;
          continue;
        }
        if (this.c)
          continue;
        int i = Selection.getSelectionEnd(paramEditable);
        if (i != paramEditable.length())
          break label284;
        j = bool;
        String str = a(paramEditable);
        if (str.equals(paramEditable.toString()))
        {
          k = i;
          break label276;
          if ((k - 1 > 0) && (!PhoneNumberUtils.isNonSeparator(str.charAt(k - 1))))
          {
            k--;
            continue;
          }
        }
        else
        {
          if (j == 0)
            break label290;
          k = str.length();
          break label276;
          if (i1 >= paramEditable.length())
            break label299;
          if (i1 >= i)
          {
            break label299;
            if (i3 >= str.length())
              break label273;
            if (i2 == n)
            {
              k = i3;
              break label276;
            }
          }
          else
          {
            if (!PhoneNumberUtils.isNonSeparator(paramEditable.charAt(i1)))
              break label308;
            n++;
            break label308;
          }
          if (!PhoneNumberUtils.isNonSeparator(str.charAt(i3)))
            break label314;
          i2++;
          break label314;
        }
        int m = k;
        if (str == null)
          continue;
        this.c = true;
        paramEditable.replace(0, paramEditable.length(), str, 0, str.length());
        this.c = false;
        this.b = paramEditable;
        Selection.setSelection(paramEditable, m);
        continue;
      }
      finally
      {
      }
      label273: int k = 0;
      label276: if (j == 0)
      {
        continue;
        label284: j = 0;
        continue;
        label290: n = 0;
        i1 = 0;
        continue;
        label299: i2 = 0;
        i3 = 0;
        continue;
        label308: i1++;
        continue;
        label314: i3++;
      }
    }
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.c) || (this.d));
    while ((paramInt2 <= 0) || (!a(paramCharSequence, paramInt1, paramInt2)) || (this.h))
      return;
    a();
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.c) || (this.d));
    while ((paramInt3 <= 0) || (!a(paramCharSequence, paramInt1, paramInt3)))
      return;
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.r
 * JD-Core Version:    0.6.2
 */