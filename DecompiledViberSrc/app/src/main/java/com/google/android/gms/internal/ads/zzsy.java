package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public final class zzsy
{
  public static final String DEVICE;
  public static final String MANUFACTURER;
  public static final String MODEL;
  public static final int SDK_INT;
  private static final Pattern zzaqx;
  private static final Pattern zzaqy;
  public static final String zzbnq;
  private static final Pattern zzbnr;
  private static final int[] zzbns;

  static
  {
    if ((Build.VERSION.SDK_INT == 25) && (Build.VERSION.CODENAME.charAt(0) == 'O'));
    for (int i = 26; ; i = Build.VERSION.SDK_INT)
    {
      SDK_INT = i;
      DEVICE = Build.DEVICE;
      MANUFACTURER = Build.MANUFACTURER;
      MODEL = Build.MODEL;
      String str1 = DEVICE;
      String str2 = MODEL;
      String str3 = MANUFACTURER;
      int j = SDK_INT;
      zzbnq = 17 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + ", " + str2 + ", " + str3 + ", " + j;
      zzaqx = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
      zzaqy = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
      zzbnr = Pattern.compile("%([A-Fa-f0-9]{2})");
      zzbns = new int[] { 0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108 };
      return;
    }
  }

  public static float zza(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(0.1F, Math.min(paramFloat1, 8.0F));
  }

  public static int zza(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Arrays.binarySearch(paramArrayOfLong, paramLong);
    if (i < 0);
    for (int j = -(i + 2); ; j = i + 1)
    {
      if (paramBoolean2)
        j = Math.max(0, j);
      return j;
      do
        i--;
      while ((i >= 0) && (paramArrayOfLong[i] == paramLong));
    }
  }

  public static long zza(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong3 >= paramLong2) && (paramLong3 % paramLong2 == 0L))
      return paramLong1 / (paramLong3 / paramLong2);
    if ((paramLong3 < paramLong2) && (paramLong2 % paramLong3 == 0L))
      return paramLong1 * (paramLong2 / paramLong3);
    return ()(paramLong2 / paramLong3 * paramLong1);
  }

  public static String zza(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfObject.length; i++)
    {
      localStringBuilder.append(paramArrayOfObject[i].getClass().getSimpleName());
      if (i < -1 + paramArrayOfObject.length)
        localStringBuilder.append(", ");
    }
    return localStringBuilder.toString();
  }

  public static void zza(zzrv paramzzrv)
  {
    if (paramzzrv != null);
    try
    {
      paramzzrv.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static void zza(long[] paramArrayOfLong, long paramLong1, long paramLong2)
  {
    int i = 0;
    long l2;
    if ((paramLong2 >= 1000000L) && (paramLong2 % 1000000L == 0L))
      l2 = paramLong2 / 1000000L;
    while (i < paramArrayOfLong.length)
    {
      paramArrayOfLong[i] /= l2;
      i++;
      continue;
      long l1;
      if ((paramLong2 < 1000000L) && (1000000L % paramLong2 == 0L))
        l1 = 1000000L / paramLong2;
      while (i < paramArrayOfLong.length)
      {
        paramArrayOfLong[i] = (l1 * paramArrayOfLong[i]);
        i++;
        continue;
        double d = 1000000.0D / paramLong2;
        while (i < paramArrayOfLong.length)
        {
          paramArrayOfLong[i] = (()(d * paramArrayOfLong[i]));
          i++;
        }
      }
    }
  }

  public static boolean zza(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      return paramObject2 == null;
    return paramObject1.equals(paramObject2);
  }

  public static ExecutorService zzax(String paramString)
  {
    return Executors.newSingleThreadExecutor(new zzsz(paramString));
  }

  public static int zzay(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    if (j <= 4);
    int k;
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkArgument(bool);
      k = 0;
      while (i < j)
      {
        k = k << 8 | paramString.charAt(i);
        i++;
      }
    }
    return k;
  }

  public static int zzb(int paramInt1, int paramInt2)
  {
    return (-1 + (paramInt1 + paramInt2)) / paramInt2;
  }

  public static int zzb(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Arrays.binarySearch(paramArrayOfLong, paramLong);
    if (i < 0)
      i ^= -1;
    while (true)
    {
      if (paramBoolean2)
        i = Math.min(-1 + paramArrayOfLong.length, i);
      return i;
      do
        i++;
      while ((i < paramArrayOfLong.length) && (paramArrayOfLong[i] == paramLong));
      if (paramBoolean1)
        i--;
    }
  }

  public static String zzbg(String paramString)
  {
    if (paramString == null)
      return null;
    return new Locale(paramString).getLanguage();
  }

  public static byte[] zzbh(String paramString)
  {
    return paramString.getBytes(Charset.defaultCharset());
  }

  public static byte[] zzbi(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (int i = 0; i < arrayOfByte.length; i++)
    {
      int j = i << 1;
      arrayOfByte[i] = ((byte)((Character.digit(paramString.charAt(j), 16) << 4) + Character.digit(paramString.charAt(j + 1), 16)));
    }
    return arrayOfByte;
  }

  public static int zzbs(int paramInt)
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

  public static int zzbt(int paramInt)
  {
    int i = 131072;
    switch (paramInt)
    {
    default:
      throw new IllegalStateException();
    case 0:
      i = 16777216;
    case 3:
    case 4:
      return i;
    case 1:
      return 3538944;
    case 2:
    }
    return 13107200;
  }

  public static int zzd(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt2, Math.min(paramInt1, paramInt3));
  }

  public static int zzg(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      throw new IllegalArgumentException();
    case 2:
      paramInt2 <<= 1;
    case 3:
      return paramInt2;
    case -2147483648:
      return paramInt2 * 3;
    case 1073741824:
    }
    return paramInt2 << 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsy
 * JD-Core Version:    0.6.2
 */