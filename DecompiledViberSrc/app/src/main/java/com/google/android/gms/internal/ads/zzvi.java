package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

@zzare
public final class zzvi
{
  private final int zzbvy;
  private final zzuy zzbwa;
  private String zzbwh;
  private String zzbwi;
  private final boolean zzbwj;
  private final int zzbwk;
  private final int zzbwl;

  public zzvi(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzbvy = paramInt1;
    this.zzbwj = false;
    if ((paramInt2 > 64) || (paramInt2 < 0))
    {
      this.zzbwk = 64;
      if (paramInt3 > 0)
        break label63;
    }
    label63: for (this.zzbwl = 1; ; this.zzbwl = paramInt3)
    {
      this.zzbwa = new zzvh(this.zzbwk);
      return;
      this.zzbwk = paramInt2;
      break;
    }
  }

  public final String zza(ArrayList<String> paramArrayList, ArrayList<zzux> paramArrayList1)
  {
    Collections.sort(paramArrayList1, new zzvj(this));
    HashSet localHashSet = new HashSet();
    int i = 0;
    int k;
    label79: String str2;
    label236: String str3;
    if (i < paramArrayList1.size())
    {
      String[] arrayOfString1 = Normalizer.normalize((CharSequence)paramArrayList.get(((zzux)paramArrayList1.get(i)).zzne()), Normalizer.Form.NFKC).toLowerCase(Locale.US).split("\n");
      if (arrayOfString1.length != 0)
      {
        k = 0;
        if (k < arrayOfString1.length)
        {
          str2 = arrayOfString1[k];
          if (str2.indexOf("'") == -1)
            break label563;
          StringBuilder localStringBuilder = new StringBuilder(str2);
          int m = 1;
          int n = 0;
          if (m + 2 <= localStringBuilder.length())
          {
            if (localStringBuilder.charAt(m) == '\'')
            {
              if ((localStringBuilder.charAt(m - 1) == ' ') || ((localStringBuilder.charAt(m + 1) != 's') && (localStringBuilder.charAt(m + 1) != 'S')) || ((m + 2 != localStringBuilder.length()) && (localStringBuilder.charAt(m + 2) != ' ')))
                break label236;
              localStringBuilder.insert(m, ' ');
              m += 2;
            }
            while (true)
            {
              n = 1;
              m++;
              break;
              localStringBuilder.setCharAt(m, ' ');
            }
          }
          if (n != 0)
          {
            str3 = localStringBuilder.toString();
            label260: if (str3 == null)
              break label563;
            this.zzbwi = str3;
          }
        }
      }
    }
    while (true)
    {
      String[] arrayOfString2 = zzvc.zzg(str3, true);
      int i1;
      label292: String str4;
      int i2;
      if (arrayOfString2.length >= this.zzbwl)
      {
        i1 = 0;
        if (i1 < arrayOfString2.length)
        {
          str4 = "";
          i2 = 0;
          if (i2 >= this.zzbwl)
            break label557;
          if (i1 + i2 < arrayOfString2.length);
        }
      }
      label557: for (int i3 = 0; ; i3 = 1)
      {
        int j;
        if (i3 != 0)
        {
          localHashSet.add(str4);
          if (localHashSet.size() >= this.zzbvy)
            j = 0;
        }
        while (true)
        {
          if (j == 0)
            break label482;
          i++;
          break;
          str3 = null;
          break label260;
          if (i2 > 0)
            str4 = String.valueOf(str4).concat(" ");
          String str5 = String.valueOf(str4);
          String str6 = String.valueOf(arrayOfString2[(i1 + i2)]);
          if (str6.length() != 0);
          for (str4 = str5.concat(str6); ; str4 = new String(str5))
          {
            i2++;
            break;
          }
          i1++;
          break label292;
          if (localHashSet.size() >= this.zzbvy)
          {
            j = 0;
          }
          else
          {
            k++;
            break label79;
            j = 1;
          }
        }
        label482: zzvb localzzvb = new zzvb();
        this.zzbwh = "";
        Iterator localIterator = localHashSet.iterator();
        while (true)
          if (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            try
            {
              localzzvb.write(this.zzbwa.zzbl(str1));
            }
            catch (IOException localIOException)
            {
              zzaxa.zzc("Error while writing hash to byteStream", localIOException);
            }
          }
        return localzzvb.toString();
      }
      label563: str3 = str2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvi
 * JD-Core Version:    0.6.2
 */