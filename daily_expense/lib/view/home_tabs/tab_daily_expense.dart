import 'package:dailyexpense/view/add_expense_item.dart';
import 'package:dailyexpense/view/add_expense_type.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class TabDailyExpenseView extends StatefulWidget{

  @override
  State createState() {
    return TabDailyExpenseState();
  }
}

class TabDailyExpenseState extends State<TabDailyExpenseView> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text("Buttom Page 1", style: TextStyle(fontSize: 30),),
      ),
      floatingActionButton :
      // FloatingActionButton(
      //   onPressed: () {},
      //   child: Icon(Icons.add),
      // ),

      SizedBox(
        height: 180,
        child: Column(
          children: [
            FloatingActionButton(
              onPressed: () {
                addType(context);
              },
              child: Icon(Icons.add),
            ),
            SizedBox(height: 5),
            Text("type"),
            SizedBox(height: 15,),
            FloatingActionButton(
              onPressed: () {
                addItem(context);
              },
              child: Icon(Icons.add),
            ),
            SizedBox(height: 5),
            Text("item"),
          ],
        ),
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.endFloat,
    );
  }

  void addType(BuildContext context) {
    addExpenseType(context);
  }

  void addItem(BuildContext context) {
    addExpenseItem(context);
  }
}