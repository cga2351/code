import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

BuildContext _buildContext;
GlobalKey<FormState> _addExpenseTypeKey = GlobalKey();

void addExpenseType(BuildContext buildContext) {
  _buildContext = buildContext;
  showDialog(
    context: _buildContext,
    child: AlertDialog(
      title: Text("add expense type"),
      content: Container(
          width: 1000,
          height: 300,
          child: Scrollbar(
            child: SingleChildScrollView(
              child: Form(
                key: _addExpenseTypeKey,
                child: Column(
                  children: <Widget>[
                    // expense type
                    TextFormField(
                      decoration: InputDecoration(
                        filled: true,
                        fillColor: Color(0x0A000000),
                        labelText: "expense type name",
                        hintText: "input a expense type name",
                      ),
                      validator: (value) {
                        if (value.isEmpty) {
                          return "expense type name is empty";
                        }
                        return null;
                      },
                    ),
                  ],
                ),
              ),
            ),
          )
      ),

      actions: <Widget>[
        FlatButton(child: Text("cancel"), onPressed: onCancelAddExpenseType),
        FlatButton(child: Text("add"), onPressed: onAddExpenseType)
      ],
    ),
  );
}

void onCancelAddExpenseType() {
  Navigator.pop(_buildContext);
}
void onAddExpenseType() {
  _addExpenseTypeKey.currentState.validate();
}