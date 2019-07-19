package android.support.v4.text.util;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.support.v4.util.PatternsCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.webkit.WebView;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat
{
  private static final Comparator<LinkSpec> COMPARATOR = new Comparator()
  {
    public int compare(LinkifyCompat.LinkSpec paramAnonymousLinkSpec1, LinkifyCompat.LinkSpec paramAnonymousLinkSpec2)
    {
      if (paramAnonymousLinkSpec1.start < paramAnonymousLinkSpec2.start);
      do
      {
        return -1;
        if (paramAnonymousLinkSpec1.start > paramAnonymousLinkSpec2.start)
          return 1;
        if (paramAnonymousLinkSpec1.end < paramAnonymousLinkSpec2.end)
          return 1;
      }
      while (paramAnonymousLinkSpec1.end > paramAnonymousLinkSpec2.end);
      return 0;
    }
  };
  private static final String[] EMPTY_STRING = new String[0];

  private static void addLinkMovementMethod(TextView paramTextView)
  {
    MovementMethod localMovementMethod = paramTextView.getMovementMethod();
    if (((localMovementMethod == null) || (!(localMovementMethod instanceof LinkMovementMethod))) && (paramTextView.getLinksClickable()))
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }

  public static void addLinks(TextView paramTextView, Pattern paramPattern, String paramString)
  {
    if (shouldAddLinksFallbackToFramework())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString);
      return;
    }
    addLinks(paramTextView, paramPattern, paramString, null, null, null);
  }

  public static void addLinks(TextView paramTextView, Pattern paramPattern, String paramString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
      return;
    }
    addLinks(paramTextView, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }

  @SuppressLint({"NewApi"})
  public static void addLinks(TextView paramTextView, Pattern paramPattern, String paramString, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework())
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
    SpannableString localSpannableString;
    do
    {
      return;
      localSpannableString = SpannableString.valueOf(paramTextView.getText());
    }
    while (!addLinks(localSpannableString, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter));
    paramTextView.setText(localSpannableString);
    addLinkMovementMethod(paramTextView);
  }

  public static boolean addLinks(Spannable paramSpannable, int paramInt)
  {
    if (shouldAddLinksFallbackToFramework())
      return Linkify.addLinks(paramSpannable, paramInt);
    if (paramInt == 0)
      return false;
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    for (int i = -1 + arrayOfURLSpan.length; i >= 0; i--)
      paramSpannable.removeSpan(arrayOfURLSpan[i]);
    if ((paramInt & 0x4) != 0)
      Linkify.addLinks(paramSpannable, 4);
    ArrayList localArrayList = new ArrayList();
    if ((paramInt & 0x1) != 0)
      gatherLinks(localArrayList, paramSpannable, PatternsCompat.AUTOLINK_WEB_URL, new String[] { "http://", "https://", "rtsp://" }, Linkify.sUrlMatchFilter, null);
    if ((paramInt & 0x2) != 0)
      gatherLinks(localArrayList, paramSpannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[] { "mailto:" }, null, null);
    if ((paramInt & 0x8) != 0)
      gatherMapLinks(localArrayList, paramSpannable);
    pruneOverlaps(localArrayList, paramSpannable);
    if (localArrayList.size() == 0)
      return false;
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      LinkSpec localLinkSpec = (LinkSpec)localIterator.next();
      if (localLinkSpec.frameworkAddedSpan == null)
        applyLink(localLinkSpec.url, localLinkSpec.start, localLinkSpec.end, paramSpannable);
    }
    return true;
  }

  public static boolean addLinks(Spannable paramSpannable, Pattern paramPattern, String paramString)
  {
    if (shouldAddLinksFallbackToFramework())
      return Linkify.addLinks(paramSpannable, paramPattern, paramString);
    return addLinks(paramSpannable, paramPattern, paramString, null, null, null);
  }

  public static boolean addLinks(Spannable paramSpannable, Pattern paramPattern, String paramString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework())
      return Linkify.addLinks(paramSpannable, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
    return addLinks(paramSpannable, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }

  @SuppressLint({"NewApi"})
  public static boolean addLinks(Spannable paramSpannable, Pattern paramPattern, String paramString, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework())
    {
      bool1 = Linkify.addLinks(paramSpannable, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
      return bool1;
    }
    if (paramString == null)
      paramString = "";
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1))
      paramArrayOfString = EMPTY_STRING;
    String[] arrayOfString = new String[1 + paramArrayOfString.length];
    arrayOfString[0] = paramString.toLowerCase(Locale.ROOT);
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      String str1 = paramArrayOfString[i];
      int m = i + 1;
      if (str1 == null);
      for (String str2 = ""; ; str2 = str1.toLowerCase(Locale.ROOT))
      {
        arrayOfString[m] = str2;
        i++;
        break;
      }
    }
    Matcher localMatcher = paramPattern.matcher(paramSpannable);
    boolean bool1 = false;
    label130: label205: label209: 
    while (true)
    {
      int j;
      int k;
      if (localMatcher.find())
      {
        j = localMatcher.start();
        k = localMatcher.end();
        if (paramMatchFilter == null)
          break label205;
      }
      for (boolean bool2 = paramMatchFilter.acceptMatch(paramSpannable, j, k); ; bool2 = true)
      {
        if (!bool2)
          break label209;
        applyLink(makeUrl(localMatcher.group(0), arrayOfString, localMatcher, paramTransformFilter), j, k, paramSpannable);
        bool1 = true;
        break label130;
        break;
      }
    }
  }

  public static boolean addLinks(TextView paramTextView, int paramInt)
  {
    if (shouldAddLinksFallbackToFramework())
      return Linkify.addLinks(paramTextView, paramInt);
    if (paramInt == 0)
      return false;
    CharSequence localCharSequence = paramTextView.getText();
    if ((localCharSequence instanceof Spannable))
    {
      if (addLinks((Spannable)localCharSequence, paramInt))
      {
        addLinkMovementMethod(paramTextView);
        return true;
      }
      return false;
    }
    SpannableString localSpannableString = SpannableString.valueOf(localCharSequence);
    if (addLinks(localSpannableString, paramInt))
    {
      addLinkMovementMethod(paramTextView);
      paramTextView.setText(localSpannableString);
      return true;
    }
    return false;
  }

  private static void applyLink(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable)
  {
    paramSpannable.setSpan(new URLSpan(paramString), paramInt1, paramInt2, 33);
  }

  private static String findAddress(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return WebView.findAddress(paramString);
    return FindAddress.findAddress(paramString);
  }

  private static void gatherLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable, Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    Matcher localMatcher = paramPattern.matcher(paramSpannable);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((paramMatchFilter == null) || (paramMatchFilter.acceptMatch(paramSpannable, i, j)))
      {
        LinkSpec localLinkSpec = new LinkSpec();
        localLinkSpec.url = makeUrl(localMatcher.group(0), paramArrayOfString, localMatcher, paramTransformFilter);
        localLinkSpec.start = i;
        localLinkSpec.end = j;
        paramArrayList.add(localLinkSpec);
      }
    }
  }

  // ERROR //
  private static void gatherMapLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 261	java/lang/Object:toString	()Ljava/lang/String;
    //   4: astore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_2
    //   8: invokestatic 262	android/support/v4/text/util/LinkifyCompat:findAddress	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnull +124 -> 139
    //   18: aload_2
    //   19: aload 5
    //   21: invokevirtual 266	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   24: istore 6
    //   26: iload 6
    //   28: ifge +4 -> 32
    //   31: return
    //   32: new 156	android/support/v4/text/util/LinkifyCompat$LinkSpec
    //   35: dup
    //   36: invokespecial 249	android/support/v4/text/util/LinkifyCompat$LinkSpec:<init>	()V
    //   39: astore 7
    //   41: iload 6
    //   43: aload 5
    //   45: invokevirtual 267	java/lang/String:length	()I
    //   48: iadd
    //   49: istore 8
    //   51: aload 7
    //   53: iload 6
    //   55: iload_3
    //   56: iadd
    //   57: putfield 168	android/support/v4/text/util/LinkifyCompat$LinkSpec:start	I
    //   60: aload 7
    //   62: iload_3
    //   63: iload 8
    //   65: iadd
    //   66: putfield 171	android/support/v4/text/util/LinkifyCompat$LinkSpec:end	I
    //   69: aload_2
    //   70: iload 8
    //   72: invokevirtual 270	java/lang/String:substring	(I)Ljava/lang/String;
    //   75: astore 9
    //   77: aload 9
    //   79: astore_2
    //   80: iload_3
    //   81: iload 8
    //   83: iadd
    //   84: istore_3
    //   85: aload 5
    //   87: ldc_w 272
    //   90: invokestatic 278	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 11
    //   95: aload 7
    //   97: new 280	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 283
    //   107: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 11
    //   112: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: putfield 164	android/support/v4/text/util/LinkifyCompat$LinkSpec:url	Ljava/lang/String;
    //   121: aload_0
    //   122: aload 7
    //   124: invokevirtual 253	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   127: pop
    //   128: goto -121 -> 7
    //   131: astore 4
    //   133: return
    //   134: astore 10
    //   136: goto -129 -> 7
    //   139: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	13	131	java/lang/UnsupportedOperationException
    //   18	26	131	java/lang/UnsupportedOperationException
    //   32	77	131	java/lang/UnsupportedOperationException
    //   85	95	131	java/lang/UnsupportedOperationException
    //   95	128	131	java/lang/UnsupportedOperationException
    //   85	95	134	java/io/UnsupportedEncodingException
  }

  private static String makeUrl(String paramString, String[] paramArrayOfString, Matcher paramMatcher, Linkify.TransformFilter paramTransformFilter)
  {
    boolean bool = true;
    if (paramTransformFilter != null);
    for (String str1 = paramTransformFilter.transformUrl(paramMatcher, paramString); ; str1 = paramString)
    {
      int i = 0;
      if (i < paramArrayOfString.length)
        if (str1.regionMatches(bool, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
        {
          String str2 = paramArrayOfString[i];
          int j = paramArrayOfString[i].length();
          if (!str1.regionMatches(false, 0, str2, 0, j))
            str1 = paramArrayOfString[i] + str1.substring(paramArrayOfString[i].length());
        }
      while (true)
      {
        if ((!bool) && (paramArrayOfString.length > 0))
          str1 = paramArrayOfString[0] + str1;
        return str1;
        i++;
        break;
        bool = false;
      }
    }
  }

  private static void pruneOverlaps(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    int i = 0;
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    for (int j = 0; j < arrayOfURLSpan.length; j++)
    {
      LinkSpec localLinkSpec1 = new LinkSpec();
      localLinkSpec1.frameworkAddedSpan = arrayOfURLSpan[j];
      localLinkSpec1.start = paramSpannable.getSpanStart(arrayOfURLSpan[j]);
      localLinkSpec1.end = paramSpannable.getSpanEnd(arrayOfURLSpan[j]);
      paramArrayList.add(localLinkSpec1);
    }
    Collections.sort(paramArrayList, COMPARATOR);
    int k = paramArrayList.size();
    LinkSpec localLinkSpec2;
    LinkSpec localLinkSpec3;
    int m;
    if (i < k - 1)
    {
      localLinkSpec2 = (LinkSpec)paramArrayList.get(i);
      localLinkSpec3 = (LinkSpec)paramArrayList.get(i + 1);
      if ((localLinkSpec2.start <= localLinkSpec3.start) && (localLinkSpec2.end > localLinkSpec3.start))
        if (localLinkSpec3.end <= localLinkSpec2.end)
          m = i + 1;
    }
    while (true)
    {
      if (m != -1)
      {
        URLSpan localURLSpan = ((LinkSpec)paramArrayList.get(m)).frameworkAddedSpan;
        if (localURLSpan != null)
          paramSpannable.removeSpan(localURLSpan);
        paramArrayList.remove(m);
        k--;
        break;
        if (localLinkSpec2.end - localLinkSpec2.start > localLinkSpec3.end - localLinkSpec3.start)
        {
          m = i + 1;
          continue;
        }
        if (localLinkSpec2.end - localLinkSpec2.start >= localLinkSpec3.end - localLinkSpec3.start)
          break label296;
        m = i;
        continue;
      }
      i++;
      break;
      return;
      label296: m = -1;
    }
  }

  private static boolean shouldAddLinksFallbackToFramework()
  {
    return Build.VERSION.SDK_INT >= 28;
  }

  private static class LinkSpec
  {
    int end;
    URLSpan frameworkAddedSpan;
    int start;
    String url;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface LinkifyMask
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.text.util.LinkifyCompat
 * JD-Core Version:    0.6.2
 */