package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

public enum zzdnu
{
  private static final zzdnu[] zzhgo;
  private static final Type[] zzhgp;
  private final int id;
  private final zzdol zzhgk;
  private final zzdnw zzhgl;
  private final Class<?> zzhgm;
  private final boolean zzhgn;

  static
  {
    int i = 0;
    zzhel = new zzdnu("DOUBLE", 0, 0, zzdnw.zzhgt, zzdol.zzhii);
    zzhem = new zzdnu("FLOAT", 1, 1, zzdnw.zzhgt, zzdol.zzhih);
    zzhen = new zzdnu("INT64", 2, 2, zzdnw.zzhgt, zzdol.zzhig);
    zzheo = new zzdnu("UINT64", 3, 3, zzdnw.zzhgt, zzdol.zzhig);
    zzhep = new zzdnu("INT32", 4, 4, zzdnw.zzhgt, zzdol.zzhif);
    zzheq = new zzdnu("FIXED64", 5, 5, zzdnw.zzhgt, zzdol.zzhig);
    zzher = new zzdnu("FIXED32", 6, 6, zzdnw.zzhgt, zzdol.zzhif);
    zzhes = new zzdnu("BOOL", 7, 7, zzdnw.zzhgt, zzdol.zzhij);
    zzhet = new zzdnu("STRING", 8, 8, zzdnw.zzhgt, zzdol.zzhik);
    zzheu = new zzdnu("MESSAGE", 9, 9, zzdnw.zzhgt, zzdol.zzhin);
    zzhev = new zzdnu("BYTES", 10, 10, zzdnw.zzhgt, zzdol.zzhil);
    zzhew = new zzdnu("UINT32", 11, 11, zzdnw.zzhgt, zzdol.zzhif);
    zzhex = new zzdnu("ENUM", 12, 12, zzdnw.zzhgt, zzdol.zzhim);
    zzhey = new zzdnu("SFIXED32", 13, 13, zzdnw.zzhgt, zzdol.zzhif);
    zzhez = new zzdnu("SFIXED64", 14, 14, zzdnw.zzhgt, zzdol.zzhig);
    zzhfa = new zzdnu("SINT32", 15, 15, zzdnw.zzhgt, zzdol.zzhif);
    zzhfb = new zzdnu("SINT64", 16, 16, zzdnw.zzhgt, zzdol.zzhig);
    zzhfc = new zzdnu("GROUP", 17, 17, zzdnw.zzhgt, zzdol.zzhin);
    zzhfd = new zzdnu("DOUBLE_LIST", 18, 18, zzdnw.zzhgu, zzdol.zzhii);
    zzhfe = new zzdnu("FLOAT_LIST", 19, 19, zzdnw.zzhgu, zzdol.zzhih);
    zzhff = new zzdnu("INT64_LIST", 20, 20, zzdnw.zzhgu, zzdol.zzhig);
    zzhfg = new zzdnu("UINT64_LIST", 21, 21, zzdnw.zzhgu, zzdol.zzhig);
    zzhfh = new zzdnu("INT32_LIST", 22, 22, zzdnw.zzhgu, zzdol.zzhif);
    zzhfi = new zzdnu("FIXED64_LIST", 23, 23, zzdnw.zzhgu, zzdol.zzhig);
    zzhfj = new zzdnu("FIXED32_LIST", 24, 24, zzdnw.zzhgu, zzdol.zzhif);
    zzhfk = new zzdnu("BOOL_LIST", 25, 25, zzdnw.zzhgu, zzdol.zzhij);
    zzhfl = new zzdnu("STRING_LIST", 26, 26, zzdnw.zzhgu, zzdol.zzhik);
    zzhfm = new zzdnu("MESSAGE_LIST", 27, 27, zzdnw.zzhgu, zzdol.zzhin);
    zzhfn = new zzdnu("BYTES_LIST", 28, 28, zzdnw.zzhgu, zzdol.zzhil);
    zzhfo = new zzdnu("UINT32_LIST", 29, 29, zzdnw.zzhgu, zzdol.zzhif);
    zzhfp = new zzdnu("ENUM_LIST", 30, 30, zzdnw.zzhgu, zzdol.zzhim);
    zzhfq = new zzdnu("SFIXED32_LIST", 31, 31, zzdnw.zzhgu, zzdol.zzhif);
    zzhfr = new zzdnu("SFIXED64_LIST", 32, 32, zzdnw.zzhgu, zzdol.zzhig);
    zzhfs = new zzdnu("SINT32_LIST", 33, 33, zzdnw.zzhgu, zzdol.zzhif);
    zzhft = new zzdnu("SINT64_LIST", 34, 34, zzdnw.zzhgu, zzdol.zzhig);
    zzhfu = new zzdnu("DOUBLE_LIST_PACKED", 35, 35, zzdnw.zzhgv, zzdol.zzhii);
    zzhfv = new zzdnu("FLOAT_LIST_PACKED", 36, 36, zzdnw.zzhgv, zzdol.zzhih);
    zzhfw = new zzdnu("INT64_LIST_PACKED", 37, 37, zzdnw.zzhgv, zzdol.zzhig);
    zzhfx = new zzdnu("UINT64_LIST_PACKED", 38, 38, zzdnw.zzhgv, zzdol.zzhig);
    zzhfy = new zzdnu("INT32_LIST_PACKED", 39, 39, zzdnw.zzhgv, zzdol.zzhif);
    zzhfz = new zzdnu("FIXED64_LIST_PACKED", 40, 40, zzdnw.zzhgv, zzdol.zzhig);
    zzhga = new zzdnu("FIXED32_LIST_PACKED", 41, 41, zzdnw.zzhgv, zzdol.zzhif);
    zzhgb = new zzdnu("BOOL_LIST_PACKED", 42, 42, zzdnw.zzhgv, zzdol.zzhij);
    zzhgc = new zzdnu("UINT32_LIST_PACKED", 43, 43, zzdnw.zzhgv, zzdol.zzhif);
    zzhgd = new zzdnu("ENUM_LIST_PACKED", 44, 44, zzdnw.zzhgv, zzdol.zzhim);
    zzhge = new zzdnu("SFIXED32_LIST_PACKED", 45, 45, zzdnw.zzhgv, zzdol.zzhif);
    zzhgf = new zzdnu("SFIXED64_LIST_PACKED", 46, 46, zzdnw.zzhgv, zzdol.zzhig);
    zzhgg = new zzdnu("SINT32_LIST_PACKED", 47, 47, zzdnw.zzhgv, zzdol.zzhif);
    zzhgh = new zzdnu("SINT64_LIST_PACKED", 48, 48, zzdnw.zzhgv, zzdol.zzhig);
    zzhgi = new zzdnu("GROUP_LIST", 49, 49, zzdnw.zzhgu, zzdol.zzhin);
    zzhgj = new zzdnu("MAP", 50, 50, zzdnw.zzhgw, zzdol.zzhie);
    zzdnu[] arrayOfzzdnu1 = new zzdnu[51];
    arrayOfzzdnu1[0] = zzhel;
    arrayOfzzdnu1[1] = zzhem;
    arrayOfzzdnu1[2] = zzhen;
    arrayOfzzdnu1[3] = zzheo;
    arrayOfzzdnu1[4] = zzhep;
    arrayOfzzdnu1[5] = zzheq;
    arrayOfzzdnu1[6] = zzher;
    arrayOfzzdnu1[7] = zzhes;
    arrayOfzzdnu1[8] = zzhet;
    arrayOfzzdnu1[9] = zzheu;
    arrayOfzzdnu1[10] = zzhev;
    arrayOfzzdnu1[11] = zzhew;
    arrayOfzzdnu1[12] = zzhex;
    arrayOfzzdnu1[13] = zzhey;
    arrayOfzzdnu1[14] = zzhez;
    arrayOfzzdnu1[15] = zzhfa;
    arrayOfzzdnu1[16] = zzhfb;
    arrayOfzzdnu1[17] = zzhfc;
    arrayOfzzdnu1[18] = zzhfd;
    arrayOfzzdnu1[19] = zzhfe;
    arrayOfzzdnu1[20] = zzhff;
    arrayOfzzdnu1[21] = zzhfg;
    arrayOfzzdnu1[22] = zzhfh;
    arrayOfzzdnu1[23] = zzhfi;
    arrayOfzzdnu1[24] = zzhfj;
    arrayOfzzdnu1[25] = zzhfk;
    arrayOfzzdnu1[26] = zzhfl;
    arrayOfzzdnu1[27] = zzhfm;
    arrayOfzzdnu1[28] = zzhfn;
    arrayOfzzdnu1[29] = zzhfo;
    arrayOfzzdnu1[30] = zzhfp;
    arrayOfzzdnu1[31] = zzhfq;
    arrayOfzzdnu1[32] = zzhfr;
    arrayOfzzdnu1[33] = zzhfs;
    arrayOfzzdnu1[34] = zzhft;
    arrayOfzzdnu1[35] = zzhfu;
    arrayOfzzdnu1[36] = zzhfv;
    arrayOfzzdnu1[37] = zzhfw;
    arrayOfzzdnu1[38] = zzhfx;
    arrayOfzzdnu1[39] = zzhfy;
    arrayOfzzdnu1[40] = zzhfz;
    arrayOfzzdnu1[41] = zzhga;
    arrayOfzzdnu1[42] = zzhgb;
    arrayOfzzdnu1[43] = zzhgc;
    arrayOfzzdnu1[44] = zzhgd;
    arrayOfzzdnu1[45] = zzhge;
    arrayOfzzdnu1[46] = zzhgf;
    arrayOfzzdnu1[47] = zzhgg;
    arrayOfzzdnu1[48] = zzhgh;
    arrayOfzzdnu1[49] = zzhgi;
    arrayOfzzdnu1[50] = zzhgj;
    zzhgq = arrayOfzzdnu1;
    zzhgp = new Type[0];
    zzdnu[] arrayOfzzdnu2 = values();
    zzhgo = new zzdnu[arrayOfzzdnu2.length];
    int j = arrayOfzzdnu2.length;
    while (i < j)
    {
      zzdnu localzzdnu = arrayOfzzdnu2[i];
      zzhgo[localzzdnu.id] = localzzdnu;
      i++;
    }
  }

  private zzdnu(int paramInt, zzdnw paramzzdnw, zzdol paramzzdol)
  {
    this.id = paramInt;
    this.zzhgl = paramzzdnw;
    this.zzhgk = paramzzdol;
    switch (zzdnv.zzhgr[paramzzdnw.ordinal()])
    {
    default:
      this.zzhgm = null;
    case 1:
    case 2:
    }
    while (true)
    {
      zzdnw localzzdnw1 = zzdnw.zzhgt;
      boolean bool = false;
      if (paramzzdnw == localzzdnw1)
      {
        int i = zzdnv.zzhgs[paramzzdol.ordinal()];
        bool = false;
        switch (i)
        {
        default:
          bool = true;
        case 1:
        case 2:
        case 3:
        }
      }
      this.zzhgn = bool;
      return;
      this.zzhgm = paramzzdol.zzayl();
      continue;
      this.zzhgm = paramzzdol.zzayl();
    }
  }

  public final int id()
  {
    return this.id;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnu
 * JD-Core Version:    0.6.2
 */