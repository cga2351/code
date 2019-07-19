package com.viber.voip.util.links;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.liblinkparser.LinkParser;
import com.viber.liblinkparser.LinkParser.LinkSpec;
import com.viber.liblinkparser.LinkParser.LinkSpec.Type;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.style.InternalURLSpan;
import com.viber.voip.util.ar;
import com.viber.voip.util.ci;
import com.viber.voip.util.da;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class f
{
  private static final Logger a = ViberEnv.getLogger();
  private static final e b = new e()
  {
    public final String a(String paramAnonymousString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      int j = paramAnonymousString.length();
      while (i < j)
      {
        char c = paramAnonymousString.charAt(i);
        if ((c == '+') || (Character.isDigit(c)))
          localStringBuilder.append(c);
        i++;
      }
      return localStringBuilder.toString();
    }
  };
  private static final ar<b, d> c = new ar(TimeUnit.MINUTES.toMillis(1L));
  private int d = 15;

  public static a a()
  {
    return new a();
  }

  private static String a(String paramString, String[] paramArrayOfString, e parame)
  {
    boolean bool = true;
    String str1;
    int j;
    if (parame != null)
    {
      str1 = parame.a(paramString);
      int i = paramArrayOfString.length;
      j = 0;
      label22: if (j >= i)
        break label147;
      String str2 = paramArrayOfString[j];
      if (!str1.regionMatches(bool, 0, str2, 0, str2.length()))
        break label141;
      int k = str2.length();
      if (!str1.regionMatches(false, 0, str2, 0, k))
        str1 = str2 + str1.substring(str2.length());
    }
    while (true)
    {
      if (!bool)
        str1 = paramArrayOfString[0] + str1;
      return str1;
      str1 = paramString;
      break;
      label141: j++;
      break label22;
      label147: bool = false;
    }
  }

  private static void a(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable)
  {
    paramSpannable.setSpan(new InternalURLSpan(paramString), paramInt1, paramInt2, 33);
  }

  private static void a(List<d> paramList, List<LinkParser.LinkSpec> paramList1, LinkParser.LinkSpec.Type paramType, String paramString, String[] paramArrayOfString, c paramc, e parame)
  {
    int i = paramList1.size();
    int j = 0;
    if (j < i)
    {
      LinkParser.LinkSpec localLinkSpec = (LinkParser.LinkSpec)paramList1.get(j);
      if (paramType != localLinkSpec.type);
      while (true)
      {
        j++;
        break;
        if ((paramc == null) || (paramc.a(paramString, localLinkSpec.start, localLinkSpec.end)))
          try
          {
            paramList.add(new d(a(paramString.subSequence(localLinkSpec.start, localLinkSpec.end).toString(), paramArrayOfString, parame), localLinkSpec.start, localLinkSpec.end));
          }
          catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
          {
          }
      }
    }
  }

  public static f b()
  {
    return a().a();
  }

  public static d c(String paramString)
  {
    Object localObject = a(paramString, d.a, null);
    Uri localUri = Uri.parse((String)localObject);
    if (localUri.getHost() != null);
    try
    {
      String str = localUri.buildUpon().authority(IDN.toASCII(localUri.getHost())).build().toString();
      localObject = str;
      label46: return new d((String)localObject, paramString);
    }
    catch (Exception localException)
    {
      break label46;
    }
  }

  public static f c()
  {
    return a().a(11).a();
  }

  public static f d()
  {
    return a().a(1).a();
  }

  public d a(String paramString)
  {
    return a(paramString, null);
  }

  public d a(String paramString, ci<String> paramci)
  {
    i.a();
    int i = this.d;
    Object localObject1 = null;
    if (i == 0);
    b localb;
    Object localObject2;
    d locald3;
    do
    {
      boolean bool1;
      do
      {
        return localObject1;
        bool1 = da.a(paramString);
        localObject1 = null;
      }
      while (bool1);
      localb = new b(paramString, this.d);
      d locald1 = (d)c.get(localb);
      if (locald1 != null)
        return locald1;
      Iterator localIterator = b(paramString).iterator();
      localObject2 = null;
      boolean bool2 = localIterator.hasNext();
      localObject1 = null;
      if (bool2)
      {
        LinkParser.LinkSpec localLinkSpec = (LinkParser.LinkSpec)localIterator.next();
        String str = paramString.subSequence(localLinkSpec.start, localLinkSpec.end).toString();
        d locald2 = c(str);
        locald3 = new d(locald2.a, locald2.b, localLinkSpec.start, localLinkSpec.end);
        if ((paramci != null) && (!paramci.apply(str)))
          break;
        localObject1 = locald3;
      }
      if (localObject1 == null)
        localObject1 = localObject2;
    }
    while (localObject1 == null);
    c.put(localb, localObject1);
    return localObject1;
    if (localObject2 == null);
    for (Object localObject3 = locald3; ; localObject3 = localObject2)
    {
      localObject2 = localObject3;
      break;
    }
  }

  public boolean a(Spannable paramSpannable)
  {
    int i = 0;
    i.a();
    if (this.d == 0)
      return false;
    if (da.a(paramSpannable))
      return false;
    String str = paramSpannable.toString();
    List localList = b(str);
    ArrayList localArrayList = new ArrayList();
    if ((0x1 & this.d) != 0)
      a(localArrayList, localList, LinkParser.LinkSpec.Type.WEB, str, d.a, null, null);
    if ((0x2 & this.d) != 0)
      a(localArrayList, localList, LinkParser.LinkSpec.Type.EMAIL, str, d.b, null, null);
    if ((0x4 & this.d) != 0)
      a(localArrayList, localList, LinkParser.LinkSpec.Type.PHONE, str, d.c, null, b);
    if ((0x8 & this.d) != 0)
      a(localArrayList, localList, LinkParser.LinkSpec.Type.VIBER, str, d.d, null, null);
    if (localArrayList.isEmpty())
      return false;
    InternalURLSpan[] arrayOfInternalURLSpan = (InternalURLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), InternalURLSpan.class);
    for (int j = -1 + arrayOfInternalURLSpan.length; j >= 0; j--)
      paramSpannable.removeSpan(arrayOfInternalURLSpan[j]);
    int k = localArrayList.size();
    while (i < k)
    {
      d locald = (d)localArrayList.get(i);
      a(locald.a, locald.c, locald.d, paramSpannable);
      i++;
    }
    return true;
  }

  public <T extends TextView> boolean a(T paramT)
  {
    if (this.d == 0)
      return false;
    CharSequence localCharSequence = paramT.getText();
    e.b(paramT);
    if (da.a(localCharSequence))
      return false;
    if ((localCharSequence instanceof Spannable))
    {
      if (a((Spannable)localCharSequence))
      {
        e.a(paramT);
        return true;
      }
      return false;
    }
    SpannableString localSpannableString = SpannableString.valueOf(localCharSequence);
    if (a(localSpannableString))
    {
      e.a(paramT);
      paramT.setText(localSpannableString);
      return true;
    }
    return false;
  }

  public List<LinkParser.LinkSpec> b(String paramString)
  {
    if (this.d == 0)
      return Collections.emptyList();
    i.a();
    ArrayList localArrayList1 = LinkParser.parseText(paramString, LinkParser.LinkSpec.Type.ALL);
    ArrayList localArrayList2 = new ArrayList();
    int i = localArrayList1.size();
    int j = 0;
    if (j < i)
    {
      LinkParser.LinkSpec localLinkSpec = (LinkParser.LinkSpec)localArrayList1.get(j);
      if ((localLinkSpec.start < 0) || (localLinkSpec.end > paramString.length()) || (localLinkSpec.start > localLinkSpec.end));
      while (true)
      {
        j++;
        break;
        if (((0x1 & this.d) != 0) && (LinkParser.LinkSpec.Type.WEB == localLinkSpec.type))
          localArrayList2.add(localLinkSpec);
        if (((0x2 & this.d) != 0) && (LinkParser.LinkSpec.Type.EMAIL == localLinkSpec.type))
          localArrayList2.add(localLinkSpec);
        if (((0x4 & this.d) != 0) && (LinkParser.LinkSpec.Type.PHONE == localLinkSpec.type))
          localArrayList2.add(localLinkSpec);
        if (((0x8 & this.d) != 0) && (LinkParser.LinkSpec.Type.VIBER == localLinkSpec.type))
          localArrayList2.add(localLinkSpec);
      }
    }
    return localArrayList2;
  }

  public static final class a
  {
    private int a = 15;

    public a a(int paramInt)
    {
      this.a = paramInt;
      return this;
    }

    public f a()
    {
      f localf = new f(null);
      f.a(localf, this.a);
      return localf;
    }
  }

  private static final class b
  {
    private final String a;
    private final int b;

    public b(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      b localb;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localb = (b)paramObject;
        if (this.b != localb.b)
          return false;
        if (this.a != null)
          return this.a.equals(localb.a);
      }
      while (localb.a == null);
      return false;
    }

    public int hashCode()
    {
      if (this.a != null);
      for (int i = this.a.hashCode(); ; i = 0)
        return i * 31 + this.b;
    }

    public String toString()
    {
      return "CacheKey{  mText='" + this.a + '\'' + ", mScopeMask=" + this.b + "  }";
    }
  }

  private static abstract interface c
  {
    public abstract boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  }

  private static final class d
  {
    public static final String[] a = { "http://", "https://", "rtsp://" };
    public static final String[] b = { "mailto:" };
    public static final String[] c = { "tel:" };
    public static final String[] d = { "viber://", "viber.soc://", "rakutenbank://" };
  }

  private static abstract interface e
  {
    public abstract String a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.links.f
 * JD-Core Version:    0.6.2
 */