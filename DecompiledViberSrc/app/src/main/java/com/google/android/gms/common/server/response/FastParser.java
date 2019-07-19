package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

@KeepForSdk
@ShowFirstParty
public class FastParser<T extends FastJsonResponse>
{
  private static final char[] zaqf = { 117, 108, 108 };
  private static final char[] zaqg = { 114, 117, 101 };
  private static final char[] zaqh = { 114, 117, 101, 34 };
  private static final char[] zaqi = { 97, 108, 115, 101 };
  private static final char[] zaqj = { 97, 108, 115, 101, 34 };
  private static final char[] zaqk = { '\n' };
  private static final zaa<Integer> zaqm = new zaa();
  private static final zaa<Long> zaqn = new zab();
  private static final zaa<Float> zaqo = new zac();
  private static final zaa<Double> zaqp = new zad();
  private static final zaa<Boolean> zaqq = new zae();
  private static final zaa<String> zaqr = new zaf();
  private static final zaa<BigInteger> zaqs = new zag();
  private static final zaa<BigDecimal> zaqt = new zah();
  private final char[] zaqa = new char[1];
  private final char[] zaqb = new char[32];
  private final char[] zaqc = new char[1024];
  private final StringBuilder zaqd = new StringBuilder(32);
  private final StringBuilder zaqe = new StringBuilder(1024);
  private final Stack<Integer> zaql = new Stack();

  private final int zaa(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
    throws FastParser.ParseException, IOException
  {
    int i = zaj(paramBufferedReader);
    if (i == 0)
      throw new ParseException("Unexpected EOF");
    if (i == 44)
      throw new ParseException("Missing value");
    if (i == 110)
    {
      zab(paramBufferedReader, zaqf);
      return 0;
    }
    paramBufferedReader.mark(1024);
    int j;
    if (i == 34)
    {
      int k = 0;
      int m = 0;
      if ((m < paramArrayOfChar.length) && (paramBufferedReader.read(paramArrayOfChar, m, 1) != -1))
      {
        char c = paramArrayOfChar[m];
        if (Character.isISOControl(c))
          throw new ParseException("Unexpected control character while reading string");
        if ((c == '"') && (k == 0))
        {
          paramBufferedReader.reset();
          paramBufferedReader.skip(m + 1);
          return m;
        }
        if (c == '\\')
          if (k == 0)
            k = 1;
        while (true)
        {
          m++;
          break;
          k = 0;
          continue;
          k = 0;
        }
      }
      j = m;
    }
    while (j == paramArrayOfChar.length)
    {
      throw new ParseException("Absurdly long value");
      paramArrayOfChar[0] = i;
      for (j = 1; (j < paramArrayOfChar.length) && (paramBufferedReader.read(paramArrayOfChar, j, 1) != -1); j++)
        if ((paramArrayOfChar[j] == '}') || (paramArrayOfChar[j] == ',') || (Character.isWhitespace(paramArrayOfChar[j])) || (paramArrayOfChar[j] == ']'))
        {
          paramBufferedReader.reset();
          paramBufferedReader.skip(j - 1);
          paramArrayOfChar[j] = '\000';
          return j;
        }
    }
    throw new ParseException("Unexpected EOF");
  }

  private final String zaa(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    String str = null;
    this.zaql.push(Integer.valueOf(2));
    char c = zaj(paramBufferedReader);
    switch (c)
    {
    default:
      throw new ParseException(19 + "Unexpected token: " + c);
    case '}':
      zak(2);
    case ']':
    case '"':
    }
    do
    {
      return str;
      zak(2);
      zak(1);
      zak(5);
      return null;
      this.zaql.push(Integer.valueOf(3));
      str = zab(paramBufferedReader, this.zaqb, this.zaqd, null);
      zak(3);
    }
    while (zaj(paramBufferedReader) == ':');
    throw new ParseException("Expected key/value separator");
  }

  private final String zaa(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
    throws FastParser.ParseException, IOException
  {
    switch (zaj(paramBufferedReader))
    {
    default:
      throw new ParseException("Expected string");
    case '"':
      return zab(paramBufferedReader, paramArrayOfChar1, paramStringBuilder, paramArrayOfChar2);
    case 'n':
    }
    zab(paramBufferedReader, zaqf);
    return null;
  }

  private final <T extends FastJsonResponse> ArrayList<T> zaa(BufferedReader paramBufferedReader, FastJsonResponse.Field<?, ?> paramField)
    throws FastParser.ParseException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    char c1 = zaj(paramBufferedReader);
    switch (c1)
    {
    default:
      throw new ParseException(19 + "Unexpected token: " + c1);
    case ']':
      zak(5);
      return localArrayList;
    case '{':
      this.zaql.push(Integer.valueOf(1));
    case 'n':
    }
    while (true)
    {
      try
      {
        FastJsonResponse localFastJsonResponse = paramField.zacp();
        if (!zaa(paramBufferedReader, localFastJsonResponse))
          break;
        localArrayList.add(localFastJsonResponse);
        char c2 = zaj(paramBufferedReader);
        switch (c2)
        {
        default:
          throw new ParseException(19 + "Unexpected token: " + c2);
          zab(paramBufferedReader, zaqf);
          zak(5);
          return null;
        case ',':
        case ']':
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new ParseException("Error instantiating inner object", localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new ParseException("Error instantiating inner object", localIllegalAccessException);
      }
      if (zaj(paramBufferedReader) != '{')
        throw new ParseException("Expected start of next object in array");
      this.zaql.push(Integer.valueOf(1));
    }
    zak(5);
    return localArrayList;
  }

  private final <O> ArrayList<O> zaa(BufferedReader paramBufferedReader, zaa<O> paramzaa)
    throws FastParser.ParseException, IOException
  {
    int i = zaj(paramBufferedReader);
    if (i == 110)
    {
      zab(paramBufferedReader, zaqf);
      return null;
    }
    if (i != 91)
      throw new ParseException("Expected start of array");
    this.zaql.push(Integer.valueOf(5));
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      paramBufferedReader.mark(1024);
      switch (zaj(paramBufferedReader))
      {
      case ',':
      default:
        paramBufferedReader.reset();
        localArrayList.add(paramzaa.zah(this, paramBufferedReader));
      case ']':
      case '\000':
      }
    }
    zak(5);
    return localArrayList;
    throw new ParseException("Unexpected EOF");
  }

  private final boolean zaa(BufferedReader paramBufferedReader, FastJsonResponse paramFastJsonResponse)
    throws FastParser.ParseException, IOException
  {
    Map localMap = paramFastJsonResponse.getFieldMappings();
    String str1 = zaa(paramBufferedReader);
    if (str1 == null)
    {
      zak(1);
      return false;
      str1 = null;
    }
    while (str1 != null)
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localMap.get(str1);
      if (localField == null)
      {
        str1 = zab(paramBufferedReader);
      }
      else
      {
        this.zaql.push(Integer.valueOf(4));
        switch (localField.zapq)
        {
        default:
          int m = localField.zapq;
          throw new ParseException(30 + "Invalid field type " + m);
        case 0:
          if (localField.zapr)
            paramFastJsonResponse.zaa(localField, zaa(paramBufferedReader, zaqm));
          break;
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        }
        while (true)
        {
          zak(4);
          zak(2);
          char c1 = zaj(paramBufferedReader);
          switch (c1)
          {
          case '}':
          default:
            throw new ParseException(55 + "Expected end of object or field separator, but found: " + c1);
            paramFastJsonResponse.zaa(localField, zad(paramBufferedReader));
            continue;
            if (localField.zapr)
            {
              paramFastJsonResponse.zab(localField, zaa(paramBufferedReader, zaqs));
            }
            else
            {
              paramFastJsonResponse.zaa(localField, zaf(paramBufferedReader));
              continue;
              if (localField.zapr)
              {
                paramFastJsonResponse.zac(localField, zaa(paramBufferedReader, zaqn));
              }
              else
              {
                paramFastJsonResponse.zaa(localField, zae(paramBufferedReader));
                continue;
                if (localField.zapr)
                {
                  paramFastJsonResponse.zad(localField, zaa(paramBufferedReader, zaqo));
                }
                else
                {
                  paramFastJsonResponse.zaa(localField, zag(paramBufferedReader));
                  continue;
                  if (localField.zapr)
                  {
                    paramFastJsonResponse.zae(localField, zaa(paramBufferedReader, zaqp));
                  }
                  else
                  {
                    paramFastJsonResponse.zaa(localField, zah(paramBufferedReader));
                    continue;
                    if (localField.zapr)
                    {
                      paramFastJsonResponse.zaf(localField, zaa(paramBufferedReader, zaqt));
                    }
                    else
                    {
                      paramFastJsonResponse.zaa(localField, zai(paramBufferedReader));
                      continue;
                      if (localField.zapr)
                      {
                        paramFastJsonResponse.zag(localField, zaa(paramBufferedReader, zaqq));
                      }
                      else
                      {
                        paramFastJsonResponse.zaa(localField, zaa(paramBufferedReader, false));
                        continue;
                        if (localField.zapr)
                        {
                          paramFastJsonResponse.zah(localField, zaa(paramBufferedReader, zaqr));
                        }
                        else
                        {
                          paramFastJsonResponse.zaa(localField, zac(paramBufferedReader));
                          continue;
                          paramFastJsonResponse.zaa(localField, Base64Utils.decode(zaa(paramBufferedReader, this.zaqc, this.zaqe, zaqk)));
                          continue;
                          paramFastJsonResponse.zaa(localField, Base64Utils.decodeUrlSafe(zaa(paramBufferedReader, this.zaqc, this.zaqe, zaqk)));
                          continue;
                          int k = zaj(paramBufferedReader);
                          Object localObject;
                          if (k == 110)
                          {
                            zab(paramBufferedReader, zaqf);
                            localObject = null;
                          }
                          while (true)
                          {
                            paramFastJsonResponse.zaa(localField, (Map)localObject);
                            break;
                            if (k != 123)
                              throw new ParseException("Expected start of a map object");
                            this.zaql.push(Integer.valueOf(1));
                            localObject = new HashMap();
                            char c2;
                            do
                            {
                              while (true)
                                switch (zaj(paramBufferedReader))
                                {
                                default:
                                case '\000':
                                case '"':
                                case '}':
                                }
                              throw new ParseException("Unexpected EOF");
                              String str2 = zab(paramBufferedReader, this.zaqb, this.zaqd, null);
                              if (zaj(paramBufferedReader) != ':')
                              {
                                String str5 = String.valueOf(str2);
                                if (str5.length() != 0);
                                for (String str6 = "No map value found for key ".concat(str5); ; str6 = new String("No map value found for key "))
                                  throw new ParseException(str6);
                              }
                              if (zaj(paramBufferedReader) != '"')
                              {
                                String str3 = String.valueOf(str2);
                                if (str3.length() != 0);
                                for (String str4 = "Expected String value for key ".concat(str3); ; str4 = new String("Expected String value for key "))
                                  throw new ParseException(str4);
                              }
                              ((HashMap)localObject).put(str2, zab(paramBufferedReader, this.zaqb, this.zaqd, null));
                              c2 = zaj(paramBufferedReader);
                            }
                            while (c2 == ',');
                            if (c2 == '}')
                            {
                              zak(1);
                            }
                            else
                            {
                              throw new ParseException(48 + "Unexpected character while parsing string map: " + c2);
                              zak(1);
                            }
                          }
                          if (localField.zapr)
                          {
                            int j = zaj(paramBufferedReader);
                            if (j == 110)
                            {
                              zab(paramBufferedReader, zaqf);
                              paramFastJsonResponse.addConcreteTypeArrayInternal(localField, localField.zapu, null);
                            }
                            else
                            {
                              this.zaql.push(Integer.valueOf(5));
                              if (j != 91)
                                throw new ParseException("Expected array start");
                              paramFastJsonResponse.addConcreteTypeArrayInternal(localField, localField.zapu, zaa(paramBufferedReader, localField));
                            }
                          }
                          else
                          {
                            int i = zaj(paramBufferedReader);
                            if (i == 110)
                            {
                              zab(paramBufferedReader, zaqf);
                              paramFastJsonResponse.addConcreteTypeInternal(localField, localField.zapu, null);
                            }
                            else
                            {
                              this.zaql.push(Integer.valueOf(1));
                              if (i != 123)
                                throw new ParseException("Expected start of object");
                              try
                              {
                                FastJsonResponse localFastJsonResponse = localField.zacp();
                                zaa(paramBufferedReader, localFastJsonResponse);
                                paramFastJsonResponse.addConcreteTypeInternal(localField, localField.zapu, localFastJsonResponse);
                              }
                              catch (InstantiationException localInstantiationException)
                              {
                                throw new ParseException("Error instantiating inner object", localInstantiationException);
                              }
                              catch (IllegalAccessException localIllegalAccessException)
                              {
                                throw new ParseException("Error instantiating inner object", localIllegalAccessException);
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            break;
          case ',':
          }
        }
        str1 = zaa(paramBufferedReader);
      }
    }
    zak(1);
    return true;
  }

  private final boolean zaa(BufferedReader paramBufferedReader, boolean paramBoolean)
    throws FastParser.ParseException, IOException
  {
    while (true)
    {
      char c = zaj(paramBufferedReader);
      switch (c)
      {
      default:
        throw new ParseException(19 + "Unexpected token: " + c);
      case 'n':
        zab(paramBufferedReader, zaqf);
        return false;
      case 't':
        if (paramBoolean);
        for (char[] arrayOfChar2 = zaqh; ; arrayOfChar2 = zaqg)
        {
          zab(paramBufferedReader, arrayOfChar2);
          return true;
        }
      case 'f':
        if (paramBoolean);
        for (char[] arrayOfChar1 = zaqj; ; arrayOfChar1 = zaqi)
        {
          zab(paramBufferedReader, arrayOfChar1);
          return false;
        }
      case '"':
      }
      if (paramBoolean)
        throw new ParseException("No boolean value found in string");
      paramBoolean = true;
    }
  }

  private final String zab(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    paramBufferedReader.mark(1024);
    int i3;
    int i4;
    switch (zaj(paramBufferedReader))
    {
    default:
      paramBufferedReader.reset();
      zaa(paramBufferedReader, this.zaqc);
      char c1 = zaj(paramBufferedReader);
      switch (c1)
      {
      default:
        throw new ParseException(18 + "Unexpected token " + c1);
      case ',':
      case '}':
      }
    case '"':
      if (paramBufferedReader.read(this.zaqa) == -1)
        throw new ParseException("Unexpected EOF while parsing string");
      i3 = this.zaqa[0];
      i4 = 0;
    case '{':
    case '[':
    case ',':
    }
    while ((i3 != 34) || (i4 != 0))
    {
      int i5;
      if (i3 == 92)
        if (i4 == 0)
          i5 = 1;
      while (paramBufferedReader.read(this.zaqa) == -1)
      {
        throw new ParseException("Unexpected EOF while parsing string");
        i5 = 0;
        continue;
        i5 = 0;
      }
      char c4 = this.zaqa[0];
      if (Character.isISOControl(c4))
      {
        throw new ParseException("Unexpected control character while reading string");
        this.zaql.push(Integer.valueOf(1));
        paramBufferedReader.mark(32);
        char c3 = zaj(paramBufferedReader);
        if (c3 == '}')
        {
          zak(1);
          break;
        }
        if (c3 == '"')
        {
          paramBufferedReader.reset();
          zaa(paramBufferedReader);
          while (zab(paramBufferedReader) != null);
          zak(1);
          break;
        }
        throw new ParseException(18 + "Unexpected token " + c3);
        this.zaql.push(Integer.valueOf(5));
        paramBufferedReader.mark(32);
        if (zaj(paramBufferedReader) == ']')
        {
          zak(5);
          break;
        }
        paramBufferedReader.reset();
        int i = 1;
        int j = 0;
        int k = 0;
        label409: char c2;
        int i2;
        if (i > 0)
        {
          c2 = zaj(paramBufferedReader);
          if (c2 == 0)
            throw new ParseException("Unexpected EOF while parsing array");
          if (Character.isISOControl(c2))
            throw new ParseException("Unexpected control character while reading array");
          if ((c2 != '"') || (k != 0))
            break label614;
          if (j == 0)
            i2 = 1;
        }
        label475: label614: for (int m = i2; ; m = j)
        {
          if ((c2 == '[') && (m == 0));
          for (int n = i + 1; ; n = i)
          {
            if ((c2 == ']') && (m == 0));
            for (i = n - 1; ; i = n)
            {
              if ((c2 == '\\') && (m != 0))
              {
                if (k == 0);
                for (int i1 = 1; ; i1 = 0)
                {
                  k = i1;
                  j = m;
                  break;
                  i2 = 0;
                  break label475;
                }
              }
              j = m;
              k = 0;
              break label409;
              zak(5);
              break;
              throw new ParseException("Missing value");
              zak(2);
              return zaa(paramBufferedReader);
              zak(2);
              return null;
            }
          }
        }
      }
      i4 = i5;
      i3 = c4;
    }
  }

  private static String zab(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
    throws FastParser.ParseException, IOException
  {
    paramStringBuilder.setLength(0);
    paramBufferedReader.mark(paramArrayOfChar1.length);
    int i = 0;
    int j = 0;
    while (true)
    {
      int k = paramBufferedReader.read(paramArrayOfChar1);
      if (k == -1)
        break;
      int m = 0;
      if (m < k)
      {
        char c = paramArrayOfChar1[m];
        if (Character.isISOControl(c))
        {
          int i2;
          if (paramArrayOfChar2 != null)
          {
            i2 = 0;
            if (i2 < paramArrayOfChar2.length)
              if (paramArrayOfChar2[i2] != c);
          }
          for (int i1 = 1; ; i1 = 0)
          {
            if (i1 != 0)
              break label107;
            throw new ParseException("Unexpected control character while reading string");
            i2++;
            break;
          }
        }
        label107: if ((c == '"') && (j == 0))
        {
          paramStringBuilder.append(paramArrayOfChar1, 0, m);
          paramBufferedReader.reset();
          paramBufferedReader.skip(m + 1);
          if (i != 0)
            return JsonUtils.unescapeString(paramStringBuilder.toString());
          return paramStringBuilder.toString();
        }
        int n;
        if (c == '\\')
          if (j == 0)
          {
            n = 1;
            label175: j = n;
            i = 1;
          }
        while (true)
        {
          m++;
          break;
          n = 0;
          break label175;
          j = 0;
        }
      }
      paramStringBuilder.append(paramArrayOfChar1, 0, k);
      paramBufferedReader.mark(paramArrayOfChar1.length);
    }
    throw new ParseException("Unexpected EOF while parsing string");
  }

  private final void zab(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
    throws FastParser.ParseException, IOException
  {
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      int j = paramBufferedReader.read(this.zaqb, 0, paramArrayOfChar.length - i);
      if (j == -1)
        throw new ParseException("Unexpected EOF");
      for (int k = 0; k < j; k++)
        if (paramArrayOfChar[(k + i)] != this.zaqb[k])
          throw new ParseException("Unexpected character");
      i += j;
    }
  }

  private final String zac(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    return zaa(paramBufferedReader, this.zaqb, this.zaqd, null);
  }

  private final int zad(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqc);
    int j = 0;
    if (i == 0);
    int m;
    label112: 
    do
    {
      return j;
      char[] arrayOfChar = this.zaqc;
      int n;
      if (i > 0)
      {
        int k;
        if (arrayOfChar[0] == '-')
        {
          k = -2147483648;
          n = 1;
          m = 1;
        }
        int i4;
        int i5;
        while (true)
        {
          j = 0;
          if (m >= i)
            break label112;
          i4 = m + 1;
          i5 = Character.digit(arrayOfChar[m], 10);
          if (i5 >= 0)
            break;
          throw new ParseException("Unexpected non-digit character");
          k = -2147483647;
          m = 0;
          n = 0;
        }
        j = -i5;
        int i1;
        for (m = i4; m < i; m = i1)
        {
          i1 = m + 1;
          int i2 = Character.digit(arrayOfChar[m], 10);
          if (i2 < 0)
            throw new ParseException("Unexpected non-digit character");
          if (j < -214748364)
            throw new ParseException("Number too large");
          int i3 = j * 10;
          if (i3 < k + i2)
            throw new ParseException("Number too large");
          j = i3 - i2;
        }
      }
      throw new ParseException("No number to parse");
      if (n == 0)
        break;
    }
    while (m > 1);
    throw new ParseException("No digits to parse");
    return -j;
  }

  private final long zae(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    long l1 = 0L;
    int i = zaa(paramBufferedReader, this.zaqc);
    if (i == 0);
    int j;
    do
    {
      return l1;
      char[] arrayOfChar = this.zaqc;
      int k;
      if (i > 0)
      {
        long l2;
        if (arrayOfChar[0] == '-')
        {
          l2 = -9223372036854775808L;
          k = 1;
          j = 1;
        }
        int i1;
        while (j < i)
        {
          i1 = j + 1;
          int i2 = Character.digit(arrayOfChar[j], 10);
          if (i2 < 0)
          {
            throw new ParseException("Unexpected non-digit character");
            l2 = -9223372036854775807L;
            j = 0;
            k = 0;
          }
          else
          {
            l1 = -i2;
          }
        }
        int m;
        for (j = i1; j < i; j = m)
        {
          m = j + 1;
          int n = Character.digit(arrayOfChar[j], 10);
          if (n < 0)
            throw new ParseException("Unexpected non-digit character");
          if (l1 < -922337203685477580L)
            throw new ParseException("Number too large");
          long l3 = l1 * 10L;
          if (l3 < l2 + n)
            throw new ParseException("Number too large");
          l1 = l3 - n;
        }
      }
      throw new ParseException("No number to parse");
      if (k == 0)
        break;
    }
    while (j > 1);
    throw new ParseException("No digits to parse");
    return -l1;
  }

  private final BigInteger zaf(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqc);
    if (i == 0)
      return null;
    return new BigInteger(new String(this.zaqc, 0, i));
  }

  private final float zag(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqc);
    if (i == 0)
      return 0.0F;
    return Float.parseFloat(new String(this.zaqc, 0, i));
  }

  private final double zah(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqc);
    if (i == 0)
      return 0.0D;
    return Double.parseDouble(new String(this.zaqc, 0, i));
  }

  private final BigDecimal zai(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqc);
    if (i == 0)
      return null;
    return new BigDecimal(new String(this.zaqc, 0, i));
  }

  private final char zaj(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    if (paramBufferedReader.read(this.zaqa) == -1)
      return '\000';
    while (Character.isWhitespace(this.zaqa[0]))
      if (paramBufferedReader.read(this.zaqa) == -1)
        return '\000';
    return this.zaqa[0];
  }

  private final void zak(int paramInt)
    throws FastParser.ParseException
  {
    if (this.zaql.isEmpty())
      throw new ParseException(46 + "Expected state " + paramInt + " but had empty stack");
    int i = ((Integer)this.zaql.pop()).intValue();
    if (i != paramInt)
      throw new ParseException(46 + "Expected state " + paramInt + " but had " + i);
  }

  @KeepForSdk
  public void parse(InputStream paramInputStream, T paramT)
    throws FastParser.ParseException
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1024);
    try
    {
      this.zaql.push(Integer.valueOf(0));
      char c = zaj(localBufferedReader);
      switch (c)
      {
      default:
        throw new ParseException(19 + "Unexpected token: " + c);
      case '{':
      case '[':
      case '\000':
      }
    }
    catch (IOException localIOException2)
    {
      localIOException2 = localIOException2;
      throw new ParseException(localIOException2);
    }
    finally
    {
    }
    try
    {
      localBufferedReader.close();
      throw localObject;
      this.zaql.push(Integer.valueOf(1));
      zaa(localBufferedReader, paramT);
      while (true)
      {
        zak(0);
        try
        {
          localBufferedReader.close();
          return;
          this.zaql.push(Integer.valueOf(5));
          Map localMap = paramT.getFieldMappings();
          if (localMap.size() != 1)
            throw new ParseException("Object array response class must have a single Field");
          FastJsonResponse.Field localField = (FastJsonResponse.Field)((Map.Entry)localMap.entrySet().iterator().next()).getValue();
          ArrayList localArrayList = zaa(localBufferedReader, localField);
          paramT.addConcreteTypeArrayInternal(localField, localField.zapu, localArrayList);
          continue;
          throw new ParseException("No data to parse");
        }
        catch (IOException localIOException3)
        {
          Log.w("FastParser", "Failed to close reader while parsing.");
          return;
        }
      }
    }
    catch (IOException localIOException1)
    {
      while (true)
        Log.w("FastParser", "Failed to close reader while parsing.");
    }
  }

  @KeepForSdk
  @ShowFirstParty
  public static class ParseException extends Exception
  {
    public ParseException(String paramString)
    {
      super();
    }

    public ParseException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }

    public ParseException(Throwable paramThrowable)
    {
      super();
    }
  }

  private static abstract interface zaa<O>
  {
    public abstract O zah(FastParser paramFastParser, BufferedReader paramBufferedReader)
      throws FastParser.ParseException, IOException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FastParser
 * JD-Core Version:    0.6.2
 */