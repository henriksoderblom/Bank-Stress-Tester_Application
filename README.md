This is an application for testing how well different banks can withstand different scenarios. The user will have to put in parameters and load a file consisting of the parameters regarding the bank (the user can also create a bank file in the application). When the user is satisfied with the parameters he/she can click "GO" which will open a new window where three graphs are shown and also the numerical values of different parameters that the application has calculated.
  The user can go and check the run-window anytime and choose which of the runs he/she wants to take a look at. It is also possible to load multiple bank-files which makes it is easy to switch between the banks which the user wants to test. The user can save internally or externally in the run-window and load internally or externally in the menu in the top left corner.
  In "Settings" in the menu, the user will have to put in required information for external saving and external loading (do not have to be same but perhaps that's the easiest way!). There is also "Help" which explains the function of the application and the restrictions the parameters have. It also explains more about the economic background. There is also information about the external saving and loading. The application will give an error message if the user does something prohibited.
  
About the code: The GUI is coded in Swing and JavaSocket was used for the dataconnection. The external server has to have the Server class and it also has to understand the object "Result" that is being sent to it. The Model-View-Controller design is used. Referenced Libraries are jfreechart, jcommon and opencsv. 

<img src="/Pictures/AppView.png">
<img src="/Pictures/RunWindow.png">
<img src="/Pictures/SettingsView.png">
