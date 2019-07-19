package com.google.android.exoplayer2.trackselection;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector extends d
{
  private static final int[] a = new int[0];
  private final e.a b;
  private final AtomicReference<Parameters> c;

  public DefaultTrackSelector()
  {
    this(new a.a());
  }

  public DefaultTrackSelector(e.a parama)
  {
    this.b = parama;
    this.c = new AtomicReference(Parameters.DEFAULT);
  }

  private static int a(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<Integer> paramList)
  {
    int i = 0;
    int j = 0;
    if (i < paramList.size())
    {
      int k = ((Integer)paramList.get(i)).intValue();
      if (!a(paramTrackGroup.getFormat(k), paramString, paramArrayOfInt[k], paramInt1, paramInt2, paramInt3, paramInt4, paramInt5))
        break label80;
    }
    label80: for (int m = j + 1; ; m = j)
    {
      i++;
      j = m;
      break;
      return j;
    }
  }

  private static int a(TrackGroup paramTrackGroup, int[] paramArrayOfInt, a parama)
  {
    int i = 0;
    int j = 0;
    while (i < paramTrackGroup.length)
    {
      if (a(paramTrackGroup.getFormat(i), paramArrayOfInt[i], parama))
        j++;
      i++;
    }
    return j;
  }

  private static Point a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    int j;
    if (paramBoolean)
    {
      if (paramInt3 <= paramInt4)
        break label64;
      j = i;
      if (paramInt1 <= paramInt2)
        break label70;
    }
    while (true)
    {
      if (j != i)
      {
        int k = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = k;
      }
      if (paramInt3 * paramInt2 < paramInt4 * paramInt1)
        break label76;
      return new Point(paramInt1, com.google.android.exoplayer2.g.ag.a(paramInt1 * paramInt4, paramInt3));
      label64: j = 0;
      break;
      label70: i = 0;
    }
    label76: return new Point(com.google.android.exoplayer2.g.ag.a(paramInt2 * paramInt3, paramInt4), paramInt2);
  }

  private static e a(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, int paramInt, Parameters paramParameters, e.a parama, com.google.android.exoplayer2.f.d paramd)
    throws i
  {
    int i;
    boolean bool;
    if (paramParameters.allowNonSeamlessAdaptiveness)
    {
      i = 24;
      if ((!paramParameters.allowMixedMimeAdaptiveness) || ((paramInt & i) == 0))
        break label124;
      bool = true;
    }
    label28: for (int j = 0; ; j++)
    {
      if (j >= paramTrackGroupArray.length)
        break label136;
      TrackGroup localTrackGroup = paramTrackGroupArray.get(j);
      int[] arrayOfInt = a(localTrackGroup, paramArrayOfInt[j], bool, i, paramParameters.maxVideoWidth, paramParameters.maxVideoHeight, paramParameters.maxVideoFrameRate, paramParameters.maxVideoBitrate, paramParameters.viewportWidth, paramParameters.viewportHeight, paramParameters.viewportOrientationMayChange);
      if (arrayOfInt.length > 0)
      {
        return ((e.a)a.a(parama)).b(localTrackGroup, paramd, arrayOfInt);
        i = 16;
        break;
        label124: bool = false;
        break label28;
      }
    }
    label136: return null;
  }

  private static List<Integer> a(TrackGroup paramTrackGroup, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList(paramTrackGroup.length);
    for (int j = 0; j < paramTrackGroup.length; j++)
      localArrayList.add(Integer.valueOf(j));
    if ((paramInt1 == 2147483647) || (paramInt2 == 2147483647))
      return localArrayList;
    int k = 2147483647;
    int i1;
    if (i < paramTrackGroup.length)
    {
      Format localFormat = paramTrackGroup.getFormat(i);
      if ((localFormat.width <= 0) || (localFormat.height <= 0))
        break label254;
      Point localPoint = a(paramBoolean, paramInt1, paramInt2, localFormat.width, localFormat.height);
      i1 = localFormat.width * localFormat.height;
      if ((localFormat.width < (int)(0.98F * localPoint.x)) || (localFormat.height < (int)(0.98F * localPoint.y)) || (i1 >= k))
        break label254;
    }
    while (true)
    {
      i++;
      k = i1;
      break;
      if (k != 2147483647)
        for (int m = -1 + localArrayList.size(); m >= 0; m--)
        {
          int n = paramTrackGroup.getFormat(((Integer)localArrayList.get(m)).intValue()).getPixelCount();
          if ((n == -1) || (n > k))
            localArrayList.remove(m);
        }
      return localArrayList;
      label254: i1 = k;
    }
  }

  private static void a(d.a parama, int[][][] paramArrayOfInt, com.google.android.exoplayer2.ag[] paramArrayOfag, e[] paramArrayOfe, int paramInt)
  {
    if (paramInt == 0)
      return;
    int i = 0;
    int j = -1;
    int k = -1;
    int m;
    if (i < parama.a())
    {
      int i1 = parama.a(i);
      e locale = paramArrayOfe[i];
      if (((i1 == 1) || (i1 == 2)) && (locale != null) && (a(paramArrayOfInt[i], parama.b(i), locale)))
      {
        if (i1 != 1)
          break label151;
        if (k != -1)
          m = 0;
      }
    }
    while (true)
    {
      label88: int n = 0;
      if (k != -1)
      {
        n = 0;
        if (j != -1)
          n = 1;
      }
      if ((m & n) == 0)
        break;
      com.google.android.exoplayer2.ag localag = new com.google.android.exoplayer2.ag(paramInt);
      paramArrayOfag[k] = localag;
      paramArrayOfag[j] = localag;
      return;
      k = i;
      while (true)
      {
        i++;
        break;
        label151: if (j != -1)
        {
          m = 0;
          break label88;
        }
        j = i;
      }
      m = 1;
    }
  }

  protected static boolean a(int paramInt, boolean paramBoolean)
  {
    int i = paramInt & 0x7;
    return (i == 4) || ((paramBoolean) && (i == 3));
  }

  protected static boolean a(Format paramFormat)
  {
    return (TextUtils.isEmpty(paramFormat.language)) || (a(paramFormat, "und"));
  }

  private static boolean a(Format paramFormat, int paramInt, a parama)
  {
    boolean bool1 = a(paramInt, false);
    boolean bool2 = false;
    if (bool1)
    {
      int i = paramFormat.channelCount;
      int j = parama.a;
      bool2 = false;
      if (i == j)
      {
        int k = paramFormat.sampleRate;
        int m = parama.b;
        bool2 = false;
        if (k == m)
          if (parama.c != null)
          {
            boolean bool3 = TextUtils.equals(parama.c, paramFormat.sampleMimeType);
            bool2 = false;
            if (!bool3);
          }
          else
          {
            bool2 = true;
          }
      }
    }
    return bool2;
  }

  protected static boolean a(Format paramFormat, String paramString)
  {
    return (paramString != null) && (TextUtils.equals(paramString, com.google.android.exoplayer2.g.ag.b(paramFormat.language)));
  }

  private static boolean a(Format paramFormat, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    boolean bool1 = a(paramInt1, false);
    boolean bool2 = false;
    if (bool1)
    {
      int i = paramInt1 & paramInt2;
      bool2 = false;
      if (i != 0)
        if (paramString != null)
        {
          boolean bool4 = com.google.android.exoplayer2.g.ag.a(paramFormat.sampleMimeType, paramString);
          bool2 = false;
          if (!bool4);
        }
        else if (paramFormat.width != -1)
        {
          int m = paramFormat.width;
          bool2 = false;
          if (m > paramInt3);
        }
        else if (paramFormat.height != -1)
        {
          int k = paramFormat.height;
          bool2 = false;
          if (k > paramInt4);
        }
        else if (paramFormat.frameRate != -1.0F)
        {
          boolean bool3 = paramFormat.frameRate < paramInt5;
          bool2 = false;
          if (bool3);
        }
        else if (paramFormat.bitrate != -1)
        {
          int j = paramFormat.bitrate;
          bool2 = false;
          if (j > paramInt6);
        }
        else
        {
          bool2 = true;
        }
    }
    return bool2;
  }

  private static boolean a(int[][] paramArrayOfInt, TrackGroupArray paramTrackGroupArray, e parame)
  {
    if (parame == null)
      return false;
    int i = paramTrackGroupArray.indexOf(parame.f());
    for (int j = 0; ; j++)
    {
      if (j >= parame.g())
        break label57;
      if ((0x20 & paramArrayOfInt[i][parame.b(j)]) != 32)
        break;
    }
    label57: return true;
  }

  private static int[] a(TrackGroup paramTrackGroup, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = 0;
    HashSet localHashSet = new HashSet();
    int j = 0;
    Object localObject1 = null;
    int k = 0;
    Format localFormat;
    String str;
    label58: Object localObject2;
    int i4;
    if (j < paramTrackGroup.length)
    {
      localFormat = paramTrackGroup.getFormat(j);
      int i1 = localFormat.channelCount;
      int i2 = localFormat.sampleRate;
      if (paramBoolean)
      {
        str = null;
        localObject2 = new a(i1, i2, str);
        if (!localHashSet.add(localObject2))
          break label208;
        i4 = a(paramTrackGroup, paramArrayOfInt, (a)localObject2);
        if (i4 <= k)
          break label208;
      }
    }
    for (int i3 = i4; ; i3 = k)
    {
      j++;
      k = i3;
      localObject1 = localObject2;
      break;
      str = localFormat.sampleMimeType;
      break label58;
      int[] arrayOfInt;
      int m;
      int n;
      if (k > 1)
      {
        arrayOfInt = new int[k];
        m = 0;
        if (i < paramTrackGroup.length)
        {
          if (!a(paramTrackGroup.getFormat(i), paramArrayOfInt[i], (a)a.a(localObject1)))
            break label201;
          n = m + 1;
          arrayOfInt[m] = i;
        }
      }
      while (true)
      {
        i++;
        m = n;
        break;
        return arrayOfInt;
        return a;
        label201: n = m;
      }
      label208: localObject2 = localObject1;
    }
  }

  private static int[] a(TrackGroup paramTrackGroup, int[] paramArrayOfInt, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean2)
  {
    if (paramTrackGroup.length < 2)
      return a;
    List localList = a(paramTrackGroup, paramInt6, paramInt7, paramBoolean2);
    if (localList.size() < 2)
      return a;
    Object localObject1 = null;
    int i;
    Object localObject3;
    int k;
    if (!paramBoolean1)
    {
      HashSet localHashSet = new HashSet();
      i = 0;
      int j = 0;
      while (j < localList.size())
      {
        localObject3 = paramTrackGroup.getFormat(((Integer)localList.get(j)).intValue()).sampleMimeType;
        if (!localHashSet.add(localObject3))
          break label191;
        k = a(paramTrackGroup, paramArrayOfInt, paramInt1, (String)localObject3, paramInt2, paramInt3, paramInt4, paramInt5, localList);
        if (k <= i)
          break label191;
        j++;
        i = k;
        localObject1 = localObject3;
      }
    }
    for (Object localObject2 = localObject1; ; localObject2 = null)
    {
      b(paramTrackGroup, paramArrayOfInt, paramInt1, localObject2, paramInt2, paramInt3, paramInt4, paramInt5, localList);
      if (localList.size() < 2)
        return a;
      return com.google.android.exoplayer2.g.ag.a(localList);
      label191: k = i;
      localObject3 = localObject1;
      break;
    }
  }

  private static int b(int paramInt1, int paramInt2)
  {
    int i = -1;
    if (paramInt1 == i)
    {
      if (paramInt2 == i)
        i = 0;
      return i;
    }
    if (paramInt2 == i)
      return 1;
    return paramInt1 - paramInt2;
  }

  private static e b(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, Parameters paramParameters)
  {
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    int k = -1;
    int m = -1;
    int n = 0;
    TrackGroup localTrackGroup;
    int[] arrayOfInt;
    int i1;
    label62: Format localFormat;
    int i3;
    label202: int i2;
    Object localObject2;
    if (j < paramTrackGroupArray.length)
    {
      localTrackGroup = paramTrackGroupArray.get(j);
      List localList = a(localTrackGroup, paramParameters.viewportWidth, paramParameters.viewportHeight, paramParameters.viewportOrientationMayChange);
      arrayOfInt = paramArrayOfInt[j];
      i1 = 0;
      if (i1 < localTrackGroup.length)
      {
        if (!a(arrayOfInt[i1], paramParameters.exceedRendererCapabilitiesIfNecessary))
          break label467;
        localFormat = localTrackGroup.getFormat(i1);
        if ((localList.contains(Integer.valueOf(i1))) && ((localFormat.width == -1) || (localFormat.width <= paramParameters.maxVideoWidth)) && ((localFormat.height == -1) || (localFormat.height <= paramParameters.maxVideoHeight)) && ((localFormat.frameRate == -1.0F) || (localFormat.frameRate <= paramParameters.maxVideoFrameRate)) && ((localFormat.bitrate == -1) || (localFormat.bitrate <= paramParameters.maxVideoBitrate)))
        {
          i3 = 1;
          if ((i3 != 0) || (paramParameters.exceedVideoConstraintsIfNecessary))
            break label240;
          i2 = i;
          localObject2 = localObject1;
        }
      }
    }
    while (true)
    {
      label221: i1++;
      localObject1 = localObject2;
      i = i2;
      break label62;
      i3 = 0;
      break label202;
      label240: int i4;
      label248: boolean bool;
      int i5;
      if (i3 != 0)
      {
        i4 = 2;
        bool = a(arrayOfInt[i1], false);
        if (bool)
          i4 += 1000;
        if (i4 <= n)
          break label350;
        i5 = 1;
        label280: if (i4 == n)
        {
          if (!paramParameters.forceLowestBitrate)
            break label362;
          if (b(localFormat.bitrate, m) >= 0)
            break label356;
          i5 = 1;
        }
      }
      while (true)
        if (i5 != 0)
        {
          m = localFormat.bitrate;
          k = localFormat.getPixelCount();
          n = i4;
          localObject2 = localTrackGroup;
          i2 = i1;
          break label221;
          i4 = 1;
          break label248;
          label350: i5 = 0;
          break label280;
          label356: i5 = 0;
          continue;
          label362: int i6 = localFormat.getPixelCount();
          int i7;
          if (i6 != k)
            i7 = b(i6, k);
          while (true)
            if ((bool) && (i3 != 0))
            {
              if (i7 > 0)
              {
                i5 = 1;
                break;
                i7 = b(localFormat.bitrate, m);
                continue;
              }
              i5 = 0;
              break;
            }
          if (i7 < 0)
          {
            i5 = 1;
          }
          else
          {
            i5 = 0;
            continue;
            j++;
            break;
            if (localObject1 == null)
              return null;
            return new c(localObject1, i);
          }
        }
      label467: i2 = i;
      localObject2 = localObject1;
    }
  }

  private static void b(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<Integer> paramList)
  {
    for (int i = -1 + paramList.size(); i >= 0; i--)
    {
      int j = ((Integer)paramList.get(i)).intValue();
      if (!a(paramTrackGroup.getFormat(j), paramString, paramArrayOfInt[j], paramInt1, paramInt2, paramInt3, paramInt4, paramInt5))
        paramList.remove(i);
    }
  }

  private static int c(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      return 1;
    if (paramInt2 > paramInt1)
      return -1;
    return 0;
  }

  protected Pair<e, Integer> a(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, Parameters paramParameters)
    throws i
  {
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    int k = 0;
    int m;
    label38: Format localFormat;
    int i2;
    label96: int i3;
    label106: int i4;
    label146: int i5;
    label154: int i6;
    label161: Object localObject2;
    int n;
    if (j < paramTrackGroupArray.length)
    {
      TrackGroup localTrackGroup = paramTrackGroupArray.get(j);
      int[] arrayOfInt = paramArrayOfInt[j];
      m = 0;
      if (m < localTrackGroup.length)
      {
        if (!a(arrayOfInt[m], paramParameters.exceedRendererCapabilitiesIfNecessary))
          break label321;
        localFormat = localTrackGroup.getFormat(m);
        int i1 = localFormat.selectionFlags & (0xFFFFFFFF ^ paramParameters.disabledTextTrackSelectionFlags);
        if ((i1 & 0x1) != 0)
        {
          i2 = 1;
          if ((i1 & 0x2) == 0)
            break label218;
          i3 = 1;
          boolean bool = a(localFormat, paramParameters.preferredTextLanguage);
          if ((!bool) && ((!paramParameters.selectUndeterminedTextLanguage) || (!a(localFormat))))
            break label248;
          if (i2 == 0)
            break label224;
          i4 = 8;
          if (!bool)
            break label242;
          i5 = 1;
          i6 = i5 + i4;
          if (a(arrayOfInt[m], false))
            i6 += 1000;
          if (i6 <= k)
            break label321;
          k = i6;
          localObject2 = localTrackGroup;
          n = m;
        }
      }
    }
    while (true)
    {
      m++;
      localObject1 = localObject2;
      i = n;
      break label38;
      i2 = 0;
      break label96;
      label218: i3 = 0;
      break label106;
      label224: if (i3 == 0)
      {
        i4 = 6;
        break label146;
      }
      i4 = 4;
      break label146;
      label242: i5 = 0;
      break label154;
      label248: if (i2 != 0)
      {
        i6 = 3;
        break label161;
      }
      if (i3 != 0)
      {
        if (a(localFormat, paramParameters.preferredAudioLanguage))
        {
          i6 = 2;
          break label161;
        }
        i6 = 1;
        break label161;
        j++;
        break;
        if (localObject1 == null)
          return null;
        return Pair.create(new c(localObject1, i), Integer.valueOf(k));
      }
      label321: n = i;
      localObject2 = localObject1;
    }
  }

  protected final Pair<com.google.android.exoplayer2.ag[], e[]> a(d.a parama, int[][][] paramArrayOfInt, int[] paramArrayOfInt1)
    throws i
  {
    Parameters localParameters = (Parameters)this.c.get();
    int i = parama.a();
    e[] arrayOfe = a(parama, paramArrayOfInt, paramArrayOfInt1, localParameters);
    int j = 0;
    if (j < i)
    {
      if (localParameters.getRendererDisabled(j))
        arrayOfe[j] = null;
      while (true)
      {
        j++;
        break;
        TrackGroupArray localTrackGroupArray = parama.b(j);
        if (localParameters.hasSelectionOverride(j, localTrackGroupArray))
        {
          SelectionOverride localSelectionOverride = localParameters.getSelectionOverride(j, localTrackGroupArray);
          if (localSelectionOverride == null)
            arrayOfe[j] = null;
          else if (localSelectionOverride.length == 1)
            arrayOfe[j] = new c(localTrackGroupArray.get(localSelectionOverride.groupIndex), localSelectionOverride.tracks[0]);
          else
            arrayOfe[j] = ((e.a)a.a(this.b)).b(localTrackGroupArray.get(localSelectionOverride.groupIndex), c(), localSelectionOverride.tracks);
        }
      }
    }
    com.google.android.exoplayer2.ag[] arrayOfag = new com.google.android.exoplayer2.ag[i];
    int k = 0;
    if (k < i)
    {
      int m;
      if ((!localParameters.getRendererDisabled(k)) && ((parama.a(k) == 6) || (arrayOfe[k] != null)))
      {
        m = 1;
        label238: if (m == 0)
          break label267;
      }
      label267: for (com.google.android.exoplayer2.ag localag = com.google.android.exoplayer2.ag.a; ; localag = null)
      {
        arrayOfag[k] = localag;
        k++;
        break;
        m = 0;
        break label238;
      }
    }
    a(parama, paramArrayOfInt, arrayOfag, arrayOfe, localParameters.tunnelingAudioSessionId);
    return Pair.create(arrayOfag, arrayOfe);
  }

  public Parameters a()
  {
    return (Parameters)this.c.get();
  }

  protected e a(int paramInt, TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, Parameters paramParameters)
    throws i
  {
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    int k = 0;
    TrackGroup localTrackGroup;
    int m;
    label38: int i2;
    label82: int n;
    label90: int i1;
    if (k < paramTrackGroupArray.length)
    {
      localTrackGroup = paramTrackGroupArray.get(k);
      int[] arrayOfInt = paramArrayOfInt[k];
      m = 0;
      if (m < localTrackGroup.length)
      {
        if (!a(arrayOfInt[m], paramParameters.exceedRendererCapabilitiesIfNecessary))
          break label178;
        if ((0x1 & localTrackGroup.getFormat(m).selectionFlags) != 0)
        {
          i2 = 1;
          if (i2 == 0)
            break label147;
          n = 2;
          if (a(arrayOfInt[m], false))
            n += 1000;
          if (n <= j)
            break label178;
          i1 = m;
        }
      }
    }
    for (Object localObject2 = localTrackGroup; ; localObject2 = localObject1)
    {
      m++;
      localObject1 = localObject2;
      i = i1;
      j = n;
      break label38;
      i2 = 0;
      break label82;
      label147: n = 1;
      break label90;
      k++;
      break;
      if (localObject1 == null)
        return null;
      return new c(localObject1, i);
      label178: n = j;
      i1 = i;
    }
  }

  protected e a(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, int paramInt, Parameters paramParameters, e.a parama)
    throws i
  {
    boolean bool1 = paramParameters.forceHighestSupportedBitrate;
    e locale = null;
    if (!bool1)
    {
      boolean bool2 = paramParameters.forceLowestBitrate;
      locale = null;
      if (!bool2)
      {
        locale = null;
        if (parama != null)
          locale = a(paramTrackGroupArray, paramArrayOfInt, paramInt, paramParameters, parama, c());
      }
    }
    if (locale == null)
      locale = b(paramTrackGroupArray, paramArrayOfInt, paramParameters);
    return locale;
  }

  protected e[] a(d.a parama, int[][][] paramArrayOfInt, int[] paramArrayOfInt1, Parameters paramParameters)
    throws i
  {
    int i = parama.a();
    e[] arrayOfe = new e[i];
    int j = 0;
    int k = 0;
    int m = 0;
    label84: int i10;
    if (k < i)
    {
      if (2 != parama.a(k))
        break label496;
      if (m == 0)
      {
        arrayOfe[k] = a(parama.b(k), paramArrayOfInt[k], paramArrayOfInt1[k], paramParameters, this.b);
        if (arrayOfe[k] != null)
          m = 1;
      }
      else
      {
        if (parama.b(k).length <= 0)
          break label122;
        i10 = 1;
      }
    }
    label99: label227: label496: for (int i9 = i10 | j; ; i9 = j)
    {
      k++;
      j = i9;
      break;
      m = 0;
      break label84;
      label122: i10 = 0;
      break label99;
      Object localObject1 = null;
      int n = -1;
      int i1 = -2147483648;
      int i2 = -1;
      int i3 = 0;
      if (i3 < i)
      {
        int i4 = parama.a(i3);
        int i7;
        int i5;
        int i6;
        Object localObject2;
        switch (i4)
        {
        default:
          arrayOfe[i3] = a(i4, parama.b(i3), paramArrayOfInt[i3], paramParameters);
          i7 = i2;
          i5 = i1;
          i6 = n;
          localObject2 = localObject1;
        case 2:
        case 1:
        case 3:
        }
        while (true)
        {
          i3++;
          i2 = i7;
          i1 = i5;
          n = i6;
          localObject1 = localObject2;
          break;
          i7 = i2;
          i5 = i1;
          i6 = n;
          localObject2 = localObject1;
          continue;
          TrackGroupArray localTrackGroupArray = parama.b(i3);
          int[][] arrayOfInt = paramArrayOfInt[i3];
          int i8 = paramArrayOfInt1[i3];
          if (j != 0);
          for (e.a locala = null; ; locala = this.b)
          {
            Pair localPair2 = b(localTrackGroupArray, arrayOfInt, i8, paramParameters, locala);
            if ((localPair2 == null) || ((localObject1 != null) && (((b)localPair2.second).a(localObject1) <= 0)))
              break;
            if (n != -1)
              arrayOfe[n] = null;
            arrayOfe[i3] = ((e)localPair2.first);
            b localb = (b)localPair2.second;
            i5 = i1;
            i6 = i3;
            localObject2 = localb;
            i7 = i2;
            break label227;
          }
          Pair localPair1 = a(parama.b(i3), paramArrayOfInt[i3], paramParameters);
          if ((localPair1 == null) || (((Integer)localPair1.second).intValue() <= i1))
            break label211;
          if (i2 != -1)
            arrayOfe[i2] = null;
          arrayOfe[i3] = ((e)localPair1.first);
          i5 = ((Integer)localPair1.second).intValue();
          i6 = n;
          localObject2 = localObject1;
          i7 = i3;
        }
      }
      return arrayOfe;
    }
  }

  protected Pair<e, b> b(TrackGroupArray paramTrackGroupArray, int[][] paramArrayOfInt, int paramInt, Parameters paramParameters, e.a parama)
    throws i
  {
    int i = -1;
    int j = -1;
    Object localObject1 = null;
    int k = 0;
    int n;
    label38: int i1;
    int i2;
    if (k < paramTrackGroupArray.length)
    {
      TrackGroup localTrackGroup2 = paramTrackGroupArray.get(k);
      int[] arrayOfInt2 = paramArrayOfInt[k];
      n = 0;
      if (n < localTrackGroup2.length)
      {
        if (!a(arrayOfInt2[n], paramParameters.exceedRendererCapabilitiesIfNecessary))
          break label263;
        b localb = new b(localTrackGroup2.getFormat(n), paramParameters, arrayOfInt2[n]);
        if ((localObject1 != null) && (localb.a((b)localObject1) <= 0))
          break label263;
        localObject1 = localb;
        i1 = n;
        i2 = k;
      }
    }
    while (true)
    {
      n++;
      i = i1;
      j = i2;
      break label38;
      k++;
      break;
      if (j == -1)
        return null;
      TrackGroup localTrackGroup1 = paramTrackGroupArray.get(j);
      boolean bool1 = paramParameters.forceHighestSupportedBitrate;
      Object localObject2 = null;
      if (!bool1)
      {
        boolean bool2 = paramParameters.forceLowestBitrate;
        localObject2 = null;
        if (!bool2)
        {
          localObject2 = null;
          if (parama != null)
          {
            int[] arrayOfInt1 = a(localTrackGroup1, paramArrayOfInt[j], paramParameters.allowMixedMimeAdaptiveness);
            int m = arrayOfInt1.length;
            localObject2 = null;
            if (m > 0)
              localObject2 = parama.b(localTrackGroup1, c(), arrayOfInt1);
          }
        }
      }
      if (localObject2 == null)
        localObject2 = new c(localTrackGroup1, i);
      return Pair.create(localObject2, a.a(localObject1));
      label263: i2 = j;
      i1 = i;
    }
  }

  public static final class Parameters
    implements Parcelable
  {
    public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator()
    {
      public DefaultTrackSelector.Parameters a(Parcel paramAnonymousParcel)
      {
        return new DefaultTrackSelector.Parameters(paramAnonymousParcel);
      }

      public DefaultTrackSelector.Parameters[] a(int paramAnonymousInt)
      {
        return new DefaultTrackSelector.Parameters[paramAnonymousInt];
      }
    };
    public static final Parameters DEFAULT = new Parameters();
    public final boolean allowMixedMimeAdaptiveness;
    public final boolean allowNonSeamlessAdaptiveness;
    public final int disabledTextTrackSelectionFlags;
    public final boolean exceedRendererCapabilitiesIfNecessary;
    public final boolean exceedVideoConstraintsIfNecessary;
    public final boolean forceHighestSupportedBitrate;
    public final boolean forceLowestBitrate;
    public final int maxVideoBitrate;
    public final int maxVideoFrameRate;
    public final int maxVideoHeight;
    public final int maxVideoWidth;
    public final String preferredAudioLanguage;
    public final String preferredTextLanguage;
    private final SparseBooleanArray rendererDisabledFlags;
    public final boolean selectUndeterminedTextLanguage;
    private final SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> selectionOverrides;
    public final int tunnelingAudioSessionId;
    public final int viewportHeight;
    public final boolean viewportOrientationMayChange;
    public final int viewportWidth;

    private Parameters()
    {
      this(new SparseArray(), new SparseBooleanArray(), null, null, false, 0, false, false, false, true, 2147483647, 2147483647, 2147483647, 2147483647, true, true, 2147483647, 2147483647, true, 0);
    }

    Parameters(Parcel paramParcel)
    {
      this.selectionOverrides = readSelectionOverrides(paramParcel);
      this.rendererDisabledFlags = paramParcel.readSparseBooleanArray();
      this.preferredAudioLanguage = paramParcel.readString();
      this.preferredTextLanguage = paramParcel.readString();
      this.selectUndeterminedTextLanguage = com.google.android.exoplayer2.g.ag.a(paramParcel);
      this.disabledTextTrackSelectionFlags = paramParcel.readInt();
      this.forceLowestBitrate = com.google.android.exoplayer2.g.ag.a(paramParcel);
      this.forceHighestSupportedBitrate = com.google.android.exoplayer2.g.ag.a(paramParcel);
      this.allowMixedMimeAdaptiveness = com.google.android.exoplayer2.g.ag.a(paramParcel);
      this.allowNonSeamlessAdaptiveness = com.google.android.exoplayer2.g.ag.a(paramParcel);
      this.maxVideoWidth = paramParcel.readInt();
      this.maxVideoHeight = paramParcel.readInt();
      this.maxVideoFrameRate = paramParcel.readInt();
      this.maxVideoBitrate = paramParcel.readInt();
      this.exceedVideoConstraintsIfNecessary = com.google.android.exoplayer2.g.ag.a(paramParcel);
      this.exceedRendererCapabilitiesIfNecessary = com.google.android.exoplayer2.g.ag.a(paramParcel);
      this.viewportWidth = paramParcel.readInt();
      this.viewportHeight = paramParcel.readInt();
      this.viewportOrientationMayChange = com.google.android.exoplayer2.g.ag.a(paramParcel);
      this.tunnelingAudioSessionId = paramParcel.readInt();
    }

    Parameters(SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> paramSparseArray, SparseBooleanArray paramSparseBooleanArray, String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean6, boolean paramBoolean7, int paramInt6, int paramInt7, boolean paramBoolean8, int paramInt8)
    {
      this.selectionOverrides = paramSparseArray;
      this.rendererDisabledFlags = paramSparseBooleanArray;
      this.preferredAudioLanguage = com.google.android.exoplayer2.g.ag.b(paramString1);
      this.preferredTextLanguage = com.google.android.exoplayer2.g.ag.b(paramString2);
      this.selectUndeterminedTextLanguage = paramBoolean1;
      this.disabledTextTrackSelectionFlags = paramInt1;
      this.forceLowestBitrate = paramBoolean2;
      this.forceHighestSupportedBitrate = paramBoolean3;
      this.allowMixedMimeAdaptiveness = paramBoolean4;
      this.allowNonSeamlessAdaptiveness = paramBoolean5;
      this.maxVideoWidth = paramInt2;
      this.maxVideoHeight = paramInt3;
      this.maxVideoFrameRate = paramInt4;
      this.maxVideoBitrate = paramInt5;
      this.exceedVideoConstraintsIfNecessary = paramBoolean6;
      this.exceedRendererCapabilitiesIfNecessary = paramBoolean7;
      this.viewportWidth = paramInt6;
      this.viewportHeight = paramInt7;
      this.viewportOrientationMayChange = paramBoolean8;
      this.tunnelingAudioSessionId = paramInt8;
    }

    private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray paramSparseBooleanArray1, SparseBooleanArray paramSparseBooleanArray2)
    {
      int i = paramSparseBooleanArray1.size();
      if (paramSparseBooleanArray2.size() != i)
        return false;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label40;
        if (paramSparseBooleanArray2.indexOfKey(paramSparseBooleanArray1.keyAt(j)) < 0)
          break;
      }
      label40: return true;
    }

    private static boolean areSelectionOverridesEqual(SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> paramSparseArray1, SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> paramSparseArray2)
    {
      int i = paramSparseArray1.size();
      if (paramSparseArray2.size() != i)
        return false;
      for (int j = 0; j < i; j++)
      {
        int k = paramSparseArray2.indexOfKey(paramSparseArray1.keyAt(j));
        if ((k < 0) || (!areSelectionOverridesEqual((Map)paramSparseArray1.valueAt(j), (Map)paramSparseArray2.valueAt(k))))
          return false;
      }
      return true;
    }

    private static boolean areSelectionOverridesEqual(Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride> paramMap1, Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride> paramMap2)
    {
      int i = paramMap1.size();
      if (paramMap2.size() != i)
        return false;
      Iterator localIterator = paramMap1.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        TrackGroupArray localTrackGroupArray = (TrackGroupArray)localEntry.getKey();
        if ((!paramMap2.containsKey(localTrackGroupArray)) || (!com.google.android.exoplayer2.g.ag.a(localEntry.getValue(), paramMap2.get(localTrackGroupArray))))
          return false;
      }
      return true;
    }

    private static SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> readSelectionOverrides(Parcel paramParcel)
    {
      int i = paramParcel.readInt();
      SparseArray localSparseArray = new SparseArray(i);
      for (int j = 0; j < i; j++)
      {
        int k = paramParcel.readInt();
        int m = paramParcel.readInt();
        HashMap localHashMap = new HashMap(m);
        for (int n = 0; n < m; n++)
          localHashMap.put((TrackGroupArray)paramParcel.readParcelable(TrackGroupArray.class.getClassLoader()), (DefaultTrackSelector.SelectionOverride)paramParcel.readParcelable(DefaultTrackSelector.SelectionOverride.class.getClassLoader()));
        localSparseArray.put(k, localHashMap);
      }
      return localSparseArray;
    }

    private static void writeSelectionOverridesToParcel(Parcel paramParcel, SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> paramSparseArray)
    {
      int i = paramSparseArray.size();
      paramParcel.writeInt(i);
      for (int j = 0; j < i; j++)
      {
        int k = paramSparseArray.keyAt(j);
        Map localMap = (Map)paramSparseArray.valueAt(j);
        int m = localMap.size();
        paramParcel.writeInt(k);
        paramParcel.writeInt(m);
        Iterator localIterator = localMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramParcel.writeParcelable((Parcelable)localEntry.getKey(), 0);
          paramParcel.writeParcelable((Parcelable)localEntry.getValue(), 0);
        }
      }
    }

    public DefaultTrackSelector.c buildUpon()
    {
      return new DefaultTrackSelector.c(this, null);
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      Parameters localParameters;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localParameters = (Parameters)paramObject;
      }
      while ((this.selectUndeterminedTextLanguage == localParameters.selectUndeterminedTextLanguage) && (this.disabledTextTrackSelectionFlags == localParameters.disabledTextTrackSelectionFlags) && (this.forceLowestBitrate == localParameters.forceLowestBitrate) && (this.forceHighestSupportedBitrate == localParameters.forceHighestSupportedBitrate) && (this.allowMixedMimeAdaptiveness == localParameters.allowMixedMimeAdaptiveness) && (this.allowNonSeamlessAdaptiveness == localParameters.allowNonSeamlessAdaptiveness) && (this.maxVideoWidth == localParameters.maxVideoWidth) && (this.maxVideoHeight == localParameters.maxVideoHeight) && (this.maxVideoFrameRate == localParameters.maxVideoFrameRate) && (this.exceedVideoConstraintsIfNecessary == localParameters.exceedVideoConstraintsIfNecessary) && (this.exceedRendererCapabilitiesIfNecessary == localParameters.exceedRendererCapabilitiesIfNecessary) && (this.viewportOrientationMayChange == localParameters.viewportOrientationMayChange) && (this.viewportWidth == localParameters.viewportWidth) && (this.viewportHeight == localParameters.viewportHeight) && (this.maxVideoBitrate == localParameters.maxVideoBitrate) && (this.tunnelingAudioSessionId == localParameters.tunnelingAudioSessionId) && (TextUtils.equals(this.preferredAudioLanguage, localParameters.preferredAudioLanguage)) && (TextUtils.equals(this.preferredTextLanguage, localParameters.preferredTextLanguage)) && (areRendererDisabledFlagsEqual(this.rendererDisabledFlags, localParameters.rendererDisabledFlags)) && (areSelectionOverridesEqual(this.selectionOverrides, localParameters.selectionOverrides)));
      return false;
    }

    public final boolean getRendererDisabled(int paramInt)
    {
      return this.rendererDisabledFlags.get(paramInt);
    }

    public final DefaultTrackSelector.SelectionOverride getSelectionOverride(int paramInt, TrackGroupArray paramTrackGroupArray)
    {
      Map localMap = (Map)this.selectionOverrides.get(paramInt);
      if (localMap != null)
        return (DefaultTrackSelector.SelectionOverride)localMap.get(paramTrackGroupArray);
      return null;
    }

    public final boolean hasSelectionOverride(int paramInt, TrackGroupArray paramTrackGroupArray)
    {
      Map localMap = (Map)this.selectionOverrides.get(paramInt);
      return (localMap != null) && (localMap.containsKey(paramTrackGroupArray));
    }

    public int hashCode()
    {
      int i = 1;
      int j;
      int m;
      label34: int i1;
      label53: int i3;
      label73: int i5;
      label93: int i7;
      label137: int i9;
      label157: label174: int i12;
      label225: int i13;
      int i14;
      if (this.selectUndeterminedTextLanguage)
      {
        j = i;
        int k = 31 * (j * 31 + this.disabledTextTrackSelectionFlags);
        if (!this.forceLowestBitrate)
          break label260;
        m = i;
        int n = 31 * (m + k);
        if (!this.forceHighestSupportedBitrate)
          break label266;
        i1 = i;
        int i2 = 31 * (i1 + n);
        if (!this.allowMixedMimeAdaptiveness)
          break label272;
        i3 = i;
        int i4 = 31 * (i3 + i2);
        if (!this.allowNonSeamlessAdaptiveness)
          break label278;
        i5 = i;
        int i6 = 31 * (31 * (31 * (31 * (i5 + i4) + this.maxVideoWidth) + this.maxVideoHeight) + this.maxVideoFrameRate);
        if (!this.exceedVideoConstraintsIfNecessary)
          break label284;
        i7 = i;
        int i8 = 31 * (i7 + i6);
        if (!this.exceedRendererCapabilitiesIfNecessary)
          break label290;
        i9 = i;
        int i10 = 31 * (i9 + i8);
        if (!this.viewportOrientationMayChange)
          break label296;
        int i11 = 31 * (31 * (31 * (31 * (31 * (i10 + i) + this.viewportWidth) + this.viewportHeight) + this.maxVideoBitrate) + this.tunnelingAudioSessionId);
        if (this.preferredAudioLanguage != null)
          break label301;
        i12 = 0;
        i13 = 31 * (i12 + i11);
        String str = this.preferredTextLanguage;
        i14 = 0;
        if (str != null)
          break label313;
      }
      while (true)
      {
        return i13 + i14;
        j = 0;
        break;
        label260: m = 0;
        break label34;
        label266: i1 = 0;
        break label53;
        label272: i3 = 0;
        break label73;
        label278: i5 = 0;
        break label93;
        label284: i7 = 0;
        break label137;
        label290: i9 = 0;
        break label157;
        label296: i = 0;
        break label174;
        label301: i12 = this.preferredAudioLanguage.hashCode();
        break label225;
        label313: i14 = this.preferredTextLanguage.hashCode();
      }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      writeSelectionOverridesToParcel(paramParcel, this.selectionOverrides);
      paramParcel.writeSparseBooleanArray(this.rendererDisabledFlags);
      paramParcel.writeString(this.preferredAudioLanguage);
      paramParcel.writeString(this.preferredTextLanguage);
      com.google.android.exoplayer2.g.ag.a(paramParcel, this.selectUndeterminedTextLanguage);
      paramParcel.writeInt(this.disabledTextTrackSelectionFlags);
      com.google.android.exoplayer2.g.ag.a(paramParcel, this.forceLowestBitrate);
      com.google.android.exoplayer2.g.ag.a(paramParcel, this.forceHighestSupportedBitrate);
      com.google.android.exoplayer2.g.ag.a(paramParcel, this.allowMixedMimeAdaptiveness);
      com.google.android.exoplayer2.g.ag.a(paramParcel, this.allowNonSeamlessAdaptiveness);
      paramParcel.writeInt(this.maxVideoWidth);
      paramParcel.writeInt(this.maxVideoHeight);
      paramParcel.writeInt(this.maxVideoFrameRate);
      paramParcel.writeInt(this.maxVideoBitrate);
      com.google.android.exoplayer2.g.ag.a(paramParcel, this.exceedVideoConstraintsIfNecessary);
      com.google.android.exoplayer2.g.ag.a(paramParcel, this.exceedRendererCapabilitiesIfNecessary);
      paramParcel.writeInt(this.viewportWidth);
      paramParcel.writeInt(this.viewportHeight);
      com.google.android.exoplayer2.g.ag.a(paramParcel, this.viewportOrientationMayChange);
      paramParcel.writeInt(this.tunnelingAudioSessionId);
    }
  }

  public static final class SelectionOverride
    implements Parcelable
  {
    public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator()
    {
      public DefaultTrackSelector.SelectionOverride a(Parcel paramAnonymousParcel)
      {
        return new DefaultTrackSelector.SelectionOverride(paramAnonymousParcel);
      }

      public DefaultTrackSelector.SelectionOverride[] a(int paramAnonymousInt)
      {
        return new DefaultTrackSelector.SelectionOverride[paramAnonymousInt];
      }
    };
    public final int groupIndex;
    public final int length;
    public final int[] tracks;

    public SelectionOverride(int paramInt, int[] paramArrayOfInt)
    {
      this.groupIndex = paramInt;
      this.tracks = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      this.length = paramArrayOfInt.length;
      Arrays.sort(this.tracks);
    }

    SelectionOverride(Parcel paramParcel)
    {
      this.groupIndex = paramParcel.readInt();
      this.length = paramParcel.readByte();
      this.tracks = new int[this.length];
      paramParcel.readIntArray(this.tracks);
    }

    public boolean containsTrack(int paramInt)
    {
      int[] arrayOfInt = this.tracks;
      int i = arrayOfInt.length;
      for (int j = 0; ; j++)
      {
        boolean bool = false;
        if (j < i)
        {
          if (arrayOfInt[j] == paramInt)
            bool = true;
        }
        else
          return bool;
      }
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      SelectionOverride localSelectionOverride;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localSelectionOverride = (SelectionOverride)paramObject;
      }
      while ((this.groupIndex == localSelectionOverride.groupIndex) && (Arrays.equals(this.tracks, localSelectionOverride.tracks)));
      return false;
    }

    public int hashCode()
    {
      return 31 * this.groupIndex + Arrays.hashCode(this.tracks);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.groupIndex);
      paramParcel.writeInt(this.tracks.length);
      paramParcel.writeIntArray(this.tracks);
    }
  }

  private static final class a
  {
    public final int a;
    public final int b;
    public final String c;

    public a(int paramInt1, int paramInt2, String paramString)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
      }
      while ((this.a == locala.a) && (this.b == locala.b) && (TextUtils.equals(this.c, locala.c)));
      return false;
    }

    public int hashCode()
    {
      int i = 31 * (31 * this.a + this.b);
      if (this.c != null);
      for (int j = this.c.hashCode(); ; j = 0)
        return j + i;
    }
  }

  protected static final class b
    implements Comparable<b>
  {
    private final DefaultTrackSelector.Parameters a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public b(Format paramFormat, DefaultTrackSelector.Parameters paramParameters, int paramInt)
    {
      this.a = paramParameters;
      int j;
      int k;
      if (DefaultTrackSelector.a(paramInt, false))
      {
        j = i;
        this.b = j;
        if (!DefaultTrackSelector.a(paramFormat, paramParameters.preferredAudioLanguage))
          break label97;
        k = i;
        label45: this.c = k;
        if ((0x1 & paramFormat.selectionFlags) == 0)
          break label103;
      }
      while (true)
      {
        this.d = i;
        this.e = paramFormat.channelCount;
        this.f = paramFormat.sampleRate;
        this.g = paramFormat.bitrate;
        return;
        j = 0;
        break;
        label97: k = 0;
        break label45;
        label103: i = 0;
      }
    }

    public int a(b paramb)
    {
      int i = 1;
      if (this.b != paramb.b)
        return DefaultTrackSelector.a(this.b, paramb.b);
      if (this.c != paramb.c)
        return DefaultTrackSelector.a(this.c, paramb.c);
      if (this.d != paramb.d)
        return DefaultTrackSelector.a(this.d, paramb.d);
      if (this.a.forceLowestBitrate)
        return DefaultTrackSelector.a(paramb.g, this.g);
      if (this.b == i);
      while (this.e != paramb.e)
      {
        return i * DefaultTrackSelector.a(this.e, paramb.e);
        i = -1;
      }
      if (this.f != paramb.f)
        return i * DefaultTrackSelector.a(this.f, paramb.f);
      return i * DefaultTrackSelector.a(this.g, paramb.g);
    }
  }

  public static final class c
  {
    private final SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> a;
    private final SparseBooleanArray b;
    private String c;
    private String d;
    private boolean e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private boolean s;
    private int t;

    public c()
    {
      this(DefaultTrackSelector.Parameters.DEFAULT);
    }

    private c(DefaultTrackSelector.Parameters paramParameters)
    {
      this.a = a(paramParameters.selectionOverrides);
      this.b = paramParameters.rendererDisabledFlags.clone();
      this.c = paramParameters.preferredAudioLanguage;
      this.d = paramParameters.preferredTextLanguage;
      this.e = paramParameters.selectUndeterminedTextLanguage;
      this.f = paramParameters.disabledTextTrackSelectionFlags;
      this.g = paramParameters.forceLowestBitrate;
      this.h = paramParameters.forceHighestSupportedBitrate;
      this.i = paramParameters.allowMixedMimeAdaptiveness;
      this.j = paramParameters.allowNonSeamlessAdaptiveness;
      this.k = paramParameters.maxVideoWidth;
      this.l = paramParameters.maxVideoHeight;
      this.m = paramParameters.maxVideoFrameRate;
      this.n = paramParameters.maxVideoBitrate;
      this.o = paramParameters.exceedVideoConstraintsIfNecessary;
      this.p = paramParameters.exceedRendererCapabilitiesIfNecessary;
      this.q = paramParameters.viewportWidth;
      this.r = paramParameters.viewportHeight;
      this.s = paramParameters.viewportOrientationMayChange;
      this.t = paramParameters.tunnelingAudioSessionId;
    }

    private static SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> a(SparseArray<Map<TrackGroupArray, DefaultTrackSelector.SelectionOverride>> paramSparseArray)
    {
      SparseArray localSparseArray = new SparseArray();
      for (int i1 = 0; i1 < paramSparseArray.size(); i1++)
        localSparseArray.put(paramSparseArray.keyAt(i1), new HashMap((Map)paramSparseArray.valueAt(i1)));
      return localSparseArray;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.DefaultTrackSelector
 * JD-Core Version:    0.6.2
 */