package org.webrtc;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class RtpParameters
{
  public final List<Codec> codecs;
  public final List<Encoding> encodings;
  private final List<HeaderExtension> headerExtensions;
  private final Rtcp rtcp;
  public final String transactionId;

  @CalledByNative
  RtpParameters(String paramString, Rtcp paramRtcp, List<HeaderExtension> paramList, List<Encoding> paramList1, List<Codec> paramList2)
  {
    this.transactionId = paramString;
    this.rtcp = paramRtcp;
    this.headerExtensions = paramList;
    this.encodings = paramList1;
    this.codecs = paramList2;
  }

  @CalledByNative
  List<Codec> getCodecs()
  {
    return this.codecs;
  }

  @CalledByNative
  List<Encoding> getEncodings()
  {
    return this.encodings;
  }

  @CalledByNative
  public List<HeaderExtension> getHeaderExtensions()
  {
    return this.headerExtensions;
  }

  @CalledByNative
  public Rtcp getRtcp()
  {
    return this.rtcp;
  }

  @CalledByNative
  String getTransactionId()
  {
    return this.transactionId;
  }

  public static class Codec
  {
    public Integer clockRate;
    MediaStreamTrack.MediaType kind;
    public String name;
    public Integer numChannels;
    public Map<String, String> parameters;
    public int payloadType;

    @CalledByNative("Codec")
    Codec(int paramInt, String paramString, MediaStreamTrack.MediaType paramMediaType, Integer paramInteger1, Integer paramInteger2, Map<String, String> paramMap)
    {
      this.payloadType = paramInt;
      this.name = paramString;
      this.kind = paramMediaType;
      this.clockRate = paramInteger1;
      this.numChannels = paramInteger2;
      this.parameters = paramMap;
    }

    @CalledByNative("Codec")
    Integer getClockRate()
    {
      return this.clockRate;
    }

    @CalledByNative("Codec")
    MediaStreamTrack.MediaType getKind()
    {
      return this.kind;
    }

    @CalledByNative("Codec")
    String getName()
    {
      return this.name;
    }

    @CalledByNative("Codec")
    Integer getNumChannels()
    {
      return this.numChannels;
    }

    @CalledByNative("Codec")
    Map getParameters()
    {
      return this.parameters;
    }

    @CalledByNative("Codec")
    int getPayloadType()
    {
      return this.payloadType;
    }
  }

  public static class Encoding
  {
    public boolean active = true;

    @Nullable
    public Integer maxBitrateBps;

    @Nullable
    public Integer minBitrateBps;
    public Long ssrc;

    @CalledByNative("Encoding")
    Encoding(boolean paramBoolean, Integer paramInteger1, Integer paramInteger2, Long paramLong)
    {
      this.active = paramBoolean;
      this.maxBitrateBps = paramInteger1;
      this.minBitrateBps = paramInteger2;
      this.ssrc = paramLong;
    }

    @CalledByNative("Encoding")
    boolean getActive()
    {
      return this.active;
    }

    @Nullable
    @CalledByNative("Encoding")
    Integer getMaxBitrateBps()
    {
      return this.maxBitrateBps;
    }

    @Nullable
    @CalledByNative("Encoding")
    Integer getMinBitrateBps()
    {
      return this.minBitrateBps;
    }

    @CalledByNative("Encoding")
    Long getSsrc()
    {
      return this.ssrc;
    }
  }

  public static class HeaderExtension
  {
    private final boolean encrypted;
    private final int id;
    private final String uri;

    @CalledByNative("HeaderExtension")
    HeaderExtension(String paramString, int paramInt, boolean paramBoolean)
    {
      this.uri = paramString;
      this.id = paramInt;
      this.encrypted = paramBoolean;
    }

    @CalledByNative("HeaderExtension")
    public boolean getEncrypted()
    {
      return this.encrypted;
    }

    @CalledByNative("HeaderExtension")
    public int getId()
    {
      return this.id;
    }

    @CalledByNative("HeaderExtension")
    public String getUri()
    {
      return this.uri;
    }
  }

  public static class Rtcp
  {
    private final String cname;
    private final boolean reducedSize;

    @CalledByNative("Rtcp")
    Rtcp(String paramString, boolean paramBoolean)
    {
      this.cname = paramString;
      this.reducedSize = paramBoolean;
    }

    @CalledByNative("Rtcp")
    public String getCname()
    {
      return this.cname;
    }

    @CalledByNative("Rtcp")
    public boolean getReducedSize()
    {
      return this.reducedSize;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.RtpParameters
 * JD-Core Version:    0.6.2
 */