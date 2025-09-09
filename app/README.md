Jayden Cruz

UI: It is in the activity_main.xml  line 9 - 51
example of defined string resource:     <string name="app_name">LightsOut</string>



Code:It is in MainActivity.java line 19-55 methods oncreate creates the matrix then methods recolor and randomize

cellstate a matrix of boolean: line 22:    cellState = new boolean[][]{{true, true, true}, {true, true, true}, {true, true, true}};


code to color each button: line 40-44
if (cellState[row][col] == true) {
gridButton.setBackgroundColor(getColor(R.color.blue_500));
} else {
gridButton.setBackgroundColor(getColor(R.color.black));


code to get a handle on the gridlayout: line 25 in java     grid = findViewById(R.id.light_grid);





