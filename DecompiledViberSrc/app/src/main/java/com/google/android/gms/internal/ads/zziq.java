package com.google.android.gms.internal.ads;

class zziq
{
  private static final int zzajz = zzkq.zzay("ftyp");
  public static final int zzaka = zzkq.zzay("avc1");
  public static final int zzakb = zzkq.zzay("avc3");
  public static final int zzakc = zzkq.zzay("esds");
  private static final int zzakd = zzkq.zzay("mdat");
  public static final int zzake = zzkq.zzay("mp4a");
  public static final int zzakf = zzkq.zzay("ac-3");
  public static final int zzakg = zzkq.zzay("dac3");
  public static final int zzakh = zzkq.zzay("ec-3");
  public static final int zzaki = zzkq.zzay("dec3");
  private static final int zzakj = zzkq.zzay("tfdt");
  private static final int zzakk = zzkq.zzay("tfhd");
  private static final int zzakl = zzkq.zzay("trex");
  private static final int zzakm = zzkq.zzay("trun");
  private static final int zzakn = zzkq.zzay("sidx");
  public static final int zzako = zzkq.zzay("moov");
  public static final int zzakp = zzkq.zzay("mvhd");
  public static final int zzakq = zzkq.zzay("trak");
  public static final int zzakr = zzkq.zzay("mdia");
  public static final int zzaks = zzkq.zzay("minf");
  public static final int zzakt = zzkq.zzay("stbl");
  public static final int zzaku = zzkq.zzay("avcC");
  private static final int zzakv = zzkq.zzay("moof");
  private static final int zzakw = zzkq.zzay("traf");
  private static final int zzakx = zzkq.zzay("mvex");
  public static final int zzaky = zzkq.zzay("tkhd");
  public static final int zzakz = zzkq.zzay("mdhd");
  public static final int zzala = zzkq.zzay("hdlr");
  public static final int zzalb = zzkq.zzay("stsd");
  private static final int zzalc = zzkq.zzay("pssh");
  public static final int zzald = zzkq.zzay("sinf");
  public static final int zzale = zzkq.zzay("schm");
  public static final int zzalf = zzkq.zzay("schi");
  public static final int zzalg = zzkq.zzay("tenc");
  public static final int zzalh = zzkq.zzay("encv");
  public static final int zzali = zzkq.zzay("enca");
  public static final int zzalj = zzkq.zzay("frma");
  private static final int zzalk = zzkq.zzay("saiz");
  private static final int zzall = zzkq.zzay("uuid");
  private static final int zzalm = zzkq.zzay("senc");
  public static final int zzaln = zzkq.zzay("pasp");
  public static final int zzalo = zzkq.zzay("TTML");
  public static final int zzalp = zzkq.zzay("vmhd");
  public static final int zzalq = zzkq.zzay("smhd");
  public static final int zzalr = zzkq.zzay("mp4v");
  public static final int zzals = zzkq.zzay("stts");
  public static final int zzalt = zzkq.zzay("stss");
  public static final int zzalu = zzkq.zzay("ctts");
  public static final int zzalv = zzkq.zzay("stsc");
  public static final int zzalw = zzkq.zzay("stsz");
  public static final int zzalx = zzkq.zzay("stco");
  public static final int zzaly = zzkq.zzay("co64");
  public final int type;

  zziq(int paramInt)
  {
    this.type = paramInt;
  }

  public static int zzt(int paramInt)
  {
    return 0xFF & paramInt >> 24;
  }

  public static String zzu(int paramInt)
  {
    char c1 = (char)(paramInt >> 24);
    char c2 = (char)(0xFF & paramInt >> 16);
    char c3 = (char)(0xFF & paramInt >> 8);
    char c4 = (char)(paramInt & 0xFF);
    return 4 + c1 + c2 + c3 + c4;
  }

  public String toString()
  {
    return zzu(this.type);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zziq
 * JD-Core Version:    0.6.2
 */