import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

Widget loadTestBtn1UI() {
  return Scaffold(
    appBar: AppBar(
      title: Text("Test Btn 1"),
    ),
    body: Container(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Row(
//            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              Expanded(
                child: Image.network("https://cdn.jsdelivr.net/gh/flutterchina/website@1.0/images/flutter-mark-square-100.png"),
              ),
              Expanded(
                flex: 2,
                child: Image.network("https://cdn.jsdelivr.net/gh/flutterchina/website@1.0/images/flutter-mark-square-100.png"),
              ),
              Expanded(
                child: Image.network("https://cdn.jsdelivr.net/gh/flutterchina/website@1.0/images/flutter-mark-square-100.png"),
              ),
            ],
          ),
          Center(
            child: Row(
              mainAxisSize: MainAxisSize.min,
              children: <Widget>[
                Image.network("https://cdn.jsdelivr.net/gh/flutterchina/website@1.0/images/flutter-mark-square-100.png"),
                Image.network("https://cdn.jsdelivr.net/gh/flutterchina/website@1.0/images/flutter-mark-square-100.png"),
                Image.network("https://cdn.jsdelivr.net/gh/flutterchina/website@1.0/images/flutter-mark-square-100.png"),
              ],
            ),
          ),

          // test background
//          Center(
//            child: Container(
//              padding: EdgeInsets.fromLTRB(20, 20, 20, 20),
//              child: Text("a;lkdf;aldkf"),
//            ),
//          ),
          Container(
//            foregroundDecoration: ShapeDecoration(color: Colors.yellow, shape: Border.all(color: Colors.red, width: 3),),
//            decoration: ShapeDecoration(color: Colors.lightBlue, shape: Border.all(color: Colors.red, width: 3)),
            decoration: BoxDecoration(
              border: Border.all(color: Colors.red, width: 2.0),
              borderRadius: BorderRadius.all(Radius.circular(10.0))
            ),
            padding: EdgeInsets.fromLTRB(20, 20, 20, 20),
            child: Center(
              child: Text("a;lkdf;aldkf"),


            ),
          ),
        ],
      ),
    ),
  );
}

