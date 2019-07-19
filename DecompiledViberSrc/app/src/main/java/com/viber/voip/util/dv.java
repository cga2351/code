package com.viber.voip.util;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import com.viber.voip.backgrounds.m;
import java.io.File;

public enum dv
{
  final String Q;
  File R;
  private final String S;
  private final String T;
  private final as U;

  static
  {
    // Byte code:
    //   0: new 63	com/viber/voip/util/dv$1
    //   3: dup
    //   4: ldc 65
    //   6: iconst_0
    //   7: ldc 67
    //   9: ldc 69
    //   11: ldc 71
    //   13: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   16: invokespecial 79	com/viber/voip/util/dv$1:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   19: putstatic 81	com/viber/voip/util/dv:a	Lcom/viber/voip/util/dv;
    //   22: new 83	com/viber/voip/util/dv$12
    //   25: dup
    //   26: ldc 85
    //   28: iconst_1
    //   29: ldc 87
    //   31: ldc 89
    //   33: ldc 71
    //   35: getstatic 91	com/viber/voip/util/as:d	Lcom/viber/voip/util/as;
    //   38: invokespecial 92	com/viber/voip/util/dv$12:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   41: putstatic 94	com/viber/voip/util/dv:b	Lcom/viber/voip/util/dv;
    //   44: new 96	com/viber/voip/util/dv$16
    //   47: dup
    //   48: ldc 98
    //   50: iconst_2
    //   51: ldc 67
    //   53: ldc 100
    //   55: aconst_null
    //   56: getstatic 102	com/viber/voip/util/as:b	Lcom/viber/voip/util/as;
    //   59: invokespecial 103	com/viber/voip/util/dv$16:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   62: putstatic 105	com/viber/voip/util/dv:c	Lcom/viber/voip/util/dv;
    //   65: new 107	com/viber/voip/util/dv$17
    //   68: dup
    //   69: ldc 109
    //   71: iconst_3
    //   72: ldc 111
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: invokespecial 112	com/viber/voip/util/dv$17:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   80: putstatic 114	com/viber/voip/util/dv:d	Lcom/viber/voip/util/dv;
    //   83: new 116	com/viber/voip/util/dv$18
    //   86: dup
    //   87: ldc 118
    //   89: iconst_4
    //   90: ldc 120
    //   92: ldc 69
    //   94: aconst_null
    //   95: aconst_null
    //   96: invokespecial 121	com/viber/voip/util/dv$18:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   99: putstatic 123	com/viber/voip/util/dv:e	Lcom/viber/voip/util/dv;
    //   102: new 125	com/viber/voip/util/dv$19
    //   105: dup
    //   106: ldc 127
    //   108: iconst_5
    //   109: ldc 120
    //   111: ldc 69
    //   113: ldc 71
    //   115: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   118: invokespecial 128	com/viber/voip/util/dv$19:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   121: putstatic 130	com/viber/voip/util/dv:f	Lcom/viber/voip/util/dv;
    //   124: new 2	com/viber/voip/util/dv
    //   127: dup
    //   128: ldc 132
    //   130: bipush 6
    //   132: ldc 134
    //   134: ldc 136
    //   136: aconst_null
    //   137: aconst_null
    //   138: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   141: putstatic 139	com/viber/voip/util/dv:g	Lcom/viber/voip/util/dv;
    //   144: new 2	com/viber/voip/util/dv
    //   147: dup
    //   148: ldc 141
    //   150: bipush 7
    //   152: ldc 134
    //   154: ldc 69
    //   156: ldc 71
    //   158: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   161: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   164: putstatic 143	com/viber/voip/util/dv:h	Lcom/viber/voip/util/dv;
    //   167: new 2	com/viber/voip/util/dv
    //   170: dup
    //   171: ldc 145
    //   173: bipush 8
    //   175: ldc 134
    //   177: ldc 147
    //   179: ldc 71
    //   181: getstatic 91	com/viber/voip/util/as:d	Lcom/viber/voip/util/as;
    //   184: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   187: putstatic 149	com/viber/voip/util/dv:i	Lcom/viber/voip/util/dv;
    //   190: new 2	com/viber/voip/util/dv
    //   193: dup
    //   194: ldc 151
    //   196: bipush 9
    //   198: ldc 134
    //   200: ldc 153
    //   202: aconst_null
    //   203: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   206: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   209: putstatic 155	com/viber/voip/util/dv:j	Lcom/viber/voip/util/dv;
    //   212: new 2	com/viber/voip/util/dv
    //   215: dup
    //   216: ldc 157
    //   218: bipush 10
    //   220: ldc 134
    //   222: ldc 159
    //   224: aconst_null
    //   225: getstatic 91	com/viber/voip/util/as:d	Lcom/viber/voip/util/as;
    //   228: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   231: putstatic 161	com/viber/voip/util/dv:k	Lcom/viber/voip/util/dv;
    //   234: new 2	com/viber/voip/util/dv
    //   237: dup
    //   238: ldc 163
    //   240: bipush 11
    //   242: ldc 134
    //   244: ldc 165
    //   246: aconst_null
    //   247: aconst_null
    //   248: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   251: putstatic 167	com/viber/voip/util/dv:l	Lcom/viber/voip/util/dv;
    //   254: new 2	com/viber/voip/util/dv
    //   257: dup
    //   258: ldc 169
    //   260: bipush 12
    //   262: ldc 134
    //   264: ldc 171
    //   266: aconst_null
    //   267: getstatic 173	com/viber/voip/util/as:c	Lcom/viber/voip/util/as;
    //   270: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   273: putstatic 175	com/viber/voip/util/dv:m	Lcom/viber/voip/util/dv;
    //   276: new 177	com/viber/voip/util/dv$20
    //   279: dup
    //   280: ldc 179
    //   282: bipush 13
    //   284: ldc 134
    //   286: aconst_null
    //   287: aconst_null
    //   288: aconst_null
    //   289: invokespecial 180	com/viber/voip/util/dv$20:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   292: putstatic 182	com/viber/voip/util/dv:n	Lcom/viber/voip/util/dv;
    //   295: new 2	com/viber/voip/util/dv
    //   298: dup
    //   299: ldc 184
    //   301: bipush 14
    //   303: ldc 134
    //   305: ldc 186
    //   307: aconst_null
    //   308: getstatic 188	com/viber/voip/util/as:g	Lcom/viber/voip/util/as;
    //   311: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   314: putstatic 190	com/viber/voip/util/dv:o	Lcom/viber/voip/util/dv;
    //   317: new 2	com/viber/voip/util/dv
    //   320: dup
    //   321: ldc 192
    //   323: bipush 15
    //   325: ldc 194
    //   327: ldc 196
    //   329: aconst_null
    //   330: aconst_null
    //   331: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   334: putstatic 198	com/viber/voip/util/dv:p	Lcom/viber/voip/util/dv;
    //   337: new 200	com/viber/voip/util/dv$21
    //   340: dup
    //   341: ldc 202
    //   343: bipush 16
    //   345: ldc 204
    //   347: ldc 69
    //   349: ldc 71
    //   351: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   354: invokespecial 205	com/viber/voip/util/dv$21:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   357: putstatic 207	com/viber/voip/util/dv:q	Lcom/viber/voip/util/dv;
    //   360: new 209	com/viber/voip/util/dv$22
    //   363: dup
    //   364: ldc 211
    //   366: bipush 17
    //   368: ldc 204
    //   370: ldc 69
    //   372: ldc 71
    //   374: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   377: invokespecial 212	com/viber/voip/util/dv$22:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   380: putstatic 214	com/viber/voip/util/dv:r	Lcom/viber/voip/util/dv;
    //   383: new 2	com/viber/voip/util/dv
    //   386: dup
    //   387: ldc 216
    //   389: bipush 18
    //   391: ldc 218
    //   393: ldc 69
    //   395: ldc 71
    //   397: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   400: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   403: putstatic 220	com/viber/voip/util/dv:s	Lcom/viber/voip/util/dv;
    //   406: new 2	com/viber/voip/util/dv
    //   409: dup
    //   410: ldc 222
    //   412: bipush 19
    //   414: ldc 224
    //   416: ldc 69
    //   418: ldc 71
    //   420: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   423: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   426: putstatic 226	com/viber/voip/util/dv:t	Lcom/viber/voip/util/dv;
    //   429: new 228	com/viber/voip/util/dv$2
    //   432: dup
    //   433: ldc 230
    //   435: bipush 20
    //   437: ldc 232
    //   439: ldc 100
    //   441: aconst_null
    //   442: getstatic 102	com/viber/voip/util/as:b	Lcom/viber/voip/util/as;
    //   445: invokespecial 233	com/viber/voip/util/dv$2:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   448: putstatic 235	com/viber/voip/util/dv:u	Lcom/viber/voip/util/dv;
    //   451: new 237	com/viber/voip/util/dv$3
    //   454: dup
    //   455: ldc 239
    //   457: bipush 21
    //   459: ldc 241
    //   461: ldc 243
    //   463: aconst_null
    //   464: getstatic 245	com/viber/voip/util/as:m	Lcom/viber/voip/util/as;
    //   467: invokespecial 246	com/viber/voip/util/dv$3:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   470: putstatic 248	com/viber/voip/util/dv:v	Lcom/viber/voip/util/dv;
    //   473: new 250	com/viber/voip/util/dv$4
    //   476: dup
    //   477: ldc 252
    //   479: bipush 22
    //   481: ldc 254
    //   483: aconst_null
    //   484: aconst_null
    //   485: getstatic 256	com/viber/voip/util/as:n	Lcom/viber/voip/util/as;
    //   488: invokespecial 257	com/viber/voip/util/dv$4:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   491: putstatic 259	com/viber/voip/util/dv:w	Lcom/viber/voip/util/dv;
    //   494: new 261	com/viber/voip/util/dv$5
    //   497: dup
    //   498: ldc_w 263
    //   501: bipush 23
    //   503: ldc 254
    //   505: aconst_null
    //   506: aconst_null
    //   507: getstatic 265	com/viber/voip/util/as:o	Lcom/viber/voip/util/as;
    //   510: invokespecial 266	com/viber/voip/util/dv$5:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   513: putstatic 268	com/viber/voip/util/dv:x	Lcom/viber/voip/util/dv;
    //   516: new 270	com/viber/voip/util/dv$6
    //   519: dup
    //   520: ldc_w 272
    //   523: bipush 24
    //   525: ldc 254
    //   527: aconst_null
    //   528: aconst_null
    //   529: aconst_null
    //   530: invokespecial 273	com/viber/voip/util/dv$6:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   533: putstatic 275	com/viber/voip/util/dv:y	Lcom/viber/voip/util/dv;
    //   536: new 2	com/viber/voip/util/dv
    //   539: dup
    //   540: ldc_w 277
    //   543: bipush 25
    //   545: ldc_w 279
    //   548: aconst_null
    //   549: aconst_null
    //   550: getstatic 281	com/viber/voip/util/as:j	Lcom/viber/voip/util/as;
    //   553: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   556: putstatic 283	com/viber/voip/util/dv:z	Lcom/viber/voip/util/dv;
    //   559: new 2	com/viber/voip/util/dv
    //   562: dup
    //   563: ldc_w 285
    //   566: bipush 26
    //   568: ldc_w 287
    //   571: aconst_null
    //   572: aconst_null
    //   573: getstatic 289	com/viber/voip/util/as:f	Lcom/viber/voip/util/as;
    //   576: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   579: putstatic 291	com/viber/voip/util/dv:A	Lcom/viber/voip/util/dv;
    //   582: new 2	com/viber/voip/util/dv
    //   585: dup
    //   586: ldc_w 293
    //   589: bipush 27
    //   591: ldc_w 295
    //   594: aconst_null
    //   595: aconst_null
    //   596: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   599: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   602: putstatic 297	com/viber/voip/util/dv:B	Lcom/viber/voip/util/dv;
    //   605: new 2	com/viber/voip/util/dv
    //   608: dup
    //   609: ldc_w 299
    //   612: bipush 28
    //   614: ldc_w 301
    //   617: ldc_w 303
    //   620: aconst_null
    //   621: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   624: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   627: putstatic 305	com/viber/voip/util/dv:C	Lcom/viber/voip/util/dv;
    //   630: new 2	com/viber/voip/util/dv
    //   633: dup
    //   634: ldc_w 307
    //   637: bipush 29
    //   639: ldc_w 301
    //   642: ldc_w 303
    //   645: aconst_null
    //   646: getstatic 102	com/viber/voip/util/as:b	Lcom/viber/voip/util/as;
    //   649: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   652: putstatic 309	com/viber/voip/util/dv:D	Lcom/viber/voip/util/dv;
    //   655: new 2	com/viber/voip/util/dv
    //   658: dup
    //   659: ldc_w 311
    //   662: bipush 30
    //   664: ldc_w 313
    //   667: ldc_w 315
    //   670: aconst_null
    //   671: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   674: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   677: putstatic 317	com/viber/voip/util/dv:E	Lcom/viber/voip/util/dv;
    //   680: new 2	com/viber/voip/util/dv
    //   683: dup
    //   684: ldc_w 319
    //   687: bipush 31
    //   689: ldc_w 313
    //   692: ldc_w 315
    //   695: aconst_null
    //   696: getstatic 102	com/viber/voip/util/as:b	Lcom/viber/voip/util/as;
    //   699: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   702: putstatic 321	com/viber/voip/util/dv:F	Lcom/viber/voip/util/dv;
    //   705: new 323	com/viber/voip/util/dv$7
    //   708: dup
    //   709: ldc_w 325
    //   712: bipush 32
    //   714: ldc_w 327
    //   717: aconst_null
    //   718: aconst_null
    //   719: getstatic 173	com/viber/voip/util/as:c	Lcom/viber/voip/util/as;
    //   722: invokespecial 328	com/viber/voip/util/dv$7:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   725: putstatic 330	com/viber/voip/util/dv:G	Lcom/viber/voip/util/dv;
    //   728: new 332	com/viber/voip/util/dv$8
    //   731: dup
    //   732: ldc_w 334
    //   735: bipush 33
    //   737: ldc_w 336
    //   740: aconst_null
    //   741: aconst_null
    //   742: getstatic 173	com/viber/voip/util/as:c	Lcom/viber/voip/util/as;
    //   745: invokespecial 337	com/viber/voip/util/dv$8:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   748: putstatic 339	com/viber/voip/util/dv:H	Lcom/viber/voip/util/dv;
    //   751: new 341	com/viber/voip/util/dv$9
    //   754: dup
    //   755: ldc_w 343
    //   758: bipush 34
    //   760: ldc_w 345
    //   763: aconst_null
    //   764: ldc_w 347
    //   767: getstatic 91	com/viber/voip/util/as:d	Lcom/viber/voip/util/as;
    //   770: invokespecial 348	com/viber/voip/util/dv$9:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   773: putstatic 350	com/viber/voip/util/dv:I	Lcom/viber/voip/util/dv;
    //   776: new 2	com/viber/voip/util/dv
    //   779: dup
    //   780: ldc_w 352
    //   783: bipush 35
    //   785: ldc_w 354
    //   788: ldc_w 356
    //   791: ldc 71
    //   793: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   796: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   799: putstatic 358	com/viber/voip/util/dv:J	Lcom/viber/voip/util/dv;
    //   802: new 2	com/viber/voip/util/dv
    //   805: dup
    //   806: ldc_w 360
    //   809: bipush 36
    //   811: ldc_w 354
    //   814: ldc_w 362
    //   817: ldc 71
    //   819: getstatic 91	com/viber/voip/util/as:d	Lcom/viber/voip/util/as;
    //   822: invokespecial 137	com/viber/voip/util/dv:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   825: putstatic 364	com/viber/voip/util/dv:K	Lcom/viber/voip/util/dv;
    //   828: new 366	com/viber/voip/util/dv$10
    //   831: dup
    //   832: ldc_w 368
    //   835: bipush 37
    //   837: ldc_w 370
    //   840: getstatic 374	com/viber/voip/backgrounds/m:a	Ljava/lang/String;
    //   843: ldc_w 376
    //   846: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   849: invokespecial 377	com/viber/voip/util/dv$10:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   852: putstatic 379	com/viber/voip/util/dv:L	Lcom/viber/voip/util/dv;
    //   855: new 381	com/viber/voip/util/dv$11
    //   858: dup
    //   859: ldc_w 383
    //   862: bipush 38
    //   864: ldc_w 370
    //   867: getstatic 374	com/viber/voip/backgrounds/m:a	Ljava/lang/String;
    //   870: ldc_w 385
    //   873: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   876: invokespecial 386	com/viber/voip/util/dv$11:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   879: putstatic 388	com/viber/voip/util/dv:M	Lcom/viber/voip/util/dv;
    //   882: new 390	com/viber/voip/util/dv$13
    //   885: dup
    //   886: ldc_w 392
    //   889: bipush 39
    //   891: ldc_w 370
    //   894: getstatic 374	com/viber/voip/backgrounds/m:a	Ljava/lang/String;
    //   897: ldc_w 394
    //   900: getstatic 75	com/viber/voip/util/as:a	Lcom/viber/voip/util/as;
    //   903: invokespecial 395	com/viber/voip/util/dv$13:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   906: putstatic 397	com/viber/voip/util/dv:N	Lcom/viber/voip/util/dv;
    //   909: new 399	com/viber/voip/util/dv$14
    //   912: dup
    //   913: ldc_w 401
    //   916: bipush 40
    //   918: getstatic 406	android/os/Environment:DIRECTORY_NOTIFICATIONS	Ljava/lang/String;
    //   921: aconst_null
    //   922: aconst_null
    //   923: getstatic 281	com/viber/voip/util/as:j	Lcom/viber/voip/util/as;
    //   926: invokespecial 407	com/viber/voip/util/dv$14:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   929: putstatic 409	com/viber/voip/util/dv:O	Lcom/viber/voip/util/dv;
    //   932: new 411	com/viber/voip/util/dv$15
    //   935: dup
    //   936: ldc_w 413
    //   939: bipush 41
    //   941: getstatic 416	android/os/Environment:DIRECTORY_RINGTONES	Ljava/lang/String;
    //   944: aconst_null
    //   945: aconst_null
    //   946: getstatic 281	com/viber/voip/util/as:j	Lcom/viber/voip/util/as;
    //   949: invokespecial 417	com/viber/voip/util/dv$15:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/viber/voip/util/as;)V
    //   952: putstatic 419	com/viber/voip/util/dv:P	Lcom/viber/voip/util/dv;
    //   955: bipush 42
    //   957: anewarray 2	com/viber/voip/util/dv
    //   960: astore_0
    //   961: aload_0
    //   962: iconst_0
    //   963: getstatic 81	com/viber/voip/util/dv:a	Lcom/viber/voip/util/dv;
    //   966: aastore
    //   967: aload_0
    //   968: iconst_1
    //   969: getstatic 94	com/viber/voip/util/dv:b	Lcom/viber/voip/util/dv;
    //   972: aastore
    //   973: aload_0
    //   974: iconst_2
    //   975: getstatic 105	com/viber/voip/util/dv:c	Lcom/viber/voip/util/dv;
    //   978: aastore
    //   979: aload_0
    //   980: iconst_3
    //   981: getstatic 114	com/viber/voip/util/dv:d	Lcom/viber/voip/util/dv;
    //   984: aastore
    //   985: aload_0
    //   986: iconst_4
    //   987: getstatic 123	com/viber/voip/util/dv:e	Lcom/viber/voip/util/dv;
    //   990: aastore
    //   991: aload_0
    //   992: iconst_5
    //   993: getstatic 130	com/viber/voip/util/dv:f	Lcom/viber/voip/util/dv;
    //   996: aastore
    //   997: aload_0
    //   998: bipush 6
    //   1000: getstatic 139	com/viber/voip/util/dv:g	Lcom/viber/voip/util/dv;
    //   1003: aastore
    //   1004: aload_0
    //   1005: bipush 7
    //   1007: getstatic 143	com/viber/voip/util/dv:h	Lcom/viber/voip/util/dv;
    //   1010: aastore
    //   1011: aload_0
    //   1012: bipush 8
    //   1014: getstatic 149	com/viber/voip/util/dv:i	Lcom/viber/voip/util/dv;
    //   1017: aastore
    //   1018: aload_0
    //   1019: bipush 9
    //   1021: getstatic 155	com/viber/voip/util/dv:j	Lcom/viber/voip/util/dv;
    //   1024: aastore
    //   1025: aload_0
    //   1026: bipush 10
    //   1028: getstatic 161	com/viber/voip/util/dv:k	Lcom/viber/voip/util/dv;
    //   1031: aastore
    //   1032: aload_0
    //   1033: bipush 11
    //   1035: getstatic 167	com/viber/voip/util/dv:l	Lcom/viber/voip/util/dv;
    //   1038: aastore
    //   1039: aload_0
    //   1040: bipush 12
    //   1042: getstatic 175	com/viber/voip/util/dv:m	Lcom/viber/voip/util/dv;
    //   1045: aastore
    //   1046: aload_0
    //   1047: bipush 13
    //   1049: getstatic 182	com/viber/voip/util/dv:n	Lcom/viber/voip/util/dv;
    //   1052: aastore
    //   1053: aload_0
    //   1054: bipush 14
    //   1056: getstatic 190	com/viber/voip/util/dv:o	Lcom/viber/voip/util/dv;
    //   1059: aastore
    //   1060: aload_0
    //   1061: bipush 15
    //   1063: getstatic 198	com/viber/voip/util/dv:p	Lcom/viber/voip/util/dv;
    //   1066: aastore
    //   1067: aload_0
    //   1068: bipush 16
    //   1070: getstatic 207	com/viber/voip/util/dv:q	Lcom/viber/voip/util/dv;
    //   1073: aastore
    //   1074: aload_0
    //   1075: bipush 17
    //   1077: getstatic 214	com/viber/voip/util/dv:r	Lcom/viber/voip/util/dv;
    //   1080: aastore
    //   1081: aload_0
    //   1082: bipush 18
    //   1084: getstatic 220	com/viber/voip/util/dv:s	Lcom/viber/voip/util/dv;
    //   1087: aastore
    //   1088: aload_0
    //   1089: bipush 19
    //   1091: getstatic 226	com/viber/voip/util/dv:t	Lcom/viber/voip/util/dv;
    //   1094: aastore
    //   1095: aload_0
    //   1096: bipush 20
    //   1098: getstatic 235	com/viber/voip/util/dv:u	Lcom/viber/voip/util/dv;
    //   1101: aastore
    //   1102: aload_0
    //   1103: bipush 21
    //   1105: getstatic 248	com/viber/voip/util/dv:v	Lcom/viber/voip/util/dv;
    //   1108: aastore
    //   1109: aload_0
    //   1110: bipush 22
    //   1112: getstatic 259	com/viber/voip/util/dv:w	Lcom/viber/voip/util/dv;
    //   1115: aastore
    //   1116: aload_0
    //   1117: bipush 23
    //   1119: getstatic 268	com/viber/voip/util/dv:x	Lcom/viber/voip/util/dv;
    //   1122: aastore
    //   1123: aload_0
    //   1124: bipush 24
    //   1126: getstatic 275	com/viber/voip/util/dv:y	Lcom/viber/voip/util/dv;
    //   1129: aastore
    //   1130: aload_0
    //   1131: bipush 25
    //   1133: getstatic 283	com/viber/voip/util/dv:z	Lcom/viber/voip/util/dv;
    //   1136: aastore
    //   1137: aload_0
    //   1138: bipush 26
    //   1140: getstatic 291	com/viber/voip/util/dv:A	Lcom/viber/voip/util/dv;
    //   1143: aastore
    //   1144: aload_0
    //   1145: bipush 27
    //   1147: getstatic 297	com/viber/voip/util/dv:B	Lcom/viber/voip/util/dv;
    //   1150: aastore
    //   1151: aload_0
    //   1152: bipush 28
    //   1154: getstatic 305	com/viber/voip/util/dv:C	Lcom/viber/voip/util/dv;
    //   1157: aastore
    //   1158: aload_0
    //   1159: bipush 29
    //   1161: getstatic 309	com/viber/voip/util/dv:D	Lcom/viber/voip/util/dv;
    //   1164: aastore
    //   1165: aload_0
    //   1166: bipush 30
    //   1168: getstatic 317	com/viber/voip/util/dv:E	Lcom/viber/voip/util/dv;
    //   1171: aastore
    //   1172: aload_0
    //   1173: bipush 31
    //   1175: getstatic 321	com/viber/voip/util/dv:F	Lcom/viber/voip/util/dv;
    //   1178: aastore
    //   1179: aload_0
    //   1180: bipush 32
    //   1182: getstatic 330	com/viber/voip/util/dv:G	Lcom/viber/voip/util/dv;
    //   1185: aastore
    //   1186: aload_0
    //   1187: bipush 33
    //   1189: getstatic 339	com/viber/voip/util/dv:H	Lcom/viber/voip/util/dv;
    //   1192: aastore
    //   1193: aload_0
    //   1194: bipush 34
    //   1196: getstatic 350	com/viber/voip/util/dv:I	Lcom/viber/voip/util/dv;
    //   1199: aastore
    //   1200: aload_0
    //   1201: bipush 35
    //   1203: getstatic 358	com/viber/voip/util/dv:J	Lcom/viber/voip/util/dv;
    //   1206: aastore
    //   1207: aload_0
    //   1208: bipush 36
    //   1210: getstatic 364	com/viber/voip/util/dv:K	Lcom/viber/voip/util/dv;
    //   1213: aastore
    //   1214: aload_0
    //   1215: bipush 37
    //   1217: getstatic 379	com/viber/voip/util/dv:L	Lcom/viber/voip/util/dv;
    //   1220: aastore
    //   1221: aload_0
    //   1222: bipush 38
    //   1224: getstatic 388	com/viber/voip/util/dv:M	Lcom/viber/voip/util/dv;
    //   1227: aastore
    //   1228: aload_0
    //   1229: bipush 39
    //   1231: getstatic 397	com/viber/voip/util/dv:N	Lcom/viber/voip/util/dv;
    //   1234: aastore
    //   1235: aload_0
    //   1236: bipush 40
    //   1238: getstatic 409	com/viber/voip/util/dv:O	Lcom/viber/voip/util/dv;
    //   1241: aastore
    //   1242: aload_0
    //   1243: bipush 41
    //   1245: getstatic 419	com/viber/voip/util/dv:P	Lcom/viber/voip/util/dv;
    //   1248: aastore
    //   1249: aload_0
    //   1250: putstatic 421	com/viber/voip/util/dv:V	[Lcom/viber/voip/util/dv;
    //   1253: return
  }

  private dv(String paramString1, String paramString2, String paramString3, as paramas)
  {
    this.Q = paramString1;
    this.S = paramString2;
    this.T = paramString3;
    this.U = paramas;
  }

  public static boolean a(Uri paramUri, dv paramdv)
  {
    return (dk.b(paramUri)) && (paramUri.getLastPathSegment().startsWith(paramdv.S));
  }

  public static boolean a(Uri paramUri, dv paramdv, Context paramContext)
  {
    return (dk.b(paramUri)) && (a(new File(paramUri.getPath()), paramdv, paramContext));
  }

  public static boolean a(File paramFile, dv paramdv, Context paramContext)
  {
    return paramFile.getParentFile().equals(paramdv.a(paramContext));
  }

  public static boolean a(String paramString, dv paramdv, Context paramContext)
  {
    return (!da.a(paramString)) && (a(Uri.parse(paramString), paramdv, paramContext));
  }

  static String c(String paramString)
    throws IllegalArgumentException
  {
    if (da.a(paramString))
      throw new IllegalArgumentException("File name must be provided");
    return paramString;
  }

  public static dv d(String paramString)
  {
    if (da.a(paramString))
      return a;
    if (paramString.startsWith("video"))
      return b;
    if (paramString.equals("image/gif"))
      return u;
    if (paramString.startsWith("image"))
      return a;
    return l;
  }

  public final Uri a(Context paramContext, String paramString, boolean paramBoolean)
  {
    File localFile = b(paramContext, paramString, paramBoolean);
    if (localFile != null)
      return Uri.fromFile(localFile);
    return null;
  }

  public File a(Context paramContext)
  {
    if (this.R == null)
      this.R = at.b(paramContext, this.Q);
    return this.R;
  }

  public final File a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, true);
  }

  public final String a()
  {
    return this.S;
  }

  String a(String paramString)
  {
    if (da.a(paramString))
      return String.valueOf(System.currentTimeMillis());
    return bu.a(Uri.parse(paramString).getPath());
  }

  public File b(Context paramContext)
  {
    return new File(at.a("media"), this.Q);
  }

  public final File b(Context paramContext, String paramString)
  {
    return new File(a(paramContext), b(paramString));
  }

  public final File b(Context paramContext, String paramString, boolean paramBoolean)
  {
    return at.a(a(paramContext), b(paramString), paramBoolean);
  }

  final String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    da.a(this.S, localStringBuilder);
    localStringBuilder.append(a(paramString));
    da.a(this.T, localStringBuilder);
    if (this.U != null)
      localStringBuilder.append('.').append(this.U.a());
    return localStringBuilder.toString();
  }

  public final File c(Context paramContext, String paramString, boolean paramBoolean)
  {
    return at.a(b(paramContext), b(paramString), paramBoolean);
  }

  public final String c(Context paramContext, String paramString)
  {
    return b(paramContext, paramString).getPath();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dv
 * JD-Core Version:    0.6.2
 */