
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class TestBtn3UI extends StatefulWidget {

  @override
  State createState() {
    return TestBtn3UIState();
  }
}

class TestBtn3UIState extends State {
  BuildContext buildContext;

  @override
  Widget build(BuildContext context) {
    buildContext = context;

    return Scaffold(
      appBar: AppBar(
        title: Text("Test Btn3 UI"),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          // test ListView
          Container(
              padding: EdgeInsets.only(left: 20, right: 20),
              height: 300,
              child: ListView.builder(
//                itemExtent: 50,
                  itemBuilder: (context, index) {
                    if (index > 50) {
                      return null;
                    }
                    Widget item;
                    if (index % 2 == 0) {
                      item = ListTile(
                        leading:Container(
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: <Widget>[
                                Text("leading:" + index.toString()),
                                Icon(Icons.local_movies, color: Colors.lightBlue,),
                              ],
                            )
                        ),
                        title: Container(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: <Widget>[
                              Text("title:" + index.toString()),
                              Icon(Icons.local_movies, color: Colors.lightBlue,),
                              Icon(Icons.local_movies, color: Colors.lightBlue,),
                            ],
                          ),
                        ),
                        trailing: Container(
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: <Widget>[
                                Text("trailing:" + index.toString()),
                                Icon(Icons.local_movies, color: Colors.lightBlue,),
                              ],
                            )
                        ),
                        contentPadding: EdgeInsets.all(10),
                      );
                    } else {
                      item = Divider(color: Colors.black,);
                    }
                    print("TestBtn3UI, list view count:$index");
                    return item;
                    return Divider();
                  })
          ),
          Container(
            padding: EdgeInsets.all(20),
            child: Row(
              children: <Widget>[
                // test Stack
                Stack(
                  alignment: Alignment(0.6, 0.6),
                  children: <Widget>[
                    CircleAvatar(
                      backgroundImage: NetworkImage(
                          "https://cdn.jsdelivr.net/gh/flutterchina/website@1.0/images/flutter-mark-square-100.png"),
                      radius: 50.0,
                    ),
                    Container(
                      decoration: BoxDecoration(
                          color: Colors.black38
                      ),
                      child: Text("abcaaa", style: TextStyle(
                        fontSize: 20.0,
                        fontWeight: FontWeight.bold,
                        color: Colors.white,
                      ),),
                    ),
                  ],
                ),
                // test GestureDetector
                SizedBox(
                  width: 100,
                  height: 100,
                  child: GestureDetector(
                    onTap: (){
                      print("onTap(), entry");
                    },
                    child: Container(
                      decoration: BoxDecoration(
                        color: Colors.lightBlue
                      ),
                      child: Text("abc"),
                    )
                  ),
                ),
                // test customized self state view
                SizedBox(
                  width: 100,
                  height: 100,
                  child: MyCheckBox(),
                )
              ],
            ),
          ),
          Container(
            padding: EdgeInsets.all(20),
            child: Row(
              children: <Widget>[
                Text("aaa"),
                Text("ddd"),
              ],
            ),
          )
        ],
      )
    );
  }
}

class MyCheckBox extends StatefulWidget {

  @override
  State createState() {
    return MyCheckBoxState();
  }
}

class MyCheckBoxState extends State {
  bool checked = false;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
        onTap: (){
          setState(() {
            checked = !checked;
          });
        },
        child: Container(
          decoration: BoxDecoration(
              color: Colors.lightGreen
          ),
          child: checked ? Icon(Icons.check_circle) : Icon(Icons.radio_button_unchecked),
        )
    );

//    return Checkbox(
//      value: checked,
//      onChanged: (value) {
//        setState(() {
//          checked = value;
//        });
//      },);
  }
}