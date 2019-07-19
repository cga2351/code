package com.google.android.exoplayer2.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Parcel;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.exoplayer2.ai;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.w;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class ag
{
  public static final int a = Build.VERSION.SDK_INT;
  public static final String b = Build.DEVICE;
  public static final String c = Build.MANUFACTURER;
  public static final String d = Build.MODEL;
  public static final String e = b + ", " + d + ", " + c + ", " + a;
  public static final byte[] f = new byte[0];
  private static final Pattern g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
  private static final Pattern h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
  private static final Pattern i = Pattern.compile("%([A-Fa-f0-9]{2})");
  private static final int[] j = { 0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108 };

  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }

  public static int a(int paramInt1, int paramInt2)
  {
    return (-1 + (paramInt1 + paramInt2)) / paramInt2;
  }

  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt2, Math.min(paramInt1, paramInt3));
  }

  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2)
      return -1;
    if (paramLong1 == paramLong2)
      return 0;
    return 1;
  }

  public static int a(Context paramContext)
  {
    if (paramContext == null)
      return 0;
    NetworkInfo localNetworkInfo;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
        return 0;
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
        return 1;
    }
    catch (SecurityException localSecurityException)
    {
      return 0;
    }
    switch (localNetworkInfo.getType())
    {
    case 2:
    case 3:
    case 7:
    case 8:
    default:
      return 8;
    case 1:
      return 2;
    case 6:
      return 5;
    case 0:
    case 4:
    case 5:
      return a(localNetworkInfo);
    case 9:
    }
    return 7;
  }

  private static int a(NetworkInfo paramNetworkInfo)
  {
    switch (paramNetworkInfo.getSubtype())
    {
    case 16:
    default:
      return 6;
    case 1:
    case 2:
      return 3;
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    case 14:
    case 15:
    case 17:
      return 4;
    case 13:
      return 5;
    case 18:
    }
    return 2;
  }

  public static <T extends Comparable<? super T>> int a(List<? extends Comparable<? super T>> paramList, T paramT, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = Collections.binarySearch(paramList, paramT);
    int m;
    if (k < 0)
      m = -(k + 2);
    while (true)
    {
      if (paramBoolean2)
        m = Math.max(0, m);
      return m;
      do
        k--;
      while ((k >= 0) && (((Comparable)paramList.get(k)).compareTo(paramT) == 0));
      if (paramBoolean1)
        m = k + 1;
      else
        m = k;
    }
  }

  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt1 < paramInt2)
    {
      paramInt3 = paramInt3 << 8 ^ j[(0xFF & (paramInt3 >>> 24 ^ 0xFF & paramArrayOfByte[paramInt1]))];
      paramInt1++;
    }
    return paramInt3;
  }

  public static int a(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = Arrays.binarySearch(paramArrayOfLong, paramLong);
    if (k < 0)
      k = -(k + 2);
    while (true)
    {
      if (paramBoolean2)
        k = Math.max(0, k);
      return k;
      do
        k--;
      while ((k >= 0) && (paramArrayOfLong[k] == paramLong));
      if (paramBoolean1)
        k++;
    }
  }

  public static long a(long paramLong, float paramFloat)
  {
    if (paramFloat == 1.0F)
      return paramLong;
    return Math.round(paramLong * paramFloat);
  }

  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.max(paramLong2, Math.min(paramLong1, paramLong3));
  }

  public static long a(long paramLong1, ai paramai, long paramLong2, long paramLong3)
  {
    if (ai.a.equals(paramai))
      paramLong2 = paramLong1;
    long l1;
    int k;
    label57: int m;
    label112: label118: 
    do
    {
      return paramLong2;
      l1 = c(paramLong1, paramai.f, -9223372036854775808L);
      long l2 = b(paramLong1, paramai.g, 9223372036854775807L);
      if ((l1 <= paramLong2) && (paramLong2 <= l2))
      {
        k = 1;
        if ((l1 > paramLong3) || (paramLong3 > l2))
          break label112;
      }
      for (m = 1; ; m = 0)
      {
        if ((k == 0) || (m == 0))
          break label118;
        if (Math.abs(paramLong2 - paramLong1) <= Math.abs(paramLong3 - paramLong1))
          break;
        return paramLong3;
        k = 0;
        break label57;
      }
    }
    while (k != 0);
    if (m != 0)
      return paramLong3;
    return l1;
  }

  public static ComponentName a(Context paramContext, Intent paramIntent)
  {
    if (a >= 26)
      return paramContext.startForegroundService(paramIntent);
    return paramContext.startService(paramIntent);
  }

  public static Handler a(Looper paramLooper, Handler.Callback paramCallback)
  {
    return new Handler(paramLooper, paramCallback);
  }

  public static Looper a()
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null)
      return localLooper;
    return Looper.getMainLooper();
  }

  @EnsuresNonNull({"#1"})
  public static <T> T a(T paramT)
  {
    return paramT;
  }

  public static String a(Context paramContext, String paramString)
  {
    try
    {
      String str2 = paramContext.getPackageName();
      str1 = paramContext.getPackageManager().getPackageInfo(str2, 0).versionName;
      return paramString + "/" + str1 + " (Linux;Android " + Build.VERSION.RELEASE + ") " + "ExoPlayerLib/2.9.4";
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        String str1 = "?";
    }
  }

  public static String a(String paramString, int paramInt)
  {
    String[] arrayOfString = i(paramString);
    if (arrayOfString.length == 0);
    StringBuilder localStringBuilder;
    do
    {
      return null;
      localStringBuilder = new StringBuilder();
      int k = arrayOfString.length;
      for (int m = 0; m < k; m++)
      {
        String str = arrayOfString[m];
        if (paramInt == o.i(str))
        {
          if (localStringBuilder.length() > 0)
            localStringBuilder.append(",");
          localStringBuilder.append(str);
        }
      }
    }
    while (localStringBuilder.length() <= 0);
    return localStringBuilder.toString();
  }

  public static String a(String paramString, Object[] paramArrayOfObject)
  {
    return String.format(Locale.US, paramString, paramArrayOfObject);
  }

  public static String a(StringBuilder paramStringBuilder, Formatter paramFormatter, long paramLong)
  {
    if (paramLong == -9223372036854775807L)
      paramLong = 0L;
    long l1 = (500L + paramLong) / 1000L;
    long l2 = l1 % 60L;
    long l3 = l1 / 60L % 60L;
    long l4 = l1 / 3600L;
    paramStringBuilder.setLength(0);
    if (l4 > 0L)
    {
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = Long.valueOf(l4);
      arrayOfObject2[1] = Long.valueOf(l3);
      arrayOfObject2[2] = Long.valueOf(l2);
      return paramFormatter.format("%d:%02d:%02d", arrayOfObject2).toString();
    }
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Long.valueOf(l3);
    arrayOfObject1[1] = Long.valueOf(l2);
    return paramFormatter.format("%02d:%02d", arrayOfObject1).toString();
  }

  public static String a(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, Charset.forName("UTF-8"));
  }

  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new String(paramArrayOfByte, paramInt1, paramInt2, Charset.forName("UTF-8"));
  }

  public static ExecutorService a(String paramString)
  {
    return Executors.newSingleThreadExecutor(new ah(paramString));
  }

  public static void a(Parcel paramParcel, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int k = 1; ; k = 0)
    {
      paramParcel.writeInt(k);
      return;
    }
  }

  public static void a(h paramh)
  {
    if (paramh != null);
    try
    {
      paramh.c();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static <T> void a(List<T> paramList, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 > paramList.size()) || (paramInt1 > paramInt2))
      throw new IllegalArgumentException();
    if (paramInt1 != paramInt2)
      paramList.subList(paramInt1, paramInt2).clear();
  }

  public static void a(long[] paramArrayOfLong, long paramLong1, long paramLong2)
  {
    int k = 0;
    long l2;
    if ((paramLong2 >= paramLong1) && (paramLong2 % paramLong1 == 0L))
      l2 = paramLong2 / paramLong1;
    while (k < paramArrayOfLong.length)
    {
      paramArrayOfLong[k] /= l2;
      k++;
      continue;
      long l1;
      if ((paramLong2 < paramLong1) && (paramLong1 % paramLong2 == 0L))
        l1 = paramLong1 / paramLong2;
      while (k < paramArrayOfLong.length)
      {
        paramArrayOfLong[k] = (l1 * paramArrayOfLong[k]);
        k++;
        continue;
        double d1 = paramLong1 / paramLong2;
        while (k < paramArrayOfLong.length)
        {
          paramArrayOfLong[k] = (()(d1 * paramArrayOfLong[k]));
          k++;
        }
      }
    }
  }

  public static boolean a(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 13);
  }

  public static boolean a(Uri paramUri)
  {
    String str = paramUri.getScheme();
    return (TextUtils.isEmpty(str)) || ("file".equals(str));
  }

  public static boolean a(Parcel paramParcel)
  {
    return paramParcel.readInt() != 0;
  }

  public static boolean a(r paramr1, r paramr2, Inflater paramInflater)
  {
    if (paramr1.b() <= 0)
      return false;
    byte[] arrayOfByte1 = paramr2.a;
    if (arrayOfByte1.length < paramr1.b())
      arrayOfByte1 = new byte[2 * paramr1.b()];
    if (paramInflater == null)
      paramInflater = new Inflater();
    paramInflater.setInput(paramr1.a, paramr1.d(), paramr1.b());
    Object localObject1 = arrayOfByte1;
    int k = 0;
    try
    {
      while (true)
      {
        k += paramInflater.inflate((byte[])localObject1, k, localObject1.length - k);
        if (paramInflater.finished())
        {
          paramr2.a((byte[])localObject1, k);
          return true;
        }
        if (!paramInflater.needsDictionary())
        {
          boolean bool = paramInflater.needsInput();
          if (!bool);
        }
        else
        {
          return false;
        }
        if (k == localObject1.length)
        {
          byte[] arrayOfByte2 = Arrays.copyOf((byte[])localObject1, 2 * localObject1.length);
          localObject1 = arrayOfByte2;
        }
      }
    }
    catch (DataFormatException localDataFormatException)
    {
      return false;
    }
    finally
    {
      paramInflater.reset();
    }
  }

  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      return paramObject2 == null;
    return paramObject1.equals(paramObject2);
  }

  public static int[] a(List<Integer> paramList)
  {
    if (paramList == null)
      return null;
    int k = paramList.size();
    int[] arrayOfInt = new int[k];
    for (int m = 0; m < k; m++)
      arrayOfInt[m] = ((Integer)paramList.get(m)).intValue();
    return arrayOfInt;
  }

  @EnsuresNonNull({"#1"})
  public static <T> T[] a(T[] paramArrayOfT)
  {
    return paramArrayOfT;
  }

  public static <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    if (paramInt <= paramArrayOfT.length);
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      return Arrays.copyOf(paramArrayOfT, paramInt);
    }
  }

  public static String[] a(String paramString1, String paramString2)
  {
    return paramString1.split(paramString2, -1);
  }

  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0;
    case 8:
      return 3;
    case 16:
      return 2;
    case 24:
      return -2147483648;
    case 32:
    }
    return 1073741824;
  }

  public static int b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      throw new IllegalArgumentException();
    case 2:
      paramInt2 *= 2;
    case 3:
      return paramInt2;
    case -2147483648:
      return paramInt2 * 3;
    case 4:
    case 1073741824:
    }
    return paramInt2 * 4;
  }

  public static int b(Uri paramUri)
  {
    String str = paramUri.getPath();
    if (str == null)
      return 3;
    return j(str);
  }

  public static int b(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = Arrays.binarySearch(paramArrayOfLong, paramLong);
    if (k < 0)
      k ^= -1;
    while (true)
    {
      if (paramBoolean2)
        k = Math.min(-1 + paramArrayOfLong.length, k);
      return k;
      do
        k++;
      while ((k < paramArrayOfLong.length) && (paramArrayOfLong[k] == paramLong));
      if (paramBoolean1)
        k--;
    }
  }

  public static long b(long paramLong, float paramFloat)
  {
    if (paramFloat == 1.0F)
      return paramLong;
    return Math.round(paramLong / paramFloat);
  }

  public static long b(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramLong1 + paramLong2;
    if (((paramLong1 ^ l) & (paramLong2 ^ l)) < 0L)
      return paramLong3;
    return l;
  }

  public static String b(Context paramContext)
  {
    if (paramContext != null)
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null)
      {
        String str = localTelephonyManager.getNetworkCountryIso();
        if (!TextUtils.isEmpty(str))
          return e(str);
      }
    }
    return e(Locale.getDefault().getCountry());
  }

  public static String b(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      String str = new Locale(paramString).getISO3Language();
      return str;
    }
    catch (MissingResourceException localMissingResourceException)
    {
    }
    return d(paramString);
  }

  public static String b(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int k = 0; k < paramArrayOfObject.length; k++)
    {
      localStringBuilder.append(paramArrayOfObject[k].getClass().getSimpleName());
      if (k < -1 + paramArrayOfObject.length)
        localStringBuilder.append(", ");
    }
    return localStringBuilder.toString();
  }

  public static String[] b(String paramString1, String paramString2)
  {
    return paramString1.split(paramString2, 2);
  }

  public static long c(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramLong1 - paramLong2;
    if (((paramLong1 ^ paramLong2) & (paramLong1 ^ l)) < 0L)
      return paramLong3;
    return l;
  }

  public static boolean c(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 2) || (paramInt == -2147483648) || (paramInt == 1073741824) || (paramInt == 4);
  }

  public static byte[] c(String paramString)
  {
    return paramString.getBytes(Charset.forName("UTF-8"));
  }

  public static long d(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong3 >= paramLong2) && (paramLong3 % paramLong2 == 0L))
      return paramLong1 / (paramLong3 / paramLong2);
    if ((paramLong3 < paramLong2) && (paramLong2 % paramLong3 == 0L))
      return paramLong1 * (paramLong2 / paramLong3);
    return ()(paramLong2 / paramLong3 * paramLong1);
  }

  public static String d(String paramString)
  {
    if (paramString == null)
      return paramString;
    return paramString.toLowerCase(Locale.US);
  }

  public static boolean d(int paramInt)
  {
    return (paramInt == -2147483648) || (paramInt == 1073741824);
  }

  public static int e(int paramInt)
  {
    int k = 6396;
    switch (paramInt)
    {
    default:
      k = 0;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    do
    {
      return k;
      return 4;
      return 12;
      return 28;
      return 204;
      return 220;
      return 252;
      return 1276;
    }
    while ((a >= 23) || (a >= 21));
    return 0;
  }

  public static String e(String paramString)
  {
    if (paramString == null)
      return paramString;
    return paramString.toUpperCase(Locale.US);
  }

  public static int f(int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    case 11:
    case 12:
    case 14:
    default:
      return 3;
    case 13:
      return 1;
    case 2:
      return 0;
    case 3:
      return 8;
    case 4:
      return 4;
    case 6:
      return 2;
    case 5:
    case 7:
    case 8:
    case 9:
    case 10:
    }
    return 5;
  }

  public static long f(String paramString)
    throws w
  {
    Matcher localMatcher = g.matcher(paramString);
    if (!localMatcher.matches())
      throw new w("Invalid date/time format: " + paramString);
    int k;
    if (localMatcher.group(9) == null)
      k = 0;
    while (true)
    {
      GregorianCalendar localGregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
      localGregorianCalendar.clear();
      localGregorianCalendar.set(Integer.parseInt(localMatcher.group(1)), -1 + Integer.parseInt(localMatcher.group(2)), Integer.parseInt(localMatcher.group(3)), Integer.parseInt(localMatcher.group(4)), Integer.parseInt(localMatcher.group(5)), Integer.parseInt(localMatcher.group(6)));
      if (!TextUtils.isEmpty(localMatcher.group(8)))
        localGregorianCalendar.set(14, new BigDecimal("0." + localMatcher.group(8)).movePointRight(3).intValue());
      long l = localGregorianCalendar.getTimeInMillis();
      if (k != 0)
        l -= 60000 * k;
      return l;
      if (localMatcher.group(9).equalsIgnoreCase("Z"))
      {
        k = 0;
      }
      else
      {
        int m = 60 * Integer.parseInt(localMatcher.group(12)) + Integer.parseInt(localMatcher.group(13));
        if ("-".equals(localMatcher.group(11)))
          k = m * -1;
        else
          k = m;
      }
    }
  }

  public static int g(int paramInt)
  {
    int k = 131072;
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException();
    case 0:
      k = 16777216;
    case 3:
    case 4:
    case 5:
      return k;
    case 1:
      return 3538944;
    case 2:
      return 13107200;
    case 6:
    }
    return 0;
  }

  public static int g(String paramString)
  {
    int k = 0;
    int m = paramString.length();
    if (m <= 4);
    int n;
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      n = 0;
      while (k < m)
      {
        n = n << 8 | paramString.charAt(k);
        k++;
      }
    }
    return n;
  }

  public static byte[] h(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (int k = 0; k < arrayOfByte.length; k++)
    {
      int m = k * 2;
      arrayOfByte[k] = ((byte)((Character.digit(paramString.charAt(m), 16) << 4) + Character.digit(paramString.charAt(m + 1), 16)));
    }
    return arrayOfByte;
  }

  public static String[] i(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return new String[0];
    return a(paramString.trim(), "(\\s*,\\s*)");
  }

  public static int j(String paramString)
  {
    String str = d(paramString);
    if (str.endsWith(".mpd"))
      return 0;
    if (str.endsWith(".m3u8"))
      return 2;
    if (str.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?"))
      return 1;
    return 3;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.ag
 * JD-Core Version:    0.6.2
 */