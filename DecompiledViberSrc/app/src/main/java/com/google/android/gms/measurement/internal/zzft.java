package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzya;
import com.google.android.gms.internal.measurement.zzyi;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class zzft extends zzfm
{
  zzft(zzfn paramzzfn)
  {
    super(paramzzfn);
  }

  static zzfu zza(com.google.android.gms.internal.measurement.zzft paramzzft, String paramString)
  {
    for (zzfu localzzfu : paramzzft.zzaxc)
      if (localzzfu.name.equals(paramString))
        return localzzfu;
    return null;
  }

  private static void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
      paramStringBuilder.append("  ");
  }

  private final void zza(StringBuilder paramStringBuilder, int paramInt, zzfk paramzzfk)
  {
    if (paramzzfk == null)
      return;
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("filter {\n");
    zza(paramStringBuilder, paramInt, "complement", paramzzfk.zzavu);
    zza(paramStringBuilder, paramInt, "param_name", zzgq().zzbu(paramzzfk.zzavv));
    int i = paramInt + 1;
    com.google.android.gms.internal.measurement.zzfn localzzfn = paramzzfk.zzavs;
    if (localzzfn != null)
    {
      zza(paramStringBuilder, i);
      paramStringBuilder.append("string_filter");
      paramStringBuilder.append(" {\n");
      String str2;
      if (localzzfn.zzawe != null)
      {
        str2 = "UNKNOWN_MATCH_TYPE";
        switch (localzzfn.zzawe.intValue())
        {
        default:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        }
      }
      while (true)
      {
        zza(paramStringBuilder, i, "match_type", str2);
        zza(paramStringBuilder, i, "expression", localzzfn.zzawf);
        zza(paramStringBuilder, i, "case_sensitive", localzzfn.zzawg);
        if (localzzfn.zzawh.length <= 0)
          break label306;
        zza(paramStringBuilder, i + 1);
        paramStringBuilder.append("expression_list {\n");
        for (String str1 : localzzfn.zzawh)
        {
          zza(paramStringBuilder, i + 2);
          paramStringBuilder.append(str1);
          paramStringBuilder.append("\n");
        }
        str2 = "REGEXP";
        continue;
        str2 = "BEGINS_WITH";
        continue;
        str2 = "ENDS_WITH";
        continue;
        str2 = "PARTIAL";
        continue;
        str2 = "EXACT";
        continue;
        str2 = "IN_LIST";
      }
      paramStringBuilder.append("}\n");
      label306: zza(paramStringBuilder, i);
      paramStringBuilder.append("}\n");
    }
    zza(paramStringBuilder, paramInt + 1, "number_filter", paramzzfk.zzavt);
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }

  private final void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, zzfl paramzzfl)
  {
    if (paramzzfl == null)
      return;
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    String str;
    if (paramzzfl.zzavw != null)
    {
      str = "UNKNOWN_COMPARISON_TYPE";
      switch (paramzzfl.zzavw.intValue())
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    while (true)
    {
      zza(paramStringBuilder, paramInt, "comparison_type", str);
      zza(paramStringBuilder, paramInt, "match_as_float", paramzzfl.zzavx);
      zza(paramStringBuilder, paramInt, "comparison_value", paramzzfl.zzavy);
      zza(paramStringBuilder, paramInt, "min_comparison_value", paramzzfl.zzavz);
      zza(paramStringBuilder, paramInt, "max_comparison_value", paramzzfl.zzawa);
      zza(paramStringBuilder, paramInt);
      paramStringBuilder.append("}\n");
      return;
      str = "LESS_THAN";
      continue;
      str = "GREATER_THAN";
      continue;
      str = "EQUAL";
      continue;
      str = "BETWEEN";
    }
  }

  private final void zza(StringBuilder paramStringBuilder, int paramInt, String paramString1, zzfx paramzzfx, String paramString2)
  {
    if (paramzzfx == null)
      return;
    zza(paramStringBuilder, 3);
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(" {\n");
    if (paramzzfx.zzayq != null)
    {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("results: ");
      int i12 = 0;
      long[] arrayOfLong3 = paramzzfx.zzayq;
      int i13 = arrayOfLong3.length;
      int i14 = 0;
      while (i14 < i13)
      {
        Long localLong2 = Long.valueOf(arrayOfLong3[i14]);
        int i15 = i12 + 1;
        if (i12 != 0)
          paramStringBuilder.append(", ");
        paramStringBuilder.append(localLong2);
        i14++;
        i12 = i15;
      }
      paramStringBuilder.append('\n');
    }
    if (paramzzfx.zzayp != null)
    {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("status: ");
      int i8 = 0;
      long[] arrayOfLong2 = paramzzfx.zzayp;
      int i9 = arrayOfLong2.length;
      int i10 = 0;
      while (i10 < i9)
      {
        Long localLong1 = Long.valueOf(arrayOfLong2[i10]);
        int i11 = i8 + 1;
        if (i8 != 0)
          paramStringBuilder.append(", ");
        paramStringBuilder.append(localLong1);
        i10++;
        i8 = i11;
      }
      paramStringBuilder.append('\n');
    }
    if (zzgv().zzbb(paramString2))
    {
      if (paramzzfx.zzayr != null)
      {
        zza(paramStringBuilder, 4);
        paramStringBuilder.append("dynamic_filter_timestamps: {");
        int i4 = 0;
        zzfs[] arrayOfzzfs = paramzzfx.zzayr;
        int i5 = arrayOfzzfs.length;
        int i6 = 0;
        while (i6 < i5)
        {
          zzfs localzzfs = arrayOfzzfs[i6];
          int i7 = i4 + 1;
          if (i4 != 0)
            paramStringBuilder.append(", ");
          paramStringBuilder.append(localzzfs.zzawz).append(":").append(localzzfs.zzaxa);
          i6++;
          i4 = i7;
        }
        paramStringBuilder.append("}\n");
      }
      if (paramzzfx.zzays != null)
      {
        zza(paramStringBuilder, 4);
        paramStringBuilder.append("sequence_filter_timestamps: {");
        zzfy[] arrayOfzzfy = paramzzfx.zzays;
        int i = arrayOfzzfy.length;
        int j = 0;
        int m;
        for (int k = 0; j < i; k = m)
        {
          zzfy localzzfy = arrayOfzzfy[j];
          m = k + 1;
          if (k != 0)
            paramStringBuilder.append(", ");
          paramStringBuilder.append(localzzfy.zzawz).append(": [");
          int n = 0;
          long[] arrayOfLong1 = localzzfy.zzayu;
          int i1 = arrayOfLong1.length;
          int i2 = 0;
          while (i2 < i1)
          {
            long l = arrayOfLong1[i2];
            int i3 = n + 1;
            if (n != 0)
              paramStringBuilder.append(", ");
            paramStringBuilder.append(l);
            i2++;
            n = i3;
          }
          paramStringBuilder.append("]");
          j++;
        }
        paramStringBuilder.append("}\n");
      }
    }
    zza(paramStringBuilder, 3);
    paramStringBuilder.append("}\n");
  }

  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if (paramObject == null)
      return;
    zza(paramStringBuilder, paramInt + 1);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append('\n');
  }

  static boolean zza(long[] paramArrayOfLong, int paramInt)
  {
    if (paramInt >= paramArrayOfLong.length << 6);
    while ((paramArrayOfLong[(paramInt / 64)] & 1L << paramInt % 64) == 0L)
      return false;
    return true;
  }

  static long[] zza(BitSet paramBitSet)
  {
    int i = (63 + paramBitSet.length()) / 64;
    long[] arrayOfLong = new long[i];
    for (int j = 0; j < i; j++)
    {
      arrayOfLong[j] = 0L;
      for (int k = 0; (k < 64) && (k + (j << 6) < paramBitSet.length()); k++)
        if (paramBitSet.get(k + (j << 6)))
          arrayOfLong[j] |= 1L << k;
    }
    return arrayOfLong;
  }

  static zzfu[] zza(zzfu[] paramArrayOfzzfu, String paramString, Object paramObject)
  {
    int i = paramArrayOfzzfu.length;
    for (int j = 0; j < i; j++)
    {
      zzfu localzzfu2 = paramArrayOfzzfu[j];
      if (paramString.equals(localzzfu2.name))
      {
        localzzfu2.zzaxg = null;
        localzzfu2.zzamn = null;
        localzzfu2.zzaup = null;
        if ((paramObject instanceof Long))
          localzzfu2.zzaxg = ((Long)paramObject);
        do
        {
          return paramArrayOfzzfu;
          if ((paramObject instanceof String))
          {
            localzzfu2.zzamn = ((String)paramObject);
            return paramArrayOfzzfu;
          }
        }
        while (!(paramObject instanceof Double));
        localzzfu2.zzaup = ((Double)paramObject);
        return paramArrayOfzzfu;
      }
    }
    zzfu[] arrayOfzzfu = new zzfu[1 + paramArrayOfzzfu.length];
    System.arraycopy(paramArrayOfzzfu, 0, arrayOfzzfu, 0, paramArrayOfzzfu.length);
    zzfu localzzfu1 = new zzfu();
    localzzfu1.name = paramString;
    if ((paramObject instanceof Long))
      localzzfu1.zzaxg = ((Long)paramObject);
    while (true)
    {
      arrayOfzzfu[paramArrayOfzzfu.length] = localzzfu1;
      return arrayOfzzfu;
      if ((paramObject instanceof String))
        localzzfu1.zzamn = ((String)paramObject);
      else if ((paramObject instanceof Double))
        localzzfu1.zzaup = ((Double)paramObject);
    }
  }

  static Object zzb(com.google.android.gms.internal.measurement.zzft paramzzft, String paramString)
  {
    zzfu localzzfu = zza(paramzzft, paramString);
    if (localzzfu != null)
    {
      if (localzzfu.zzamn != null)
        return localzzfu.zzamn;
      if (localzzfu.zzaxg != null)
        return localzzfu.zzaxg;
      if (localzzfu.zzaup != null)
        return localzzfu.zzaup;
    }
    return null;
  }

  static boolean zzcs(String paramString)
  {
    return (paramString != null) && (paramString.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)")) && (paramString.length() <= 310);
  }

  final <T extends Parcelable> T zza(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    if (paramArrayOfByte == null)
      return null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      Parcelable localParcelable = (Parcelable)paramCreator.createFromParcel(localParcel);
      return localParcelable;
    }
    catch (SafeParcelReader.ParseException localParseException)
    {
      zzgt().zzjg().zzby("Failed to load parcelable from buffer");
      return null;
    }
    finally
    {
      localParcel.recycle();
    }
  }

  final String zza(zzfj paramzzfj)
  {
    int i = 0;
    if (paramzzfj == null)
      return "null";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nevent_filter {\n");
    zza(localStringBuilder, 0, "filter_id", paramzzfj.zzavm);
    zza(localStringBuilder, 0, "event_name", zzgq().zzbt(paramzzfj.zzavn));
    zza(localStringBuilder, 1, "event_count_filter", paramzzfj.zzavq);
    localStringBuilder.append("  filters {\n");
    zzfk[] arrayOfzzfk = paramzzfj.zzavo;
    int j = arrayOfzzfk.length;
    while (i < j)
    {
      zza(localStringBuilder, 2, arrayOfzzfk[i]);
      i++;
    }
    zza(localStringBuilder, 1);
    localStringBuilder.append("}\n}\n");
    return localStringBuilder.toString();
  }

  final String zza(com.google.android.gms.internal.measurement.zzfm paramzzfm)
  {
    if (paramzzfm == null)
      return "null";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nproperty_filter {\n");
    zza(localStringBuilder, 0, "filter_id", paramzzfm.zzavm);
    zza(localStringBuilder, 0, "property_name", zzgq().zzbv(paramzzfm.zzawc));
    zza(localStringBuilder, 1, paramzzfm.zzawd);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }

  final void zza(zzfu paramzzfu, Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    paramzzfu.zzamn = null;
    paramzzfu.zzaxg = null;
    paramzzfu.zzaup = null;
    if ((paramObject instanceof String))
    {
      paramzzfu.zzamn = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramzzfu.zzaxg = ((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramzzfu.zzaup = ((Double)paramObject);
      return;
    }
    zzgt().zzjg().zzg("Ignoring invalid (type) event param value", paramObject);
  }

  final void zza(zzfz paramzzfz, Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    paramzzfz.zzamn = null;
    paramzzfz.zzaxg = null;
    paramzzfz.zzaup = null;
    if ((paramObject instanceof String))
    {
      paramzzfz.zzamn = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramzzfz.zzaxg = ((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramzzfz.zzaup = ((Double)paramObject);
      return;
    }
    zzgt().zzjg().zzg("Ignoring invalid (type) user attribute value", paramObject);
  }

  final byte[] zza(zzfv paramzzfv)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramzzfv.zzvx()];
      zzya localzzya = zzya.zzk(arrayOfByte, 0, arrayOfByte.length);
      paramzzfv.zza(localzzya);
      localzzya.zzza();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      zzgt().zzjg().zzg("Data loss. Failed to serialize batch", localIOException);
    }
    return null;
  }

  final byte[] zza(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteArrayInputStream localByteArrayInputStream;
    GZIPInputStream localGZIPInputStream;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte1 = new byte[1024];
      while (true)
      {
        int i = localGZIPInputStream.read(arrayOfByte1);
        if (i <= 0)
          break;
        localByteArrayOutputStream.write(arrayOfByte1, 0, i);
      }
    }
    catch (IOException localIOException)
    {
      zzgt().zzjg().zzg("Failed to ungzip content", localIOException);
      throw localIOException;
    }
    localGZIPInputStream.close();
    localByteArrayInputStream.close();
    byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    return arrayOfByte2;
  }

  final String zzb(zzfv paramzzfv)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nbatch {\n");
    if (paramzzfv.zzaxh != null)
      for (zzfw localzzfw : paramzzfv.zzaxh)
        if ((localzzfw != null) && (localzzfw != null))
        {
          zza(localStringBuilder, 1);
          localStringBuilder.append("bundle {\n");
          zza(localStringBuilder, 1, "protocol_version", localzzfw.zzaxj);
          zza(localStringBuilder, 1, "platform", localzzfw.zzaxr);
          zza(localStringBuilder, 1, "gmp_version", localzzfw.zzaxv);
          zza(localStringBuilder, 1, "uploading_gmp_version", localzzfw.zzaxw);
          zza(localStringBuilder, 1, "config_version", localzzfw.zzayh);
          zza(localStringBuilder, 1, "gmp_app_id", localzzfw.zzafi);
          zza(localStringBuilder, 1, "admob_app_id", localzzfw.zzawr);
          zza(localStringBuilder, 1, "app_id", localzzfw.zztt);
          zza(localStringBuilder, 1, "app_version", localzzfw.zzts);
          zza(localStringBuilder, 1, "app_version_major", localzzfw.zzayd);
          zza(localStringBuilder, 1, "firebase_instance_id", localzzfw.zzafk);
          zza(localStringBuilder, 1, "dev_cert_hash", localzzfw.zzaxz);
          zza(localStringBuilder, 1, "app_store", localzzfw.zzafp);
          zza(localStringBuilder, 1, "upload_timestamp_millis", localzzfw.zzaxm);
          zza(localStringBuilder, 1, "start_timestamp_millis", localzzfw.zzaxn);
          zza(localStringBuilder, 1, "end_timestamp_millis", localzzfw.zzaxo);
          zza(localStringBuilder, 1, "previous_bundle_start_timestamp_millis", localzzfw.zzaxp);
          zza(localStringBuilder, 1, "previous_bundle_end_timestamp_millis", localzzfw.zzaxq);
          zza(localStringBuilder, 1, "app_instance_id", localzzfw.zzafh);
          zza(localStringBuilder, 1, "resettable_device_id", localzzfw.zzaxx);
          zza(localStringBuilder, 1, "device_id", localzzfw.zzayg);
          zza(localStringBuilder, 1, "ds_id", localzzfw.zzayj);
          zza(localStringBuilder, 1, "limited_ad_tracking", localzzfw.zzaxy);
          zza(localStringBuilder, 1, "os_version", localzzfw.zzaxs);
          zza(localStringBuilder, 1, "device_model", localzzfw.zzaxt);
          zza(localStringBuilder, 1, "user_default_language", localzzfw.zzahr);
          zza(localStringBuilder, 1, "time_zone_offset_minutes", localzzfw.zzaxu);
          zza(localStringBuilder, 1, "bundle_sequential_index", localzzfw.zzaya);
          zza(localStringBuilder, 1, "service_upload", localzzfw.zzayb);
          zza(localStringBuilder, 1, "health_monitor", localzzfw.zzagm);
          if ((localzzfw.zzayi != null) && (localzzfw.zzayi.longValue() != 0L))
            zza(localStringBuilder, 1, "android_id", localzzfw.zzayi);
          if (localzzfw.zzayl != null)
            zza(localStringBuilder, 1, "retry_counter", localzzfw.zzayl);
          zzfz[] arrayOfzzfz = localzzfw.zzaxl;
          if (arrayOfzzfz != null)
          {
            int i4 = arrayOfzzfz.length;
            for (int i5 = 0; i5 < i4; i5++)
            {
              zzfz localzzfz = arrayOfzzfz[i5];
              if (localzzfz != null)
              {
                zza(localStringBuilder, 2);
                localStringBuilder.append("user_property {\n");
                zza(localStringBuilder, 2, "set_timestamp_millis", localzzfz.zzayw);
                zza(localStringBuilder, 2, "name", zzgq().zzbv(localzzfz.name));
                zza(localStringBuilder, 2, "string_value", localzzfz.zzamn);
                zza(localStringBuilder, 2, "int_value", localzzfz.zzaxg);
                zza(localStringBuilder, 2, "double_value", localzzfz.zzaup);
                zza(localStringBuilder, 2);
                localStringBuilder.append("}\n");
              }
            }
          }
          zzfr[] arrayOfzzfr = localzzfw.zzayc;
          String str = localzzfw.zztt;
          if (arrayOfzzfr != null)
          {
            int i2 = arrayOfzzfr.length;
            for (int i3 = 0; i3 < i2; i3++)
            {
              zzfr localzzfr = arrayOfzzfr[i3];
              if (localzzfr != null)
              {
                zza(localStringBuilder, 2);
                localStringBuilder.append("audience_membership {\n");
                zza(localStringBuilder, 2, "audience_id", localzzfr.zzavg);
                zza(localStringBuilder, 2, "new_audience", localzzfr.zzawx);
                zza(localStringBuilder, 2, "current_data", localzzfr.zzawv, str);
                zza(localStringBuilder, 2, "previous_data", localzzfr.zzaww, str);
                zza(localStringBuilder, 2);
                localStringBuilder.append("}\n");
              }
            }
          }
          com.google.android.gms.internal.measurement.zzft[] arrayOfzzft = localzzfw.zzaxk;
          if (arrayOfzzft != null)
          {
            int k = arrayOfzzft.length;
            for (int m = 0; m < k; m++)
            {
              com.google.android.gms.internal.measurement.zzft localzzft = arrayOfzzft[m];
              if (localzzft != null)
              {
                zza(localStringBuilder, 2);
                localStringBuilder.append("event {\n");
                zza(localStringBuilder, 2, "name", zzgq().zzbt(localzzft.name));
                zza(localStringBuilder, 2, "timestamp_millis", localzzft.zzaxd);
                zza(localStringBuilder, 2, "previous_timestamp_millis", localzzft.zzaxe);
                zza(localStringBuilder, 2, "count", localzzft.count);
                zzfu[] arrayOfzzfu = localzzft.zzaxc;
                if (arrayOfzzfu != null)
                {
                  int n = arrayOfzzfu.length;
                  for (int i1 = 0; i1 < n; i1++)
                  {
                    zzfu localzzfu = arrayOfzzfu[i1];
                    if (localzzfu != null)
                    {
                      zza(localStringBuilder, 3);
                      localStringBuilder.append("param {\n");
                      zza(localStringBuilder, 3, "name", zzgq().zzbu(localzzfu.name));
                      zza(localStringBuilder, 3, "string_value", localzzfu.zzamn);
                      zza(localStringBuilder, 3, "int_value", localzzfu.zzaxg);
                      zza(localStringBuilder, 3, "double_value", localzzfu.zzaup);
                      zza(localStringBuilder, 3);
                      localStringBuilder.append("}\n");
                    }
                  }
                }
                zza(localStringBuilder, 2);
                localStringBuilder.append("}\n");
              }
            }
          }
          zza(localStringBuilder, 1);
          localStringBuilder.append("}\n");
        }
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }

  final boolean zzb(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 <= 0L));
    while (Math.abs(zzbx().currentTimeMillis() - paramLong1) > paramLong2)
      return true;
    return false;
  }

  final byte[] zzb(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      zzgt().zzjg().zzg("Failed to gzip content", localIOException);
      throw localIOException;
    }
  }

  final boolean zze(zzag paramzzag, zzk paramzzk)
  {
    Preconditions.checkNotNull(paramzzag);
    Preconditions.checkNotNull(paramzzk);
    if ((TextUtils.isEmpty(paramzzk.zzafi)) && (TextUtils.isEmpty(paramzzk.zzafv)))
    {
      zzgw();
      return false;
    }
    return true;
  }

  protected final boolean zzgy()
  {
    return false;
  }

  final int[] zzmi()
  {
    int i = 0;
    Map localMap = zzai.zzm(this.zzamx.getContext());
    if ((localMap == null) || (localMap.size() == 0))
      return null;
    ArrayList localArrayList1 = new ArrayList();
    int j = ((Integer)zzai.zzakg.get()).intValue();
    Iterator localIterator = localMap.entrySet().iterator();
    while (true)
    {
      Map.Entry localEntry;
      if (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        if (!((String)localEntry.getKey()).startsWith("measurement.id."));
      }
      else
      {
        try
        {
          int i1 = Integer.parseInt((String)localEntry.getValue());
          if (i1 != 0)
          {
            localArrayList1.add(Integer.valueOf(i1));
            if (localArrayList1.size() >= j)
            {
              zzgt().zzjj().zzg("Too many experiment IDs. Number of IDs", Integer.valueOf(localArrayList1.size()));
              if (localArrayList1.size() != 0)
                break;
              return null;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          zzgt().zzjj().zzg("Experiment ID NumberFormatException", localNumberFormatException);
        }
      }
    }
    int[] arrayOfInt = new int[localArrayList1.size()];
    ArrayList localArrayList2 = (ArrayList)localArrayList1;
    int k = localArrayList2.size();
    int m = 0;
    while (m < k)
    {
      Object localObject = localArrayList2.get(m);
      m++;
      Integer localInteger = (Integer)localObject;
      int n = i + 1;
      arrayOfInt[i] = localInteger.intValue();
      i = n;
    }
    return arrayOfInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzft
 * JD-Core Version:    0.6.2
 */