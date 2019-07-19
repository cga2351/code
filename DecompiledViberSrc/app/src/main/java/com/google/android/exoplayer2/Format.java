package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format
  implements Parcelable
{
  public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator()
  {
    public Format a(Parcel paramAnonymousParcel)
    {
      return new Format(paramAnonymousParcel);
    }

    public Format[] a(int paramAnonymousInt)
    {
      return new Format[paramAnonymousInt];
    }
  };
  public static final int NO_VALUE = -1;
  public static final long OFFSET_SAMPLE_RELATIVE = 9223372036854775807L;
  public final int accessibilityChannel;
  public final int bitrate;
  public final int channelCount;
  public final String codecs;
  public final ColorInfo colorInfo;
  public final String containerMimeType;
  public final DrmInitData drmInitData;
  public final int encoderDelay;
  public final int encoderPadding;
  public final float frameRate;
  private int hashCode;
  public final int height;
  public final String id;
  public final List<byte[]> initializationData;
  public final String label;
  public final String language;
  public final int maxInputSize;
  public final Metadata metadata;
  public final int pcmEncoding;
  public final float pixelWidthHeightRatio;
  public final byte[] projectionData;
  public final int rotationDegrees;
  public final String sampleMimeType;
  public final int sampleRate;
  public final int selectionFlags;
  public final int stereoMode;
  public final long subsampleOffsetUs;
  public final int width;

  Format(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.label = paramParcel.readString();
    this.containerMimeType = paramParcel.readString();
    this.sampleMimeType = paramParcel.readString();
    this.codecs = paramParcel.readString();
    this.bitrate = paramParcel.readInt();
    this.maxInputSize = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.frameRate = paramParcel.readFloat();
    this.rotationDegrees = paramParcel.readInt();
    this.pixelWidthHeightRatio = paramParcel.readFloat();
    if (ag.a(paramParcel));
    for (byte[] arrayOfByte = paramParcel.createByteArray(); ; arrayOfByte = null)
    {
      this.projectionData = arrayOfByte;
      this.stereoMode = paramParcel.readInt();
      this.colorInfo = ((ColorInfo)paramParcel.readParcelable(ColorInfo.class.getClassLoader()));
      this.channelCount = paramParcel.readInt();
      this.sampleRate = paramParcel.readInt();
      this.pcmEncoding = paramParcel.readInt();
      this.encoderDelay = paramParcel.readInt();
      this.encoderPadding = paramParcel.readInt();
      this.selectionFlags = paramParcel.readInt();
      this.language = paramParcel.readString();
      this.accessibilityChannel = paramParcel.readInt();
      this.subsampleOffsetUs = paramParcel.readLong();
      int i = paramParcel.readInt();
      this.initializationData = new ArrayList(i);
      for (int j = 0; j < i; j++)
        this.initializationData.add(paramParcel.createByteArray());
    }
    this.drmInitData = ((DrmInitData)paramParcel.readParcelable(DrmInitData.class.getClassLoader()));
    this.metadata = ((Metadata)paramParcel.readParcelable(Metadata.class.getClassLoader()));
  }

  Format(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, ColorInfo paramColorInfo, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString6, int paramInt13, long paramLong, List<byte[]> paramList, DrmInitData paramDrmInitData, Metadata paramMetadata)
  {
    this.id = paramString1;
    this.label = paramString2;
    this.containerMimeType = paramString3;
    this.sampleMimeType = paramString4;
    this.codecs = paramString5;
    this.bitrate = paramInt1;
    this.maxInputSize = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.frameRate = paramFloat1;
    if (paramInt5 == -1)
      paramInt5 = 0;
    this.rotationDegrees = paramInt5;
    if (paramFloat2 == -1.0F)
      paramFloat2 = 1.0F;
    this.pixelWidthHeightRatio = paramFloat2;
    this.projectionData = paramArrayOfByte;
    this.stereoMode = paramInt6;
    this.colorInfo = paramColorInfo;
    this.channelCount = paramInt7;
    this.sampleRate = paramInt8;
    this.pcmEncoding = paramInt9;
    if (paramInt10 == -1)
      paramInt10 = 0;
    this.encoderDelay = paramInt10;
    if (paramInt11 == -1)
      paramInt11 = 0;
    this.encoderPadding = paramInt11;
    this.selectionFlags = paramInt12;
    this.language = paramString6;
    this.accessibilityChannel = paramInt13;
    this.subsampleOffsetUs = paramLong;
    if (paramList == null)
      paramList = Collections.emptyList();
    this.initializationData = paramList;
    this.drmInitData = paramDrmInitData;
    this.metadata = paramMetadata;
  }

  @Deprecated
  public static Format createAudioContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, List<byte[]> paramList, int paramInt4, String paramString5)
  {
    return createAudioContainerFormat(paramString1, null, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramList, paramInt4, paramString5);
  }

  public static Format createAudioContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, List<byte[]> paramList, int paramInt4, String paramString6)
  {
    return new Format(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt2, paramInt3, -1, -1, -1, paramInt4, paramString6, -1, 9223372036854775807L, paramList, null, null);
  }

  public static Format createAudioSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt8, String paramString4, Metadata paramMetadata)
  {
    return new Format(paramString1, null, null, paramString2, paramString3, paramInt1, paramInt2, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramString4, -1, 9223372036854775807L, paramList, paramDrmInitData, paramMetadata);
  }

  public static Format createAudioSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt6, String paramString4)
  {
    return createAudioSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, -1, -1, paramList, paramDrmInitData, paramInt6, paramString4, null);
  }

  public static Format createAudioSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt5, String paramString4)
  {
    return createAudioSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList, paramDrmInitData, paramInt5, paramString4);
  }

  @Deprecated
  public static Format createContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5)
  {
    return createContainerFormat(paramString1, null, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramString5);
  }

  public static Format createContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6)
  {
    return new Format(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString6, -1, 9223372036854775807L, null, null, null);
  }

  public static Format createImageSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, List<byte[]> paramList, String paramString4, DrmInitData paramDrmInitData)
  {
    return new Format(paramString1, null, null, paramString2, paramString3, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString4, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
  }

  public static Format createSampleFormat(String paramString1, String paramString2, long paramLong)
  {
    return new Format(paramString1, null, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, paramLong, null, null, null);
  }

  public static Format createSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt, DrmInitData paramDrmInitData)
  {
    return new Format(paramString1, null, null, paramString2, paramString3, paramInt, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, paramDrmInitData, null);
  }

  @Deprecated
  public static Format createTextContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5)
  {
    return createTextContainerFormat(paramString1, null, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramString5);
  }

  public static Format createTextContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6)
  {
    return createTextContainerFormat(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, -1);
  }

  public static Format createTextContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, int paramInt3)
  {
    return new Format(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString6, paramInt3, 9223372036854775807L, null, null, null);
  }

  public static Format createTextSampleFormat(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return createTextSampleFormat(paramString1, paramString2, paramInt, paramString3, null);
  }

  public static Format createTextSampleFormat(String paramString1, String paramString2, int paramInt, String paramString3, DrmInitData paramDrmInitData)
  {
    return createTextSampleFormat(paramString1, paramString2, null, -1, paramInt, paramString3, -1, paramDrmInitData, 9223372036854775807L, Collections.emptyList());
  }

  public static Format createTextSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, DrmInitData paramDrmInitData)
  {
    return createTextSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramInt3, paramDrmInitData, 9223372036854775807L, Collections.emptyList());
  }

  public static Format createTextSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, DrmInitData paramDrmInitData, long paramLong, List<byte[]> paramList)
  {
    return new Format(paramString1, null, null, paramString2, paramString3, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString4, paramInt3, paramLong, paramList, paramDrmInitData, null);
  }

  public static Format createTextSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, DrmInitData paramDrmInitData, long paramLong)
  {
    return createTextSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, -1, paramDrmInitData, paramLong, Collections.emptyList());
  }

  @Deprecated
  public static Format createVideoContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, float paramFloat, List<byte[]> paramList, int paramInt4)
  {
    return createVideoContainerFormat(paramString1, null, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramFloat, paramList, paramInt4);
  }

  public static Format createVideoContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, float paramFloat, List<byte[]> paramList, int paramInt4)
  {
    return new Format(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, -1, paramInt2, paramInt3, paramFloat, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt4, null, -1, 9223372036854775807L, paramList, null, null);
  }

  public static Format createVideoSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, List<byte[]> paramList, int paramInt5, float paramFloat2, DrmInitData paramDrmInitData)
  {
    return createVideoSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramList, paramInt5, paramFloat2, null, -1, null, paramDrmInitData);
  }

  public static Format createVideoSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, List<byte[]> paramList, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, ColorInfo paramColorInfo, DrmInitData paramDrmInitData)
  {
    return new Format(paramString1, null, null, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramInt5, paramFloat2, paramArrayOfByte, paramInt6, paramColorInfo, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
  }

  public static Format createVideoSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, List<byte[]> paramList, DrmInitData paramDrmInitData)
  {
    return createVideoSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, paramList, -1, -1.0F, paramDrmInitData);
  }

  public static String toLogString(Format paramFormat)
  {
    if (paramFormat == null)
      return "null";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(paramFormat.id).append(", mimeType=").append(paramFormat.sampleMimeType);
    if (paramFormat.bitrate != -1)
      localStringBuilder.append(", bitrate=").append(paramFormat.bitrate);
    if (paramFormat.codecs != null)
      localStringBuilder.append(", codecs=").append(paramFormat.codecs);
    if ((paramFormat.width != -1) && (paramFormat.height != -1))
      localStringBuilder.append(", res=").append(paramFormat.width).append("x").append(paramFormat.height);
    if (paramFormat.frameRate != -1.0F)
      localStringBuilder.append(", fps=").append(paramFormat.frameRate);
    if (paramFormat.channelCount != -1)
      localStringBuilder.append(", channels=").append(paramFormat.channelCount);
    if (paramFormat.sampleRate != -1)
      localStringBuilder.append(", sample_rate=").append(paramFormat.sampleRate);
    if (paramFormat.language != null)
      localStringBuilder.append(", language=").append(paramFormat.language);
    if (paramFormat.label != null)
      localStringBuilder.append(", label=").append(paramFormat.label);
    return localStringBuilder.toString();
  }

  public Format copyWithContainerInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString5)
  {
    return new Format(paramString1, paramString2, this.containerMimeType, paramString3, paramString4, paramInt1, this.maxInputSize, paramInt2, paramInt3, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, paramInt4, paramString5, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
  }

  public Format copyWithDrmInitData(DrmInitData paramDrmInitData)
  {
    return new Format(this.id, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, paramDrmInitData, this.metadata);
  }

  public Format copyWithFrameRate(float paramFloat)
  {
    return new Format(this.id, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, paramFloat, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
  }

  public Format copyWithGaplessInfo(int paramInt1, int paramInt2)
  {
    return new Format(this.id, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, paramInt1, paramInt2, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
  }

  public Format copyWithManifestFormatInfo(Format paramFormat)
  {
    if (this == paramFormat)
      return this;
    int i = o.g(this.sampleMimeType);
    String str1 = paramFormat.id;
    String str2;
    String str3;
    int j;
    label76: String str4;
    String str5;
    if (paramFormat.label != null)
    {
      str2 = paramFormat.label;
      str3 = this.language;
      if (((i == 3) || (i == 1)) && (paramFormat.language != null))
        str3 = paramFormat.language;
      if (this.bitrate != -1)
        break label264;
      j = paramFormat.bitrate;
      str4 = this.codecs;
      if (str4 != null)
        break label273;
      str5 = ag.a(paramFormat.codecs, i);
      if (ag.i(str5).length != 1)
        break label273;
    }
    while (true)
    {
      float f = this.frameRate;
      if ((f == -1.0F) && (i == 2))
        f = paramFormat.frameRate;
      int k = this.selectionFlags | paramFormat.selectionFlags;
      DrmInitData localDrmInitData = DrmInitData.createSessionCreationData(paramFormat.drmInitData, this.drmInitData);
      return new Format(str1, str2, this.containerMimeType, this.sampleMimeType, str5, j, this.maxInputSize, this.width, this.height, f, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, k, str3, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, localDrmInitData, this.metadata);
      str2 = this.label;
      break;
      label264: j = this.bitrate;
      break label76;
      label273: str5 = str4;
    }
  }

  public Format copyWithMaxInputSize(int paramInt)
  {
    return new Format(this.id, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, paramInt, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
  }

  public Format copyWithMetadata(Metadata paramMetadata)
  {
    return new Format(this.id, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, paramMetadata);
  }

  public Format copyWithRotationDegrees(int paramInt)
  {
    return new Format(this.id, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, paramInt, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
  }

  public Format copyWithSubsampleOffsetUs(long paramLong)
  {
    return new Format(this.id, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, paramLong, this.initializationData, this.drmInitData, this.metadata);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Format localFormat;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFormat = (Format)paramObject;
      if ((this.hashCode != 0) && (localFormat.hashCode != 0) && (this.hashCode != localFormat.hashCode))
        return false;
    }
    while ((this.bitrate == localFormat.bitrate) && (this.maxInputSize == localFormat.maxInputSize) && (this.width == localFormat.width) && (this.height == localFormat.height) && (Float.compare(this.frameRate, localFormat.frameRate) == 0) && (this.rotationDegrees == localFormat.rotationDegrees) && (Float.compare(this.pixelWidthHeightRatio, localFormat.pixelWidthHeightRatio) == 0) && (this.stereoMode == localFormat.stereoMode) && (this.channelCount == localFormat.channelCount) && (this.sampleRate == localFormat.sampleRate) && (this.pcmEncoding == localFormat.pcmEncoding) && (this.encoderDelay == localFormat.encoderDelay) && (this.encoderPadding == localFormat.encoderPadding) && (this.subsampleOffsetUs == localFormat.subsampleOffsetUs) && (this.selectionFlags == localFormat.selectionFlags) && (ag.a(this.id, localFormat.id)) && (ag.a(this.label, localFormat.label)) && (ag.a(this.language, localFormat.language)) && (this.accessibilityChannel == localFormat.accessibilityChannel) && (ag.a(this.containerMimeType, localFormat.containerMimeType)) && (ag.a(this.sampleMimeType, localFormat.sampleMimeType)) && (ag.a(this.codecs, localFormat.codecs)) && (ag.a(this.drmInitData, localFormat.drmInitData)) && (ag.a(this.metadata, localFormat.metadata)) && (ag.a(this.colorInfo, localFormat.colorInfo)) && (Arrays.equals(this.projectionData, localFormat.projectionData)) && (initializationDataEquals(localFormat)));
    return false;
  }

  public int getPixelCount()
  {
    if ((this.width == -1) || (this.height == -1))
      return -1;
    return this.width * this.height;
  }

  public int hashCode()
  {
    int i;
    int k;
    label34: int n;
    label52: int i2;
    label72: int i4;
    label132: int i6;
    label160: int i7;
    if (this.hashCode == 0)
    {
      if (this.id != null)
        break label314;
      i = 0;
      int j = 31 * (i + 527);
      if (this.containerMimeType != null)
        break label325;
      k = 0;
      int m = 31 * (k + j);
      if (this.sampleMimeType != null)
        break label336;
      n = 0;
      int i1 = 31 * (n + m);
      if (this.codecs != null)
        break label348;
      i2 = 0;
      int i3 = 31 * (31 * (31 * (31 * (31 * (31 * (i2 + i1) + this.bitrate) + this.width) + this.height) + this.channelCount) + this.sampleRate);
      if (this.language != null)
        break label360;
      i4 = 0;
      int i5 = 31 * (31 * (i4 + i3) + this.accessibilityChannel);
      if (this.drmInitData != null)
        break label372;
      i6 = 0;
      i7 = 31 * (i6 + i5);
      if (this.metadata != null)
        break label384;
    }
    label384: for (int i8 = 0; ; i8 = this.metadata.hashCode())
    {
      int i9 = 31 * (i8 + i7);
      String str = this.label;
      int i10 = 0;
      if (str != null)
        i10 = this.label.hashCode();
      this.hashCode = (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (i9 + i10) + this.maxInputSize) + (int)this.subsampleOffsetUs) + Float.floatToIntBits(this.frameRate)) + Float.floatToIntBits(this.pixelWidthHeightRatio)) + this.rotationDegrees) + this.stereoMode) + this.pcmEncoding) + this.encoderDelay) + this.encoderPadding) + this.selectionFlags);
      return this.hashCode;
      label314: i = this.id.hashCode();
      break;
      label325: k = this.containerMimeType.hashCode();
      break label34;
      label336: n = this.sampleMimeType.hashCode();
      break label52;
      label348: i2 = this.codecs.hashCode();
      break label72;
      label360: i4 = this.language.hashCode();
      break label132;
      label372: i6 = this.drmInitData.hashCode();
      break label160;
    }
  }

  public boolean initializationDataEquals(Format paramFormat)
  {
    if (this.initializationData.size() != paramFormat.initializationData.size())
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= this.initializationData.size())
        break label76;
      if (!Arrays.equals((byte[])this.initializationData.get(i), (byte[])paramFormat.initializationData.get(i)))
        break;
    }
    label76: return true;
  }

  public String toString()
  {
    return "Format(" + this.id + ", " + this.label + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.codecs + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.label);
    paramParcel.writeString(this.containerMimeType);
    paramParcel.writeString(this.sampleMimeType);
    paramParcel.writeString(this.codecs);
    paramParcel.writeInt(this.bitrate);
    paramParcel.writeInt(this.maxInputSize);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeFloat(this.frameRate);
    paramParcel.writeInt(this.rotationDegrees);
    paramParcel.writeFloat(this.pixelWidthHeightRatio);
    if (this.projectionData != null);
    for (boolean bool = true; ; bool = false)
    {
      ag.a(paramParcel, bool);
      if (this.projectionData != null)
        paramParcel.writeByteArray(this.projectionData);
      paramParcel.writeInt(this.stereoMode);
      paramParcel.writeParcelable(this.colorInfo, paramInt);
      paramParcel.writeInt(this.channelCount);
      paramParcel.writeInt(this.sampleRate);
      paramParcel.writeInt(this.pcmEncoding);
      paramParcel.writeInt(this.encoderDelay);
      paramParcel.writeInt(this.encoderPadding);
      paramParcel.writeInt(this.selectionFlags);
      paramParcel.writeString(this.language);
      paramParcel.writeInt(this.accessibilityChannel);
      paramParcel.writeLong(this.subsampleOffsetUs);
      int i = this.initializationData.size();
      paramParcel.writeInt(i);
      for (int j = 0; j < i; j++)
        paramParcel.writeByteArray((byte[])this.initializationData.get(j));
    }
    paramParcel.writeParcelable(this.drmInitData, 0);
    paramParcel.writeParcelable(this.metadata, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.Format
 * JD-Core Version:    0.6.2
 */