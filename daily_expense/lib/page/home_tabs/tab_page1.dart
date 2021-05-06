import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class TabPage1View extends StatefulWidget{

  @override
  State createState() {
    return TabPage1State();
  }
}

class TabPage1State extends State<TabPage1View> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text("Bottom Page 1", style: TextStyle(fontSize: 30),),
      ),

     // floatingActionButton: FloatingActionButton(
     //   onPressed: () {},
     //   child: Icon(Icons.add),
     // ),
     // floatingActionButtonLocation: FloatingActionButtonLocation.endFloat,
    );
  }
}