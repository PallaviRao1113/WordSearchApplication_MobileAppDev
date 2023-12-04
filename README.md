# WordSearchApplication_MobileAppDev

1. 	Download the zip file titled “PROJECT_TEAM02.zip”, and unzip the file. Open Android Studio, and then click the “Open” button, and select the aforementioned unzipped folder. The project will now open in Android 	Studio. Ensure that you have an Android Emulator setup and running.
		-An emulator with the following specifications should run the application in the case that you do not already have an emulator set up: 
			- Pixel 7
			- API Level 33 (Tiramisu) 
			- Android 13.0
			- System Image: arm64-v8a)
	To run the application, click the “Run” menu from the Android Studio toolbar, and select the first option (“Run ‘app’"). The application will now launch in the emulator. 


2.	This application that launched is a Word Search game, and you will be directed to the Main Screen of the game upon launching it. You will see an image of a star as well as the title “WORD SEARCH”, and a menu with 	the following options: 
		- “CHOOSE MUSIC!”
		- “BONUS CHALLENGE”
		- “CHECK POINTS”
		- “EASY”
		- “MEDIUM”
		- “HARD” 
	First, click the “CHECK POINTS!” option to view your current star count (point count), and you will be redirected to another activity which shows an image of a star, your current star count, and a "Back to Main 	Screen" button. Click the “Back to Main Screen” button, and now click the “CHOOSE MUSIC!” button. You will now be redirected to another activity where you can select a soundtrack to play in the background while 	playing the game. Select any of the three soundtrack buttons, and click the “OFF” button to pause the music, and the selected soundtrack will continue to loop and play in the background until you terminate the 	application. 


3.	Click the “Back To Main Screen” button on the Soundtrack Selector screen, and then click one of the four game buttons on the Main Screen (“BONUS CHALLENGE”, “EASY”, “MEDIUM”, “HARD”). 
		- Clicking the “BONUS CHALLENGE” button will redirect you to an activity with a randomly generated 10x10 word search puzzle and a one-minute timer, and there will be a hidden word which was randomly 			selected from a pre-programmed list of words.
		- Clicking the “EASY” button will redirect you to an activity with a randomly generated 3x3 word search puzzle and a three-minute timer, and there will be a hidden word which was randomly selected from a 		pre-programmed list of words.
		- Clicking the “MEDIUM” button will redirect you to an activity with a randomly generated 5x5 word search puzzle and a two-minute timer, and there will be a hidden word which was randomly selected from a 		pre-programmed list of words.
		- Clicking the “HARD” button will redirect you to an activity with a randomly generated 7x7 word search puzzle and a one-minute timer, and there will be a hidden word which was randomly selected from a 		pre-programmed list of words
	Each game screen will also have a “Back To Main Screen” button which can be used to go back to the Main Screen and navigate to the screen you would like to go to. On any of the word search screens, you can scan 	through the puzzle to locate the hidden word. 


4. 	Once you locate the word, click each letter of the word in order from left to right across the row. When you click a letter, a temporary message will be displayed at the bottom of the screen which shows the 		letter you just selected. Your selection is automatically verified by the application:
		- In the Easy level of the game the selection is automatically verified after any 3 letters are clicked.
		- In the Medium level of the game the selection is automatically verified after any 5 letters are clicked.
		- In the Hard level of the game the selection is automatically verified after any 7 letters are clicked.
		- In the Bonus Challenge the selection is automatically verified after any 10 letters are clicked. 
	If you identify and click the correct letters in the correct order before the timer runs out, you will be redirected to the star count screen, and you will see that a star has been added to your total star count. 	If you click the incorrect letters you will again be redirected to the start count screen, but this time you will see that a star point has been deducted from your total start count. If the timer runs out before 	you correctly identify the correct word/letters/order, you will be redirected to the Main Screen. 


5.	Each of the three game levels and the Bonus Challenge puzzle follow this same logic and format. To terminate the application, click the "Run" menu from the Android Studio and click the "Stop 'app'" option. 
