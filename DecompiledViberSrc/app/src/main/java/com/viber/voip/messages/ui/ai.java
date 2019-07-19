package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.util.da;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

public class ai
{
  private static final Pattern a = Pattern.compile(c() + "|" + b() + "|([-])|(" + a() + ")|(\\([0-9a-zA-Z_\\!\\$\\?]+?\\))");
  private Context b;
  private dagger.a<aj> c;

  @Inject
  public ai(Context paramContext)
  {
    this.b = paramContext;
    this.c = aj.a();
  }

  private Drawable a(aj.a parama, int paramInt, boolean paramBoolean)
  {
    Resources localResources = this.b.getResources();
    Bitmap localBitmap1 = ((aj)this.c.get()).a(parama);
    Bitmap localBitmap2;
    if (paramBoolean)
    {
      localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawColor(localResources.getColor(R.color.higtlight_text_color));
      localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, null);
    }
    while (true)
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(localResources, localBitmap2);
      localBitmapDrawable.setBounds(0, 0, paramInt, paramInt);
      int i = localResources.getDimensionPixelOffset(R.dimen.emoticon_left_insert);
      int j = localResources.getDimensionPixelOffset(R.dimen.emoticon_right_insert);
      InsetDrawable localInsetDrawable = new InsetDrawable(localBitmapDrawable, i, 0, j, 0);
      localInsetDrawable.setBounds(0, 0, j + (paramInt + i), paramInt);
      return localInsetDrawable;
      localBitmap2 = localBitmap1;
    }
  }

  private Spannable a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    CharSequence localCharSequence = paramTextView.getText();
    int i;
    Object localObject;
    boolean[] arrayOfBoolean;
    if ((localCharSequence instanceof Spannable))
    {
      Spannable localSpannable = (Spannable)localCharSequence;
      i = 0;
      localObject = localSpannable;
      arrayOfBoolean = new boolean[localCharSequence.length()];
      if (paramString == null)
        break label146;
    }
    boolean bool2;
    label146: for (String str = paramString.trim(); ; str = null)
    {
      boolean bool1 = da.a(str);
      bool2 = false;
      if (bool1)
        break label152;
      Matcher localMatcher = Pattern.compile(Pattern.quote(str)).matcher(localCharSequence.subSequence(paramInt2, paramInt3));
      while (localMatcher.find())
      {
        int j = localMatcher.start();
        while (j < localMatcher.end())
        {
          arrayOfBoolean[j] = true;
          j++;
          bool2 = true;
        }
      }
      localObject = new SpannableStringBuilder(localCharSequence);
      i = 1;
      break;
    }
    label152: boolean bool3 = a((Spannable)localObject, paramInt1, paramInt2, paramInt3, bool2, arrayOfBoolean);
    if ((i != 0) && (bool3))
      paramTextView.setText((CharSequence)localObject);
    return localObject;
  }

  private static String a()
  {
    String str1 = new String(Character.toChars(127744));
    String str2 = new String(Character.toChars(128767));
    return "[" + str1 + "-" + str2 + "]";
  }

  private boolean a(Spannable paramSpannable, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, boolean[] paramArrayOfBoolean)
  {
    Matcher localMatcher;
    String str;
    if ((paramInt2 == 0) && (paramInt3 == paramSpannable.length()))
    {
      localMatcher = a.matcher(paramSpannable);
      bool1 = false;
      if (!localMatcher.find())
        break label378;
      str = localMatcher.group(0);
      if ((str.length() != 1) && (str.length() != 2))
        break label252;
      if (str.length() != 1)
        break label204;
    }
    aj.a locala1;
    int j;
    int k;
    int m;
    label204: for (int i = str.charAt(0); ; i = Character.toCodePoint(str.charAt(0), str.charAt(1)))
    {
      locala1 = ((aj)this.c.get()).a(i);
      if (locala1 == null)
        locala1 = ((aj)this.c.get()).b(str.trim());
      if (locala1 == null)
        break label241;
      j = paramInt2 + localMatcher.start();
      k = paramInt2 + localMatcher.end();
      m = 0;
      if (!paramBoolean)
        break label224;
      for (int n = j; (n < k) && (m == 0); n++)
        m = paramArrayOfBoolean[n];
      localMatcher = a.matcher(paramSpannable.subSequence(paramInt2, paramInt3));
      break;
    }
    label224: a(paramSpannable, paramInt1, locala1, j, k, m);
    boolean bool1 = true;
    label241: boolean bool2 = bool1;
    while (true)
    {
      bool1 = bool2;
      break;
      label252: aj.a locala2 = ((aj)this.c.get()).a(str);
      if (locala2 == null)
        locala2 = ((aj)this.c.get()).b(str.trim());
      if (locala2 != null)
      {
        int i1 = paramInt2 + localMatcher.start();
        int i2 = paramInt2 + localMatcher.end();
        int i3 = 0;
        if (paramBoolean)
          for (int i4 = i1; (i4 < i2) && (i3 == 0); i4++)
            i3 = paramArrayOfBoolean[i4];
        a(paramSpannable, paramInt1, locala2, i1, i2, i3);
        bool2 = true;
        continue;
        label378: return bool1;
      }
      else
      {
        bool2 = bool1;
      }
    }
  }

  private static String b()
  {
    String str1 = new String(Character.toChars(9749));
    String str2 = new String(Character.toChars(10084));
    return "([" + str1 + "-" + str2 + "])";
  }

  private void b(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramTextView, paramInt1, paramInt2, paramInt3, null);
  }

  private static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(20 * aj.b().c().size());
    localStringBuilder.append('(');
    Iterator localIterator = aj.b().c().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append("(^|\\s)");
      localStringBuilder.append(Pattern.quote(str));
      localStringBuilder.append("(?!\\S)");
      localStringBuilder.append('|');
    }
    localStringBuilder.replace(-1 + localStringBuilder.length(), localStringBuilder.length(), ")");
    return localStringBuilder.toString();
  }

  public Spannable a(TextView paramTextView, int paramInt1, int paramInt2, String paramString)
  {
    return a(paramTextView, paramInt1, paramInt2, paramTextView.getText().length(), paramString);
  }

  public Spannable a(TextView paramTextView, int paramInt, String paramString)
  {
    return a(paramTextView, paramInt, 0, paramString);
  }

  public void a(Spannable paramSpannable, int paramInt)
  {
    a(paramSpannable, paramInt, 0, paramSpannable.length(), false, null);
  }

  public void a(Spannable paramSpannable, int paramInt1, aj.a parama, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Drawable localDrawable = a(parama, paramInt1, paramBoolean);
    if (paramInt1 == aj.c)
    {
      paramSpannable.setSpan(new com.viber.voip.ui.style.a(localDrawable, 0), paramInt2, paramInt3, 33);
      return;
    }
    paramSpannable.setSpan(new ImageSpan(localDrawable, parama.c(), 0), paramInt2, paramInt3, 33);
  }

  public void a(TextView paramTextView, int paramInt)
  {
    a(paramTextView, paramInt, null);
  }

  public void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    CharSequence localCharSequence = paramTextView.getText();
    if (localCharSequence.length() == 0);
    int j;
    label78: 
    do
    {
      return;
      j = paramInt3 - paramInt2;
      if ((localCharSequence instanceof Spannable))
      {
        Spannable localSpannable = (Spannable)localCharSequence;
        int k = paramInt2 - 1;
        int i5;
        if (k >= 0)
        {
          int i4 = Math.max(paramInt2 - ((aj)this.c.get()).d(), 0);
          i5 = k;
          if (i5 > i4)
          {
            int i6 = localCharSequence.charAt(i5);
            if ((i6 != 40) && (i6 != 41))
              break label317;
          }
          if (localCharSequence.charAt(i5) == '(')
            paramInt2 = i5;
        }
        int i1;
        if (paramInt3 > 0)
          i1 = -1 + Math.min(paramInt3 + ((aj)this.c.get()).d(), localCharSequence.length());
        int m;
        for (int i2 = paramInt3; ; i2++)
          if (i2 < i1)
          {
            int i3 = localCharSequence.charAt(i2);
            if ((i3 != 40) && (i3 != 41));
          }
          else
          {
            if ((i2 <= i1) && (localCharSequence.charAt(i2) == ')'))
              paramInt3 = i2 + 1;
            m = paramInt3 - paramInt2;
            if (m <= 0)
              break;
            ImageSpan[] arrayOfImageSpan = (ImageSpan[])localSpannable.getSpans(paramInt2, paramInt3, ImageSpan.class);
            int n = arrayOfImageSpan.length;
            while (i < n)
            {
              ImageSpan localImageSpan = arrayOfImageSpan[i];
              if ((localSpannable.getSpanEnd(localImageSpan) > paramInt2) && (localSpannable.getSpanStart(localImageSpan) < paramInt3))
                localSpannable.removeSpan(localImageSpan);
              i++;
            }
            i5--;
            break label78;
          }
        j = m;
      }
    }
    while (j <= 0);
    label317: b(paramTextView, paramInt1, paramInt2, paramInt3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ai
 * JD-Core Version:    0.6.2
 */