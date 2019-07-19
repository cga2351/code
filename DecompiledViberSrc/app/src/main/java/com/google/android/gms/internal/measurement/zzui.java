package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

public enum zzui
{
  private static final zzui[] zzbxq;
  private static final Type[] zzbxr;
  private final int id;
  private final zzux zzbxm;
  private final zzuk zzbxn;
  private final Class<?> zzbxo;
  private final boolean zzbxp;

  static
  {
    int i = 0;
    zzbvn = new zzui("DOUBLE", 0, 0, zzuk.zzbxv, zzux.zzbzk);
    zzbvo = new zzui("FLOAT", 1, 1, zzuk.zzbxv, zzux.zzbzj);
    zzbvp = new zzui("INT64", 2, 2, zzuk.zzbxv, zzux.zzbzi);
    zzbvq = new zzui("UINT64", 3, 3, zzuk.zzbxv, zzux.zzbzi);
    zzbvr = new zzui("INT32", 4, 4, zzuk.zzbxv, zzux.zzbzh);
    zzbvs = new zzui("FIXED64", 5, 5, zzuk.zzbxv, zzux.zzbzi);
    zzbvt = new zzui("FIXED32", 6, 6, zzuk.zzbxv, zzux.zzbzh);
    zzbvu = new zzui("BOOL", 7, 7, zzuk.zzbxv, zzux.zzbzl);
    zzbvv = new zzui("STRING", 8, 8, zzuk.zzbxv, zzux.zzbzm);
    zzbvw = new zzui("MESSAGE", 9, 9, zzuk.zzbxv, zzux.zzbzp);
    zzbvx = new zzui("BYTES", 10, 10, zzuk.zzbxv, zzux.zzbzn);
    zzbvy = new zzui("UINT32", 11, 11, zzuk.zzbxv, zzux.zzbzh);
    zzbvz = new zzui("ENUM", 12, 12, zzuk.zzbxv, zzux.zzbzo);
    zzbwa = new zzui("SFIXED32", 13, 13, zzuk.zzbxv, zzux.zzbzh);
    zzbwb = new zzui("SFIXED64", 14, 14, zzuk.zzbxv, zzux.zzbzi);
    zzbwc = new zzui("SINT32", 15, 15, zzuk.zzbxv, zzux.zzbzh);
    zzbwd = new zzui("SINT64", 16, 16, zzuk.zzbxv, zzux.zzbzi);
    zzbwe = new zzui("GROUP", 17, 17, zzuk.zzbxv, zzux.zzbzp);
    zzbwf = new zzui("DOUBLE_LIST", 18, 18, zzuk.zzbxw, zzux.zzbzk);
    zzbwg = new zzui("FLOAT_LIST", 19, 19, zzuk.zzbxw, zzux.zzbzj);
    zzbwh = new zzui("INT64_LIST", 20, 20, zzuk.zzbxw, zzux.zzbzi);
    zzbwi = new zzui("UINT64_LIST", 21, 21, zzuk.zzbxw, zzux.zzbzi);
    zzbwj = new zzui("INT32_LIST", 22, 22, zzuk.zzbxw, zzux.zzbzh);
    zzbwk = new zzui("FIXED64_LIST", 23, 23, zzuk.zzbxw, zzux.zzbzi);
    zzbwl = new zzui("FIXED32_LIST", 24, 24, zzuk.zzbxw, zzux.zzbzh);
    zzbwm = new zzui("BOOL_LIST", 25, 25, zzuk.zzbxw, zzux.zzbzl);
    zzbwn = new zzui("STRING_LIST", 26, 26, zzuk.zzbxw, zzux.zzbzm);
    zzbwo = new zzui("MESSAGE_LIST", 27, 27, zzuk.zzbxw, zzux.zzbzp);
    zzbwp = new zzui("BYTES_LIST", 28, 28, zzuk.zzbxw, zzux.zzbzn);
    zzbwq = new zzui("UINT32_LIST", 29, 29, zzuk.zzbxw, zzux.zzbzh);
    zzbwr = new zzui("ENUM_LIST", 30, 30, zzuk.zzbxw, zzux.zzbzo);
    zzbws = new zzui("SFIXED32_LIST", 31, 31, zzuk.zzbxw, zzux.zzbzh);
    zzbwt = new zzui("SFIXED64_LIST", 32, 32, zzuk.zzbxw, zzux.zzbzi);
    zzbwu = new zzui("SINT32_LIST", 33, 33, zzuk.zzbxw, zzux.zzbzh);
    zzbwv = new zzui("SINT64_LIST", 34, 34, zzuk.zzbxw, zzux.zzbzi);
    zzbww = new zzui("DOUBLE_LIST_PACKED", 35, 35, zzuk.zzbxx, zzux.zzbzk);
    zzbwx = new zzui("FLOAT_LIST_PACKED", 36, 36, zzuk.zzbxx, zzux.zzbzj);
    zzbwy = new zzui("INT64_LIST_PACKED", 37, 37, zzuk.zzbxx, zzux.zzbzi);
    zzbwz = new zzui("UINT64_LIST_PACKED", 38, 38, zzuk.zzbxx, zzux.zzbzi);
    zzbxa = new zzui("INT32_LIST_PACKED", 39, 39, zzuk.zzbxx, zzux.zzbzh);
    zzbxb = new zzui("FIXED64_LIST_PACKED", 40, 40, zzuk.zzbxx, zzux.zzbzi);
    zzbxc = new zzui("FIXED32_LIST_PACKED", 41, 41, zzuk.zzbxx, zzux.zzbzh);
    zzbxd = new zzui("BOOL_LIST_PACKED", 42, 42, zzuk.zzbxx, zzux.zzbzl);
    zzbxe = new zzui("UINT32_LIST_PACKED", 43, 43, zzuk.zzbxx, zzux.zzbzh);
    zzbxf = new zzui("ENUM_LIST_PACKED", 44, 44, zzuk.zzbxx, zzux.zzbzo);
    zzbxg = new zzui("SFIXED32_LIST_PACKED", 45, 45, zzuk.zzbxx, zzux.zzbzh);
    zzbxh = new zzui("SFIXED64_LIST_PACKED", 46, 46, zzuk.zzbxx, zzux.zzbzi);
    zzbxi = new zzui("SINT32_LIST_PACKED", 47, 47, zzuk.zzbxx, zzux.zzbzh);
    zzbxj = new zzui("SINT64_LIST_PACKED", 48, 48, zzuk.zzbxx, zzux.zzbzi);
    zzbxk = new zzui("GROUP_LIST", 49, 49, zzuk.zzbxw, zzux.zzbzp);
    zzbxl = new zzui("MAP", 50, 50, zzuk.zzbxy, zzux.zzbzg);
    zzui[] arrayOfzzui1 = new zzui[51];
    arrayOfzzui1[0] = zzbvn;
    arrayOfzzui1[1] = zzbvo;
    arrayOfzzui1[2] = zzbvp;
    arrayOfzzui1[3] = zzbvq;
    arrayOfzzui1[4] = zzbvr;
    arrayOfzzui1[5] = zzbvs;
    arrayOfzzui1[6] = zzbvt;
    arrayOfzzui1[7] = zzbvu;
    arrayOfzzui1[8] = zzbvv;
    arrayOfzzui1[9] = zzbvw;
    arrayOfzzui1[10] = zzbvx;
    arrayOfzzui1[11] = zzbvy;
    arrayOfzzui1[12] = zzbvz;
    arrayOfzzui1[13] = zzbwa;
    arrayOfzzui1[14] = zzbwb;
    arrayOfzzui1[15] = zzbwc;
    arrayOfzzui1[16] = zzbwd;
    arrayOfzzui1[17] = zzbwe;
    arrayOfzzui1[18] = zzbwf;
    arrayOfzzui1[19] = zzbwg;
    arrayOfzzui1[20] = zzbwh;
    arrayOfzzui1[21] = zzbwi;
    arrayOfzzui1[22] = zzbwj;
    arrayOfzzui1[23] = zzbwk;
    arrayOfzzui1[24] = zzbwl;
    arrayOfzzui1[25] = zzbwm;
    arrayOfzzui1[26] = zzbwn;
    arrayOfzzui1[27] = zzbwo;
    arrayOfzzui1[28] = zzbwp;
    arrayOfzzui1[29] = zzbwq;
    arrayOfzzui1[30] = zzbwr;
    arrayOfzzui1[31] = zzbws;
    arrayOfzzui1[32] = zzbwt;
    arrayOfzzui1[33] = zzbwu;
    arrayOfzzui1[34] = zzbwv;
    arrayOfzzui1[35] = zzbww;
    arrayOfzzui1[36] = zzbwx;
    arrayOfzzui1[37] = zzbwy;
    arrayOfzzui1[38] = zzbwz;
    arrayOfzzui1[39] = zzbxa;
    arrayOfzzui1[40] = zzbxb;
    arrayOfzzui1[41] = zzbxc;
    arrayOfzzui1[42] = zzbxd;
    arrayOfzzui1[43] = zzbxe;
    arrayOfzzui1[44] = zzbxf;
    arrayOfzzui1[45] = zzbxg;
    arrayOfzzui1[46] = zzbxh;
    arrayOfzzui1[47] = zzbxi;
    arrayOfzzui1[48] = zzbxj;
    arrayOfzzui1[49] = zzbxk;
    arrayOfzzui1[50] = zzbxl;
    zzbxs = arrayOfzzui1;
    zzbxr = new Type[0];
    zzui[] arrayOfzzui2 = values();
    zzbxq = new zzui[arrayOfzzui2.length];
    int j = arrayOfzzui2.length;
    while (i < j)
    {
      zzui localzzui = arrayOfzzui2[i];
      zzbxq[localzzui.id] = localzzui;
      i++;
    }
  }

  private zzui(int paramInt, zzuk paramzzuk, zzux paramzzux)
  {
    this.id = paramInt;
    this.zzbxn = paramzzuk;
    this.zzbxm = paramzzux;
    switch (zzuj.zzbxt[paramzzuk.ordinal()])
    {
    default:
      this.zzbxo = null;
    case 1:
    case 2:
    }
    while (true)
    {
      zzuk localzzuk1 = zzuk.zzbxv;
      boolean bool = false;
      if (paramzzuk == localzzuk1)
      {
        int i = zzuj.zzbxu[paramzzux.ordinal()];
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
      this.zzbxp = bool;
      return;
      this.zzbxo = paramzzux.zzwy();
      continue;
      this.zzbxo = paramzzux.zzwy();
    }
  }

  public final int id()
  {
    return this.id;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzui
 * JD-Core Version:    0.6.2
 */